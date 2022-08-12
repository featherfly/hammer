
package cn.featherfly.hammer.sqldb.sql.dml;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.db.SqlUtils;
import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.db.mapping.ClassMappingUtils;
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
import cn.featherfly.common.lang.function.StringSupplier;
import cn.featherfly.common.repository.Execution;
import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.common.repository.operate.LogicOperator;
import cn.featherfly.common.repository.operate.QueryOperator;
import cn.featherfly.common.repository.operate.QueryOperator.QueryPolicy;
import cn.featherfly.hammer.dsl.query.TypeQueryEntity;
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
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * sql condition group builder sql条件逻辑组构造器 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
@SuppressWarnings("unchecked")
public abstract class AbstractSqlConditionGroupExpression<C extends ConditionGroupExpression<C, L>,
        L extends ConditionGroupLogicExpression<C, L>> extends AbstractSqlConditionExpression<L>
        implements ConditionGroupExpression<C, L>, ConditionGroupLogicExpression<C, L>, SqlBuilder, ParamedExpression {

    /** The type query entity. */
    protected TypeQueryEntity typeQueryEntity;

    /** The sql page factory. */
    protected SqlPageFactory sqlPageFactory;

    /**
     * Instantiates a new abstract sql condition group expression.
     *
     * @param dialect         dialect
     * @param ignorePolicy    the ignore policy
     * @param sqlPageFactory  the sql page factory
     * @param typeQueryEntity the type query entity
     */
    public AbstractSqlConditionGroupExpression(Dialect dialect, SqlPageFactory sqlPageFactory,
            TypeQueryEntity typeQueryEntity, Predicate<Object> ignorePolicy) {
        this(dialect, sqlPageFactory, null, typeQueryEntity, ignorePolicy);
    }

    /**
     * Instantiates a new abstract sql condition group expression.
     *
     * @param dialect         dialect
     * @param ignorePolicy    the ignore policy
     * @param sqlPageFactory  the sql page factory
     * @param queryAlias      queryAlias
     * @param typeQueryEntity the type query entity
     */
    public AbstractSqlConditionGroupExpression(Dialect dialect, SqlPageFactory sqlPageFactory, String queryAlias,
            TypeQueryEntity typeQueryEntity, Predicate<Object> ignorePolicy) {
        this(dialect, sqlPageFactory, queryAlias, null, typeQueryEntity, ignorePolicy);
    }

    /**
     * Instantiates a new abstract sql condition group expression.
     *
     * @param dialect         dialect
     * @param ignorePolicy    the ignore policy
     * @param sqlPageFactory  the sql page factory
     * @param queryAlias      queryAlias
     * @param classMapping    classMapping
     * @param typeQueryEntity the type query entity
     */
    public AbstractSqlConditionGroupExpression(Dialect dialect, SqlPageFactory sqlPageFactory, String queryAlias,
            ClassMapping<?> classMapping, TypeQueryEntity typeQueryEntity, Predicate<Object> ignorePolicy) {
        this(null, dialect, sqlPageFactory, queryAlias, classMapping, typeQueryEntity, ignorePolicy);
    }

    /**
     * Instantiates a new abstract sql condition group expression.
     *
     * @param parent          parent group
     * @param dialect         dialect
     * @param ignorePolicy    the ignore policy
     * @param sqlPageFactory  the sql page factory
     * @param queryAlias      queryAlias
     * @param classMapping    classMapping
     * @param typeQueryEntity the type query entity
     */
    protected AbstractSqlConditionGroupExpression(L parent, Dialect dialect, SqlPageFactory sqlPageFactory,
            String queryAlias, ClassMapping<?> classMapping, TypeQueryEntity typeQueryEntity,
            Predicate<Object> ignorePolicy) {
        super(dialect, ignorePolicy, parent);
        this.queryAlias = queryAlias;
        this.sqlPageFactory = sqlPageFactory;
        this.classMapping = classMapping;
        this.typeQueryEntity = typeQueryEntity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return build();
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L eq(String name, Object value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.EQ, queryAlias, ignorePolicy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T, R> L eq(SerializableFunction<T, R> name, R value) {
    //        //        return eq(getPropertyName(name), value);
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
    //            logic = condition.eq(tuple.get0(), tuple.get1().orElseGet(() -> null));
    //        }
    //        if (tuples.size() > 1) {
    //            logic = logic.endGroup();
    //        }
    //        return logic;
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <R> L eq(SerializableSupplier<R> property) {
    //        //        Tuple2<String, R> tuple = supplier(LambdaUtils.getSerializableSupplierLambdaInfo(property));
    //        //        return eq(tuple.get0(), tuple.get1());
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
    //            logic = condition.eq(tuple.get0(), tuple.get1().orElseGet(() -> null));
    //        }
    //        if (tuples.size() > 1) {
    //            logic = logic.endGroup();
    //        }
    //        return logic;
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String name, Object value, QueryPolicy queryPolicy) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.EQ, queryPolicy, queryAlias, ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L eq(SerializableFunction<T, R> name, R value, QueryPolicy queryPolicy) {
        List<Tuple2<String, Optional<R>>> tuples = supplier(LambdaUtils.getLambdaInfo(name), value);
        L logic = null;
        C condition = (C) this;
        if (tuples.size() > 1) {
            condition = group();
        }
        for (Tuple2<String, Optional<R>> tuple : tuples) {
            if (logic != null) {
                condition = logic.and();
            }
            logic = condition.eq(tuple.get0(), tuple.get1().orElseGet(() -> null), queryPolicy);
        }
        if (tuples.size() > 1) {
            logic = logic.endGroup();
        }
        return logic;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L eq(SerializableSupplier<R> property, QueryPolicy queryPolicy) {
        List<Tuple2<String, Optional<R>>> tuples = supplier(LambdaUtils.getSerializableSupplierLambdaInfo(property));
        L logic = null;
        C condition = (C) this;
        if (tuples.size() > 1) {
            condition = group();
        }
        for (Tuple2<String, Optional<R>> tuple : tuples) {
            if (logic != null) {
                condition = logic.and();
            }
            logic = condition.eq(tuple.get0(), tuple.get1().orElseGet(() -> null), queryPolicy);
        }
        if (tuples.size() > 1) {
            logic = logic.endGroup();
        }
        return logic;
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
    //    public <T, R> L ne(SerializableFunction<T, R> name, R value) {
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

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String name, Object value, QueryPolicy queryPolicy) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.NE, queryPolicy, queryAlias, ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L ne(SerializableFunction<T, R> name, R value, QueryPolicy queryPolicy) {
        List<Tuple2<String, Optional<R>>> tuples = supplier(LambdaUtils.getLambdaInfo(name), value);
        L l = null;
        C c = (C) this;
        if (tuples.size() > 1) {
            c = group();
        }
        for (Tuple2<String, Optional<R>> tuple : tuples) {
            if (l != null) {
                c = l.and();
            }
            l = c.ne(tuple.get0(), tuple.get1().orElseGet(() -> null), queryPolicy);
        }
        if (tuples.size() > 1) {
            l = l.endGroup();
        }
        return l;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ne(SerializableSupplier<R> property, QueryPolicy queryPolicy) {
        List<Tuple2<String, Optional<R>>> tuples = supplier(LambdaUtils.getSerializableSupplierLambdaInfo(property));
        L l = null;
        C c = (C) this;
        if (tuples.size() > 1) {
            c = group();
        }
        for (Tuple2<String, Optional<R>> tuple : tuples) {
            if (l != null) {
                c = l.and();
            }
            l = c.ne(tuple.get0(), tuple.get1().orElseGet(() -> null), queryPolicy);
        }
        if (tuples.size() > 1) {
            l = l.endGroup();
        }
        return l;
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L lk(String name, String value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.LK, queryAlias, ignorePolicy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L lk(ReturnStringFunction<T> name, String value) {
    //        return lk(getPropertyName(name), value);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L lk(StringSupplier property) {
    //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //        return lk(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(String name, String value, QueryPolicy queryPolicy) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LK, queryPolicy, queryAlias, ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L lk(ReturnStringFunction<T> name, String value, QueryPolicy queryPolicy) {
        return lk(getPropertyName(name), value, queryPolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(StringSupplier property, QueryPolicy queryPolicy) {
        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return lk(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), queryPolicy);
    }

    //  /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L sw(String name, String value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.SW, queryAlias, ignorePolicy));
    //    }
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L sw(ReturnStringFunction<T> name, String value) {
    //        return sw(getPropertyName(name), value);
    //    }
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L sw(StringSupplier property) {
    //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //        return sw(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(String name, String value, QueryPolicy queryPolicy) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.SW, queryPolicy, queryAlias, ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L sw(ReturnStringFunction<T> name, String value, QueryPolicy queryPolicy) {
        return sw(getPropertyName(name), value, queryPolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(StringSupplier property, QueryPolicy queryPolicy) {
        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return sw(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L ew(String name, String value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.EW, queryAlias, ignorePolicy));
    //    }
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L ew(ReturnStringFunction<T> name, String value) {
    //        return ew(getPropertyName(name), value);
    //    }
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L ew(StringSupplier property) {
    //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //        return co(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String name, String value, QueryPolicy queryPolicy) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.EW, queryPolicy, queryAlias, ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ew(ReturnStringFunction<T> name, String value, QueryPolicy queryPolicy) {
        return ew(getPropertyName(name), value, queryPolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(StringSupplier property, QueryPolicy queryPolicy) {
        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return co(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), queryPolicy);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L co(String name, String value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        QueryOperator.CO, queryAlias, ignorePolicy));
    //    }
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L co(ReturnStringFunction<T> name, String value) {
    //        return co(getPropertyName(name), value);
    //    }
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L co(StringSupplier property) {
    //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //        return co(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String name, String value, QueryPolicy queryPolicy) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.CO, queryPolicy, queryAlias, ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L co(ReturnStringFunction<T> name, String value, QueryPolicy queryPolicy) {
        return co(getPropertyName(name), value, queryPolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(StringSupplier property, QueryPolicy queryPolicy) {
        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return co(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), queryPolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ge(String name, N value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GE, queryAlias, ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ge(String name, D value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GE, queryAlias, ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String name, LocalTime value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GE, queryAlias, ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String name, LocalDate value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GE, queryAlias, ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String name, LocalDateTime value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GE, queryAlias, ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String name, String value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GE, queryAlias, ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L gt(String name, N value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GT, queryAlias, ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L gt(String name, D value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GT, queryAlias, ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String name, LocalTime value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GT, queryAlias, ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String name, LocalDate value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GT, queryAlias, ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String name, LocalDateTime value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GT, queryAlias, ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String name, String value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GT, queryAlias, ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String name, Object value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.IN, queryAlias, ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L inn(String name) {
        return inn(name, true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L inn(String name, Boolean value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.INN, queryAlias, ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L isn(String name) {
        return isn(name, true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L isn(String name, Boolean value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.ISN, queryAlias, ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L le(String name, N value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LE, queryAlias, ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L le(String name, D value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LE, queryAlias, ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, LocalTime value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LE, queryAlias, ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, LocalDate value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LE, queryAlias, ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, LocalDateTime value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LE, queryAlias, ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, String value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LE, queryAlias, ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L lt(String name, N value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LT, queryAlias, ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L lt(String name, D value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LT, queryAlias, ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String name, LocalTime value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LT, queryAlias, ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String name, LocalDate value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LT, queryAlias, ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String name, LocalDateTime value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LT, queryAlias, ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String name, String value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LT, queryAlias, ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(String name, Object value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.NIN, queryAlias, ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public C group() {
        // SqlConditionGroupExpressionBuilder group = new
        // SqlConditionGroupExpressionBuilder(
        // jdbc, this, queryAlias);
        C group = createGroup((L) this, queryAlias, typeQueryEntity);
        addCondition(group);
        return group;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L group(Consumer<C> group) {
        group.accept(group());
        return endGroup();
    }

    /**
     * Creates the group.
     *
     * @param parent          the parent
     * @param queryAlias      the query alias
     * @param typeQueryEntity the type query entity
     * @return the c
     */
    protected abstract C createGroup(L parent, String queryAlias, TypeQueryEntity typeQueryEntity);

    /**
     * Gets the root.
     *
     * @return the root
     */
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
    public L and(Consumer<C> group) {
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
    public L or(Consumer<C> group) {
        return or().group(group);
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
    public <T, R> L inn(SerializableFunction<T, R> name, Boolean value) {
        return inn(getPropertyName(name), value);
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
    public <T, R> L isn(SerializableFunction<T, R> name, Boolean value) {
        return isn(getPropertyName(name), value);
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
    public <T, R> L nin(SerializableFunction<T, R> name, Object value) {
        return nin(getPropertyName(name), value);
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
    public <R> L nin(SerializableSupplier<R> property) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return nin(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L expression(String expression, final Map<String, Object> params) {
        final Execution execution = SqlUtils.convertNamedParamSql(expression, params);
        return expression(execution.getExecution(), execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L expression(String expression, Object... params) {
        return (L) addCondition(new ParamedExpression() {

            @Override
            public String expression() {
                return expression;
            }

            @Override
            public Object getParam() {
                return params;
            }
        });
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

    /**
     * Supplier.
     *
     * @param <R>  the generic type
     * @param info the info
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
    protected ClassMapping<?> classMapping;

    /** The query alias. */
    private String queryAlias;

    /**
     * 返回queryAlias.
     *
     * @return queryAlias
     */
    public String getQueryAlias() {
        return queryAlias;
    }

    /**
     * 设置queryAlias.
     *
     * @param queryAlias queryAlias
     */
    public void setQueryAlias(String queryAlias) {
        this.queryAlias = queryAlias;
    }
}
