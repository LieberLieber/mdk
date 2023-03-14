package org.openmbee.mdk.viewedit;

import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.GUILog;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.ElementValue;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.InstanceSpecification;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Slot;
import org.openmbee.mdk.api.docgen.uml.classes.PresentationElementClasses;
import org.openmbee.mdk.api.incubating.MDKConstants;
import org.openmbee.mdk.api.incubating.convert.Converters;
import org.openmbee.mdk.docgen.DocGenUtils;
import org.openmbee.mdk.generator.PresentationElementInfo;
import org.openmbee.mdk.generator.PresentationElementInstance;
import org.openmbee.mdk.generator.PresentationElementUtils;
import org.openmbee.mdk.model.Section;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openmbee.mdk.docgen.docbook.*;

import java.util.*;

public class DBAlfrescoVisitor extends DBAbstractVisitor {

    private Stack<List<Element>> sibviewsElements = new Stack<>();
    private Stack<Set<String>> viewElements = new Stack<>(); //ids of view elements
    private Set<DBImage> images = new LinkedHashSet<>();
    protected boolean recurse;
    private GUILog gl = Application.getInstance().getGUILog();

    private Map<From, String> sourceMapping = new HashMap<>();
    private Map<Element, List<Element>> view2viewElements = new HashMap<>();
    private boolean doc;
    protected Set<Element> elementSet = new HashSet<>();

    //for ems 2.2 reference tree
    // these are linked hash maps to make recursive sense in ViewPresentationGenerator
    private Map<Element, JSONArray> view2elements = new LinkedHashMap<>();
    private Map<Element, List<PresentationElementInstance>> view2pe = new LinkedHashMap<>();
    private Map<Element, List<PresentationElementInstance>> view2peOld = new LinkedHashMap<>();
    private Stack<Element> currentView = new Stack<>();
    private Stack<PresentationElementInstance> currentSection = new Stack<>(); //if currently in section, sections cannot cross views
    private Stack<List<InstanceSpecification>> currentInstanceList = new Stack<>();
    private Stack<List<InstanceSpecification>> currentTableInstances = new Stack<>();
    private Stack<List<InstanceSpecification>> currentFigureInstances = new Stack<>();
    private Stack<List<InstanceSpecification>> currentListInstances = new Stack<>();
    private Stack<List<InstanceSpecification>> currentParaInstances = new Stack<>();
    private Stack<List<InstanceSpecification>> currentSectionInstances = new Stack<>();
    private Stack<List<InstanceSpecification>> currentImageInstances = new Stack<>();
    private Stack<List<InstanceSpecification>> currentManualInstances = new Stack<>();
    private Stack<List<InstanceSpecification>> currentUnusedInstances = new Stack<>();
    private Stack<List<PresentationElementInstance>> newpe = new Stack<>();

    private boolean main = false; //for ems 2.2 reference tree, only consider generated pe from main view and
    //not nested tables/lists since those are embedded in json blob, main is false for Table and List Visitor

    private PresentationElementUtils viu = new PresentationElementUtils();

    public DBAlfrescoVisitor(boolean recurse) {
        this(recurse, false);
    }

    public DBAlfrescoVisitor(boolean recurse, boolean main) {
        this.recurse = recurse;
        sourceMapping.put(From.DOCUMENTATION, "documentation");
        sourceMapping.put(From.DVALUE, "value");
        sourceMapping.put(From.NAME, "name");
        this.main = main;
    }

