
package cn.featherfly.hammer.sqldb.dsl.entity.execute;

import java.io.Serializable;
import java.util.List;

import cn.featherfly.common.db.builder.dml.basic.SqlUpdateSetBasicBuilder;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroup6;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroupLogic6;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlUpdateRelation;

/**
 * sql entity update conditions group expression .
 *
 * @author zhongj
 * @param <E> the update type
 * @param <J1> the join type 1
 * @param <J2> the join type 2
 * @param <J3> the join type 3
 * @param <J4> the join type 4
 * @param <J5> the join type 5
 */
public class EntitySqlUpdateConditions6<E, J1, J2, J3, J4, J5>
    extends AbstractMulitiEntitySqlExecutableConditionsGroup6<E, J1, J2, J3, J4, J5, UpdateConditionConfig,
        EntitySqlUpdateRelation, SqlUpdateSetBasicBuilder> {
    /**
     * Instantiates a new sql entity update expression.
     *
     * @param factory the factory
     * @param entityRelation the entity relation
     */
    public EntitySqlUpdateConditions6(JdbcMappingFactory factory, EntitySqlUpdateRelation entityRelation) {
        this(null, factory, entityRelation);
    }

    /**
     * Instantiates a new sql entity update expression.
     *
     * @param parent the parent
     * @param factory the factory
     * @param entityRelation the entity relation
     */
    EntitySqlUpdateConditions6(
        EntityExecutableConditionGroupLogic6<E, J1, J2, J3, J4, J5, UpdateConditionConfig> parent,
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
    protected EntityExecutableConditionGroup6<E, J1, J2, J3, J4, J5, UpdateConditionConfig> createGroup(
        EntityExecutableConditionGroupLogic6<E, J1, J2, J3, J4, J5, UpdateConditionConfig> parent) {
        return new EntitySqlUpdateConditions6<>(parent, factory, entityRelation);
    }
}
