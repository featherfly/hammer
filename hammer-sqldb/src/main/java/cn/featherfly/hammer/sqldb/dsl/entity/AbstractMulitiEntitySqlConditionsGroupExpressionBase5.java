/*
 * All rights Reserved, Designed By zhongj
 * @Title: AbstractEntitySqlConditionGroupExpressionBase5.java
 * @Package cn.featherfly.hammer.sqldb.sql.dml
 * @author: zhongj
 * @version V1.0
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */

package cn.featherfly.hammer.sqldb.dsl.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Date;
import java.util.function.BiPredicate;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.CharPredicate;
import cn.featherfly.common.function.FiveArgusFunction;
import cn.featherfly.common.function.serializable.SerializableBoolSupplier;
import cn.featherfly.common.function.serializable.SerializableBooleanSupplier;
import cn.featherfly.common.function.serializable.SerializableCharSupplier;
import cn.featherfly.common.function.serializable.SerializableDateSupplier;
import cn.featherfly.common.function.serializable.SerializableDoubleSupplier;
import cn.featherfly.common.function.serializable.SerializableEnumSupplier;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableIntSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableLongSupplier;
import cn.featherfly.common.function.serializable.SerializableNumberSupplier;
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.function.serializable.SerializableToCharFunction;
import cn.featherfly.common.function.serializable.SerializableToDateFunction;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction;
import cn.featherfly.common.function.serializable.SerializableToEnumFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.common.function.serializable.SerializableToNumberFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LambdaUtils.SerializableSupplierLambdaInfo;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.config.dsl.ConditionConfig;
import cn.featherfly.hammer.expression.condition.GroupEndExpression;
import cn.featherfly.hammer.expression.condition.GroupExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.EntityPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.EntityPropertyExpression5;
import cn.featherfly.hammer.expression.entity.condition.ba.EntityBetweenExpressionBase5;
import cn.featherfly.hammer.expression.entity.condition.co.EntityContainsExpressionBase5;
import cn.featherfly.hammer.expression.entity.condition.eq.EntityEqualsExpressionBase5;
import cn.featherfly.hammer.expression.entity.condition.ew.EntityEndWithExpressionBase5;
import cn.featherfly.hammer.expression.entity.condition.ge.EntityGreatEqualsExpressionBase5;
import cn.featherfly.hammer.expression.entity.condition.gt.EntityGreatThanExpressionBase5;
import cn.featherfly.hammer.expression.entity.condition.in.EntityInExpressionBase5;
import cn.featherfly.hammer.expression.entity.condition.inn.EntityIsNotNullExpressionBase5;
import cn.featherfly.hammer.expression.entity.condition.isn.EntityIsNullExpressionBase5;
import cn.featherfly.hammer.expression.entity.condition.le.EntityLessEqualsExpressionBase5;
import cn.featherfly.hammer.expression.entity.condition.lk.EntityLikeExpressionBase5;
import cn.featherfly.hammer.expression.entity.condition.lt.EntityLessThanExpressionBase5;
import cn.featherfly.hammer.expression.entity.condition.nba.EntityNotBetweenExpressionBase5;
import cn.featherfly.hammer.expression.entity.condition.nco.EntityNotContainsExpressionBase5;
import cn.featherfly.hammer.expression.entity.condition.ne.EntityNotEqualsExpressionBase5;
import cn.featherfly.hammer.expression.entity.condition.newv.EntityNotEndWithExpressionBase5;
import cn.featherfly.hammer.expression.entity.condition.ni.EntityNotInExpressionBase5;
import cn.featherfly.hammer.expression.entity.condition.nl.EntityNotLikeExpressionBase5;
import cn.featherfly.hammer.expression.entity.condition.nsw.EntityNotStartWithExpressionBase5;
import cn.featherfly.hammer.expression.entity.condition.sw.EntityStartWithExpressionBase5;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlRelation.EntityRelation;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.propery.EntityPropertyOnlyExpressionImpl;

/**
 * sql condition group expression 5. sql条件逻辑组表达式5.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <E3> third filterable entity type
 * @param <E4> fouth filterable entity type
 * @param <E5> fifth filterable entity type
 * @param <C> condition expression
 * @param <L> logic expression
 * @param <C2> condition config
 * @param <ER> entity sql relation
 * @param <B> sql builder
 */
