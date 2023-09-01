
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.relation;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate2FP;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelatedFetched2FP;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;

/**
 * The Class EntitySqlQueryRelate2FP.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 */
public class EntitySqlQueryRelate2FP<E, R1, R2> extends AbstractEntitySqlQueryRelate2FX<E, R1, R2, Tuple2<E, R1>>
        implements EntityQueryRelate2FP<E, R1, R2> {

    /**
     * Instantiates a new entity sql query relate 2 R.
     *
     * @param classMapping   the class mapping
     * @param jdbc           the jdbc
     * @param factory        the factory
     * @param sqlPageFactory the sql page factory
     * @param aliasManager   the alias manager
     * @param ignoreStrategy the ignore strategy
     */
    public EntitySqlQueryRelate2FP(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelatedFetched2FP<E, R1, R2> fetch() {
        queryRelation.fetchProperty(2); // 获取第三个查询实体（index = 2），并设置为对象属性
        return new EntitySqlQueryRelatedFetched2FP<>(this, factory, sqlPageFactory, queryRelation);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <QR extends EntityQueryRelateExpression3FRR<E, R1, R2, R3, RC, RL, RS, QRF, FC, FL, FS>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R1>>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R1>>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R1>>,
    //            QRF extends EntityQueryRelatedFetchedExpression3FRF<E, R1, R2, R3, FC, FL, FS>,
    //            FC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, FC, FL, FS, Tuple3<E, R1, R3>>,
    //            FL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, FC, FL, FS, Tuple3<E, R1, R3>>,
    //            FS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R1, R3>>,
    //            R3> EntityQueryRelatedExpression<E, R3, QR, QRF> join(Class<R3> joinType) {
    //        return new EntitySqlQueryRelated<>((QR) new EntitySqlQueryRelate3FRR<>(factory, sqlPageFactory, queryRelation),
    //                factory, queryRelation, joinType, 0);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression3FRP<E, R1, R2, R3, RC, RL, RS, QR>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R1>>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R1>>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R1>>,
    //            QR extends EntityQueryRelatedFetchedExpression3FRP<E, R1, R2, R3, RC, RL, RS>,
    //            R3> RE join(SerializableFunction1<E, R3> propertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
    //        queryRelation.join(0, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
    //        return (RE) new EntitySqlQueryRelate3FRP<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression3FRR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R1>>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R1>>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R1>>,
    //            QR extends EntityQueryRelatedFetchedExpression3FRF<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R1, R3>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R1, R3>>,
    //            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R1, R3>>,
    //            R3> RE join(SerializableFunction2<R3, E> propertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
    //        queryRelation.join(0, queryRelation.getEntityRelationMapping(0).getIdName(),
    //                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
    //        return (RE) new EntitySqlQueryRelate3FRR<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression3FRP<E, R1, R2, E, RC, RL, RS, QR>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, E, RC, RL, RS, Tuple2<E, R1>>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, E, RC, RL, RS, Tuple2<E, R1>>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, E, Tuple2<E, R1>>,
    //            QR extends EntityQueryRelatedFetchedExpression3FRP<E, R1, R2, E, RC, RL, RS>> RE join(
    //                    SerializableUnaryOperator1<E> propertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
    //        queryRelation.join(0, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
    //        return (RE) new EntitySqlQueryRelate3FRP<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <QR extends EntityQueryRelateExpression3FRR<E, R1, R2, R3, RC, RL, RS, QRF, FC, FL, FS>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R1>>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R1>>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R1>>,
    //            QRF extends EntityQueryRelatedFetchedExpression3FRF<E, R1, R2, R3, FC, FL, FS>,
    //            FC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, FC, FL, FS, Tuple3<E, R1, R3>>,
    //            FL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, FC, FL, FS, Tuple3<E, R1, R3>>,
    //            FS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R1, R3>>,
    //            R3> EntityQueryRelatedExpression<R1, R3, QR, QRF> join2(Class<R3> joinType) {
    //        return new EntitySqlQueryRelated<>((QR) new EntitySqlQueryRelate3FRR<>(factory, sqlPageFactory, queryRelation),
    //                factory, queryRelation, joinType, 1);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression3FRP<E, R1, R2, R3, RC, RL, RS, QR>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R1>>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R1>>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R1>>,
    //            QR extends EntityQueryRelatedFetchedExpression3FRP<E, R1, R2, R3, RC, RL, RS>,
    //            R3> RE join2(SerializableFunction1<R1, R3> propertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
    //        queryRelation.join(1, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
    //        return (RE) new EntitySqlQueryRelate3FRP<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression3FRR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R1>>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R1>>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R1>>,
    //            QR extends EntityQueryRelatedFetchedExpression3FRF<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R1, R3>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R1, R3>>,
    //            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R1, R3>>,
    //            R3> RE join2(SerializableFunction2<R3, R1> propertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
    //        queryRelation.join(1, queryRelation.getEntityRelationMapping(0).getIdName(),
    //                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
    //        return (RE) new EntitySqlQueryRelate3FRR<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression3FRP<E, R1, R2, R1, RC, RL, RS, QR>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R1, RC, RL, RS, Tuple2<E, R1>>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R1, RC, RL, RS, Tuple2<E, R1>>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R1, Tuple2<E, R1>>,
    //            QR extends EntityQueryRelatedFetchedExpression3FRP<E, R1, R2, R1, RC, RL, RS>> RE join2(
    //                    SerializableUnaryOperator1<R1> propertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
    //        queryRelation.join(1, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
    //        return (RE) new EntitySqlQueryRelate3FRP<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <QR extends EntityQueryRelateExpression3FRR<E, R1, R2, R3, RC, RL, RS, QRF, FC, FL, FS>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R1>>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R1>>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R1>>,
    //            QRF extends EntityQueryRelatedFetchedExpression3FRF<E, R1, R2, R3, FC, FL, FS>,
    //            FC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, FC, FL, FS, Tuple3<E, R1, R3>>,
    //            FL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, FC, FL, FS, Tuple3<E, R1, R3>>,
    //            FS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R1, R3>>,
    //            R3> EntityQueryRelatedExpression<R2, R3, QR, QRF> join3(Class<R3> joinType) {
    //        return new EntitySqlQueryRelated<>((QR) new EntitySqlQueryRelate3FRR<>(factory, sqlPageFactory, queryRelation),
    //                factory, queryRelation, joinType, 2);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression3FRP<E, R1, R2, R3, RC, RL, RS, QR>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R1>>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R1>>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R1>>,
    //            QR extends EntityQueryRelatedFetchedExpression3FRP<E, R1, R2, R3, RC, RL, RS>,
    //            R3> RE join3(SerializableFunction1<R2, R3> propertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
    //        queryRelation.join(2, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
    //        return (RE) new EntitySqlQueryRelate3FRP<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression3FRR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R1>>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R1>>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R1>>,
    //            QR extends EntityQueryRelatedFetchedExpression3FRF<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R1, R3>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R1, R3>>,
    //            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R1, R3>>,
    //            R3> RE join3(SerializableFunction2<R3, R2> propertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
    //        queryRelation.join(2, queryRelation.getEntityRelationMapping(0).getIdName(),
    //                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
    //        return (RE) new EntitySqlQueryRelate3FRR<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression3FRP<E, R1, R2, R2, RC, RL, RS, QR>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R2, RC, RL, RS, Tuple2<E, R1>>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R2, RC, RL, RS, Tuple2<E, R1>>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R2, Tuple2<E, R1>>,
    //            QR extends EntityQueryRelatedFetchedExpression3FRP<E, R1, R2, R2, RC, RL, RS>> RE join3(
    //                    SerializableUnaryOperator1<R2> propertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
    //        queryRelation.join(2, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
    //        return (RE) new EntitySqlQueryRelate3FRP<>(factory, sqlPageFactory, queryRelation);
    //    }
}
