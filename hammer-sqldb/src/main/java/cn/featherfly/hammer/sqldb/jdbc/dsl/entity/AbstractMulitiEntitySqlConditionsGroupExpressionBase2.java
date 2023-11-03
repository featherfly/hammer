
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Date;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.CharPredicate;
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
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction2;
import cn.featherfly.common.function.serializable.SerializableToEnumFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction2;
import cn.featherfly.common.function.serializable.SerializableToLocalDateFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction2;
import cn.featherfly.common.function.serializable.SerializableToNumberFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.config.dsl.ConditionConfig;
import cn.featherfly.hammer.expression.condition.GroupEndExpression;
import cn.featherfly.hammer.expression.condition.GroupExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.EntityPropertyExpression2;
import cn.featherfly.hammer.expression.entity.condition.ba.EntityBetweenExpressionBase2;
import cn.featherfly.hammer.expression.entity.condition.co.EntityContainsExpressionBase2;
import cn.featherfly.hammer.expression.entity.condition.eq.EntityEqualsExpressionBase2;
import cn.featherfly.hammer.expression.entity.condition.ew.EntityEndWithExpressionBase2;
import cn.featherfly.hammer.expression.entity.condition.ge.EntityGreatEqualsExpressionBase2;
import cn.featherfly.hammer.expression.entity.condition.gt.EntityGreatThanExpressionBase2;
import cn.featherfly.hammer.expression.entity.condition.in.EntityInExpressionBase2;
import cn.featherfly.hammer.expression.entity.condition.inn.EntityIsNotNullExpressionBase2;
import cn.featherfly.hammer.expression.entity.condition.isn.EntityIsNullExpressionBase2;
import cn.featherfly.hammer.expression.entity.condition.le.EntityLessEqualsExpressionBase2;
import cn.featherfly.hammer.expression.entity.condition.lk.EntityLikeExpressionBase2;
import cn.featherfly.hammer.expression.entity.condition.lt.EntityLessThanExpressionBase2;
import cn.featherfly.hammer.expression.entity.condition.nba.EntityNotBetweenExpressionBase2;
import cn.featherfly.hammer.expression.entity.condition.nco.EntityNotContainsExpressionBase2;
import cn.featherfly.hammer.expression.entity.condition.ne.EntityNotEqualsExpressionBase2;
import cn.featherfly.hammer.expression.entity.condition.newv.EntityNotEndWithExpressionBase2;
import cn.featherfly.hammer.expression.entity.condition.ni.EntityNotInExpressionBase2;
import cn.featherfly.hammer.expression.entity.condition.nl.EntityNotLikeExpressionBase2;
import cn.featherfly.hammer.expression.entity.condition.nsw.EntityNotStartWithExpressionBase2;
import cn.featherfly.hammer.expression.entity.condition.property.EntityPropertyOnlyExpression;
import cn.featherfly.hammer.expression.entity.condition.sw.EntityStartWithExpressionBase2;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlRelation.EntityRelationMapping;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.EntityPropertyOnlyExpressionImpl;

