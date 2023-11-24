
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository;

import java.util.List;
import java.util.Map;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.builder.dml.SqlSortBuilder;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
import cn.featherfly.common.function.ThreeArgusConsumer;
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
import cn.featherfly.hammer.expression.repository.condition.co.RepositoryContainsExpression3;
import cn.featherfly.hammer.expression.repository.condition.eq.RepositoryEqualsExpression3;
import cn.featherfly.hammer.expression.repository.condition.ew.RepositoryEndWithExpression3;
import cn.featherfly.hammer.expression.repository.condition.ge.RepositoryGreatEqualsExpression3;
import cn.featherfly.hammer.expression.repository.condition.gt.RepositoryGreatThanExpression3;
import cn.featherfly.hammer.expression.repository.condition.in.RepositoryInExpression3;
import cn.featherfly.hammer.expression.repository.condition.inn.RepositoryIsNotNullExpression3;
import cn.featherfly.hammer.expression.repository.condition.isn.RepositoryIsNullExpression3;
import cn.featherfly.hammer.expression.repository.condition.le.RepositoryLessEqualsExpression3;
import cn.featherfly.hammer.expression.repository.condition.lk.RepositoryLikeExpression3;
import cn.featherfly.hammer.expression.repository.condition.lt.RepositoryLessThanExpression3;
import cn.featherfly.hammer.expression.repository.condition.ne.RepositoryNotEqualsExpression3;
import cn.featherfly.hammer.expression.repository.condition.ni.RepositoryNotInExpression3;
import cn.featherfly.hammer.expression.repository.condition.sw.RepositoryStartWithExpression3;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupExpression3;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupLogicExpression3;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression3;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortedExpression3;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.sort.SetSqlSortFieldExpression;

/**
 * abstract muliti repository sql query conditions group expression3.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractMulitiRepositorySqlQueryConditionsGroupExpression3<
        C extends RepositoryQueryConditionsGroupExpression3<C, L, S, Q>,
        L extends RepositoryQueryConditionsGroupLogicExpression3<C, L, S, Q>,
        S extends RepositoryQuerySortExpression3<Q>, Q extends QueryLimitExecutor> extends
        AbstractMulitiRepositorySqlConditionsGroupExpressionBase3<C, L, QueryConditionConfig,
                RepositorySqlQueryRelation, SqlSelectBasicBuilder>
        implements RepositoryQueryConditionsGroupExpression3<C, L, S, Q>,
        RepositoryQueryConditionsGroupLogicExpression3<C, L, S, Q>, ParamedExpression,
        RepositoryContainsExpression3<C, L>, RepositoryEndWithExpression3<C, L>, RepositoryEqualsExpression3<C, L>,
        RepositoryGreatEqualsExpression3<C, L>, RepositoryGreatThanExpression3<C, L>, RepositoryInExpression3<C, L>,
        RepositoryIsNotNullExpression3<C, L>, RepositoryIsNullExpression3<C, L>, RepositoryLessEqualsExpression3<C, L>,
        RepositoryLessThanExpression3<C, L>, RepositoryNotEqualsExpression3<C, L>, RepositoryNotInExpression3<C, L>,
        RepositoryStartWithExpression3<C, L>, RepositoryLikeExpression3<C, L> //
        , RepositoryQuerySortExpression3<Q>, RepositoryQuerySortedExpression3<Q> {

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
    protected AbstractMulitiRepositorySqlQueryConditionsGroupExpression3(L parent, int index,
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
    public RepositoryQuerySortedExpression3<Q> asc(String... names) {
        getRootSortBuilder().asc(names);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression3<Q> asc2(String... names) {
        getRootSortBuilder().asc(repositoryAlias2, () -> names);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression3<Q> asc3(String... names) {
        getRootSortBuilder().asc(repositoryAlias3, () -> names);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression3<Q> asc(ThreeArgusConsumer<SetSortFieldExpression, SetSortFieldExpression,
            SetSortFieldExpression> sortExpressions) {
        sortExpressions.accept(new SetSqlSortFieldExpression(sortBuilder, repositoryAlias, SortOperator.ASC),
                new SetSqlSortFieldExpression(sortBuilder, repositoryAlias2, SortOperator.ASC),
                new SetSqlSortFieldExpression(sortBuilder, repositoryAlias3, SortOperator.ASC));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression3<Q> desc(String... names) {
        getRootSortBuilder().desc(names);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression3<Q> desc2(String... names) {
        getRootSortBuilder().desc(repositoryAlias2, () -> names);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression3<Q> desc3(String... names) {
        getRootSortBuilder().desc(repositoryAlias3, () -> names);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression3<Q> desc(ThreeArgusConsumer<SetSortFieldExpression, SetSortFieldExpression,
            SetSortFieldExpression> sortExpressions) {
        sortExpressions.accept(new SetSqlSortFieldExpression(sortBuilder, repositoryAlias, SortOperator.DESC),
                new SetSqlSortFieldExpression(sortBuilder, repositoryAlias2, SortOperator.DESC),
                new SetSqlSortFieldExpression(sortBuilder, repositoryAlias3, SortOperator.DESC));
        return this;
    }

    // ****************************************************************************************************************
    //	private method
    // ****************************************************************************************************************

    @SuppressWarnings("unchecked")
    protected SortBuilder getRootSortBuilder() {
        return ((AbstractMulitiRepositorySqlQueryConditionsGroupExpression3<C, L, S, Q>) getRoot()).sortBuilder;
    }
}
