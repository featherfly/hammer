
package cn.featherfly.hammer.tpl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * Config
 * </p>
 *
 * @author zhongj
 */
public class TplExecuteConfigs extends HashMap<String, Object> {

    private String filePath;

    private Set<Class<?>> types = new HashSet<>(0);

    private String namespace;

    /**
     *
     */
    private static final long serialVersionUID = -3757923566368519179L;

    /**
     */
    public TplExecuteConfigs() {
    }

    public TplExecuteConfig getConfig(String sqlId) {
        return (TplExecuteConfig) get(sqlId);
    }

    /**
     * 返回filePath
     *
     * @return filePath
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * 设置filePath
     *
     * @param filePath filePath
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * get namespace value
     *
     * @return namespace
     */
    public String getNamespace() {
        return namespace;
    }

    /**
     * set namespace value
     *
     * @param namespace namespace
     */
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    /**
     * get types value
     *
     * @return types
     */
    public Set<Class<?>> getTypes() {
        return types;
    }

    /**
     * set types value
     *
     * @param types types
     */
    public void setTypes(Set<Class<?>> types) {
        this.types = types;
    }

}
