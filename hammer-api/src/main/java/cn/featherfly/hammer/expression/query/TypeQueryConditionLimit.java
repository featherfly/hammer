
package cn.featherfly.hammer.expression.query;

import cn.featherfly.common.structure.page.Page;

/**
 * <p>
 * limit condition
 * </p>
 *
 * @author zhongj
 */
public interface TypeQueryConditionLimit {
    /**
     * limit
     *
     * @param limit limit rows
     * @return TypeQueryExecutor
     */
    TypeQueryLimitExecutor limit(Integer limit);

    /**
     * limit
     *
     * @param offset start index offset
     * @param limit  limit rows
     * @return TypeQueryExecutor
     */
    TypeQueryLimitExecutor limit(Integer offset, Integer limit);

    /**
     * limit
     *
     * @param page params for pagination
     * @return TypeQueryExecutor
     */
    TypeQueryLimitExecutor limit(Page page);
}
