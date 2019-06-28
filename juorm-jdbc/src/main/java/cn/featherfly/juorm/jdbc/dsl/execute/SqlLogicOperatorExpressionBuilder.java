
package cn.featherfly.juorm.jdbc.dsl.execute;

import cn.featherfly.juorm.expression.LogicOperatorExpression;
import cn.featherfly.juorm.operator.LogicOperator;

/**
 * <p>
 * sql logic expression
 * </p>
 *
 * @author zhongj
 */
public class SqlLogicOperatorExpressionBuilder extends LogicOperatorExpression implements SqlBuilder {

    /**
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
        return getLogicOperator().toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return build();
    }
}
