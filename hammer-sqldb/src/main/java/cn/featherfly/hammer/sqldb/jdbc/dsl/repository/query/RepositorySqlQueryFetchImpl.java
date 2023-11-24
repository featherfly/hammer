
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import cn.featherfly.common.db.metadata.DatabaseMetadata;
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
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryFetched1Fields;
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
 * SqlQueryProperties.
 *
 * @author zhongj
 */
public class RepositorySqlQueryFetchImpl
        extends AbstractRepositorySqlQueryFetch<RepositoryQueryFetched1Fields, RepositoryQueryFetchedFields>
        implements RepositorySqlQueryFetch {

    /**
     * Instantiates a new sql query entity properties.
     *
     * @param repositoryRelation the repository relation
     * @param databaseMetadata   the database metadata
     * @param sqlPageFactory     the sql page factory
     * @param aliasManager       aliasManager
     * @param tableName          tableName
     */
    public RepositorySqlQueryFetchImpl(RepositorySqlQueryRelation repositoryRelation, DatabaseMetadata databaseMetadata,
            SqlPageFactory sqlPageFactory, AliasManager aliasManager, String tableName) {
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
    public RepositorySqlQueryFetchImpl(RepositorySqlQueryRelation repositoryRelation, DatabaseMetadata databaseMetadata,
            SqlPageFactory sqlPageFactory, AliasManager aliasManager, String tableName, String tableAlias) {
        super(repositoryRelation, databaseMetadata, sqlPageFactory, aliasManager, tableName, tableAlias);
        repositoryRelation.query(tableName, tableAlias).fetch(0);
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
        RepositoryQueryConditionsGroup repositorySqlQueryExpression = where();
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
    public RepositoryQueryFetched1Fields fetch(Consumer<FetchField> consumer) {
        FetchFieldImpl fetchField = new FetchFieldImpl();
        consumer.accept(fetchField);
        for (QueryableField field : fetchField.getFields()) {
            fetch(field);
        }
        return new RepositorySqlQueryFetched1FieldsImpl(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryFetched1Fields fetch(boolean distinct, String name, String alias) {
        selectBuilder.addColumn(distinct, name, alias);
        return new RepositorySqlQueryFetched1FieldsImpl(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryFetched1Fields fetch(AggregateFunction aggregateFunction, boolean distinct, String name,
            String alias) {
        selectBuilder.addColumn(aggregateFunction, distinct, name, alias);
        return new RepositorySqlQueryFetched1FieldsImpl(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryFetchedFields fetch(BiConsumer<RepositoryQueryFetchedFields, FetchField> consumer) {
        RepositorySqlQueryFetchedFieldsImpl fetchedFields = new RepositorySqlQueryFetchedFieldsImpl(this);
        fetchedFields.fetch(consumer);
        return fetchedFields;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryFetchedFields fetch(String... fields) {
        RepositorySqlQueryFetchedFieldsImpl fetchedFields = new RepositorySqlQueryFetchedFieldsImpl(this);
        fetchedFields.fetch(fields);
        return fetchedFields;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryFetchedFields fetch(Field... fields) {
        RepositorySqlQueryFetchedFieldsImpl fetchedFields = new RepositorySqlQueryFetchedFieldsImpl(this);
        fetchedFields.fetch(fields);
        return fetchedFields;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryFetchedFields fetch(AliasField... fields) {
        RepositorySqlQueryFetchedFieldsImpl fetchedFields = new RepositorySqlQueryFetchedFieldsImpl(this);
        fetchedFields.fetch(fields);
        return fetchedFields;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryFetchedFields fetch(SerializableFunction<?, ?>... fields) {
        RepositorySqlQueryFetchedFieldsImpl fetchedFields = new RepositorySqlQueryFetchedFieldsImpl(this);
        fetchedFields.fetch(fields);
        return fetchedFields;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryRelatedExpression<RepositoryQueryRelate1R, RepositoryQueryRelatedFetched1F> join(
            String repository) {
        //        new RepositorySqlQueryRelated<>(new RepositorySqlQueryRelate1R(), repositoryRelation, repository, 0);
        // IMPLSOON 后续来实现join
        return null;
    }

}
