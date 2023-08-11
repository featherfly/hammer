
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.relation;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.lang.function.SerializableFunction1;
import cn.featherfly.common.lang.function.SerializableFunction2;
import cn.featherfly.common.lang.function.SerializableFunction3;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate2R;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelatedFetched2RF;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression4;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelateExpression3RR;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedExpression;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedFetchedExpression3RRF;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.AbstractEntitySqlQueryFetch3;

/**
 * The Class EntitySqlQueryRelate2R.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 */
public class EntitySqlQueryRelate2R<E, R1, R2> extends AbstractEntitySqlQueryFetch3<E, R1, R2, E>
        implements EntityQueryRelate2R<E, R1, R2> {

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
    public EntitySqlQueryRelate2R(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <QR extends EntityQueryRelateExpression3RR<E, R1, R2, R3, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
            QRF extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>,
            R3> EntityQueryRelatedExpression<E, R3, QR, QRF> join(Class<R3> joinType) {
        return new EntitySqlQueryRelated<>((QR) new EntitySqlQueryRelate3RR<>(factory, sqlPageFactory, queryRelation),
                factory, queryRelation, joinType, 0);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression3RR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
    //            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>, R3,
    //            J> RE join(SerializableFunction1<E, J> propertyName, Class<R3> joinType) {
    //        queryRelation.join(0, getPropertyName(propertyName), factory.getClassMapping(joinType));
    //        return (RE) new EntitySqlQueryRelate3RR<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression3RR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
    //            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>, R3,
    //            J> RE join(SerializableFunction1<E, J> propertyName, SerializableFunction1<R3, J> joinTypePropertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
    //        queryRelation.join(0, getPropertyName(propertyName),
    //                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
    //        return (RE) new EntitySqlQueryRelate3RR<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression3RR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
    //            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>, R3,
    //            J> RE join(SerializableFunction4<R3, J> joinTypePropertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
    //        queryRelation.join(0, factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())),
    //                info.getPropertyName());
    //        return (RE) new EntitySqlQueryRelate3RR<>(factory, sqlPageFactory, queryRelation);
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression3RR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>,
            R3> RE join(SerializableFunction1<E, R3> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression3RR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>,
            R3> RE join(SerializableFunction2<R3, E> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression3RR<E, R1, R2, E, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, E, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, E, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, E, E>,
            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, E, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, E, QRC, QRL, QRS, Tuple2<E, E>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, E, QRC, QRL, QRS, Tuple2<E, E>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, E, Tuple2<E, E>>> RE join(
                    SerializableFunction3<E, E> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    // ****************************************************************************************************************
    //	2
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <QR extends EntityQueryRelateExpression3RR<E, R1, R2, R3, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
            QRF extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>,
            R3> EntityQueryRelatedExpression<R1, R3, QR, QRF> join2(Class<R3> joinType) {
        return new EntitySqlQueryRelated<>((QR) new EntitySqlQueryRelate3RR<>(factory, sqlPageFactory, queryRelation),
                factory, queryRelation, joinType, 1);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression3RR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
    //            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>, R3,
    //            J> RE join2(SerializableFunction1<R1, J> propertyName, Class<R3> joinType) {
    //        queryRelation.join(1, getPropertyName(propertyName), factory.getClassMapping(joinType));
    //        return (RE) new EntitySqlQueryRelate3RR<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression3RR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
    //            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>, R3,
    //            J> RE join2(SerializableFunction1<R1, J> propertyName, SerializableFunction1<R3, J> joinTypePropertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
    //        queryRelation.join(1, getPropertyName(propertyName),
    //                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
    //        return (RE) new EntitySqlQueryRelate3RR<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression3RR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
    //            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>, R3,
    //            J> RE join2(SerializableFunction4<R3, J> joinTypePropertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
    //        queryRelation.join(1, factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())),
    //                info.getPropertyName());
    //        return (RE) new EntitySqlQueryRelate3RR<>(factory, sqlPageFactory, queryRelation);
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression3RR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>,
            R3> RE join2(SerializableFunction1<R1, R3> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression3RR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>,
            R3> RE join2(SerializableFunction2<R3, R1> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression3RR<E, R1, R2, R1, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R1, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R1, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R1, E>,
            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R1, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R1, QRC, QRL, QRS, Tuple2<E, R1>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R1, QRC, QRL, QRS, Tuple2<E, R1>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R1, Tuple2<E, R1>>> RE join2(
                    SerializableFunction3<R1, R1> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    // ****************************************************************************************************************
    //	3
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <QR extends EntityQueryRelateExpression3RR<E, R1, R2, R3, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
            QRF extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>,
            R3> EntityQueryRelatedExpression<R2, R3, QR, QRF> join3(Class<R3> joinType) {
        return new EntitySqlQueryRelated<>((QR) new EntitySqlQueryRelate3RR<>(factory, sqlPageFactory, queryRelation),
                factory, queryRelation, joinType, 2);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression3RR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
    //            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>, R3,
    //            J> RE join3(SerializableFunction1<R2, J> propertyName, Class<R3> joinType) {
    //        queryRelation.join(2, getPropertyName(propertyName), factory.getClassMapping(joinType));
    //        return (RE) new EntitySqlQueryRelate3RR<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression3RR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
    //            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>, R3,
    //            J> RE join3(SerializableFunction1<R2, J> propertyName, SerializableFunction1<R3, J> joinTypePropertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
    //        queryRelation.join(2, getPropertyName(propertyName),
    //                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
    //        return (RE) new EntitySqlQueryRelate3RR<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression3RR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
    //            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>, R3,
    //            J> RE join3(SerializableFunction4<R3, J> joinTypePropertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
    //        queryRelation.join(2, factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())),
    //                info.getPropertyName());
    //        return (RE) new EntitySqlQueryRelate3RR<>(factory, sqlPageFactory, queryRelation);
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression3RR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>,
            R3> RE join3(SerializableFunction1<R2, R3> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression3RR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>,
            R3> RE join3(SerializableFunction2<R3, R2> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression3RR<E, R1, R2, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R2, E>,
            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R2, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R2, Tuple2<E, R2>>> RE join3(
                    SerializableFunction3<R2, R2> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public EntityQueryConditionGroup3<E, R1, R2, E> where() {
    //        return new EntitySqlQueryExpression3<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public EntityQueryConditionGroup3<E, R1, R2, E> where(
    //            Consumer<ConditionGroupConfig<EntityQueryConditionGroup3<E, R1, R2, E>>> consumer) {
    //        EntitySqlQueryExpression3<E, R1, R2,
    //                E> exp = new EntitySqlQueryExpression3<>(factory, sqlPageFactory, queryRelation);
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
    //    public EntityQuerySortExpression3<E, R1, R2, E> sort() {
    //        return new EntitySqlQueryExpression3<>(factory, sqlPageFactory, queryRelation);
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelatedFetched2RF<E, R1, R2> fetch() {
        queryRelation.fetch(2); // 获取第三个查询实体（index = 2）
        return new EntitySqlQueryRelatedFetched2RF<>(factory, sqlPageFactory, queryRelation);
    }
}
