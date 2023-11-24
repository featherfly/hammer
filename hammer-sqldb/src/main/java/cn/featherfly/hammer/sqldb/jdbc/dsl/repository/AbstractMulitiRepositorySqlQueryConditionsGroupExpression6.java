
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository;

import java.util.List;
import java.util.Map;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.builder.dml.SqlSortBuilder;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
import cn.featherfly.common.function.SixArgusConsumer;
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
import cn.featherfly.hammer.expression.repository.condition.co.RepositoryContainsExpression6;
import cn.featherfly.hammer.expression.repository.condition.eq.RepositoryEqualsExpression6;
import cn.featherfly.hammer.expression.repository.condition.ew.RepositoryEndWithExpression6;
import cn.featherfly.hammer.expression.repository.condition.ge.RepositoryGreatEqualsExpression6;
import cn.featherfly.hammer.expression.repository.condition.gt.RepositoryGreatThanExpression6;
import cn.featherfly.hammer.expression.repository.condition.in.RepositoryInExpression6;
import cn.featherfly.hammer.expression.repository.condition.inn.RepositoryIsNotNullExpression6;
import cn.featherfly.hammer.expression.repository.condition.isn.RepositoryIsNullExpression6;
import cn.featherfly.hammer.expression.repository.condition.le.RepositoryLessEqualsExpression6;
import cn.featherfly.hammer.expression.repository.condition.lk.RepositoryLikeExpression6;
import cn.featherfly.hammer.expression.repository.condition.lt.RepositoryLessThanExpression6;
import cn.featherfly.hammer.expression.repository.condition.ne.RepositoryNotEqualsExpression6;
import cn.featherfly.hammer.expression.repository.condition.ni.RepositoryNotInExpression6;
import cn.featherfly.hammer.expression.repository.condition.sw.RepositoryStartWithExpression6;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupExpression6;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupLogicExpression6;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression6;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortedExpression6;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.sort.SetSqlSortFieldExpression;

/**
 * abstract muliti repository sql query conditions group expression6.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractMulitiRepositorySqlQueryConditionsGroupExpression6<
        C extends RepositoryQueryConditionsGroupExpression6<C, L, S, Q>,
        L extends RepositoryQueryConditionsGroupLogicExpression6<C, L, S, Q>,
        S extends RepositoryQuerySortExpression6<Q>, Q extends QueryLimitExecutor> extends
        AbstractMulitiRepositorySqlConditionsGroupExpressionBase6<C, L, QueryConditionConfig,
                RepositorySqlQueryRelation, SqlSelectBasicBuilder>
        implements RepositoryQueryConditionsGroupExpression6<C, L, S, Q>,
        RepositoryQueryConditionsGroupLogicExpression6<C, L, S, Q>, ParamedExpression,
        RepositoryContainsExpression6<C, L>, RepositoryEndWithExpression6<C, L>, RepositoryEqualsExpression6<C, L>,
        RepositoryGreatEqualsExpression6<C, L>, RepositoryGreatThanExpression6<C, L>, RepositoryInExpression6<C, L>,
        RepositoryIsNotNullExpression6<C, L>, RepositoryIsNullExpression6<C, L>, RepositoryLessEqualsExpression6<C, L>,
        RepositoryLessThanExpression6<C, L>, RepositoryNotEqualsExpression6<C, L>, RepositoryNotInExpression6<C, L>,
        RepositoryStartWithExpression6<C, L>, RepositoryLikeExpression6<C, L> //
        , RepositoryQuerySortExpression6<Q>, RepositoryQuerySortedExpression6<Q> {

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
    protected AbstractMulitiRepositorySqlQueryConditionsGroupExpression6(L parent, int index,
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
    public RepositoryQuerySortedExpression6<Q> asc(String... names) {
        getRootSortBuilder().asc(names);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression6<Q> asc2(String... names) {
        getRootSortBuilder().asc(repositoryAlias2, () -> names);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression6<Q> asc3(String... names) {
        getRootSortBuilder().asc(repositoryAlias3, () -> names);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression6<Q> asc4(String... names) {
        getRootSortBuilder().asc(repositoryAlias4, () -> names);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression6<Q> asc5(String... names) {
        getRootSortBuilder().asc(repositoryAlias5, () -> names);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression6<Q> asc6(String... names) {
        getRootSortBuilder().asc(repositoryAlias6, () -> names);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression6<Q> asc(
            SixArgusConsumer<SetSortFieldExpression, SetSortFieldExpression, SetSortFieldExpression,
                    SetSortFieldExpression, SetSortFieldExpression, SetSortFieldExpression> sortExpressions) {
        sortExpressions.accept(new SetSqlSortFieldExpression(sortBuilder, repositoryAlias, SortOperator.ASC),
                new SetSqlSortFieldExpression(sortBuilder, repositoryAlias2, SortOperator.ASC),
                new SetSqlSortFieldExpression(sortBuilder, repositoryAlias3, SortOperator.ASC),
                new SetSqlSortFieldExpression(sortBuilder, repositoryAlias4, SortOperator.ASC),
                new SetSqlSortFieldExpression(sortBuilder, repositoryAlias5, SortOperator.ASC),
                new SetSqlSortFieldExpression(sortBuilder, repositoryAlias6, SortOperator.ASC));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression6<Q> desc(String... names) {
        getRootSortBuilder().desc(names);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression6<Q> desc2(String... names) {
        getRootSortBuilder().desc(repositoryAlias2, () -> names);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression6<Q> desc3(String... names) {
        getRootSortBuilder().desc(repositoryAlias3, () -> names);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression6<Q> desc4(String... names) {
        getRootSortBuilder().desc(repositoryAlias4, () -> names);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression6<Q> desc5(String... names) {
        getRootSortBuilder().desc(repositoryAlias5, () -> names);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression6<Q> desc6(String... names) {
        getRootSortBuilder().desc(repositoryAlias6, () -> names);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression6<Q> desc(
            SixArgusConsumer<SetSortFieldExpression, SetSortFieldExpression, SetSortFieldExpression,
                    SetSortFieldExpression, SetSortFieldExpression, SetSortFieldExpression> sortExpressions) {
        sortExpressions.accept(new SetSqlSortFieldExpression(sortBuilder, repositoryAlias, SortOperator.DESC),
                new SetSqlSortFieldExpression(sortBuilder, repositoryAlias2, SortOperator.DESC),
                new SetSqlSortFieldExpression(sortBuilder, repositoryAlias3, SortOperator.DESC),
                new SetSqlSortFieldExpression(sortBuilder, repositoryAlias4, SortOperator.DESC),
                new SetSqlSortFieldExpression(sortBuilder, repositoryAlias5, SortOperator.DESC),
                new SetSqlSortFieldExpression(sortBuilder, repositoryAlias6, SortOperator.DESC));
        return this;
    }

    // ****************************************************************************************************************
    //	private method
    // ****************************************************************************************************************

    @SuppressWarnings("unchecked")
    protected SortBuilder getRootSortBuilder() {
        return ((AbstractMulitiRepositorySqlQueryConditionsGroupExpression6<C, L, S, Q>) getRoot()).sortBuilder;
    }
}
