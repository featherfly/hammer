
package cn.featherfly.hammer.sqldb.jdbc.dsl.execute;

import java.util.function.Predicate;

import cn.featherfly.common.operator.QueryOperator;
import cn.featherfly.common.operator.QueryOperator.QueryPolicy;
import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.hammer.dsl.execute.ExecutableConditionGroupExpression;
import cn.featherfly.hammer.dsl.execute.ExecutableConditionGroupLogicExpression;
import cn.featherfly.hammer.dsl.query.TypeQueryEntity;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.sql.dml.AbstractSqlConditionGroupExpression;

/**
 * sql condition group builder sql条件逻辑组构造器 .
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
     * @param ignoreStrategy the ignore strategy
     */
    public SqlConditionGroupExpression(Jdbc jdbc, Predicate<?> ignoreStrategy) {
        this(jdbc, null, ignoreStrategy);
    }

    /**
     * Instantiates a new sql condition group expression.
     *
     * @param jdbc         jdbc
     * @param queryAlias   queryAlias
     * @param ignoreStrategy the ignore strategy
     */
    public SqlConditionGroupExpression(Jdbc jdbc, String queryAlias, Predicate<?> ignoreStrategy) {
        this(null, jdbc, queryAlias, ignoreStrategy);
    }

    /**
     * Instantiates a new sql condition group expression.
     *
     * @param jdbc         jdbc
     * @param parent       parent group
     * @param queryAlias   queryAlias
     * @param classMapping classMapping
     * @param ignoreStrategy the ignore strategy
     */
    SqlConditionGroupExpression(ExecutableConditionGroupLogicExpression parent, Jdbc jdbc, String queryAlias,
            Predicate<?> ignoreStrategy) {
        // 删除，和更新不需要分页
        super(parent, jdbc.getDialect(), null, queryAlias, null, ignoreStrategy);
        this.jdbc = jdbc;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int execute() {
        if (parent != null) {
            return parent.execute();
        } else {
            String sql = build();
            if (sql == null) {
                return 0;
            } else {
                return jdbc.update(sql, getParams().toArray());
            }
        }
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
        return new SqlConditionGroupExpression(parent, jdbc, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAlias(int index) {
        // IMPLSOON 后续来实现
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <CM extends ClassMapping<T, P>, T, P extends PropertyMapping<P>> CM getClassMapping(int index) {
        // IMPLSOON 后续来实现
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected <T, R> ExecutableConditionGroupLogicExpression eq_ne(int index, QueryOperator queryOperator,
            PropertyMapping<?> pm, R value, QueryPolicy queryPolicy, Predicate<?> ignoreStrategy) {
        // IMPLSOON 后续来实现
        return null;
    }
}
