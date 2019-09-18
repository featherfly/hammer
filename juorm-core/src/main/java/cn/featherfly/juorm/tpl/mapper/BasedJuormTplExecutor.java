
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

// TODO: Auto-generated Javadoc
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
     * Save.
     *
     * @param <E>    the element type
     * @param entity the entity
     * @return the int
     * @see cn.featherfly.juorm.Juorm#save(java.lang.Object)
     */
    @Override
    public <E> int save(E entity) {
        return juorm.save(entity);
    }

    /**
     * Save.
     *
     * @param <E>      the element type
     * @param entities the entities
     * @return the int
     * @see cn.featherfly.juorm.Juorm#save(java.util.List)
     */
    @Override
    public <E> int save(List<E> entities) {
        return juorm.save(entities);
    }

    /**
     * Update.
     *
     * @param <E>    the element type
     * @param entity the entity
     * @return the int
     * @see cn.featherfly.juorm.Juorm#update(java.lang.Object)
     */
    @Override
    public <E> int update(E entity) {
        return juorm.update(entity);
    }

    /**
     * Update.
     *
     * @param <E>      the element type
     * @param entities the entities
     * @return the int
     * @see cn.featherfly.juorm.Juorm#update(java.util.List)
     */
    @Override
    public <E> int update(List<E> entities) {
        return juorm.update(entities);
    }

    /**
     * Update.
     *
     * @param <E>          the element type
     * @param entity       the entity
     * @param ignorePolicy the ignore policy
     * @return the int
     * @see cn.featherfly.juorm.Juorm#update(java.lang.Object,
     *      cn.featherfly.juorm.Juorm.IgnorePolicy)
     */
    @Override
    public <E> int update(E entity, IgnorePolicy ignorePolicy) {
        return juorm.update(entity, ignorePolicy);
    }

    /**
     * Update.
     *
     * @param <E>          the element type
     * @param entities     the entities
     * @param ignorePolicy the ignore policy
     * @return the int
     * @see cn.featherfly.juorm.Juorm#update(java.util.List,
     *      cn.featherfly.juorm.Juorm.IgnorePolicy)
     */
    @Override
    public <E> int update(List<E> entities, IgnorePolicy ignorePolicy) {
        return juorm.update(entities, ignorePolicy);
    }

    /**
     * Merge.
     *
     * @param <E>    the element type
     * @param entity the entity
     * @return the int
     * @see cn.featherfly.juorm.Juorm#merge(java.lang.Object)
     */
    @Override
    public <E> int merge(E entity) {
        return juorm.merge(entity);
    }

    /**
     * Merge.
     *
     * @param <E>      the element type
     * @param entities the entities
     * @return the int
     * @see cn.featherfly.juorm.Juorm#merge(java.util.List)
     */
    @Override
    public <E> int merge(List<E> entities) {
        return juorm.merge(entities);
    }

    /**
     * Delete.
     *
     * @param <E>    the element type
     * @param entity the entity
     * @return the int
     * @see cn.featherfly.juorm.Juorm#delete(java.lang.Object)
     */
    @Override
    public <E> int delete(E entity) {
        return juorm.delete(entity);
    }

    /**
     * Delete.
     *
     * @param <E>      the element type
     * @param entities the entities
     * @return the int
     * @see cn.featherfly.juorm.Juorm#delete(java.util.List)
     */
    @Override
    public <E> int delete(List<E> entities) {
        return juorm.delete(entities);
    }

    /**
     * Gets the.
     *
     * @param <E>  the element type
     * @param id   the id
     * @param type the type
     * @return the e
     * @see cn.featherfly.juorm.Juorm#get(java.io.Serializable, java.lang.Class)
     */
    @Override
    public <E> E get(Serializable id, Class<E> type) {
        return juorm.get(id, type);
    }

    /**
     * Gets the.
     *
     * @param <E>    the element type
     * @param entity the entity
     * @return the e
     * @see cn.featherfly.juorm.Juorm#get(java.lang.Object)
     */
    @Override
    public <E> E get(E entity) {
        return juorm.get(entity);
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
    public <E> TypeQueryEntity query(Class<E> entityType) {
        return juorm.query(entityType);
    }

    /**
     * Update.
     *
     * @param <E>        the element type
     * @param entityType the entity type
     * @return the update
     * @see cn.featherfly.juorm.Juorm#update(java.lang.Class)
     */
    @Override
    public <E> Update update(Class<E> entityType) {
        return juorm.update(entityType);
    }

    /**
     * Delete.
     *
     * @param <E>        the element type
     * @param entityType the entity type
     * @return the delete
     * @see cn.featherfly.juorm.Juorm#delete(java.lang.Class)
     */
    @Override
    public <E> Delete delete(Class<E> entityType) {
        return juorm.delete(entityType);
    }

    /**
     * Single.
     *
     * @param <E>          the element type
     * @param tplExecuteId the tpl execute id
     * @param entityType   the entity type
     * @param params       the params
     * @return the e
     * @see cn.featherfly.juorm.Juorm#single(java.lang.String, java.lang.Class,
     *      java.util.Map)
     */
    @Override
    public <E> E single(String tplExecuteId, Class<E> entityType, Map<String, Object> params) {
        return juorm.single(tplExecuteId, entityType, params);
    }

    /**
     * List.
     *
     * @param <E>          the element type
     * @param tplExecuteId the tpl execute id
     * @param entityType   the entity type
     * @param params       the params
     * @return the list
     * @see cn.featherfly.juorm.Juorm#list(java.lang.String, java.lang.Class,
     *      java.util.Map)
     */
    @Override
    public <E> List<E> list(String tplExecuteId, Class<E> entityType, Map<String, Object> params) {
        return juorm.list(tplExecuteId, entityType, params);
    }

    /**
     * List.
     *
     * @param <E>          the element type
     * @param tplExecuteId the tpl execute id
     * @param entityType   the entity type
     * @param params       the params
     * @param offset       the offset
     * @param limit        the limit
     * @return the list
     * @see cn.featherfly.juorm.Juorm#list(java.lang.String, java.lang.Class,
     *      java.util.Map, int, int)
     */
    @Override
    public <E> List<E> list(String tplExecuteId, Class<E> entityType, Map<String, Object> params, int offset,
            int limit) {
        return juorm.list(tplExecuteId, entityType, params, offset, limit);
    }

    /**
     * List.
     *
     * @param <E>          the element type
     * @param tplExecuteId the tpl execute id
     * @param entityType   the entity type
     * @param params       the params
     * @param page         the page
     * @return the list
     * @see cn.featherfly.juorm.Juorm#list(java.lang.String, java.lang.Class,
     *      java.util.Map, cn.featherfly.common.structure.page.Page)
     */
    @Override
    public <E> List<E> list(String tplExecuteId, Class<E> entityType, Map<String, Object> params, Page page) {
        return juorm.list(tplExecuteId, entityType, params, page);
    }

    /**
     * Pagination.
     *
     * @param <E>          the element type
     * @param tplExecuteId the tpl execute id
     * @param entityType   the entity type
     * @param params       the params
     * @param offset       the offset
     * @param limit        the limit
     * @return the pagination results
     * @see cn.featherfly.juorm.Juorm#pagination(java.lang.String,
     *      java.lang.Class, java.util.Map, int, int)
     */
    @Override
    public <E> PaginationResults<E> pagination(String tplExecuteId, Class<E> entityType, Map<String, Object> params,
            int offset, int limit) {
        return juorm.pagination(tplExecuteId, entityType, params, offset, limit);
    }

    /**
     * Pagination.
     *
     * @param <E>          the element type
     * @param tplExecuteId the tpl execute id
     * @param entityType   the entity type
     * @param params       the params
     * @param page         the page
     * @return the pagination results
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
     * Single.
     *
     * @param <E>          the element type
     * @param tplExecuteId the tpl execute id
     * @param entityType   the entity type
     * @param params       the params
     * @return the e
     * @see cn.featherfly.juorm.Juorm#single(cn.featherfly.juorm.tpl.TplExecuteId,
     *      java.lang.Class, java.util.Map)
     */
    @Override
    public <E> E single(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params) {
        return juorm.single(tplExecuteId, entityType, params);
    }

    /**
     * List.
     *
     * @param <E>          the element type
     * @param tplExecuteId the tpl execute id
     * @param entityType   the entity type
     * @param params       the params
     * @return the list
     * @see cn.featherfly.juorm.Juorm#list(cn.featherfly.juorm.tpl.TplExecuteId,
     *      java.lang.Class, java.util.Map)
     */
    @Override
    public <E> List<E> list(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params) {
        return juorm.list(tplExecuteId, entityType, params);
    }

    /**
     * List.
     *
     * @param <E>          the element type
     * @param tplExecuteId the tpl execute id
     * @param entityType   the entity type
     * @param params       the params
     * @param offset       the offset
     * @param limit        the limit
     * @return the list
     * @see cn.featherfly.juorm.Juorm#list(cn.featherfly.juorm.tpl.TplExecuteId,
     *      java.lang.Class, java.util.Map, int, int)
     */
    @Override
    public <E> List<E> list(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params, int offset,
            int limit) {
        return juorm.list(tplExecuteId, entityType, params, offset, limit);
    }

    /**
     * List.
     *
     * @param <E>          the element type
     * @param tplExecuteId the tpl execute id
     * @param entityType   the entity type
     * @param params       the params
     * @param page         the page
     * @return the list
     * @see cn.featherfly.juorm.Juorm#list(cn.featherfly.juorm.tpl.TplExecuteId,
     *      java.lang.Class, java.util.Map,
     *      cn.featherfly.common.structure.page.Page)
     */
    @Override
    public <E> List<E> list(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params, Page page) {
        return juorm.list(tplExecuteId, entityType, params, page);
    }

    /**
     * Pagination.
     *
     * @param <E>          the element type
     * @param tplExecuteId the tpl execute id
     * @param entityType   the entity type
     * @param params       the params
     * @param offset       the offset
     * @param limit        the limit
     * @return the pagination results
     * @see cn.featherfly.juorm.Juorm#pagination(cn.featherfly.juorm.tpl.TplExecuteId,
     *      java.lang.Class, java.util.Map, int, int)
     */
    @Override
    public <E> PaginationResults<E> pagination(TplExecuteId tplExecuteId, Class<E> entityType,
            Map<String, Object> params, int offset, int limit) {
        return juorm.pagination(tplExecuteId, entityType, params, offset, limit);
    }

    /**
     * Pagination.
     *
     * @param <E>          the element type
     * @param tplExecuteId the tpl execute id
     * @param entityType   the entity type
     * @param params       the params
     * @param page         the page
     * @return the pagination results
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
     * Single.
     *
     * @param tplExecuteId the tpl execute id
     * @param params       the params
     * @return the map
     * @see cn.featherfly.juorm.Juorm#single(java.lang.String, java.util.Map)
     */
    @Override
    public Map<String, Object> single(String tplExecuteId, Map<String, Object> params) {
        return juorm.single(tplExecuteId, params);
    }

    /**
     * Single.
     *
     * @param tplExecuteId the tpl execute id
     * @param params       the params
     * @return the map
     * @see cn.featherfly.juorm.Juorm#single(cn.featherfly.juorm.tpl.TplExecuteId,
     *      java.util.Map)
     */
    @Override
    public Map<String, Object> single(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return juorm.single(tplExecuteId, params);
    }

    /**
     * List.
     *
     * @param tplExecuteId the tpl execute id
     * @param params       the params
     * @return the list
     * @see cn.featherfly.juorm.Juorm#list(java.lang.String, java.util.Map)
     */
    @Override
    public List<Map<String, Object>> list(String tplExecuteId, Map<String, Object> params) {
        return juorm.list(tplExecuteId, params);
    }

    /**
     * List.
     *
     * @param tplExecuteId the tpl execute id
     * @param params       the params
     * @return the list
     * @see cn.featherfly.juorm.Juorm#list(cn.featherfly.juorm.tpl.TplExecuteId,
     *      java.util.Map)
     */
    @Override
    public List<Map<String, Object>> list(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return juorm.list(tplExecuteId, params);
    }

    /**
     * List.
     *
     * @param tplExecuteId the tpl execute id
     * @param params       the params
     * @param offset       the offset
     * @param limit        the limit
     * @return the list
     * @see cn.featherfly.juorm.Juorm#list(java.lang.String, java.util.Map, int,
     *      int)
     */
    @Override
    public List<Map<String, Object>> list(String tplExecuteId, Map<String, Object> params, int offset, int limit) {
        return juorm.list(tplExecuteId, params, offset, limit);
    }

    /**
     * List.
     *
     * @param tplExecuteId the tpl execute id
     * @param params       the params
     * @param offset       the offset
     * @param limit        the limit
     * @return the list
     * @see cn.featherfly.juorm.Juorm#list(cn.featherfly.juorm.tpl.TplExecuteId,
     *      java.util.Map, int, int)
     */
    @Override
    public List<Map<String, Object>> list(TplExecuteId tplExecuteId, Map<String, Object> params, int offset,
            int limit) {
        return juorm.list(tplExecuteId, params, offset, limit);
    }

    /**
     * List.
     *
     * @param tplExecuteId the tpl execute id
     * @param params       the params
     * @param page         the page
     * @return the list
     * @see cn.featherfly.juorm.Juorm#list(java.lang.String, java.util.Map,
     *      cn.featherfly.common.structure.page.Page)
     */
    @Override
    public List<Map<String, Object>> list(String tplExecuteId, Map<String, Object> params, Page page) {
        return juorm.list(tplExecuteId, params, page);
    }

    /**
     * List.
     *
     * @param tplExecuteId the tpl execute id
     * @param params       the params
     * @param page         the page
     * @return the list
     * @see cn.featherfly.juorm.Juorm#list(cn.featherfly.juorm.tpl.TplExecuteId,
     *      java.util.Map, cn.featherfly.common.structure.page.Page)
     */
    @Override
    public List<Map<String, Object>> list(TplExecuteId tplExecuteId, Map<String, Object> params, Page page) {
        return juorm.list(tplExecuteId, params, page);
    }

    /**
     * Pagination.
     *
     * @param tplExecuteId the tpl execute id
     * @param params       the params
     * @param offset       the offset
     * @param limit        the limit
     * @return the pagination results
     * @see cn.featherfly.juorm.Juorm#pagination(java.lang.String,
     *      java.util.Map, int, int)
     */
    @Override
    public PaginationResults<Map<String, Object>> pagination(String tplExecuteId, Map<String, Object> params,
            int offset, int limit) {
        return juorm.pagination(tplExecuteId, params, offset, limit);
    }

    /**
     * Pagination.
     *
     * @param tplExecuteId the tpl execute id
     * @param params       the params
     * @param offset       the offset
     * @param limit        the limit
     * @return the pagination results
     * @see cn.featherfly.juorm.Juorm#pagination(cn.featherfly.juorm.tpl.TplExecuteId,
     *      java.util.Map, int, int)
     */
    @Override
    public PaginationResults<Map<String, Object>> pagination(TplExecuteId tplExecuteId, Map<String, Object> params,
            int offset, int limit) {
        return juorm.pagination(tplExecuteId, params, offset, limit);
    }

    /**
     * Pagination.
     *
     * @param tplExecuteId the tpl execute id
     * @param params       the params
     * @param page         the page
     * @return the pagination results
     * @see cn.featherfly.juorm.Juorm#pagination(java.lang.String,
     *      java.util.Map, cn.featherfly.common.structure.page.Page)
     */
    @Override
    public PaginationResults<Map<String, Object>> pagination(String tplExecuteId, Map<String, Object> params,
            Page page) {
        return juorm.pagination(tplExecuteId, params, page);
    }

    /**
     * Pagination.
     *
     * @param tplExecuteId the tpl execute id
     * @param params       the params
     * @param page         the page
     * @return the pagination results
     * @see cn.featherfly.juorm.Juorm#pagination(cn.featherfly.juorm.tpl.TplExecuteId,
     *      java.util.Map, cn.featherfly.common.structure.page.Page)
     */
    @Override
    public PaginationResults<Map<String, Object>> pagination(TplExecuteId tplExecuteId, Map<String, Object> params,
            Page page) {
        return juorm.pagination(tplExecuteId, params, page);
    }

    /**
     * Value.
     *
     * @param <E>          the element type
     * @param tplExecuteId the tpl execute id
     * @param valueType    the value type
     * @param params       the params
     * @return the e
     * @see cn.featherfly.juorm.Juorm#value(java.lang.String, java.lang.Class,
     *      java.util.Map)
     */
    @Override
    public <E> E value(String tplExecuteId, Class<E> valueType, Map<String, Object> params) {
        return juorm.value(tplExecuteId, valueType, params);
    }

    /**
     * Number.
     *
     * @param <N>          the number type
     * @param tplExecuteId the tpl execute id
     * @param numberType   the number type
     * @param params       the params
     * @return the n
     * @see cn.featherfly.juorm.Juorm#number(java.lang.String, java.lang.Class,
     *      java.util.Map)
     */
    @Override
    public <N extends Number> N number(String tplExecuteId, Class<N> numberType, Map<String, Object> params) {
        return juorm.number(tplExecuteId, numberType, params);
    }

    /**
     * Int value.
     *
     * @param tplExecuteId the tpl execute id
     * @param params       the params
     * @return the integer
     * @see cn.featherfly.juorm.Juorm#intValue(java.lang.String, java.util.Map)
     */
    @Override
    public Integer intValue(String tplExecuteId, Map<String, Object> params) {
        return juorm.intValue(tplExecuteId, params);
    }

    /**
     * Long value.
     *
     * @param tplExecuteId the tpl execute id
     * @param params       the params
     * @return the long
     * @see cn.featherfly.juorm.Juorm#longValue(java.lang.String, java.util.Map)
     */
    @Override
    public Long longValue(String tplExecuteId, Map<String, Object> params) {
        return juorm.longValue(tplExecuteId, params);
    }

    /**
     * Big decimal value.
     *
     * @param tplExecuteId the tpl execute id
     * @param params       the params
     * @return the big decimal
     * @see cn.featherfly.juorm.Juorm#bigDecimalValue(java.lang.String,
     *      java.util.Map)
     */
    @Override
    public BigDecimal bigDecimalValue(String tplExecuteId, Map<String, Object> params) {
        return juorm.bigDecimalValue(tplExecuteId, params);
    }

    /**
     * Double value.
     *
     * @param tplExecuteId the tpl execute id
     * @param params       the params
     * @return the double
     * @see cn.featherfly.juorm.Juorm#doubleValue(java.lang.String,
     *      java.util.Map)
     */
    @Override
    public Double doubleValue(String tplExecuteId, Map<String, Object> params) {
        return juorm.doubleValue(tplExecuteId, params);
    }

    /**
     * String value.
     *
     * @param tplExecuteId the tpl execute id
     * @param params       the params
     * @return the string
     * @see cn.featherfly.juorm.Juorm#stringValue(java.lang.String,
     *      java.util.Map)
     */
    @Override
    public String stringValue(String tplExecuteId, Map<String, Object> params) {
        return juorm.stringValue(tplExecuteId, params);
    }

}
