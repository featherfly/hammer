
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
import cn.featherfly.juorm.tpl.TplExecuteId;

/**
 * <p>
 * JuormBaseMapper
 * </p>
 * <p>
 * 2019-08-14
 * </p>
 *
 * @author zhongj
 */
public class BasedJuormTplExecutor implements Juorm {

    protected Juorm juorm;

    /**
     * @param juorm
     */
    public BasedJuormTplExecutor(Juorm juorm) {
        this.juorm = juorm;
    }

    /**
     * @param <E>
     * @param entity
     * @return
     * @see cn.featherfly.juorm.Juorm#save(java.lang.Object)
     */
    @Override
    public <E> int save(E entity) {
        return juorm.save(entity);
    }

    /**
     * @param <E>
     * @param entities
     * @return
     * @see cn.featherfly.juorm.Juorm#save(java.util.List)
     */
    @Override
    public <E> int save(List<E> entities) {
        return juorm.save(entities);
    }

    /**
     * @param <E>
     * @param entity
     * @return
     * @see cn.featherfly.juorm.Juorm#update(java.lang.Object)
     */
    @Override
    public <E> int update(E entity) {
        return juorm.update(entity);
    }

    /**
     * @param <E>
     * @param entities
     * @return
     * @see cn.featherfly.juorm.Juorm#update(java.util.List)
     */
    @Override
    public <E> int update(List<E> entities) {
        return juorm.update(entities);
    }

    /**
     * @param <E>
     * @param entity
     * @param ignorePolicy
     * @return
     * @see cn.featherfly.juorm.Juorm#update(java.lang.Object,
     *      cn.featherfly.juorm.Juorm.IgnorePolicy)
     */
    @Override
    public <E> int update(E entity, IgnorePolicy ignorePolicy) {
        return juorm.update(entity, ignorePolicy);
    }

    /**
     * @param <E>
     * @param entities
     * @param ignorePolicy
     * @return
     * @see cn.featherfly.juorm.Juorm#update(java.util.List,
     *      cn.featherfly.juorm.Juorm.IgnorePolicy)
     */
    @Override
    public <E> int update(List<E> entities, IgnorePolicy ignorePolicy) {
        return juorm.update(entities, ignorePolicy);
    }

    /**
     * @param <E>
     * @param entity
     * @return
     * @see cn.featherfly.juorm.Juorm#merge(java.lang.Object)
     */
    @Override
    public <E> int merge(E entity) {
        return juorm.merge(entity);
    }

    /**
     * @param <E>
     * @param entities
     * @return
     * @see cn.featherfly.juorm.Juorm#merge(java.util.List)
     */
    @Override
    public <E> int merge(List<E> entities) {
        return juorm.merge(entities);
    }

    /**
     * @param <E>
     * @param entity
     * @return
     * @see cn.featherfly.juorm.Juorm#delete(java.lang.Object)
     */
    @Override
    public <E> int delete(E entity) {
        return juorm.delete(entity);
    }

    /**
     * @param <E>
     * @param entities
     * @return
     * @see cn.featherfly.juorm.Juorm#delete(java.util.List)
     */
    @Override
    public <E> int delete(List<E> entities) {
        return juorm.delete(entities);
    }

    /**
     * @param <E>
     * @param id
     * @param type
     * @return
     * @see cn.featherfly.juorm.Juorm#get(java.io.Serializable, java.lang.Class)
     */
    @Override
    public <E> E get(Serializable id, Class<E> type) {
        return juorm.get(id, type);
    }

    /**
     * @param <E>
     * @param entity
     * @return
     * @see cn.featherfly.juorm.Juorm#get(java.lang.Object)
     */
    @Override
    public <E> E get(E entity) {
        return juorm.get(entity);
    }

    /**
     * @param <E>
     * @param entityType
     * @return
     * @see cn.featherfly.juorm.Juorm#query(java.lang.Class)
     */
    @Override
    public <E> QueryEntity query(Class<E> entityType) {
        return juorm.query(entityType);
    }

    /**
     * @param <E>
     * @param entityType
     * @return
     * @see cn.featherfly.juorm.Juorm#update(java.lang.Class)
     */
    @Override
    public <E> Update update(Class<E> entityType) {
        return juorm.update(entityType);
    }

    /**
     * @param <E>
     * @param entityType
     * @return
     * @see cn.featherfly.juorm.Juorm#delete(java.lang.Class)
     */
    @Override
    public <E> Delete delete(Class<E> entityType) {
        return juorm.delete(entityType);
    }

