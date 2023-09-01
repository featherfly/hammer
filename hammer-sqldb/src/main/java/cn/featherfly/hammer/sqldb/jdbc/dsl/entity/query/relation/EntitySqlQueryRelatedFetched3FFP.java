
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

import com.speedment.common.tuple.Tuple3;
import com.speedment.common.tuple.Tuple4;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.serializable.SerializableFunction1;
import cn.featherfly.common.function.serializable.SerializableFunction2;
import cn.featherfly.common.function.serializable.SerializableUnaryOperator1;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelatedFetched3FFP;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression5;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression5;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression5;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelateExpression4FFRP;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelateExpression4FFRR;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedExpression;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedFetchedExpression4FFRF;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedFetchedExpression4FFRP;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.AbstractEntitySqlQueryFetch4;

/**
 * The Class EntitySqlQueryRelatedFetched3FFP.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 * @param <R3> the generic type
 */
public class EntitySqlQueryRelatedFetched3FFP<E, R1, R2, R3>
        extends AbstractEntitySqlQueryFetch4<E, R1, R2, R3, Tuple3<E, R1, R2>>
        implements EntityQueryRelatedFetched3FFP<E, R1, R2, R3> {

    private EntitySqlQueryRelate3FFP<E, R1, R2, R3> proxy;

    /**
     * Instantiates a new entity sql query related fetched 3 FFP.
     *
     * @param entitySqlQueryRelate   the entity sql query relate
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    public EntitySqlQueryRelatedFetched3FFP(EntitySqlQueryRelate3FFP<E, R1, R2, R3> entitySqlQueryRelate,
            JdbcMappingFactory factory, SqlPageFactory sqlPageFactory, EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
        proxy = entitySqlQueryRelate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <QR extends EntityQueryRelateExpression4FFRR<E, R1, R2, R3, R4, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R2>>,
            QRF extends EntityQueryRelatedFetchedExpression4FFRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple4<E, R1, R2, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS,
                    Tuple4<E, R1, R2, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple4<E, R1, R2, R4>>,
            R4> EntityQueryRelatedExpression<E, R4, QR, QRF> join(Class<R4> joinType) {
        return proxy.join(joinType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression4FFRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression4FFRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple4<E, R1, R2, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS,
                    Tuple4<E, R1, R2, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple4<E, R1, R2, R4>>,
            R4> RE join(SerializableFunction2<R4, E> propertyName) {
        return proxy.join(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression4FFRP<E, R1, R2, R3, R4, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression4FFRP<E, R1, R2, R3, R4, RC, RL, RS>,
            R4> RE join(SerializableFunction1<E, R4> propertyName) {
        return proxy.join(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression4FFRP<E, R1, R2, R3, E, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, E, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, E, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, E, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression4FFRP<E, R1, R2, R3, E, RC, RL, RS>> RE join(
                    SerializableUnaryOperator1<E> propertyName) {
        return proxy.join(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <QR extends EntityQueryRelateExpression4FFRR<E, R1, R2, R3, R4, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R2>>,
            QRF extends EntityQueryRelatedFetchedExpression4FFRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple4<E, R1, R2, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS,
                    Tuple4<E, R1, R2, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple4<E, R1, R2, R4>>,
            R4> EntityQueryRelatedExpression<R1, R4, QR, QRF> join2(Class<R4> joinType) {
        return proxy.join2(joinType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression4FFRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression4FFRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple4<E, R1, R2, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS,
                    Tuple4<E, R1, R2, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple4<E, R1, R2, R4>>,
            R4> RE join2(SerializableFunction2<R4, R1> propertyName) {
        return proxy.join2(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression4FFRP<E, R1, R2, R3, R4, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression4FFRP<E, R1, R2, R3, R4, RC, RL, RS>,
            R4> RE join2(SerializableFunction1<R1, R4> propertyName) {
        return proxy.join2(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression4FFRP<E, R1, R2, R3, R1, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R1, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R1, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R1, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression4FFRP<E, R1, R2, R3, R1, RC, RL, RS>> RE join2(
                    SerializableUnaryOperator1<R1> propertyName) {
        return proxy.join2(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <QR extends EntityQueryRelateExpression4FFRR<E, R1, R2, R3, R4, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R2>>,
            QRF extends EntityQueryRelatedFetchedExpression4FFRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple4<E, R1, R2, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS,
                    Tuple4<E, R1, R2, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple4<E, R1, R2, R4>>,
            R4> EntityQueryRelatedExpression<R2, R4, QR, QRF> join3(Class<R4> joinType) {
        return proxy.join3(joinType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression4FFRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression4FFRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple4<E, R1, R2, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS,
                    Tuple4<E, R1, R2, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple4<E, R1, R2, R4>>,
            R4> RE join3(SerializableFunction2<R4, R2> propertyName) {
        return proxy.join3(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression4FFRP<E, R1, R2, R3, R4, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression4FFRP<E, R1, R2, R3, R4, RC, RL, RS>,
            R4> RE join3(SerializableFunction1<R2, R4> propertyName) {
        return proxy.join3(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression4FFRP<E, R1, R2, R3, R2, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R2, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R2, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R2, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression4FFRP<E, R1, R2, R3, R2, RC, RL, RS>> RE join3(
                    SerializableUnaryOperator1<R2> propertyName) {
        return proxy.join3(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <QR extends EntityQueryRelateExpression4FFRR<E, R1, R2, R3, R4, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R2>>,
            QRF extends EntityQueryRelatedFetchedExpression4FFRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple4<E, R1, R2, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS,
                    Tuple4<E, R1, R2, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple4<E, R1, R2, R4>>,
            R4> EntityQueryRelatedExpression<R3, R4, QR, QRF> join4(Class<R4> joinType) {
        return proxy.join4(joinType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression4FFRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression4FFRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple4<E, R1, R2, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS,
                    Tuple4<E, R1, R2, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple4<E, R1, R2, R4>>,
            R4> RE join4(SerializableFunction2<R4, R3> propertyName) {
        return proxy.join4(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression4FFRP<E, R1, R2, R3, R4, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression4FFRP<E, R1, R2, R3, R4, RC, RL, RS>,
            R4> RE join4(SerializableFunction1<R3, R4> propertyName) {
        return proxy.join4(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression4FFRP<E, R1, R2, R3, R3, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R3, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression4FFRP<E, R1, R2, R3, R3, RC, RL, RS>> RE join4(
                    SerializableUnaryOperator1<R3> propertyName) {
        return proxy.join4(propertyName);
    }
}
