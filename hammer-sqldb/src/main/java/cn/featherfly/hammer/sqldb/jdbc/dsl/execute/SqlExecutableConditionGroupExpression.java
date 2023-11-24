
package cn.featherfly.hammer.sqldb.jdbc.dsl.execute;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.exception.NotImplementedException;
import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.dsl.execute.ExecutableConditionGroup;
import cn.featherfly.hammer.dsl.execute.ExecutableConditionGroupLogic;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.AbstractMulitiRepositorySqlConditionsGroupExpression;

/**
 * sql condition group builder sql条件逻辑组构造器 .
 *
 * @author zhongj
 * @param <C> the generic type
 */
public abstract class SqlExecutableConditionGroupExpression<C extends ExecutableConditionConfig<C>,
        R extends RepositorySqlRelation<R, B>, B extends SqlBuilder> extends
        //        AbstractRepositorySqlConditionGroupExpression<ExecutableConditionGroup<C>, ExecutableConditionGroupLogic<C>, C>
        AbstractMulitiRepositorySqlConditionsGroupExpression<ExecutableConditionGroup<C>,
                ExecutableConditionGroupLogic<C>, C, R, B>
        implements ExecutableConditionGroup<C>, ExecutableConditionGroupLogic<C> {
    // FIXME 使用AbstractMulitiRepositorySqlConditionExpression代替AbstractMulitiRepositorySqlConditionsGroupExpression
    /**
     * Instantiates a new sql condition group expression.
     *
     * @param jdbc            jdbc
     * @param conditionConfig the condition config
     */
    public SqlExecutableConditionGroupExpression(Jdbc jdbc, R repositoryRelation, C conditionConfig) {
        this(jdbc, null, repositoryRelation, conditionConfig);
    }

    /**
     * Instantiates a new sql condition group expression.
     *
     * @param jdbc            jdbc
     * @param queryAlias      queryAlias
     * @param conditionConfig the condition config
     */
    public SqlExecutableConditionGroupExpression(Jdbc jdbc, String queryAlias, R repositoryRelation,
            C conditionConfig) {
        this(null, jdbc, queryAlias, repositoryRelation, conditionConfig);
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
            R repositoryRelation, C conditionConfig) {
        // 删除，和更新不需要分页
        super(parent, jdbc.getDialect(), queryAlias, repositoryRelation, conditionConfig);
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
            String sql = expression();
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
    public String getAlias(int index) {
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
