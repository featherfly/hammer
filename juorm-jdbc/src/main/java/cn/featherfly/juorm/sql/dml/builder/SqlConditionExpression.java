
package cn.featherfly.juorm.sql.dml.builder;

import cn.featherfly.juorm.dml.builder.BuilderException;
import cn.featherfly.juorm.dml.builder.ParamedExpression;
import cn.featherfly.juorm.operator.QueryOperator;
import cn.featherfly.juorm.sql.dialect.Dialect;
import cn.featherfly.juorm.sql.model.ConditionColumnElement;

/**
 * <p>
 * sql condition expression sql 条件表达式
 * </p>
 *
 * @author zhongj
 */
public class SqlConditionExpression implements ParamedExpression {

    private ConditionColumnElement conditionColumnElement;

    /**
     * @param dialect       dialect
     * @param name          名称
     * @param value         值
     * @param queryOperator 查询运算符（查询类型）
     */
    SqlConditionExpression(Dialect dialect, String name, Object value, QueryOperator queryOperator) {
        this(dialect, name, value, queryOperator, null);
    }

    /**
     * @param dialect       dialect
     * @param name          名称
     * @param queryAlias    查询别名
     * @param value         值
     * @param queryOperator 查询运算符（查询类型）
     */
    SqlConditionExpression(Dialect dialect, String name, Object value, QueryOperator queryOperator, String queryAlias) {
        if (queryOperator == null) {
            throw new BuilderException("#query.operator.null");
        }
        conditionColumnElement = new ConditionColumnElement(dialect, name, value, queryOperator, queryAlias);
    }

    /**
     * 返回conditionColumnElement
     *
     * @return conditionColumnElement
     */
    public ConditionColumnElement getConditionColumnElement() {
        return conditionColumnElement;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getParamValue() {
        return conditionColumnElement.getParam();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String build() {
        return conditionColumnElement.toSql();
    }
}
