package cn.featherfly.hammer.expression.entity.query.sort;

/**
 * 已排序排序构建接口，代表已经调用过至少一次asc（desc）方法.
 *
 * @author zhongj
 * @param <E>  the entity type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <S>  the EntitySortedExpression4 type
 */
public interface EntitySortedExpression4<E, E2, E3, E4, S extends EntitySortedExpression4<E, E2, E3, E4, S>>
        extends EntitySortExpression4<E, E2, E3, E4, S>, EntitySortedExpression<E, S> {
}