public abstract class AbstractMulitiEntitySqlConditionsGroupExpressionBase5<E1, E2, E3, E4, E5,
    C extends GroupExpression<C, L>, L extends GroupEndExpression<C, L>, C2 extends ConditionConfig<C2>,
    ER extends EntitySqlRelation<ER, B>, B extends SqlBuilder>
    extends AbstractMulitiEntitySqlConditionsGroupExpressionBase4<E1, E2, E3, E4, C, L, C2, ER, B> implements
    EntityBetweenExpressionBase5<E1, E2, E3, E4, E5, C, L>, EntityNotBetweenExpressionBase5<E1, E2, E3, E4, E5, C, L> //
    , EntityContainsExpressionBase5<E1, E2, E3, E4, E5, C, L>,
    EntityNotContainsExpressionBase5<E1, E2, E3, E4, E5, C, L> //
    , EntityEndWithExpressionBase5<E1, E2, E3, E4, E5, C, L>, EntityNotEndWithExpressionBase5<E1, E2, E3, E4, E5, C, L> //
    , EntityEqualsExpressionBase5<E1, E2, E3, E4, E5, C, L>, EntityNotEqualsExpressionBase5<E1, E2, E3, E4, E5, C, L>//
    , EntityGreatEqualsExpressionBase5<E1, E2, E3, E4, E5, C, L>,
    EntityGreatThanExpressionBase5<E1, E2, E3, E4, E5, C, L> //
    , EntityInExpressionBase5<E1, E2, E3, E4, E5, C, L>, EntityNotInExpressionBase5<E1, E2, E3, E4, E5, C, L> //
    , EntityIsNotNullExpressionBase5<E1, E2, E3, E4, E5, C, L>, EntityIsNullExpressionBase5<E1, E2, E3, E4, E5, C, L> //
    , EntityLessEqualsExpressionBase5<E1, E2, E3, E4, E5, C, L>, EntityLessThanExpressionBase5<E1, E2, E3, E4, E5, C, L> //
    , EntityStartWithExpressionBase5<E1, E2, E3, E4, E5, C, L>,
    EntityNotStartWithExpressionBase5<E1, E2, E3, E4, E5, C, L> //
    , EntityLikeExpressionBase5<E1, E2, E3, E4, E5, C, L>, EntityNotLikeExpressionBase5<E1, E2, E3, E4, E5, C, L>//
    , EntityPropertyExpression5<E1, E2, E3, E4, E5, C, L> {

    /** The class mapping. */
    protected final JdbcClassMapping<E5> classMapping5;

    /** The table alias 5. */
    protected final String tableAlias5;

    /**
     * Instantiates a new abstract entity sql condition group expression base 4.
     *
     * @param parent the parent
     * @param factory the factory
     * @param entitySqlRelation the entity sql relation
     */
    @SuppressWarnings("unchecked")
    protected AbstractMulitiEntitySqlConditionsGroupExpressionBase5(L parent, JdbcMappingFactory factory,
        ER entitySqlRelation) {
        super(parent, factory, entitySqlRelation);

        EntityRelation<?> erm = entitySqlRelation.getEntityRelationTuple().getOrNull4();
        classMapping5 = (JdbcClassMapping<E5>) erm.getClassMapping();
        tableAlias5 = erm.getTableAlias();
    }

    // ****************************************************************************************************************
    //  eq
    // ****************************************************************************************************************

    @Override
    public <R extends Serializable> L eq5(SerializableFunction<E5, R> name, R value) {
        return eq(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <R extends Serializable> L eq5(SerializableFunction<E5, R> name, R value, Predicate<R> ignoreStrategy) {
        return eq(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public <D extends Date> L eq5(SerializableToDateFunction<E5, D> name, D value) {
        return eq(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <D extends Date> L eq5(SerializableToDateFunction<E5, D> name, D value, Predicate<D> ignoreStrategy) {
        return eq(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L eq5(SerializableToDoubleFunction<E5> name, double value) {
        return eq(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L eq5(SerializableToDoubleFunction<E5> name, double value, DoublePredicate ignoreStrategy) {
        return eq(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public <E extends Enum<E>> L eq5(SerializableToEnumFunction<E5, E> name, E value) {
        return eq(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <E extends Enum<E>> L eq5(SerializableToEnumFunction<E5, E> name, E value, Predicate<E> ignoreStrategy) {
        return eq(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L eq5(SerializableToCharFunction<E5> name, char value) {
        return eq(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L eq5(SerializableToCharFunction<E5> name, char value, CharPredicate ignoreStrategy) {
        return eq(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L eq5(SerializableToIntFunction<E5> name, int value) {
        return eq(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L eq5(SerializableToIntFunction<E5> name, int value, IntPredicate ignoreStrategy) {
        return eq(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L eq5(SerializableToLocalDateFunction<E5> name, LocalDate value) {
        return eq(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L eq5(SerializableToLocalDateFunction<E5> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return eq(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L eq5(SerializableToLocalDateTimeFunction<E5> name, LocalDateTime value) {
        return eq(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L eq5(SerializableToLocalDateTimeFunction<E5> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return eq(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L eq5(SerializableToLocalTimeFunction<E5> name, LocalTime value) {
        return eq(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L eq5(SerializableToLocalTimeFunction<E5> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return eq(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L eq5(SerializableToLongFunction<E5> name, long value) {
        return eq(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L eq5(SerializableToLongFunction<E5> name, long value, LongPredicate ignoreStrategy) {
        return eq(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public <N extends Number> L eq5(SerializableToNumberFunction<E5, N> name, N value) {
        return eq(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <N extends Number> L eq5(SerializableToNumberFunction<E5, N> name, N value, Predicate<N> ignoreStrategy) {
        return eq(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L eq5(SerializableToStringFunction<E5> name, String value, MatchStrategy matchStrategy) {
        return eq(classMapping5, name, value, tableAlias5, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L eq5(SerializableToStringFunction<E5> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return eq(classMapping5, name, value, tableAlias5, matchStrategy, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    @Override
    public <D extends Date> L eq5(SerializableDateSupplier<D> property, D value) {
        return eq(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <D extends Date> L eq5(SerializableDateSupplier<D> property, D value, Predicate<D> ignoreStrategy) {
        return eq(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L eq5(SerializableDoubleSupplier property, double value) {
        return eq(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L eq5(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy) {
        return eq(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public <E extends Enum<E>> L eq5(SerializableEnumSupplier<E> property, E value) {
        return eq(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <E extends Enum<E>> L eq5(SerializableEnumSupplier<E> property, E value, Predicate<E> ignoreStrategy) {
        return eq(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L eq5(SerializableBooleanSupplier property, boolean value) {
        return eq(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L eq5(SerializableBoolSupplier property, Boolean value) {
        return eq(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L eq5(SerializableBoolSupplier property, Boolean value, Predicate<Boolean> ignoreStrategy) {
        return eq(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L eq5(SerializableCharSupplier property, char value) {
        return eq(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L eq5(SerializableCharSupplier property, char value, CharPredicate ignoreStrategy) {
        return eq(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L eq5(SerializableIntSupplier property, int value) {
        return eq(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L eq5(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy) {
        return eq(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L eq5(SerializableLocalDateSupplier property, LocalDate value) {
        return eq(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L eq5(SerializableLocalDateSupplier property, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return eq(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L eq5(SerializableLocalDateTimeSupplier property, LocalDateTime value) {
        return eq(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L eq5(SerializableLocalDateTimeSupplier property, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return eq(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L eq5(SerializableLocalTimeSupplier property, LocalTime value) {
        return eq(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L eq5(SerializableLocalTimeSupplier property, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return eq(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L eq5(SerializableLongSupplier property, long value) {
        return eq(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L eq5(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy) {
        return eq(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public <N extends Number> L eq5(SerializableNumberSupplier<N> property, N value) {
        return eq(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <N extends Number> L eq5(SerializableNumberSupplier<N> property, N value, Predicate<N> ignoreStrategy) {
        return eq(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L eq5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return eq(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L eq5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return eq(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public <R extends Serializable> L eq5(SerializableSupplier<R> property, R value) {
        return eq(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <R extends Serializable> L eq5(SerializableSupplier<R> property, R value, Predicate<R> ignoreStrategy) {
        return eq(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    // ****************************************************************************************************************
    //  ne
    // ****************************************************************************************************************

    @Override
    public <R extends Serializable> L ne5(SerializableFunction<E5, R> name, R value) {
        return ne(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <R extends Serializable> L ne5(SerializableFunction<E5, R> name, R value, Predicate<R> ignoreStrategy) {
        return ne(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public <D extends Date> L ne5(SerializableToDateFunction<E5, D> name, D value) {
        return ne(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <D extends Date> L ne5(SerializableToDateFunction<E5, D> name, D value, Predicate<D> ignoreStrategy) {
        return ne(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L ne5(SerializableToDoubleFunction<E5> name, double value) {
        return ne(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L ne5(SerializableToDoubleFunction<E5> name, double value, DoublePredicate ignoreStrategy) {
        return ne(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public <E extends Enum<E>> L ne5(SerializableToEnumFunction<E5, E> name, E value) {
        return ne(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <E extends Enum<E>> L ne5(SerializableToEnumFunction<E5, E> name, E value, Predicate<E> ignoreStrategy) {
        return ne(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L ne5(SerializableToIntFunction<E5> name, int value) {
        return ne(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L ne5(SerializableToIntFunction<E5> name, int value, IntPredicate ignoreStrategy) {
        return ne(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L ne5(SerializableToLocalDateFunction<E5> name, LocalDate value) {
        return ne(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L ne5(SerializableToLocalDateFunction<E5> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ne(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L ne5(SerializableToLocalDateTimeFunction<E5> name, LocalDateTime value) {
        return ne(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L ne5(SerializableToLocalDateTimeFunction<E5> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return ne(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L ne5(SerializableToLocalTimeFunction<E5> name, LocalTime value) {
        return ne(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L ne5(SerializableToLocalTimeFunction<E5> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ne(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L ne5(SerializableToLongFunction<E5> name, long value) {
        return ne(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L ne5(SerializableToLongFunction<E5> name, long value, LongPredicate ignoreStrategy) {
        return ne(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public <N extends Number> L ne5(SerializableToNumberFunction<E5, N> name, N value) {
        return ne(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <N extends Number> L ne5(SerializableToNumberFunction<E5, N> name, N value, Predicate<N> ignoreStrategy) {
        return ne(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L ne5(SerializableToStringFunction<E5> name, String value, MatchStrategy matchStrategy) {
        return ne(classMapping5, name, value, tableAlias5, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L ne5(SerializableToStringFunction<E5> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ne(classMapping5, name, value, tableAlias5, matchStrategy, ignoreStrategy);
    }

    @Override
    public <D extends Date> L ne5(SerializableDateSupplier<D> property, D value) {
        return ne(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <D extends Date> L ne5(SerializableDateSupplier<D> property, D value, Predicate<D> ignoreStrategy) {
        return ne(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L ne5(SerializableDoubleSupplier property, double value) {
        return ne(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L ne5(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy) {
        return ne(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public <E extends Enum<E>> L ne5(SerializableEnumSupplier<E> property, E value) {
        return ne(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <E extends Enum<E>> L ne5(SerializableEnumSupplier<E> property, E value, Predicate<E> ignoreStrategy) {
        return ne(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L ne5(SerializableBooleanSupplier property, boolean value) {
        return ne(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L ne5(SerializableBoolSupplier property, Boolean value) {
        return ne(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L ne5(SerializableBoolSupplier property, Boolean value, Predicate<Boolean> ignoreStrategy) {
        return ne(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L ne5(SerializableCharSupplier property, char value) {
        return ne(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L ne5(SerializableCharSupplier property, char value, CharPredicate ignoreStrategy) {
        return ne(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L ne5(SerializableIntSupplier property, int value) {
        return ne(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L ne5(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy) {
        return ne(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L ne5(SerializableLocalDateSupplier property, LocalDate value) {
        return ne(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L ne5(SerializableLocalDateSupplier property, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ne(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L ne5(SerializableLocalDateTimeSupplier property, LocalDateTime value) {
        return ne(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L ne5(SerializableLocalDateTimeSupplier property, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return ne(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L ne5(SerializableLocalTimeSupplier property, LocalTime value) {
        return ne(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L ne5(SerializableLocalTimeSupplier property, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ne(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L ne5(SerializableLongSupplier property, long value) {
        return ne(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L ne5(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy) {
        return ne(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public <N extends Number> L ne5(SerializableNumberSupplier<N> property, N value) {
        return ne(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <N extends Number> L ne5(SerializableNumberSupplier<N> property, N value, Predicate<N> ignoreStrategy) {
        return ne(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L ne5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return ne(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L ne5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ne(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public <R extends Serializable> L ne5(SerializableSupplier<R> property, R value) {
        return ne(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <R extends Serializable> L ne5(SerializableSupplier<R> property, R value, Predicate<R> ignoreStrategy) {
        return ne(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L lk5(SerializableFunction<E5, String> name, String value, MatchStrategy matchStrategy) {
        return lk(classMapping5, name, value, tableAlias5, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L lk5(SerializableFunction<E5, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return lk(classMapping5, name, value, tableAlias5, matchStrategy, ignoreStrategy);
    }

    @Override
    public L lk5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return lk(classMapping5, property, value, tableAlias5, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L lk5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return lk(classMapping5, property, value, tableAlias5, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L nl5(SerializableFunction<E5, String> name, String value, MatchStrategy matchStrategy) {
        return nl(classMapping5, name, value, tableAlias5, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L nl5(SerializableFunction<E5, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nl(classMapping5, name, value, tableAlias5, matchStrategy, ignoreStrategy);
    }

    @Override
    public L nl5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return nl(classMapping5, property, value, tableAlias5, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L nl5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nl(classMapping5, property, value, tableAlias5, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L sw5(SerializableFunction<E5, String> name, String value, MatchStrategy matchStrategy) {
        return sw(classMapping5, name, value, tableAlias5, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L sw5(SerializableFunction<E5, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return sw(classMapping5, name, value, tableAlias5, matchStrategy, ignoreStrategy);
    }

    @Override
    public L sw5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return sw(classMapping5, property, value, tableAlias5, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L sw5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return sw(classMapping5, property, value, tableAlias5, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L nsw5(SerializableFunction<E5, String> name, String value, MatchStrategy matchStrategy) {
        return nsw(classMapping5, name, value, tableAlias5, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L nsw5(SerializableFunction<E5, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nsw(classMapping5, name, value, tableAlias5, matchStrategy, ignoreStrategy);
    }

    @Override
    public L nsw5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return nsw(classMapping5, property, value, tableAlias5, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L nsw5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nsw(classMapping5, property, value, tableAlias5, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L ew5(SerializableFunction<E5, String> name, String value, MatchStrategy matchStrategy) {
        return ew(classMapping5, name, value, tableAlias5, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L ew5(SerializableFunction<E5, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ew(classMapping5, name, value, tableAlias5, matchStrategy, ignoreStrategy);
    }

    @Override
    public L ew5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return ew(classMapping5, property, value, tableAlias5, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L ew5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ew(classMapping5, property, value, tableAlias5, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L new5(SerializableFunction<E5, String> name, String value, MatchStrategy matchStrategy) {
        return newv(classMapping5, name, value, tableAlias5, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L new5(SerializableFunction<E5, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return newv(classMapping5, name, value, tableAlias5, matchStrategy, ignoreStrategy);
    }

    @Override
    public L new5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return newv(classMapping5, property, value, tableAlias5, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L new5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return newv(classMapping5, property, value, tableAlias5, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L co5(SerializableFunction<E5, String> name, String value, MatchStrategy matchStrategy) {
        return co(classMapping5, name, value, tableAlias5, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L co5(SerializableFunction<E5, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return co(classMapping5, name, value, tableAlias5, matchStrategy, ignoreStrategy);
    }

    @Override
    public L co5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return co(classMapping5, property, value, tableAlias5, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L co5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return co(classMapping5, property, value, tableAlias5, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L nco5(SerializableFunction<E5, String> name, String value, MatchStrategy matchStrategy) {
        return nco(classMapping5, name, value, tableAlias5, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L nco5(SerializableFunction<E5, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nco(classMapping5, name, value, tableAlias5, matchStrategy, ignoreStrategy);
    }

    @Override
    public L nco5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return nco(classMapping5, property, value, tableAlias5, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L nco5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nco(classMapping5, property, value, tableAlias5, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L ge5(SerializableFunction<E5, N> name, N value) {
        return ge(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <N extends Number> L ge5(SerializableFunction<E5, N> name, N value, Predicate<N> ignoreStrategy) {
        return ge(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public <E extends Enum<E>> L ge5(SerializableFunction<E5, E> name, E value) {
        return ge(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <E extends Enum<E>> L ge5(SerializableFunction<E5, E> name, E value, Predicate<E> ignoreStrategy) {
        return ge(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L ge5(SerializableFunction<E5, String> name, String value, MatchStrategy matchStrategy) {
        return ge(classMapping5, name, value, tableAlias5, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L ge5(SerializableFunction<E5, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ge(classMapping5, name, value, tableAlias5, matchStrategy, ignoreStrategy);
    }

    @Override
    public <E extends Enum<E>> L ge5(SerializableEnumSupplier<E> property, E value) {
        return ge(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <E extends Enum<E>> L ge5(SerializableEnumSupplier<E> property, E value, Predicate<E> ignoreStrategy) {
        return ge(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L ge5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return ge(classMapping5, property, matchStrategy, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L ge5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ge(classMapping5, property, matchStrategy, tableAlias5, ignoreStrategy);
    }

    @Override
    public <D extends Date> L ge5(SerializableFunction<E5, D> name, D value) {
        return ge(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <D extends Date> L ge5(SerializableFunction<E5, D> name, D value, Predicate<D> ignoreStrategy) {
        return ge(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L ge5(SerializableFunction<E5, LocalTime> name, LocalTime value) {
        return ge(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L ge5(SerializableFunction<E5, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ge(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L ge5(SerializableFunction<E5, LocalDate> name, LocalDate value) {
        return ge(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L ge5(SerializableFunction<E5, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ge(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L ge5(SerializableFunction<E5, LocalDateTime> name, LocalDateTime value) {
        return ge(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L ge5(SerializableFunction<E5, LocalDateTime> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return ge(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L ge5(SerializableFunction<E5, String> name, String value) {
        return ge(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L ge5(SerializableFunction<E5, String> name, String value, Predicate<String> ignoreStrategy) {
        return ge(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L ge5(SerializableToIntFunction<E5> name, int value) {
        return ge(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L ge5(SerializableToIntFunction<E5> name, int value, IntPredicate ignoreStrategy) {
        return ge(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L ge5(SerializableToLongFunction<E5> name, long value) {
        return ge(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L ge5(SerializableToLongFunction<E5> name, long value, LongPredicate ignoreStrategy) {
        return ge(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L ge5(SerializableToDoubleFunction<E5> name, double value) {
        return ge(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L ge5(SerializableToDoubleFunction<E5> name, double value, DoublePredicate ignoreStrategy) {
        return ge(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    @Override
    public <D extends Date> L ge5(SerializableDateSupplier<D> property, D value) {
        return ge(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <D extends Date> L ge5(SerializableDateSupplier<D> property, D value, Predicate<D> ignoreStrategy) {
        return ge(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public <N extends Number> L ge5(SerializableNumberSupplier<N> property, N value) {
        return ge(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <N extends Number> L ge5(SerializableNumberSupplier<N> property, N value, Predicate<N> ignoreStrategy) {
        return ge(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L ge5(SerializableLocalDateSupplier property, LocalDate value) {
        return ge(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L ge5(SerializableLocalDateSupplier property, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ge(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L ge5(SerializableLocalTimeSupplier property, LocalTime value) {
        return ge(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L ge5(SerializableLocalTimeSupplier property, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ge(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L ge5(SerializableLocalDateTimeSupplier property, LocalDateTime value) {
        return ge(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L ge5(SerializableLocalDateTimeSupplier property, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return ge(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L ge5(SerializableStringSupplier property, String value) {
        return ge(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L ge5(SerializableStringSupplier property, String value, Predicate<String> ignoreStrategy) {
        return ge(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L ge5(SerializableIntSupplier property, int value) {
        return ge(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L ge5(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy) {
        return ge(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L ge5(SerializableLongSupplier property, long value) {
        return ge(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L ge5(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy) {
        return ge(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L ge5(SerializableDoubleSupplier property, double value) {
        return ge(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L ge5(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy) {
        return ge(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L gt5(SerializableFunction<E5, N> name, N value) {
        return gt(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <N extends Number> L gt5(SerializableFunction<E5, N> name, N value, Predicate<N> ignoreStrategy) {
        return gt(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public <E extends Enum<E>> L gt5(SerializableFunction<E5, E> name, E value) {
        return gt(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <E extends Enum<E>> L gt5(SerializableFunction<E5, E> name, E value, Predicate<E> ignoreStrategy) {
        return gt(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L gt5(SerializableFunction<E5, String> name, String value, MatchStrategy matchStrategy) {
        return gt(classMapping5, name, value, matchStrategy, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L gt5(SerializableFunction<E5, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return gt(classMapping5, name, value, matchStrategy, tableAlias5, ignoreStrategy);
    }

    @Override
    public <D extends Date> L gt5(SerializableFunction<E5, D> name, D value) {
        return gt(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <D extends Date> L gt5(SerializableFunction<E5, D> name, D value, Predicate<D> ignoreStrategy) {
        return gt(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L gt5(SerializableFunction<E5, LocalTime> name, LocalTime value) {
        return gt(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L gt5(SerializableFunction<E5, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return gt(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L gt5(SerializableFunction<E5, LocalDate> name, LocalDate value) {
        return gt(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L gt5(SerializableFunction<E5, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return gt(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L gt5(SerializableFunction<E5, LocalDateTime> name, LocalDateTime value) {
        return gt(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L gt5(SerializableFunction<E5, LocalDateTime> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return gt(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L gt5(SerializableFunction<E5, String> name, String value) {
        return gt(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L gt5(SerializableFunction<E5, String> name, String value, Predicate<String> ignoreStrategy) {
        return gt(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L gt5(SerializableToIntFunction<E5> name, int value) {
        return gt(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L gt5(SerializableToIntFunction<E5> name, int value, IntPredicate ignoreStrategy) {
        return gt(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L gt5(SerializableToLongFunction<E5> name, long value) {
        return gt(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L gt5(SerializableToLongFunction<E5> name, long value, LongPredicate ignoreStrategy) {
        return gt(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L gt5(SerializableToDoubleFunction<E5> name, double value) {
        return gt(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L gt5(SerializableToDoubleFunction<E5> name, double value, DoublePredicate ignoreStrategy) {
        return gt(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    @Override
    public <E extends Enum<E>> L gt5(SerializableEnumSupplier<E> property, E value) {
        return gt(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <E extends Enum<E>> L gt5(SerializableEnumSupplier<E> property, E value, Predicate<E> ignoreStrategy) {
        return gt(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L gt5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return gt(classMapping5, property, value, matchStrategy, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L gt5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return gt(classMapping5, property, value, matchStrategy, tableAlias5, ignoreStrategy);
    }

    @Override
    public <N extends Number> L gt5(SerializableNumberSupplier<N> property, N value) {
        return gt(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <N extends Number> L gt5(SerializableNumberSupplier<N> property, N value, Predicate<N> ignoreStrategy) {
        return gt(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public <D extends Date> L gt5(SerializableDateSupplier<D> property, D value) {
        return gt(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <D extends Date> L gt5(SerializableDateSupplier<D> property, D value, Predicate<D> ignoreStrategy) {
        return gt(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L gt5(SerializableLocalDateSupplier property, LocalDate value) {
        return gt(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L gt5(SerializableLocalDateSupplier property, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return gt(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L gt5(SerializableLocalTimeSupplier property, LocalTime value) {
        return gt(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L gt5(SerializableLocalTimeSupplier property, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return gt(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L gt5(SerializableLocalDateTimeSupplier property, LocalDateTime value) {
        return gt(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L gt5(SerializableLocalDateTimeSupplier property, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return gt(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L gt5(SerializableStringSupplier property, String value) {
        return gt(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L gt5(SerializableStringSupplier property, String value, Predicate<String> ignoreStrategy) {
        return gt(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L gt5(SerializableIntSupplier property, int value) {
        return gt(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L gt5(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy) {
        return gt(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L gt5(SerializableLongSupplier property, long value) {
        return gt(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L gt5(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy) {
        return gt(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L gt5(SerializableDoubleSupplier property, double value) {
        return gt(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L gt5(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy) {
        return gt(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L le5(SerializableFunction<E5, N> name, N value) {
        return le(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <N extends Number> L le5(SerializableFunction<E5, N> name, N value, Predicate<N> ignoreStrategy) {
        return le(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public <D extends Date> L le5(SerializableFunction<E5, D> name, D value) {
        return le(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <D extends Date> L le5(SerializableFunction<E5, D> name, D value, Predicate<D> ignoreStrategy) {
        return le(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L le5(SerializableFunction<E5, LocalTime> name, LocalTime value) {
        return le(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L le5(SerializableFunction<E5, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return le(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L le5(SerializableFunction<E5, LocalDate> name, LocalDate value) {
        return le(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L le5(SerializableFunction<E5, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return le(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L le5(SerializableFunction<E5, LocalDateTime> name, LocalDateTime value) {
        return le(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L le5(SerializableFunction<E5, LocalDateTime> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return le(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L le5(SerializableFunction<E5, String> name, String value) {
        return le(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L le5(SerializableFunction<E5, String> name, String value, Predicate<String> ignoreStrategy) {
        return le(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public <E extends Enum<E>> L le5(SerializableFunction<E5, E> name, E value) {
        return le(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <E extends Enum<E>> L le5(SerializableFunction<E5, E> name, E value, Predicate<E> ignoreStrategy) {
        return le(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L le5(SerializableFunction<E5, String> name, String value, MatchStrategy matchStrategy) {
        return le(classMapping5, name, value, matchStrategy, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L le5(SerializableFunction<E5, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return le(classMapping5, name, value, matchStrategy, tableAlias5, ignoreStrategy);
    }

    @Override
    public L le5(SerializableToIntFunction<E5> name, int value) {
        return le(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L le5(SerializableToIntFunction<E5> name, int value, IntPredicate ignoreStrategy) {
        return le(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L le5(SerializableToLongFunction<E5> name, long value) {
        return le(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L le5(SerializableToLongFunction<E5> name, long value, LongPredicate ignoreStrategy) {
        return le(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L le5(SerializableToDoubleFunction<E5> name, double value) {
        return le(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L le5(SerializableToDoubleFunction<E5> name, double value, DoublePredicate ignoreStrategy) {
        return le(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    @Override
    public <E extends Enum<E>> L le5(SerializableEnumSupplier<E> property, E value) {
        return le(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <E extends Enum<E>> L le5(SerializableEnumSupplier<E> property, E value, Predicate<E> ignoreStrategy) {
        return le(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L le5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return le(classMapping5, property, matchStrategy, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L le5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return le(classMapping5, property, matchStrategy, tableAlias5, ignoreStrategy);
    }

    @Override
    public <D extends Date> L le5(SerializableDateSupplier<D> property, D value) {
        return le(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <D extends Date> L le5(SerializableDateSupplier<D> property, D value, Predicate<D> ignoreStrategy) {
        return le(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public <N extends Number> L le5(SerializableNumberSupplier<N> property, N value) {
        return le(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <N extends Number> L le5(SerializableNumberSupplier<N> property, N value, Predicate<N> ignoreStrategy) {
        return le(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L le5(SerializableLocalDateSupplier property, LocalDate value) {
        return le(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L le5(SerializableLocalDateSupplier property, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return le(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L le5(SerializableLocalTimeSupplier property, LocalTime value) {
        return le(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L le5(SerializableLocalTimeSupplier property, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return le(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L le5(SerializableLocalDateTimeSupplier property, LocalDateTime value) {
        return le(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L le5(SerializableLocalDateTimeSupplier property, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return le(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L le5(SerializableStringSupplier property, String value) {
        return le(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L le5(SerializableStringSupplier property, String value, Predicate<String> ignoreStrategy) {
        return le(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L le5(SerializableIntSupplier property, int value) {
        return le(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L le5(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy) {
        return le(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L le5(SerializableLongSupplier property, long value) {
        return le(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L le5(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy) {
        return le(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L le5(SerializableDoubleSupplier property, double value) {
        return le(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L le5(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy) {
        return le(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L lt5(SerializableFunction<E5, N> name, N value) {
        return lt(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <N extends Number> L lt5(SerializableFunction<E5, N> name, N value, Predicate<N> ignoreStrategy) {
        return lt(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public <E extends Enum<E>> L lt5(SerializableFunction<E5, E> name, E value) {
        return lt(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <E extends Enum<E>> L lt5(SerializableFunction<E5, E> name, E value, Predicate<E> ignoreStrategy) {
        return lt(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public <D extends Date> L lt5(SerializableFunction<E5, D> name, D value) {
        return lt(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <D extends Date> L lt5(SerializableFunction<E5, D> name, D value, Predicate<D> ignoreStrategy) {
        return lt(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L lt5(SerializableFunction<E5, LocalTime> name, LocalTime value) {
        return lt(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L lt5(SerializableFunction<E5, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return lt(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L lt5(SerializableFunction<E5, LocalDate> name, LocalDate value) {
        return lt(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L lt5(SerializableFunction<E5, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return lt(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L lt5(SerializableFunction<E5, LocalDateTime> name, LocalDateTime value) {
        return lt(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L lt5(SerializableFunction<E5, LocalDateTime> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return lt(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L lt5(SerializableFunction<E5, String> name, String value) {
        return lt(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L lt5(SerializableFunction<E5, String> name, String value, Predicate<String> ignoreStrategy) {
        return lt(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L lt5(SerializableFunction<E5, String> name, String value, MatchStrategy matchStrategy) {
        return lt(classMapping5, name, value, matchStrategy, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L lt5(SerializableFunction<E5, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return lt(classMapping5, name, value, matchStrategy, tableAlias5, ignoreStrategy);
    }

    @Override
    public L lt5(SerializableToIntFunction<E5> name, int value) {
        return lt(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L lt5(SerializableToIntFunction<E5> name, int value, IntPredicate ignoreStrategy) {
        return lt(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L lt5(SerializableToLongFunction<E5> name, long value) {
        return lt(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L lt5(SerializableToLongFunction<E5> name, long value, LongPredicate ignoreStrategy) {
        return lt(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L lt5(SerializableToDoubleFunction<E5> name, double value) {
        return lt(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L lt5(SerializableToDoubleFunction<E5> name, double value, DoublePredicate ignoreStrategy) {
        return lt(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    @Override
    public <E extends Enum<E>> L lt5(SerializableEnumSupplier<E> property, E value) {
        return lt(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <E extends Enum<E>> L lt5(SerializableEnumSupplier<E> property, E value, Predicate<E> ignoreStrategy) {
        return lt(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L lt5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return lt(classMapping5, property, matchStrategy, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L lt5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return lt(classMapping5, property, matchStrategy, tableAlias5, ignoreStrategy);
    }

    @Override
    public <R extends Number> L lt5(SerializableNumberSupplier<R> property, R value) {
        return lt(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <R extends Number> L lt5(SerializableNumberSupplier<R> property, R value, Predicate<R> ignoreStrategy) {
        return lt(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public <R extends Date> L lt5(SerializableDateSupplier<R> property, R value) {
        return lt(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <R extends Date> L lt5(SerializableDateSupplier<R> property, R value, Predicate<R> ignoreStrategy) {
        return lt(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L lt5(SerializableLocalDateSupplier property, LocalDate value) {
        return lt(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L lt5(SerializableLocalDateSupplier property, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return lt(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L lt5(SerializableLocalTimeSupplier property, LocalTime value) {
        return lt(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L lt5(SerializableLocalTimeSupplier property, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return lt(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L lt5(SerializableLocalDateTimeSupplier property, LocalDateTime value) {
        return lt(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L lt5(SerializableLocalDateTimeSupplier property, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return lt(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L lt5(SerializableStringSupplier property, String value) {
        return lt(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L lt5(SerializableStringSupplier property, String value, Predicate<String> ignoreStrategy) {
        return lt(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L lt5(SerializableIntSupplier property, int value) {
        return lt(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L lt5(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy) {
        return lt(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L lt5(SerializableLongSupplier property, long value) {
        return lt(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L lt5(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy) {
        return lt(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L lt5(SerializableDoubleSupplier property, double value) {
        return lt(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L lt5(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy) {
        return lt(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <R extends Serializable> L in5(SerializableFunction<E5, R> name, R value) {
        return in(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <R extends Serializable> L in5(SerializableFunction<E5, R> name, R value, Predicate<R> ignoreStrategy) {
        return in(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public <R extends Serializable> L in5(SerializableFunction<E5, R> name, @SuppressWarnings("unchecked") R... value) {
        return in(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <R extends Serializable> L in5(SerializableFunction<E5, R> name, R[] value, Predicate<R[]> ignoreStrategy) {
        return in(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public <R extends Serializable> L in5(SerializableFunction<E5, R> name, Collection<R> value) {
        return in(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <R extends Serializable> L in5(SerializableFunction<E5, R> name, Collection<R> value,
        Predicate<Collection<R>> ignoreStrategy) {
        return in(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L in5(SerializableToStringFunction<E5> name, String value, MatchStrategy matchStrategy) {
        return in(classMapping5, name, value, matchStrategy, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L in5(SerializableToStringFunction<E5> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return in(classMapping5, name, value, matchStrategy, tableAlias5, ignoreStrategy);
    }

    @Override
    public L in5(SerializableToStringFunction<E5> name, String[] value, MatchStrategy matchStrategy) {
        return in(classMapping5, name, value, matchStrategy, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L in5(SerializableToStringFunction<E5> name, String[] value, MatchStrategy matchStrategy,
        Predicate<String[]> ignoreStrategy) {
        return in(classMapping5, name, value, matchStrategy, tableAlias5, ignoreStrategy);
    }

    @Override
    public L in5(SerializableToIntFunction<E5> name, int value) {
        return in(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L in5(SerializableToIntFunction<E5> name, int value, IntPredicate ignoreStrategy) {
        return in(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L in5(SerializableToLongFunction<E5> name, long value) {
        return in(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L in5(SerializableToLongFunction<E5> name, long value, LongPredicate ignoreStrategy) {
        return in(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L in5(SerializableToDoubleFunction<E5> name, double value) {
        return in(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L in5(SerializableToDoubleFunction<E5> name, double value, DoublePredicate ignoreStrategy) {
        return in(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L in5(SerializableToIntFunction<E5> name, int... value) {
        return in(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L in5(SerializableToLongFunction<E5> name, long... value) {
        return in(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L in5(SerializableToDoubleFunction<E5> name, double... value) {
        return in(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L in5(SerializableToDoubleFunction<E5> name, double[] value, Predicate<double[]> ignoreStrategy) {
        return in(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L in5(SerializableToIntFunction<E5> name, int[] value, Predicate<int[]> ignoreStrategy) {
        return in(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L in5(SerializableToLongFunction<E5> name, long[] value, Predicate<long[]> ignoreStrategy) {
        return in(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L in5(SerializableSupplier<R> property, R value) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return in(classMapping5.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), value,
            tableAlias5, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L in5(SerializableSupplier<R> property, @SuppressWarnings("unchecked") R... value) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return in(classMapping5.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), value,
            tableAlias5, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L in5(SerializableSupplier<R> property, R value, Predicate<R> ignoreStrategy) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return in(classMapping5.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), value,
            tableAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L in5(SerializableSupplier<R> property, R[] value, Predicate<R[]> ignoreStrategy) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return in(classMapping5.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), value,
            tableAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in5(SerializableIntSupplier property, int value) {
        return in(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L in5(SerializableIntSupplier property, int... value) {
        return in(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in5(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy) {
        return in(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in5(SerializableIntSupplier property, int[] value, Predicate<int[]> ignoreStrategy) {
        return in(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in5(SerializableLongSupplier property, long value) {
        return in(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L in5(SerializableLongSupplier property, long... value) {
        return in(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in5(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy) {
        return in(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in5(SerializableLongSupplier property, long[] value, Predicate<long[]> ignoreStrategy) {
        return in(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in5(SerializableDoubleSupplier property, double value) {
        return in(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L in5(SerializableDoubleSupplier property, double... value) {
        return in(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in5(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy) {
        return in(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L in5(SerializableDoubleSupplier property, double[] value, Predicate<double[]> ignoreStrategy) {
        return in(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return in(classMapping5, property, value, matchStrategy, tableAlias5, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in5(SerializableStringSupplier property, String[] value, MatchStrategy matchStrategy) {
        return in(classMapping5, property, value, matchStrategy, tableAlias5, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return in(classMapping5, property, value, matchStrategy, tableAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in5(SerializableStringSupplier property, String[] value, MatchStrategy matchStrategy,
        Predicate<String[]> ignoreStrategy) {
        return in(classMapping5, property, value, matchStrategy, tableAlias5, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni5(SerializableFunction<E5, R> name, R value) {
        return ni(classMapping5.getPropertyMapping(getPropertyName(name)), value, tableAlias5, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni5(SerializableFunction<E5, R> name, R value, Predicate<R> ignoreStrategy) {
        return ni(classMapping5.getPropertyMapping(getPropertyName(name)), value, tableAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni5(SerializableFunction<E5, R> name, @SuppressWarnings("unchecked") R... value) {
        return ni(classMapping5.getPropertyMapping(getPropertyName(name)), value, tableAlias5, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni5(SerializableFunction<E5, R> name, R[] value, Predicate<R[]> ignoreStrategy) {
        return ni(classMapping5.getPropertyMapping(getPropertyName(name)), value, tableAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni5(SerializableFunction<E5, R> name, Collection<R> value) {
        return ni(classMapping5.getPropertyMapping(getPropertyName(name)), value, tableAlias5,
            getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni5(SerializableFunction<E5, R> name, Collection<R> value,
        Predicate<Collection<R>> ignoreStrategy) {
        return ni(classMapping5.getPropertyMapping(getPropertyName(name)), value, tableAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni5(SerializableToIntFunction<E5> name, int value) {
        return ni(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni5(SerializableToIntFunction<E5> name, int value, IntPredicate ignoreStrategy) {
        return ni(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni5(SerializableToLongFunction<E5> name, long value) {
        return ni(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni5(SerializableToLongFunction<E5> name, long value, LongPredicate ignoreStrategy) {
        return ni(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni5(SerializableToDoubleFunction<E5> name, double value) {
        return ni(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni5(SerializableToDoubleFunction<E5> name, double value, DoublePredicate ignoreStrategy) {
        return ni(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni5(SerializableToIntFunction<E5> name, int... value) {
        return ni(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni5(SerializableToLongFunction<E5> name, long... value) {
        return ni(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni5(SerializableToDoubleFunction<E5> name, double... value) {
        return ni(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni5(SerializableToIntFunction<E5> name, int[] value, Predicate<int[]> ignoreStrategy) {
        return ni(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni5(SerializableToLongFunction<E5> name, long[] value, Predicate<long[]> ignoreStrategy) {
        return ni(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni5(SerializableToDoubleFunction<E5> name, double[] value, Predicate<double[]> ignoreStrategy) {
        return ni(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni5(SerializableSupplier<R> property, R value) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ni(classMapping5.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), value,
            tableAlias5, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni5(SerializableSupplier<R> property, @SuppressWarnings("unchecked") R... value) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ni(classMapping5.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), value,
            tableAlias5, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni5(SerializableSupplier<R> property, R value, Predicate<R> ignoreStrategy) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ni(classMapping5.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), value,
            tableAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni5(SerializableSupplier<R> property, R[] value, Predicate<R[]> ignoreStrategy) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ni(classMapping5.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), value,
            tableAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni5(SerializableIntSupplier property, int value) {
        return ni(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L ni5(SerializableIntSupplier name, int... value) {
        return ni(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni5(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy) {
        return ni(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L ni5(SerializableIntSupplier name, int[] value, Predicate<int[]> ignoreStrategy) {
        return ni(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni5(SerializableLongSupplier property, long value) {
        return ni(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L ni5(SerializableLongSupplier property, long... value) {
        return ni(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni5(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy) {
        return ni(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L ni5(SerializableLongSupplier name, long[] value, Predicate<long[]> ignoreStrategy) {
        return ni(classMapping5, name, value, tableAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni5(SerializableDoubleSupplier property, double value) {
        return ni(classMapping5, property, value, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L ni5(SerializableDoubleSupplier name, double... value) {
        return ni(classMapping5, name, value, tableAlias5, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni5(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy) {
        return ni(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    @Override
    public L ni5(SerializableDoubleSupplier property, double[] value, Predicate<double[]> ignoreStrategy) {
        return ni(classMapping5, property, value, tableAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni5(SerializableToStringFunction<E5> name, String value, MatchStrategy matchStrategy) {
        return ni(classMapping5, name, value, matchStrategy, tableAlias5, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni5(SerializableToStringFunction<E5> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ni(classMapping5, name, value, matchStrategy, tableAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni5(SerializableToStringFunction<E5> name, String[] value, MatchStrategy matchStrategy) {
        return ni(classMapping5, name, value, matchStrategy, tableAlias5, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni5(SerializableToStringFunction<E5> name, String[] value, MatchStrategy matchStrategy,
        Predicate<String[]> ignoreStrategy) {
        return ni(classMapping5, name, value, matchStrategy, tableAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return ni(classMapping5, property, value, matchStrategy, tableAlias5, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni5(SerializableStringSupplier property, String[] value, MatchStrategy matchStrategy) {
        return ni(classMapping5, property, value, matchStrategy, tableAlias5, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ni(classMapping5, property, value, matchStrategy, tableAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni5(SerializableStringSupplier property, String[] value, MatchStrategy matchStrategy,
        Predicate<String[]> ignoreStrategy) {
        return ni(classMapping5, property, value, matchStrategy, tableAlias5, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L ba5(SerializableToIntFunction<E5> name, int min, int max) {
        return ba(classMapping5, name, min, max, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L ba5(SerializableToIntFunction<E5> name, int min, int max, BiPredicate<Integer, Integer> ignoreStrategy) {
        return ba(classMapping5, name, min, max, tableAlias5, ignoreStrategy);
    }

    @Override
    public L ba5(SerializableToLongFunction<E5> name, long min, long max) {
        return ba(classMapping5, name, min, max, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L ba5(SerializableToLongFunction<E5> name, long min, long max, BiPredicate<Long, Long> ignoreStrategy) {
        return ba(classMapping5, name, min, max, tableAlias5, ignoreStrategy);
    }

    @Override
    public L ba5(SerializableToDoubleFunction<E5> name, double min, double max) {
        return ba(classMapping5, name, min, max, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L ba5(SerializableToDoubleFunction<E5> name, double min, double max,
        BiPredicate<Double, Double> ignoreStrategy) {
        return ba(classMapping5, name, min, max, tableAlias5, ignoreStrategy);
    }

    @Override
    public <N extends Number> L ba5(SerializableToNumberFunction<E5, N> name, N min, N max) {
        return ba(classMapping5, name, min, max, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <N extends Number> L ba5(SerializableToNumberFunction<E5, N> name, N min, N max,
        BiPredicate<N, N> ignoreStrategy) {
        return ba(classMapping5, name, min, max, tableAlias5, ignoreStrategy);
    }

    @Override
    public <D extends Date> L ba5(SerializableToDateFunction<E5, D> name, D min, D max) {
        return ba(classMapping5, name, min, max, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <D extends Date> L ba5(SerializableToDateFunction<E5, D> name, D min, D max,
        BiPredicate<D, D> ignoreStrategy) {
        return ba(classMapping5, name, min, max, tableAlias5, ignoreStrategy);
    }

    @Override
    public <E extends Enum<E>> L ba5(SerializableToEnumFunction<E5, E> name, E min, E max) {
        return ba(classMapping5, name, min, max, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <E extends Enum<E>> L ba5(SerializableToEnumFunction<E5, E> name, E min, E max,
        BiPredicate<E, E> ignoreStrategy) {
        return ba(classMapping5, name, min, max, tableAlias5, ignoreStrategy);
    }

    @Override
    public L ba5(SerializableToLocalTimeFunction<E5> name, LocalTime min, LocalTime max) {
        return ba(classMapping5, name, min, max, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L ba5(SerializableToLocalTimeFunction<E5> name, LocalTime min, LocalTime max,
        BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return ba(classMapping5, name, min, max, tableAlias5, ignoreStrategy);
    }

    @Override
    public L ba5(SerializableToLocalDateFunction<E5> name, LocalDate min, LocalDate max) {
        return ba(classMapping5, name, min, max, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L ba5(SerializableToLocalDateFunction<E5> name, LocalDate min, LocalDate max,
        BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return ba(classMapping5, name, min, max, tableAlias5, ignoreStrategy);
    }

    @Override
    public L ba5(SerializableToLocalDateTimeFunction<E5> name, LocalDateTime min, LocalDateTime max) {
        return ba(classMapping5, name, min, max, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L ba5(SerializableToLocalDateTimeFunction<E5> name, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return ba(classMapping5, name, min, max, tableAlias5, ignoreStrategy);
    }

    @Override
    public L ba5(SerializableToStringFunction<E5> name, String min, String max) {
        return ba(classMapping5, name, min, max, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L ba5(SerializableToStringFunction<E5> name, String min, String max,
        BiPredicate<String, String> ignoreStrategy) {
        return ba(classMapping5, name, min, max, tableAlias5, ignoreStrategy);
    }

    // --------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ba5(SerializableNumberSupplier<N> property, N min, N max) {
        return ba(classMapping5, property, min, max, tableAlias5, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ba5(SerializableNumberSupplier<N> name, N min, N max,
        BiPredicate<N, N> ignoreStrategy) {
        return ba(classMapping5, name, min, max, tableAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ba5(SerializableDateSupplier<D> property, D min, D max) {
        return ba(classMapping5, property, min, max, tableAlias5, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ba5(SerializableDateSupplier<D> property, D min, D max,
        BiPredicate<D, D> ignoreStrategy) {
        return ba(classMapping5, property, min, max, tableAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba5(SerializableLocalTimeSupplier property, LocalTime min, LocalTime max) {
        return ba(classMapping5, property, min, max, tableAlias5, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba5(SerializableLocalTimeSupplier property, LocalTime min, LocalTime max,
        BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return ba(classMapping5, property, min, max, tableAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba5(SerializableLocalDateSupplier property, LocalDate min, LocalDate max) {
        return ba(classMapping5, property, min, max, tableAlias5, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba5(SerializableLocalDateSupplier property, LocalDate min, LocalDate max,
        BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return ba(classMapping5, property, min, max, tableAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba5(SerializableLocalDateTimeSupplier property, LocalDateTime min, LocalDateTime max) {
        return ba(classMapping5, property, min, max, tableAlias5, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba5(SerializableLocalDateTimeSupplier property, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return ba(classMapping5, property, min, max, tableAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba5(SerializableStringSupplier property, String min, String max) {
        return ba(classMapping5, property, min, max, tableAlias5, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba5(SerializableStringSupplier property, String min, String max,
        BiPredicate<String, String> ignoreStrategy) {
        return ba(classMapping5, property, min, max, tableAlias5, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L nba5(SerializableToIntFunction<E5> name, int min, int max) {
        return nba(classMapping5, name, min, max, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L nba5(SerializableToIntFunction<E5> name, int min, int max, BiPredicate<Integer, Integer> ignoreStrategy) {
        return nba(classMapping5, name, min, max, tableAlias5, ignoreStrategy);
    }

    @Override
    public L nba5(SerializableToLongFunction<E5> name, long min, long max) {
        return nba(classMapping5, name, min, max, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L nba5(SerializableToLongFunction<E5> name, long min, long max, BiPredicate<Long, Long> ignoreStrategy) {
        return nba(classMapping5, name, min, max, tableAlias5, ignoreStrategy);
    }

    @Override
    public L nba5(SerializableToDoubleFunction<E5> name, double min, double max) {
        return nba(classMapping5, name, min, max, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L nba5(SerializableToDoubleFunction<E5> name, double min, double max,
        BiPredicate<Double, Double> ignoreStrategy) {
        return nba(classMapping5, name, min, max, tableAlias5, ignoreStrategy);
    }

    @Override
    public <N extends Number> L nba5(SerializableToNumberFunction<E5, N> name, N min, N max) {
        return nba(classMapping5, name, min, max, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <N extends Number> L nba5(SerializableToNumberFunction<E5, N> name, N min, N max,
        BiPredicate<N, N> ignoreStrategy) {
        return nba(classMapping5, name, min, max, tableAlias5, ignoreStrategy);
    }

    @Override
    public <D extends Date> L nba5(SerializableToDateFunction<E5, D> name, D min, D max) {
        return nba(classMapping5, name, min, max, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <D extends Date> L nba5(SerializableToDateFunction<E5, D> name, D min, D max,
        BiPredicate<D, D> ignoreStrategy) {
        return nba(classMapping5, name, min, max, tableAlias5, ignoreStrategy);
    }

    @Override
    public <E extends Enum<E>> L nba5(SerializableToEnumFunction<E5, E> name, E min, E max) {
        return nba(classMapping5, name, min, max, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public <E extends Enum<E>> L nba5(SerializableToEnumFunction<E5, E> name, E min, E max,
        BiPredicate<E, E> ignoreStrategy) {
        return nba(classMapping5, name, min, max, tableAlias5, ignoreStrategy);
    }

    @Override
    public L nba5(SerializableToLocalTimeFunction<E5> name, LocalTime min, LocalTime max) {
        return nba(classMapping5, name, min, max, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L nba5(SerializableToLocalTimeFunction<E5> name, LocalTime min, LocalTime max,
        BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return nba(classMapping5, name, min, max, tableAlias5, ignoreStrategy);
    }

    @Override
    public L nba5(SerializableToLocalDateFunction<E5> name, LocalDate min, LocalDate max) {
        return nba(classMapping5, name, min, max, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L nba5(SerializableToLocalDateFunction<E5> name, LocalDate min, LocalDate max,
        BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return nba(classMapping5, name, min, max, tableAlias5, ignoreStrategy);
    }

    @Override
    public L nba5(SerializableToLocalDateTimeFunction<E5> name, LocalDateTime min, LocalDateTime max) {
        return nba(classMapping5, name, min, max, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L nba5(SerializableToLocalDateTimeFunction<E5> name, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return nba(classMapping5, name, min, max, tableAlias5, ignoreStrategy);
    }

    @Override
    public L nba5(SerializableToStringFunction<E5> name, String min, String max) {
        return nba(classMapping5, name, min, max, tableAlias5, getIgnoreStrategy());
    }

    @Override
    public L nba5(SerializableToStringFunction<E5> name, String min, String max,
        BiPredicate<String, String> ignoreStrategy) {
        return nba(classMapping5, name, min, max, tableAlias5, ignoreStrategy);
    }

    // --------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L nba5(SerializableNumberSupplier<N> property, N min, N max) {
        return nba(classMapping5, property, min, max, tableAlias5, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L nba5(SerializableNumberSupplier<N> name, N min, N max,
        BiPredicate<N, N> ignoreStrategy) {
        return nba(classMapping5, name, min, max, tableAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L nba5(SerializableDateSupplier<D> property, D min, D max) {
        return nba(classMapping5, property, min, max, tableAlias5, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L nba5(SerializableDateSupplier<D> property, D min, D max,
        BiPredicate<D, D> ignoreStrategy) {
        return nba(classMapping5, property, min, max, tableAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba5(SerializableLocalTimeSupplier property, LocalTime min, LocalTime max) {
        return nba(classMapping5, property, min, max, tableAlias5, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba5(SerializableLocalTimeSupplier property, LocalTime min, LocalTime max,
        BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return nba(classMapping5, property, min, max, tableAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba5(SerializableLocalDateSupplier property, LocalDate min, LocalDate max) {
        return nba(classMapping5, property, min, max, tableAlias5, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba5(SerializableLocalDateSupplier property, LocalDate min, LocalDate max,
        BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return nba(classMapping5, property, min, max, tableAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba5(SerializableLocalDateTimeSupplier property, LocalDateTime min, LocalDateTime max) {
        return nba(classMapping5, property, min, max, tableAlias5, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba5(SerializableLocalDateTimeSupplier property, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return nba(classMapping5, property, min, max, tableAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba5(SerializableStringSupplier property, String min, String max) {
        return nba(classMapping5, property, min, max, tableAlias5, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba5(SerializableStringSupplier property, String min, String max,
        BiPredicate<String, String> ignoreStrategy) {
        return nba(classMapping5, property, min, max, tableAlias5, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <R> L inn5(SerializableFunction<E5, R> name, Boolean value) {
        return inn(classMapping5, name, value, tableAlias5);
    }

    @Override
    public <R> L inn5(SerializableSupplier<R> name, Boolean value) {
        return inn(classMapping5, name, value, tableAlias5);
    }

    @Override
    public <R> L isn5(SerializableFunction<E5, R> name, Boolean value) {
        return isn(classMapping5, name, value, tableAlias5);
    }

    @Override
    public <R> L isn5(SerializableSupplier<R> name, Boolean value) {
        return isn(classMapping5, name, value, tableAlias5);
    }

    // ****************************************************************************************************************
    // property
    // ****************************************************************************************************************
    @Override
    @SuppressWarnings("unchecked")
    public L property(FiveArgusFunction<EntityPropertyExpression<E1, ?, ?>, EntityPropertyExpression<E2, ?, ?>,
        EntityPropertyExpression<E3, ?, ?>, EntityPropertyExpression<E4, ?, ?>, EntityPropertyExpression<E5, ?, ?>,
        LogicExpression<?, ?>> entitiesPropertyFunction) {
        return (L) entitiesPropertyFunction.apply(
            new EntityPropertyOnlyExpressionImpl<>(0, this, factory, entityRelation),
            new EntityPropertyOnlyExpressionImpl<>(1, this, factory, entityRelation),
            new EntityPropertyOnlyExpressionImpl<>(2, this, factory, entityRelation),
            new EntityPropertyOnlyExpressionImpl<>(3, this, factory, entityRelation),
            new EntityPropertyOnlyExpressionImpl<>(4, this, factory, entityRelation));
    }

    // ********************************************************************
    // private method
    // ********************************************************************

    // ********************************************************************
    // protected method
    // ********************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    protected int getIndex() {
        return 4;
    }
}
