
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryValueConditionsGroup;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryValueConditionsGroupLogic;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * repository sql query expression .
 *
 * @author zhongj
 */
public class RepositorySqlQueryValueExpression extends AbstractRepositorySqlQueryValueConditionsGroupExpression {

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
    public RepositorySqlQueryValueExpression(Jdbc jdbc, SqlPageFactory sqlPageFactory,
            SqlSelectBasicBuilder selectBuilder, QueryConditionConfig queryConditionConfig) {
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
    RepositorySqlQueryValueExpression(RepositoryQueryValueConditionsGroupLogic parent, Jdbc jdbc,
            SqlPageFactory sqlPageFactory, String queryAlias, QueryConditionConfig queryConditionConfig) {
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
    public RepositorySqlQueryValueExpression(Jdbc jdbc, SqlPageFactory sqlPageFactory, String queryAlias,
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
    public RepositorySqlQueryValueExpression(Jdbc jdbc, SqlPageFactory sqlPageFactory,
            QueryConditionConfig queryConditionConfig) {
        super(jdbc, sqlPageFactory, queryConditionConfig);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryValueConditionsGroup createGroup(RepositoryQueryValueConditionsGroupLogic parent,
            String queryAlias) {
        return new RepositorySqlQueryValueExpression(parent, jdbc, sqlPageFactory, queryAlias,
                (QueryConditionConfig) conditionConfig);
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
    public String expression() {
        String result = "";
        if (selectBuilder != null) {
            result = selectBuilder
                    .build((tableName, tableAlias) -> selectBuilder.getDefaultTableAlias().equals(tableAlias));
        }
        String condition = super.expression();
        if (Lang.isNotEmpty(condition)) {
            // result = result + Chars.SPACE +
            // jdbc.getDialect().getKeywords().where() + Chars.SPACE +
            // condition;
            result = result + Chars.SPACE + condition;
        }
        return result;
    }
}
