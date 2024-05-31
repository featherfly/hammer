
package cn.featherfly.hammer.sqldb.dsl.entity.query;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import com.speedment.common.tuple.Tuple6;
import com.speedment.common.tuple.Tuple7;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.config.cache.QueryPageResult;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryValueConditionGroup;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryValueConditionGroupLogic;
import cn.featherfly.hammer.expression.entity.query.EntityQueryValueSortExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryValueSortedExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * EntitySqlQueryValueExpression .
 *
 * @author zhongj
 * @param <E> the element type
 * @param <V> the value type
 */
public class EntitySqlQueryValueExpression<E, V> extends
    AbstractMulitiEntitySqlQueryValueConditionsGroupExpression<E, V, EntityQueryValueConditionGroup<E, V>,
        EntityQueryValueConditionGroupLogic<E, V>>
    implements EntityQueryValueConditionGroup<E, V>, EntityQueryValueConditionGroupLogic<E, V>,
    EntityQueryValueSortExpression<E, V>, EntityQueryValueSortedExpression<E, V> {

    /**
     * Instantiates a new entity sql query expression.
     *
     * @param factory the factory
     * @param hammeConfig the hamme config
     * @param sqlPageFactory the sql page factory
     * @param queryRelation the query relation
     * @param valueType the value type
     */
    public EntitySqlQueryValueExpression(JdbcMappingFactory factory, HammerConfig hammeConfig,
        SqlPageFactory sqlPageFactory, EntitySqlQueryRelation queryRelation, Class<V> valueType) {
        this(null, hammeConfig, factory, sqlPageFactory, queryRelation, valueType);
    }

    /**
     * Instantiates a new entity sql query expression.
     *
     * @param parent the parent
     * @param hammeConfig the hamme config
     * @param factory the factory
     * @param sqlPageFactory the sql page factory
     * @param queryRelation the query relation
     * @param valueType the value type
     */
    EntitySqlQueryValueExpression(EntityQueryValueConditionGroupLogic<E, V> parent, HammerConfig hammeConfig,
        JdbcMappingFactory factory, SqlPageFactory sqlPageFactory, EntitySqlQueryRelation queryRelation,
        Class<V> valueType) {
        super(parent, hammeConfig, factory, sqlPageFactory, queryRelation, valueType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected EntitySqlQueryValueExpression<E, V> createGroup(EntityQueryValueConditionGroupLogic<E, V> parent) {
        return new EntitySqlQueryValueExpression<>(parent, hammerConfig, factory, sqlPageFactory, entityRelation,
            valueType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {
        return EntitySqlQueryExpression.expression(super.expression(), parent, entityRelation, getRootSortBuilder(),
            dialect);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Tuple7<String, String, List<Serializable>, Optional<Limit>, Optional<QueryPageResult>, String,
        Function<Object, Serializable>> preparePagination(Limit limit) {
        return EntitySqlQueryExpression.preparePage(hammerConfig, this, super.expression(), parent, entityRelation,
            getRootSortBuilder(), dialect, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Tuple6<String, List<Serializable>, Optional<Limit>, Optional<QueryPageResult>, String,
        Function<Object, Serializable>> prepareList(Limit limit) {
        return EntitySqlQueryExpression.prepareList(hammerConfig, this, super.expression(), parent, entityRelation,
            getRootSortBuilder(), dialect, limit);
    }
}
