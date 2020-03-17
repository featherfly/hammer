package cn.featherfly.juorm.sqldb.sql.dml.builder;

import cn.featherfly.juorm.dml.builder.SortBuilder;
import cn.featherfly.juorm.sqldb.sql.dialect.Dialect;
import cn.featherfly.juorm.sqldb.sql.dml.builder.basic.SqlOrderByBasicBuilder;

/**
 * <p>
 * sql sort builder
 * </p>
 *
 * @author zhongj
 */
public class SqlSortBuilder implements SortBuilder {

    private SqlOrderByBasicBuilder orderByBuilder;

    private String tableAlias;

    public SqlSortBuilder(Dialect dialect) {
        this(dialect, null);
    }

    public SqlSortBuilder(Dialect dialect, String tableAlias) {
        orderByBuilder = new SqlOrderByBasicBuilder(dialect);
        this.tableAlias = tableAlias;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SortBuilder asc(String... names) {
        for (String name : names) {
            orderByBuilder.addAsc(name, tableAlias);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SortBuilder desc(String... names) {
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
     * @param tableAlias tableAlias
     */
    public void setTableAlias(String tableAlias) {
        this.tableAlias = tableAlias;
    }
}