
package cn.featherfly.juorm.rdb.jdbc.dsl.execute;

import cn.featherfly.juorm.dsl.execute.ExecutableConditionGroupExpression;
import cn.featherfly.juorm.dsl.execute.ExecutableConditionGroupLogicExpression;
import cn.featherfly.juorm.rdb.jdbc.Jdbc;
import cn.featherfly.juorm.rdb.jdbc.mapping.ClassMapping;
import cn.featherfly.juorm.rdb.sql.dml.AbstractSqlConditionGroupExpression;

/**
 * <p>
 * sql condition group builder sql条件逻辑组构造器
 * </p>
 *
 * @author zhongj
 */
public class SqlConditionGroupExpression extends
        AbstractSqlConditionGroupExpression<ExecutableConditionGroupExpression, ExecutableConditionGroupLogicExpression>
        implements ExecutableConditionGroupExpression, ExecutableConditionGroupLogicExpression {

    /**
     * @param dialect dialect
     */
    public SqlConditionGroupExpression(Jdbc jdbc) {
        this(jdbc, null);
    }

    /**
     * @param dialect    dialect
     * @param queryAlias queryAlias
     */
    public SqlConditionGroupExpression(Jdbc jdbc, String queryAlias) {
        this(jdbc, queryAlias, null);
    }

    /**
     * @param dialect      dialect
     * @param queryAlias   queryAlias
     * @param classMapping classMapping
     */
    public SqlConditionGroupExpression(Jdbc jdbc, String queryAlias, ClassMapping<?> classMapping) {
        this(jdbc, null, queryAlias, classMapping);
    }

    /**
     * @param dialect      dialect
     * @param parent       parent group
     * @param queryAlias   queryAlias
     * @param classMapping classMapping
     */
    SqlConditionGroupExpression(Jdbc jdbc, ExecutableConditionGroupLogicExpression parent, String queryAlias,
            ClassMapping<?> classMapping) {
        super(jdbc.getDialect(), parent, queryAlias, classMapping);
        this.jdbc = jdbc;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int execute() {
        return jdbc.update(build(), getParams().toArray());
    }

    // ********************************************************************
    // property
    // ********************************************************************

    protected Jdbc jdbc;

    /**
     * {@inheritDoc}
     */
    @Override
    protected ExecutableConditionGroupExpression createGroup(ExecutableConditionGroupLogicExpression parent,
            String queryAlias) {
        return new SqlConditionGroupExpression(jdbc, parent, queryAlias, classMapping);
    }
}
