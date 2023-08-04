//
//package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query;
//
//import java.util.function.Consumer;
//import java.util.function.Predicate;
//
//import com.speedment.common.tuple.Tuple2;
//
//import cn.featherfly.common.db.mapping.JdbcClassMapping;
//import cn.featherfly.common.db.mapping.JdbcMappingFactory;
//import cn.featherfly.common.lang.function.SerializableFunction1;
//import cn.featherfly.common.lang.function.SerializableFunction2;
//import cn.featherfly.common.lang.function.SerializableFunction3;
//import cn.featherfly.common.lang.function.SerializableFunction4;
//import cn.featherfly.common.repository.builder.AliasManager;
//import cn.featherfly.hammer.dsl.query.type.EntityQueryConditionGroup3;
//import cn.featherfly.hammer.dsl.query.type.EntityQueryFetched;
//import cn.featherfly.hammer.dsl.query.type.EntityQueryRelate2R;
//import cn.featherfly.hammer.dsl.query.type.EntityQueryRelatedFetched2RF;
//import cn.featherfly.hammer.expression.condition.ConditionGroupConfig;
//import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression4;
//import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression4;
//import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression3;
//import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression4;
//import cn.featherfly.hammer.expression.query.type.EntityQueryRelateExpression3RR;
//import cn.featherfly.hammer.expression.query.type.EntityQueryRelatedFetchedExpression3RRF;
//import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
//import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
//
///**
// * The Class EntitySqlQueryRelate2R.
// *
// * @author zhongj
// * @param <E>  the element type
// * @param <R1> the generic type
// * @param <R2> the generic type
// */
//public class EntitySqlQueryRelate2R<E, R1, R2> extends AbstractEntitySqlQuerySingle3<E, R1, R2, EntityQueryFetched<E>>
//        implements EntityQueryRelate2R<E, R1, R2> {
//
//    /**
//     * Instantiates a new entity sql query relate 2 R.
//     *
//     * @param classMapping   the class mapping
//     * @param jdbc           the jdbc
//     * @param factory        the factory
//     * @param sqlPageFactory the sql page factory
//     * @param aliasManager   the alias manager
//     * @param ignoreStrategy   the ignore strategy
//     */
//    public EntitySqlQueryRelate2R(JdbcClassMapping<E> classMapping, JdbcClassMapping<E> classMapping, Jdbc jdbc,
//            JdbcMappingFactory factory, SqlPageFactory sqlPageFactory, AliasManager aliasManager,
//            Predicate<Object> ignoreStrategy) {
//        super(classMapping, jdbc, factory, sqlPageFactory, aliasManager, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <RE extends EntityQueryRelateExpression3RR<E, R2, R1, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
//            RC extends EntityQueryConditionGroupExpression4<E, R2, R1, R3, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression4<E, R2, R1, R3, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression4<E, R2, R1, R3, E>,
//            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R2, R1, R3, QRC, QRL, QRS>,
//            QRC extends EntityQueryConditionGroupExpression4<E, R2, R1, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
//            QRL extends EntityQueryConditionGroupLogicExpression4<E, R2, R1, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
//            QRS extends EntityQuerySortExpression4<E, R2, R1, R3, Tuple2<E, R3>>, R3,
//            J> RE join(SerializableFunction1<E, J> propertyName, Class<R3> joinType) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <RE extends EntityQueryRelateExpression3RR<E, R2, R1, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
//            RC extends EntityQueryConditionGroupExpression4<E, R2, R1, R3, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression4<E, R2, R1, R3, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression4<E, R2, R1, R3, E>,
//            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R2, R1, R3, QRC, QRL, QRS>,
//            QRC extends EntityQueryConditionGroupExpression4<E, R2, R1, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
//            QRL extends EntityQueryConditionGroupLogicExpression4<E, R2, R1, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
//            QRS extends EntityQuerySortExpression4<E, R2, R1, R3, Tuple2<E, R3>>, R3,
//            J> RE join(SerializableFunction1<E, J> propertyName, SerializableFunction1<R3, J> joinTypePropertyName) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <RE extends EntityQueryRelateExpression3RR<E, R2, R1, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
//            RC extends EntityQueryConditionGroupExpression4<E, R2, R1, R3, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression4<E, R2, R1, R3, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression4<E, R2, R1, R3, E>,
//            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R2, R1, R3, QRC, QRL, QRS>,
//            QRC extends EntityQueryConditionGroupExpression4<E, R2, R1, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
//            QRL extends EntityQueryConditionGroupLogicExpression4<E, R2, R1, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
//            QRS extends EntityQuerySortExpression4<E, R2, R1, R3, Tuple2<E, R3>>, R3,
//            J> RE join(SerializableFunction4<R3, J> joinTypePropertyName) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <RE extends EntityQueryRelateExpression3RR<E, R2, R1, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
//            RC extends EntityQueryConditionGroupExpression4<E, R2, R1, R3, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression4<E, R2, R1, R3, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression4<E, R2, R1, R3, E>,
//            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R2, R1, R3, QRC, QRL, QRS>,
//            QRC extends EntityQueryConditionGroupExpression4<E, R2, R1, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
//            QRL extends EntityQueryConditionGroupLogicExpression4<E, R2, R1, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
//            QRS extends EntityQuerySortExpression4<E, R2, R1, R3, Tuple2<E, R3>>,
//            R3> RE join(SerializableFunction1<E, R3> propertyName) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <RE extends EntityQueryRelateExpression3RR<E, R2, R1, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
//            RC extends EntityQueryConditionGroupExpression4<E, R2, R1, R3, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression4<E, R2, R1, R3, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression4<E, R2, R1, R3, E>,
//            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R2, R1, R3, QRC, QRL, QRS>,
//            QRC extends EntityQueryConditionGroupExpression4<E, R2, R1, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
//            QRL extends EntityQueryConditionGroupLogicExpression4<E, R2, R1, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
//            QRS extends EntityQuerySortExpression4<E, R2, R1, R3, Tuple2<E, R3>>,
//            R3> RE join(SerializableFunction2<R3, E> propertyName) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <RE extends EntityQueryRelateExpression3RR<E, R2, R1, E, RC, RL, RS, QR, QRC, QRL, QRS>,
//            RC extends EntityQueryConditionGroupExpression4<E, R2, R1, E, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression4<E, R2, R1, E, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression4<E, R2, R1, E, E>,
//            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R2, R1, E, QRC, QRL, QRS>,
//            QRC extends EntityQueryConditionGroupExpression4<E, R2, R1, E, QRC, QRL, QRS, Tuple2<E, E>>,
//            QRL extends EntityQueryConditionGroupLogicExpression4<E, R2, R1, E, QRC, QRL, QRS, Tuple2<E, E>>,
//            QRS extends EntityQuerySortExpression4<E, R2, R1, E, Tuple2<E, E>>> RE join(
//                    SerializableFunction3<E, E> propertyName) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <RE extends EntityQueryRelateExpression3RR<E, R2, R1, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
//            RC extends EntityQueryConditionGroupExpression4<E, R2, R1, R3, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression4<E, R2, R1, R3, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression4<E, R2, R1, R3, E>,
//            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R2, R1, R3, QRC, QRL, QRS>,
//            QRC extends EntityQueryConditionGroupExpression4<E, R2, R1, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
//            QRL extends EntityQueryConditionGroupLogicExpression4<E, R2, R1, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
//            QRS extends EntityQuerySortExpression4<E, R2, R1, R3, Tuple2<E, R3>>, R3,
//            J> RE join2(SerializableFunction1<R2, J> propertyName, Class<R3> joinType) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <RE extends EntityQueryRelateExpression3RR<E, R2, R1, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
//            RC extends EntityQueryConditionGroupExpression4<E, R2, R1, R3, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression4<E, R2, R1, R3, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression4<E, R2, R1, R3, E>,
//            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R2, R1, R3, QRC, QRL, QRS>,
//            QRC extends EntityQueryConditionGroupExpression4<E, R2, R1, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
//            QRL extends EntityQueryConditionGroupLogicExpression4<E, R2, R1, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
//            QRS extends EntityQuerySortExpression4<E, R2, R1, R3, Tuple2<E, R3>>, R3,
//            J> RE join2(SerializableFunction1<R2, J> propertyName, SerializableFunction1<R3, J> joinTypePropertyName) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <RE extends EntityQueryRelateExpression3RR<E, R2, R1, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
//            RC extends EntityQueryConditionGroupExpression4<E, R2, R1, R3, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression4<E, R2, R1, R3, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression4<E, R2, R1, R3, E>,
//            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R2, R1, R3, QRC, QRL, QRS>,
//            QRC extends EntityQueryConditionGroupExpression4<E, R2, R1, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
//            QRL extends EntityQueryConditionGroupLogicExpression4<E, R2, R1, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
//            QRS extends EntityQuerySortExpression4<E, R2, R1, R3, Tuple2<E, R3>>, R3,
//            J> RE join2(SerializableFunction4<R3, J> joinTypePropertyName) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <RE extends EntityQueryRelateExpression3RR<E, R2, R1, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
//            RC extends EntityQueryConditionGroupExpression4<E, R2, R1, R3, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression4<E, R2, R1, R3, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression4<E, R2, R1, R3, E>,
//            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R2, R1, R3, QRC, QRL, QRS>,
//            QRC extends EntityQueryConditionGroupExpression4<E, R2, R1, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
//            QRL extends EntityQueryConditionGroupLogicExpression4<E, R2, R1, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
//            QRS extends EntityQuerySortExpression4<E, R2, R1, R3, Tuple2<E, R3>>,
//            R3> RE join2(SerializableFunction1<R2, R3> propertyName) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <RE extends EntityQueryRelateExpression3RR<E, R2, R1, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
//            RC extends EntityQueryConditionGroupExpression4<E, R2, R1, R3, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression4<E, R2, R1, R3, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression4<E, R2, R1, R3, E>,
//            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R2, R1, R3, QRC, QRL, QRS>,
//            QRC extends EntityQueryConditionGroupExpression4<E, R2, R1, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
//            QRL extends EntityQueryConditionGroupLogicExpression4<E, R2, R1, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
//            QRS extends EntityQuerySortExpression4<E, R2, R1, R3, Tuple2<E, R3>>,
//            R3> RE join2(SerializableFunction2<R3, R2> propertyName) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <RE extends EntityQueryRelateExpression3RR<E, R2, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
//            RC extends EntityQueryConditionGroupExpression4<E, R2, R1, R2, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression4<E, R2, R1, R2, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression4<E, R2, R1, R2, E>,
//            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R2, R1, R2, QRC, QRL, QRS>,
//            QRC extends EntityQueryConditionGroupExpression4<E, R2, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
//            QRL extends EntityQueryConditionGroupLogicExpression4<E, R2, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
//            QRS extends EntityQuerySortExpression4<E, R2, R1, R2, Tuple2<E, R2>>> RE join2(
//                    SerializableFunction3<R2, R2> propertyName) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <RE extends EntityQueryRelateExpression3RR<E, R2, R1, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
//            RC extends EntityQueryConditionGroupExpression4<E, R2, R1, R3, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression4<E, R2, R1, R3, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression4<E, R2, R1, R3, E>,
//            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R2, R1, R3, QRC, QRL, QRS>,
//            QRC extends EntityQueryConditionGroupExpression4<E, R2, R1, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
//            QRL extends EntityQueryConditionGroupLogicExpression4<E, R2, R1, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
//            QRS extends EntityQuerySortExpression4<E, R2, R1, R3, Tuple2<E, R3>>, R3,
//            J> RE join3(SerializableFunction1<R1, J> propertyName, Class<R3> joinType) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <RE extends EntityQueryRelateExpression3RR<E, R2, R1, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
//            RC extends EntityQueryConditionGroupExpression4<E, R2, R1, R3, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression4<E, R2, R1, R3, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression4<E, R2, R1, R3, E>,
//            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R2, R1, R3, QRC, QRL, QRS>,
//            QRC extends EntityQueryConditionGroupExpression4<E, R2, R1, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
//            QRL extends EntityQueryConditionGroupLogicExpression4<E, R2, R1, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
//            QRS extends EntityQuerySortExpression4<E, R2, R1, R3, Tuple2<E, R3>>, R3,
//            J> RE join3(SerializableFunction1<R1, J> propertyName, SerializableFunction1<R3, J> joinTypePropertyName) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <RE extends EntityQueryRelateExpression3RR<E, R2, R1, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
//            RC extends EntityQueryConditionGroupExpression4<E, R2, R1, R3, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression4<E, R2, R1, R3, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression4<E, R2, R1, R3, E>,
//            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R2, R1, R3, QRC, QRL, QRS>,
//            QRC extends EntityQueryConditionGroupExpression4<E, R2, R1, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
//            QRL extends EntityQueryConditionGroupLogicExpression4<E, R2, R1, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
//            QRS extends EntityQuerySortExpression4<E, R2, R1, R3, Tuple2<E, R3>>, R3,
//            J> RE join3(SerializableFunction4<R3, J> joinTypePropertyName) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <RE extends EntityQueryRelateExpression3RR<E, R2, R1, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
//            RC extends EntityQueryConditionGroupExpression4<E, R2, R1, R3, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression4<E, R2, R1, R3, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression4<E, R2, R1, R3, E>,
//            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R2, R1, R3, QRC, QRL, QRS>,
//            QRC extends EntityQueryConditionGroupExpression4<E, R2, R1, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
//            QRL extends EntityQueryConditionGroupLogicExpression4<E, R2, R1, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
//            QRS extends EntityQuerySortExpression4<E, R2, R1, R3, Tuple2<E, R3>>,
//            R3> RE join3(SerializableFunction1<R1, R3> propertyName) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <RE extends EntityQueryRelateExpression3RR<E, R2, R1, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
//            RC extends EntityQueryConditionGroupExpression4<E, R2, R1, R3, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression4<E, R2, R1, R3, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression4<E, R2, R1, R3, E>,
//            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R2, R1, R3, QRC, QRL, QRS>,
//            QRC extends EntityQueryConditionGroupExpression4<E, R2, R1, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
//            QRL extends EntityQueryConditionGroupLogicExpression4<E, R2, R1, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
//            QRS extends EntityQuerySortExpression4<E, R2, R1, R3, Tuple2<E, R3>>,
//            R3> RE join3(SerializableFunction2<R3, R1> propertyName) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <RE extends EntityQueryRelateExpression3RR<E, R2, R1, R1, RC, RL, RS, QR, QRC, QRL, QRS>,
//            RC extends EntityQueryConditionGroupExpression4<E, R2, R1, R1, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression4<E, R2, R1, R1, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression4<E, R2, R1, R1, E>,
//            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R2, R1, R1, QRC, QRL, QRS>,
//            QRC extends EntityQueryConditionGroupExpression4<E, R2, R1, R1, QRC, QRL, QRS, Tuple2<E, R1>>,
//            QRL extends EntityQueryConditionGroupLogicExpression4<E, R2, R1, R1, QRC, QRL, QRS, Tuple2<E, R1>>,
//            QRS extends EntityQuerySortExpression4<E, R2, R1, R1, Tuple2<E, R1>>> RE join3(
//                    SerializableFunction3<R1, R1> propertyName) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public EntityQueryConditionGroup3<E, R2, R1, E> where() {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public EntityQueryConditionGroup3<E, R2, R1, E> where(
//            Consumer<ConditionGroupConfig<EntityQueryConditionGroup3<E, R2, R1, E>>> consumer) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public EntityQuerySortExpression3<E, R2, R1, E> sort() {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public EntityQueryRelatedFetched2RF<E, R1, R2> fetch() {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//}
