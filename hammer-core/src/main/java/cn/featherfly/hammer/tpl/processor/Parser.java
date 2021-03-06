
package cn.featherfly.hammer.tpl.processor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.lang.Strings;
import cn.featherfly.hammer.tpl.TplException;

/**
 * <p>
 * Parser
 * </p>
 * .
 *
 * @author zhongj
 */
public class Parser {

    private char[] directiveStart = new char[] { '/', '*' };

    private char[] directiveEnd = new char[] { '*', '/' };

    private char startDirecitve = '<';

    private char endDirecitve = '>';

    private char namedParamStart = ':';

    private char[] namedParamEnds = { directiveEnd[0], ' ', '\n' };

    private String source;

    /**
     * The Enum NullType.
     */
    public enum NullType {
        /** The null. */
        NULL, EMPTY
    }

    //    Parser parent;

    //    List<Parser> parsers = new ArrayList<>();

    private AbstractElement parentElement;

    /** The elements. */
    List<AbstractElement> elements = new ArrayList<>();

    /**
     * Instantiates a new parser.
     *
     * @param parent the parent
     * @param parent the parent
     */
    private Parser(Parser parent, AbstractElement parentElement) {
        directiveStart = parent.directiveStart;
        directiveEnd = parent.directiveEnd;
        startDirecitve = parent.startDirecitve;
        endDirecitve = parent.endDirecitve;
        this.parentElement = parentElement;
    }

    /**
     * Instantiates a new parser.
     */
    public Parser() {

    }

    /**
     * Instantiates a new parser.
     *
     * @param directiveStart the directive start
     * @param directiveEnd   the directive end
     * @param startDirecitve the start direcitve
     * @param endDirecitve   the end direcitve
     */
    public Parser(char[] directiveStart, char[] directiveEnd, char startDirecitve, char endDirecitve) {
        super();
        this.directiveStart = directiveStart;
        this.directiveEnd = directiveEnd;
        this.startDirecitve = startDirecitve;
        this.endDirecitve = endDirecitve;
    }

