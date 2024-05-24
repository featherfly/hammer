package cn.featherfly.hammer.dml.builder.sql.meta.user;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import cn.featherfly.common.operator.LogicOperator;
import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.GroupEndExpression;
import cn.featherfly.hammer.expression.condition.GroupExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.query.QueryConditionLimit;
import cn.featherfly.hammer.expression.query.QueryExecutor;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;

public class UserTableLogic implements
    //RepositoryQueryConditionsGroupLogicExpression<UserTableFilterable, UserTableLogic, RepositoryQuerySortExpression>
    GroupEndExpression<UserTableFilterable, UserTableLogic>, QueryExecutor, QueryLimitExecutor,
    QueryConditionLimit<QueryLimitExecutor> {

    private UserTableFilterable query;

    /**
     * @param query
     */
    public UserTableLogic(UserTableFilterable query) {
        super();
        this.query = query;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserTableFilterable logic(LogicOperator operator) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserTableFilterable and() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserTableLogic and(Function<UserTableFilterable, UserTableLogic> group) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserTableFilterable or() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserTableLogic or(Function<UserTableFilterable, UserTableLogic> group) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserTableLogic endGroup() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Serializable>> list() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(RowMapper<E> rowMapper) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(Class<E> type) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Serializable> single() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Serializable> unique() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E single(Class<E> type) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E unique(Class<E> type) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E single(RowMapper<E> rowMapper) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E unique(RowMapper<E> rowMapper) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<Map<String, Serializable>> pagination() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> PaginationResults<E> pagination(Class<E> type) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> PaginationResults<E> pagination(RowMapper<E> rowMapper) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryLimitExecutor limit(int limit) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryLimitExecutor limit(int offset, int limit) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryLimitExecutor limit(Page page) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryLimitExecutor limit(Limit limit) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserTableLogic logic(LogicOperator operator, LogicExpression<?, ?> logicExpression) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserTableLogic logic(LogicOperator operator, Function<UserTableFilterable, UserTableLogic> group) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserTableLogic and(LogicExpression<?, ?> logicExpression) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserTableLogic or(LogicExpression<?, ?> logicExpression) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <G extends GroupExpression<GC, GL>, GC extends ConditionExpression,
        GL extends GroupEndExpression<GC, GL>> G and(G conditionExpression) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <G extends GroupExpression<GC, GL>, GC extends ConditionExpression,
        GL extends GroupEndExpression<GC, GL>> G or(G conditionExpression) {

        return null;
    }
}