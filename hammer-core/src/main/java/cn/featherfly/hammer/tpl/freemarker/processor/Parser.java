
package cn.featherfly.hammer.tpl.freemarker.processor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.Strings;
import cn.featherfly.hammer.config.tpl.TemplateConfig;
import cn.featherfly.hammer.tpl.TplException;
import cn.featherfly.hammer.tpl.TplExecuteConfig;
import cn.featherfly.hammer.tpl.TplExecuteConfig.Param;

/**
 * Parser .
 *
 * @author zhongj
 */
public class Parser {

    private static final Pattern WRAP_PARAM_WITH_VALUE_PATTERN = Pattern.compile("(.+/\\*\\$=.*\\*/)(.+)");

    private static final char[] COMMENT_SYMBOL_AFTER_DIRECTIVE_START = new char[] { '+', ' ', '\n' };

    private static final String SQL_DELIM = " \n\t";

    private char[] directiveStart = new char[] { '/', '*' };

    private char[] directiveEnd = new char[] { '*', '/' };

    private char startDirecitve = '<';

    private char endDirecitve = '>';

    private char namedParamStart = ':';

    private char fuzzyQueryChar = '%';

    private char[] sqlStringWarpChars = new char[] { '\'', '\"' };

    private char[] namedParamEnds = { directiveEnd[0], ' ', '\n', fuzzyQueryChar };

    private String source;

    private Pattern hasReplaceableTargetPattern = Pattern.compile("\\$=%?" + namedParamStart + "\\w+%?");

    private TemplateConfig templateConfig;

    /**
     * The Enum NullType.
     */
    public enum NullType {
        /** The null. */
        NULL,
        /** The empty. */
        EMPTY
    }

    //    Parser parent;

    //    List<Parser> parsers = new ArrayList<>();

    //    private List<String> paramNames;

