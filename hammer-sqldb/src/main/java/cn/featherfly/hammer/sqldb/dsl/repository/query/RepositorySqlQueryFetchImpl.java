
package cn.featherfly.hammer.sqldb.dsl.repository.query;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.QueryableField;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.config.dsl.QueryConfig;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression1;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryFetched1Field;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryFetchedFields;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate1R;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.query.FetchField;
import cn.featherfly.hammer.expression.query.FetchFieldImpl;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.dsl.repository.condition.field.RepositoryFieldOnlyExpressionImpl;
import cn.featherfly.hammer.sqldb.dsl.repository.query.relation.RepositorySqlQueryOn1;
import cn.featherfly.hammer.sqldb.dsl.repository.query.relation.RepositorySqlQueryRelate1R;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * SqlQueryProperties.
 *
 * @author zhongj
 */
public class RepositorySqlQueryFetchImpl extends AbstractRepositorySqlQueryFetch<RepositoryQueryFetched1Field,
    RepositoryQueryFetchedFields, RepositoryQueryConditionsGroup, QueryLimitExecutor>
    implements RepositorySqlQueryFetch {

    /**
     * Instantiates a new sql query entity properties.
     *
     * @param repositoryRelation the repository relation
     * @param sqlPageFactory     the sql page factory
     */
    public RepositorySqlQueryFetchImpl(RepositorySqlQueryRelation repositoryRelation, SqlPageFactory sqlPageFactory) {
        super(repositoryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionsGroup where() {
        return new RepositorySqlQueryExpression(queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionsGroupLogic where(
        Function<RepositoryFieldOnlyExpression, LogicExpression<?, ?>> function) {
        RepositorySqlQueryExpression expr = new RepositorySqlQueryExpression(queryRelation, sqlPageFactory);
        if (function != null) {
            // function.apply(expr);
            expr.addCondition(function.apply(new RepositoryFieldOnlyExpressionImpl<>(0, queryRelation)));
        }
        return expr;
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
        configure.accept(queryRelation.getConfig());
        return this;
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public QueryLimitExecutor limit(Limit limit) {
    //        return new RepositorySqlQueryExpression(queryRelation, sqlPageFactory).limit(limit);
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortExpression sort() {
        return new RepositorySqlQueryExpression(queryRelation, sqlPageFactory).sort();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryFetched1Field fetch(Consumer<FetchField> consumer) {
        FetchFieldImpl fetchField = new FetchFieldImpl();
        consumer.accept(fetchField);
        for (QueryableField field : fetchField.getFields()) {
            fetch(field);
        }
        return new RepositorySqlQueryFetched1FieldImpl(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryFetched1Field fetch(boolean distinct, String name, String alias) {
        queryRelation.getBuilder().addColumn(distinct, name, alias);
        return new RepositorySqlQueryFetched1FieldImpl(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryFetched1Field fetch(AggregateFunction aggregateFunction, boolean distinct, String name,
        String alias) {
        queryRelation.getBuilder().addColumn(aggregateFunction, distinct, name, alias);
        return new RepositorySqlQueryFetched1FieldImpl(this);
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
    public RepositoryQueryFetchedFields fetch(SerializableFunction<?, ?>... fields) {
        RepositorySqlQueryFetchedFieldsImpl fetchedFields = new RepositorySqlQueryFetchedFieldsImpl(this);
        fetchedFields.fetch(fields);
        return fetchedFields;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryOnExpression1<RepositoryQueryRelate1R> join(
        Repository repository) {
        return new RepositorySqlQueryOn1<>(new RepositorySqlQueryRelate1R(queryRelation, sqlPageFactory), queryRelation,
            repository, relate -> ((RepositorySqlQueryRelate1R) relate).setIdName());
    }
}
