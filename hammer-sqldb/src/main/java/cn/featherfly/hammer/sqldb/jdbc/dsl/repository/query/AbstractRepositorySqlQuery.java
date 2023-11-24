
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.Table;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.hammer.HammerException;
import cn.featherfly.hammer.config.dsl.QueryConfig;
import cn.featherfly.hammer.expression.query.QueryCountExecutor;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * AbstractRepositorySqlQuery.
 *
 * @author zhongj
 * @param <Q> the element type
 */
public abstract class AbstractRepositorySqlQuery<Q> implements QueryCountExecutor {

    /** The jdbc. */
    protected final Jdbc jdbc;

    /** The select builder. */
    protected final SqlSelectBasicBuilder selectBuilder;

    /** The sql page factory. */
    protected final SqlPageFactory sqlPageFactory;

    /** The alias manager. */
    protected final AliasManager aliasManager;

    /** The ignore strategy. */
    protected final QueryConfig queryConfig;

    /** The table alias. */
    protected final String tableAlias;

    /** The id name. */
    protected String idName;

    /**
     * Instantiates a new abstract sql query entity properties.
     *
     * @param jdbc             jdbc
     * @param databaseMetadata databaseMetadata
     * @param sqlPageFactory   the sql page factory
     * @param aliasManager     aliasManager
     * @param tableName        tableName
     * @param tableAlias       tableAlias
     * @param queryConfig      the query config
     */
    protected AbstractRepositorySqlQuery(Jdbc jdbc, DatabaseMetadata databaseMetadata, SqlPageFactory sqlPageFactory,
            AliasManager aliasManager, String tableName, String tableAlias, QueryConfig queryConfig) {
        this.jdbc = jdbc;
        this.sqlPageFactory = sqlPageFactory;
        this.aliasManager = aliasManager;
        this.queryConfig = queryConfig.clone();
        if (tableAlias == null) {
            tableAlias = aliasManager.put(tableName);
        }
        Table tableMetadata = databaseMetadata.getTable(tableName);
        if (tableMetadata.getPrimaryColumns().size() == 1) {
            // FIXME 这里处理不了复合主键的问题
            idName = tableMetadata.getPrimaryColumns().get(0).getName();
        }
        this.tableAlias = tableAlias;
        selectBuilder = new SqlSelectBasicBuilder(jdbc.getDialect(), tableName, tableAlias, aliasManager);
    }

    /**
     * Instantiates a new abstract sql query entity properties.
     *
     * @param repositorySqlQueryFetch the repository sql query fetch
     */
    protected AbstractRepositorySqlQuery(AbstractRepositorySqlQuery<Q> repositorySqlQueryFetch) {
        jdbc = repositorySqlQueryFetch.jdbc;
        sqlPageFactory = repositorySqlQueryFetch.sqlPageFactory;
        aliasManager = repositorySqlQueryFetch.aliasManager;
        //        queryRelation = repositorySqlQueryFetch.queryRelation;
        queryConfig = repositorySqlQueryFetch.queryConfig;
        tableAlias = repositorySqlQueryFetch.tableAlias;
        idName = repositorySqlQueryFetch.idName;
        selectBuilder = repositorySqlQueryFetch.selectBuilder;
    }

    /**
     * Gets the id name.
     *
     * @return the id name
     */
    protected String getIdName() {
        if (Lang.isEmpty(idName)) {
            throw new HammerException("privary key column name is null");
        }
        return idName;
    }

    /**
     * 返回selectBuilder.
     *
     * @return selectBuilder
     */
    SqlSelectBasicBuilder getSelectBuilder() {
        return selectBuilder;
    }

    /**
     * Count.
     *
     * @return the e
     */
    @Override
    public long count() {
        return new RepositorySqlQueryValueExpression(jdbc, sqlPageFactory,
                selectBuilder.clearColumns().addColumn(AggregateFunction.COUNT, Chars.STAR), queryConfig).count();
    }
}
