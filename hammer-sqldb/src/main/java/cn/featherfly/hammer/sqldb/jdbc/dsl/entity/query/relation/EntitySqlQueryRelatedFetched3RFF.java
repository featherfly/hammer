
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
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelatedFetched3RFF;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression5;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression5;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression5;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelateExpression4RFFP;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelateExpression4RFFR;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedExpression;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedFetchedExpression4RFFF;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedFetchedExpression4RFFP;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.AbstractEntitySqlQueryFetch4;

/**
 * The Class EntitySqlQueryRelatedFetched3RFF.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 * @param <R3> the generic type
 */
public class EntitySqlQueryRelatedFetched3RFF<E, R1, R2, R3>
        extends AbstractEntitySqlQueryFetch4<E, R1, R2, R3, Tuple3<E, R2, R3>>
        implements EntityQueryRelatedFetched3RFF<E, R1, R2, R3> {

    /**
     * Instantiates a new entity sql query related fetched 3 RFF.
     *
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    public EntitySqlQueryRelatedFetched3RFF(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <QR extends EntityQueryRelateExpression4RFFR<E, R1, R2, R3, R4, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R2, R3>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R2, R3>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R2, R3>>,
            QRF extends EntityQueryRelatedFetchedExpression4RFFF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple4<E, R2, R3, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS,
                    Tuple4<E, R2, R3, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple4<E, R2, R3, R4>>,
            R4> EntityQueryRelatedExpression<E, R4, QR, QRF> join(Class<R4> joinType) {
        return new EntitySqlQueryRelated<>((QR) new EntitySqlQueryRelate4RFFR<>(factory, sqlPageFactory, queryRelation),
                factory, queryRelation, joinType, 0);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelateExpression4RFFR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R2, R3>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R2, R3>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R2, R3>>,
            QR extends EntityQueryRelatedFetchedExpression4RFFF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple4<E, R2, R3, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS,
                    Tuple4<E, R2, R3, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple4<E, R2, R3, R4>>,
            R4> RE join(SerializableFunction2<R4, E> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(0, queryRelation.getEntityRelationMapping(0).getIdName(),
                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return (RE) new EntitySqlQueryRelate4RFFR<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelateExpression4RFFP<E, R1, R2, R3, R4, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R2, R3>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R2, R3>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R2, R3>>,
            QR extends EntityQueryRelatedFetchedExpression4RFFP<E, R1, R2, R3, R4, RC, RL, RS>,
            R4> RE join(SerializableFunction1<E, R4> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(0, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return (RE) new EntitySqlQueryRelate4RFFP<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelateExpression4RFFP<E, R1, R2, R3, E, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, E, RC, RL, RS, Tuple3<E, R2, R3>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, E, RC, RL, RS, Tuple3<E, R2, R3>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, E, Tuple3<E, R2, R3>>,
            QR extends EntityQueryRelatedFetchedExpression4RFFP<E, R1, R2, R3, E, RC, RL, RS>> RE join(
                    SerializableUnaryOperator1<E> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(0, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return (RE) new EntitySqlQueryRelate4RFFP<>(factory, sqlPageFactory, queryRelation);
    }

    // ****************************************************************************************************************
    //	join 2
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <QR extends EntityQueryRelateExpression4RFFR<E, R1, R2, R3, R4, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R2, R3>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R2, R3>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R2, R3>>,
            QRF extends EntityQueryRelatedFetchedExpression4RFFF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple4<E, R2, R3, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS,
                    Tuple4<E, R2, R3, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple4<E, R2, R3, R4>>,
            R4> EntityQueryRelatedExpression<R1, R4, QR, QRF> join2(Class<R4> joinType) {
        return new EntitySqlQueryRelated<>((QR) new EntitySqlQueryRelate4RFFR<>(factory, sqlPageFactory, queryRelation),
                factory, queryRelation, joinType, 1);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelateExpression4RFFR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R2, R3>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R2, R3>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R2, R3>>,
            QR extends EntityQueryRelatedFetchedExpression4RFFF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple4<E, R2, R3, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS,
                    Tuple4<E, R2, R3, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple4<E, R2, R3, R4>>,
            R4> RE join2(SerializableFunction2<R4, R1> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(1, queryRelation.getEntityRelationMapping(0).getIdName(),
                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return (RE) new EntitySqlQueryRelate4RFFR<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelateExpression4RFFP<E, R1, R2, R3, R4, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R2, R3>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R2, R3>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R2, R3>>,
            QR extends EntityQueryRelatedFetchedExpression4RFFP<E, R1, R2, R3, R4, RC, RL, RS>,
            R4> RE join2(SerializableFunction1<R1, R4> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(1, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return (RE) new EntitySqlQueryRelate4RFFP<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelateExpression4RFFP<E, R1, R2, R3, R1, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R1, RC, RL, RS, Tuple3<E, R2, R3>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R1, RC, RL, RS, Tuple3<E, R2, R3>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R1, Tuple3<E, R2, R3>>,
            QR extends EntityQueryRelatedFetchedExpression4RFFP<E, R1, R2, R3, R1, RC, RL, RS>> RE join2(
                    SerializableUnaryOperator1<R1> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(1, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return (RE) new EntitySqlQueryRelate4RFFP<>(factory, sqlPageFactory, queryRelation);
    }

    // ****************************************************************************************************************
    //	join 3
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <QR extends EntityQueryRelateExpression4RFFR<E, R1, R2, R3, R4, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R2, R3>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R2, R3>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R2, R3>>,
            QRF extends EntityQueryRelatedFetchedExpression4RFFF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple4<E, R2, R3, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS,
                    Tuple4<E, R2, R3, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple4<E, R2, R3, R4>>,
            R4> EntityQueryRelatedExpression<R2, R4, QR, QRF> join3(Class<R4> joinType) {
        return new EntitySqlQueryRelated<>((QR) new EntitySqlQueryRelate4RFFR<>(factory, sqlPageFactory, queryRelation),
                factory, queryRelation, joinType, 2);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelateExpression4RFFR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R2, R3>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R2, R3>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R2, R3>>,
            QR extends EntityQueryRelatedFetchedExpression4RFFF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple4<E, R2, R3, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS,
                    Tuple4<E, R2, R3, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple4<E, R2, R3, R4>>,
            R4> RE join3(SerializableFunction2<R4, R2> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(2, queryRelation.getEntityRelationMapping(0).getIdName(),
                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return (RE) new EntitySqlQueryRelate4RFFR<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelateExpression4RFFP<E, R1, R2, R3, R4, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R2, R3>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R2, R3>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R2, R3>>,
            QR extends EntityQueryRelatedFetchedExpression4RFFP<E, R1, R2, R3, R4, RC, RL, RS>,
            R4> RE join3(SerializableFunction1<R2, R4> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(2, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return (RE) new EntitySqlQueryRelate4RFFP<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelateExpression4RFFP<E, R1, R2, R3, R2, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R2, RC, RL, RS, Tuple3<E, R2, R3>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R2, RC, RL, RS, Tuple3<E, R2, R3>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R2, Tuple3<E, R2, R3>>,
            QR extends EntityQueryRelatedFetchedExpression4RFFP<E, R1, R2, R3, R2, RC, RL, RS>> RE join3(
                    SerializableUnaryOperator1<R2> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(2, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return (RE) new EntitySqlQueryRelate4RFFP<>(factory, sqlPageFactory, queryRelation);
    }

    // ****************************************************************************************************************
    //	join 4
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <QR extends EntityQueryRelateExpression4RFFR<E, R1, R2, R3, R4, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R2, R3>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R2, R3>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R2, R3>>,
            QRF extends EntityQueryRelatedFetchedExpression4RFFF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple4<E, R2, R3, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS,
                    Tuple4<E, R2, R3, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple4<E, R2, R3, R4>>,
            R4> EntityQueryRelatedExpression<R3, R4, QR, QRF> join4(Class<R4> joinType) {
        return new EntitySqlQueryRelated<>((QR) new EntitySqlQueryRelate4RFFR<>(factory, sqlPageFactory, queryRelation),
                factory, queryRelation, joinType, 3);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelateExpression4RFFR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R2, R3>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R2, R3>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R2, R3>>,
            QR extends EntityQueryRelatedFetchedExpression4RFFF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple4<E, R2, R3, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS,
                    Tuple4<E, R2, R3, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple4<E, R2, R3, R4>>,
            R4> RE join4(SerializableFunction2<R4, R3> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(3, queryRelation.getEntityRelationMapping(0).getIdName(),
                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return (RE) new EntitySqlQueryRelate4RFFR<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelateExpression4RFFP<E, R1, R2, R3, R4, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R2, R3>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple3<E, R2, R3>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R2, R3>>,
            QR extends EntityQueryRelatedFetchedExpression4RFFP<E, R1, R2, R3, R4, RC, RL, RS>,
            R4> RE join4(SerializableFunction1<R3, R4> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(3, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return (RE) new EntitySqlQueryRelate4RFFP<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelateExpression4RFFP<E, R1, R2, R3, R3, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R3, RC, RL, RS, Tuple3<E, R2, R3>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R3, RC, RL, RS, Tuple3<E, R2, R3>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R3, Tuple3<E, R2, R3>>,
            QR extends EntityQueryRelatedFetchedExpression4RFFP<E, R1, R2, R3, R3, RC, RL, RS>> RE join4(
                    SerializableUnaryOperator1<R3> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(3, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return (RE) new EntitySqlQueryRelate4RFFP<>(factory, sqlPageFactory, queryRelation);
    }

}
