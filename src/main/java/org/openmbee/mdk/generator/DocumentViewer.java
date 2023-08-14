package org.openmbee.mdk.generator;

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement;
import org.openmbee.mdk.docgen.DocGenUtils;
import org.openmbee.mdk.docgen.table.EditableTable;
import org.openmbee.mdk.model.*;
import org.openmbee.mdk.model.Container;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * viewer for docgen 3 document someone should make the gui appear nicer
 *
 * @author dlam
 */
public class DocumentViewer {

    static class ParagraphRenderer extends JTextArea implements TableCellRenderer {
        private static final long serialVersionUID = 1L;

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int col) {
            this.setLineWrap(true);
            this.setWrapStyleWord(true);
            if (value instanceof String) {
                this.setText((String) value);
            }
            else {
                this.setText("");
            }
            if (this.getText().length() > 80 || this.getText().contains("\n")) {
                table.setRowHeight(row, 50);
            }
            // JScrollPane pane = new JScrollPane(this);
            return this;
        }
    }

    public static void view(Document d) {
        List<List<Object>> body = new ArrayList<List<Object>>();
        List<Integer> sections = new ArrayList<Integer>();
        List<String> headers = new ArrayList<String>();
        headers.add("View/Template");
        headers.add("Targets/text (for templates)");
        sections.add(1);
        for (DocGenElement dge : d.getChildren()) {
            makeBody(dge, sections, body);
            sections.set(0, sections.get(0) + 1);
        }
        EditableTable et = new EditableTable("Document Preview", body, headers, null, null, null);
        et.prepareTable();
        et.getTable().getColumnModel().getColumn(1).setCellRenderer(new ParagraphRenderer());
        et.showTable();
    }

    private static void makeBody(DocGenElement dge, List<Integer> sections, List<List<Object>> body) {
        List<Object> row = new ArrayList<Object>();
        int indent = sections.size() - 1;
        String titlePrefix = dge.getTitlePrefix();
        String titleSuffix = dge.getTitleSuffix();
        titlePrefix = titlePrefix == null ? "" : titlePrefix;
        titleSuffix = titleSuffix == null ? "" : titleSuffix;
        if (dge instanceof Container) {
            String title = ((Container) dge).getTitle();
            title = title == null ? "(no title)" : title;
            String display = makeStringFromSections(sections) + " " + titlePrefix + title + titleSuffix;
            display = getIndented(display, indent);
            row.add(display);
            row.add("");
            body.add(row);
            sections.add(0);
            for (DocGenElement dge2 : ((Container) dge).getChildren()) {
                if (dge2 instanceof Container) {
                    sections.set(sections.size() - 1, sections.get(sections.size() - 1) + 1);
                }
                makeBody(dge2, sections, body);
            }
            sections.remove(sections.size() - 1);
        }
        else if (dge instanceof Query) {
            String templateType = dge.getClass().getSimpleName();
            List<Object> targets = ((Query) dge).getTargets();
            List<String> titles = ((Query) dge).getTitles();
            String title = (titles != null && titles.size() > 0) ? titles.get(0) : "(no title)";
            String display = "(" + templateType + ") " + titlePrefix + title + titleSuffix;
            display = getIndented(display, indent);
            row.add(display);
            if (dge instanceof Paragraph && ((Paragraph) dge).getText() != null) {
                row.add(((Paragraph) dge).getText());
            }
            else {
                row.add(stringFromTargets(targets));
            }
            body.add(row);
        }
    }

    private static String stringFromTargets(List<Object> targets) {
        if (targets == null || targets.isEmpty()) {
            return "(no targets)";
        }
        String res = "";
        for (Object e : targets) {
            if (e instanceof NamedElement) {
                res += ((NamedElement) e).getName() + "\n";
            }
            else if (e instanceof Element) {
                res += "(element)" + "\n";
            }
            else {
                res += DocGenUtils.fixString(e);
            }
        }
        return res;
    }

    private static String makeStringFromSections(List<Integer> sections) {
        String res = "";
        res += Integer.toString(sections.get(0));
        for (Integer i : sections.subList(1, sections.size())) {
            res += "." + Integer.toString(i);
        }
        return res;
    }

    private static String getIndented(String s, int i) {
        String res = "";
        for (int j = 0; j < i; j++) {
            res += "    ";
        }
        return res + s;
    }

}
