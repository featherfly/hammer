
package cn.featherfly.hammer.tpl;

import java.util.Collection;

import cn.featherfly.hammer.config.tpl.TemplateConfig;

/**
 * SqlTplConfigFactory.
 *
 * @author zhongj
 */
public interface TplConfigFactory {

    /** The file sign. */
    String FILE_SIGN = "#";

    /** The count suffix. */
    String COUNT_SUFFIX = ".count";

    /**
     * Gets the template config.
     *
     * @return the template config
     */
    TemplateConfig getTemplateConfig();

    /**
     * get all configs.
     *
     * @return TplExecuteConfig Collection
     */
    Collection<TplExecuteConfigs> getAllConfigs();

    /**
     * get configs.
     *
     * @param namespace the namespace
     * @return TplExecuteConfig
     */
    TplExecuteConfigs getConfigs(String namespace);

    /**
     * get config.
     *
     * @param executeId executeId
     * @return TplExecuteConfig
     */
    TplExecuteConfig getConfig(String executeId);

    /**
     * get config.
     *
     * @param executeId executeId
     * @return TplExecuteConfig
     */
    TplExecuteConfig getConfig(TplExecuteId executeId);
}
