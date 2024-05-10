
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2022-05-10 18:29:10
 * @Copyright: 2022 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.tpl;

import java.util.List;
import java.util.Map;

import com.speedment.common.tuple.Tuple1;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.repository.ExecutionExecutor;
import cn.featherfly.common.repository.mapping.PrefixedBeanMapper1;
import cn.featherfly.common.repository.mapping.PrefixedBeanMapper2;
import cn.featherfly.common.structure.page.PaginationResults;

/**
 * The Class PrefixedBeanMapper1Impl.
 *
 * @author zhongj
 * @param <E1> the generic type
 * @param <E2> the generic type
 * @param <T1> the generic type
 */
public class PrefixedBeanMapper1Impl<E1 extends ExecutionExecutor<E2>, E2, T1>
        extends AbstractPrefixEntityMapper<E1, E2, Object, Tuple1<String>> implements PrefixedBeanMapper1<T1> {

    private final Class<T1> type1;

    /**
     * Instantiates a new tpl prefix entity mapper 1.
     *
     * @param executor  the executor
     * @param execution the execution
     * @param params    the params
     * @param type1     the type 1
     */
    public PrefixedBeanMapper1Impl(E1 executor, E2 execution, Map<String, Object> params, Class<T1> type1) {
        this(executor, execution, params, "", type1);
    }

    /**
     * Instantiates a new tpl prefix entity mapper 1.
     *
     * @param executor  the executor
     * @param execution the execution
     * @param params    the params
     * @param prefix    the prefix
     * @param type1     the type 1
     */
    public PrefixedBeanMapper1Impl(E1 executor, E2 execution, Map<String, Object> params, String prefix,
            Class<T1> type1) {
        super(executor, execution, params, Tuples.of(prefix));
        this.type1 = type1;
    }

    /**
     * Instantiates a new tpl prefix entity mapper 1.
     *
     * @param executor  the executor
     * @param execution the execution
     * @param params    the params
     * @param type1     the type 1
     */
    public PrefixedBeanMapper1Impl(E1 executor, E2 execution, Object[] params, Class<T1> type1) {
        this(executor, execution, params, "", type1);
    }

    /**
     * Instantiates a new tpl prefix entity mapper 1.
     *
     * @param executor  the executor
     * @param execution the execution
     * @param params    the params
     * @param prefix    the prefix
     * @param type1     the type 1
     */
    public PrefixedBeanMapper1Impl(E1 executor, E2 execution, Object[] params, String prefix, Class<T1> type1) {
        super(executor, execution, params, Tuples.of(prefix));
        this.type1 = type1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T1 single() {
        if (params instanceof Map) {
            return executor.single(execution, type1, getParamsMap());
        } else {
            return executor.single(execution, type1, getParams());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T1 unique() {
        if (params instanceof Map) {
            return executor.unique(execution, type1, getParamsMap());
        } else {
            return executor.unique(execution, type1, getParams());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<T1> list() {
        if (params instanceof Map) {
            return executor.list(execution, type1, getParamsMap());
        } else {
            return executor.list(execution, type1, getParams());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<T1> list(int offset, int limit) {
        if (params instanceof Map) {
            return executor.list(execution, type1, getParamsMap(), offset, limit);
        } else {
            return executor.list(execution, type1, getParams(), offset, limit);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<T1> pagination(int offset, int limit) {
        if (params instanceof Map) {
            return executor.pagination(execution, type1, getParamsMap(), offset, limit);
        } else {
            return executor.pagination(execution, type1, getParams(), offset, limit);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T2> PrefixedBeanMapper2<T1, T2> map(String prefix, Class<T2> type) {
        if (params instanceof Map) {
            return new PrefixedBeanMapper2Impl<>(executor, execution, getParamsMap(), type1, type,
                    Tuples.of(prefixes.get0(), prefix));
        } else {
            return new PrefixedBeanMapper2Impl<>(executor, execution, getParams(), type1, type,
                    Tuples.of(prefixes.get0(), prefix));
        }
    }
}
