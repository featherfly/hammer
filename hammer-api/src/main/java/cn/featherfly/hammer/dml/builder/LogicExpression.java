
package cn.featherfly.hammer.dml.builder;

import cn.featherfly.hammer.operator.LogicOperator;

/**
 * <p>
 * sql logic expression
 * </p>
 *
 * @author zhongj
 */
public abstract class LogicExpression implements Expression{

	private LogicOperator logicOperator = LogicOperator.AND;

	/**
	 * @param logicOperator 逻辑运算符
	 */
	public LogicExpression(LogicOperator logicOperator) {
		if (logicOperator != null) {
			this.logicOperator = logicOperator;
		}
	}

	/**
	 * 返回logicOperator
	 * @return logicOperator
	 */
	public LogicOperator getLogicOperator() {
		return logicOperator;
	}
}
