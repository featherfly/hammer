
package cn.featherfly.db.dsl.builder.sql;

import cn.featherfly.db.dsl.builder.LogicExpression;
import cn.featherfly.db.dsl.operator.LogicOperator;

/**
 * <p>
 * sql logic expression
 * </p>
 *
 * @author zhongj
 */
public class SqlLogicExpression extends LogicExpression{

	/**
     * @param logicOperator logicOperator
     */
    public SqlLogicExpression(LogicOperator logicOperator) {
        super(logicOperator);
    }

    /**
	 * {@inheritDoc}
	 */
	@Override
	public String build() {
		return getLogicOperator().toString();
	}
}
