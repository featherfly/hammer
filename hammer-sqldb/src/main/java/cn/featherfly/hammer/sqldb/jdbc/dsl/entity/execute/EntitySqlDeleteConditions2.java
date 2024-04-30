
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.execute;

import cn.featherfly.common.db.builder.dml.basic.SqlDeleteFromBasicBuilder;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroup2;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroupLogic2;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlDeleteRelation;

/**
 * entity sql delete conditions 2.
 *
 * @author zhongj
 * @param <E>  the delete type
 * @param <J1> the join type 1
 */
public class EntitySqlDeleteConditions2<E, J1> extends AbstractMulitiEntitySqlExecutableConditionsGroup2<E, J1,
    DeleteConditionConfig, EntitySqlDeleteRelation, SqlDeleteFromBasicBuilder> {

    /**
     * Instantiates a new entity sql delete expression.
     *
     * @param factory        the factory
     * @param entityRelation the entity relation
     */
    public EntitySqlDeleteConditions2(JdbcMappingFactory factory, EntitySqlDeleteRelation entityRelation) {
        this(null, factory, entityRelation);
    }

    /**
     * Instantiates a new sql entity delete expression.
     *
     * @param parent         the parent
     * @param factory        the factory
     * @param entityRelation the entity relation
     */
    EntitySqlDeleteConditions2(EntityExecutableConditionGroupLogic2<E, J1, DeleteConditionConfig> parent,
        JdbcMappingFactory factory, EntitySqlDeleteRelation entityRelation) {
        super(parent, factory, entityRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {
        return EntitySqlDeleteConditions.expression(super.expression(), parent, entityRelation, conditionConfig);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected EntityExecutableConditionGroup2<E, J1, DeleteConditionConfig> createGroup(
        EntityExecutableConditionGroupLogic2<E, J1, DeleteConditionConfig> parent) {
        return new EntitySqlDeleteConditions2<>(parent, factory, entityRelation);
    }
}
