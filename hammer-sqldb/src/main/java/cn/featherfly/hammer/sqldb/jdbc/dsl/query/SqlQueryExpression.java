
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
import cn.featherfly.common.exception.NotImplementedException;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.operator.ComparisonOperator;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.dsl.query.QueryConditionGroupExpression;
import cn.featherfly.hammer.dsl.query.QueryConditionGroupLogicExpression;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * SqlDeleteExpression .
 *
 * @author zhongj
 */
public class SqlQueryExpression extends SqlQueryConditionGroupExpression {

    /** The select builder. */
    private SqlSelectBasicBuilder selectBuilder;

    /**
     * Instantiates a new sql query expression.
     *
     * @param jdbc                 the jdbc
     * @param sqlPageFactory       the sql page factory
     * @param selectBuilder        the select builder
     * @param queryConditionConfig the query condition config
     */
    public SqlQueryExpression(Jdbc jdbc, SqlPageFactory sqlPageFactory, SqlSelectBasicBuilder selectBuilder,
            QueryConditionConfig queryConditionConfig) {
        super(jdbc, sqlPageFactory, selectBuilder.getDefaultTableAlias(), queryConditionConfig);
        this.selectBuilder = selectBuilder;
    }

    /**
     * Instantiates a new sql query expression.
     *
     * @param parent               the parent
     * @param jdbc                 the jdbc
     * @param sqlPageFactory       the sql page factory
     * @param queryAlias           the query alias
     * @param queryConditionConfig the query condition config
     */
    SqlQueryExpression(QueryConditionGroupLogicExpression parent, Jdbc jdbc, SqlPageFactory sqlPageFactory,
            String queryAlias, QueryConditionConfig queryConditionConfig) {
        super(parent, jdbc, sqlPageFactory, queryAlias, queryConditionConfig);
    }

    /**
     * Instantiates a new sql query expression.
     *
     * @param jdbc                 the jdbc
     * @param sqlPageFactory       the sql page factory
     * @param queryAlias           the query alias
     * @param queryConditionConfig the query condition config
     */
    public SqlQueryExpression(Jdbc jdbc, SqlPageFactory sqlPageFactory, String queryAlias,
            QueryConditionConfig queryConditionConfig) {
        super(jdbc, sqlPageFactory, queryAlias, queryConditionConfig);
    }

    /**
     * Instantiates a new sql query expression.
     *
     * @param jdbc                 jdbc
     * @param sqlPageFactory       the sql page factory
     * @param queryConditionConfig the query condition config
     */
    public SqlQueryExpression(Jdbc jdbc, SqlPageFactory sqlPageFactory, QueryConditionConfig queryConditionConfig) {
        super(jdbc, sqlPageFactory, queryConditionConfig);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected QueryConditionGroupExpression createGroup(QueryConditionGroupLogicExpression parent, String queryAlias) {
        return new SqlQueryExpression(parent, jdbc, sqlPageFactory, queryAlias, (QueryConditionConfig) conditionConfig);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long count() {
        selectBuilder.clearColumns().addColumn(AggregateFunction.COUNT, Chars.STAR);
        return longValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String build() {
        String result = "";
        if (selectBuilder != null) {
            result = selectBuilder
                    .build((tableName, tableAlias) -> selectBuilder.getDefaultTableAlias().equals(tableAlias));
        }
        String condition = super.build();
        if (Lang.isNotEmpty(condition)) {
            // result = result + Chars.SPACE +
            // jdbc.getDialect().getKeywords().where() + Chars.SPACE +
            // condition;
            result = result + Chars.SPACE + condition;
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAlias(int index) {
        // IMPLSOON 未实现
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <M extends ClassMapping<T, P>, T, P extends PropertyMapping<P>> M getClassMapping(int index) {
        // IMPLSOON 未实现
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected <R> QueryConditionGroupLogicExpression eq_ne(AtomicInteger index, ComparisonOperator comparisonOperator,
            PropertyMapping<?> pm, R value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        // IMPLSOON 未实现
        throw new NotImplementedException();
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    protected <R> QueryConditionGroupLogicExpression eq_ne(int index, ComparisonOperator comparisonOperator,
    //            List<PropertyMapping<?>> pms, R value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
    //        // IMPLSOON 未实现
    //        throw new NotImplementedException();
    //    }
}
