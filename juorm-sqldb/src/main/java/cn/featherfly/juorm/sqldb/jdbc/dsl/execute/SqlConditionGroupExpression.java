
package cn.featherfly.juorm.sqldb.jdbc.dsl.execute;

import cn.featherfly.juorm.dsl.execute.ExecutableConditionGroupExpression;
import cn.featherfly.juorm.dsl.execute.ExecutableConditionGroupLogicExpression;
import cn.featherfly.juorm.mapping.ClassMapping;
import cn.featherfly.juorm.sqldb.jdbc.Jdbc;
import cn.featherfly.juorm.sqldb.sql.dml.AbstractSqlConditionGroupExpression;

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
     * @param jdbc jdbc
     */
    public SqlConditionGroupExpression(Jdbc jdbc) {
        this(jdbc, null);
    }

    /**
     * @param jdbc       jdbc
     * @param queryAlias queryAlias
     */
    public SqlConditionGroupExpression(Jdbc jdbc, String queryAlias) {
        this(jdbc, queryAlias, null);
    }

    /**
     * @param jdbc         jdbc
     * @param queryAlias   queryAlias
     * @param classMapping classMapping
     */
    public SqlConditionGroupExpression(Jdbc jdbc, String queryAlias, ClassMapping<?> classMapping) {
        this(jdbc, null, queryAlias, classMapping);
    }

    /**
     * @param jdbc         jdbc
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
