package cn.featherfly.juorm.sql.dml.builder;

import java.util.Collection;

import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.juorm.dml.builder.ConditionBuilder;
import cn.featherfly.juorm.dml.builder.FindBuilder;

/**
 * <p>
 * sql find builder
 * </p>
 * 
 * @author zhongj
 */
public class SqlFindBuilder extends AbstractSqlSelectBuilder implements FindBuilder {

    /**
     * @param conditionBuilder conditionBuilder
     */
    public SqlFindBuilder(SqlConditionGroup conditionBuilder) {
        this(null, null, conditionBuilder);
    }
    /**
     * @param tableName tableName
     * @param conditionBuilder conditionBuilder
     */
    public SqlFindBuilder(String tableName, SqlConditionGroup conditionBuilder) {
        this(tableName, null, conditionBuilder);
    }
    
    /**
     * @param tableName tableName
     * @param alias alias
     * @param conditionBuilder conditionBuilder
     */
    public SqlFindBuilder(String tableName, String alias, SqlConditionGroup conditionBuilder) {
        super(tableName, alias, conditionBuilder);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public FindBuilder with(String... propertyNames) {
        if (LangUtils.isNotEmpty(propertyNames)) {
            for (String p : propertyNames) {
                with(p);
            }
        }
        return this;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public FindBuilder with(String propertyName) {
        addSelectColumn(propertyName);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FindBuilder with(Collection<String> propertyNames) {
        if (LangUtils.isNotEmpty(propertyNames)) {
            for (String p : propertyNames) {
                with(p);
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
