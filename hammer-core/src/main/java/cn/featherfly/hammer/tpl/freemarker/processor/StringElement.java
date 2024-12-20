
package cn.featherfly.hammer.tpl.freemarker.processor;

/**
 * StringElement .
 *
 * @author zhongj
 */
public class StringElement extends AbstractElement {

    private char preSqlStringChar = 0;

    /**
     * Instantiates a new string element.
     *
     * @param namedParamPlaceholder the named param placeholder
     * @param previous              the previous
     * @param parser                the parser
     */
    public StringElement(boolean namedParamPlaceholder, Element previous, Parser parser) {
        super(namedParamPlaceholder, previous, parser);
    }

    /**
     * Instantiates a new string element.
     *
     * @param value                 the value
     * @param namedParamPlaceholder the named param placeholder
     * @param previous              the previous
     * @param parser                the parser
     */
    public StringElement(String value, boolean namedParamPlaceholder, Element previous, Parser parser) {
        super(namedParamPlaceholder, previous, parser);
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

    private boolean allow2(char c) {
        return c != parser.getFuzzyQueryChar();
    }

    private boolean allow(char c) {
        // FIXME 这里其实有BUG，如果有转义符在字符串中间，会出问题，但是一般在sql中的参数很少会用到转移符，后续看需不需要处理
        if (preSqlStringChar == 0) {
            if (parser.isSqlStringWarpChar(c)) {
                preSqlStringChar = c; //字符串开始
                return true;
            } else {
                return allow2(c);
            }
        } else if (preSqlStringChar == c) {
            preSqlStringChar = 0; // 字符串结束
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getValue() {
        String result = source.toString();
        if (result.trim().equals("(")) {
            return result.replaceAll("\\(", "");
        }
        if (result.trim().equals(")")) {
            return result.replaceAll("\\)", "");
        }
        return parser.scanParamName(result);
    }
}
