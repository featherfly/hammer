
package cn.featherfly.hammer.sqldb.dsl.entity.query;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import com.speedment.common.tuple.Tuple6;
import com.speedment.common.tuple.Tuple7;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.repository.QueryPageResult;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup6;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic6;
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
 * @param <T6> the generic type
 * @param <RS> the query result type
 */
public class EntitySqlQueryExpression6<T1, T2, T3, T4, T5, T6, RS> extends
    AbstractMulitiEntitySqlQueryConditionsGroupExpression6<T1, T2, T3, T4, T5, T6, RS,
        EntityQueryConditionGroup6<T1, T2, T3, T4, T5, T6, RS>,
        EntityQueryConditionGroupLogic6<T1, T2, T3, T4, T5, T6, RS>>
    implements EntityQueryConditionGroup6<T1, T2, T3, T4, T5, T6, RS>,
    EntityQueryConditionGroupLogic6<T1, T2, T3, T4, T5, T6, RS> {

    /**
     * Instantiates a new entity sql query expression.
     *
     * @param hammerConfig the hammer config
     * @param factory the factory
     * @param sqlPageFactory the sql page factory
     * @param queryRelation the query relation
     */
    public EntitySqlQueryExpression6(HammerConfig hammerConfig, JdbcMappingFactory factory,
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
    EntitySqlQueryExpression6(EntityQueryConditionGroupLogic6<T1, T2, T3, T4, T5, T6, RS> parent,
        HammerConfig hammerConfig, JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
        EntitySqlQueryRelation queryRelation) {
        super(parent, hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected EntityQueryConditionGroup6<T1, T2, T3, T4, T5, T6, RS> createGroup(
        EntityQueryConditionGroupLogic6<T1, T2, T3, T4, T5, T6, RS> parent) {
        return new EntitySqlQueryExpression6<>(parent, hammerConfig, factory, sqlPageFactory, entityRelation);
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
    public Tuple7<String, String, List<Object>, Optional<Limit>, Optional<QueryPageResult>, String,
        Function<Object, Object>> preparePagination(Limit limit) {
        return EntitySqlQueryExpression.preparePage(hammerConfig, this, super.expression(), parent, entityRelation,
            getRootSortBuilder(), dialect, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Tuple6<String, List<Object>, Optional<Limit>, Optional<QueryPageResult>, String,
        Function<Object, Object>> prepareList(Limit limit) {
        return EntitySqlQueryExpression.prepareList(hammerConfig, this, super.expression(), parent, entityRelation,
            getRootSortBuilder(), dialect, limit);
    }
}
