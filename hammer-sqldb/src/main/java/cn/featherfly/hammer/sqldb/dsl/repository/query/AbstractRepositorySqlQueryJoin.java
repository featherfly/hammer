
package cn.featherfly.hammer.sqldb.dsl.repository.query;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.QueryableField;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.query.FetchField;
import cn.featherfly.hammer.expression.query.FetchFieldImpl;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * AbstractRepositorySqlQueryFetch.
 *
 * @author zhongj
 * @param <R> the element type
 * @param <C> the generic type
 * @param <Q> the generic type
 */
public abstract class AbstractRepositorySqlQueryJoin<R extends RepositoryQueryRelateExpression<R>,
        C extends ConditionExpression, Q> extends AbstractRepositorySqlQuery<C, Q>
        implements RepositoryQueryRelateExpression<R> {

    /**
     * Instantiates a new abstract sql query entity properties.
     *
     * @param index          the index
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    protected AbstractRepositorySqlQueryJoin(int index, RepositorySqlQueryRelation queryRelation,
            SqlPageFactory sqlPageFactory) {
        super(index, queryRelation, sqlPageFactory);
    }

    /**
     * Instantiates a new abstract sql query entity properties.
     *
     * @param repositorySqlQueryFetch the repository sql query fetch
     */
    protected AbstractRepositorySqlQueryJoin(AbstractRepositorySqlQueryJoin<?, ?, ?> repositorySqlQueryFetch) {
        super(repositorySqlQueryFetch);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public R fetch() {
        queryRelation.fetch(index);
        return createFetched();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public R fetch(Consumer<FetchField> consumer) {
        FetchFieldImpl fetchField = new FetchFieldImpl();
        consumer.accept(fetchField);
        for (QueryableField field : fetchField.getFields()) {
            fetch(field);
        }
        return createFetched();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public R fetch(BiConsumer<R, FetchField> consumer) {
        if (consumer == null) {
            return createFetched();
        }
        R q = createFetched();
        consumer.accept(q, new FetchFieldImpl());
        return q;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public R fetch(String... fields) {
        for (String field : fields) {
            fetch(field);
        }
        return createFetched();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public R fetch(Field... fields) {
        for (Field field : fields) {
            fetch(field);
        }
        return createFetched();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public R fetch(boolean distinct, String name, String alias) {
        queryRelation.fetch(index, distinct, name, alias);
        return createFetched();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public R fetch(AggregateFunction aggregateFunction, boolean distinct, String name, String alias) {
        queryRelation.fetch(index, aggregateFunction, distinct, name, alias);
        return createFetched();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public R fetch(SerializableFunction<?, ?>... fields) {
        for (SerializableFunction<?, ?> field : fields) {
            fetch(field);
        }
        return createFetched();
    }

    /**
     * Creates the fetched.
     *
     * @return the r
     */
    protected abstract R createFetched();
}
