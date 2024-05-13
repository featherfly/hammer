
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2022-05-10 18:29:10
 * @Copyright: 2022 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.tpl;

import java.util.Map;

import com.speedment.common.tuple.Tuple;

import cn.featherfly.common.repository.ExecutionExecutor;

/**
 * The Class AbstractPrefixEntityMapper.
 *
 * @author      zhongj
 * @param  <E1> executor type
 * @param  <E2> execution type
 * @param  <E2> params type
 * @param  <T>  prefixes tuple type
 */
public abstract class AbstractPrefixEntityMapper<E1 extends ExecutionExecutor<E2>, E2, P, T extends Tuple> {

    /** The executor. */
    protected E1 executor;

    /** The execution. */
    protected E2 execution;

    /** The params. */
    protected final P params;

    /** The prefixes. */
    protected final T prefixes;

    /**
     * Instantiates a new abstract prefix entity mapper.
     *
     * @param executor  the executor
     * @param execution the execution
     * @param params    the params
     * @param prefixes  the prefixes
     */
    protected AbstractPrefixEntityMapper(E1 executor, E2 execution, P params, T prefixes) {
        super();
        this.executor = executor;
        this.execution = execution;
        this.params = params;
        this.prefixes = prefixes;
    }

    @SuppressWarnings("unchecked")
    protected Map<String, Object> getParamsMap() {
        return (Map<String, Object>) params;
    }

    protected Object[] getParams() {
        return (Object[]) params;
    }

}