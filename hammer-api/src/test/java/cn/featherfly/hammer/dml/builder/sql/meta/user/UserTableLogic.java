package cn.featherfly.hammer.dml.builder.sql.meta.user;

import java.sql.Blob;
import java.sql.Clob;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import cn.featherfly.common.operator.LogicOperator;
import cn.featherfly.common.repository.mapping.RowMapper;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.hammer.expression.query.QueryConditionLogicExpression;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;

public class UserTableLogic implements QueryConditionLogicExpression<UserTableFilterable, UserTableLogic> {

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
    public QueryLimitExecutor limit(Integer limit) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryLimitExecutor limit(Integer offset, Integer limit) {

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
    public List<Map<String, Object>> list() {

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
    public <E> List<E> list(RowMapper<E> rowMapper) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Object> single() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Object> unique() {

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
    public String string() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date date() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDate localDate() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime localDateTime() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalTime localTime() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp timestamp() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] bytes() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Clob clob() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Blob blob() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean bool() {

        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte byteValue() {

        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public short shortValue() {

        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int intValue() {

        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long longValue() {

        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T value(Class<T> type) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long count() {

        return 0;
    }

}