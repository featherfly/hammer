//
//package cn.featherfly.hammer.expression.entity.query;
//
//import cn.featherfly.common.structure.page.Limit;
//import cn.featherfly.common.structure.page.Page;
//
///**
// * entity query value limit condition.
// *
// * @author zhongj
// * @param <E> the element type
// * @param <V> the value type
// */
//public interface EntityQueryValueConditionLimit<E, V> {
//
//    /**
//     * limit.
//     *
//     * @param limit limit rows
//     * @return EntityQueryValueLimitExecutor
//     */
//    default EntityQueryValueLimitExecutor<E, V> limit(Integer limit) {
//        return limit(0, limit);
//    }
//
//    /**
//     * limit.
//     *
//     * @param offset start index offset
//     * @param limit  limit rows
//     * @return EntityQueryValueLimitExecutor
//     */
//    default EntityQueryValueLimitExecutor<E, V> limit(Integer offset, Integer limit) {
//        return limit(new Limit(offset, limit));
//    }
//
//    /**
//     * limit.
//     *
//     * @param page params for pagination
//     * @return EntityQueryValueLimitExecutor
//     */
//    default EntityQueryValueLimitExecutor<E, V> limit(Page page) {
//        return limit(new Limit(page));
//    }
//
//    /**
//     * Limit.
//     *
//     * @param limit the limit
//     * @return EntityQueryValueLimitExecutor
//     */
//    EntityQueryValueLimitExecutor<E, V> limit(Limit limit);
//}
