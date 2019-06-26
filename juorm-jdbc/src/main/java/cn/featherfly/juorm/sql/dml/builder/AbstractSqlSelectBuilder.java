package cn.featherfly.juorm.sql.dml.builder;

import cn.featherfly.juorm.dml.builder.Builder;
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
     * @param conditionBuilder
     *            conditionBuilder
     */
    public AbstractSqlSelectBuilder(SqlConditionGroup conditionBuilder) {
        this(null, null, conditionBuilder);
    }

    /**
     * @param tableName
     *            tableName
     * @param conditionBuilder
     *            conditionBuilder
     */
    public AbstractSqlSelectBuilder(String tableName, SqlConditionGroup conditionBuilder) {
        this(tableName, null, conditionBuilder);
    }

    /**
     * @param tableName
     *            tableName
     * @param alias
     *            alias
     * @param conditionBuilder
     *            conditionBuilder
     */
    public AbstractSqlSelectBuilder(String tableName, String alias, SqlConditionGroup conditionBuilder) {
        this.conditionBuilder = conditionBuilder;
        this.selectBuilder = new SqlSelectBasicBuilder(tableName, alias);
    }

    protected void addSelectColumn(String column) {
        selectBuilder.addSelectColumn(column);
    }

    /**
     * 返回alias
     * 
     * @return alias
     */
    public String getAlias() {
        return selectBuilder.getAlias();
    }

    /**
     * 设置alias
     * 
     * @param alias
     *            alias
     */
    public void setAlias(String alias) {
        selectBuilder.setAlias(alias);
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
     * @param tableName
     *            tableName
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
     * @param buildWithFrom
     *            buildWithFrom
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
