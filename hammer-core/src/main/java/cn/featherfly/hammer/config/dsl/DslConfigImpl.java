
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-10-23 18:48:23
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.config.dsl;

/**
 * DslConfigImpl.
 *
 * @author zhongj
 */
public class DslConfigImpl implements DslConfig {

    private final DslQueryConfig queryConfig;
    private final DeleteConfig deleteConfig;
    private final UpdateConfig updateConfig;

    /**
     * Instantiates a new dsl config impl.
     */
    public DslConfigImpl() {
        queryConfig = new DslQueryConfigImpl();
        deleteConfig = new DeleteConfigImpl();
        updateConfig = new UpdateConfigImpl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DslQueryConfig getQueryConfig() {
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
