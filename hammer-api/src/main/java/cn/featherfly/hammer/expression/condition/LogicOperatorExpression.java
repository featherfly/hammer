
package cn.featherfly.hammer.expression.condition;

import cn.featherfly.common.operator.LogicOperator;

/**
 * logic operator expression. 逻辑条件操作符表达式.
 *
 * @author zhongj
 */
public abstract class LogicOperatorExpression implements Expression {
    private LogicOperator logicOperator = LogicOperator.AND;

    /**
     * Instantiates a new logic operator expression.
     *
     * @param logicOperator the logic operator
     */
    protected LogicOperatorExpression(LogicOperator logicOperator) {
        if (logicOperator != null) {
            this.logicOperator = logicOperator;
        }
    }

    /**
     * Gets the logic operator.
     *
     * @return logicOperator
     */
    public LogicOperator getLogicOperator() {
        return logicOperator;
    }
}
