
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntitySqlQueryRelatedFetchedExpression2FF.java
 * @Package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query
 * @Description: EntitySqlQueryRelatedFetchedExpression2FF
 * @author: zhongj
 * @date: 2023-07-14 16:04:14
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.relation;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuple3;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.serializable.SerializableFunction1;
import cn.featherfly.common.function.serializable.SerializableFunction2;
import cn.featherfly.common.function.serializable.SerializableUnaryOperator1;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelatedFetched2FP;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression4;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelateExpression3FRP;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelateExpression3FRR;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedExpression;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedFetchedExpression3FRF;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedFetchedExpression3FRP;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.AbstractEntitySqlQueryFetch3;

/**
 * The Class EntitySqlQueryRelatedFetched2RF.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 */
public class EntitySqlQueryRelatedFetched2FP<E, R1, R2> extends AbstractEntitySqlQueryFetch3<E, R1, R2, Tuple2<E, R1>>
        implements EntityQueryRelatedFetched2FP<E, R1, R2> {

    private EntitySqlQueryRelate2FP<E, R1, R2> proxy;

    /**
     * Instantiates a new entity sql query related fetched 2 RF.
     *
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    public EntitySqlQueryRelatedFetched2FP(EntitySqlQueryRelate2FP<E, R1, R2> entitySqlQueryRelate,
            JdbcMappingFactory factory, SqlPageFactory sqlPageFactory, EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
        proxy = entitySqlQueryRelate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <QR extends EntityQueryRelateExpression3FRR<E, R1, R2, R3, RC, RL, RS, QRF, FC, FL, FS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R1>>,
            QRF extends EntityQueryRelatedFetchedExpression3FRF<E, R1, R2, R3, FC, FL, FS>,
            FC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, FC, FL, FS, Tuple3<E, R1, R3>>,
            FL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, FC, FL, FS, Tuple3<E, R1, R3>>,
            FS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R1, R3>>,
            R3> EntityQueryRelatedExpression<E, R3, QR, QRF> join(Class<R3> joinType) {
        return proxy.join(joinType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression3FRR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression3FRF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R1, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R1, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R1, R3>>,
            R3> RE join(SerializableFunction2<R3, E> propertyName) {
        return proxy.join(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression3FRP<E, R1, R2, R3, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression3FRP<E, R1, R2, R3, RC, RL, RS>,
            R3> RE join(SerializableFunction1<E, R3> propertyName) {
        return proxy.join(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression3FRP<E, R1, R2, E, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, E, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, E, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, E, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression3FRP<E, R1, R2, E, RC, RL, RS>> RE join(
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
    public <QR extends EntityQueryRelateExpression3FRR<E, R1, R2, R3, RC, RL, RS, QRF, FC, FL, FS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R1>>,
            QRF extends EntityQueryRelatedFetchedExpression3FRF<E, R1, R2, R3, FC, FL, FS>,
            FC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, FC, FL, FS, Tuple3<E, R1, R3>>,
            FL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, FC, FL, FS, Tuple3<E, R1, R3>>,
            FS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R1, R3>>,
            R3> EntityQueryRelatedExpression<R1, R3, QR, QRF> join2(Class<R3> joinType) {
        return proxy.join2(joinType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression3FRR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression3FRF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R1, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R1, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R1, R3>>,
            R3> RE join2(SerializableFunction2<R3, R1> propertyName) {
        return proxy.join2(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression3FRP<E, R1, R2, R3, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression3FRP<E, R1, R2, R3, RC, RL, RS>,
            R3> RE join2(SerializableFunction1<R1, R3> propertyName) {
        return proxy.join2(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression3FRP<E, R1, R2, R1, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R1, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R1, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R1, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression3FRP<E, R1, R2, R1, RC, RL, RS>> RE join2(
                    SerializableUnaryOperator1<R1> propertyName) {
        return proxy.join2(propertyName);
    }

    // ****************************************************************************************************************
    //	join 3
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <QR extends EntityQueryRelateExpression3FRR<E, R1, R2, R3, RC, RL, RS, QRF, FC, FL, FS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R1>>,
            QRF extends EntityQueryRelatedFetchedExpression3FRF<E, R1, R2, R3, FC, FL, FS>,
            FC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, FC, FL, FS, Tuple3<E, R1, R3>>,
            FL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, FC, FL, FS, Tuple3<E, R1, R3>>,
            FS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R1, R3>>,
            R3> EntityQueryRelatedExpression<R2, R3, QR, QRF> join3(Class<R3> joinType) {
        return proxy.join3(joinType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression3FRR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression3FRF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R1, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R1, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R1, R3>>,
            R3> RE join3(SerializableFunction2<R3, R2> propertyName) {
        return proxy.join3(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression3FRP<E, R1, R2, R3, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression3FRP<E, R1, R2, R3, RC, RL, RS>,
            R3> RE join3(SerializableFunction1<R2, R3> propertyName) {
        return proxy.join3(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression3FRP<E, R1, R2, R2, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R2, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R2, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R2, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression3FRP<E, R1, R2, R2, RC, RL, RS>> RE join3(
                    SerializableUnaryOperator1<R2> propertyName) {
        return proxy.join3(propertyName);
    }
}
