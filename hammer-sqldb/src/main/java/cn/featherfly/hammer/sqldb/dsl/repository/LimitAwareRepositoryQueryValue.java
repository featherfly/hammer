
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-04-11 11:23:11
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.repository;

import java.sql.Blob;
import java.sql.Clob;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import cn.featherfly.common.repository.RowIterable;
import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.data.query.LimitAwareQueryValue;
import cn.featherfly.data.query.QueryLimitExecutor;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractMulitiRepositorySqlQueryValueConditionsGroupExpression;

/**
 * RepositoryLimitQuery.
 *
 * @author zhongj
 * @param <Map<String, Serializable>> the element type
 */
public class LimitAwareRepositoryQueryValue implements LimitAwareQueryValue {

    private final AbstractMulitiRepositorySqlQueryValueConditionsGroupExpression exp;

    /**
     * Instantiates a new limit aware repository query.
     *
     * @param exp the repository sql query condition group query
     */
    public LimitAwareRepositoryQueryValue(AbstractMulitiRepositorySqlQueryValueConditionsGroupExpression exp) {
        super();
        this.exp = exp;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> QueryLimitExecutor<T> mapper(RowMapper<T> rowMapper) {
        return new RepositorySqlQueryValueLimitExecutor<>(exp, rowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> QueryLimitExecutor<T> mapper(Class<T> type) {
        return new RepositorySqlQueryValueLimitExecutor<>(exp, exp.getJdbc().createRowMapper(type));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String string() {
        return exp.string();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date date() {
        return exp.date();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDate localDate() {
        return exp.localDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime localDateTime() {
        return exp.localDateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalTime localTime() {
        return exp.localTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp timestamp() {
        return exp.timestamp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] bytes() {
        return exp.bytes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Clob clob() {
        return exp.clob();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Blob blob() {
        return exp.blob();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean bool() {
        return exp.bool();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte byteValue() {
        return exp.byteValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public short shortValue() {
        return exp.shortValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int int32() {
        return exp.int32();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long longInt64() {
        return exp.longInt64();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double doubleValue() {
        return exp.doubleValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T single(Class<T> type) {
        return exp.single(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T unique(Class<T> type) {
        return exp.unique(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list() {
        return exp.list();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> RowIterable<E> each() {
        return exp.each();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T single() {
        return exp.single();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T unique() {
        return exp.unique();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> PaginationResults<E> pagination() {
        return exp.pagination();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long count() {
        return exp.count();
    }
}
