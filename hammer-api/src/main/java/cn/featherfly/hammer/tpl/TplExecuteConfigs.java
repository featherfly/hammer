
package cn.featherfly.hammer.tpl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * template execute configs.
 *
 * @author zhongj
 */
public class TplExecuteConfigs extends HashMap<String, Object> {

    private final Set<String> filePaths = new HashSet<>(0);

    private final Set<Class<?>> types = new HashSet<>(0);

    private String namespace;

    /**
     *
     */
    private static final long serialVersionUID = -3757923566368519179L;

    /**
     * Instantiates a new tpl execute configs.
     */
    public TplExecuteConfigs() {
    }

    /**
     * Contains config.
     *
     * @param name the name
     * @return true, if successful
     */
    public boolean containsConfig(String name) {
        return containsKey(name);
    }

    /**
     * Gets the config.
     *
     * @param name the name
     * @return the config
     */
    public TplExecuteConfig getConfig(String name) {
        return (TplExecuteConfig) get(name);
    }

    /**
     * 返回filePath.
     *
     * @return filePath
     */
    public Set<String> getFilePath() {
        return filePaths;
    }

    /**
     * get namespace value.
     *
     * @return namespace
     */
    public String getNamespace() {
        return namespace;
    }

    /**
     * set namespace value.
     *
     * @param namespace namespace
     */
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    /**
     * get types value.
     *
     * @return types
     */
    public Set<Class<?>> getTypes() {
        return types;
    }
}
