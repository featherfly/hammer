
package cn.featherfly.juorm.tpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import cn.featherfly.common.structure.page.Page;
import cn.featherfly.common.structure.page.PaginationResults;

/**
 * <p>
 * TplExecutor
 * </p>
 *
 * @author zhongj
 */
public interface TplExecutor {

    /**
     * <p>
     * query single, use query str in template find with executeId
     * </p>
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return map
     */
    Map<String, Object> single(String tplExecuteId, Map<String, Object> params);

    /**
     * <p>
     * query single, use query str in template find with executeId
     * </p>
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return map
     */
    Map<String, Object> single(TplExecuteId tplExecuteId, Map<String, Object> params);

    /**
     * <p>
     * query single, use query str in template find with executeId
     * </p>
     *
     * @param <E>          entity type
     * @param tplExecuteId tpl execute id
     * @param entityType   entityType
     * @param params       params
     * @return entity
     */
    <E> E single(String tplExecuteId, Class<E> entityType, Map<String, Object> params);

    /**
     * <p>
     * query single, use query str in template find with executeId
     * </p>
     *
     * @param <E>          entity type
     * @param tplExecuteId tpl execute id
     * @param entityType   entityType
     * @param params       params
     * @return list
     */
    <E> E single(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params);

    /**
     * <p>
     * query value, use query str in template find with executeId
     * </p>
     *
     * @param <E>          value type
     * @param tplExecuteId tpl execute id
     * @param valueType    valueType
     * @param params       params
     * @return value
     */
    <E> E value(String tplExecuteId, Class<E> valueType, Map<String, Object> params);

    /**
     * <p>
     * query number value, use query str in template find with executeId
     * </p>
     *
     * @param <N>          number type
     * @param tplExecuteId tpl execute id
     * @param numberType   numberType
     * @param params       params
     * @return number value
     */
    <N extends Number> N number(String tplExecuteId, Class<N> numberType, Map<String, Object> params);

    /**
     * <p>
     * query int value, use query str in template find with executeId
     * </p>
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return Integer
     */
    Integer intValue(String tplExecuteId, Map<String, Object> params);

    /**
     * <p>
     * query long value, use query str in template find with executeId
     * </p>
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return Long
     */
    Long longValue(String tplExecuteId, Map<String, Object> params);

    /**
     * <p>
     * query bigDecimal value, use query str in template find with executeId
     * </p>
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return BigDecimal
     */
    BigDecimal bigDecimalValue(String tplExecuteId, Map<String, Object> params);

    /**
     * <p>
     * query double value, use query str in template find with executeId
     * </p>
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return BigDecimal
     */
    Double doubleValue(String tplExecuteId, Map<String, Object> params);

    /**
     * <p>
     * query string value, use query str in template find with executeId
     * </p>
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return String
     */
    String stringValue(String tplExecuteId, Map<String, Object> params);

    // /**
    // * <p>
    // * query single, use query str in template find with executeId
    // * </p>
    // *
    // * @param <E>
    // * @param executeId executeId
    // * @param entityType entityType
    // * @param params params
    // * @return list
    // */
    // <E> E single(String executeId, Class<E> entityType, Object params);

    /**
     * <p>
     * query list, use query str in template find with executeId
     * </p>
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return map list
     */
    List<Map<String, Object>> list(String tplExecuteId, Map<String, Object> params);

    /**
     * <p>
     * query list, use query str in template find with executeId
     * </p>
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return map list
     */
    List<Map<String, Object>> list(TplExecuteId tplExecuteId, Map<String, Object> params);

    /**
     * <p>
     * query list, use query str in template find with executeId
     * </p>
     *
     * @param <E>          entity type
     * @param tplExecuteId tpl execute id
     * @param entityType   entityType
     * @param params       params
     * @return entity list
     */
    <E> List<E> list(String tplExecuteId, Class<E> entityType, Map<String, Object> params);

    /**
     * <p>
     * query list, use query str in template find with executeId
     * </p>
     *
     * @param <E>          entity type
     * @param tplExecuteId tpl execute id
     * @param entityType   entityType
     * @param params       params
     * @return entity list
     */
    <E> List<E> list(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params);

    /**
     * <p>
     * query list, use query str in template find with executeId
     * </p>
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @param offset       paging start with offset
     * @param limit        paging end with limit
     * @return map list
     */
    List<Map<String, Object>> list(String tplExecuteId, Map<String, Object> params, int offset, int limit);

    /**
     * <p>
     * query list, use query str in template find with executeId
     * </p>
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @param offset       paging start with offset
     * @param limit        paging end with limit
     * @return map list
     */
    List<Map<String, Object>> list(TplExecuteId tplExecuteId, Map<String, Object> params, int offset, int limit);

    /**
     * <p>
     * query list, use query str in template find with executeId
     * </p>
     *
     * @param <E>          entity type
     * @param tplExecuteId tpl execute id
     * @param entityType   entityType
     * @param params       params
     * @param offset       paging start with offset
     * @param limit        paging end with limit
     * @return entity list
     */
    <E> List<E> list(String tplExecuteId, Class<E> entityType, Map<String, Object> params, int offset, int limit);

