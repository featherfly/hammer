
package cn.featherfly.hammer.tpl.processor;

/**
 * <p>
 * StringElement
 * </p>
 * .
 *
 * @author zhongj
 */
public class StringElement extends AbstractElement {

    /**
     * Instantiates a new string element.
     */
    public StringElement() {
    }

    /**
     * Instantiates a new string element.
     *
     * @param value the value
     */
    public StringElement(String value) {
        super(value);
    }

    @Override
    public String getValue() {
        if (source.toString().trim().equals("(")) {
            return source.toString().replaceAll("\\(", "");
        }
        if (source.toString().trim().equals(")")) {
            return source.toString().replaceAll("\\)", "");
        }
        return source.toString();
    }
}
