//
//package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.function.Function;
//
//import com.speedment.common.tuple.Tuple4;
//
//import cn.featherfly.common.constant.Chars;
//import cn.featherfly.common.db.builder.dml.SqlSortBuilder;
//import cn.featherfly.common.db.mapping.ClassMappingUtils;
//import cn.featherfly.common.db.mapping.JdbcMappingFactory;
//import cn.featherfly.common.function.FourArgusConsumer;
//import cn.featherfly.common.lang.LambdaUtils;
//import cn.featherfly.common.lang.function.SerializableFunction;
//import cn.featherfly.common.lang.function.SerializableFunction1;
//import cn.featherfly.common.lang.function.SerializableFunction2;
//import cn.featherfly.common.lang.function.SerializableFunction3;
//import cn.featherfly.common.structure.page.Limit;
//import cn.featherfly.common.structure.page.PaginationResults;
//import cn.featherfly.hammer.dsl.QueryEntityRepository;
//import cn.featherfly.hammer.dsl.query.type.EntityQueryConditionGroup4;
//import cn.featherfly.hammer.dsl.query.type.EntityQueryConditionGroupLogic4;
//import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression4;
//import cn.featherfly.hammer.expression.entity.query.EntityQuerySortedExpression4;
//import cn.featherfly.hammer.expression.entity.query.sort.SortEntityExpression;
//import cn.featherfly.hammer.expression.query.type.EntityQueryLimitExecutor;
//import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
//import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;
//import cn.featherfly.hammer.sqldb.sql.dml.AbstractEntitySqlQueryConditionGroupExpression4;
//import cn.featherfly.hammer.sqldb.sql.dml.EntitySqlQueryConditionGroupQuery;
//
///**
// * entity sql query condition group expression.实体sql查询条件逻辑组表达式.
// *
// * @author zhongj
// * @param <E>  the element type
// * @param <E2> the generic type
// * @param <RS> the query result type
// */
//public abstract class EntitySqlQueryConditionGroupExpression4<E, E2, E3, E4, RS> extends
//        AbstractEntitySqlQueryConditionGroupExpression4<E, E2, E3, E4, RS, EntityQueryConditionGroup4<E, E2, E3, E4, RS>,
//                EntityQueryConditionGroupLogic4<E, E2, E3, E4, RS>>
//        implements EntityQueryConditionGroup4<E, E2, E3, E4, RS>, EntityQueryConditionGroupLogic4<E, E2, E3, E4, RS>,
//        EntityQuerySortExpression4<E, E2, E3, E4, RS>, EntityQuerySortedExpression4<E, E2, E3, E4, RS> {
//
//    /** The sort builder. */
//    private SqlSortBuilder sortBuilder = new SqlSortBuilder(dialect);
//
//    private EntitySqlQueryConditionGroupQuery<RS> entitySqlQueryConditionGroupQuery;
//
//    /**
//     * Instantiates a new type sql query condition group expression.
//     *
//     * @param factory        the factory
//     * @param sqlPageFactory the sql page factory
//     * @param queryRelation  the query relation
//     */
//    public EntitySqlQueryConditionGroupExpression4(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
//            EntitySqlQueryRelation queryRelation) {
//        this(null, factory, sqlPageFactory, queryRelation);
//        sortBuilder = new SqlSortBuilder(dialect);
//        entitySqlQueryConditionGroupQuery = new EntitySqlQueryConditionGroupQuery<>(this, queryRelation);
//    }
//
//    /**
//     * Instantiates a new entity sql query condition group expression 2.
//     *
//     * @param parent         the parent
//     * @param sqlPageFactory the sql page factory
//     * @param factory        the factory
//     * @param queryRelation  the query relation
//     */
//    EntitySqlQueryConditionGroupExpression4(EntityQueryConditionGroupLogic4<E, E2, E3, E4, RS> parent,
//            JdbcMappingFactory factory, SqlPageFactory sqlPageFactory, EntitySqlQueryRelation queryRelation) {
//        super(parent, factory, sqlPageFactory, queryRelation);
//    }
//
//    // ********************************************************************
//    // property
//    // ********************************************************************
//
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //    @Override
//    //    protected EntitySqlQueryConditionGroupExpression<E> createGroup(EntityQueryConditionGroupLogicExpression<E> parent,
//    //            String queryAlias, EntitySqlQuery<E> entityQueryEntity) {
//    //        return new EntitySqlQueryConditionGroupExpression<>(parent, jdbc, queryAlias, classMapping, factory,
//    //                sqlPageFactory, aliasManager, entityQueryEntity, ignoreStrategy);
//    //    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public String build() {
//        return super.build() + Chars.SPACE + sortBuilder.build();
//    }
//
//    /**
//     * Limit.
//     *
//     * @param limit the limit
//     * @return the type query limit executor
//     */
//    @Override
//    public EntityQueryLimitExecutor<RS> limit(Limit limit) {
//        entitySqlQueryConditionGroupQuery.setLimit(limit);
//        return this;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public List<RS> list() {
//        return entitySqlQueryConditionGroupQuery.list();
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public PaginationResults<RS> pagination() {
//        return entitySqlQueryConditionGroupQuery.pagination();
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public RS single() {
//        return entitySqlQueryConditionGroupQuery.single();
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public RS unique() {
//        return entitySqlQueryConditionGroupQuery.unique();
//    }
//
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //    @Override
//    //    public Long count() {
//    //        throw new UnsupportedException();
//    //    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public EntityQuerySortExpression4<E, E2, E3, E4, RS> sort() {
//        return this;
//    }
//
//    //        /**
//    //         * {@inheritDoc}
//    //         */
//    /**
//     * Asc.
//     *
//     * @param names the names
//     * @return the entity query sorted expression
//     */
//    //        @Override
//    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc(String... names) {
//        ((EntitySqlQueryConditionGroupExpression4<E, E2, E3, E4, RS>) getRoot()).sortBuilder
//                .asc(ClassMappingUtils.getColumnNames(classMapping, names));
//        return this;
//    }
//
//    //        /**
//    //         * {@inheritDoc}
//    //         */
//    /**
//     * Asc.
//     *
//     * @param names the names
//     * @return the entity query sorted expression
//     */
//    //        @Override
//    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc(List<String> names) {
//        // YUFEI_TODO asc desc 需要和强类型绑定
//        ((EntitySqlQueryConditionGroupExpression4<E, E2, E3, E4, RS>) getRoot()).sortBuilder
//                .asc(ClassMappingUtils.getColumnNames(classMapping, names));
//        return this;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <P> EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc(SerializableFunction<E, P> name) {
//        // YUFEI_TODO asc desc 需要和强类型绑定
//        return asc(getPropertyName(name));
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc(
//            @SuppressWarnings("unchecked") SerializableFunction<E, ?>... names) {
//        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
//                .toArray(value -> new String[value]);
//        return asc(nameArray);
//    }
//
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    /**
//     * Desc.
//     *
//     * @param names the names
//     * @return the entity query sorted expression
//     */
//    //    @Override
//    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc(String... names) {
//        ((EntitySqlQueryConditionGroupExpression4<E, E2, E3, E4, RS>) getRoot()).sortBuilder
//                .desc(ClassMappingUtils.getColumnNames(classMapping, names));
//        return this;
//    }
//
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    /**
//     * Desc.
//     *
//     * @param names the names
//     * @return the entity query sorted expression
//     */
//    //    @Override
//    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc(List<String> names) {
//        ((EntitySqlQueryConditionGroupExpression4<E, E2, E3, E4, RS>) getRoot()).sortBuilder
//                .desc(ClassMappingUtils.getColumnNames(classMapping, names));
//        return this;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <P> EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc(SerializableFunction<E, P> name) {
//        return desc(getPropertyName(name));
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc(
//            @SuppressWarnings("unchecked") SerializableFunction<E, ?>... names) {
//        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
//                .toArray(value -> new String[value]);
//        return desc(nameArray);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc(FourArgusConsumer<SortEntityExpression<E>,
//            SortEntityExpression<E2>, SortEntityExpression<E3>, SortEntityExpression<E4>> sortEntityExpressions) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc(FourArgusConsumer<SortEntityExpression<E>,
//            SortEntityExpression<E2>, SortEntityExpression<E3>, SortEntityExpression<E4>> sortEntityExpressions) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <R> EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc(
//            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
//                    QueryEntityRepository<E4>>, QueryEntityRepository<E>> entities,
//            SerializableFunction<E, R> name) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc(
//            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
//                    QueryEntityRepository<E4>>, QueryEntityRepository<E>> entities,
//            SerializableFunction<E, ?>... names) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <R> EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc(
//            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
//                    QueryEntityRepository<E4>>, QueryEntityRepository<E2>> entities,
//            SerializableFunction1<E2, R> name) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc(
//            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
//                    QueryEntityRepository<E4>>, QueryEntityRepository<E2>> entities,
//            SerializableFunction1<E2, ?>... names) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <R> EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc(
//            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
//                    QueryEntityRepository<E4>>, QueryEntityRepository<E3>> entities,
//            SerializableFunction2<E3, R> name) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc(
//            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
//                    QueryEntityRepository<E4>>, QueryEntityRepository<E3>> entities,
//            SerializableFunction2<E3, ?>... names) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <R> EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc(
//            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
//                    QueryEntityRepository<E4>>, QueryEntityRepository<E4>> entities,
//            SerializableFunction3<E4, R> name) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc(
//            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
//                    QueryEntityRepository<E4>>, QueryEntityRepository<E4>> entities,
//            SerializableFunction3<E4, ?>... names) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <R> EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc(
//            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
//                    QueryEntityRepository<E4>>, QueryEntityRepository<E>> entities,
//            SerializableFunction<E, R> name) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc(
//            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
//                    QueryEntityRepository<E4>>, QueryEntityRepository<E>> entities,
//            SerializableFunction<E, ?>... names) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <R> EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc(
//            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
//                    QueryEntityRepository<E4>>, QueryEntityRepository<E2>> entities,
//            SerializableFunction1<E2, R> name) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc(
//            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
//                    QueryEntityRepository<E4>>, QueryEntityRepository<E2>> entities,
//            SerializableFunction1<E2, ?>... names) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <R> EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc(
//            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
//                    QueryEntityRepository<E4>>, QueryEntityRepository<E3>> entities,
//            SerializableFunction2<E3, R> name) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc(
//            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
//                    QueryEntityRepository<E4>>, QueryEntityRepository<E3>> entities,
//            SerializableFunction2<E3, ?>... names) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <R> EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc(
//            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
//                    QueryEntityRepository<E4>>, QueryEntityRepository<E4>> entities,
//            SerializableFunction3<E4, R> name) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc(
//            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
//                    QueryEntityRepository<E4>>, QueryEntityRepository<E4>> entities,
//            SerializableFunction3<E4, ?>... names) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <R> EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc4(SerializableFunction<E4, R> name) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc4(SerializableFunction<E4, ?>... names) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <R> EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc4(SerializableFunction<E4, R> name) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc4(SerializableFunction<E4, ?>... names) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <R> EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc3(SerializableFunction<E3, R> name) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc3(SerializableFunction<E3, ?>... names) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <R> EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc3(SerializableFunction<E3, R> name) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc3(SerializableFunction<E3, ?>... names) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <R> EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc2(SerializableFunction<E2, R> name) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc2(SerializableFunction<E2, ?>... names) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <R> EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc2(SerializableFunction<E2, R> name) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc2(SerializableFunction<E2, ?>... names) {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//}
