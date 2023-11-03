//
//package cn.featherfly.hammer.dsl.entity.query;
//
//import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionLimit;
//import cn.featherfly.hammer.expression.entity.query.EntityQueryExecutor;
//import cn.featherfly.hammer.expression.entity.query.EntityQuerySortedExpression;
//import cn.featherfly.hammer.expression.query.QueryCountExecutor;
//import cn.featherfly.hammer.expression.query.QueryValueExecutor;
//
///**
// * The Interface EntityQueryConditionLogicExpression.
// *
// * @author zhongj
// * @param <E> the element type
// */
//public interface EntityQueryConditionLogicExpression<E>
//        extends EntityQueryConditionLimit<E>, EntityQueryExecutor<E>, QueryCountExecutor, QueryValueExecutor,
//        EntityQueryConditionGroupLogic<EntityQueryCondition<E>, EntityQueryConditionLogicExpression<E>> {
//
//    /**
//     * 结束当前条件并进入排序器.
//     *
//     * @return QuerySortExpression
//     */
//    EntityQuerySortedExpression<E> sort();
//}
