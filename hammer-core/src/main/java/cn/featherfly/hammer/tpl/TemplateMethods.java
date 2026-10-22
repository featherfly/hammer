
package cn.featherfly.hammer.tpl;

import java.util.HashMap;
import java.util.Map;

import cn.featherfly.common.lang.Lang;
import cn.featherfly.hammer.HammerException;

/**
 * <p>
 * TemplateMethodes
 * </p>
 * .
 *
 * @author zhongj
 * @param <M> the generic type
 */
public class TemplateMethods<M> {

    /** The Constant DEFAULT_PREFIX. */
    public static final String DEFAULT_PREFIX = "tpl";

    /** The Constant WRAP_METHOD_KEY. */
    // public static final String PROPERTIES_METHOD_KEY = "prop";
    public static final String WRAP_METHOD_KEY = "wrap";

    /** The Constant STRING_REPLACE_METHOD_KEY. */
    public static final String STRING_REPLACE_METHOD_KEY = "str";

    private static final String[] SHARED_REQUIRED_KEYS = { WRAP_METHOD_KEY, STRING_REPLACE_METHOD_KEY };

    private static final String[] REQUIRED_KEYS = {};

    /** The method map. */
    protected Map<String, M> methodMap = new HashMap<>();

    private String prefix = DEFAULT_PREFIX;

    /**
     * Instantiates a new template methods.
     */
    public TemplateMethods() {
    }

    /**
     * get prefix.
     *
     * @return prefix
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * set prefix.
     *
     * @param prefix prefix
     */
    public void setPrefix(String prefix) {
        if (Lang.isNotEmpty(prefix)) {
            this.prefix = prefix;
        }
    }

    /**
     * Adds the methode.
     *
     * @param key the key
     * @param method the method
     */
    public void addMethode(String key, M method) {
        methodMap.put(getKey(key), method);
    }

    /**
     * Gets the methode map.
     *
     * @return the methode map
     */
    public Map<String, M> getMethodeMap() {
        return methodMap;
    }

    /**
     * Gets the methode map after check.
     *
     * @param shared the shared
     * @return the methode map after check
     */
    public Map<String, M> getMethodeMapAfterCheck(boolean shared) {
        for (String key : shared ? SHARED_REQUIRED_KEYS : REQUIRED_KEYS) {
            if (!methodMap.containsKey(getKey(key))) {
                throw new HammerException("no method found with key " + key);
            }
        }
        return methodMap;
    }

    /**
     * Adds the wrap methode.
     *
     * @param method the method
     */
    public void addWrapMethode(M method) {
        addMethode(WRAP_METHOD_KEY, method);
    }

    /**
     * Adds the string replace methode.
     *
     * @param method the method
     */
    public void addStringReplaceMethode(M method) {
        addMethode(STRING_REPLACE_METHOD_KEY, method);
    }

    private String getKey(String key) {
        return prefix + "_" + key;
    }
}
