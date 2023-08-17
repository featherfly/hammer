
package cn.featherfly.hammer.sqldb.sql.dml;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.db.FieldValueOperator;
import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LambdaUtils.SerializableSupplierLambdaInfo;
import cn.featherfly.common.lang.LambdaUtils.SerializedLambdaInfo;
import cn.featherfly.common.lang.function.SerializableDateSupplier;
import cn.featherfly.common.lang.function.SerializableDoubleSupplier;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableIntSupplier;
import cn.featherfly.common.lang.function.SerializableLocalDateSupplier;
import cn.featherfly.common.lang.function.SerializableLocalDateTimeSupplier;
import cn.featherfly.common.lang.function.SerializableLocalTimeSupplier;
import cn.featherfly.common.lang.function.SerializableLongSupplier;
import cn.featherfly.common.lang.function.SerializableNumberSupplier;
import cn.featherfly.common.lang.function.SerializableStringSupplier;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.common.lang.function.SerializableToCollectionFunction;
import cn.featherfly.common.lang.function.SerializableToDateFunction;
import cn.featherfly.common.lang.function.SerializableToDoubleFunction;
import cn.featherfly.common.lang.function.SerializableToEnumFunction;
import cn.featherfly.common.lang.function.SerializableToIntFunction;
import cn.featherfly.common.lang.function.SerializableToLocalDateFunction;
import cn.featherfly.common.lang.function.SerializableToLocalDateTimeFunction;
import cn.featherfly.common.lang.function.SerializableToLocalTimeFunction;
import cn.featherfly.common.lang.function.SerializableToLongFunction;
import cn.featherfly.common.lang.function.SerializableToNumberFunction;
import cn.featherfly.common.lang.function.SerializableToStringFunction;
import cn.featherfly.common.operator.QueryOperator;
import cn.featherfly.common.operator.QueryOperator.QueryPolicy;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.EntityPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.co.EntityContainsExpression;
import cn.featherfly.hammer.expression.entity.condition.eq.EntityEqualsExpression;
import cn.featherfly.hammer.expression.entity.condition.ew.EntityEndWithExpression;
import cn.featherfly.hammer.expression.entity.condition.ge.EntityGreatEqualsExpression;
import cn.featherfly.hammer.expression.entity.condition.gt.EntityGreatThanExpression;
import cn.featherfly.hammer.expression.entity.condition.in.EntityInExpression;
import cn.featherfly.hammer.expression.entity.condition.inn.EntityIsNotNullExpression;
import cn.featherfly.hammer.expression.entity.condition.isn.EntityIsNullExpression;
import cn.featherfly.hammer.expression.entity.condition.le.EntityLessEqualsExpression;
import cn.featherfly.hammer.expression.entity.condition.lk.EntityLikeExpression;
import cn.featherfly.hammer.expression.entity.condition.lt.EntityLessThanExpression;
import cn.featherfly.hammer.expression.entity.condition.ne.EntityNotEqualsExpression;
import cn.featherfly.hammer.expression.entity.condition.nin.EntityNotInExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityDatePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityEnumPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityLocalDatePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityLocalDateTimePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityLocalTimePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityNumberPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityPropertyTypeExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityStringPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.sw.EntityStartWithExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlRelation.EntityRelationMapping;

