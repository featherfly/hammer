
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntitySqlQueryRelatedFetched.java
 * @Package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query
 * @Description: EntitySqlQueryRelatedFetched
 * @author: zhongj
 * @date: 2023-07-14 15:58:14
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.relation;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuple3;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.lang.function.SerializableFunction1;
import cn.featherfly.common.lang.function.SerializableFunction2;
import cn.featherfly.common.lang.function.SerializableFunction3;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelatedFetched;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression3;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelateExpression2F;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedExpression;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedFetchedExpression2FF;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.AbstractEntitySqlQueryFetch2;

/**
 * The Class EntitySqlQueryRelatedFetched.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 */
public class EntitySqlQueryRelatedFetched<E, R1> extends AbstractEntitySqlQueryFetch2<E, R1, Tuple2<E, R1>>
        implements EntityQueryRelatedFetched<E, R1> {

    /**
     * @param factory
     * @param sqlPageFactory
     * @param entitySqlQueryRelation
     */
    public EntitySqlQueryRelatedFetched(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <QR extends EntityQueryRelateExpression2F<E, R1, R2, RC, RL, RS, QRF, FC, FL, FS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R1>>,
            QRF extends EntityQueryRelatedFetchedExpression2FF<E, R1, R2, FC, FL, FS>,
            FC extends EntityQueryConditionGroupExpression3<E, R1, R2, FC, FL, FS, Tuple3<E, R1, R2>>,
            FL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, FC, FL, FS, Tuple3<E, R1, R2>>,
            FS extends EntityQuerySortExpression3<E, R1, R2, Tuple3<E, R1, R2>>, R2,
            J> EntityQueryRelatedExpression<E, R2, QR, QRF> join(Class<R2> joinType) {
        return new EntitySqlQueryRelated<>((QR) new EntitySqlQueryRelate2F<>(factory, sqlPageFactory, queryRelation),
                factory, queryRelation, joinType, 0);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression2F<E, R1, R2, RC, RL, RS, QR, FC, FL, FS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, Tuple2<E, R1>>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, Tuple2<E, R1>>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R1>>,
    //            QR extends EntityQueryRelatedFetchedExpression2FF<E, R1, R2, FC, FL, FS>,
    //            FC extends EntityQueryConditionGroupExpression3<E, R1, R2, FC, FL, FS, Tuple3<E, R1, R2>>,
    //            FL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, FC, FL, FS, Tuple3<E, R1, R2>>,
    //            FS extends EntityQuerySortExpression3<E, R1, R2, Tuple3<E, R1, R2>>, R2,
    //            J> RE join(SerializableFunction1<E, J> propertyName, Class<R2> joinType) {
    //        queryRelation.join(0, getPropertyName(propertyName), factory.getClassMapping(joinType));
    //        return (RE) new EntitySqlQueryRelate2F<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression2F<E, R1, R2, RC, RL, RS, QR, FC, FL, FS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, Tuple2<E, R1>>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, Tuple2<E, R1>>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R1>>,
    //            QR extends EntityQueryRelatedFetchedExpression2FF<E, R1, R2, FC, FL, FS>,
    //            FC extends EntityQueryConditionGroupExpression3<E, R1, R2, FC, FL, FS, Tuple3<E, R1, R2>>,
    //            FL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, FC, FL, FS, Tuple3<E, R1, R2>>,
    //            FS extends EntityQuerySortExpression3<E, R1, R2, Tuple3<E, R1, R2>>, R2,
    //            J> RE join(SerializableFunction1<E, J> propertyName, SerializableFunction1<R2, J> joinTypePropertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
    //        queryRelation.join(0, getPropertyName(propertyName),
    //                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
    //        return (RE) new EntitySqlQueryRelate2F<>(factory, sqlPageFactory, queryRelation);
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression2F<E, R1, R2, RC, RL, RS, QR, FC, FL, FS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, Tuple2<E, R1>>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, Tuple2<E, R1>>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R1>>,
    //            QR extends EntityQueryRelatedFetchedExpression2FF<E, R1, R2, FC, FL, FS>,
    //            FC extends EntityQueryConditionGroupExpression3<E, R1, R2, FC, FL, FS, Tuple3<E, R1, R2>>,
    //            FL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, FC, FL, FS, Tuple3<E, R1, R2>>,
    //            FS extends EntityQuerySortExpression3<E, R1, R2, Tuple3<E, R1, R2>>, R2,
    //            J> RE join(SerializableFunction4<R2, J> joinTypePropertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
    //        queryRelation.join(0, factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())),
    //                info.getPropertyName());
    //        return (RE) new EntitySqlQueryRelate2F<>(factory, sqlPageFactory, queryRelation);
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression2F<E, R1, R2, RC, RL, RS, QR, FC, FL, FS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression2FF<E, R1, R2, FC, FL, FS>,
            FC extends EntityQueryConditionGroupExpression3<E, R1, R2, FC, FL, FS, Tuple3<E, R1, R2>>,
            FL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, FC, FL, FS, Tuple3<E, R1, R2>>,
            FS extends EntityQuerySortExpression3<E, R1, R2, Tuple3<E, R1, R2>>,
            R2> RE join(SerializableFunction1<E, R2> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression2F<E, R1, R2, RC, RL, RS, QR, FC, FL, FS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression2FF<E, R1, R2, FC, FL, FS>,
            FC extends EntityQueryConditionGroupExpression3<E, R1, R2, FC, FL, FS, Tuple3<E, R1, R2>>,
            FL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, FC, FL, FS, Tuple3<E, R1, R2>>,
            FS extends EntityQuerySortExpression3<E, R1, R2, Tuple3<E, R1, R2>>,
            R2> RE join(SerializableFunction2<R2, E> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression2F<E, R1, E, RC, RL, RS, QR, FC, FL, FS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, E, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, E, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression3<E, R1, E, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression2FF<E, R1, E, FC, FL, FS>,
            FC extends EntityQueryConditionGroupExpression3<E, R1, E, FC, FL, FS, Tuple3<E, R1, E>>,
            FL extends EntityQueryConditionGroupLogicExpression3<E, R1, E, FC, FL, FS, Tuple3<E, R1, E>>,
            FS extends EntityQuerySortExpression3<E, R1, E, Tuple3<E, R1, E>>> RE join(
                    SerializableFunction3<E, E> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    // ****************************************************************************************************************
    //	join 2
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <QR extends EntityQueryRelateExpression2F<E, R1, R2, RC, RL, RS, QRF, FC, FL, FS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R1>>,
            QRF extends EntityQueryRelatedFetchedExpression2FF<E, R1, R2, FC, FL, FS>,
            FC extends EntityQueryConditionGroupExpression3<E, R1, R2, FC, FL, FS, Tuple3<E, R1, R2>>,
            FL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, FC, FL, FS, Tuple3<E, R1, R2>>,
            FS extends EntityQuerySortExpression3<E, R1, R2, Tuple3<E, R1, R2>>, R2,
            J> EntityQueryRelatedExpression<R1, R2, QR, QRF> join2(Class<R2> joinType) {
        return new EntitySqlQueryRelated<>((QR) new EntitySqlQueryRelate2F<>(factory, sqlPageFactory, queryRelation),
                factory, queryRelation, joinType, 1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression2F<E, R1, R2, RC, RL, RS, QR, FC, FL, FS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression2FF<E, R1, R2, FC, FL, FS>,
            FC extends EntityQueryConditionGroupExpression3<E, R1, R2, FC, FL, FS, Tuple3<E, R1, R2>>,
            FL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, FC, FL, FS, Tuple3<E, R1, R2>>,
            FS extends EntityQuerySortExpression3<E, R1, R2, Tuple3<E, R1, R2>>,
            R2> RE join2(SerializableFunction1<R1, R2> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression2F<E, R1, R2, RC, RL, RS, QR, FC, FL, FS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression2FF<E, R1, R2, FC, FL, FS>,
            FC extends EntityQueryConditionGroupExpression3<E, R1, R2, FC, FL, FS, Tuple3<E, R1, R2>>,
            FL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, FC, FL, FS, Tuple3<E, R1, R2>>,
            FS extends EntityQuerySortExpression3<E, R1, R2, Tuple3<E, R1, R2>>,
            R2> RE join2(SerializableFunction2<R2, R1> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression2F<E, R1, R1, RC, RL, RS, QR, FC, FL, FS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R1, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R1, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression3<E, R1, R1, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression2FF<E, R1, R1, FC, FL, FS>,
            FC extends EntityQueryConditionGroupExpression3<E, R1, R1, FC, FL, FS, Tuple3<E, R1, R1>>,
            FL extends EntityQueryConditionGroupLogicExpression3<E, R1, R1, FC, FL, FS, Tuple3<E, R1, R1>>,
            FS extends EntityQuerySortExpression3<E, R1, R1, Tuple3<E, R1, R1>>> RE join2(
                    SerializableFunction3<R1, R1> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression2F<E, R1, R2, RC, RL, RS, QR, FC, FL, FS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, Tuple2<E, R1>>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, Tuple2<E, R1>>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R1>>,
    //            QR extends EntityQueryRelatedFetchedExpression2FF<E, R1, R2, FC, FL, FS>,
    //            FC extends EntityQueryConditionGroupExpression3<E, R1, R2, FC, FL, FS, Tuple3<E, R1, R2>>,
    //            FL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, FC, FL, FS, Tuple3<E, R1, R2>>,
    //            FS extends EntityQuerySortExpression3<E, R1, R2, Tuple3<E, R1, R2>>, R2,
    //            J> RE join2(SerializableFunction1<R1, J> propertyName, Class<R2> joinType) {
    //        queryRelation.join(1, getPropertyName(propertyName), factory.getClassMapping(joinType));
    //        return (RE) new EntitySqlQueryRelate2F<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression2F<E, R1, R2, RC, RL, RS, QR, FC, FL, FS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, Tuple2<E, R1>>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, Tuple2<E, R1>>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R1>>,
    //            QR extends EntityQueryRelatedFetchedExpression2FF<E, R1, R2, FC, FL, FS>,
    //            FC extends EntityQueryConditionGroupExpression3<E, R1, R2, FC, FL, FS, Tuple3<E, R1, R2>>,
    //            FL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, FC, FL, FS, Tuple3<E, R1, R2>>,
    //            FS extends EntityQuerySortExpression3<E, R1, R2, Tuple3<E, R1, R2>>, R2,
    //            J> RE join2(SerializableFunction1<R1, J> propertyName, SerializableFunction1<R2, J> joinTypePropertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
    //        queryRelation.join(1, getPropertyName(propertyName),
    //                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
    //        return (RE) new EntitySqlQueryRelate2F<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression2F<E, R1, R2, RC, RL, RS, QR, FC, FL, FS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, Tuple2<E, R1>>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, Tuple2<E, R1>>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R1>>,
    //            QR extends EntityQueryRelatedFetchedExpression2FF<E, R1, R2, FC, FL, FS>,
    //            FC extends EntityQueryConditionGroupExpression3<E, R1, R2, FC, FL, FS, Tuple3<E, R1, R2>>,
    //            FL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, FC, FL, FS, Tuple3<E, R1, R2>>,
    //            FS extends EntityQuerySortExpression3<E, R1, R2, Tuple3<E, R1, R2>>, R2,
    //            J> RE join2(SerializableFunction4<R2, J> joinTypePropertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
    //        queryRelation.join(1, factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())),
    //                info.getPropertyName());
    //        return (RE) new EntitySqlQueryRelate2F<>(factory, sqlPageFactory, queryRelation);
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public EntityQueryConditionGroup2<E, R1, Tuple2<E, R1>> where() {
    //        return new EntitySqlQueryExpression2<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public EntityQueryConditionGroup2<E, R1, Tuple2<E, R1>> where(
    //            Consumer<ConditionGroupConfig<EntityQueryConditionGroup2<E, R1, Tuple2<E, R1>>>> consumer) {
    //        EntitySqlQueryExpression2<E, R1,
    //                Tuple2<E, R1>> exp = new EntitySqlQueryExpression2<>(factory, sqlPageFactory, queryRelation);
    //        if (consumer != null) {
    //            consumer.accept(exp);
    //        }
    //        return exp;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public EntityQuerySortExpression2<E, R1, Tuple2<E, R1>> sort() {
    //        return new EntitySqlQueryExpression2<>(factory, sqlPageFactory, queryRelation);
    //    }
}
