package org.openmbee.mdk.generator;

import com.nomagic.uml2.ext.jmi.helpers.StereotypesHelper;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;
import org.openmbee.mdk.SysMLExtensions;
import org.openmbee.mdk.model.Container;
import org.openmbee.mdk.model.Document;
import org.openmbee.mdk.model.Section;

/**
 *
 * @author dlam
 */
public class ViewParser {

    private DocumentGenerator dg;
    private boolean singleView;
    private boolean recurse;
    private Document doc;
    private Element start;

    public ViewParser(DocumentGenerator dg, boolean singleView, boolean recurse, Document doc, Element start) {
        this.dg = dg;
        this.singleView = singleView;
        this.recurse = recurse;
        this.doc = doc;
        this.start = start;
    }

    public Section parse() {
        Stereotype documentView = SysMLExtensions.getInstance(start).product().getStereotype();
        if (StereotypesHelper.hasStereotypeOrDerived(start, documentView)) {
            doc.setDgElement(start);
        }
        else {// starting from regular view, not document
            return parseView(start, doc);
        }
        return null;
    }

    /**
     * @param view       current view
     * @param parent     parent view
     */
    private Section parseView(Element view, Container parent) {
        Section viewSection = dg.parseView(view);
        parent.addElement(viewSection);
        return viewSection;
    }
}
