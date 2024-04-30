
package cn.featherfly.hammer.tpl.mapper;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuple3;
import com.speedment.common.tuple.Tuple4;
import com.speedment.common.tuple.Tuple5;
import com.speedment.common.tuple.Tuple6;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.dsl.entity.execute.EntityDelete;
import cn.featherfly.hammer.dsl.entity.execute.EntityUpdate;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryFetch;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryDelete;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryUpdate;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryFetch;
import cn.featherfly.hammer.tpl.TplExecuteId;

/**
 * BasedTplHammer.
 *
 * @author zhongj
 */
public class BasedTplHammer implements Hammer {

    /** The hammer. */
    protected Hammer hammer;

    /**
     * Instantiates a new based hammer tpl executor.
     *
     * @param hammer the hammer
     */
    public BasedTplHammer(Hammer hammer) {
        this.hammer = hammer;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal numberBigDecimal(String tplExecuteId, Map<String, Object> params) {
        return hammer.numberBigDecimal(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryDelete delete(String repository) {
        return hammer.delete(repository);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> EntityDelete<E> delete(Class<E> entityType) {
        return hammer.delete(entityType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int delete(Serializable id, Class<E> entityType) {
        return hammer.delete(id, entityType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int delete(E entity) {
        return hammer.delete(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int[] delete(@SuppressWarnings("unchecked") E... entities) {
        return hammer.delete(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int[] delete(List<E> entities) {
        return hammer.delete(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double numberDouble(String tplExecuteId, Map<String, Object> params) {
        return hammer.numberDouble(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E load(E entity) {
        return hammer.load(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E get(E entity) {
        return hammer.load(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E get(Serializable id, Class<E> type) {
        return hammer.get(id, type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer numberInt(String tplExecuteId, Map<String, Object> params) {
        return hammer.numberInt(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(String tplExecuteId, Class<E> entityType, Map<String, Object> params) {
        return hammer.list(tplExecuteId, entityType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(String tplExecuteId, Class<E> entityType, Map<String, Object> params, int offset,
            int limit) {
        return hammer.list(tplExecuteId, entityType, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list(String tplExecuteId, Map<String, Object> params) {
        return hammer.list(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list(String tplExecuteId, Map<String, Object> params, int offset, int limit) {
        return hammer.list(tplExecuteId, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params) {
        return hammer.list(tplExecuteId, entityType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params, int offset,
            int limit) {
        return hammer.list(tplExecuteId, entityType, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return hammer.list(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list(TplExecuteId tplExecuteId, Map<String, Object> params, int offset,
            int limit) {
        return hammer.list(tplExecuteId, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> List<Tuple2<R1, R2>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Map<String, Object> params) {
        return hammer.list(tplExecuteId, entityType1, entityType2, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> List<Tuple2<R1, R2>> list(TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Map<String, Object> params) {
        return hammer.list(tplExecuteId, entityType1, entityType2, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> List<Tuple2<R1, R2>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Map<String, Object> params, int offset, int limit) {
        return hammer.list(tplExecuteId, entityType1, entityType2, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> List<Tuple2<R1, R2>> list(TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Map<String, Object> params, int offset, int limit) {
        return hammer.list(tplExecuteId, entityType1, entityType2, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> List<Tuple2<R1, R2>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Tuple2<String, String> prefixes, Map<String, Object> params) {
        return hammer.list(tplExecuteId, entityType1, entityType2, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> List<Tuple2<R1, R2>> list(TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Tuple2<String, String> prefixes, Map<String, Object> params) {
        return hammer.list(tplExecuteId, entityType1, entityType2, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> List<Tuple2<R1, R2>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Tuple2<String, String> prefixes, Map<String, Object> params, int offset, int limit) {
        return hammer.list(tplExecuteId, entityType1, entityType2, prefixes, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> List<Tuple2<R1, R2>> list(TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Tuple2<String, String> prefixes, Map<String, Object> params, int offset, int limit) {
        return hammer.list(tplExecuteId, entityType1, entityType2, prefixes, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Class<R3> entityType3, Map<String, Object> params) {
        return hammer.list(tplExecuteId, entityType1, entityType2, entityType3, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Map<String, Object> params) {
        return hammer.list(tplExecuteId, entityType1, entityType2, entityType3, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Class<R3> entityType3, Map<String, Object> param, int offset, int limits) {
        return hammer.list(tplExecuteId, entityType1, entityType2, entityType3, param, offset, limits);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Map<String, Object> params, int offset, int limit) {
        return hammer.list(tplExecuteId, entityType1, entityType2, entityType3, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Class<R3> entityType3, Tuple3<String, String, String> prefixes, Map<String, Object> params) {
        return hammer.list(tplExecuteId, entityType1, entityType2, entityType3, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Tuple3<String, String, String> prefixes,
            Map<String, Object> params) {
        return hammer.list(tplExecuteId, entityType1, entityType2, entityType3, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Class<R3> entityType3, Tuple3<String, String, String> prefixes, Map<String, Object> params, int offset,
            int limit) {
        return hammer.list(tplExecuteId, entityType1, entityType2, entityType3, prefixes, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Tuple3<String, String, String> prefixes,
            Map<String, Object> params, int offset, int limit) {
        return hammer.list(tplExecuteId, entityType1, entityType2, entityType3, prefixes, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Map<String, Object> params) {
        return hammer.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Map<String, Object> params) {
        return hammer.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Map<String, Object> params, int offset,
            int limit) {
        return hammer.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Map<String, Object> params, int offset,
            int limit) {
        return hammer.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Tuple4<String, String, String, String> prefixes, Map<String, Object> params) {
        return hammer.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Tuple4<String, String, String, String> prefixes, Map<String, Object> params) {
        return hammer.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Tuple4<String, String, String, String> prefixes, Map<String, Object> params, int offset, int limit) {
        return hammer.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, prefixes, params, offset,
                limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Tuple4<String, String, String, String> prefixes, Map<String, Object> params, int offset, int limit) {
        return hammer.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, prefixes, params, offset,
                limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Map<String, Object> params) {
        return hammer.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Map<String, Object> params) {
        return hammer.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Map<String, Object> params, int offset, int limit) {
        return hammer.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, params,
                offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Map<String, Object> params, int offset, int limit) {
        return hammer.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, params,
                offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Tuple5<String, String, String, String, String> prefixes, Map<String, Object> params) {
        return hammer.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, prefixes,
                params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Tuple5<String, String, String, String, String> prefixes, Map<String, Object> params) {
        return hammer.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, prefixes,
                params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Tuple5<String, String, String, String, String> prefixes, Map<String, Object> params, int offset,
            int limit) {
        return hammer.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, prefixes,
                params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Tuple5<String, String, String, String, String> prefixes, Map<String, Object> params, int offset,
            int limit) {
        return hammer.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, prefixes,
                params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long numberLong(String tplExecuteId, Map<String, Object> params) {
        return hammer.numberLong(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int merge(E entity) {
        return hammer.merge(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int[] merge(@SuppressWarnings("unchecked") E... entities) {
        return hammer.merge(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int[] merge(List<E> entities) {
        return hammer.merge(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> N number(String tplExecuteId, Class<N> numberType, Map<String, Object> params) {
        return hammer.number(tplExecuteId, numberType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> PaginationResults<E> pagination(String tplExecuteId, Class<E> entityType, Map<String, Object> params,
            int offset, int limit) {
        return hammer.pagination(tplExecuteId, entityType, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<Map<String, Object>> pagination(String tplExecuteId, Map<String, Object> params,
            int offset, int limit) {
        return hammer.pagination(tplExecuteId, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> PaginationResults<E> pagination(TplExecuteId tplExecuteId, Class<E> entityType,
            Map<String, Object> params, int offset, int limit) {
        return hammer.pagination(tplExecuteId, entityType, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<Map<String, Object>> pagination(TplExecuteId tplExecuteId, Map<String, Object> params,
            int offset, int limit) {
        return hammer.pagination(tplExecuteId, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> PaginationResults<Tuple2<R1, R2>> pagination(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Map<String, Object> params, int offset, int limit) {
        return hammer.pagination(tplExecuteId, entityType1, entityType2, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> PaginationResults<Tuple2<R1, R2>> pagination(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Map<String, Object> params, int offset, int limit) {
        return hammer.pagination(tplExecuteId, entityType1, entityType2, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> PaginationResults<Tuple2<R1, R2>> pagination(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Tuple2<String, String> prefixes, Map<String, Object> params, int offset, int limit) {
        return hammer.pagination(tplExecuteId, entityType1, entityType2, prefixes, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> PaginationResults<Tuple2<R1, R2>> pagination(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Tuple2<String, String> prefixes, Map<String, Object> params, int offset, int limit) {
        return hammer.pagination(tplExecuteId, entityType1, entityType2, prefixes, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> PaginationResults<Tuple3<R1, R2, R3>> pagination(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Map<String, Object> param, int offset, int limits) {
        return hammer.pagination(tplExecuteId, entityType1, entityType2, entityType3, param, offset, limits);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> PaginationResults<Tuple3<R1, R2, R3>> pagination(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Map<String, Object> params, int offset,
            int limit) {
        return hammer.pagination(tplExecuteId, entityType1, entityType2, entityType3, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> PaginationResults<Tuple3<R1, R2, R3>> pagination(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Tuple3<String, String, String> prefixes,
            Map<String, Object> params, int offset, int limit) {
        return hammer.pagination(tplExecuteId, entityType1, entityType2, entityType3, prefixes, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> PaginationResults<Tuple3<R1, R2, R3>> pagination(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3,
            Tuple3<String, String, String> prefixes, Map<String, Object> params, int offset, int limit) {
        return hammer.pagination(tplExecuteId, entityType1, entityType2, entityType3, prefixes, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> PaginationResults<Tuple4<R1, R2, R3, R4>> pagination(String tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Map<String, Object> params, int offset, int limit) {
        return hammer.pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, params, offset,
                limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> PaginationResults<Tuple4<R1, R2, R3, R4>> pagination(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Map<String, Object> params, int offset, int limit) {
        return hammer.pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, params, offset,
                limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> PaginationResults<Tuple4<R1, R2, R3, R4>> pagination(String tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Tuple4<String, String, String, String> prefixes, Map<String, Object> params, int offset, int limit) {
        return hammer.pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, prefixes, params,
                offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> PaginationResults<Tuple4<R1, R2, R3, R4>> pagination(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Tuple4<String, String, String, String> prefixes, Map<String, Object> params, int offset, int limit) {
        return hammer.pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, prefixes, params,
                offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> PaginationResults<Tuple5<R1, R2, R3, R4, R5>> pagination(String tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Map<String, Object> params, int offset, int limit) {
        return hammer.pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, params,
                offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> PaginationResults<Tuple5<R1, R2, R3, R4, R5>> pagination(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Map<String, Object> params, int offset, int limit) {
        return hammer.pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, params,
                offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> PaginationResults<Tuple5<R1, R2, R3, R4, R5>> pagination(String tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Tuple5<String, String, String, String, String> prefixes, Map<String, Object> params,
            int offset, int limit) {
        return hammer.pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
                prefixes, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> PaginationResults<Tuple5<R1, R2, R3, R4, R5>> pagination(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Tuple5<String, String, String, String, String> prefixes, Map<String, Object> params,
            int offset, int limit) {
        return hammer.pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
                prefixes, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> EntityQueryFetch<E> query(Class<E> entityType) {
        return hammer.query(entityType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryFetch query(String repository) {
        return hammer.query(repository);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryFetch query(Repository repository) {
        return hammer.query(repository);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int save(E entity) {
        return hammer.save(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int[] save(@SuppressWarnings("unchecked") E... entities) {
        return hammer.save(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int[] save(E[] entities, int batchSize) {
        return hammer.save(entities, batchSize);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int[] save(List<E> entities) {
        return hammer.save(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int[] save(List<E> entities, int batchSize) {
        return hammer.save(entities, batchSize);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Object> single(String tplExecuteId, Map<String, Object> params) {
        return hammer.single(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Object> single(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return hammer.single(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E single(String tplExecuteId, Class<E> entityType, Map<String, Object> params) {
        return hammer.single(tplExecuteId, entityType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E single(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params) {
        return hammer.single(tplExecuteId, entityType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> Tuple2<R1, R2> single(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Map<String, Object> params) {
        return hammer.single(tplExecuteId, entityType1, entityType2, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> Tuple2<R1, R2> single(TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Map<String, Object> params) {
        return hammer.single(tplExecuteId, entityType1, entityType2, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> Tuple2<R1, R2> single(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Tuple2<String, String> prefixes, Map<String, Object> params) {
        return hammer.single(tplExecuteId, entityType1, entityType2, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> Tuple2<R1, R2> single(TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Tuple2<String, String> prefixes, Map<String, Object> params) {
        return hammer.single(tplExecuteId, entityType1, entityType2, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> Tuple3<R1, R2, R3> single(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Class<R3> entityType3, Map<String, Object> params) {
        return hammer.single(tplExecuteId, entityType1, entityType2, entityType3, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> Tuple3<R1, R2, R3> single(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Map<String, Object> params) {
        return hammer.single(tplExecuteId, entityType1, entityType2, entityType3, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> Tuple3<R1, R2, R3> single(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Class<R3> entityType3, Tuple3<String, String, String> prefixes, Map<String, Object> params) {
        return hammer.single(tplExecuteId, entityType1, entityType2, entityType3, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> Tuple3<R1, R2, R3> single(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Tuple3<String, String, String> prefixes,
            Map<String, Object> params) {
        return hammer.single(tplExecuteId, entityType1, entityType2, entityType3, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> Tuple4<R1, R2, R3, R4> single(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Map<String, Object> params) {
        return hammer.single(tplExecuteId, entityType1, entityType2, entityType3, entityType4, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> Tuple4<R1, R2, R3, R4> single(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Map<String, Object> params) {
        return hammer.single(tplExecuteId, entityType1, entityType2, entityType3, entityType4, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> Tuple4<R1, R2, R3, R4> single(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Tuple4<String, String, String, String> prefixes, Map<String, Object> params) {
        return hammer.single(tplExecuteId, entityType1, entityType2, entityType3, entityType4, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> Tuple4<R1, R2, R3, R4> single(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Tuple4<String, String, String, String> prefixes, Map<String, Object> params) {
        return hammer.single(tplExecuteId, entityType1, entityType2, entityType3, entityType4, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> Tuple5<R1, R2, R3, R4, R5> single(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Tuple5<String, String, String, String, String> prefixes, Map<String, Object> params) {
        return hammer.single(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, prefixes,
                params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> Tuple5<R1, R2, R3, R4, R5> single(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Tuple5<String, String, String, String, String> prefixes, Map<String, Object> params) {
        return hammer.single(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, prefixes,
                params);
    }

    /**
     * Single.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param tplExecuteId the tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param params       the params
     * @return the tuple 5
     * @see cn.featherfly.hammer.tpl.TplExecutor#single(java.lang.String,
     *      java.lang.Class, java.lang.Class, java.lang.Class, java.lang.Class,
     *      java.lang.Class, java.util.Map)
     */
    @Override
    public <R1, R2, R3, R4, R5> Tuple5<R1, R2, R3, R4, R5> single(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Map<String, Object> params) {
        return hammer.single(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, params);
    }

    /**
     * Single.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param tplExecuteId the tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param params       the params
     * @return the tuple 5
     * @see cn.featherfly.hammer.tpl.TplExecutor#single(cn.featherfly.hammer.tpl.TplExecuteId,
     *      java.lang.Class, java.lang.Class, java.lang.Class, java.lang.Class,
     *      java.lang.Class, java.util.Map)
     */
    @Override
    public <R1, R2, R3, R4, R5> Tuple5<R1, R2, R3, R4, R5> single(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Map<String, Object> params) {
        return hammer.single(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String string(String tplExecuteId, Map<String, Object> params) {
        return hammer.string(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryUpdate update(String repository) {
        return hammer.update(repository);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> EntityUpdate<E> update(Class<E> entityType) {
        return hammer.update(entityType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int update(E entity) {
        return hammer.update(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int[] update(@SuppressWarnings("unchecked") E... entities) {
        return hammer.update(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int update(E entity, IgnoreStrategy ignoreStrategy) {
        return hammer.update(entity, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int[] update(List<E> entities) {
        return hammer.update(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int[] update(List<E> entities, int batchSize) {
        return hammer.update(entities, batchSize);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int[] update(List<E> entities, IgnoreStrategy ignoreStrategy) {
        return hammer.update(entities, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E value(String tplExecuteId, Class<E> valueType, Map<String, Object> params) {
        return hammer.value(tplExecuteId, valueType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E value(TplExecuteId tplExecuteId, Class<E> valueType, Map<String, Object> params) {
        return hammer.value(tplExecuteId, valueType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> N number(TplExecuteId tplExecuteId, Class<N> numberType, Map<String, Object> params) {
        return hammer.number(tplExecuteId, numberType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer numberInt(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return hammer.numberInt(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long numberLong(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return hammer.numberLong(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal numberBigDecimal(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return hammer.numberBigDecimal(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double numberDouble(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return hammer.numberDouble(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String string(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return hammer.string(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int execute(String tplExecuteId, Map<String, Object> params) {
        return hammer.execute(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int execute(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return hammer.execute(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int intValue(String tplExecuteId, Map<String, Object> params) {
        return hammer.intValue(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int intValue(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return hammer.intValue(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long longValue(String tplExecuteId, Map<String, Object> params) {
        return hammer.longValue(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long longValue(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return hammer.longValue(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double doubleValue(String tplExecuteId, Map<String, Object> params) {
        return hammer.doubleValue(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double doubleValue(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return hammer.doubleValue(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int[] delete(Serializable[] ids, Class<E> entityType) {
        return hammer.delete(ids, entityType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, ID extends Serializable> int[] delete(List<ID> ids, Class<E> entityType) {
        return hammer.delete(ids, entityType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> get(Class<E> type, Serializable... ids) {
        return hammer.get(type, ids);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> get(Class<E> type, List<Serializable> ids) {
        return hammer.get(type, ids);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, R> E get(Serializable id, Class<E> type, SerializableFunction<E, R> fetchProperty) {
        return hammer.get(id, type, fetchProperty);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int saveOrUpdate(E entity) {
        return hammer.saveOrUpdate(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int saveOrUpdate(E entity, Predicate<E> updatable) {
        return hammer.saveOrUpdate(entity, updatable);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E updateFetch(Serializable id, Class<E> type, UnaryOperator<E> updateOperator) {
        return hammer.updateFetch(id, type, updateOperator);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E updateFetch(E entity, UnaryOperator<E> updateOperator) {
        return hammer.updateFetch(entity, updateOperator);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryUpdate update(Repository repository) {
        return hammer.update(repository);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryDelete delete(Repository repository) {
        return hammer.delete(repository);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> Tuple6<R1, R2, R3, R4, R5, R6> single(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Class<R6> entityType6, Map<String, Object> params) {
        return hammer.single(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
                params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> Tuple6<R1, R2, R3, R4, R5, R6> single(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Class<R6> entityType6, Map<String, Object> params) {
        return hammer.single(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
                params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> Tuple6<R1, R2, R3, R4, R5, R6> single(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Class<R6> entityType6, Tuple6<String, String, String, String, String, String> prefixes,
            Map<String, Object> params) {
        return hammer.single(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
                prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> Tuple6<R1, R2, R3, R4, R5, R6> single(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Class<R6> entityType6,
            Tuple6<String, String, String, String, String, String> prefixes, Map<String, Object> params) {
        return hammer.single(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
                prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> List<Tuple6<R1, R2, R3, R4, R5, R6>> list(String tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Class<R6> entityType6, Map<String, Object> params) {
        return hammer.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
                params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> List<Tuple6<R1, R2, R3, R4, R5, R6>> list(String tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Class<R6> entityType6, Map<String, Object> params, int offset, int limit) {
        return hammer.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
                params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> List<Tuple6<R1, R2, R3, R4, R5, R6>> list(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Class<R6> entityType6, Map<String, Object> params) {
        return hammer.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
                params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> List<Tuple6<R1, R2, R3, R4, R5, R6>> list(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Class<R6> entityType6, Map<String, Object> params, int offset, int limit) {
        return hammer.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
                params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> List<Tuple6<R1, R2, R3, R4, R5, R6>> list(String tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Class<R6> entityType6,
            Tuple6<String, String, String, String, String, String> prefixes, Map<String, Object> params) {
        return hammer.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
                prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> List<Tuple6<R1, R2, R3, R4, R5, R6>> list(String tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Class<R6> entityType6,
            Tuple6<String, String, String, String, String, String> prefixes, Map<String, Object> params, int offset,
            int limit) {
        return hammer.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
                prefixes, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> List<Tuple6<R1, R2, R3, R4, R5, R6>> list(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Class<R6> entityType6,
            Tuple6<String, String, String, String, String, String> prefixes, Map<String, Object> params) {
        return hammer.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
                prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> List<Tuple6<R1, R2, R3, R4, R5, R6>> list(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Class<R6> entityType6,
            Tuple6<String, String, String, String, String, String> prefixes, Map<String, Object> params, int offset,
            int limit) {
        return hammer.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
                prefixes, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> PaginationResults<Tuple6<R1, R2, R3, R4, R5, R6>> pagination(String tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Class<R6> entityType6, Map<String, Object> params, int offset, int limit) {
        return hammer.pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
                entityType6, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> PaginationResults<Tuple6<R1, R2, R3, R4, R5, R6>> pagination(
            TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3,
            Class<R4> entityType4, Class<R5> entityType5, Class<R6> entityType6, Map<String, Object> params, int offset,
            int limit) {
        return hammer.pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
                entityType6, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> PaginationResults<Tuple6<R1, R2, R3, R4, R5, R6>> pagination(String tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Class<R6> entityType6,
            Tuple6<String, String, String, String, String, String> prefixes, Map<String, Object> params, int offset,
            int limit) {
        return hammer.pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
                entityType6, prefixes, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> PaginationResults<Tuple6<R1, R2, R3, R4, R5, R6>> pagination(
            TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3,
            Class<R4> entityType4, Class<R5> entityType5, Class<R6> entityType6,
            Tuple6<String, String, String, String, String, String> prefixes, Map<String, Object> params, int offset,
            int limit) {
        return hammer.pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
                entityType6, prefixes, params, offset, limit);
    }
}
