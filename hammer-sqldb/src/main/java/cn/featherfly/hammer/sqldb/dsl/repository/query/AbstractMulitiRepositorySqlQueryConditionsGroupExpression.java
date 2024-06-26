
package cn.featherfly.hammer.sqldb.dsl.repository.query;

import java.util.List;
import java.util.Map;

import com.speedment.common.tuple.Tuple1;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.builder.dml.SqlSortBuilder;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.repository.builder.dml.SortBuilder;
import cn.featherfly.common.repository.mapping.RowMapper;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortedExpression;
import cn.featherfly.hammer.sqldb.dsl.repository.AbstractMulitiRepositorySqlConditionsGroupExpressionBase;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryConditionGroupQuery;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * abstract muliti repository sql query conditions group expression.
 *
 * @author zhongj
 */
public abstract class AbstractMulitiRepositorySqlQueryConditionsGroupExpression extends
    AbstractMulitiRepositorySqlConditionsGroupExpressionBase<RepositoryQueryConditionsGroup,
        RepositoryQueryConditionsGroupLogic, Tuple1<Integer>, QueryConditionConfig, RepositorySqlQueryRelation,
        SqlSelectBasicBuilder>
    implements
    //    RepositoryQueryableExpression<RepositoryQuerySortExpression, QueryLimitExecutor>, //
    //    ConditionConfigureExpression<RepositoryQuery, QueryConditionConfig>, //
    RepositoryQueryConditionsGroup, RepositoryQueryConditionsGroupLogic, //
    RepositoryQuerySortExpression, RepositoryQuerySortedExpression {

    private SqlSortBuilder sortBuilder;

    /** The sql page factory. */
    protected SqlPageFactory sqlPageFactory;

    private final RepositorySqlQueryConditionGroupQuery repositorySqlQueryConditionGroupQuery;

    /**
     * Instantiates a new abstract muliti repository sql query conditions group
     * expression.
     *
     * @param parent         the parent
     * @param index          the index
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    protected AbstractMulitiRepositorySqlQueryConditionsGroupExpression(RepositoryQueryConditionsGroupLogic parent,
        int index, RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
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
    @Override
    public QueryLimitExecutor limit(Limit limit) {
        repositorySqlQueryConditionGroupQuery.setLimit(limit);
        return this;
    }

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

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortExpression sort() {
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression asc(String... names) {
        getRootSortBuilder().asc(names);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression desc(String... names) {
        getRootSortBuilder().desc(names);
        return this;
    }

    // ****************************************************************************************************************
    //	private method
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    protected Tuple1<Integer> createTuple() {
        return Tuples.of(0);
    }

    /**
     * Gets the root sort builder.
     *
     * @return the root sort builder
     */
    protected SortBuilder getRootSortBuilder() {
        return ((AbstractMulitiRepositorySqlQueryConditionsGroupExpression) getRoot()).sortBuilder;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {
        String condition = super.expression();
        if (parent == null) {
            String result = repositoryRelation.buildSelectSql();
            String sort = getRootSortBuilder().build();
            if (Lang.isEmpty(condition)) {
                return result + Chars.SPACE + sort;
            } else {
                return result + Chars.SPACE + dialect.getKeywords().where() + Chars.SPACE + condition + Chars.SPACE
                    + sort;
            }
        } else {
            return condition;
        }
    }
}
