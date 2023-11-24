
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query;

import java.sql.Blob;
import java.sql.Clob;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.exception.NotImplementedException;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryFetchedFields;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryValueConditionsGroup;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate1R;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedExpression;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched1F;
import cn.featherfly.hammer.expression.query.FetchField;
import cn.featherfly.hammer.expression.query.QueryValueLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryValueSortExpression;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlQueryRelation;

/**
 * SqlQueryProperties.
 *
 * @author zhongj
 */
public class RepositorySqlQueryFetched1FieldsImpl
        extends AbstractRepositorySqlQueryFetch<RepositoryQueryFetchedFields, RepositoryQueryFetchedFields>
        implements RepositorySqlQueryFetched1Fields {

    /**
     * Instantiates a new sql query entity properties.
     *
     * @param repositoryRelation the repository relation
     * @param databaseMetadata   the database metadata
     * @param sqlPageFactory     the sql page factory
     * @param aliasManager       aliasManager
     * @param tableName          tableName
     */
    public RepositorySqlQueryFetched1FieldsImpl(RepositorySqlQueryRelation repositoryRelation,
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
    public RepositorySqlQueryFetched1FieldsImpl(RepositorySqlQueryRelation repositoryRelation,
            DatabaseMetadata databaseMetadata, SqlPageFactory sqlPageFactory, AliasManager aliasManager,
            String tableName, String tableAlias) {
        super(repositoryRelation, databaseMetadata, sqlPageFactory, aliasManager, tableName, tableAlias);
    }

    /**
     * Instantiates a new repository sql query fetched 1 fields impl.
     *
     * @param repositorySqlQueryFetch the repository sql query fetch
     */
    RepositorySqlQueryFetched1FieldsImpl(AbstractRepositorySqlQueryFetch<?, ?> repositorySqlQueryFetch) {
        super(repositorySqlQueryFetch);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryValueConditionsGroup where() {
        return new RepositorySqlQueryValueExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryValueConditionsGroup where(Consumer<RepositoryQueryValueConditionsGroup> consumer) {
        RepositorySqlQueryValueExpression repositorySqlQueryExpression = new RepositorySqlQueryValueExpression(jdbc,
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
    public <E> List<E> list() {
        return new RepositorySqlQueryValueExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).list();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(Class<E> type) {
        return new RepositorySqlQueryValueExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).list(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryValueLimitExecutor limit(Limit limit) {
        return new RepositorySqlQueryValueExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).limit(limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryFetchedFields fetch(Consumer<FetchField> consumer) {
        RepositorySqlQueryFetchedFieldsImpl fetchedFields = new RepositorySqlQueryFetchedFieldsImpl(this);
        fetchedFields.fetch(consumer);
        return fetchedFields;
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
    public RepositoryQueryFetchedFields fetch(boolean distinct, String name, String alias) {
        RepositorySqlQueryFetchedFieldsImpl fetchedFields = new RepositorySqlQueryFetchedFieldsImpl(this);
        fetchedFields.fetch(distinct, name, alias);
        return fetchedFields;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryFetchedFields fetch(AggregateFunction aggregateFunction, boolean distinct, String columnName,
            String columnAlias) {
        RepositorySqlQueryFetchedFieldsImpl fetchedFields = new RepositorySqlQueryFetchedFieldsImpl(this);
        fetchedFields.fetch(aggregateFunction, distinct, columnName, columnAlias);
        return fetchedFields;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String string() {
        return new RepositorySqlQueryValueExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).string();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date date() {
        return new RepositorySqlQueryValueExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).date();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDate localDate() {
        return new RepositorySqlQueryValueExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).localDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime localDateTime() {
        return new RepositorySqlQueryValueExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).localDateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalTime localTime() {
        return new RepositorySqlQueryValueExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).localTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp timestamp() {
        return new RepositorySqlQueryValueExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).timestamp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] bytes() {
        return new RepositorySqlQueryValueExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).bytes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Clob clob() {
        return new RepositorySqlQueryValueExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).clob();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Blob blob() {
        return new RepositorySqlQueryValueExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).blob();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean bool() {
        return new RepositorySqlQueryValueExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).bool();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte byteValue() {
        return new RepositorySqlQueryValueExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).byteValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public short shortValue() {
        return new RepositorySqlQueryValueExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).shortValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int intValue() {
        return new RepositorySqlQueryValueExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).intValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long longValue() {
        return new RepositorySqlQueryValueExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).longValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double doubleValue() {
        return new RepositorySqlQueryValueExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).doubleValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T single() {
        return new RepositorySqlQueryValueExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).single();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T single(Class<T> type) {
        return new RepositorySqlQueryValueExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).single(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T unique() {
        return new RepositorySqlQueryValueExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).unique();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T unique(Class<T> type) {
        return new RepositorySqlQueryValueExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).unique(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryValueSortExpression sort() {
        return new RepositorySqlQueryValueExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).sort();
    }

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
    public RepositoryQueryRelatedExpression<RepositoryQueryRelate1R, RepositoryQueryRelatedFetched1F> join(
            String repository) {
        // IMPLSOON 后续来实现
        // FIXME 后续来实现
        throw new NotImplementedException();
    }
}
