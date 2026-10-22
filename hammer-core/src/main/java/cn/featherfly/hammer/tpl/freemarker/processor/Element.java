
package cn.featherfly.hammer.tpl.freemarker.processor;

import java.util.List;

/**
 * Element.
 *
 * @author zhongj
 */
public interface Element {

    /**
     * Gets the value.
     *
     * @return the value
     */
    String getValue();

    /**
     * Gets the source.
     *
     * @return the source
     */
    String getSource();

    /**
     * Parent.
     *
     * @return the element
     */
    Element parent();

    /**
     * Previous.
     *
     * @return the element
     */
    Element previous();

    /**
     * Gets the start.
     *
     * @return the start
     */
    int getStart();

    /**
     * Gets the end.
     *
     * @return the end
     */
    int getEnd();

    /**
     * Childs.
     *
     * @return the list
     */
    List<Element> childs();
}
