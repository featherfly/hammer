
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query;

import java.util.function.Consumer;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.dsl.query.type.EntityQueryFetchedProperty;
import cn.featherfly.hammer.dsl.query.type.EntityQueryValueConditionGroup;
import cn.featherfly.hammer.expression.condition.ConditionGroupConfig;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;

/**
 * abstract entity sql query entity properties.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <P> the generic type
 */
public class EntitySqlQueryFetchedProperty<E> extends AbstractEntitySqlQueryFetch<E, EntityQueryFetchedProperty<E>>
        implements EntityQueryFetchedProperty<E> {
    //    extends AbstractEntitySqlQueryFetched<E> {

    /**
     * Instantiates a new entity sql query fetch.
     *
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     * @param classMapping           the class mapping
     */
    public EntitySqlQueryFetchedProperty(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryValueConditionGroup<E> where() {
        return new EntitySqlQueryValueExpression<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryValueConditionGroup<E> where(
            Consumer<ConditionGroupConfig<EntityQueryValueConditionGroup<E>>> consumer) {
        EntitySqlQueryValueExpression<
                E> exp = new EntitySqlQueryValueExpression<>(factory, sqlPageFactory, queryRelation);
        if (consumer != null) {
            consumer.accept(exp);
        }
        return exp;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortExpression<E> sort() {
        return new EntitySqlQueryExpression<>(factory, sqlPageFactory, queryRelation);
    }
}
