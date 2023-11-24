
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository;

import java.util.List;
import java.util.Map;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.builder.dml.SqlSortBuilder;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
import cn.featherfly.common.function.FiveArgusConsumer;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.operator.SortOperator;
import cn.featherfly.common.repository.builder.dml.SortBuilder;
import cn.featherfly.common.repository.mapping.RowMapper;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.expression.condition.ParamedExpression;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.query.sort.SetSortFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.co.RepositoryContainsExpression5;
import cn.featherfly.hammer.expression.repository.condition.eq.RepositoryEqualsExpression5;
import cn.featherfly.hammer.expression.repository.condition.ew.RepositoryEndWithExpression5;
import cn.featherfly.hammer.expression.repository.condition.ge.RepositoryGreatEqualsExpression5;
import cn.featherfly.hammer.expression.repository.condition.gt.RepositoryGreatThanExpression5;
import cn.featherfly.hammer.expression.repository.condition.in.RepositoryInExpression5;
import cn.featherfly.hammer.expression.repository.condition.inn.RepositoryIsNotNullExpression5;
import cn.featherfly.hammer.expression.repository.condition.isn.RepositoryIsNullExpression5;
import cn.featherfly.hammer.expression.repository.condition.le.RepositoryLessEqualsExpression5;
import cn.featherfly.hammer.expression.repository.condition.lk.RepositoryLikeExpression5;
import cn.featherfly.hammer.expression.repository.condition.lt.RepositoryLessThanExpression5;
import cn.featherfly.hammer.expression.repository.condition.ne.RepositoryNotEqualsExpression5;
import cn.featherfly.hammer.expression.repository.condition.ni.RepositoryNotInExpression5;
import cn.featherfly.hammer.expression.repository.condition.sw.RepositoryStartWithExpression5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupExpression5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupLogicExpression5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortedExpression5;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.sort.SetSqlSortFieldExpression;

