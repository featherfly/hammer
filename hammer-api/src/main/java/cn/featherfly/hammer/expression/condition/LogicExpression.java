
package cn.featherfly.hammer.expression.condition;

import java.util.function.Function;

import cn.featherfly.common.operator.LogicOperator;

/**
 * logic expression. 逻辑条件.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface LogicExpression<C extends ConditionExpression, L extends LogicExpression<C, L>> extends Expression {

    /**
     * 根据传入参数进行逻辑运算.
     *
     * @param operator the operator
     * @return ConditionExpression
     */
    C logic(LogicOperator operator);

    /**
     * 根据传入参数进行逻辑运算.
     *
     * @param logicExpression the logic expression
     * @return LogicExpression
     */
    L logic(LogicOperator operator, LogicExpression<?, ?> logicExpression);

    /**
     * 根据传入参数进行逻辑运算，后跟分组条件即需要把逻辑放在一个分组内的条件.
     *
     * @param group group
     * @return LogicExpression
     */
    L logic(LogicOperator operator, Function<C, L> group);

    /**
     * logic and. 逻辑与.
     *
     * @return ConditionExpression
     */
    C and();

    /**
     * logic and. 逻辑与.
     *
     * @param logicExpression the logic expression
     * @return LogicExpression
     */
    L and(LogicExpression<?, ?> logicExpression);

    /**
     * logic and. 逻辑与，后跟分组条件即需要把逻辑放在一个分组内的条件.
     *
     * @param group group
     * @return LogicExpression
     */
    L and(Function<C, L> group);

    /**
     * logic or. 逻辑或.
     *
     * @return ConditionExpression
     */
    C or();

    /**
     * logic or. 逻辑与.
     *
     * @param logicExpression the logic expression
     * @return LogicExpression
     */
    L or(LogicExpression<?, ?> logicExpression);

    /**
     * logic or. 逻辑或，后跟分组条件即需要把逻辑放在一个分组内的条件.
     *
     * @param group group
     * @return LogicExpression
     */
    L or(Function<C, L> group);

    // /**
    // * 结束当前条件逻辑组并返回上一级逻辑组 {@link ConditionExpression#group()}
    // *
    // * @return parent LogicBuilder
    // */
    // L parent();
}
