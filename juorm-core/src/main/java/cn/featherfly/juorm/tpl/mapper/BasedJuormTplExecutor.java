
package cn.featherfly.juorm.tpl.mapper;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import cn.featherfly.common.structure.page.Page;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.juorm.Juorm;
import cn.featherfly.juorm.dsl.execute.Delete;
import cn.featherfly.juorm.dsl.execute.Update;
import cn.featherfly.juorm.dsl.query.QueryEntity;
import cn.featherfly.juorm.dsl.query.TypeQueryEntity;
import cn.featherfly.juorm.tpl.TplExecuteId;

/**
 * <p>
 * JuormBaseMapper
 * </p>
 * <p>
 * 2019-08-14
 * </p>
 * .
 *
 * @author zhongj
 */
public class BasedJuormTplExecutor implements Juorm {

    /** The juorm. */
    protected Juorm juorm;

    /**
     * Instantiates a new based juorm tpl executor.
     *
     * @param juorm the juorm
     */
    public BasedJuormTplExecutor(Juorm juorm) {
        this.juorm = juorm;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal bigDecimalValue(String tplExecuteId, Map<String, Object> params) {
        return juorm.bigDecimalValue(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> Delete delete(Class<E> entityType) {
        return juorm.delete(entityType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int delete(E entity) {
        return juorm.delete(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int delete(@SuppressWarnings("unchecked") E... entities) {
        return juorm.delete(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int delete(List<E> entities) {
        return juorm.delete(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double doubleValue(String tplExecuteId, Map<String, Object> params) {
        return juorm.doubleValue(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E get(E entity) {
        return juorm.get(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E get(Serializable id, Class<E> type) {
        return juorm.get(id, type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer intValue(String tplExecuteId, Map<String, Object> params) {
        return juorm.intValue(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(String tplExecuteId, Class<E> entityType, Map<String, Object> params) {
        return juorm.list(tplExecuteId, entityType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(String tplExecuteId, Class<E> entityType, Map<String, Object> params, int offset,
            int limit) {
        return juorm.list(tplExecuteId, entityType, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(String tplExecuteId, Class<E> entityType, Map<String, Object> params, Page page) {
        return juorm.list(tplExecuteId, entityType, params, page);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list(String tplExecuteId, Map<String, Object> params) {
        return juorm.list(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list(String tplExecuteId, Map<String, Object> params, int offset, int limit) {
        return juorm.list(tplExecuteId, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list(String tplExecuteId, Map<String, Object> params, Page page) {
        return juorm.list(tplExecuteId, params, page);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params) {
        return juorm.list(tplExecuteId, entityType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params, int offset,
            int limit) {
        return juorm.list(tplExecuteId, entityType, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params, Page page) {
        return juorm.list(tplExecuteId, entityType, params, page);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return juorm.list(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list(TplExecuteId tplExecuteId, Map<String, Object> params, int offset,
            int limit) {
        return juorm.list(tplExecuteId, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list(TplExecuteId tplExecuteId, Map<String, Object> params, Page page) {
        return juorm.list(tplExecuteId, params, page);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long longValue(String tplExecuteId, Map<String, Object> params) {
        return juorm.longValue(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int merge(E entity) {
        return juorm.merge(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int merge(@SuppressWarnings("unchecked") E... entities) {
        return juorm.merge(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int merge(List<E> entities) {
        return juorm.merge(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> N number(String tplExecuteId, Class<N> numberType, Map<String, Object> params) {
        return juorm.number(tplExecuteId, numberType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> PaginationResults<E> pagination(String tplExecuteId, Class<E> entityType, Map<String, Object> params,
            int offset, int limit) {
        return juorm.pagination(tplExecuteId, entityType, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> PaginationResults<E> pagination(String tplExecuteId, Class<E> entityType, Map<String, Object> params,
            Page page) {
        return juorm.pagination(tplExecuteId, entityType, params, page);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<Map<String, Object>> pagination(String tplExecuteId, Map<String, Object> params,
            int offset, int limit) {
        return juorm.pagination(tplExecuteId, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<Map<String, Object>> pagination(String tplExecuteId, Map<String, Object> params,
            Page page) {
        return juorm.pagination(tplExecuteId, params, page);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> PaginationResults<E> pagination(TplExecuteId tplExecuteId, Class<E> entityType,
            Map<String, Object> params, int offset, int limit) {
        return juorm.pagination(tplExecuteId, entityType, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> PaginationResults<E> pagination(TplExecuteId tplExecuteId, Class<E> entityType,
            Map<String, Object> params, Page page) {
        return juorm.pagination(tplExecuteId, entityType, params, page);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<Map<String, Object>> pagination(TplExecuteId tplExecuteId, Map<String, Object> params,
            int offset, int limit) {
        return juorm.pagination(tplExecuteId, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<Map<String, Object>> pagination(TplExecuteId tplExecuteId, Map<String, Object> params,
            Page page) {
        return juorm.pagination(tplExecuteId, params, page);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> TypeQueryEntity query(Class<E> entityType) {
        return juorm.query(entityType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryEntity query(String repository) {
        return juorm.query(repository);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int save(E entity) {
        return juorm.save(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int save(@SuppressWarnings("unchecked") E... entities) {
        return juorm.save(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int save(List<E> entities) {
        return juorm.save(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E single(String tplExecuteId, Class<E> entityType, Map<String, Object> params) {
        return juorm.single(tplExecuteId, entityType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Object> single(String tplExecuteId, Map<String, Object> params) {
        return juorm.single(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E single(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params) {
        return juorm.single(tplExecuteId, entityType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Object> single(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return juorm.single(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String stringValue(String tplExecuteId, Map<String, Object> params) {
        return juorm.stringValue(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> Update update(Class<E> entityType) {
        return juorm.update(entityType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int update(E entity) {
        return juorm.update(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int update(@SuppressWarnings("unchecked") E... entities) {
        return juorm.update(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int update(E entity, IgnorePolicy ignorePolicy) {
        return juorm.update(entity, ignorePolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int update(List<E> entities) {
        return juorm.update(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int update(List<E> entities, IgnorePolicy ignorePolicy) {
        return juorm.update(entities, ignorePolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E value(String tplExecuteId, Class<E> valueType, Map<String, Object> params) {
        return juorm.value(tplExecuteId, valueType, params);
    }

}