    /**
     * <p>
     * query list, use query str in template find with executeId
     * </p>
     *
     * @param <E>          entity type
     * @param tplExecuteId tpl execute id
     * @param entityType   entityType
     * @param params       params
     * @param offset       paging start with offset
     * @param limit        paging end with limit
     * @return entity list
     */
    <E> List<E> list(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params, int offset, int limit);

    /**
     * <p>
     * query list, use query str in template find with executeId
     * </p>
     *
     * @param <E>          entity type
     * @param tplExecuteId tpl execute id
     * @param entityType   entityType
     * @param params       params
     * @param page         page
     * @return entity list
     */
    <E> List<E> list(String tplExecuteId, Class<E> entityType, Map<String, Object> params, Page page);

    /**
     * <p>
     * query list, use query str in template find with executeId
     * </p>
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @param page         page
     * @return map list
     */
    List<Map<String, Object>> list(String tplExecuteId, Map<String, Object> params, Page page);

    /**
     * <p>
     * query list, use query str in template find with executeId
     * </p>
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @param page         page
     * @return map list
     */
    List<Map<String, Object>> list(TplExecuteId tplExecuteId, Map<String, Object> params, Page page);

    /**
     * <p>
     * query list, use query str in template find with executeId
     * </p>
     *
     * @param <E>          entity type
     * @param tplExecuteId tpl execute id
     * @param entityType   entityType
     * @param params       params
     * @param page         page
     * @return entity list
     */
    <E> List<E> list(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params, Page page);

    // /**
    // * <p>
    // * query list, use query str in template find with executeId
    // * </p>
    // *
    // * @param <E>
    // * @param executeId executeId
    // * @param entityType entityType
    // * @param params params
    // * @return list
    // */
    // <E> List<E> list(String executeId, Class<E> entityType, Object params);
    //
    // /**
    // * <p>
    // * query list, use query str in template find with executeId
    // * </p>
    // *
    // * @param <E>
    // * @param executeId executeId
    // * @param entityType entityType
    // * @param params params
    // * @param paging ispaging
    // * @return list
    // */
    // <E> List<E> list(String executeId, Class<E> entityType, Object params,
    // boolean paging);

    // /**
    // * <p>
    // * query list, use query str in template find with executeId
    // * </p>
    // *
    // * @param <E>
    // * @param executeId executeId
    // * @param entityType entityType
    // * @param params params
    // * @return list
    // */
    // <E> PaginationResults<E> pagination(String executeId, Class<E>
    // entityType,
    // Object params);

    /**
     * <p>
     * query page, use query str in template find with executeId
     * </p>
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @param offset       paging start with offset
     * @param limit        paging end with limit
     * @return map pagination
     */
    PaginationResults<Map<String, Object>> pagination(String tplExecuteId, Map<String, Object> params, int offset,
            int limit);

    /**
     * <p>
     * query page, use query str in template find with executeId
     * </p>
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @param offset       paging start with offset
     * @param limit        paging end with limit
     * @return map pagination
     */
    PaginationResults<Map<String, Object>> pagination(TplExecuteId tplExecuteId, Map<String, Object> params, int offset,
            int limit);

    /**
     * <p>
     * query page, use query str in template find with executeId
     * </p>
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @param page         page
     * @return map pagination
     */
    PaginationResults<Map<String, Object>> pagination(String tplExecuteId, Map<String, Object> params, Page page);

    /**
     * <p>
     * query page, use query str in template find with executeId
     * </p>
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @param page         page
     * @return map pagination
     */
    PaginationResults<Map<String, Object>> pagination(TplExecuteId tplExecuteId, Map<String, Object> params, Page page);

    /**
     * <p>
     * query page, use query str in template find with executeId
     * </p>
     *
     * @param <E>          entity type
     * @param tplExecuteId tpl execute id
     * @param entityType   entityType
     * @param params       params
     * @param offset       paging start with offset
     * @param limit        paging end with limit
     * @return entity pagination
     */
    <E> PaginationResults<E> pagination(String tplExecuteId, Class<E> entityType, Map<String, Object> params,
            int offset, int limit);

    /**
     * <p>
     * query page, use query str in template find with executeId
     * </p>
     *
     * @param <E>          entity type
     * @param tplExecuteId tpl execute id
     * @param entityType   entityType
     * @param params       params
     * @param offset       paging start with offset
     * @param limit        paging end with limit
     * @return entity pagination
     */
    <E> PaginationResults<E> pagination(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params,
            int offset, int limit);

    /**
     * <p>
     * query page, use query str in template find with executeId
     * </p>
     *
     * @param <E>          entity type
     * @param tplExecuteId tpl execute id
     * @param entityType   entityType
     * @param params       params
     * @param page         page
     * @return entity pagination
     */
    <E> PaginationResults<E> pagination(String tplExecuteId, Class<E> entityType, Map<String, Object> params,
            Page page);

    /**
     * <p>
     * query page, use query str in template find with executeId
     * </p>
     *
     * @param <E>          entity type
     * @param tplExecuteId tpl execute id
     * @param entityType   entityType
     * @param params       params
     * @param page         page
     * @return entity pagination
     */
    <E> PaginationResults<E> pagination(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params,
            Page page);
}
