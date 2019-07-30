
package cn.featherfly.juorm.tpl;

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
}
