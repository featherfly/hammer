
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.lang.function.SerializableFunction1;
import cn.featherfly.common.lang.function.SerializableFunction2;
import cn.featherfly.common.lang.function.SerializableFunction3;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryFetchedProperty;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression2;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression2;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression2;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelateExpression;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelateExpression1P;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedExpression;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedFetchedExpression;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedFetchedExpression1P;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.relation.EntitySqlQueryRelate;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.relation.EntitySqlQueryRelated;

/**
 * The Class AbstractEntitySqlQueryFetch.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <P> the generic type
 */
public abstract class AbstractEntitySqlQueryFetch<E, P extends EntityQueryFetchedProperty<E>>
        extends AbstractEntitySqlQueryProperties<E, P> {

    /**
     * Instantiates a new abstract entity sql query fetched.
     *
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    protected AbstractEntitySqlQueryFetch(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
    }

    @SuppressWarnings("unchecked")
    public <QR extends EntityQueryRelateExpression<E, R, RC, RL, RS, QRF, FC, FL, FS>,
            RC extends EntityQueryConditionGroupExpression2<E, R, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression2<E, R, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression2<E, R, E>,
            QRF extends EntityQueryRelatedFetchedExpression<E, R, FC, FL, FS>,
            FC extends EntityQueryConditionGroupExpression2<E, R, FC, FL, FS, Tuple2<E, R>>,
            FL extends EntityQueryConditionGroupLogicExpression2<E, R, FC, FL, FS, Tuple2<E, R>>,
            FS extends EntityQuerySortExpression2<E, R, Tuple2<E, R>>,
            R> EntityQueryRelatedExpression<E, R, QR, QRF> join(Class<R> joinType) {
        return new EntitySqlQueryRelated<>((QR) new EntitySqlQueryRelate<>(factory, sqlPageFactory, queryRelation),
                factory, queryRelation, joinType, 0);
    }

    //    @SuppressWarnings("unchecked")
    //    public <RE extends EntityQueryRelateExpression<E, R, RC, RL, RS, QR, FC, FL, FS>,
    //            RC extends EntityQueryConditionGroupExpression2<E, R, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression2<E, R, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression2<E, R, E>,
    //            QR extends EntityQueryRelatedFetchedExpression<E, R, FC, FL, FS>,
    //            FC extends EntityQueryConditionGroupExpression2<E, R, FC, FL, FS, Tuple2<E, R>>,
    //            FL extends EntityQueryConditionGroupLogicExpression2<E, R, FC, FL, FS, Tuple2<E, R>>,
    //            FS extends EntityQuerySortExpression2<E, R, Tuple2<E, R>>, J,
    //            R> RE join(SerializableFunction1<E, J> propertyName, Class<R> joinType) {
    //        queryRelation.join(0, getPropertyName(propertyName), factory.getClassMapping(joinType));
    //        return (RE) new EntitySqlQueryRelate<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    @SuppressWarnings("unchecked")
    //    public <RE extends EntityQueryRelateExpression<E, R, RC, RL, RS, QR, FC, FL, FS>,
    //            RC extends EntityQueryConditionGroupExpression2<E, R, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression2<E, R, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression2<E, R, E>,
    //            QR extends EntityQueryRelatedFetchedExpression<E, R, FC, FL, FS>,
    //            FC extends EntityQueryConditionGroupExpression2<E, R, FC, FL, FS, Tuple2<E, R>>,
    //            FL extends EntityQueryConditionGroupLogicExpression2<E, R, FC, FL, FS, Tuple2<E, R>>,
    //            FS extends EntityQuerySortExpression2<E, R, Tuple2<E, R>>, J extends Number,
    //            R> RE join(SerializableToNumberFunction1<E, J> propertyName,
    //                    SerializableToNumberFunction1<R, J> joinTypePropertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
    //        queryRelation.join(0, getPropertyName(propertyName),
    //                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
    //        return (RE) new EntitySqlQueryRelate<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    @SuppressWarnings("unchecked")
    //    public <RE extends EntityQueryRelateExpression<E, R, RC, RL, RS, QR, FC, FL, FS>,
    //            RC extends EntityQueryConditionGroupExpression2<E, R, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression2<E, R, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression2<E, R, E>,
    //            QR extends EntityQueryRelatedFetchedExpression<E, R, FC, FL, FS>,
    //            FC extends EntityQueryConditionGroupExpression2<E, R, FC, FL, FS, Tuple2<E, R>>,
    //            FL extends EntityQueryConditionGroupLogicExpression2<E, R, FC, FL, FS, Tuple2<E, R>>,
    //            FS extends EntityQuerySortExpression2<E, R, Tuple2<E, R>>,
    //            R> RE join(SerializableToStringFunction1<E> propertyName,
    //                    SerializableToStringFunction1<R> joinTypePropertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
    //        queryRelation.join(0, getPropertyName(propertyName),
    //                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
    //        return (RE) new EntitySqlQueryRelate<>(factory, sqlPageFactory, queryRelation);
    //    }

    //    @SuppressWarnings("unchecked")
    //    public <RE extends EntityQueryRelateExpression<E, R, RC, RL, RS, QR, FC, FL, FS>,
    //            RC extends EntityQueryConditionGroupExpression2<E, R, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression2<E, R, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression2<E, R, E>,
    //            QR extends EntityQueryRelatedFetchedExpression<E, R, FC, FL, FS>,
    //            FC extends EntityQueryConditionGroupExpression2<E, R, FC, FL, FS, Tuple2<E, R>>,
    //            FL extends EntityQueryConditionGroupLogicExpression2<E, R, FC, FL, FS, Tuple2<E, R>>,
    //            FS extends EntityQuerySortExpression2<E, R, Tuple2<E, R>>, R,
    //            J extends Number> RE join(SerializableToNumberFunction1<R, J> joinTypePropertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
    //        queryRelation.join(0, factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())),
    //                info.getPropertyName());
    //        return (RE) new EntitySqlQueryRelate<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    @SuppressWarnings("unchecked")
    //    public <RE extends EntityQueryRelateExpression<E, R, RC, RL, RS, QR, FC, FL, FS>,
    //            RC extends EntityQueryConditionGroupExpression2<E, R, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression2<E, R, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression2<E, R, E>,
    //            QR extends EntityQueryRelatedFetchedExpression<E, R, FC, FL, FS>,
    //            FC extends EntityQueryConditionGroupExpression2<E, R, FC, FL, FS, Tuple2<E, R>>,
    //            FL extends EntityQueryConditionGroupLogicExpression2<E, R, FC, FL, FS, Tuple2<E, R>>,
    //            FS extends EntityQuerySortExpression2<E, R, Tuple2<E, R>>,
    //            R> RE join(SerializableToStringFunction1<R> joinTypePropertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
    //        queryRelation.join(0, factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())),
    //                info.getPropertyName());
    //        return (RE) new EntitySqlQueryRelate<>(factory, sqlPageFactory, queryRelation);
    //    }

    public <RE extends EntityQueryRelateExpression1P<E, R, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression2<E, R, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression2<E, R, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression2<E, R, E>,
            QR extends EntityQueryRelatedFetchedExpression1P<E, R, RC, RL, RS>,
            R> RE join(SerializableFunction1<E, R> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    public <RE extends EntityQueryRelateExpression1P<E, R, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression2<E, R, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression2<E, R, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression2<E, R, E>,
            QR extends EntityQueryRelatedFetchedExpression1P<E, R, RC, RL, RS>,
            R> RE join(SerializableFunction2<R, E> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    public <RE extends EntityQueryRelateExpression1P<E, E, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression2<E, E, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression2<E, E, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression2<E, E, E>,
            QR extends EntityQueryRelatedFetchedExpression1P<E, E, RC, RL, RS>> RE join(
                    SerializableFunction3<E, E> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }
}
