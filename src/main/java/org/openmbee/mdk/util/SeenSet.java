package org.openmbee.mdk.util;

import java.util.Set;

/**
 * A set of seen (already visited) elements for avoiding infinite recursion.
 */
public interface SeenSet<E> extends Set<E> {

    /**
     * Manage a "seen" set for avoiding infinite recursion. If the element is
     * not in the set, add it and return
     * {@code false). Otherwise, the element has been seen; return {@code true}.
     *
     * @param o         is the object visited
     * @param recursive is whether infinite recursion is possible
     * @return whether the object has already been visited
     */
    boolean see(E element, boolean recursive);

}
