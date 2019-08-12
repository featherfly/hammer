
package cn.featherfly.juorm.tpl;

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
     * query single, user query str in template find with strId
     * </p>
     *
     * @param <E>          entity type
     * @param tplExecuteId tpl execute id
     * @param entityType   entityType
     * @param params       params
     * @return list
     */
    <E> E single(String tplExecuteId, Class<E> entityType, Map<String, Object> params);

    /**
     * <p>
     * query single, user query str in template find with strId
     * </p>
     *
     * @param <E>          entity type
     * @param tplExecuteId tpl execute id
     * @param entityType   entityType
     * @param params       params
     * @return list
     */
    <E> E single(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params);

    //    /**
    //     * <p>
    //     * query single, user query str in template find with strId
    //     * </p>
    //     *
    //     * @param <E>
    //     * @param strId      strId
    //     * @param entityType entityType
    //     * @param params     params
    //     * @return list
    //     */
    //    <E> E single(String strId, Class<E> entityType, Object params);

    /**
     * <p>
     * query list, user query str in template find with strId
     * </p>
     *
     * @param <E>          entity type
     * @param tplExecuteId tpl execute id
     * @param entityType   entityType
     * @param params       params
     * @return list
     */
    <E> List<E> list(String tplExecuteId, Class<E> entityType, Map<String, Object> params);

    /**
     * <p>
     * query list, user query str in template find with strId
     * </p>
     *
     * @param <E>          entity type
     * @param tplExecuteId tpl execute id
     * @param entityType   entityType
     * @param params       params
     * @return list
     */
    <E> List<E> list(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params);

    /**
     * <p>
     * query list, user query str in template find with strId
     * </p>
     *
     * @param <E>          entity type
     * @param tplExecuteId tpl execute id
     * @param entityType   entityType
     * @param params       params
     * @param offset       paging start with offset
     * @param limit        paging end with limit
     * @return list
     */
    <E> List<E> list(String tplExecuteId, Class<E> entityType, Map<String, Object> params, int offset, int limit);

    /**
     * <p>
     * query list, user query str in template find with strId
     * </p>
     *
     * @param <E>          entity type
     * @param tplExecuteId tpl execute id
     * @param entityType   entityType
     * @param params       params
     * @param offset       paging start with offset
     * @param limit        paging end with limit
     * @return list
     */
    <E> List<E> list(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params, int offset, int limit);

    /**
     * <p>
     * query list, user query str in template find with strId
     * </p>
     *
     * @param <E>          entity type
     * @param tplExecuteId tpl execute id
     * @param entityType   entityType
     * @param params       params
     * @param page         page
     * @return list
     */
    <E> List<E> list(String tplExecuteId, Class<E> entityType, Map<String, Object> params, Page page);

    /**
     * <p>
     * query list, user query str in template find with strId
     * </p>
     *
     * @param <E>          entity type
     * @param tplExecuteId tpl execute id
     * @param entityType   entityType
     * @param params       params
     * @param page         page
     * @return list
     */
    <E> List<E> list(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params, Page page);

    //    /**
    //     * <p>
    //     * query list, user query str in template find with strId
    //     * </p>
    //     *
    //     * @param <E>
    //     * @param strId      strId
    //     * @param entityType entityType
    //     * @param params     params
    //     * @return list
    //     */
    //    <E> List<E> list(String strId, Class<E> entityType, Object params);
    //
    //    /**
    //     * <p>
    //     * query list, user query str in template find with strId
    //     * </p>
    //     *
    //     * @param <E>
    //     * @param strId      strId
    //     * @param entityType entityType
    //     * @param params     params
    //     * @param paging     ispaging
    //     * @return list
    //     */
    //    <E> List<E> list(String strId, Class<E> entityType, Object params, boolean paging);

    //    /**
    //     * <p>
    //     * query list, user query str in template find with strId
    //     * </p>
    //     *
    //     * @param <E>
    //     * @param strId      strId
    //     * @param entityType entityType
    //     * @param params     params
    //     * @return list
    //     */
    //    <E> PaginationResults<E> pagination(String strId, Class<E> entityType, Object params);

    /**
     * <p>
     * query list, user query str in template find with strId
     * </p>
     *
     * @param <E>          entity type
     * @param tplExecuteId tpl execute id
     * @param entityType   entityType
     * @param params       params
     * @param offset       paging start with offset
     * @param limit        paging end with limit
     * @return list
     */
    <E> PaginationResults<E> pagination(String tplExecuteId, Class<E> entityType, Map<String, Object> params,
            int offset, int limit);

    /**
     * <p>
     * query list, user query str in template find with strId
     * </p>
     *
     * @param <E>          entity type
     * @param tplExecuteId tpl execute id
     * @param entityType   entityType
     * @param params       params
     * @param offset       paging start with offset
     * @param limit        paging end with limit
     * @return list
     */
    <E> PaginationResults<E> pagination(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params,
            int offset, int limit);

    /**
     * <p>
     * query list, user query str in template find with strId
     * </p>
     *
     * @param <E>          entity type
     * @param tplExecuteId tpl execute id
     * @param entityType   entityType
     * @param params       params
     * @param page         page
     * @return list
     */
    <E> PaginationResults<E> pagination(String tplExecuteId, Class<E> entityType, Map<String, Object> params,
            Page page);

    /**
     * <p>
     * query list, user query str in template find with strId
     * </p>
     *
     * @param <E>          entity type
     * @param tplExecuteId tpl execute id
     * @param entityType   entityType
     * @param params       params
     * @param page         page
     * @return list
     */
    <E> PaginationResults<E> pagination(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params,
            Page page);
}
