
package cn.featherfly.hammer.sqldb.dsl.entity.query;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
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
     * @param factory the factory
     * @param sqlPageFactory the sql page factory
     * @param queryRelation the query relation
     */
    public EntitySqlQueryExpression6(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
        EntitySqlQueryRelation queryRelation) {
        this(null, factory, sqlPageFactory, queryRelation);
    }

    /**
     * Instantiates a new entity sql query expression.
     *
     * @param parent the parent
     * @param factory the factory
     * @param sqlPageFactory the sql page factory
     * @param queryRelation the query relation
     */
    EntitySqlQueryExpression6(EntityQueryConditionGroupLogic6<T1, T2, T3, T4, T5, T6, RS> parent,
        JdbcMappingFactory factory, SqlPageFactory sqlPageFactory, EntitySqlQueryRelation queryRelation) {
        super(parent, factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected EntityQueryConditionGroup6<T1, T2, T3, T4, T5, T6, RS> createGroup(
        EntityQueryConditionGroupLogic6<T1, T2, T3, T4, T5, T6, RS> parent) {
        return new EntitySqlQueryExpression6<>(parent, factory, sqlPageFactory, entityRelation);
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
