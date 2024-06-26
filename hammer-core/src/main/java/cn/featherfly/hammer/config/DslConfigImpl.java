
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-10-23 18:48:23
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.config;

import cn.featherfly.hammer.config.dsl.DeleteConfig;
import cn.featherfly.hammer.config.dsl.DslConfig;
import cn.featherfly.hammer.config.dsl.QueryConfig;
import cn.featherfly.hammer.config.dsl.UpdateConfig;

/**
 * DslConfigImpl.
 *
 * @author zhongj
 */
public class DslConfigImpl implements DslConfig {

    private QueryConfig queryConfig = new QueryConfigImpl();
    private DeleteConfig deleteConfig = new DeleteConfigImpl();
    private UpdateConfig updateConfig = new UpdateConfigImpl();

    /**
     * Instantiates a new dsl config impl.
     */
    public DslConfigImpl() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConfig getQueryConfig() {
        return queryConfig;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UpdateConfig getUpdateConfig() {
        return updateConfig;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DeleteConfig getDeleteConfig() {
        return deleteConfig;
    }
}