/**
 * abstract muliti repository sql query conditions group expression5.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractMulitiRepositorySqlQueryConditionsGroupExpression5<
        C extends RepositoryQueryConditionsGroupExpression5<C, L, S, Q>,
        L extends RepositoryQueryConditionsGroupLogicExpression5<C, L, S, Q>,
        S extends RepositoryQuerySortExpression5<Q>, Q extends QueryLimitExecutor> extends
        AbstractMulitiRepositorySqlConditionsGroupExpressionBase5<C, L, QueryConditionConfig,
                RepositorySqlQueryRelation, SqlSelectBasicBuilder>
        implements RepositoryQueryConditionsGroupExpression5<C, L, S, Q>,
        RepositoryQueryConditionsGroupLogicExpression5<C, L, S, Q>, ParamedExpression,
        RepositoryContainsExpression5<C, L>, RepositoryEndWithExpression5<C, L>, RepositoryEqualsExpression5<C, L>,
        RepositoryGreatEqualsExpression5<C, L>, RepositoryGreatThanExpression5<C, L>, RepositoryInExpression5<C, L>,
        RepositoryIsNotNullExpression5<C, L>, RepositoryIsNullExpression5<C, L>, RepositoryLessEqualsExpression5<C, L>,
        RepositoryLessThanExpression5<C, L>, RepositoryNotEqualsExpression5<C, L>, RepositoryNotInExpression5<C, L>,
        RepositoryStartWithExpression5<C, L>, RepositoryLikeExpression5<C, L> //
        , RepositoryQuerySortExpression5<Q>, RepositoryQuerySortedExpression5<Q> {

    private SqlSortBuilder sortBuilder;

    /** The sql page factory. */
    protected SqlPageFactory sqlPageFactory;

    private final RepositorySqlQueryConditionGroupQuery repositorySqlQueryConditionGroupQuery;

    /**
     * Instantiates a new abstract muliti repository sql query conditions group
     * expression.
     *
     * @param parent             the parent
     * @param index              the index
     * @param repositoryRelation the repository relation
     * @param sqlPageFactory     the sql page factory
     * @param conditionConfig    the condition config
     */
    protected AbstractMulitiRepositorySqlQueryConditionsGroupExpression5(L parent, int index,
            RepositorySqlQueryRelation repositoryRelation, SqlPageFactory sqlPageFactory,
            QueryConditionConfig conditionConfig) {
        super(parent, index, repositoryRelation, conditionConfig);
        this.sqlPageFactory = sqlPageFactory;
        if (parent == null) {
            // use root only, see getRootSortBuilder()
            sortBuilder = new SqlSortBuilder(dialect, repositoryAlias);
        }
        repositorySqlQueryConditionGroupQuery = new RepositorySqlQueryConditionGroupQuery(this, sqlPageFactory,
                repositoryRelation);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Q limit(Limit limit) {
        repositorySqlQueryConditionGroupQuery.setLimit(limit);
        return (Q) this;
    }

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

    @SuppressWarnings("unchecked")
    @Override
    public S sort() {
        return (S) this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression5<Q> asc(String... names) {
        getRootSortBuilder().asc(names);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression5<Q> asc2(String... names) {
        getRootSortBuilder().asc(repositoryAlias2, () -> names);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression5<Q> asc3(String... names) {
        getRootSortBuilder().asc(repositoryAlias3, () -> names);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression5<Q> asc4(String... names) {
        getRootSortBuilder().asc(repositoryAlias4, () -> names);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression5<Q> asc5(String... names) {
        getRootSortBuilder().asc(repositoryAlias5, () -> names);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression5<Q> asc(FiveArgusConsumer<SetSortFieldExpression, SetSortFieldExpression,
            SetSortFieldExpression, SetSortFieldExpression, SetSortFieldExpression> sortExpressions) {
        sortExpressions.accept(new SetSqlSortFieldExpression(sortBuilder, repositoryAlias, SortOperator.ASC),
                new SetSqlSortFieldExpression(sortBuilder, repositoryAlias2, SortOperator.ASC),
                new SetSqlSortFieldExpression(sortBuilder, repositoryAlias3, SortOperator.ASC),
                new SetSqlSortFieldExpression(sortBuilder, repositoryAlias4, SortOperator.ASC),
                new SetSqlSortFieldExpression(sortBuilder, repositoryAlias5, SortOperator.ASC));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression5<Q> desc(String... names) {
        getRootSortBuilder().desc(names);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression5<Q> desc2(String... names) {
        getRootSortBuilder().desc(repositoryAlias2, () -> names);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression5<Q> desc3(String... names) {
        getRootSortBuilder().desc(repositoryAlias3, () -> names);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression5<Q> desc4(String... names) {
        getRootSortBuilder().desc(repositoryAlias4, () -> names);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression5<Q> desc5(String... names) {
        getRootSortBuilder().desc(repositoryAlias5, () -> names);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression5<Q> desc(FiveArgusConsumer<SetSortFieldExpression, SetSortFieldExpression,
            SetSortFieldExpression, SetSortFieldExpression, SetSortFieldExpression> sortExpressions) {
        sortExpressions.accept(new SetSqlSortFieldExpression(sortBuilder, repositoryAlias, SortOperator.DESC),
                new SetSqlSortFieldExpression(sortBuilder, repositoryAlias2, SortOperator.DESC),
                new SetSqlSortFieldExpression(sortBuilder, repositoryAlias3, SortOperator.DESC),
                new SetSqlSortFieldExpression(sortBuilder, repositoryAlias4, SortOperator.DESC),
                new SetSqlSortFieldExpression(sortBuilder, repositoryAlias5, SortOperator.DESC));
        return this;
    }

    // ****************************************************************************************************************
    //	private method
    // ****************************************************************************************************************

    @SuppressWarnings("unchecked")
    protected SortBuilder getRootSortBuilder() {
        return ((AbstractMulitiRepositorySqlQueryConditionsGroupExpression5<C, L, S, Q>) getRoot()).sortBuilder;
    }
}
