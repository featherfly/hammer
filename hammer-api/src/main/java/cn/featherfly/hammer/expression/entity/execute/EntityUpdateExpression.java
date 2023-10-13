
package cn.featherfly.hammer.expression.entity.execute;

/**
 * EntityUpdateExpression.
 *
 * @author zhongj
 */
public interface EntityUpdateExpression<E, U extends EntityExecutableUpdateExpression<E, U, C, L>,
        C extends EntityExecutableConditionGroupExpression<E, C, L>,
        L extends EntityExecutableConditionGroupLogicExpression<E, C, L>>
        extends EntityPropertyUpdateExpression<E, U, C, L>, EntityUpdateSetExpression<E, U, C, L> {

}
