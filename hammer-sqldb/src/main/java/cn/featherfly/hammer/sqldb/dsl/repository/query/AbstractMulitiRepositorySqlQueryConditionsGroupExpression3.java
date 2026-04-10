
package cn.featherfly.hammer.sqldb.dsl.repository.query;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.builder.dml.SqlSortBuilder;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
import cn.featherfly.common.function.ThConsumer;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.operator.SortOperator;
import cn.featherfly.common.repository.RowIterable;
import cn.featherfly.common.repository.builder.dml.SortBuilder;
import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.common.repository.mapper.TupleRowMapperBuilder;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.common.tuple.Tuple2;
import cn.featherfly.data.query.LimitAwareQuery0;
import cn.featherfly.data.query.QueryExecutor;
import cn.featherfly.data.query.QueryPageExecutor;
import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.expression.query.sort.SetSortFieldExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupExpression3;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupLogicExpression3;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression3;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortedExpression3;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryable3;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortExpression;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortedExpression;
import cn.featherfly.hammer.sqldb.dsl.repository.AbstractMulitiRepositorySqlConditionsGroupExpression3;
import cn.featherfly.hammer.sqldb.dsl.repository.LimitAwareRepositoryQuery;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryConditionGroupQuery;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryLimitExecutor;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.dsl.repository.query.sort.SetSqlSortFieldExpression;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.mapper.TupleRowMapperBuilderImpl;

/**
 * abstract muliti repository sql query conditions group expression3.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 * @param <D> the generic type
 * @param <Q> the generic type
 */