/**
 * sql condition group builder sql条件逻辑组构造器 .
 *
 * @author zhongj
 * @param <T1> the element type
 * @param <T2> the generic type
 * @param <ER> the generic type
 * @param <B>  the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public abstract class AbstractMulitiEntitySqlConditionsGroupExpressionBase2<T1, T2, ER extends EntitySqlRelation<ER, B>,
    B extends SqlBuilder, C extends GroupExpression<C, L>, L extends GroupEndExpression<C, L>,
    C2 extends ConditionConfig<C2>> extends AbstractMulitiEntitySqlConditionsGroupExpressionBase<T1, ER, B, C, L, C2>
    implements EntityBetweenExpressionBase2<T1, T2, C, L>, EntityNotBetweenExpressionBase2<T1, T2, C, L> //
    , EntityContainsExpressionBase2<T1, T2, C, L>, EntityNotContainsExpressionBase2<T1, T2, C, L> //
    , EntityEndWithExpressionBase2<T1, T2, C, L>, EntityNotEndWithExpressionBase2<T1, T2, C, L>//
    , EntityEqualsExpressionBase2<T1, T2, C, L>, EntityNotEqualsExpressionBase2<T1, T2, C, L> //
    , EntityGreatEqualsExpressionBase2<T1, T2, C, L>, EntityGreatThanExpressionBase2<T1, T2, C, L> //
    , EntityInExpressionBase2<T1, T2, C, L>, EntityNotInExpressionBase2<T1, T2, C, L> //
    , EntityIsNotNullExpressionBase2<T1, T2, C, L>, EntityIsNullExpressionBase2<T1, T2, C, L> //
    , EntityLessEqualsExpressionBase2<T1, T2, C, L>, EntityLessThanExpressionBase2<T1, T2, C, L> //
    , EntityStartWithExpressionBase2<T1, T2, C, L>, EntityNotStartWithExpressionBase2<T1, T2, C, L> //
    , EntityLikeExpressionBase2<T1, T2, C, L>, EntityNotLikeExpressionBase2<T1, T2, C, L> //
    , EntityPropertyExpression2<T1, T2, C, L> {

    /** The class mapping. */
    protected JdbcClassMapping<T2> classMapping2;

    /** The query alias. */
    protected String queryAlias2;

    /**
     * Instantiates a new abstract entity sql condition group expression base 2.
     *
     * @param parent            the parent
     * @param factory           the factory
     * @param entitySqlRelation the entity sql relation
     */
    @SuppressWarnings("unchecked")
    protected AbstractMulitiEntitySqlConditionsGroupExpressionBase2(L parent, JdbcMappingFactory factory,
        ER entitySqlRelation) {
        super(parent, factory, entitySqlRelation);
        EntityRelationMapping<?> erm = entitySqlRelation.getEntityRelationMappingTuple().getOrNull1();
        classMapping2 = (JdbcClassMapping<T2>) erm.getClassMapping();
        queryAlias2 = erm.getTableAlias();
    }

    // ****************************************************************************************************************
    //	eq
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L eq2(SerializableFunction<T2, R> name, R value) {
        return eq(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L eq2(SerializableFunction<T2, R> name, R value, Predicate<R> ignoreStrategy) {
        return eq(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L eq2(SerializableToDateFunction<T2, D> name, D value) {
        return eq(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L eq2(SerializableToDateFunction<T2, D> name, D value, Predicate<D> ignoreStrategy) {
        return eq(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(SerializableToDoubleFunction<T2> name, double value) {
        return eq(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(SerializableToDoubleFunction<T2> name, double value, DoublePredicate ignoreStrategy) {
        return eq(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L eq2(SerializableToEnumFunction<T2, E> name, E value) {
        return eq(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L eq2(SerializableToEnumFunction<T2, E> name, E value, Predicate<E> ignoreStrategy) {
        return eq(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(SerializableToCharFunction<T2> name, char value) {
        return eq(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(SerializableToCharFunction<T2> name, char value, CharPredicate ignoreStrategy) {
        return eq(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(SerializableToIntFunction<T2> name, int value) {
        return eq(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(SerializableToIntFunction<T2> name, int value, IntPredicate ignoreStrategy) {
        return eq(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(SerializableToLocalDateFunction<T2> name, LocalDate value) {
        return eq(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(SerializableToLocalDateFunction<T2> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return eq(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(SerializableToLocalDateTimeFunction<T2> name, LocalDateTime value) {
        return eq(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(SerializableToLocalDateTimeFunction<T2> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return eq(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(SerializableToLocalTimeFunction<T2> name, LocalTime value) {
        return eq(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(SerializableToLocalTimeFunction<T2> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return eq(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(SerializableToLongFunction<T2> name, long value) {
        return eq(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(SerializableToLongFunction<T2> name, long value, LongPredicate ignoreStrategy) {
        return eq(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L eq2(SerializableToNumberFunction<T2, N> name, N value) {
        return eq(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L eq2(SerializableToNumberFunction<T2, N> name, N value, Predicate<N> ignoreStrategy) {
        return eq(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(SerializableToStringFunction<T2> name, String value, MatchStrategy matchStrategy) {
        return eq(classMapping2, name, value, queryAlias2, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(SerializableToStringFunction<T2> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return eq(classMapping2, name, value, queryAlias2, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L eq2(SerializableDateSupplier<R> property) {
        return eq(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L eq2(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return eq(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(SerializableDoubleSupplier property) {
        return eq(classMapping2, property, property.getAsDouble(), queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return eq(classMapping2, property, property.getAsDouble(), queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L eq2(SerializableEnumSupplier<E> property) {
        return eq(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L eq2(SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy) {
        return eq(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(SerializableBooleanSupplier propertyValue) {
        return eq(classMapping2, propertyValue, propertyValue.getAsBoolean(), queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(SerializableBoolSupplier propertyValue) {
        return eq(classMapping2, propertyValue, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(SerializableBoolSupplier propertyValue, Predicate<Boolean> ignoreStrategy) {
        return eq(classMapping2, propertyValue, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(SerializableCharSupplier propertyValue) {
        return eq(classMapping2, propertyValue, propertyValue.get(), queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(SerializableCharSupplier propertyValue, CharPredicate ignoreStrategy) {
        return eq(classMapping2, propertyValue, propertyValue.get(), queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(SerializableIntSupplier property) {
        return eq(classMapping2, property, property.getAsInt(), queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return eq(classMapping2, property, property.getAsInt(), queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(SerializableLocalDateSupplier property) {
        return eq(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return eq(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(SerializableLocalDateTimeSupplier property) {
        return eq(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return eq(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(SerializableLocalTimeSupplier property) {
        return eq(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return eq(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(SerializableLongSupplier property) {
        return eq(classMapping2, property, property.getAsLong(), queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return eq(classMapping2, property, property.getAsLong(), queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L eq2(SerializableNumberSupplier<R> property) {
        return eq(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L eq2(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return eq(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return eq(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return eq(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L eq2(SerializableSupplier<R> property) {
        return eq(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L eq2(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return eq(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    // ****************************************************************************************************************
    //	ne
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ne2(SerializableFunction<T2, R> name, R value) {
        return ne(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ne2(SerializableFunction<T2, R> name, R value, Predicate<R> ignoreStrategy) {
        return ne(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ne2(SerializableToDateFunction<T2, D> name, D value) {
        return ne(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ne2(SerializableToDateFunction<T2, D> name, D value, Predicate<D> ignoreStrategy) {
        return ne(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(SerializableToDoubleFunction<T2> name, double value) {
        return ne(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(SerializableToDoubleFunction<T2> name, double value, DoublePredicate ignoreStrategy) {
        return ne(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ne2(SerializableToEnumFunction<T2, E> name, E value) {
        return ne(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ne2(SerializableToEnumFunction<T2, E> name, E value, Predicate<E> ignoreStrategy) {
        return ne(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(SerializableToIntFunction<T2> name, int value) {
        return ne(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(SerializableToIntFunction<T2> name, int value, IntPredicate ignoreStrategy) {
        return ne(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(SerializableToLocalDateFunction<T2> name, LocalDate value) {
        return ne(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(SerializableToLocalDateFunction<T2> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ne(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(SerializableToLocalDateTimeFunction<T2> name, LocalDateTime value) {
        return ne(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(SerializableToLocalDateTimeFunction<T2> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return ne(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(SerializableToLocalTimeFunction<T2> name, LocalTime value) {
        return ne(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(SerializableToLocalTimeFunction<T2> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ne(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(SerializableToLongFunction<T2> name, long value) {
        return ne(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(SerializableToLongFunction<T2> name, long value, LongPredicate ignoreStrategy) {
        return ne(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ne2(SerializableToNumberFunction<T2, N> name, N value) {
        return ne(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ne2(SerializableToNumberFunction<T2, N> name, N value, Predicate<N> ignoreStrategy) {
        return ne(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(SerializableToStringFunction<T2> name, String value, MatchStrategy matchStrategy) {
        return ne(classMapping2, name, value, queryAlias2, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(SerializableToStringFunction<T2> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ne(classMapping2, name, value, queryAlias2, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L ne2(SerializableDateSupplier<R> property) {
        return ne(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L ne2(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ne(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(SerializableDoubleSupplier property) {
        return ne(classMapping2, property, property.getAsDouble(), queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return ne(classMapping2, property, property.getAsDouble(), queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ne2(SerializableEnumSupplier<E> property) {
        return ne(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ne2(SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy) {
        return ne(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(SerializableBooleanSupplier propertyValue) {
        return ne(classMapping2, propertyValue, propertyValue.getAsBoolean(), queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(SerializableBoolSupplier propertyValue) {
        return ne(classMapping2, propertyValue, propertyValue.get(), queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(SerializableBoolSupplier propertyValue, Predicate<Boolean> ignoreStrategy) {
        return ne(classMapping2, propertyValue, propertyValue.get(), queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(SerializableCharSupplier propertyValue) {
        return ne(classMapping2, propertyValue, propertyValue.get(), queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(SerializableCharSupplier propertyValue, CharPredicate ignoreStrategy) {
        return ne(classMapping2, propertyValue, propertyValue.get(), queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(SerializableIntSupplier property) {
        return ne(classMapping2, property, property.get(), queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return ne(classMapping2, property, property.getAsInt(), queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(SerializableLocalDateSupplier property) {
        return ne(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return ne(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(SerializableLocalDateTimeSupplier property) {
        return ne(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return ne(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(SerializableLocalTimeSupplier property) {
        return ne(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return ne(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(SerializableLongSupplier property) {
        return ne(classMapping2, property, property.getAsLong(), queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return ne(classMapping2, property, property.getAsLong(), queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L ne2(SerializableNumberSupplier<R> property) {
        return ne(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L ne2(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ne(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return ne(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ne(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ne2(SerializableSupplier<R> property) {
        return ne(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ne2(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ne(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk2(SerializableFunction<T2, String> name, String value, MatchStrategy matchStrategy) {
        return lk(classMapping2, name, value, queryAlias2, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk2(SerializableFunction<T2, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return lk(classMapping2, name, value, queryAlias2, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk2(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return lk(classMapping2, property, queryAlias2, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk2(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return lk(classMapping2, property, queryAlias2, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl2(SerializableFunction<T2, String> name, String value, MatchStrategy matchStrategy) {
        return nl(classMapping, name, value, queryAlias2, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl2(SerializableFunction<T2, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nl(classMapping, name, value, queryAlias2, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl2(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return nl(classMapping, property, queryAlias2, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl2(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nl(classMapping, property, queryAlias2, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw2(SerializableFunction<T2, String> name, String value, MatchStrategy matchStrategy) {
        return sw(classMapping2, name, value, queryAlias2, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw2(SerializableFunction<T2, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return sw(classMapping2, name, value, queryAlias2, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw2(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return sw(classMapping2, property, queryAlias2, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw2(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return sw(classMapping2, property, queryAlias2, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw2(SerializableFunction<T2, String> name, String value, MatchStrategy matchStrategy) {
        return nsw(classMapping, name, value, queryAlias2, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw2(SerializableFunction<T2, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nsw(classMapping, name, value, queryAlias2, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw2(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return nsw(classMapping, property, queryAlias2, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw2(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nsw(classMapping, property, queryAlias2, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew2(SerializableFunction<T2, String> name, String value, MatchStrategy matchStrategy) {
        return ew(classMapping2, name, value, queryAlias2, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew2(SerializableFunction<T2, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ew(classMapping2, name, value, queryAlias2, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew2(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return ew(classMapping2, property, queryAlias2, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew2(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ew(classMapping2, property, queryAlias2, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L new2(SerializableFunction<T2, String> name, String value, MatchStrategy matchStrategy) {
        return newv(classMapping, name, value, queryAlias2, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L new2(SerializableFunction<T2, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return newv(classMapping, name, value, queryAlias2, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L new2(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return newv(classMapping, property, queryAlias2, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L new2(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return newv(classMapping, property, queryAlias2, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L co2(SerializableFunction<T2, String> name, String value, MatchStrategy matchStrategy) {
        return co(classMapping2, name, value, queryAlias2, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co2(SerializableFunction<T2, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return co(classMapping2, name, value, queryAlias2, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co2(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return co(classMapping2, property, queryAlias2, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co2(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return co(classMapping2, property, queryAlias2, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco2(SerializableFunction<T2, String> name, String value, MatchStrategy matchStrategy) {
        return nco(classMapping, name, value, queryAlias2, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco2(SerializableFunction<T2, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nco(classMapping, name, value, queryAlias2, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco2(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return nco(classMapping, property, queryAlias2, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco2(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nco(classMapping, property, queryAlias2, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ge2(SerializableFunction<T2, N> name, N value) {
        return ge(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ge2(SerializableFunction<T2, N> name, N value, Predicate<N> ignoreStrategy) {
        return ge(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ge2(SerializableFunction<T2, E> name, E value) {
        return ge(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ge2(SerializableFunction<T2, E> name, E value, Predicate<E> ignoreStrategy) {
        return ge(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableFunction<T2, String> name, String value, MatchStrategy matchStrategy) {
        return ge(classMapping2, name, value, queryAlias2, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableFunction<T2, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ge(classMapping2, name, value, queryAlias2, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ge2(SerializableEnumSupplier<E> property) {
        return ge(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ge2(SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy) {
        return ge(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return ge(classMapping2, property, matchStrategy, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ge(classMapping2, property, matchStrategy, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ge2(SerializableFunction<T2, D> name, D value) {
        return ge(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ge2(SerializableFunction<T2, D> name, D value, Predicate<D> ignoreStrategy) {
        return ge(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableFunction<T2, LocalTime> name, LocalTime value) {
        return ge(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableFunction<T2, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ge(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableFunction<T2, LocalDate> name, LocalDate value) {
        return ge(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableFunction<T2, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ge(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableFunction<T2, LocalDateTime> name, LocalDateTime value) {
        return ge(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableFunction<T2, LocalDateTime> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return ge(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableFunction<T2, String> name, String value) {
        return ge(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableFunction<T2, String> name, String value, Predicate<String> ignoreStrategy) {
        return ge(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableToIntFunction2<T2> name, int value) {
        return ge(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableToIntFunction2<T2> name, int value, IntPredicate ignoreStrategy) {
        return ge(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableToLongFunction2<T2> name, long value) {
        return ge(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableToLongFunction2<T2> name, long value, LongPredicate ignoreStrategy) {
        return ge(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableToDoubleFunction2<T2> name, double value) {
        return ge(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableToDoubleFunction2<T2> name, double value, DoublePredicate ignoreStrategy) {
        return ge(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L ge2(SerializableDateSupplier<R> property) {
        return ge(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L ge2(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ge(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L ge2(SerializableNumberSupplier<R> property) {
        return ge(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L ge2(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ge(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableLocalDateSupplier property) {
        return ge(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return ge(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableLocalTimeSupplier property) {
        return ge(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return ge(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableLocalDateTimeSupplier property) {
        return ge(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return ge(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableStringSupplier property) {
        return ge(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return ge(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableIntSupplier property) {
        return ge(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return ge(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableLongSupplier property) {
        return ge(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return ge(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableDoubleSupplier property) {
        return ge(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return ge(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L gt2(SerializableFunction<T2, N> name, N value) {
        return gt(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L gt2(SerializableFunction<T2, N> name, N value, Predicate<N> ignoreStrategy) {
        return gt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L gt2(SerializableFunction<T2, E> name, E value) {
        return gt(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L gt2(SerializableFunction<T2, E> name, E value, Predicate<E> ignoreStrategy) {
        return gt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableFunction<T2, String> name, String value, MatchStrategy matchStrategy) {
        return gt(classMapping2, name, value, matchStrategy, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableFunction<T2, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return gt(classMapping2, name, value, matchStrategy, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L gt2(SerializableEnumSupplier<E> property) {
        return gt(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L gt2(SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy) {
        return gt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return gt(classMapping2, property, matchStrategy, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return gt(classMapping2, property, matchStrategy, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L gt2(SerializableFunction<T2, D> name, D value) {
        return gt(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L gt2(SerializableFunction<T2, D> name, D value, Predicate<D> ignoreStrategy) {
        return gt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableFunction<T2, LocalTime> name, LocalTime value) {
        return gt(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableFunction<T2, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return gt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableFunction<T2, LocalDate> name, LocalDate value) {
        return gt(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableFunction<T2, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return gt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableFunction<T2, LocalDateTime> name, LocalDateTime value) {
        return gt(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableFunction<T2, LocalDateTime> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return gt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableFunction<T2, String> name, String value) {
        return gt(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableFunction<T2, String> name, String value, Predicate<String> ignoreStrategy) {
        return gt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableToIntFunction2<T2> name, int value) {
        return gt(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableToIntFunction2<T2> name, int value, IntPredicate ignoreStrategy) {
        return gt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableToLongFunction2<T2> name, long value) {
        return gt(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableToLongFunction2<T2> name, long value, LongPredicate ignoreStrategy) {
        return gt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableToDoubleFunction2<T2> name, double value) {
        return gt(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableToDoubleFunction2<T2> name, double value, DoublePredicate ignoreStrategy) {
        return gt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L gt2(SerializableNumberSupplier<R> property) {
        return gt(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L gt2(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return gt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L gt2(SerializableDateSupplier<R> property) {
        return gt(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L gt2(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return gt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableLocalDateSupplier property) {
        return gt(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return gt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableLocalTimeSupplier property) {
        return gt(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return gt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableLocalDateTimeSupplier property) {
        return gt(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return gt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableStringSupplier property) {
        return gt(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return gt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableIntSupplier property) {
        return gt(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return gt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableLongSupplier property) {
        return gt(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return gt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableDoubleSupplier property) {
        return gt(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return gt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L le2(SerializableFunction<T2, N> name, N value) {
        return le(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L le2(SerializableFunction<T2, N> name, N value, Predicate<N> ignoreStrategy) {
        return le(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L le2(SerializableFunction<T2, D> name, D value) {
        return le(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L le2(SerializableFunction<T2, D> name, D value, Predicate<D> ignoreStrategy) {
        return le(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableFunction<T2, LocalTime> name, LocalTime value) {
        return le(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableFunction<T2, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return le(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableFunction<T2, LocalDate> name, LocalDate value) {
        return le(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableFunction<T2, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return le(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableFunction<T2, LocalDateTime> name, LocalDateTime value) {
        return le(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableFunction<T2, LocalDateTime> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return le(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableFunction<T2, String> name, String value) {
        return le(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableFunction<T2, String> name, String value, Predicate<String> ignoreStrategy) {
        return le(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L le2(SerializableFunction<T2, E> name, E value) {
        return le(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L le2(SerializableFunction<T2, E> name, E value, Predicate<E> ignoreStrategy) {
        return le(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableFunction<T2, String> name, String value, MatchStrategy matchStrategy) {
        return le(classMapping2, name, value, matchStrategy, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableFunction<T2, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return le(classMapping2, name, value, matchStrategy, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L le2(SerializableEnumSupplier<E> property) {
        return le(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L le2(SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy) {
        return le(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return le(classMapping2, property, matchStrategy, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return le(classMapping2, property, matchStrategy, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L le2(SerializableDateSupplier<R> property) {
        return le(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L le2(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return le(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L le2(SerializableNumberSupplier<R> property) {
        return le(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L le2(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return le(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableLocalDateSupplier property) {
        return le(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return le(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableLocalTimeSupplier property) {
        return le(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return le(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableLocalDateTimeSupplier property) {
        return le(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return le(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableStringSupplier property) {
        return le(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return le(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableToIntFunction2<T2> name, int value) {
        return le(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableToIntFunction2<T2> name, int value, IntPredicate ignoreStrategy) {
        return le(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableToLongFunction2<T2> name, long value) {
        return le(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableToLongFunction2<T2> name, long value, LongPredicate ignoreStrategy) {
        return le(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableToDoubleFunction2<T2> name, double value) {
        return le(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableToDoubleFunction2<T2> name, double value, DoublePredicate ignoreStrategy) {
        return le(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableIntSupplier property) {
        return le(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return le(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableLongSupplier property) {
        return le(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return le(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableDoubleSupplier property) {
        return le(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return le(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L lt2(SerializableFunction<T2, N> name, N value) {
        return lt(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L lt2(SerializableFunction<T2, N> name, N value, Predicate<N> ignoreStrategy) {
        return lt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L lt2(SerializableFunction<T2, E> name, E value) {
        return lt(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L lt2(SerializableFunction<T2, E> name, E value, Predicate<E> ignoreStrategy) {
        return lt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L lt2(SerializableFunction<T2, D> name, D value) {
        return lt(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L lt2(SerializableFunction<T2, D> name, D value, Predicate<D> ignoreStrategy) {
        return lt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableFunction<T2, LocalTime> name, LocalTime value) {
        return lt(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableFunction<T2, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return lt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableFunction<T2, LocalDate> name, LocalDate value) {
        return lt(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableFunction<T2, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return lt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableFunction<T2, LocalDateTime> name, LocalDateTime value) {
        return lt(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableFunction<T2, LocalDateTime> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return lt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableFunction<T2, String> name, String value) {
        return lt(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableFunction<T2, String> name, String value, Predicate<String> ignoreStrategy) {
        return lt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableFunction<T2, String> name, String value, MatchStrategy matchStrategy) {
        return lt(classMapping2, name, value, matchStrategy, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableFunction<T2, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return lt(classMapping2, name, value, matchStrategy, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L lt2(SerializableEnumSupplier<E> property) {
        return lt(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L lt2(SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy) {
        return lt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return lt(classMapping2, property, matchStrategy, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return lt(classMapping2, property, matchStrategy, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L lt2(SerializableNumberSupplier<R> property) {
        return lt(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L lt2(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return lt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L lt2(SerializableDateSupplier<R> property) {
        return lt(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L lt2(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return lt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableLocalDateSupplier property) {
        return lt(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return lt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableLocalTimeSupplier property) {
        return lt(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return lt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableLocalDateTimeSupplier property) {
        return lt(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return lt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableStringSupplier property) {
        return lt(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return lt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableToIntFunction2<T2> name, int value) {
        return lt(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableToIntFunction2<T2> name, int value, IntPredicate ignoreStrategy) {
        return lt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableToLongFunction2<T2> name, long value) {
        return lt(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableToLongFunction2<T2> name, long value, LongPredicate ignoreStrategy) {
        return lt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableToDoubleFunction2<T2> name, double value) {
        return lt(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableToDoubleFunction2<T2> name, double value, DoublePredicate ignoreStrategy) {
        return lt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableIntSupplier property) {
        return lt(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return lt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableLongSupplier property) {
        return lt(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return lt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableDoubleSupplier property) {
        return lt(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return lt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in2(SerializableFunction<T2, R> name, R value) {
        return in(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in2(SerializableFunction<T2, R> name, R value, Predicate<R> ignoreStrategy) {
        return in(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in2(SerializableFunction<T2, R> name, @SuppressWarnings("unchecked") R... value) {
        return in(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in2(SerializableFunction<T2, R> name, R[] value, Predicate<R[]> ignoreStrategy) {
        return in(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in2(SerializableFunction<T2, R> name, Collection<R> value) {
        return in(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in2(SerializableFunction<T2, R> name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy) {
        return in(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in2(SerializableSupplier<R> property) {
        return in(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in2(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return in(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(SerializableToIntFunction2<T2> name, int value) {
        return in(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(SerializableToIntFunction2<T2> name, int value, IntPredicate ignoreStrategy) {
        return in(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(SerializableToLongFunction2<T2> name, long value) {
        return in(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(SerializableToLongFunction2<T2> name, long value, LongPredicate ignoreStrategy) {
        return in(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(SerializableToDoubleFunction<T2> name, double value) {
        return in(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(SerializableToDoubleFunction<T2> name, double value, DoublePredicate ignoreStrategy) {
        return in(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(SerializableToIntFunction2<T2> name, int... value) {
        return in(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(SerializableToLongFunction2<T2> name, long... value) {
        return in(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(SerializableToDoubleFunction2<T2> name, double... value) {
        return in(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(SerializableToDoubleFunction2<T2> name, double[] value, Predicate<double[]> ignoreStrategy) {
        return in(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(SerializableToIntFunction2<T2> name, int[] value, Predicate<int[]> ignoreStrategy) {
        return in(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(SerializableToLongFunction2<T2> name, long[] value, Predicate<long[]> ignoreStrategy) {
        return in(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(SerializableIntSupplier property) {
        return in(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return in(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(SerializableLongSupplier property) {
        return in(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return in(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(SerializableDoubleSupplier property) {
        return in(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return in(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(SerializableToStringFunction<T2> name, String value, MatchStrategy matchStrategy) {
        return in(classMapping2, name, value, matchStrategy, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(SerializableToStringFunction<T2> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return in(classMapping2, name, value, matchStrategy, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(SerializableToStringFunction<T2> name, String[] value, MatchStrategy matchStrategy) {
        return in(classMapping2, name, value, matchStrategy, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(SerializableToStringFunction<T2> name, String[] value, MatchStrategy matchStrategy,
        Predicate<String[]> ignoreStrategy) {
        return in(classMapping2, name, value, matchStrategy, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return in(classMapping2, property, property.get(), matchStrategy, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return in(classMapping2, property, property.get(), matchStrategy, queryAlias2, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni2(SerializableFunction<T2, R> name, R value) {
        return ni(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni2(SerializableFunction<T2, R> name, R value, Predicate<R> ignoreStrategy) {
        return ni(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni2(SerializableFunction<T2, R> name, @SuppressWarnings("unchecked") R... value) {
        return ni(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni2(SerializableFunction<T2, R> name, R[] value, Predicate<R[]> ignoreStrategy) {
        return ni(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni2(SerializableFunction<T2, R> name, Collection<R> value) {
        return ni(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni2(SerializableFunction<T2, R> name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy) {
        return ni(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni2(SerializableSupplier<R> property) {
        return ni(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni2(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ni(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni2(SerializableToIntFunction2<T2> name, int value) {
        return ni(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni2(SerializableToIntFunction2<T2> name, int value, IntPredicate ignoreStrategy) {
        return ni(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni2(SerializableToLongFunction2<T2> name, long value) {
        return ni(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni2(SerializableToLongFunction2<T2> name, long value, LongPredicate ignoreStrategy) {
        return ni(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni2(SerializableToDoubleFunction<T2> name, double value) {
        return ni(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni2(SerializableToDoubleFunction<T2> name, double value, DoublePredicate ignoreStrategy) {
        return ni(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni2(SerializableToIntFunction2<T2> name, int... value) {
        return ni(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni2(SerializableToLongFunction2<T2> name, long... value) {
        return ni(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni2(SerializableToDoubleFunction2<T2> name, double... value) {
        return ni(classMapping2, name, value, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni2(SerializableToDoubleFunction2<T2> name, double[] value, Predicate<double[]> ignoreStrategy) {
        return ni(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni2(SerializableToIntFunction2<T2> name, int[] value, Predicate<int[]> ignoreStrategy) {
        return ni(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni2(SerializableToLongFunction2<T2> name, long[] value, Predicate<long[]> ignoreStrategy) {
        return ni(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni2(SerializableIntSupplier property) {
        return ni(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni2(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return ni(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni2(SerializableLongSupplier property) {
        return ni(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni2(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return ni(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni2(SerializableDoubleSupplier property) {
        return ni(classMapping2, property, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni2(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return ni(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni2(SerializableToStringFunction<T2> name, String value, MatchStrategy matchStrategy) {
        return ni(classMapping2, name, value, matchStrategy, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni2(SerializableToStringFunction<T2> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ni(classMapping2, name, value, matchStrategy, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni2(SerializableToStringFunction<T2> name, String[] value, MatchStrategy matchStrategy) {
        return ni(classMapping2, name, value, matchStrategy, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni2(SerializableToStringFunction<T2> name, String[] value, MatchStrategy matchStrategy,
        Predicate<String[]> ignoreStrategy) {
        return ni(classMapping2, name, value, matchStrategy, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni2(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return ni(classMapping2, property, property.get(), matchStrategy, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni2(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ni(classMapping2, property, property.get(), matchStrategy, queryAlias2, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba2(SerializableToIntFunction<T2> name, int min, int max) {
        return ba(classMapping, name, min, max, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba2(SerializableToIntFunction<T2> name, int min, int max, BiPredicate<Integer, Integer> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba2(SerializableToLongFunction<T2> name, long min, long max) {
        return ba(classMapping, name, min, max, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba2(SerializableToLongFunction<T2> name, long min, long max, BiPredicate<Long, Long> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba2(SerializableToDoubleFunction<T2> name, double min, double max) {
        return ba(classMapping, name, min, max, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba2(SerializableToDoubleFunction<T2> name, double min, double max,
        BiPredicate<Double, Double> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ba2(SerializableToNumberFunction<T2, N> name, N min, N max) {
        return ba(classMapping, name, min, max, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ba2(SerializableToNumberFunction<T2, N> name, N min, N max,
        BiPredicate<N, N> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ba2(SerializableToDateFunction<T2, D> name, D min, D max) {
        return ba(classMapping, name, min, max, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ba2(SerializableToDateFunction<T2, D> name, D min, D max,
        BiPredicate<D, D> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ba2(SerializableToEnumFunction<T2, E> name, E min, E max) {
        return ba(classMapping, name, min, max, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ba2(SerializableToEnumFunction<T2, E> name, E min, E max,
        BiPredicate<E, E> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba2(SerializableToLocalTimeFunction<T2> name, LocalTime min, LocalTime max) {
        return ba(classMapping, name, min, max, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba2(SerializableToLocalTimeFunction<T2> name, LocalTime min, LocalTime max,
        BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba2(SerializableToLocalDateFunction<T2> name, LocalDate min, LocalDate max) {
        return ba(classMapping, name, min, max, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba2(SerializableToLocalDateFunction<T2> name, LocalDate min, LocalDate max,
        BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba2(SerializableToLocalDateTimeFunction<T2> name, LocalDateTime min, LocalDateTime max) {
        return ba(classMapping, name, min, max, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba2(SerializableToLocalDateTimeFunction<T2> name, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba2(SerializableToStringFunction<T2> name, String min, String max) {
        return ba(classMapping, name, min, max, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba2(SerializableToStringFunction<T2> name, String min, String max,
        BiPredicate<String, String> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias2, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba2(SerializableToIntFunction<T2> name, int min, int max) {
        return nba(classMapping, name, min, max, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba2(SerializableToIntFunction<T2> name, int min, int max, BiPredicate<Integer, Integer> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba2(SerializableToLongFunction<T2> name, long min, long max) {
        return nba(classMapping, name, min, max, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba2(SerializableToLongFunction<T2> name, long min, long max, BiPredicate<Long, Long> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba2(SerializableToDoubleFunction<T2> name, double min, double max) {
        return nba(classMapping, name, min, max, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba2(SerializableToDoubleFunction<T2> name, double min, double max,
        BiPredicate<Double, Double> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L nba2(SerializableToNumberFunction<T2, N> name, N min, N max) {
        return nba(classMapping, name, min, max, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L nba2(SerializableToNumberFunction<T2, N> name, N min, N max,
        BiPredicate<N, N> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L nba2(SerializableToDateFunction<T2, D> name, D min, D max) {
        return nba(classMapping, name, min, max, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L nba2(SerializableToDateFunction<T2, D> name, D min, D max,
        BiPredicate<D, D> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L nba2(SerializableToEnumFunction<T2, E> name, E min, E max) {
        return nba(classMapping, name, min, max, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L nba2(SerializableToEnumFunction<T2, E> name, E min, E max,
        BiPredicate<E, E> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba2(SerializableToLocalTimeFunction<T2> name, LocalTime min, LocalTime max) {
        return nba(classMapping, name, min, max, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba2(SerializableToLocalTimeFunction<T2> name, LocalTime min, LocalTime max,
        BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba2(SerializableToLocalDateFunction<T2> name, LocalDate min, LocalDate max) {
        return nba(classMapping, name, min, max, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba2(SerializableToLocalDateFunction<T2> name, LocalDate min, LocalDate max,
        BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba2(SerializableToLocalDateTimeFunction<T2> name, LocalDateTime min, LocalDateTime max) {
        return nba(classMapping, name, min, max, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba2(SerializableToLocalDateTimeFunction<T2> name, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba2(SerializableToStringFunction<T2> name, String min, String max) {
        return nba(classMapping, name, min, max, queryAlias2, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba2(SerializableToStringFunction<T2> name, String min, String max,
        BiPredicate<String, String> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias2, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L inn2(SerializableFunction<T2, R> name, Boolean value) {
        return inn(classMapping2, name, value, queryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L isn2(SerializableFunction<T2, R> name, Boolean value) {
        return isn(classMapping2, name, value, queryAlias2);
    }

    // ****************************************************************************************************************
    // property
    // ****************************************************************************************************************

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L property(BiFunction<EntityPropertyOnlyExpression<T1, ?, ?>, EntityPropertyOnlyExpression<T2, ?, ?>,
    //            L> entitiesPropertyFunction) {
    //        return entitiesPropertyFunction.apply(new EntityPropertyFunctionImpl<>(0, this, factory, entityRelation),
    //                new EntityPropertyFunctionImpl<>(1, this, factory, entityRelation));
    //    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L property(BiFunction<EntityPropertyOnlyExpression<T1>, EntityPropertyOnlyExpression<T2>,
        LogicExpression<?, ?>> entitiesPropertyFunction) {
        // FIXME InternalMulitiEntityCondition<L> 与this的L泛型不匹配
        // InternalMulitiEntityCondition<EntityPropertyOnlyLogicExpression<E>> expression
        //  L extends GroupEndExpression<C, L>
        return (L) entitiesPropertyFunction.apply(
            new EntityPropertyOnlyExpressionImpl<>(0, this, factory, entityRelation),
            new EntityPropertyOnlyExpressionImpl<>(1, this, factory, entityRelation));
    }

    // ********************************************************************
    // protected method
    // ********************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    protected int getIndex() {
        return 1;
    }
}
