
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query;

import java.util.function.Consumer;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup6;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic6;
import cn.featherfly.hammer.expression.api.Sortable;
import cn.featherfly.hammer.expression.entity.EntityWhereExpression6;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression6;
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
public abstract class AbstractEntitySqlQueryFetch6<E, E2, E3, E4, E5, E6, RS> extends AbstractEntitySqlQuery<RS>
        implements
        EntityWhereExpression6<E, E2, E3, E4, E5, E6, EntityQueryConditionGroup6<E, E2, E3, E4, E5, E6, RS>,
                EntityQueryConditionGroupLogic6<E, E2, E3, E4, E5, E6, RS>>,
        Sortable<EntityQuerySortExpression6<E, E2, E3, E4, E5, E6, RS>> {

    /**
     * Instantiates a new abstract entity sql query fetched.
     *
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    protected AbstractEntitySqlQueryFetch6(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryConditionGroup6<E, E2, E3, E4, E5, E6, RS> where() {
        return new EntitySqlQueryExpression6<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryConditionGroup6<E, E2, E3, E4, E5, E6, RS> where(
            Consumer<EntityQueryConditionGroup6<E, E2, E3, E4, E5, E6, RS>> consumer) {
        EntitySqlQueryExpression6<E, E2, E3, E4, E5, E6,
                RS> exp = new EntitySqlQueryExpression6<>(factory, sqlPageFactory, queryRelation);
        if (consumer != null) {
            consumer.accept(exp);
        }
        return exp;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortExpression6<E, E2, E3, E4, E5, E6, RS> sort() {
        return new EntitySqlQueryExpression6<>(factory, sqlPageFactory, queryRelation);
    }

}
