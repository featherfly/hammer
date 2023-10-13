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
 * @param <E7> the generic type
 * @param <S>  the EntitySortedExpression7 type
 */
public interface EntitySortedExpression7<E, E2, E3, E4, E5, E6, E7,
        S extends EntitySortedExpression7<E, E2, E3, E4, E5, E6, E7, S>>
        extends EntitySortExpression7<E, E2, E3, E4, E5, E6, E7, S>, EntitySortedExpression<E, S> {
}