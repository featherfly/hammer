
package cn.featherfly.hammer.expression.entity.query;

/**
 * The Interface EntityQueryConditionGroupExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 */
public interface EntityQueryValueConditionGroupExpression<E,
        C extends EntityQueryValueConditionGroupExpression<E, C, L, S>,
        L extends EntityQueryValueConditionGroupLogicExpression<E, C, L, S>, S extends EntityQuerySortExpression<E>>
        extends EntityQueryConditionGroupExpression<E, C, L, S> {
}
