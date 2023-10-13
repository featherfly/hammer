
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.Page;

/**
 * type query limit condition.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface EntityQueryConditionLimit<E> {

    /**
     * limit.
     *
     * @param limit limit rows
     * @return EntityQueryLimitExecutor
     */
    default EntityQueryLimitExecutor<E> limit(Integer limit) {
        return limit(0, limit);
    }

    /**
     * limit.
     *
     * @param offset start index offset
     * @param limit  limit rows
     * @return EntityQueryLimitExecutor
     */
    default EntityQueryLimitExecutor<E> limit(Integer offset, Integer limit) {
        return limit(new Limit(offset, limit));
    }

    /**
     * limit.
     *
     * @param page params for pagination
     * @return EntityQueryLimitExecutor
     */
    default EntityQueryLimitExecutor<E> limit(Page page) {
        return limit(new Limit(page));
    }

    /**
     * Limit.
     *
     * @param limit the limit
     * @return EntityQueryLimitExecutor
     */
    EntityQueryLimitExecutor<E> limit(Limit limit);
}
