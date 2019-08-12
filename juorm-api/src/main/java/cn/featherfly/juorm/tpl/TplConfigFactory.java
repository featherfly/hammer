
package cn.featherfly.juorm.tpl;

import java.util.Collection;

/**
 * <p>
 * SqlTplConfigFactory
 * </p>
 *
 * @author zhongj
 */
public interface TplConfigFactory {

    String IdSign = "@";

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
}