    /**
     * Parses the.
     *
     * @param source the source
     */
    public void parse(String source) {
        char c = 0;
        char c2 = 0;
        AbstractElement element = null;
        for (int index = 0; index < source.length();) {
            c = source.charAt(index);
            if (index + 1 < source.length()) {
                c2 = source.charAt(index + 1);
            } else {
                c2 = 0;
            }
            // 直接找到group结束的索引
            if (element instanceof DirectiveElement && ((DirectiveElement) element).isGroupStart()) {
                DirectiveElement de = (DirectiveElement) element;
                if (!de.isEnclosed()) {
                    Directive directive = getEndDirective(source, (DirectiveElement) element);
                    // 去掉directive开始标签和结束标签，因为element就已经代表了这个标签

                    //                Parser parser = new Parser(source.substring(element.getEnd() + 1, directive.start), element);
                    //                parser.parse();
                    Parser parser = new Parser(this, element);
                    int substart = element.getEnd() + 1;
                    if (de.getName().equals("where")) {
                        int wrapIndex = wrapString(source, substart);
                        if (source.substring(substart, wrapIndex).trim().equalsIgnoreCase("where")) {
                            substart = wrapIndex;
                        }
                    }
                    if (de.isCondition()) {
                        int wrapIndex = wrapString(source, substart);
                        String ss = source.substring(substart, wrapIndex).trim();
                        if (ss.equalsIgnoreCase("and")) {
                            de.setSource(de.getSource().replaceAll("\\?", "") + "and");
                            substart = wrapIndex;
                        } else if (ss.equalsIgnoreCase("or")) {
                            de.setSource(de.getSource().replaceAll("\\?", "") + "or");
                            substart = wrapIndex;
                        }
                    }
                    String subSource = source.substring(substart, directive.start);
                    parser.parse(subSource);
                    index = directive.end;
                    element = null;
                }
            } else {
                if (isDirectiveStart(c, c2)) {
                    Directive directive = parseDirective(source, index);
                    element = new DirectiveElement(directive.content, this);
                    addElement(element);
                    element.setEnd(directive.end);
                    element.setStart(directive.start);
                    index = directive.end;
                }
                //                else if (comment) {
                //                    if (!(element instanceof DirectiveElement)) {
                //                        element = new DirectiveElement();
                //                        //                    addChildElement(element);
                //                        //                    elements.add(element);
                //                        addElement(element);
                //                    }
                //                    element.append(c);
                //                    // TODO todo
                //                    if (c == tagSign) {
                //                        if (c2 == tagSign) {
                //                        } else {
                //                        }
                //                    }
                //                }
                else {
                    if (!(element instanceof StringElement)) {
                        DirectiveElement de = null;
                        if (element != null) {
                            de = (DirectiveElement) element;
                        }
                        element = new StringElement();
                        addElement(element);

                        if (de != null) {
                            if (de.isWrapper()) {
                                int wrapIndex = wrapString(source, index, de.isCondition());
                                int subStart = index;
                                if (de.isCondition()) {
                                    int logicIndex = wrapString(source, index, false);
                                    String ss = source.substring(index, logicIndex).trim();
                                    String pre = null;
                                    String append = "";
                                    String name = "";
                                    if (ss.equalsIgnoreCase("and")) {
                                        pre = "<and if=";
                                        subStart = logicIndex + 1;
                                    } else if (ss.equalsIgnoreCase("or")) {
                                        pre = "<or if=";
                                        subStart = logicIndex + 1;
                                    } else {
                                        pre = "<and if=";
                                    }
                                    if (de.isEmptyConditionParam()) {
                                        name = getFirstParamName(source.substring(index, wrapIndex));
                                        if (isConditionNull(de.getSource())) {
                                            append = "?";
                                        } else if (isConditionNullOrEmpty(de.getSource())) {
                                            if (isInCondition(source.substring(index, wrapIndex))) {
                                                append = " && " + name + "?size gt 0";
                                            } else {
                                                append = " && " + name + "?length gt 0";
                                            }
                                        }
                                        append = append + " name='" + name + "'";
                                        de.setSource(pre + name + de.getSource() + append);
                                    } else {
                                        name = de.getSource().replaceAll("\\?", "");
                                        if (isConditionNull(de.getSource())) {
                                            append = "??";
                                        } else if (isConditionNullOrEmpty(de.getSource())) {
                                            if (isInCondition(source.substring(index, wrapIndex))) {
                                                append = "?? && " + name + "?size gt 0";
                                            } else {
                                                append = "?? && " + name + "?length gt 0";
                                            }
                                        }
                                        de.setSource(pre + name + append);
                                    }
                                    Parser parser = new Parser(this, de);
                                    parser.parse(source.substring(subStart, wrapIndex));
                                } else {
                                    de.addChild(new StringElement(source.substring(index, wrapIndex)));
                                }
                                index = wrapIndex;
                                continue;
                            } else if (de.isReplaceable()) {
                                int logicIndex = wrapString(source, index, false);
                                index = logicIndex;
                                continue;
                            }
                        }
                    }
                    element.append(c);
                }
            }
            index++;
        }
    }

