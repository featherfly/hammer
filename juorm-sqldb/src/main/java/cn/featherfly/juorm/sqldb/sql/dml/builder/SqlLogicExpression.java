
package cn.featherfly.juorm.sqldb.sql.dml.builder;

import cn.featherfly.juorm.dml.builder.LogicExpression;
import cn.featherfly.juorm.operator.LogicOperator;

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
