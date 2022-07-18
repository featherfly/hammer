
package cn.featherfly.hammer.expression.query;

import cn.featherfly.common.structure.page.Page;

/**
 * limit condition.
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
    QueryLimitExecutor limit(Integer limit);

    /**
     * limit
     *
     * @param offset start index offset
     * @param limit  limit rows
     * @return QueryExecutor
     */
    QueryLimitExecutor limit(Integer offset, Integer limit);

    /**
     * limit
     *
     * @param page params for pagination
     * @return QueryExecutor
     */
    QueryLimitExecutor limit(Page page);
}
