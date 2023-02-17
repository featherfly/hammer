
package cn.featherfly.hammer.sqldb.sql.dml;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuple3;

import cn.featherfly.common.bean.BeanDescriptor;
import cn.featherfly.common.db.FieldValueOperator;
import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.ClassUtils;
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
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.common.repository.mapping.PropertyMapping.Mode;
import cn.featherfly.hammer.expression.EntityConditionGroupExpression;
import cn.featherfly.hammer.expression.EntityConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.condition.ParamedExpression;
import cn.featherfly.hammer.expression.condition.type.property.EntityDatePropertyExpression;
import cn.featherfly.hammer.expression.condition.type.property.EntityDatePropertyExpressionImpl;
import cn.featherfly.hammer.expression.condition.type.property.EntityEnumPropertyExpression;
import cn.featherfly.hammer.expression.condition.type.property.EntityEnumPropertyExpressionImpl;
import cn.featherfly.hammer.expression.condition.type.property.EntityLocalDatePropertyExpression;
import cn.featherfly.hammer.expression.condition.type.property.EntityLocalDatePropertyExpressionImpl;
import cn.featherfly.hammer.expression.condition.type.property.EntityLocalDateTimePropertyExpression;
import cn.featherfly.hammer.expression.condition.type.property.EntityLocalDateTimePropertyExpressionImpl;
import cn.featherfly.hammer.expression.condition.type.property.EntityLocalTimePropertyExpression;
import cn.featherfly.hammer.expression.condition.type.property.EntityLocalTimePropertyExpressionImpl;
import cn.featherfly.hammer.expression.condition.type.property.EntityNumberPropertyExpression;
import cn.featherfly.hammer.expression.condition.type.property.EntityNumberPropertyExpressionImpl;
import cn.featherfly.hammer.expression.condition.type.property.EntityStringPropertyExpression;
import cn.featherfly.hammer.expression.condition.type.property.EntityStringPropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.query.EntitySqlQuery;

