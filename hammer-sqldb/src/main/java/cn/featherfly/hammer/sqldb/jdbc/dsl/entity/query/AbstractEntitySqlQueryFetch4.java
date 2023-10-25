
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query;

import java.util.function.Consumer;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup4;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic4;
import cn.featherfly.hammer.expression.api.Sortable;
import cn.featherfly.hammer.expression.entity.EntityWhereExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression4;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;

/**
 * The Class AbstractEntitySqlQueryFetch4.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <RS> the generic type
 */
public abstract class AbstractEntitySqlQueryFetch4<E, E2, E3, E4, RS> extends AbstractEntitySqlQuery<RS> implements
        EntityWhereExpression4<E, E2, E3, E4, EntityQueryConditionGroup4<E, E2, E3, E4, RS>,
                EntityQueryConditionGroupLogic4<E, E2, E3, E4, RS>>,
        Sortable<EntityQuerySortExpression4<E, E2, E3, E4, RS>> {

    /**
     * Instantiates a new abstract entity sql query fetched.
     *
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    protected AbstractEntitySqlQueryFetch4(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryConditionGroup4<E, E2, E3, E4, RS> where() {
        return new EntitySqlQueryExpression4<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryConditionGroup4<E, E2, E3, E4, RS> where(
            Consumer<EntityQueryConditionGroup4<E, E2, E3, E4, RS>> consumer) {
        EntitySqlQueryExpression4<E, E2, E3, E4,
                RS> exp = new EntitySqlQueryExpression4<>(factory, sqlPageFactory, queryRelation);
        if (consumer != null) {
            consumer.accept(exp);
        }
        return exp;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortExpression4<E, E2, E3, E4, RS> sort() {
        return new EntitySqlQueryExpression4<>(factory, sqlPageFactory, queryRelation);
    }

}
