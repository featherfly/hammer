
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

    /**
     * @param name name
     */
    public SelectColumnElement(Dialect dialect, String name) {
        this(dialect, name, null);
    }

    /**
     * @param name
     * @param tableAlias
     */
    public SelectColumnElement(Dialect dialect, String name, String tableAlias) {
        this(dialect, name, tableAlias, null);
    }

    /**
     * @param name               name
     * @param tableAlias         tableAlias
     * @param aggregateFunctions aggregateFunctions
     */
    public SelectColumnElement(Dialect dialect, String name, String tableAlias, AggregateFunction aggregateFunctions) {
        super(dialect, name, tableAlias);
        this.aggregateFunctions = aggregateFunctions;
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
        return dialect.buildColumnSql(getName(), getTableAlias(), aggregateFunctions);
    }
}
