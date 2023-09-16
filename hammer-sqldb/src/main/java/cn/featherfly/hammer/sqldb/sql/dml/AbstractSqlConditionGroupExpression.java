
package cn.featherfly.hammer.sqldb.sql.dml;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.db.SqlUtils;
import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.function.serializable.SerializableDateSupplier;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableLocalDateSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableNumberSupplier;
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.function.serializable.SerializableToDateFunction;
import cn.featherfly.common.function.serializable.SerializableToEnumFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToNumberFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LambdaUtils.SerializableSupplierLambdaInfo;
import cn.featherfly.common.lang.LambdaUtils.SerializedLambdaInfo;
import cn.featherfly.common.operator.ComparisonOperator;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.operator.LogicOperator;
import cn.featherfly.common.repository.Execution;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.ConditionGroupExpression;
import cn.featherfly.hammer.expression.ConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.condition.ParamedExpression;
import cn.featherfly.hammer.expression.condition.property.DatePropertyExpression;
import cn.featherfly.hammer.expression.condition.property.EnumPropertyExpression;
import cn.featherfly.hammer.expression.condition.property.NumberPropertyExpression;
import cn.featherfly.hammer.expression.condition.property.ObjectPropertyExpression;
import cn.featherfly.hammer.expression.condition.property.SimpleDatePropertyExpression;
import cn.featherfly.hammer.expression.condition.property.SimpleEnumPropertyExpression;
import cn.featherfly.hammer.expression.condition.property.SimpleNumberPropertyExpression;
import cn.featherfly.hammer.expression.condition.property.SimpleObjectPropertyExpression;
import cn.featherfly.hammer.expression.condition.property.SimpleStringPropertyExpression;
import cn.featherfly.hammer.expression.condition.property.StringPropertyExpression;
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
        L extends ConditionGroupLogicExpression<C, L>> extends AbstractSqlConditionExpression<C, L>
        implements ConditionGroupExpression<C, L>, ConditionGroupLogicExpression<C, L>, SqlBuilder, ParamedExpression {

    /** The sql page factory. */
    protected SqlPageFactory sqlPageFactory;

    /** The query alias. */
    private String queryAlias;

    /**
     * Instantiates a new abstract sql condition group expression.
     *
     * @param parent         parent group
     * @param dialect        dialect
     * @param sqlPageFactory the sql page factory
     * @param queryAlias     queryAlias
     * @param ignoreStrategy the ignore strategy
     */
    protected AbstractSqlConditionGroupExpression(L parent, Dialect dialect, SqlPageFactory sqlPageFactory,
            String queryAlias, Predicate<?> ignoreStrategy) {
        super(parent, dialect, ignoreStrategy);
        this.queryAlias = queryAlias;
        this.sqlPageFactory = sqlPageFactory;
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L eq(String name, Object value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, name, value,
    //                        ComparisonOperator.EQ, queryAlias, ignoreStrategy));
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
    public L eq(String name, Object value, MatchStrategy matchStrategy) {
        return eq(name, value, matchStrategy, (Predicate<Object>) ignoreStrategy);
        //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.EQ,
        //                matchStrategy, queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L eq(SerializableFunction<T, R> name, R value, MatchStrategy matchStrategy) {
        return eq(name, value, matchStrategy, (Predicate<R>) ignoreStrategy); //YUFEI_TEST 需要测试
        //        return eq(name, value, matchStrategy, (v) -> ((Predicate<Object>) ignoreStrategy).test(v));
        //        SerializedLambdaInfo lambdaInfo = LambdaUtils.getLambdaInfo(name);
        //        if (value == null) {
        //            return eq(lambdaInfo.getPropertyName(), value, matchStrategy);
        //        }
        //        List<Tuple2<String, Optional<R>>> tuples = supplier(lambdaInfo, value);
        //        L logic = null;
        //        C condition = (C) this;
        //        if (tuples.size() > 1) {
        //            condition = group();
        //        }
        //        for (Tuple2<String, Optional<R>> tuple : tuples) {
        //            if (logic != null) {
        //                condition = logic.and();
        //            }
        //            logic = condition.eq(tuple.get0(), tuple.get1().orElseGet(() -> null), matchStrategy);
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
    public <R> L eq(SerializableSupplier<R> property, MatchStrategy matchStrategy) {
        return eq(property, matchStrategy, (Predicate<R>) ignoreStrategy); //YUFEI_TEST 需要测试
        //        return eq(property, matchStrategy, (v) -> ((Predicate<Object>) ignoreStrategy).test(v));
        //        SerializableSupplierLambdaInfo<R> lambdaInfo = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        if (property.get() == null) {
        //            return eq(lambdaInfo.getSerializedLambdaInfo().getPropertyName(), property.get(), matchStrategy);
        //        }
        //        List<Tuple2<String, Optional<R>>> tuples = supplier(lambdaInfo);
        //        L logic = null;
        //        C condition = (C) this;
        //        if (tuples.size() > 1) {
        //            condition = group();
        //        }
        //        for (Tuple2<String, Optional<R>> tuple : tuples) {
        //            if (logic != null) {
        //                condition = logic.and();
        //            }
        //            logic = condition.eq(tuple.get0(), tuple.get1().orElseGet(() -> null), matchStrategy);
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
    public <R> L eq(String name, R value, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.EQ,
                matchStrategy, queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L eq(SerializableFunction<T, R> name, R value, MatchStrategy matchStrategy,
            Predicate<R> ignoreStrategy) {
        SerializedLambdaInfo lambdaInfo = LambdaUtils.getLambdaInfo(name);
        if (value == null) {
            return eq(lambdaInfo.getPropertyName(), value, matchStrategy, ignoreStrategy);
        }
        List<Tuple2<String, Optional<R>>> tuples = supplier(lambdaInfo, value);
        L logic = null;
        C condition = (C) this;
        if (tuples.size() > 1) {
            condition = group();
        }
        for (Tuple2<String, Optional<R>> tuple : tuples) {
            if (logic != null) {
                condition = logic.and();
            }
            logic = condition.eq(tuple.get0(), tuple.get1().orElseGet(() -> null), matchStrategy);
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
    public <R> L eq(SerializableSupplier<R> property, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy) {
        SerializableSupplierLambdaInfo<R> lambdaInfo = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        if (property.get() == null) {
            return eq(lambdaInfo.getSerializedLambdaInfo().getPropertyName(), property.get(), matchStrategy,
                    ignoreStrategy);
        }
        List<Tuple2<String, Optional<R>>> tuples = supplier(lambdaInfo);
        L logic = null;
        C condition = (C) this;
        if (tuples.size() > 1) {
            condition = group();
        }
        for (Tuple2<String, Optional<R>> tuple : tuples) {
            if (logic != null) {
                condition = logic.and();
            }
            logic = condition.eq(tuple.get0(), tuple.get1().orElseGet(() -> null), matchStrategy);
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
    //                new SqlConditionExpressionBuilder(dialect, name, value,
    //                        ComparisonOperator.NE, queryAlias, ignoreStrategy));
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
    public L ne(String name, Object value, MatchStrategy matchStrategy) {
        return ne(name, value, matchStrategy, (Predicate<Object>) ignoreStrategy);
        //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.NE,
        //                matchStrategy, queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L ne(SerializableFunction<T, R> name, R value, MatchStrategy matchStrategy) {
        return ne(name, value, matchStrategy, (Predicate<R>) ignoreStrategy); //YUFEI_TEST 需要测试
        //        return ne(name, value, matchStrategy, (v) -> ((Predicate<Object>) ignoreStrategy).test(v));
        //        SerializedLambdaInfo lambdaInfo = LambdaUtils.getLambdaInfo(name);
        //        if (value == null) {
        //            return ne(lambdaInfo.getPropertyName(), value, matchStrategy);
        //        }
        //        List<Tuple2<String, Optional<R>>> tuples = supplier(lambdaInfo, value);
        //        L l = null;
        //        C c = (C) this;
        //        if (tuples.size() > 1) {
        //            c = group();
        //        }
        //        for (Tuple2<String, Optional<R>> tuple : tuples) {
        //            if (l != null) {
        //                c = l.and();
        //            }
        //            l = c.ne(tuple.get0(), tuple.get1().orElseGet(() -> null), matchStrategy);
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
    public <R> L ne(SerializableSupplier<R> property, MatchStrategy matchStrategy) {
        return eq(property, matchStrategy, (Predicate<R>) ignoreStrategy); //YUFEI_TEST 需要测试
        //        return eq(property, matchStrategy, (v) -> ((Predicate<Object>) ignoreStrategy).test(v));
        //        SerializableSupplierLambdaInfo<R> lambdaInfo = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        if (property.get() == null) {
        //            return ne(lambdaInfo.getSerializedLambdaInfo().getPropertyName(), property.get(), matchStrategy);
        //        }
        //        List<Tuple2<String, Optional<R>>> tuples = supplier(lambdaInfo);
        //        L l = null;
        //        C c = (C) this;
        //        if (tuples.size() > 1) {
        //            c = group();
        //        }
        //        for (Tuple2<String, Optional<R>> tuple : tuples) {
        //            if (l != null) {
        //                c = l.and();
        //            }
        //            l = c.ne(tuple.get0(), tuple.get1().orElseGet(() -> null), matchStrategy);
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
    public <R> L ne(String name, R value, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.NE,
                matchStrategy, queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L ne(SerializableFunction<T, R> name, R value, MatchStrategy matchStrategy,
            Predicate<R> ignoreStrategy) {
        SerializedLambdaInfo lambdaInfo = LambdaUtils.getLambdaInfo(name);
        if (value == null) {
            return ne(lambdaInfo.getPropertyName(), value, matchStrategy, ignoreStrategy);
        }
        List<Tuple2<String, Optional<R>>> tuples = supplier(lambdaInfo, value);
        L l = null;
        C c = (C) this;
        if (tuples.size() > 1) {
            c = group();
        }
        for (Tuple2<String, Optional<R>> tuple : tuples) {
            if (l != null) {
                c = l.and();
            }
            l = c.ne(tuple.get0(), tuple.get1().orElseGet(() -> null), matchStrategy);
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
    public <R> L ne(SerializableSupplier<R> property, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy) {
        SerializableSupplierLambdaInfo<R> lambdaInfo = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        if (property.get() == null) {
            return ne(lambdaInfo.getSerializedLambdaInfo().getPropertyName(), property.get(), matchStrategy,
                    ignoreStrategy);
        }
        List<Tuple2<String, Optional<R>>> tuples = supplier(lambdaInfo);
        L l = null;
        C c = (C) this;
        if (tuples.size() > 1) {
            c = group();
        }
        for (Tuple2<String, Optional<R>> tuple : tuples) {
            if (l != null) {
                c = l.and();
            }
            l = c.ne(tuple.get0(), tuple.get1().orElseGet(() -> null), matchStrategy);
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
    //                new SqlConditionExpressionBuilder(dialect, name, value,
    //                        ComparisonOperator.LK, queryAlias, ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L lk(SerializableToStringFunction<T> name, String value) {
    //        return lk(getPropertyName(name), value);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L lk(SerializableStringSupplier property) {
    //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //        return lk(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(String name, String value, MatchStrategy matchStrategy) {
        return lk(name, value, matchStrategy, (Predicate<String>) ignoreStrategy);
        //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LK,
        //                matchStrategy, queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L lk(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy) {
        return lk(name, value, matchStrategy, (Predicate<String>) ignoreStrategy);
        //        return lk(getPropertyName(name), value, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return lk(property, matchStrategy, (Predicate<String>) ignoreStrategy);
        //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        return lk(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LK,
                matchStrategy, queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LK,
                matchStrategy, queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L lk(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {
        return lk(getPropertyName(name), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L lk(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return lk(getPropertyName(name), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(SerializableStringSupplier property, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return lk(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return lk(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), matchStrategy, ignoreStrategy);
    }

    //  /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L sw(String name, String value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, name, value,
    //                        ComparisonOperator.SW, queryAlias, ignoreStrategy));
    //    }
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L sw(SerializableToStringFunction<T> name, String value) {
    //        return sw(getPropertyName(name), value);
    //    }
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L sw(SerializableStringSupplier property) {
    //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //        return sw(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(String name, String value, MatchStrategy matchStrategy) {
        return sw(name, value, matchStrategy, (Predicate<String>) ignoreStrategy);
        //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.SW,
        //                matchStrategy, queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L sw(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy) {
        return sw(name, value, matchStrategy, (Predicate<String>) ignoreStrategy);
        //        return sw(getPropertyName(name), value, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return sw(property, matchStrategy, (Predicate<String>) ignoreStrategy);
        //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        return sw(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.SW,
                matchStrategy, queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.SW,
                matchStrategy, queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L sw(SerializableToStringFunction<T> propertyName, String value, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {
        return sw(getPropertyName(propertyName), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L sw(SerializableToStringFunction<T> propertyName, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return sw(getPropertyName(propertyName), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(propertyValue);
        return sw(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(propertyValue);
        return sw(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), matchStrategy, ignoreStrategy);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L ew(String name, String value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, name, value,
    //                        ComparisonOperator.EW, queryAlias, ignoreStrategy));
    //    }
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L ew(SerializableToStringFunction<T> name, String value) {
    //        return ew(getPropertyName(name), value);
    //    }
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L ew(SerializableStringSupplier property) {
    //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //        return co(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String name, String value, MatchStrategy matchStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.EW,
                matchStrategy, queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ew(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy) {
        return ew(getPropertyName(name), value, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ew(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.EW,
                matchStrategy, queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.EW,
                matchStrategy, queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ew(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {
        return ew(getPropertyName(name), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ew(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return ew(getPropertyName(name), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(propertyValue);
        return ew(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(propertyValue);
        return ew(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), matchStrategy, ignoreStrategy);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L co(String name, String value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, name, value,
    //                        ComparisonOperator.CO, queryAlias, ignoreStrategy));
    //    }
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L co(SerializableToStringFunction<T> name, String value) {
    //        return co(getPropertyName(name), value);
    //    }
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L co(SerializableStringSupplier property) {
    //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //        return co(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String name, String value, MatchStrategy matchStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.CO,
                matchStrategy, queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L co(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy) {
        return co(getPropertyName(name), value, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return co(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.CO,
                matchStrategy, queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.CO,
                matchStrategy, queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L co(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {
        return co(getPropertyName(name), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L co(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return co(getPropertyName(name), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(propertyValue);
        return co(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(propertyValue);
        return co(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ge(String name, N value) {
        return ge(name, value, (Predicate<N>) ignoreStrategy);
        //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GE,
        //                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ge(String name, N value, IgnoreStrategy ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GE,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ge(String name, N value, Predicate<N> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GE,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> L ge(SerializableToNumberFunction<T, N> name, N value) {
        return ge(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> L ge(SerializableToNumberFunction<T, N> name, N value, IgnoreStrategy ignoreStrategy) {
        return ge(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> L ge(SerializableToNumberFunction<T, N> name, N value, Predicate<N> ignoreStrategy) {
        return ge(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ge(SerializableNumberSupplier<N> property) {
        return ge(property, (Predicate<N>) ignoreStrategy);
        //        SerializableSupplierLambdaInfo<N> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        return ge(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ge(SerializableNumberSupplier<N> property, IgnoreStrategy ignoreStrategy) {
        SerializableSupplierLambdaInfo<N> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ge(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ge(SerializableNumberSupplier<N> property, Predicate<N> ignoreStrategy) {
        SerializableSupplierLambdaInfo<N> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ge(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ge(String name, D value) {
        return ge(name, value, (Predicate<D>) ignoreStrategy);
        //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GE,
        //                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ge(String name, D value, IgnoreStrategy ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GE,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ge(String name, D value, Predicate<D> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GE,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> L ge(SerializableToDateFunction<T, D> name, D value) {
        return ge(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> L ge(SerializableToDateFunction<T, D> name, D value, IgnoreStrategy ignoreStrategy) {
        return ge(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> L ge(SerializableToDateFunction<T, D> name, D value, Predicate<D> ignoreStrategy) {
        return ge(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ge(SerializableDateSupplier<D> property) {
        return ge(property, (Predicate<D>) ignoreStrategy);
        //        SerializableSupplierLambdaInfo<D> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        return ge(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ge(SerializableDateSupplier<D> property, IgnoreStrategy ignoreStrategy) {
        SerializableSupplierLambdaInfo<D> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ge(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ge(SerializableDateSupplier<D> property, Predicate<D> ignoreStrategy) {
        SerializableSupplierLambdaInfo<D> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ge(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String name, LocalTime value) {
        return ge(name, value, (Predicate<LocalTime>) ignoreStrategy);
        //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GE,
        //                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String name, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GE,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GE,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ge(SerializableToLocalTimeFunction<T> name, LocalTime value) {
        return ge(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ge(SerializableToLocalTimeFunction<T> name, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return ge(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ge(SerializableToLocalTimeFunction<T> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ge(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableLocalTimeSupplier property) {
        return ge(property, (Predicate<LocalTime>) ignoreStrategy);
        //        SerializableSupplierLambdaInfo<LocalTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        return ge(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableLocalTimeSupplier property, IgnoreStrategy ignoreStrategy) {
        SerializableSupplierLambdaInfo<LocalTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ge(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        SerializableSupplierLambdaInfo<LocalTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ge(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String name, LocalDate value) {
        return ge(name, value, (Predicate<LocalDate>) ignoreStrategy);
        //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GE,
        //                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String name, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GE,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GE,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ge(SerializableToLocalDateFunction<T> name, LocalDate value) {
        return ge(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ge(SerializableToLocalDateFunction<T> name, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return ge(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ge(SerializableToLocalDateFunction<T> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ge(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableLocalDateSupplier property) {
        return ge(property, (Predicate<LocalDate>) ignoreStrategy);
        //        SerializableSupplierLambdaInfo<LocalDate> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        return ge(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableLocalDateSupplier property, IgnoreStrategy ignoreStrategy) {
        SerializableSupplierLambdaInfo<LocalDate> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ge(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        SerializableSupplierLambdaInfo<LocalDate> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ge(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String name, LocalDateTime value) {
        return ge(name, value, (Predicate<LocalDateTime>) ignoreStrategy);
        //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GE,
        //                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String name, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GE,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GE,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ge(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value) {
        return ge(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ge(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return ge(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ge(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return ge(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableLocalDateTimeSupplier property) {
        return ge(property, (Predicate<LocalDateTime>) ignoreStrategy);
        //        SerializableSupplierLambdaInfo<LocalDateTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        return ge(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableLocalDateTimeSupplier property, IgnoreStrategy ignoreStrategy) {
        SerializableSupplierLambdaInfo<LocalDateTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ge(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        SerializableSupplierLambdaInfo<LocalDateTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ge(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String name, String value) {
        return ge(name, value, (Predicate<String>) ignoreStrategy);
        //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GE,
        //                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String name, String value, IgnoreStrategy ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GE,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String name, String value, IgnoreStrategy ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GE,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String name, String value, Predicate<String> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GE,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ge(SerializableToStringFunction<T> name, String value) {
        return ge(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L gt(SerializableToStringFunction<T> name, String value, IgnoreStrategy ignoreStrategy) {
        return ge(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ge(SerializableToStringFunction<T> name, String value, IgnoreStrategy ignoreStrategy) {
        return ge(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ge(SerializableToStringFunction<T> name, String value, Predicate<String> ignoreStrategy) {
        return ge(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableStringSupplier property) {
        return ge(property, (Predicate<String>) ignoreStrategy);
        //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        return ge(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableStringSupplier property, IgnoreStrategy ignoreStrategy) {
        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ge(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableStringSupplier property, IgnoreStrategy ignoreStrategy) {
        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ge(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ge(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L gt(String name, N value) {
        return gt(name, value, (Predicate<N>) ignoreStrategy);
        //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GT,
        //                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L gt(String name, N value, IgnoreStrategy ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GT,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L gt(String name, N value, Predicate<N> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GT,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> L gt(SerializableToNumberFunction<T, N> name, N value) {
        return gt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> L gt(SerializableToNumberFunction<T, N> name, N value, IgnoreStrategy ignoreStrategy) {
        return gt(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> L gt(SerializableToNumberFunction<T, N> name, N value, Predicate<N> ignoreStrategy) {
        return gt(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L gt(SerializableNumberSupplier<N> property) {
        return gt(property, (Predicate<N>) ignoreStrategy);
        //        SerializableSupplierLambdaInfo<N> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        return gt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L gt(SerializableNumberSupplier<N> property, IgnoreStrategy ignoreStrategy) {
        SerializableSupplierLambdaInfo<N> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return gt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L gt(SerializableNumberSupplier<N> property, Predicate<N> ignoreStrategy) {
        SerializableSupplierLambdaInfo<N> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return gt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L gt(String name, D value) {
        return gt(name, value, (Predicate<D>) ignoreStrategy);
        //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GT,
        //                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L gt(String name, D value, IgnoreStrategy ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GT,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L gt(String name, D value, Predicate<D> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GT,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> L gt(SerializableToDateFunction<T, D> name, D value) {
        return gt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> L gt(SerializableToDateFunction<T, D> name, D value, IgnoreStrategy ignoreStrategy) {
        return gt(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> L gt(SerializableToDateFunction<T, D> name, D value, Predicate<D> ignoreStrategy) {
        return gt(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L gt(SerializableDateSupplier<D> property) {
        return gt(property, (Predicate<D>) ignoreStrategy);
        //        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        return gt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L gt(SerializableDateSupplier<D> property, IgnoreStrategy ignoreStrategy) {
        SerializableSupplierLambdaInfo<D> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return gt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L gt(SerializableDateSupplier<D> property, Predicate<D> ignoreStrategy) {
        SerializableSupplierLambdaInfo<D> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return gt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String name, LocalTime value) {
        return gt(name, value, (Predicate<LocalTime>) ignoreStrategy);
        //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GT,
        //                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String name, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GT,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GT,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L gt(SerializableToLocalTimeFunction<T> name, LocalTime value) {
        return gt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L gt(SerializableToLocalTimeFunction<T> name, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return gt(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L gt(SerializableToLocalTimeFunction<T> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return gt(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableLocalTimeSupplier property) {
        return gt(property, (Predicate<LocalTime>) ignoreStrategy);
        //        SerializableSupplierLambdaInfo<LocalTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        return gt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableLocalTimeSupplier property, IgnoreStrategy ignoreStrategy) {
        SerializableSupplierLambdaInfo<LocalTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return gt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        SerializableSupplierLambdaInfo<LocalTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return gt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String name, LocalDate value) {
        return gt(name, value, (Predicate<LocalDate>) ignoreStrategy);
        //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GT,
        //                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String name, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GT,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GT,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L gt(SerializableToLocalDateFunction<T> name, LocalDate value) {
        return gt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L gt(SerializableToLocalDateFunction<T> name, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return gt(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L gt(SerializableToLocalDateFunction<T> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return gt(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableLocalDateSupplier property) {
        return gt(property, (Predicate<LocalDate>) ignoreStrategy);
        //        SerializableSupplierLambdaInfo<LocalDate> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        return gt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableLocalDateSupplier property, IgnoreStrategy ignoreStrategy) {
        SerializableSupplierLambdaInfo<LocalDate> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return gt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        SerializableSupplierLambdaInfo<LocalDate> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return gt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String name, LocalDateTime value) {
        return gt(name, value, (Predicate<LocalDateTime>) ignoreStrategy);
        //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GT,
        //                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String name, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GT,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GT,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L gt(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value) {
        return gt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L gt(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return gt(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L gt(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return gt(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableLocalDateTimeSupplier property) {
        return gt(property, (Predicate<LocalDateTime>) ignoreStrategy);
        //        SerializableSupplierLambdaInfo<LocalDateTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        return gt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableLocalDateTimeSupplier property, IgnoreStrategy ignoreStrategy) {
        SerializableSupplierLambdaInfo<LocalDateTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return gt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        SerializableSupplierLambdaInfo<LocalDateTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return gt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String name, String value) {
        return gt(name, value, (Predicate<String>) ignoreStrategy);
        //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GT,
        //                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String name, String value, Predicate<String> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GT,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L gt(SerializableToStringFunction<T> name, String value) {
        return gt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L gt(SerializableToStringFunction<T> name, String value, Predicate<String> ignoreStrategy) {
        return gt(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableStringSupplier property) {
        return gt(property, (Predicate<String>) ignoreStrategy);
        //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        return gt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return gt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String name, Object value) {
        return in(name, value, (Predicate<Object>) ignoreStrategy);
        //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.IN,
        //                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in(SerializableSupplier<R> property) {
        return in(property, (Predicate<R>) ignoreStrategy);
        //        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        return in(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L in(SerializableFunction<T, R> name, Object value) {
        return in(name, value, (Predicate<Object>) ignoreStrategy);
        //        return in(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String name, Object value, Predicate<Object> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.IN,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L in(SerializableFunction<T, R> name, Object value, Predicate<Object> ignoreStrategy) {
        return in(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return in(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(),
                (Predicate<Object>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L inn(String name, Boolean value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.INN,
                queryAlias, ignoreStrategy));
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
    public L isn(String name, Boolean value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.ISN,
                queryAlias, ignoreStrategy));
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
    public <N extends Number> L le(String name, N value) {
        return le(name, value, (Predicate<N>) ignoreStrategy);
        //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LE,
        //                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L le(String name, N value, IgnoreStrategy ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LE,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L le(String name, N value, Predicate<N> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LE,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> L le(SerializableToNumberFunction<T, N> name, N value) {
        return le(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> L le(SerializableToNumberFunction<T, N> name, N value, IgnoreStrategy ignoreStrategy) {
        return le(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> L le(SerializableToNumberFunction<T, N> name, N value, Predicate<N> ignoreStrategy) {
        return le(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L le(SerializableNumberSupplier<N> property) {
        return le(property, (Predicate<N>) property);
        //        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        return le(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L le(SerializableNumberSupplier<N> propertyValue, IgnoreStrategy ignoreStrategy) {
        SerializableSupplierLambdaInfo<N> info = LambdaUtils.getSerializableSupplierLambdaInfo(propertyValue);
        return le(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L le(SerializableNumberSupplier<N> propertyValue, Predicate<N> ignoreStrategy) {
        SerializableSupplierLambdaInfo<N> info = LambdaUtils.getSerializableSupplierLambdaInfo(propertyValue);
        return le(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L le(String name, D value) {
        return le(name, value, (Predicate<D>) ignoreStrategy);
        //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LE,
        //                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L le(String name, D value, IgnoreStrategy ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LE,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L le(String name, D value, Predicate<D> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LE,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> L le(SerializableToDateFunction<T, D> name, D value) {
        return le(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> L le(SerializableToDateFunction<T, D> name, D value, IgnoreStrategy ignoreStrategy) {
        return le(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> L le(SerializableToDateFunction<T, D> name, D value, Predicate<D> ignoreStrategy) {
        return le(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L le(SerializableDateSupplier<D> property) {
        return le(property, (Predicate<D>) ignoreStrategy);
        //        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        return le(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L le(SerializableDateSupplier<D> propertyValue, IgnoreStrategy ignoreStrategy) {
        SerializableSupplierLambdaInfo<D> info = LambdaUtils.getSerializableSupplierLambdaInfo(propertyValue);
        return le(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L le(SerializableDateSupplier<D> propertyValue, Predicate<D> ignoreStrategy) {
        SerializableSupplierLambdaInfo<D> info = LambdaUtils.getSerializableSupplierLambdaInfo(propertyValue);
        return le(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, LocalTime value) {
        return le(name, value, (Predicate<LocalTime>) ignoreStrategy);
        //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LE,
        //                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LE,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LE,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L le(SerializableToLocalTimeFunction<T> name, LocalTime value) {
        return le(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L le(SerializableToLocalTimeFunction<T> name, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return le(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L le(SerializableToLocalTimeFunction<T> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return le(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableLocalTimeSupplier property) {
        return le(property, (Predicate<LocalTime>) ignoreStrategy);
        //        SerializableSupplierLambdaInfo<LocalTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        return le(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableLocalTimeSupplier propertyValue, IgnoreStrategy ignoreStrategy) {
        SerializableSupplierLambdaInfo<LocalTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(propertyValue);
        return le(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableLocalTimeSupplier propertyValue, Predicate<LocalTime> ignoreStrategy) {
        SerializableSupplierLambdaInfo<LocalTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(propertyValue);
        return le(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, LocalDate value) {
        return le(name, value, (Predicate<LocalDate>) ignoreStrategy);
        //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LE,
        //                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LE,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LE,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L le(SerializableToLocalDateFunction<T> name, LocalDate value) {
        return le(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L le(SerializableToLocalDateFunction<T> name, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return le(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L le(SerializableToLocalDateFunction<T> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return le(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableLocalDateSupplier property) {
        return le(property, (Predicate<LocalDate>) ignoreStrategy);
        //        SerializableSupplierLambdaInfo<LocalDate> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        return le(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableLocalDateSupplier propertyValue, IgnoreStrategy ignoreStrategy) {
        SerializableSupplierLambdaInfo<LocalDate> info = LambdaUtils.getSerializableSupplierLambdaInfo(propertyValue);
        return le(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableLocalDateSupplier propertyValue, Predicate<LocalDate> ignoreStrategy) {
        SerializableSupplierLambdaInfo<LocalDate> info = LambdaUtils.getSerializableSupplierLambdaInfo(propertyValue);
        return le(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, LocalDateTime value) {
        return le(name, value, (Predicate<LocalDateTime>) ignoreStrategy);
        //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LE,
        //                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LE,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LE,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L le(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value) {
        return le(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L le(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return le(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L le(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return le(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableLocalDateTimeSupplier property) {
        return le(property, (Predicate<LocalDateTime>) ignoreStrategy);
        //        SerializableSupplierLambdaInfo<LocalDateTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        return le(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableLocalDateTimeSupplier propertyValue, IgnoreStrategy ignoreStrategy) {
        SerializableSupplierLambdaInfo<LocalDateTime> info = LambdaUtils
                .getSerializableSupplierLambdaInfo(propertyValue);
        return le(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableLocalDateTimeSupplier propertyValue, Predicate<LocalDateTime> ignoreStrategy) {
        SerializableSupplierLambdaInfo<LocalDateTime> info = LambdaUtils
                .getSerializableSupplierLambdaInfo(propertyValue);
        return le(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, String value) {
        return le(name, value, (Predicate<String>) ignoreStrategy);
        //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LE,
        //                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, String value, IgnoreStrategy ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LE,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, String value, Predicate<String> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LE,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L le(SerializableToStringFunction<T> name, String value) {
        return le(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L le(SerializableToStringFunction<T> name, String value, IgnoreStrategy ignoreStrategy) {
        return le(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L le(SerializableToStringFunction<T> name, String value, Predicate<String> ignoreStrategy) {
        return le(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableStringSupplier property) {
        return le(property, (Predicate<String>) ignoreStrategy);
        //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        return le(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableStringSupplier propertyValue, IgnoreStrategy ignoreStrategy) {
        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(propertyValue);
        return le(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableStringSupplier propertyValue, Predicate<String> ignoreStrategy) {
        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(propertyValue);
        return le(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L lt(String name, N value) {
        return lt(name, value, (Predicate<N>) ignoreStrategy);
        //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LT,
        //                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L lt(String name, N value, IgnoreStrategy ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LT,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L lt(String name, N value, Predicate<N> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LT,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> L lt(SerializableToNumberFunction<T, N> name, N value) {
        return lt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> L lt(SerializableToNumberFunction<T, N> name, N value, IgnoreStrategy ignoreStrategy) {
        return lt(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> L lt(SerializableToNumberFunction<T, N> name, N value, Predicate<N> ignoreStrategy) {
        return lt(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L lt(SerializableNumberSupplier<N> property) {
        return lt(property, (Predicate<N>) ignoreStrategy);
        //        SerializableSupplierLambdaInfo<N> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        return lt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L lt(SerializableNumberSupplier<N> property, IgnoreStrategy ignoreStrategy) {
        SerializableSupplierLambdaInfo<N> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return lt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L lt(SerializableNumberSupplier<N> property, Predicate<N> ignoreStrategy) {
        SerializableSupplierLambdaInfo<N> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return lt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L lt(String name, D value) {
        return lt(name, value, (Predicate<D>) ignoreStrategy);
        //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LT,
        //                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L lt(String name, D value, IgnoreStrategy ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LT,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L lt(String name, D value, Predicate<D> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LT,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> L lt(SerializableToDateFunction<T, D> name, D value) {
        return lt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> L lt(SerializableToDateFunction<T, D> name, D value, IgnoreStrategy ignoreStrategy) {
        return lt(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> L lt(SerializableToDateFunction<T, D> name, D value, Predicate<D> ignoreStrategy) {
        return lt(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L lt(SerializableDateSupplier<D> property) {
        return lt(property, (Predicate<D>) ignoreStrategy);
        //        SerializableSupplierLambdaInfo<D> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        return lt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L lt(SerializableDateSupplier<D> property, IgnoreStrategy ignoreStrategy) {
        SerializableSupplierLambdaInfo<D> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return lt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L lt(SerializableDateSupplier<D> property, Predicate<D> ignoreStrategy) {
        SerializableSupplierLambdaInfo<D> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return lt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String name, LocalTime value) {
        return lt(name, value, (Predicate<LocalTime>) ignoreStrategy);
        //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LT,
        //                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String name, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LT,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LT,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L lt(SerializableToLocalTimeFunction<T> name, LocalTime value) {
        return lt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L lt(SerializableToLocalTimeFunction<T> name, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return lt(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L lt(SerializableToLocalTimeFunction<T> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return lt(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableLocalTimeSupplier property) {
        return lt(property, (Predicate<LocalTime>) ignoreStrategy);
        //        SerializableSupplierLambdaInfo<LocalTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        return lt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableLocalTimeSupplier property, IgnoreStrategy ignoreStrategy) {
        SerializableSupplierLambdaInfo<LocalTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return lt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        SerializableSupplierLambdaInfo<LocalTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return lt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String name, LocalDate value) {
        return lt(name, value, (Predicate<LocalDate>) ignoreStrategy);
        //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LT,
        //                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String name, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LT,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LT,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L lt(SerializableToLocalDateFunction<T> name, LocalDate value) {
        return lt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L lt(SerializableToLocalDateFunction<T> name, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return lt(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L lt(SerializableToLocalDateFunction<T> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return lt(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableLocalDateSupplier property) {
        return lt(property, (Predicate<LocalDate>) ignoreStrategy);
        //        SerializableSupplierLambdaInfo<LocalDate> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        return lt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableLocalDateSupplier property, IgnoreStrategy ignoreStrategy) {
        SerializableSupplierLambdaInfo<LocalDate> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return lt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        SerializableSupplierLambdaInfo<LocalDate> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return lt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String name, LocalDateTime value) {
        return lt(name, value, (Predicate<LocalDateTime>) ignoreStrategy);
        //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LT,
        //                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String name, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LT,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LT,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L lt(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value) {
        return lt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L lt(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return lt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L lt(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return lt(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableLocalDateTimeSupplier property) {
        return lt(property, (Predicate<LocalDateTime>) ignoreStrategy);
        //        SerializableSupplierLambdaInfo<LocalDateTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        return lt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableLocalDateTimeSupplier property, IgnoreStrategy ignoreStrategy) {
        SerializableSupplierLambdaInfo<LocalDateTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return lt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        SerializableSupplierLambdaInfo<LocalDateTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return lt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String name, String value) {
        return lt(name, value, (Predicate<String>) ignoreStrategy);
        //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LT,
        //                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String name, String value, IgnoreStrategy ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LT,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String name, String value, Predicate<String> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LT,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L lt(SerializableToStringFunction<T> name, String value) {
        return lt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L lt(SerializableToStringFunction<T> name, String value, IgnoreStrategy ignoreStrategy) {
        return lt(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L lt(SerializableToStringFunction<T> name, String value, Predicate<String> ignoreStrategy) {
        return lt(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableStringSupplier property) {
        return lt(property, (Predicate<String>) ignoreStrategy);
        //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        return lt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableStringSupplier property, IgnoreStrategy ignoreStrategy) {
        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return lt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return lt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(String name, Object value) {
        return nin(name, value, (Predicate<Object>) ignoreStrategy);
        //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.NIN,
        //                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(String name, Object value, Predicate<Object> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.NIN,
                queryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L nin(SerializableFunction<T, R> name, Object value) {
        return nin(name, value, (Predicate<Object>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L nin(SerializableFunction<T, R> name, Object value, Predicate<Object> ignoreStrategy) {
        return nin(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin(SerializableSupplier<R> property) {
        return nin(property, (Predicate<R>) ignoreStrategy);
        //        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        return nin(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return nin(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(),
                (Predicate<Object>) ignoreStrategy);
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

    // ********************************************************************
    //
    // ********************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public C group() {
        C group = createGroup((L) this, queryAlias);
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
     * @param parent          the parent
     * @param queryAlias      the query alias
     * @param typeQueryEntity the type query entity
     * @return the c
     */
    protected abstract C createGroup(L parent, String queryAlias);

    /**
     * Gets the root.
     *
     * @return the root
     */
    protected AbstractSqlConditionGroupExpression<C, L> getRoot() {
        L p = endGroup();
        //        L p2 = p.endGroup();
        //        while (p != p2) {
        while (p != p.endGroup()) {
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

    // ********************************************************************
    //	property
    // ********************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public ObjectPropertyExpression<C, L> property(String name) {
        return new SimpleObjectPropertyExpression<>(name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StringPropertyExpression<C, L> propertyString(String name) {
        return new SimpleStringPropertyExpression<>(name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> NumberPropertyExpression<N, C, L> propertyNumber(String name) {
        return new SimpleNumberPropertyExpression<>(name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> DatePropertyExpression<D, C, L> propertyDate(String name) {
        return new SimpleDatePropertyExpression<>(name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> EnumPropertyExpression<E, C, L> propertyEnum(String name) {
        return new SimpleEnumPropertyExpression<>(name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> ObjectPropertyExpression<C, L> property(SerializableFunction<T, R> name) {
        return property(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> StringPropertyExpression<C, L> property(SerializableToStringFunction<T> name) {
        return propertyString(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R extends Number> NumberPropertyExpression<R, C, L> property(SerializableToNumberFunction<T, R> name) {
        return new SimpleNumberPropertyExpression<>(getPropertyName(name), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R extends Date> DatePropertyExpression<R, C, L> property(SerializableToDateFunction<T, R> name) {
        return new SimpleDatePropertyExpression<>(getPropertyName(name), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R extends Enum<R>> EnumPropertyExpression<R, C, L> property(SerializableToEnumFunction<T, R> name) {
        return propertyEnum(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public C setIgnoreStrategy(Predicate<?> ignoreStrategy) {
        AssertIllegalArgument.isNotNull(ignoreStrategy, "ignoreStrategy");
        this.ignoreStrategy = ignoreStrategy;
        return (C) this;
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
        List<Tuple2<String, Optional<R>>> list = new ArrayList<>();
        if (value != null) {
            String propertyName = info.getPropertyName();
            list.add(Tuples.of(propertyName, Optional.of(value)));
        }
        return list;
    }

    /**
     * Supplier.
     *
     * @param <R>  the generic type
     * @param info the info
     * @return the list
     */
    protected <R> List<Tuple2<String, Optional<R>>> supplier(SerializableSupplierLambdaInfo<R> info) {
        return supplier(info.getSerializedLambdaInfo(), info.get());
    }

    // ********************************************************************
    // property
    // ********************************************************************

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
