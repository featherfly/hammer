
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

import cn.featherfly.common.db.dialect.Join;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.common.repository.mapping.RowMapper;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.hammer.dsl.query.QueryConditionGroupExpression;
import cn.featherfly.hammer.dsl.query.QueryEntityProperties;
import cn.featherfly.hammer.dsl.query.QuerySortExpression;
import cn.featherfly.hammer.expression.condition.ConditionGroupConfig;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * SqlQueryProperties.
 *
 * @author zhongj
 */
public class SqlQueryEntityProperties extends AbstractSqlQueryEntityProperties<SqlQueryEntityProperties>
        implements SqlQueryEntity, QueryEntityProperties {

    /**
     * Instantiates a new sql query entity properties.
     *
     * @param jdbc             jdbc
     * @param databaseMetadata the database metadata
     * @param tableName        tableName
     * @param sqlPageFactory   the sql page factory
     * @param aliasManager     aliasManager
     * @param ignoreStrategy     the ignore strategy
     */
    public SqlQueryEntityProperties(Jdbc jdbc, DatabaseMetadata databaseMetadata, String tableName,
            SqlPageFactory sqlPageFactory, AliasManager aliasManager, Predicate<Object> ignoreStrategy) {
        this(jdbc, databaseMetadata, tableName, aliasManager.put(tableName), sqlPageFactory, aliasManager,
                ignoreStrategy);
    }

    /**
     * Instantiates a new sql query entity properties.
     *
     * @param jdbc             jdbc
     * @param databaseMetadata databaseMetadata
     * @param tableName        tableName
     * @param tableAlias       tableAlias
     * @param sqlPageFactory   the sql page factory
     * @param aliasManager     aliasManager
     * @param ignoreStrategy     the ignore strategy
     */
    public SqlQueryEntityProperties(Jdbc jdbc, DatabaseMetadata databaseMetadata, String tableName, String tableAlias,
            SqlPageFactory sqlPageFactory, AliasManager aliasManager, Predicate<Object> ignoreStrategy) {
        super(jdbc, databaseMetadata, tableName, tableAlias, sqlPageFactory, aliasManager, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupExpression where() {
        return new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupExpression where(Consumer<ConditionGroupConfig<QueryConditionGroupExpression>> consumer) {
        SqlQueryExpression sqlQueryExpression = new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder,
                ignoreStrategy);
        if (consumer != null) {
            consumer.accept(sqlQueryExpression);
        }
        return sqlQueryExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list() {
        return new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, ignoreStrategy).list();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(Class<E> type) {
        return new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, ignoreStrategy).list(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(RowMapper<E> rowMapper) {
        return new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, ignoreStrategy).list(rowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryLimitExecutor limit(Integer limit) {
        return new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, ignoreStrategy).limit(limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryLimitExecutor limit(Integer offset, Integer limit) {
        return new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, ignoreStrategy).limit(offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryLimitExecutor limit(Page page) {
        return new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, ignoreStrategy).limit(page);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String string() {
        return new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, ignoreStrategy).string();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int intValue() {
        return new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, ignoreStrategy).intValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long longValue() {
        return new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, ignoreStrategy).longValue();
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public Integer integer() {
    //        return new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, ignoreStrategy).integer();
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public Long longInt() {
    //        return new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, ignoreStrategy).longInt();
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public BigDecimal decimal() {
    //        return new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, ignoreStrategy).decimal();
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> N number(Class<N> type) {
        return new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, ignoreStrategy).number(type);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public Long count() {
    //        return new SqlQueryExpression(jdbc, sqlPageFactory, classMapping,
    //                selectBuilder.addColumn(Chars.STAR, AggregateFunction.COUNT), ignoreStrategy).longInt();
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlQueryWithOn join(Join join, String repositoryName) {
        //        return new SqlQueryWith(this, aliasManager, factory, sqlPageFactory, selectBuilder.getTableAlias(), getIdName(),
        //                repositoryName, aliasManager.put(repositoryName), join, ignoreStrategy);
        //        SqlQueryEntityProperties sqlQueryEntityProperties, AliasManager aliasManager,
        //        SqlPageFactory sqlPageFactory, String selectTableAlis, String selectTableColumn, String joinTableName,
        //        String joinTableAlias, Join join, Predicate<Object> ignoreStrategy
        return new SqlQueryWith(this, aliasManager, sqlPageFactory, tableAlias, getIdName(), repositoryName,
                aliasManager.put(repositoryName), join, ignoreStrategy);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> SqlQueryWithOn join(Join join, Class<T> repositoryType) {
    //        //        return new SqlQueryWith(this, aliasManager, factory, sqlPageFactory, selectBuilder.getTableAlias(), getIdName(),
    //        //                repositoryType, join, ignoreStrategy);
    //        return new SqlQueryWith(this, aliasManager, sqlPageFactory, tableAlias, getIdName(), join, ignoreStrategy);
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QuerySortExpression sort() {
        return new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, ignoreStrategy).sort();
    }
}
