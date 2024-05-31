
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-10 18:27:10
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.tpl;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.common.repository.ExecutionExecutor;
import cn.featherfly.common.repository.mapper.PrefixedBeanMapper1;
import cn.featherfly.common.repository.mapper.TupleMapperBuilder;

/**
 * TemplateTupleMapperBuilder.
 *
 * @author zhongj
 * @param <E1> executor type
 * @param <E2> execution type
 */
public class MapParamsTupleMapperBuilder<E1 extends ExecutionExecutor<E2>, E2> implements TupleMapperBuilder {

    /** The executor. */
    protected final E1 executor;

    /** The execution. */
    protected final E2 execution;

    /** The params. */
    protected final Map<String, Serializable> params;

    /**
     * Instantiates a new template tuple mapper builder.
     *
     * @param executor the executor
     * @param execution the execution
     * @param params the params
     */
    public MapParamsTupleMapperBuilder(E1 executor, E2 execution, Map<String, Serializable> params) {
        super();
        this.executor = executor;
        this.execution = execution;
        this.params = params;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1> PrefixedBeanMapper1<T1> map(String prefix, Class<T1> type) {
        return new PrefixedBeanMapper1Impl<>(executor, execution, params, prefix, type);
    }
}
