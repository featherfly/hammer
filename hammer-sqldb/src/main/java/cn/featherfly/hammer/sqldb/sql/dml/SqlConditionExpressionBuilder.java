
package cn.featherfly.hammer.sqldb.sql.dml;

import java.util.function.Predicate;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.builder.model.ColumnElement;
import cn.featherfly.common.db.builder.model.ConditionColumnElement;
import cn.featherfly.common.db.builder.model.SqlElement;
import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.operator.ComparisonOperator;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.AliasRepository;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.RepositoryAwareField;
import cn.featherfly.common.repository.builder.BuilderException;
import cn.featherfly.common.repository.builder.BuilderExceptionCode;
import cn.featherfly.hammer.expression.condition.Expression;
import cn.featherfly.hammer.expression.condition.ParamedExpression;

/**
 * sql condition expression builder.
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
    public SqlConditionExpressionBuilder(Dialect dialect, String name, Object value,
        ComparisonOperator comparisonOperator, MatchStrategy matchStrategy, String queryAlias,
        Predicate<?> ignoreStrategy) {
        init(dialect, name, value, comparisonOperator, matchStrategy, queryAlias, ignoreStrategy);
    }

    private void init(Dialect dialect, String name, Object value, ComparisonOperator comparisonOperator,
        MatchStrategy matchStrategy, String queryAlias, Predicate<?> ignoreStrategy) {
        if (comparisonOperator == null) {
            throw new BuilderException(BuilderExceptionCode.createQueryOperatorNullCode());
        }
        if (value instanceof RepositoryAwareField) {
            @SuppressWarnings("unchecked")
            RepositoryAwareField<AliasRepository> f = (RepositoryAwareField<AliasRepository>) value;
            AliasRepository r = f.repository();
            SqlElement se = new ColumnElement(dialect, f.name(), r.alias());
            conditionColumnElement = new ConditionColumnElement(dialect, name, se, comparisonOperator, matchStrategy,
                queryAlias, ignoreStrategy);
        } else if (value instanceof Field) {
            Field f = (Field) value;
            SqlElement se = new ColumnElement(dialect, f.name());
            conditionColumnElement = new ConditionColumnElement(dialect, name, se, comparisonOperator, matchStrategy,
                queryAlias, ignoreStrategy);
        } else if (value instanceof Expression) {
            SqlElement se = () -> ((Expression) value).expression();
            //            if (value instanceof ParamedExpression) {
            //                // YUFEI_TODO 还未实现带参数的情况
            //                Object param = ((ParamedExpression) value).getParam();
            //            }
            conditionColumnElement = new ConditionColumnElement(dialect, name, se, comparisonOperator, matchStrategy,
                queryAlias, ignoreStrategy);
        } else {
            conditionColumnElement = new ConditionColumnElement(dialect, name, value, comparisonOperator, matchStrategy,
                queryAlias, ignoreStrategy);
        }
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
