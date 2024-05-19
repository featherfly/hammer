
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-10 17:17:10
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.tpl;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuple3;
import com.speedment.common.tuple.Tuple4;
import com.speedment.common.tuple.Tuple5;
import com.speedment.common.tuple.Tuple6;

import cn.featherfly.common.repository.ExecutionExecutor;
import cn.featherfly.common.repository.ParamedExecutionExecutor;
import cn.featherfly.common.repository.ParamedMappedExecutor;
import cn.featherfly.common.repository.mapping.RowMapper;
import cn.featherfly.common.repository.mapping.TupleMapperBuilder;

/**
 * TemplateParamedExecutionExecutor.
 *
 * @author zhongj
 * @param <E1> the generic type
 * @param <E2> the generic type
 */
public class ArrayParamedExecutionExecutor<E1 extends ExecutionExecutor<E2>, E2> implements ParamedExecutionExecutor {

    /** The executor. */
    protected final E1 executor;

    /** The execution. */
    protected final E2 execution;

    /** The params. */
    protected final Object[] params;

    /**
     * Instantiates a new template paramed execution executor.
     *
     * @param executor the executor
     * @param execution the execution
     * @param params the params
     */
    public ArrayParamedExecutionExecutor(E1 executor, E2 execution, Object... params) {
        super();
        this.executor = executor;
        this.execution = execution;
        this.params = params;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> ParamedMappedExecutor<T> mapper(Class<T> mapType) {
        return new PrefixedBeanMapper1Impl<>(executor, execution, params, mapType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2> ParamedMappedExecutor<Tuple2<T1, T2>> mapper(Class<T1> type1, Class<T2> type2) {
        return new PrefixedBeanMapper2Impl<>(executor, execution, params, type1, type2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3> ParamedMappedExecutor<Tuple3<T1, T2, T3>> mapper(Class<T1> type1, Class<T2> type2,
        Class<T3> type3) {
        return new PrefixedBeanMapper3Impl<>(executor, execution, params, type1, type2, type3);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4> ParamedMappedExecutor<Tuple4<T1, T2, T3, T4>> mapper(Class<T1> type1, Class<T2> type2,
        Class<T3> type3, Class<T4> type4) {
        return new PrefixedBeanMapper4Impl<>(executor, execution, params, type1, type2, type3, type4);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5> ParamedMappedExecutor<Tuple5<T1, T2, T3, T4, T5>> mapper(Class<T1> type1,
        Class<T2> type2, Class<T3> type3, Class<T4> type4, Class<T5> type5) {
        return new PrefixedBeanMapper5Impl<>(executor, execution, params, type1, type2, type3, type4, type5);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5, T6> ParamedMappedExecutor<Tuple6<T1, T2, T3, T4, T5, T6>> mapper(Class<T1> type1,
        Class<T2> type2, Class<T3> type3, Class<T4> type4, Class<T5> type5, Class<T6> type6) {
        return new PrefixedBeanMapper6Impl<>(executor, execution, params, type1, type2, type3, type4, type5, type6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> ParamedMappedExecutor<T> mapper(
        Function<TupleMapperBuilder, ParamedMappedExecutor<T>> mapperBuilderFunction) {
        return mapperBuilderFunction.apply(new ArrayParamTupleMapperBuilder<>(executor, execution, params));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int execute() {
        return executor.execute(execution, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int intValue() {
        return executor.intValue(execution, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long longValue() {
        return executor.longValue(execution, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double doubleValue() {
        return executor.doubleValue(execution, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean bool() {
        return executor.bool(execution, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <V> V value(Class<V> valueType) {
        return executor.value(execution, valueType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Object> single() {
        return executor.single(execution, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T single(Class<T> mapType) {
        return executor.single(execution, mapType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T single(RowMapper<T> rowMapper) {
        return executor.single(execution, rowMapper, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Object> unique() {
        return executor.unique(execution, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T unique(Class<T> mapType) {
        return executor.unique(execution, mapType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T unique(RowMapper<T> rowMapper) {
        return executor.unique(execution, rowMapper, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list() {
        return executor.list(execution, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> List<T> list(Class<T> mapType) {
        return executor.list(execution, mapType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> List<T> list(RowMapper<T> rowMapper) {
        return executor.list(execution, rowMapper, params);
    }
}
