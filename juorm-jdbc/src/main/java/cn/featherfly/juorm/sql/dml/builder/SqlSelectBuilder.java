package cn.featherfly.juorm.sql.dml.builder;

import java.util.Collection;

import cn.featherfly.common.lang.LangUtils;

/**
 * <p>
 * sql find builder
 * </p>
 * 
 * @author zhongj
 */
public class SqlSelectBuilder extends AbstractSqlSelectBuilder implements SelectBuilder {

    /**
     * @param conditionBuilder conditionBuilder
     */
    public SqlSelectBuilder(SqlConditionGroup conditionBuilder) {
        this(null, null, conditionBuilder);
    }
    /**
     * @param tableName tableName
     * @param conditionBuilder conditionBuilder
     */
    public SqlSelectBuilder(String tableName, SqlConditionGroup conditionBuilder) {
        this(tableName, null, conditionBuilder);
    }
    
    /**
     * @param tableName tableName
     * @param alias alias
     * @param conditionBuilder conditionBuilder
     */
    public SqlSelectBuilder(String tableName, String alias, SqlConditionGroup conditionBuilder) {
        super(tableName, alias, conditionBuilder);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public SelectBuilder select(String columnName) {
        addSelectColumn(columnName);
        return this;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public SelectBuilder select(String...columnNames) {
        if (LangUtils.isNotEmpty(columnNames)) {
            for (String columnName : columnNames) {
                select(columnName);
            }
        }
        return this;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public SelectBuilder select(Collection<String> columnNames) {
        if (LangUtils.isNotEmpty(columnNames)) {
            for (String columnName : columnNames) {
                select(columnName);
            }
        }
        return this;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public SqlConditionBuilder from(String tableName) {
        return from(tableName, null);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public SqlConditionBuilder from(String tableName, String alias) {
        setTableName(tableName);
        setAlias(alias);
        return conditionBuilder;
    }
}
