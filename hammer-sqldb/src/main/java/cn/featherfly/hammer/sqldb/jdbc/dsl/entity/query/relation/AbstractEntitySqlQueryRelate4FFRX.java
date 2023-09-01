
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
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelateExpression5FFRRP;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelateExpression5FFRRR;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedExpression;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedFetchedExpression5FFRRF;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedFetchedExpression5FFRRP;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.AbstractEntitySqlQueryFetch5;

/**
 * The Class AbstractEntitySqlQueryRelate4FFRX.
 *
 * @author zhongj
 * @param <E>   the element type
 * @param <R1>  the generic type
 * @param <R2>  the generic type
 * @param <R3>  the generic type
 * @param <R4>  the generic type
 * @param <RES> the generic type
 */
public abstract class AbstractEntitySqlQueryRelate4FFRX<E, R1, R2, R3, R4, RES>
        extends AbstractEntitySqlQueryFetch5<E, R1, R2, R3, R4, RES> {

    /**
     * Instantiates a new abstract entity sql query relate 4 FFRX.
     *
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    protected AbstractEntitySqlQueryRelate4FFRX(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * Join.
     *
     * @param <QR>     the generic type
     * @param <RC>     the generic type
     * @param <RL>     the generic type
     * @param <RS>     the generic type
     * @param <QRF>    the generic type
     * @param <QRC>    the generic type
     * @param <QRL>    the generic type
     * @param <QRS>    the generic type
     * @param <R5>     the generic type
     * @param joinType the join type
     * @return the entity query related expression
     */
    @SuppressWarnings("unchecked")
    public <QR extends EntityQueryRelateExpression5FFRRR<E, R1, R2, R3, R4, R5, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R1, R2>>,
            QRF extends EntityQueryRelatedFetchedExpression5FFRRF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple4<E, R1, R2, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple4<E, R1, R2, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple4<E, R1, R2, R5>>,
            R5> EntityQueryRelatedExpression<E, R5, QR, QRF> join(Class<R5> joinType) {
        return new EntitySqlQueryRelated<>(
                (QR) new EntitySqlQueryRelate5FFRRR<>(factory, sqlPageFactory, queryRelation), factory, queryRelation,
                joinType, 0);
    }

    /**
     * Join.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param <QRC>        the generic type
     * @param <QRL>        the generic type
     * @param <QRS>        the generic type
     * @param <R5>         the generic type
     * @param propertyName the property name
     * @return the re
     */
    @SuppressWarnings("unchecked")
    public <RE extends EntityQueryRelateExpression5FFRRR<E, R1, R2, R3, R4, R5, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression5FFRRF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple4<E, R1, R2, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple4<E, R1, R2, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple4<E, R1, R2, R5>>,
            R5> RE join(SerializableFunction2<R5, E> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(0, queryRelation.getEntityRelationMapping(0).getIdName(),
                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return (RE) new EntitySqlQueryRelate5FFRRR<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * Join.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param <R5>         the generic type
     * @param propertyName the property name
     * @return the re
     */
    @SuppressWarnings("unchecked")
    public <RE extends EntityQueryRelateExpression5FFRRP<E, R1, R2, R3, R4, R5, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression5FFRRP<E, R1, R2, R3, R4, R5, RC, RL, RS>,
            R5> RE join(SerializableFunction1<E, R5> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(0, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return (RE) new EntitySqlQueryRelate5FFRRP<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * Join.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param propertyName the property name
     * @return the re
     */
    @SuppressWarnings("unchecked")
    public <RE extends EntityQueryRelateExpression5FFRRP<E, R1, R2, R3, R4, E, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, E, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, E, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, E, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression5FFRRP<E, R1, R2, R3, R4, E, RC, RL, RS>> RE join(
                    SerializableUnaryOperator1<E> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(0, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return (RE) new EntitySqlQueryRelate5FFRRP<>(factory, sqlPageFactory, queryRelation);
    }

    // ****************************************************************************************************************
    //	2
    // ****************************************************************************************************************

    /**
     * Join 2.
     *
     * @param <QR>     the generic type
     * @param <RC>     the generic type
     * @param <RL>     the generic type
     * @param <RS>     the generic type
     * @param <QRF>    the generic type
     * @param <QRC>    the generic type
     * @param <QRL>    the generic type
     * @param <QRS>    the generic type
     * @param <R5>     the generic type
     * @param joinType the join type
     * @return the entity query related expression
     */
    @SuppressWarnings("unchecked")
    public <QR extends EntityQueryRelateExpression5FFRRR<E, R1, R2, R3, R4, R5, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R1, R2>>,
            QRF extends EntityQueryRelatedFetchedExpression5FFRRF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple4<E, R1, R2, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple4<E, R1, R2, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple4<E, R1, R2, R5>>,
            R5> EntityQueryRelatedExpression<R1, R5, QR, QRF> join2(Class<R5> joinType) {
        return new EntitySqlQueryRelated<>(
                (QR) new EntitySqlQueryRelate5FFRRR<>(factory, sqlPageFactory, queryRelation), factory, queryRelation,
                joinType, 1);
    }

    /**
     * Join 2.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param <QRC>        the generic type
     * @param <QRL>        the generic type
     * @param <QRS>        the generic type
     * @param <R5>         the generic type
     * @param propertyName the property name
     * @return the re
     */
    @SuppressWarnings("unchecked")
    public <RE extends EntityQueryRelateExpression5FFRRR<E, R1, R2, R3, R4, R5, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression5FFRRF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple4<E, R1, R2, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple4<E, R1, R2, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple4<E, R1, R2, R5>>,
            R5> RE join2(SerializableFunction2<R5, R1> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(1, queryRelation.getEntityRelationMapping(0).getIdName(),
                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return (RE) new EntitySqlQueryRelate5FFRRR<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * Join 2.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param <R5>         the generic type
     * @param propertyName the property name
     * @return the re
     */
    @SuppressWarnings("unchecked")
    public <RE extends EntityQueryRelateExpression5FFRRP<E, R1, R2, R3, R4, R5, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression5FFRRP<E, R1, R2, R3, R4, R5, RC, RL, RS>,
            R5> RE join2(SerializableFunction1<R1, R5> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(1, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return (RE) new EntitySqlQueryRelate5FFRRP<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * Join 2.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param propertyName the property name
     * @return the re
     */
    @SuppressWarnings("unchecked")
    public <RE extends EntityQueryRelateExpression5FFRRP<E, R1, R2, R3, R4, R1, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R1, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R1, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R1, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression5FFRRP<E, R1, R2, R3, R4, R1, RC, RL, RS>> RE join2(
                    SerializableUnaryOperator1<R1> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(1, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return (RE) new EntitySqlQueryRelate5FFRRP<>(factory, sqlPageFactory, queryRelation);
    }

    // ****************************************************************************************************************
    //	3
    // ****************************************************************************************************************

    /**
     * Join 3.
     *
     * @param <QR>     the generic type
     * @param <RC>     the generic type
     * @param <RL>     the generic type
     * @param <RS>     the generic type
     * @param <QRF>    the generic type
     * @param <QRC>    the generic type
     * @param <QRL>    the generic type
     * @param <QRS>    the generic type
     * @param <R5>     the generic type
     * @param joinType the join type
     * @return the entity query related expression
     */
    @SuppressWarnings("unchecked")
    public <QR extends EntityQueryRelateExpression5FFRRR<E, R1, R2, R3, R4, R5, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R1, R2>>,
            QRF extends EntityQueryRelatedFetchedExpression5FFRRF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple4<E, R1, R2, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple4<E, R1, R2, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple4<E, R1, R2, R5>>,
            R5> EntityQueryRelatedExpression<R2, R5, QR, QRF> join3(Class<R5> joinType) {
        return new EntitySqlQueryRelated<>(
                (QR) new EntitySqlQueryRelate5FFRRR<>(factory, sqlPageFactory, queryRelation), factory, queryRelation,
                joinType, 2);
    }

    /**
     * Join 3.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param <QRC>        the generic type
     * @param <QRL>        the generic type
     * @param <QRS>        the generic type
     * @param <R5>         the generic type
     * @param propertyName the property name
     * @return the re
     */
    @SuppressWarnings("unchecked")
    public <RE extends EntityQueryRelateExpression5FFRRR<E, R1, R2, R3, R4, R5, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression5FFRRF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple4<E, R1, R2, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple4<E, R1, R2, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple4<E, R1, R2, R5>>,
            R5> RE join3(SerializableFunction2<R5, R2> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(2, queryRelation.getEntityRelationMapping(0).getIdName(),
                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return (RE) new EntitySqlQueryRelate5FFRRR<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * Join 3.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param <R5>         the generic type
     * @param propertyName the property name
     * @return the re
     */
    @SuppressWarnings("unchecked")
    public <RE extends EntityQueryRelateExpression5FFRRP<E, R1, R2, R3, R4, R5, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression5FFRRP<E, R1, R2, R3, R4, R5, RC, RL, RS>,
            R5> RE join3(SerializableFunction1<R2, R5> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(2, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return (RE) new EntitySqlQueryRelate5FFRRP<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * Join 3.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param propertyName the property name
     * @return the re
     */
    @SuppressWarnings("unchecked")
    public <RE extends EntityQueryRelateExpression5FFRRP<E, R1, R2, R3, R4, R2, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R2, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R2, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R2, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression5FFRRP<E, R1, R2, R3, R4, R2, RC, RL, RS>> RE join3(
                    SerializableUnaryOperator1<R2> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(2, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return (RE) new EntitySqlQueryRelate5FFRRP<>(factory, sqlPageFactory, queryRelation);
    }

    // ****************************************************************************************************************
    //	4
    // ****************************************************************************************************************

    /**
     * Join 4.
     *
     * @param <QR>     the generic type
     * @param <RC>     the generic type
     * @param <RL>     the generic type
     * @param <RS>     the generic type
     * @param <QRF>    the generic type
     * @param <QRC>    the generic type
     * @param <QRL>    the generic type
     * @param <QRS>    the generic type
     * @param <R5>     the generic type
     * @param joinType the join type
     * @return the entity query related expression
     */
    @SuppressWarnings("unchecked")
    public <QR extends EntityQueryRelateExpression5FFRRR<E, R1, R2, R3, R4, R5, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R1, R2>>,
            QRF extends EntityQueryRelatedFetchedExpression5FFRRF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple4<E, R1, R2, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple4<E, R1, R2, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple4<E, R1, R2, R5>>,
            R5> EntityQueryRelatedExpression<R3, R5, QR, QRF> join4(Class<R5> joinType) {
        return new EntitySqlQueryRelated<>(
                (QR) new EntitySqlQueryRelate5FFRRR<>(factory, sqlPageFactory, queryRelation), factory, queryRelation,
                joinType, 3);
    }

    /**
     * Join 4.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param <QRC>        the generic type
     * @param <QRL>        the generic type
     * @param <QRS>        the generic type
     * @param <R5>         the generic type
     * @param propertyName the property name
     * @return the re
     */
    @SuppressWarnings("unchecked")
    public <RE extends EntityQueryRelateExpression5FFRRR<E, R1, R2, R3, R4, R5, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression5FFRRF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple4<E, R1, R2, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple4<E, R1, R2, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple4<E, R1, R2, R5>>,
            R5> RE join4(SerializableFunction2<R5, R3> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(3, queryRelation.getEntityRelationMapping(0).getIdName(),
                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return (RE) new EntitySqlQueryRelate5FFRRR<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * Join 4.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param <R5>         the generic type
     * @param propertyName the property name
     * @return the re
     */
    @SuppressWarnings("unchecked")
    public <RE extends EntityQueryRelateExpression5FFRRP<E, R1, R2, R3, R4, R5, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression5FFRRP<E, R1, R2, R3, R4, R5, RC, RL, RS>,
            R5> RE join4(SerializableFunction1<R3, R5> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(3, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return (RE) new EntitySqlQueryRelate5FFRRP<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * Join 4.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param propertyName the property name
     * @return the re
     */
    @SuppressWarnings("unchecked")
    public <RE extends EntityQueryRelateExpression5FFRRP<E, R1, R2, R3, R4, R3, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R3, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression5FFRRP<E, R1, R2, R3, R4, R3, RC, RL, RS>> RE join4(
                    SerializableUnaryOperator1<R3> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(3, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return (RE) new EntitySqlQueryRelate5FFRRP<>(factory, sqlPageFactory, queryRelation);
    }

    // ****************************************************************************************************************
    //	5
    // ****************************************************************************************************************

    /**
     * Join 5.
     *
     * @param <QR>     the generic type
     * @param <RC>     the generic type
     * @param <RL>     the generic type
     * @param <RS>     the generic type
     * @param <QRF>    the generic type
     * @param <QRC>    the generic type
     * @param <QRL>    the generic type
     * @param <QRS>    the generic type
     * @param <R5>     the generic type
     * @param joinType the join type
     * @return the entity query related expression
     */
    @SuppressWarnings("unchecked")
    public <QR extends EntityQueryRelateExpression5FFRRR<E, R1, R2, R3, R4, R5, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R1, R2>>,
            QRF extends EntityQueryRelatedFetchedExpression5FFRRF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple4<E, R1, R2, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple4<E, R1, R2, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple4<E, R1, R2, R5>>,
            R5> EntityQueryRelatedExpression<R4, R5, QR, QRF> join5(Class<R5> joinType) {
        return new EntitySqlQueryRelated<>(
                (QR) new EntitySqlQueryRelate5FFRRR<>(factory, sqlPageFactory, queryRelation), factory, queryRelation,
                joinType, 4);
    }

    /**
     * Join 5.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param <QRC>        the generic type
     * @param <QRL>        the generic type
     * @param <QRS>        the generic type
     * @param <R5>         the generic type
     * @param propertyName the property name
     * @return the re
     */
    @SuppressWarnings("unchecked")
    public <RE extends EntityQueryRelateExpression5FFRRR<E, R1, R2, R3, R4, R5, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression5FFRRF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple4<E, R1, R2, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple4<E, R1, R2, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple4<E, R1, R2, R5>>,
            R5> RE join5(SerializableFunction2<R5, R4> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(4, queryRelation.getEntityRelationMapping(0).getIdName(),
                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return (RE) new EntitySqlQueryRelate5FFRRR<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * Join 5.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param <R5>         the generic type
     * @param propertyName the property name
     * @return the re
     */
    @SuppressWarnings("unchecked")
    public <RE extends EntityQueryRelateExpression5FFRRP<E, R1, R2, R3, R4, R5, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression5FFRRP<E, R1, R2, R3, R4, R5, RC, RL, RS>,
            R5> RE join5(SerializableFunction1<R4, R5> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(4, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return (RE) new EntitySqlQueryRelate5FFRRP<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * Join 5.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param propertyName the property name
     * @return the re
     */
    @SuppressWarnings("unchecked")
    public <RE extends EntityQueryRelateExpression5FFRRP<E, R1, R2, R3, R4, R4, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R4, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R4, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R4, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression5FFRRP<E, R1, R2, R3, R4, R4, RC, RL, RS>> RE join5(
                    SerializableUnaryOperator1<R4> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(4, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return (RE) new EntitySqlQueryRelate5FFRRP<>(factory, sqlPageFactory, queryRelation);
    }
}
