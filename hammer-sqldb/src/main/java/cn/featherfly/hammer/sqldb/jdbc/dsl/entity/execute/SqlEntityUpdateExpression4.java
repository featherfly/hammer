
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.execute;

import java.util.List;

import cn.featherfly.common.db.builder.dml.basic.SqlUpdateSetBasicBuilder;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroup4;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroupLogic4;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlUpdateRelation;

/**
 * sql entity update expression .
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <J1> the join type 1
 * @param <J2> the join type 2
 * @param <J3> the join type 3
 */
public class SqlEntityUpdateExpression4<E, J1, J2, J3> extends AbstractSqlEntityExecutableConditionGroupExpression4<E,
    J1, J2, J3, UpdateConditionConfig, EntitySqlUpdateRelation, SqlUpdateSetBasicBuilder> {
    /**
     * Instantiates a new sql entity update expression.
     *
     * @param factory        the factory
     * @param entityRelation the entity relation
     */
    public SqlEntityUpdateExpression4(JdbcMappingFactory factory, EntitySqlUpdateRelation entityRelation) {
        this(null, factory, entityRelation);
    }

    /**
     * Instantiates a new sql entity update expression.
     *
     * @param parent         the parent
     * @param factory        the factory
     * @param entityRelation the entity relation
     */
    SqlEntityUpdateExpression4(EntityExecutableConditionGroupLogic4<E, J1, J2, J3, UpdateConditionConfig> parent,
        JdbcMappingFactory factory, EntitySqlUpdateRelation entityRelation) {
        super(parent, factory, entityRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {
        return SqlEntityUpdateExpression.expression(super.expression(), parent, entityRelation, conditionConfig);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Object> getParams() {
        return SqlEntityUpdateExpression.getParams(parent, entityRelation, super.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected EntityExecutableConditionGroup4<E, J1, J2, J3, UpdateConditionConfig> createGroup(
        EntityExecutableConditionGroupLogic4<E, J1, J2, J3, UpdateConditionConfig> parent) {
        return new SqlEntityUpdateExpression4<>(parent, factory, entityRelation);
    }
}