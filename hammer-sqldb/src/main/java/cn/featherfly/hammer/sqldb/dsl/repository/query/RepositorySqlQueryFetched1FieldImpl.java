
package cn.featherfly.hammer.sqldb.dsl.repository.query;

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
import java.util.function.Function;

import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression1;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryFetchedFields;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryValueConditionsGroup;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryValueConditionsGroupLogic;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate1R;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.query.FetchField;
import cn.featherfly.hammer.expression.query.QueryValueLimitExecutor;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryValueSortExpression;
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
public class RepositorySqlQueryFetched1FieldImpl
    extends AbstractRepositorySqlQueryBase<RepositoryQueryValueConditionsGroup, QueryValueLimitExecutor>
    implements RepositorySqlQueryFetched1Field {

    /**
     * Instantiates a new sql query entity properties.
     *
     * @param queryRelation  the repository relation
     * @param sqlPageFactory the sql page factory
     */
    public RepositorySqlQueryFetched1FieldImpl(RepositorySqlQueryRelation queryRelation,
        SqlPageFactory sqlPageFactory) {
        super(0, queryRelation, sqlPageFactory);
    }

    /**
     * Instantiates a new repository sql query fetched 1 fields impl.
     *
     * @param repositorySqlQueryFetch the repository sql query fetch
     */
    RepositorySqlQueryFetched1FieldImpl(AbstractRepositorySqlQueryFetch<?, ?, ?, ?> repositorySqlQueryFetch) {
        super(repositorySqlQueryFetch);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryValueConditionsGroup where() {
        return new RepositorySqlQueryValueExpression(queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryValueConditionsGroupLogic where(
        Function<RepositoryFieldOnlyExpression, LogicExpression<?, ?>> function) {
        RepositorySqlQueryValueExpression expr = new RepositorySqlQueryValueExpression(queryRelation, sqlPageFactory);
        RepositoryFieldOnlyExpression field = new RepositoryFieldOnlyExpressionImpl<QueryConditionConfig,
            RepositorySqlQueryRelation, SqlSelectBasicBuilder>(0, queryRelation);
        if (function != null) {
            expr.addCondition(function.apply(field));
        }
        return expr;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list() {
        return new RepositorySqlQueryValueExpression(queryRelation, sqlPageFactory).list();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(Class<E> type) {
        return new RepositorySqlQueryValueExpression(queryRelation, sqlPageFactory).list(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryValueLimitExecutor limit(Limit limit) {
        return new RepositorySqlQueryValueExpression(queryRelation, sqlPageFactory).limit(limit);
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
        return new RepositorySqlQueryValueExpression(queryRelation, sqlPageFactory).string();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date date() {
        return new RepositorySqlQueryValueExpression(queryRelation, sqlPageFactory).date();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDate localDate() {
        return new RepositorySqlQueryValueExpression(queryRelation, sqlPageFactory).localDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime localDateTime() {
        return new RepositorySqlQueryValueExpression(queryRelation, sqlPageFactory).localDateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalTime localTime() {
        return new RepositorySqlQueryValueExpression(queryRelation, sqlPageFactory).localTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp timestamp() {
        return new RepositorySqlQueryValueExpression(queryRelation, sqlPageFactory).timestamp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] bytes() {
        return new RepositorySqlQueryValueExpression(queryRelation, sqlPageFactory).bytes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Clob clob() {
        return new RepositorySqlQueryValueExpression(queryRelation, sqlPageFactory).clob();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Blob blob() {
        return new RepositorySqlQueryValueExpression(queryRelation, sqlPageFactory).blob();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean bool() {
        return new RepositorySqlQueryValueExpression(queryRelation, sqlPageFactory).bool();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte byteValue() {
        return new RepositorySqlQueryValueExpression(queryRelation, sqlPageFactory).byteValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public short shortValue() {
        return new RepositorySqlQueryValueExpression(queryRelation, sqlPageFactory).shortValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int intValue() {
        return new RepositorySqlQueryValueExpression(queryRelation, sqlPageFactory).intValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long longValue() {
        return new RepositorySqlQueryValueExpression(queryRelation, sqlPageFactory).longValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double doubleValue() {
        return new RepositorySqlQueryValueExpression(queryRelation, sqlPageFactory).doubleValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T single() {
        return new RepositorySqlQueryValueExpression(queryRelation, sqlPageFactory).single();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T single(Class<T> type) {
        return new RepositorySqlQueryValueExpression(queryRelation, sqlPageFactory).single(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T unique() {
        return new RepositorySqlQueryValueExpression(queryRelation, sqlPageFactory).unique();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T unique(Class<T> type) {
        return new RepositorySqlQueryValueExpression(queryRelation, sqlPageFactory).unique(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryValueSortExpression sort() {
        return new RepositorySqlQueryValueExpression(queryRelation, sqlPageFactory).sort();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryOnExpression1<RepositoryQueryRelate1R> join(
        Repository repository) {
        // ENHANCE 目前Fetch1Field在join后和其他的一样，后续考虑是否特化
        return new RepositorySqlQueryOn1<>(new RepositorySqlQueryRelate1R(queryRelation, sqlPageFactory), queryRelation,
            repository, relate -> ((RepositorySqlQueryRelate1R) relate).setIdName());
    }
}
