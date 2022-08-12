
package cn.featherfly.hammer.tpl;

import java.util.Collection;

/**
 * SqlTplConfigFactory.
 *
 * @author zhongj
 */
public interface TplConfigFactory {

    String ID_SIGN = "@";
    String FILE_SIGN = "#";
    String COUNT_SUFFIX = ".count";

    /**
     * getConfigs
     *
     * @return TplExecuteConfig Collection
     */
    Collection<TplExecuteConfigs> getAllConfigs();

    /**
     * getConfigs
     *
     * @param filePath filePath
     * @return TplExecuteConfig
     */
    TplExecuteConfigs getConfigs(String filePath);

    /**
     * getConfigs
     *
     * @param executeId executeId
     * @return TplExecuteConfig
     */
    TplExecuteConfig getConfig(String executeId);

    /**
     * getConfigs
     *
     * @param executeId executeId
     * @return TplExecuteConfig
     */
    TplExecuteConfig getConfig(TplExecuteId executeId);
}
