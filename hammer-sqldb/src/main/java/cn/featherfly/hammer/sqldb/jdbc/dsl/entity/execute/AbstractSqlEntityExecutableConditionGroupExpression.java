
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.execute;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroup;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroupLogic;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.AbstractEntitySqlExecutableConditionGroupExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlRelation;

/**
 * sql condition group builder sql条件逻辑组构造器 .
 *
 * @author zhongj
 * @param <T> the element type
 * @param <R> the generic type
 * @param <B> the generic type
 * @param <C> the generic type
 */
public abstract class AbstractSqlEntityExecutableConditionGroupExpression<T, R extends EntitySqlRelation<R, B>,
        B extends SqlBuilder, C extends ExecutableConditionConfig<C>> extends
        AbstractEntitySqlExecutableConditionGroupExpression<T, R, B, EntityExecutableConditionGroupLogic<T, C>, C>
        implements EntityExecutableConditionGroup<T, C>, EntityExecutableConditionGroupLogic<T, C> {

    /**
     * Instantiates a new sql entity condition group expression.
     *
     * @param parent         the parent
     * @param factory        the factory
     * @param entityRelation the entity relation
     */
    protected AbstractSqlEntityExecutableConditionGroupExpression(EntityExecutableConditionGroupLogic<T, C> parent,
            JdbcMappingFactory factory, R entityRelation) {
        // 删除，和更新不需要分页
        super(parent, factory, entityRelation);
    }

    // ********************************************************************
    // property
    // ********************************************************************
}
