
package cn.featherfly.hammer.sqldb.sql.dml;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.function.Function;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LambdaUtils.SerializableSupplierLambdaInfo;
import cn.featherfly.common.lang.Lang;
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
import cn.featherfly.common.lang.function.StringSupplier;
import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.common.repository.operate.LogicOperator;
import cn.featherfly.common.repository.operate.QueryOperator;
import cn.featherfly.hammer.expression.ConditionGroupExpression;
import cn.featherfly.hammer.expression.ConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.condition.ParamedExpression;
import cn.featherfly.hammer.expression.condition.property.DateExpression;
import cn.featherfly.hammer.expression.condition.property.EnumExpression;
import cn.featherfly.hammer.expression.condition.property.NumberExpression;
import cn.featherfly.hammer.expression.condition.property.ObjectExpression;
import cn.featherfly.hammer.expression.condition.property.SimpleDateExpression;
import cn.featherfly.hammer.expression.condition.property.SimpleEnumExpression;
import cn.featherfly.hammer.expression.condition.property.SimpleNumberExpression;
import cn.featherfly.hammer.expression.condition.property.SimpleObjectExpression;
import cn.featherfly.hammer.expression.condition.property.SimpleStringExpression;
import cn.featherfly.hammer.expression.condition.property.StringExpression;

/**
 * <p>
 * sql condition group builder sql条件逻辑组构造器
 * </p>
 *
 * @author zhongj
 */
