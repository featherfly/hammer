
package cn.featherfly.hammer.expression.entity.compatible.query;

// TODO 编译报错，发布版本先屏蔽
// 错误: 类型cn.featherfly.data.query.QueryValueListExecutor和cn.featherfly.data.query.QueryListExecutor<E>不兼容;
// 两者都定义了list(), 但却带有不相关的返回类型
// /**
// * entity query one value expression.
// *
// * @author zhongj
// * @param <E> the query entity type
// * @param <V> the fetch value type
// * @param <C> condition expression
// * @param <L> logic expression
// * @param <S> sort expression
// * @param <T> this expression
// */
//public interface EntityQueryOneValueCompatibleExpression<E, V,
//    C extends EntityQueryValueConditionGroupCompatibleExpression<E, V, C, L, S>,
//    L extends EntityQueryValueConditionGroupLogicCompatibleExpression<E, V, C, L, S>,
//    S extends EntityQueryValueSortCompatibleExpression<E, V>,
//    T extends EntityQueryOneValueCompatibleExpression<E, V, C, L, S, T>>
//    extends EntityQueryValueWhereCompatibleExpression<E, V, C, L, S>, QueryListExecutor<E>, QueryValueExecutor,
//    QueryCountExecutor, QueryLimitSetter<QueryValueLimitExecutor>, Queryable<S>,
//    ConfigureExpression<T, DslQueryConfig, QueryConditionConfig> {
//
//}
