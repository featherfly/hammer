//
//package cn.featherfly.hammer.sqldb.sql.dml;
//
//import java.lang.reflect.Array;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//import java.util.function.Function;
//import java.util.function.Predicate;
//
//import com.speedment.common.tuple.Tuple2;
//
//import cn.featherfly.common.bean.BeanDescriptor;
//import cn.featherfly.common.constant.Chars;
//import cn.featherfly.common.db.FieldValueOperator;
//import cn.featherfly.common.db.mapping.JdbcClassMapping;
//import cn.featherfly.common.db.mapping.JdbcMappingFactory;
//import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
//import cn.featherfly.common.lang.AssertIllegalArgument;
//import cn.featherfly.common.lang.ClassUtils;
//import cn.featherfly.common.lang.LambdaUtils;
//import cn.featherfly.common.lang.LambdaUtils.SerializableSupplierLambdaInfo;
//import cn.featherfly.common.lang.LambdaUtils.SerializedLambdaInfo;
//import cn.featherfly.common.lang.function.SerializableDateSupplier;
//import cn.featherfly.common.lang.function.SerializableLocalDateSupplier;
//import cn.featherfly.common.lang.function.SerializableLocalDateTimeSupplier;
//import cn.featherfly.common.lang.function.SerializableLocalTimeSupplier;
//import cn.featherfly.common.lang.function.SerializableNumberSupplier;
//import cn.featherfly.common.lang.function.SerializableFunction;
//import cn.featherfly.common.lang.function.SerializableSupplier;
//import cn.featherfly.common.lang.function.SerializableStringSupplier;
//import cn.featherfly.common.operator.AggregateFunction;
//import cn.featherfly.common.operator.LogicOperator;
//import cn.featherfly.common.operator.QueryOperator;
//import cn.featherfly.common.operator.QueryOperator.QueryPolicy;
//import cn.featherfly.common.repository.builder.AliasManager;
//import cn.featherfly.common.repository.mapping.PropertyMapping.Mode;
//import cn.featherfly.hammer.expression.condition.GroupEndExpression;
//import cn.featherfly.hammer.expression.condition.GroupExpression;
//import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
//import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.EntitySqlQueryRelation;
//
///**
// * sql condition group builder sql条件逻辑组构造器 .
// *
// * @author zhongj
// * @param <E> the element type
// * @param <C> the generic type
// * @param <L> the generic type
// */
//@SuppressWarnings("unchecked")
//public abstract class AbstractEntitySqlConditionGroupExpressionBaseBak<E,
//        //        C extends ConditionExpression, L extends LogicExpression<C, L>> extends AbstractSqlConditionExpression<L> {
//        C extends GroupExpression<C, L>, L extends GroupEndExpression<C, L>>
//        extends AbstractEntitySqlConditionExpressionBase<E, C, L> {
//
//    //    /** The type query entity. */
//    //    protected EntitySqlQuery<E> entityQuery;
//
//    /** The sql page factory. */
//    protected SqlPageFactory sqlPageFactory;
//
//    /** The factory. */
//    protected JdbcMappingFactory factory;
//
//    /** The alias manager. */
//    protected AliasManager aliasManager;
//
//    /** The class mapping. */
//    protected JdbcClassMapping<E> classMapping;
//
//    protected Predicate<Object> ignoreStrategy;
//
//    /** The query alias. */
//    protected String queryAlias;
//
//    protected EntitySqlQueryRelation queryRelation;
//
//    /**
//     * Instantiates a new abstract sql condition group expression.
//     *
//     * @param parent         parent group
//     * @param factory        the factory
//     * @param sqlPageFactory the sql page factory
//     * @param queryRelation  the query relation
//     */
//    protected AbstractEntitySqlConditionGroupExpressionBaseBak(L parent, JdbcMappingFactory factory,
//            SqlPageFactory sqlPageFactory, EntitySqlQueryRelation queryRelation) {
//        super(parent, queryRelation.getJdbc().getDialect(), queryRelation.getIgnorePolicy());
//        this.sqlPageFactory = sqlPageFactory;
//        this.factory = factory;
//        queryAlias = queryRelation.getEntityRelationMappingTuple().getOrNull0().getTableAlias();
//        classMapping = (JdbcClassMapping<E>) queryRelation.getEntityRelationMappingTuple().getOrNull0().getClassMapping();
//        aliasManager = queryRelation.getAliasManager();
//        ignoreStrategy = queryRelation.getIgnorePolicy();
//        this.queryRelation = queryRelation;
//        //        this.entityQuery = entityQuery;
//    }
//    //    /**
//    //     * Instantiates a new abstract sql condition group expression.
//    //     *
//    //     * @param parent         parent group
//    //     * @param dialect        dialect
//    //     * @param sqlPageFactory the sql page factory
//    //     * @param queryAlias     queryAlias
//    //     * @param classMapping   classMapping
//    //     * @param factory        the factory
//    //     * @param aliasManager   the alias manager
//    //     * @param entityQuery    the entity query
//    //     * @param ignoreStrategy   the ignore strategy
//    //     */
//    //    protected AbstractEntitySqlConditionGroupExpressionBase(L parent, Dialect dialect, SqlPageFactory sqlPageFactory,
//    //            String queryAlias, JdbcClassMapping<E> classMapping, JdbcMappingFactory factory, AliasManager aliasManager,
//    //            EntitySqlQuery<E> entityQuery, Predicate<Object> ignoreStrategy) {
//    //        super(dialect, ignoreStrategy, parent);
//    //        this.queryAlias = queryAlias;
//    //        this.sqlPageFactory = sqlPageFactory;
//    //        this.classMapping = classMapping;
//    //        this.factory = factory;
//    //        this.aliasManager = aliasManager;
//    //        this.entityQuery = entityQuery;
//    //    }
//
//    @Override
//    public long count() {
//        queryRelation.getSelectBuilder().addColumn(AggregateFunction.COUNT, Chars.STAR);
//        return queryRelation.getJdbc().queryLong(getRoot().expression(), getRoot().getParams().toArray());
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <R> L eq(SerializableFunction<E, R> name, R value, QueryPolicy queryPolicy) {
//        return eq(name, value, queryPolicy, (Predicate<R>) ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <R> L eq(SerializableFunction<E, R> name, R value, QueryPolicy queryPolicy, Predicate<R> ignoreStrategy) {
//        return eq_ne(QueryOperator.EQ, classMapping.getPropertyMapping(getPropertyName(name)), value, queryPolicy,
//                (Predicate<Object>) ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <R> L eq(SerializableSupplier<R> property, QueryPolicy queryPolicy) {
//        return eq(property, queryPolicy, (Predicate<R>) ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <R> L eq(SerializableSupplier<R> property, QueryPolicy queryPolicy, Predicate<R> ignoreStrategy) {
//        return eq_ne(QueryOperator.EQ,
//                classMapping.getPropertyMapping(LambdaUtils.getSerializableSupplierLambdaInfo(property)
//                        .getSerializedLambdaInfo().getPropertyName()),
//                property.get(), queryPolicy, (Predicate<Object>) ignoreStrategy);
//    }
//
//    //
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //
//    //    public < R> L ne(SerializableFunction<E, R> name, R value) {
//    //        //        return ne(getPropertyName(name), value);
//    //        List<Tuple2<String, Optional<R>>> tuples = supplier(LambdaUtils.getLambdaInfo(name), value);
//    //        L l = null;
//    //        C c = (C) this;
//    //        if (tuples.size() > 1) {
//    //            c = group();
//    //        }
//    //        for (Tuple2<String, Optional<R>> tuple : tuples) {
//    //            if (l != null) {
//    //                c = l.and();
//    //            }
//    //            l = c.ne(tuple.get0(), tuple.get1().orElseGet(() -> null));
//    //        }
//    //        if (tuples.size() > 1) {
//    //            l = l.endGroup();
//    //        }
//    //        return l;
//    //    }
//    //
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //
//    //    public <R> L ne(SerializableSupplier<R> property) {
//    //        //        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
//    //        //        return ne(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
//    //        List<Tuple2<String, Optional<R>>> tuples = supplier(LambdaUtils.getSerializableSupplierLambdaInfo(property));
//    //        L l = null;
//    //        C c = (C) this;
//    //        if (tuples.size() > 1) {
//    //            c = group();
//    //        }
//    //        for (Tuple2<String, Optional<R>> tuple : tuples) {
//    //            if (l != null) {
//    //                c = l.and();
//    //            }
//    //            l = c.ne(tuple.get0(), tuple.get1().orElseGet(() -> null));
//    //        }
//    //        if (tuples.size() > 1) {
//    //            l = l.endGroup();
//    //        }
//    //        return l;
//    //    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <R> L ne(SerializableFunction<E, R> name, R value, QueryPolicy queryPolicy) {
//        return ne(name, value, queryPolicy, (Predicate<R>) ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <R> L ne(SerializableFunction<E, R> name, R value, QueryPolicy queryPolicy, Predicate<R> ignoreStrategy) {
//        return eq_ne(QueryOperator.NE, classMapping.getPropertyMapping(getPropertyName(name)), value, queryPolicy,
//                (Predicate<Object>) ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <R> L ne(SerializableSupplier<R> property, QueryPolicy queryPolicy) {
//        return ne(property, queryPolicy, (Predicate<R>) ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <R> L ne(SerializableSupplier<R> property, QueryPolicy queryPolicy, Predicate<R> ignoreStrategy) {
//        return eq_ne(QueryOperator.NE,
//                classMapping.getPropertyMapping(LambdaUtils.getSerializableSupplierLambdaInfo(property)
//                        .getSerializedLambdaInfo().getPropertyName()),
//                property.get(), queryPolicy, (Predicate<Object>) ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L lk(SerializableFunction<E, String> name, String value, QueryPolicy queryPolicy) {
//        // YUFEI_TODO 未测试
//        //        JdbcPropertyMapping pm = classMapping.getPropertyMapping(getPropertyName(name));
//        //        return (L) addCondition(
//        //                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
//        //                        value == null ? null
//        //                                : new FieldValueOperator<>(
//        //                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
//        //                        QueryOperator.LK, queryPolicy, queryAlias, ignoreStrategy));
//        return lk(classMapping.getPropertyMapping(getPropertyName(name)), value, queryPolicy, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L lk(SerializableFunction<E, String> name, String value, QueryPolicy queryPolicy,
//            Predicate<String> ignoreStrategy) {
//        // YUFEI_TODO 未测试
//        //        JdbcPropertyMapping pm = classMapping.getPropertyMapping(getPropertyName(name));
//        //        return (L) addCondition(
//        //                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
//        //                        value == null ? null
//        //                                : new FieldValueOperator<>(
//        //                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
//        //                        QueryOperator.LK, queryPolicy, queryAlias, ignoreStrategy));
//        return lk(classMapping.getPropertyMapping(getPropertyName(name)), value, queryPolicy, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L lk(SerializableStringSupplier property, QueryPolicy queryPolicy) {
//        //  YUFEI_TODO 未测试
//        //        String value = property.get();
//        //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
//        //        JdbcPropertyMapping pm = classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName());
//        //        return (L) addCondition(
//        //                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
//        //                        value == null ? null
//        //                                : new FieldValueOperator<>(
//        //                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
//        //                        QueryOperator.LK, queryPolicy, queryAlias, ignoreStrategy));
//        return lk(classMapping.getPropertyMapping(
//                LambdaUtils.getSerializableSupplierLambdaInfo(property).getSerializedLambdaInfo().getPropertyName()),
//                property.get(), queryPolicy, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L lk(SerializableStringSupplier property, QueryPolicy queryPolicy, Predicate<String> ignoreStrategy) {
//        //  YUFEI_TODO 未测试
//        //        String value = property.get();
//        //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
//        //        JdbcPropertyMapping pm = classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName());
//        //        return (L) addCondition(
//        //                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
//        //                        value == null ? null
//        //                                : new FieldValueOperator<>(
//        //                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
//        //                        QueryOperator.LK, queryPolicy, queryAlias, ignoreStrategy));
//        return lk(classMapping.getPropertyMapping(
//                LambdaUtils.getSerializableSupplierLambdaInfo(property).getSerializedLambdaInfo().getPropertyName()),
//                property.get(), queryPolicy, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L sw(SerializableFunction<E, String> name, String value, QueryPolicy queryPolicy) {
//        // YUFEI_TODO 未测试
//        //        JdbcPropertyMapping pm = classMapping.getPropertyMapping(getPropertyName(name));
//        //        return (L) addCondition(
//        //                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
//        //                        value == null ? null
//        //                                : new FieldValueOperator<>(
//        //                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
//        //                        QueryOperator.SW, queryPolicy, queryAlias, ignoreStrategy));
//        return sw(classMapping.getPropertyMapping(getPropertyName(name)), value, queryPolicy, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L sw(SerializableFunction<E, String> name, String value, QueryPolicy queryPolicy,
//            Predicate<String> ignoreStrategy) {
//        // YUFEI_TODO 未测试
//        //        JdbcPropertyMapping pm = classMapping.getPropertyMapping(getPropertyName(name));
//        //        return (L) addCondition(
//        //                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
//        //                        value == null ? null
//        //                                : new FieldValueOperator<>(
//        //                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
//        //                        QueryOperator.SW, queryPolicy, queryAlias, ignoreStrategy));
//        return sw(classMapping.getPropertyMapping(getPropertyName(name)), value, queryPolicy, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L sw(SerializableStringSupplier property, QueryPolicy queryPolicy) {
//        //  YUFEI_TODO 未测试
//        //        String value = property.get();
//        //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
//        //        JdbcPropertyMapping pm = classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName());
//        //        return (L) addCondition(
//        //                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
//        //                        value == null ? null
//        //                                : new FieldValueOperator<>(
//        //                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
//        //                        QueryOperator.SW, queryPolicy, queryAlias, ignoreStrategy));
//        return sw(classMapping.getPropertyMapping(
//                LambdaUtils.getSerializableSupplierLambdaInfo(property).getSerializedLambdaInfo().getPropertyName()),
//                property.get(), queryPolicy, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L sw(SerializableStringSupplier property, QueryPolicy queryPolicy, Predicate<String> ignoreStrategy) {
//        //  YUFEI_TODO 未测试
//        //        String value = property.get();
//        //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
//        //        JdbcPropertyMapping pm = classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName());
//        //        return (L) addCondition(
//        //                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
//        //                        value == null ? null
//        //                                : new FieldValueOperator<>(
//        //                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
//        //                        QueryOperator.SW, queryPolicy, queryAlias, ignoreStrategy));
//        return sw(classMapping.getPropertyMapping(
//                LambdaUtils.getSerializableSupplierLambdaInfo(property).getSerializedLambdaInfo().getPropertyName()),
//                property.get(), queryPolicy, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L ew(SerializableFunction<E, String> name, String value, QueryPolicy queryPolicy) {
//        // YUFEI_TODO 未测试
//        //        JdbcPropertyMapping pm = classMapping.getPropertyMapping(getPropertyName(name));
//        //        return (L) addCondition(
//        //                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
//        //                        value == null ? null
//        //                                : new FieldValueOperator<>(
//        //                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
//        //                        QueryOperator.EW, queryPolicy, queryAlias, ignoreStrategy));
//        return ew(classMapping.getPropertyMapping(getPropertyName(name)), value, queryPolicy, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L ew(SerializableFunction<E, String> name, String value, QueryPolicy queryPolicy,
//            Predicate<String> ignoreStrategy) {
//        // YUFEI_TODO 未测试
//        //        JdbcPropertyMapping pm = classMapping.getPropertyMapping(getPropertyName(name));
//        //        return (L) addCondition(
//        //                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
//        //                        value == null ? null
//        //                                : new FieldValueOperator<>(
//        //                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
//        //                        QueryOperator.EW, queryPolicy, queryAlias, ignoreStrategy));
//        return ew(classMapping.getPropertyMapping(getPropertyName(name)), value, queryPolicy, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L ew(SerializableStringSupplier property, QueryPolicy queryPolicy) {
//        //  YUFEI_TODO 未测试
//        //        String value = property.get();
//        //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
//        //        JdbcPropertyMapping pm = classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName());
//        //        return (L) addCondition(
//        //                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
//        //                        value == null ? null
//        //                                : new FieldValueOperator<>(
//        //                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
//        //                        QueryOperator.EW, queryPolicy, queryAlias, ignoreStrategy));
//        return ew(classMapping.getPropertyMapping(
//                LambdaUtils.getSerializableSupplierLambdaInfo(property).getSerializedLambdaInfo().getPropertyName()),
//                property.get(), queryPolicy, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L ew(SerializableStringSupplier property, QueryPolicy queryPolicy, Predicate<String> ignoreStrategy) {
//        //  YUFEI_TODO 未测试
//        //        String value = property.get();
//        //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
//        //        JdbcPropertyMapping pm = classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName());
//        //        return (L) addCondition(
//        //                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
//        //                        value == null ? null
//        //                                : new FieldValueOperator<>(
//        //                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
//        //                        QueryOperator.EW, queryPolicy, queryAlias, ignoreStrategy));
//        return ew(classMapping.getPropertyMapping(
//                LambdaUtils.getSerializableSupplierLambdaInfo(property).getSerializedLambdaInfo().getPropertyName()),
//                property.get(), queryPolicy, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L co(SerializableFunction<E, String> name, String value, QueryPolicy queryPolicy) {
//        // YUFEI_TODO 未测试
//        //        JdbcPropertyMapping pm = classMapping.getPropertyMapping(getPropertyName(name));
//        //        return (L) addCondition(
//        //                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
//        //                        value == null ? null
//        //                                : new FieldValueOperator<>(
//        //                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
//        //                        QueryOperator.CO, queryPolicy, queryAlias, ignoreStrategy));
//        return co(classMapping.getPropertyMapping(getPropertyName(name)), value, queryPolicy, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L co(SerializableFunction<E, String> name, String value, QueryPolicy queryPolicy,
//            Predicate<String> ignoreStrategy) {
//        // YUFEI_TODO 未测试
//        //        JdbcPropertyMapping pm = classMapping.getPropertyMapping(getPropertyName(name));
//        //        return (L) addCondition(
//        //                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
//        //                        value == null ? null
//        //                                : new FieldValueOperator<>(
//        //                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
//        //                        QueryOperator.CO, queryPolicy, queryAlias, ignoreStrategy));
//        return co(classMapping.getPropertyMapping(getPropertyName(name)), value, queryPolicy, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L co(SerializableStringSupplier property, QueryPolicy queryPolicy) {
//        //  YUFEI_TODO 未测试
//        //        String value = property.get();
//        //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
//        //        JdbcPropertyMapping pm = classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName());
//        //        return (L) addCondition(
//        //                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
//        //                        value == null ? null
//        //                                : new FieldValueOperator<>(
//        //                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
//        //                        QueryOperator.CO, queryPolicy, queryAlias, ignoreStrategy));
//        return co(classMapping.getPropertyMapping(
//                LambdaUtils.getSerializableSupplierLambdaInfo(property).getSerializedLambdaInfo().getPropertyName()),
//                property.get(), queryPolicy, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L co(SerializableStringSupplier property, QueryPolicy queryPolicy, Predicate<String> ignoreStrategy) {
//        //  YUFEI_TODO 未测试
//        //        String value = property.get();
//        //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
//        //        JdbcPropertyMapping pm = classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName());
//        //        return (L) addCondition(
//        //                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
//        //                        value == null ? null
//        //                                : new FieldValueOperator<>(
//        //                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
//        //                        QueryOperator.CO, queryPolicy, queryAlias, ignoreStrategy));
//        return co(classMapping.getPropertyMapping(
//                LambdaUtils.getSerializableSupplierLambdaInfo(property).getSerializedLambdaInfo().getPropertyName()),
//                property.get(), queryPolicy, ignoreStrategy);
//    }
//
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //
//    //    public <N extends Number> L ge(String name, N value) {
//    //        return (L) addCondition(
//    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
//    //                        QueryOperator.GE, queryAlias, ignoreStrategy));
//    //    }
//
//    //
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //
//    //    public <D extends Date> L ge(String name, D value) {
//    //        return (L) addCondition(
//    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
//    //                        QueryOperator.GE, queryAlias, ignoreStrategy));
//    //    }
//
//    //
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //
//    //    public L ge(String name, LocalTime value) {
//    //        return (L) addCondition(
//    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
//    //                        QueryOperator.GE, queryAlias, ignoreStrategy));
//    //    }
//
//    //
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //
//    //    public L ge(String name, LocalDate value) {
//    //        return (L) addCondition(
//    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
//    //                        QueryOperator.GE, queryAlias, ignoreStrategy));
//    //    }
//
//    //
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //
//    //    public L ge(String name, LocalDateTime value) {
//    //        return (L) addCondition(
//    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
//    //                        QueryOperator.GE, queryAlias, ignoreStrategy));
//    //    }
//
//    //
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //
//    //    public L ge(String name, String value) {
//    //        return (L) addCondition(
//    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
//    //                        QueryOperator.GE, queryAlias, ignoreStrategy));
//    //    }
//
//    //
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //
//    //    public <N extends Number> L gt(String name, N value) {
//    //        return (L) addCondition(
//    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
//    //                        QueryOperator.GT, queryAlias, ignoreStrategy));
//    //    }
//
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //
//    //    public <D extends Date> L gt(String name, D value) {
//    //        return (L) addCondition(
//    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
//    //                        QueryOperator.GT, queryAlias, ignoreStrategy));
//    //    }
//
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //
//    //    public L gt(String name, LocalTime value) {
//    //        return (L) addCondition(
//    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
//    //                        QueryOperator.GT, queryAlias, ignoreStrategy));
//    //    }
//
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //
//    //    public L gt(String name, LocalDate value) {
//    //        return (L) addCondition(
//    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
//    //                        QueryOperator.GT, queryAlias, ignoreStrategy));
//    //    }
//
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //
//    //    public L gt(String name, LocalDateTime value) {
//    //        return (L) addCondition(
//    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
//    //                        QueryOperator.GT, queryAlias, ignoreStrategy));
//    //    }
//
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //
//    //    public L gt(String name, String value) {
//    //        return (L) addCondition(
//    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
//    //                        QueryOperator.GT, queryAlias, ignoreStrategy));
//    //    }
//
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //
//    //    public L in(String name, Object value) {
//    //        return (L) addCondition(
//    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
//    //                        QueryOperator.IN, queryAlias, ignoreStrategy));
//    //    }
//
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //
//    //    public L inn(String name) {
//    //        return inn(name, true);
//    //    }
//
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //
//    //    public L inn(String name, Boolean value) {
//    //        return (L) addCondition(
//    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
//    //                        QueryOperator.INN, queryAlias, ignoreStrategy));
//    //    }
//
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //
//    //    public L isn(String name) {
//    //        return isn(name, true);
//    //    }
//
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //
//    //    public L isn(String name, Boolean value) {
//    //        return (L) addCondition(
//    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
//    //                        QueryOperator.ISN, queryAlias, ignoreStrategy));
//    //    }
//
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //
//    //    public <N extends Number> L le(String name, N value) {
//    //        return (L) addCondition(
//    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
//    //                        QueryOperator.LE, queryAlias, ignoreStrategy));
//    //    }
//
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //
//    //    public <D extends Date> L le(String name, D value) {
//    //        return (L) addCondition(
//    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
//    //                        QueryOperator.LE, queryAlias, ignoreStrategy));
//    //    }
//
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //
//    //    public L le(String name, LocalTime value) {
//    //        return (L) addCondition(
//    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
//    //                        QueryOperator.LE, queryAlias, ignoreStrategy));
//    //    }
//
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //
//    //    public L le(String name, LocalDate value) {
//    //        return (L) addCondition(
//    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
//    //                        QueryOperator.LE, queryAlias, ignoreStrategy));
//    //    }
//
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //
//    //    public L le(String name, LocalDateTime value) {
//    //        return (L) addCondition(
//    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
//    //                        QueryOperator.LE, queryAlias, ignoreStrategy));
//    //    }
//
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //
//    //    public L le(String name, String value) {
//    //        return (L) addCondition(
//    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
//    //                        QueryOperator.LE, queryAlias, ignoreStrategy));
//    //    }
//
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //
//    //    public <N extends Number> L lt(String name, N value) {
//    //        return (L) addCondition(
//    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
//    //                        QueryOperator.LT, queryAlias, ignoreStrategy));
//    //    }
//
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //
//    //    public <D extends Date> L lt(String name, D value) {
//    //        return (L) addCondition(
//    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
//    //                        QueryOperator.LT, queryAlias, ignoreStrategy));
//    //    }
//
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //
//    //    public L lt(String name, LocalTime value) {
//    //        return (L) addCondition(
//    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
//    //                        QueryOperator.LT, queryAlias, ignoreStrategy));
//    //    }
//
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //
//    //    public L lt(String name, LocalDate value) {
//    //        return (L) addCondition(
//    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
//    //                        QueryOperator.LT, queryAlias, ignoreStrategy));
//    //    }
//
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //
//    //    public L lt(String name, LocalDateTime value) {
//    //        return (L) addCondition(
//    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
//    //                        QueryOperator.LT, queryAlias, ignoreStrategy));
//    //    }
//
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //
//    //    public L lt(String name, String value) {
//    //        return (L) addCondition(
//    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
//    //                        QueryOperator.LT, queryAlias, ignoreStrategy));
//    //    }
//
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //
//    //    public L nin(String name, Object value) {
//    //        return (L) addCondition(
//    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
//    //                        QueryOperator.NIN, queryAlias, ignoreStrategy));
//    //    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public C group() {
//        C group = createGroup((L) this);
//        addCondition(group);
//        return group;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L group(Function<C, L> group) {
//        C g = group();
//        return ((GroupEndExpression<C, L>) group.apply(g)).endGroup();
//    }
//
//    /**
//     * Creates the group.
//     *
//     * @param parent     the parent
//     * @param queryAlias the query alias
//     * @return the c
//     */
//    @Override
//    protected abstract C createGroup(L parent);
//
//    /**
//     * Gets the root.
//     *
//     * @return the root
//     */
//    @Override
//    protected AbstractEntitySqlConditionGroupExpressionBaseBak<E, C, L> getRoot() {
//        L p = endGroup();
//        while (p != p.endGroup()) {
//            p = p.endGroup();
//        }
//        return (AbstractEntitySqlConditionGroupExpressionBaseBak<E, C, L>) p;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L endGroup() {
//        if (parent != null) {
//            return parent;
//        } else {
//            return (L) this;
//        }
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public C logic(LogicOperator operator) {
//        AssertIllegalArgument.isNotNull(operator, "operator");
//        return (C) addCondition(new SqlLogicOperatorExpressionBuilder(operator));
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public C and() {
//        return (C) addCondition(new SqlLogicOperatorExpressionBuilder(LogicOperator.AND));
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L and(Function<C, L> group) {
//        return and().group(group);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public C or() {
//        return (C) addCondition(new SqlLogicOperatorExpressionBuilder(LogicOperator.OR));
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L or(Function<C, L> group) {
//        return or().group(group);
//    }
//
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //
//    //    public ObjectExpression<C, L> property(String name) {
//    //        // IMPLSOON 这里后续来实现
//    //        return null;
//    //        //        return new SimpleObjectExpression<C, L>(ClassMappingUtils.getColumnName(name, classMapping), this);
//    //    }
//    //
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //
//    //    public StringExpression<C, L> propertyString(String name) {
//    //        return new SimpleStringExpression<>(ClassMappingUtils.getColumnName(name, classMapping), this);
//    //    }
//    //
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //
//    //    public NumberExpression<C, L> propertyNumber(String name) {
//    //        return new SimpleNumberExpression<>(ClassMappingUtils.getColumnName(name, classMapping), this);
//    //    }
//    //
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //
//    //    public DateExpression<C, L> propertyDate(String name) {
//    //        return new SimpleDateExpression<>(ClassMappingUtils.getColumnName(name, classMapping), this);
//    //    }
//    //
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //
//    //    public EnumExpression<C, L> propertyEnum(String name) {
//    //        return new SimpleEnumExpression<>(ClassMappingUtils.getColumnName(name, classMapping), this);
//    //    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <N extends Number> L ge(SerializableFunction<E, N> name, N value) {
//        return ge0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <N extends Number> L ge(SerializableFunction<E, N> name, N value, Predicate<N> ignoreStrategy) {
//        return ge0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <D extends Date> L ge(SerializableFunction<E, D> name, D value) {
//        return ge0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <D extends Date> L ge(SerializableFunction<E, D> name, D value, Predicate<D> ignoreStrategy) {
//        return ge0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L ge(SerializableFunction<E, LocalTime> name, LocalTime value) {
//        return ge0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L ge(SerializableFunction<E, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
//        return ge0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L ge(SerializableFunction<E, LocalDate> name, LocalDate value) {
//        return ge0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L ge(SerializableFunction<E, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
//        return ge0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L ge(SerializableFunction<E, LocalDateTime> name, LocalDateTime value) {
//        return ge0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L ge(SerializableFunction<E, LocalDateTime> name, LocalDateTime value,
//            Predicate<LocalDateTime> ignoreStrategy) {
//        return ge0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L ge(SerializableFunction<E, String> name, String value) {
//        return ge0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L ge(SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy) {
//        return ge0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <R extends Date> L ge(SerializableDateSupplier<R> property) {
//        return ge0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <R extends Date> L ge(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
//        return ge0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <R extends Number> L ge(SerializableNumberSupplier<R> property) {
//        return ge0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <R extends Number> L ge(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
//        return ge0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L ge(SerializableLocalDateSupplier property) {
//        return ge0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L ge(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
//        return ge0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L ge(SerializableLocalTimeSupplier property) {
//        return ge0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L ge(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
//        return ge0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L ge(SerializableLocalDateTimeSupplier property) {
//        return ge0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L ge(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
//        return ge0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L ge(SerializableStringSupplier property) {
//        return ge0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L ge(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
//        return ge0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <N extends Number> L gt(SerializableFunction<E, N> name, N value) {
//        return gt0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <N extends Number> L gt(SerializableFunction<E, N> name, N value, Predicate<N> ignoreStrategy) {
//        return gt0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <D extends Date> L gt(SerializableFunction<E, D> name, D value) {
//        return gt0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <D extends Date> L gt(SerializableFunction<E, D> name, D value, Predicate<D> ignoreStrategy) {
//        return gt0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L gt(SerializableFunction<E, LocalTime> name, LocalTime value) {
//        return gt0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L gt(SerializableFunction<E, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
//        return gt0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L gt(SerializableFunction<E, LocalDate> name, LocalDate value) {
//        return gt0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L gt(SerializableFunction<E, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
//        return gt0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L gt(SerializableFunction<E, LocalDateTime> name, LocalDateTime value) {
//        return gt0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L gt(SerializableFunction<E, LocalDateTime> name, LocalDateTime value,
//            Predicate<LocalDateTime> ignoreStrategy) {
//        return gt0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L gt(SerializableFunction<E, String> name, String value) {
//        return gt0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L gt(SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy) {
//        return gt0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <R extends Number> L gt(SerializableNumberSupplier<R> property) {
//        return gt0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <R extends Number> L gt(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
//        return gt0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <R extends Date> L gt(SerializableDateSupplier<R> property) {
//        return gt0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <R extends Date> L gt(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
//        return gt0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L gt(SerializableLocalDateSupplier property) {
//        return gt0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L gt(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
//        return gt0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L gt(SerializableLocalTimeSupplier property) {
//        return gt0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L gt(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
//        return gt0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L gt(SerializableLocalDateTimeSupplier property) {
//        return gt0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L gt(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
//        return gt0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L gt(SerializableStringSupplier property) {
//        return gt0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L gt(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
//        return gt0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <R> L in(SerializableFunction<E, R> name, R value) {
//        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <R> L in(SerializableFunction<E, R> name, R value, Predicate<R> ignoreStrategy) {
//        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <R> L in(SerializableFunction<E, R> name, R... value) {
//        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <R> L in(SerializableFunction<E, R> name, R[] value, Predicate<R[]> ignoreStrategy) {
//        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <R> L in(SerializableFunction<E, R> name, Collection<R> value) {
//        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <R> L in(SerializableFunction<E, R> name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy) {
//        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <R> L in(SerializableSupplier<R> property) {
//        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
//        return in(classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), property.get(),
//                ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <R> L in(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
//        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
//        return in(classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), property.get(),
//                ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <R> L nin(SerializableFunction<E, R> name, R value) {
//        return nin(classMapping.getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <R> L nin(SerializableFunction<E, R> name, R value, Predicate<R> ignoreStrategy) {
//        return nin(classMapping.getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <R> L nin(SerializableFunction<E, R> name, R... value) {
//        return nin(classMapping.getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <R> L nin(SerializableFunction<E, R> name, R[] value, Predicate<R[]> ignoreStrategy) {
//        return nin(classMapping.getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <R> L nin(SerializableFunction<E, R> name, Collection<R> value) {
//        return nin(classMapping.getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <R> L nin(SerializableFunction<E, R> name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy) {
//        return nin(classMapping.getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <R> L nin(SerializableSupplier<R> property) {
//        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
//        return nin(classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), property.get(),
//                ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <R> L nin(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
//        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
//        return nin(classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), property.get(),
//                ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <R> L inn(SerializableFunction<E, R> name, Boolean value) {
//        return inn(classMapping.getPropertyMapping(getPropertyName(name)), value);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <R> L isn(SerializableFunction<E, R> name, Boolean value) {
//        return isn(classMapping.getPropertyMapping(getPropertyName(name)), value);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <N extends Number> L le(SerializableFunction<E, N> name, N value) {
//        return le0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <N extends Number> L le(SerializableFunction<E, N> name, N value, Predicate<N> ignoreStrategy) {
//        return le0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <D extends Date> L le(SerializableFunction<E, D> name, D value) {
//        return le0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <D extends Date> L le(SerializableFunction<E, D> name, D value, Predicate<D> ignoreStrategy) {
//        return le0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L le(SerializableFunction<E, LocalTime> name, LocalTime value) {
//        return le0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L le(SerializableFunction<E, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
//        return le0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L le(SerializableFunction<E, LocalDate> name, LocalDate value) {
//        return le0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L le(SerializableFunction<E, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
//        return le0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L le(SerializableFunction<E, LocalDateTime> name, LocalDateTime value) {
//        return le0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L le(SerializableFunction<E, LocalDateTime> name, LocalDateTime value,
//            Predicate<LocalDateTime> ignoreStrategy) {
//        return le0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L le(SerializableFunction<E, String> name, String value) {
//        return le0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L le(SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy) {
//        return le0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <R extends Date> L le(SerializableDateSupplier<R> property) {
//        return le0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <R extends Date> L le(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
//        return le0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <R extends Number> L le(SerializableNumberSupplier<R> property) {
//        return le0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <R extends Number> L le(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
//        return le0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L le(SerializableLocalDateSupplier property) {
//        return le0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L le(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
//        return le0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L le(SerializableLocalTimeSupplier property) {
//        return le0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L le(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
//        return le0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L le(SerializableLocalDateTimeSupplier property) {
//        return le0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L le(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
//        return le0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L le(SerializableStringSupplier property) {
//        return le0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L le(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
//        return le0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <N extends Number> L lt(SerializableFunction<E, N> name, N value) {
//        return lt0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <N extends Number> L lt(SerializableFunction<E, N> name, N value, Predicate<N> ignoreStrategy) {
//        return lt0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <D extends Date> L lt(SerializableFunction<E, D> name, D value) {
//        return lt0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <D extends Date> L lt(SerializableFunction<E, D> name, D value, Predicate<D> ignoreStrategy) {
//        return lt0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L lt(SerializableFunction<E, LocalTime> name, LocalTime value) {
//        return lt0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L lt(SerializableFunction<E, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
//        return lt0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L lt(SerializableFunction<E, LocalDate> name, LocalDate value) {
//        return lt0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L lt(SerializableFunction<E, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
//        return lt0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L lt(SerializableFunction<E, LocalDateTime> name, LocalDateTime value) {
//        return lt0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L lt(SerializableFunction<E, LocalDateTime> name, LocalDateTime value,
//            Predicate<LocalDateTime> ignoreStrategy) {
//        return lt0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L lt(SerializableFunction<E, String> name, String value) {
//        return lt0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L lt(SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy) {
//        return lt0(name, value, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <R extends Number> L lt(SerializableNumberSupplier<R> property) {
//        return lt0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <R extends Number> L lt(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
//        return lt0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <R extends Date> L lt(SerializableDateSupplier<R> property) {
//        return lt0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public <R extends Date> L lt(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
//        return lt0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L lt(SerializableLocalDateSupplier property) {
//        return lt0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L lt(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
//        return lt0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L lt(SerializableLocalTimeSupplier property) {
//        return lt0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L lt(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
//        return lt0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L lt(SerializableLocalDateTimeSupplier property) {
//        return lt0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L lt(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
//        return lt0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L lt(SerializableStringSupplier property) {
//        return lt0(property, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//
//    @Override
//    public L lt(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
//        return lt0(property, ignoreStrategy);
//    }
//
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //
//    //    public L expression(String expression, final Map<String, Object> params) {
//    //        final Execution execution = SqlUtils.convertNamedParamSql(expression, params);
//    //        return expression(execution.getExecution(), execution.getParams());
//    //    }
//    //
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //
//    //    public L expression(String expression, Object... params) {
//    //        return (L) addCondition(new ParamedExpression() {
//    //
//    //
//    //            public String expression() {
//    //                return expression;
//    //            }
//    //
//    //
//    //            public Object getParam() {
//    //                return params;
//    //            }
//    //        });
//    //    }
//
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //
//    //    public <R> ObjectExpression<C, L> property(SerializableFunction<E, R> name) {
//    //        return property(getPropertyName(name));
//    //    }
//
//    @Override
//    public C setIgnorePolicy(Predicate<Object> ignoreStrategy) {
//        AssertIllegalArgument.isNotNull(ignoreStrategy, "ignoreStrategy");
//        this.ignoreStrategy = ignoreStrategy;
//        return (C) this;
//    }
//
//    // ********************************************************************
//    // private method
//    // ********************************************************************
//
//    @Override
//    protected <R> FieldValueOperator<R> getFieldValueOperator(JdbcPropertyMapping pm, R value) {
//        return value == null ? null : FieldValueOperator.create(pm, value);
//    }
//
//    @Override
//    protected Object getInParam(JdbcPropertyMapping pm, Object value) {
//        Object param = null;
//        if (value != null) {
//            if (value.getClass().isArray()) {
//                int length = Array.getLength(value);
//                param = Array.newInstance(FieldValueOperator.class, length);
//                for (int i = 0; i < length; i++) {
//                    //                    Array.set(param, i, new FieldValueOperator(pm.getJavaTypeSqlTypeOperator(), Array.get(value, i)));
//                    Array.set(param, i, FieldValueOperator.create(pm, Array.get(value, i)));
//                }
//            } else if (value instanceof Collection) {
//                param = new ArrayList<>();
//                for (Object op : (Collection<?>) value) {
//                    ((Collection<FieldValueOperator<?>>) param).add(FieldValueOperator.create(pm, op));
//                    //                    .add(new FieldValueOperator(pm.getJavaTypeSqlTypeOperator(), op));
//                }
//            } else if (!(value instanceof FieldValueOperator)) {
//                param = FieldValueOperator.create(pm, value);
//            } else {
//                param = value;
//            }
//        }
//        return param;
//    }
//
//    private <T, R> L eq_ne0(QueryOperator queryOperator, JdbcPropertyMapping pm, R value, QueryPolicy queryPolicy,
//            Predicate<R> ignoreStrategy) {
//        return eq_ne0(queryOperator, queryAlias, pm, value, queryPolicy, ignoreStrategy);
//    }
//
//    @Override
//    protected <T, R> L eq_ne0(QueryOperator queryOperator, String queryAlias, JdbcPropertyMapping pm, R value,
//            QueryPolicy queryPolicy, Predicate<R> ignoreStrategy) {
//        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
//                getFieldValueOperator(pm, value), queryOperator, queryPolicy, queryAlias, ignoreStrategy));
//    }
//
//    private <T, R> L eq_ne(QueryOperator queryOperator, JdbcPropertyMapping pm, R value, QueryPolicy queryPolicy,
//            Predicate<Object> ignoreStrategy) {
//        AssertIllegalArgument.isNotNull(ignoreStrategy, "ignoreStrategy");
//        if (value != null) {
//            //            if (Lang.isNotEmpty(pm.getPropertyMappings())) {
//            if (pm.getMode() == Mode.MANY_TO_ONE || pm.getMode() == Mode.EMBEDDED) {
//                L logic = null;
//                C condition = (C) this;
//                boolean groupable = pm.getPropertyMappings().size() > 1;
//                if (groupable) {
//                    condition = group();
//                }
//                if (ClassUtils.isParent(pm.getPropertyType(), value.getClass())) {
//                    BeanDescriptor<?> bd = BeanDescriptor.getBeanDescriptor(value.getClass());
//
//                    for (JdbcPropertyMapping spm : pm.getPropertyMappings()) {
//                        Object ov = bd.getBeanProperty(spm.getPropertyName()).getValue(value);
//                        if (logic != null) {
//                            condition = logic.and();
//                        }
//                        logic = ((AbstractEntitySqlConditionGroupExpressionBaseBak<E, C, L>) condition)
//                                .eq_ne0(queryOperator, spm, ov, queryPolicy, ignoreStrategy);
//                    }
//
//                    //                    if (pm.getMode() == Mode.EMBEDDED) {
//                    //                        for (JdbcPropertyMapping spm : pm.getPropertyMappings()) {
//                    //                            Object ov = bd.getBeanProperty(spm.getPropertyName()).getValue(value);
//                    //                            if (logic != null) {
//                    //                                condition = logic.and();
//                    //                            }
//                    //                            logic = ((AbstractEntitySqlConditionGroupExpression<E, C, L>) condition)
//                    //                                    .eq_ne0(queryOperator, spm, ov, queryPolicy);
//                    //                        }
//                    //                    } else if (pm.getMode() == Mode.MANY_TO_ONE) {
//                    //                        JdbcClassMapping<?> cm = factory.getClassMapping(pm.getPropertyType());
//                    //                        for (JdbcPropertyMapping cpm : cm.getPropertyMappings()) {
//                    //                            // IMPLSOON 后续来实现关联对象的联表查询
//                    //                            Object ov = bd.getBeanProperty(cpm.getPropertyName()).getValue(value);
//                    //                            if (logic != null) {
//                    //                                condition = logic.and();
//                    //                            }
//                    //                            logic = ((AbstractEntitySqlConditionGroupExpression<E, C, L>) condition)
//                    //                                    .eq_ne0(queryOperator, "", cpm, ov, queryPolicy);
//                    //                        }
//                    //                    } else {
//                    //                        // FIXME 后续来实现
//                    //                        throw new SqldbHammerException("not support");
//                    //                    }
//                    if (groupable) {
//                        logic = logic.endGroup();
//                    }
//                    return logic;
//                } else {
//                    for (JdbcPropertyMapping spm : pm.getPropertyMappings()) {
//                        if (ClassUtils.isParent(spm.getPropertyType(), value.getClass())) {
//                            return eq_ne0(queryOperator, spm, value, queryPolicy, ignoreStrategy);
//                        }
//                    }
//                }
//            }
//        }
//        return eq_ne0(queryOperator, pm, value, queryPolicy, ignoreStrategy);
//    }
//
//    private <T> L sw(JdbcPropertyMapping pm, String value, QueryPolicy queryPolicy, Predicate<?> ignoreStrategy) {
//        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
//                getFieldValueOperator(pm, value), QueryOperator.SW, queryPolicy, queryAlias, ignoreStrategy));
//    }
//
//    private <T> L co(JdbcPropertyMapping pm, String value, QueryPolicy queryPolicy, Predicate<?> ignoreStrategy) {
//        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
//                getFieldValueOperator(pm, value), QueryOperator.CO, queryPolicy, queryAlias, ignoreStrategy));
//    }
//
//    private <T> L ew(JdbcPropertyMapping pm, String value, QueryPolicy queryPolicy, Predicate<?> ignoreStrategy) {
//        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
//                getFieldValueOperator(pm, value), QueryOperator.EW, queryPolicy, queryAlias, ignoreStrategy));
//    }
//
//    private <T> L lk(JdbcPropertyMapping pm, String value, QueryPolicy queryPolicy, Predicate<?> ignoreStrategy) {
//        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
//                getFieldValueOperator(pm, value), QueryOperator.LK, queryPolicy, queryAlias, ignoreStrategy));
//    }
//
//    private <T, R> L in(JdbcPropertyMapping pm, R value, Predicate<?> ignoreStrategy) {
//        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
//                getInParam(pm, value), QueryOperator.IN, queryAlias, ignoreStrategy));
//    }
//
//    private <R> L nin(JdbcPropertyMapping pm, R value, Predicate<?> ignoreStrategy) {
//        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
//                getInParam(pm, value), QueryOperator.NIN, queryAlias, ignoreStrategy));
//    }
//
//    private L isn(JdbcPropertyMapping pm, Boolean value) {
//        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(), value,
//                QueryOperator.ISN, queryAlias, ignoreStrategy));
//    }
//
//    private L inn(JdbcPropertyMapping pm, Boolean value) {
//        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(), value,
//                QueryOperator.INN, queryAlias, ignoreStrategy));
//    }
//
//    private <V> L ge0(SerializableFunction<E, V> name, V value, Predicate<?> ignoreStrategy) {
//        return ge0(classMapping.getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
//    }
//
//    private <V> L ge0(SerializableSupplier<V> property, Predicate<?> ignoreStrategy) {
//        return ge0(classMapping.getPropertyMapping(
//                LambdaUtils.getSerializableSupplierLambdaInfo(property).getSerializedLambdaInfo().getPropertyName()),
//                property.get(), ignoreStrategy);
//    }
//
//    private <V> L ge0(JdbcPropertyMapping pm, V value, Predicate<?> ignoreStrategy) {
//        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
//                getFieldValueOperator(pm, value), QueryOperator.GE, queryAlias, ignoreStrategy));
//    }
//
//    private <V> L gt0(SerializableFunction<E, V> name, V value, Predicate<?> ignoreStrategy) {
//        return gt0(classMapping.getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
//    }
//
//    private <V> L gt0(SerializableSupplier<V> property, Predicate<?> ignoreStrategy) {
//        return gt0(classMapping.getPropertyMapping(
//                LambdaUtils.getSerializableSupplierLambdaInfo(property).getSerializedLambdaInfo().getPropertyName()),
//                property.get(), ignoreStrategy);
//    }
//
//    private <V> L gt0(JdbcPropertyMapping pm, V value, Predicate<?> ignoreStrategy) {
//        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
//                getFieldValueOperator(pm, value), QueryOperator.GT, queryAlias, ignoreStrategy));
//    }
//
//    private <V> L le0(SerializableFunction<E, V> name, V value, Predicate<?> ignoreStrategy) {
//        return le0(classMapping.getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
//    }
//
//    private <V> L le0(SerializableSupplier<V> property, Predicate<?> ignoreStrategy) {
//        return le0(classMapping.getPropertyMapping(
//                LambdaUtils.getSerializableSupplierLambdaInfo(property).getSerializedLambdaInfo().getPropertyName()),
//                property.get(), ignoreStrategy);
//    }
//
//    private <V> L le0(JdbcPropertyMapping pm, V value, Predicate<?> ignoreStrategy) {
//        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
//                getFieldValueOperator(pm, value), QueryOperator.LE, queryAlias, ignoreStrategy));
//    }
//
//    private <V> L lt0(SerializableFunction<E, V> name, V value, Predicate<?> ignoreStrategy) {
//        return lt0(classMapping.getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
//    }
//
//    private <V> L lt0(SerializableSupplier<V> property, Predicate<?> ignoreStrategy) {
//        return lt0(classMapping.getPropertyMapping(
//                LambdaUtils.getSerializableSupplierLambdaInfo(property).getSerializedLambdaInfo().getPropertyName()),
//                property.get(), ignoreStrategy);
//    }
//
//    private <V> L lt0(JdbcPropertyMapping pm, V value, Predicate<?> ignoreStrategy) {
//        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
//                getFieldValueOperator(pm, value), QueryOperator.LT, queryAlias, ignoreStrategy));
//    }
//
//    // ********************************************************************
//    // protected method
//    // ********************************************************************
//
//    /**
//     * Supplier.
//     *
//     * @param <R>   the generic type
//     * @param info  the info
//     * @param value the value
//     * @return the list
//     */
//    @Override
//    protected <R> List<Tuple2<String, Optional<R>>> supplier(SerializedLambdaInfo info, R value) {
//        return supplier(info, value, classMapping);
//    }
//
//    /**
//     * Supplier.
//     *
//     * @param <R>  the generic type
//     * @param info the info
//     * @return the list
//     */
//    @Override
//    protected <R> List<Tuple2<String, Optional<R>>> supplier(SerializableSupplierLambdaInfo<R> info) {
//        return supplier(info, classMapping);
//    }
//
//    // ********************************************************************
//    // property
//    // ********************************************************************
//
//    /**
//     * Gets the query alias.
//     *
//     * @return queryAlias
//     */
//    @Override
//    protected String getQueryAlias() {
//        return queryAlias;
//    }
//}
