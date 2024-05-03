
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity;

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
import cn.featherfly.common.function.ThreeArgusFunction;
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
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction3;
import cn.featherfly.common.function.serializable.SerializableToEnumFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction3;
import cn.featherfly.common.function.serializable.SerializableToLocalDateFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction3;
import cn.featherfly.common.function.serializable.SerializableToNumberFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.config.dsl.ConditionConfig;
import cn.featherfly.hammer.expression.condition.GroupEndExpression;
import cn.featherfly.hammer.expression.condition.GroupExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityPropertyOnlyExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlRelation.EntityRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.EntityPropertyOnlyExpressionImpl;

/**
 * sql condition group expression 3. sql条件逻辑组表达式3.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <E3> third filterable entity type
 * @param <C>  condition expression
 * @param <L>  logic expression
 * @param <C2> condition config
 * @param <ER> entity sql relation
 * @param <B>  sql builder
 */
public abstract class AbstractMulitiEntitySqlConditionsGroupExpressionBase3<E1, E2, E3, C extends GroupExpression<C, L>,
    L extends GroupEndExpression<C, L>, C2 extends ConditionConfig<C2>, ER extends EntitySqlRelation<ER, B>,
    B extends SqlBuilder> extends AbstractMulitiEntitySqlConditionsGroupExpressionBase2<E1, E2, C, L, C2, ER, B>
