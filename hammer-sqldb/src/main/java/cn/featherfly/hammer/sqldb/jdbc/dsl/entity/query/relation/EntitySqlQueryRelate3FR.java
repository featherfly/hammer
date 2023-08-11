
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

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuple3;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.lang.function.SerializableFunction1;
import cn.featherfly.common.lang.function.SerializableFunction2;
import cn.featherfly.common.lang.function.SerializableFunction3;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate3FR;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelatedFetched3FRF;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression5;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression5;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression5;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelateExpression4FRR;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedExpression;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedFetchedExpression4FRRF;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.AbstractEntitySqlQueryFetch4;

/**
 * The Class EntitySqlQueryRelate3FR.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 * @param <R3> the generic type
 */
public class EntitySqlQueryRelate3FR<E, R1, R2, R3> extends AbstractEntitySqlQueryFetch4<E, R1, R2, R3, Tuple2<E, R1>>
        implements EntityQueryRelate3FR<E, R1, R2, R3> {

    /**
     * Instantiates a new entity sql query relate 3 FR.
     *
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    public EntitySqlQueryRelate3FR(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelatedFetched3FRF<E, R1, R2, R3> fetch() {
        queryRelation.fetch(3);
        return new EntitySqlQueryRelatedFetched3FRF<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <QR extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
            QRF extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>,
            R4> EntityQueryRelatedExpression<E, R4, QR, QRF> join(Class<R4> joinType) {
        return new EntitySqlQueryRelated<>((QR) new EntitySqlQueryRelate4FRR<>(factory, sqlPageFactory, queryRelation),
                factory, queryRelation, joinType, 0);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
    //            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
    //            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
    //            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
    //            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>, R4,
    //            J> RE join(SerializableFunction1<E, J> propertyName, Class<R4> joinType) {
    //        queryRelation.join(0, getPropertyName(propertyName), factory.getClassMapping(joinType));
    //        return (RE) new EntitySqlQueryRelate4FRR<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
    //            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
    //            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
    //            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
    //            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>, R4,
    //            J> RE join(SerializableFunction1<E, J> propertyName, SerializableFunction1<R4, J> joinTypePropertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
    //        queryRelation.join(0, getPropertyName(propertyName),
    //                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
    //        return (RE) new EntitySqlQueryRelate4FRR<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
    //            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
    //            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
    //            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
    //            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>, R4,
    //            J> RE join(SerializableFunction4<R4, J> joinTypePropertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
    //        queryRelation.join(0, factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())),
    //                info.getPropertyName());
    //        return (RE) new EntitySqlQueryRelate4FRR<>(factory, sqlPageFactory, queryRelation);
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>,
            R4> RE join(SerializableFunction1<E, R4> propertyName) {
        // IMPLSOON 后续来实现实体关系（ManyToOne、OneToOne、OneToMany）关联
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>,
            R4> RE join(SerializableFunction2<R4, E> propertyName) {
        // IMPLSOON 后续来实现实体关系（ManyToOne、OneToOne、OneToMany）关联
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, E, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, E, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, E, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, E, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, E, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, E, QRC, QRL, QRS, Tuple3<E, R1, E>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, E, QRC, QRL, QRS, Tuple3<E, R1, E>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, E, Tuple3<E, R1, E>>> RE join(
                    SerializableFunction3<E, E> propertyName) {
        // IMPLSOON 后续来实现实体关系（ManyToOne、OneToOne、OneToMany）关联
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
    public <QR extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
            QRF extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>,
            R4> EntityQueryRelatedExpression<R1, R4, QR, QRF> join2(Class<R4> joinType) {
        return new EntitySqlQueryRelated<>((QR) new EntitySqlQueryRelate4FRR<>(factory, sqlPageFactory, queryRelation),
                factory, queryRelation, joinType, 1);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
    //            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
    //            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
    //            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
    //            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>, R4,
    //            J> RE join2(SerializableFunction1<R1, J> propertyName, Class<R4> joinType) {
    //        queryRelation.join(1, getPropertyName(propertyName), factory.getClassMapping(joinType));
    //        return (RE) new EntitySqlQueryRelate4FRR<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
    //            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
    //            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
    //            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
    //            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>, R4,
    //            J> RE join2(SerializableFunction1<R1, J> propertyName, SerializableFunction1<R4, J> joinTypePropertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
    //        queryRelation.join(1, getPropertyName(propertyName),
    //                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
    //        return (RE) new EntitySqlQueryRelate4FRR<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //  /**
    //  * {@inheritDoc}
    //  */
    // @SuppressWarnings("unchecked")
    // @Override
    // public <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
    //         RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
    //         RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
    //         RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
    //         QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
    //         QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
    //         QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
    //         QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>, R4,
    //         J> RE join2(SerializableFunction4<R4, J> joinTypePropertyName) {
    //     SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
    //     queryRelation.join(1, factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())),
    //             info.getPropertyName());
    //     return (RE) new EntitySqlQueryRelate4FRR<>(factory, sqlPageFactory, queryRelation);
    // }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>,
            R4> RE join2(SerializableFunction1<R1, R4> propertyName) {
        // IMPLSOON 后续来实现实体关系（ManyToOne、OneToOne、OneToMany）关联
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>,
            R4> RE join2(SerializableFunction2<R4, R1> propertyName) {
        // IMPLSOON 后续来实现实体关系（ManyToOne、OneToOne、OneToMany）关联
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R1, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R1, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R1, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R1, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R1, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R1, QRC, QRL, QRS, Tuple3<E, R1, R1>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R1, QRC, QRL, QRS, Tuple3<E, R1, R1>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R1, Tuple3<E, R1, R1>>> RE join2(
                    SerializableFunction3<R1, R1> propertyName) {
        // IMPLSOON 后续来实现实体关系（ManyToOne、OneToOne、OneToMany）关联
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
    public <QR extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
            QRF extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>,
            R4> EntityQueryRelatedExpression<R2, R4, QR, QRF> join3(Class<R4> joinType) {
        return new EntitySqlQueryRelated<>((QR) new EntitySqlQueryRelate4FRR<>(factory, sqlPageFactory, queryRelation),
                factory, queryRelation, joinType, 2);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
    //            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
    //            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
    //            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
    //            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>, R4,
    //            J> RE join3(SerializableFunction1<R2, J> propertyName, Class<R4> joinType) {
    //        queryRelation.join(2, getPropertyName(propertyName), factory.getClassMapping(joinType));
    //        return (RE) new EntitySqlQueryRelate4FRR<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
    //            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
    //            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
    //            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
    //            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>, R4,
    //            J> RE join3(SerializableFunction1<R2, J> propertyName, SerializableFunction1<R4, J> joinTypePropertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
    //        queryRelation.join(2, getPropertyName(propertyName),
    //                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
    //        return (RE) new EntitySqlQueryRelate4FRR<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
    //            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
    //            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
    //            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
    //            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>, R4,
    //            J> RE join3(SerializableFunction4<R4, J> joinTypePropertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
    //        queryRelation.join(2, factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())),
    //                info.getPropertyName());
    //        return (RE) new EntitySqlQueryRelate4FRR<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
    //            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
    //            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
    //            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
    //            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>, R4,
    //            J> RE join4(SerializableFunction4<R4, J> joinTypePropertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
    //        queryRelation.join(3, factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())),
    //                info.getPropertyName());
    //        return (RE) new EntitySqlQueryRelate4FRR<>(factory, sqlPageFactory, queryRelation);
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>,
            R4> RE join3(SerializableFunction1<R2, R4> propertyName) {
        // IMPLSOON 后续来实现实体关系（ManyToOne、OneToOne、OneToMany）关联
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>,
            R4> RE join3(SerializableFunction2<R4, R2> propertyName) {
        // IMPLSOON 后续来实现实体关系（ManyToOne、OneToOne、OneToMany）关联
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R2, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R2, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R2, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R2, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R2, QRC, QRL, QRS, Tuple3<E, R1, R2>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R2, QRC, QRL, QRS, Tuple3<E, R1, R2>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R2, Tuple3<E, R1, R2>>> RE join3(
                    SerializableFunction3<R2, R2> propertyName) {
        // IMPLSOON 后续来实现实体关系（ManyToOne、OneToOne、OneToMany）关联
        return null;
    }

    // ****************************************************************************************************************
    //  4
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <QR extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
            QRF extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>,
            R4> EntityQueryRelatedExpression<R3, R4, QR, QRF> join4(Class<R4> joinType) {
        return new EntitySqlQueryRelated<>((QR) new EntitySqlQueryRelate4FRR<>(factory, sqlPageFactory, queryRelation),
                factory, queryRelation, joinType, 3);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
    //            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
    //            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
    //            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
    //            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>, R4,
    //            J> RE join4(SerializableFunction1<R3, J> propertyName, Class<R4> joinType) {
    //        queryRelation.join(3, getPropertyName(propertyName), factory.getClassMapping(joinType));
    //        return (RE) new EntitySqlQueryRelate4FRR<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
    //            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
    //            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
    //            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
    //            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>, R4,
    //            J> RE join4(SerializableFunction1<R3, J> propertyName, SerializableFunction1<R4, J> joinTypePropertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
    //        queryRelation.join(3, getPropertyName(propertyName),
    //                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
    //        return (RE) new EntitySqlQueryRelate4FRR<>(factory, sqlPageFactory, queryRelation);
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>,
            R4> RE join4(SerializableFunction1<R3, R4> propertyName) {
        // IMPLSOON 后续来实现实体关系（ManyToOne、OneToOne、OneToMany）关联
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>,
            R4> RE join4(SerializableFunction2<R4, R3> propertyName) {
        // IMPLSOON 后续来实现实体关系（ManyToOne、OneToOne、OneToMany）关联
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R3, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R3, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R3, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R3, QRC, QRL, QRS, Tuple3<E, R1, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R3, QRC, QRL, QRS, Tuple3<E, R1, R3>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R3, Tuple3<E, R1, R3>>> RE join4(
                    SerializableFunction3<R3, R3> propertyName) {
        // IMPLSOON 后续来实现实体关系（ManyToOne、OneToOne、OneToMany）关联
        return null;
    }

}
