package cn.featherfly.hammer.sqldb.sql.dml;

import java.util.Arrays;
import java.util.List;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.builder.dml.basic.SqlOrderByBasicBuilder;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.hammer.expression.condition.SortExpression;
import cn.featherfly.common.db.dialect.Dialect;

/**
 * <p>
 * sql sort builder
 * </p>
 *
 * @author zhongj
 */
public class SqlSortExpressionBuilder implements SortExpression<SqlSortExpressionBuilder>, SqlBuilder {

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
    public SqlSortExpressionBuilder asc(List<String> names) {
        for (String name : names) {
            orderByBuilder.addAsc(name, tableAlias);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> SqlSortExpressionBuilder asc(SerializableFunction<T, R> name) {
        return asc(LambdaUtils.getLambdaPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> SqlSortExpressionBuilder asc(@SuppressWarnings("unchecked") SerializableFunction<T, R>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
                .toArray(value -> new String[value]);
        return asc(nameArray);
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
    public SqlSortExpressionBuilder desc(List<String> names) {
        for (String name : names) {
            orderByBuilder.addDesc(name, tableAlias);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> SqlSortExpressionBuilder desc(SerializableFunction<T, R> name) {
        return desc(LambdaUtils.getLambdaPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> SqlSortExpressionBuilder desc(@SuppressWarnings("unchecked") SerializableFunction<T, R>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
                .toArray(value -> new String[value]);
        return desc(nameArray);
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

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {
        return build();
    }
}