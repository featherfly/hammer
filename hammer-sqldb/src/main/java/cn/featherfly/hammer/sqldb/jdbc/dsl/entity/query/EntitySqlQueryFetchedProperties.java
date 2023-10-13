
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query;

import java.util.function.Consumer;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.config.dsl.QueryConfig;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryFetchedProperties;
import cn.featherfly.hammer.expression.entity.query.EntityQueryExpression;
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
public class EntitySqlQueryFetchedProperties<E>
        extends AbstractEntitySqlQueryFetchedProperties<E, E, EntityQueryFetchedProperties<E>>
        implements EntityQueryFetchedProperties<E> {

    /**
     * Instantiates a new entity sql query fetch.
     *
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     * @param classMapping           the class mapping
     */
    public EntitySqlQueryFetchedProperties(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation, null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryConditionGroup<E> where() {
        return new EntitySqlQueryExpression<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryConditionGroup<E> where(Consumer<EntityQueryConditionGroup<E>> consumer) {
        EntitySqlQueryExpression<E> exp = new EntitySqlQueryExpression<>(factory, sqlPageFactory, queryRelation);
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
        // YUFEI_TODO 后续加入EntityQueryValueSortExpression
        return new EntitySqlQueryExpression<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryExpression<E, EntityQueryConditionGroup<E>, EntityQueryConditionGroupLogic<E>,
            EntityQuerySortExpression<E>> configure(Consumer<QueryConfig> configure) {
        if (configure != null) {
            configure.accept(queryRelation.getConfig());
        }
        return this;
    }
}
