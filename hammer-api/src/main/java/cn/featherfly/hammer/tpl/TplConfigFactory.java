
package cn.featherfly.hammer.tpl;

import java.util.Collection;

/**
 * SqlTplConfigFactory.
 *
 * @author zhongj
 */
public interface TplConfigFactory {

    //    String ID_SIGN = "@";
    String FILE_SIGN = "#";
    String COUNT_SUFFIX = ".count";

    /**
     * Gets the parser.
     *
     * @return the parser
     */
    TplExecuteIdParser getParser();

    /**
     * get all configs
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
     * get config
     *
     * @param executeId executeId
     * @return TplExecuteConfig
     */
    TplExecuteConfig getConfig(String executeId);

    /**
     * get config
     *
     * @param executeId executeId
     * @return TplExecuteConfig
     */
    TplExecuteConfig getConfig(TplExecuteId executeId);
}
