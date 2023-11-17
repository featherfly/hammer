
package cn.featherfly.hammer.expression.query;

import cn.featherfly.common.structure.page.Page;

/**
 * limit condition.
 *
 * @author zhongj
 */
public interface QueryValueConditionLimit {
    /**
     * limit
     *
     * @param limit limit rows
     * @return QueryExecutor
     */
    QueryValueLimitExecutor limit(Integer limit);

    /**
     * limit
     *
     * @param offset start index offset
     * @param limit  limit rows
     * @return QueryExecutor
     */
    QueryValueLimitExecutor limit(Integer offset, Integer limit);

    /**
     * limit
     *
     * @param page params for pagination
     * @return QueryExecutor
     */
    QueryValueLimitExecutor limit(Page page);
}
