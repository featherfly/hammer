
package cn.featherfly.hammer.sqldb.dsl.entity.query;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import com.speedment.common.tuple.Tuple7;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.repository.QueryPageResults;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup4;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic4;
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
 * @param <RS> the query result type
 */
public class EntitySqlQueryExpression4<T1, T2, T3, T4, RS> extends
    AbstractMulitiEntitySqlQueryConditionsGroupExpression4<T1, T2, T3, T4, RS,
        EntityQueryConditionGroup4<T1, T2, T3, T4, RS>, EntityQueryConditionGroupLogic4<T1, T2, T3, T4, RS>>
    implements EntityQueryConditionGroup4<T1, T2, T3, T4, RS>, EntityQueryConditionGroupLogic4<T1, T2, T3, T4, RS> {

    /**
     * Instantiates a new entity sql query expression.
     *
     * @param hammerConfig the hammer config
     * @param factory the factory
     * @param sqlPageFactory the sql page factory
     * @param queryRelation the query relation
     */
    public EntitySqlQueryExpression4(HammerConfig hammerConfig, JdbcMappingFactory factory,
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
    EntitySqlQueryExpression4(EntityQueryConditionGroupLogic4<T1, T2, T3, T4, RS> parent, HammerConfig hammerConfig,
        JdbcMappingFactory factory, SqlPageFactory sqlPageFactory, EntitySqlQueryRelation queryRelation) {
        super(parent, hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected EntityQueryConditionGroup4<T1, T2, T3, T4, RS> createGroup(
        EntityQueryConditionGroupLogic4<T1, T2, T3, T4, RS> parent) {
        return new EntitySqlQueryExpression4<>(parent, hammerConfig, factory, sqlPageFactory, entityRelation);
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
    public Tuple7<String, String, List<Object>, Limit, Optional<QueryPageResults>, String,
        Function<Object, Object>> expressionPagination(Limit limit) {
        return EntitySqlQueryExpression.expressionPageAndParams(hammerConfig, this, super.expression(), parent,
            entityRelation, getRootSortBuilder(), dialect, limit);
    }
}
