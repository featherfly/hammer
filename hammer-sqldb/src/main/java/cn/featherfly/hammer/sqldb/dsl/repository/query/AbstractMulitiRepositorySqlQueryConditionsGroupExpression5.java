
package cn.featherfly.hammer.sqldb.dsl.repository.query;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.builder.dml.SqlSortBuilder;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
import cn.featherfly.common.function.FiveArgusConsumer;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.operator.SortOperator;
import cn.featherfly.common.repository.builder.dml.SortBuilder;
import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.common.tuple.Tuple2;
import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.query.sort.SetSortFieldExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupExpression5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupLogicExpression5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortedExpression5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryable5;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortExpression;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortedExpression;
import cn.featherfly.hammer.sqldb.dsl.repository.AbstractMulitiRepositorySqlConditionsGroupExpression5;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryConditionGroupQuery;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.dsl.repository.query.sort.SetSqlSortFieldExpression;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * abstract muliti repository sql query conditions group expression5.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 * @param <D> the generic type
 * @param <Q> the generic type
 */
public abstract class AbstractMulitiRepositorySqlQueryConditionsGroupExpression5<
    C extends RepositoryQueryConditionsGroupExpression5<C, L, S, D, Q>,
    L extends RepositoryQueryConditionsGroupLogicExpression5<C, L, S, D, Q>,
    S extends RepositoryQuerySortExpression5<D, Q>, D extends RepositoryQuerySortedExpression5<D, Q>,
    Q extends QueryLimitExecutor> extends
    AbstractMulitiRepositorySqlConditionsGroupExpression5<C, L, QueryConditionConfig, RepositorySqlQueryRelation,
        SqlSelectBasicBuilder>
    implements RepositoryQueryable5<S, D, Q>, //
    //        RepositoryQueryConditionsGroupExpression5<C, L, S, Q>,RepositoryQueryConditionsGroupLogicExpression5<C, L, S, Q>,
    RepositoryQuerySortExpression5<D, Q>, RepositoryQuerySortedExpression5<D, Q> {

    private SqlSortBuilder sortBuilder;

    /** The sql page factory. */
    protected SqlPageFactory sqlPageFactory;

    /** The repository sql query condition group query. */
    protected final RepositorySqlQueryConditionGroupQuery repositorySqlQueryConditionGroupQuery;

    /**
     * Instantiates a new abstract muliti repository sql query conditions group expression.
     *
     * @param parent the parent
     * @param index the index
     * @param queryRelation the query relation
     * @param sqlPageFactory the sql page factory
     */
    protected AbstractMulitiRepositorySqlQueryConditionsGroupExpression5(L parent, int index,
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

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public Q limit(Limit limit) {
        repositorySqlQueryConditionGroupQuery.setLimit(limit);
        return (Q) this;
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
    public List<Map<String, Serializable>> list() {
        return repositorySqlQueryConditionGroupQuery.list();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(Class<E> type) {
        return repositorySqlQueryConditionGroupQuery.list(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(RowMapper<E> rowMapper) {
        return repositorySqlQueryConditionGroupQuery.list(rowMapper);
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
    public <E> PaginationResults<E> pagination(Class<E> type) {
        return repositorySqlQueryConditionGroupQuery.pagination(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> PaginationResults<E> pagination(RowMapper<E> rowMapper) {
        return repositorySqlQueryConditionGroupQuery.pagination(rowMapper);
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
    public <E> E single(Class<E> type) {
        return repositorySqlQueryConditionGroupQuery.single(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E single(RowMapper<E> rowMapper) {
        return repositorySqlQueryConditionGroupQuery.single(rowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Serializable> unique() {
        return repositorySqlQueryConditionGroupQuery.unique();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E unique(Class<E> type) {
        return repositorySqlQueryConditionGroupQuery.unique(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E unique(RowMapper<E> rowMapper) {
        return repositorySqlQueryConditionGroupQuery.unique(rowMapper);
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
        S3 extends RepositorySortedExpression<S3>, S4 extends RepositorySortedExpression<S4>,
        S5 extends RepositorySortedExpression<S5>> D sort(
            FiveArgusConsumer<RepositorySortExpression<S1>, RepositorySortExpression<S2>, RepositorySortExpression<S3>,
                RepositorySortExpression<S4>, RepositorySortExpression<S5>> repositorySortExpresions) {
        if (repositorySortExpresions != null) {
            repositorySortExpresions.accept(new RepositorySortExpressionImpl<>(repositoryAlias, getRootSortBuilder()),
                new RepositorySortExpressionImpl<>(repositoryAlias2, getRootSortBuilder()),
                new RepositorySortExpressionImpl<>(repositoryAlias3, getRootSortBuilder()),
                new RepositorySortExpressionImpl<>(repositoryAlias4, getRootSortBuilder()),
                new RepositorySortExpressionImpl<>(repositoryAlias5, getRootSortBuilder()));
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
    public D asc4(String... names) {
        getRootSortBuilder().asc(repositoryAlias4, () -> names);
        return (D) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public D asc5(String... names) {
        getRootSortBuilder().asc(repositoryAlias5, () -> names);
        return (D) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public D asc(FiveArgusConsumer<SetSortFieldExpression, SetSortFieldExpression, SetSortFieldExpression,
        SetSortFieldExpression, SetSortFieldExpression> sortExpressions) {
        sortExpressions.accept(new SetSqlSortFieldExpression(sortBuilder, repositoryAlias, SortOperator.ASC),
            new SetSqlSortFieldExpression(sortBuilder, repositoryAlias2, SortOperator.ASC),
            new SetSqlSortFieldExpression(sortBuilder, repositoryAlias3, SortOperator.ASC),
            new SetSqlSortFieldExpression(sortBuilder, repositoryAlias4, SortOperator.ASC),
            new SetSqlSortFieldExpression(sortBuilder, repositoryAlias5, SortOperator.ASC));
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
    public D desc4(String... names) {
        getRootSortBuilder().desc(repositoryAlias4, () -> names);
        return (D) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public D desc5(String... names) {
        getRootSortBuilder().desc(repositoryAlias5, () -> names);
        return (D) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public D desc(FiveArgusConsumer<SetSortFieldExpression, SetSortFieldExpression, SetSortFieldExpression,
        SetSortFieldExpression, SetSortFieldExpression> sortExpressions) {
        sortExpressions.accept(new SetSqlSortFieldExpression(sortBuilder, repositoryAlias, SortOperator.DESC),
            new SetSqlSortFieldExpression(sortBuilder, repositoryAlias2, SortOperator.DESC),
            new SetSqlSortFieldExpression(sortBuilder, repositoryAlias3, SortOperator.DESC),
            new SetSqlSortFieldExpression(sortBuilder, repositoryAlias4, SortOperator.DESC),
            new SetSqlSortFieldExpression(sortBuilder, repositoryAlias5, SortOperator.DESC));
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
        return ((AbstractMulitiRepositorySqlQueryConditionsGroupExpression5<C, L, S, D, Q>) getRoot()).sortBuilder;
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
