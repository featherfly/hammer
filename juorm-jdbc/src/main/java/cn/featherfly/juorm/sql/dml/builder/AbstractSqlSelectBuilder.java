package cn.featherfly.juorm.sql.dml.builder;

import cn.featherfly.juorm.dml.builder.Builder;
import cn.featherfly.juorm.operator.AggregateFunction;
import cn.featherfly.juorm.sql.dialect.Dialect;
import cn.featherfly.juorm.sql.dml.builder.basic.SqlSelectBasicBuilder;

/**
 * <p>
 * abstract sql Select builder
 * </p>
 *
 * @author zhongj
 */
public abstract class AbstractSqlSelectBuilder implements Builder {

    private SqlSelectBasicBuilder selectBuilder;

    protected SqlConditionGroup conditionBuilder;

    /**
     * @param dialect          dialect
     * @param conditionBuilder conditionBuilder
     */
    public AbstractSqlSelectBuilder(Dialect dialect, SqlConditionGroup conditionBuilder) {
        this(dialect, null, null, conditionBuilder);
    }

    /**
     * @param dialect          dialect
     * @param tableName        tableName
     * @param conditionBuilder conditionBuilder
     */
    public AbstractSqlSelectBuilder(Dialect dialect, String tableName, SqlConditionGroup conditionBuilder) {
        this(dialect, tableName, null, conditionBuilder);
    }

    /**
     * @param dialect          dialect
     * @param tableName        tableName
     * @param alias            alias
     * @param conditionBuilder conditionBuilder
     */
    public AbstractSqlSelectBuilder(Dialect dialect, String tableName, String alias,
            SqlConditionGroup conditionBuilder) {
        this.conditionBuilder = conditionBuilder;
        selectBuilder = new SqlSelectBasicBuilder(dialect, tableName, alias);
    }

    protected void addSelectColumn(String column, AggregateFunction function) {
        selectBuilder.addSelectColumn(column, function);
    }

    /**
     * 返回tableAlias
     *
     * @return tableAlias
     */
    public String getTableAlias() {
        return selectBuilder.getTableAlias();
    }

    /**
     * 设置alias
     *
     * @param tableAlias tableAlias
     */
    public void setTableAlias(String tableAlias) {
        selectBuilder.setTableAlias(tableAlias);
    }

    /**
     * 返回tableName
     *
     * @return tableName
     */
    public String getTableName() {
        return selectBuilder.getTableName();
    }

    /**
     * 设置tableName
     *
     * @param tableName tableName
     */
    public void setTableName(String tableName) {
        selectBuilder.setTableName(tableName);
    }

    /**
     * 返回buildWithFrom
     *
     * @return buildWithFrom
     */
    public boolean isBuildWithFrom() {
        return selectBuilder.isBuildWithFrom();
    }

    /**
     * 设置buildWithFrom
     *
     * @param buildWithFrom buildWithFrom
     */
    public void setBuildWithFrom(boolean buildWithFrom) {
        selectBuilder.setBuildWithFrom(buildWithFrom);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String build() {
        return selectBuilder.build();
    }
}