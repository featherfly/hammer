
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryFetchFieldExpression;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlQueryRelation;

/**
 * AbstractRepositorySqlQueryFetch.
 *
 * @author zhongj
 * @param <Q>  the element type
 * @param <Q2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public abstract class AbstractRepositorySqlQueryFetch<Q, Q2, C extends ConditionExpression, L> extends
        AbstractRepositorySqlQuery<C, L> implements RepositoryQueryFetchFieldExpression<Q, Q2>, QueryLimitExecutor {

    /**
     * Instantiates a new abstract sql query entity properties.
     *
     * @param repositoryRelation the repository relation
     * @param sqlPageFactory     the sql page factory
     */
    protected AbstractRepositorySqlQueryFetch(RepositorySqlQueryRelation repositoryRelation,
            SqlPageFactory sqlPageFactory) {
        super(0, repositoryRelation, sqlPageFactory);
    }

    /**
     * Instantiates a new abstract sql query entity properties.
     *
     * @param repositorySqlQueryFetch the repository sql query fetch
     */
    protected AbstractRepositorySqlQueryFetch(AbstractRepositorySqlQueryBase<?, ?> repositorySqlQueryFetch) {
        super(repositorySqlQueryFetch);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public Q field(Consumer<FetchField> consumer) {
    //        if (consumer == null) {
    //            return (Q) this;
    //        }
    //        FetchFieldImpl fetchField = new FetchFieldImpl();
    //        consumer.accept(fetchField);
    //        field(fetchField.getField());
    //        return (Q) this;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public Q2 field(BiConsumer<Q2, FetchField> consumer) {
    //        if (consumer == null) {
    //            return (Q2) this;
    //        }
    //        consumer.accept((Q2) this, new FetchFieldImpl());
    //        return (Q2) this;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public Q2 fields(String... fields) {
    //        for (String field : fields) {
    //            field(field);
    //        }
    //        return (Q2) this;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public Q field(boolean distinct, String name, String alias) {
    //        selectBuilder.addColumn(distinct, name, alias);
    //        return (Q) this;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    @SuppressWarnings("unchecked")
    //    public Q field(AggregateFunction aggregateFunction, boolean distinct, String columnName, String columnAlias) {
    //        selectBuilder.addColumn(aggregateFunction, distinct, columnName, columnAlias);
    //        return (Q) this;
    //    }

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
}
