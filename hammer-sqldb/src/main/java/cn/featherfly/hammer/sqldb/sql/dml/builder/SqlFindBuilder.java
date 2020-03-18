package cn.featherfly.hammer.sqldb.sql.dml.builder;

import java.util.Collection;

import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.hammer.dml.builder.ConditionBuilder;
import cn.featherfly.hammer.dml.builder.FindBuilder;
import cn.featherfly.hammer.operator.AggregateFunction;
import cn.featherfly.hammer.sqldb.sql.dialect.Dialect;

/**
 * <p>
 * sql find builder
 * </p>
 *
 * @author zhongj
 */
public class SqlFindBuilder extends AbstractSqlSelectBuilder implements FindBuilder {

    /**
     * @param dialect          dialect
     * @param conditionBuilder conditionBuilder
     */
    public SqlFindBuilder(Dialect dialect, SqlConditionGroup conditionBuilder) {
        this(dialect, null, null, conditionBuilder);
    }

    /**
     * @param dialect          dialect
     * @param tableName        tableName
     * @param conditionBuilder conditionBuilder
     */
    public SqlFindBuilder(Dialect dialect, String tableName, SqlConditionGroup conditionBuilder) {
        this(dialect, tableName, null, conditionBuilder);
    }

    /**
     * @param dialect          dialect
     * @param tableName        tableName
     * @param alias            alias
     * @param conditionBuilder conditionBuilder
     */
    public SqlFindBuilder(Dialect dialect, String tableName, String alias, SqlConditionGroup conditionBuilder) {
        super(dialect, tableName, alias, conditionBuilder);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FindBuilder property(String... propertyNames) {
        if (LangUtils.isNotEmpty(propertyNames)) {
            for (String p : propertyNames) {
                property(p);
            }
        }
        return this;
    }

    public FindBuilder with(String propertyName, AggregateFunction aggregateFunction) {
        addSelectColumn(propertyName, aggregateFunction);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FindBuilder property(String propertyName) {
        return with(propertyName, null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FindBuilder property(Collection<String> propertyNames) {
        if (LangUtils.isNotEmpty(propertyNames)) {
            for (String p : propertyNames) {
                property(p);
            }
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionBuilder where() {
        return conditionBuilder;
    }
}
