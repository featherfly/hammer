
package cn.featherfly.juorm.dsl.query;

import cn.featherfly.common.structure.page.Page;

/**
 * <p>
 * limit condition
 * </p>
 *
 * @author zhongj
 */
public interface QueryConditionLimit {
    /**
     * limit
     *
     * @param limit limit rows
     * @return QueryExecutor
     */
    QueryExecutor limit(Integer limit);

    /**
     * limit
     *
     * @param offset start index offset
     * @param limit  limit rows
     * @return QueryExecutor
     */
    QueryExecutor limit(Integer offset, Integer limit);

    /**
     * limit
     *
     * @param page params for pagination
     * @return QueryExecutor
     */
    QueryExecutor limit(Page page);
}