    /**
     * @param <E>
     * @param tplExecuteId
     * @param entityType
     * @param params
     * @return
     * @see cn.featherfly.juorm.Juorm#single(java.lang.String, java.lang.Class,
     *      java.util.Map)
     */
    @Override
    public <E> E single(String tplExecuteId, Class<E> entityType, Map<String, Object> params) {
        return juorm.single(tplExecuteId, entityType, params);
    }

    /**
     * @param <E>
     * @param tplExecuteId
     * @param entityType
     * @param params
     * @return
     * @see cn.featherfly.juorm.Juorm#list(java.lang.String, java.lang.Class,
     *      java.util.Map)
     */
    @Override
    public <E> List<E> list(String tplExecuteId, Class<E> entityType, Map<String, Object> params) {
        return juorm.list(tplExecuteId, entityType, params);
    }

    /**
     * @param <E>
     * @param tplExecuteId
     * @param entityType
     * @param params
     * @param offset
     * @param limit
     * @return
     * @see cn.featherfly.juorm.Juorm#list(java.lang.String, java.lang.Class,
     *      java.util.Map, int, int)
     */
    @Override
    public <E> List<E> list(String tplExecuteId, Class<E> entityType, Map<String, Object> params, int offset,
            int limit) {
        return juorm.list(tplExecuteId, entityType, params, offset, limit);
    }

    /**
     * @param <E>
     * @param tplExecuteId
     * @param entityType
     * @param params
     * @param page
     * @return
     * @see cn.featherfly.juorm.Juorm#list(java.lang.String, java.lang.Class,
     *      java.util.Map, cn.featherfly.common.structure.page.Page)
     */
    @Override
    public <E> List<E> list(String tplExecuteId, Class<E> entityType, Map<String, Object> params, Page page) {
        return juorm.list(tplExecuteId, entityType, params, page);
    }

    /**
     * @param <E>
     * @param tplExecuteId
     * @param entityType
     * @param params
     * @param offset
     * @param limit
     * @return
     * @see cn.featherfly.juorm.Juorm#pagination(java.lang.String,
     *      java.lang.Class, java.util.Map, int, int)
     */
    @Override
    public <E> PaginationResults<E> pagination(String tplExecuteId, Class<E> entityType, Map<String, Object> params,
            int offset, int limit) {
        return juorm.pagination(tplExecuteId, entityType, params, offset, limit);
    }

    /**
     * @param <E>
     * @param tplExecuteId
     * @param entityType
     * @param params
     * @param page
     * @return
     * @see cn.featherfly.juorm.Juorm#pagination(java.lang.String,
     *      java.lang.Class, java.util.Map,
     *      cn.featherfly.common.structure.page.Page)
     */
    @Override
    public <E> PaginationResults<E> pagination(String tplExecuteId, Class<E> entityType, Map<String, Object> params,
            Page page) {
        return juorm.pagination(tplExecuteId, entityType, params, page);
    }

    /**
     * @param <E>
     * @param tplExecuteId
     * @param entityType
     * @param params
     * @return
     * @see cn.featherfly.juorm.Juorm#single(cn.featherfly.juorm.tpl.TplExecuteId,
     *      java.lang.Class, java.util.Map)
     */
    @Override
    public <E> E single(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params) {
        return juorm.single(tplExecuteId, entityType, params);
    }

    /**
     * @param <E>
     * @param tplExecuteId
     * @param entityType
     * @param params
     * @return
     * @see cn.featherfly.juorm.Juorm#list(cn.featherfly.juorm.tpl.TplExecuteId,
     *      java.lang.Class, java.util.Map)
     */
    @Override
    public <E> List<E> list(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params) {
        return juorm.list(tplExecuteId, entityType, params);
    }

    /**
     * @param <E>
     * @param tplExecuteId
     * @param entityType
     * @param params
     * @param offset
     * @param limit
     * @return
     * @see cn.featherfly.juorm.Juorm#list(cn.featherfly.juorm.tpl.TplExecuteId,
     *      java.lang.Class, java.util.Map, int, int)
     */
    @Override
    public <E> List<E> list(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params, int offset,
            int limit) {
        return juorm.list(tplExecuteId, entityType, params, offset, limit);
    }

    /**
     * @param <E>
     * @param tplExecuteId
     * @param entityType
     * @param params
     * @param page
     * @return
     * @see cn.featherfly.juorm.Juorm#list(cn.featherfly.juorm.tpl.TplExecuteId,
     *      java.lang.Class, java.util.Map,
     *      cn.featherfly.common.structure.page.Page)
     */
    @Override
    public <E> List<E> list(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params, Page page) {
        return juorm.list(tplExecuteId, entityType, params, page);
    }

