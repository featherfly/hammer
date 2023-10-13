
package cn.featherfly.hammer.expression.entity.execute;

/**
 * ExecutableUpdateExpression.
 *
 * @author zhongj
 */
public interface EntityExecutableUpdateExpression<E, U extends EntityExecutableUpdateExpression<E, U, C, L>,
        C extends EntityExecutableConditionGroupExpression<E, C, L>,
        L extends EntityExecutableConditionGroupLogicExpression<E, C, L>> extends EntityUpdateExpression<E, U, C, L>,
        EntityPropertyExecutableUpdateExpression<E, U, C, L>, EntityUpdateSetExecutableExpression<E, U, C, L> {

}
