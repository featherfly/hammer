
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.builder.dml.SqlSortBuilder;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
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
import cn.featherfly.hammer.expression.repository.condition.co.ContainsRepositoryExpression;
import cn.featherfly.hammer.expression.repository.condition.co.RepositoryContainsExpression2;
import cn.featherfly.hammer.expression.repository.condition.eq.EqualsRepositoryExpression;
import cn.featherfly.hammer.expression.repository.condition.eq.RepositoryEqualsExpression2;
import cn.featherfly.hammer.expression.repository.condition.ew.RepositoryEndWithExpression2;
import cn.featherfly.hammer.expression.repository.condition.ge.RepositoryGreatEqualsExpression2;
import cn.featherfly.hammer.expression.repository.condition.gt.RepositoryGreatThanExpression2;
import cn.featherfly.hammer.expression.repository.condition.in.RepositoryInExpression2;
import cn.featherfly.hammer.expression.repository.condition.inn.RepositoryIsNotNullExpression2;
import cn.featherfly.hammer.expression.repository.condition.isn.IsNullRepositoryExpression;
import cn.featherfly.hammer.expression.repository.condition.isn.RepositoryIsNullExpression2;
import cn.featherfly.hammer.expression.repository.condition.le.RepositoryLessEqualsExpression2;
import cn.featherfly.hammer.expression.repository.condition.lk.RepositoryLikeExpression2;
import cn.featherfly.hammer.expression.repository.condition.lt.RepositoryLessThanExpression2;
import cn.featherfly.hammer.expression.repository.condition.nco.NotContainsRepositoryExpression;
import cn.featherfly.hammer.expression.repository.condition.ne.EqualsNotRepositoryExpression;
import cn.featherfly.hammer.expression.repository.condition.ne.RepositoryNotEqualsExpression2;
import cn.featherfly.hammer.expression.repository.condition.ni.RepositoryNotInExpression2;
import cn.featherfly.hammer.expression.repository.condition.sw.RepositoryStartWithExpression2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupExpression2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupLogicExpression2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortedExpression2;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.sort.SetSqlSortFieldExpression;

/**
 * abstract muliti repository sql query conditions group expression2.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractMulitiRepositorySqlQueryConditionsGroupExpression2<
        C extends RepositoryQueryConditionsGroupExpression2<C, L, S, Q>,
        L extends RepositoryQueryConditionsGroupLogicExpression2<C, L, S, Q>,
        S extends RepositoryQuerySortExpression2<Q>, Q extends QueryLimitExecutor> extends
        AbstractMulitiRepositorySqlConditionsGroupExpressionBase2<C, L, QueryConditionConfig,
                RepositorySqlQueryRelation, SqlSelectBasicBuilder>
        implements RepositoryQueryConditionsGroupExpression2<C, L, S, Q>,
        RepositoryQueryConditionsGroupLogicExpression2<C, L, S, Q>, ParamedExpression,
        RepositoryContainsExpression2<C, L>, RepositoryEndWithExpression2<C, L>, RepositoryEqualsExpression2<C, L>,
        RepositoryGreatEqualsExpression2<C, L>, RepositoryGreatThanExpression2<C, L>, RepositoryInExpression2<C, L>,
        RepositoryIsNotNullExpression2<C, L>, RepositoryIsNullExpression2<C, L>, RepositoryLessEqualsExpression2<C, L>,
        RepositoryLessThanExpression2<C, L>, RepositoryNotEqualsExpression2<C, L>, RepositoryNotInExpression2<C, L>,
        RepositoryStartWithExpression2<C, L>, RepositoryLikeExpression2<C, L> //
        , RepositoryQuerySortExpression2<Q>, RepositoryQuerySortedExpression2<Q> {

    private SqlSortBuilder sortBuilder;

    /** The sql page factory. */
    protected SqlPageFactory sqlPageFactory;

    protected final RepositorySqlQueryConditionGroupQuery repositorySqlQueryConditionGroupQuery;

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
    protected AbstractMulitiRepositorySqlQueryConditionsGroupExpression2(L parent, int index,
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

    // ****************************************************************************************************************
    // condition
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(Consumer<
            Tuple2<ContainsRepositoryExpression, ContainsRepositoryExpression>> containsRepositoryExpressions) {
        // IMPLSOON 后续来实现
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(BiConsumer<ContainsRepositoryExpression, ContainsRepositoryExpression> containsRepositoryExpressions) {
        // IMPLSOON 后续来实现
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco(Consumer<
            Tuple2<NotContainsRepositoryExpression, NotContainsRepositoryExpression>> containsRepositoryExpressions) {
        // IMPLSOON 后续来实现
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco(BiConsumer<NotContainsRepositoryExpression,
            NotContainsRepositoryExpression> containsRepositoryExpressions) {
        // IMPLSOON 后续来实现
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(Consumer<Tuple2<EqualsRepositoryExpression, EqualsRepositoryExpression>> equalsRepositoryExpressions) {
        // IMPLSOON 后续来实现
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(BiConsumer<EqualsRepositoryExpression, EqualsRepositoryExpression> equalsRepositoryExpressions) {
        // IMPLSOON 后续来实现
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(Consumer<
            Tuple2<EqualsNotRepositoryExpression, EqualsNotRepositoryExpression>> equalsRepositoryExpressions) {
        // IMPLSOON 后续来实现
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(BiConsumer<EqualsNotRepositoryExpression, EqualsNotRepositoryExpression> equalsRepositoryExpressions) {
        // IMPLSOON 后续来实现
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L isn(Consumer<Tuple2<IsNullRepositoryExpression, IsNullRepositoryExpression>> isNullRepositoryExpressions) {
        // IMPLSOON 后续来实现
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L isn(BiConsumer<IsNullRepositoryExpression, IsNullRepositoryExpression> isNullRepositoryExpressions) {
        // IMPLSOON 后续来实现
        return null;
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

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2> List<Tuple2<E1, E2>> list(Tuple2<String, String> prefixes, Class<E1> type1, Class<E2> type2) {
        return repositorySqlQueryConditionGroupQuery.list(prefixes, type1, type2);
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

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2> PaginationResults<Tuple2<E1, E2>> pagination(Tuple2<String, String> prefixes, Class<E1> type1,
            Class<E2> type2) {
        return repositorySqlQueryConditionGroupQuery.pagination(prefixes, type1, type2);
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

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2> Tuple2<E1, E2> single(Tuple2<String, String> prefixes, Class<E1> type1, Class<E2> type2) {
        return repositorySqlQueryConditionGroupQuery.single(prefixes, type1, type2);
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

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2> Tuple2<E1, E2> unique(Tuple2<String, String> prefixes, Class<E1> type1, Class<E2> type2) {
        return repositorySqlQueryConditionGroupQuery.unique(prefixes, type1, type2);
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

    @SuppressWarnings("unchecked")
    protected SortBuilder getRootSortBuilder() {
        return ((AbstractMulitiRepositorySqlQueryConditionsGroupExpression2<C, L, S, Q>) getRoot()).sortBuilder;
    }
}
