
package cn.featherfly.hammer.sqldb.dsl.entity.query;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import cn.featherfly.common.tuple.Tuple7;
import cn.featherfly.common.tuple.Tuple8;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.config.cache.QueryPageResult;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup5;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic5;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * The Class EntitySqlQueryExpression4.
 *
 * @author zhongj
 * @param <T1> the element type
 * @param <T2> the generic type
 * @param <T3> the generic type
 * @param <T4> the generic type
 * @param <T5> the generic type
 * @param <RS> the query result type
 */
public class EntitySqlQueryExpression5<T1, T2, T3, T4, T5, RS> extends
    AbstractMulitiEntitySqlQueryConditionsGroupExpression5<T1, T2, T3, T4, T5, RS,
        EntityQueryConditionGroup5<T1, T2, T3, T4, T5, RS>, EntityQueryConditionGroupLogic5<T1, T2, T3, T4, T5, RS>>
    implements EntityQueryConditionGroup5<T1, T2, T3, T4, T5, RS>,
    EntityQueryConditionGroupLogic5<T1, T2, T3, T4, T5, RS> {

    /**
     * Instantiates a new entity sql query expression.
     *
     * @param hammerConfig the hammer config
     * @param factory the factory
     * @param sqlPageFactory the sql page factory
     * @param queryRelation the query relation
     */
    public EntitySqlQueryExpression5(HammerConfig hammerConfig, JdbcMappingFactory factory,
        SqlPageFactory sqlPageFactory, EntitySqlQueryRelation queryRelation) {
        this(null, hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    /**
     * Instantiates a new entity sql query expression.
     *
     * @param parent the parent
     * @param hammerConfig the hammer config
     * @param factory the factory
     * @param sqlPageFactory the sql page factory
     * @param queryRelation the query relation
     */
    EntitySqlQueryExpression5(EntityQueryConditionGroupLogic5<T1, T2, T3, T4, T5, RS> parent, HammerConfig hammerConfig,
        JdbcMappingFactory factory, SqlPageFactory sqlPageFactory, EntitySqlQueryRelation queryRelation) {
        super(parent, hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected EntityQueryConditionGroup5<T1, T2, T3, T4, T5, RS> createGroup(
        EntityQueryConditionGroupLogic5<T1, T2, T3, T4, T5, RS> parent) {
        return new EntitySqlQueryExpression5<>(parent, hammerConfig, factory, sqlPageFactory, entityRelation);
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
    public Tuple8<String, String, List<Serializable>, Optional<Limit>, Optional<QueryPageResult>, String,
        Function<Object, Serializable>, Optional<Boolean>> preparePagination(Limit limit) {
        return EntitySqlQueryExpression.preparePage(hammerConfig, this, super.expression(), parent, entityRelation,
            getRootSortBuilder(), dialect, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Tuple7<String, List<Serializable>, Optional<Limit>, Optional<QueryPageResult>, String,
        Function<Object, Serializable>, Optional<Boolean>> prepareList(Limit limit) {
        return EntitySqlQueryExpression.prepareList(hammerConfig, this, super.expression(), parent, entityRelation,
            getRootSortBuilder(), dialect, limit);
    }
}
