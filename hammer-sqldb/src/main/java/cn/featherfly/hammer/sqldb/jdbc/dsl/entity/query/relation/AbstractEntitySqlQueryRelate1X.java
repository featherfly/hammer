
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.relation;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.serializable.SerializableFunction1;
import cn.featherfly.common.function.serializable.SerializableFunction2;
import cn.featherfly.common.function.serializable.SerializableUnaryOperator1;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LambdaUtils.SerializedLambdaInfo;
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
 * The Class AbstractEntitySqlQueryRelate1X.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 */
public abstract class AbstractEntitySqlQueryRelate1X<E, R1> extends AbstractEntitySqlQueryFetch2<E, R1, E> {

    /**
     * Instantiates a new abstract entity sql query relate 1 X.
     *
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    protected AbstractEntitySqlQueryRelate1X(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
    }

    // ****************************************************************************************************************

    /**
     * Join.
     *
     * @param <QR>     the generic type
     * @param <RC>     the generic type
     * @param <RL>     the generic type
     * @param <RS>     the generic type
     * @param <QRC>    the generic type
     * @param <QRL>    the generic type
     * @param <QRS>    the generic type
     * @param <QRF>    the generic type
     * @param <R2>     the generic type
     * @param joinType the join type
     * @return the entity query related expression
     */
    @SuppressWarnings("unchecked")

    public <QR extends EntityQueryRelateExpression2RR<E, R1, R2, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
            QRF extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>,
            R2> EntityQueryRelatedExpression<E, R2, QR, QRF> join(Class<R2> joinType) {
        return new EntitySqlQueryRelated<>((QR) new EntitySqlQueryRelate2RR<>(factory, sqlPageFactory, queryRelation),
                factory, queryRelation, joinType, 0);
    }

    /**
     * Join.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param <R2>         the generic type
     * @param propertyName the property name
     * @return the re
     */
    @SuppressWarnings("unchecked")

    public <RE extends EntityQueryRelateExpression2RP<E, R1, R2, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QR extends EntityQueryRelatedFetchedExpression2RP<E, R1, R2, RC, RL, RS>,
            R2> RE join(SerializableFunction1<E, R2> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(0, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return (RE) new EntitySqlQueryRelate2RP<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * Join.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param <FC>         the generic type
     * @param <FL>         the generic type
     * @param <FS>         the generic type
     * @param <R2>         the generic type
     * @param propertyName the property name
     * @return the re
     */
    @SuppressWarnings("unchecked")

    public <RE extends EntityQueryRelateExpression2RR<E, R1, R2, RC, RL, RS, QR, FC, FL, FS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, FC, FL, FS>,
            FC extends EntityQueryConditionGroupExpression3<E, R1, R2, FC, FL, FS, Tuple2<E, R2>>,
            FL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, FC, FL, FS, Tuple2<E, R2>>,
            FS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
            R2> RE join(SerializableFunction2<R2, E> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(0, queryRelation.getEntityRelationMapping(0).getIdName(),
                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return (RE) new EntitySqlQueryRelate2RR<>(factory, sqlPageFactory, queryRelation);
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

    public <RE extends EntityQueryRelateExpression2RP<E, R1, E, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, E, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, E, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, E, E>,
            QR extends EntityQueryRelatedFetchedExpression2RP<E, R1, E, RC, RL, RS>> RE join(
                    SerializableUnaryOperator1<E> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(0, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return (RE) new EntitySqlQueryRelate2RP<>(factory, sqlPageFactory, queryRelation);
    }

    // ****************************************************************************************************************
    //	join 2
    // ****************************************************************************************************************

    /**
     * Join 2.
     *
     * @param <QR>     the generic type
     * @param <RC>     the generic type
     * @param <RL>     the generic type
     * @param <RS>     the generic type
     * @param <QRC>    the generic type
     * @param <QRL>    the generic type
     * @param <QRS>    the generic type
     * @param <QRF>    the generic type
     * @param <R2>     the generic type
     * @param joinType the join type
     * @return the entity query related expression
     */
    @SuppressWarnings("unchecked")

    public <QR extends EntityQueryRelateExpression2RR<E, R1, R2, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
            QRF extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>,
            R2> EntityQueryRelatedExpression<R1, R2, QR, QRF> join2(Class<R2> joinType) {
        return new EntitySqlQueryRelated<>((QR) new EntitySqlQueryRelate2RR<>(factory, sqlPageFactory, queryRelation),
                factory, queryRelation, joinType, 1);
    }

    /**
     * Join 2.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param <FC>         the generic type
     * @param <FL>         the generic type
     * @param <FS>         the generic type
     * @param <R2>         the generic type
     * @param propertyName the property name
     * @return the re
     */
    @SuppressWarnings("unchecked")

    public <RE extends EntityQueryRelateExpression2RR<E, R1, R2, RC, RL, RS, QR, FC, FL, FS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, FC, FL, FS>,
            FC extends EntityQueryConditionGroupExpression3<E, R1, R2, FC, FL, FS, Tuple2<E, R2>>,
            FL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, FC, FL, FS, Tuple2<E, R2>>,
            FS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
            R2> RE join2(SerializableFunction2<R2, R1> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(1, queryRelation.getEntityRelationMapping(0).getIdName(),
                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return (RE) new EntitySqlQueryRelate2RR<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * Join 2.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param <R2>         the generic type
     * @param propertyName the property name
     * @return the re
     */
    @SuppressWarnings("unchecked")

    public <RE extends EntityQueryRelateExpression2RP<E, R1, R2, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QR extends EntityQueryRelatedFetchedExpression2RP<E, R1, R2, RC, RL, RS>,
            R2> RE join2(SerializableFunction1<R1, R2> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(1, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return (RE) new EntitySqlQueryRelate2RP<>(factory, sqlPageFactory, queryRelation);
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

    public <RE extends EntityQueryRelateExpression2RP<E, R1, R1, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R1, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R1, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R1, E>,
            QR extends EntityQueryRelatedFetchedExpression2RP<E, R1, R1, RC, RL, RS>> RE join2(
                    SerializableUnaryOperator1<R1> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(1, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return (RE) new EntitySqlQueryRelate2RP<>(factory, sqlPageFactory, queryRelation);
    }

}
