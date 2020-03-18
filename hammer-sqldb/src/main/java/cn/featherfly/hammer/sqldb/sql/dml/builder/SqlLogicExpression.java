
package cn.featherfly.hammer.sqldb.sql.dml.builder;

import cn.featherfly.hammer.dml.builder.LogicExpression;
import cn.featherfly.hammer.operator.LogicOperator;

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
