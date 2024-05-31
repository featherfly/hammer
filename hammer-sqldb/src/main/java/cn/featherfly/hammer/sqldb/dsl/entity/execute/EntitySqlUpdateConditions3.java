
package cn.featherfly.hammer.sqldb.dsl.entity.execute;

import java.io.Serializable;
import java.util.List;

import cn.featherfly.common.db.builder.dml.basic.SqlUpdateSetBasicBuilder;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroup3;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroupLogic3;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlUpdateRelation;

/**
 * sql entity update conditions group expression .
 *
 * @author zhongj
 * @param <E> the update type
 * @param <J1> the join type 1
 * @param <J2> the join type 2
 */
public class EntitySqlUpdateConditions3<E, J1, J2> extends AbstractMulitiEntitySqlExecutableConditionsGroup3<E, J1, J2,
    UpdateConditionConfig, EntitySqlUpdateRelation, SqlUpdateSetBasicBuilder> {
    /**
     * Instantiates a new sql entity update expression.
     *
     * @param factory the factory
     * @param entityRelation the entity relation
     */
    public EntitySqlUpdateConditions3(JdbcMappingFactory factory, EntitySqlUpdateRelation entityRelation) {
        this(null, factory, entityRelation);
    }

    /**
     * Instantiates a new sql entity update expression.
     *
     * @param parent the parent
     * @param factory the factory
     * @param entityRelation the entity relation
     */
    EntitySqlUpdateConditions3(EntityExecutableConditionGroupLogic3<E, J1, J2, UpdateConditionConfig> parent,
        JdbcMappingFactory factory, EntitySqlUpdateRelation entityRelation) {
        super(parent, factory, entityRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {
        return EntitySqlUpdateConditions.expression(super.expression(), parent, entityRelation, conditionConfig);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Serializable> getParams() {
        return EntitySqlUpdateConditions.getParams(parent, entityRelation, super.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected EntityExecutableConditionGroup3<E, J1, J2, UpdateConditionConfig> createGroup(
        EntityExecutableConditionGroupLogic3<E, J1, J2, UpdateConditionConfig> parent) {
        return new EntitySqlUpdateConditions3<>(parent, factory, entityRelation);
    }
}
