package org.openmbee.mdk.model;

import com.nomagic.magicdraw.actions.MDAction;
import com.nomagic.magicdraw.core.Application;
import org.openmbee.mdk.SysMLExtensions;
import org.openmbee.mdk.docgen.docbook.DocumentElement;
import org.openmbee.mdk.generator.Generatable;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * This class should be extended if writing java extensions, or any of its
 * subclass like Table
 * </p>
 *
 * @author dlam
 */
public abstract class Query extends DocGenElement implements Generatable {
    /**
     * The elements passed into this query. These are magicdraw elements
     * resulting from collect/filter/sort actions
     */
    protected List<Object> targets;
    protected List<String> titles;
    protected boolean sortElementsByName = false;

    public void setTargets(List<Object> t) {
        targets = t;
    }

    public List<Object> getTargets() {
        return targets;
    }

    public void setTitles(List<String> t) {
        titles = t;
    }

    public List<String> getTitles() {
        return titles;
    }

    public boolean isSortElementsByName() {
        return sortElementsByName;
    }

    public void setSortElementsByName(boolean sortElementsByName) {
        this.sortElementsByName = sortElementsByName;
    }

    /**
     * This is called after the query object has been constructed and the
     * targets and dgElement fields are set
     */
    @Override
    public void initialize() {
        if (profile == null) {
            profile = SysMLExtensions.getInstanceByProject(Application.getInstance().getProject());
        }
    }

    /**
     * This method must be overidden by subclasses to return the result of the
     * query
     */
    @Override
    public List<DocumentElement> visit(boolean forViewEditor, String outputDir) {
        return new ArrayList<DocumentElement>();
    }

    /**
     * This is called after initialize
     */
    @Override
    public void parse() {

    }

    /**
     * <p>
     * These actions will show up as menu items under View Interaction, if the
     * user right clicks on a view that will execute this query
     * </p>
     * <p>
     * targets and dgElement would have been filled
     * </p>
     */
    @Override
    public List<MDAction> getActions() {
        return new ArrayList<MDAction>();
    }

    @Override
    public void accept(IModelVisitor visitor) {
        visitor.visit(this);
    }

    protected static HashSet<Field> notToStringSet = new HashSet<Field>() {
        private static final long serialVersionUID = -2943965696220565323L;

        {
            try {
                //add(Query.class.getField( "sortElementsByName" ));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    protected Set<Field> notToString() {
        return notToStringSet;
    }

    @Override
    public String toStringStart() {
        StringBuffer sb = new StringBuffer();
        sb.append(super.toStringStart());
        for (Field f : getClass().getDeclaredFields()) {
            if (notToString().contains(f)) {
                continue;
            }
            f.setAccessible(true);
            try {
                sb.append("," + f.getName() + "=" + f.get(this));
            } catch (IllegalArgumentException e) {
            } catch (IllegalAccessException e) {
            }
        }
        return sb.toString();
    }

}
