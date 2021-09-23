
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.common.repository.mapping.MappingFactory;
import cn.featherfly.common.repository.operate.AggregateFunction;
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
     */
    public RepositorySqlQueryExpression(Jdbc jdbc, MappingFactory factory, AliasManager aliasManager,
            SqlSelectBasicBuilder selectBuilder, SqlPageFactory sqlPageFactory) {
        super(jdbc, factory, aliasManager, selectBuilder.getTableAlias(), sqlPageFactory);
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
     */
    public RepositorySqlQueryExpression(Jdbc jdbc, MappingFactory factory, AliasManager aliasManager,
            SqlPageFactory sqlPageFactory, ClassMapping<?> classMapping, SqlSelectBasicBuilder selectBuilder) {
        super(jdbc, factory, aliasManager, selectBuilder.getTableAlias(), sqlPageFactory, classMapping);
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
     */
    public RepositorySqlQueryExpression(Jdbc jdbc, MappingFactory factory, AliasManager aliasManager, String queryAlias,
            SqlPageFactory sqlPageFactory) {
        super(jdbc, factory, aliasManager, queryAlias, sqlPageFactory);
    }

    /**
     * Instantiates a new sql query expression.
     *
     * @param jdbc           jdbc
     * @param factory        MappingFactory
     * @param aliasManager   aliasManager
     * @param sqlPageFactory the sql page factory
     */
    public RepositorySqlQueryExpression(Jdbc jdbc, MappingFactory factory, AliasManager aliasManager,
            SqlPageFactory sqlPageFactory) {
        super(jdbc, factory, aliasManager, sqlPageFactory);
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
     */
    RepositorySqlQueryExpression(RepositoryQueryConditionGroupLogicExpression parent, Jdbc jdbc, MappingFactory factory,
            AliasManager aliasManager, String queryAlias, SqlPageFactory sqlPageFactory, ClassMapping<?> classMapping) {
        super(parent, jdbc, factory, aliasManager, queryAlias, sqlPageFactory, classMapping);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryConditionGroupExpression createGroup(RepositoryQueryConditionGroupLogicExpression parent,
            String queryAlias) {
        selectBuilder.setTableAlias(queryAlias);
        return new RepositorySqlQueryExpression(parent, jdbc, factory, aliasManager, queryAlias, sqlPageFactory,
                classMapping);
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