    private List<Param> params;

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
        this.parentElement = parentElement;
        directiveStart = parent.directiveStart;
        directiveEnd = parent.directiveEnd;
        startDirecitve = parent.startDirecitve;
        endDirecitve = parent.endDirecitve;
        params = parent.params;
        templateConfig = parent.templateConfig;
    }

    /**
     * Instantiates a new parser.
     */
    public Parser() {
    }

    /**
     * Instantiates a new parser.
     *
     * @param templateConfig the template config
     */
    public Parser(TemplateConfig templateConfig) {
        this.templateConfig = templateConfig;
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
     * @param source           the source
     * @param tplExecuteConfig the consumer
     * @return the string
     */
    public String parse(String source, TplExecuteConfig tplExecuteConfig) {
        //        List<String> paramNames = new ArrayList<>();
        params = new ArrayList<>();
        String content = parse(source, tplExecuteConfig, params);
        //        tplExecuteConfig.setParamNames(paramNames.toArray(new String[paramNames.size()]));
        tplExecuteConfig.setParams(params.toArray(new Param[params.size()]));
        return content;
    }

    private String parse(String source, TplExecuteConfig tplExecuteConfig, List<Param> params) {
        char c = 0;
        char c2 = 0;
        elements.clear();
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
                // FIXME 当多个/*< .. >*/ 自关闭标签连续时，只有第一个被转换出后，后续的丢失
                // 问题是这!de.isEnclosed()这里一直是true
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
                    parser.parse(subSource, tplExecuteConfig, params);
                    index = directive.end;
                    element = null;
                }
            } else {
                if (isDirectiveStart(c, c2)) {
                    Directive directive = parseDirective(source, index);
                    if (directive.comment) {
                        element = new CommentElement(directive.content, element, this);
                    } else {
                        element = new DirectiveElement(directive.content,
                                templateConfig.isPrecompileNamedParamPlaceholder(), element, this);
                    }
                    addElement(element);
                    element.setEnd(directive.end);
                    element.setStart(directive.start);
                    index = directive.end;
                } else {
                    if (!(element instanceof StringElement || element instanceof CommentElement)) {
                        DirectiveElement de = null;
                        if (element != null) {
                            de = (DirectiveElement) element;
                        }
                        element = new StringElement(templateConfig.isPrecompileNamedParamPlaceholder(), element, this);
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
                                        String paramContent = source.substring(index, wrapIndex);
                                        StringPart namePart = getFirstParamName(paramContent);
                                        name = namePart.getValue();
                                        if (isConditionNull(de.getSource())) {
                                            append = "?";
                                        } else if (isConditionNullOrEmpty(de.getSource())) {
                                            if (isInCondition(source.substring(index, wrapIndex))) {
                                                append = " && " + name + "?size gt 0";
                                            } else {
                                                append = " && " + name + "?length gt 0";
                                            }
                                        }

                                        boolean endWith = paramContent
                                                .charAt(namePart.getStart() - 2) == fuzzyQueryChar;
                                        boolean startWith = paramContent.charAt(namePart.getEnd()) == fuzzyQueryChar;
                                        append = appendTransverter(startWith, endWith, append);

                                        //                                        de.setSource(pre + name + de.getSource() + append);
                                        de.setSource(pre + name + de.getSource() + append + " name=\"" + name + "\"");

                                        // IMPLSOON 处理 in
                                        //                                        params.add(new Param(name));
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

                                        String paramContent = source.substring(index, wrapIndex);
                                        Matcher matcher = WRAP_PARAM_WITH_VALUE_PATTERN.matcher(paramContent);
                                        if (matcher.matches()) {
                                            paramContent = matcher.group(1);
                                        }
                                        Tuple2<Boolean, Boolean> isFuzzy = isFuzzy(paramContent);
                                        append = appendTransverter(isFuzzy.get0(), isFuzzy.get1(), append);

                                        //                                        String fuzzyStr = paramContent.chars()
                                        //                                                .filter(i -> i == fuzzyQueryChar || i == namedParamStart || i == '?')
                                        //                                                .collect(StringBuilder::new, StringBuilder::appendCodePoint,
                                        //                                                        StringBuilder::append)
                                        //                                                .toString();
                                        //                                        boolean endWith = fuzzyStr.indexOf(fuzzyQueryChar) == 0;
                                        //                                        boolean startWith = fuzzyStr.lastIndexOf(fuzzyQueryChar) == fuzzyStr.length()
                                        //                                                - 1;
                                        //                                        append = appendTransverter(startWith, endWith, append);
                                        //                                        de.setSource(pre + name + append);
                                        de.setSource(pre + name + append + " name=\"" + name + "\"");

                                        //                                        params.add(new Param(name));
                                    }
                                    Parser parser = new Parser(this, de);
                                    parser.parse(source.substring(subStart, wrapIndex), tplExecuteConfig, params);
                                } else {
                                    de.addChild(new StringElement(source.substring(index, wrapIndex),
                                            templateConfig.isPrecompileNamedParamPlaceholder(), element, this));
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
        StringBuilder result = new StringBuilder();
        for (AbstractElement abstractElement : elements) {
            result.append(abstractElement.getValue());
        }

        return result.toString();
    }

    private Tuple2<Boolean, Boolean> isFuzzy(CharSequence paramContent) {
        AtomicInteger preSqlStringChar = new AtomicInteger(0);
        String fuzzyStr = paramContent.chars().filter(i -> {
            char c = (char) i;
            if (preSqlStringChar.byteValue() == 0) {
                if (isSqlStringWarpChar(c)) {
                    preSqlStringChar.set(c);
                    return true;
                } else {
                    return c == fuzzyQueryChar || c == namedParamStart || c == '?';
                }
            } else if (preSqlStringChar.byteValue() == c) {
                preSqlStringChar.set(0); // 字符串结束
            }
            return true;
        }).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        boolean endWith = fuzzyStr.indexOf(fuzzyQueryChar) == 0;
        boolean startWith = fuzzyStr.lastIndexOf(fuzzyQueryChar) == fuzzyStr.length() - 1;
        return Tuples.of(startWith, endWith);
    }

    private String appendTransverter(boolean startWith, boolean endWith, String append) {
        if (startWith && endWith) {
            append = append + " transverter='CO'";
        } else if (startWith) {
            append = append + " transverter='SW'";
        } else if (endWith) {
            append = append + " transverter='EW'";
        }
        return append;
    }

    private boolean isInCondition(CharSequence value) {
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
    private StringPart getFirstParamName(CharSequence value, boolean autoEnd) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = 0;
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            end = i;
            if (c == namedParamStart) {
                start = i;
                sb.append(c);
            } else if (sb.length() > 0) {
                if (isNamedParamEnd(c)) {
                    sb.deleteCharAt(0);
                    start++;
                    return new StringPart(start, end, sb.toString());
                    //                    return sb.toString();
                }
                sb.append(c);
            }
        }
        if (sb.length() > 0 && !autoEnd) {
            throw new TplException("格式错误，未找到匹配的结束符号");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(0);
            start++;
        }
        return new StringPart(start, end, sb.toString());
        //        return sb.toString();
    }

    private StringPart getFirstParamName(CharSequence value) {
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

    private int wrapString(CharSequence value, int start) {
        return wrapString(value, start, false);
    }

    private int wrapString(CharSequence value, int start, boolean onlyNewLine) {
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
                if (notWhitespace && c == Chars.NEW_LINE_CHAR) {
                    return index;
                }
            } else {
                if (notWhitespace && (c == Chars.SPACE_CHAR || c == Chars.NEW_LINE_CHAR)) {
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
    public NullType getNullType(CharSequence value) {
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
    public boolean isCondition(CharSequence value) {
        return getNullType(value) != null;
    }

    /**
     * Checks if is condition null.
     *
     * @param value the value
     * @return true, if is null
     */
    public boolean isConditionNull(CharSequence value) {
        NullType type = getNullType(value);
        return type != null && type == NullType.NULL;
    }

    /**
     * Checks if is condition null or string.
     *
     * @param value the value
     * @return true, if is null or empty string
     */
    public boolean isConditionNullOrEmpty(CharSequence value) {
        NullType type = getNullType(value);
        return type != null && type == NullType.EMPTY;
    }

    private Directive parseDirective(String value, int start) {
        char c = 0;
        char c2 = 0;
        char c3 = 0;
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
                if (index + 2 < value.length()) {
                    c3 = value.charAt(index + 2);
                } else {
                    c3 = 0;
                }
                if (isComment(c3)) {
                    directive.comment = true;
                }
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
        //        char c3 = 0;
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
                //                if (index + 2 < value.length()) {
                //                    c3 = value.charAt(index + 2);
                //                } else {
                //                    c3 = 0;
                //                }
                //                if (isComment(c3)) {
                //                    directive.comment = true;
                //                }
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

    //    private boolean isComment(char c, char c2, char c3) {
    //        if (isDirectiveStart(c, c2)) {
    //            return isComment(c3);
    //        }
    //        return false;
    //    }

    private boolean isComment(char c3) {
        return COMMENT_SYMBOL_AFTER_DIRECTIVE_START[0] == c3 || COMMENT_SYMBOL_AFTER_DIRECTIVE_START[1] == c3
                || COMMENT_SYMBOL_AFTER_DIRECTIVE_START[2] == c3;
    }

    private boolean isDirectiveEnd(char c, char c2) {
        return directiveEnd[0] == c && directiveEnd[1] == c2;
    }

    String scanParamName(CharSequence content) {
        return scanParamName(content, false);
    }

    String scanParamName(CharSequence content, boolean inParam) {
        if (Lang.isEmpty(content)) {
            return content.toString();
        } else if (StringUtils.isBlank(content)) {
            if (templateConfig.isPrecompileMinimize()) {
                return Chars.SPACE;
            } else {
                return content.toString();
            }
        }
        StringBuilder sb = new StringBuilder();
        StringTokenizer tokenizer = new StringTokenizer(content.toString(), SQL_DELIM,
                !templateConfig.isPrecompileMinimize());
        String preToken = null;

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (templateConfig.isPrecompileMinimize()) {
                sb.append(" ");
            }
            if (token.charAt(0) == namedParamStart) {
                //                if (templateConfig.isPrecompileInParamPlaceholder() && "in".equalsIgnoreCase(preToken)) {

                if (inParam || "in".equalsIgnoreCase(preToken)) {
                    // id in :ids -> id in ${_ids}
                    sb.append("${").append(templateConfig.getInParamPlaceholderName().apply(token.substring(1)))
                            .append("}");
                    params.add(new Param(token.substring(1), true));
                    continue;
                }

                if (!templateConfig.isPrecompileNamedParamPlaceholder()) {
                    params.add(new Param(token.substring(1)));
                    // id = :id -> id = ?
                    sb.append("?");
                    continue;
                }
            }
            sb.append(token);
            if (Strings.isNotBlank(token)) {
                preToken = token;
            }
        }
        if (templateConfig.isPrecompileMinimize()) {
            char c = content.charAt(content.length() - 1);
            if (c == ' ' || c == '\n' || c == '\t' || c == '\r') {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    /**
     * Directive content.
     *
     * @param directiveSouce the directive souce
     * @return the string
     */
    public CharSequence directiveContent(CharSequence directiveSouce) {
        return directiveSouce.subSequence(directiveStart.length, directiveSouce.length() - directiveStart.length);
        //        return directiveSouce.substring(directiveStart.length, directiveSouce.length() - directiveStart.length);
    }

    /**
     * Directive name and attr.
     *
     * @param directiveContent the directive content
     * @return the string
     */
    public CharSequence directiveNameAndAttr(CharSequence directiveContent) {
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
    public String directiveName(CharSequence directiveContent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < directiveContent.length(); i++) {
            char c = directiveContent.charAt(i);
            if (c == Chars.SPACE_CHAR || c == Chars.NEW_LINE_CHAR) {
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
    public boolean isWrapper(CharSequence directiveContent) {
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
    public boolean isEmptyConditionParam(CharSequence directiveContent) {
        String v = directiveContent.toString().trim();
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
    public boolean isReplaceable(CharSequence directiveContent) {
        return directiveContent.length() >= 2 && directiveContent.charAt(0) == '$' && directiveContent.charAt(1) == '=';
    }

    /**
     * Checks for replaceable target.
     *
     * @param directiveContent the directive content
     * @return true, if is replaceable
     */
    public boolean hasReplaceableTarget(CharSequence directiveContent) {
        return isReplaceable(directiveContent) && directiveContent.length() > 2
                && hasReplaceableTargetPattern.matcher(directiveContent).matches();
    }

    /**
     * Checks if is enclosed.
     *
     * @param directiveContent the directive content
     * @return true, if is enclosed
     */
    public boolean isEnclosed(CharSequence directiveContent) {
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

        boolean comment;

        String name;

        CharSequence source;

        CharSequence content;

        public void setSource(CharSequence source, Parser parser) {
            this.source = source;
            if (comment) {
                content = source;
            } else {
                content = parser.directiveContent(source);
                name = parser.directiveName(content);
            }
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

    /**
     * 返回directiveStart.
     *
     * @return directiveStart
     */
    public char[] getDirectiveStart() {
        return directiveStart;
    }

    /**
     * 设置directiveStart.
     *
     * @param directiveStart directiveStart
     */
    public void setDirectiveStart(char[] directiveStart) {
        this.directiveStart = directiveStart;
    }

    /**
     * 返回directiveEnd.
     *
     * @return directiveEnd
     */
    public char[] getDirectiveEnd() {
        return directiveEnd;
    }

    /**
     * 设置directiveEnd.
     *
     * @param directiveEnd directiveEnd
     */
    public void setDirectiveEnd(char[] directiveEnd) {
        this.directiveEnd = directiveEnd;
    }

    /**
     * 返回startDirecitve.
     *
     * @return startDirecitve
     */
    public char getStartDirecitve() {
        return startDirecitve;
    }

    /**
     * 设置startDirecitve.
     *
     * @param startDirecitve startDirecitve
     */
    public void setStartDirecitve(char startDirecitve) {
        this.startDirecitve = startDirecitve;
    }

    /**
     * 返回endDirecitve.
     *
     * @return endDirecitve
     */
    public char getEndDirecitve() {
        return endDirecitve;
    }

    /**
     * 设置endDirecitve.
     *
     * @param endDirecitve endDirecitve
     */
    public void setEndDirecitve(char endDirecitve) {
        this.endDirecitve = endDirecitve;
    }

    /**
     * 返回namedParamStart.
     *
     * @return namedParamStart
     */
    public char getNamedParamStart() {
        return namedParamStart;
    }

    /**
     * 设置namedParamStart.
     *
     * @param namedParamStart namedParamStart
     */
    public void setNamedParamStart(char namedParamStart) {
        this.namedParamStart = namedParamStart;
        hasReplaceableTargetPattern = Pattern.compile("\\$=%?" + namedParamStart + "\\w+%?");
    }

    /**
     * 返回fuzzyQueryChar.
     *
     * @return fuzzyQueryChar
     */
    public char getFuzzyQueryChar() {
        return fuzzyQueryChar;
    }

    /**
     * 设置fuzzyQueryChar.
     *
     * @param fuzzyQueryChar fuzzyQueryChar
     */
    public void setFuzzyQueryChar(char fuzzyQueryChar) {
        this.fuzzyQueryChar = fuzzyQueryChar;
    }

    /**
     * 返回namedParamEnds.
     *
     * @return namedParamEnds
     */
    public char[] getNamedParamEnds() {
        return namedParamEnds;
    }

    /**
     * 设置namedParamEnds.
     *
     * @param namedParamEnds namedParamEnds
     */
    public void setNamedParamEnds(char[] namedParamEnds) {
        this.namedParamEnds = namedParamEnds;
    }

    /**
     * get sqlStringWarpChars value.
     *
     * @return sqlStringWarpChars
     */
    public char[] getSqlStringWarpChars() {
        return sqlStringWarpChars;
    }

    /**
     * set sqlStringWarpChars value.
     *
     * @param sqlStringWarpChars sqlStringWarpChars
     */
    public void setSqlStringWarpChars(char[] sqlStringWarpChars) {
        this.sqlStringWarpChars = sqlStringWarpChars;
    }

    /**
     * Checks if is sql string warp char.
     *
     * @param c the c
     * @return true, if is sql string warp char
     */
    public boolean isSqlStringWarpChar(char c) {
        for (char sqlStringWrapChar : sqlStringWarpChars) {
            if (sqlStringWrapChar == c) {
                return true;
            }
        }
        return false;
    }
}
