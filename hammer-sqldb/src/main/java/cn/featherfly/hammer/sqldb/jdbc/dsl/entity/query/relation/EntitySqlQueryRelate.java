
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.relation;

import java.util.function.BiFunction;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.lang.function.SerializableFunction1;
import cn.featherfly.common.lang.function.SerializableFunction2;
import cn.featherfly.common.lang.function.SerializableFunction3;
import cn.featherfly.common.lang.function.SerializableFunction4;
import cn.featherfly.common.lang.function.SerializableFunction5;
import cn.featherfly.common.lang.function.SerializableFunction6;
import cn.featherfly.hammer.dsl.QueryEntityRepository;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelatedFetched;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression3;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelateExpression2R;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedExpression;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedFetchedExpression2RF;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.AbstractEntitySqlQueryFetch2;

/**
 * The Class EntitySqlQueryRelation.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 */
public class EntitySqlQueryRelate<E, R1> extends AbstractEntitySqlQueryFetch2<E, R1, E>
        implements EntityQueryRelate<E, R1> {
    //    extends AbstractEntitySqlQueryFetch2<E, R1>

    /**
     * Instantiates a new entity sql query fetch.
     *
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     * @param classMapping           the class mapping
     */
    public EntitySqlQueryRelate(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelatedFetched<E, R1> fetch() {
        queryRelation.fetch(1); // 获取第二个查询实体（index = 1）
        return new EntitySqlQueryRelatedFetched<>(factory, sqlPageFactory, queryRelation);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public EntityQueryConditionGroup2<E, R1, E> where() {
    //        return new EntitySqlQueryExpression2<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public EntityQueryConditionGroup2<E, R1, E> where(
    //            Consumer<ConditionGroupConfig<EntityQueryConditionGroup2<E, R1, E>>> consumer) {
    //        EntitySqlQueryExpression2<E, R1,
    //                E> exp = new EntitySqlQueryExpression2<>(factory, sqlPageFactory, queryRelation);
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
    //    public EntityQuerySortExpression2<E, R1, E> sort() {
    //        return new EntitySqlQueryExpression2<>(factory, sqlPageFactory, queryRelation);
    //    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <QR extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
            QRF extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>,
            R2> EntityQueryRelatedExpression<E, R2, QR, QRF> join(Class<R2> joinType) {
        return new EntitySqlQueryRelated<>((QR) new EntitySqlQueryRelate2R<>(factory, sqlPageFactory, queryRelation),
                factory, queryRelation, joinType, 0);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, J,
    //            R2> RE join(SerializableFunction1<E, J> propertyName, Class<R2> joinType) {
    //        queryRelation.join(0, getPropertyName(propertyName), factory.getClassMapping(joinType));
    //        return (RE) new EntitySqlQueryRelate2R<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, J extends Number,
    //            R2> RE join(SerializableToNumberFunction1<E, J> propertyName,
    //                    SerializableToNumberFunction1<R2, J> joinTypePropertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
    //        queryRelation.join(0, getPropertyName(propertyName),
    //                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
    //        return (RE) new EntitySqlQueryRelate2R<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>,
    //            R2> RE join(SerializableToStringFunction1<E> propertyName,
    //                    SerializableToStringFunction1<R2> joinTypePropertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
    //        queryRelation.join(0, getPropertyName(propertyName),
    //                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
    //        return (RE) new EntitySqlQueryRelate2R<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, J extends Number,
    //            R2> RE join(SerializableToNumberFunction1<R2, J> joinTypePropertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
    //        queryRelation.join(0, factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())),
    //                info.getPropertyName());
    //        return (RE) new EntitySqlQueryRelate2R<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>,
    //            R2> RE join(SerializableToStringFunction1<R2> joinTypePropertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
    //        queryRelation.join(0, factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())),
    //                info.getPropertyName());
    //        return (RE) new EntitySqlQueryRelate2R<>(factory, sqlPageFactory, queryRelation);
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>,
            R2> RE join(SerializableFunction1<E, R2> propertyName) {
        // IMPLSOON 后续来实现实体关系（ManyToOne、OneToOne、OneToMany）关联
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>,
            R2> RE join(SerializableFunction2<R2, E> propertyName) {
        // IMPLSOON 后续来实现实体关系（ManyToOne、OneToOne、OneToMany）关联
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression2R<E, R1, E, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, E, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, E, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, E, E>,
            QRC extends EntityQueryConditionGroupExpression3<E, R1, E, QRC, QRL, QRS, Tuple2<E, E>>,
            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, E, QRC, QRL, QRS, Tuple2<E, E>>,
            QRS extends EntityQuerySortExpression3<E, R1, E, Tuple2<E, E>>,
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, E, QRC, QRL, QRS>> RE join(
                    SerializableFunction3<E, E> propertyName) {
        // IMPLSOON 后续来实现实体关系（ManyToOne、OneToOne、OneToMany）关联
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
    public <QR extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
            QRF extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>,
            R2> EntityQueryRelatedExpression<R1, R2, QR, QRF> join2(Class<R2> joinType) {
        return new EntitySqlQueryRelated<>((QR) new EntitySqlQueryRelate2R<>(factory, sqlPageFactory, queryRelation),
                factory, queryRelation, joinType, 1);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, J,
    //            R2> RE join2(SerializableFunction2<R1, J> propertyName, Class<R2> joinType) {
    //        queryRelation.join(1, getPropertyName(propertyName), factory.getClassMapping(joinType));
    //        return (RE) new EntitySqlQueryRelate2R<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, J extends Number,
    //            R2> RE join2(SerializableToNumberFunction2<R1, J> propertyName,
    //                    SerializableToNumberFunction2<R2, J> joinTypePropertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
    //        queryRelation.join(1, getPropertyName(propertyName),
    //                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
    //        return (RE) new EntitySqlQueryRelate2R<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>,
    //            R2> RE join2(SerializableToStringFunction2<R1> propertyName,
    //                    SerializableToStringFunction2<R2> joinTypePropertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
    //        queryRelation.join(1, getPropertyName(propertyName),
    //                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
    //        return (RE) new EntitySqlQueryRelate2R<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, J extends Number,
    //            R2> RE join2(SerializableToNumberFunction2<R2, J> joinTypePropertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
    //        queryRelation.join(1, factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())),
    //                info.getPropertyName());
    //        return (RE) new EntitySqlQueryRelate2R<>(factory, sqlPageFactory, queryRelation);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>,
    //            R2> RE join2(SerializableToStringFunction2<R2> joinTypePropertyName) {
    //        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
    //        queryRelation.join(1, factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())),
    //                info.getPropertyName());
    //        return (RE) new EntitySqlQueryRelate2R<>(factory, sqlPageFactory, queryRelation);
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>,
            R2> RE join2(SerializableFunction1<R1, R2> propertyName) {
        // IMPLSOON 后续来实现实体关系（ManyToOne、OneToOne、OneToMany）关联
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>,
            R2> RE join2(SerializableFunction2<R2, R1> propertyName) {
        // IMPLSOON 后续来实现实体关系（ManyToOne、OneToOne、OneToMany）关联
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression2R<E, R1, R1, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R1, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R1, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R1, E>,
            QRC extends EntityQueryConditionGroupExpression3<E, R1, R1, QRC, QRL, QRS, Tuple2<E, R1>>,
            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R1, QRC, QRL, QRS, Tuple2<E, R1>>,
            QRS extends EntityQuerySortExpression3<E, R1, R1, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R1, QRC, QRL, QRS>> RE join2(
                    SerializableFunction3<R1, R1> propertyName) {
        // IMPLSOON 后续来实现实体关系（ManyToOne、OneToOne、OneToMany）关联
        return null;
    }

    // ****************************************************************************************************************
    //  join tuple 1
    // ****************************************************************************************************************

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, J, R2> RE join(
    //                    BiFunction<QueryEntityRepository<E>, QueryEntityRepository<R1>, QueryEntityRepository<E>> entities,
    //                    SerializableFunction1<E, J> propertyName, Class<R2> joinType) {
    //        prepareJoin(0, entities);
    //        return join(propertyName, joinType);
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, J, R2> RE join(
    //                    Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>,
    //                            QueryEntityRepository<E>> entities,
    //                    SerializableFunction1<E, J> propertyName, Class<R2> joinType) {
    //        prepareJoin(0, entities);
    //        return join(propertyName, joinType);
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, J extends Number, R2> RE join(
    //                    BiFunction<QueryEntityRepository<E>, QueryEntityRepository<R1>, QueryEntityRepository<E>> entities,
    //                    SerializableToNumberFunction1<E, J> propertyName,
    //                    SerializableToNumberFunction1<R2, J> joinTypePropertyName) {
    //        prepareJoin(0, entities);
    //        return join(propertyName, joinTypePropertyName);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2> RE join(
    //                    BiFunction<QueryEntityRepository<E>, QueryEntityRepository<R1>, QueryEntityRepository<E>> entities,
    //                    SerializableToStringFunction1<E> propertyName,
    //                    SerializableToStringFunction1<R2> joinTypePropertyName) {
    //        prepareJoin(0, entities);
    //        return join(propertyName, joinTypePropertyName);
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, J extends Number, R2> RE join(
    //                    Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>,
    //                            QueryEntityRepository<E>> entities,
    //                    SerializableToNumberFunction1<E, J> propertyName,
    //                    SerializableToNumberFunction1<R2, J> joinTypePropertyName) {
    //        prepareJoin(0, entities);
    //        return join(propertyName, joinTypePropertyName);
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2> RE join(
    //                    Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>,
    //                            QueryEntityRepository<E>> entities,
    //                    SerializableToStringFunction1<E> propertyName,
    //                    SerializableToStringFunction1<R2> joinTypePropertyName) {
    //        prepareJoin(0, entities);
    //        return join(propertyName, joinTypePropertyName);
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, J extends Number, R2> RE join(
    //                    BiFunction<QueryEntityRepository<E>, QueryEntityRepository<R1>, QueryEntityRepository<E>> entities,
    //                    SerializableToNumberFunction1<R2, J> joinTypePropertyName) {
    //        prepareJoin(0, entities);
    //        return join(joinTypePropertyName);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2> RE join(
    //                    BiFunction<QueryEntityRepository<E>, QueryEntityRepository<R1>, QueryEntityRepository<E>> entities,
    //                    SerializableToStringFunction1<R2> joinTypePropertyName) {
    //        prepareJoin(0, entities);
    //        return join(joinTypePropertyName);
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, J extends Number, R2> RE join(
    //                    Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>,
    //                            QueryEntityRepository<E>> entities,
    //                    SerializableToNumberFunction1<R2, J> joinTypePropertyName) {
    //        prepareJoin(0, entities);
    //        return join(joinTypePropertyName);
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2> RE join(
    //                    Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>,
    //                            QueryEntityRepository<E>> entities,
    //                    SerializableToStringFunction1<R2> joinTypePropertyName) {
    //        prepareJoin(0, entities);
    //        return join(joinTypePropertyName);
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2> RE join(
                    BiFunction<QueryEntityRepository<E>, QueryEntityRepository<R1>, QueryEntityRepository<E>> entities,
                    SerializableFunction1<E, R2> propertyName) {
        // IMPLSOON 后续来实现实体关系（ManyToOne、OneToOne、OneToMany）关联
        return null;
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2> RE join(Function<
    //                    Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>, QueryEntityRepository<E>> entities,
    //                    SerializableFunction1<E, R2> propertyName) {
    //        // IMPLSOON 后续来实现实体关系（ManyToOne、OneToOne、OneToMany）关联
    //        return null;
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2> RE join(
                    BiFunction<QueryEntityRepository<E>, QueryEntityRepository<R1>, QueryEntityRepository<E>> entities,
                    SerializableFunction2<R2, E> propertyName) {
        // IMPLSOON 后续来实现实体关系（ManyToOne、OneToOne、OneToMany）关联
        return null;
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2> RE join(Function<
    //                    Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>, QueryEntityRepository<E>> entities,
    //                    SerializableFunction2<R2, E> propertyName) {
    //        // IMPLSOON 后续来实现实体关系（ManyToOne、OneToOne、OneToMany）关联
    //        return null;
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression2R<E, R1, E, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, E, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, E, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, E, E>,
            QRC extends EntityQueryConditionGroupExpression3<E, R1, E, QRC, QRL, QRS, Tuple2<E, E>>,
            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, E, QRC, QRL, QRS, Tuple2<E, E>>,
            QRS extends EntityQuerySortExpression3<E, R1, E, Tuple2<E, E>>,
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, E, QRC, QRL, QRS>> RE join(
                    BiFunction<QueryEntityRepository<E>, QueryEntityRepository<R1>, QueryEntityRepository<E>> entities,
                    SerializableFunction3<E, E> propertyName) {
        // IMPLSOON 后续来实现实体关系（ManyToOne、OneToOne、OneToMany）关联
        return null;
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <RE extends EntityQueryRelateExpression2R<E, R1, E, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, E, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, E, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, E, E>,
    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, E, QRC, QRL, QRS, Tuple2<E, E>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, E, QRC, QRL, QRS, Tuple2<E, E>>,
    //            QRS extends EntityQuerySortExpression3<E, R1, E, Tuple2<E, E>>,
    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, E, QRC, QRL, QRS>> RE join(Function<
    //                    Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>, QueryEntityRepository<E>> entities,
    //                    SerializableFunction3<E, E> propertyName) {
    //        // IMPLSOON 后续来实现实体关系（ManyToOne、OneToOne、OneToMany）关联
    //        return null;
    //    }

    // ****************************************************************************************************************
    //	join tuple 2
    // ****************************************************************************************************************

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, J, R2> RE join(
    //                    BiFunction<QueryEntityRepository<E>, QueryEntityRepository<R1>, QueryEntityRepository<R1>> entities,
    //                    SerializableFunction2<R1, J> propertyName, Class<R2> joinType) {
    //        prepareJoin(1, entities);
    //        return join2(propertyName, joinType);
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, J, R2> RE join(
    //                    Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>,
    //                            QueryEntityRepository<R1>> entities,
    //                    SerializableFunction2<R1, J> propertyName, Class<R2> joinType) {
    //        prepareJoin(1, entities);
    //        return join2(propertyName, joinType);
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, J extends Number, R2> RE join(
    //                    BiFunction<QueryEntityRepository<E>, QueryEntityRepository<R1>, QueryEntityRepository<R1>> entities,
    //                    SerializableToNumberFunction2<R1, J> propertyName,
    //                    SerializableToNumberFunction2<R2, J> joinTypePropertyName) {
    //        prepareJoin(1, entities);
    //        return join2(propertyName, joinTypePropertyName);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2> RE join(
    //                    BiFunction<QueryEntityRepository<E>, QueryEntityRepository<R1>, QueryEntityRepository<R1>> entities,
    //                    SerializableToStringFunction2<R1> propertyName,
    //                    SerializableToStringFunction2<R2> joinTypePropertyName) {
    //        prepareJoin(1, entities);
    //        return join2(propertyName, joinTypePropertyName);
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, J extends Number, R2> RE join(
    //                    Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>,
    //                            QueryEntityRepository<R1>> entities,
    //                    SerializableToNumberFunction2<R1, J> propertyName,
    //                    SerializableToNumberFunction2<R2, J> joinTypePropertyName) {
    //        prepareJoin(1, entities);
    //        return join2(propertyName, joinTypePropertyName);
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2> RE join(
    //                    Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>,
    //                            QueryEntityRepository<R1>> entities,
    //                    SerializableToStringFunction2<R1> propertyName,
    //                    SerializableToStringFunction2<R2> joinTypePropertyName) {
    //        prepareJoin(1, entities);
    //        return join2(propertyName, joinTypePropertyName);
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, J extends Number, R2> RE join(
    //                    BiFunction<QueryEntityRepository<E>, QueryEntityRepository<R1>, QueryEntityRepository<R1>> entities,
    //                    SerializableToNumberFunction2<R2, J> joinTypePropertyName) {
    //        prepareJoin(1, entities);
    //        return join2(joinTypePropertyName);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2> RE join(
    //                    BiFunction<QueryEntityRepository<E>, QueryEntityRepository<R1>, QueryEntityRepository<R1>> entities,
    //                    SerializableToStringFunction2<R2> joinTypePropertyName) {
    //        prepareJoin(1, entities);
    //        return join2(joinTypePropertyName);
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, J extends Number, R2> RE join(
    //                    Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>,
    //                            QueryEntityRepository<R1>> entities,
    //                    SerializableToNumberFunction2<R2, J> joinTypePropertyName) {
    //        prepareJoin(1, entities);
    //        return join2(joinTypePropertyName);
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2> RE join(
    //                    Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>,
    //                            QueryEntityRepository<R1>> entities,
    //                    SerializableToStringFunction2<R2> joinTypePropertyName) {
    //        prepareJoin(1, entities);
    //        return join2(joinTypePropertyName);
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2> RE join(
                    BiFunction<QueryEntityRepository<E>, QueryEntityRepository<R1>, QueryEntityRepository<R1>> entities,
                    SerializableFunction4<R1, R2> propertyName) {
        // IMPLSOON 后续来实现实体关系（ManyToOne、OneToOne、OneToMany）关联
        return null;
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2> RE join(Function<
    //                    Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>, QueryEntityRepository<R1>> entities,
    //                    SerializableFunction4<R1, R2> propertyName) {
    //        // IMPLSOON 后续来实现实体关系（ManyToOne、OneToOne、OneToMany）关联
    //        return null;
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2> RE join(
                    BiFunction<QueryEntityRepository<E>, QueryEntityRepository<R1>, QueryEntityRepository<R1>> entities,
                    SerializableFunction5<R2, R1> propertyName) {
        // IMPLSOON 后续来实现实体关系（ManyToOne、OneToOne、OneToMany）关联
        return null;
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2> RE join(Function<
    //                    Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>, QueryEntityRepository<R1>> entities,
    //                    SerializableFunction5<R2, R1> propertyName) {
    //        // IMPLSOON 后续来实现实体关系（ManyToOne、OneToOne、OneToMany）关联
    //        return null;
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression2R<E, R1, R1, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R1, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R1, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R1, E>,
            QRC extends EntityQueryConditionGroupExpression3<E, R1, R1, QRC, QRL, QRS, Tuple2<E, R1>>,
            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R1, QRC, QRL, QRS, Tuple2<E, R1>>,
            QRS extends EntityQuerySortExpression3<E, R1, R1, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R1, QRC, QRL, QRS>> RE join(
                    BiFunction<QueryEntityRepository<E>, QueryEntityRepository<R1>, QueryEntityRepository<R1>> entities,
                    SerializableFunction6<R1, R1> propertyName) {
        // IMPLSOON 后续来实现实体关系（ManyToOne、OneToOne、OneToMany）关联
        return null;
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <RE extends EntityQueryRelateExpression2R<E, R1, R1, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R1, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R1, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R1, E>,
    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R1, QRC, QRL, QRS, Tuple2<E, R1>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R1, QRC, QRL, QRS, Tuple2<E, R1>>,
    //            QRS extends EntityQuerySortExpression3<E, R1, R1, Tuple2<E, R1>>,
    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R1, QRC, QRL, QRS>> RE join(Function<
    //                    Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>, QueryEntityRepository<R1>> entities,
    //                    SerializableFunction6<R1, R1> propertyName) {
    //        // IMPLSOON 后续来实现实体关系（ManyToOne、OneToOne、OneToMany）关联
    //        return null;
    //    }

    // ****************************************************************************************************************
    //
    // ****************************************************************************************************************
}
