
package cn.featherfly.hammer.tpl.freemarker.processor;

import java.util.List;

/**
 * Element.
 *
 * @author zhongj
 */
public interface Element {

    String getValue();

    String getSource();

    Element parent();

    Element previous();

    int getStart();

    int getEnd();

    List<Element> childs();
}
