package org.openmbee.mdk.model;

import com.nomagic.uml2.ext.magicdraw.actions.mdbasicactions.CallBehaviorAction;
import com.nomagic.uml2.ext.magicdraw.activities.mdbasicactivities.ActivityEdge;
import com.nomagic.uml2.ext.magicdraw.activities.mdbasicactivities.InitialNode;
import com.nomagic.uml2.ext.magicdraw.activities.mdfundamentalactivities.ActivityNode;
import com.nomagic.uml2.ext.magicdraw.activities.mdstructuredactivities.StructuredActivityNode;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.EnumerationLiteral;
import org.openmbee.mdk.docgen.docbook.DBPlot;
import org.openmbee.mdk.docgen.docbook.DBTable;
import org.openmbee.mdk.docgen.docbook.DocumentElement;
import org.openmbee.mdk.docgen.ViewViewpointValidator;
import org.openmbee.mdk.util.GeneratorUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by mw107 on 7/5/2017.
 */
public class Plot extends TableStructure {
    protected String title;
    protected String type;
    protected String config;

    public Plot(ViewViewpointValidator validator) {
        super(validator);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    @Override
    public void parse() {
        super.parse();
    }

    @Override
    public List<DocumentElement> visit(boolean forViewEditor, String outputDir) {
        List<DocumentElement> res = new ArrayList<DocumentElement>();
        if (ignore) {
            return res;
        }

        DBPlot p = new DBPlot();
        p.setTitle(title);
        p.setType(type);
        p.setConfig(config);
        List<DocumentElement> tres = super.visit(forViewEditor, outputDir);
        p.setTable((DBTable) tres.get(0));
        res.add(p);
        return res;

    }

    @SuppressWarnings("unchecked")
    @Override
    public void initialize() {
        super.initialize();
        String title = ((String) GeneratorUtils.getStereotypePropertyFirst(dgElement, profile.plot().getPlotTitleProperty(), "")).replace("'", "\\'").replace("\"", "'");
        String config = ((String) GeneratorUtils.getStereotypePropertyFirst(dgElement, profile.plot().getPlotConfigurationProperty(), "")).replace("'", "\\'").replace("\"", "'");
        String type = GeneratorUtils.getStereotypePropertyValue(dgElement, profile.plot().getPlotTypeProperty(), Collections.emptyList()).stream().filter(p -> p instanceof EnumerationLiteral).map(p -> ((EnumerationLiteral) p).getName()).findFirst().orElse("");

        setTitle(title);
        setConfig(config);
        setType(type);


        //find dgelement for table structure.
        Element temp;
        if (dgElement instanceof StructuredActivityNode) {
            temp = dgElement;
        }
        else if (dgElement instanceof CallBehaviorAction) {
            temp = ((CallBehaviorAction) dgElement).getBehavior();
        }
        else {
            temp = null;
        }
        //replace dgElement for table
        InitialNode in = null;
        if (temp != null) {
            in = GeneratorUtils.findInitialNode(temp);
            if (in != null) {
                Collection<ActivityEdge> outs = in.getOutgoing();
                if (outs != null && outs.size() == 1) {
                    ActivityNode next = outs.iterator().next().getTarget();
                    if (next instanceof StructuredActivityNode
                            && profile.tableStructure().is(next)) {
                        dgElement = next;
                    }
                }
            }
            else //uwhen c3plot does not have initialNode to TableStructure
            {
                dgElement = temp.getOwnedElement().stream()
                        .filter(x -> (x instanceof StructuredActivityNode
                                && profile.tableStructure().is(x)))
                        //.collect(java.util.stream.Collectors.toList()); //return List<Element>
                        .findAny().orElse(null);
                //dgElement = null;
            }
        }
        else {
            dgElement = null;
        }

        super.initialize();

    }
}
