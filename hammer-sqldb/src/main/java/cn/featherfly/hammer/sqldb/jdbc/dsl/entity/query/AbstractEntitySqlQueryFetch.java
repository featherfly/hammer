
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LambdaUtils.SerializedLambdaInfo;
import cn.featherfly.common.lang.function.SerializableFunction1;
import cn.featherfly.common.lang.function.SerializableFunction2;
import cn.featherfly.common.lang.function.SerializableFunction3;
import cn.featherfly.common.lang.function.SerializableFunction4;
import cn.featherfly.hammer.dsl.query.type.EntityQueryFetchedProperty;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression2;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression2;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression2;
import cn.featherfly.hammer.expression.query.type.EntityQueryRelateExpression;
import cn.featherfly.hammer.expression.query.type.EntityQueryRelateExpression1P;
import cn.featherfly.hammer.expression.query.type.EntityQueryRelatedFetchedExpression;
import cn.featherfly.hammer.expression.query.type.EntityQueryRelatedFetchedExpression1P;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;

/**
 * abstract entity sql query entity properties.
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
    public AbstractEntitySqlQueryFetch(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    //    @Override
    public <RE extends EntityQueryRelateExpression<E, R, RC, RL, RS, QR, FC, FL, FS>,
            RC extends EntityQueryConditionGroupExpression2<E, R, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression2<E, R, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression2<E, R, E>,
            QR extends EntityQueryRelatedFetchedExpression<E, R, FC, FL, FS>,
            FC extends EntityQueryConditionGroupExpression2<E, R, FC, FL, FS, Tuple2<E, R>>,
            FL extends EntityQueryConditionGroupLogicExpression2<E, R, FC, FL, FS, Tuple2<E, R>>,
            FS extends EntityQuerySortExpression2<E, R, Tuple2<E, R>>, R,
            J> RE join(SerializableFunction1<E, J> propertyName, Class<R> joinType) {
        queryRelation.join(0, getPropertyName(propertyName), factory.getClassMapping(joinType));
        return (RE) new EntitySqlQueryRelate<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    //    @Override
    public <RE extends EntityQueryRelateExpression<E, R, RC, RL, RS, QR, FC, FL, FS>,
            RC extends EntityQueryConditionGroupExpression2<E, R, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression2<E, R, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression2<E, R, E>,
            QR extends EntityQueryRelatedFetchedExpression<E, R, FC, FL, FS>,
            FC extends EntityQueryConditionGroupExpression2<E, R, FC, FL, FS, Tuple2<E, R>>,
            FL extends EntityQueryConditionGroupLogicExpression2<E, R, FC, FL, FS, Tuple2<E, R>>,
            FS extends EntityQuerySortExpression2<E, R, Tuple2<E, R>>, R,
            J> RE join(SerializableFunction1<E, J> propertyName, SerializableFunction1<R, J> joinTypePropertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
        queryRelation.join(0, getPropertyName(propertyName),
                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return (RE) new EntitySqlQueryRelate<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    //    @Override
    public <RE extends EntityQueryRelateExpression<E, R, RC, RL, RS, QR, FC, FL, FS>,
            RC extends EntityQueryConditionGroupExpression2<E, R, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression2<E, R, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression2<E, R, E>,
            QR extends EntityQueryRelatedFetchedExpression<E, R, FC, FL, FS>,
            FC extends EntityQueryConditionGroupExpression2<E, R, FC, FL, FS, Tuple2<E, R>>,
            FL extends EntityQueryConditionGroupLogicExpression2<E, R, FC, FL, FS, Tuple2<E, R>>,
            FS extends EntityQuerySortExpression2<E, R, Tuple2<E, R>>, R,
            J> RE join(SerializableFunction4<R, J> joinTypePropertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
        queryRelation.join(0, factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())),
                info.getPropertyName());
        return (RE) new EntitySqlQueryRelate<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    //    @Override
    public <RE extends EntityQueryRelateExpression1P<E, R, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression2<E, R, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression2<E, R, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression2<E, R, E>,
            QR extends EntityQueryRelatedFetchedExpression1P<E, R, RC, RL, RS>,
            R> RE join(SerializableFunction1<E, R> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    //    @Override
    public <RE extends EntityQueryRelateExpression1P<E, R, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression2<E, R, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression2<E, R, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression2<E, R, E>,
            QR extends EntityQueryRelatedFetchedExpression1P<E, R, RC, RL, RS>,
            R> RE join(SerializableFunction2<R, E> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    //    @Override
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
