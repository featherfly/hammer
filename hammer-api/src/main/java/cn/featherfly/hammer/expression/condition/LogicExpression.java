
package cn.featherfly.hammer.expression.condition;

import java.util.function.Function;

import cn.featherfly.common.lang.AssertIllegalArgument;
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
    default C logic(LogicOperator operator) {
        AssertIllegalArgument.isNotNull(operator, "operator");
        switch (operator) {
            case AND:
                return and();
            case OR:
                return or();
            default:
                throw new UnsupportedOperationException();
        }
    }

    /**
     * 根据传入参数进行逻辑运算.
     *
     * @param operator        the operator
     * @param logicExpression the logic expression
     * @return LogicExpression
     */
    default L logic(LogicOperator operator, LogicExpression<?, ?> logicExpression) {
        AssertIllegalArgument.isNotNull(operator, "operator");
        switch (operator) {
            case AND:
                return and(logicExpression);
            case OR:
                return or(logicExpression);
            default:
                throw new UnsupportedOperationException();
        }
    }

    /**
     * 根据传入参数进行逻辑运算，后跟分组条件即需要把逻辑放在一个分组内的条件.
     *
     * @param operator the operator
     * @param group    group
     * @return LogicExpression
     */
    default L logic(LogicOperator operator, Function<C, L> group) {
        AssertIllegalArgument.isNotNull(operator, "operator");
        switch (operator) {
            case AND:
                return and(group);
            case OR:
                return or(group);
            default:
                throw new UnsupportedOperationException();
        }
    }

    /**
     * 根据传入参数进行逻辑运算.
     *
     * @param <G>                 the generic type
     * @param <GC>                the generic type
     * @param <GL>                the generic type
     * @param operator            the operator
     * @param conditionExpression the condition expression
     * @return LogicExpression
     */
    default <G extends GroupExpression<GC, GL>, GC extends ConditionExpression,
        GL extends GroupEndExpression<GC, GL>> G logic(LogicOperator operator, G conditionExpression) {
        AssertIllegalArgument.isNotNull(operator, "operator");
        switch (operator) {
            case AND:
                return and(conditionExpression);
            case OR:
                return or(conditionExpression);
            default:
                throw new UnsupportedOperationException();
        }
    }

    // ----------------------------------------------------------------------------------------------------------------

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
     * logic and. 逻辑与.
     *
     * @param <G>                 the GroupExpression type
     * @param <GC>                the generic type
     * @param <GL>                the generic type
     * @param conditionExpression the condition expression
     * @return ConditionExpression
     */
    default <G extends GroupExpression<GC, GL>, GC extends ConditionExpression,
        GL extends GroupEndExpression<GC, GL>> G and(G conditionExpression) {
        and();
        return conditionExpression;
    }

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

    /**
     * logic or. 逻辑或.
     *
     * @param <G>                 the GroupExpression type
     * @param <GC>                the generic type
     * @param <GL>                the generic type
     * @param conditionExpression the condition expression
     * @return ConditionExpression
     */
    default <G extends GroupExpression<GC, GL>, GC extends ConditionExpression,
        GL extends GroupEndExpression<GC, GL>> G or(G conditionExpression) {
        or();
        return conditionExpression;
    }

    // /**
    // * 结束当前条件逻辑组并返回上一级逻辑组 {@link ConditionExpression#group()}
    // *
    // * @return parent LogicBuilder
    // */
    // L parent();
}
