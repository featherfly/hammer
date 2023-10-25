
package cn.featherfly.hammer.sqldb.jdbc.dsl.execute;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

import cn.featherfly.common.exception.NotImplementedException;
import cn.featherfly.common.operator.ComparisonOperator;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.dsl.execute.ExecutableConditionGroup;
import cn.featherfly.hammer.dsl.execute.ExecutableConditionGroupLogic;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.sql.dml.AbstractSqlConditionGroupExpression;

/**
 * sql condition group builder sql条件逻辑组构造器 .
 *
 * @author zhongj
 * @param <C> the generic type
 */
public class SqlExecutableConditionGroupExpression<C extends ExecutableConditionConfig<C>>
        extends AbstractSqlConditionGroupExpression<ExecutableConditionGroup<C>, ExecutableConditionGroupLogic<C>, C>
        implements ExecutableConditionGroup<C>, ExecutableConditionGroupLogic<C> {

    /**
     * Instantiates a new sql condition group expression.
     *
     * @param jdbc            jdbc
     * @param conditionConfig the condition config
     */
    public SqlExecutableConditionGroupExpression(Jdbc jdbc, C conditionConfig) {
        this(jdbc, null, conditionConfig);
    }

    /**
     * Instantiates a new sql condition group expression.
     *
     * @param jdbc            jdbc
     * @param queryAlias      queryAlias
     * @param conditionConfig the condition config
     */
    public SqlExecutableConditionGroupExpression(Jdbc jdbc, String queryAlias, C conditionConfig) {
        this(null, jdbc, queryAlias, conditionConfig);
    }

    /**
     * Instantiates a new sql condition group expression.
     *
     * @param parent          parent group
     * @param jdbc            jdbc
     * @param queryAlias      queryAlias
     * @param conditionConfig the condition config
     */
    SqlExecutableConditionGroupExpression(ExecutableConditionGroupLogic<C> parent, Jdbc jdbc, String queryAlias,
            C conditionConfig) {
        // 删除，和更新不需要分页
        super(parent, jdbc.getDialect(), null, queryAlias, conditionConfig);
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
    @SuppressWarnings("unchecked")
    @Override
    protected ExecutableConditionGroup<C> createGroup(ExecutableConditionGroupLogic<C> parent, String queryAlias) {
        return new SqlExecutableConditionGroupExpression<>(parent, jdbc, queryAlias, (C) conditionConfig);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAlias(int index) {
        // IMPLSOON 未实现
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <M extends ClassMapping<T, P>, T, P extends PropertyMapping<P>> M getClassMapping(int index) {
        // IMPLSOON 未实现
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected <R> ExecutableConditionGroupLogic<C> eq_ne(AtomicInteger index, ComparisonOperator comparisonOperator,
            PropertyMapping<?> pm, R value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        // IMPLSOON 未实现
        throw new NotImplementedException();
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    protected <R> ExecutableConditionGroupLogic eq_ne(int index, ComparisonOperator comparisonOperator,
    //            List<PropertyMapping<?>> pms, R value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
    //        // IMPLSOON 未实现
    //        throw new NotImplementedException();
    //    }
}
