
package cn.featherfly.juorm.expression.query;

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
