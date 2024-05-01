
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.Page;

/**
 * type query limit condition.
 *
 * @author zhongj
 * @param <T> the generic type
 */
public interface EntityQueryConditionLimit<T> {

    /**
     * limit.
     *
     * @param limit limit rows
     * @return EntityQueryLimitExecutor
     */
    default T limit(Integer limit) {
        return limit(0, limit);
    }

    /**
     * limit.
     *
     * @param offset start index offset
     * @param limit  limit rows
     * @return EntityQueryLimitExecutor
     */
    default T limit(Integer offset, Integer limit) {
        return limit(new Limit(offset, limit));
    }

    /**
     * limit.
     *
     * @param page params for pagination
     * @return EntityQueryLimitExecutor
     */
    default T limit(Page page) {
        return limit(new Limit(page));
    }

    /**
     * Limit.
     *
     * @param limit the limit
     * @return EntityQueryLimitExecutor
     */
    T limit(Limit limit);

    //    /**
    //     * limit.
    //     *
    //     * @param limit limit rows
    //     * @return EntityQueryLimitExecutor
    //     */
    //    @Override
    //    default EntityQueryLimitExecutor<E> limit(Integer limit) {
    //        return limit(0, limit);
    //    }
    //
    //    /**
    //     * limit.
    //     *
    //     * @param offset start index offset
    //     * @param limit  limit rows
    //     * @return EntityQueryLimitExecutor
    //     */
    //    @Override
    //    default EntityQueryLimitExecutor<E> limit(Integer offset, Integer limit) {
    //        return limit(new Limit(offset, limit));
    //    }
    //
    //    /**
    //     * limit.
    //     *
    //     * @param page params for pagination
    //     * @return EntityQueryLimitExecutor
    //     */
    //    @Override
    //    default EntityQueryLimitExecutor<E> limit(Page page) {
    //        return limit(new Limit(page));
    //    }
    //
    //    /**
    //     * Limit.
    //     *
    //     * @param limit the limit
    //     * @return EntityQueryLimitExecutor
    //     */
    //    @Override
    //    EntityQueryLimitExecutor<E> limit(Limit limit);
}
