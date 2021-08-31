
package cn.featherfly.hammer.tpl.freemarker.processor;

import java.util.List;

/**
 * <p>
 * Element
 * </p>
 *
 * @author zhongj
 */
public interface Element {

    String getValue();

    String getSource();

    Element parent();

    int getStart();

    int getEnd();

    List<Element> childs();
}
