
package cn.featherfly.hammer.sqldb.sql.dml;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.db.FieldValueOperator;
import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.db.mapping.JavaTypeSqlTypeOperator;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LambdaUtils.SerializableSupplierLambdaInfo;
import cn.featherfly.common.lang.LambdaUtils.SerializedLambdaInfo;
import cn.featherfly.common.lang.function.DateSupplier;
import cn.featherfly.common.lang.function.LocalDateSupplier;
import cn.featherfly.common.lang.function.LocalDateTimeSupplier;
import cn.featherfly.common.lang.function.LocalTimeSupplier;
import cn.featherfly.common.lang.function.NumberSupplier;
import cn.featherfly.common.lang.function.ReturnDateFunction;
import cn.featherfly.common.lang.function.ReturnEnumFunction;
import cn.featherfly.common.lang.function.ReturnLocalDateFunction;
import cn.featherfly.common.lang.function.ReturnLocalDateTimeFunction;
import cn.featherfly.common.lang.function.ReturnLocalTimeFunction;
import cn.featherfly.common.lang.function.ReturnNumberFunction;
import cn.featherfly.common.lang.function.ReturnStringFunction;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.common.lang.function.SerializableSupplier1;
import cn.featherfly.common.lang.function.SerializableSupplier2;
import cn.featherfly.common.lang.function.StringSupplier;
import cn.featherfly.common.operator.LogicOperator;
import cn.featherfly.common.operator.QueryOperator;
import cn.featherfly.common.operator.QueryOperator.QueryPolicy;
import cn.featherfly.hammer.expression.EntityConditionGroupExpression;
import cn.featherfly.hammer.expression.EntityConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.condition.ParamedExpression;
import cn.featherfly.hammer.expression.condition.property.DateExpression;
import cn.featherfly.hammer.expression.condition.property.EnumExpression;
import cn.featherfly.hammer.expression.condition.property.LocalDateExpression;
import cn.featherfly.hammer.expression.condition.property.LocalDateTimeExpression;
import cn.featherfly.hammer.expression.condition.property.LocalTimeExpression;
import cn.featherfly.hammer.expression.condition.property.NumberExpression;
import cn.featherfly.hammer.expression.condition.property.StringExpression;
import cn.featherfly.hammer.expression.condition.type.property.TypeDateExpression;
import cn.featherfly.hammer.expression.condition.type.property.TypeEnumExpression;
import cn.featherfly.hammer.expression.condition.type.property.TypeLocalDateExpression;
import cn.featherfly.hammer.expression.condition.type.property.TypeLocalDateTimeExpression;
import cn.featherfly.hammer.expression.condition.type.property.TypeLocalTimeExpression;
import cn.featherfly.hammer.expression.condition.type.property.TypeNumberExpression;
import cn.featherfly.hammer.expression.condition.type.property.TypeStringExpression;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.query.EntitySqlQuery;

