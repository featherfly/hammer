
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
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LambdaUtils.SerializedLambdaInfo;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelatedFetched2FF;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression4;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelateExpression3FFP;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelateExpression3FFR;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedExpression;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedFetchedExpression3FFF;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedFetchedExpression3FFP;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.AbstractEntitySqlQueryFetch3;

/**
 * The Class EntitySqlQueryRelatedFetched2FF.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 */
public class EntitySqlQueryRelatedFetched2FF<E, R1, R2> extends
        AbstractEntitySqlQueryFetch3<E, R1, R2, Tuple3<E, R1, R2>> implements EntityQueryRelatedFetched2FF<E, R1, R2> {

    /**
     * Instantiates a new entity sql query related fetched 2 FF.
     *
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    public EntitySqlQueryRelatedFetched2FF(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <QR extends EntityQueryRelateExpression3FFR<E, R1, R2, R3, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R1, R2>>,
            QRF extends EntityQueryRelatedFetchedExpression3FFF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple4<E, R1, R2, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple4<E, R1, R2, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple4<E, R1, R2, R3>>,
            R3> EntityQueryRelatedExpression<E, R3, QR, QRF> join(Class<R3> joinType) {
        return new EntitySqlQueryRelated<>((QR) new EntitySqlQueryRelate3FFR<>(factory, sqlPageFactory, queryRelation),
                factory, queryRelation, joinType, 0);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelateExpression3FFR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3FFF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple4<E, R1, R2, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple4<E, R1, R2, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple4<E, R1, R2, R3>>,
            R3> RE join(SerializableFunction2<R3, E> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(0, queryRelation.getEntityRelationMapping(0).getIdName(),
                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return (RE) new EntitySqlQueryRelate3FFR<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelateExpression3FFP<E, R1, R2, R3, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3FFP<E, R1, R2, R3, RC, RL, RS>,
            R3> RE join(SerializableFunction1<E, R3> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(0, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return (RE) new EntitySqlQueryRelate3FFP<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelateExpression3FFP<E, R1, R2, E, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, E, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, E, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, E, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3FFP<E, R1, R2, E, RC, RL, RS>> RE join(
                    SerializableUnaryOperator1<E> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(0, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return (RE) new EntitySqlQueryRelate3FFP<>(factory, sqlPageFactory, queryRelation);
    }

    // ****************************************************************************************************************
    //	2
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <QR extends EntityQueryRelateExpression3FFR<E, R1, R2, R3, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R1, R2>>,
            QRF extends EntityQueryRelatedFetchedExpression3FFF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple4<E, R1, R2, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple4<E, R1, R2, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple4<E, R1, R2, R3>>,
            R3> EntityQueryRelatedExpression<R1, R3, QR, QRF> join2(Class<R3> joinType) {
        return new EntitySqlQueryRelated<>((QR) new EntitySqlQueryRelate3FFR<>(factory, sqlPageFactory, queryRelation),
                factory, queryRelation, joinType, 1);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelateExpression3FFR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3FFF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple4<E, R1, R2, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple4<E, R1, R2, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple4<E, R1, R2, R3>>,
            R3> RE join2(SerializableFunction2<R3, R1> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(1, queryRelation.getEntityRelationMapping(0).getIdName(),
                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return (RE) new EntitySqlQueryRelate3FFR<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelateExpression3FFP<E, R1, R2, R3, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3FFP<E, R1, R2, R3, RC, RL, RS>,
            R3> RE join2(SerializableFunction1<R1, R3> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(1, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return (RE) new EntitySqlQueryRelate3FFP<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelateExpression3FFP<E, R1, R2, R1, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R1, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R1, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R1, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3FFP<E, R1, R2, R1, RC, RL, RS>> RE join2(
                    SerializableUnaryOperator1<R1> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(1, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return (RE) new EntitySqlQueryRelate3FFP<>(factory, sqlPageFactory, queryRelation);
    }

    // ****************************************************************************************************************
    //	3
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <QR extends EntityQueryRelateExpression3FFR<E, R1, R2, R3, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R1, R2>>,
            QRF extends EntityQueryRelatedFetchedExpression3FFF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple4<E, R1, R2, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple4<E, R1, R2, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple4<E, R1, R2, R3>>,
            R3> EntityQueryRelatedExpression<R2, R3, QR, QRF> join3(Class<R3> joinType) {
        return new EntitySqlQueryRelated<>((QR) new EntitySqlQueryRelate3FFR<>(factory, sqlPageFactory, queryRelation),
                factory, queryRelation, joinType, 2);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelateExpression3FFR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3FFF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple4<E, R1, R2, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple4<E, R1, R2, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple4<E, R1, R2, R3>>,
            R3> RE join3(SerializableFunction2<R3, R2> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(2, queryRelation.getEntityRelationMapping(0).getIdName(),
                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return (RE) new EntitySqlQueryRelate3FFR<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelateExpression3FFP<E, R1, R2, R3, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3FFP<E, R1, R2, R3, RC, RL, RS>,
            R3> RE join3(SerializableFunction1<R2, R3> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(2, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return (RE) new EntitySqlQueryRelate3FFP<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelateExpression3FFP<E, R1, R2, R2, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R2, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R2, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R2, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3FFP<E, R1, R2, R2, RC, RL, RS>> RE join3(
                    SerializableUnaryOperator1<R2> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(2, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return (RE) new EntitySqlQueryRelate3FFP<>(factory, sqlPageFactory, queryRelation);
    }

}
