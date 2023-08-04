//
///*
// * All rights Reserved, Designed By zhongj
// * @Title: EntitySqlQueryRelate3FF.java
// * @Package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query
// * @Description: EntitySqlQueryRelate3FF
// * @author: zhongj
// * @date: 2023-07-14 16:01:14
// * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
// */
//package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query;
//
//import java.util.function.Consumer;
//
//import com.speedment.common.tuple.Tuple2;
//
//import cn.featherfly.common.lang.function.SerializableFunction1;
//import cn.featherfly.common.lang.function.SerializableFunction2;
//import cn.featherfly.common.lang.function.SerializableFunction3;
//import cn.featherfly.common.lang.function.SerializableFunction4;
//import cn.featherfly.hammer.dsl.query.type.EntityQueryConditionGroup4;
//import cn.featherfly.hammer.dsl.query.type.EntityQueryRelate3RR;
//import cn.featherfly.hammer.dsl.query.type.EntityQueryRelatedFetched3RRF;
//import cn.featherfly.hammer.expression.condition.ConditionGroupConfig;
//import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression5;
//import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression5;
//import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression4;
//import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression5;
//import cn.featherfly.hammer.expression.query.type.EntityQueryRelateExpression4RRR;
//import cn.featherfly.hammer.expression.query.type.EntityQueryRelatedFetchedExpression4RRRF;
//
///**
// * The Class EntitySqlQueryRelate3RR.
// *
// * @author zhongj
// * @param <E>  the element type
// * @param <R1> the generic type
// * @param <R2> the generic type
// * @param <R3> the generic type
// */
//public class EntitySqlQueryRelate3RR<E, R1, R2, R3> extends AbstractEntitySqlQueryRelate<E, R1, E>
//        implements EntityQueryRelate3RR<E, R1, R2, R3> {
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <RE extends EntityQueryRelateExpression4RRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
//            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, E>,
//            QR extends EntityQueryRelatedFetchedExpression4RRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
//            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
//            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
//            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R4>>, R4,
//            J> RE join(SerializableFunction1<E, J> propertyName, Class<R4> joinType) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <RE extends EntityQueryRelateExpression4RRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
//            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, E>,
//            QR extends EntityQueryRelatedFetchedExpression4RRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
//            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
//            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
//            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R4>>, R4,
//            J> RE join(SerializableFunction1<E, J> propertyName, SerializableFunction1<R4, J> joinTypePropertyName) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <RE extends EntityQueryRelateExpression4RRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
//            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, E>,
//            QR extends EntityQueryRelatedFetchedExpression4RRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
//            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
//            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
//            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R4>>, R4,
//            J> RE join(SerializableFunction4<R4, J> joinTypePropertyName) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <RE extends EntityQueryRelateExpression4RRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
//            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, E>,
//            QR extends EntityQueryRelatedFetchedExpression4RRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
//            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
//            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
//            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R4>>,
//            R4> RE join(SerializableFunction1<E, R4> propertyName) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <RE extends EntityQueryRelateExpression4RRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
//            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, E>,
//            QR extends EntityQueryRelatedFetchedExpression4RRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
//            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
//            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
//            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R4>>,
//            R4> RE join(SerializableFunction2<R4, E> propertyName) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <RE extends EntityQueryRelateExpression4RRR<E, R1, R2, R3, E, RC, RL, RS, QR, QRC, QRL, QRS>,
//            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, E, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, E, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression5<E, R1, R2, R3, E, E>,
//            QR extends EntityQueryRelatedFetchedExpression4RRRF<E, R1, R2, R3, E, QRC, QRL, QRS>,
//            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, E, QRC, QRL, QRS, Tuple2<E, E>>,
//            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, E, QRC, QRL, QRS, Tuple2<E, E>>,
//            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, E, Tuple2<E, E>>> RE join(
//                    SerializableFunction3<E, E> propertyName) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <RE extends EntityQueryRelateExpression4RRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
//            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, E>,
//            QR extends EntityQueryRelatedFetchedExpression4RRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
//            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
//            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
//            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R4>>, R4,
//            J> RE join2(SerializableFunction1<R1, J> propertyName, Class<R4> joinType) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <RE extends EntityQueryRelateExpression4RRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
//            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, E>,
//            QR extends EntityQueryRelatedFetchedExpression4RRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
//            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
//            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
//            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R4>>, R4,
//            J> RE join2(SerializableFunction1<R1, J> propertyName, SerializableFunction1<R4, J> joinTypePropertyName) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <RE extends EntityQueryRelateExpression4RRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
//            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, E>,
//            QR extends EntityQueryRelatedFetchedExpression4RRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
//            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
//            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
//            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R4>>, R4,
//            J> RE join2(SerializableFunction4<R4, J> joinTypePropertyName) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <RE extends EntityQueryRelateExpression4RRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
//            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, E>,
//            QR extends EntityQueryRelatedFetchedExpression4RRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
//            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
//            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
//            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R4>>,
//            R4> RE join2(SerializableFunction1<R1, R4> propertyName) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <RE extends EntityQueryRelateExpression4RRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
//            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, E>,
//            QR extends EntityQueryRelatedFetchedExpression4RRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
//            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
//            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
//            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R4>>,
//            R4> RE join2(SerializableFunction2<R4, R1> propertyName) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <RE extends EntityQueryRelateExpression4RRR<E, R1, R2, R3, R1, RC, RL, RS, QR, QRC, QRL, QRS>,
//            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R1, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R1, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R1, E>,
//            QR extends EntityQueryRelatedFetchedExpression4RRRF<E, R1, R2, R3, R1, QRC, QRL, QRS>,
//            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R1, QRC, QRL, QRS, Tuple2<E, R1>>,
//            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R1, QRC, QRL, QRS, Tuple2<E, R1>>,
//            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R1, Tuple2<E, R1>>> RE join2(
//                    SerializableFunction3<R1, R1> propertyName) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <RE extends EntityQueryRelateExpression4RRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
//            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, E>,
//            QR extends EntityQueryRelatedFetchedExpression4RRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
//            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
//            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
//            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R4>>, R4,
//            J> RE join3(SerializableFunction1<R2, J> propertyName, Class<R4> joinType) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <RE extends EntityQueryRelateExpression4RRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
//            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, E>,
//            QR extends EntityQueryRelatedFetchedExpression4RRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
//            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
//            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
//            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R4>>, R4,
//            J> RE join3(SerializableFunction1<R2, J> propertyName, SerializableFunction1<R4, J> joinTypePropertyName) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <RE extends EntityQueryRelateExpression4RRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
//            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, E>,
//            QR extends EntityQueryRelatedFetchedExpression4RRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
//            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
//            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
//            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R4>>, R4,
//            J> RE join3(SerializableFunction4<R4, J> joinTypePropertyName) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <RE extends EntityQueryRelateExpression4RRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
//            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, E>,
//            QR extends EntityQueryRelatedFetchedExpression4RRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
//            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
//            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
//            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R4>>,
//            R4> RE join3(SerializableFunction1<R2, R4> propertyName) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <RE extends EntityQueryRelateExpression4RRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
//            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, E>,
//            QR extends EntityQueryRelatedFetchedExpression4RRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
//            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
//            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
//            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R4>>,
//            R4> RE join3(SerializableFunction2<R4, R2> propertyName) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <RE extends EntityQueryRelateExpression4RRR<E, R1, R2, R3, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
//            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R2, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R2, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R2, E>,
//            QR extends EntityQueryRelatedFetchedExpression4RRRF<E, R1, R2, R3, R2, QRC, QRL, QRS>,
//            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
//            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
//            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R2, Tuple2<E, R2>>> RE join3(
//                    SerializableFunction3<R2, R2> propertyName) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <RE extends EntityQueryRelateExpression4RRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
//            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, E>,
//            QR extends EntityQueryRelatedFetchedExpression4RRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
//            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
//            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
//            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R4>>, R4,
//            J> RE join4(SerializableFunction1<R3, J> propertyName, Class<R4> joinType) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <RE extends EntityQueryRelateExpression4RRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
//            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, E>,
//            QR extends EntityQueryRelatedFetchedExpression4RRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
//            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
//            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
//            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R4>>, R4,
//            J> RE join4(SerializableFunction1<R3, J> propertyName, SerializableFunction1<R4, J> joinTypePropertyName) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <RE extends EntityQueryRelateExpression4RRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
//            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, E>,
//            QR extends EntityQueryRelatedFetchedExpression4RRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
//            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
//            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
//            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R4>>, R4,
//            J> RE join4(SerializableFunction4<R4, J> joinTypePropertyName) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <RE extends EntityQueryRelateExpression4RRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
//            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, E>,
//            QR extends EntityQueryRelatedFetchedExpression4RRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
//            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
//            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
//            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R4>>,
//            R4> RE join4(SerializableFunction1<R3, R4> propertyName) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <RE extends EntityQueryRelateExpression4RRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
//            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, E>,
//            QR extends EntityQueryRelatedFetchedExpression4RRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
//            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
//            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
//            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R4>>,
//            R4> RE join4(SerializableFunction2<R4, R3> propertyName) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <RE extends EntityQueryRelateExpression4RRR<E, R1, R2, R3, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
//            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R3, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R3, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R3, E>,
//            QR extends EntityQueryRelatedFetchedExpression4RRRF<E, R1, R2, R3, R3, QRC, QRL, QRS>,
//            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
//            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
//            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R3, Tuple2<E, R3>>> RE join4(
//                    SerializableFunction3<R3, R3> propertyName) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public EntityQueryConditionGroup4<E, R1, R2, R3, E> where() {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public EntityQueryConditionGroup4<E, R1, R2, R3, E> where(
//            Consumer<ConditionGroupConfig<EntityQueryConditionGroup4<E, R1, R2, R3, E>>> consumer) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public EntityQuerySortExpression4<E, R1, R2, R3, E> sort() {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public EntityQueryRelatedFetched3RRF<E, R1, R2, R3> fetch() {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//}
