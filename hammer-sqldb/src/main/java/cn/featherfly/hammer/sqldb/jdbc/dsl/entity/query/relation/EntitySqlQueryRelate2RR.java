
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.relation;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate2RR;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelatedFetched2RF;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;

/**
 * The Class EntitySqlQueryRelate2RR.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 */
public class EntitySqlQueryRelate2RR<E, R1, R2> extends AbstractEntitySqlQueryRelate2RX<E, R1, R2, E>
        implements EntityQueryRelate2RR<E, R1, R2> {

    /**
     * Instantiates a new entity sql query relate 2 RR.
     *
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    public EntitySqlQueryRelate2RR(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelatedFetched2RF<E, R1, R2> fetch() {
        queryRelation.fetch(2); // 获取第三个查询实体（index = 2）
        return new EntitySqlQueryRelatedFetched2RF<>(factory, sqlPageFactory, queryRelation);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <QR extends EntityQueryRelateExpression3RRR<E, R1, R2, R3, RC, RL, RS, QRF, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
    //            QRF extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>,
    //            R3> EntityQueryRelatedExpression<E, R3, QR, QRF> join(Class<R3> joinType) {
    //        return new EntitySqlQueryRelated<>((QR) new EntitySqlQueryRelate3RRR<>(factory, sqlPageFactory, queryRelation),
    //                factory, queryRelation, joinType, 0);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression3RRR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
    //            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>,
    //            R3> RE join(SerializableFunction2<R3, E> propertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
    //        queryRelation.join(0, queryRelation.getEntityRelationMapping(0).getIdName(),
    //                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
    //        return (RE) new EntitySqlQueryRelate3RRR<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression3RRP<E, R1, R2, R3, RC, RL, RS, QR>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
    //            QR extends EntityQueryRelatedFetchedExpression3RRP<E, R1, R2, R3, RC, RL, RS>,
    //            R3> RE join(SerializableFunction1<E, R3> propertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
    //        queryRelation.join(0, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
    //        return (RE) new EntitySqlQueryRelate3RRP<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression3RRP<E, R1, R2, E, RC, RL, RS, QR>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, E, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, E, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, E, E>,
    //            QR extends EntityQueryRelatedFetchedExpression3RRP<E, R1, R2, E, RC, RL, RS>> RE join(
    //                    SerializableUnaryOperator1<E> propertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
    //        queryRelation.join(0, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
    //        return (RE) new EntitySqlQueryRelate3RRP<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    // ****************************************************************************************************************
    //    //	2
    //    // ****************************************************************************************************************
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <QR extends EntityQueryRelateExpression3RRR<E, R1, R2, R3, RC, RL, RS, QRF, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
    //            QRF extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>,
    //            R3> EntityQueryRelatedExpression<R1, R3, QR, QRF> join2(Class<R3> joinType) {
    //        return new EntitySqlQueryRelated<>((QR) new EntitySqlQueryRelate3RRR<>(factory, sqlPageFactory, queryRelation),
    //                factory, queryRelation, joinType, 1);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression3RRR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
    //            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>,
    //            R3> RE join2(SerializableFunction2<R3, R1> propertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
    //        queryRelation.join(1, queryRelation.getEntityRelationMapping(0).getIdName(),
    //                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
    //        return (RE) new EntitySqlQueryRelate3RRR<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression3RRP<E, R1, R2, R3, RC, RL, RS, QR>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
    //            QR extends EntityQueryRelatedFetchedExpression3RRP<E, R1, R2, R3, RC, RL, RS>,
    //            R3> RE join2(SerializableFunction1<R1, R3> propertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
    //        queryRelation.join(1, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
    //        return (RE) new EntitySqlQueryRelate3RRP<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression3RRP<E, R1, R2, R1, RC, RL, RS, QR>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R1, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R1, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R1, E>,
    //            QR extends EntityQueryRelatedFetchedExpression3RRP<E, R1, R2, R1, RC, RL, RS>> RE join2(
    //                    SerializableUnaryOperator1<R1> propertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
    //        queryRelation.join(1, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
    //        return (RE) new EntitySqlQueryRelate3RRP<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    // ****************************************************************************************************************
    //    //	3
    //    // ****************************************************************************************************************
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <QR extends EntityQueryRelateExpression3RRR<E, R1, R2, R3, RC, RL, RS, QRF, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
    //            QRF extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>,
    //            R3> EntityQueryRelatedExpression<R2, R3, QR, QRF> join3(Class<R3> joinType) {
    //        return new EntitySqlQueryRelated<>((QR) new EntitySqlQueryRelate3RRR<>(factory, sqlPageFactory, queryRelation),
    //                factory, queryRelation, joinType, 2);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression3RRR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
    //            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>,
    //            R3> RE join3(SerializableFunction2<R3, R2> propertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
    //        queryRelation.join(2, queryRelation.getEntityRelationMapping(0).getIdName(),
    //                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
    //        return (RE) new EntitySqlQueryRelate3RRR<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression3RRP<E, R1, R2, R3, RC, RL, RS, QR>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
    //            QR extends EntityQueryRelatedFetchedExpression3RRP<E, R1, R2, R3, RC, RL, RS>,
    //            R3> RE join3(SerializableFunction1<R2, R3> propertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
    //        queryRelation.join(2, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
    //        return (RE) new EntitySqlQueryRelate3RRP<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression3RRP<E, R1, R2, R2, RC, RL, RS, QR>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R2, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R2, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R2, E>,
    //            QR extends EntityQueryRelatedFetchedExpression3RRP<E, R1, R2, R2, RC, RL, RS>> RE join3(
    //                    SerializableUnaryOperator1<R2> propertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
    //        queryRelation.join(2, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
    //        return (RE) new EntitySqlQueryRelate3RRP<>(factory, sqlPageFactory, queryRelation);
    //    }

}
