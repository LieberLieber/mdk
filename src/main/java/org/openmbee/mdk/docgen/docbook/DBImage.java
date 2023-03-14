package org.openmbee.mdk.docgen.docbook;

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Diagram;

/**
 * Print an image with optional caption. If you're using this directly, you will
 * need to add the documentation as the caption if applicable, and set the
 * title.
 *
 * @author dlam
 */
public class DBImage extends DocumentElement {

    private Diagram image;
    private String caption;
    private boolean doNotShow;
    private boolean excludeFromList;

    public DBImage(Diagram diagram) {
        this.image = diagram;
    }

    public DBImage() {
    }

    public void setDiagram(Diagram d) {
        image = d;
    }

    public void setCaption(String cap) {
        caption = cap;
    }

    public Diagram getImage() {
        return image;
    }

    public void setImage(Diagram image) {
        this.image = image;
    }

    public String getCaption() {
        return caption;
    }

    public boolean isDoNotShow() {
        return doNotShow;
    }

    public void setDoNotShow(boolean b) {
        doNotShow = b;
    }

    public boolean isExcludeFromList() {
        return excludeFromList;
    }

    public void setExcludeFromList(boolean excludeFromList) {
        this.excludeFromList = excludeFromList;
    }

    @Override
    public void accept(IDBVisitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(super.toString());
        int pos = sb.lastIndexOf(")");
        sb.insert(pos, ", " + getImage());
        return sb.toString();
    }

    @Deprecated
    public boolean isGennew() {
        return true;
    }

    @Deprecated
    public void setGennew(boolean b) {
    }
}
