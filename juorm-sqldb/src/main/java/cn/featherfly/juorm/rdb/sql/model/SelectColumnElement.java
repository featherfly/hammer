
package cn.featherfly.juorm.rdb.sql.model;

import cn.featherfly.juorm.operator.AggregateFunction;
import cn.featherfly.juorm.rdb.sql.dialect.Dialect;

/**
 * <p>
 * Column
 * </p>
 *
 * @author zhongj
 */
public class SelectColumnElement extends ColumnElement {

    protected AggregateFunction aggregateFunctions;

    protected String asName;

    /**
     * @param dialect dialect
     * @param name    name
     */
    public SelectColumnElement(Dialect dialect, String name) {
        this(dialect, name, null);
    }

    /**
     * @param dialect    dialect
     * @param name       name
     * @param tableAlias table alias name
     */
    public SelectColumnElement(Dialect dialect, String name, String tableAlias) {
        this(dialect, name, tableAlias, null, null);
    }

    /**
     * @param dialect            dialect
     * @param name               name
     * @param tableAlias         tableAlias
     * @param aggregateFunctions aggregateFunctions
     */
    public SelectColumnElement(Dialect dialect, String name, String tableAlias, AggregateFunction aggregateFunctions) {
        this(dialect, name, tableAlias, aggregateFunctions, null);
    }

    /**
     * @param dialect    dialect
     * @param name       name
     * @param tableAlias tableAlias
     * @param asName     asName
     */
    public SelectColumnElement(Dialect dialect, String name, String tableAlias, String asName) {
        this(dialect, name, tableAlias, null, asName);
    }

    /**
     * @param dialect            dialect
     * @param name               name
     * @param tableAlias         tableAlias
     * @param aggregateFunctions aggregateFunctions
     * @param asName             asName
     */
    public SelectColumnElement(Dialect dialect, String name, String tableAlias, AggregateFunction aggregateFunctions,
            String asName) {
        super(dialect, name, tableAlias);
        this.aggregateFunctions = aggregateFunctions;
        this.asName = asName;
    }

    /**
     * 返回aggregateFunctions
     *
     * @return aggregateFunctions
     */
    public AggregateFunction getAggregateFunctions() {
        return aggregateFunctions;
    }

    /**
     * 设置aggregateFunctions
     *
     * @param aggregateFunctions aggregateFunctions
     */
    public void setAggregateFunctions(AggregateFunction aggregateFunctions) {
        this.aggregateFunctions = aggregateFunctions;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toSql() {
        return dialect.buildColumnSql(getName(), getTableAlias(), aggregateFunctions, asName);
    }
}
