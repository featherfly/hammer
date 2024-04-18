
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
import cn.featherfly.common.function.SixArgusFunction;
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
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction6;
import cn.featherfly.common.function.serializable.SerializableToEnumFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction6;
import cn.featherfly.common.function.serializable.SerializableToLocalDateFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction6;
import cn.featherfly.common.function.serializable.SerializableToNumberFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.config.dsl.ConditionConfig;
import cn.featherfly.hammer.expression.condition.GroupEndExpression;
import cn.featherfly.hammer.expression.condition.GroupExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.EntityPropertyExpression6;
import cn.featherfly.hammer.expression.entity.condition.ba.EntityBetweenExpressionBase6;
import cn.featherfly.hammer.expression.entity.condition.co.EntityContainsExpressionBase6;
import cn.featherfly.hammer.expression.entity.condition.eq.EntityEqualsExpressionBase6;
import cn.featherfly.hammer.expression.entity.condition.ew.EntityEndWithExpressionBase6;
import cn.featherfly.hammer.expression.entity.condition.ge.EntityGreatEqualsExpressionBase6;
import cn.featherfly.hammer.expression.entity.condition.gt.EntityGreatThanExpressionBase6;
import cn.featherfly.hammer.expression.entity.condition.in.EntityInExpressionBase6;
import cn.featherfly.hammer.expression.entity.condition.inn.EntityIsNotNullExpressionBase6;
import cn.featherfly.hammer.expression.entity.condition.isn.EntityIsNullExpressionBase6;
import cn.featherfly.hammer.expression.entity.condition.le.EntityLessEqualsExpressionBase6;
import cn.featherfly.hammer.expression.entity.condition.lk.EntityLikeExpressionBase6;
import cn.featherfly.hammer.expression.entity.condition.lt.EntityLessThanExpressionBase6;
import cn.featherfly.hammer.expression.entity.condition.nba.EntityNotBetweenExpressionBase6;
import cn.featherfly.hammer.expression.entity.condition.nco.EntityNotContainsExpressionBase6;
import cn.featherfly.hammer.expression.entity.condition.ne.EntityNotEqualsExpressionBase6;
import cn.featherfly.hammer.expression.entity.condition.newv.EntityNotEndWithExpressionBase6;
import cn.featherfly.hammer.expression.entity.condition.ni.EntityNotInExpressionBase6;
import cn.featherfly.hammer.expression.entity.condition.nl.EntityNotLikeExpressionBase6;
import cn.featherfly.hammer.expression.entity.condition.nsw.EntityNotStartWithExpressionBase6;
import cn.featherfly.hammer.expression.entity.condition.property.EntityPropertyOnlyExpression;
import cn.featherfly.hammer.expression.entity.condition.sw.EntityStartWithExpressionBase6;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlRelation.EntityRelationMapping;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.EntityPropertyOnlyExpressionImpl;

