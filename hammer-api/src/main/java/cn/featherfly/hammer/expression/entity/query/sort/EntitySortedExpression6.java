package cn.featherfly.hammer.expression.entity.query.sort;

/**
 * 已排序排序构建接口，代表已经调用过至少一次asc（desc）方法.
 *
 * @author zhongj
 * @param <E>  the entity type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <E6> the generic type
 * @param <S>  the EntitySortedExpression6 type
 */
public interface EntitySortedExpression6<E, E2, E3, E4, E5, E6,
        S extends EntitySortedExpression6<E, E2, E3, E4, E5, E6, S>>
        extends EntitySortExpression6<E, E2, E3, E4, E5, E6, S>, EntitySortedExpression<E, S> {
}