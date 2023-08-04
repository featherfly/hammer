package cn.featherfly.hammer.expression.entity.query.sort;

/**
 * 已排序排序构建接口，代表已经调用过至少一次asc（desc）方法.
 *
 * @author zhongj
 * @param <E>  the entity type
 * @param <E2> the generic type
 * @param <S>  the EntitySortedExpression2 type
 */
public interface EntitySortedExpression2<E, E2, S extends EntitySortedExpression2<E, E2, S>>
        extends EntitySortExpression2<E, E2, S>, EntitySortedExpression<E, S> {

}