/**
 * sql condition group builder sql条件逻辑组构造器 .
 *
 * @author zhongj
 * @param <E> the element type
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

    /** The factory. */
    protected JdbcMappingFactory factory;

    /** The alias manager. */
    protected AliasManager aliasManager;

    /**
     * Instantiates a new abstract sql condition group expression.
     *
     * @param parent         parent group
     * @param dialect        dialect
     * @param sqlPageFactory the sql page factory
     * @param queryAlias     queryAlias
     * @param classMapping   classMapping
     * @param factory        the factory
     * @param aliasManager   the alias manager
     * @param entityQuery    the entity query
     * @param ignorePolicy   the ignore policy
     */
    protected AbstractEntitySqlConditionGroupExpression(L parent, Dialect dialect, SqlPageFactory sqlPageFactory,
            String queryAlias, JdbcClassMapping<E> classMapping, JdbcMappingFactory factory, AliasManager aliasManager,
            EntitySqlQuery<E> entityQuery, Predicate<Object> ignorePolicy) {
        super(dialect, ignorePolicy, parent);
        this.queryAlias = queryAlias;
        this.sqlPageFactory = sqlPageFactory;
        this.classMapping = classMapping;
        this.factory = factory;
        this.aliasManager = aliasManager;
        this.entityQuery = entityQuery;
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
        return eq_ne(QueryOperator.EQ, classMapping.getPropertyMapping(getPropertyName(name)), value, queryPolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L eq(SerializableSupplier<R> property, QueryPolicy queryPolicy) {
        return eq_ne(
                QueryOperator.EQ, classMapping.getPropertyMapping(LambdaUtils
                        .getSerializableSupplierLambdaInfo(property).getSerializedLambdaInfo().getPropertyName()),
                property.get(), queryPolicy);
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
        return eq_ne(QueryOperator.NE, classMapping.getPropertyMapping(getPropertyName(name)), value, queryPolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ne(SerializableSupplier<R> property, QueryPolicy queryPolicy) {
        return eq_ne(
                QueryOperator.NE, classMapping.getPropertyMapping(LambdaUtils
                        .getSerializableSupplierLambdaInfo(property).getSerializedLambdaInfo().getPropertyName()),
                property.get(), queryPolicy);
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
        //        JdbcPropertyMapping pm = classMapping.getPropertyMapping(getPropertyName(name));
        //        return (L) addCondition(
        //                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
        //                        value == null ? null
        //                                : new FieldValueOperator<>(
        //                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
        //                        QueryOperator.LK, queryPolicy, queryAlias, ignorePolicy));
        return lk(classMapping.getPropertyMapping(getPropertyName(name)), value, queryPolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(StringSupplier property, QueryPolicy queryPolicy) {
        //  YUFEI_TODO 未测试
        //        String value = property.get();
        //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        JdbcPropertyMapping pm = classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName());
        //        return (L) addCondition(
        //                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
        //                        value == null ? null
        //                                : new FieldValueOperator<>(
        //                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
        //                        QueryOperator.LK, queryPolicy, queryAlias, ignorePolicy));
        return lk(classMapping.getPropertyMapping(
                LambdaUtils.getSerializableSupplierLambdaInfo(property).getSerializedLambdaInfo().getPropertyName()),
                property.get(), queryPolicy);
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
        //        JdbcPropertyMapping pm = classMapping.getPropertyMapping(getPropertyName(name));
        //        return (L) addCondition(
        //                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
        //                        value == null ? null
        //                                : new FieldValueOperator<>(
        //                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
        //                        QueryOperator.SW, queryPolicy, queryAlias, ignorePolicy));
        return sw(classMapping.getPropertyMapping(getPropertyName(name)), value, queryPolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(StringSupplier property, QueryPolicy queryPolicy) {
        //  YUFEI_TODO 未测试
        //        String value = property.get();
        //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        JdbcPropertyMapping pm = classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName());
        //        return (L) addCondition(
        //                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
        //                        value == null ? null
        //                                : new FieldValueOperator<>(
        //                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
        //                        QueryOperator.SW, queryPolicy, queryAlias, ignorePolicy));
        return sw(classMapping.getPropertyMapping(
                LambdaUtils.getSerializableSupplierLambdaInfo(property).getSerializedLambdaInfo().getPropertyName()),
                property.get(), queryPolicy);
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
        //        JdbcPropertyMapping pm = classMapping.getPropertyMapping(getPropertyName(name));
        //        return (L) addCondition(
        //                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
        //                        value == null ? null
        //                                : new FieldValueOperator<>(
        //                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
        //                        QueryOperator.EW, queryPolicy, queryAlias, ignorePolicy));
        return ew(classMapping.getPropertyMapping(getPropertyName(name)), value, queryPolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(StringSupplier property, QueryPolicy queryPolicy) {
        //  YUFEI_TODO 未测试
        //        String value = property.get();
        //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        JdbcPropertyMapping pm = classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName());
        //        return (L) addCondition(
        //                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
        //                        value == null ? null
        //                                : new FieldValueOperator<>(
        //                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
        //                        QueryOperator.EW, queryPolicy, queryAlias, ignorePolicy));
        return ew(classMapping.getPropertyMapping(
                LambdaUtils.getSerializableSupplierLambdaInfo(property).getSerializedLambdaInfo().getPropertyName()),
                property.get(), queryPolicy);
    }

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
        //                        QueryOperator.CO, queryPolicy, queryAlias, ignorePolicy));
        return co(classMapping.getPropertyMapping(getPropertyName(name)), value, queryPolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(StringSupplier property, QueryPolicy queryPolicy) {
        //  YUFEI_TODO 未测试
        //        String value = property.get();
        //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        JdbcPropertyMapping pm = classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName());
        //        return (L) addCondition(
        //                new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
        //                        value == null ? null
        //                                : new FieldValueOperator<>(
        //                                        (JavaTypeSqlTypeOperator<String>) pm.getJavaTypeSqlTypeOperator(), value),
        //                        QueryOperator.CO, queryPolicy, queryAlias, ignorePolicy));
        return co(classMapping.getPropertyMapping(
                LambdaUtils.getSerializableSupplierLambdaInfo(property).getSerializedLambdaInfo().getPropertyName()),
                property.get(), queryPolicy);
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
        //        L p2 = p.endGroup();
        //        while (p != p2) {
        while (p != p.endGroup()) {
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
    public L in(SerializableFunction<E, ?> name, Object value) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in(SerializableFunction<E, R> name, R[] value) {
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
    public L nin(SerializableFunction<E, ?> name, Object value) {
        return nin(classMapping.getPropertyMapping(getPropertyName(name)), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin(SerializableFunction<E, R> name, R[] value) {
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
    public EntityStringPropertyExpression<E, C, L> property(ReturnStringFunction<E> name) {
        return new EntityStringPropertyExpressionImpl<>(name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> EntityNumberPropertyExpression<E, R, C, L> property(ReturnNumberFunction<E, R> name) {
        return new EntityNumberPropertyExpressionImpl<>(name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLocalDatePropertyExpression<E, C, L> property(ReturnLocalDateFunction<E> name) {
        return new EntityLocalDatePropertyExpressionImpl<>(name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLocalDateTimePropertyExpression<E, C, L> property(ReturnLocalDateTimeFunction<E> name) {
        return new EntityLocalDateTimePropertyExpressionImpl<>(name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLocalTimePropertyExpression<E, C, L> property(ReturnLocalTimeFunction<E> name) {
        return new EntityLocalTimePropertyExpressionImpl<>(name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> EntityDatePropertyExpression<E, R, C, L> property(ReturnDateFunction<E, R> name) {
        return new EntityDatePropertyExpressionImpl<>(name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Enum<R>> EntityEnumPropertyExpression<E, R, C, L> property(ReturnEnumFunction<E, R> name) {
        return new EntityEnumPropertyExpressionImpl<>(name, this);
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

    //  join 条件查询

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L co(SerializableFunction<E, R> repository, SerializableFunction<R, String> property, String value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), value, QueryOperator.CO,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L co(SerializableSupplier<R> repository, SerializableFunction<R, String> property) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), tuple.get2(), QueryOperator.CO,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ew(SerializableFunction<E, R> repository, SerializableFunction<R, String> property, String value) {
        //        IMPLSOON 后续来实现join
        //         //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), value, QueryOperator.EW,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ew(SerializableSupplier<R> repository, SerializableFunction<R, String> property) {
        //        IMPLSOON 后续来实现join
        //         //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), tuple.get2(), QueryOperator.EW,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, V> L eq(SerializableFunction<E, R> repository, SerializableFunction<R, V> property, V value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), value, QueryOperator.EQ,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, V> L eq(SerializableSupplier<R> repository, SerializableFunction<R, V> property) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), tuple.get2(), QueryOperator.EQ,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, N extends Number> L ge(SerializableFunction<E, R> repository, SerializableFunction<R, N> property,
            N value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), value, QueryOperator.GE,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> L ge(SerializableSupplier<T> repository, ReturnNumberFunction<T, N> property) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), tuple.get2(), QueryOperator.GE,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, D extends Date> L ge(SerializableFunction<E, R> repository, SerializableFunction<R, D> property,
            D value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), value, QueryOperator.GE,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> L ge(SerializableSupplier<T> repository, ReturnDateFunction<T, D> property) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), tuple.get2(), QueryOperator.GE,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ge(SerializableFunction<E, R> repository, SerializableFunction<R, LocalTime> property,
            LocalTime value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), value, QueryOperator.GE,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ge(SerializableSupplier<T> repository, ReturnLocalTimeFunction<T> property) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), tuple.get2(), QueryOperator.GE,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ge(SerializableFunction<E, R> repository, SerializableFunction<R, LocalDate> property,
            LocalDate value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), value, QueryOperator.GE,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ge(SerializableSupplier<T> repository, ReturnLocalDateFunction<T> property) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), tuple.get2(), QueryOperator.GE,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ge(SerializableFunction<E, R> repository, SerializableFunction<R, LocalDateTime> property,
            LocalDateTime value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), value, QueryOperator.GE,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ge(SerializableSupplier<T> repository, ReturnLocalDateTimeFunction<T> property) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), tuple.get2(), QueryOperator.GE,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ge(SerializableFunction<E, R> repository, SerializableFunction<R, String> property, String value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), value, QueryOperator.GE,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ge(SerializableSupplier<T> repository, ReturnStringFunction<T> property) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), tuple.get2(), QueryOperator.GE,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, N extends Number> L gt(SerializableFunction<E, R> repository, SerializableFunction<R, N> property,
            N value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), value, QueryOperator.GT,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> L gt(SerializableSupplier<T> repository, ReturnNumberFunction<T, N> property) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), tuple.get2(), QueryOperator.GT,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, D extends Date> L gt(SerializableFunction<E, R> repository, SerializableFunction<R, D> property,
            D value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), value, QueryOperator.GT,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> L gt(SerializableSupplier<T> repository, ReturnDateFunction<T, D> property) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), tuple.get2(), QueryOperator.GT,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L gt(SerializableFunction<E, R> repository, SerializableFunction<R, LocalTime> property,
            LocalTime value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), value, QueryOperator.GT,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L gt(SerializableSupplier<T> repository, ReturnLocalTimeFunction<T> property) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), tuple.get2(), QueryOperator.GT,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L gt(SerializableFunction<E, R> repository, SerializableFunction<R, LocalDate> property,
            LocalDate value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), value, QueryOperator.GT,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L gt(SerializableSupplier<T> repository, ReturnLocalDateFunction<T> property) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), tuple.get2(), QueryOperator.GT,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L gt(SerializableFunction<E, R> repository, SerializableFunction<R, LocalDateTime> property,
            LocalDateTime value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), value, QueryOperator.GT,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L gt(SerializableSupplier<T> repository, ReturnLocalDateTimeFunction<T> property) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), tuple.get2(), QueryOperator.GT,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L gt(SerializableFunction<E, R> repository, SerializableFunction<R, String> property, String value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), value, QueryOperator.GT,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L gt(SerializableSupplier<T> repository, ReturnStringFunction<T> property) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), tuple.get2(), QueryOperator.GT,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, V> L in(SerializableFunction<E, R> repository, SerializableFunction<R, V> property, V value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), value, QueryOperator.IN,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, V> L in(SerializableSupplier<R> repository, SerializableFunction<R, V> property) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), tuple.get2(), QueryOperator.IN,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, V> L inn(SerializableFunction<E, R> repository, SerializableFunction<R, V> property, Boolean value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), value, QueryOperator.INN,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, V> L isn(SerializableFunction<E, R> repository, SerializableFunction<R, V> property) {
        return isn(repository, property, true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, V> L isn(SerializableFunction<E, R> repository, SerializableFunction<R, V> property, Boolean value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), value, QueryOperator.ISN,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, N extends Number> L le(SerializableFunction<E, R> repository, SerializableFunction<R, N> property,
            N value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), value, QueryOperator.LE,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, N extends Number> L le(SerializableSupplier<R> repository, ReturnNumberFunction<R, N> property) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), tuple.get2(), QueryOperator.LE,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, D extends Date> L le(SerializableFunction<E, R> repository, SerializableFunction<R, D> property,
            D value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), value, QueryOperator.LE,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, D extends Date> L le(SerializableSupplier<R> repository, ReturnDateFunction<R, D> property) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), tuple.get2(), QueryOperator.LE,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L le(SerializableFunction<E, R> repository, SerializableFunction<R, LocalTime> property,
            LocalTime value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), value, QueryOperator.LE,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L le(SerializableSupplier<T> repository, ReturnLocalTimeFunction<T> property) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), tuple.get2(), QueryOperator.LE,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L le(SerializableFunction<E, R> repository, SerializableFunction<R, LocalDate> property,
            LocalDate value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), value, QueryOperator.LE,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L le(SerializableSupplier<T> repository, ReturnLocalDateFunction<T> property) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), tuple.get2(), QueryOperator.LE,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L le(SerializableFunction<E, R> repository, SerializableFunction<R, LocalDateTime> property,
            LocalDateTime value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), value, QueryOperator.LE,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L le(SerializableSupplier<T> repository, ReturnLocalDateTimeFunction<T> property) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), tuple.get2(), QueryOperator.LE,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L le(SerializableFunction<E, R> repository, SerializableFunction<R, String> property, String value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), value, QueryOperator.LE,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L le(SerializableSupplier<R> repository, ReturnStringFunction<R> property) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), tuple.get2(), QueryOperator.LE,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, N extends Number> L lt(SerializableFunction<E, R> repository, SerializableFunction<R, N> property,
            N value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), value, QueryOperator.LT,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> L lt(SerializableSupplier<T> repository, ReturnNumberFunction<T, N> property) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), tuple.get2(), QueryOperator.LT,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, D extends Date> L lt(SerializableFunction<E, R> repository, SerializableFunction<R, D> property,
            D value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), value, QueryOperator.LT,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> L lt(SerializableSupplier<T> repository, SerializableFunction<T, D> property) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), tuple.get2(), QueryOperator.LT,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L lt(SerializableFunction<E, R> repository, SerializableFunction<R, LocalTime> property,
            LocalTime value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), value, QueryOperator.LT,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L lt(SerializableSupplier<T> repository, ReturnLocalTimeFunction<T> property) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), tuple.get2(), QueryOperator.LT,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L lt(SerializableFunction<E, R> repository, SerializableFunction<R, LocalDate> property,
            LocalDate value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), value, QueryOperator.LT,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L lt(SerializableSupplier<T> repository, ReturnLocalDateFunction<T> property) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), tuple.get2(), QueryOperator.LT,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L lt(SerializableFunction<E, R> repository, SerializableFunction<R, LocalDateTime> property,
            LocalDateTime value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), value, QueryOperator.LT,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L lt(SerializableSupplier<T> repository, ReturnLocalDateTimeFunction<T> property) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), tuple.get2(), QueryOperator.LT,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L lt(SerializableFunction<E, R> repository, SerializableFunction<R, String> property, String value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), value, QueryOperator.LT,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L lt(SerializableSupplier<T> repository, ReturnStringFunction<T> property) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), tuple.get2(), QueryOperator.LT,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, V> L ne(SerializableFunction<E, R> repository, SerializableFunction<R, V> property, V value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), value, QueryOperator.EQ,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, V> L ne(SerializableSupplier<R> repository, SerializableFunction<R, V> property) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), tuple.get2(), QueryOperator.NE,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, V> L nin(SerializableFunction<E, R> repository, SerializableFunction<R, V> property, V value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), value, QueryOperator.NIN,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, V> L nin(SerializableSupplier<R> repository, SerializableFunction<R, V> property) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), tuple.get2(), QueryOperator.NE,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L sw(SerializableFunction<E, R> repository, SerializableFunction<R, String> property, String value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), value, QueryOperator.SW,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L sw(SerializableSupplier<R> repository, SerializableFunction<R, String> property) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), tuple.get2(), QueryOperator.SW,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L lk(SerializableFunction<E, R> repository, SerializableFunction<R, String> property, String value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), value, QueryOperator.LK,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L lk(SerializableSupplier<R> repository, SerializableFunction<R, String> property) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, classMapping, factory);
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, tuple.get1(), tuple.get2(), QueryOperator.LK,
                aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    //  join 条件查询

    // ********************************************************************
    // private method
    // ********************************************************************

    private <R> FieldValueOperator<R> getFieldValueOperator(JdbcPropertyMapping pm, R value) {
        return value == null ? null : FieldValueOperator.craete(pm, value);
    }

    private Object getInParam(JdbcPropertyMapping pm, Object value) {
        Object param = null;
        if (value != null) {
            if (value.getClass().isArray()) {
                int length = Array.getLength(value);
                param = Array.newInstance(FieldValueOperator.class, length);
                for (int i = 0; i < length; i++) {
                    //                    Array.set(param, i, new FieldValueOperator(pm.getJavaTypeSqlTypeOperator(), Array.get(value, i)));
                    Array.set(param, i, FieldValueOperator.craete(pm, Array.get(value, i)));
                }
            } else if (value instanceof Collection) {
                param = new ArrayList<>();
                for (Object op : (Collection<?>) value) {
                    ((Collection<FieldValueOperator<?>>) param).add(FieldValueOperator.craete(pm, op));
                    //                    .add(new FieldValueOperator(pm.getJavaTypeSqlTypeOperator(), op));
                }
            } else if (!(value instanceof FieldValueOperator)) {
                param = FieldValueOperator.craete(pm, value);
            } else {
                param = value;
            }
        }
        return param;
    }

    private <T, R> L eq_ne0(QueryOperator queryOperator, JdbcPropertyMapping pm, R value, QueryPolicy queryPolicy) {
        return eq_ne0(queryOperator, queryAlias, pm, value, queryPolicy);
    }

    private <T, R> L eq_ne0(QueryOperator queryOperator, String queryAlias, JdbcPropertyMapping pm, R value,
            QueryPolicy queryPolicy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), queryOperator, queryPolicy, queryAlias, ignorePolicy));
    }

    private <T, R> L eq_ne(QueryOperator queryOperator, JdbcPropertyMapping pm, R value, QueryPolicy queryPolicy) {
        if (value != null) {
            //            if (Lang.isNotEmpty(pm.getPropertyMappings())) {
            if (pm.getMode() == Mode.MANY_TO_ONE || pm.getMode() == Mode.EMBEDDED) {
                L logic = null;
                C condition = (C) this;
                boolean groupable = pm.getPropertyMappings().size() > 1;
                if (groupable) {
                    condition = group();
                }
                if (ClassUtils.isParent(pm.getPropertyType(), value.getClass())) {
                    BeanDescriptor<?> bd = BeanDescriptor.getBeanDescriptor(value.getClass());

                    for (JdbcPropertyMapping spm : pm.getPropertyMappings()) {
                        Object ov = bd.getBeanProperty(spm.getPropertyName()).getValue(value);
                        if (logic != null) {
                            condition = logic.and();
                        }
                        logic = ((AbstractEntitySqlConditionGroupExpression<E, C, L>) condition).eq_ne0(queryOperator,
                                spm, ov, queryPolicy);
                    }

                    //                    if (pm.getMode() == Mode.EMBEDDED) {
                    //                        for (JdbcPropertyMapping spm : pm.getPropertyMappings()) {
                    //                            Object ov = bd.getBeanProperty(spm.getPropertyName()).getValue(value);
                    //                            if (logic != null) {
                    //                                condition = logic.and();
                    //                            }
                    //                            logic = ((AbstractEntitySqlConditionGroupExpression<E, C, L>) condition)
                    //                                    .eq_ne0(queryOperator, spm, ov, queryPolicy);
                    //                        }
                    //                    } else if (pm.getMode() == Mode.MANY_TO_ONE) {
                    //                        JdbcClassMapping<?> cm = factory.getClassMapping(pm.getPropertyType());
                    //                        for (JdbcPropertyMapping cpm : cm.getPropertyMappings()) {
                    //                            // IMPLSOON 后续来实现关联对象的联表查询
                    //                            Object ov = bd.getBeanProperty(cpm.getPropertyName()).getValue(value);
                    //                            if (logic != null) {
                    //                                condition = logic.and();
                    //                            }
                    //                            logic = ((AbstractEntitySqlConditionGroupExpression<E, C, L>) condition)
                    //                                    .eq_ne0(queryOperator, "", cpm, ov, queryPolicy);
                    //                        }
                    //                    } else {
                    //                        // FIXME 后续来实现
                    //                        throw new SqldbHammerException("not support");
                    //                    }
                    if (groupable) {
                        logic = logic.endGroup();
                    }
                    return logic;
                } else {
                    for (JdbcPropertyMapping spm : pm.getPropertyMappings()) {
                        if (ClassUtils.isParent(spm.getPropertyType(), value.getClass())) {
                            return eq_ne0(queryOperator, spm, value, queryPolicy);
                        }
                    }
                }
            }
        }
        return eq_ne0(queryOperator, pm, value, queryPolicy);
    }

    private <T> L sw(JdbcPropertyMapping pm, String value, QueryPolicy queryPolicy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), QueryOperator.SW, queryPolicy, queryAlias, ignorePolicy));
    }

    private <T> L co(JdbcPropertyMapping pm, String value, QueryPolicy queryPolicy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), QueryOperator.CO, queryPolicy, queryAlias, ignorePolicy));
    }

    private <T> L ew(JdbcPropertyMapping pm, String value, QueryPolicy queryPolicy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), QueryOperator.EW, queryPolicy, queryAlias, ignorePolicy));
    }

    private <T> L lk(JdbcPropertyMapping pm, String value, QueryPolicy queryPolicy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), QueryOperator.LK, queryPolicy, queryAlias, ignorePolicy));
    }

    private <T, R> L in(JdbcPropertyMapping pm, R value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                getInParam(pm, value), QueryOperator.IN, queryAlias, ignorePolicy));
    }

    private <R> L nin(JdbcPropertyMapping pm, R value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                getInParam(pm, value), QueryOperator.NIN, queryAlias, ignorePolicy));
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
                getFieldValueOperator(pm, value), QueryOperator.GE, queryAlias, ignorePolicy));
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
                getFieldValueOperator(pm, value), QueryOperator.GT, queryAlias, ignorePolicy));
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
                getFieldValueOperator(pm, value), QueryOperator.LE, queryAlias, ignorePolicy));
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
                getFieldValueOperator(pm, value), QueryOperator.LT, queryAlias, ignorePolicy));
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
