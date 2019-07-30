
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
     * query single, use sql in template find with sqlId
     * </p>
     *
     * @param <E>
     * @param sqlFullId  sql full id
     * @param entityType entityType
     * @param params     params
     * @return list
     */
    <E> E single(String sqlFullId, Class<E> entityType, Map<String, Object> params);

    //    /**
    //     * <p>
    //     * query single, use sql in template find with sqlId
    //     * </p>
    //     *
    //     * @param <E>
    //     * @param sqlId      sqlId
    //     * @param entityType entityType
    //     * @param params     params
    //     * @return list
    //     */
    //    <E> E single(String sqlId, Class<E> entityType, Object params);

    /**
     * <p>
     * query list, use sql in template find with sqlId
     * </p>
     *
     * @param <E>
     * @param sqlFullId  sql full id
     * @param entityType entityType
     * @param params     params
     * @return list
     */
    <E> List<E> list(String sqlFullId, Class<E> entityType, Map<String, Object> params);

    /**
     * <p>
     * query list, use sql in template find with sqlId
     * </p>
     *
     * @param <E>
     * @param sqlFullId  sql full id
     * @param entityType entityType
     * @param params     params
     * @param offset     paging start with offset
     * @param limit      paging end with limit
     * @return list
     */
    <E> List<E> list(String sqlFullId, Class<E> entityType, Map<String, Object> params, int offset, int limit);

    /**
     * <p>
     * query list, use sql in template find with sqlId
     * </p>
     *
     * @param <E>
     * @param sqlFullId  sql full id
     * @param entityType entityType
     * @param params     params
     * @param page       page
     * @return list
     */
    <E> List<E> list(String sqlFullId, Class<E> entityType, Map<String, Object> params, Page page);

    //    /**
    //     * <p>
    //     * query list, use sql in template find with sqlId
    //     * </p>
    //     *
    //     * @param <E>
    //     * @param sqlId      sqlId
    //     * @param entityType entityType
    //     * @param params     params
    //     * @return list
    //     */
    //    <E> List<E> list(String sqlId, Class<E> entityType, Object params);
    //
    //    /**
    //     * <p>
    //     * query list, use sql in template find with sqlId
    //     * </p>
    //     *
    //     * @param <E>
    //     * @param sqlId      sqlId
    //     * @param entityType entityType
    //     * @param params     params
    //     * @param paging     ispaging
    //     * @return list
    //     */
    //    <E> List<E> list(String sqlId, Class<E> entityType, Object params, boolean paging);

    //    /**
    //     * <p>
    //     * query list, use sql in template find with sqlId
    //     * </p>
    //     *
    //     * @param <E>
    //     * @param sqlId      sqlId
    //     * @param entityType entityType
    //     * @param params     params
    //     * @return list
    //     */
    //    <E> PaginationResults<E> pagination(String sqlId, Class<E> entityType, Object params);

    /**
     * <p>
     * query list, use sql in template find with sqlId
     * </p>
     *
     * @param <E>
     * @param sqlFullId  sql full id
     * @param entityType entityType
     * @param params     params
     * @param offset     paging start with offset
     * @param limit      paging end with limit
     * @return list
     */
    <E> PaginationResults<E> pagination(String sqlFullId, Class<E> entityType, Map<String, Object> params, int offset,
            int limit);

    /**
     * <p>
     * query list, use sql in template find with sqlId
     * </p>
     *
     * @param <E>
     * @param sqlFullId  sql full id
     * @param entityType entityType
     * @param params     params
     * @param page       page
     * @return list
     */
    <E> PaginationResults<E> pagination(String sqlFullId, Class<E> entityType, Map<String, Object> params, Page page);
}
