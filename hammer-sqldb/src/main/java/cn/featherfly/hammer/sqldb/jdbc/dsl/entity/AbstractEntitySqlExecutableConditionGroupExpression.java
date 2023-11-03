
/*
 * All rights Reserved, Designed By zhongj
 * @Title: AbstractEntitySqlExecutionConditionGroupExpression.java
 * @Package cn.featherfly.hammer.sqldb.sql.dml
 * @Description: AbstractEntitySqlExecutionConditionGroupExpression
 * @author: zhongj
 * @date: 2023-07-31 18:29:31
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity;

import java.util.function.Consumer;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroup;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroupLogic;

/**
 * AbstractEntitySqlExecutionConditionGroupExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <R> the generic type
 * @param <B> the generic type
 * @param <L> the generic type
 * @param <C> the generic type
 */
public abstract class AbstractEntitySqlExecutableConditionGroupExpression<E, R extends EntitySqlRelation<R, B>,
        B extends SqlBuilder, L extends EntityExecutableConditionGroupLogic<E, C>,
        C extends ExecutableConditionConfig<C>> extends
        AbstractMulitiEntitySqlConditionsGroupExpressionBase<E, R, B, EntityExecutableConditionGroup<E, C>,
                EntityExecutableConditionGroupLogic<E, C>, C>
        implements EntityExecutableConditionGroup<E, C>, EntityExecutableConditionGroupLogic<E, C> {

    /**
     * Instantiates a new abstract entity sql executable condition group
     * expression.
     *
     * @param parent            the parent
     * @param factory           the factory
     * @param entitySqlRelation the entity sql relation
     */
    protected AbstractEntitySqlExecutableConditionGroupExpression(L parent, JdbcMappingFactory factory,
            R entitySqlRelation) {
        super(parent, factory, entitySqlRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int execute() {
        if (parent != null) {
            return parent.execute();
        } else {
            return entityRelation.getJdbc().update(expression(), getParams().toArray());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityExecutableConditionGroup<E, C> configure(Consumer<C> configure) {
        if (configure != null) {
            configure.accept(conditionConfig);
        }
        return this;
    }
}
