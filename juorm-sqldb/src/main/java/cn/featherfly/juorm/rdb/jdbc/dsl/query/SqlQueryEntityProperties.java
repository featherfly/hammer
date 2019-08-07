
package cn.featherfly.juorm.rdb.jdbc.dsl.query;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import cn.featherfly.common.structure.page.Page;
import cn.featherfly.juorm.dsl.query.QueryConditionGroupExpression;
import cn.featherfly.juorm.dsl.query.QueryEntityProperties;
import cn.featherfly.juorm.expression.query.QueryExecutor;
import cn.featherfly.juorm.mapping.RowMapper;
import cn.featherfly.juorm.rdb.jdbc.Jdbc;
import cn.featherfly.juorm.rdb.sql.dml.builder.basic.SqlSelectBasicBuilder;

/**
 * <p>
 * SqlQueryProperties
 * </p>
 *
 * @author zhongj
 */
public class SqlQueryEntityProperties implements SqlQueryEntity, QueryEntityProperties {

    private String tableName;

    private Jdbc jdbc;

    private SqlSelectBasicBuilder selectBuilder;

    /**
     * @param tableName
     * @param jdbc
     */
    public SqlQueryEntityProperties(String tableName, Jdbc jdbc) {
        this(tableName, jdbc, null);
    }

    /**
     * @param tableName
     * @param jdbc
     */
    public SqlQueryEntityProperties(String tableName, Jdbc jdbc, String tableAlias) {
        super();
        this.tableName = tableName;
        this.jdbc = jdbc;
        selectBuilder = new SqlSelectBasicBuilder(jdbc.getDialect(), tableName, tableAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryEntityProperties property(String propertyName) {
        selectBuilder.addSelectColumn(propertyName);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryEntityProperties property(String... propertyNames) {
        selectBuilder.addSelectColumns(propertyNames);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryEntityProperties property(Collection<String> propertyNames) {
        selectBuilder.addSelectColumns(propertyNames);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupExpression where() {
        return new SqlQueryExpression(jdbc, tableName, selectBuilder);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(Class<E> type) {
        return new SqlQueryExpression(jdbc, tableName, selectBuilder).list(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(RowMapper<E> rowMapper) {
        return new SqlQueryExpression(jdbc, tableName, selectBuilder).list(rowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryExecutor limit(Integer limit) {
        return new SqlQueryExpression(jdbc, tableName, selectBuilder).limit(limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryExecutor limit(Integer offset, Integer limit) {
        return new SqlQueryExpression(jdbc, tableName, selectBuilder).limit(offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryExecutor limit(Page page) {
        return new SqlQueryExpression(jdbc, tableName, selectBuilder).limit(page);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String string() {
        return new SqlQueryExpression(jdbc, tableName, selectBuilder).string();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer integer() {
        return new SqlQueryExpression(jdbc, tableName, selectBuilder).integer();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long longInt() {
        return new SqlQueryExpression(jdbc, tableName, selectBuilder).longInt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal decimal() {
        return new SqlQueryExpression(jdbc, tableName, selectBuilder).decimal();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> N number(Class<N> type) {
        return new SqlQueryExpression(jdbc, tableName, selectBuilder).number(type);
    }

}
