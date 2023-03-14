package org.openmbee.mdk.viewedit;

import com.nomagic.magicdraw.core.Project;
import org.openmbee.mdk.api.incubating.convert.Converters;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openmbee.mdk.docgen.docbook.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DBAlfrescoTableVisitor extends DBAlfrescoVisitor {

    private JSONObject tablejson;
    private JSONArray curRow;
    private JSONArray curCell;
    private Set<String> tableelements;
    private int rowspan;
    private int colspan;

    // private GUILog gl = Application.getInstance().getGUILog();

    public DBAlfrescoTableVisitor(boolean recurse) {
        super(recurse);
        tablejson = new JSONObject();
        tableelements = new HashSet<String>();
    }

    public JSONObject getObject() {
        return tablejson;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void visit(DBTable table) {
        if (tablejson.containsKey("body")) {
            DBAlfrescoTableVisitor inner = new DBAlfrescoTableVisitor(recurse);
            table.accept(inner);
            curCell.add(inner.getObject());
            tableelements.addAll(inner.getTableElements());
            elementSet.addAll(inner.getElementSet());
        }
        else {
            if (table.isTranspose()) {
                table.transpose();
            }
            JSONArray body = new JSONArray();
            tablejson.put("body", body);
            for (List<DocumentElement> row : table.getBody()) {
                curRow = new JSONArray();
                body.add(curRow);
                for (DocumentElement de : row) {
                    rowspan = 1;
                    colspan = 1;
                    if (de != null) {
                        if (de instanceof DBTableEntry) {
                            de.accept(this);
                        }
                        else {
                            curCell = new JSONArray();
                            de.accept(this);
                            JSONObject entry = new JSONObject();
                            entry.put("content", curCell);
                            addSpans(entry);
                            curRow.add(entry);
                        }
                    }
                }
            }
            if (!table.isHideHeaders()) {
                JSONArray headers = new JSONArray();
                tablejson.put("header", headers);
                if (table.getHeaders() != null) {
                    for (List<DocumentElement> row : table.getHeaders()) {
                        curRow = new JSONArray();
                        headers.add(curRow);
                        for (DocumentElement de : row) {
                            rowspan = 1;
                            colspan = 1;
                            if (de != null) {
                                if (de instanceof DBTableEntry) {
                                    de.accept(this);
                                }
                                else {
                                    curCell = new JSONArray();
                                    de.accept(this);
                                    JSONObject entry = new JSONObject();
                                    entry.put("content", curCell);
                                    addSpans(entry);
                                    curRow.add(entry);
                                }
                            }
                        }
                    }
                }
            }
            if (table.getStyle() == null) {
                tablejson.put("style", "normal");
            }
            else {
                tablejson.put("style", table.getStyle());
            }
            tablejson.put("title", table.getTitle());
            tablejson.put("type", "Table");
            tablejson.put("showIfEmpty", table.isShowIfEmpty());
            tablejson.put("excludeFromList", table.isExcludeFromList());
            JSONArray colwidths = new JSONArray();

            if (table.getColspecs() != null && !table.getColspecs().isEmpty()) {
                for (DBColSpec cs : table.getColspecs()) {
                    colwidths.add(cs.getColwidth());
                }
                tablejson.put("colwidths", colwidths);
            }

            // gl.log( "tablejson =\n" + tablejson );
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void visit(DBTableEntry tableentry) { // TODO; check for
        // informaltable and ignore it
        if (tableentry.getMorerows() > 0) {
            rowspan = tableentry.getMorerows() + 1;
        }
        if (tableentry.getNamest() != null && tableentry.getNameend() != null) {
            try {
                int startcol = Integer.parseInt(tableentry.getNamest());
                int endcol = Integer.parseInt(tableentry.getNameend());
                colspan = endcol - startcol + 1;
            } catch (Exception e) {

            }
        }
        curCell = new JSONArray();
        for (DocumentElement de : tableentry.getChildren()) {
            de.accept(this);
        }
        JSONObject entry = new JSONObject();
        entry.put("content", curCell);
        addSpans(entry);
        curRow.add(entry);
    }

    @Override
    public void visit(DBColSpec colspec) {

    }

    @SuppressWarnings("unchecked")
    @Override
    public void visit(DBImage image) {
        JSONObject entry = getJSONForDBImage(image);
        if (image.getFrom() != null && image.getFromProperty() != null) {
            // TODO how necessary is this?
            if (Converters.getElementToJsonConverter().apply(image.getFrom(), Project.getProject(image.getFrom())) != null) {
                this.tableelements.add(Converters.getElementToIdConverter().apply(image.getFrom()));
            }
        }
        curCell.add(entry);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void visit(DBList list) {
        DBAlfrescoListVisitor listv = new DBAlfrescoListVisitor(this.recurse);
        list.accept(listv);
        tableelements.addAll(listv.getListElements());
        elementSet.addAll(listv.getElementSet());
        curCell.add(listv.getObject());
    }

    @SuppressWarnings("unchecked")
    @Override
    public void visit(DBParagraph para) {
        JSONObject entry = getJSONForDBParagraph(para);
        if (para.getFrom() != null && para.getFromProperty() != null) {
            // TODO how necessary is this?
            if (Converters.getElementToJsonConverter().apply(para.getFrom(), Project.getProject(para.getFrom())) != null) {
                this.tableelements.add(Converters.getElementToIdConverter().apply(para.getFrom()));
            }
        }
        curCell.add(entry);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void visit(DBText text) {
        JSONObject entry = getJSONForDBText(text);
        if (text.getFrom() != null && text.getFromProperty() != null) {
            // TODO how necessary is this?
            if (Converters.getElementToJsonConverter().apply(text.getFrom(), Project.getProject(text.getFrom())) != null) {
                this.tableelements.add(Converters.getElementToIdConverter().apply(text.getFrom()));
            }
        }
        curCell.add(entry);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void visit(DBSimpleList simplelist) {
        DBHTMLVisitor html = new DBHTMLVisitor();
        simplelist.accept(html);
        JSONObject entry = new JSONObject();
        entry.put("sourceType", "text");
        entry.put("text", html.getOut());
        curCell.add(entry);
    }

    @SuppressWarnings("unchecked")
    private void addSpans(JSONObject entry) {
        if (rowspan > 0) {
            entry.put("rowspan", Integer.toString(rowspan));
        }
        if (colspan > 0) {
            entry.put("colspan", Integer.toString(colspan));
        }
    }

    public Set<String> getTableElements() {
        return tableelements;
    }
}