/**
 * sql condition group builder sql条件逻辑组构造器 .
 *
 * @author zhongj
 * @param <E> the element type
 * @param <Q> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
@SuppressWarnings("unchecked")
public abstract class AbstractEntitySqlConditionGroupExpression<E, C extends EntityConditionGroupExpression<E, C, L>,
        L extends EntityConditionGroupLogicExpression<E, C, L>> extends AbstractSqlConditionExpression<L>
        implements EntityConditionGroupExpression<E, C, L>, EntityConditionGroupLogicExpression<E, C, L>, SqlBuilder,
        ParamedExpression {

    /** The type query entity. */
    protected EntitySqlQuery<E> entityQuery;

    /** The sql page factory. */
    protected SqlPageFactory sqlPageFactory;

    /**
     * Instantiates a new abstract sql condition group expression.
     *
     * @param dialect        dialect
     * @param sqlPageFactory the sql page factory
     * @param entityQuery    the entity query
     * @param ignorePolicy   the ignore policy
     */
    public AbstractEntitySqlConditionGroupExpression(Dialect dialect, SqlPageFactory sqlPageFactory,
            EntitySqlQuery<E> entityQuery, Predicate<Object> ignorePolicy) {
        this(dialect, sqlPageFactory, null, entityQuery, ignorePolicy);
    }

    /**
     * Instantiates a new abstract sql condition group expression.
     *
     * @param dialect        dialect
     * @param sqlPageFactory the sql page factory
     * @param queryAlias     queryAlias
     * @param entityQuery    the entity query
     * @param ignorePolicy   the ignore policy
     */
    public AbstractEntitySqlConditionGroupExpression(Dialect dialect, SqlPageFactory sqlPageFactory, String queryAlias,
            EntitySqlQuery<E> entityQuery, Predicate<Object> ignorePolicy) {
        this(dialect, sqlPageFactory, queryAlias, null, entityQuery, ignorePolicy);
    }

    /**
     * Instantiates a new abstract sql condition group expression.
     *
     * @param dialect        dialect
     * @param sqlPageFactory the sql page factory
     * @param queryAlias     queryAlias
     * @param classMapping   classMapping
     * @param entityQuery    the entity query
     * @param ignorePolicy   the ignore policy
     */
    public AbstractEntitySqlConditionGroupExpression(Dialect dialect, SqlPageFactory sqlPageFactory, String queryAlias,
            JdbcClassMapping<E> classMapping, EntitySqlQuery<E> entityQuery, Predicate<Object> ignorePolicy) {
        this(null, dialect, sqlPageFactory, queryAlias, classMapping, entityQuery, ignorePolicy);
    }

    /**
     * Instantiates a new abstract sql condition group expression.
     *
     * @param parent         parent group
     * @param dialect        dialect
     * @param sqlPageFactory the sql page factory
     * @param queryAlias     queryAlias
     * @param classMapping   classMapping
     * @param entityQuery    the entity query
     * @param ignorePolicy   the ignore policy
     */
    protected AbstractEntitySqlConditionGroupExpression(L parent, Dialect dialect, SqlPageFactory sqlPageFactory,
            String queryAlias, JdbcClassMapping<E> classMapping, EntitySqlQuery<E> entityQuery,
            Predicate<Object> ignorePolicy) {
        super(dialect, ignorePolicy, parent);
        this.queryAlias = queryAlias;
        this.sqlPageFactory = sqlPageFactory;
        this.classMapping = classMapping;
        this.entityQuery = entityQuery;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return build();
    }

    //      /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L eq(String name, Object value) {
    //        return eq(name, value, QueryPolicy.AUTO);
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L eq(String name, Object value, QueryPolicy queryPolicy) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.EQ, queryPolicy, queryAlias, ignorePolicy));
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L eq(SerializableFunction<E, R> name, R value, QueryPolicy queryPolicy) {
        // YUFEI_TODO 未测试
        JdbcPropertyMapping pm = classMapping.getPropertyMapping(getPropertyName(name));
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                value == null ? null
                        : new FieldValueOperator<>((JavaTypeSqlTypeOperator<R>) pm.getJavaTypeSqlTypeOperator(), value),
                QueryOperator.EQ, queryPolicy, queryAlias, ignorePolicy));
        // IMPLSOON 后续再把下面的逻辑加回来
        // FIXME value 空指针异常
        //        List<Tuple2<String, Optional<R>>> tuples = supplier(LambdaUtils.getLambdaInfo(name), value);
        //        L logic = null;
        //        C condition = (C) this;
        //        if (tuples.size() > 1) {
        //            condition = group();
        //        }
        //        for (Tuple2<String, Optional<R>> tuple : tuples) {
        //            if (logic != null) {
        //                condition = logic.and();
        //            }
        //            logic = condition.eq(tuple.get0(), tuple.get1().orElseGet(() -> null), queryPolicy);
        //        }
        //        if (tuples.size() > 1) {
        //            logic = logic.endGroup();
        //        }
        //        return logic;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L eq(SerializableSupplier<R> property, QueryPolicy queryPolicy) {
        //  YUFEI_TODO 未测试
        R value = property.get();
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        JdbcPropertyMapping pm = classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName());
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                value == null ? null
                        : new FieldValueOperator<>((JavaTypeSqlTypeOperator<R>) pm.getJavaTypeSqlTypeOperator(), value),
                QueryOperator.EQ, queryPolicy, queryAlias, ignorePolicy));
        // IMPLSOON 后续再把下面的逻辑加回来
        //        List<Tuple2<String, Optional<R>>> tuples = supplier(LambdaUtils.getSerializableSupplierLambdaInfo(property));
        //        L logic = null;
        //        C condition = (C) this;
        //        if (tuples.size() > 1) {
        //            condition = group();
        //        }
        //        for (Tuple2<String, Optional<R>> tuple : tuples) {
        //            if (logic != null) {
        //                condition = logic.and();
        //            }
        //            logic = condition.eq(tuple.get0(), tuple.get1().orElseGet(() -> null), queryPolicy);
        //        }
        //        if (tuples.size() > 1) {
        //            logic = logic.endGroup();
        //        }
        //        return logic;
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L ne(String name, Object value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.NE, queryAlias, ignorePolicy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
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
    //    @Override
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

    //    /**
    //     * {@inheritDoc}
    //     */
    //    /**
    //    //    @Override
    //    public L ne(String name, Object value, QueryPolicy queryPolicy) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.NE, queryPolicy, queryAlias, ignorePolicy));
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ne(SerializableFunction<E, R> name, R value, QueryPolicy queryPolicy) {
        // YUFEI_TODO 未测试
        JdbcPropertyMapping pm = classMapping.getPropertyMapping(getPropertyName(name));
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                value == null ? null
                        : new FieldValueOperator<>((JavaTypeSqlTypeOperator<R>) pm.getJavaTypeSqlTypeOperator(), value),
                QueryOperator.NE, queryPolicy, queryAlias, ignorePolicy));
        // IMPLSOON 后续再把下面的逻辑加回来
        // FIXME value 空指针异常
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
        //            l = c.ne(tuple.get0(), tuple.get1().orElseGet(() -> null), queryPolicy);
        //        }
        //        if (tuples.size() > 1) {
        //            l = l.endGroup();
        //        }
        //        return l;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ne(SerializableSupplier<R> property, QueryPolicy queryPolicy) {
        //  YUFEI_TODO 未测试
        R value = property.get();
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        JdbcPropertyMapping pm = classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName());
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                value == null ? null
                        : new FieldValueOperator<>((JavaTypeSqlTypeOperator<R>) pm.getJavaTypeSqlTypeOperator(), value),
                QueryOperator.NE, queryPolicy, queryAlias, ignorePolicy));
        // IMPLSOON 后续再把下面的逻辑加回来
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
        //            l = c.ne(tuple.get0(), tuple.get1().orElseGet(() -> null), queryPolicy);
        //        }
        //        if (tuples.size() > 1) {
        //            l = l.endGroup();
        //        }
        //        return l;
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L lk(String name, String value, QueryPolicy queryPolicy) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.LK, queryPolicy, queryAlias, ignorePolicy));
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(SerializableFunction<E, String> name, String value, QueryPolicy queryPolicy) {
        // YUFEI_TODO 未测试
        JdbcPropertyMapping pm = classMapping.getPropertyMapping(getPropertyName(name));
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                        value == null ? null
                                : new FieldValueOperator<>(
                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
                        QueryOperator.LK, queryPolicy, queryAlias, ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(StringSupplier property, QueryPolicy queryPolicy) {
        //  YUFEI_TODO 未测试
        String value = property.get();
        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        JdbcPropertyMapping pm = classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName());
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                        value == null ? null
                                : new FieldValueOperator<>(
                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
                        QueryOperator.LK, queryPolicy, queryAlias, ignorePolicy));
    }

    //  /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L sw(String name, String value) {
    //        return sw(name, value, QueryPolicy.AUTO);
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L sw(String name, String value, QueryPolicy queryPolicy) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.SW, queryPolicy, queryAlias, ignorePolicy));
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(SerializableFunction<E, String> name, String value, QueryPolicy queryPolicy) {
        // YUFEI_TODO 未测试
        JdbcPropertyMapping pm = classMapping.getPropertyMapping(getPropertyName(name));
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                        value == null ? null
                                : new FieldValueOperator<>(
                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
                        QueryOperator.SW, queryPolicy, queryAlias, ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(StringSupplier property, QueryPolicy queryPolicy) {
        //  YUFEI_TODO 未测试
        String value = property.get();
        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        JdbcPropertyMapping pm = classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName());
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                        value == null ? null
                                : new FieldValueOperator<>(
                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
                        QueryOperator.SW, queryPolicy, queryAlias, ignorePolicy));
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L ew(String name, String value, QueryPolicy queryPolicy) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.EW, queryPolicy, queryAlias, ignorePolicy));
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(SerializableFunction<E, String> name, String value, QueryPolicy queryPolicy) {
        // YUFEI_TODO 未测试
        JdbcPropertyMapping pm = classMapping.getPropertyMapping(getPropertyName(name));
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                        value == null ? null
                                : new FieldValueOperator<>(
                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
                        QueryOperator.EW, queryPolicy, queryAlias, ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(StringSupplier property, QueryPolicy queryPolicy) {
        //  YUFEI_TODO 未测试
        String value = property.get();
        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        JdbcPropertyMapping pm = classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName());
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                        value == null ? null
                                : new FieldValueOperator<>(
                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
                        QueryOperator.EW, queryPolicy, queryAlias, ignorePolicy));
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L co(String name, String value, QueryPolicy queryPolicy) {
    //        // TODO 后续来加入BeanPropertyValue
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.CO, queryPolicy, queryAlias, ignorePolicy));
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(SerializableFunction<E, String> name, String value, QueryPolicy queryPolicy) {
        // YUFEI_TODO 未测试
        JdbcPropertyMapping pm = classMapping.getPropertyMapping(getPropertyName(name));
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                        value == null ? null
                                : new FieldValueOperator<>(
                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
                        QueryOperator.CO, queryPolicy, queryAlias, ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(StringSupplier property, QueryPolicy queryPolicy) {
        //  YUFEI_TODO 未测试
        String value = property.get();
        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        JdbcPropertyMapping pm = classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName());
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                        value == null ? null
                                : new FieldValueOperator<>(
                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
                        QueryOperator.CO, queryPolicy, queryAlias, ignorePolicy));
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <N extends Number> L ge(String name, N value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.GE, queryAlias, ignorePolicy));
    //    }

    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <D extends Date> L ge(String name, D value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.GE, queryAlias, ignorePolicy));
    //    }

    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L ge(String name, LocalTime value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.GE, queryAlias, ignorePolicy));
    //    }

    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L ge(String name, LocalDate value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.GE, queryAlias, ignorePolicy));
    //    }

    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L ge(String name, LocalDateTime value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.GE, queryAlias, ignorePolicy));
    //    }

    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L ge(String name, String value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.GE, queryAlias, ignorePolicy));
    //    }

    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <N extends Number> L gt(String name, N value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.GT, queryAlias, ignorePolicy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <D extends Date> L gt(String name, D value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.GT, queryAlias, ignorePolicy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L gt(String name, LocalTime value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.GT, queryAlias, ignorePolicy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L gt(String name, LocalDate value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.GT, queryAlias, ignorePolicy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L gt(String name, LocalDateTime value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.GT, queryAlias, ignorePolicy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L gt(String name, String value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.GT, queryAlias, ignorePolicy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L in(String name, Object value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.IN, queryAlias, ignorePolicy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L inn(String name) {
    //        return inn(name, true);
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L inn(String name, Boolean value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.INN, queryAlias, ignorePolicy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L isn(String name) {
    //        return isn(name, true);
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L isn(String name, Boolean value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.ISN, queryAlias, ignorePolicy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <N extends Number> L le(String name, N value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.LE, queryAlias, ignorePolicy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <D extends Date> L le(String name, D value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.LE, queryAlias, ignorePolicy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L le(String name, LocalTime value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.LE, queryAlias, ignorePolicy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L le(String name, LocalDate value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.LE, queryAlias, ignorePolicy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L le(String name, LocalDateTime value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.LE, queryAlias, ignorePolicy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L le(String name, String value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.LE, queryAlias, ignorePolicy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <N extends Number> L lt(String name, N value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.LT, queryAlias, ignorePolicy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <D extends Date> L lt(String name, D value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.LT, queryAlias, ignorePolicy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L lt(String name, LocalTime value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.LT, queryAlias, ignorePolicy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L lt(String name, LocalDate value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.LT, queryAlias, ignorePolicy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L lt(String name, LocalDateTime value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.LT, queryAlias, ignorePolicy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L lt(String name, String value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.LT, queryAlias, ignorePolicy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L nin(String name, Object value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.NIN, queryAlias, ignorePolicy));
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public C group() {
        C group = createGroup((L) this, queryAlias, entityQuery);
        addCondition(group);
        return group;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L group(Function<C, L> group) {
        C g = group();
        return group.apply(g).endGroup();
    }

    /**
     * Creates the group.
     *
     * @param parent            the parent
     * @param queryAlias        the query alias
     * @param entityQueryEntity the entity query entity
     * @return the c
     */
    protected abstract C createGroup(L parent, String queryAlias, EntitySqlQuery<E> entityQueryEntity);

    /**
     * Gets the root.
     *
     * @return the root
     */
    protected AbstractEntitySqlConditionGroupExpression<E, C, L> getRoot() {
        L p = endGroup();
        L p2 = p.endGroup();
        while (p != p2) {
            p = p.endGroup();
        }
        return (AbstractEntitySqlConditionGroupExpression<E, C, L>) p;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L endGroup() {
        if (parent != null) {
            return parent;
        } else {
            return (L) this;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public C logic(LogicOperator operator) {
        AssertIllegalArgument.isNotNull(operator, "operator");
        return (C) addCondition(new SqlLogicOperatorExpressionBuilder(operator));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public C and() {
        return (C) addCondition(new SqlLogicOperatorExpressionBuilder(LogicOperator.AND));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L and(Function<C, L> group) {
        return and().group(group);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public C or() {
        return (C) addCondition(new SqlLogicOperatorExpressionBuilder(LogicOperator.OR));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L or(Function<C, L> group) {
        return or().group(group);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public ObjectExpression<C, L> property(String name) {
    //        // IMPLSOON 这里后续来实现
    //        return null;
    //        //        return new SimpleObjectExpression<C, L>(ClassMappingUtils.getColumnName(name, classMapping), this);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public StringExpression<C, L> propertyString(String name) {
    //        return new SimpleStringExpression<>(ClassMappingUtils.getColumnName(name, classMapping), this);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public NumberExpression<C, L> propertyNumber(String name) {
    //        return new SimpleNumberExpression<>(ClassMappingUtils.getColumnName(name, classMapping), this);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public DateExpression<C, L> propertyDate(String name) {
    //        return new SimpleDateExpression<>(ClassMappingUtils.getColumnName(name, classMapping), this);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public EnumExpression<C, L> propertyEnum(String name) {
    //        return new SimpleEnumExpression<>(ClassMappingUtils.getColumnName(name, classMapping), this);
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ge(SerializableFunction<E, N> name, N value) {
        return ge0(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ge(SerializableFunction<E, D> name, D value) {
        return ge0(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableFunction<E, LocalTime> name, LocalTime value) {
        return ge0(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableFunction<E, LocalDate> name, LocalDate value) {
        return ge0(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableFunction<E, LocalDateTime> name, LocalDateTime value) {
        return ge0(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableFunction<E, String> name, String value) {
        return ge0(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L ge(DateSupplier<R> property) {
        return ge0(property);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L ge(NumberSupplier<R> property) {
        return ge0(property);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(LocalDateSupplier property) {
        return ge0(property);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(LocalTimeSupplier property) {
        return ge0(property);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(LocalDateTimeSupplier property) {
        return ge0(property);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(StringSupplier property) {
        return ge0(property);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L gt(SerializableFunction<E, N> name, N value) {
        return gt0(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L gt(SerializableFunction<E, D> name, D value) {
        return gt0(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableFunction<E, LocalTime> name, LocalTime value) {
        return gt0(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableFunction<E, LocalDate> name, LocalDate value) {
        return gt0(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableFunction<E, LocalDateTime> name, LocalDateTime value) {
        return gt0(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableFunction<E, String> name, String value) {
        return gt0(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L gt(NumberSupplier<R> property) {
        return gt0(property);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L gt(DateSupplier<R> property) {
        return gt0(property);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(LocalDateSupplier property) {
        return gt0(property);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(LocalTimeSupplier property) {
        return gt0(property);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(LocalDateTimeSupplier property) {
        return gt0(property);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(StringSupplier property) {
        return gt0(property);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in(SerializableFunction<E, R> name, R value) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in(SerializableFunction<E, R> name, R... value) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in(SerializableFunction<E, R> name, Collection<R> value) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in(SerializableSupplier<R> property) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return in(classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in(SerializableSupplier1<R[]> property) {
        SerializableSupplierLambdaInfo<R[]> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return in(classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in(SerializableSupplier2<Collection<R>> property) {
        SerializableSupplierLambdaInfo<Collection<R>> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return in(classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin(SerializableFunction<E, R> name, R value) {
        return nin(classMapping.getPropertyMapping(getPropertyName(name)), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin(SerializableFunction<E, R> name, R... value) {
        return nin(classMapping.getPropertyMapping(getPropertyName(name)), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin(SerializableFunction<E, R> name, Collection<R> value) {
        return nin(classMapping.getPropertyMapping(getPropertyName(name)), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin(SerializableSupplier<R> property) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return nin(classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin(SerializableSupplier1<R[]> property) {
        SerializableSupplierLambdaInfo<R[]> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return nin(classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin(SerializableSupplier2<Collection<R>> property) {
        SerializableSupplierLambdaInfo<Collection<R>> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return nin(classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L inn(SerializableFunction<E, R> name, Boolean value) {
        return inn(classMapping.getPropertyMapping(getPropertyName(name)), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L isn(SerializableFunction<E, R> name, Boolean value) {
        return isn(classMapping.getPropertyMapping(getPropertyName(name)), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L le(SerializableFunction<E, N> name, N value) {
        return le0(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L le(SerializableFunction<E, D> name, D value) {
        return le0(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableFunction<E, LocalTime> name, LocalTime value) {
        return le0(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableFunction<E, LocalDate> name, LocalDate value) {
        return le0(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableFunction<E, LocalDateTime> name, LocalDateTime value) {
        return le0(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableFunction<E, String> name, String value) {
        return le0(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L le(DateSupplier<R> property) {
        return le0(property);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L le(NumberSupplier<R> property) {
        return le0(property);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(LocalDateSupplier property) {
        return le0(property);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(LocalTimeSupplier property) {
        return le0(property);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(LocalDateTimeSupplier property) {
        return le0(property);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(StringSupplier property) {
        return le0(property);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L lt(SerializableFunction<E, N> name, N value) {
        return lt0(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L lt(SerializableFunction<E, D> name, D value) {
        return lt0(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableFunction<E, LocalTime> name, LocalTime value) {
        return lt0(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableFunction<E, LocalDate> name, LocalDate value) {
        return lt0(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableFunction<E, LocalDateTime> name, LocalDateTime value) {
        return lt0(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableFunction<E, String> name, String value) {
        return lt0(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L lt(NumberSupplier<R> property) {
        return lt0(property);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L lt(DateSupplier<R> property) {
        return lt0(property);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(LocalDateSupplier property) {
        return lt0(property);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(LocalTimeSupplier property) {
        return lt0(property);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(LocalDateTimeSupplier property) {
        return lt0(property);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(StringSupplier property) {
        return lt0(property);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L expression(String expression, final Map<String, Object> params) {
    //        final Execution execution = SqlUtils.convertNamedParamSql(expression, params);
    //        return expression(execution.getExecution(), execution.getParams());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L expression(String expression, Object... params) {
    //        return (L) addCondition(new ParamedExpression() {
    //
    //            @Override
    //            public String expression() {
    //                return expression;
    //            }
    //
    //            @Override
    //            public Object getParam() {
    //                return params;
    //            }
    //        });
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <R> ObjectExpression<C, L> property(SerializableFunction<E, R> name) {
    //        return property(getPropertyName(name));
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StringExpression<C, L> property(ReturnStringFunction<E> name) {
        return new TypeStringExpression<>(name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> NumberExpression<R, C, L> property(ReturnNumberFunction<E, R> name) {
        return new TypeNumberExpression<>(name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateExpression<C, L> property(ReturnLocalDateFunction<E> name) {
        return new TypeLocalDateExpression<>(name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTimeExpression<C, L> property(ReturnLocalDateTimeFunction<E> name) {
        return new TypeLocalDateTimeExpression<>(name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalTimeExpression<C, L> property(ReturnLocalTimeFunction<E> name) {
        return new TypeLocalTimeExpression<>(name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> DateExpression<R, C, L> property(ReturnDateFunction<E, R> name) {
        return new TypeDateExpression<>(name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Enum<?>> EnumExpression<R, C, L> property(ReturnEnumFunction<E, R> name) {
        // IMPLSOON 这里后续来实现
        return new TypeEnumExpression<>(name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public C setIgnorePolicy(Predicate<Object> ignorePolicy) {
        AssertIllegalArgument.isNotNull(ignorePolicy, "ignorePolicy");
        this.ignorePolicy = ignorePolicy;
        return (C) this;
    }

    // ********************************************************************
    // private method
    // ********************************************************************

    private <R> L in(JdbcPropertyMapping pm, R value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                value == null ? null
                        : new FieldValueOperator<>((JavaTypeSqlTypeOperator<R>) pm.getJavaTypeSqlTypeOperator(), value),
                QueryOperator.IN, queryAlias, ignorePolicy));
    }

    private <R> L nin(JdbcPropertyMapping pm, R value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                value == null ? null
                        : new FieldValueOperator<>((JavaTypeSqlTypeOperator<R>) pm.getJavaTypeSqlTypeOperator(), value),
                QueryOperator.NIN, queryAlias, ignorePolicy));
    }

    private L isn(JdbcPropertyMapping pm, Boolean value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(), value,
                QueryOperator.ISN, queryAlias, ignorePolicy));
    }

    private L inn(JdbcPropertyMapping pm, Boolean value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(), value,
                QueryOperator.INN, queryAlias, ignorePolicy));
    }

    private <V> L ge0(SerializableFunction<E, V> name, V value) {
        return ge0(classMapping.getPropertyMapping(getPropertyName(name)), value);
    }

    private <V> L ge0(SerializableSupplier<V> property) {
        return ge0(classMapping.getPropertyMapping(
                LambdaUtils.getSerializableSupplierLambdaInfo(property).getSerializedLambdaInfo().getPropertyName()),
                property.get());
    }

    private <V> L ge0(JdbcPropertyMapping pm, V value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                value == null ? null
                        : new FieldValueOperator<>((JavaTypeSqlTypeOperator<V>) pm.getJavaTypeSqlTypeOperator(), value),
                QueryOperator.GE, queryAlias, ignorePolicy));
    }

    private <V> L gt0(SerializableFunction<E, V> name, V value) {
        return gt0(classMapping.getPropertyMapping(getPropertyName(name)), value);
    }

    private <V> L gt0(SerializableSupplier<V> property) {
        return gt0(classMapping.getPropertyMapping(
                LambdaUtils.getSerializableSupplierLambdaInfo(property).getSerializedLambdaInfo().getPropertyName()),
                property.get());
    }

    private <V> L gt0(JdbcPropertyMapping pm, V value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                value == null ? null
                        : new FieldValueOperator<>((JavaTypeSqlTypeOperator<V>) pm.getJavaTypeSqlTypeOperator(), value),
                QueryOperator.GT, queryAlias, ignorePolicy));
    }

    private <V> L le0(SerializableFunction<E, V> name, V value) {
        return le0(classMapping.getPropertyMapping(getPropertyName(name)), value);
    }

    private <V> L le0(SerializableSupplier<V> property) {
        return le0(classMapping.getPropertyMapping(
                LambdaUtils.getSerializableSupplierLambdaInfo(property).getSerializedLambdaInfo().getPropertyName()),
                property.get());
    }

    private <V> L le0(JdbcPropertyMapping pm, V value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                value == null ? null
                        : new FieldValueOperator<>((JavaTypeSqlTypeOperator<V>) pm.getJavaTypeSqlTypeOperator(), value),
                QueryOperator.LE, queryAlias, ignorePolicy));
    }

    private <V> L lt0(SerializableFunction<E, V> name, V value) {
        return lt0(classMapping.getPropertyMapping(getPropertyName(name)), value);
    }

    private <V> L lt0(SerializableSupplier<V> property) {
        return lt0(classMapping.getPropertyMapping(
                LambdaUtils.getSerializableSupplierLambdaInfo(property).getSerializedLambdaInfo().getPropertyName()),
                property.get());
    }

    private <V> L lt0(JdbcPropertyMapping pm, V value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                value == null ? null
                        : new FieldValueOperator<>((JavaTypeSqlTypeOperator<V>) pm.getJavaTypeSqlTypeOperator(), value),
                QueryOperator.LT, queryAlias, ignorePolicy));
    }

    // ********************************************************************
    // protected method
    // ********************************************************************

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

    /** The class mapping. */
    protected JdbcClassMapping<E> classMapping;

    /** The query alias. */
    protected String queryAlias;

    /**
     * 返回queryAlias.
     *
     * @return queryAlias
     */
    public String getQueryAlias() {
        return queryAlias;
    }
}
