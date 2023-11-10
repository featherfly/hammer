
package cn.featherfly.hammer.expression.condition;

/**
 * fetch value(one field/column) logic expression. 获取值(一列数据）逻辑条件.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface ValueLogicExpression<C extends ConditionExpression, L extends ValueLogicExpression<C, L>>
        extends LogicExpression<C, L> {
}
