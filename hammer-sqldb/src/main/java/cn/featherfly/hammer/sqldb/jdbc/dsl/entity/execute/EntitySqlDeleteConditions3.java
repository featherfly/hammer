
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.execute;

import cn.featherfly.common.db.builder.dml.basic.SqlDeleteFromBasicBuilder;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroup3;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroupLogic3;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlDeleteRelation;

/**
 * entity sql delete conditions 3.
 *
 * @author zhongj
 * @param <E>  the delete type
 * @param <J1> the join type 1
 * @param <J2> the join type 2
 */
public class EntitySqlDeleteConditions3<E, J1, J2> extends AbstractMulitiEntitySqlExecutableConditionsGroup3<E, J1, J2,
    DeleteConditionConfig, EntitySqlDeleteRelation, SqlDeleteFromBasicBuilder> {

    /**
     * Instantiates a new entity sql delete expression.
     *
     * @param factory        the factory
     * @param entityRelation the entity relation
     */
    public EntitySqlDeleteConditions3(JdbcMappingFactory factory, EntitySqlDeleteRelation entityRelation) {
        this(null, factory, entityRelation);
    }

    /**
     * Instantiates a new sql entity delete expression.
     *
     * @param parent         the parent
     * @param factory        the factory
     * @param entityRelation the entity relation
     */
    EntitySqlDeleteConditions3(EntityExecutableConditionGroupLogic3<E, J1, J2, DeleteConditionConfig> parent,
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
    protected EntityExecutableConditionGroup3<E, J1, J2, DeleteConditionConfig> createGroup(
        EntityExecutableConditionGroupLogic3<E, J1, J2, DeleteConditionConfig> parent) {
        return new EntitySqlDeleteConditions3<>(parent, factory, entityRelation);
    }
}