    /**
     * @param <E>
     * @param tplExecuteId
     * @param entityType
     * @param params
     * @param offset
     * @param limit
     * @return
     * @see cn.featherfly.juorm.Juorm#pagination(cn.featherfly.juorm.tpl.TplExecuteId,
     *      java.lang.Class, java.util.Map, int, int)
     */
    @Override
    public <E> PaginationResults<E> pagination(TplExecuteId tplExecuteId, Class<E> entityType,
            Map<String, Object> params, int offset, int limit) {
        return juorm.pagination(tplExecuteId, entityType, params, offset, limit);
    }

    /**
     * @param <E>
     * @param tplExecuteId
     * @param entityType
     * @param params
     * @param page
     * @return
     * @see cn.featherfly.juorm.Juorm#pagination(cn.featherfly.juorm.tpl.TplExecuteId,
     *      java.lang.Class, java.util.Map,
     *      cn.featherfly.common.structure.page.Page)
     */
    @Override
    public <E> PaginationResults<E> pagination(TplExecuteId tplExecuteId, Class<E> entityType,
            Map<String, Object> params, Page page) {
        return juorm.pagination(tplExecuteId, entityType, params, page);
    }

    /**
     * @param tplExecuteId
     * @param params
     * @return
     * @see cn.featherfly.juorm.Juorm#single(java.lang.String, java.util.Map)
     */
    @Override
    public Map<String, Object> single(String tplExecuteId, Map<String, Object> params) {
        return juorm.single(tplExecuteId, params);
    }

    /**
     * @param tplExecuteId
     * @param params
     * @return
     * @see cn.featherfly.juorm.Juorm#single(cn.featherfly.juorm.tpl.TplExecuteId,
     *      java.util.Map)
     */
    @Override
    public Map<String, Object> single(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return juorm.single(tplExecuteId, params);
    }

    /**
     * @param tplExecuteId
     * @param params
     * @return
     * @see cn.featherfly.juorm.Juorm#list(java.lang.String, java.util.Map)
     */
    @Override
    public List<Map<String, Object>> list(String tplExecuteId, Map<String, Object> params) {
        return juorm.list(tplExecuteId, params);
    }

    /**
     * @param tplExecuteId
     * @param params
     * @return
     * @see cn.featherfly.juorm.Juorm#list(cn.featherfly.juorm.tpl.TplExecuteId,
     *      java.util.Map)
     */
    @Override
    public List<Map<String, Object>> list(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return juorm.list(tplExecuteId, params);
    }

    /**
     * @param tplExecuteId
     * @param params
     * @param offset
     * @param limit
     * @return
     * @see cn.featherfly.juorm.Juorm#list(java.lang.String, java.util.Map, int,
     *      int)
     */
    @Override
    public List<Map<String, Object>> list(String tplExecuteId, Map<String, Object> params, int offset, int limit) {
        return juorm.list(tplExecuteId, params, offset, limit);
    }

    /**
     * @param tplExecuteId
     * @param params
     * @param offset
     * @param limit
     * @return
     * @see cn.featherfly.juorm.Juorm#list(cn.featherfly.juorm.tpl.TplExecuteId,
     *      java.util.Map, int, int)
     */
    @Override
    public List<Map<String, Object>> list(TplExecuteId tplExecuteId, Map<String, Object> params, int offset,
            int limit) {
        return juorm.list(tplExecuteId, params, offset, limit);
    }

    /**
     * @param tplExecuteId
     * @param params
     * @param page
     * @return
     * @see cn.featherfly.juorm.Juorm#list(java.lang.String, java.util.Map,
     *      cn.featherfly.common.structure.page.Page)
     */
    @Override
    public List<Map<String, Object>> list(String tplExecuteId, Map<String, Object> params, Page page) {
        return juorm.list(tplExecuteId, params, page);
    }

    /**
     * @param tplExecuteId
     * @param params
     * @param page
     * @return
     * @see cn.featherfly.juorm.Juorm#list(cn.featherfly.juorm.tpl.TplExecuteId,
     *      java.util.Map, cn.featherfly.common.structure.page.Page)
     */
    @Override
    public List<Map<String, Object>> list(TplExecuteId tplExecuteId, Map<String, Object> params, Page page) {
        return juorm.list(tplExecuteId, params, page);
    }

