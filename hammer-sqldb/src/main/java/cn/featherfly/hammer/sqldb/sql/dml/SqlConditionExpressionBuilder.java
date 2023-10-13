
package cn.featherfly.hammer.sqldb.sql.dml;

import java.util.function.Predicate;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.builder.model.ConditionColumnElement;
import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.operator.ComparisonOperator;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.builder.BuilderException;
import cn.featherfly.common.repository.builder.BuilderExceptionCode;
import cn.featherfly.hammer.expression.condition.ParamedExpression;

/**
 * <p>
 * sql condition expression sql 条件表达式
 * </p>
 * .
 *
 * @author zhongj
 */
public class SqlConditionExpressionBuilder implements ParamedExpression, SqlBuilder {

    private ConditionColumnElement conditionColumnElement;

    /**
     * Instantiates a new sql condition expression builder.
     *
     * @param dialect            dialect
     * @param name               名称
     * @param value              值
     * @param comparisonOperator 查询运算符（查询类型）
     * @param ignoreStrategy     the ignore strategy
     */
    public SqlConditionExpressionBuilder(Dialect dialect, String name, Object value,
            ComparisonOperator comparisonOperator, Predicate<?> ignoreStrategy) {
        this(dialect, name, value, comparisonOperator, null, ignoreStrategy);
    }

    /**
     * Instantiates a new sql condition expression builder.
     *
     * @param dialect            dialect
     * @param name               名称
     * @param value              值
     * @param comparisonOperator 查询运算符（查询类型）
     * @param queryAlias         查询别名
     * @param ignoreStrategy     the ignore strategy
     */
    public SqlConditionExpressionBuilder(Dialect dialect, String name, Object value,
            ComparisonOperator comparisonOperator, String queryAlias, Predicate<?> ignoreStrategy) {
        this(dialect, name, value, comparisonOperator, MatchStrategy.AUTO, queryAlias, ignoreStrategy);
    }

    /**
     * Instantiates a new sql condition expression builder.
     *
     * @param dialect            dialect
     * @param name               名称
     * @param value              值
     * @param comparisonOperator 查询运算符（查询类型）
     * @param matchStrategy      the match strategy
     * @param queryAlias         查询别名
     * @param ignoreStrategy     the ignore strategy
     */
    @SuppressWarnings("unchecked")
    public SqlConditionExpressionBuilder(Dialect dialect, String name, Object value,
            ComparisonOperator comparisonOperator, MatchStrategy matchStrategy, String queryAlias,
            Predicate<?> ignoreStrategy) {
        if (comparisonOperator == null) {
            throw new BuilderException(BuilderExceptionCode.createQueryOperatorNullCode());
        }
        conditionColumnElement = new ConditionColumnElement(dialect, name, value, comparisonOperator, matchStrategy,
                queryAlias, (Predicate<Object>) ignoreStrategy);
    }

    /**
     * 返回conditionColumnElement.
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
    public Object getParam() {
        return conditionColumnElement.getParam();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String build() {
        return conditionColumnElement.toSql();
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