public abstract class AbstractMulitiRepositorySqlQueryConditionsGroupExpression3<
    C extends RepositoryQueryConditionsGroupExpression3<C, L, S, D, Q>,
    L extends RepositoryQueryConditionsGroupLogicExpression3<C, L, S, D, Q>,
    S extends RepositoryQuerySortExpression3<D, Q>, D extends RepositoryQuerySortedExpression3<D, Q>,
    Q extends LimitAwareQuery0<Map<String, Serializable>>> extends
    AbstractMulitiRepositorySqlConditionsGroupExpression3<C, L, QueryConditionConfig, RepositorySqlQueryRelation,
        SqlSelectBasicBuilder>
    implements RepositoryQueryable3<S, D, Q>, //
    //        RepositoryQueryConditionsGroupExpression3<C, L, S, Q>,RepositoryQueryConditionsGroupLogicExpression3<C, L, S, Q>,
    RepositoryQuerySortExpression3<D, Q>, RepositoryQuerySortedExpression3<D, Q>,
    QueryPageExecutor<Map<String, Serializable>> {

    private SqlSortBuilder sortBuilder;

    /** The sql page factory. */
    protected SqlPageFactory sqlPageFactory;

    /** The repository sql query condition group query. */
    protected final RepositorySqlQueryConditionGroupQuery repositorySqlQueryConditionGroupQuery;

    /**
     * Instantiates a new abstract muliti repository sql query conditions group
     * expression.
     *
     * @param parent the parent
     * @param index the index
     * @param queryRelation the query relation
     * @param sqlPageFactory the sql page factory
     */
    protected AbstractMulitiRepositorySqlQueryConditionsGroupExpression3(L parent, int index,
        RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        super(parent, index, queryRelation);
        this.sqlPageFactory = sqlPageFactory;
        if (parent == null) {
            // use root only, see getRootSortBuilder()
            sortBuilder = new SqlSortBuilder(dialect, repositoryAlias);
        }
        repositorySqlQueryConditionGroupQuery = new RepositorySqlQueryConditionGroupQuery(this, sqlPageFactory,
            queryRelation);
    }

    // ****************************************************************************************************************
    // field
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public Q limit(Limit limit) {
        repositorySqlQueryConditionGroupQuery.setLimit(limit);
        return (Q) new LimitAwareRepositoryQuery(repositorySqlQueryConditionGroupQuery);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long count() {
        repositoryRelation.getBuilder().clearColumns().addColumn(AggregateFunction.COUNT, Chars.STAR);
        return repositoryRelation.getJdbc().queryLong(getRoot().expression(), getRoot().getParamsArray());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RowIterable<Map<String, Serializable>> each() {
        return repositorySqlQueryConditionGroupQuery.each();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Serializable>> list() {
        return repositorySqlQueryConditionGroupQuery.list();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<Map<String, Serializable>> pagination() {
        return repositorySqlQueryConditionGroupQuery.pagination();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Serializable> single() {
        return repositorySqlQueryConditionGroupQuery.single();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Serializable> unique() {
        return repositorySqlQueryConditionGroupQuery.unique();
    }

    // ****************************************************************************************************************
    //  mapper
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> QueryExecutor<T> mapper(RowMapper<T> rowMapper) {
        return new RepositorySqlQueryLimitExecutor<>(repositorySqlQueryConditionGroupQuery, rowMapper);
    }

    public <T> QueryExecutor<T> mapper(Class<T> type) {
        return mapper(repositorySqlQueryConditionGroupQuery.createRowMapper(type));
    }

    public <T> QueryExecutor<T> mapper(Function<TupleRowMapperBuilder, RowMapper<T>> tupleRowMapperBuilderFunction) {
        return mapper(tupleRowMapperBuilderFunction
            .apply(new TupleRowMapperBuilderImpl(repositorySqlQueryConditionGroupQuery::createRowMapper)));
    }

    // ****************************************************************************************************************
    //	sort
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public S sort() {
        return (S) this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public <S1 extends RepositorySortedExpression<S1>, S2 extends RepositorySortedExpression<S2>,
        S3 extends RepositorySortedExpression<S3>> D sort(ThConsumer<RepositorySortExpression<S1>,
            RepositorySortExpression<S2>, RepositorySortExpression<S3>> repositorySortExpresions) {
        if (repositorySortExpresions != null) {
            repositorySortExpresions.accept(new RepositorySortExpressionImpl<>(repositoryAlias, getRootSortBuilder()),
                new RepositorySortExpressionImpl<>(repositoryAlias2, getRootSortBuilder()),
                new RepositorySortExpressionImpl<>(repositoryAlias3, getRootSortBuilder()));
        }
        return (D) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public D asc(String... names) {
        getRootSortBuilder().asc(names);
        return (D) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public D asc2(String... names) {
        getRootSortBuilder().asc(repositoryAlias2, () -> names);
        return (D) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public D asc3(String... names) {
        getRootSortBuilder().asc(repositoryAlias3, () -> names);
        return (D) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public D asc(ThConsumer<SetSortFieldExpression, SetSortFieldExpression, SetSortFieldExpression> sortExpressions) {
        sortExpressions.accept(new SetSqlSortFieldExpression(sortBuilder, repositoryAlias, SortOperator.ASC),
            new SetSqlSortFieldExpression(sortBuilder, repositoryAlias2, SortOperator.ASC),
            new SetSqlSortFieldExpression(sortBuilder, repositoryAlias3, SortOperator.ASC));
        return (D) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public D desc(String... names) {
        getRootSortBuilder().desc(names);
        return (D) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public D desc2(String... names) {
        getRootSortBuilder().desc(repositoryAlias2, () -> names);
        return (D) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public D desc3(String... names) {
        getRootSortBuilder().desc(repositoryAlias3, () -> names);
        return (D) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public D desc(ThConsumer<SetSortFieldExpression, SetSortFieldExpression, SetSortFieldExpression> sortExpressions) {
        sortExpressions.accept(new SetSqlSortFieldExpression(sortBuilder, repositoryAlias, SortOperator.DESC),
            new SetSqlSortFieldExpression(sortBuilder, repositoryAlias2, SortOperator.DESC),
            new SetSqlSortFieldExpression(sortBuilder, repositoryAlias3, SortOperator.DESC));
        return (D) this;
    }

    // ****************************************************************************************************************
    //	private method
    // ****************************************************************************************************************

    /**
     * Gets the root sort builder.
     *
     * @return the root sort builder
     */
    @SuppressWarnings("unchecked")
    protected SortBuilder getRootSortBuilder() {
        return ((AbstractMulitiRepositorySqlQueryConditionsGroupExpression3<C, L, S, D, Q>) getRoot()).sortBuilder;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {
        return AbstractMulitiRepositorySqlQueryConditionsGroupExpression.expression(super.expression(), parent,
            repositoryRelation, getRootSortBuilder(), dialect);
    }

    /**
     * Expression page.
     *
     * @return the tuple 2
     */
    public Tuple2<String, String> expressionPage() {
        return AbstractMulitiRepositorySqlQueryConditionsGroupExpression.expressionPage(super.expression(), parent,
            repositoryRelation, getRootSortBuilder(), dialect);
    }
}
