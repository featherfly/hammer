
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.common.repository.mapping.RowMapper;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.hammer.config.dsl.QueryConfig;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryFetched1Fields;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedExpression;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.query.AbstractRepositorySqlQueryFetch;

/**
 * SqlQueryProperties.
 *
 * @author zhongj
 */
public class RepositorySqlQueryFetchImpl extends AbstractRepositorySqlQueryFetch<RepositoryQueryFetched1Fields>
        implements RepositorySqlQueryFetch {

    /**
     * Instantiates a new sql query entity properties.
     *
     * @param jdbc             jdbc
     * @param databaseMetadata the database metadata
     * @param tableName        tableName
     * @param sqlPageFactory   the sql page factory
     * @param aliasManager     aliasManager
     * @param ignoreStrategy   the ignore strategy
     */
    public RepositorySqlQueryFetchImpl(Jdbc jdbc, DatabaseMetadata databaseMetadata, String tableName,
            SqlPageFactory sqlPageFactory, AliasManager aliasManager, QueryConfig queryConfig) {
        this(jdbc, databaseMetadata, tableName, aliasManager.put(tableName), sqlPageFactory, aliasManager, queryConfig);
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
     * @param ignoreStrategy   the ignore strategy
     */
    public RepositorySqlQueryFetchImpl(Jdbc jdbc, DatabaseMetadata databaseMetadata, String tableName,
            String tableAlias, SqlPageFactory sqlPageFactory, AliasManager aliasManager, QueryConfig queryConfig) {
        super(jdbc, databaseMetadata, tableName, tableAlias, sqlPageFactory, aliasManager, queryConfig);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionsGroup where() {
        return new RepositorySqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionsGroup where(Consumer<RepositoryQueryConditionsGroup> consumer) {
        RepositorySqlQueryExpression repositorySqlQueryExpression = new RepositorySqlQueryExpression(jdbc,
                sqlPageFactory, selectBuilder, queryConfig);
        if (consumer != null) {
            consumer.accept(repositorySqlQueryExpression);
        }
        return repositorySqlQueryExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryExpression<RepositoryQueryConditionsGroup, RepositoryQueryConditionsGroupLogic, RepositoryQuerySortExpression> configure(
            Consumer<QueryConfig> configure) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list() {
        return new RepositorySqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).list();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(Class<E> type) {
        return new RepositorySqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).list(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(RowMapper<E> rowMapper) {
        return new RepositorySqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).list(rowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryLimitExecutor limit(Integer limit) {
        return new RepositorySqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).limit(limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryLimitExecutor limit(Integer offset, Integer limit) {
        return new RepositorySqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).limit(offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryLimitExecutor limit(Page page) {
        return new RepositorySqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).limit(page);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public String string() {
    //        return new RepositorySqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).string();
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public Date date() {
    //        return new RepositorySqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).date();
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public LocalDate localDate() {
    //        return new RepositorySqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).localDate();
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public LocalDateTime localDateTime() {
    //        return new RepositorySqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).localDateTime();
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public LocalTime localTime() {
    //        return new RepositorySqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).localTime();
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public Timestamp timestamp() {
    //        return new RepositorySqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).timestamp();
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public byte[] bytes() {
    //        return new RepositorySqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).bytes();
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public Clob clob() {
    //        return new RepositorySqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).clob();
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public Blob blob() {
    //        return new RepositorySqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).blob();
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public boolean bool() {
    //        return new RepositorySqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).bool();
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public byte byteValue() {
    //        return new RepositorySqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).byteValue();
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public short shortValue() {
    //        return new RepositorySqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).shortValue();
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public int intValue() {
    //        return new RepositorySqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).intValue();
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public long longValue() {
    //        return new RepositorySqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).longValue();
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> T value(Class<T> type) {
    //        return new RepositorySqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).value(type);
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> SqlQueryWithOn join(Join join, Class<T> repositoryType) {
    //        //        return new SqlQueryWith(this, aliasManager, factory, sqlPageFactory, selectBuilder.getTableAlias(), getIdName(),
    //        //                repositoryType, join, queryConfig);
    //        return new SqlQueryWith(this, aliasManager, sqlPageFactory, tableAlias, getIdName(), join, queryConfig);
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortExpression sort() {
        return new RepositorySqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).sort();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> RepositoryQueryRelatedExpression<?, ?> join(String repository) {
        // IMPLSOON 后续来实现
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> RepositoryQueryRelatedExpression<?, ?> join(Field repository) {
        // IMPLSOON 后续来实现
        return null;
    }

    //    public RepositoryQueryRelatedExpression<?, ?> join(Join join, String repositoryName) {
    //        //        return new SqlQueryWith(this, aliasManager, factory, sqlPageFactory, selectBuilder.getTableAlias(), getIdName(),
    //        //                repositoryName, aliasManager.put(repositoryName), join, queryConfig);
    //        //        SqlQueryEntityProperties sqlQueryEntityProperties, AliasManager aliasManager,
    //        //        SqlPageFactory sqlPageFactory, String selectTableAlis, String selectTableColumn, String joinTableName,
    //        //        String joinTableAlias, Join join, Predicate<?> ignoreStrategy
    //        return new SqlQueryWith(this, aliasManager, sqlPageFactory, tableAlias, getIdName(), repositoryName,
    //                aliasManager.put(repositoryName), join, queryConfig.getIgnoreStrategy());
    //    }
}
