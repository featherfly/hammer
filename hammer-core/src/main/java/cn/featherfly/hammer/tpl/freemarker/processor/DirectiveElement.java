
package cn.featherfly.hammer.tpl.freemarker.processor;

import cn.featherfly.common.lang.Lang;
import cn.featherfly.hammer.tpl.TplException;

/**
 * DirectiveElement.
 *
 * @author zhongj
 */
public class DirectiveElement extends AbstractElement {

    protected char directive = '@';

    protected char macro = '#';

    //    /**
    //     * Instantiates a new directive element.
    //     *
    //     * @param parser the parser
    //     */
    //    public DirectiveElement(Parser parser) {
    //        this("", parser);
    //    }

    /**
     * Instantiates a new directive element.
     *
     * @param value                 the value
     * @param namedParamPlaceholder the named param placeholder
     * @param previous              the previous
     * @param parser                the parser
     */
    public DirectiveElement(String value, boolean namedParamPlaceholder, Element previous, Parser parser) {
        super(value, namedParamPlaceholder, previous, parser);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getValue() {
        if (Lang.isEmpty(childs)) {
            return wrapDirective();
        } else {
            return getValue(this);
        }
    }

    /**
     * Warp directive.
     *
     * @return the string
     */
    protected String wrapDirective() {
        if (isReplaceable()) {
            if (parser.hasReplaceableTarget(source.toString())) {
                String result = null;
                boolean isStartWith = source.charAt(2) == parser.getFuzzyQueryChar();
                boolean isEndWith = source.charAt(source.length() - 1) == parser.getFuzzyQueryChar();
                if (isStartWith && isEndWith) {
                    result = source.substring(3, source.length() - 1);
                } else if (isEndWith) {
                    result = source.substring(2, source.length() - 1);
                } else if (isStartWith) {
                    result = source.substring(3);
                } else {
                    result = source.substring(2);
                }

                if (!namedParamPlaceholder) {
                    parser.scanParamName(result, previous != null && previous.getSource().trim().endsWith("in"));
                    return "?";
                }

                return result;
            } else {
                throw new TplException(
                        "replaceable warp directive has no replaceble target, you can give target after $=");
            }
        } else {
            if (isEnclosed()) {
                return getString(false, true);
            } else if (isEnd()) {
                return appendAfterChilds();
            } else {
                return appendBeforeChilds();
            }
        }
    }

    /**
     * Gets the value.
     *
     * @param element the element
     * @return the value
     */
    protected String getValue(Element element) {
        if (Lang.isEmpty(element.childs())) {
            return element.getValue();
        } else {
            StringBuilder sb = new StringBuilder();
            if (element instanceof DirectiveElement) {
                sb.append(((DirectiveElement) element).appendBeforeChilds());
            }
            for (Element child : element.childs()) {
                sb.append(getValue(child));
            }
            if (element instanceof DirectiveElement) {
                sb.append(((DirectiveElement) element).appendAfterChilds());
            }
            return sb.toString();
        }
    }

    /**
     * Append before childs.
     *
     * @return the string
     */
    protected String appendBeforeChilds() {
        return getString(false, false);
    }

    /**
     * Append after childs.
     *
     * @return the string
     */
    protected String appendAfterChilds() {
        return getString(true, false);
    }

    private String getString(boolean isEndDirective, boolean isEnclosed) {
        char sign = directive;
        if (getName().equals("if")) {
            sign = macro;
        }
        String directiveEnd = "";
        if (isEndDirective) {
            directiveEnd = "/";
        }
        String enclosed = "";
        if (isEnclosed) {
            enclosed = "/";
        }
        String content = null;
        if (isEndDirective) {
            content = getName();
        } else {
            content = getNameAndAttr();
        }
        return new StringBuilder().append("<").append(directiveEnd).append(sign).append(content).append(enclosed)
                .append(">").toString();

    }

    //    private String getValue(Element element) {
    //        if (Lang.isEmpty(element.childs())) {
    //            return element.getValue();
    //        } else {
    //            StringBuilder sb = new StringBuilder();
    //            for (Element child : element.childs()) {
    //                sb.append(getValue(child));
    //            }
    //            return sb.toString();
    //        }
    //    }

    /**
     * Gets the content.
     *
     * @return the content
     */
    public String getNameAndAttr() {
        return parser.directiveNameAndAttr(source.toString());
        //        StringBuilder sb = new StringBuilder();
        //        for (int i = 0; i < source.length(); i++) {
        //            char c = source.charAt(i);
        //            if (i < 2) {
        //                if (c != '<' && c != '>') {
        //                    sb.append(c);
        //                }
        //            } else {
        //                sb.append(c);
        //            }
        //        }
        //        getValue().chars().forEach(i -> {
        //            char c = (char) i;
        //            if (c != '<' && c != '>') {
        //                sb.append(c);
        //            }
        //        });
        //        return sb.toString();
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return parser.directiveName(source.toString());
    }

    //    /**
    //     * Gets the insert index.
    //     *
    //     * @param v the v
    //     * @return the insert index
    //     */
    //    public int getInsertIndex(String v) {
    //        Strings.trimStart(v);
    //        int newLineIndex = v.indexOf(Chars.NEW_LINEZ_CHAR);
    //        if (isCondition()) {
    //            if (newLineIndex == -1) {
    //                return v.length() - 1;
    //            } else {
    //                return newLineIndex;
    //            }
    //        }
    //        int spaceIndex = v.indexOf(Chars.SPACE_CHAR);
    //        int insertIndex = -1;
    //        if (spaceIndex > 0 && newLineIndex > 0) {
    //            insertIndex = spaceIndex < newLineIndex ? spaceIndex : newLineIndex;
    //        } else if (spaceIndex > 0) {
    //            insertIndex = spaceIndex;
    //        } else if (newLineIndex > 0) {
    //            insertIndex = newLineIndex;
    //        }
    //        return insertIndex;
    //    }

    /**
     * Checks if is condition.
     *
     * @return true, if is condition
     */
    public boolean isCondition() {
        return parser.isCondition(source.toString());
    }

    /**
     * Checks if is end.
     *
     * @return true, if is end
     */
    public boolean isEnd() {
        return source.charAt(0) == '>';
    }

    /**
     * Checks if is replaceable.
     *
     * @return true, if is replaceable
     */
    public boolean isReplaceable() {
        return parser.isReplaceable(source.toString());
    }

    /**
     * Gets the replace.
     *
     * @return the replace
     */
    public String getReplace() {
        return source.substring(2);
    }

    //    /**
    //     * End wrapper.
    //     *
    //     * @param c the c
    //     * @return true, if successful
    //     */
    //    public boolean endWrapper(char c) {
    //        if (isCondition()) {
    //            return Chars.NEW_LINEZ_CHAR == c;
    //        }
    //        if (isWrapper()) {
    //            return Chars.SPACE_CHAR == c || Chars.NEW_LINEZ_CHAR == c;
    //        }
    //        //        if (source.charAt(0) == '<') {
    //        //        }
    //        return false;
    //    }

    /**
     * Checks if is group start.
     *
     * @return true, if is group start
     */
    public boolean isGroupStart() {
        if (source.length() == 0) {
            return false;
        }
        return source.charAt(0) == '<' && source.length() > 1 && source.charAt(1) != '<';
    }

    /**
     * Checks if is wrapper.
     *
     * @return true, if is wrapper
     */
    public boolean isWrapper() {
        return parser.isWrapper(source.toString());
        //        if (source.length() == 0) {
        //            return false;
        //        }
        //        boolean b = source.charAt(0) == '<';
        //        if (b) {
        //            return source.length() > 1 && source.charAt(1) == '<';
        //        }
        //        return Character.isLetter(source.charAt(0));
    }

    /**
     * Checks if is empty condition param.
     *
     * @return true, if is empty condition param
     */
    public boolean isEmptyConditionParam() {
        return parser.isEmptyConditionParam(source.toString());
    }

    /**
     * Checks if is enclose.
     *
     * @return true, if is enclose
     */
    public boolean isEnclosed() {
        return parser.isEnclosed(source.toString());
    }

}