
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
import cn.featherfly.common.lang.function.SerializableFunction1;
import cn.featherfly.common.lang.function.SerializableFunction2;
import cn.featherfly.common.lang.function.SerializableFunction3;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelatedFetched2RF;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression4;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelateExpression3RF;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedExpression;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedFetchedExpression3RFF;
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
public class EntitySqlQueryRelatedFetched2RF<E, R1, R2> extends AbstractEntitySqlQueryFetch3<E, R1, R2, Tuple2<E, R2>>
        implements EntityQueryRelatedFetched2RF<E, R1, R2> {

    /**
     * Instantiates a new entity sql query related fetched 2 RF.
     *
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    protected EntitySqlQueryRelatedFetched2RF(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <QR extends EntityQueryRelateExpression3RF<E, R1, R2, R3, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R2>>,
            QRF extends EntityQueryRelatedFetchedExpression3RFF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R2, R3>>,
            R3> EntityQueryRelatedExpression<E, R3, QR, QRF> join(Class<R3> joinType) {
        return new EntitySqlQueryRelated<>((QR) new EntitySqlQueryRelate3RF<>(factory, sqlPageFactory, queryRelation),
                factory, queryRelation, joinType, 0);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression3RF<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression3RFF<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
    //            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R2, R3>>, R3,
    //            J> RE join(SerializableFunction1<E, J> propertyName, Class<R3> joinType) {
    //        queryRelation.join(0, getPropertyName(propertyName), factory.getClassMapping(joinType));
    //        return (RE) new EntitySqlQueryRelate3RF<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression3RF<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression3RFF<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
    //            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R2, R3>>, R3,
    //            J> RE join(SerializableFunction1<E, J> propertyName, SerializableFunction1<R3, J> joinTypePropertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
    //        queryRelation.join(0, getPropertyName(propertyName),
    //                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
    //        return (RE) new EntitySqlQueryRelate3RF<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression3RF<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression3RFF<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
    //            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R2, R3>>, R3,
    //            J> RE join(SerializableFunction4<R3, J> joinTypePropertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
    //        queryRelation.join(0, factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())),
    //                info.getPropertyName());
    //        return (RE) new EntitySqlQueryRelate3RF<>(factory, sqlPageFactory, queryRelation);
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression3RF<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3RFF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R2, R3>>,
            R3> RE join(SerializableFunction1<E, R3> propertyName) {
        // IMPLSOON 后续来实现实体关系（ManyToOne、OneToOne、OneToMany）关联
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression3RF<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3RFF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R2, R3>>,
            R3> RE join(SerializableFunction2<R3, E> propertyName) {
        // IMPLSOON 后续来实现实体关系（ManyToOne、OneToOne、OneToMany）关联
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression3RF<E, R1, R2, E, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, E, RC, RL, RS, Tuple2<E, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, E, RC, RL, RS, Tuple2<E, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, E, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3RFF<E, R1, R2, E, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, E, QRC, QRL, QRS, Tuple3<E, R2, E>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, E, QRC, QRL, QRS, Tuple3<E, R2, E>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, E, Tuple3<E, R2, E>>> RE join(
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
    public <QR extends EntityQueryRelateExpression3RF<E, R1, R2, R3, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R2>>,
            QRF extends EntityQueryRelatedFetchedExpression3RFF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R2, R3>>,
            R3> EntityQueryRelatedExpression<R1, R3, QR, QRF> join2(Class<R3> joinType) {
        return new EntitySqlQueryRelated<>((QR) new EntitySqlQueryRelate3RF<>(factory, sqlPageFactory, queryRelation),
                factory, queryRelation, joinType, 1);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression3RF<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression3RFF<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
    //            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R2, R3>>, R3,
    //            J> RE join2(SerializableFunction1<R1, J> propertyName, Class<R3> joinType) {
    //        queryRelation.join(1, getPropertyName(propertyName), factory.getClassMapping(joinType));
    //        return (RE) new EntitySqlQueryRelate3RF<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression3RF<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression3RFF<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
    //            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R2, R3>>, R3,
    //            J> RE join2(SerializableFunction1<R1, J> propertyName, SerializableFunction1<R3, J> joinTypePropertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
    //        queryRelation.join(1, getPropertyName(propertyName),
    //                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
    //        return (RE) new EntitySqlQueryRelate3RF<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression3RF<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression3RFF<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
    //            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R2, R3>>, R3,
    //            J> RE join2(SerializableFunction4<R3, J> joinTypePropertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
    //        queryRelation.join(1, factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())),
    //                info.getPropertyName());
    //        return (RE) new EntitySqlQueryRelate3RF<>(factory, sqlPageFactory, queryRelation);
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression3RF<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3RFF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R2, R3>>,
            R3> RE join2(SerializableFunction1<R1, R3> propertyName) {
        // IMPLSOON 后续来实现实体关系（ManyToOne、OneToOne、OneToMany）关联
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression3RF<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3RFF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R2, R3>>,
            R3> RE join2(SerializableFunction2<R3, R1> propertyName) {
        // IMPLSOON 后续来实现实体关系（ManyToOne、OneToOne、OneToMany）关联
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression3RF<E, R1, R2, R1, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R1, RC, RL, RS, Tuple2<E, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R1, RC, RL, RS, Tuple2<E, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R1, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3RFF<E, R1, R2, R1, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R1, QRC, QRL, QRS, Tuple3<E, R2, R1>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R1, QRC, QRL, QRS, Tuple3<E, R2, R1>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R1, Tuple3<E, R2, R1>>> RE join2(
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
    public <QR extends EntityQueryRelateExpression3RF<E, R1, R2, R3, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R2>>,
            QRF extends EntityQueryRelatedFetchedExpression3RFF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R2, R3>>,
            R3> EntityQueryRelatedExpression<R2, R3, QR, QRF> join3(Class<R3> joinType) {
        return new EntitySqlQueryRelated<>((QR) new EntitySqlQueryRelate3RF<>(factory, sqlPageFactory, queryRelation),
                factory, queryRelation, joinType, 2);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression3RF<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression3RFF<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
    //            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R2, R3>>, R3,
    //            J> RE join3(SerializableFunction1<R2, J> propertyName, Class<R3> joinType) {
    //        queryRelation.join(2, getPropertyName(propertyName), factory.getClassMapping(joinType));
    //        return (RE) new EntitySqlQueryRelate3RF<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression3RF<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression3RFF<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
    //            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R2, R3>>, R3,
    //            J> RE join3(SerializableFunction1<R2, J> propertyName, SerializableFunction1<R3, J> joinTypePropertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
    //        queryRelation.join(2, getPropertyName(propertyName),
    //                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
    //        return (RE) new EntitySqlQueryRelate3RF<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression3RF<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression3RFF<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
    //            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R2, R3>>, R3,
    //            J> RE join3(SerializableFunction4<R3, J> joinTypePropertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
    //        queryRelation.join(2, factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())),
    //                info.getPropertyName());
    //        return (RE) new EntitySqlQueryRelate3RF<>(factory, sqlPageFactory, queryRelation);
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression3RF<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3RFF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R2, R3>>,
            R3> RE join3(SerializableFunction1<R2, R3> propertyName) {
        // IMPLSOON 后续来实现实体关系（ManyToOne、OneToOne、OneToMany）关联
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression3RF<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3RFF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R2, R3>>,
            R3> RE join3(SerializableFunction2<R3, R2> propertyName) {
        // IMPLSOON 后续来实现实体关系（ManyToOne、OneToOne、OneToMany）关联
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression3RF<E, R1, R2, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R2, RC, RL, RS, Tuple2<E, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R2, RC, RL, RS, Tuple2<E, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R2, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3RFF<E, R1, R2, R2, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R2, QRC, QRL, QRS, Tuple3<E, R2, R2>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R2, QRC, QRL, QRS, Tuple3<E, R2, R2>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R2, Tuple3<E, R2, R2>>> RE join3(
                    SerializableFunction3<R2, R2> propertyName) {
        // IMPLSOON 后续来实现实体关系（ManyToOne、OneToOne、OneToMany）关联
        return null;
    }

}
