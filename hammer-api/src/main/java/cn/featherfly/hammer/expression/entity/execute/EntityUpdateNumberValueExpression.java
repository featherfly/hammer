
package cn.featherfly.hammer.expression.entity.execute;

/**
 * EntityUpdateNumberValueExpression.
 *
 * @author zhongj
 */
public interface EntityUpdateNumberValueExpression<E, T extends Number,
        U extends EntityPropertyExecutableUpdateExpression<E, U, C, L>,
        C extends EntityExecutableConditionGroupExpression<E, C, L>,
        L extends EntityExecutableConditionGroupLogicExpression<E, C, L>>
        extends EntityUpdateValueExpression<E, T, U, C, L> {

    U increase(T value);
}