    /**
     * @param tplExecuteId
     * @param params
     * @param offset
     * @param limit
     * @return
     * @see cn.featherfly.juorm.Juorm#pagination(java.lang.String,
     *      java.util.Map, int, int)
     */
    @Override
    public PaginationResults<Map<String, Object>> pagination(String tplExecuteId, Map<String, Object> params,
            int offset, int limit) {
        return juorm.pagination(tplExecuteId, params, offset, limit);
    }

    /**
     * @param tplExecuteId
     * @param params
     * @param offset
     * @param limit
     * @return
     * @see cn.featherfly.juorm.Juorm#pagination(cn.featherfly.juorm.tpl.TplExecuteId,
     *      java.util.Map, int, int)
     */
    @Override
    public PaginationResults<Map<String, Object>> pagination(TplExecuteId tplExecuteId, Map<String, Object> params,
            int offset, int limit) {
        return juorm.pagination(tplExecuteId, params, offset, limit);
    }

    /**
     * @param tplExecuteId
     * @param params
     * @param page
     * @return
     * @see cn.featherfly.juorm.Juorm#pagination(java.lang.String,
     *      java.util.Map, cn.featherfly.common.structure.page.Page)
     */
    @Override
    public PaginationResults<Map<String, Object>> pagination(String tplExecuteId, Map<String, Object> params,
            Page page) {
        return juorm.pagination(tplExecuteId, params, page);
    }

    /**
     * @param tplExecuteId
     * @param params
     * @param page
     * @return
     * @see cn.featherfly.juorm.Juorm#pagination(cn.featherfly.juorm.tpl.TplExecuteId,
     *      java.util.Map, cn.featherfly.common.structure.page.Page)
     */
    @Override
    public PaginationResults<Map<String, Object>> pagination(TplExecuteId tplExecuteId, Map<String, Object> params,
            Page page) {
        return juorm.pagination(tplExecuteId, params, page);
    }

    /**
     * @param <E>
     * @param tplExecuteId
     * @param valueType
     * @param params
     * @return
     * @see cn.featherfly.juorm.Juorm#value(java.lang.String, java.lang.Class,
     *      java.util.Map)
     */
    @Override
    public <E> E value(String tplExecuteId, Class<E> valueType, Map<String, Object> params) {
        return juorm.value(tplExecuteId, valueType, params);
    }

    /**
     * @param <N>
     * @param tplExecuteId
     * @param numberType
     * @param params
     * @return
     * @see cn.featherfly.juorm.Juorm#number(java.lang.String, java.lang.Class,
     *      java.util.Map)
     */
    @Override
    public <N extends Number> N number(String tplExecuteId, Class<N> numberType, Map<String, Object> params) {
        return juorm.number(tplExecuteId, numberType, params);
    }

    /**
     * @param tplExecuteId
     * @param params
     * @return
     * @see cn.featherfly.juorm.Juorm#intValue(java.lang.String, java.util.Map)
     */
    @Override
    public Integer intValue(String tplExecuteId, Map<String, Object> params) {
        return juorm.intValue(tplExecuteId, params);
    }

    /**
     * @param tplExecuteId
     * @param params
     * @return
     * @see cn.featherfly.juorm.Juorm#longValue(java.lang.String, java.util.Map)
     */
    @Override
    public Long longValue(String tplExecuteId, Map<String, Object> params) {
        return juorm.longValue(tplExecuteId, params);
    }

    /**
     * @param tplExecuteId
     * @param params
     * @return
     * @see cn.featherfly.juorm.Juorm#bigDecimalValue(java.lang.String,
     *      java.util.Map)
     */
    @Override
    public BigDecimal bigDecimalValue(String tplExecuteId, Map<String, Object> params) {
        return juorm.bigDecimalValue(tplExecuteId, params);
    }

    /**
     * @param tplExecuteId
     * @param params
     * @return
     * @see cn.featherfly.juorm.Juorm#doubleValue(java.lang.String,
     *      java.util.Map)
     */
    @Override
    public Double doubleValue(String tplExecuteId, Map<String, Object> params) {
        return juorm.doubleValue(tplExecuteId, params);
    }

    /**
     * @param tplExecuteId
     * @param params
     * @return
     * @see cn.featherfly.juorm.Juorm#stringValue(java.lang.String,
     *      java.util.Map)
     */
    @Override
    public String stringValue(String tplExecuteId, Map<String, Object> params) {
        return juorm.stringValue(tplExecuteId, params);
    }

}
