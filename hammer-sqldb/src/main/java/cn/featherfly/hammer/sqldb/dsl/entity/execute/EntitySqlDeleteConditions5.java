
package cn.featherfly.hammer.sqldb.dsl.entity.execute;

import cn.featherfly.common.db.builder.dml.basic.SqlDeleteFromBasicBuilder;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroup5;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroupLogic5;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlDeleteRelation;

/**
 * entity sql delete conditions 5.
 *
 * @author zhongj
 * @param <E>  the delete type
 * @param <J1> the join type 1
 * @param <J2> the join type 2
 * @param <J3> the join type 3
 * @param <J4> the join type 4
 */
public class EntitySqlDeleteConditions5<E, J1, J2, J3, J4> extends AbstractMulitiEntitySqlExecutableConditionsGroup5<E,
    J1, J2, J3, J4, DeleteConditionConfig, EntitySqlDeleteRelation, SqlDeleteFromBasicBuilder> {

    /**
     * Instantiates a new entity sql delete expression.
     *
     * @param factory        the factory
     * @param entityRelation the entity relation
     */
    public EntitySqlDeleteConditions5(JdbcMappingFactory factory, EntitySqlDeleteRelation entityRelation) {
        this(null, factory, entityRelation);
    }

    /**
     * Instantiates a new sql entity delete expression.
     *
     * @param parent         the parent
     * @param factory        the factory
     * @param entityRelation the entity relation
     */
    EntitySqlDeleteConditions5(EntityExecutableConditionGroupLogic5<E, J1, J2, J3, J4, DeleteConditionConfig> parent,
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
    protected EntityExecutableConditionGroup5<E, J1, J2, J3, J4, DeleteConditionConfig> createGroup(
        EntityExecutableConditionGroupLogic5<E, J1, J2, J3, J4, DeleteConditionConfig> parent) {
        return new EntitySqlDeleteConditions5<>(parent, factory, entityRelation);
    }
}
