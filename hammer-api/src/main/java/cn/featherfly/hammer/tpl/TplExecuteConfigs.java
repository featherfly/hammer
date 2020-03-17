
package cn.featherfly.hammer.tpl;

import java.util.HashMap;

/**
 * <p>
 * Config
 * </p>
 *
 * @author zhongj
 */
public class TplExecuteConfigs extends HashMap<String, Object> {

    private String filePath;

    private String name;

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
     * 返回name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置name
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }
}
