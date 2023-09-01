
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

import com.speedment.common.tuple.Tuple3;
import com.speedment.common.tuple.Tuple4;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.serializable.SerializableFunction1;
import cn.featherfly.common.function.serializable.SerializableFunction2;
import cn.featherfly.common.function.serializable.SerializableUnaryOperator1;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LambdaUtils.SerializedLambdaInfo;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression6;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression6;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression6;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelateExpression5FRFRP;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelateExpression5FRFRR;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedExpression;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedFetchedExpression5FRFRF;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedFetchedExpression5FRFRP;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.AbstractEntitySqlQueryFetch5;

/**
 * The Class AbstractEntitySqlQueryRelate4FRFX.
 *
 * @author zhongj
 * @param <E>   the element type
 * @param <R1>  the generic type
 * @param <R2>  the generic type
 * @param <R3>  the generic type
 * @param <R4>  the generic type
 * @param <RES> the generic type
 */
public class AbstractEntitySqlQueryRelate4FRFX<E, R1, R2, R3, R4, RES>
        extends AbstractEntitySqlQueryFetch5<E, R1, R2, R3, R4, RES> {

    /**
     * Instantiates a new abstract entity sql query relate 4 FRFX.
     *
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    protected AbstractEntitySqlQueryRelate4FRFX(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
    }

    @SuppressWarnings("unchecked")
    public <QR extends EntityQueryRelateExpression5FRFRR<E, R1, R2, R3, R4, R5, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R3>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R3>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R1, R3>>,
            QRF extends EntityQueryRelatedFetchedExpression5FRFRF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple4<E, R1, R3, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple4<E, R1, R3, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple4<E, R1, R3, R5>>,
            R5> EntityQueryRelatedExpression<E, R5, QR, QRF> join(Class<R5> joinType) {
        return new EntitySqlQueryRelated<>(
                (QR) new EntitySqlQueryRelate5FRFRR<>(factory, sqlPageFactory, queryRelation), factory, queryRelation,
                joinType, 0);
    }

    @SuppressWarnings("unchecked")
    public <RE extends EntityQueryRelateExpression5FRFRR<E, R1, R2, R3, R4, R5, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R3>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R3>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R1, R3>>,
            QR extends EntityQueryRelatedFetchedExpression5FRFRF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple4<E, R1, R3, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple4<E, R1, R3, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple4<E, R1, R3, R5>>,
            R5> RE join(SerializableFunction2<R5, E> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(0, queryRelation.getEntityRelationMapping(0).getIdName(),
                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return (RE) new EntitySqlQueryRelate5FRFRR<>(factory, sqlPageFactory, queryRelation);
    }

    @SuppressWarnings("unchecked")
    public <RE extends EntityQueryRelateExpression5FRFRP<E, R1, R2, R3, R4, R5, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R3>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R3>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R1, R3>>,
            QR extends EntityQueryRelatedFetchedExpression5FRFRP<E, R1, R2, R3, R4, R5, RC, RL, RS>,
            R5> RE join(SerializableFunction1<E, R5> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(0, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return (RE) new EntitySqlQueryRelate5FRFRP<>(factory, sqlPageFactory, queryRelation);
    }

    @SuppressWarnings("unchecked")
    public <RE extends EntityQueryRelateExpression5FRFRP<E, R1, R2, R3, R4, E, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, E, RC, RL, RS, Tuple3<E, R1, R3>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, E, RC, RL, RS, Tuple3<E, R1, R3>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, E, Tuple3<E, R1, R3>>,
            QR extends EntityQueryRelatedFetchedExpression5FRFRP<E, R1, R2, R3, R4, E, RC, RL, RS>> RE join(
                    SerializableUnaryOperator1<E> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(0, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return (RE) new EntitySqlQueryRelate5FRFRP<>(factory, sqlPageFactory, queryRelation);
    }

    // ****************************************************************************************************************
    //	2
    // ****************************************************************************************************************

    @SuppressWarnings("unchecked")
    public <QR extends EntityQueryRelateExpression5FRFRR<E, R1, R2, R3, R4, R5, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R3>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R3>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R1, R3>>,
            QRF extends EntityQueryRelatedFetchedExpression5FRFRF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple4<E, R1, R3, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple4<E, R1, R3, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple4<E, R1, R3, R5>>,
            R5> EntityQueryRelatedExpression<R1, R5, QR, QRF> join2(Class<R5> joinType) {
        return new EntitySqlQueryRelated<>(
                (QR) new EntitySqlQueryRelate5FRFRR<>(factory, sqlPageFactory, queryRelation), factory, queryRelation,
                joinType, 1);
    }

    @SuppressWarnings("unchecked")
    public <RE extends EntityQueryRelateExpression5FRFRR<E, R1, R2, R3, R4, R5, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R3>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R3>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R1, R3>>,
            QR extends EntityQueryRelatedFetchedExpression5FRFRF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple4<E, R1, R3, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple4<E, R1, R3, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple4<E, R1, R3, R5>>,
            R5> RE join2(SerializableFunction2<R5, R1> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(1, queryRelation.getEntityRelationMapping(0).getIdName(),
                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return (RE) new EntitySqlQueryRelate5FRFRR<>(factory, sqlPageFactory, queryRelation);
    }

    @SuppressWarnings("unchecked")
    public <RE extends EntityQueryRelateExpression5FRFRP<E, R1, R2, R3, R4, R5, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R3>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R3>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R1, R3>>,
            QR extends EntityQueryRelatedFetchedExpression5FRFRP<E, R1, R2, R3, R4, R5, RC, RL, RS>,
            R5> RE join2(SerializableFunction1<R1, R5> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(1, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return (RE) new EntitySqlQueryRelate5FRFRP<>(factory, sqlPageFactory, queryRelation);
    }

    @SuppressWarnings("unchecked")
    public <RE extends EntityQueryRelateExpression5FRFRP<E, R1, R2, R3, R4, R1, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R1, RC, RL, RS, Tuple3<E, R1, R3>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R1, RC, RL, RS, Tuple3<E, R1, R3>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R1, Tuple3<E, R1, R3>>,
            QR extends EntityQueryRelatedFetchedExpression5FRFRP<E, R1, R2, R3, R4, R1, RC, RL, RS>> RE join2(
                    SerializableUnaryOperator1<R1> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(1, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return (RE) new EntitySqlQueryRelate5FRFRP<>(factory, sqlPageFactory, queryRelation);
    }

    // ****************************************************************************************************************
    //	3
    // ****************************************************************************************************************

    @SuppressWarnings("unchecked")
    public <QR extends EntityQueryRelateExpression5FRFRR<E, R1, R2, R3, R4, R5, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R3>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R3>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R1, R3>>,
            QRF extends EntityQueryRelatedFetchedExpression5FRFRF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple4<E, R1, R3, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple4<E, R1, R3, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple4<E, R1, R3, R5>>,
            R5> EntityQueryRelatedExpression<R2, R5, QR, QRF> join3(Class<R5> joinType) {
        return new EntitySqlQueryRelated<>(
                (QR) new EntitySqlQueryRelate5FRFRR<>(factory, sqlPageFactory, queryRelation), factory, queryRelation,
                joinType, 2);
    }

    @SuppressWarnings("unchecked")
    public <RE extends EntityQueryRelateExpression5FRFRR<E, R1, R2, R3, R4, R5, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R3>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R3>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R1, R3>>,
            QR extends EntityQueryRelatedFetchedExpression5FRFRF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple4<E, R1, R3, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple4<E, R1, R3, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple4<E, R1, R3, R5>>,
            R5> RE join3(SerializableFunction2<R5, R2> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(2, queryRelation.getEntityRelationMapping(0).getIdName(),
                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return (RE) new EntitySqlQueryRelate5FRFRR<>(factory, sqlPageFactory, queryRelation);
    }

    @SuppressWarnings("unchecked")
    public <RE extends EntityQueryRelateExpression5FRFRP<E, R1, R2, R3, R4, R5, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R3>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R3>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R1, R3>>,
            QR extends EntityQueryRelatedFetchedExpression5FRFRP<E, R1, R2, R3, R4, R5, RC, RL, RS>,
            R5> RE join3(SerializableFunction1<R2, R5> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(2, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return (RE) new EntitySqlQueryRelate5FRFRP<>(factory, sqlPageFactory, queryRelation);
    }

    @SuppressWarnings("unchecked")
    public <RE extends EntityQueryRelateExpression5FRFRP<E, R1, R2, R3, R4, R2, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R2, RC, RL, RS, Tuple3<E, R1, R3>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R2, RC, RL, RS, Tuple3<E, R1, R3>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R2, Tuple3<E, R1, R3>>,
            QR extends EntityQueryRelatedFetchedExpression5FRFRP<E, R1, R2, R3, R4, R2, RC, RL, RS>> RE join3(
                    SerializableUnaryOperator1<R2> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(2, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return (RE) new EntitySqlQueryRelate5FRFRP<>(factory, sqlPageFactory, queryRelation);
    }

    // ****************************************************************************************************************
    //	4
    // ****************************************************************************************************************

    @SuppressWarnings("unchecked")
    public <QR extends EntityQueryRelateExpression5FRFRR<E, R1, R2, R3, R4, R5, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R3>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R3>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R1, R3>>,
            QRF extends EntityQueryRelatedFetchedExpression5FRFRF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple4<E, R1, R3, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple4<E, R1, R3, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple4<E, R1, R3, R5>>,
            R5> EntityQueryRelatedExpression<R3, R5, QR, QRF> join4(Class<R5> joinType) {
        return new EntitySqlQueryRelated<>(
                (QR) new EntitySqlQueryRelate5FRFRR<>(factory, sqlPageFactory, queryRelation), factory, queryRelation,
                joinType, 3);
    }

    @SuppressWarnings("unchecked")
    public <RE extends EntityQueryRelateExpression5FRFRR<E, R1, R2, R3, R4, R5, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R3>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R3>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R1, R3>>,
            QR extends EntityQueryRelatedFetchedExpression5FRFRF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple4<E, R1, R3, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple4<E, R1, R3, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple4<E, R1, R3, R5>>,
            R5> RE join4(SerializableFunction2<R5, R3> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(3, queryRelation.getEntityRelationMapping(0).getIdName(),
                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return (RE) new EntitySqlQueryRelate5FRFRR<>(factory, sqlPageFactory, queryRelation);
    }

    @SuppressWarnings("unchecked")
    public <RE extends EntityQueryRelateExpression5FRFRP<E, R1, R2, R3, R4, R5, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R3>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R3>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R1, R3>>,
            QR extends EntityQueryRelatedFetchedExpression5FRFRP<E, R1, R2, R3, R4, R5, RC, RL, RS>,
            R5> RE join4(SerializableFunction1<R3, R5> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(3, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return (RE) new EntitySqlQueryRelate5FRFRP<>(factory, sqlPageFactory, queryRelation);
    }

    @SuppressWarnings("unchecked")
    public <RE extends EntityQueryRelateExpression5FRFRP<E, R1, R2, R3, R4, R3, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R3, RC, RL, RS, Tuple3<E, R1, R3>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R3, RC, RL, RS, Tuple3<E, R1, R3>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R3, Tuple3<E, R1, R3>>,
            QR extends EntityQueryRelatedFetchedExpression5FRFRP<E, R1, R2, R3, R4, R3, RC, RL, RS>> RE join4(
                    SerializableUnaryOperator1<R3> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(3, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return (RE) new EntitySqlQueryRelate5FRFRP<>(factory, sqlPageFactory, queryRelation);
    }

    // ****************************************************************************************************************
    //	5
    // ****************************************************************************************************************

    @SuppressWarnings("unchecked")
    public <QR extends EntityQueryRelateExpression5FRFRR<E, R1, R2, R3, R4, R5, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R3>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R3>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R1, R3>>,
            QRF extends EntityQueryRelatedFetchedExpression5FRFRF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple4<E, R1, R3, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple4<E, R1, R3, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple4<E, R1, R3, R5>>,
            R5> EntityQueryRelatedExpression<R4, R5, QR, QRF> join5(Class<R5> joinType) {
        return new EntitySqlQueryRelated<>(
                (QR) new EntitySqlQueryRelate5FRFRR<>(factory, sqlPageFactory, queryRelation), factory, queryRelation,
                joinType, 4);
    }

    @SuppressWarnings("unchecked")
    public <RE extends EntityQueryRelateExpression5FRFRR<E, R1, R2, R3, R4, R5, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R3>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R3>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R1, R3>>,
            QR extends EntityQueryRelatedFetchedExpression5FRFRF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple4<E, R1, R3, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple4<E, R1, R3, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple4<E, R1, R3, R5>>,
            R5> RE join5(SerializableFunction2<R5, R4> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(4, queryRelation.getEntityRelationMapping(0).getIdName(),
                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return (RE) new EntitySqlQueryRelate5FRFRR<>(factory, sqlPageFactory, queryRelation);
    }

    @SuppressWarnings("unchecked")
    public <RE extends EntityQueryRelateExpression5FRFRP<E, R1, R2, R3, R4, R5, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R3>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R3>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R1, R3>>,
            QR extends EntityQueryRelatedFetchedExpression5FRFRP<E, R1, R2, R3, R4, R5, RC, RL, RS>,
            R5> RE join5(SerializableFunction1<R4, R5> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(4, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return (RE) new EntitySqlQueryRelate5FRFRP<>(factory, sqlPageFactory, queryRelation);
    }

    @SuppressWarnings("unchecked")
    public <RE extends EntityQueryRelateExpression5FRFRP<E, R1, R2, R3, R4, R4, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R4, RC, RL, RS, Tuple3<E, R1, R3>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R4, RC, RL, RS, Tuple3<E, R1, R3>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R4, Tuple3<E, R1, R3>>,
            QR extends EntityQueryRelatedFetchedExpression5FRFRP<E, R1, R2, R3, R4, R4, RC, RL, RS>> RE join5(
                    SerializableUnaryOperator1<R4> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(4, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return (RE) new EntitySqlQueryRelate5FRFRP<>(factory, sqlPageFactory, queryRelation);
    }

}
