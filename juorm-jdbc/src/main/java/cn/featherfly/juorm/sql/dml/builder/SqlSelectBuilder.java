package cn.featherfly.juorm.sql.dml.builder;

import java.util.Collection;

import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.juorm.operator.AggregateFunction;
import cn.featherfly.juorm.sql.dialect.Dialect;

/**
 * <p>
 * sql find builder
 * </p>
 *
 * @author zhongj
 */
public class SqlSelectBuilder extends AbstractSqlSelectBuilder implements SelectBuilder {

    /**
     * @param dialect          dialect
     * @param conditionBuilder conditionBuilder
     */
    public SqlSelectBuilder(Dialect dialect, SqlConditionGroup conditionBuilder) {
        this(dialect, null, null, conditionBuilder);
    }

    /**
     * @param dialect          dialect
     * @param tableName        tableName
     * @param conditionBuilder conditionBuilder
     */
    public SqlSelectBuilder(Dialect dialect, String tableName, SqlConditionGroup conditionBuilder) {
        this(dialect, tableName, null, conditionBuilder);
    }

    /**
     * @param dialect          dialect
     * @param tableName        tableName
     * @param alias            alias
     * @param conditionBuilder conditionBuilder
     */
    public SqlSelectBuilder(Dialect dialect, String tableName, String alias, SqlConditionGroup conditionBuilder) {
        super(dialect, tableName, alias, conditionBuilder);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SelectBuilder select(String columnName, AggregateFunction aggregateFunction) {
        addSelectColumn(columnName, aggregateFunction);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SelectBuilder select(String columnName) {
        return select(columnName, null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SelectBuilder select(String... columnNames) {
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
        setTableAlias(alias);
        conditionBuilder.setQueryAlias(alias);
        return conditionBuilder;
    }

}
