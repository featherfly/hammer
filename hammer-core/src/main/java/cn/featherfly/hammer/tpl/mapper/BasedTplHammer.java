
package cn.featherfly.hammer.tpl.mapper;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.repository.IgnorePolicy;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.dsl.execute.Delete;
import cn.featherfly.hammer.dsl.execute.Update;
import cn.featherfly.hammer.dsl.query.QueryEntity;
import cn.featherfly.hammer.dsl.query.TypeQueryEntity;
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
    public Delete delete(String repository) {
        return hammer.delete(repository);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> Delete delete(Class<E> entityType) {
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
    public <E> int delete(@SuppressWarnings("unchecked") E... entities) {
        return hammer.delete(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int delete(List<E> entities) {
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
    public <E> List<E> list(String tplExecuteId, Class<E> entityType, Map<String, Object> params, Page page) {
        return hammer.list(tplExecuteId, entityType, params, page);
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
    public List<Map<String, Object>> list(String tplExecuteId, Map<String, Object> params, Page page) {
        return hammer.list(tplExecuteId, params, page);
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
    public <E> List<E> list(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params, Page page) {
        return hammer.list(tplExecuteId, entityType, params, page);
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
    public List<Map<String, Object>> list(TplExecuteId tplExecuteId, Map<String, Object> params, Page page) {
        return hammer.list(tplExecuteId, params, page);
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
    public <E> int merge(@SuppressWarnings("unchecked") E... entities) {
        return hammer.merge(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int merge(List<E> entities) {
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
    public <E> PaginationResults<E> pagination(String tplExecuteId, Class<E> entityType, Map<String, Object> params,
            Page page) {
        return hammer.pagination(tplExecuteId, entityType, params, page);
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
    public PaginationResults<Map<String, Object>> pagination(String tplExecuteId, Map<String, Object> params,
            Page page) {
        return hammer.pagination(tplExecuteId, params, page);
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
    public <E> PaginationResults<E> pagination(TplExecuteId tplExecuteId, Class<E> entityType,
            Map<String, Object> params, Page page) {
        return hammer.pagination(tplExecuteId, entityType, params, page);
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
    public PaginationResults<Map<String, Object>> pagination(TplExecuteId tplExecuteId, Map<String, Object> params,
            Page page) {
        return hammer.pagination(tplExecuteId, params, page);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> TypeQueryEntity query(Class<E> entityType) {
        return hammer.query(entityType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryEntity query(String repository) {
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
    public <E> int save(@SuppressWarnings("unchecked") E... entities) {
        return hammer.save(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int save(List<E> entities) {
        return hammer.save(entities);
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
    public Map<String, Object> single(String tplExecuteId, Map<String, Object> params) {
        return hammer.single(tplExecuteId, params);
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
    public Map<String, Object> single(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return hammer.single(tplExecuteId, params);
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
    public Update update(String repository) {
        return hammer.update(repository);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> Update update(Class<E> entityType) {
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
    public <E> int update(@SuppressWarnings("unchecked") E... entities) {
        return hammer.update(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int update(E entity, IgnorePolicy ignorePolicy) {
        return hammer.update(entity, ignorePolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int update(List<E> entities) {
        return hammer.update(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int update(List<E> entities, IgnorePolicy ignorePolicy) {
        return hammer.update(entities, ignorePolicy);
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
    public <E> int delete(Serializable[] ids, Class<E> entityType) {
        return hammer.delete(ids, entityType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, ID extends Serializable> int delete(List<ID> ids, Class<E> entityType) {
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
}
