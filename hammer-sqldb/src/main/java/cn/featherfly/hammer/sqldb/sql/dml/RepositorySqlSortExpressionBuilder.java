package cn.featherfly.hammer.sqldb.sql.dml;

import java.util.Arrays;
import java.util.List;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.builder.dml.basic.SqlOrderByBasicBuilder;
import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortExpression;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortedExpression;

/**
 * repository sql sort expression builder.
 *
 * @author zhongj
 */
public class RepositorySqlSortExpressionBuilder implements RepositorySortExpression<RepositorySqlSortExpressionBuilder>,
        RepositorySortedExpression<RepositorySqlSortExpressionBuilder>, SqlBuilder {

    private SqlOrderByBasicBuilder orderByBuilder;

    private String tableAlias;

    public RepositorySqlSortExpressionBuilder(Dialect dialect) {
        this(dialect, null);
    }

    public RepositorySqlSortExpressionBuilder(Dialect dialect, String tableAlias) {
        orderByBuilder = new SqlOrderByBasicBuilder(dialect);
        this.tableAlias = tableAlias;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositorySqlSortExpressionBuilder asc(String... names) {
        for (String name : names) {
            orderByBuilder.addAsc(name, tableAlias);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositorySqlSortExpressionBuilder asc(List<String> names) {
        for (String name : names) {
            orderByBuilder.addAsc(name, tableAlias);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositorySqlSortExpressionBuilder asc(SerializableFunction<T, R> name) {
        return asc(LambdaUtils.getLambdaPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositorySqlSortExpressionBuilder asc(
            @SuppressWarnings("unchecked") SerializableFunction<T, R>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
                .toArray(value -> new String[value]);
        return asc(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositorySqlSortExpressionBuilder desc(String... names) {
        for (String name : names) {
            orderByBuilder.addDesc(name, tableAlias);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositorySqlSortExpressionBuilder desc(List<String> names) {
        for (String name : names) {
            orderByBuilder.addDesc(name, tableAlias);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositorySqlSortExpressionBuilder desc(SerializableFunction<T, R> name) {
        return desc(LambdaUtils.getLambdaPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositorySqlSortExpressionBuilder desc(
            @SuppressWarnings("unchecked") SerializableFunction<T, R>... names) {
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