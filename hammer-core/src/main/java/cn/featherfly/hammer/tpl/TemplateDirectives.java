
package cn.featherfly.hammer.tpl;

import java.util.HashMap;
import java.util.Map;

import cn.featherfly.hammer.HammerException;

/**
 * TemplateDirectives.
 *
 * @author zhongj
 * @param <D> the generic type
 */
public class TemplateDirectives<D> {

    /** The Constant WHERE_DIRECTIVE_KEY. */
    public static final String WHERE_DIRECTIVE_KEY = "where";

    /** The Constant AND_DIRECTIVE_KEY. */
    public static final String AND_DIRECTIVE_KEY = "and";

    /** The Constant OR_DIRECTIVE_KEY. */
    public static final String OR_DIRECTIVE_KEY = "or";

    /** The Constant PROPERTIES_DIRECTIVE_KEY. */
    public static final String PROPERTIES_DIRECTIVE_KEY = "prop";

    /** The Constant TEMPLATE_INCLUDE_DIRECTIVE_KEY. */
    public static final String TEMPLATE_INCLUDE_DIRECTIVE_KEY = "tpl";

    /** The Constant WRAP_DIRECTIVE_KEY. */
    public static final String WRAP_DIRECTIVE_KEY = "wrap";

    /** The Constant STRING_REPLACE_DIRECTIVE_KEY. */
    public static final String STRING_REPLACE_DIRECTIVE_KEY = "str";

    private static final String[] SHARED_REQUIRED_KEYS = { TEMPLATE_INCLUDE_DIRECTIVE_KEY, WRAP_DIRECTIVE_KEY,
        STRING_REPLACE_DIRECTIVE_KEY };

    private static final String[] REQUIRED_KEYS = { WHERE_DIRECTIVE_KEY, AND_DIRECTIVE_KEY, OR_DIRECTIVE_KEY,
        PROPERTIES_DIRECTIVE_KEY };

    /** The directive map. */
    protected Map<String, D> directiveMap = new HashMap<>();

    /**
     * Adds the directive.
     *
     * @param key the key
     * @param directive the directive
     */
    public void addDirective(String key, D directive) {
        directiveMap.put(key, directive);
    }

    /**
     * Gets the directive map.
     *
     * @return the directive map
     */
    public Map<String, D> getDirectiveMap() {
        return directiveMap;
    }

    /**
     * Gets the directive map after check.
     *
     * @param shared the shared
     * @return the directive map after check
     */
    public Map<String, D> getDirectiveMapAfterCheck(boolean shared) {
        for (String key : shared ? SHARED_REQUIRED_KEYS : REQUIRED_KEYS) {
            if (!directiveMap.containsKey(key)) {
                throw new HammerException("directive with key " + key + " is null");
            }
        }
        return directiveMap;
    }

    /**
     * Adds the where directive.
     *
     * @param directive the directive
     */
    public void addWhereDirective(D directive) {
        directiveMap.put(WHERE_DIRECTIVE_KEY, directive);
    }

    /**
     * Adds the and directive.
     *
     * @param directive the directive
     */
    public void addAndDirective(D directive) {
        directiveMap.put(AND_DIRECTIVE_KEY, directive);
    }

    /**
     * Adds the or directive.
     *
     * @param directive the directive
     */
    public void addOrDirective(D directive) {
        directiveMap.put(OR_DIRECTIVE_KEY, directive);
    }

    /**
     * Adds the properties directive.
     *
     * @param directive the directive
     */
    public void addPropertiesDirective(D directive) {
        directiveMap.put(PROPERTIES_DIRECTIVE_KEY, directive);
    }

    /**
     * Adds the template include directive.
     *
     * @param directive the directive
     */
    public void addTemplateIncludeDirective(D directive) {
        directiveMap.put(TEMPLATE_INCLUDE_DIRECTIVE_KEY, directive);
    }

    /**
     * Adds the wrap directive.
     *
     * @param directive the directive
     */
    public void addWrapDirective(D directive) {
        directiveMap.put(WRAP_DIRECTIVE_KEY, directive);
    }

    /**
     * Adds the string replace directive.
     *
     * @param directive the directive
     */
    public void addStringReplaceDirective(D directive) {
        directiveMap.put(STRING_REPLACE_DIRECTIVE_KEY, directive);
    }

    /**
     * Gets the where directive.
     *
     * @return the where directive
     */
    public D getWhereDirective() {
        return directiveMap.get(WHERE_DIRECTIVE_KEY);
    }

}
