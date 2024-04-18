
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.execute;

import java.util.List;

import cn.featherfly.common.db.builder.dml.basic.SqlUpdateSetBasicBuilder;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroup3;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroupLogic3;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlUpdateRelation;

/**
 * sql entity update expression .
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <J1> the join type 1
 * @param <J2> the join type 2
 */
public class SqlEntityUpdateExpression3<E, J1, J2> extends AbstractSqlEntityExecutableConditionGroupExpression3<E, J1,
    J2, UpdateConditionConfig, EntitySqlUpdateRelation, SqlUpdateSetBasicBuilder> {
    /**
     * Instantiates a new sql entity update expression.
     *
     * @param factory        the factory
     * @param entityRelation the entity relation
     */
    public SqlEntityUpdateExpression3(JdbcMappingFactory factory, EntitySqlUpdateRelation entityRelation) {
        this(null, factory, entityRelation);
    }

    /**
     * Instantiates a new sql entity update expression.
     *
     * @param parent         the parent
     * @param factory        the factory
     * @param entityRelation the entity relation
     */
    SqlEntityUpdateExpression3(EntityExecutableConditionGroupLogic3<E, J1, J2, UpdateConditionConfig> parent,
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
    protected EntityExecutableConditionGroup3<E, J1, J2, UpdateConditionConfig> createGroup(
        EntityExecutableConditionGroupLogic3<E, J1, J2, UpdateConditionConfig> parent) {
        return new SqlEntityUpdateExpression3<>(parent, factory, entityRelation);
    }
}
