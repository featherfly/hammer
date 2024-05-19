
package cn.featherfly.hammer.tpl;

import java.util.HashMap;
import java.util.Map;

import cn.featherfly.hammer.HammerException;

/**
 * <p>
 * TemplateDirectives
 * </p>
 *
 * @author zhongj
 */
public class TemplateDirectives<D> {

    public static final String WHERE_DIRECTIVE_KEY = "where";
    public static final String AND_DIRECTIVE_KEY = "and";
    public static final String OR_DIRECTIVE_KEY = "or";
    public static final String PROPERTIES_DIRECTIVE_KEY = "prop";
    public static final String TEMPLATE_INCLUDE_DIRECTIVE_KEY = "tpl";
    public static final String WRAP_DIRECTIVE_KEY = "wrap";
    public static final String STRING_REPLACE_DIRECTIVE_KEY = "str";

    private static final String[] REQUIRED_KEYS = { WHERE_DIRECTIVE_KEY, AND_DIRECTIVE_KEY, OR_DIRECTIVE_KEY,
        PROPERTIES_DIRECTIVE_KEY, TEMPLATE_INCLUDE_DIRECTIVE_KEY, WRAP_DIRECTIVE_KEY };

    protected Map<String, D> directiveMap = new HashMap<>();

    public void addDirective(String key, D directive) {
        directiveMap.put(key, directive);
    }

    public Map<String, D> getDirectiveMap() {
        return directiveMap;
    }

    public Map<String, D> getDirectiveMapAfterCheck() {
        for (String key : REQUIRED_KEYS) {
            if (!directiveMap.containsKey(key)) {
                throw new HammerException("directive with key " + key + " is null");
            }
        }
        return directiveMap;
    }

    public void addWhereDirective(D directive) {
        directiveMap.put(WHERE_DIRECTIVE_KEY, directive);
    }

    public void addAndDirective(D directive) {
        directiveMap.put(AND_DIRECTIVE_KEY, directive);
    }

    public void addOrDirective(D directive) {
        directiveMap.put(OR_DIRECTIVE_KEY, directive);
    }

    public void addPropertiesDirective(D directive) {
        directiveMap.put(PROPERTIES_DIRECTIVE_KEY, directive);
    }

    public void addTemplateIncludeDirective(D directive) {
        directiveMap.put(TEMPLATE_INCLUDE_DIRECTIVE_KEY, directive);
    }

    public void addWrapDirective(D directive) {
        directiveMap.put(WRAP_DIRECTIVE_KEY, directive);
    }

    public void addStringReplaceDirective(D directive) {
        directiveMap.put(STRING_REPLACE_DIRECTIVE_KEY, directive);
    }

}
