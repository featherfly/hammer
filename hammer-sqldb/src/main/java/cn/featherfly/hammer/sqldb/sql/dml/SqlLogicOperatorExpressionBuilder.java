
package cn.featherfly.hammer.sqldb.sql.dml;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.operator.LogicOperator;
import cn.featherfly.hammer.expression.condition.LogicOperatorExpression;

/**
 * sql logic operator expression builder.
 *
 * @author zhongj
 */
public class SqlLogicOperatorExpressionBuilder extends LogicOperatorExpression implements SqlBuilder {

    /**
     * Instantiates a new sql logic operator expression builder.
     *
     * @param logicOperator 逻辑运算符
     */
    public SqlLogicOperatorExpressionBuilder(LogicOperator logicOperator) {
        super(logicOperator);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String build() {
        return getLogicOperator().getSymbol();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return build();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {
        return build();
    }
}