    public Set<DBImage> getImages() {
        return images;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void visit(DBBook book) {
        sibviewsElements.push(new ArrayList<Element>());

        if (book.getFrom() != null) {
            doc = true;
            Element docview = book.getFrom();
            startView(docview);
            for (DocumentElement de : book.getChildren()) {
                if (de instanceof DBSection && ((DBSection) de).isView()) {
                    break;
                }
                de.accept(this);
            }
        }
        if (recurse || !doc) {
            for (DocumentElement de : book.getChildren()) {
                if (de instanceof DBSection && ((DBSection) de).isView()) {
                    de.accept(this);
                    if (!recurse) {
                        break;
                    }
                }
            }
        }
        if (doc) {
            endView(book.getFrom());
        }
        sibviewsElements.pop();
    }

    @Override
    public void visit(DBColSpec colspec) {

    }

    @SuppressWarnings("unchecked")
    protected JSONObject getJSONForDBImage(DBImage image) {
        images.add(image);

        JSONObject entry = new JSONObject();
        entry.put("type", "Image");
        entry.put(MDKConstants.ID_KEY, Converters.getElementToIdConverter().apply(image.getImage()));
        entry.put("title", image.getTitle());
        entry.put("excludeFromList", image.isExcludeFromList());
        return entry;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void visit(DBImage image) {
        if (!main) {
            return;
        }
        String id;
        if (image.getFrom() != null && (id = Converters.getElementToIdConverter().apply(image.getFrom())) != null) {
            viewElements.peek().add(id);
        }
        JSONObject entry = getJSONForDBImage(image);
        InstanceSpecification i = null;
        if (!currentImageInstances.peek().isEmpty()) {
            i = currentImageInstances.peek().remove(0);
            currentInstanceList.peek().remove(i);
        }
        PresentationElementInstance parentSec = currentSection.isEmpty() ? null : currentSection.peek();
        PresentationElementInstance ipe = new PresentationElementInstance(i, entry, PresentationElementClasses.IMAGE, currentView.peek(), (image.getTitle() == null ? "image" : image.getTitle()), parentSec, null);
        newpe.peek().add(ipe);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void visit(DBList list) {
        if (!main) {
            return;
        }
        DBAlfrescoListVisitor l = new DBAlfrescoListVisitor(recurse);
        list.accept(l);
        viewElements.peek().addAll(l.getListElements());
        elementSet.addAll(l.getElementSet());
        images.addAll(l.getImages());

        InstanceSpecification i = null;
        if (!currentListInstances.peek().isEmpty()) {
            i = currentListInstances.peek().remove(0);
            currentInstanceList.peek().remove(i);
        }

        PresentationElementInstance parentSec = currentSection.isEmpty() ? null : currentSection.peek();
        PresentationElementInstance ipe = new PresentationElementInstance(i, l.getObject(), PresentationElementClasses.LIST, currentView.peek(), "list", parentSec, null);
        newpe.peek().add(ipe);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void visit(DBParagraph para) {
        if (!main) {
            return;
        }
        String id;
        if (para.getFrom() != null && (id = Converters.getElementToIdConverter().apply(para.getFrom())) != null) {
            viewElements.peek().add(id);
        }
        JSONObject entry = getJSONForDBParagraph(para);
        InstanceSpecification i = null;
        if (!currentParaInstances.peek().isEmpty()) {
            i = currentParaInstances.peek().remove(0);
            currentInstanceList.peek().remove(i);
        }

        PresentationElementInstance parentSec = currentSection.isEmpty() ? null : currentSection.peek();
        PresentationElementInstance ipe = new PresentationElementInstance(i, entry, PresentationElementClasses.PARAGRAPH, currentView.peek(), "paragraph", parentSec, null);
        newpe.peek().add(ipe);
    }

    @SuppressWarnings("unchecked")
    protected JSONObject getJSONForDBParagraph(DBParagraph para) {
        JSONObject entry = new JSONObject();
        if (para.getFrom() != null && para.getFromProperty() != null) {
            entry.put("sourceType", "reference");
            entry.put("source", Converters.getElementToIdConverter().apply(para.getFrom()));
            entry.put("sourceProperty", sourceMapping.get(para.getFromProperty()));
        }
        else {
            entry.put("sourceType", "text");
            entry.put("text", DocGenUtils.addP(DocGenUtils.fixString(para.getText(), false)));
        }
        entry.put("nonEditable", para.isEditable() != null && !para.isEditable());
        entry.put("type", "Paragraph");
        return entry;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void visit(DBText text) {
        if (!main) {
            return;
        }
        String id;
        if (text.getFrom() != null && (id = Converters.getElementToIdConverter().apply(text.getFrom())) != null) {
            viewElements.peek().add(id);
        }
        JSONObject entry = getJSONForDBText(text);
        InstanceSpecification i = null;
        if (!currentParaInstances.peek().isEmpty()) {
            i = currentParaInstances.peek().remove(0);
            currentInstanceList.peek().remove(i);
        }

        PresentationElementInstance parentSec = currentSection.isEmpty() ? null : currentSection.peek();
        PresentationElementInstance ipe = new PresentationElementInstance(i, entry, PresentationElementClasses.PARAGRAPH, currentView.peek(), "paragraph", parentSec, null);
        newpe.peek().add(ipe);
    }

    @SuppressWarnings("unchecked")
    protected JSONObject getJSONForDBText(DBText text) {
        JSONObject entry = new JSONObject();
        if (text.getFrom() != null && text.getFromProperty() != null) {
            entry.put("sourceType", "reference");
            entry.put("source", Converters.getElementToIdConverter().apply(text.getFrom()));
            entry.put("sourceProperty", sourceMapping.get(text.getFromProperty()));
        }
        else {
            entry.put("sourceType", "text");
            entry.put("text", DocGenUtils.addP(DocGenUtils.fixString(text.getText(), false)));
        }
        entry.put("type", "Paragraph");
        return entry;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void visit(DBSection section) {
        if (section.isView()) {
            Element eview = section.getFrom();
            startView(eview);

            for (DocumentElement de : section.getChildren()) {
                if (!recurse && de instanceof DBSection && ((DBSection) de).isView()) {
                    break;
                }
                de.accept(this);
                addManualInstances(false);
            }
            endView(eview);
        }
        else {
            startSection(section);
            for (DocumentElement de : section.getChildren()) {
                de.accept(this);
                addManualInstances(false);
            }
            endSection(section);

        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void visit(DBSimpleList simplelist) {
        DBHTMLVisitor html = new DBHTMLVisitor();
        simplelist.accept(html);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void visit(DBPlot plot) {
        JSONObject entry = new JSONObject();
        entry.put("title", plot.getTitle());
        entry.put("ptype", plot.getType());
        entry.put("config", plot.getConfig());
        DBTable table = plot.getTable();
        DBAlfrescoTableVisitor v = new DBAlfrescoTableVisitor(this.recurse);
        table.accept(v);
        entry.put("table", v.getObject());
        entry.put("type", "Plot");

        InstanceSpecification i = null;
        if (!currentFigureInstances.peek().isEmpty()) {
            i = currentFigureInstances.peek().remove(0);
            currentInstanceList.peek().remove(i);
        }

        PresentationElementInstance parentSec = currentSection.isEmpty() ? null : currentSection.peek();
        PresentationElementInstance ipe = new PresentationElementInstance(i, entry, PresentationElementClasses.FIGURE, currentView.peek(), "plot", parentSec, null);
        System.out.println(entry.toJSONString());
        newpe.peek().add(ipe);
    }

    @Override
    public void visit(DBTomSawyerDiagram tomSawyerDiagram) {
        String id;
        if (tomSawyerDiagram.getFrom() != null && (id = Converters.getElementToIdConverter().apply(tomSawyerDiagram.getFrom())) != null) {
            viewElements.peek().add(id);
        }
        JSONObject entry = new JSONObject();
        entry.put("type", "TomSawyerDiagram");
        entry.put("diagramType", tomSawyerDiagram.getType() != null ? tomSawyerDiagram.getType().getAbbreviation() : null);
        JSONArray elements = new JSONArray();
        tomSawyerDiagram.getElements().stream().map(element -> Converters.getElementToIdConverter().apply(element)).filter(Objects::nonNull).forEach(elements::add);
        entry.put("elements", elements);
        switch (tomSawyerDiagram.getType()) {
            case INTERNAL_BLOCK:
            case PARAMETRIC:
                entry.put("context", Converters.getElementToIdConverter().apply(tomSawyerDiagram.getContext()));
                break;
        }

        InstanceSpecification i = null;
        if (!currentFigureInstances.peek().isEmpty()) {
            i = currentFigureInstances.peek().remove(0);
            currentInstanceList.peek().remove(i);
        }

        //TODO should add new presentation element OpaqueFigure type
        PresentationElementInstance parentSec = currentSection.isEmpty() ? null : currentSection.peek();
        PresentationElementInstance ipe = new PresentationElementInstance(i, entry, PresentationElementClasses.FIGURE, currentView.peek(), "tomSawyerDiagram", parentSec, null);
        newpe.peek().add(ipe);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void visit(DBTable table) {
        if (!main) {
            return;
        }
        DBAlfrescoTableVisitor v = new DBAlfrescoTableVisitor(this.recurse);
        table.accept(v);
        viewElements.peek().addAll(v.getTableElements());
        elementSet.addAll(v.getElementSet());
        images.addAll(v.getImages());

        InstanceSpecification i = null;
        if (!currentTableInstances.peek().isEmpty()) {
            i = currentTableInstances.peek().remove(0);
            currentInstanceList.peek().remove(i);
        }

        PresentationElementInstance parentSec = currentSection.isEmpty() ? null : currentSection.peek();
        PresentationElementInstance ipe = new PresentationElementInstance(i, v.getObject(), PresentationElementClasses.TABLE, currentView.peek(), table.getTitle() != null ? table.getTitle() : "table", parentSec, null);
        newpe.peek().add(ipe);
    }

    @SuppressWarnings("unchecked")
    public void startView(Element e) {
        //MDEV #673
        //Update code to create a specialization
        //object and then insert appropriate
        //sub-elements in that specialization object.
        //
        Set<String> viewE = new HashSet<>();
        viewElements.push(viewE);
        sibviewsElements.peek().add(e);
        sibviewsElements.push(new ArrayList<>());

        //for ems 2.2 reference tree
        currentView.push(e);
        List<PresentationElementInstance> viewChildren = new ArrayList<>();
        newpe.push(viewChildren);
        view2pe.put(e, viewChildren);
        view2peOld.put(e, new ArrayList<>());

        processCurrentInstances(e, e);
        addManualInstances(false);
    }

    @SuppressWarnings("unchecked")
    public void endView(Element e) {
        JSONArray viewEs = new JSONArray();
        viewEs.addAll(viewElements.pop());
        view2viewElements.put(e, sibviewsElements.pop());

        //for ems 2.2 reference tree
        view2elements.put(e, viewEs);
        addManualInstances(true);
        processUnusedInstances(e);
        currentView.pop();
        currentManualInstances.pop();
        currentImageInstances.pop();
        currentSectionInstances.pop();
        currentParaInstances.pop();
        currentListInstances.pop();
        currentTableInstances.pop();
        currentFigureInstances.pop();
        currentInstanceList.pop();
        currentUnusedInstances.pop();
    }

    protected void startSection(DBSection section) {
        JSONObject newSection = new JSONObject();

        newSection.put("type", "Section");
        newSection.put("name", section.getTitle());

        //for ems 2.2 reference tree
        InstanceSpecification sec = null;
        Element loopElement = null;
        if (section.getDgElement() instanceof Section) {
            if (((Section) section.getDgElement()).getLoopElement() != null) {
                loopElement = ((Section) section.getDgElement()).getLoopElement();
                sec = findInstanceForSection(loopElement);
            }
            else {
                sec = findInstanceForSection(null);
            }
        }
        if (sec != null) {
            currentInstanceList.peek().remove(sec);
            currentSectionInstances.peek().remove(sec);
        }

        PresentationElementInstance parentSec = currentSection.isEmpty() ? null : currentSection.peek();
        List<PresentationElementInstance> secChildren = new ArrayList<PresentationElementInstance>();
        PresentationElementInstance pe = new PresentationElementInstance(sec, newSection, PresentationElementClasses.SECTION, currentView.peek(), section.getTitle() != null ? section.getTitle() : "section", parentSec, secChildren);
        pe.setLoopElement(loopElement);
        newpe.peek().add(pe);
        currentSection.push(pe);
        newpe.push(secChildren);
        processCurrentInstances(sec, currentView.peek());
        addManualInstances(false);
    }

    protected void endSection(DBSection section) {
        //for ems 2.2 reference tree
        addManualInstances(true);
        processUnusedInstances(currentView.peek());
        newpe.pop();
        currentSection.pop();
        currentManualInstances.pop();
        currentImageInstances.pop();
        currentSectionInstances.pop();
        currentParaInstances.pop();
        currentListInstances.pop();
        currentTableInstances.pop();
        currentFigureInstances.pop();
        currentInstanceList.pop();
        currentUnusedInstances.pop();
    }

    public Map<Element, List<Element>> getHierarchyElements() {
        return view2viewElements;
    }

    public Map<Element, JSONArray> getView2Elements() {
        return view2elements;
    }

    public Set<Element> getElementSet() {
        return elementSet;
    }

    public Map<Element, List<PresentationElementInstance>> getView2Pe() {
        return view2pe;
    }

    public Map<Element, List<PresentationElementInstance>> getView2Unused() {
        return view2peOld;
    }

    private void processCurrentInstances(Element viewOrSection, Element view) {
        PresentationElementInfo info = viu.getCurrentInstances(viewOrSection, view);
        currentInstanceList.push(info.getAll());
        currentImageInstances.push(info.getImages());
        currentTableInstances.push(info.getTables());
        currentFigureInstances.push(info.getFigures());
        currentParaInstances.push(info.getParas());
        currentListInstances.push(info.getLists());
        currentSectionInstances.push(info.getSections());
        currentManualInstances.push(info.getManuals());
        currentUnusedInstances.push(info.getUnused());
    }

    private InstanceSpecification findInstanceForSection(Element e) {
        if (e != null) {
            for (InstanceSpecification is : currentSectionInstances.peek()) {
                for (Element el : is.getOwnedElement()) {
                    if (el instanceof Slot && ((Slot) el).getDefiningFeature().getName().equals("generatedFromElement") &&
                            !((Slot) el).getValue().isEmpty() && ((Slot) el).getValue().get(0) instanceof ElementValue &&
                            ((ElementValue) ((Slot) el).getValue().get(0)).getElement() == e) {
                        return is;
                    }
                }
            }
            return null;
        }
        for (InstanceSpecification is : currentSectionInstances.peek()) {
            boolean loop = false;
            for (Element el : is.getOwnedElement()) {
                if (el instanceof Slot && ((Slot) el).getDefiningFeature().getName().equals("generatedFromElement")) {
                    loop = true;
                }
                break;
            }
            if (loop) {
                continue;
            }
            return is;
        }
        return null;
    }

    private void addManualInstances(boolean all) {
        List<InstanceSpecification> instances = currentInstanceList.peek();
        List<InstanceSpecification> manuals = currentManualInstances.peek();
        while (!instances.isEmpty() && manuals.contains(instances.get(0))) {
            InstanceSpecification is = instances.get(0);
            PresentationElementInstance pe = new PresentationElementInstance(is, null, null, null, null, null, null);
            pe.setManual(true);
            newpe.peek().add(pe);
            manuals.remove(is);
            instances.remove(is);
        }
        if (all) {
            for (InstanceSpecification is : new ArrayList<InstanceSpecification>(manuals)) {
                PresentationElementInstance pe = new PresentationElementInstance(is, null, null, null, null, null, null);
                pe.setManual(true);
                newpe.peek().add(pe);
                manuals.remove(is);
                instances.remove(is);
            }
        }
    }

    private void processUnusedInstances(Element v) {
        for (InstanceSpecification is : currentTableInstances.peek()) {
            view2peOld.get(v).add(new PresentationElementInstance(is, null, PresentationElementClasses.TABLE, v, is.getName(), null, null));
        }
        for (InstanceSpecification is : currentFigureInstances.peek()) {
            view2peOld.get(v).add(new PresentationElementInstance(is, null, PresentationElementClasses.FIGURE, v, is.getName(), null, null));
        }
        for (InstanceSpecification is : currentListInstances.peek()) {
            view2peOld.get(v).add(new PresentationElementInstance(is, null, PresentationElementClasses.LIST, v, is.getName(), null, null));
        }
        for (InstanceSpecification is : currentParaInstances.peek()) {
            view2peOld.get(v).add(new PresentationElementInstance(is, null, PresentationElementClasses.PARAGRAPH, v, is.getName(), null, null));
        }
        for (InstanceSpecification is : currentImageInstances.peek()) {
            view2peOld.get(v).add(new PresentationElementInstance(is, null, PresentationElementClasses.IMAGE, v, is.getName(), null, null));
        }
        for (InstanceSpecification is : currentSectionInstances.peek()) {
            view2peOld.get(v).add(new PresentationElementInstance(is, null, PresentationElementClasses.SECTION, v, is.getName(), null, null));
        }
        for (InstanceSpecification is : currentUnusedInstances.peek()) {
            view2peOld.get(v).add(new PresentationElementInstance(is, null, null, v, is.getName(), null, null));
        }
    }
}

