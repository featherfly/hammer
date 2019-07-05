
package cn.featherfly.juorm.rdb.jdbc.dsl.query;

import java.math.BigDecimal;
import java.util.List;

import cn.featherfly.common.structure.page.Page;
import cn.featherfly.juorm.dml.builder.SortBuilder;
import cn.featherfly.juorm.dsl.query.QueryConditionGroupExpression;
import cn.featherfly.juorm.dsl.query.QueryConditionGroupLogicExpression;
import cn.featherfly.juorm.expression.query.QueryExecutor;
import cn.featherfly.juorm.mapping.RowMapper;
import cn.featherfly.juorm.rdb.jdbc.Jdbc;
import cn.featherfly.juorm.rdb.jdbc.SqlResultSet;
import cn.featherfly.juorm.rdb.sql.dml.AbstractSqlConditionGroupExpression;
import cn.featherfly.juorm.rdb.sql.dml.builder.SqlSortBuilder;

/**
 * <p>
 * sql condition group builder sql条件逻辑组构造器
 * </p>
 *
 * @author zhongj
 */
public class SqlQueryConditionGroupExpression
        extends AbstractSqlConditionGroupExpression<QueryConditionGroupExpression, QueryConditionGroupLogicExpression>
        implements QueryConditionGroupExpression, QueryConditionGroupLogicExpression {

    private SqlSortBuilder sortBuilder;

    /**
     * @param dialect dialect
     */
    public SqlQueryConditionGroupExpression(Jdbc jdbc) {
        this(jdbc, null);
    }

    /**
     * @param dialect    dialect
     * @param queryAlias queryAlias
     */
    public SqlQueryConditionGroupExpression(Jdbc jdbc, String queryAlias) {
        this(jdbc, null, queryAlias);
    }

    /**
     * @param dialect    dialect
     * @param parent     parent group
     * @param queryAlias queryAlias
     */
    SqlQueryConditionGroupExpression(Jdbc jdbc, QueryConditionGroupLogicExpression parent, String queryAlias) {
        super(jdbc.getDialect(), parent, queryAlias);
        this.jdbc = jdbc;
    }

    // ********************************************************************
    // property
    // ********************************************************************

    protected Jdbc jdbc;

    /**
     * {@inheritDoc}
     */
    @Override
    protected QueryConditionGroupExpression createGroup(QueryConditionGroupLogicExpression parent, String queryAlias) {
        return new SqlQueryConditionGroupExpression(jdbc, parent, queryAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryExecutor limit(Integer limit) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryExecutor limit(Integer offset, Integer limit) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryExecutor limit(Page page) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(Class<E> type) {
        return jdbc.queryList(getRoot().expression(), getRoot().getParams().toArray(), type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(RowMapper<E> rowMapper) {
        return jdbc.query(getRoot().expression(), getRoot().getParams().toArray(), (rs, rowNum) -> {
            return rowMapper.mapRow(new SqlResultSet(rs), rowNum);
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E single(Class<E> type) {
        return jdbc.querySingle(getRoot().expression(), getRoot().getParams().toArray(), type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E single(RowMapper<E> rowMapper) {
        return jdbc.querySingle(getRoot().expression(), getRoot().getParams().toArray(), (rs, rowNum) -> {
            return rowMapper.mapRow(new SqlResultSet(rs), rowNum);
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String string() {
        return jdbc.queryString(getRoot().expression(), getRoot().getParams().toArray());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer integer() {
        return jdbc.queryInt(getRoot().expression(), getRoot().getParams().toArray());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long longInt() {
        return jdbc.queryLong(getRoot().expression(), getRoot().getParams().toArray());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal decimal() {
        return jdbc.queryBigDecimal(getRoot().expression(), getRoot().getParams().toArray());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> N number(Class<N> type) {
        return jdbc.queryValue(getRoot().expression(), getRoot().getParams().toArray(), type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SortBuilder sort() {
        return new SqlSortBuilder(jdbc.getDialect());
    }
}
