
package cn.featherfly.hammer.sqldb.dsl.entity.query;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup2;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic2;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * The Class EntitySqlQueryExpression2.
 *
 * @author zhongj
 * @param <T1> the element type
 * @param <T2> the generic type
 * @param <RS> the query result type
 */
public class EntitySqlQueryExpression2<T1, T2, RS> extends
    AbstractMulitiEntitySqlQueryConditionsGroupExpression2<T1, T2, RS, EntityQueryConditionGroup2<T1, T2, RS>,
        EntityQueryConditionGroupLogic2<T1, T2, RS>>
    implements EntityQueryConditionGroup2<T1, T2, RS>, EntityQueryConditionGroupLogic2<T1, T2, RS> {

    /**
     * Instantiates a new entity sql query expression.
     *
     * @param hammerConfig the hammer config
     * @param factory the factory
     * @param sqlPageFactory the sql page factory
     * @param queryRelation the query relation
     */
    public EntitySqlQueryExpression2(HammerConfig hammerConfig, JdbcMappingFactory factory,
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
    EntitySqlQueryExpression2(EntityQueryConditionGroupLogic2<T1, T2, RS> parent, HammerConfig hammerConfig,
        JdbcMappingFactory factory, SqlPageFactory sqlPageFactory, EntitySqlQueryRelation queryRelation) {
        super(parent, hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected EntityQueryConditionGroup2<T1, T2, RS> createGroup(EntityQueryConditionGroupLogic2<T1, T2, RS> parent) {
        return new EntitySqlQueryExpression2<>(parent, hammerConfig, factory, sqlPageFactory, entityRelation);
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