@SuppressWarnings("unchecked")
public abstract class AbstractSqlConditionGroupExpression<C extends ConditionGroupExpression<C, L>,
        L extends ConditionGroupLogicExpression<C, L>> extends AbstractSqlConditionExpression<L>
        implements ConditionGroupExpression<C, L>, ConditionGroupLogicExpression<C, L>, SqlBuilder, ParamedExpression {

    /**
     * @param dialect dialect
     */
    public AbstractSqlConditionGroupExpression(Dialect dialect) {
        this(dialect, null, null);
    }

    /**
     * @param dialect    dialect
     * @param queryAlias queryAlias
     */
    public AbstractSqlConditionGroupExpression(Dialect dialect, String queryAlias) {
        this(dialect, null, queryAlias, null);
    }

    /**
     * @param dialect      dialect
     * @param queryAlias   queryAlias
     * @param classMapping classMapping
     */
    public AbstractSqlConditionGroupExpression(Dialect dialect, String queryAlias, ClassMapping<?> classMapping) {
        this(dialect, null, queryAlias, classMapping);
    }

    /**
     * @param dialect      dialect
     * @param parent       parent group
     * @param queryAlias   queryAlias
     * @param classMapping classMapping
     */
    protected AbstractSqlConditionGroupExpression(Dialect dialect, L parent, String queryAlias,
            ClassMapping<?> classMapping) {
        super(dialect, parent);
        this.queryAlias = queryAlias;
        this.classMapping = classMapping;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return build();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String name, String value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.CO, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String name, String value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.EW, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String name, Object value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.EQ, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ge(String name, N value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.GE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ge(String name, D value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.GE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String name, LocalTime value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.GE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String name, LocalDate value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.GE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String name, LocalDateTime value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.GE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String name, String value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.GE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L gt(String name, N value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.GT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L gt(String name, D value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.GT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String name, LocalTime value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.GT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String name, LocalDate value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.GT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String name, LocalDateTime value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.GT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String name, String value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.GT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String name, Object value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.IN, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L inn(String name) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), null, QueryOperator.INN, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L isn(String name) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), null, QueryOperator.ISN, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L le(String name, N value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.LE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L le(String name, D value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.LE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, LocalTime value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.LE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, LocalDate value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.LE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, LocalDateTime value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.LE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, String value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.LE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L lt(String name, N value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.LT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L lt(String name, D value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.LT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String name, LocalTime value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.LT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String name, LocalDate value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.LT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String name, LocalDateTime value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.LT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String name, String value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.LT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String name, Object value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.NE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(String name, Object value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.NIN, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(String name, String value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.SW, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public C group() {
        // SqlConditionGroupExpressionBuilder group = new
        // SqlConditionGroupExpressionBuilder(
        // jdbc, this, queryAlias);
        C group = createGroup((L) this, queryAlias);
        addCondition(group);
        return group;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L group(Function<C, L> group) {
        group.apply(group());
        return endGroup();
    }

    protected abstract C createGroup(L parent, String queryAlias);

    protected AbstractSqlConditionGroupExpression<C, L> getRoot() {
        L p = endGroup();
        L p2 = p.endGroup();
        while (p != p2) {
            p = p.endGroup();
        }
        return (AbstractSqlConditionGroupExpression<C, L>) p;
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
    public C and() {
        return (C) addCondition(new SqlLogicOperatorExpressionBuilder(LogicOperator.AND));
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
    public ObjectExpression<C, L> property(String name) {
        return new SimpleObjectExpression<>(ClassMappingUtils.getColumnName(name, classMapping), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StringExpression<C, L> propertyString(String name) {
        return new SimpleStringExpression<>(ClassMappingUtils.getColumnName(name, classMapping), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NumberExpression<C, L> propertyNumber(String name) {
        return new SimpleNumberExpression<>(ClassMappingUtils.getColumnName(name, classMapping), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DateExpression<C, L> propertyDate(String name) {
        return new SimpleDateExpression<>(ClassMappingUtils.getColumnName(name, classMapping), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EnumExpression<C, L> propertyEnum(String name) {
        return new SimpleEnumExpression<>(ClassMappingUtils.getColumnName(name, classMapping), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L co(ReturnStringFunction<T> name, String value) {
        return co(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ew(ReturnStringFunction<T> name, String value) {
        return ew(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L eq(SerializableFunction<T, R> name, Object value) {
        return eq(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> L ge(ReturnNumberFunction<T, N> name, N value) {
        return ge(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> L ge(ReturnDateFunction<T, D> name, D value) {
        return ge(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ge(ReturnLocalTimeFunction<T> name, LocalTime value) {
        return ge(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ge(ReturnLocalDateFunction<T> name, LocalDate value) {
        return ge(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ge(ReturnLocalDateTimeFunction<T> name, LocalDateTime value) {
        return ge(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ge(ReturnStringFunction<T> name, String value) {
        return ge(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> L gt(ReturnNumberFunction<T, N> name, N value) {
        return gt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> L gt(ReturnDateFunction<T, D> name, D value) {
        return gt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L gt(ReturnLocalTimeFunction<T> name, LocalTime value) {
        return gt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L gt(ReturnLocalDateFunction<T> name, LocalDate value) {
        return gt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L gt(ReturnLocalDateTimeFunction<T> name, LocalDateTime value) {
        return gt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L gt(ReturnStringFunction<T> name, String value) {
        return gt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L in(SerializableFunction<T, R> name, Object value) {
        return in(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L inn(SerializableFunction<T, R> name) {
        return inn(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L isn(SerializableFunction<T, R> name) {
        return isn(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> L le(ReturnNumberFunction<T, N> name, N value) {
        return le(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> L le(ReturnDateFunction<T, D> name, D value) {
        return le(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L le(ReturnLocalTimeFunction<T> name, LocalTime value) {
        return le(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L le(ReturnLocalDateFunction<T> name, LocalDate value) {
        return le(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L le(ReturnLocalDateTimeFunction<T> name, LocalDateTime value) {
        return le(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L le(ReturnStringFunction<T> name, String value) {
        return le(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> L lt(ReturnNumberFunction<T, N> name, N value) {
        return lt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> L lt(ReturnDateFunction<T, D> name, D value) {
        return lt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L lt(ReturnLocalTimeFunction<T> name, LocalTime value) {
        return lt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L lt(ReturnLocalDateFunction<T> name, LocalDate value) {
        return lt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L lt(ReturnLocalDateTimeFunction<T> name, LocalDateTime value) {
        return lt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L lt(ReturnStringFunction<T> name, String value) {
        return lt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L ne(SerializableFunction<T, R> name, Object value) {
        return ne(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L nin(SerializableFunction<T, R> name, Object value) {
        return nin(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L sw(ReturnStringFunction<T> name, String value) {
        return sw(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(StringSupplier property) {
        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return co(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(StringSupplier property) {
        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return co(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L eq(SerializableSupplier<R> property) {
        Tuple2<String, R> tuple = supplier(LambdaUtils.getSerializableSupplierLambdaInfo(property));
        return eq(tuple.get0(), tuple.get1());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L ge(DateSupplier<R> property) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ge(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L ge(NumberSupplier<R> property) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ge(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(LocalDateSupplier property) {
        SerializableSupplierLambdaInfo<LocalDate> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ge(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(LocalTimeSupplier property) {
        SerializableSupplierLambdaInfo<LocalTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ge(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(LocalDateTimeSupplier property) {
        SerializableSupplierLambdaInfo<LocalDateTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ge(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(StringSupplier property) {
        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ge(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L gt(NumberSupplier<R> property) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return gt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L gt(DateSupplier<R> property) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return gt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(LocalDateSupplier property) {
        SerializableSupplierLambdaInfo<LocalDate> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return gt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(LocalTimeSupplier property) {
        SerializableSupplierLambdaInfo<LocalTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return gt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(LocalDateTimeSupplier property) {
        SerializableSupplierLambdaInfo<LocalDateTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return gt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(StringSupplier property) {
        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return gt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L le(DateSupplier<R> property) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return le(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L le(NumberSupplier<R> property) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return le(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(LocalDateSupplier property) {
        SerializableSupplierLambdaInfo<LocalDate> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return le(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(LocalTimeSupplier property) {
        SerializableSupplierLambdaInfo<LocalTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return le(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(LocalDateTimeSupplier property) {
        SerializableSupplierLambdaInfo<LocalDateTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return le(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(StringSupplier property) {
        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return le(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L lt(NumberSupplier<R> property) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return lt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L lt(DateSupplier<R> property) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return lt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(LocalDateSupplier property) {
        SerializableSupplierLambdaInfo<LocalDate> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return lt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(LocalTimeSupplier property) {
        SerializableSupplierLambdaInfo<LocalTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return lt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(LocalDateTimeSupplier property) {
        SerializableSupplierLambdaInfo<LocalDateTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return lt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(StringSupplier property) {
        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return lt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in(SerializableSupplier<R> property) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return in(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ne(SerializableSupplier<R> property) {
        //        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        return ne(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
        Tuple2<String, R> tuple = supplier(LambdaUtils.getSerializableSupplierLambdaInfo(property));
        return ne(tuple.get0(), tuple.get1());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin(SerializableSupplier<R> property) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return nin(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(StringSupplier property) {
        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return sw(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> ObjectExpression<C, L> property(SerializableFunction<T, R> name) {
        return property(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> StringExpression<C, L> property(ReturnStringFunction<T> name) {
        return propertyString(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R extends Number> NumberExpression<C, L> property(ReturnNumberFunction<T, R> name) {
        return propertyNumber(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R extends Date> DateExpression<C, L> property(ReturnDateFunction<T, R> name) {
        return propertyDate(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R extends Enum<?>> EnumExpression<C, L> property(ReturnEnumFunction<T, R> name) {
        return propertyEnum(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> StringExpression<C, L> propertyString(SerializableFunction<T, String> name) {
        return propertyString(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R extends Number> NumberExpression<C, L> propertyNumber(SerializableFunction<T, R> name) {
        return propertyNumber(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R extends Date> DateExpression<C, L> propertyDate(SerializableFunction<T, R> name) {
        return propertyDate(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R extends Enum<?>> EnumExpression<C, L> propertyEnum(SerializableFunction<T, R> name) {
        return propertyEnum(getPropertyName(name));
    }

    // ********************************************************************
    // private method
    // ********************************************************************

    protected <R> Tuple2<String, R> supplier(SerializableSupplierLambdaInfo<R> info) {
        String propertyName = info.getSerializedLambdaInfo().getPropertyName();
        R r = info.getValue();
        if (r != null && classMapping != null) {
            PropertyMapping propertyMapping = classMapping.getPropertyMapping(propertyName);
            if (Lang.isNotEmpty(propertyMapping.getPropertyMappings())) {
                PropertyMapping pm = propertyMapping.getPropertyMappings().get(0);
                return (Tuple2<String, R>) Tuples.of(pm.getRepositoryFieldName(),
                        cn.featherfly.common.bean.BeanUtils.getProperty(r, pm.getPropertyName()));
            }
        }
        return Tuples.of(propertyName, r);
    }

    // ********************************************************************
    // property
    // ********************************************************************

    protected ClassMapping<?> classMapping;

    private String queryAlias;

    /**
     * 返回queryAlias
     *
     * @return queryAlias
     */
    public String getQueryAlias() {
        return queryAlias;
    }

    /**
     * 设置queryAlias
     *
     * @param queryAlias queryAlias
     */
    public void setQueryAlias(String queryAlias) {
        this.queryAlias = queryAlias;
    }
}
