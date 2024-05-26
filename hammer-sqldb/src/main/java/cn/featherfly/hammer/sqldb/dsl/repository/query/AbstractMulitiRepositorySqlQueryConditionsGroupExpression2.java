
package cn.featherfly.hammer.sqldb.dsl.repository.query;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.builder.dml.SqlSortBuilder;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.operator.SortOperator;
import cn.featherfly.common.repository.builder.dml.SortBuilder;
import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.query.sort.SetSortFieldExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupExpression2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupLogicExpression2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortedExpression2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryableExpression;
import cn.featherfly.hammer.sqldb.dsl.repository.AbstractMulitiRepositorySqlConditionsGroupExpression2;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryConditionGroupQuery;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.dsl.repository.query.sort.SetSqlSortFieldExpression;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * abstract muliti repository sql query conditions group expression2.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public abstract class AbstractMulitiRepositorySqlQueryConditionsGroupExpression2<
    C extends RepositoryQueryConditionsGroupExpression2<C, L, S, Q>,
    L extends RepositoryQueryConditionsGroupLogicExpression2<C, L, S, Q>, S extends RepositoryQuerySortExpression2<Q>,
    Q extends QueryLimitExecutor> extends
    AbstractMulitiRepositorySqlConditionsGroupExpression2<C, L, QueryConditionConfig, RepositorySqlQueryRelation,
        SqlSelectBasicBuilder>
    implements RepositoryQueryableExpression<S, Q>, //
    //    ,RepositoryQueryConditionsGroupExpression2<C, L, S, Q>, RepositoryQueryConditionsGroupLogicExpression2<C, L, S, Q> //
    RepositoryQuerySortExpression2<Q>, RepositoryQuerySortedExpression2<Q> {

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
    protected AbstractMulitiRepositorySqlQueryConditionsGroupExpression2(L parent, int index,
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

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public Q limit(Limit limit) {
        repositorySqlQueryConditionGroupQuery.setLimit(limit);
        return (Q) this;
    }

    // ****************************************************************************************************************
    // query
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public long count() {
        repositoryRelation.getBuilder().clearColumns().addColumn(AggregateFunction.COUNT, Chars.STAR);
        return repositoryRelation.getJdbc().queryLong(getRoot().expression(), getRoot().getParams().toArray());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list() {
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

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<Map<String, Object>> pagination() {
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

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Object> single() {
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

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Object> unique() {
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
    public RepositoryQuerySortedExpression2<Q> asc(String... names) {
        getRootSortBuilder().asc(names);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression2<Q> asc2(String... names) {
        getRootSortBuilder().asc(repositoryAlias2, () -> names);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression2<Q> asc(
        BiConsumer<SetSortFieldExpression, SetSortFieldExpression> sortExpressions) {
        sortExpressions.accept(new SetSqlSortFieldExpression(sortBuilder, repositoryAlias, SortOperator.ASC),
            new SetSqlSortFieldExpression(sortBuilder, repositoryAlias2, SortOperator.ASC));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression2<Q> desc(String... names) {
        getRootSortBuilder().desc(names);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression2<Q> desc2(String... names) {
        getRootSortBuilder().desc(repositoryAlias2, () -> names);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression2<Q> desc(
        BiConsumer<SetSortFieldExpression, SetSortFieldExpression> sortExpressions) {
        sortExpressions.accept(new SetSqlSortFieldExpression(sortBuilder, repositoryAlias, SortOperator.DESC),
            new SetSqlSortFieldExpression(sortBuilder, repositoryAlias2, SortOperator.DESC));
        return this;
    }

    // ****************************************************************************************************************
    //	private method
    // ****************************************************************************************************************

    // ****************************************************************************************************************
    //	protected method
    // ****************************************************************************************************************

    /**
     * Gets the root sort builder.
     *
     * @return the root sort builder
     */
    @SuppressWarnings("unchecked")
    protected SortBuilder getRootSortBuilder() {
        return ((AbstractMulitiRepositorySqlQueryConditionsGroupExpression2<C, L, S, Q>) getRoot()).sortBuilder;
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