    private boolean isInCondition(String value) {
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (c == 'i' || c == 'I') {
                if (value.length() == i + 1) {
                    return false;
                }
                char c2 = value.charAt(i + 1);
                return c2 == 'n' || c2 == 'N';
            }
        }
        return false;
    }

    // TODO 后续加入多个参数的获取，主要是为了between :param1 and :param2
    private String getFirstParamName(String value, boolean autoEnd) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (c == namedParamStart) {
                sb.append(c);
            } else if (sb.length() > 0) {
                if (isNamedParamEnd(c)) {
                    sb.deleteCharAt(0);
                    return sb.toString();
                }
                sb.append(c);
            }
        }
        if (sb.length() > 0 && !autoEnd) {
            throw new TplException("格式错误，未找到匹配的结束符号");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    private String getFirstParamName(String value) {
        return getFirstParamName(value, true);
    }

    private boolean isNamedParamEnd(char c) {
        for (int i = 0; i < namedParamEnds.length; i++) {
            if (namedParamEnds[i] == c) {
                return true;
            }
        }
        return false;
    }

    private int wrapString(String value, int start) {
        return wrapString(value, start, false);
    }

    private int wrapString(String value, int start, boolean onlyNewLine) {
        char c = 0;
        int index = start;
        boolean notWhitespace = false;
        while (index < value.length()) {
            c = value.charAt(index);
            if (!notWhitespace && !Character.isWhitespace(c)) {
                notWhitespace = true;
            }
            if (c == directiveStart[0] && value.length() < index + 1) {
                char c2 = value.charAt(index + 1);
                if (c2 == directiveStart[1]) {
                    return index;
                }
            }
            if (onlyNewLine) {
                if (notWhitespace && c == Chars.NEW_LINEZ_CHAR) {
                    return index;
                }
            } else {
                if (notWhitespace && (c == Chars.SPACE_CHAR || c == Chars.NEW_LINEZ_CHAR)) {
                    return index;
                }
            }

            index++;
        }
        if (index == start) {
            return -1;
        }
        return index;
    }

    /**
     * Gets the null type.
     *
     * @param value the value
     * @return the null type
     */
    public NullType getNullType(String value) {
        if (value.length() == 0) {
            return null;
        }
        if (value.charAt(0) == '?') {
            if (value.length() == 1) {
                return NullType.NULL;
            } else {
                if (value.charAt(value.length() - 1) == '?') {
                    return NullType.EMPTY;
                } else {
                    return NullType.NULL;
                }
            }
        } else {
            if (value.charAt(value.length() - 1) == '?') {
                if (value.length() - 2 >= 0 && value.charAt(value.length() - 2) == '?') {
                    return NullType.EMPTY;
                } else {
                    return NullType.NULL;
                }
            }
        }
        return null;
    }

    /**
     * Checks if is condition.
     *
     * @param value the value
     * @return true, if is condition
     */
    public boolean isCondition(String value) {
        return getNullType(value) != null;
    }

    /**
     * Checks if is condition null.
     *
     * @param value the value
     * @return true, if is null
     */
    public boolean isConditionNull(String value) {
        NullType type = getNullType(value);
        return type != null && type == NullType.NULL;
    }

    /**
     * Checks if is condition null or string.
     *
     * @param value the value
     * @return true, if is null or empty string
     */
    public boolean isConditionNullOrEmpty(String value) {
        NullType type = getNullType(value);
        return type != null && type == NullType.EMPTY;
    }

    private Directive parseDirective(String value, int start) {
        char c = 0;
        char c2 = 0;
        int index = start;
        Directive directive = new Directive();
        directive.start = start;
        while (index < value.length()) {
            c = value.charAt(index);
            if (index + 1 < value.length()) {
                c2 = value.charAt(index + 1);
            } else {
                c2 = 0;
            }
            if (isDirectiveStart(c, c2)) {
                directive.start = index;
            } else if (isDirectiveEnd(c, c2)) {
                // 因为结束是两位符号
                directive.end = index + directiveEnd.length - 1;
                break;
            }
            index++;
        }

        if (directive.start != -1 && directive.end != -1) {
            directive.setSource(value.substring(directive.start, directive.end + 1), this);
            //            directive.source = value.substring(directive.start, directive.end + 1);
            //            directive.content = directiveContent(directive.source, directiveStart.length, directiveEnd.length);
            //            directive.name = directiveName(directive.content);
            //            System.out.println(directive);
            return directive;
        } else {
            throw new TplException("解析指令出错， 没有找到指令结束符号" + Arrays.toString(directiveEnd));
        }
    }

    private Directive getEndDirective(String value, DirectiveElement directiveElement) {
        char c = 0;
        char c2 = 0;
        int index = directiveElement.getStart();
        Directive directive = new Directive();
        directive.start = directiveElement.getStart();
        while (index < value.length()) {
            c = value.charAt(index);
            if (index + 1 < value.length()) {
                c2 = value.charAt(index + 1);
            } else {
                c2 = 0;
            }
            if (isDirectiveStart(c, c2)) {
                directive.start = index;
            } else if (isDirectiveEnd(c, c2)) {
                // 当前是结束符开始的第一个字符
                directive.end = index + directiveEnd.length - 1;
                if (directive.start != -1 && directive.end != -1) {
                    // start + 1 去掉<符号
                    directive.setSource(value.substring(directive.start, directive.end + 1), this);
                    if (directive.content.charAt(0) == endDirecitve
                            && directive.name.equals(directiveElement.getName())) {
                        directive.end = index + directiveEnd.length - 1;
                        return directive;
                    }
                }
            }
            index++;
        }
        throw new TplException(Strings.format("没有找到标签[{0}]对应的结束标签", directiveElement.getSource()));
    }

    private void addElement(AbstractElement element) {
        if (parentElement != null) {
            parentElement.addChild(element);
        } else {
            elements.add(element);
        }
    }

    private boolean isDirectiveStart(char c, char c2) {
        return directiveStart[0] == c && directiveStart[1] == c2;
    }

    private boolean isDirectiveEnd(char c, char c2) {
        return directiveEnd[0] == c && directiveEnd[1] == c2;
    }

    /**
     * Directive content.
     *
     * @param directiveSouce the directive souce
     * @return the string
     */
    public String directiveContent(String directiveSouce) {
        return directiveSouce.substring(directiveStart.length, directiveSouce.length() - directiveStart.length);
    }

    /**
     * Directive name and attr.
     *
     * @param directiveContent the directive content
     * @return the string
     */
    public String directiveNameAndAttr(String directiveContent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < directiveContent.length(); i++) {
            char c = directiveContent.charAt(i);
            if (i < 2) {
                if (c != startDirecitve && c != endDirecitve && c != '@') {
                    sb.append(c);
                }
            } else if (i == directiveContent.length() - 1) {
                if (c != endDirecitve) {
                    sb.append(c);
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * Directive name.
     *
     * @param directiveContent the directive content
     * @return the string
     */
    public String directiveName(String directiveContent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < directiveContent.length(); i++) {
            char c = directiveContent.charAt(i);
            if (c == Chars.SPACE_CHAR || c == Chars.NEW_LINEZ_CHAR) {
                return sb.toString();
            } else if (c != '<' && c != '>') {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * Checks if is wrapper.
     *
     * @param directiveContent the directive content
     * @return true, if is wrapper
     */
    public boolean isWrapper(String directiveContent) {
        if (directiveContent.length() == 0) {
            return false;
        }
        boolean b = directiveContent.charAt(0) == startDirecitve;
        if (b) {
            return directiveContent.length() > 1 && directiveContent.charAt(1) == startDirecitve;
        }
        b = isEmptyConditionParam(directiveContent);
        return b ? b : Character.isLetter(directiveContent.charAt(0));
    }

    /**
     * Checks if is empty condition param.
     *
     * @param directiveContent the directive content
     * @return true, if is empty condition param
     */
    public boolean isEmptyConditionParam(String directiveContent) {
        String v = directiveContent.trim();
        if (v.length() == 1) {
            return v.charAt(0) == '?';
        } else if (v.length() == 2) {
            return v.charAt(0) == '?' && v.charAt(1) == '?';
        }
        return false;
    }

    /**
     * Checks if is replaceable.
     *
     * @param directiveContent the directive content
     * @return true, if is replaceable
     */
    public boolean isReplaceable(String directiveContent) {
        return directiveContent.charAt(0) == '$';
    }

    /**
     * Checks if is enclosed.
     *
     * @param directiveContent the directive content
     * @return true, if is enclosed
     */
    public boolean isEnclosed(String directiveContent) {
        return directiveContent.charAt(directiveContent.length() - 1) == endDirecitve;
    }

    /**
     * Directive name.
     *
     * @param directiveSouce the directive souce
     * @return the string
     */
    public String directiveNameFromSource(String directiveSouce) {
        return directiveName(
                directiveSouce.substring(directiveStart.length, directiveSouce.length() - directiveEnd.length));
    }

    private static class Directive {

        Directive() {
        }

        int start = -1;

        int end = -1;

        String name;

        String source;

        String content;

        public void setSource(String source, Parser parser) {
            this.source = source;
            content = parser.directiveContent(source);
            name = parser.directiveName(content);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return "Directive [start=" + start + ", end=" + end + ", source=" + source + ", content=" + content + "]";
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Parser [source=" + source + "]";
    }

    /**
     * 返回elements.
     *
     * @return elements
     */
    public List<AbstractElement> getElements() {
        return elements;
    }
}
