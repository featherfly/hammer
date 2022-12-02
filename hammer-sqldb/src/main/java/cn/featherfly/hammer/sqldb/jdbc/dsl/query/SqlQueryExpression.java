
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import java.util.function.Predicate;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.repository.IgnorePolicy;
import cn.featherfly.hammer.dsl.query.QueryConditionGroupExpression;
import cn.featherfly.hammer.dsl.query.QueryConditionGroupLogicExpression;
import cn.featherfly.hammer.dsl.query.TypeQueryEntity;
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
     * @param jdbc           the jdbc
     * @param sqlPageFactory the sql page factory
     * @param selectBuilder  the select builder
     */
    public SqlQueryExpression(Jdbc jdbc, SqlPageFactory sqlPageFactory, SqlSelectBasicBuilder selectBuilder) {
        this(jdbc, sqlPageFactory, IgnorePolicy.EMPTY);
    }

    /**
     * Instantiates a new sql query expression.
     *
     * @param jdbc           the jdbc
     * @param sqlPageFactory the sql page factory
     * @param selectBuilder  the select builder
     * @param ignorePolicy   the ignore policy
     */
    public SqlQueryExpression(Jdbc jdbc, SqlPageFactory sqlPageFactory, SqlSelectBasicBuilder selectBuilder,
            Predicate<Object> ignorePolicy) {
        super(jdbc, sqlPageFactory, selectBuilder.getDefaultTableAlias(), ignorePolicy);
        this.selectBuilder = selectBuilder;
    }

    /**
     * Instantiates a new sql query expression.
     *
     * @param parent         the parent
     * @param jdbc           the jdbc
     * @param sqlPageFactory the sql page factory
     * @param queryAlias     the query alias
     * @param ignorePolicy   the ignore policy
     */
    SqlQueryExpression(QueryConditionGroupLogicExpression parent, Jdbc jdbc, SqlPageFactory sqlPageFactory,
            String queryAlias, Predicate<Object> ignorePolicy) {
        super(parent, jdbc, sqlPageFactory, queryAlias, ignorePolicy);
    }

    /**
     * Instantiates a new sql query expression.
     *
     * @param jdbc           the jdbc
     * @param sqlPageFactory the sql page factory
     * @param queryAlias     the query alias
     * @param ignorePolicy   the ignore policy
     */
    public SqlQueryExpression(Jdbc jdbc, SqlPageFactory sqlPageFactory, String queryAlias,
            Predicate<Object> ignorePolicy) {
        super(jdbc, sqlPageFactory, queryAlias, ignorePolicy);
    }

    /**
     * Instantiates a new sql query expression.
     *
     * @param jdbc           jdbc
     * @param sqlPageFactory the sql page factory
     * @param ignorePolicy   the ignore policy
     */
    public SqlQueryExpression(Jdbc jdbc, SqlPageFactory sqlPageFactory, Predicate<Object> ignorePolicy) {
        super(jdbc, sqlPageFactory, ignorePolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected QueryConditionGroupExpression createGroup(QueryConditionGroupLogicExpression parent, String queryAlias,
            TypeQueryEntity typeQueryEntity) {
        return new SqlQueryExpression(parent, jdbc, sqlPageFactory, queryAlias, ignorePolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long count() {
        selectBuilder.addColumn(AggregateFunction.COUNT, Chars.STAR);
        return longInt();
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
}
