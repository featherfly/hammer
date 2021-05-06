
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
    public StringElement(Parser parser) {
        super(parser);
    }

    /**
     * Instantiates a new string element.
     *
     * @param value the value
     */
    public StringElement(String value, Parser parser) {
        super(parser);
        append(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AbstractElement append(char c) {
        if (allow(c)) {
            return super.append(c);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AbstractElement append(String str) {
        return super.append(str.chars().filter(c -> allow((char) c))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString());
    }

    private boolean allow(char c) {
        return c != parser.getFuzzyQueryChar();
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
