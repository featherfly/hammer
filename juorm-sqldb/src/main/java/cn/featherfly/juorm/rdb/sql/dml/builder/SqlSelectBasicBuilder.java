package cn.featherfly.juorm.rdb.sql.dml.builder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.dialect.Dialect.Keyworld;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.juorm.operator.AggregateFunction;
import cn.featherfly.juorm.rdb.sql.dialect.Dialect;
import cn.featherfly.juorm.rdb.sql.dml.SqlBuilder;
import cn.featherfly.juorm.rdb.sql.model.SelectColumnElement;

/**
 * <p>
 * sql select basic builder. columns with given table
 * </p>
 *
 * @author zhongj
 */
public class SqlSelectBasicBuilder implements SqlBuilder {

    protected String tableAlias;

    protected String tableName;

    protected boolean buildWithFrom = true;

    protected List<SelectColumnElement> columns = new ArrayList<>(0);

    protected Dialect dialect;

    /**
     * @param dialect dialect
     */
    public SqlSelectBasicBuilder(Dialect dialect) {
        this(dialect, null);
    }

    /**
     * @param dialect   dialect
     * @param tableName tableName
     */
    public SqlSelectBasicBuilder(Dialect dialect, String tableName) {
        this(dialect, tableName, null);
    }

    /**
     * @param dialect    dialect
     * @param tableName  tableName
     * @param tableAlias alias
     */
    public SqlSelectBasicBuilder(Dialect dialect, String tableName, String tableAlias) {
        this.dialect = dialect;
        this.tableAlias = tableAlias;
        this.tableName = tableName;
    }

    /**
     * 返回alias
     *
     * @return alias
     */
    public String getTableAlias() {
        return tableAlias;
    }

    /**
     * 设置alias
     *
     * @param tableAlias tableAlias
     */
    public void setTableAlias(String tableAlias) {
        this.tableAlias = tableAlias;
    }

    /**
     * 返回tableName
     *
     * @return tableName
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 设置tableName
     *
     * @param tableName tableName
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * 返回buildWithFrom
     *
     * @return buildWithFrom
     */
    public boolean isBuildWithFrom() {
        return buildWithFrom;
    }

    /**
     * 设置buildWithFrom
     *
     * @param buildWithFrom buildWithFrom
     */
    public void setBuildWithFrom(boolean buildWithFrom) {
        this.buildWithFrom = buildWithFrom;
    }

    /**
     * add column
     *
     * @param column            column
     * @param aggregateFunction aggregateFunction
     * @return this
     */
    public SqlSelectBasicBuilder addSelectColumn(String column, AggregateFunction aggregateFunction) {
        columns.add(new SelectColumnElement(dialect, column, tableAlias, aggregateFunction));
        return this;
    }

    /**
     * add column
     *
     * @param column            column
     * @param aggregateFunction aggregateFunction
     * @return this
     */
    public SqlSelectBasicBuilder addSelectColumn(String column, AggregateFunction aggregateFunction, String asName) {
        columns.add(new SelectColumnElement(dialect, column, tableAlias, aggregateFunction, asName));
        return this;
    }

    /**
     * add column
     *
     * @param column column
     * @return this
     */
    public SqlSelectBasicBuilder addSelectColumn(String column) {
        columns.add(new SelectColumnElement(dialect, column, tableAlias));
        return this;
    }

    /**
     * add column
     *
     * @param column column
     * @return this
     */
    public SqlSelectBasicBuilder addSelectColumn(String column, String asName) {
        columns.add(new SelectColumnElement(dialect, column, tableAlias, asName));
        return this;
    }

    /**
     * addColumns
     *
     * @param columns columns
     * @return this
     */
    public SqlSelectBasicBuilder addSelectColumns(String... columns) {
        for (String c : columns) {
            addSelectColumn(c);
        }
        return this;
    }

    /**
     * addColumns
     *
     * @param columns columns
     * @return this
     */
    public SqlSelectBasicBuilder addSelectColumns(Collection<String> columns) {
        for (String c : columns) {
            addSelectColumn(c);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String build() {
        StringBuilder select = new StringBuilder();
        Keyworld keyworld = dialect.getKeywords();
        select.append(keyworld.select());
        if (columns.isEmpty()) {
            if (LangUtils.isEmpty(tableAlias)) {
                select.append(Chars.SPACE).append(Chars.STAR);
            } else {
                select.append(Chars.SPACE).append(tableAlias).append(Chars.DOT).append(Chars.STAR);
            }
        } else {
            for (SelectColumnElement column : columns) {
                // 基础构建器一个实例对应一个table
                column.setTableAlias(tableAlias);
                select.append(Chars.SPACE).append(column).append(Chars.COMMA);
            }
            select.deleteCharAt(select.length() - 1);
        }

        if (buildWithFrom) {
            AssertIllegalArgument.isNotEmpty(tableName, "buildWithFrom=true时，tableName不能为空");
            select.append(" ").append(keyworld.from()).append(" ").append(dialect.buildTableSql(tableName, tableAlias));
        }
        return select.toString();
    }
}
