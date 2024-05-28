
package cn.featherfly.hammer.sqldb.dsl.entity.query;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup3;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic3;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * EntitySqlQueryExpression .
 *
 * @author zhongj
 * @param <T1> the element type
 * @param <T2> the generic type
 * @param <T3> the generic type
 * @param <RS> the query result type
 */
public class EntitySqlQueryExpression3<T1, T2, T3, RS> extends
    AbstractMulitiEntitySqlQueryConditionsGroupExpression3<T1, T2, T3, RS, EntityQueryConditionGroup3<T1, T2, T3, RS>,
        EntityQueryConditionGroupLogic3<T1, T2, T3, RS>>
    implements EntityQueryConditionGroup3<T1, T2, T3, RS>, EntityQueryConditionGroupLogic3<T1, T2, T3, RS> {

    /**
     * Instantiates a new entity sql query expression.
     *
     * @param hammerConfig the hammer config
     * @param factory the factory
     * @param sqlPageFactory the sql page factory
     * @param queryRelation the query relation
     */
    public EntitySqlQueryExpression3(HammerConfig hammerConfig, JdbcMappingFactory factory,
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
    EntitySqlQueryExpression3(EntityQueryConditionGroupLogic3<T1, T2, T3, RS> parent, HammerConfig hammerConfig,
        JdbcMappingFactory factory, SqlPageFactory sqlPageFactory, EntitySqlQueryRelation queryRelation) {
        super(parent, hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected EntityQueryConditionGroup3<T1, T2, T3, RS> createGroup(
        EntityQueryConditionGroupLogic3<T1, T2, T3, RS> parent) {
        return new EntitySqlQueryExpression3<>(parent, hammerConfig, factory, sqlPageFactory, entityRelation);
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
    public Tuple2<String, String> expressionPage() {
        return EntitySqlQueryExpression.expressionPage(super.expression(), parent, entityRelation, getRootSortBuilder(),
            dialect);
    }
}
