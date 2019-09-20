
package cn.featherfly.juorm.expression;

/**
 * <p>
 * WhereExpression
 * </p>
 *
 * @author zhongj
 */
public interface WhereExpression<C extends ConditionGroupExpression<C, L>,
        L extends ConditionGroupLogicExpression<C, L>> {
    /**
     * <p>
     * 进入条件表达式
     * </p>
     *
     * @return QueryCondition
     */
    C where();
}
