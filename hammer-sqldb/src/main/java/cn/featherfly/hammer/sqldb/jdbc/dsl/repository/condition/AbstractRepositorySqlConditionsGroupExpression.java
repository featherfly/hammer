
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition;

import java.util.Date;

import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.hammer.config.dsl.ConditionConfig;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupExpression;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupLogicExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryDateFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryEnumFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryLocalDateFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryLocalDateTimeFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryLocalTimeFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryNumberFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositorySerializableFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryStringFieldExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.condition.AbstractSqlConditionsGroupExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.field.DateFieldExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.field.EnumFieldExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.field.LocalDateFieldExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.field.LocalDateTimeFieldExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.field.LocalTimeFieldExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.field.NumberFieldExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.field.SerializableFieldExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.field.StringFieldExpressionImpl;

/**
 * sql condition group builder sql条件逻辑组构造器 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractRepositorySqlConditionsGroupExpression<
    C extends RepositoryConditionsGroupExpression<C, L>, L extends RepositoryConditionsGroupLogicExpression<C, L>,
    C2 extends ConditionConfig<C2>> extends AbstractSqlConditionsGroupExpression<C, L, C2>
    implements RepositoryConditionsGroupExpression<C, L>, RepositoryConditionsGroupLogicExpression<C, L> {

    /** The alias manager. */
    protected AliasManager aliasManager;

    /**
     * Instantiates a new abstract repository sql condition group expression.
     *
     * @param parent          parent group
     * @param dialect         dialect
     * @param aliasManager    aliasManager
     * @param repositoryAlias queryAlias
     * @param conditionConfig the condition config
     */
    protected AbstractRepositorySqlConditionsGroupExpression(L parent, Dialect dialect, AliasManager aliasManager,
        String repositoryAlias, C2 conditionConfig) {
        super(parent, dialect, repositoryAlias, conditionConfig);
        this.aliasManager = aliasManager;
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T, R> L eq(SerializableFunction<T, R> name, R value, MatchStrategy matchStrategy) {
    //        return eq(name, value, matchStrategy, getIgnoreStrategy()::test); //YUFEI_TEST 需要测试
    //        //        return eq(name, value, matchStrategy, (v) -> ((Predicate<Object>) ignoreStrategy).test(v));
    //        //        SerializedLambdaInfo lambdaInfo = LambdaUtils.getLambdaInfo(name);
    //        //        if (value == null) {
    //        //            return eq(lambdaInfo.getPropertyName(), value, matchStrategy);
    //        //        }
    //        //        List<Tuple2<String, Optional<R>>> tuples = supplier(lambdaInfo, value);
    //        //        L logic = null;
    //        //        C condition = (C) this;
    //        //        if (tuples.size() > 1) {
    //        //            condition = group();
    //        //        }
    //        //        for (Tuple2<String, Optional<R>> tuple : tuples) {
    //        //            if (logic != null) {
    //        //                condition = logic.and();
    //        //            }
    //        //            logic = condition.eq(tuple.get0(), tuple.get1().orElseGet(() -> null), matchStrategy);
    //        //        }
    //        //        if (tuples.size() > 1) {
    //        //            logic = logic.endGroup();
    //        //        }
    //        //        return logic;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T, R> L eq(SerializableFunction<T, R> name, R value, MatchStrategy matchStrategy,
    //            Predicate<R> ignoreStrategy) {
    //        SerializedLambdaInfo lambdaInfo = LambdaUtils.getLambdaInfo(name);
    //        if (value == null) {
    //            return eq(lambdaInfo.getPropertyName(), value, matchStrategy, ignoreStrategy);
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
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T, R> L ne(SerializableFunction<T, R> name, R value, MatchStrategy matchStrategy) {
    //        return ne(name, value, matchStrategy, getIgnoreStrategy()::test); //YUFEI_TEST 需要测试
    //        //        return ne(name, value, matchStrategy, (v) -> ((Predicate<Object>) ignoreStrategy).test(v));
    //        //        SerializedLambdaInfo lambdaInfo = LambdaUtils.getLambdaInfo(name);
    //        //        if (value == null) {
    //        //            return ne(lambdaInfo.getPropertyName(), value, matchStrategy);
    //        //        }
    //        //        List<Tuple2<String, Optional<R>>> tuples = supplier(lambdaInfo, value);
    //        //        L l = null;
    //        //        C c = (C) this;
    //        //        if (tuples.size() > 1) {
    //        //            c = group();
    //        //        }
    //        //        for (Tuple2<String, Optional<R>> tuple : tuples) {
    //        //            if (l != null) {
    //        //                c = l.and();
    //        //            }
    //        //            l = c.ne(tuple.get0(), tuple.get1().orElseGet(() -> null), matchStrategy);
    //        //        }
    //        //        if (tuples.size() > 1) {
    //        //            l = l.endGroup();
    //        //        }
    //        //        return l;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T, R> L ne(SerializableFunction<T, R> name, R value, MatchStrategy matchStrategy,
    //            Predicate<R> ignoreStrategy) {
    //        SerializedLambdaInfo lambdaInfo = LambdaUtils.getLambdaInfo(name);
    //        if (value == null) {
    //            return ne(lambdaInfo.getPropertyName(), value, matchStrategy, ignoreStrategy);
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
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public C logic(LogicOperator operator) {
    //        AssertIllegalArgument.isNotNull(operator, "operator");
    //        return (C) addCondition(new SqlLogicOperatorExpressionBuilder(operator));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public C and() {
    //        return (C) addCondition(new SqlLogicOperatorExpressionBuilder(LogicOperator.AND));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L and(Function<C, L> group) {
    //        return and().group(group);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public C or() {
    //        return (C) addCondition(new SqlLogicOperatorExpressionBuilder(LogicOperator.OR));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L or(Function<C, L> group) {
    //        return or().group(group);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public C group() {
    //        C group = createGroup((L) this, queryAlias);
    //        addCondition(group);
    //        return group;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L group(Function<C, L> group) {
    //        return group.apply(group()).endGroup();
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
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
    //     * Creates the group.
    //     *
    //     * @param parent     the parent
    //     * @param queryAlias the query alias
    //     * @return the c
    //     */
    //    protected abstract C createGroup(L parent, String queryAlias);
    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T, R> L eq(SerializableFunction<T, R> name, R value) {
    //    //        return eq(getPropertyName(name), value);
    //    //    }
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public L eq(String name, Object value) {
    //    //        return (L) addCondition(
    //    //                new SqlConditionExpressionBuilder(dialect, name, value,
    //    //                        ComparisonOperator.EQ, queryAlias, ignoreStrategy));
    //    //    }
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <R> L eq(SerializableSupplier<R> property) {
    //    //        //        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //    //        //        return eq(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    //    //        //        Tuple2<String, R> tuple = supplier(LambdaUtils.getSerializableSupplierLambdaInfo(property));
    //    //        //        return eq(tuple.get0(), tuple.get1());
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
    //    @Override
    //    public L eq(String name, Object value, MatchStrategy matchStrategy) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.EQ,
    //                queryPolicy, queryAlias, ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T, R> L eq(SerializableFunction<T, R> name, R value, MatchStrategy matchStrategy) {
    //        // FIXME value 空指针异常
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
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <R> L eq(SerializableSupplier<R> property, MatchStrategy matchStrategy) {
    //        // FIXME value 空指针异常
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
    //            l = c.eq(tuple.get0(), tuple.get1().orElseGet(() -> null), queryPolicy);
    //        }
    //        if (tuples.size() > 1) {
    //            l = l.endGroup();
    //        }
    //        return l;
    //    }
    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public L eq(String repository, String name, Object value) {
    //    //        return (L) addCondition(
    //    //                new SqlConditionExpressionBuilder(dialect, name, value,
    //    //                        ComparisonOperator.EQ, aliasManager.getAlias(repository), ignoreStrategy));
    //    //    }
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T> L eq(Class<T> repository, String name, Object value) {
    //    //        return eq(getTableName(repository), name, value);
    //    //    }
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public L eq(int repositoryIndex, String name, Object value) {
    //    //        return (L) addCondition(
    //    //                new SqlConditionExpressionBuilder(dialect, name, value,
    //    //                        ComparisonOperator.EQ, aliasManager.getAlias(repositoryIndex), ignoreStrategy));
    //    //    }
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T, R> L eq(SerializableFunction<T, R> repository, SerializableFunction<T, R> property, R value) {
    //    //        return eq(getPropertyName(repository), getPropertyName(property), value);
    //    //    }
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T, R> L eq(SerializableSupplier<T> repository, SerializableFunction<T, R> property) {
    //    //        Tuple3<String, String, Object> tuple = conditionResult(repository, property);
    //    //        return eq(tuple.get0(), tuple.get1(), tuple.get2());
    //    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L eq(String repository, String name, Object value, MatchStrategy matchStrategy) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.EQ,
    //                queryPolicy, aliasManager.getAlias(repository), ignoreStrategy));
    //    }
    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T> L eq(Class<T> repository, String name, Object value, MatchStrategy matchStrategy) {
    //    //        return eq(getTableName(repository), name, value, queryPolicy);
    //    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L eq(int repositoryIndex, String name, Object value, MatchStrategy matchStrategy) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.EQ,
    //                queryPolicy, aliasManager.getAlias(repositoryIndex), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T, R> L eq(SerializableFunction<T, R> repository, SerializableFunction<T, R> property, R value,
    //            MatchStrategy matchStrategy) {
    //        return eq(getPropertyName(repository), getPropertyName(property), value, queryPolicy);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T, R> L eq(SerializableSupplier<T> repository, SerializableFunction<T, R> property,
    //            MatchStrategy matchStrategy) {
    //        Tuple3<String, String, Object> tuple = conditionResult(repository, property);
    //        return eq(tuple.get0(), tuple.get1(), tuple.get2(), queryPolicy);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L ne(String name, Object value, MatchStrategy matchStrategy) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.NE,
    //                queryPolicy, queryAlias, ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T, R> L ne(SerializableFunction<T, R> name, R value, MatchStrategy matchStrategy) {
    //        // FIXME value 空指针异常
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
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <R> L ne(SerializableSupplier<R> property, MatchStrategy matchStrategy) {
    //        // FIXME value 空指针异常
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
    //    }
    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T> L ne(Class<T> repository, String name, Object value) {
    //    //        return ne(getTableName(repository), name, value);
    //    //    }
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public L ne(int repositoryIndex, String name, Object value) {
    //    //        return (L) addCondition(
    //    //                new SqlConditionExpressionBuilder(dialect, name, value,
    //    //                        ComparisonOperator.NE, aliasManager.getAlias(repositoryIndex), ignoreStrategy));
    //    //    }
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public L ne(String repository, String name, Object value) {
    //    //        return (L) addCondition(
    //    //                new SqlConditionExpressionBuilder(dialect, name, value,
    //    //                        ComparisonOperator.NE, aliasManager.getAlias(repository), ignoreStrategy));
    //    //    }
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T, R> L ne(SerializableFunction<T, R> repository, SerializableFunction<T, R> property, R value) {
    //    //        return ne(getPropertyName(repository), getPropertyName(property), value);
    //    //    }
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T, R> L ne(SerializableSupplier<T> repository, SerializableFunction<T, R> property) {
    //    //        Tuple3<String, String, Object> tuple = conditionResult(repository, property);
    //    //        return ne(tuple.get0(), tuple.get1(), tuple.get2());
    //    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L ne(String repository, String name, Object value, MatchStrategy matchStrategy) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.NE,
    //                queryPolicy, aliasManager.getAlias(repository), ignoreStrategy));
    //    }
    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T> L ne(Class<T> repository, String name, Object value, MatchStrategy matchStrategy) {
    //    //        return ne(getTableName(repository), name, value, queryPolicy);
    //    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L ne(int repositoryIndex, String name, Object value, MatchStrategy matchStrategy) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.NE,
    //                queryPolicy, aliasManager.getAlias(repositoryIndex), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T, R> L ne(SerializableFunction<T, R> repository, SerializableFunction<T, R> property, R value,
    //            MatchStrategy matchStrategy) {
    //        return eq(getPropertyName(repository), getPropertyName(property), value, queryPolicy);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T, R> L ne(SerializableSupplier<T> repository, SerializableFunction<T, R> property,
    //            MatchStrategy matchStrategy) {
    //        Tuple3<String, String, Object> tuple = conditionResult(repository, property);
    //        return eq(tuple.get0(), tuple.get1(), tuple.get2(), queryPolicy);
    //    }
    //
    //    //  /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public L lk(String name, String value) {
    //    //        return (L) addCondition(
    //    //                new SqlConditionExpressionBuilder(dialect, name, value,
    //    //                        ComparisonOperator.LK, queryAlias, ignoreStrategy));
    //    //    }
    //    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T> L lk(SerializableToStringFunction<T> name, String value) {
    //    //        return lk(getPropertyName(name), value);
    //    //    }
    //    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public L lk(SerializableStringSupplier property) {
    //    //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //    //        return lk(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    //    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L lk(String name, String value, MatchStrategy matchStrategy) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LK,
    //                queryPolicy, queryAlias, ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L lk(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy) {
    //        return lk(getPropertyName(name), value, queryPolicy);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L lk(SerializableStringSupplier property, MatchStrategy matchStrategy) {
    //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //        return lk(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), queryPolicy);
    //    }
    //
    //    //     /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public L lk(String repository, String name, String value) {
    //    //        return (L) addCondition(
    //    //                new SqlConditionExpressionBuilder(dialect, name, value,
    //    //                        ComparisonOperator.LK, aliasManager.getAlias(repository), ignoreStrategy));
    //    //    }
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T> L lk(Class<T> repository, String name, String value) {
    //    //        return lk(getTableName(repository), name, value);
    //    //    }
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public L lk(int repositoryIndex, String name, String value) {
    //    //        return (L) addCondition(
    //    //                new SqlConditionExpressionBuilder(dialect, name, value,
    //    //                        ComparisonOperator.LK, aliasManager.getAlias(repositoryIndex), ignoreStrategy));
    //    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L lk(String repository, String name, String value, MatchStrategy matchStrategy) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LK,
    //                queryPolicy, aliasManager.getAlias(repository), ignoreStrategy));
    //    }
    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T> L lk(Class<T> repository, String name, String value, MatchStrategy matchStrategy) {
    //    //        return lk(getTableName(repository), name, value, queryPolicy);
    //    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L lk(int repositoryIndex, String name, String value, MatchStrategy matchStrategy) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LK,
    //                queryPolicy, aliasManager.getAlias(repositoryIndex), ignoreStrategy));
    //    }
    //
    //    //  /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public L sw(String name, String value) {
    //    //        return (L) addCondition(
    //    //                new SqlConditionExpressionBuilder(dialect, name, value,
    //    //                        ComparisonOperator.SW, queryAlias, ignoreStrategy));
    //    //    }
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T> L sw(SerializableToStringFunction<T> name, String value) {
    //    //        return sw(getPropertyName(name), value);
    //    //    }
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public L sw(SerializableStringSupplier property) {
    //    //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //    //        return sw(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    //    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L sw(String name, String value, MatchStrategy matchStrategy) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.SW,
    //                queryPolicy, queryAlias, ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L sw(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy) {
    //        return sw(getPropertyName(name), value, queryPolicy);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L sw(SerializableStringSupplier property, MatchStrategy matchStrategy) {
    //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //        return sw(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    //    }
    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T> L sw(Class<T> repository, String name, String value) {
    //    //        return sw(getTableName(repository), name, value);
    //    //    }
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public L sw(int repositoryIndex, String name, String value) {
    //    //        return (L) addCondition(
    //    //                new SqlConditionExpressionBuilder(dialect, name, value,
    //    //                        ComparisonOperator.SW, aliasManager.getAlias(repositoryIndex), ignoreStrategy));
    //    //    }
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public L sw(String repository, String name, String value) {
    //    //        return (L) addCondition(
    //    //                new SqlConditionExpressionBuilder(dialect, name, value,
    //    //                        ComparisonOperator.SW, aliasManager.getAlias(repository), ignoreStrategy));
    //    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L sw(String repository, String name, String value, MatchStrategy matchStrategy) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.SW,
    //                queryPolicy, aliasManager.getAlias(repository), ignoreStrategy));
    //    }
    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T> L sw(Class<T> repository, String name, String value, MatchStrategy matchStrategy) {
    //    //        return sw(getTableName(repository), name, value, queryPolicy);
    //    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L sw(int repositoryIndex, String name, String value, MatchStrategy matchStrategy) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.SW,
    //                queryPolicy, aliasManager.getAlias(repositoryIndex), ignoreStrategy));
    //    }
    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public L ew(String name, String value) {
    //    //        return (L) addCondition(
    //    //                new SqlConditionExpressionBuilder(dialect, name, value,
    //    //                        ComparisonOperator.EW, queryAlias, ignoreStrategy));
    //    //    }
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T> L ew(SerializableToStringFunction<T> name, String value) {
    //    //        return ew(getPropertyName(name), value);
    //    //    }
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public L ew(SerializableStringSupplier property) {
    //    //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //    //        return co(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    //    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L ew(String name, String value, MatchStrategy matchStrategy) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.EW,
    //                queryPolicy, queryAlias, ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L ew(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy) {
    //        return ew(getPropertyName(name), value, queryPolicy);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L ew(SerializableStringSupplier property, MatchStrategy matchStrategy) {
    //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //        return co(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), queryPolicy);
    //    }
    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T> L ew(Class<T> repository, String name, String value) {
    //    //        return ew(getTableName(repository), name, value);
    //    //    }
    //    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public L ew(int repositoryIndex, String name, String value) {
    //    //        return (L) addCondition(
    //    //                new SqlConditionExpressionBuilder(dialect, name, value,
    //    //                        ComparisonOperator.EW, aliasManager.getAlias(repositoryIndex), ignoreStrategy));
    //    //    }
    //    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public L ew(String repository, String name, String value) {
    //    //        return (L) addCondition(
    //    //                new SqlConditionExpressionBuilder(dialect, name, value,
    //    //                        ComparisonOperator.EW, aliasManager.getAlias(repository), ignoreStrategy));
    //    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L ew(String repository, String name, String value, MatchStrategy matchStrategy) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.EW,
    //                queryPolicy, aliasManager.getAlias(repository), ignoreStrategy));
    //    }
    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T> L ew(Class<T> repository, String name, String value, MatchStrategy matchStrategy) {
    //    //        return ew(getTableName(repository), name, value, queryPolicy);
    //    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L ew(int repositoryIndex, String name, String value, MatchStrategy matchStrategy) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.EW,
    //                queryPolicy, aliasManager.getAlias(repositoryIndex), ignoreStrategy));
    //    }
    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public L co(String name, String value) {
    //    //        return (L) addCondition(
    //    //                new SqlConditionExpressionBuilder(dialect, name, value,
    //    //                        ComparisonOperator.CO, queryAlias, ignoreStrategy));
    //    //    }
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T> L co(SerializableToStringFunction<T> name, String value) {
    //    //        return co(getPropertyName(name), value);
    //    //    }
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public L co(SerializableStringSupplier property) {
    //    //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //    //        return co(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    //    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L co(String name, String value, MatchStrategy matchStrategy) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.CO,
    //                queryPolicy, queryAlias, ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L co(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy) {
    //        return co(getPropertyName(name), value, queryPolicy);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L co(SerializableStringSupplier property, MatchStrategy matchStrategy) {
    //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //        return co(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), queryPolicy);
    //    }
    //
    //    //  /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T> L co(Class<T> repository, String name, String value) {
    //    //        return co(getTableName(repository), name, value);
    //    //    }
    //    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public L co(int repositoryIndex, String name, String value) {
    //    //        return (L) addCondition(
    //    //                new SqlConditionExpressionBuilder(dialect, name, value,
    //    //                        ComparisonOperator.CO, aliasManager.getAlias(repositoryIndex), ignoreStrategy));
    //    //    }
    //    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public L co(String repository, String name, String value) {
    //    //        return (L) addCondition(
    //    //                new SqlConditionExpressionBuilder(dialect, name, value,
    //    //                        ComparisonOperator.CO, queryAlias, ignoreStrategy));
    //    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L co(String repository, String name, String value, MatchStrategy matchStrategy) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.CO,
    //                queryPolicy, aliasManager.getAlias(repository), ignoreStrategy));
    //    }
    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T> L co(Class<T> repository, String name, String value, MatchStrategy matchStrategy) {
    //    //        return co(getTableName(repository), name, value, queryPolicy);
    //    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L co(int repositoryIndex, String name, String value, MatchStrategy matchStrategy) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.CO,
    //                queryPolicy, aliasManager.getAlias(repositoryIndex), ignoreStrategy));
    //    }
    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <D extends Date, T> L ge(Class<T> repository, String name, D value) {
    //    //        return ge(getTableName(repository), name, value);
    //    //    }
    //    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T> L ge(Class<T> repository, String name, LocalDate value) {
    //    //        return ge(getTableName(repository), name, value);
    //    //    }
    //    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T> L ge(Class<T> repository, String name, LocalDateTime value) {
    //    //        return ge(getTableName(repository), name, value);
    //    //    }
    //    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T> L ge(Class<T> repository, String name, LocalTime value) {
    //    //        return ge(getTableName(repository), name, value);
    //    //    }
    //    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <N extends Number, T> L ge(Class<T> repository, String name, N value) {
    //    //        return ge(getTableName(repository), name, value);
    //    //    }
    //    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T> L ge(Class<T> repository, String name, String value) {
    //    //        return ge(getTableName(repository), name, value);
    //    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <D extends Date> L ge(int repositoryIndex, String name, D value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GE,
    //                aliasManager.getAlias(repositoryIndex), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L ge(int repositoryIndex, String name, LocalDate value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GE,
    //                aliasManager.getAlias(repositoryIndex), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L ge(int repositoryIndex, String name, LocalDateTime value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GE,
    //                aliasManager.getAlias(repositoryIndex), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L ge(int repositoryIndex, String name, LocalTime value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GE,
    //                aliasManager.getAlias(repositoryIndex), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <N extends Number> L ge(int repositoryIndex, String name, N value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GE,
    //                aliasManager.getAlias(repositoryIndex), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L ge(int repositoryIndex, String name, String value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GE,
    //                aliasManager.getAlias(repositoryIndex), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T, D extends Date> L ge(SerializableToDateFunction<T, D> name, D value) {
    //        return ge(getPropertyName(name), value);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L ge(SerializableToLocalDateFunction<T> name, LocalDate value) {
    //        return ge(getPropertyName(name), value);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L ge(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value) {
    //        return ge(getPropertyName(name), value);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L ge(SerializableToLocalTimeFunction<T> name, LocalTime value) {
    //        return ge(getPropertyName(name), value);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T, N extends Number> L ge(SerializableToNumberFunction<T, N> name, N value) {
    //        return ge(getPropertyName(name), value);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L ge(SerializableToStringFunction<T> name, String value) {
    //        return ge(getPropertyName(name), value);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <D extends Date> L ge(String name, D value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GE,
    //                queryAlias, ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L ge(String name, LocalDate value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GE,
    //                queryAlias, ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L ge(String name, LocalDateTime value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GE,
    //                queryAlias, ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L ge(String name, LocalTime value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GE,
    //                queryAlias, ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <N extends Number> L ge(String name, N value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GE,
    //                queryAlias, ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L ge(String name, String value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GE,
    //                queryAlias, ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <D extends Date> L ge(String repository, String name, D value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GE,
    //                aliasManager.getAlias(repository), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L ge(String repository, String name, LocalDate value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GE,
    //                aliasManager.getAlias(repository), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L ge(String repository, String name, LocalDateTime value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GE,
    //                aliasManager.getAlias(repository), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L ge(String repository, String name, LocalTime value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GE,
    //                aliasManager.getAlias(repository), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <N extends Number> L ge(String repository, String name, N value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GE,
    //                aliasManager.getAlias(repository), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L ge(String repository, String name, String value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GE,
    //                aliasManager.getAlias(repository), ignoreStrategy));
    //    }
    //
    //    /**
    //     * 返回queryAlias.
    //     *
    //     * @return queryAlias
    //     */
    //    public String getQueryAlias() {
    //        return queryAlias;
    //    }
    //
    //    /**
    //     * Gets the root.
    //     *
    //     * @return the root
    //     */
    //    protected AbstractRepositorySqlConditionGroupExpression<C, L> getRoot() {
    //        L p = endGroup();
    //        //        L p2 = p.endGroup();
    //        //        while (p != p2) {
    //        while (p != p.endGroup()) {
    //            p = p.endGroup();
    //        }
    //        return (AbstractRepositorySqlConditionGroupExpression<C, L>) p;
    //    }
    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <D extends Date, T> L gt(Class<T> repository, String name, D value) {
    //    //        return gt(getTableName(repository), name, value);
    //    //    }
    //    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T> L gt(Class<T> repository, String name, LocalDate value) {
    //    //        return gt(getTableName(repository), name, value);
    //    //    }
    //    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T> L gt(Class<T> repository, String name, LocalDateTime value) {
    //    //        return gt(getTableName(repository), name, value);
    //    //    }
    //    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T> L gt(Class<T> repository, String name, LocalTime value) {
    //    //        return gt(getTableName(repository), name, value);
    //    //    }
    //    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <N extends Number, T> L gt(Class<T> repository, String name, N value) {
    //    //        return gt(getTableName(repository), name, value);
    //    //    }
    //    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T> L gt(Class<T> repository, String name, String value) {
    //    //        return gt(getTableName(repository), name, value);
    //    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <D extends Date> L gt(int repositoryIndex, String name, D value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GT,
    //                aliasManager.getAlias(repositoryIndex), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L gt(int repositoryIndex, String name, LocalDate value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GT,
    //                aliasManager.getAlias(repositoryIndex), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L gt(int repositoryIndex, String name, LocalDateTime value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GT,
    //                aliasManager.getAlias(repositoryIndex), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L gt(int repositoryIndex, String name, LocalTime value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GT,
    //                aliasManager.getAlias(repositoryIndex), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <N extends Number> L gt(int repositoryIndex, String name, N value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GT,
    //                aliasManager.getAlias(repositoryIndex), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L gt(int repositoryIndex, String name, String value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GT,
    //                aliasManager.getAlias(repositoryIndex), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T, D extends Date> L gt(SerializableToDateFunction<T, D> name, D value) {
    //        return gt(getPropertyName(name), value);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L gt(SerializableToLocalDateFunction<T> name, LocalDate value) {
    //        return gt(getPropertyName(name), value);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L gt(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value) {
    //        return gt(getPropertyName(name), value);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L gt(SerializableToLocalTimeFunction<T> name, LocalTime value) {
    //        return gt(getPropertyName(name), value);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T, N extends Number> L gt(SerializableToNumberFunction<T, N> name, N value) {
    //        return gt(getPropertyName(name), value);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L gt(SerializableToStringFunction<T> name, String value) {
    //        return gt(getPropertyName(name), value);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <D extends Date> L gt(String name, D value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GT,
    //                queryAlias, ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L gt(String name, LocalDate value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GT,
    //                queryAlias, ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L gt(String name, LocalDateTime value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GT,
    //                queryAlias, ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L gt(String name, LocalTime value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GT,
    //                queryAlias, ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <N extends Number> L gt(String name, N value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GT,
    //                queryAlias, ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L gt(String name, String value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GT,
    //                queryAlias, ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <D extends Date> L gt(String repository, String name, D value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GT,
    //                aliasManager.getAlias(repository), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L gt(String repository, String name, LocalDate value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GT,
    //                aliasManager.getAlias(repository), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L gt(String repository, String name, LocalDateTime value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GT,
    //                aliasManager.getAlias(repository), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L gt(String repository, String name, LocalTime value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GT,
    //                aliasManager.getAlias(repository), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <N extends Number> L gt(String repository, String name, N value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GT,
    //                aliasManager.getAlias(repository), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L gt(String repository, String name, String value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GT,
    //                aliasManager.getAlias(repository), ignoreStrategy));
    //    }
    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T> L in(Class<T> repository, String name, Object value) {
    //    //        return in(getTableName(repository), name, value);
    //    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L in(int repositoryIndex, String name, Object value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.IN,
    //                aliasManager.getAlias(repositoryIndex), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T, R> L in(SerializableFunction<T, R> name, Object value) {
    //        return in(getPropertyName(name), value);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L in(String name, Object value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.IN,
    //                queryAlias, ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L in(String repository, String name, Object value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.IN,
    //                aliasManager.getAlias(repository), ignoreStrategy));
    //    }
    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T> L inn(Class<T> repository, String name) {
    //    //        return inn(getTableName(repository), name);
    //    //    }
    //    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T> L inn(Class<T> repository, String name, Boolean value) {
    //    //        return inn(getTableName(repository), name, value);
    //    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L inn(int repositoryIndex, String name) {
    //        return inn(repositoryIndex, name, true);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L inn(int repositoryIndex, String name, Boolean value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.INN,
    //                aliasManager.getAlias(repositoryIndex), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T, R> L inn(SerializableFunction<T, R> name) {
    //        return inn(getPropertyName(name));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T, R> L inn(SerializableFunction<T, R> name, Boolean value) {
    //        return inn(getPropertyName(name), value);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L inn(String name) {
    //        return inn(name, true);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L inn(String name, Boolean value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.INN,
    //                queryAlias, ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L inn(String repository, String name) {
    //        return inn(repository, name, true);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L inn(String repository, String name, Boolean value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.INN,
    //                aliasManager.getAlias(repository), ignoreStrategy));
    //    }
    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T> L isn(Class<T> repository, String name) {
    //    //        return isn(getTableName(repository), name);
    //    //    }
    //    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T> L isn(Class<T> repository, String name, Boolean value) {
    //    //        return isn(getTableName(repository), name, value);
    //    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L isn(int repositoryIndex, String name) {
    //        return isn(repositoryIndex, name, true);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L isn(int repositoryIndex, String name, Boolean value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.ISN,
    //                aliasManager.getAlias(repositoryIndex), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T, R> L isn(SerializableFunction<T, R> name) {
    //        return isn(getPropertyName(name));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T, R> L isn(SerializableFunction<T, R> name, Boolean value) {
    //        return isn(getPropertyName(name), value);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L isn(String name) {
    //        return isn(name, true);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L isn(String name, Boolean value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.ISN,
    //                queryAlias, ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L isn(String repository, String name) {
    //        return isn(repository, name, true);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L isn(String repository, String name, Boolean value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.ISN,
    //                aliasManager.getAlias(repository), ignoreStrategy));
    //    }
    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <D extends Date, T> L le(Class<T> repository, String name, D value) {
    //    //        return le(getTableName(repository), name, value);
    //    //    }
    //    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T> L le(Class<T> repository, String name, LocalDate value) {
    //    //        return le(getTableName(repository), name, value);
    //    //    }
    //    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T> L le(Class<T> repository, String name, LocalDateTime value) {
    //    //        return le(getTableName(repository), name, value);
    //    //    }
    //    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T> L le(Class<T> repository, String name, LocalTime value) {
    //    //        return le(getTableName(repository), name, value);
    //    //    }
    //    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <N extends Number, T> L le(Class<T> repository, String name, N value) {
    //    //        return le(getTableName(repository), name, value);
    //    //    }
    //    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T> L le(Class<T> repository, String name, String value) {
    //    //        return le(getTableName(repository), name, value);
    //    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <D extends Date> L le(int repositoryIndex, String name, D value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LE,
    //                aliasManager.getAlias(repositoryIndex), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L le(int repositoryIndex, String name, LocalDate value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LE,
    //                aliasManager.getAlias(repositoryIndex), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L le(int repositoryIndex, String name, LocalDateTime value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LE,
    //                aliasManager.getAlias(repositoryIndex), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L le(int repositoryIndex, String name, LocalTime value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LE,
    //                aliasManager.getAlias(repositoryIndex), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <N extends Number> L le(int repositoryIndex, String name, N value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LE,
    //                aliasManager.getAlias(repositoryIndex), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L le(int repositoryIndex, String name, String value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LE,
    //                aliasManager.getAlias(repositoryIndex), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T, D extends Date> L le(SerializableToDateFunction<T, D> name, D value) {
    //        return le(getPropertyName(name), value);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L le(SerializableToLocalDateFunction<T> name, LocalDate value) {
    //        return le(getPropertyName(name), value);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L le(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value) {
    //        return le(getPropertyName(name), value);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L le(SerializableToLocalTimeFunction<T> name, LocalTime value) {
    //        return le(getPropertyName(name), value);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T, N extends Number> L le(SerializableToNumberFunction<T, N> name, N value) {
    //        return le(getPropertyName(name), value);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L le(SerializableToStringFunction<T> name, String value) {
    //        return le(getPropertyName(name), value);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <D extends Date> L le(String name, D value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LE,
    //                queryAlias, ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L le(String name, LocalDate value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LE,
    //                queryAlias, ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L le(String name, LocalDateTime value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LE,
    //                queryAlias, ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L le(String name, LocalTime value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LE,
    //                queryAlias, ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <N extends Number> L le(String name, N value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LE,
    //                queryAlias, ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L le(String name, String value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LE,
    //                queryAlias, ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <D extends Date> L le(String repository, String name, D value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LE,
    //                aliasManager.getAlias(repository), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L le(String repository, String name, LocalDate value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LE,
    //                aliasManager.getAlias(repository), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L le(String repository, String name, LocalDateTime value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LE,
    //                aliasManager.getAlias(repository), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L le(String repository, String name, LocalTime value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LE,
    //                aliasManager.getAlias(repository), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <N extends Number> L le(String repository, String name, N value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LE,
    //                aliasManager.getAlias(repository), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L le(String repository, String name, String value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LE,
    //                aliasManager.getAlias(repository), ignoreStrategy));
    //    }
    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <D extends Date, T> L lt(Class<T> repository, String name, D value) {
    //    //        return lt(getTableName(repository), name, value);
    //    //    }
    //    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T> L lt(Class<T> repository, String name, LocalDate value) {
    //    //        return lt(getTableName(repository), name, value);
    //    //    }
    //    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T> L lt(Class<T> repository, String name, LocalDateTime value) {
    //    //        return lt(getTableName(repository), name, value);
    //    //    }
    //    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T> L lt(Class<T> repository, String name, LocalTime value) {
    //    //        return lt(getTableName(repository), name, value);
    //    //    }
    //    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <N extends Number, T> L lt(Class<T> repository, String name, N value) {
    //    //        return lt(getTableName(repository), name, value);
    //    //    }
    //    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T> L lt(Class<T> repository, String name, String value) {
    //    //        return lt(getTableName(repository), name, value);
    //    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <D extends Date> L lt(int repositoryIndex, String name, D value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LT,
    //                aliasManager.getAlias(repositoryIndex), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L lt(int repositoryIndex, String name, LocalDate value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LT,
    //                aliasManager.getAlias(repositoryIndex), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L lt(int repositoryIndex, String name, LocalDateTime value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LT,
    //                aliasManager.getAlias(repositoryIndex), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L lt(int repositoryIndex, String name, LocalTime value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LT,
    //                aliasManager.getAlias(repositoryIndex), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <N extends Number> L lt(int repositoryIndex, String name, N value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LT,
    //                aliasManager.getAlias(repositoryIndex), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L lt(int repositoryIndex, String name, String value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LT,
    //                aliasManager.getAlias(repositoryIndex), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T, D extends Date> L lt(SerializableToDateFunction<T, D> name, D value) {
    //        return lt(getPropertyName(name), value);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L lt(SerializableToLocalDateFunction<T> name, LocalDate value) {
    //        return lt(getPropertyName(name), value);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L lt(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value) {
    //        return lt(getPropertyName(name), value);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L lt(SerializableToLocalTimeFunction<T> name, LocalTime value) {
    //        return lt(getPropertyName(name), value);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T, N extends Number> L lt(SerializableToNumberFunction<T, N> name, N value) {
    //        return lt(getPropertyName(name), value);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L lt(SerializableToStringFunction<T> name, String value) {
    //        return lt(getPropertyName(name), value);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <D extends Date> L lt(String name, D value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LT,
    //                queryAlias, ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L lt(String name, LocalDate value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LT,
    //                queryAlias, ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L lt(String name, LocalDateTime value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LT,
    //                queryAlias, ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L lt(String name, LocalTime value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LT,
    //                queryAlias, ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <N extends Number> L lt(String name, N value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LT,
    //                queryAlias, ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L lt(String name, String value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LT,
    //                queryAlias, ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <D extends Date> L lt(String repository, String name, D value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LT,
    //                aliasManager.getAlias(repository), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L lt(String repository, String name, LocalDate value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LT,
    //                aliasManager.getAlias(repository), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L lt(String repository, String name, LocalDateTime value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LT,
    //                aliasManager.getAlias(repository), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L lt(String repository, String name, LocalTime value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LT,
    //                aliasManager.getAlias(repository), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <N extends Number> L lt(String repository, String name, N value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LT,
    //                aliasManager.getAlias(repository), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L lt(String repository, String name, String value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LT,
    //                aliasManager.getAlias(repository), ignoreStrategy));
    //    }
    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T> L nin(Class<T> repository, String name, Object value) {
    //    //        return nin(getTableName(repository), name, value);
    //    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L nin(int repositoryIndex, String name, Object value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.NIN,
    //                aliasManager.getAlias(repositoryIndex), ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T, R> L nin(SerializableFunction<T, R> name, Object value) {
    //        return nin(getPropertyName(name), value);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L nin(String name, Object value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.NIN,
    //                queryAlias, ignoreStrategy));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L nin(String repository, String name, Object value) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.NIN,
    //                aliasManager.getAlias(repository), ignoreStrategy));
    //    }
    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T> ObjectExpression<C, L> property(Class<T> repository, String name) {
    //    //        return property(getTableName(repository), name);
    //    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public ObjectExpression<C, L> property(int repositoryIndex, String name) {
    //        return new RepositorySimpleObjectExpression<>(repositoryIndex, name, this);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T, R> ObjectExpression<C, L> property(SerializableFunction<T, R> name) {
    //        return property(getPropertyName(name));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public ObjectExpression<C, L> property(String name) {
    //        return new SimpleObjectExpression<>(name, this);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public ObjectExpression<C, L> property(String repository, String name) {
    //        return new RepositorySimpleObjectExpression<>(repository, name, this);
    //    }
    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <D extends Date, T> DateExpression<D, C, L> propertyDate(Class<T> repository, String name) {
    //    //        return propertyDate(getTableName(repository), name);
    //    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <D extends Date> DateExpression<D, C, L> propertyDate(int repositoryIndex, String name) {
    //        return new RepositorySimpleDateExpression<>(repositoryIndex, name, this);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <D extends Date> DateExpression<D, C, L> propertyDate(String name) {
    //        return new SimpleDateExpression<>(name, this);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <D extends Date> DateExpression<D, C, L> propertyDate(String repository, String name) {
    //        return new RepositorySimpleDateExpression<>(repository, name, this);
    //    }
    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T, E extends Enum<E>> EnumExpression<E, C, L> propertyEnum(Class<T> repository, String name) {
    //    //        return propertyEnum(getTableName(repository), name);
    //    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <E extends Enum<E>> EnumExpression<E, C, L> propertyEnum(int repositoryIndex, String name) {
    //        return new RepositorySimpleEnumExpression<>(repositoryIndex, name, this);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <E extends Enum<E>> EnumExpression<E, C, L> propertyEnum(String repository, String name) {
    //        return new RepositorySimpleEnumExpression<>(repository, name, this);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <E extends Enum<E>> EnumExpression<E, C, L> propertyEnum(String name) {
    //        return new SimpleEnumExpression<>(name, this);
    //    }
    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <N extends Number, T> NumberExpression<N, C, L> propertyNumber(Class<T> repository, String name) {
    //    //        return propertyNumber(getTableName(repository), name);
    //    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <N extends Number> NumberExpression<N, C, L> propertyNumber(int repositoryIndex, String name) {
    //        return new RepositorySimpleNumberExpression<>(repositoryIndex, name, this);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <N extends Number> NumberExpression<N, C, L> propertyNumber(String name) {
    //        return new SimpleNumberExpression<>(name, this);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <N extends Number> NumberExpression<N, C, L> propertyNumber(String repository, String name) {
    //        return new RepositorySimpleNumberExpression<>(repository, name, this);
    //    }
    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <T> StringExpression<C, L> propertyString(Class<T> repository, String name) {
    //    //        return propertyString(getTableName(repository), name);
    //    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public StringExpression<C, L> propertyString(int repositoryIndex, String name) {
    //        return new RepositorySimpleStringExpression<>(repositoryIndex, name, this);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public StringExpression<C, L> propertyString(String name) {
    //        return new SimpleStringExpression<>(name, this);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public StringExpression<C, L> propertyString(String repository, String name) {
    //        return new RepositorySimpleStringExpression<>(repository, name, this);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> StringExpression<C, L> property(SerializableToStringFunction<T> name) {
    //        return propertyString(getPropertyName(name));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T, R extends Number> NumberExpression<R, C, L> property(SerializableToNumberFunction<T, R> name) {
    //        return (NumberExpression<R, C, L>) propertyNumber(getPropertyName(name));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T, R extends Date> DateExpression<R, C, L> property(SerializableToDateFunction<T, R> name) {
    //        return propertyDate(getPropertyName(name));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T, R extends Enum<R>> EnumExpression<R, C, L> property(SerializableToEnumFunction<T, R> name) {
    //        return propertyEnum(getPropertyName(name));
    //    }
    //
    //    // ********************************************************************
    //    // property
    //    // ********************************************************************
    //
    //    /**
    //     * 设置queryAlias.
    //     *
    //     * @param queryAlias queryAlias
    //     */
    //    public void setQueryAlias(String queryAlias) {
    //        this.queryAlias = queryAlias;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <R> L in(SerializableSupplier<R> property) {
    //        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //        return in(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <R> L nin(SerializableSupplier<R> property) {
    //        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //        return nin(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <R extends Date> L ge(SerializableDateSupplier<R> property) {
    //        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //        return ge(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <R extends Number> L ge(SerializableNumberSupplier<R> property) {
    //        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //        return ge(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L ge(SerializableLocalDateSupplier property) {
    //        SerializableSupplierLambdaInfo<LocalDate> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //        return ge(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L ge(SerializableLocalTimeSupplier property) {
    //        SerializableSupplierLambdaInfo<LocalTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //        return ge(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L ge(SerializableLocalDateTimeSupplier property) {
    //        SerializableSupplierLambdaInfo<LocalDateTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //        return ge(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L ge(SerializableStringSupplier property) {
    //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //        return ge(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <R extends Number> L gt(SerializableNumberSupplier<R> property) {
    //        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //        return gt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <R extends Date> L gt(SerializableDateSupplier<R> property) {
    //        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //        return gt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L gt(SerializableLocalDateSupplier property) {
    //        SerializableSupplierLambdaInfo<LocalDate> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //        return gt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L gt(SerializableLocalTimeSupplier property) {
    //        SerializableSupplierLambdaInfo<LocalTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //        return gt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L gt(SerializableLocalDateTimeSupplier property) {
    //        SerializableSupplierLambdaInfo<LocalDateTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //        return gt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L gt(SerializableStringSupplier property) {
    //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //        return gt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <R extends Date> L le(SerializableDateSupplier<R> property) {
    //        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //        return le(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <R extends Number> L le(SerializableNumberSupplier<R> property) {
    //        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //        return le(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L le(SerializableLocalDateSupplier property) {
    //        SerializableSupplierLambdaInfo<LocalDate> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //        return le(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L le(SerializableLocalTimeSupplier property) {
    //        SerializableSupplierLambdaInfo<LocalTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //        return le(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L le(SerializableLocalDateTimeSupplier property) {
    //        SerializableSupplierLambdaInfo<LocalDateTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //        return le(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L le(SerializableStringSupplier property) {
    //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //        return le(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <R extends Number> L lt(SerializableNumberSupplier<R> property) {
    //        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //        return lt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <R extends Date> L lt(SerializableDateSupplier<R> property) {
    //        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //        return lt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L lt(SerializableLocalDateSupplier property) {
    //        SerializableSupplierLambdaInfo<LocalDate> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //        return lt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L lt(SerializableLocalTimeSupplier property) {
    //        SerializableSupplierLambdaInfo<LocalTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //        return lt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L lt(SerializableLocalDateTimeSupplier property) {
    //        SerializableSupplierLambdaInfo<LocalDateTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //        return lt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L lt(SerializableStringSupplier property) {
    //        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //        return lt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    //    }
    //
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
    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public C setIgnorePolicy(Predicate<?> ignoreStrategy) {
    //    //        AssertIllegalArgument.isNotNull(ignoreStrategy, "ignoreStrategy");
    //    //        this.ignoreStrategy = ignoreStrategy;
    //    //        return (C) this;
    //    //    }
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
    //     * @return LogicExpressionist
    //     */
    //    protected <R> List<Tuple2<String, Optional<R>>> supplier(SerializedLambdaInfo info, R value) {
    //        List<Tuple2<String, Optional<R>>> list = new ArrayList<>();
    //        if (value != null) {
    //            String propertyName = info.getPropertyName();
    //            list.add(Tuples.of(propertyName, Optional.of(value)));
    //        }
    //        return list;
    //    }
    //
    //    /**
    //     * Supplier.
    //     *
    //     * @param <R>  the generic type
    //     * @param info the info
    //     * @return LogicExpressionist
    //     */
    //    protected <R> List<Tuple2<String, Optional<R>>> supplier(SerializableSupplierLambdaInfo<R> info) {
    //        return supplier(info.getSerializedLambdaInfo(), info.get());
    //    }
    //
    //    /**
    //     * Properties.
    //     *
    //     * @param <T>        the generic type
    //     * @param <R>        the generic type
    //     * @param repository the repository
    //     * @param property   the property
    //     * @return the tuple 3
    //     */
    //    protected <T, R> Tuple3<String, String, Object> conditionResult(SerializableSupplier<T> repository,
    //            SerializableFunction<T, R> property) {
    //        // FIXME 后续来实现
    //        throw new UnsupportedException("未实现");
    //        //        return conditionResult(repository, property, classMapping, factory);
    //    }

    // ----------------------------------------------------------------------------------------------------------------

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L sw(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy) {
    //        return sw(name, value, matchStrategy, getIgnoreStrategy()::test);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L sw(SerializableToStringFunction<T> propertyName, String value, MatchStrategy matchStrategy,
    //            Predicate<String> ignoreStrategy) {
    //        return sw(getPropertyName(propertyName), value, matchStrategy, ignoreStrategy);
    //    }

    // ----------------------------------------------------------------------------------------------------------------

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L nsw(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy) {
    //        return nsw(name, value, matchStrategy, getIgnoreStrategy()::test);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L nsw(SerializableToStringFunction<T> propertyName, String value, MatchStrategy matchStrategy,
    //            Predicate<String> ignoreStrategy) {
    //        return nsw(getPropertyName(propertyName), value, matchStrategy, ignoreStrategy);
    //    }

    // ----------------------------------------------------------------------------------------------------------------

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L ew(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy) {
    //        return ew(getPropertyName(name), value, matchStrategy);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L ew(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
    //            Predicate<String> ignoreStrategy) {
    //        return ew(getPropertyName(name), value, matchStrategy, ignoreStrategy);
    //    }

    // ----------------------------------------------------------------------------------------------------------------

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L newv(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy) {
    //        return newv(getPropertyName(name), value, matchStrategy);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L newv(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
    //            Predicate<String> ignoreStrategy) {
    //        return newv(getPropertyName(name), value, matchStrategy, ignoreStrategy);
    //    }

    // ----------------------------------------------------------------------------------------------------------------

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L co(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy) {
    //        return co(getPropertyName(name), value, matchStrategy);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L co(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
    //            Predicate<String> ignoreStrategy) {
    //        return co(getPropertyName(name), value, matchStrategy, ignoreStrategy);
    //    }

    // ----------------------------------------------------------------------------------------------------------------

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L nco(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy) {
    //        return nco(getPropertyName(name), value, matchStrategy);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L nco(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
    //            Predicate<String> ignoreStrategy) {
    //        return nco(getPropertyName(name), value, matchStrategy, ignoreStrategy);
    //    }

    // ----------------------------------------------------------------------------------------------------------------

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L in(SerializableToIntFunction<T> name, int... values) {
    //        return in(getPropertyName(name), values);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L in(SerializableToIntFunction<T> name, int[] values, Predicate<int[]> ignoreStrategy) {
    //        return in(getPropertyName(name), values, ignoreStrategy);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L in(SerializableToLongFunction<T> name, long... values) {
    //        return in(getPropertyName(name), values);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L in(SerializableToLongFunction<T> name, long[] values, Predicate<long[]> ignoreStrategy) {
    //        return in(getPropertyName(name), values, ignoreStrategy);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L in(SerializableToDoubleFunction<T> name, double... values) {
    //        return in(getPropertyName(name), values);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L in(SerializableToDoubleFunction<T> name, double[] values, Predicate<double[]> ignoreStrategy) {
    //        return in(getPropertyName(name), values, ignoreStrategy);
    //    }

    // ----------------------------------------------------------------------------------------------------------------

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T, N extends Number> L ge(SerializableToNumberFunction<T, N> name, N value) {
    //        return ge(getPropertyName(name), value);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T, N extends Number> L ge(SerializableToNumberFunction<T, N> name, N value, Predicate<N> ignoreStrategy) {
    //        return ge(getPropertyName(name), value, ignoreStrategy);
    //    }

    // ----------------------------------------------------------------------------------------------------------------

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L ni(SerializableToIntFunction<T> name, int... values) {
    //        return ni(getPropertyName(name), values);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L ni(SerializableToIntFunction<T> name, int[] values, Predicate<int[]> ignoreStrategy) {
    //        return ni(getPropertyName(name), values, ignoreStrategy);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L ni(SerializableToLongFunction<T> name, long... values) {
    //        return ni(getPropertyName(name), values);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L ni(SerializableToLongFunction<T> name, long[] values, Predicate<long[]> ignoreStrategy) {
    //        return ni(getPropertyName(name), values, ignoreStrategy);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L ni(SerializableToDoubleFunction<T> name, double... values) {
    //        return ni(getPropertyName(name), values);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L ni(SerializableToDoubleFunction<T> name, double[] values, Predicate<double[]> ignoreStrategy) {
    //        return ni(getPropertyName(name), values, ignoreStrategy);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L ni(SerializableToStringFunction<T> name, String[] values, MatchStrategy matchStrategy) {
    //        return ni(getPropertyName(name), values, matchStrategy);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L ni(SerializableToStringFunction<T> name, String[] values, MatchStrategy matchStrategy,
    //            Predicate<String[]> ignoreStrategy) {
    //        return ni(getPropertyName(name), values, matchStrategy, ignoreStrategy);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T, R> L ni(SerializableFunction<T, R> name, R... values) {
    //        return ni(getPropertyName(name), values);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T, R> L ni(SerializableFunction<T, R> name, R[] values, Predicate<R[]> ignoreStrategy) {
    //        return ni(getPropertyName(name), values, ignoreStrategy);
    //    }

    // ----------------------------------------------------------------------------------------------------------------

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L in(SerializableToStringFunction<T> name, String[] values, MatchStrategy matchStrategy) {
    //        return in(getPropertyName(name), values, matchStrategy);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> L in(SerializableToStringFunction<T> name, String[] values, MatchStrategy matchStrategy,
    //            Predicate<String[]> ignoreStrategy) {
    //        return in(getPropertyName(name), values, matchStrategy, ignoreStrategy);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T, R> L in(SerializableFunction<T, R> name, R... values) {
    //        return in(getPropertyName(name), values);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T, R> L in(SerializableFunction<T, R> name, R[] values, Predicate<R[]> ignoreStrategy) {
    //        return in(getPropertyName(name), values, ignoreStrategy);
    //    }

    // ----------------------------------------------------------------------------------------------------------------

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T, N extends Number> L ba(SerializableToNumberFunction<T, N> name, N min, N max) {
    //        return ba0(name, min, max, getIgnoreStrategy());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T, N extends Number> L ba(SerializableToNumberFunction<T, N> name, N min, N max,
    //            IgnoreStrategy ignoreStrategy) {
    //        return ba0(name, min, max, ignoreStrategy);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T, N extends Number> L ba(SerializableToNumberFunction<T, N> name, N min, N max,
    //            BiPredicate<N, N> ignoreStrategy) {
    //        return ba0(name, min, max, ignoreStrategy);
    //    }

    // ----------------------------------------------------------------------------------------------------------------

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T, N extends Number> L nba(SerializableToNumberFunction<T, N> name, N min, N max) {
    //        return nba0(name, min, max, getIgnoreStrategy());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T, N extends Number> L nba(SerializableToNumberFunction<T, N> name, N min, N max,
    //            IgnoreStrategy ignoreStrategy) {
    //        return nba0(name, min, max, ignoreStrategy);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T, N extends Number> L nba(SerializableToNumberFunction<T, N> name, N min, N max,
    //            BiPredicate<N, N> ignoreStrategy) {
    //        return nba0(name, min, max, ignoreStrategy);
    //    }

    // ----------------------------------------------------------------------------------------------------------------

    //    private L ba0(Serializable name, Object min, Object max, BiPredicate<?, ?> ignoreStrategy) {
    //        return ba0(getPropertyName(name), min, max, v -> {
    //            Object[] params = (Object[]) v;
    //            return ((BiPredicate<Object, Object>) ignoreStrategy).test(params[0], params[1]);
    //        });
    //    }
    //
    //    private L ba0(Serializable name, Object min, Object max, Predicate<?> ignoreStrategy) {
    //        return ba0(getPropertyName(name), min, max, ignoreStrategy);
    //    }
    //
    //    private L nba0(Serializable name, Object min, Object max, BiPredicate<?, ?> ignoreStrategy) {
    //        return nba0(getPropertyName(name), min, max, v -> {
    //            Object[] params = (Object[]) v;
    //            return ((BiPredicate<Object, Object>) ignoreStrategy).test(params[0], params[1]);
    //        });
    //    }
    //
    //    private L nba0(Serializable name, Object min, Object max, Predicate<?> ignoreStrategy) {
    //        return nba0(getPropertyName(name), min, max, ignoreStrategy);
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <R> L eqOrNe(AtomicInteger index, ComparisonOperator comparisonOperator, String name, R value,
    //            MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, comparisonOperator,
    //                matchStrategy, getRepositoryAlias(), ignoreStrategy));
    //    }

    // ********************************************************************
    //  property
    // ********************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositorySerializableFieldExpression<C, L> field(String name) {
        return new SerializableFieldExpressionImpl<>(name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryStringFieldExpression<C, L> fieldAsString(String name) {
        return new StringFieldExpressionImpl<>(name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> RepositoryNumberFieldExpression<N, C, L> fieldAsNumber(String name) {
        return new NumberFieldExpressionImpl<>(name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> RepositoryDateFieldExpression<D, C, L> fieldAsDate(String name) {
        return new DateFieldExpressionImpl<>(name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> RepositoryEnumFieldExpression<E, C, L> fieldAsEnum(String name) {
        return new EnumFieldExpressionImpl<>(name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryLocalDateFieldExpression<C, L> fieldAsLocalDate(String name) {
        return new LocalDateFieldExpressionImpl<>(name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryLocalDateTimeFieldExpression<C, L> fieldAsLocalDateTime(String name) {
        return new LocalDateTimeFieldExpressionImpl<>(name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryLocalTimeFieldExpression<C, L> fieldAsLocalTime(String name) {
        return new LocalTimeFieldExpressionImpl<>(name, this);
    }
}
