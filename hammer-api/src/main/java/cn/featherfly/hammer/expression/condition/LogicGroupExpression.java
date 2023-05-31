
package cn.featherfly.hammer.expression.condition;

/**
 * 逻辑条件组.
 *
 * @author zhongj
 */
public interface LogicGroupExpression<C extends ConditionsGroupExpression<C, L>, L extends LogicGroupExpression<C, L>>
        extends LogicExpression<C, L>, GroupEndExpression<L> {
}
