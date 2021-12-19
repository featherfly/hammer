
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import java.util.function.Predicate;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.common.repository.operate.AggregateFunction;
import cn.featherfly.hammer.dsl.query.QueryConditionGroupExpression;
import cn.featherfly.hammer.dsl.query.QueryConditionGroupLogicExpression;
import cn.featherfly.hammer.dsl.query.TypeQueryEntity;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * <p>
 * SqlDeleteExpression
 * </p>
 * .
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
     * @param ignorePolicy   the ignore policy
     */
    public SqlQueryExpression(Jdbc jdbc, SqlPageFactory sqlPageFactory, SqlSelectBasicBuilder selectBuilder,
            Predicate<Object> ignorePolicy) {
        super(jdbc, sqlPageFactory, selectBuilder.getTableAlias(), ignorePolicy);
        this.selectBuilder = selectBuilder;
    }

    /**
     * Instantiates a new sql query expression.
     *
     * @param jdbc           the jdbc
     * @param sqlPageFactory the sql page factory
     * @param classMapping   the class mapping
     * @param selectBuilder  the select builder
     * @param ignorePolicy   the ignore policy
     */
    public SqlQueryExpression(Jdbc jdbc, SqlPageFactory sqlPageFactory, ClassMapping<?> classMapping,
            SqlSelectBasicBuilder selectBuilder, Predicate<Object> ignorePolicy) {
        super(jdbc, sqlPageFactory, selectBuilder.getTableAlias(), classMapping, ignorePolicy);
        this.selectBuilder = selectBuilder;
    }

    /**
     * Instantiates a new sql query expression.
     *
     * @param parent         the parent
     * @param jdbc           the jdbc
     * @param sqlPageFactory the sql page factory
     * @param queryAlias     the query alias
     * @param classMapping   the class mapping
     * @param ignorePolicy   the ignore policy
     */
    SqlQueryExpression(QueryConditionGroupLogicExpression parent, Jdbc jdbc, SqlPageFactory sqlPageFactory,
            String queryAlias, ClassMapping<?> classMapping, Predicate<Object> ignorePolicy) {
        super(parent, jdbc, sqlPageFactory, queryAlias, classMapping, ignorePolicy);
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
        selectBuilder.setTableAlias(queryAlias);
        return new SqlQueryExpression(parent, jdbc, sqlPageFactory, queryAlias, classMapping, ignorePolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long count() {
        selectBuilder.addSelectColumn(Chars.STAR, AggregateFunction.COUNT);
        return longInt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String build() {
        String result = "";
        if (selectBuilder != null) {
            result = selectBuilder.build();
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
