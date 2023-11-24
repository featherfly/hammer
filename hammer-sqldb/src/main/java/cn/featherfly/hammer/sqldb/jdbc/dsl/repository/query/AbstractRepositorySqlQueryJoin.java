
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.QueryableField;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.hammer.expression.query.FetchField;
import cn.featherfly.hammer.expression.query.FetchFieldImpl;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlQueryRelation;

/**
 * AbstractRepositorySqlQueryFetch.
 *
 * @author zhongj
 * @param <Q> the element type
 */
public abstract class AbstractRepositorySqlQueryJoin<Q extends RepositoryQueryRelateExpression<Q>>
        extends AbstractRepositorySqlQuery<QueryLimitExecutor> implements RepositoryQueryRelateExpression<Q> {

    /** The query relation. */
    protected final RepositorySqlQueryRelation queryRelation;

    /** The index. */
    protected final int index;

    /**
     * Instantiates a new abstract sql query entity properties.
     *
     * @param repositoryRelation the repository relation
     * @param index              the index
     * @param databaseMetadata   databaseMetadata
     * @param sqlPageFactory     the sql page factory
     * @param aliasManager       aliasManager
     * @param tableName          tableName
     * @param tableAlias         tableAlias
     */
    protected AbstractRepositorySqlQueryJoin(RepositorySqlQueryRelation repositoryRelation, int index,
            DatabaseMetadata databaseMetadata, SqlPageFactory sqlPageFactory, AliasManager aliasManager,
            String tableName, String tableAlias) {
        super(repositoryRelation.getJdbc(), databaseMetadata, sqlPageFactory, aliasManager, tableName, tableAlias,
                repositoryRelation.getConfig());
        queryRelation = repositoryRelation;
        this.index = index;
    }

    /**
     * Instantiates a new abstract sql query entity properties.
     *
     * @param repositorySqlQueryFetch the repository sql query fetch
     */
    protected AbstractRepositorySqlQueryJoin(AbstractRepositorySqlQueryJoin<Q> repositorySqlQueryFetch) {
        super(repositorySqlQueryFetch);
        queryRelation = repositorySqlQueryFetch.queryRelation;
        index = repositorySqlQueryFetch.index;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Q fetch() {
        queryRelation.fetch(index);
        return returnThis();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Q fetch(Consumer<FetchField> consumer) {
        FetchFieldImpl fetchField = new FetchFieldImpl();
        consumer.accept(fetchField);
        for (QueryableField field : fetchField.getFields()) {
            fetch(field);
        }
        return returnThis();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Q fetch(BiConsumer<Q, FetchField> consumer) {
        if (consumer == null) {
            return returnThis();
        }
        Q q = returnThis();
        consumer.accept(q, new FetchFieldImpl());
        return q;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Q fetch(String... fields) {
        for (String field : fields) {
            fetch(field);
        }
        return returnThis();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Q fetch(Field... fields) {
        for (Field field : fields) {
            fetch(field);
        }
        return returnThis();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Q fetch(AliasField... fields) {
        for (AliasField field : fields) {
            fetch(field);
        }
        return returnThis();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Q fetch(boolean distinct, String name, String alias) {
        queryRelation.fetch(index, distinct, name, alias);
        return returnThis();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Q fetch(AggregateFunction aggregateFunction, boolean distinct, String name, String alias) {
        queryRelation.fetch(index, aggregateFunction, distinct, name, alias);
        return returnThis();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Q fetch(SerializableFunction<?, ?>... fields) {
        for (SerializableFunction<?, ?> field : fields) {
            fetch(field);
        }
        return returnThis();
    }

    @SuppressWarnings("unchecked")
    private Q returnThis() {
        return (Q) this;
    }
}
