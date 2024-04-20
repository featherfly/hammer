
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.QueryableField;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.config.dsl.QueryConfig;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryFetchedFields;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryOnExpression1;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate1R;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched1F;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.query.FetchField;
import cn.featherfly.hammer.expression.query.FetchFieldImpl;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.field.RepositoryFieldOnlyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.relation.RepositorySqlQueryOn1;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.relation.RepositorySqlQueryRelate1R;

/**
 * RepositorySqlQueryFetchedFieldsImpl.
 *
 * @author zhongj
 */
public class RepositorySqlQueryFetchedFieldsImpl extends AbstractRepositorySqlQueryFetch<RepositoryQueryFetchedFields,
    RepositoryQueryFetchedFields, RepositoryQueryConditionsGroup, QueryLimitExecutor>
    implements RepositorySqlQueryFetchedFields {

    /**
     * Instantiates a new sql query entity properties.
     *
     * @param queryRelation    the repository relation
     * @param databaseMetadata the database metadata
     * @param sqlPageFactory   the sql page factory
     * @param aliasManager     aliasManager
     * @param tableName        tableName
     */
    public RepositorySqlQueryFetchedFieldsImpl(RepositorySqlQueryRelation queryRelation,
        SqlPageFactory sqlPageFactory) {
        super(queryRelation, sqlPageFactory);
    }

    /**
     * Instantiates a new repository sql query fetched fields impl.
     *
     * @param repositorySqlQueryFetch the repository sql query fetch
     */
    RepositorySqlQueryFetchedFieldsImpl(AbstractRepositorySqlQueryBase<?, ?> repositorySqlQueryFetch) {
        super(repositorySqlQueryFetch);
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
        queryRelation.getBuilder().addColumn(distinct, name, alias);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryFetchedFields fetch(AggregateFunction aggregateFunction, boolean distinct, String columnName,
        String columnAlias) {
        queryRelation.getBuilder().addColumn(aggregateFunction, distinct, columnName, columnAlias);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryOnExpression1<RepositoryQueryRelate1R, RepositoryQueryRelatedFetched1F> join(
        Repository repository) {
        return new RepositorySqlQueryOn1<>(new RepositorySqlQueryRelate1R(queryRelation, sqlPageFactory), queryRelation,
            repository, relate -> ((RepositorySqlQueryRelate1R) relate).setIdName());
    }
}
