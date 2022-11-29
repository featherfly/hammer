
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import java.util.function.Predicate;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.hammer.dsl.query.RepositoryQueryConditionGroupExpression;
import cn.featherfly.hammer.dsl.query.RepositoryQueryConditionGroupLogicExpression;
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
public class RepositorySqlQueryExpression extends RepositorySqlQueryConditionGroupExpression {

    /** The select builder. */
    private SqlSelectBasicBuilder selectBuilder;

    /**
     * Instantiates a new sql query expression.
     *
     * @param jdbc           the jdbc
     * @param factory        MappingFactory
     * @param aliasManager   aliasManager
     * @param selectBuilder  the select builder
     * @param sqlPageFactory the sql page factory
     * @param ignorePolicy   the ignore policy
     */
    public RepositorySqlQueryExpression(Jdbc jdbc, AliasManager aliasManager, SqlSelectBasicBuilder selectBuilder,
            SqlPageFactory sqlPageFactory, Predicate<Object> ignorePolicy) {
        //        super(jdbc, factory, aliasManager, selectBuilder.getTableAlias(), sqlPageFactory, ignorePolicy);
        //      IMPLSOON 后续来实现，先让编译通过
        super(jdbc, aliasManager, "", sqlPageFactory, ignorePolicy);
        this.selectBuilder = selectBuilder;
    }

    /**
     * Instantiates a new sql query expression.
     *
     * @param jdbc           the jdbc
     * @param factory        MappingFactory
     * @param aliasManager   aliasManager
     * @param sqlPageFactory the sql page factory
     * @param classMapping   the class mapping
     * @param selectBuilder  the select builder
     * @param ignorePolicy   the ignore policy
     */
    public RepositorySqlQueryExpression(Jdbc jdbc, AliasManager aliasManager, SqlPageFactory sqlPageFactory,
            SqlSelectBasicBuilder selectBuilder, Predicate<Object> ignorePolicy) {
        //        super(jdbc, factory, aliasManager, selectBuilder.getTableAlias(), sqlPageFactory, classMapping, ignorePolicy);
        //      IMPLSOON 后续来实现，先让编译通过
        super(jdbc, aliasManager, "", sqlPageFactory, ignorePolicy);
        this.selectBuilder = selectBuilder;
    }

    /**
     * Instantiates a new sql query expression.
     *
     * @param jdbc           the jdbc
     * @param factory        MappingFactory
     * @param aliasManager   aliasManager
     * @param queryAlias     the query alias
     * @param sqlPageFactory the sql page factory
     * @param ignorePolicy   the ignore policy
     */
    public RepositorySqlQueryExpression(Jdbc jdbc, AliasManager aliasManager, String queryAlias,
            SqlPageFactory sqlPageFactory, Predicate<Object> ignorePolicy) {
        super(jdbc, aliasManager, queryAlias, sqlPageFactory, ignorePolicy);
    }

    /**
     * Instantiates a new sql query expression.
     *
     * @param jdbc           jdbc
     * @param factory        MappingFactory
     * @param aliasManager   aliasManager
     * @param sqlPageFactory the sql page factory
     * @param ignorePolicy   the ignore policy
     */
    public RepositorySqlQueryExpression(Jdbc jdbc, AliasManager aliasManager, SqlPageFactory sqlPageFactory,
            Predicate<Object> ignorePolicy) {
        super(jdbc, aliasManager, sqlPageFactory, ignorePolicy);
    }

    /**
     * Instantiates a new repository sql query expression.
     *
     * @param parent         the parent
     * @param jdbc           the jdbc
     * @param factory        MappingFactory
     * @param aliasManager   aliasManager
     * @param queryAlias     the query alias
     * @param sqlPageFactory the sql page factory
     * @param classMapping   the class mapping
     * @param ignorePolicy   the ignore policy
     */
    RepositorySqlQueryExpression(RepositoryQueryConditionGroupLogicExpression parent, Jdbc jdbc,
            AliasManager aliasManager, String queryAlias, SqlPageFactory sqlPageFactory,
            Predicate<Object> ignorePolicy) {
        super(parent, jdbc, aliasManager, queryAlias, sqlPageFactory, ignorePolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryConditionGroupExpression createGroup(RepositoryQueryConditionGroupLogicExpression parent,
            String queryAlias) {
        //      IMPLSOON 后续来实现，先让编译通过
        //        selectBuilder.setTableAlias(queryAlias);
        return new RepositorySqlQueryExpression(parent, jdbc, aliasManager, queryAlias, sqlPageFactory, ignorePolicy);
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
