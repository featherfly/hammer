
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.Table;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.hammer.HammerException;
import cn.featherfly.hammer.config.dsl.QueryConfig;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryFetchFieldExpression;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.RepositorySqlQueryValueExpression;

/**
 * AbstractSqlQueryEntityProperties.
 *
 * @author zhongj
 * @param <Q> the element type
 */
public abstract class AbstractRepositorySqlQueryFetch<Q> implements RepositoryQueryFetchFieldExpression<Q> {

    /** The jdbc. */
    protected Jdbc jdbc;

    /** The id name. */
    protected String idName;

    /** The select builder. */
    protected SqlSelectBasicBuilder selectBuilder;

    /** The sql page factory. */
    protected SqlPageFactory sqlPageFactory;

    /** The alias manager. */
    protected AliasManager aliasManager;

    /** The ignore strategy. */
    protected QueryConfig queryConfig;

    /** The table alias. */
    protected String tableAlias;

    /**
     * Instantiates a new abstract sql query entity properties.
     *
     * @param jdbc             jdbc
     * @param databaseMetadata databaseMetadata
     * @param tableName        tableName
     * @param tableAlias       tableAlias
     * @param sqlPageFactory   the sql page factory
     * @param aliasManager     aliasManager
     * @param ignoreStrategy   the ignore strategy
     */
    protected AbstractRepositorySqlQueryFetch(Jdbc jdbc, DatabaseMetadata databaseMetadata, String tableName, String tableAlias,
            SqlPageFactory sqlPageFactory, AliasManager aliasManager, QueryConfig queryConfig) {
        //        AssertIllegalArgument.isNotNull(queryConfig, "queryConfig");
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
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public Q field(boolean distinct, String name, String alias) {
        selectBuilder.addColumn(distinct, name, alias);
        return (Q) this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public Q field(AggregateFunction aggregateFunction, boolean distinct, String columnName, String columnAlias) {
        selectBuilder.addColumn(aggregateFunction, distinct, columnName, columnAlias);
        return (Q) this;
    }

    //    /**
    //     * Property.
    //     *
    //     * @param propertyNames the property names
    //     * @return the e
    //     */
    //    @SuppressWarnings("unchecked")
    //    public E field(String... propertyNames) {
    //        for (String propertyName : propertyNames) {
    //            field(propertyName);
    //        }
    //        return (E) this;
    //    }

    //    /**
    //     * Property.
    //     *
    //     * @param propertyNames the property names
    //     * @return the e
    //     */
    //    @SuppressWarnings("unchecked")
    //    public E field(Collection<String> propertyNames) {
    //        for (String propertyName : propertyNames) {
    //            field(propertyName);
    //        }
    //        return (E) this;
    //    }

    //    /**
    //     * Property.
    //     *
    //     * @param <T>           the generic type
    //     * @param <R>           the generic type
    //     * @param propertyNames the property names
    //     * @return the e
    //     */
    //    public <T, R> E field(@SuppressWarnings("unchecked") SerializableFunction<T, R>... propertyNames) {
    //        return field(
    //                Arrays.stream(propertyNames).map(LambdaUtils::getLambdaPropertyName).collect(Collectors.toList()));
    //    }

    /**
     * Id.
     *
     * @param columnName the column name
     * @return the e
     */
    @SuppressWarnings("unchecked")
    public Q id(String columnName) {
        idName = columnName;
        return (Q) this;
    }

    /**
     * Id.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param propertyName the property name
     * @return the e
     */
    public <T, R> Q id(SerializableFunction<T, R> propertyName) {
        return id(LambdaUtils.getLambdaPropertyName(propertyName));
    }

    /**
     * Count.
     *
     * @return the e
     */
    public long count() {
        return new RepositorySqlQueryValueExpression(jdbc, sqlPageFactory,
                selectBuilder.clearColumns().addColumn(AggregateFunction.COUNT, Chars.STAR), queryConfig).count();
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
}