/**
 * sql condition group builder sql条件逻辑组构造器 .
 *
 * @author zhongj
 * @param <T1> the element type
 * @param <T2> the generic type
 * @param <T3> the generic type
 * @param <T4> the generic type
 * @param <T5> the generic type
 * @param <T6> the generic type
 * @param <ER> the generic type
 * @param <B>  the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public abstract class AbstractMulitiEntitySqlConditionsGroupExpressionBase6<T1, T2, T3, T4, T5, T6,
    ER extends EntitySqlRelation<ER, B>, B extends SqlBuilder, C extends GroupExpression<C, L>,
    L extends GroupEndExpression<C, L>, C2 extends ConditionConfig<C2>>
    extends AbstractMulitiEntitySqlConditionsGroupExpressionBase5<T1, T2, T3, T4, T5, ER, B, C, L, C2>
    implements EntityBetweenExpressionBase6<T1, T2, T3, T4, T5, T6, C, L>,
    EntityNotBetweenExpressionBase6<T1, T2, T3, T4, T5, T6, C, L> //
    , EntityContainsExpressionBase6<T1, T2, T3, T4, T5, T6, C, L>,
    EntityNotContainsExpressionBase6<T1, T2, T3, T4, T5, T6, C, L> //
    , EntityEndWithExpressionBase6<T1, T2, T3, T4, T5, T6, C, L>,
    EntityNotEndWithExpressionBase6<T1, T2, T3, T4, T5, T6, C, L> //
    , EntityEqualsExpressionBase6<T1, T2, T3, T4, T5, T6, C, L>,
    EntityNotEqualsExpressionBase6<T1, T2, T3, T4, T5, T6, C, L> //
    , EntityGreatEqualsExpressionBase6<T1, T2, T3, T4, T5, T6, C, L>,
    EntityGreatThanExpressionBase6<T1, T2, T3, T4, T5, T6, C, L> //
    , EntityInExpressionBase6<T1, T2, T3, T4, T5, T6, C, L>, EntityNotInExpressionBase6<T1, T2, T3, T4, T5, T6, C, L> //
    , EntityIsNotNullExpressionBase6<T1, T2, T3, T4, T5, T6, C, L>,
    EntityIsNullExpressionBase6<T1, T2, T3, T4, T5, T6, C, L> //
    , EntityLessEqualsExpressionBase6<T1, T2, T3, T4, T5, T6, C, L>,
    EntityLessThanExpressionBase6<T1, T2, T3, T4, T5, T6, C, L> //
    , EntityStartWithExpressionBase6<T1, T2, T3, T4, T5, T6, C, L>,
    EntityNotStartWithExpressionBase6<T1, T2, T3, T4, T5, T6, C, L> //
    , EntityLikeExpressionBase6<T1, T2, T3, T4, T5, T6, C, L>,
    EntityNotLikeExpressionBase6<T1, T2, T3, T4, T5, T6, C, L> //
    , EntityPropertyExpression6<T1, T2, T3, T4, T5, T6, C, L> {

    /** The class mapping. */
    protected JdbcClassMapping<T6> classMapping6;

    /** The query alias 6. */
    protected String queryAlias6;

    /**
     * Instantiates a new abstract entity sql condition group expression base 4.
     *
     * @param parent            the parent
     * @param factory           the factory
     * @param entitySqlRelation the entity sql relation
     */
    @SuppressWarnings("unchecked")
    protected AbstractMulitiEntitySqlConditionsGroupExpressionBase6(L parent, JdbcMappingFactory factory,
        ER entitySqlRelation) {
        super(parent, factory, entitySqlRelation);

        EntityRelationMapping<?> erm = entitySqlRelation.getEntityRelationMappingTuple().getOrNull5();
        classMapping6 = (JdbcClassMapping<T6>) erm.getClassMapping();
        queryAlias6 = erm.getTableAlias();
    }

    // ****************************************************************************************************************
    //  eq
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L eq6(SerializableFunction<T6, R> name, R value) {
        return eq(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L eq6(SerializableFunction<T6, R> name, R value, Predicate<R> ignoreStrategy) {
        return eq(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L eq6(SerializableToDateFunction<T6, D> name, D value) {
        return eq(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L eq6(SerializableToDateFunction<T6, D> name, D value, Predicate<D> ignoreStrategy) {
        return eq(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(SerializableToDoubleFunction<T6> name, double value) {
        return eq(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(SerializableToDoubleFunction<T6> name, double value, DoublePredicate ignoreStrategy) {
        return eq(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L eq6(SerializableToEnumFunction<T6, E> name, E value) {
        return eq(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L eq6(SerializableToEnumFunction<T6, E> name, E value, Predicate<E> ignoreStrategy) {
        return eq(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(SerializableToCharFunction<T6> name, char value) {
        return eq(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(SerializableToCharFunction<T6> name, char value, CharPredicate ignoreStrategy) {
        return eq(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(SerializableToIntFunction<T6> name, int value) {
        return eq(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(SerializableToIntFunction<T6> name, int value, IntPredicate ignoreStrategy) {
        return eq(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(SerializableToLocalDateFunction<T6> name, LocalDate value) {
        return eq(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(SerializableToLocalDateFunction<T6> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return eq(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(SerializableToLocalDateTimeFunction<T6> name, LocalDateTime value) {
        return eq(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(SerializableToLocalDateTimeFunction<T6> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return eq(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(SerializableToLocalTimeFunction<T6> name, LocalTime value) {
        return eq(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(SerializableToLocalTimeFunction<T6> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return eq(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(SerializableToLongFunction<T6> name, long value) {
        return eq(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(SerializableToLongFunction<T6> name, long value, LongPredicate ignoreStrategy) {
        return eq(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L eq6(SerializableToNumberFunction<T6, N> name, N value) {
        return eq(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L eq6(SerializableToNumberFunction<T6, N> name, N value, Predicate<N> ignoreStrategy) {
        return eq(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(SerializableToStringFunction<T6> name, String value, MatchStrategy matchStrategy) {
        return eq(classMapping6, name, value, queryAlias6, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(SerializableToStringFunction<T6> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return eq(classMapping6, name, value, queryAlias6, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L eq6(SerializableDateSupplier<R> property) {
        return eq(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L eq6(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return eq(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(SerializableDoubleSupplier property) {
        return eq(classMapping6, property, property.getAsDouble(), queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return eq(classMapping6, property, property.getAsDouble(), queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L eq6(SerializableEnumSupplier<E> property) {
        return eq(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L eq6(SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy) {
        return eq(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(SerializableBooleanSupplier propertyValue) {
        return eq(classMapping6, propertyValue, propertyValue.getAsBoolean(), queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(SerializableBoolSupplier propertyValue) {
        return eq(classMapping6, propertyValue, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(SerializableBoolSupplier propertyValue, Predicate<Boolean> ignoreStrategy) {
        return eq(classMapping6, propertyValue, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(SerializableCharSupplier property) {
        return eq(classMapping6, property, property.get(), queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(SerializableCharSupplier property, CharPredicate ignoreStrategy) {
        return eq(classMapping6, property, property.get(), queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(SerializableIntSupplier property) {
        return eq(classMapping6, property, property.getAsInt(), queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return eq(classMapping6, property, property.getAsInt(), queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(SerializableLocalDateSupplier property) {
        return eq(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return eq(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(SerializableLocalDateTimeSupplier property) {
        return eq(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return eq(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(SerializableLocalTimeSupplier property) {
        return eq(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return eq(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(SerializableLongSupplier property) {
        return eq(classMapping6, property, property.getAsLong(), queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return eq(classMapping6, property, property.getAsLong(), queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L eq6(SerializableNumberSupplier<R> property) {
        return eq(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L eq6(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return eq(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return eq(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return eq(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L eq6(SerializableSupplier<R> property) {
        return eq(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L eq6(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return eq(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    // ****************************************************************************************************************
    //  ne
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ne6(SerializableFunction<T6, R> name, R value) {
        return ne(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ne6(SerializableFunction<T6, R> name, R value, Predicate<R> ignoreStrategy) {
        return ne(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ne6(SerializableToDateFunction<T6, D> name, D value) {
        return ne(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ne6(SerializableToDateFunction<T6, D> name, D value, Predicate<D> ignoreStrategy) {
        return ne(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(SerializableToDoubleFunction<T6> name, double value) {
        return ne(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(SerializableToDoubleFunction<T6> name, double value, DoublePredicate ignoreStrategy) {
        return ne(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ne6(SerializableToEnumFunction<T6, E> name, E value) {
        return ne(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ne6(SerializableToEnumFunction<T6, E> name, E value, Predicate<E> ignoreStrategy) {
        return ne(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(SerializableToIntFunction<T6> name, int value) {
        return ne(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(SerializableToIntFunction<T6> name, int value, IntPredicate ignoreStrategy) {
        return ne(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(SerializableToLocalDateFunction<T6> name, LocalDate value) {
        return ne(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(SerializableToLocalDateFunction<T6> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ne(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(SerializableToLocalDateTimeFunction<T6> name, LocalDateTime value) {
        return ne(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(SerializableToLocalDateTimeFunction<T6> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return ne(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(SerializableToLocalTimeFunction<T6> name, LocalTime value) {
        return ne(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(SerializableToLocalTimeFunction<T6> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ne(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(SerializableToLongFunction<T6> name, long value) {
        return ne(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(SerializableToLongFunction<T6> name, long value, LongPredicate ignoreStrategy) {
        return ne(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ne6(SerializableToNumberFunction<T6, N> name, N value) {
        return ne(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ne6(SerializableToNumberFunction<T6, N> name, N value, Predicate<N> ignoreStrategy) {
        return ne(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(SerializableToStringFunction<T6> name, String value, MatchStrategy matchStrategy) {
        return ne(classMapping6, name, value, queryAlias6, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(SerializableToStringFunction<T6> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ne(classMapping6, name, value, queryAlias6, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L ne6(SerializableDateSupplier<R> property) {
        return ne(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L ne6(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ne(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(SerializableDoubleSupplier property) {
        return ne(classMapping6, property, property.getAsDouble(), queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return ne(classMapping6, property, property.getAsDouble(), queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ne6(SerializableEnumSupplier<E> property) {
        return ne(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ne6(SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy) {
        return ne(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(SerializableBooleanSupplier propertyValue) {
        return ne(classMapping6, propertyValue, propertyValue.getAsBoolean(), queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(SerializableBoolSupplier propertyValue) {
        return ne(classMapping6, propertyValue, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(SerializableBoolSupplier propertyValue, Predicate<Boolean> ignoreStrategy) {
        return ne(classMapping6, propertyValue, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(SerializableCharSupplier propertyValue) {
        return ne(classMapping6, propertyValue, propertyValue.get(), queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(SerializableCharSupplier propertyValue, CharPredicate ignoreStrategy) {
        return ne(classMapping6, propertyValue, propertyValue.get(), queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(SerializableIntSupplier property) {
        return ne(classMapping6, property, property.getAsInt(), queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return ne(classMapping6, property, property.getAsInt(), queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(SerializableLocalDateSupplier property) {
        return ne(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return ne(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(SerializableLocalDateTimeSupplier property) {
        return ne(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return ne(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(SerializableLocalTimeSupplier property) {
        return ne(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return ne(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(SerializableLongSupplier property) {
        return ne(classMapping6, property, property.getAsLong(), queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return ne(classMapping6, property, property.getAsLong(), queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L ne6(SerializableNumberSupplier<R> property) {
        return ne(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L ne6(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ne(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return ne(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ne(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ne6(SerializableSupplier<R> property) {
        return ne(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ne6(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ne(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk6(SerializableFunction<T6, String> name, String value, MatchStrategy matchStrategy) {
        return lk(classMapping6, name, value, queryAlias6, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk6(SerializableFunction<T6, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return lk(classMapping6, name, value, queryAlias6, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk6(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return lk(classMapping6, property, queryAlias6, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk6(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return lk(classMapping6, property, queryAlias6, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl6(SerializableFunction<T6, String> name, String value, MatchStrategy matchStrategy) {
        return nl(classMapping6, name, value, queryAlias6, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl6(SerializableFunction<T6, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nl(classMapping6, name, value, queryAlias6, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl6(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return nl(classMapping6, property, queryAlias6, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl6(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nl(classMapping6, property, queryAlias6, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw6(SerializableFunction<T6, String> name, String value, MatchStrategy matchStrategy) {
        return sw(classMapping6, name, value, queryAlias6, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw6(SerializableFunction<T6, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return sw(classMapping6, name, value, queryAlias6, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw6(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return sw(classMapping6, property, queryAlias6, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw6(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return sw(classMapping6, property, queryAlias6, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw6(SerializableFunction<T6, String> name, String value, MatchStrategy matchStrategy) {
        return nsw(classMapping6, name, value, queryAlias6, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw6(SerializableFunction<T6, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nsw(classMapping6, name, value, queryAlias6, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw6(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return nsw(classMapping6, property, queryAlias6, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw6(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nsw(classMapping6, property, queryAlias6, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew6(SerializableFunction<T6, String> name, String value, MatchStrategy matchStrategy) {
        return ew(classMapping6, name, value, queryAlias6, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew6(SerializableFunction<T6, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ew(classMapping6, name, value, queryAlias6, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew6(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return ew(classMapping6, property, queryAlias6, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew6(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ew(classMapping6, property, queryAlias6, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L new6(SerializableFunction<T6, String> name, String value, MatchStrategy matchStrategy) {
        return newv(classMapping6, name, value, queryAlias6, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L new6(SerializableFunction<T6, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return newv(classMapping6, name, value, queryAlias6, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L new6(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return newv(classMapping6, property, queryAlias6, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L new6(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return newv(classMapping6, property, queryAlias6, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L co6(SerializableFunction<T6, String> name, String value, MatchStrategy matchStrategy) {
        return co(classMapping6, name, value, queryAlias6, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co6(SerializableFunction<T6, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return co(classMapping6, name, value, queryAlias6, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co6(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return co(classMapping6, property, queryAlias6, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co6(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return co(classMapping6, property, queryAlias6, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco6(SerializableFunction<T6, String> name, String value, MatchStrategy matchStrategy) {
        return nco(classMapping6, name, value, queryAlias6, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco6(SerializableFunction<T6, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nco(classMapping6, name, value, queryAlias6, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco6(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return nco(classMapping6, property, queryAlias6, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco6(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nco(classMapping6, property, queryAlias6, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ge6(SerializableFunction<T6, N> name, N value) {
        return ge(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ge6(SerializableFunction<T6, N> name, N value, Predicate<N> ignoreStrategy) {
        return ge(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ge6(SerializableFunction<T6, E> name, E value) {
        return ge(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ge6(SerializableFunction<T6, E> name, E value, Predicate<E> ignoreStrategy) {
        return ge(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableFunction<T6, String> name, String value, MatchStrategy matchStrategy) {
        return ge(classMapping6, name, value, matchStrategy, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableFunction<T6, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ge(classMapping6, name, value, matchStrategy, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ge6(SerializableEnumSupplier<E> property) {
        return ge(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ge6(SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy) {
        return ge(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return ge(classMapping6, property, matchStrategy, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ge(classMapping6, property, matchStrategy, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ge6(SerializableFunction<T6, D> name, D value) {
        return ge(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ge6(SerializableFunction<T6, D> name, D value, Predicate<D> ignoreStrategy) {
        return ge(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableFunction<T6, LocalTime> name, LocalTime value) {
        return ge(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableFunction<T6, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ge(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableFunction<T6, LocalDate> name, LocalDate value) {
        return ge(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableFunction<T6, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ge(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableFunction<T6, LocalDateTime> name, LocalDateTime value) {
        return ge(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableFunction<T6, LocalDateTime> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return ge(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableFunction<T6, String> name, String value) {
        return ge(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableFunction<T6, String> name, String value, Predicate<String> ignoreStrategy) {
        return ge(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableToIntFunction6<T6> name, int value) {
        return ge(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableToIntFunction6<T6> name, int value, IntPredicate ignoreStrategy) {
        return ge(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableToLongFunction6<T6> name, long value) {
        return ge(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableToLongFunction6<T6> name, long value, LongPredicate ignoreStrategy) {
        return ge(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableToDoubleFunction6<T6> name, double value) {
        return ge(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableToDoubleFunction6<T6> name, double value, DoublePredicate ignoreStrategy) {
        return ge(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L ge6(SerializableDateSupplier<R> property) {
        return ge(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L ge6(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ge(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L ge6(SerializableNumberSupplier<R> property) {
        return ge(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L ge6(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ge(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableLocalDateSupplier property) {
        return ge(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return ge(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableLocalTimeSupplier property) {
        return ge(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return ge(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableLocalDateTimeSupplier property) {
        return ge(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return ge(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableStringSupplier property) {
        return ge(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return ge(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableIntSupplier property) {
        return ge(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return ge(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableLongSupplier property) {
        return ge(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return ge(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableDoubleSupplier property) {
        return ge(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return ge(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L gt6(SerializableFunction<T6, N> name, N value) {
        return gt(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L gt6(SerializableFunction<T6, N> name, N value, Predicate<N> ignoreStrategy) {
        return gt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L gt6(SerializableFunction<T6, E> name, E value) {
        return gt(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L gt6(SerializableFunction<T6, E> name, E value, Predicate<E> ignoreStrategy) {
        return gt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableFunction<T6, String> name, String value, MatchStrategy matchStrategy) {
        return gt(classMapping6, name, value, matchStrategy, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableFunction<T6, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return gt(classMapping6, name, value, matchStrategy, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L gt6(SerializableEnumSupplier<E> property) {
        return gt(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L gt6(SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy) {
        return gt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return gt(classMapping6, property, matchStrategy, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return gt(classMapping6, property, matchStrategy, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L gt6(SerializableFunction<T6, D> name, D value) {
        return gt(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L gt6(SerializableFunction<T6, D> name, D value, Predicate<D> ignoreStrategy) {
        return gt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableFunction<T6, LocalTime> name, LocalTime value) {
        return gt(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableFunction<T6, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return gt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableFunction<T6, LocalDate> name, LocalDate value) {
        return gt(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableFunction<T6, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return gt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableFunction<T6, LocalDateTime> name, LocalDateTime value) {
        return gt(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableFunction<T6, LocalDateTime> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return gt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableFunction<T6, String> name, String value) {
        return gt(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableFunction<T6, String> name, String value, Predicate<String> ignoreStrategy) {
        return gt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableToIntFunction6<T6> name, int value) {
        return gt(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableToIntFunction6<T6> name, int value, IntPredicate ignoreStrategy) {
        return gt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableToLongFunction6<T6> name, long value) {
        return gt(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableToLongFunction6<T6> name, long value, LongPredicate ignoreStrategy) {
        return gt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableToDoubleFunction6<T6> name, double value) {
        return gt(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableToDoubleFunction6<T6> name, double value, DoublePredicate ignoreStrategy) {
        return gt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L gt6(SerializableNumberSupplier<R> property) {
        return gt(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L gt6(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return gt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L gt6(SerializableDateSupplier<R> property) {
        return gt(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L gt6(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return gt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableLocalDateSupplier property) {
        return gt(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return gt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableLocalTimeSupplier property) {
        return gt(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return gt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableLocalDateTimeSupplier property) {
        return gt(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return gt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableStringSupplier property) {
        return gt(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return gt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableIntSupplier property) {
        return gt(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return gt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableLongSupplier property) {
        return gt(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return gt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableDoubleSupplier property) {
        return gt(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return gt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L le6(SerializableFunction<T6, N> name, N value) {
        return le(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L le6(SerializableFunction<T6, N> name, N value, Predicate<N> ignoreStrategy) {
        return le(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L le6(SerializableFunction<T6, E> name, E value) {
        return le(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L le6(SerializableFunction<T6, E> name, E value, Predicate<E> ignoreStrategy) {
        return le(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableFunction<T6, String> name, String value, MatchStrategy matchStrategy) {
        return le(classMapping6, name, value, matchStrategy, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableFunction<T6, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return le(classMapping6, name, value, matchStrategy, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L le6(SerializableEnumSupplier<E> property) {
        return le(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L le6(SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy) {
        return le(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return le(classMapping6, property, matchStrategy, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return le(classMapping6, property, matchStrategy, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L le6(SerializableFunction<T6, D> name, D value) {
        return le(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L le6(SerializableFunction<T6, D> name, D value, Predicate<D> ignoreStrategy) {
        return le(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableFunction<T6, LocalTime> name, LocalTime value) {
        return le(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableFunction<T6, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return le(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableFunction<T6, LocalDate> name, LocalDate value) {
        return le(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableFunction<T6, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return le(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableFunction<T6, LocalDateTime> name, LocalDateTime value) {
        return le(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableFunction<T6, LocalDateTime> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return le(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableFunction<T6, String> name, String value) {
        return le(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableFunction<T6, String> name, String value, Predicate<String> ignoreStrategy) {
        return le(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L le6(SerializableDateSupplier<R> property) {
        return le(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L le6(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return le(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L le6(SerializableNumberSupplier<R> property) {
        return le(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L le6(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return le(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableLocalDateSupplier property) {
        return le(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return le(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableLocalTimeSupplier property) {
        return le(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return le(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableLocalDateTimeSupplier property) {
        return le(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return le(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableStringSupplier property) {
        return le(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return le(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableToIntFunction6<T6> name, int value) {
        return le(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableToIntFunction6<T6> name, int value, IntPredicate ignoreStrategy) {
        return le(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableToLongFunction6<T6> name, long value) {
        return le(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableToLongFunction6<T6> name, long value, LongPredicate ignoreStrategy) {
        return le(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableToDoubleFunction6<T6> name, double value) {
        return le(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableToDoubleFunction6<T6> name, double value, DoublePredicate ignoreStrategy) {
        return le(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableIntSupplier property) {
        return le(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return le(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableLongSupplier property) {
        return le(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return le(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableDoubleSupplier property) {
        return le(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return le(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L lt6(SerializableFunction<T6, N> name, N value) {
        return lt(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L lt6(SerializableFunction<T6, N> name, N value, Predicate<N> ignoreStrategy) {
        return lt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L lt6(SerializableFunction<T6, E> name, E value) {
        return lt(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L lt6(SerializableFunction<T6, E> name, E value, Predicate<E> ignoreStrategy) {
        return lt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableFunction<T6, String> name, String value, MatchStrategy matchStrategy) {
        return lt(classMapping6, name, value, matchStrategy, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableFunction<T6, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return lt(classMapping6, name, value, matchStrategy, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L lt6(SerializableEnumSupplier<E> property) {
        return lt(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L lt6(SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy) {
        return lt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return lt(classMapping6, property, matchStrategy, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return lt(classMapping6, property, matchStrategy, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L lt6(SerializableFunction<T6, D> name, D value) {
        return lt(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L lt6(SerializableFunction<T6, D> name, D value, Predicate<D> ignoreStrategy) {
        return lt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableFunction<T6, LocalTime> name, LocalTime value) {
        return lt(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableFunction<T6, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return lt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableFunction<T6, LocalDate> name, LocalDate value) {
        return lt(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableFunction<T6, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return lt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableFunction<T6, LocalDateTime> name, LocalDateTime value) {
        return lt(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableFunction<T6, LocalDateTime> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return lt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableFunction<T6, String> name, String value) {
        return lt(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableFunction<T6, String> name, String value, Predicate<String> ignoreStrategy) {
        return lt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L lt6(SerializableNumberSupplier<R> property) {
        return lt(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L lt6(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return lt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L lt6(SerializableDateSupplier<R> property) {
        return lt(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L lt6(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return lt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableLocalDateSupplier property) {
        return lt(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return lt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableLocalTimeSupplier property) {
        return lt(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return lt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableLocalDateTimeSupplier property) {
        return lt(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return lt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableStringSupplier property) {
        return lt(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return lt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableToIntFunction6<T6> name, int value) {
        return lt(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableToIntFunction6<T6> name, int value, IntPredicate ignoreStrategy) {
        return lt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableToLongFunction6<T6> name, long value) {
        return lt(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableToLongFunction6<T6> name, long value, LongPredicate ignoreStrategy) {
        return lt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableToDoubleFunction6<T6> name, double value) {
        return lt(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableToDoubleFunction6<T6> name, double value, DoublePredicate ignoreStrategy) {
        return lt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableIntSupplier property) {
        return lt(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return lt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableLongSupplier property) {
        return lt(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return lt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableDoubleSupplier property) {
        return lt(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return lt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in6(SerializableFunction<T6, R> name, R value) {
        return in(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in6(SerializableFunction<T6, R> name, R value, Predicate<R> ignoreStrategy) {
        return in(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in6(SerializableFunction<T6, R> name, @SuppressWarnings("unchecked") R... value) {
        return in(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in6(SerializableFunction<T6, R> name, R[] value, Predicate<R[]> ignoreStrategy) {
        return in(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in6(SerializableFunction<T6, R> name, Collection<R> value) {
        return in(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in6(SerializableFunction<T6, R> name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy) {
        return in(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in6(SerializableSupplier<R> property) {
        return in(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in6(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return in(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in6(SerializableToIntFunction6<T6> name, int value) {
        return in(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in6(SerializableToIntFunction6<T6> name, int value, IntPredicate ignoreStrategy) {
        return in(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in6(SerializableToLongFunction6<T6> name, long value) {
        return in(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in6(SerializableToLongFunction6<T6> name, long value, LongPredicate ignoreStrategy) {
        return in(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in6(SerializableToDoubleFunction<T6> name, double value) {
        return in(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in6(SerializableToDoubleFunction<T6> name, double value, DoublePredicate ignoreStrategy) {
        return in(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in6(SerializableToDoubleFunction6<T6> name, double... value) {
        return in(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in6(SerializableToDoubleFunction6<T6> name, double[] value, Predicate<double[]> ignoreStrategy) {
        return in(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in6(SerializableToIntFunction6<T6> name, int... value) {
        return in(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in6(SerializableToLongFunction6<T6> name, long... value) {
        return in(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in6(SerializableToIntFunction6<T6> name, int[] value, Predicate<int[]> ignoreStrategy) {
        return in(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in6(SerializableToLongFunction6<T6> name, long[] value, Predicate<long[]> ignoreStrategy) {
        return in(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in6(SerializableToStringFunction<T6> name, String value, MatchStrategy matchStrategy) {
        return in(classMapping6, name, value, matchStrategy, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in6(SerializableToStringFunction<T6> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return in(classMapping6, name, value, matchStrategy, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in6(SerializableToStringFunction<T6> name, String[] value, MatchStrategy matchStrategy) {
        return in(classMapping6, name, value, matchStrategy, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in6(SerializableToStringFunction<T6> name, String[] value, MatchStrategy matchStrategy,
        Predicate<String[]> ignoreStrategy) {
        return in(classMapping6, name, value, matchStrategy, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in6(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return in(classMapping6, property, matchStrategy, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in6(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return in(classMapping6, property, matchStrategy, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in6(SerializableIntSupplier property) {
        return in(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in6(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return in(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in6(SerializableLongSupplier property) {
        return in(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in6(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return in(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in6(SerializableDoubleSupplier property) {
        return in(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in6(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return in(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni6(SerializableFunction<T6, R> name, R value) {
        return ni(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni6(SerializableFunction<T6, R> name, R value, Predicate<R> ignoreStrategy) {
        return ni(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni6(SerializableFunction<T6, R> name, @SuppressWarnings("unchecked") R... value) {
        return ni(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni6(SerializableFunction<T6, R> name, R[] value, Predicate<R[]> ignoreStrategy) {
        return ni(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni6(SerializableFunction<T6, R> name, Collection<R> value) {
        return ni(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni6(SerializableFunction<T6, R> name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy) {
        return ni(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni6(SerializableSupplier<R> property) {
        return ni(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni6(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ni(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni6(SerializableToIntFunction6<T6> name, int value) {
        return ni(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni6(SerializableToIntFunction6<T6> name, int value, IntPredicate ignoreStrategy) {
        return ni(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni6(SerializableToLongFunction6<T6> name, long value) {
        return ni(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni6(SerializableToLongFunction6<T6> name, long value, LongPredicate ignoreStrategy) {
        return ni(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni6(SerializableToDoubleFunction<T6> name, double value) {
        return ni(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni6(SerializableToDoubleFunction<T6> name, double value, DoublePredicate ignoreStrategy) {
        return ni(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni6(SerializableToDoubleFunction6<T6> name, double... value) {
        return ni(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni6(SerializableToDoubleFunction6<T6> name, double[] value, Predicate<double[]> ignoreStrategy) {
        return ni(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni6(SerializableToIntFunction6<T6> name, int... value) {
        return ni(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni6(SerializableToLongFunction6<T6> name, long... value) {
        return ni(classMapping6, name, value, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni6(SerializableToIntFunction6<T6> name, int[] value, Predicate<int[]> ignoreStrategy) {
        return ni(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni6(SerializableToLongFunction6<T6> name, long[] value, Predicate<long[]> ignoreStrategy) {
        return ni(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni6(SerializableToStringFunction<T6> name, String value, MatchStrategy matchStrategy) {
        return ni(classMapping6, name, value, matchStrategy, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni6(SerializableToStringFunction<T6> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ni(classMapping6, name, value, matchStrategy, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni6(SerializableToStringFunction<T6> name, String[] value, MatchStrategy matchStrategy) {
        return ni(classMapping6, name, value, matchStrategy, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni6(SerializableToStringFunction<T6> name, String[] value, MatchStrategy matchStrategy,
        Predicate<String[]> ignoreStrategy) {
        return ni(classMapping6, name, value, matchStrategy, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni6(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return ni(classMapping6, property, matchStrategy, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni6(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ni(classMapping6, property, matchStrategy, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni6(SerializableIntSupplier property) {
        return ni(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni6(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return ni(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni6(SerializableLongSupplier property) {
        return ni(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni6(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return ni(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni6(SerializableDoubleSupplier property) {
        return ni(classMapping6, property, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni6(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return ni(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L inn6(SerializableFunction<T6, R> name, Boolean value) {
        return inn(classMapping6, name, value, queryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L isn6(SerializableFunction<T6, R> name, Boolean value) {
        return isn(classMapping6, name, value, queryAlias6);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba6(SerializableToIntFunction<T6> name, int min, int max) {
        return ba(classMapping, name, min, max, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba6(SerializableToIntFunction<T6> name, int min, int max, BiPredicate<Integer, Integer> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba6(SerializableToLongFunction<T6> name, long min, long max) {
        return ba(classMapping, name, min, max, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba6(SerializableToLongFunction<T6> name, long min, long max, BiPredicate<Long, Long> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba6(SerializableToDoubleFunction<T6> name, double min, double max) {
        return ba(classMapping, name, min, max, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba6(SerializableToDoubleFunction<T6> name, double min, double max,
        BiPredicate<Double, Double> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ba6(SerializableToNumberFunction<T6, N> name, N min, N max) {
        return ba(classMapping, name, min, max, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ba6(SerializableToNumberFunction<T6, N> name, N min, N max,
        BiPredicate<N, N> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ba6(SerializableToDateFunction<T6, D> name, D min, D max) {
        return ba(classMapping, name, min, max, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ba6(SerializableToDateFunction<T6, D> name, D min, D max,
        BiPredicate<D, D> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ba6(SerializableToEnumFunction<T6, E> name, E min, E max) {
        return ba(classMapping, name, min, max, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ba6(SerializableToEnumFunction<T6, E> name, E min, E max,
        BiPredicate<E, E> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba6(SerializableToLocalTimeFunction<T6> name, LocalTime min, LocalTime max) {
        return ba(classMapping, name, min, max, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba6(SerializableToLocalTimeFunction<T6> name, LocalTime min, LocalTime max,
        BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba6(SerializableToLocalDateFunction<T6> name, LocalDate min, LocalDate max) {
        return ba(classMapping, name, min, max, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba6(SerializableToLocalDateFunction<T6> name, LocalDate min, LocalDate max,
        BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba6(SerializableToLocalDateTimeFunction<T6> name, LocalDateTime min, LocalDateTime max) {
        return ba(classMapping, name, min, max, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba6(SerializableToLocalDateTimeFunction<T6> name, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba6(SerializableToStringFunction<T6> name, String min, String max) {
        return ba(classMapping, name, min, max, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba6(SerializableToStringFunction<T6> name, String min, String max,
        BiPredicate<String, String> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias6, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba6(SerializableToIntFunction<T6> name, int min, int max) {
        return nba(classMapping, name, min, max, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba6(SerializableToIntFunction<T6> name, int min, int max, BiPredicate<Integer, Integer> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba6(SerializableToLongFunction<T6> name, long min, long max) {
        return nba(classMapping, name, min, max, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba6(SerializableToLongFunction<T6> name, long min, long max, BiPredicate<Long, Long> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba6(SerializableToDoubleFunction<T6> name, double min, double max) {
        return nba(classMapping, name, min, max, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba6(SerializableToDoubleFunction<T6> name, double min, double max,
        BiPredicate<Double, Double> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L nba6(SerializableToNumberFunction<T6, N> name, N min, N max) {
        return nba(classMapping, name, min, max, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L nba6(SerializableToNumberFunction<T6, N> name, N min, N max,
        BiPredicate<N, N> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L nba6(SerializableToDateFunction<T6, D> name, D min, D max) {
        return nba(classMapping, name, min, max, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L nba6(SerializableToDateFunction<T6, D> name, D min, D max,
        BiPredicate<D, D> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L nba6(SerializableToEnumFunction<T6, E> name, E min, E max) {
        return nba(classMapping, name, min, max, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L nba6(SerializableToEnumFunction<T6, E> name, E min, E max,
        BiPredicate<E, E> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba6(SerializableToLocalTimeFunction<T6> name, LocalTime min, LocalTime max) {
        return nba(classMapping, name, min, max, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba6(SerializableToLocalTimeFunction<T6> name, LocalTime min, LocalTime max,
        BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba6(SerializableToLocalDateFunction<T6> name, LocalDate min, LocalDate max) {
        return nba(classMapping, name, min, max, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba6(SerializableToLocalDateFunction<T6> name, LocalDate min, LocalDate max,
        BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba6(SerializableToLocalDateTimeFunction<T6> name, LocalDateTime min, LocalDateTime max) {
        return nba(classMapping, name, min, max, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba6(SerializableToLocalDateTimeFunction<T6> name, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba6(SerializableToStringFunction<T6> name, String min, String max) {
        return nba(classMapping, name, min, max, queryAlias6, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba6(SerializableToStringFunction<T6> name, String min, String max,
        BiPredicate<String, String> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias6, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @SuppressWarnings("unchecked")
    /**
     * {@inheritDoc}
     */
    @Override
    public L property(SixArgusFunction<EntityPropertyOnlyExpression<T1>, EntityPropertyOnlyExpression<T2>,
        EntityPropertyOnlyExpression<T3>, EntityPropertyOnlyExpression<T4>, EntityPropertyOnlyExpression<T5>,
        EntityPropertyOnlyExpression<T6>, LogicExpression<?, ?>> entityPropertyConsumer) {
        return (L) entityPropertyConsumer.apply(
            new EntityPropertyOnlyExpressionImpl<>(0, this, factory, entityRelation),
            new EntityPropertyOnlyExpressionImpl<>(1, this, factory, entityRelation),
            new EntityPropertyOnlyExpressionImpl<>(2, this, factory, entityRelation),
            new EntityPropertyOnlyExpressionImpl<>(3, this, factory, entityRelation),
            new EntityPropertyOnlyExpressionImpl<>(4, this, factory, entityRelation),
            new EntityPropertyOnlyExpressionImpl<>(5, this, factory, entityRelation));
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
        return 5;
    }
}
