
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntitySqlQueryRelate3FF.java
 * @Package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query
 * @Description: EntitySqlQueryRelate3FF
 * @author: zhongj
 * @date: 2023-07-14 16:01:14
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.relation;

import com.speedment.common.tuple.Tuple4;
import com.speedment.common.tuple.Tuple5;
import com.speedment.common.tuple.Tuple6;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.lang.function.SerializableFunction1;
import cn.featherfly.common.lang.function.SerializableFunction2;
import cn.featherfly.common.lang.function.SerializableFunction3;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate4FFF;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelatedFetched4FFFF;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression6;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression6;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression6;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelateExpression5FFFF;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedExpression;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedFetchedExpression5FFFFF;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.AbstractEntitySqlQueryFetch5;

/**
 * The Class EntitySqlQueryRelate4FFF.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 * @param <R3> the generic type
 * @param <R4> the generic type
 */
public class EntitySqlQueryRelate4FFF<E, R1, R2, R3, R4>
        extends AbstractEntitySqlQueryFetch5<E, R1, R2, R3, R4, Tuple4<E, R1, R2, R3>>
        implements EntityQueryRelate4FFF<E, R1, R2, R3, R4> {

    /**
     * Instantiates a new entity sql query relate 4 FFF.
     *
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    public EntitySqlQueryRelate4FFF(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelatedFetched4FFFF<E, R1, R2, R3, R4> fetch() {
        queryRelation.fetch(4);
        return new EntitySqlQueryRelatedFetched4FFFF<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <QR extends EntityQueryRelateExpression5FFFF<E, R1, R2, R3, R4, R5, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple5<E, R1, R2, R3, R4>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple5<E, R1, R2, R3, R4>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple5<E, R1, R2, R3, R4>>,
            QRF extends EntityQueryRelatedFetchedExpression5FFFFF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple6<E, R1, R2, R3, R4, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple6<E, R1, R2, R3, R4, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple6<E, R1, R2, R3, R4, R5>>,
            R5> EntityQueryRelatedExpression<E, R5, QR, QRF> join(Class<R5> joinType) {
        return new EntitySqlQueryRelated<>((QR) new EntitySqlQueryRelate5FFFF<>(factory, sqlPageFactory, queryRelation),
                factory, queryRelation, joinType, 0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression5FFFF<E, R1, R2, R3, R4, R5, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple5<E, R1, R2, R3, R4>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple5<E, R1, R2, R3, R4>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple5<E, R1, R2, R3, R4>>,
            QR extends EntityQueryRelatedFetchedExpression5FFFFF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple6<E, R1, R2, R3, R4, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple6<E, R1, R2, R3, R4, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple6<E, R1, R2, R3, R4, R5>>,
            R5> RE join(SerializableFunction1<E, R5> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression5FFFF<E, R1, R2, R3, R4, R5, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple5<E, R1, R2, R3, R4>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple5<E, R1, R2, R3, R4>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple5<E, R1, R2, R3, R4>>,
            QR extends EntityQueryRelatedFetchedExpression5FFFFF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple6<E, R1, R2, R3, R4, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple6<E, R1, R2, R3, R4, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple6<E, R1, R2, R3, R4, R5>>,
            R5> RE join(SerializableFunction2<R5, Tuple5<E, R1, R2, R3, R4>> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression5FFFF<E, R1, R2, R3, R4, E, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, E, RC, RL, RS,
                    Tuple5<E, R1, R2, R3, R4>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, E, RC, RL, RS,
                    Tuple5<E, R1, R2, R3, R4>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, E, Tuple5<E, R1, R2, R3, R4>>,
            QR extends EntityQueryRelatedFetchedExpression5FFFFF<E, R1, R2, R3, R4, E, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, E, QRC, QRL, QRS,
                    Tuple6<E, R1, R2, R3, R4, E>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, E, QRC, QRL, QRS,
                    Tuple6<E, R1, R2, R3, R4, E>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, E, Tuple6<E, R1, R2, R3, R4, E>>> RE join(
                    SerializableFunction3<E, E> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }
    // ****************************************************************************************************************
    //	2
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <QR extends EntityQueryRelateExpression5FFFF<E, R1, R2, R3, R4, R5, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple5<E, R1, R2, R3, R4>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple5<E, R1, R2, R3, R4>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple5<E, R1, R2, R3, R4>>,
            QRF extends EntityQueryRelatedFetchedExpression5FFFFF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple6<E, R1, R2, R3, R4, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple6<E, R1, R2, R3, R4, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple6<E, R1, R2, R3, R4, R5>>,
            R5> EntityQueryRelatedExpression<R1, R5, QR, QRF> join2(Class<R5> joinType) {
        return new EntitySqlQueryRelated<>((QR) new EntitySqlQueryRelate5FFFF<>(factory, sqlPageFactory, queryRelation),
                factory, queryRelation, joinType, 1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression5FFFF<E, R1, R2, R3, R4, R5, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple5<E, R1, R2, R3, R4>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple5<E, R1, R2, R3, R4>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple5<E, R1, R2, R3, R4>>,
            QR extends EntityQueryRelatedFetchedExpression5FFFFF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple6<E, R1, R2, R3, R4, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple6<E, R1, R2, R3, R4, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple6<E, R1, R2, R3, R4, R5>>,
            R5> RE join2(SerializableFunction1<R1, R5> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression5FFFF<E, R1, R2, R3, R4, R5, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple5<E, R1, R2, R3, R4>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple5<E, R1, R2, R3, R4>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple5<E, R1, R2, R3, R4>>,
            QR extends EntityQueryRelatedFetchedExpression5FFFFF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple6<E, R1, R2, R3, R4, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple6<E, R1, R2, R3, R4, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple6<E, R1, R2, R3, R4, R5>>,
            R5> RE join2(SerializableFunction2<R5, R1> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression5FFFF<E, R1, R2, R3, R4, R1, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R1, RC, RL, RS,
                    Tuple5<E, R1, R2, R3, R4>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R1, RC, RL, RS,
                    Tuple5<E, R1, R2, R3, R4>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R1, Tuple5<E, R1, R2, R3, R4>>,
            QR extends EntityQueryRelatedFetchedExpression5FFFFF<E, R1, R2, R3, R4, R1, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R1, QRC, QRL, QRS,
                    Tuple6<E, R1, R2, R3, R4, R1>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R1, QRC, QRL, QRS,
                    Tuple6<E, R1, R2, R3, R4, R1>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R1, Tuple6<E, R1, R2, R3, R4, R1>>> RE join2(
                    SerializableFunction3<R1, R1> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    // ****************************************************************************************************************
    //	3
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <QR extends EntityQueryRelateExpression5FFFF<E, R1, R2, R3, R4, R5, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple5<E, R1, R2, R3, R4>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple5<E, R1, R2, R3, R4>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple5<E, R1, R2, R3, R4>>,
            QRF extends EntityQueryRelatedFetchedExpression5FFFFF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple6<E, R1, R2, R3, R4, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple6<E, R1, R2, R3, R4, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple6<E, R1, R2, R3, R4, R5>>,
            R5> EntityQueryRelatedExpression<R2, R5, QR, QRF> join3(Class<R5> joinType) {
        return new EntitySqlQueryRelated<>((QR) new EntitySqlQueryRelate5FFFF<>(factory, sqlPageFactory, queryRelation),
                factory, queryRelation, joinType, 2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression5FFFF<E, R1, R2, R3, R4, R5, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple5<E, R1, R2, R3, R4>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple5<E, R1, R2, R3, R4>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple5<E, R1, R2, R3, R4>>,
            QR extends EntityQueryRelatedFetchedExpression5FFFFF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple6<E, R1, R2, R3, R4, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple6<E, R1, R2, R3, R4, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple6<E, R1, R2, R3, R4, R5>>,
            R5> RE join3(SerializableFunction1<R2, R5> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression5FFFF<E, R1, R2, R3, R4, R5, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple5<E, R1, R2, R3, R4>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple5<E, R1, R2, R3, R4>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple5<E, R1, R2, R3, R4>>,
            QR extends EntityQueryRelatedFetchedExpression5FFFFF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple6<E, R1, R2, R3, R4, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple6<E, R1, R2, R3, R4, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple6<E, R1, R2, R3, R4, R5>>,
            R5> RE join3(SerializableFunction2<R5, R2> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression5FFFF<E, R1, R2, R3, R4, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R2, RC, RL, RS,
                    Tuple5<E, R1, R2, R3, R4>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R2, RC, RL, RS,
                    Tuple5<E, R1, R2, R3, R4>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R2, Tuple5<E, R1, R2, R3, R4>>,
            QR extends EntityQueryRelatedFetchedExpression5FFFFF<E, R1, R2, R3, R4, R2, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R2, QRC, QRL, QRS,
                    Tuple6<E, R1, R2, R3, R4, R2>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R2, QRC, QRL, QRS,
                    Tuple6<E, R1, R2, R3, R4, R2>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R2, Tuple6<E, R1, R2, R3, R4, R2>>> RE join3(
                    SerializableFunction3<R2, R2> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    // ****************************************************************************************************************
    //	4
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <QR extends EntityQueryRelateExpression5FFFF<E, R1, R2, R3, R4, R5, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple5<E, R1, R2, R3, R4>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple5<E, R1, R2, R3, R4>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple5<E, R1, R2, R3, R4>>,
            QRF extends EntityQueryRelatedFetchedExpression5FFFFF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple6<E, R1, R2, R3, R4, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple6<E, R1, R2, R3, R4, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple6<E, R1, R2, R3, R4, R5>>,
            R5> EntityQueryRelatedExpression<R3, R5, QR, QRF> join4(Class<R5> joinType) {
        return new EntitySqlQueryRelated<>((QR) new EntitySqlQueryRelate5FFFF<>(factory, sqlPageFactory, queryRelation),
                factory, queryRelation, joinType, 3);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression5FFFF<E, R1, R2, R3, R4, R5, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple5<E, R1, R2, R3, R4>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple5<E, R1, R2, R3, R4>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple5<E, R1, R2, R3, R4>>,
            QR extends EntityQueryRelatedFetchedExpression5FFFFF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple6<E, R1, R2, R3, R4, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple6<E, R1, R2, R3, R4, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple6<E, R1, R2, R3, R4, R5>>,
            R5> RE join4(SerializableFunction1<R3, R5> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression5FFFF<E, R1, R2, R3, R4, R5, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple5<E, R1, R2, R3, R4>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple5<E, R1, R2, R3, R4>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple5<E, R1, R2, R3, R4>>,
            QR extends EntityQueryRelatedFetchedExpression5FFFFF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple6<E, R1, R2, R3, R4, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple6<E, R1, R2, R3, R4, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple6<E, R1, R2, R3, R4, R5>>,
            R5> RE join4(SerializableFunction2<R5, R3> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression5FFFF<E, R1, R2, R3, R4, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R3, RC, RL, RS,
                    Tuple5<E, R1, R2, R3, R4>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R3, RC, RL, RS,
                    Tuple5<E, R1, R2, R3, R4>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R3, Tuple5<E, R1, R2, R3, R4>>,
            QR extends EntityQueryRelatedFetchedExpression5FFFFF<E, R1, R2, R3, R4, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R3, QRC, QRL, QRS,
                    Tuple6<E, R1, R2, R3, R4, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R3, QRC, QRL, QRS,
                    Tuple6<E, R1, R2, R3, R4, R3>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R3, Tuple6<E, R1, R2, R3, R4, R3>>> RE join4(
                    SerializableFunction3<R3, R3> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    // ****************************************************************************************************************
    //	5
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <QR extends EntityQueryRelateExpression5FFFF<E, R1, R2, R3, R4, R5, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple5<E, R1, R2, R3, R4>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple5<E, R1, R2, R3, R4>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple5<E, R1, R2, R3, R4>>,
            QRF extends EntityQueryRelatedFetchedExpression5FFFFF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple6<E, R1, R2, R3, R4, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple6<E, R1, R2, R3, R4, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple6<E, R1, R2, R3, R4, R5>>,
            R5> EntityQueryRelatedExpression<R4, R5, QR, QRF> join5(Class<R5> joinType) {
        return new EntitySqlQueryRelated<>((QR) new EntitySqlQueryRelate5FFFF<>(factory, sqlPageFactory, queryRelation),
                factory, queryRelation, joinType, 4);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression5FFFF<E, R1, R2, R3, R4, R5, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple5<E, R1, R2, R3, R4>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple5<E, R1, R2, R3, R4>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple5<E, R1, R2, R3, R4>>,
            QR extends EntityQueryRelatedFetchedExpression5FFFFF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple6<E, R1, R2, R3, R4, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple6<E, R1, R2, R3, R4, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple6<E, R1, R2, R3, R4, R5>>,
            R5> RE join5(SerializableFunction1<R4, R5> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression5FFFF<E, R1, R2, R3, R4, R5, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple5<E, R1, R2, R3, R4>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple5<E, R1, R2, R3, R4>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple5<E, R1, R2, R3, R4>>,
            QR extends EntityQueryRelatedFetchedExpression5FFFFF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple6<E, R1, R2, R3, R4, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple6<E, R1, R2, R3, R4, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple6<E, R1, R2, R3, R4, R5>>,
            R5> RE join5(SerializableFunction2<R5, R4> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression5FFFF<E, R1, R2, R3, R4, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R4, RC, RL, RS,
                    Tuple5<E, R1, R2, R3, R4>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R4, RC, RL, RS,
                    Tuple5<E, R1, R2, R3, R4>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R4, Tuple5<E, R1, R2, R3, R4>>,
            QR extends EntityQueryRelatedFetchedExpression5FFFFF<E, R1, R2, R3, R4, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R4, QRC, QRL, QRS,
                    Tuple6<E, R1, R2, R3, R4, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R4, QRC, QRL, QRS,
                    Tuple6<E, R1, R2, R3, R4, R4>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R4, Tuple6<E, R1, R2, R3, R4, R4>>> RE join5(
                    SerializableFunction3<R4, R4> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

}
