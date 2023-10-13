
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query;

import java.util.function.Consumer;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup3;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic3;
import cn.featherfly.hammer.expression.api.Sortable;
import cn.featherfly.hammer.expression.entity.EntityWhereExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression3;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;

/**
 * The Class AbstractEntitySqlQueryFetch3.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <RS> the generic type
 */
public abstract class AbstractEntitySqlQueryFetch3<E, E2, E3, RS> extends AbstractEntitySqlQuery<RS>
        implements EntityWhereExpression3<E, E2, E3, EntityQueryConditionGroup3<E, E2, E3, RS>,
                EntityQueryConditionGroupLogic3<E, E2, E3, RS>>,
        Sortable<EntityQuerySortExpression3<E, E2, E3, RS>> {

    /**
     * Instantiates a new abstract entity sql query fetched.
     *
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    protected AbstractEntitySqlQueryFetch3(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryConditionGroup3<E, E2, E3, RS> where() {
        return new EntitySqlQueryExpression3<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryConditionGroup3<E, E2, E3, RS> where(
            Consumer<EntityQueryConditionGroup3<E, E2, E3, RS>> consumer) {
        EntityQueryConditionGroup3<E, E2, E3,
                RS> exp = new EntitySqlQueryExpression3<>(factory, sqlPageFactory, queryRelation);
        if (consumer != null) {
            consumer.accept(exp);
        }
        return exp;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortExpression3<E, E2, E3, RS> sort() {
        return new EntitySqlQueryExpression3<>(factory, sqlPageFactory, queryRelation);
    }

}
