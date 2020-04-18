
package cn.featherfly.hammer.expression.condition;

import cn.featherfly.common.repository.operate.LogicOperator;

/**
 * <p>
 * 逻辑条件操作符表达式
 * </p>
 *
 * @author zhongj
 */
public abstract class LogicOperatorExpression implements Expression {
    private LogicOperator logicOperator = LogicOperator.AND;

    /**
     * @param logicOperator 逻辑运算符
     */
    public LogicOperatorExpression(LogicOperator logicOperator) {
        if (logicOperator != null) {
            this.logicOperator = logicOperator;
        }
    }

    /**
     * 返回logicOperator
     *
     * @return logicOperator
     */
    public LogicOperator getLogicOperator() {
        return logicOperator;
    }
}