//        implements EntityBetweenExpressionBase3<T1, T2, T3, C, L>, EntityNotBetweenExpressionBase3<T1, T2, T3, C, L> //
//        , EntityContainsExpressionBase3<T1, T2, T3, C, L>, EntityNotContainsExpressionBase3<T1, T2, T3, C, L> //
//        , EntityEndWithExpressionBase3<T1, T2, T3, C, L>, EntityNotEndWithExpressionBase3<T1, T2, T3, C, L>//
//        , EntityEqualsExpressionBase3<T1, T2, T3, C, L>, EntityNotEqualsExpressionBase3<T1, T2, T3, C, L>//
//        , EntityGreatEqualsExpressionBase3<T1, T2, T3, C, L>, EntityGreatThanExpressionBase3<T1, T2, T3, C, L> //
//        , EntityInExpressionBase3<T1, T2, T3, C, L>, EntityNotInExpressionBase3<T1, T2, T3, C, L>//
//        , EntityIsNotNullExpressionBase3<T1, T2, T3, C, L>, EntityIsNullExpressionBase3<T1, T2, T3, C, L> //
//        , EntityLessEqualsExpressionBase3<T1, T2, T3, C, L>, EntityLessThanExpressionBase3<T1, T2, T3, C, L> //
//        , EntityStartWithExpressionBase3<T1, T2, T3, C, L>, EntityNotStartWithExpressionBase3<T1, T2, T3, C, L> //
//        , EntityLikeExpressionBase3<T1, T2, T3, C, L>, EntityNotLikeExpressionBase3<T1, T2, T3, C, L>//
//        , EntityPropertyExpression3<T1, T2, T3, C, L> //
// 这里注释掉是为了编译速度
{

    /** The class mapping. */
    protected JdbcClassMapping<E3> classMapping3;

    /** The query alias 3. */
    protected String queryAlias3;

    /**
     * Instantiates a new abstract entity sql condition group expression base 3.
     *
     * @param parent            the parent
     * @param factory           the factory
     * @param entitySqlRelation the entity sql relation
     */
    @SuppressWarnings("unchecked")
    protected AbstractMulitiEntitySqlConditionsGroupExpressionBase3(L parent, JdbcMappingFactory factory,
        ER entitySqlRelation) {
        super(parent, factory, entitySqlRelation);
        EntityRelation<?> erm = entitySqlRelation.getEntityRelationTuple().getOrNull2();
        classMapping3 = (JdbcClassMapping<E3>) erm.getClassMapping();
        queryAlias3 = erm.getTableAlias();
    }

    // ****************************************************************************************************************
    //  eq
    // ****************************************************************************************************************

    /**
     * Eq 3.
     *
     * @param <R>   the generic type
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public <R> L eq3(SerializableFunction<E3, R> name, R value) {
        return eq(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Eq 3.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <R> L eq3(SerializableFunction<E3, R> name, R value, Predicate<R> ignoreStrategy) {
        return eq(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Eq 3.
     *
     * @param <D>   the generic type
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public <D extends Date> L eq3(SerializableToDateFunction<E3, D> name, D value) {
        return eq(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Eq 3.
     *
     * @param <D>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <D extends Date> L eq3(SerializableToDateFunction<E3, D> name, D value, Predicate<D> ignoreStrategy) {
        return eq(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Eq 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L eq3(SerializableToDoubleFunction<E3> name, double value) {
        return eq(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Eq 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L eq3(SerializableToDoubleFunction<E3> name, double value, DoublePredicate ignoreStrategy) {
        return eq(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Eq 3.
     *
     * @param <E>   the element type
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public <E extends Enum<E>> L eq3(SerializableToEnumFunction<E3, E> name, E value) {
        return eq(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Eq 3.
     *
     * @param <E>            the element type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <E extends Enum<E>> L eq3(SerializableToEnumFunction<E3, E> name, E value, Predicate<E> ignoreStrategy) {
        return eq(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Eq 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L eq3(SerializableToCharFunction<E3> name, char value) {
        return eq(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Eq 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L eq3(SerializableToCharFunction<E3> name, char value, CharPredicate ignoreStrategy) {
        return eq(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Eq 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L eq3(SerializableToIntFunction<E3> name, int value) {
        return eq(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Eq 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L eq3(SerializableToIntFunction<E3> name, int value, IntPredicate ignoreStrategy) {
        return eq(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Eq 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L eq3(SerializableToLocalDateFunction<E3> name, LocalDate value) {
        return eq(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Eq 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L eq3(SerializableToLocalDateFunction<E3> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return eq(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Eq 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L eq3(SerializableToLocalDateTimeFunction<E3> name, LocalDateTime value) {
        return eq(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Eq 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L eq3(SerializableToLocalDateTimeFunction<E3> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return eq(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Eq 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L eq3(SerializableToLocalTimeFunction<E3> name, LocalTime value) {
        return eq(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Eq 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L eq3(SerializableToLocalTimeFunction<E3> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return eq(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Eq 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L eq3(SerializableToLongFunction<E3> name, long value) {
        return eq(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Eq 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L eq3(SerializableToLongFunction<E3> name, long value, LongPredicate ignoreStrategy) {
        return eq(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Eq 3.
     *
     * @param <N>   the number type
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public <N extends Number> L eq3(SerializableToNumberFunction<E3, N> name, N value) {
        return eq(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Eq 3.
     *
     * @param <N>            the number type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <N extends Number> L eq3(SerializableToNumberFunction<E3, N> name, N value, Predicate<N> ignoreStrategy) {
        return eq(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Eq 3.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L eq3(SerializableToStringFunction<E3> name, String value, MatchStrategy matchStrategy) {
        return eq(classMapping3, name, value, queryAlias3, matchStrategy, getIgnoreStrategy());
    }

    /**
     * Eq 3.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L eq3(SerializableToStringFunction<E3> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return eq(classMapping3, name, value, queryAlias3, matchStrategy, ignoreStrategy);
    }

    /**
     * Eq 3.
     *
     * @param <R>      the generic type
     * @param property the property
     * @return the l
     */
    public <R extends Date> L eq3(SerializableDateSupplier<R> property) {
        return eq(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Eq 3.
     *
     * @param <R>            the generic type
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <R extends Date> L eq3(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return eq(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Eq 3.
     *
     * @param property the property
     * @return the l
     */
    public L eq3(SerializableDoubleSupplier property) {
        return eq(classMapping3, property, property.getAsDouble(), queryAlias3, getIgnoreStrategy());
    }

    /**
     * Eq 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L eq3(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return eq(classMapping3, property, property.getAsDouble(), queryAlias3, ignoreStrategy);
    }

    /**
     * Eq 3.
     *
     * @param <E>      the element type
     * @param property the property
     * @return the l
     */
    public <E extends Enum<E>> L eq3(SerializableEnumSupplier<E> property) {
        return eq(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Eq 3.
     *
     * @param <E>            the element type
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <E extends Enum<E>> L eq3(SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy) {
        return eq(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Eq 3.
     *
     * @param propertyValue the property value
     * @return the l
     */
    public L eq3(SerializableBooleanSupplier propertyValue) {
        return eq(classMapping3, propertyValue, propertyValue.getAsBoolean(), queryAlias3, getIgnoreStrategy());
    }

    /**
     * Eq 3.
     *
     * @param propertyValue the property value
     * @return the l
     */
    public L eq3(SerializableBoolSupplier propertyValue) {
        return eq(classMapping3, propertyValue, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Eq 3.
     *
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L eq3(SerializableBoolSupplier propertyValue, Predicate<Boolean> ignoreStrategy) {
        return eq(classMapping3, propertyValue, queryAlias3, ignoreStrategy);
    }

    /**
     * Eq 3.
     *
     * @param property the property
     * @return the l
     */
    public L eq3(SerializableCharSupplier property) {
        return eq(classMapping3, property, property.get(), queryAlias3, getIgnoreStrategy());
    }

    /**
     * Eq 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L eq3(SerializableCharSupplier property, CharPredicate ignoreStrategy) {
        return eq(classMapping3, property, property.get(), queryAlias3, ignoreStrategy);
    }

    /**
     * Eq 3.
     *
     * @param property the property
     * @return the l
     */
    public L eq3(SerializableIntSupplier property) {
        return eq(classMapping3, property, property.getAsInt(), queryAlias3, getIgnoreStrategy());
    }

    /**
     * Eq 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L eq3(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return eq(classMapping3, property, property.getAsInt(), queryAlias3, ignoreStrategy);
    }

    /**
     * Eq 3.
     *
     * @param property the property
     * @return the l
     */
    public L eq3(SerializableLocalDateSupplier property) {
        return eq(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Eq 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L eq3(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return eq(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Eq 3.
     *
     * @param property the property
     * @return the l
     */
    public L eq3(SerializableLocalDateTimeSupplier property) {
        return eq(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Eq 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L eq3(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return eq(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Eq 3.
     *
     * @param property the property
     * @return the l
     */
    public L eq3(SerializableLocalTimeSupplier property) {
        return eq(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Eq 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L eq3(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return eq(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Eq 3.
     *
     * @param property the property
     * @return the l
     */
    public L eq3(SerializableLongSupplier property) {
        return eq(classMapping3, property, property.getAsLong(), queryAlias3, getIgnoreStrategy());
    }

    /**
     * Eq 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L eq3(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return eq(classMapping3, property, property.getAsLong(), queryAlias3, ignoreStrategy);
    }

    /**
     * Eq 3.
     *
     * @param <R>      the generic type
     * @param property the property
     * @return the l
     */
    public <R extends Number> L eq3(SerializableNumberSupplier<R> property) {
        return eq(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Eq 3.
     *
     * @param <R>            the generic type
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <R extends Number> L eq3(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return eq(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Eq 3.
     *
     * @param property      the property
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L eq3(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return eq(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Eq 3.
     *
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L eq3(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return eq(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Eq 3.
     *
     * @param <R>      the generic type
     * @param property the property
     * @return the l
     */
    public <R extends Serializable> L eq3(SerializableSupplier<R> property) {
        return eq(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Eq 3.
     *
     * @param <R>            the generic type
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <R extends Serializable> L eq3(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return eq(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    // ****************************************************************************************************************
    //  ne
    // ****************************************************************************************************************

    /**
     * Ne 3.
     *
     * @param <R>   the generic type
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public <R> L ne3(SerializableFunction<E3, R> name, R value) {
        return ne(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ne 3.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <R> L ne3(SerializableFunction<E3, R> name, R value, Predicate<R> ignoreStrategy) {
        return ne(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Ne 3.
     *
     * @param <D>   the generic type
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public <D extends Date> L ne3(SerializableToDateFunction<E3, D> name, D value) {
        return ne(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ne 3.
     *
     * @param <D>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <D extends Date> L ne3(SerializableToDateFunction<E3, D> name, D value, Predicate<D> ignoreStrategy) {
        return ne(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Ne 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L ne3(SerializableToDoubleFunction<E3> name, double value) {
        return ne(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ne 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ne3(SerializableToDoubleFunction<E3> name, double value, DoublePredicate ignoreStrategy) {
        return ne(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Ne 3.
     *
     * @param <E>   the element type
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public <E extends Enum<E>> L ne3(SerializableToEnumFunction<E3, E> name, E value) {
        return ne(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ne 3.
     *
     * @param <E>            the element type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <E extends Enum<E>> L ne3(SerializableToEnumFunction<E3, E> name, E value, Predicate<E> ignoreStrategy) {
        return ne(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Ne 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L ne3(SerializableToIntFunction<E3> name, int value) {
        return ne(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ne 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ne3(SerializableToIntFunction<E3> name, int value, IntPredicate ignoreStrategy) {
        return ne(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Ne 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L ne3(SerializableToLocalDateFunction<E3> name, LocalDate value) {
        return ne(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ne 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ne3(SerializableToLocalDateFunction<E3> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ne(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Ne 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L ne3(SerializableToLocalDateTimeFunction<E3> name, LocalDateTime value) {
        return ne(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ne 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ne3(SerializableToLocalDateTimeFunction<E3> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return ne(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Ne 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L ne3(SerializableToLocalTimeFunction<E3> name, LocalTime value) {
        return ne(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ne 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ne3(SerializableToLocalTimeFunction<E3> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ne(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Ne 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L ne3(SerializableToLongFunction<E3> name, long value) {
        return ne(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ne 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ne3(SerializableToLongFunction<E3> name, long value, LongPredicate ignoreStrategy) {
        return ne(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Ne 3.
     *
     * @param <N>   the number type
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public <N extends Number> L ne3(SerializableToNumberFunction<E3, N> name, N value) {
        return ne(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ne 3.
     *
     * @param <N>            the number type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <N extends Number> L ne3(SerializableToNumberFunction<E3, N> name, N value, Predicate<N> ignoreStrategy) {
        return ne(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Ne 3.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L ne3(SerializableToStringFunction<E3> name, String value, MatchStrategy matchStrategy) {
        return ne(classMapping3, name, value, queryAlias3, matchStrategy, getIgnoreStrategy());
    }

    /**
     * Ne 3.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ne3(SerializableToStringFunction<E3> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ne(classMapping3, name, value, queryAlias3, matchStrategy, ignoreStrategy);
    }

    /**
     * Ne 3.
     *
     * @param <R>      the generic type
     * @param property the property
     * @return the l
     */
    public <R extends Date> L ne3(SerializableDateSupplier<R> property) {
        return ne(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ne 3.
     *
     * @param <R>            the generic type
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <R extends Date> L ne3(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ne(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Ne 3.
     *
     * @param property the property
     * @return the l
     */
    public L ne3(SerializableDoubleSupplier property) {
        return ne(classMapping3, property, property.getAsDouble(), queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ne 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ne3(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return ne(classMapping3, property, property.getAsDouble(), queryAlias3, ignoreStrategy);
    }

    /**
     * Ne 3.
     *
     * @param <E>      the element type
     * @param property the property
     * @return the l
     */
    public <E extends Enum<E>> L ne3(SerializableEnumSupplier<E> property) {
        return ne(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ne 3.
     *
     * @param <E>            the element type
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <E extends Enum<E>> L ne3(SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy) {
        return ne(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Ne 3.
     *
     * @param propertyValue the property value
     * @return the l
     */
    public L ne3(SerializableBooleanSupplier propertyValue) {
        return ne(classMapping3, propertyValue, propertyValue.getAsBoolean(), queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ne 3.
     *
     * @param propertyValue the property value
     * @return the l
     */
    public L ne3(SerializableBoolSupplier propertyValue) {
        return ne(classMapping3, propertyValue, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ne 3.
     *
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ne3(SerializableBoolSupplier propertyValue, Predicate<Boolean> ignoreStrategy) {
        return ne(classMapping3, propertyValue, queryAlias3, ignoreStrategy);
    }

    /**
     * Ne 3.
     *
     * @param propertyValue the property value
     * @return the l
     */
    public L ne3(SerializableCharSupplier propertyValue) {
        return ne(classMapping3, propertyValue, propertyValue.get(), queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ne 3.
     *
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ne3(SerializableCharSupplier propertyValue, CharPredicate ignoreStrategy) {
        return ne(classMapping3, propertyValue, propertyValue.get(), queryAlias3, ignoreStrategy);
    }

    /**
     * Ne 3.
     *
     * @param property the property
     * @return the l
     */
    public L ne3(SerializableIntSupplier property) {
        return ne(classMapping3, property, property.getAsInt(), queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ne 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ne3(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return ne(classMapping3, property, property.getAsInt(), queryAlias3, ignoreStrategy);
    }

    /**
     * Ne 3.
     *
     * @param property the property
     * @return the l
     */
    public L ne3(SerializableLocalDateSupplier property) {
        return ne(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ne 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ne3(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return ne(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Ne 3.
     *
     * @param property the property
     * @return the l
     */
    public L ne3(SerializableLocalDateTimeSupplier property) {
        return ne(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ne 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ne3(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return ne(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Ne 3.
     *
     * @param property the property
     * @return the l
     */
    public L ne3(SerializableLocalTimeSupplier property) {
        return ne(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ne 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ne3(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return ne(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Ne 3.
     *
     * @param property the property
     * @return the l
     */
    public L ne3(SerializableLongSupplier property) {
        return ne(classMapping3, property, property.getAsLong(), queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ne 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ne3(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return ne(classMapping3, property, property.getAsLong(), queryAlias3, ignoreStrategy);
    }

    /**
     * Ne 3.
     *
     * @param <R>      the generic type
     * @param property the property
     * @return the l
     */
    public <R extends Number> L ne3(SerializableNumberSupplier<R> property) {
        return ne(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ne 3.
     *
     * @param <R>            the generic type
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <R extends Number> L ne3(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ne(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Ne 3.
     *
     * @param property      the property
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L ne3(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return ne(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ne 3.
     *
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ne3(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ne(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Ne 3.
     *
     * @param <R>      the generic type
     * @param property the property
     * @return the l
     */
    public <R extends Serializable> L ne3(SerializableSupplier<R> property) {
        return ne(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ne 3.
     *
     * @param <R>            the generic type
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <R extends Serializable> L ne3(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ne(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * Lk 3.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L lk3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy) {
        return lk(classMapping3, name, value, queryAlias3, matchStrategy, getIgnoreStrategy());
    }

    /**
     * Lk 3.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L lk3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return lk(classMapping3, name, value, queryAlias3, matchStrategy, ignoreStrategy);
    }

    /**
     * Lk 3.
     *
     * @param property      the property
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L lk3(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return lk(classMapping3, property, queryAlias3, matchStrategy, getIgnoreStrategy());
    }

    /**
     * Lk 3.
     *
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L lk3(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return lk(classMapping3, property, queryAlias3, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * Nl 3.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L nl3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy) {
        return nl(classMapping3, name, value, queryAlias3, matchStrategy, getIgnoreStrategy());
    }

    /**
     * Nl 3.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L nl3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nl(classMapping3, name, value, queryAlias3, matchStrategy, ignoreStrategy);
    }

    /**
     * Nl 3.
     *
     * @param property      the property
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L nl3(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return nl(classMapping3, property, queryAlias3, matchStrategy, getIgnoreStrategy());
    }

    /**
     * Nl 3.
     *
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L nl3(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nl(classMapping3, property, queryAlias3, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * Sw 3.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L sw3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy) {
        return sw(classMapping3, name, value, queryAlias3, matchStrategy, getIgnoreStrategy());
    }

    /**
     * Sw 3.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L sw3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return sw(classMapping3, name, value, queryAlias3, matchStrategy, ignoreStrategy);
    }

    /**
     * Sw 3.
     *
     * @param property      the property
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L sw3(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return sw(classMapping3, property, queryAlias3, matchStrategy, getIgnoreStrategy());
    }

    /**
     * Sw 3.
     *
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L sw3(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return sw(classMapping3, property, queryAlias3, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * Nsw 3.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L nsw3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy) {
        return nsw(classMapping3, name, value, queryAlias3, matchStrategy, getIgnoreStrategy());
    }

    /**
     * Nsw 3.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L nsw3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nsw(classMapping3, name, value, queryAlias3, matchStrategy, ignoreStrategy);
    }

    /**
     * Nsw 3.
     *
     * @param property      the property
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L nsw3(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return nsw(classMapping3, property, queryAlias3, matchStrategy, getIgnoreStrategy());
    }

    /**
     * Nsw 3.
     *
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L nsw3(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nsw(classMapping3, property, queryAlias3, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * Ew 3.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L ew3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy) {
        return ew(classMapping3, name, value, queryAlias3, matchStrategy, getIgnoreStrategy());
    }

    /**
     * Ew 3.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ew3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ew(classMapping3, name, value, queryAlias3, matchStrategy, ignoreStrategy);
    }

    /**
     * Ew 3.
     *
     * @param property      the property
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L ew3(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return ew(classMapping3, property, queryAlias3, matchStrategy, getIgnoreStrategy());
    }

    /**
     * Ew 3.
     *
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ew3(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ew(classMapping3, property, queryAlias3, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * New 3.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L new3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy) {
        return newv(classMapping3, name, value, queryAlias3, matchStrategy, getIgnoreStrategy());
    }

    /**
     * New 3.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L new3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return newv(classMapping3, name, value, queryAlias3, matchStrategy, ignoreStrategy);
    }

    /**
     * New 3.
     *
     * @param property      the property
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L new3(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return newv(classMapping3, property, queryAlias3, matchStrategy, getIgnoreStrategy());
    }

    /**
     * New 3.
     *
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L new3(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return newv(classMapping3, property, queryAlias3, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * Co 3.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L co3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy) {
        return co(classMapping3, name, value, queryAlias3, matchStrategy, getIgnoreStrategy());
    }

    /**
     * Co 3.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L co3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return co(classMapping3, name, value, queryAlias3, matchStrategy, ignoreStrategy);
    }

    /**
     * Co 3.
     *
     * @param property      the property
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L co3(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return co(classMapping3, property, queryAlias3, matchStrategy, getIgnoreStrategy());
    }

    /**
     * Co 3.
     *
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L co3(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return co(classMapping3, property, queryAlias3, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * Nco 3.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L nco3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy) {
        return nco(classMapping3, name, value, queryAlias3, matchStrategy, getIgnoreStrategy());
    }

    /**
     * Nco 3.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L nco3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nco(classMapping3, name, value, queryAlias3, matchStrategy, ignoreStrategy);
    }

    /**
     * Nco 3.
     *
     * @param property      the property
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L nco3(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return nco(classMapping3, property, queryAlias3, matchStrategy, getIgnoreStrategy());
    }

    /**
     * Nco 3.
     *
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L nco3(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nco(classMapping3, property, queryAlias3, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * Ge 3.
     *
     * @param <N>   the number type
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public <N extends Number> L ge3(SerializableFunction<E3, N> name, N value) {
        return ge(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ge 3.
     *
     * @param <N>            the number type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <N extends Number> L ge3(SerializableFunction<E3, N> name, N value, Predicate<N> ignoreStrategy) {
        return ge(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Ge 3.
     *
     * @param <D>   the generic type
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public <D extends Date> L ge3(SerializableFunction<E3, D> name, D value) {
        return ge(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ge 3.
     *
     * @param <D>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <D extends Date> L ge3(SerializableFunction<E3, D> name, D value, Predicate<D> ignoreStrategy) {
        return ge(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Ge 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L ge3(SerializableFunction<E3, LocalTime> name, LocalTime value) {
        return ge(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ge 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ge3(SerializableFunction<E3, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ge(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Ge 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L ge3(SerializableFunction<E3, LocalDate> name, LocalDate value) {
        return ge(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ge 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ge3(SerializableFunction<E3, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ge(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Ge 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L ge3(SerializableFunction<E3, LocalDateTime> name, LocalDateTime value) {
        return ge(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ge 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ge3(SerializableFunction<E3, LocalDateTime> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return ge(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Ge 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L ge3(SerializableFunction<E3, String> name, String value) {
        return ge(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ge 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ge3(SerializableFunction<E3, String> name, String value, Predicate<String> ignoreStrategy) {
        return ge(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Ge 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L ge3(SerializableToIntFunction3<E3> name, int value) {
        return ge(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ge 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ge3(SerializableToIntFunction3<E3> name, int value, IntPredicate ignoreStrategy) {
        return ge(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Ge 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L ge3(SerializableToLongFunction3<E3> name, long value) {
        return ge(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ge 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ge3(SerializableToLongFunction3<E3> name, long value, LongPredicate ignoreStrategy) {
        return ge(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Ge 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L ge3(SerializableToDoubleFunction3<E3> name, double value) {
        return ge(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ge 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ge3(SerializableToDoubleFunction3<E3> name, double value, DoublePredicate ignoreStrategy) {
        return ge(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Ge 3.
     *
     * @param <E>   the element type
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public <E extends Enum<E>> L ge3(SerializableFunction<E3, E> name, E value) {
        return ge(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ge 3.
     *
     * @param <E>            the element type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <E extends Enum<E>> L ge3(SerializableFunction<E3, E> name, E value, Predicate<E> ignoreStrategy) {
        return ge(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Ge 3.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L ge3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy) {
        return ge(classMapping3, name, value, matchStrategy, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ge 3.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ge3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ge(classMapping3, name, value, matchStrategy, queryAlias3, ignoreStrategy);
    }

    /**
     * Ge 3.
     *
     * @param <E>      the element type
     * @param property the property
     * @return the l
     */
    public <E extends Enum<E>> L ge3(SerializableEnumSupplier<E> property) {
        return ge(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ge 3.
     *
     * @param <E>            the element type
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <E extends Enum<E>> L ge3(SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy) {
        return ge(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Ge 3.
     *
     * @param property      the property
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L ge3(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return ge(classMapping3, property, matchStrategy, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ge 3.
     *
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ge3(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ge(classMapping3, property, matchStrategy, queryAlias3, ignoreStrategy);
    }

    /**
     * Ge 3.
     *
     * @param <R>      the generic type
     * @param property the property
     * @return the l
     */
    public <R extends Date> L ge3(SerializableDateSupplier<R> property) {
        return ge(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ge 3.
     *
     * @param <R>            the generic type
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <R extends Date> L ge3(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ge(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Ge 3.
     *
     * @param <R>      the generic type
     * @param property the property
     * @return the l
     */
    public <R extends Number> L ge3(SerializableNumberSupplier<R> property) {
        return ge(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ge 3.
     *
     * @param <R>            the generic type
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <R extends Number> L ge3(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ge(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Ge 3.
     *
     * @param property the property
     * @return the l
     */
    public L ge3(SerializableLocalDateSupplier property) {
        return ge(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ge 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ge3(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return ge(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Ge 3.
     *
     * @param property the property
     * @return the l
     */
    public L ge3(SerializableLocalTimeSupplier property) {
        return ge(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ge 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ge3(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return ge(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Ge 3.
     *
     * @param property the property
     * @return the l
     */
    public L ge3(SerializableLocalDateTimeSupplier property) {
        return ge(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ge 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ge3(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return ge(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Ge 3.
     *
     * @param property the property
     * @return the l
     */
    public L ge3(SerializableStringSupplier property) {
        return ge(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ge 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ge3(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return ge(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Ge 3.
     *
     * @param property the property
     * @return the l
     */
    public L ge3(SerializableIntSupplier property) {
        return ge(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ge 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ge3(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return ge(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Ge 3.
     *
     * @param property the property
     * @return the l
     */
    public L ge3(SerializableLongSupplier property) {
        return ge(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ge 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ge3(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return ge(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Ge 3.
     *
     * @param property the property
     * @return the l
     */
    public L ge3(SerializableDoubleSupplier property) {
        return ge(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ge 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ge3(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return ge(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * Gt 3.
     *
     * @param <N>   the number type
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public <N extends Number> L gt3(SerializableFunction<E3, N> name, N value) {
        return gt(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Gt 3.
     *
     * @param <N>            the number type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <N extends Number> L gt3(SerializableFunction<E3, N> name, N value, Predicate<N> ignoreStrategy) {
        return gt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Gt 3.
     *
     * @param <E>   the element type
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public <E extends Enum<E>> L gt3(SerializableFunction<E3, E> name, E value) {
        return gt(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Gt 3.
     *
     * @param <E>            the element type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <E extends Enum<E>> L gt3(SerializableFunction<E3, E> name, E value, Predicate<E> ignoreStrategy) {
        return gt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Gt 3.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L gt3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy) {
        return gt(classMapping3, name, value, matchStrategy, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Gt 3.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L gt3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return gt(classMapping3, name, value, matchStrategy, queryAlias3, ignoreStrategy);
    }

    /**
     * Gt 3.
     *
     * @param <E>      the element type
     * @param property the property
     * @return the l
     */
    public <E extends Enum<E>> L gt3(SerializableEnumSupplier<E> property) {
        return gt(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Gt 3.
     *
     * @param <E>            the element type
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <E extends Enum<E>> L gt3(SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy) {
        return gt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Gt 3.
     *
     * @param property      the property
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L gt3(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return gt(classMapping3, property, matchStrategy, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Gt 3.
     *
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L gt3(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return gt(classMapping3, property, matchStrategy, queryAlias3, ignoreStrategy);
    }

    /**
     * Gt 3.
     *
     * @param <D>   the generic type
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public <D extends Date> L gt3(SerializableFunction<E3, D> name, D value) {
        return gt(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Gt 3.
     *
     * @param <D>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <D extends Date> L gt3(SerializableFunction<E3, D> name, D value, Predicate<D> ignoreStrategy) {
        return gt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Gt 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L gt3(SerializableFunction<E3, LocalTime> name, LocalTime value) {
        return gt(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Gt 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L gt3(SerializableFunction<E3, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return gt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Gt 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L gt3(SerializableFunction<E3, LocalDate> name, LocalDate value) {
        return gt(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Gt 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L gt3(SerializableFunction<E3, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return gt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Gt 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L gt3(SerializableFunction<E3, LocalDateTime> name, LocalDateTime value) {
        return gt(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Gt 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L gt3(SerializableFunction<E3, LocalDateTime> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return gt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Gt 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L gt3(SerializableFunction<E3, String> name, String value) {
        return gt(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Gt 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L gt3(SerializableFunction<E3, String> name, String value, Predicate<String> ignoreStrategy) {
        return gt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Gt 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L gt3(SerializableToIntFunction3<E3> name, int value) {
        return gt(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Gt 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L gt3(SerializableToIntFunction3<E3> name, int value, IntPredicate ignoreStrategy) {
        return gt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Gt 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L gt3(SerializableToLongFunction3<E3> name, long value) {
        return gt(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Gt 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L gt3(SerializableToLongFunction3<E3> name, long value, LongPredicate ignoreStrategy) {
        return gt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Gt 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L gt3(SerializableToDoubleFunction3<E3> name, double value) {
        return gt(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Gt 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L gt3(SerializableToDoubleFunction3<E3> name, double value, DoublePredicate ignoreStrategy) {
        return gt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Gt 3.
     *
     * @param <R>      the generic type
     * @param property the property
     * @return the l
     */
    public <R extends Number> L gt3(SerializableNumberSupplier<R> property) {
        return gt(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Gt 3.
     *
     * @param <R>            the generic type
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <R extends Number> L gt3(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return gt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Gt 3.
     *
     * @param <R>      the generic type
     * @param property the property
     * @return the l
     */
    public <R extends Date> L gt3(SerializableDateSupplier<R> property) {
        return gt(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Gt 3.
     *
     * @param <R>            the generic type
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <R extends Date> L gt3(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return gt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Gt 3.
     *
     * @param property the property
     * @return the l
     */
    public L gt3(SerializableLocalDateSupplier property) {
        return gt(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Gt 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L gt3(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return gt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Gt 3.
     *
     * @param property the property
     * @return the l
     */
    public L gt3(SerializableLocalTimeSupplier property) {
        return gt(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Gt 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L gt3(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return gt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Gt 3.
     *
     * @param property the property
     * @return the l
     */
    public L gt3(SerializableLocalDateTimeSupplier property) {
        return gt(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Gt 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L gt3(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return gt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Gt 3.
     *
     * @param property the property
     * @return the l
     */
    public L gt3(SerializableStringSupplier property) {
        return gt(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Gt 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L gt3(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return gt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Gt 3.
     *
     * @param property the property
     * @return the l
     */
    public L gt3(SerializableIntSupplier property) {
        return gt(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Gt 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L gt3(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return gt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Gt 3.
     *
     * @param property the property
     * @return the l
     */
    public L gt3(SerializableLongSupplier property) {
        return gt(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Gt 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L gt3(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return gt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Gt 3.
     *
     * @param property the property
     * @return the l
     */
    public L gt3(SerializableDoubleSupplier property) {
        return gt(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Gt 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L gt3(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return gt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * Le 3.
     *
     * @param <N>   the number type
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public <N extends Number> L le3(SerializableFunction<E3, N> name, N value) {
        return le(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Le 3.
     *
     * @param <N>            the number type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <N extends Number> L le3(SerializableFunction<E3, N> name, N value, Predicate<N> ignoreStrategy) {
        return le(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Le 3.
     *
     * @param <E>   the element type
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public <E extends Enum<E>> L le3(SerializableFunction<E3, E> name, E value) {
        return le(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Le 3.
     *
     * @param <E>            the element type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <E extends Enum<E>> L le3(SerializableFunction<E3, E> name, E value, Predicate<E> ignoreStrategy) {
        return le(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Le 3.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L le3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy) {
        return le(classMapping3, name, value, matchStrategy, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Le 3.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L le3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return le(classMapping3, name, value, matchStrategy, queryAlias3, ignoreStrategy);
    }

    /**
     * Le 3.
     *
     * @param <E>      the element type
     * @param property the property
     * @return the l
     */
    public <E extends Enum<E>> L le3(SerializableEnumSupplier<E> property) {
        return le(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Le 3.
     *
     * @param <E>            the element type
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <E extends Enum<E>> L le3(SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy) {
        return le(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Le 3.
     *
     * @param property      the property
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L le3(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return le(classMapping3, property, matchStrategy, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Le 3.
     *
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L le3(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return le(classMapping3, property, matchStrategy, queryAlias3, ignoreStrategy);
    }

    /**
     * Le 3.
     *
     * @param <D>   the generic type
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public <D extends Date> L le3(SerializableFunction<E3, D> name, D value) {
        return le(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Le 3.
     *
     * @param <D>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <D extends Date> L le3(SerializableFunction<E3, D> name, D value, Predicate<D> ignoreStrategy) {
        return le(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Le 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L le3(SerializableFunction<E3, LocalTime> name, LocalTime value) {
        return le(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Le 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L le3(SerializableFunction<E3, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return le(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Le 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L le3(SerializableFunction<E3, LocalDate> name, LocalDate value) {
        return le(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Le 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L le3(SerializableFunction<E3, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return le(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Le 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L le3(SerializableFunction<E3, LocalDateTime> name, LocalDateTime value) {
        return le(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Le 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L le3(SerializableFunction<E3, LocalDateTime> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return le(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Le 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L le3(SerializableFunction<E3, String> name, String value) {
        return le(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Le 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L le3(SerializableFunction<E3, String> name, String value, Predicate<String> ignoreStrategy) {
        return le(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Le 3.
     *
     * @param <R>      the generic type
     * @param property the property
     * @return the l
     */
    public <R extends Date> L le3(SerializableDateSupplier<R> property) {
        return le(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Le 3.
     *
     * @param <R>            the generic type
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <R extends Date> L le3(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return le(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Le 3.
     *
     * @param <R>      the generic type
     * @param property the property
     * @return the l
     */
    public <R extends Number> L le3(SerializableNumberSupplier<R> property) {
        return le(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Le 3.
     *
     * @param <R>            the generic type
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <R extends Number> L le3(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return le(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Le 3.
     *
     * @param property the property
     * @return the l
     */
    public L le3(SerializableLocalDateSupplier property) {
        return le(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Le 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L le3(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return le(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Le 3.
     *
     * @param property the property
     * @return the l
     */
    public L le3(SerializableLocalTimeSupplier property) {
        return le(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Le 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L le3(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return le(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Le 3.
     *
     * @param property the property
     * @return the l
     */
    public L le3(SerializableLocalDateTimeSupplier property) {
        return le(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Le 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L le3(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return le(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Le 3.
     *
     * @param property the property
     * @return the l
     */
    public L le3(SerializableStringSupplier property) {
        return le(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Le 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L le3(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return le(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Le 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L le3(SerializableToIntFunction3<E3> name, int value) {
        return le(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Le 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L le3(SerializableToIntFunction3<E3> name, int value, IntPredicate ignoreStrategy) {
        return le(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Le 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L le3(SerializableToLongFunction3<E3> name, long value) {
        return le(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Le 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L le3(SerializableToLongFunction3<E3> name, long value, LongPredicate ignoreStrategy) {
        return le(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Le 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L le3(SerializableToDoubleFunction3<E3> name, double value) {
        return le(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Le 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L le3(SerializableToDoubleFunction3<E3> name, double value, DoublePredicate ignoreStrategy) {
        return le(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Le 3.
     *
     * @param property the property
     * @return the l
     */
    public L le3(SerializableIntSupplier property) {
        return le(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Le 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L le3(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return le(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Le 3.
     *
     * @param property the property
     * @return the l
     */
    public L le3(SerializableLongSupplier property) {
        return le(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Le 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L le3(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return le(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Le 3.
     *
     * @param property the property
     * @return the l
     */
    public L le3(SerializableDoubleSupplier property) {
        return le(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Le 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L le3(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return le(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * Lt 3.
     *
     * @param <N>   the number type
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public <N extends Number> L lt3(SerializableFunction<E3, N> name, N value) {
        return lt(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Lt 3.
     *
     * @param <N>            the number type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <N extends Number> L lt3(SerializableFunction<E3, N> name, N value, Predicate<N> ignoreStrategy) {
        return lt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Lt 3.
     *
     * @param <E>   the element type
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public <E extends Enum<E>> L lt3(SerializableFunction<E3, E> name, E value) {
        return lt(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Lt 3.
     *
     * @param <E>            the element type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <E extends Enum<E>> L lt3(SerializableFunction<E3, E> name, E value, Predicate<E> ignoreStrategy) {
        return lt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Lt 3.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L lt3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy) {
        return lt(classMapping3, name, value, matchStrategy, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Lt 3.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L lt3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return lt(classMapping3, name, value, matchStrategy, queryAlias3, ignoreStrategy);
    }

    /**
     * Lt 3.
     *
     * @param <E>      the element type
     * @param property the property
     * @return the l
     */
    public <E extends Enum<E>> L lt3(SerializableEnumSupplier<E> property) {
        return lt(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Lt 3.
     *
     * @param <E>            the element type
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <E extends Enum<E>> L lt3(SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy) {
        return lt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Lt 3.
     *
     * @param property      the property
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L lt3(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return lt(classMapping3, property, matchStrategy, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Lt 3.
     *
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L lt3(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return lt(classMapping3, property, matchStrategy, queryAlias3, ignoreStrategy);
    }

    /**
     * Lt 3.
     *
     * @param <D>   the generic type
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public <D extends Date> L lt3(SerializableFunction<E3, D> name, D value) {
        return lt(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Lt 3.
     *
     * @param <D>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <D extends Date> L lt3(SerializableFunction<E3, D> name, D value, Predicate<D> ignoreStrategy) {
        return lt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Lt 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L lt3(SerializableFunction<E3, LocalTime> name, LocalTime value) {
        return lt(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Lt 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L lt3(SerializableFunction<E3, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return lt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Lt 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L lt3(SerializableFunction<E3, LocalDate> name, LocalDate value) {
        return lt(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Lt 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L lt3(SerializableFunction<E3, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return lt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Lt 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L lt3(SerializableFunction<E3, LocalDateTime> name, LocalDateTime value) {
        return lt(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Lt 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L lt3(SerializableFunction<E3, LocalDateTime> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return lt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Lt 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L lt3(SerializableFunction<E3, String> name, String value) {
        return lt(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Lt 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L lt3(SerializableFunction<E3, String> name, String value, Predicate<String> ignoreStrategy) {
        return lt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Lt 3.
     *
     * @param <R>      the generic type
     * @param property the property
     * @return the l
     */
    public <R extends Number> L lt3(SerializableNumberSupplier<R> property) {
        return lt(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Lt 3.
     *
     * @param <R>            the generic type
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <R extends Number> L lt3(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return lt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Lt 3.
     *
     * @param <R>      the generic type
     * @param property the property
     * @return the l
     */
    public <R extends Date> L lt3(SerializableDateSupplier<R> property) {
        return lt(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Lt 3.
     *
     * @param <R>            the generic type
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <R extends Date> L lt3(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return lt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Lt 3.
     *
     * @param property the property
     * @return the l
     */
    public L lt3(SerializableLocalDateSupplier property) {
        return lt(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Lt 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L lt3(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return lt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Lt 3.
     *
     * @param property the property
     * @return the l
     */
    public L lt3(SerializableLocalTimeSupplier property) {
        return lt(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Lt 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L lt3(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return lt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Lt 3.
     *
     * @param property the property
     * @return the l
     */
    public L lt3(SerializableLocalDateTimeSupplier property) {
        return lt(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Lt 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L lt3(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return lt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Lt 3.
     *
     * @param property the property
     * @return the l
     */
    public L lt3(SerializableStringSupplier property) {
        return lt(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Lt 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L lt3(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return lt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Lt 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L lt3(SerializableToIntFunction3<E3> name, int value) {
        return lt(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Lt 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L lt3(SerializableToIntFunction3<E3> name, int value, IntPredicate ignoreStrategy) {
        return lt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Lt 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L lt3(SerializableToLongFunction3<E3> name, long value) {
        return lt(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Lt 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L lt3(SerializableToLongFunction3<E3> name, long value, LongPredicate ignoreStrategy) {
        return lt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Lt 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L lt3(SerializableToDoubleFunction3<E3> name, double value) {
        return lt(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Lt 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L lt3(SerializableToDoubleFunction3<E3> name, double value, DoublePredicate ignoreStrategy) {
        return lt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Lt 3.
     *
     * @param property the property
     * @return the l
     */
    public L lt3(SerializableIntSupplier property) {
        return lt(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Lt 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L lt3(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return lt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Lt 3.
     *
     * @param property the property
     * @return the l
     */
    public L lt3(SerializableLongSupplier property) {
        return lt(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Lt 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L lt3(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return lt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Lt 3.
     *
     * @param property the property
     * @return the l
     */
    public L lt3(SerializableDoubleSupplier property) {
        return lt(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Lt 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L lt3(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return lt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * In 3.
     *
     * @param <R>   the generic type
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public <R> L in3(SerializableFunction<E3, R> name, R value) {
        return in(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * In 3.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <R> L in3(SerializableFunction<E3, R> name, R value, Predicate<R> ignoreStrategy) {
        return in(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * In 3.
     *
     * @param <R>   the generic type
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public <R> L in3(SerializableFunction<E3, R> name, @SuppressWarnings("unchecked") R... value) {
        return in(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * In 3.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <R> L in3(SerializableFunction<E3, R> name, R[] value, Predicate<R[]> ignoreStrategy) {
        return in(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * In 3.
     *
     * @param <R>   the generic type
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public <R> L in3(SerializableFunction<E3, R> name, Collection<R> value) {
        return in(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * In 3.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <R> L in3(SerializableFunction<E3, R> name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy) {
        return in(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * In 3.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L in3(SerializableToStringFunction<E3> name, String value, MatchStrategy matchStrategy) {
        return in(classMapping3, name, value, matchStrategy, queryAlias3, getIgnoreStrategy());
    }

    /**
     * In 3.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L in3(SerializableToStringFunction<E3> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return in(classMapping3, name, value, matchStrategy, queryAlias3, ignoreStrategy);
    }

    /**
     * In 3.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L in3(SerializableToStringFunction<E3> name, String[] value, MatchStrategy matchStrategy) {
        return in(classMapping3, name, value, matchStrategy, queryAlias3, getIgnoreStrategy());
    }

    /**
     * In 3.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L in3(SerializableToStringFunction<E3> name, String[] value, MatchStrategy matchStrategy,
        Predicate<String[]> ignoreStrategy) {
        return in(classMapping3, name, value, matchStrategy, queryAlias3, ignoreStrategy);
    }

    /**
     * In 3.
     *
     * @param property      the property
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L in3(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return in(classMapping3, property, matchStrategy, queryAlias3, getIgnoreStrategy());
    }

    /**
     * In 3.
     *
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L in3(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return in(classMapping3, property, matchStrategy, queryAlias3, ignoreStrategy);
    }

    /**
     * In 3.
     *
     * @param <R>      the generic type
     * @param property the property
     * @return the l
     */
    public <R> L in3(SerializableSupplier<R> property) {
        return in(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * In 3.
     *
     * @param <R>            the generic type
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <R> L in3(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return in(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * In 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L in3(SerializableToIntFunction3<E3> name, int value) {
        return in(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * In 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L in3(SerializableToIntFunction3<E3> name, int value, IntPredicate ignoreStrategy) {
        return in(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * In 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L in3(SerializableToLongFunction3<E3> name, long value) {
        return in(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * In 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L in3(SerializableToLongFunction3<E3> name, long value, LongPredicate ignoreStrategy) {
        return in(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * In 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L in3(SerializableToDoubleFunction<E3> name, double value) {
        return in(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * In 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L in3(SerializableToDoubleFunction<E3> name, double value, DoublePredicate ignoreStrategy) {
        return in(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * In 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L in3(SerializableToIntFunction3<E3> name, int... value) {
        return in(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * In 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L in3(SerializableToLongFunction3<E3> name, long... value) {
        return in(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * In 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L in3(SerializableToDoubleFunction3<E3> name, double... value) {
        return in(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * In 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L in3(SerializableToDoubleFunction3<E3> name, double[] value, Predicate<double[]> ignoreStrategy) {
        return in(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * In 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L in3(SerializableToIntFunction3<E3> name, int[] value, Predicate<int[]> ignoreStrategy) {
        return in(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * In 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L in3(SerializableToLongFunction3<E3> name, long[] value, Predicate<long[]> ignoreStrategy) {
        return in(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * In 3.
     *
     * @param property the property
     * @return the l
     */
    public L in3(SerializableIntSupplier property) {
        return in(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * In 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L in3(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return in(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * In 3.
     *
     * @param property the property
     * @return the l
     */
    public L in3(SerializableLongSupplier property) {
        return in(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * In 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L in3(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return in(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * In 3.
     *
     * @param property the property
     * @return the l
     */
    public L in3(SerializableDoubleSupplier property) {
        return in(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * In 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L in3(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return in(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * Ni 3.
     *
     * @param <R>   the generic type
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public <R> L ni3(SerializableFunction<E3, R> name, R value) {
        return ni(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ni 3.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <R> L ni3(SerializableFunction<E3, R> name, R value, Predicate<R> ignoreStrategy) {
        return ni(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Ni 3.
     *
     * @param <R>   the generic type
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public <R> L ni3(SerializableFunction<E3, R> name, @SuppressWarnings("unchecked") R... value) {
        return ni(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ni 3.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <R> L ni3(SerializableFunction<E3, R> name, R[] value, Predicate<R[]> ignoreStrategy) {
        return ni(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Ni 3.
     *
     * @param <R>   the generic type
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public <R> L ni3(SerializableFunction<E3, R> name, Collection<R> value) {
        return ni(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ni 3.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <R> L ni3(SerializableFunction<E3, R> name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy) {
        return ni(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Ni 3.
     *
     * @param <R>      the generic type
     * @param property the property
     * @return the l
     */
    public <R> L ni3(SerializableSupplier<R> property) {
        return ni(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ni 3.
     *
     * @param <R>            the generic type
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <R> L ni3(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ni(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Ni 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L ni3(SerializableToIntFunction3<E3> name, int value) {
        return ni(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ni 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ni3(SerializableToIntFunction3<E3> name, int value, IntPredicate ignoreStrategy) {
        return ni(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Ni 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L ni3(SerializableToLongFunction3<E3> name, long value) {
        return ni(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ni 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ni3(SerializableToLongFunction3<E3> name, long value, LongPredicate ignoreStrategy) {
        return ni(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Ni 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L ni3(SerializableToDoubleFunction<E3> name, double value) {
        return ni(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ni 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ni3(SerializableToDoubleFunction<E3> name, double value, DoublePredicate ignoreStrategy) {
        return ni(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Ni 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L ni3(SerializableToIntFunction3<E3> name, int... value) {
        return ni(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ni 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L ni3(SerializableToLongFunction3<E3> name, long... value) {
        return ni(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ni 3.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L ni3(SerializableToDoubleFunction3<E3> name, double... value) {
        return ni(classMapping3, name, value, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ni 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ni3(SerializableToDoubleFunction3<E3> name, double[] value, Predicate<double[]> ignoreStrategy) {
        return ni(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Ni 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ni3(SerializableToIntFunction3<E3> name, int[] value, Predicate<int[]> ignoreStrategy) {
        return ni(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Ni 3.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ni3(SerializableToLongFunction3<E3> name, long[] value, Predicate<long[]> ignoreStrategy) {
        return ni(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * Ni 3.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L ni3(SerializableToStringFunction<E3> name, String value, MatchStrategy matchStrategy) {
        return ni(classMapping3, name, value, matchStrategy, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ni 3.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ni3(SerializableToStringFunction<E3> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ni(classMapping3, name, value, matchStrategy, queryAlias3, ignoreStrategy);
    }

    /**
     * Ni 3.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L ni3(SerializableToStringFunction<E3> name, String[] value, MatchStrategy matchStrategy) {
        return ni(classMapping3, name, value, matchStrategy, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ni 3.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ni3(SerializableToStringFunction<E3> name, String[] value, MatchStrategy matchStrategy,
        Predicate<String[]> ignoreStrategy) {
        return ni(classMapping3, name, value, matchStrategy, queryAlias3, ignoreStrategy);
    }

    /**
     * Ni 3.
     *
     * @param property      the property
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L ni3(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return ni(classMapping3, property, matchStrategy, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ni 3.
     *
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ni3(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ni(classMapping3, property, matchStrategy, queryAlias3, ignoreStrategy);
    }

    /**
     * Ni 3.
     *
     * @param property the property
     * @return the l
     */
    public L ni3(SerializableIntSupplier property) {
        return ni(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ni 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ni3(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return ni(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Ni 3.
     *
     * @param property the property
     * @return the l
     */
    public L ni3(SerializableLongSupplier property) {
        return ni(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ni 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ni3(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return ni(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * Ni 3.
     *
     * @param property the property
     * @return the l
     */
    public L ni3(SerializableDoubleSupplier property) {
        return ni(classMapping3, property, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ni 3.
     *
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ni3(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return ni(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * Inn 3.
     *
     * @param <R>   the generic type
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public <R> L inn3(SerializableFunction<E3, R> name, Boolean value) {
        return inn(classMapping3, name, value, queryAlias3);
    }

    /**
     * Isn 3.
     *
     * @param <R>   the generic type
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public <R> L isn3(SerializableFunction<E3, R> name, Boolean value) {
        return isn(classMapping3, name, value, queryAlias3);
    }

    // ****************************************************************************************************************

    /**
     * Ba 3.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return the l
     */
    public L ba3(SerializableToIntFunction<E3> name, int min, int max) {
        return ba(classMapping, name, min, max, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ba 3.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ba3(SerializableToIntFunction<E3> name, int min, int max, BiPredicate<Integer, Integer> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * Ba 3.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return the l
     */
    public L ba3(SerializableToLongFunction<E3> name, long min, long max) {
        return ba(classMapping, name, min, max, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ba 3.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ba3(SerializableToLongFunction<E3> name, long min, long max, BiPredicate<Long, Long> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * Ba 3.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return the l
     */
    public L ba3(SerializableToDoubleFunction<E3> name, double min, double max) {
        return ba(classMapping, name, min, max, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ba 3.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ba3(SerializableToDoubleFunction<E3> name, double min, double max,
        BiPredicate<Double, Double> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * Ba 3.
     *
     * @param <N>  the number type
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return the l
     */
    public <N extends Number> L ba3(SerializableToNumberFunction<E3, N> name, N min, N max) {
        return ba(classMapping, name, min, max, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ba 3.
     *
     * @param <N>            the number type
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <N extends Number> L ba3(SerializableToNumberFunction<E3, N> name, N min, N max,
        BiPredicate<N, N> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * Ba 3.
     *
     * @param <D>  the generic type
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return the l
     */
    public <D extends Date> L ba3(SerializableToDateFunction<E3, D> name, D min, D max) {
        return ba(classMapping, name, min, max, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ba 3.
     *
     * @param <D>            the generic type
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <D extends Date> L ba3(SerializableToDateFunction<E3, D> name, D min, D max,
        BiPredicate<D, D> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * Ba 3.
     *
     * @param <E>  the element type
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return the l
     */
    public <E extends Enum<E>> L ba3(SerializableToEnumFunction<E3, E> name, E min, E max) {
        return ba(classMapping, name, min, max, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ba 3.
     *
     * @param <E>            the element type
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <E extends Enum<E>> L ba3(SerializableToEnumFunction<E3, E> name, E min, E max,
        BiPredicate<E, E> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * Ba 3.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return the l
     */
    public L ba3(SerializableToLocalTimeFunction<E3> name, LocalTime min, LocalTime max) {
        return ba(classMapping, name, min, max, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ba 3.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ba3(SerializableToLocalTimeFunction<E3> name, LocalTime min, LocalTime max,
        BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * Ba 3.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return the l
     */
    public L ba3(SerializableToLocalDateFunction<E3> name, LocalDate min, LocalDate max) {
        return ba(classMapping, name, min, max, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ba 3.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ba3(SerializableToLocalDateFunction<E3> name, LocalDate min, LocalDate max,
        BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * Ba 3.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return the l
     */
    public L ba3(SerializableToLocalDateTimeFunction<E3> name, LocalDateTime min, LocalDateTime max) {
        return ba(classMapping, name, min, max, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ba 3.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ba3(SerializableToLocalDateTimeFunction<E3> name, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * Ba 3.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return the l
     */
    public L ba3(SerializableToStringFunction<E3> name, String min, String max) {
        return ba(classMapping, name, min, max, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Ba 3.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ba3(SerializableToStringFunction<E3> name, String min, String max,
        BiPredicate<String, String> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * Nba 3.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return the l
     */
    public L nba3(SerializableToIntFunction<E3> name, int min, int max) {
        return nba(classMapping, name, min, max, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Nba 3.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L nba3(SerializableToIntFunction<E3> name, int min, int max, BiPredicate<Integer, Integer> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * Nba 3.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return the l
     */
    public L nba3(SerializableToLongFunction<E3> name, long min, long max) {
        return nba(classMapping, name, min, max, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Nba 3.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L nba3(SerializableToLongFunction<E3> name, long min, long max, BiPredicate<Long, Long> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * Nba 3.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return the l
     */
    public L nba3(SerializableToDoubleFunction<E3> name, double min, double max) {
        return nba(classMapping, name, min, max, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Nba 3.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L nba3(SerializableToDoubleFunction<E3> name, double min, double max,
        BiPredicate<Double, Double> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * Nba 3.
     *
     * @param <N>  the number type
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return the l
     */
    public <N extends Number> L nba3(SerializableToNumberFunction<E3, N> name, N min, N max) {
        return nba(classMapping, name, min, max, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Nba 3.
     *
     * @param <N>            the number type
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <N extends Number> L nba3(SerializableToNumberFunction<E3, N> name, N min, N max,
        BiPredicate<N, N> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * Nba 3.
     *
     * @param <D>  the generic type
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return the l
     */
    public <D extends Date> L nba3(SerializableToDateFunction<E3, D> name, D min, D max) {
        return nba(classMapping, name, min, max, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Nba 3.
     *
     * @param <D>            the generic type
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <D extends Date> L nba3(SerializableToDateFunction<E3, D> name, D min, D max,
        BiPredicate<D, D> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * Nba 3.
     *
     * @param <E>  the element type
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return the l
     */
    public <E extends Enum<E>> L nba3(SerializableToEnumFunction<E3, E> name, E min, E max) {
        return nba(classMapping, name, min, max, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Nba 3.
     *
     * @param <E>            the element type
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <E extends Enum<E>> L nba3(SerializableToEnumFunction<E3, E> name, E min, E max,
        BiPredicate<E, E> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * Nba 3.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return the l
     */
    public L nba3(SerializableToLocalTimeFunction<E3> name, LocalTime min, LocalTime max) {
        return nba(classMapping, name, min, max, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Nba 3.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L nba3(SerializableToLocalTimeFunction<E3> name, LocalTime min, LocalTime max,
        BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * Nba 3.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return the l
     */
    public L nba3(SerializableToLocalDateFunction<E3> name, LocalDate min, LocalDate max) {
        return nba(classMapping, name, min, max, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Nba 3.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L nba3(SerializableToLocalDateFunction<E3> name, LocalDate min, LocalDate max,
        BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * Nba 3.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return the l
     */
    public L nba3(SerializableToLocalDateTimeFunction<E3> name, LocalDateTime min, LocalDateTime max) {
        return nba(classMapping, name, min, max, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Nba 3.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L nba3(SerializableToLocalDateTimeFunction<E3> name, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * Nba 3.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return the l
     */
    public L nba3(SerializableToStringFunction<E3> name, String min, String max) {
        return nba(classMapping, name, min, max, queryAlias3, getIgnoreStrategy());
    }

    /**
     * Nba 3.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L nba3(SerializableToStringFunction<E3> name, String min, String max,
        BiPredicate<String, String> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * Property.
     *
     * @param entitiesPropertyFunction the entities property function
     * @return the l
     */
    @SuppressWarnings("unchecked")
    public L property(ThreeArgusFunction<EntityPropertyOnlyExpression<E1>, EntityPropertyOnlyExpression<E2>,
        EntityPropertyOnlyExpression<E3>, LogicExpression<?, ?>> entitiesPropertyFunction) {
        return (L) entitiesPropertyFunction.apply(
            new EntityPropertyOnlyExpressionImpl<>(0, this, factory, entityRelation),
            new EntityPropertyOnlyExpressionImpl<>(1, this, factory, entityRelation),
            new EntityPropertyOnlyExpressionImpl<>(2, this, factory, entityRelation));
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
        return 2;
    }
}
