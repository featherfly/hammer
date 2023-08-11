
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query;

import java.util.function.Consumer;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup5;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic5;
import cn.featherfly.hammer.expression.api.Sortable;
import cn.featherfly.hammer.expression.condition.ConditionGroupConfig;
import cn.featherfly.hammer.expression.entity.EntityWhereExpression5;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression5;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;

/**
 * The Class AbstractEntitySqlQueryFetch5.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <RS> the generic type
 */
public abstract class AbstractEntitySqlQueryFetch5<E, E2, E3, E4, E5, RS> extends AbstractEntitySqlQuery<RS> implements
        EntityWhereExpression5<E, E2, E3, E4, E5, EntityQueryConditionGroup5<E, E2, E3, E4, E5, RS>,
                EntityQueryConditionGroupLogic5<E, E2, E3, E4, E5, RS>>,
        Sortable<EntityQuerySortExpression5<E, E2, E3, E4, E5, RS>> {

    /**
     * Instantiates a new abstract entity sql query fetched.
     *
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    protected AbstractEntitySqlQueryFetch5(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryConditionGroup5<E, E2, E3, E4, E5, RS> where() {
        return new EntitySqlQueryExpression5<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryConditionGroup5<E, E2, E3, E4, E5, RS> where(
            Consumer<ConditionGroupConfig<EntityQueryConditionGroup5<E, E2, E3, E4, E5, RS>>> consumer) {
        EntitySqlQueryExpression5<E, E2, E3, E4, E5,
                RS> exp = new EntitySqlQueryExpression5<>(factory, sqlPageFactory, queryRelation);
        if (consumer != null) {
            consumer.accept(exp);
        }
        return exp;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortExpression5<E, E2, E3, E4, E5, RS> sort() {
        return new EntitySqlQueryExpression5<>(factory, sqlPageFactory, queryRelation);
    }

}
