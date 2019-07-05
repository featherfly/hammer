package cn.featherfly.juorm.rdb.sql.dml;

import cn.featherfly.juorm.expression.condition.SortExpression;
import cn.featherfly.juorm.rdb.sql.dialect.Dialect;
import cn.featherfly.juorm.rdb.sql.dml.builder.basic.SqlOrderByBasicBuilder;

/**
 * <p>
 * sql sort builder
 * </p>
 *
 * @author zhongj
 */
public class SqlSortExpressionBuilder
        implements SortExpression<SqlSortExpressionBuilder>, SqlBuilder {

    private SqlOrderByBasicBuilder orderByBuilder;

    private String tableAlias;

    public SqlSortExpressionBuilder(Dialect dialect) {
        this(dialect, null);
    }

    public SqlSortExpressionBuilder(Dialect dialect, String tableAlias) {
        orderByBuilder = new SqlOrderByBasicBuilder(dialect);
        this.tableAlias = tableAlias;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlSortExpressionBuilder asc(String... names) {
        for (String name : names) {
            orderByBuilder.addAsc(name, tableAlias);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlSortExpressionBuilder desc(String... names) {
        for (String name : names) {
            orderByBuilder.addDesc(name, tableAlias);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String build() {
        return orderByBuilder.build();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return this.getClass().getName() + " : " + build();
    }

    /**
     * 返回tableAlias
     *
     * @return tableAlias
     */
    public String getTableAlias() {
        return tableAlias;
    }

    /**
     * 设置tableAlias
     *
     * @param tableAlias
     *            tableAlias
     */
    public void setTableAlias(String tableAlias) {
        this.tableAlias = tableAlias;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {
        return build();
    }
}