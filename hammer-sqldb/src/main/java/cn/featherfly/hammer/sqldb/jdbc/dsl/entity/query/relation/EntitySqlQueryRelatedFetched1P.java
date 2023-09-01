
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntitySqlQueryRelatedFetched.java
 * @Package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query
 * @Description: EntitySqlQueryRelatedFetched
 * @author: zhongj
 * @date: 2023-07-14 15:58:14
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.relation;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.serializable.SerializableFunction1;
import cn.featherfly.common.function.serializable.SerializableFunction2;
import cn.featherfly.common.function.serializable.SerializableUnaryOperator1;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelatedFetched1P;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression3;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelateExpression2RP;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelateExpression2RR;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedExpression;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedFetchedExpression2RF;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedFetchedExpression2RP;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.AbstractEntitySqlQueryFetch2;

/**
 * The Class EntitySqlQueryRelatedFetched1P.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 */
public class EntitySqlQueryRelatedFetched1P<E, R1> extends AbstractEntitySqlQueryFetch2<E, R1, E>
        implements EntityQueryRelatedFetched1P<E, R1> {

    private EntitySqlQueryRelate1P<E, R1> proxy;

    /**
     * Instantiates a new entity sql query related fetched 1 P.
     *
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    public EntitySqlQueryRelatedFetched1P(EntitySqlQueryRelate1P<E, R1> entitySqlQueryRelate,
            JdbcMappingFactory factory, SqlPageFactory sqlPageFactory, EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
        proxy = entitySqlQueryRelate;
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <QR extends EntityQueryRelateExpression2RR<E, R1, R2, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
            QRF extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>,
            R2> EntityQueryRelatedExpression<E, R2, QR, QRF> join(Class<R2> joinType) {
        return proxy.join(joinType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression2RP<E, R1, R2, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QR extends EntityQueryRelatedFetchedExpression2RP<E, R1, R2, RC, RL, RS>,
            R2> RE join(SerializableFunction1<E, R2> propertyName) {
        return proxy.join(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression2RR<E, R1, R2, RC, RL, RS, QR, FC, FL, FS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, FC, FL, FS>,
            FC extends EntityQueryConditionGroupExpression3<E, R1, R2, FC, FL, FS, Tuple2<E, R2>>,
            FL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, FC, FL, FS, Tuple2<E, R2>>,
            FS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
            R2> RE join(SerializableFunction2<R2, E> propertyName) {
        return proxy.join(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression2RP<E, R1, E, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, E, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, E, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, E, E>,
            QR extends EntityQueryRelatedFetchedExpression2RP<E, R1, E, RC, RL, RS>> RE join(
                    SerializableUnaryOperator1<E> propertyName) {
        return proxy.join(propertyName);
    }

    // ****************************************************************************************************************
    //	join 2
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <QR extends EntityQueryRelateExpression2RR<E, R1, R2, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
            QRF extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>,
            R2> EntityQueryRelatedExpression<R1, R2, QR, QRF> join2(Class<R2> joinType) {
        return proxy.join2(joinType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression2RP<E, R1, R2, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QR extends EntityQueryRelatedFetchedExpression2RP<E, R1, R2, RC, RL, RS>,
            R2> RE join2(SerializableFunction1<R1, R2> propertyName) {
        return proxy.join2(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression2RR<E, R1, R2, RC, RL, RS, QR, FC, FL, FS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, FC, FL, FS>,
            FC extends EntityQueryConditionGroupExpression3<E, R1, R2, FC, FL, FS, Tuple2<E, R2>>,
            FL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, FC, FL, FS, Tuple2<E, R2>>,
            FS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
            R2> RE join2(SerializableFunction2<R2, R1> propertyName) {
        return proxy.join2(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression2RP<E, R1, R1, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R1, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R1, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R1, E>,
            QR extends EntityQueryRelatedFetchedExpression2RP<E, R1, R1, RC, RL, RS>> RE join2(
                    SerializableUnaryOperator1<R1> propertyName) {
        return proxy.join2(propertyName);
    }
}
