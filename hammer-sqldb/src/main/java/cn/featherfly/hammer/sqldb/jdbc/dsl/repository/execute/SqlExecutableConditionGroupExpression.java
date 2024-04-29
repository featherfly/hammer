
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.execute;

import java.util.Date;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.exception.NotImplementedException;
import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroup;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroupLogic;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryDateFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryEnumFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryLocalDateFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryLocalDateTimeFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryLocalTimeFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryNumberFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositorySerializableFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryStringFieldExpression;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.AbstractMulitiRepositorySqlConditionsGroupExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.field.DateFieldExpressionMulitiRepositoryImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.field.EnumFieldExpressionMulitiRepositoryImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.field.LocalDateFieldExpressionMulitiRepositoryImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.field.LocalDateTimeFieldExpressionMulitiRepositoryImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.field.LocalTimeFieldExpressionMulitiRepositoryImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.field.NumberFieldExpressionMulitiRepositoryImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.field.SerializableFieldExpressionMulitiRepositoryImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.field.StringFieldExpressionMulitiRepositoryImpl;

/**
 * sql condition group builder sql条件逻辑组构造器 .
 *
 * @author zhongj
 * @param <C> the generic type
 */
public abstract class SqlExecutableConditionGroupExpression<C extends ExecutableConditionConfig<C>,
        R extends RepositorySqlRelation<R, B>, B extends SqlBuilder> extends
        //        AbstractRepositorySqlConditionGroupExpression<ExecutableConditionGroup<C>, ExecutableConditionGroupLogic<C>, C>
        AbstractMulitiRepositorySqlConditionsGroupExpression<RepositoryExecutableConditionsGroup<C>, RepositoryExecutableConditionsGroupLogic<C>, C, R, B>
        implements RepositoryExecutableConditionsGroup<C>, RepositoryExecutableConditionsGroupLogic<C> {
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
    SqlExecutableConditionGroupExpression(RepositoryExecutableConditionsGroupLogic<C> parent, Jdbc jdbc, String queryAlias,
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

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositorySerializableFieldExpression<RepositoryExecutableConditionsGroup<C>, RepositoryExecutableConditionsGroupLogic<C>> field(
            String name) {
        return new SerializableFieldExpressionMulitiRepositoryImpl<>(0, name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryStringFieldExpression<RepositoryExecutableConditionsGroup<C>, RepositoryExecutableConditionsGroupLogic<C>> fieldAsString(
            String name) {
        return new StringFieldExpressionMulitiRepositoryImpl<>(0, name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> RepositoryNumberFieldExpression<N, RepositoryExecutableConditionsGroup<C>, RepositoryExecutableConditionsGroupLogic<C>> fieldAsNumber(
            String name) {
        return new NumberFieldExpressionMulitiRepositoryImpl<>(0, name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> RepositoryEnumFieldExpression<E, RepositoryExecutableConditionsGroup<C>, RepositoryExecutableConditionsGroupLogic<C>> fieldAsEnum(
            String name) {
        return new EnumFieldExpressionMulitiRepositoryImpl<>(0, name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> RepositoryDateFieldExpression<D, RepositoryExecutableConditionsGroup<C>, RepositoryExecutableConditionsGroupLogic<C>> fieldAsDate(
            String name) {
        return new DateFieldExpressionMulitiRepositoryImpl<>(0, name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryLocalDateFieldExpression<RepositoryExecutableConditionsGroup<C>, RepositoryExecutableConditionsGroupLogic<C>> fieldAsLocalDate(
            String name) {
        return new LocalDateFieldExpressionMulitiRepositoryImpl<>(0, name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryLocalDateTimeFieldExpression<RepositoryExecutableConditionsGroup<C>, RepositoryExecutableConditionsGroupLogic<C>> fieldAsLocalDateTime(
            String name) {
        return new LocalDateTimeFieldExpressionMulitiRepositoryImpl<>(0, name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryLocalTimeFieldExpression<RepositoryExecutableConditionsGroup<C>, RepositoryExecutableConditionsGroupLogic<C>> fieldAsLocalTime(
            String name) {
        return new LocalTimeFieldExpressionMulitiRepositoryImpl<>(0, name, this);
    }
}