/**
 * sql condition group builder sql条件逻辑组构造器 .
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
@SuppressWarnings("unchecked")
public abstract class AbstractEntitySqlConditionExpressionBase<E, ER extends EntitySqlRelation<ER, B>,
        B extends SqlBuilder, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractSqlConditionExpression<C, L>
        implements EntityContainsExpression<E, C, L>, EntityEndWithExpression<E, C, L>, EntityEqualsExpression<E, C, L>,
        EntityGreatEqualsExpression<E, C, L>, EntityGreatThanExpression<E, C, L>, EntityInExpression<E, C, L>,
        EntityIsNotNullExpression<E, C, L>, EntityIsNullExpression<E, C, L>, EntityLessEqualsExpression<E, C, L>,
        EntityLessThanExpression<E, C, L>, EntityNotEqualsExpression<E, C, L>, EntityNotInExpression<E, C, L>,
        EntityStartWithExpression<E, C, L>, EntityLikeExpression<E, C, L>, EntityPropertyExpression<E, C, L> {

    //    /** The type query entity. */
    //    protected EntitySqlQuery<E> entityQuery;

    /** The factory. */
    protected JdbcMappingFactory factory;

    /** The alias manager. */
    protected AliasManager aliasManager;

    /** The class mapping. */
    protected JdbcClassMapping<E> classMapping;

    /** The ignore strategy. */
    protected Predicate<?> ignoreStrategy;

    /** The query alias. */
    protected String queryAlias;

    /** The entity sql relation. */
    protected ER entityRelation;

    /**
     * Instantiates a new abstract sql condition group expression.
     *
     * @param parent         parent group
     * @param factory        the factory
     * @param entityRelation the entity relation
     */
    protected AbstractEntitySqlConditionExpressionBase(L parent, JdbcMappingFactory factory, ER entityRelation) {
        super(parent, entityRelation.getJdbc().getDialect(), entityRelation.getIgnorePolicy());
        this.factory = factory;
        EntityRelationMapping<
                E> erm = (EntityRelationMapping<E>) entityRelation.getEntityRelationMappingTuple().getOrNull0();
        queryAlias = erm.getTableAlias();
        classMapping = erm.getClassMapping();
        aliasManager = entityRelation.getAliasManager();
        ignoreStrategy = entityRelation.getIgnorePolicy();
        this.entityRelation = entityRelation;
    }
    //    /**
    //     * Instantiates a new abstract sql condition group expression.
    //     *
    //     * @param parent         parent group
    //     * @param dialect        dialect
    //     * @param sqlPageFactory the sql page factory
    //     * @param queryAlias     queryAlias
    //     * @param classMapping   classMapping
    //     * @param factory        the factory
    //     * @param aliasManager   the alias manager
    //     * @param entityQuery    the entity query
    //     * @param ignoreStrategy   the ignore strategy
    //     */
    //    protected AbstractEntitySqlConditionGroupExpressionBase(L parent, Dialect dialect, SqlPageFactory sqlPageFactory,
    //            String queryAlias, JdbcClassMapping<E> classMapping, JdbcMappingFactory factory, AliasManager aliasManager,
    //            EntitySqlQuery<E> entityQuery, Predicate<Object> ignoreStrategy) {
    //        super(dialect, ignoreStrategy, parent);
    //        this.queryAlias = queryAlias;
    //        this.sqlPageFactory = sqlPageFactory;
    //        this.classMapping = classMapping;
    //        this.factory = factory;
    //        this.aliasManager = aliasManager;
    //        this.entityQuery = entityQuery;
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAlias(int index) {
        return entityRelation.getEntityRelationMapping(index).getTableAlias();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <CM extends ClassMapping<T, P>, T, P extends PropertyMapping<P>> CM getClassMapping(int index) {
        return (CM) entityRelation.getEntityRelationMapping(index).getClassMapping();
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L eq(SerializableFunction<E, R> name, R value, QueryPolicy queryPolicy) {
        return eq(classMapping, name, value, queryAlias, queryPolicy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L eq(SerializableFunction<E, R> name, R value, QueryPolicy queryPolicy, Predicate<R> ignoreStrategy) {
        return eq(classMapping, name, value, queryAlias, queryPolicy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L eq(SerializableSupplier<R> property, QueryPolicy queryPolicy) {
        return eq(classMapping, property, queryAlias, queryPolicy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L eq(SerializableSupplier<R> property, QueryPolicy queryPolicy, Predicate<R> ignoreStrategy) {
        return eq(classMapping, property, queryAlias, queryPolicy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public < R> L ne(SerializableFunction<E, R> name, R value) {
    //        //        return ne(getPropertyName(name), value);
    //        List<Tuple2<String, Optional<R>>> tuples = supplier(LambdaUtils.getLambdaInfo(name), value);
    //        L l = null;
    //        C c = (C) this;
    //        if (tuples.size() > 1) {
    //            c = group();
    //        }
    //        for (Tuple2<String, Optional<R>> tuple : tuples) {
    //            if (l != null) {
    //                c = l.and();
    //            }
    //            l = c.ne(tuple.get0(), tuple.get1().orElseGet(() -> null));
    //        }
    //        if (tuples.size() > 1) {
    //            l = l.endGroup();
    //        }
    //        return l;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public <R> L ne(SerializableSupplier<R> property) {
    //        //        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //        //        return ne(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    //        List<Tuple2<String, Optional<R>>> tuples = supplier(LambdaUtils.getSerializableSupplierLambdaInfo(property));
    //        L l = null;
    //        C c = (C) this;
    //        if (tuples.size() > 1) {
    //            c = group();
    //        }
    //        for (Tuple2<String, Optional<R>> tuple : tuples) {
    //            if (l != null) {
    //                c = l.and();
    //            }
    //            l = c.ne(tuple.get0(), tuple.get1().orElseGet(() -> null));
    //        }
    //        if (tuples.size() > 1) {
    //            l = l.endGroup();
    //        }
    //        return l;
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ne(SerializableFunction<E, R> name, R value, QueryPolicy queryPolicy) {
        return ne(classMapping, name, value, queryAlias, queryPolicy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ne(SerializableFunction<E, R> name, R value, QueryPolicy queryPolicy, Predicate<R> ignoreStrategy) {
        return ne(classMapping, name, value, queryAlias, queryPolicy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ne(SerializableSupplier<R> property, QueryPolicy queryPolicy) {
        return ne(classMapping, property, queryAlias, queryPolicy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ne(SerializableSupplier<R> property, QueryPolicy queryPolicy, Predicate<R> ignoreStrategy) {
        return ne(classMapping, property, queryAlias, queryPolicy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(SerializableFunction<E, String> name, String value, QueryPolicy queryPolicy) {
        // YUFEI_TODO 未测试
        //        JdbcPropertyMapping pm = classMapping.getPropertyMapping(getPropertyName(name));
        //        return (L) addCondition(
        //                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
        //                        value == null ? null
        //                                : new FieldValueOperator<>(
        //                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
        //                        QueryOperator.LK, queryPolicy, queryAlias, ignoreStrategy));
        //        return lk(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, queryPolicy, ignoreStrategy);
        return lk(classMapping, name, value, queryAlias, queryPolicy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(SerializableFunction<E, String> name, String value, QueryPolicy queryPolicy,
            Predicate<String> ignoreStrategy) {
        // YUFEI_TODO 未测试
        //        JdbcPropertyMapping pm = classMapping.getPropertyMapping(getPropertyName(name));
        //        return (L) addCondition(
        //                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
        //                        value == null ? null
        //                                : new FieldValueOperator<>(
        //                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
        //                        QueryOperator.LK, queryPolicy, queryAlias, ignoreStrategy));
        //        return lk(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, queryPolicy, ignoreStrategy);
        return lk(classMapping, name, value, queryAlias, queryPolicy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(SerializableStringSupplier property, QueryPolicy queryPolicy) {
        //  YUFEI_TODO 未测试
        //        String value = property.get();
        //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        JdbcPropertyMapping pm = classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName());
        //        return (L) addCondition(
        //                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
        //                        value == null ? null
        //                                : new FieldValueOperator<>(
        //                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
        //                        QueryOperator.LK, queryPolicy, queryAlias, ignoreStrategy));
        //        return lk(
        //                classMapping.getPropertyMapping(LambdaUtils.getSerializableSupplierLambdaInfo(property)
        //                        .getSerializedLambdaInfo().getPropertyName()),
        //                property.get(), queryAlias, queryPolicy, ignoreStrategy);
        return lk(classMapping, property, queryAlias, queryPolicy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(SerializableStringSupplier property, QueryPolicy queryPolicy, Predicate<String> ignoreStrategy) {
        //  YUFEI_TODO 未测试
        //        String value = property.get();
        //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        JdbcPropertyMapping pm = classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName());
        //        return (L) addCondition(
        //                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
        //                        value == null ? null
        //                                : new FieldValueOperator<>(
        //                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
        //                        QueryOperator.LK, queryPolicy, queryAlias, ignoreStrategy));
        //        return lk(
        //                classMapping.getPropertyMapping(LambdaUtils.getSerializableSupplierLambdaInfo(property)
        //                        .getSerializedLambdaInfo().getPropertyName()),
        //                property.get(), queryAlias, queryPolicy, ignoreStrategy);
        return lk(classMapping, property, queryAlias, queryPolicy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(SerializableFunction<E, String> name, String value, QueryPolicy queryPolicy) {
        // YUFEI_TODO 未测试
        //        JdbcPropertyMapping pm = classMapping.getPropertyMapping(getPropertyName(name));
        //        return (L) addCondition(
        //                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
        //                        value == null ? null
        //                                : new FieldValueOperator<>(
        //                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
        //                        QueryOperator.SW, queryPolicy, queryAlias, ignoreStrategy));
        //        return sw(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, queryPolicy, ignoreStrategy);
        return sw(classMapping, name, value, queryAlias, queryPolicy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(SerializableFunction<E, String> name, String value, QueryPolicy queryPolicy,
            Predicate<String> ignoreStrategy) {
        // YUFEI_TODO 未测试
        //        JdbcPropertyMapping pm = classMapping.getPropertyMapping(getPropertyName(name));
        //        return (L) addCondition(
        //                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
        //                        value == null ? null
        //                                : new FieldValueOperator<>(
        //                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
        //                        QueryOperator.SW, queryPolicy, queryAlias, ignoreStrategy));
        //        return sw(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, queryPolicy, ignoreStrategy);
        return sw(classMapping, name, value, queryAlias, queryPolicy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(SerializableStringSupplier property, QueryPolicy queryPolicy) {
        //  YUFEI_TODO 未测试
        //        String value = property.get();
        //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        JdbcPropertyMapping pm = classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName());
        //        return (L) addCondition(
        //                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
        //                        value == null ? null
        //                                : new FieldValueOperator<>(
        //                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
        //                        QueryOperator.SW, queryPolicy, queryAlias, ignoreStrategy));
        //        return sw(
        //                classMapping.getPropertyMapping(LambdaUtils.getSerializableSupplierLambdaInfo(property)
        //                        .getSerializedLambdaInfo().getPropertyName()),
        //                property.get(), queryAlias, queryPolicy, ignoreStrategy);
        return sw(classMapping, property, queryAlias, queryPolicy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(SerializableStringSupplier property, QueryPolicy queryPolicy, Predicate<String> ignoreStrategy) {
        //  YUFEI_TODO 未测试
        //        String value = property.get();
        //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        JdbcPropertyMapping pm = classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName());
        //        return (L) addCondition(
        //                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
        //                        value == null ? null
        //                                : new FieldValueOperator<>(
        //                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
        //                        QueryOperator.SW, queryPolicy, queryAlias, ignoreStrategy));
        //        return sw(
        //                classMapping.getPropertyMapping(LambdaUtils.getSerializableSupplierLambdaInfo(property)
        //                        .getSerializedLambdaInfo().getPropertyName()),
        //                property.get(), queryAlias, queryPolicy, ignoreStrategy);
        return sw(classMapping, property, queryAlias, queryPolicy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(SerializableFunction<E, String> name, String value, QueryPolicy queryPolicy) {
        // YUFEI_TODO 未测试
        //        JdbcPropertyMapping pm = classMapping.getPropertyMapping(getPropertyName(name));
        //        return (L) addCondition(
        //                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
        //                        value == null ? null
        //                                : new FieldValueOperator<>(
        //                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
        //                        QueryOperator.EW, queryPolicy, queryAlias, ignoreStrategy));
        //        return ew(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, queryPolicy, ignoreStrategy);
        return sw(classMapping, name, value, queryAlias, queryPolicy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(SerializableFunction<E, String> name, String value, QueryPolicy queryPolicy,
            Predicate<String> ignoreStrategy) {
        // YUFEI_TODO 未测试
        //        JdbcPropertyMapping pm = classMapping.getPropertyMapping(getPropertyName(name));
        //        return (L) addCondition(
        //                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
        //                        value == null ? null
        //                                : new FieldValueOperator<>(
        //                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
        //                        QueryOperator.EW, queryPolicy, queryAlias, ignoreStrategy));
        //        return ew(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, queryPolicy, ignoreStrategy);
        return sw(classMapping, name, value, queryAlias, queryPolicy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(SerializableStringSupplier property, QueryPolicy queryPolicy) {
        //  YUFEI_TODO 未测试
        //        String value = property.get();
        //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        JdbcPropertyMapping pm = classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName());
        //        return (L) addCondition(
        //                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
        //                        value == null ? null
        //                                : new FieldValueOperator<>(
        //                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
        //                        QueryOperator.EW, queryPolicy, queryAlias, ignoreStrategy));
        //        return ew(
        //                classMapping.getPropertyMapping(LambdaUtils.getSerializableSupplierLambdaInfo(property)
        //                        .getSerializedLambdaInfo().getPropertyName()),
        //                property.get(), queryAlias, queryPolicy, ignoreStrategy);
        return sw(classMapping, property, queryAlias, queryPolicy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(SerializableStringSupplier property, QueryPolicy queryPolicy, Predicate<String> ignoreStrategy) {
        //  YUFEI_TODO 未测试
        //        String value = property.get();
        //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        JdbcPropertyMapping pm = classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName());
        //        return (L) addCondition(
        //                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
        //                        value == null ? null
        //                                : new FieldValueOperator<>(
        //                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
        //                        QueryOperator.EW, queryPolicy, queryAlias, ignoreStrategy));
        //        return ew(
        //                classMapping.getPropertyMapping(LambdaUtils.getSerializableSupplierLambdaInfo(property)
        //                        .getSerializedLambdaInfo().getPropertyName()),
        //                property.get(), queryAlias, queryPolicy, ignoreStrategy);
        return sw(classMapping, property, queryAlias, queryPolicy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(SerializableFunction<E, String> name, String value, QueryPolicy queryPolicy) {
        // YUFEI_TODO 未测试
        //        JdbcPropertyMapping pm = classMapping.getPropertyMapping(getPropertyName(name));
        //        return (L) addCondition(
        //                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
        //                        value == null ? null
        //                                : new FieldValueOperator<>(
        //                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
        //                        QueryOperator.CO, queryPolicy, queryAlias, ignoreStrategy));
        //        return co(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, queryPolicy, ignoreStrategy);
        return co(classMapping, name, value, queryAlias, queryPolicy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(SerializableFunction<E, String> name, String value, QueryPolicy queryPolicy,
            Predicate<String> ignoreStrategy) {
        // YUFEI_TODO 未测试
        //        JdbcPropertyMapping pm = classMapping.getPropertyMapping(getPropertyName(name));
        //        return (L) addCondition(
        //                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
        //                        value == null ? null
        //                                : new FieldValueOperator<>(
        //                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
        //                        QueryOperator.CO, queryPolicy, queryAlias, ignoreStrategy));
        //        return co(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, queryPolicy, ignoreStrategy);
        return co(classMapping, name, value, queryAlias, queryPolicy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(SerializableStringSupplier property, QueryPolicy queryPolicy) {
        //  YUFEI_TODO 未测试
        //        String value = property.get();
        //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        JdbcPropertyMapping pm = classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName());
        //        return (L) addCondition(
        //                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
        //                        value == null ? null
        //                                : new FieldValueOperator<>(
        //                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
        //                        QueryOperator.CO, queryPolicy, queryAlias, ignoreStrategy));
        //        return co(
        //                classMapping.getPropertyMapping(LambdaUtils.getSerializableSupplierLambdaInfo(property)
        //                        .getSerializedLambdaInfo().getPropertyName()),
        //                property.get(), queryAlias, queryPolicy, ignoreStrategy);
        return co(classMapping, property, queryAlias, queryPolicy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(SerializableStringSupplier property, QueryPolicy queryPolicy, Predicate<String> ignoreStrategy) {
        //  YUFEI_TODO 未测试
        //        String value = property.get();
        //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        JdbcPropertyMapping pm = classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName());
        //        return (L) addCondition(
        //                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
        //                        value == null ? null
        //                                : new FieldValueOperator<>(
        //                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
        //                        QueryOperator.CO, queryPolicy, queryAlias, ignoreStrategy));
        //        return co(
        //                classMapping.getPropertyMapping(LambdaUtils.getSerializableSupplierLambdaInfo(property)
        //                        .getSerializedLambdaInfo().getPropertyName()),
        //                property.get(), queryAlias, queryPolicy, ignoreStrategy);
        return co(classMapping, property, queryAlias, queryPolicy, ignoreStrategy);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public <N extends Number> L ge(String name, N value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.GE, queryAlias, ignoreStrategy));
    //    }

    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public <D extends Date> L ge(String name, D value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.GE, queryAlias, ignoreStrategy));
    //    }

    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L ge(String name, LocalTime value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.GE, queryAlias, ignoreStrategy));
    //    }

    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L ge(String name, LocalDate value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.GE, queryAlias, ignoreStrategy));
    //    }

    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L ge(String name, LocalDateTime value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.GE, queryAlias, ignoreStrategy));
    //    }

    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L ge(String name, String value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.GE, queryAlias, ignoreStrategy));
    //    }

    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public <N extends Number> L gt(String name, N value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.GT, queryAlias, ignoreStrategy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public <D extends Date> L gt(String name, D value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.GT, queryAlias, ignoreStrategy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L gt(String name, LocalTime value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.GT, queryAlias, ignoreStrategy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L gt(String name, LocalDate value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.GT, queryAlias, ignoreStrategy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L gt(String name, LocalDateTime value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.GT, queryAlias, ignoreStrategy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L gt(String name, String value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.GT, queryAlias, ignoreStrategy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L in(String name, Object value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.IN, queryAlias, ignoreStrategy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L inn(String name) {
    //        return inn(name, true);
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L inn(String name, Boolean value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.INN, queryAlias, ignoreStrategy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L isn(String name) {
    //        return isn(name, true);
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L isn(String name, Boolean value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.ISN, queryAlias, ignoreStrategy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public <N extends Number> L le(String name, N value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.LE, queryAlias, ignoreStrategy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public <D extends Date> L le(String name, D value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.LE, queryAlias, ignoreStrategy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L le(String name, LocalTime value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.LE, queryAlias, ignoreStrategy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L le(String name, LocalDate value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.LE, queryAlias, ignoreStrategy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L le(String name, LocalDateTime value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.LE, queryAlias, ignoreStrategy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L le(String name, String value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.LE, queryAlias, ignoreStrategy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public <N extends Number> L lt(String name, N value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.LT, queryAlias, ignoreStrategy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public <D extends Date> L lt(String name, D value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.LT, queryAlias, ignoreStrategy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L lt(String name, LocalTime value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.LT, queryAlias, ignoreStrategy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L lt(String name, LocalDate value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.LT, queryAlias, ignoreStrategy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L lt(String name, LocalDateTime value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.LT, queryAlias, ignoreStrategy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L lt(String name, String value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.LT, queryAlias, ignoreStrategy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L nin(String name, Object value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.NIN, queryAlias, ignoreStrategy));
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ge(SerializableFunction<E, N> name, N value) {
        return ge(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ge(SerializableFunction<E, N> name, N value, Predicate<N> ignoreStrategy) {
        return ge(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ge(SerializableFunction<E, D> name, D value) {
        return ge(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ge(SerializableFunction<E, D> name, D value, Predicate<D> ignoreStrategy) {
        return ge(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableFunction<E, LocalTime> name, LocalTime value) {
        return ge(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableFunction<E, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ge(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableFunction<E, LocalDate> name, LocalDate value) {
        return ge(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableFunction<E, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ge(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableFunction<E, LocalDateTime> name, LocalDateTime value) {
        return ge(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableFunction<E, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return ge(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableFunction<E, String> name, String value) {
        return ge(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy) {
        return ge(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L ge(SerializableDateSupplier<R> property) {
        return ge(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L ge(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ge(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L ge(SerializableNumberSupplier<R> property) {
        return ge(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L ge(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ge(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableLocalDateSupplier property) {
        return ge(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return ge(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableLocalTimeSupplier property) {
        return ge(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return ge(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableLocalDateTimeSupplier property) {
        return ge(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return ge(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableStringSupplier property) {
        return ge(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return ge(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableToIntFunction<E> name, int value) {
        return ge(name, value, (Predicate<Integer>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableToIntFunction<E> name, int value, Predicate<Integer> ignoreStrategy) {
        return ge(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableToLongFunction<E> name, long value) {
        return ge(name, value, (Predicate<Long>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableToLongFunction<E> name, long value, Predicate<Long> ignoreStrategy) {
        return ge(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableToDoubleFunction<E> name, double value) {
        return ge(name, value, (Predicate<Double>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableToDoubleFunction<E> name, double value, Predicate<Double> ignoreStrategy) {
        return ge(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableIntSupplier property) {
        return ge(property, (Predicate<Integer>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return ge(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableLongSupplier property) {
        return ge(property, (Predicate<Long>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return ge(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableDoubleSupplier property) {
        return ge(property, (Predicate<Double>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy) {
        return ge(classMapping, property, queryAlias, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L gt(SerializableFunction<E, N> name, N value) {
        return gt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L gt(SerializableFunction<E, N> name, N value, Predicate<N> ignoreStrategy) {
        return gt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L gt(SerializableFunction<E, D> name, D value) {
        return gt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L gt(SerializableFunction<E, D> name, D value, Predicate<D> ignoreStrategy) {
        return gt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableFunction<E, LocalTime> name, LocalTime value) {
        return gt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableFunction<E, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return gt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableFunction<E, LocalDate> name, LocalDate value) {
        return gt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableFunction<E, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return gt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableFunction<E, LocalDateTime> name, LocalDateTime value) {
        return gt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableFunction<E, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return gt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableFunction<E, String> name, String value) {
        return gt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy) {
        return gt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L gt(SerializableNumberSupplier<R> property) {
        return gt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L gt(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return gt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L gt(SerializableDateSupplier<R> property) {
        return gt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L gt(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return gt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableLocalDateSupplier property) {
        return gt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return gt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableLocalTimeSupplier property) {
        return gt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return gt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableLocalDateTimeSupplier property) {
        return gt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return gt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableStringSupplier property) {
        return gt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return gt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableToIntFunction<E> name, int value) {
        return gt(name, value, (Predicate<Integer>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableToIntFunction<E> name, int value, Predicate<Integer> ignoreStrategy) {
        return gt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableToLongFunction<E> name, long value) {
        return gt(name, value, (Predicate<Long>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableToLongFunction<E> name, long value, Predicate<Long> ignoreStrategy) {
        return gt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableToDoubleFunction<E> name, double value) {
        return gt(name, value, (Predicate<Double>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableToDoubleFunction<E> name, double value, Predicate<Double> ignoreStrategy) {
        return gt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableIntSupplier property) {
        return gt(property, (Predicate<Integer>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return gt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableLongSupplier property) {
        return gt(property, (Predicate<Long>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return gt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableDoubleSupplier property) {
        return gt(property, (Predicate<Double>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy) {
        return gt(classMapping, property, queryAlias, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in(SerializableFunction<E, R> name, R value) {
        //        return in(classMapping, name, value, queryAlias, ignoreStrategy);
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in(SerializableFunction<E, R> name, R value, Predicate<R> ignoreStrategy) {
        //        return in(classMapping, name, value, queryAlias, ignoreStrategy);
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in(SerializableFunction<E, R> name, R... value) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in(SerializableFunction<E, R> name, R[] value, Predicate<R[]> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in(SerializableFunction<E, R> name, Collection<R> value) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in(SerializableFunction<E, R> name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in(SerializableSupplier<R> property) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return in(classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), property.get(),
                queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return in(classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), property.get(),
                queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToIntFunction<E> name, int value) {
        //        return in(classMapping, name, value, (Predicate<Integer>) ignoreStrategy);
        return in(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToIntFunction<E> name, int value, Predicate<Integer> ignoreStrategy) {
        return in(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToLongFunction<E> name, long value) {
        //        return in(classMapping, name, value, (Predicate<Long>) ignoreStrategy);
        return in(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToLongFunction<E> name, long value, Predicate<Long> ignoreStrategy) {
        return in(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToIntFunction<E> name, int... value) {
        //        return in(classMapping, name, value, (Predicate<int[]>) ignoreStrategy);
        return in(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToLongFunction<E> name, long... value) {
        //        return in(classMapping, name, value, (Predicate<long[]>) ignoreStrategy);
        return in(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToIntFunction<E> name, int[] value, Predicate<int[]> ignoreStrategy) {
        return in(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToLongFunction<E> name, long[] value, Predicate<long[]> ignoreStrategy) {
        return in(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in(SerializableIntSupplier property) {
        return in(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return in(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in(SerializableLongSupplier property) {
        return in(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return in(classMapping, property, queryAlias, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin(SerializableFunction<E, R> name, R value) {
        return nin(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin(SerializableFunction<E, R> name, R value, Predicate<R> ignoreStrategy) {
        return nin(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin(SerializableFunction<E, R> name, R... value) {
        return nin(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin(SerializableFunction<E, R> name, R[] value, Predicate<R[]> ignoreStrategy) {
        return nin(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin(SerializableFunction<E, R> name, Collection<R> value) {
        return nin(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin(SerializableFunction<E, R> name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy) {
        return nin(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin(SerializableSupplier<R> property) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return nin(classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), property.get(),
                queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return nin(classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), property.get(),
                queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(SerializableToIntFunction<E> name, int value) {
        //        return nin(classMapping, name, value, (Predicate<Integer>) ignoreStrategy);
        return nin(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(SerializableToIntFunction<E> name, int value, Predicate<Integer> ignoreStrategy) {
        return nin(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(SerializableToLongFunction<E> name, long value) {
        //        return nin(classMapping, name, value, (Predicate<Long>) ignoreStrategy);
        return nin(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(SerializableToLongFunction<E> name, long value, Predicate<Long> ignoreStrategy) {
        return nin(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(SerializableToIntFunction<E> name, int... value) {
        //        return nin(classMapping, name, value, (Predicate<int[]>) ignoreStrategy);
        return nin(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(SerializableToLongFunction<E> name, long... value) {
        //        return nin(classMapping, name, value, (Predicate<long[]>) ignoreStrategy);
        return nin(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(SerializableToIntFunction<E> name, int[] value, Predicate<int[]> ignoreStrategy) {
        return nin(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(SerializableToLongFunction<E> name, long[] value, Predicate<long[]> ignoreStrategy) {
        return nin(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin(SerializableIntSupplier property) {
        //        return nin(property, (Predicate<Integer>) ignoreStrategy);
        return nin(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return nin(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin(SerializableLongSupplier property) {
        //        return nin(property, (Predicate<Long>) ignoreStrategy);
        return nin(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return nin(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L inn(SerializableFunction<E, R> name, Boolean value) {
        return inn(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L isn(SerializableFunction<E, R> name, Boolean value) {
        return isn(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L le(SerializableFunction<E, N> name, N value) {
        return le(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L le(SerializableFunction<E, N> name, N value, Predicate<N> ignoreStrategy) {
        return le(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L le(SerializableFunction<E, D> name, D value) {
        return le(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L le(SerializableFunction<E, D> name, D value, Predicate<D> ignoreStrategy) {
        return le(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableFunction<E, LocalTime> name, LocalTime value) {
        return le(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableFunction<E, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return le(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableFunction<E, LocalDate> name, LocalDate value) {
        return le(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableFunction<E, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return le(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableFunction<E, LocalDateTime> name, LocalDateTime value) {
        return le(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableFunction<E, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return le(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableFunction<E, String> name, String value) {
        return le(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy) {
        return le(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L le(SerializableDateSupplier<R> property) {
        return le(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L le(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return le(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L le(SerializableNumberSupplier<R> property) {
        return le(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L le(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return le(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableLocalDateSupplier property) {
        return le(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return le(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableLocalTimeSupplier property) {
        return le(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return le(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableLocalDateTimeSupplier property) {
        return le(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return le(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableStringSupplier property) {
        return le(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return le(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableToIntFunction<E> name, int value) {
        return le(name, value, (Predicate<Integer>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableToIntFunction<E> name, int value, Predicate<Integer> ignoreStrategy) {
        return le(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableToLongFunction<E> name, long value) {
        return le(name, value, (Predicate<Long>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableToLongFunction<E> name, long value, Predicate<Long> ignoreStrategy) {
        return le(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableToDoubleFunction<E> name, double value) {
        return le(name, value, (Predicate<Double>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableToDoubleFunction<E> name, double value, Predicate<Double> ignoreStrategy) {
        return le(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableIntSupplier property) {
        return le(property, (Predicate<Integer>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return le(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableLongSupplier property) {
        return le(property, (Predicate<Long>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return le(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableDoubleSupplier property) {
        return le(property, (Predicate<Double>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy) {
        return le(classMapping, property, queryAlias, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L lt(SerializableFunction<E, N> name, N value) {
        return lt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L lt(SerializableFunction<E, N> name, N value, Predicate<N> ignoreStrategy) {
        return lt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L lt(SerializableFunction<E, D> name, D value) {
        return lt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L lt(SerializableFunction<E, D> name, D value, Predicate<D> ignoreStrategy) {
        return lt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableFunction<E, LocalTime> name, LocalTime value) {
        return lt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableFunction<E, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return lt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableFunction<E, LocalDate> name, LocalDate value) {
        return lt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableFunction<E, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return lt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableFunction<E, LocalDateTime> name, LocalDateTime value) {
        return lt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableFunction<E, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return lt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableFunction<E, String> name, String value) {
        return lt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy) {
        return lt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L lt(SerializableNumberSupplier<R> property) {
        return lt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L lt(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return lt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L lt(SerializableDateSupplier<R> property) {
        return lt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L lt(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return lt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableLocalDateSupplier property) {
        return lt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return lt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableLocalTimeSupplier property) {
        return lt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return lt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableLocalDateTimeSupplier property) {
        return lt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return lt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableStringSupplier property) {
        return lt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return lt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableToIntFunction<E> name, int value) {
        return lt(name, value, (Predicate<Integer>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableToIntFunction<E> name, int value, Predicate<Integer> ignoreStrategy) {
        return lt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableToLongFunction<E> name, long value) {
        return lt(name, value, (Predicate<Long>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableToLongFunction<E> name, long value, Predicate<Long> ignoreStrategy) {
        return lt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableToDoubleFunction<E> name, double value) {
        return lt(name, value, (Predicate<Double>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableToDoubleFunction<E> name, double value, Predicate<Double> ignoreStrategy) {
        return lt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableIntSupplier property) {
        return lt(property, (Predicate<Integer>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return lt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableLongSupplier property) {
        return lt(property, (Predicate<Long>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return lt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableDoubleSupplier property) {
        return lt(property, (Predicate<Double>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy) {
        return lt(classMapping, property, queryAlias, ignoreStrategy);
    }

    // ****************************************************************************************************************

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityPropertyTypeExpression<R, C, L> property(SerializableFunction<E, R> name) {
        // IMPLSOON 后续来实现
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Collection<RE>,
            RE> EntityPropertyTypeExpression<RE, C, L> property(SerializableToCollectionFunction<E, R, RE> name) {
        // IMPLSOON 后续来实现
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityNumberPropertyExpression<E, Integer, C, L> property(SerializableToIntFunction<E> name) {
        // IMPLSOON 后续来实现
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityNumberPropertyExpression<E, Long, C, L> property(SerializableToLongFunction<E> name) {
        // IMPLSOON 后续来实现
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityNumberPropertyExpression<E, Double, C, L> property(SerializableToDoubleFunction<E> name) {
        // IMPLSOON 后续来实现
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityStringPropertyExpression<E, C, L> property(SerializableToStringFunction<E> name) {
        // IMPLSOON 后续来实现
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> EntityNumberPropertyExpression<E, R, C, L> property(
            SerializableToNumberFunction<E, R> name) {
        // IMPLSOON 后续来实现
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> EntityDatePropertyExpression<E, R, C, L> property(SerializableToDateFunction<E, R> name) {
        // IMPLSOON 后续来实现
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLocalDatePropertyExpression<E, C, L> property(SerializableToLocalDateFunction<E> name) {
        // IMPLSOON 后续来实现
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLocalDateTimePropertyExpression<E, C, L> property(SerializableToLocalDateTimeFunction<E> name) {
        // IMPLSOON 后续来实现
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLocalTimePropertyExpression<E, C, L> property(SerializableToLocalTimeFunction<E> name) {
        // IMPLSOON 后续来实现
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Enum<R>> EntityEnumPropertyExpression<E, R, C, L> property(
            SerializableToEnumFunction<E, R> name) {
        // IMPLSOON 后续来实现
        return null;
    }

    // ****************************************************************************************************************

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L expression(String expression, final Map<String, Object> params) {
    //        final Execution execution = SqlUtils.convertNamedParamSql(expression, params);
    //        return expression(execution.getExecution(), execution.getParams());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L expression(String expression, Object... params) {
    //        return (L) addCondition(new ParamedExpression() {
    //
    //
    //            public String expression() {
    //                return expression;
    //            }
    //
    //
    //            public Object getParam() {
    //                return params;
    //            }
    //        });
    //    }

    /**
     * Sets the ignore strategy.
     *
     * @param ignoreStrategy the ignore strategy
     * @return the c
     */
    public C setIgnoreStrategy(Predicate<?> ignoreStrategy) {
        AssertIllegalArgument.isNotNull(ignoreStrategy, "ignoreStrategy");
        this.ignoreStrategy = ignoreStrategy;
        return (C) this;
    }

    //  /**
    //     * {@inheritDoc}
    //     */
    //
    //    public <R> ObjectExpression<C, L> property(SerializableFunction<E, R> name) {
    //        return property(getPropertyName(name));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public ObjectExpression<C, L> property(String name) {
    //        // IMPLSOON 这里后续来实现
    //        return null;
    //        //        return new SimpleObjectExpression<C, L>(ClassMappingUtils.getColumnName(name, classMapping), this);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public StringExpression<C, L> propertyString(String name) {
    //        return new SimpleStringExpression<>(ClassMappingUtils.getColumnName(name, classMapping), this);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public NumberExpression<C, L> propertyNumber(String name) {
    //        return new SimpleNumberExpression<>(ClassMappingUtils.getColumnName(name, classMapping), this);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public DateExpression<C, L> propertyDate(String name) {
    //        return new SimpleDateExpression<>(ClassMappingUtils.getColumnName(name, classMapping), this);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public EnumExpression<C, L> propertyEnum(String name) {
    //        return new SimpleEnumExpression<>(ClassMappingUtils.getColumnName(name, classMapping), this);
    //    }

    // ********************************************************************
    // private method
    // ********************************************************************

    /**
     * Gets the field value operator.
     *
     * @param <R>   the generic type
     * @param pm    the pm
     * @param value the value
     * @return the field value operator
     */
    protected <R> FieldValueOperator<R> getFieldValueOperator(JdbcPropertyMapping pm, R value) {
        return value == null ? null : FieldValueOperator.create(pm, value);
    }

    /**
     * Gets the in param.
     *
     * @param pm    the pm
     * @param value the value
     * @return the in param
     */
    protected Object getInParam(JdbcPropertyMapping pm, Object value) {
        Object param = null;
        if (value != null) {
            if (value.getClass().isArray()) {
                int length = Array.getLength(value);
                param = Array.newInstance(FieldValueOperator.class, length);
                for (int i = 0; i < length; i++) {
                    //                    Array.set(param, i, new FieldValueOperator(pm.getJavaTypeSqlTypeOperator(), Array.get(value, i)));
                    Array.set(param, i, FieldValueOperator.create(pm, Array.get(value, i)));
                }
            } else if (value instanceof Collection) {
                param = new ArrayList<>();
                for (Object op : (Collection<?>) value) {
                    ((Collection<FieldValueOperator<?>>) param).add(FieldValueOperator.create(pm, op));
                    //                    .add(new FieldValueOperator(pm.getJavaTypeSqlTypeOperator(), op));
                }
            } else if (!(value instanceof FieldValueOperator)) {
                param = FieldValueOperator.create(pm, value);
            } else {
                param = value;
            }
        }
        return param;
    }

    // ********************************************************************

    protected <R> L eq(JdbcClassMapping<?> classMapping, SerializableSupplier<R> property, String queryAlias,
            QueryPolicy queryPolicy, Predicate<?> ignoreStrategy) {
        return eq(classMapping, property, property.get(), queryAlias, queryPolicy, ignoreStrategy);
    }

    protected <R> L eq(JdbcClassMapping<?> classMapping, Serializable property, R value, String queryAlias,
            QueryPolicy queryPolicy, Predicate<?> ignoreStrategy) {
        return eq_ne(QueryOperator.EQ, classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias,
                queryPolicy, ignoreStrategy);
    }

    protected <R> L ne(JdbcClassMapping<?> classMapping, SerializableSupplier<R> property, String queryAlias,
            QueryPolicy queryPolicy, Predicate<?> ignoreStrategy) {
        return ne(classMapping, property, property.get(), queryAlias, queryPolicy, ignoreStrategy);
    }

    protected <R> L ne(JdbcClassMapping<?> classMapping, Serializable property, R value, String queryAlias,
            QueryPolicy queryPolicy, Predicate<?> ignoreStrategy) {
        return eq_ne(QueryOperator.NE, classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias,
                queryPolicy, ignoreStrategy);
    }

    protected abstract <T, R> L eq_ne(QueryOperator queryOperator, PropertyMapping<?> pm, R value, String queryAlias,
            QueryPolicy queryPolicy, Predicate<?> ignoreStrategy);

    //    protected <T, R> L eq_ne(QueryOperator queryOperator, JdbcPropertyMapping pm, R value, String queryAlias,
    //            QueryPolicy queryPolicy, Predicate<R> ignoreStrategy) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
    //                getFieldValueOperator(pm, value), queryOperator, queryPolicy, queryAlias, ignoreStrategy));
    //    }

    // ****************************************************************************************************************

    protected L sw(JdbcClassMapping<?> classMapping, SerializableSupplier<String> property, String queryAlias,
            QueryPolicy queryPolicy, Predicate<?> ignoreStrategy) {
        return sw(classMapping, property, property.get(), queryAlias, queryPolicy, ignoreStrategy);
    }

    protected <T, R> L sw(JdbcClassMapping<?> classMapping, Serializable property, String value, String queryAlias,
            QueryPolicy queryPolicy, Predicate<?> ignoreStrategy) {
        return sw(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias, queryPolicy,
                ignoreStrategy);
    }

    protected <T> L sw(JdbcPropertyMapping pm, String value, String queryAlias, QueryPolicy queryPolicy,
            Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), QueryOperator.SW, queryPolicy, queryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    protected L co(JdbcClassMapping<?> classMapping, SerializableSupplier<String> property, String queryAlias,
            QueryPolicy queryPolicy, Predicate<?> ignoreStrategy) {
        return co(classMapping, property, property.get(), queryAlias, queryPolicy, ignoreStrategy);
    }

    protected <T, R> L co(JdbcClassMapping<?> classMapping, Serializable property, String value, String queryAlias,
            QueryPolicy queryPolicy, Predicate<?> ignoreStrategy) {
        return co(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias, queryPolicy,
                ignoreStrategy);
    }

    protected <T> L co(JdbcPropertyMapping pm, String value, String queryAlias, QueryPolicy queryPolicy,
            Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), QueryOperator.CO, queryPolicy, queryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    protected L ew(JdbcClassMapping<?> classMapping, SerializableSupplier<String> property, String queryAlias,
            QueryPolicy queryPolicy, Predicate<?> ignoreStrategy) {
        return ew(classMapping, property, property.get(), queryAlias, queryPolicy, ignoreStrategy);
    }

    protected <T, R> L ew(JdbcClassMapping<?> classMapping, Serializable property, String value, String queryAlias,
            QueryPolicy queryPolicy, Predicate<?> ignoreStrategy) {
        return ew(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias, queryPolicy,
                ignoreStrategy);
    }

    protected <T> L ew(JdbcPropertyMapping pm, String value, String queryAlias, QueryPolicy queryPolicy,
            Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), QueryOperator.EW, queryPolicy, queryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    protected L lk(JdbcClassMapping<?> classMapping, SerializableSupplier<String> property, String queryAlias,
            QueryPolicy queryPolicy, Predicate<?> ignoreStrategy) {
        return lk(classMapping, property, property.get(), queryAlias, queryPolicy, ignoreStrategy);
    }

    protected <T, R> L lk(JdbcClassMapping<?> classMapping, Serializable property, String value, String queryAlias,
            QueryPolicy queryPolicy, Predicate<?> ignoreStrategy) {
        return lk(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias, queryPolicy,
                ignoreStrategy);
    }

    protected <T> L lk(JdbcPropertyMapping pm, String value, String queryAlias, QueryPolicy queryPolicy,
            Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), QueryOperator.LK, queryPolicy, queryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    //    protected <T> L in(SerializableToIntFunction<T> name, int value, String queryAlias, Predicate<?> ignoreStrategy) {
    //        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    //    }
    //
    //    protected <T> L in(SerializableToLongFunction<T> name, long value, String queryAlias, Predicate<?> ignoreStrategy) {
    //        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    //    }
    //
    //    protected <T> L in(SerializableToDoubleFunction<T> name, double value, String queryAlias,
    //            Predicate<?> ignoreStrategy) {
    //        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    //    }
    //
    //    protected <T> L in(SerializableToIntFunction<T> name, int[] value, String queryAlias, Predicate<?> ignoreStrategy) {
    //        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    //    }
    //
    //    protected <T> L in(SerializableToLongFunction<T> name, long[] value, String queryAlias, Predicate<?> ignoreStrategy) {
    //        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    //    }

    protected <T> L in(JdbcClassMapping<?> classMapping, SerializableIntSupplier property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return in(classMapping, property, property.getAsInt(), queryAlias, ignoreStrategy);
    }

    protected <T> L in(JdbcClassMapping<?> classMapping, SerializableLongSupplier property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return in(classMapping, property, property.getAsLong(), queryAlias, ignoreStrategy);
    }

    protected <T> L in(JdbcClassMapping<?> classMapping, SerializableDoubleSupplier property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return in(classMapping, property, property.getAsDouble(), queryAlias, ignoreStrategy);
    }

    protected <R> L in(JdbcClassMapping<?> classMapping, SerializableSupplier<R> property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return in(classMapping, property, property.get(), queryAlias, ignoreStrategy);
    }

    protected <T, R> L in(JdbcClassMapping<?> classMapping, Serializable property, R value, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias, ignoreStrategy);
    }

    protected <T, R> L in(JdbcPropertyMapping pm, R value, String queryAlias, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                getInParam(pm, value), QueryOperator.IN, queryAlias, ignoreStrategy));
    }

    //    protected <T, R> L in_nin(boolean in, JdbcPropertyMapping pm, R value, String queryAlias,
    //            Predicate<?> ignoreStrategy) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
    //                getInParam(pm, value), in ? QueryOperator.IN : QueryOperator.NIN, queryAlias, ignoreStrategy));
    //    }

    // ****************************************************************************************************************

    protected <T> L nin(JdbcClassMapping<?> classMapping, SerializableIntSupplier property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return nin(classMapping, property, property.getAsInt(), queryAlias, ignoreStrategy);
    }

    protected <T> L nin(JdbcClassMapping<?> classMapping, SerializableLongSupplier property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return nin(classMapping, property, property.getAsLong(), queryAlias, ignoreStrategy);
    }

    protected <T> L nin(JdbcClassMapping<?> classMapping, SerializableDoubleSupplier property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return nin(classMapping, property, property.getAsDouble(), queryAlias, ignoreStrategy);
    }

    protected <R> L nin(JdbcClassMapping<?> classMapping, SerializableSupplier<R> property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return nin(classMapping, property, property.get(), queryAlias, ignoreStrategy);
    }

    protected <T, R> L nin(JdbcClassMapping<?> classMapping, Serializable property, R value, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return nin(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias, ignoreStrategy);
    }

    protected <R> L nin(JdbcPropertyMapping pm, R value, String queryAlias, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                getInParam(pm, value), QueryOperator.NIN, queryAlias, ignoreStrategy));
    }

    protected <T, R> L isn(JdbcClassMapping<?> classMapping, Serializable property, Boolean value, String queryAlias) {
        return isn(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias);
    }

    protected L isn(JdbcPropertyMapping pm, Boolean value, String queryAlias) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(), value,
                QueryOperator.ISN, queryAlias, ignoreStrategy));
    }

    protected <T, R> L inn(JdbcClassMapping<?> classMapping, Serializable property, Boolean value, String queryAlias) {
        return inn(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias);
    }

    protected L inn(JdbcPropertyMapping pm, Boolean value, String queryAlias) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(), value,
                QueryOperator.INN, queryAlias, ignoreStrategy));
    }

    // ********************************************************************

    //    protected <T> L ge(SerializableToIntFunction<T> name, int value, String queryAlias, Predicate<?> ignoreStrategy) {
    //        return ge(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    //    }
    //
    //    protected <T> L ge(SerializableToLongFunction<T> name, long value, String queryAlias, Predicate<?> ignoreStrategy) {
    //        return ge(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    //    }
    //
    //    protected <T> L ge(SerializableToDoubleFunction<T> name, double value, String queryAlias,
    //            Predicate<?> ignoreStrategy) {
    //        return ge(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    //    }
    //
    //    protected <T, V> L ge(SerializableFunction<T, V> name, V value, String queryAlias, Predicate<?> ignoreStrategy) {
    //        return ge(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    //    }

    protected L ge(JdbcClassMapping<?> classMapping, SerializableIntSupplier property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return ge(classMapping, property, property.getAsInt(), queryAlias, ignoreStrategy);
    }

    protected L ge(JdbcClassMapping<?> classMapping, SerializableLongSupplier property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return ge(classMapping, property, property.getAsLong(), queryAlias, ignoreStrategy);
    }

    protected L ge(JdbcClassMapping<?> classMapping, SerializableDoubleSupplier property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return ge(classMapping, property, property.getAsDouble(), queryAlias, ignoreStrategy);
    }

    protected <V> L ge(JdbcClassMapping<?> classMapping, SerializableSupplier<V> property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return ge(classMapping, property, property.get(), queryAlias, ignoreStrategy);
    }

    protected <T, V> L ge(JdbcClassMapping<?> classMapping, Serializable name, V value, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return ge(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    }

    protected <V> L ge(JdbcPropertyMapping pm, V value, String queryAlias, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), QueryOperator.GE, queryAlias, ignoreStrategy));
    }

    // ********************************************************************

    //    protected <T> L gt(SerializableToIntFunction<T> name, int value, String queryAlias, Predicate<?> ignoreStrategy) {
    //        return gt(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    //    }
    //
    //    protected <T> L gt(SerializableToLongFunction<T> name, long value, String queryAlias, Predicate<?> ignoreStrategy) {
    //        return gt(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    //    }
    //
    //    protected <T> L gt(SerializableToDoubleFunction<T> name, double value, String queryAlias,
    //            Predicate<?> ignoreStrategy) {
    //        return gt(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    //    }
    //
    //    protected <V> L gt(SerializableFunction<E, V> name, V value, String queryAlias, Predicate<?> ignoreStrategy) {
    //        return gt(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    //    }

    protected L gt(JdbcClassMapping<?> classMapping, SerializableIntSupplier property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return gt(classMapping, property, property.getAsInt(), queryAlias, ignoreStrategy);
    }

    protected L gt(JdbcClassMapping<?> classMapping, SerializableLongSupplier property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return gt(classMapping, property, property.getAsLong(), queryAlias, ignoreStrategy);
    }

    protected L gt(JdbcClassMapping<?> classMapping, SerializableDoubleSupplier property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return gt(classMapping, property, property.getAsDouble(), queryAlias, ignoreStrategy);
    }

    protected <V> L gt(JdbcClassMapping<?> classMapping, SerializableSupplier<V> property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return gt(classMapping, property, property.get(), queryAlias, ignoreStrategy);
    }

    protected <T, V> L gt(JdbcClassMapping<?> classMapping, Serializable name, V value, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return gt(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    }

    protected <V> L gt(JdbcPropertyMapping pm, V value, String queryAlias, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), QueryOperator.GT, queryAlias, ignoreStrategy));
    }

    // ********************************************************************

    //    protected <T> L le(SerializableToIntFunction<T> name, int value, String queryAlias, Predicate<?> ignoreStrategy) {
    //        return le(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    //    }
    //
    //    protected <T> L le(SerializableToLongFunction<T> name, long value, String queryAlias, Predicate<?> ignoreStrategy) {
    //        return le(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    //    }
    //
    //    protected <T> L le(SerializableToDoubleFunction<T> name, double value, String queryAlias,
    //            Predicate<?> ignoreStrategy) {
    //        return le(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    //    }
    //
    //    protected <V> L le(SerializableFunction<E, V> name, V value, String queryAlias, Predicate<?> ignoreStrategy) {
    //        return le(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    //    }

    protected L le(JdbcClassMapping<?> classMapping, SerializableIntSupplier property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return le(classMapping, property, property.getAsInt(), queryAlias, ignoreStrategy);
    }

    protected L le(JdbcClassMapping<?> classMapping, SerializableLongSupplier property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return le(classMapping, property, property.getAsLong(), queryAlias, ignoreStrategy);
    }

    protected L le(JdbcClassMapping<?> classMapping, SerializableDoubleSupplier property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return le(classMapping, property, property.getAsDouble(), queryAlias, ignoreStrategy);
    }

    protected <V> L le(JdbcClassMapping<?> classMapping, SerializableSupplier<V> property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return le(classMapping, property, property.get(), queryAlias, ignoreStrategy);
    }

    protected <T, V> L le(JdbcClassMapping<?> classMapping, Serializable name, V value, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return le(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    }

    protected <V> L le(JdbcPropertyMapping pm, V value, String queryAlias, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), QueryOperator.LE, queryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    //    protected <T> L lt(SerializableToIntFunction<T> name, int value, String queryAlias, Predicate<?> ignoreStrategy) {
    //        return lt(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    //    }
    //
    //    protected <T> L lt(SerializableToLongFunction<T> name, long value, String queryAlias, Predicate<?> ignoreStrategy) {
    //        return lt(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    //    }
    //
    //    protected <T> L lt(SerializableToDoubleFunction<T> name, double value, String queryAlias,
    //            Predicate<?> ignoreStrategy) {
    //        return lt(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    //    }
    //
    //    protected <V> L lt(SerializableFunction<E, V> name, V value, String queryAlias, Predicate<?> ignoreStrategy) {
    //        return lt(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    //    }

    protected L lt(JdbcClassMapping<?> classMapping, SerializableIntSupplier property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return lt(classMapping, property, property.getAsInt(), queryAlias, ignoreStrategy);
    }

    protected L lt(JdbcClassMapping<?> classMapping, SerializableLongSupplier property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return lt(classMapping, property, property.getAsLong(), queryAlias, ignoreStrategy);
    }

    protected L lt(JdbcClassMapping<?> classMapping, SerializableDoubleSupplier property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return lt(classMapping, property, property.getAsDouble(), queryAlias, ignoreStrategy);
    }

    protected <V> L lt(JdbcClassMapping<?> classMapping, SerializableSupplier<V> property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return lt(classMapping, property, property.get(), queryAlias, ignoreStrategy);
    }

    protected <T, V> L lt(JdbcClassMapping<?> classMapping, Serializable name, V value, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return lt(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    }

    protected <V> L lt(JdbcPropertyMapping pm, V value, String queryAlias, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), QueryOperator.LT, queryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    /**
     * Supplier.
     *
     * @param <R>   the generic type
     * @param info  the info
     * @param value the value
     * @return the list
     */
    protected <R> List<Tuple2<String, Optional<R>>> supplier(SerializedLambdaInfo info, R value) {
        return supplier(info, value, classMapping);
    }

    /**
     * Supplier.
     *
     * @param <R>  the generic type
     * @param info the info
     * @return the list
     */
    protected <R> List<Tuple2<String, Optional<R>>> supplier(SerializableSupplierLambdaInfo<R> info) {
        return supplier(info, classMapping);
    }

    // ********************************************************************
    // property
    // ********************************************************************

}
