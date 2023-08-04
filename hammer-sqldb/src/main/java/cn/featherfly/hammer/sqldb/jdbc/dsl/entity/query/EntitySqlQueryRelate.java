
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query;

import java.util.function.Consumer;
import java.util.function.Function;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.lang.function.SerializableFunction1;
import cn.featherfly.common.lang.function.SerializableFunction2;
import cn.featherfly.common.lang.function.SerializableFunction3;
import cn.featherfly.common.lang.function.SerializableFunction4;
import cn.featherfly.common.lang.function.SerializableFunction5;
import cn.featherfly.common.lang.function.SerializableFunction6;
import cn.featherfly.hammer.dsl.QueryEntityRepository;
import cn.featherfly.hammer.dsl.query.type.EntityQueryConditionGroup2;
import cn.featherfly.hammer.dsl.query.type.EntityQueryRelate;
import cn.featherfly.hammer.dsl.query.type.EntityQueryRelatedFetched;
import cn.featherfly.hammer.expression.condition.ConditionGroupConfig;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression2;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression3;
import cn.featherfly.hammer.expression.query.type.EntityQueryRelateExpression2R;
import cn.featherfly.hammer.expression.query.type.EntityQueryRelatedFetchedExpression2RF;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;

/**
 * The Class EntitySqlQueryRelation.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 */
public class EntitySqlQueryRelate<E, R1> extends AbstractEntitySqlQuery<E> implements EntityQueryRelate<E, R1> {
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
    //    /**
    //     * Instantiates a new type sql query with.
    //     *
    //     * @param sqlQueryEntityProperties  the sql query entity properties
    //     * @param conditionTypeClassMapping the condition type class mapping
    //     * @param conditionTableAlias       the condition table alias
    //     * @param conditionTableColumn      the condition table column
    //     * @param joinTypeClassMapping      the join type class mapping
    //     * @param joinTableColumn           the join table column
    //     * @param fetchProperty             the fetch property
    //     */
    //    public EntitySqlQueryRelate(EntitySqlQueryEntityProperties<E> sqlQueryEntityProperties,
    //            JdbcClassMapping<E> conditionTypeClassMapping, String conditionTableAlias, String conditionTableColumn,
    //            JdbcClassMapping<R1> joinTypeClassMapping, String joinTableColumn, String fetchProperty) {
    //        // IMPLSOON 未实现
    //        //        super(sqlQueryEntityProperties, conditionTypeClassMapping, conditionTableAlias, conditionTableColumn,
    //        //                joinTypeClassMapping, joinTableColumn, fetchProperty, new ArrayList<>());
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryConditionGroup2<E, R1, E> where() {
        return new EntitySqlQueryExpression2<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryConditionGroup2<E, R1, E> where(
            Consumer<ConditionGroupConfig<EntityQueryConditionGroup2<E, R1, E>>> consumer) {
        EntitySqlQueryExpression2<E, R1,
                E> exp = new EntitySqlQueryExpression2<>(factory, sqlPageFactory, queryRelation);
        if (consumer != null) {
            consumer.accept(exp);
        }
        return exp;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortExpression2<E, R1, E> sort() {
        return new EntitySqlQueryExpression2<>(factory, sqlPageFactory, queryRelation);
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
            R2> RE join(SerializableFunction1<E, R2> propertyName) {
        // YUFEI_TODO Auto-generated method stub
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
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2,
            J> RE join(SerializableFunction1<E, J> propertyName, Class<R2> joinType) {
        // YUFEI_TODO Auto-generated method stub
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
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2,
            J> RE join(SerializableFunction1<E, J> propertyName, SerializableFunction1<E, J> joinTypePropertyName) {
        // YUFEI_TODO Auto-generated method stub
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
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2,
            J> RE join(SerializableFunction4<R2, J> joinTypePropertyName) {
        // YUFEI_TODO Auto-generated method stub
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
        // YUFEI_TODO Auto-generated method stub
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
        // YUFEI_TODO Auto-generated method stub
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
            R2> RE join2(SerializableFunction1<R1, R2> propertyName) {
        // YUFEI_TODO Auto-generated method stub
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
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2,
            J> RE join2(SerializableFunction1<R1, J> propertyName, Class<R2> joinType) {
        // YUFEI_TODO Auto-generated method stub
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
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2,
            J> RE join2(SerializableFunction1<R1, J> propertyName, SerializableFunction1<E, J> joinTypePropertyName) {
        // YUFEI_TODO Auto-generated method stub
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
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2,
            J> RE join2(SerializableFunction4<R2, J> joinTypePropertyName) {
        // YUFEI_TODO Auto-generated method stub
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
        // YUFEI_TODO Auto-generated method stub
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
        // YUFEI_TODO Auto-generated method stub
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
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2> RE join(Function<
                    Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>, QueryEntityRepository<E>> entities,
                    SerializableFunction1<E, R2> propertyName) {
        // YUFEI_TODO Auto-generated method stub
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
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2> RE join(Function<
                    Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>, QueryEntityRepository<E>> entities,
                    SerializableFunction2<R2, E> propertyName) {
        // YUFEI_TODO Auto-generated method stub
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
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, E, QRC, QRL, QRS>> RE join(Function<
                    Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>, QueryEntityRepository<E>> entities,
                    SerializableFunction3<E, E> propertyName) {
        // YUFEI_TODO Auto-generated method stub
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
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2> RE join(Function<
                    Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>, QueryEntityRepository<R1>> entities,
                    SerializableFunction4<R1, R2> propertyName) {
        // YUFEI_TODO Auto-generated method stub
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
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2> RE join(Function<
                    Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>, QueryEntityRepository<R1>> entities,
                    SerializableFunction5<R2, R1> propertyName) {
        // YUFEI_TODO Auto-generated method stub
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
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R1, QRC, QRL, QRS>> RE join(Function<
                    Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>, QueryEntityRepository<R1>> entities,
                    SerializableFunction6<R1, R1> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelatedFetched<E, R1> fetch() {
        queryRelation.fetch(1);
        return new EntitySqlQueryRelatedFetched<>(factory, sqlPageFactory, queryRelation);
    }
}
