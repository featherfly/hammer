
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.execute;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroup;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroupLogic;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlRelation;
import cn.featherfly.hammer.sqldb.sql.dml.AbstractEntitySqlExecutableConditionGroupExpression;

/**
 * sql condition group builder sql条件逻辑组构造器 .
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <ER> the generic type
 * @param <B>  the generic type
 */
public abstract class AbstractSqlEntityExecutableConditionGroupExpression<E, ER extends EntitySqlRelation<ER, B>,
        B extends SqlBuilder> extends
        //        AbstractEntitySqlConditionGroupExpression<E, EntityExecutableConditionGroupExpression<E>,
        //                EntityExecutableConditionGroupLogicExpression<E>>
        AbstractEntitySqlExecutableConditionGroupExpression<E, ER, B, EntityExecutableConditionGroup<E>,
                EntityExecutableConditionGroupLogic<E>>
        implements EntityExecutableConditionGroup<E>, EntityExecutableConditionGroupLogic<E> {

    //    /**
    //     * Instantiates a new sql entity condition group expression.
    //     *
    //     * @param factory        the factory
    //     * @param entityRelation the entity relation
    //     */
    //    protected AbstractSqlEntityExecutableConditionGroupExpression(JdbcMappingFactory factory, ER entityRelation) {
    //        this(null, factory, entityRelation);
    //    }

    /**
     * Instantiates a new sql entity condition group expression.
     *
     * @param parent         the parent
     * @param factory        the factory
     * @param entityRelation the entity relation
     */
    protected AbstractSqlEntityExecutableConditionGroupExpression(EntityExecutableConditionGroupLogic<E> parent,
            JdbcMappingFactory factory, ER entityRelation) {
        // 删除，和更新不需要分页
        super(parent, factory, entityRelation);
    }

    // ********************************************************************
    // property
    // ********************************************************************

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    protected EntityExecutableConditionGroupExpression<E> createGroup(
    //            EntityExecutableConditionGroupLogicExpression<E> parent, String queryAlias,
    //            EntitySqlQuery<E> entityQueryEntity) {
    //        return new SqlEntityConditionGroupExpression<>(jdbc, parent, queryAlias, classMapping, factory, aliasManager,
    //                ignoreStrategy);
    //    }
}
