
package cn.featherfly.hammer.sqldb.jdbc.dsl.execute;

import java.util.function.Predicate;

import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.hammer.dsl.execute.ExecutableConditionGroupExpression;
import cn.featherfly.hammer.dsl.execute.ExecutableConditionGroupLogicExpression;
import cn.featherfly.hammer.dsl.query.TypeQueryEntity;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.sql.dml.AbstractSqlConditionGroupExpression;

/**
 * <p>
 * sql condition group builder sql条件逻辑组构造器
 * </p>
 * .
 *
 * @author zhongj
 */
public class SqlConditionGroupExpression extends
        AbstractSqlConditionGroupExpression<ExecutableConditionGroupExpression, ExecutableConditionGroupLogicExpression>
        implements ExecutableConditionGroupExpression, ExecutableConditionGroupLogicExpression {

    /**
     * Instantiates a new sql condition group expression.
     *
     * @param jdbc         jdbc
     * @param ignorePolicy the ignore policy
     */
    public SqlConditionGroupExpression(Jdbc jdbc, Predicate<Object> ignorePolicy) {
        this(jdbc, null, ignorePolicy);
    }

    /**
     * Instantiates a new sql condition group expression.
     *
     * @param jdbc         jdbc
     * @param queryAlias   queryAlias
     * @param ignorePolicy the ignore policy
     */
    public SqlConditionGroupExpression(Jdbc jdbc, String queryAlias, Predicate<Object> ignorePolicy) {
        this(jdbc, queryAlias, null, ignorePolicy);
    }

    /**
     * Instantiates a new sql condition group expression.
     *
     * @param jdbc         jdbc
     * @param queryAlias   queryAlias
     * @param classMapping classMapping
     * @param ignorePolicy the ignore policy
     */
    public SqlConditionGroupExpression(Jdbc jdbc, String queryAlias, ClassMapping<?> classMapping,
            Predicate<Object> ignorePolicy) {
        this(jdbc, null, queryAlias, classMapping, ignorePolicy);
    }

    /**
     * Instantiates a new sql condition group expression.
     *
     * @param jdbc         jdbc
     * @param parent       parent group
     * @param queryAlias   queryAlias
     * @param classMapping classMapping
     * @param ignorePolicy the ignore policy
     */
    SqlConditionGroupExpression(Jdbc jdbc, ExecutableConditionGroupLogicExpression parent, String queryAlias,
            ClassMapping<?> classMapping, Predicate<Object> ignorePolicy) {
        // 删除，和更新不需要分页
        super(parent, jdbc.getDialect(), null, queryAlias, classMapping, null, ignorePolicy);
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

    /** The jdbc. */
    protected Jdbc jdbc;

    /**
     * {@inheritDoc}
     */
    @Override
    protected ExecutableConditionGroupExpression createGroup(ExecutableConditionGroupLogicExpression parent,
            String queryAlias, TypeQueryEntity typeQueryEntity) {
        return new SqlConditionGroupExpression(jdbc, parent, queryAlias, classMapping, ignorePolicy);
    }
}
