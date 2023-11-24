
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.exception.NotImplementedException;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.QueryableField;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.common.repository.mapping.RowMapper;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.hammer.config.dsl.QueryConfig;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryFetchedFields;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate1R;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedExpression;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched1F;
import cn.featherfly.hammer.expression.query.FetchField;
import cn.featherfly.hammer.expression.query.FetchFieldImpl;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlQueryRelation;

/**
 * RepositorySqlQueryFetchedFieldsImpl.
 *
 * @author zhongj
 */
public class RepositorySqlQueryFetchedFieldsImpl
        extends AbstractRepositorySqlQueryFetch<RepositoryQueryFetchedFields, RepositoryQueryFetchedFields>
        implements RepositorySqlQueryFetchedFields {

    /**
     * Instantiates a new sql query entity properties.
     *
     * @param repositoryRelation the repository relation
     * @param databaseMetadata   the database metadata
     * @param sqlPageFactory     the sql page factory
     * @param aliasManager       aliasManager
     * @param tableName          tableName
     */
    public RepositorySqlQueryFetchedFieldsImpl(RepositorySqlQueryRelation repositoryRelation,
            DatabaseMetadata databaseMetadata, SqlPageFactory sqlPageFactory, AliasManager aliasManager,
            String tableName) {
        this(repositoryRelation, databaseMetadata, sqlPageFactory, aliasManager, tableName,
                aliasManager.put(tableName));
    }

    /**
     * Instantiates a new sql query entity properties.
     *
     * @param repositoryRelation the repository relation
     * @param databaseMetadata   databaseMetadata
     * @param sqlPageFactory     the sql page factory
     * @param aliasManager       aliasManager
     * @param tableName          tableName
     * @param tableAlias         tableAlias
     */
    public RepositorySqlQueryFetchedFieldsImpl(RepositorySqlQueryRelation repositoryRelation,
            DatabaseMetadata databaseMetadata, SqlPageFactory sqlPageFactory, AliasManager aliasManager,
            String tableName, String tableAlias) {
        super(repositoryRelation, databaseMetadata, sqlPageFactory, aliasManager, tableName, tableAlias);
    }

    /**
     * Instantiates a new repository sql query fetched fields impl.
     *
     * @param repositorySqlQueryFetch the repository sql query fetch
     */
    RepositorySqlQueryFetchedFieldsImpl(AbstractRepositorySqlQueryFetch<?, ?> repositorySqlQueryFetch) {
        super(repositorySqlQueryFetch);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionsGroup where() {
        return new RepositorySqlQueryExpression(repositoryRelation, sqlPageFactory, queryConfig);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionsGroup where(Consumer<RepositoryQueryConditionsGroup> consumer) {
        RepositorySqlQueryExpression repositorySqlQueryExpression = new RepositorySqlQueryExpression(repositoryRelation,
                sqlPageFactory, queryConfig);
        if (consumer != null) {
            consumer.accept(repositorySqlQueryExpression);
        }
        return repositorySqlQueryExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryExpression<RepositoryQueryConditionsGroup, RepositoryQueryConditionsGroupLogic,
            RepositoryQuerySortExpression> configure(Consumer<QueryConfig> configure) {
        if (configure == null) {
            return this;
        }
        configure.accept(queryConfig);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list() {

        return new RepositorySqlQueryExpression(repositoryRelation, sqlPageFactory, queryConfig).list();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(Class<E> type) {
        return new RepositorySqlQueryExpression(repositoryRelation, sqlPageFactory, queryConfig).list(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(RowMapper<E> rowMapper) {
        return new RepositorySqlQueryExpression(repositoryRelation, sqlPageFactory, queryConfig).list(rowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryLimitExecutor limit(Limit limit) {
        return new RepositorySqlQueryExpression(repositoryRelation, sqlPageFactory, queryConfig).limit(limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortExpression sort() {
        return new RepositorySqlQueryExpression(repositoryRelation, sqlPageFactory, queryConfig).sort();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryFetchedFields fetch(Consumer<FetchField> consumer) {
        if (consumer == null) {
            return this;
        }
        FetchFieldImpl fetchField = new FetchFieldImpl();
        consumer.accept(fetchField);
        for (QueryableField field : fetchField.getFields()) {
            fetch(field);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryFetchedFields fetch(BiConsumer<RepositoryQueryFetchedFields, FetchField> consumer) {
        if (consumer == null) {
            return this;
        }
        consumer.accept(this, new FetchFieldImpl());
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryFetchedFields fetch(String... fields) {
        for (String field : fields) {
            fetch(field);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryFetchedFields fetch(Field... fields) {
        for (Field field : fields) {
            fetch(field);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryFetchedFields fetch(AliasField... fields) {
        for (AliasField field : fields) {
            fetch(field);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryFetchedFields fetch(SerializableFunction<?, ?>... fields) {
        for (SerializableFunction<?, ?> field : fields) {
            fetch(field);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryFetchedFields fetch(boolean distinct, String name, String alias) {
        selectBuilder.addColumn(distinct, name, alias);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryFetchedFields fetch(AggregateFunction aggregateFunction, boolean distinct, String columnName,
            String columnAlias) {
        selectBuilder.addColumn(aggregateFunction, distinct, columnName, columnAlias);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryRelatedExpression<RepositoryQueryRelate1R, RepositoryQueryRelatedFetched1F> join(
            String repository) {
        // IMPLSOON 后续来实现
        // FIXME 后续来实现
        throw new NotImplementedException();
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
