
package cn.featherfly.hammer.tpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import cn.featherfly.common.structure.page.Page;
import cn.featherfly.common.structure.page.PaginationResults;

/**
 * TplExecutor.
 *
 * @author zhongj
 */
public interface TplExecutor {
    /**
     * execute.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return executed success size
     */
    int execute(String tplExecuteId, Map<String, Object> params);

    /**
     * execute.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return executed success size
     */
    int execute(TplExecuteId tplExecuteId, Map<String, Object> params);

    /**
     * query int value, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return int
     */
    int intValue(String tplExecuteId, Map<String, Object> params);

    /**
     * query int value, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return int
     */
    int intValue(TplExecuteId tplExecuteId, Map<String, Object> params);

    /**
     * query long value, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return long
     */
    long longValue(String tplExecuteId, Map<String, Object> params);

    /**
     * query long value, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return long
     */
    long longValue(TplExecuteId tplExecuteId, Map<String, Object> params);

    /**
     * query double value, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return double
     */
    double doubleValue(String tplExecuteId, Map<String, Object> params);

    /**
     * query double value, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return double
     */
    double doubleValue(TplExecuteId tplExecuteId, Map<String, Object> params);

    /**
     * query value, use query str in template find with executeId.
     *
     * @param <E>          value type
     * @param tplExecuteId tpl execute id
     * @param valueType    valueType
     * @param params       params
     * @return value
     */
    <E> E value(String tplExecuteId, Class<E> valueType, Map<String, Object> params);

    /**
     * query value, use query str in template find with executeId.
     *
     * @param <E>          value type
     * @param tplExecuteId tpl execute id
     * @param valueType    valueType
     * @param params       params
     * @return value
     */
    <E> E value(TplExecuteId tplExecuteId, Class<E> valueType, Map<String, Object> params);

    /**
     * query number value, use query str in template find with executeId.
     *
     * @param <N>          number type
     * @param tplExecuteId tpl execute id
     * @param numberType   numberType
     * @param params       params
     * @return number value
     */
    <N extends Number> N number(String tplExecuteId, Class<N> numberType, Map<String, Object> params);

    /**
     * query number value, use query str in template find with executeId.
     *
     * @param <N>          number type
     * @param tplExecuteId tpl execute id
     * @param numberType   numberType
     * @param params       params
     * @return number value
     */
    <N extends Number> N number(TplExecuteId tplExecuteId, Class<N> numberType, Map<String, Object> params);

    /**
     * query int value, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return Integer
     */
    Integer numberInt(String tplExecuteId, Map<String, Object> params);

    /**
     * query int value, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return Integer
     */
    Integer numberInt(TplExecuteId tplExecuteId, Map<String, Object> params);

    /**
     * query long value, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return Long
     */
    Long numberLong(String tplExecuteId, Map<String, Object> params);

    /**
     * query long value, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return Long
     */
    Long numberLong(TplExecuteId tplExecuteId, Map<String, Object> params);

    /**
     * query bigDecimal value, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return BigDecimal
     */
    BigDecimal numberBigDecimal(String tplExecuteId, Map<String, Object> params);

    /**
     * query bigDecimal value, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return BigDecimal
     */
    BigDecimal numberBigDecimal(TplExecuteId tplExecuteId, Map<String, Object> params);

    /**
     * query double value, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return BigDecimal
     */
    Double numberDouble(String tplExecuteId, Map<String, Object> params);

    /**
     * query double value, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return BigDecimal
     */
    Double numberDouble(TplExecuteId tplExecuteId, Map<String, Object> params);

    /**
     * query string value, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return String
     */
    String string(String tplExecuteId, Map<String, Object> params);

    /**
     * query string value, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return String
     */
    String string(TplExecuteId tplExecuteId, Map<String, Object> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return map
     */
    Map<String, Object> single(String tplExecuteId, Map<String, Object> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return map
     */
    Map<String, Object> single(TplExecuteId tplExecuteId, Map<String, Object> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <E>          entity type
     * @param tplExecuteId tpl execute id
     * @param entityType   entityType
     * @param params       params
     * @return entity
     */
    <E> E single(String tplExecuteId, Class<E> entityType, Map<String, Object> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <E>          entity type
     * @param tplExecuteId tpl execute id
     * @param entityType   entityType
     * @param params       params
     * @return list
     */
    <E> E single(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params);

    /**
     * query list, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return map list
     */
    List<Map<String, Object>> list(String tplExecuteId, Map<String, Object> params);

    /**
     * query list, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return map list
     */
    List<Map<String, Object>> list(TplExecuteId tplExecuteId, Map<String, Object> params);

    /**
     * query list, use query str in template find with executeId.
     *
     * @param <E>          entity type
     * @param tplExecuteId tpl execute id
     * @param entityType   entityType
     * @param params       params
     * @return entity list
     */
    <E> List<E> list(String tplExecuteId, Class<E> entityType, Map<String, Object> params);

    /**
     * query list, use query str in template find with executeId.
     *
     * @param <E>          entity type
     * @param tplExecuteId tpl execute id
     * @param entityType   entityType
     * @param params       params
     * @return entity list
     */
    <E> List<E> list(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params);

    /**
     * query list, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @param offset       paging start with offset
     * @param limit        paging end with limit
     * @return map list
     */
    List<Map<String, Object>> list(String tplExecuteId, Map<String, Object> params, int offset, int limit);

    /**
     * query list, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @param offset       paging start with offset
     * @param limit        paging end with limit
     * @return map list
     */
    List<Map<String, Object>> list(TplExecuteId tplExecuteId, Map<String, Object> params, int offset, int limit);

    /**
     * query list, use query str in template find with executeId.
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
     * query list, use query str in template find with executeId.
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
     * query list, use query str in template find with executeId.
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
     * query list, use query str in template find with executeId.
     *
     * @param <E>          entity type
     * @param tplExecuteId tpl execute id
     * @param entityType   entityType
     * @param params       params
     * @param page         page
     * @return entity list
     */
    <E> List<E> list(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params, Page page);

    /**
     * query list, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @param page         page
     * @return map list
     */
    List<Map<String, Object>> list(String tplExecuteId, Map<String, Object> params, Page page);

    /**
     * query list, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @param page         page
     * @return map list
     */
    List<Map<String, Object>> list(TplExecuteId tplExecuteId, Map<String, Object> params, Page page);

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
     * query page, use query str in template find with executeId.
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
     * query page, use query str in template find with executeId.
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
     * query page, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @param page         page
     * @return map pagination
     */
    PaginationResults<Map<String, Object>> pagination(String tplExecuteId, Map<String, Object> params, Page page);

    /**
     * query page, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @param page         page
     * @return map pagination
     */
    PaginationResults<Map<String, Object>> pagination(TplExecuteId tplExecuteId, Map<String, Object> params, Page page);

    /**
     * query page, use query str in template find with executeId.
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
     * query page, use query str in template find with executeId.
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
     * query page, use query str in template find with executeId.
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
     * query page, use query str in template find with executeId.
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
