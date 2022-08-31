
package cn.featherfly.hammer.expression.query;

import cn.featherfly.common.structure.page.Page;

/**
 * type query limit condition.
 *
 * @author zhongj
 */
public interface EntityQueryConditionLimit<E> {
    /**
     * limit
     *
     * @param limit limit rows
     * @return TypeQueryExecutor
     */
    EntityQueryLimitExecutor<E> limit(Integer limit);

    /**
     * limit
     *
     * @param offset start index offset
     * @param limit  limit rows
     * @return TypeQueryExecutor
     */
    EntityQueryLimitExecutor<E> limit(Integer offset, Integer limit);

    /**
     * limit
     *
     * @param page params for pagination
     * @return TypeQueryExecutor
     */
    EntityQueryLimitExecutor<E> limit(Page page);
}
