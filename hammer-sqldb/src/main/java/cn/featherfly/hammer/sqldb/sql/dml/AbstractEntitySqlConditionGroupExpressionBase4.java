
package cn.featherfly.hammer.sqldb.sql.dml;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Date;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.FourArgusFunction;
import cn.featherfly.common.function.serializable.SerializableDateSupplier;
import cn.featherfly.common.function.serializable.SerializableDoubleSupplier;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableIntSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableLongSupplier;
import cn.featherfly.common.function.serializable.SerializableNumberSupplier;
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.function.serializable.SerializableSupplier4;
import cn.featherfly.common.function.serializable.SerializableToDateFunction;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction4;
import cn.featherfly.common.function.serializable.SerializableToEnumFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction4;
import cn.featherfly.common.function.serializable.SerializableToLocalDateFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction4;
import cn.featherfly.common.function.serializable.SerializableToNumberFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.GroupEndExpression;
import cn.featherfly.hammer.expression.condition.GroupExpression;
import cn.featherfly.hammer.expression.entity.condition.EntityPropertyExpression4;
import cn.featherfly.hammer.expression.entity.condition.ba.EntityBetweenExpressionBase4;
import cn.featherfly.hammer.expression.entity.condition.co.EntityContainsExpressionBase4;
import cn.featherfly.hammer.expression.entity.condition.eq.EntityEqualsExpressionBase4;
import cn.featherfly.hammer.expression.entity.condition.ew.EntityEndWithExpressionBase4;
import cn.featherfly.hammer.expression.entity.condition.ge.EntityGreatEqualsExpressionBase4;
import cn.featherfly.hammer.expression.entity.condition.gt.EntityGreatThanExpressionBase4;
import cn.featherfly.hammer.expression.entity.condition.in.EntityInExpressionBase4;
import cn.featherfly.hammer.expression.entity.condition.inn.EntityIsNotNullExpressionBase4;
import cn.featherfly.hammer.expression.entity.condition.isn.EntityIsNullExpressionBase4;
import cn.featherfly.hammer.expression.entity.condition.le.EntityLessEqualsExpressionBase4;
import cn.featherfly.hammer.expression.entity.condition.lk.EntityLikeExpressionBase4;
import cn.featherfly.hammer.expression.entity.condition.lt.EntityLessThanExpressionBase4;
import cn.featherfly.hammer.expression.entity.condition.nba.EntityNotBetweenExpressionBase4;
import cn.featherfly.hammer.expression.entity.condition.nco.EntityNotContainsExpressionBase4;
import cn.featherfly.hammer.expression.entity.condition.ne.EntityNotEqualsExpressionBase4;
import cn.featherfly.hammer.expression.entity.condition.newv.EntityNotEndWithExpressionBase4;
import cn.featherfly.hammer.expression.entity.condition.ni.EntityNotInExpressionBase4;
import cn.featherfly.hammer.expression.entity.condition.nl.EntityNotLikeExpressionBase4;
import cn.featherfly.hammer.expression.entity.condition.nsw.EntityNotStartWithExpressionBase4;
import cn.featherfly.hammer.expression.entity.condition.property.EntityPropertyFunction;
import cn.featherfly.hammer.expression.entity.condition.sw.EntityStartWithExpressionBase4;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlRelation.EntityRelationMapping;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.EntityPropertyFunctionImpl;

/**
 * sql condition group builder sql条件逻辑组构造器 .
 *
 * @author zhongj
 * @param <T>  the element type
 * @param <T2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public abstract class AbstractEntitySqlConditionGroupExpressionBase4<T, T2, T3, T4, ER extends EntitySqlRelation<ER, B>,
        B extends SqlBuilder, C extends GroupExpression<C, L>, L extends GroupEndExpression<C, L>>
        extends AbstractEntitySqlConditionGroupExpressionBase3<T, T2, T3, ER, B, C, L> implements
        EntityBetweenExpressionBase4<T, T2, T3, T4, C, L>, EntityNotBetweenExpressionBase4<T, T2, T3, T4, C, L> //
        , EntityContainsExpressionBase4<T, T2, T3, T4, C, L>, EntityNotContainsExpressionBase4<T, T2, T3, T4, C, L> //
        , EntityEndWithExpressionBase4<T, T2, T3, T4, C, L>, EntityNotEndWithExpressionBase4<T, T2, T3, T4, C, L> //
        , EntityEqualsExpressionBase4<T, T2, T3, T4, C, L>, EntityNotEqualsExpressionBase4<T, T2, T3, T4, C, L>//
        , EntityGreatEqualsExpressionBase4<T, T2, T3, T4, C, L>, EntityGreatThanExpressionBase4<T, T2, T3, T4, C, L> //
        , EntityInExpressionBase4<T, T2, T3, T4, C, L>, EntityNotInExpressionBase4<T, T2, T3, T4, C, L> //
        , EntityIsNotNullExpressionBase4<T, T2, T3, T4, C, L>, EntityIsNullExpressionBase4<T, T2, T3, T4, C, L> //
        , EntityLessEqualsExpressionBase4<T, T2, T3, T4, C, L>, EntityLessThanExpressionBase4<T, T2, T3, T4, C, L> //
        , EntityStartWithExpressionBase4<T, T2, T3, T4, C, L>, EntityNotStartWithExpressionBase4<T, T2, T3, T4, C, L> //
        , EntityLikeExpressionBase4<T, T2, T3, T4, C, L>, EntityNotLikeExpressionBase4<T, T2, T3, T4, C, L>//
        , EntityPropertyExpression4<T, T2, T3, T4, C, L> {

    /** The class mapping. */
    protected JdbcClassMapping<T4> classMapping4;

    protected String queryAlias4;

    /**
     * Instantiates a new abstract entity sql condition group expression base 4.
     *
     * @param parent            the parent
     * @param factory           the factory
     * @param entitySqlRelation the entity sql relation
     */
    @SuppressWarnings("unchecked")
    protected AbstractEntitySqlConditionGroupExpressionBase4(L parent, JdbcMappingFactory factory,
            ER entitySqlRelation) {
        super(parent, factory, entitySqlRelation);

        EntityRelationMapping<?> erm = entitySqlRelation.getEntityRelationMappingTuple().getOrNull3();
        classMapping4 = (JdbcClassMapping<T4>) erm.getClassMapping();
        queryAlias4 = erm.getTableAlias();
    }

    @Override
    public <R> L eq4(SerializableFunction<T4, R> name, R value, MatchStrategy matchStrategy) {
        return eq(classMapping4, name, value, queryAlias4, matchStrategy, ignoreStrategy);
    }

    @Override
    public <R> L eq4(SerializableFunction<T4, R> name, R value, MatchStrategy matchStrategy,
            Predicate<R> ignoreStrategy) {
        return eq(classMapping4, name, value, queryAlias4, matchStrategy, ignoreStrategy);
    }

    @Override
    public <R> L eq4(SerializableSupplier4<R> property, MatchStrategy matchStrategy) {
        return eq(classMapping4, property, queryAlias4, matchStrategy, ignoreStrategy);
    }

    @Override
    public <R> L eq4(SerializableSupplier4<R> property, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy) {
        return eq(classMapping4, property, queryAlias4, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <R> L ne4(SerializableFunction<T4, R> name, R value, MatchStrategy matchStrategy) {
        return ne(classMapping4, name, value, queryAlias4, matchStrategy, ignoreStrategy);
    }

    @Override
    public <R> L ne4(SerializableFunction<T4, R> name, R value, MatchStrategy matchStrategy,
            Predicate<R> ignoreStrategy) {
        return ne(classMapping4, name, value, queryAlias4, matchStrategy, ignoreStrategy);
    }

    @Override
    public <R> L ne4(SerializableSupplier4<R> property, MatchStrategy matchStrategy) {
        return ne(classMapping4, property, queryAlias4, matchStrategy, ignoreStrategy);
    }

    @Override
    public <R> L ne4(SerializableSupplier4<R> property, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy) {
        return ne(classMapping4, property, queryAlias4, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L lk4(SerializableFunction<T4, String> name, String value, MatchStrategy matchStrategy) {
        return lk(classMapping4, name, value, queryAlias4, matchStrategy, ignoreStrategy);
    }

    @Override
    public L lk4(SerializableFunction<T4, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return lk(classMapping4, name, value, queryAlias4, matchStrategy, ignoreStrategy);
    }

    @Override
    public L lk4(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return lk(classMapping4, property, queryAlias4, matchStrategy, ignoreStrategy);
    }

    @Override
    public L lk4(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return lk(classMapping4, property, queryAlias4, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L nl4(SerializableFunction<T4, String> name, String value, MatchStrategy matchStrategy) {
        return nl(classMapping4, name, value, queryAlias4, matchStrategy, ignoreStrategy);
    }

    @Override
    public L nl4(SerializableFunction<T4, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return nl(classMapping4, name, value, queryAlias4, matchStrategy, ignoreStrategy);
    }

    @Override
    public L nl4(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return nl(classMapping4, property, queryAlias4, matchStrategy, ignoreStrategy);
    }

    @Override
    public L nl4(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nl(classMapping4, property, queryAlias4, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L sw4(SerializableFunction<T4, String> name, String value, MatchStrategy matchStrategy) {
        return sw(classMapping4, name, value, queryAlias4, matchStrategy, ignoreStrategy);
    }

    @Override
    public L sw4(SerializableFunction<T4, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return sw(classMapping4, name, value, queryAlias4, matchStrategy, ignoreStrategy);
    }

    @Override
    public L sw4(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return sw(classMapping4, property, queryAlias4, matchStrategy, ignoreStrategy);
    }

    @Override
    public L sw4(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return sw(classMapping4, property, queryAlias4, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L nsw4(SerializableFunction<T4, String> name, String value, MatchStrategy matchStrategy) {
        return nsw(classMapping4, name, value, queryAlias4, matchStrategy, ignoreStrategy);
    }

    @Override
    public L nsw4(SerializableFunction<T4, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return nsw(classMapping4, name, value, queryAlias4, matchStrategy, ignoreStrategy);
    }

    @Override
    public L nsw4(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return nsw(classMapping4, property, queryAlias4, matchStrategy, ignoreStrategy);
    }

    @Override
    public L nsw4(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nsw(classMapping4, property, queryAlias4, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L ew4(SerializableFunction<T4, String> name, String value, MatchStrategy matchStrategy) {
        return ew(classMapping4, name, value, queryAlias4, matchStrategy, ignoreStrategy);
    }

    @Override
    public L ew4(SerializableFunction<T4, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return ew(classMapping4, name, value, queryAlias4, matchStrategy, ignoreStrategy);
    }

    @Override
    public L ew4(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return ew(classMapping4, property, queryAlias4, matchStrategy, ignoreStrategy);
    }

    @Override
    public L ew4(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ew(classMapping4, property, queryAlias4, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L new4(SerializableFunction<T4, String> name, String value, MatchStrategy matchStrategy) {
        return newv(classMapping4, name, value, queryAlias4, matchStrategy, ignoreStrategy);
    }

    @Override
    public L new4(SerializableFunction<T4, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return newv(classMapping4, name, value, queryAlias4, matchStrategy, ignoreStrategy);
    }

    @Override
    public L new4(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return newv(classMapping4, property, queryAlias4, matchStrategy, ignoreStrategy);
    }

    @Override
    public L new4(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return newv(classMapping4, property, queryAlias4, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L co4(SerializableFunction<T4, String> name, String value, MatchStrategy matchStrategy) {
        return co(classMapping4, name, value, queryAlias4, matchStrategy, ignoreStrategy);
    }

    @Override
    public L co4(SerializableFunction<T4, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return co(classMapping4, name, value, queryAlias4, matchStrategy, ignoreStrategy);
    }

    @Override
    public L co4(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return co(classMapping4, property, queryAlias4, matchStrategy, ignoreStrategy);
    }

    @Override
    public L co4(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return co(classMapping4, property, queryAlias4, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L nco4(SerializableFunction<T4, String> name, String value, MatchStrategy matchStrategy) {
        return nco(classMapping4, name, value, queryAlias4, matchStrategy, ignoreStrategy);
    }

    @Override
    public L nco4(SerializableFunction<T4, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return nco(classMapping4, name, value, queryAlias4, matchStrategy, ignoreStrategy);
    }

    @Override
    public L nco4(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return nco(classMapping4, property, queryAlias4, matchStrategy, ignoreStrategy);
    }

    @Override
    public L nco4(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nco(classMapping4, property, queryAlias4, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L ge4(SerializableFunction<T4, N> name, N value) {
        return ge(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public <N extends Number> L ge4(SerializableFunction<T4, N> name, N value, Predicate<N> ignoreStrategy) {
        return ge(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public <D extends Date> L ge4(SerializableFunction<T4, D> name, D value) {
        return ge(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public <D extends Date> L ge4(SerializableFunction<T4, D> name, D value, Predicate<D> ignoreStrategy) {
        return ge(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public L ge4(SerializableFunction<T4, LocalTime> name, LocalTime value) {
        return ge(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public L ge4(SerializableFunction<T4, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ge(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public L ge4(SerializableFunction<T4, LocalDate> name, LocalDate value) {
        return ge(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public L ge4(SerializableFunction<T4, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ge(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public L ge4(SerializableFunction<T4, LocalDateTime> name, LocalDateTime value) {
        return ge(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public L ge4(SerializableFunction<T4, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return ge(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public L ge4(SerializableFunction<T4, String> name, String value) {
        return ge(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public L ge4(SerializableFunction<T4, String> name, String value, Predicate<String> ignoreStrategy) {
        return ge(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge4(SerializableToIntFunction4<T4> name, int value) {
        return ge(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge4(SerializableToIntFunction4<T4> name, int value, Predicate<Integer> ignoreStrategy) {
        return ge(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge4(SerializableToLongFunction4<T4> name, long value) {
        return ge(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge4(SerializableToLongFunction4<T4> name, long value, Predicate<Long> ignoreStrategy) {
        return ge(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge4(SerializableToDoubleFunction4<T4> name, double value) {
        return ge(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge4(SerializableToDoubleFunction4<T4> name, double value, Predicate<Double> ignoreStrategy) {
        return ge(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public <R extends Date> L ge4(SerializableDateSupplier<R> property) {
        return ge(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public <R extends Date> L ge4(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ge(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public <R extends Number> L ge4(SerializableNumberSupplier<R> property) {
        return ge(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public <R extends Number> L ge4(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ge(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public L ge4(SerializableLocalDateSupplier property) {
        return ge(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public L ge4(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return ge(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public L ge4(SerializableLocalTimeSupplier property) {
        return ge(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public L ge4(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return ge(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public L ge4(SerializableLocalDateTimeSupplier property) {
        return ge(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public L ge4(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return ge(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public L ge4(SerializableStringSupplier property) {
        return ge(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public L ge4(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return ge(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge4(SerializableIntSupplier property) {
        return ge(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge4(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return ge(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge4(SerializableLongSupplier property) {
        return ge(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge4(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return ge(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge4(SerializableDoubleSupplier property) {
        return ge(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge4(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy) {
        return ge(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L gt4(SerializableFunction<T4, N> name, N value) {
        return gt(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public <N extends Number> L gt4(SerializableFunction<T4, N> name, N value, Predicate<N> ignoreStrategy) {
        return gt(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public <D extends Date> L gt4(SerializableFunction<T4, D> name, D value) {
        return gt(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public <D extends Date> L gt4(SerializableFunction<T4, D> name, D value, Predicate<D> ignoreStrategy) {
        return gt(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public L gt4(SerializableFunction<T4, LocalTime> name, LocalTime value) {
        return gt(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public L gt4(SerializableFunction<T4, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return gt(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public L gt4(SerializableFunction<T4, LocalDate> name, LocalDate value) {
        return gt(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public L gt4(SerializableFunction<T4, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return gt(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public L gt4(SerializableFunction<T4, LocalDateTime> name, LocalDateTime value) {
        return gt(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public L gt4(SerializableFunction<T4, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return gt(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public L gt4(SerializableFunction<T4, String> name, String value) {
        return gt(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public L gt4(SerializableFunction<T4, String> name, String value, Predicate<String> ignoreStrategy) {
        return gt(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt4(SerializableToIntFunction4<T4> name, int value) {
        return gt(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt4(SerializableToIntFunction4<T4> name, int value, Predicate<Integer> ignoreStrategy) {
        return gt(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt4(SerializableToLongFunction4<T4> name, long value) {
        return gt(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt4(SerializableToLongFunction4<T4> name, long value, Predicate<Long> ignoreStrategy) {
        return gt(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt4(SerializableToDoubleFunction4<T4> name, double value) {
        return gt(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt4(SerializableToDoubleFunction4<T4> name, double value, Predicate<Double> ignoreStrategy) {
        return gt(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public <R extends Number> L gt4(SerializableNumberSupplier<R> property) {
        return gt(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public <R extends Number> L gt4(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return gt(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public <R extends Date> L gt4(SerializableDateSupplier<R> property) {
        return gt(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public <R extends Date> L gt4(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return gt(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public L gt4(SerializableLocalDateSupplier property) {
        return gt(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public L gt4(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return gt(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public L gt4(SerializableLocalTimeSupplier property) {
        return gt(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public L gt4(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return gt(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public L gt4(SerializableLocalDateTimeSupplier property) {
        return gt(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public L gt4(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return gt(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public L gt4(SerializableStringSupplier property) {
        return gt(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public L gt4(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return gt(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt4(SerializableIntSupplier property) {
        return gt(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt4(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return gt(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt4(SerializableLongSupplier property) {
        return gt(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt4(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return gt(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt4(SerializableDoubleSupplier property) {
        return gt(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt4(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy) {
        return gt(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L le4(SerializableFunction<T4, N> name, N value) {
        return le(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public <N extends Number> L le4(SerializableFunction<T4, N> name, N value, Predicate<N> ignoreStrategy) {
        return le(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public <D extends Date> L le4(SerializableFunction<T4, D> name, D value) {
        return le(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public <D extends Date> L le4(SerializableFunction<T4, D> name, D value, Predicate<D> ignoreStrategy) {
        return le(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public L le4(SerializableFunction<T4, LocalTime> name, LocalTime value) {
        return le(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public L le4(SerializableFunction<T4, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return le(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public L le4(SerializableFunction<T4, LocalDate> name, LocalDate value) {
        return le(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public L le4(SerializableFunction<T4, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return le(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public L le4(SerializableFunction<T4, LocalDateTime> name, LocalDateTime value) {
        return le(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public L le4(SerializableFunction<T4, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return le(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public L le4(SerializableFunction<T4, String> name, String value) {
        return le(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public L le4(SerializableFunction<T4, String> name, String value, Predicate<String> ignoreStrategy) {
        return le(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public <R extends Date> L le4(SerializableDateSupplier<R> property) {
        return le(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public <R extends Date> L le4(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return le(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public <R extends Number> L le4(SerializableNumberSupplier<R> property) {
        return le(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public <R extends Number> L le4(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return le(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public L le4(SerializableLocalDateSupplier property) {
        return le(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public L le4(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return le(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public L le4(SerializableLocalTimeSupplier property) {
        return le(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public L le4(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return le(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public L le4(SerializableLocalDateTimeSupplier property) {
        return le(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public L le4(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return le(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public L le4(SerializableStringSupplier property) {
        return le(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public L le4(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return le(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le4(SerializableToIntFunction4<T4> name, int value) {
        return le(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le4(SerializableToIntFunction4<T4> name, int value, Predicate<Integer> ignoreStrategy) {
        return le(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le4(SerializableToLongFunction4<T4> name, long value) {
        return le(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le4(SerializableToLongFunction4<T4> name, long value, Predicate<Long> ignoreStrategy) {
        return le(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le4(SerializableToDoubleFunction4<T4> name, double value) {
        return le(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le4(SerializableToDoubleFunction4<T4> name, double value, Predicate<Double> ignoreStrategy) {
        return le(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le4(SerializableIntSupplier property) {
        return le(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le4(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return le(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le4(SerializableLongSupplier property) {
        return le(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le4(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return le(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le4(SerializableDoubleSupplier property) {
        return le(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le4(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy) {
        return le(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L lt4(SerializableFunction<T4, N> name, N value) {
        return lt(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public <N extends Number> L lt4(SerializableFunction<T4, N> name, N value, Predicate<N> ignoreStrategy) {
        return lt(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public <D extends Date> L lt4(SerializableFunction<T4, D> name, D value) {
        return lt(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public <D extends Date> L lt4(SerializableFunction<T4, D> name, D value, Predicate<D> ignoreStrategy) {
        return lt(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public L lt4(SerializableFunction<T4, LocalTime> name, LocalTime value) {
        return lt(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public L lt4(SerializableFunction<T4, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return lt(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public L lt4(SerializableFunction<T4, LocalDate> name, LocalDate value) {
        return lt(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public L lt4(SerializableFunction<T4, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return lt(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public L lt4(SerializableFunction<T4, LocalDateTime> name, LocalDateTime value) {
        return lt(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public L lt4(SerializableFunction<T4, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return lt(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public L lt4(SerializableFunction<T4, String> name, String value) {
        return lt(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public L lt4(SerializableFunction<T4, String> name, String value, Predicate<String> ignoreStrategy) {
        return lt(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public <R extends Number> L lt4(SerializableNumberSupplier<R> property) {
        return lt(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public <R extends Number> L lt4(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return lt(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public <R extends Date> L lt4(SerializableDateSupplier<R> property) {
        return lt(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public <R extends Date> L lt4(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return lt(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public L lt4(SerializableLocalDateSupplier property) {
        return lt(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public L lt4(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return lt(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public L lt4(SerializableLocalTimeSupplier property) {
        return lt(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public L lt4(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return lt(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public L lt4(SerializableLocalDateTimeSupplier property) {
        return lt(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public L lt4(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return lt(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public L lt4(SerializableStringSupplier property) {
        return lt(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public L lt4(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return lt(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt4(SerializableToIntFunction4<T4> name, int value) {
        return lt(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt4(SerializableToIntFunction4<T4> name, int value, Predicate<Integer> ignoreStrategy) {
        return lt(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt4(SerializableToLongFunction4<T4> name, long value) {
        return lt(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt4(SerializableToLongFunction4<T4> name, long value, Predicate<Long> ignoreStrategy) {
        return lt(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt4(SerializableToDoubleFunction4<T4> name, double value) {
        return lt(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt4(SerializableToDoubleFunction4<T4> name, double value, Predicate<Double> ignoreStrategy) {
        return lt(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt4(SerializableIntSupplier property) {
        return lt(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt4(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return lt(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt4(SerializableLongSupplier property) {
        return lt(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt4(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return lt(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt4(SerializableDoubleSupplier property) {
        return lt(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt4(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy) {
        return lt(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <R> L in4(SerializableFunction<T4, R> name, R value) {
        return in(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public <R> L in4(SerializableFunction<T4, R> name, R value, Predicate<R> ignoreStrategy) {
        return in(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public <R> L in4(SerializableFunction<T4, R> name, @SuppressWarnings("unchecked") R... value) {
        return in(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public <R> L in4(SerializableFunction<T4, R> name, R[] value, Predicate<R[]> ignoreStrategy) {
        return in(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public <R> L in4(SerializableFunction<T4, R> name, Collection<R> value) {
        return in(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public <R> L in4(SerializableFunction<T4, R> name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy) {
        return in(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public <R> L in4(SerializableSupplier<R> property) {
        return in(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public <R> L in4(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return in(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in4(SerializableToIntFunction4<T4> name, int value) {
        return in(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in4(SerializableToIntFunction4<T4> name, int value, Predicate<Integer> ignoreStrategy) {
        return in(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in4(SerializableToLongFunction4<T4> name, long value) {
        return in(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in4(SerializableToLongFunction4<T4> name, long value, Predicate<Long> ignoreStrategy) {
        return in(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in4(SerializableToIntFunction4<T4> name, int... value) {
        return in(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in4(SerializableToLongFunction4<T4> name, long... value) {
        return in(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in4(SerializableToIntFunction4<T4> name, int[] value, Predicate<int[]> ignoreStrategy) {
        return in(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in4(SerializableToLongFunction4<T4> name, long[] value, Predicate<long[]> ignoreStrategy) {
        return in(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in4(SerializableIntSupplier property) {
        return in(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in4(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return in(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in4(SerializableLongSupplier property) {
        return in(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in4(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return in(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <R> L ni4(SerializableFunction<T4, R> name, R value) {
        return ni(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public <R> L ni4(SerializableFunction<T4, R> name, R value, Predicate<R> ignoreStrategy) {
        return ni(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public <R> L ni4(SerializableFunction<T4, R> name, @SuppressWarnings("unchecked") R... value) {
        return ni(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public <R> L ni4(SerializableFunction<T4, R> name, R[] value, Predicate<R[]> ignoreStrategy) {
        return ni(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public <R> L ni4(SerializableFunction<T4, R> name, Collection<R> value) {
        return ni(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public <R> L ni4(SerializableFunction<T4, R> name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy) {
        return ni(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    @Override
    public <R> L ni4(SerializableSupplier<R> property) {
        return ni(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    @Override
    public <R> L ni4(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ni(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni4(SerializableToIntFunction4<T4> name, int value) {
        return ni(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni4(SerializableToIntFunction4<T4> name, int value, Predicate<Integer> ignoreStrategy) {
        return ni(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni4(SerializableToLongFunction4<T4> name, long value) {
        return ni(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni4(SerializableToLongFunction4<T4> name, long value, Predicate<Long> ignoreStrategy) {
        return ni(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni4(SerializableToIntFunction4<T4> name, int... value) {
        return ni(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni4(SerializableToLongFunction4<T4> name, long... value) {
        return ni(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni4(SerializableToIntFunction4<T4> name, int[] value, Predicate<int[]> ignoreStrategy) {
        return ni(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni4(SerializableToLongFunction4<T4> name, long[] value, Predicate<long[]> ignoreStrategy) {
        return ni(classMapping4, name, value, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni4(SerializableIntSupplier property) {
        return ni(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni4(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return ni(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni4(SerializableLongSupplier property) {
        return ni(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni4(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return ni(classMapping4, property, queryAlias4, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <R> L inn4(SerializableFunction<T4, R> name, Boolean value) {
        return inn(classMapping4, name, value, queryAlias4);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L isn4(SerializableFunction<T4, R> name, Boolean value) {
        return isn(classMapping4, name, value, queryAlias4);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba4(SerializableToIntFunction<T4> name, int min, int max) {
        return ba(classMapping, name, min, max, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba4(SerializableToIntFunction<T4> name, int min, int max, BiPredicate<Integer, Integer> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba4(SerializableToLongFunction<T4> name, long min, long max) {
        return ba(classMapping, name, min, max, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba4(SerializableToLongFunction<T4> name, long min, long max, BiPredicate<Long, Long> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba4(SerializableToDoubleFunction<T4> name, double min, double max) {
        return ba(classMapping, name, min, max, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba4(SerializableToDoubleFunction<T4> name, double min, double max,
            BiPredicate<Double, Double> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ba4(SerializableToNumberFunction<T4, N> name, N min, N max) {
        return ba(classMapping, name, min, max, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ba4(SerializableToNumberFunction<T4, N> name, N min, N max,
            BiPredicate<N, N> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ba4(SerializableToDateFunction<T4, D> name, D min, D max) {
        return ba(classMapping, name, min, max, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ba4(SerializableToDateFunction<T4, D> name, D min, D max,
            BiPredicate<D, D> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ba4(SerializableToEnumFunction<T4, E> name, E min, E max) {
        return ba(classMapping, name, min, max, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ba4(SerializableToEnumFunction<T4, E> name, E min, E max,
            BiPredicate<E, E> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba4(SerializableToLocalTimeFunction<T4> name, LocalTime min, LocalTime max) {
        return ba(classMapping, name, min, max, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba4(SerializableToLocalTimeFunction<T4> name, LocalTime min, LocalTime max,
            BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba4(SerializableToLocalDateFunction<T4> name, LocalDate min, LocalDate max) {
        return ba(classMapping, name, min, max, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba4(SerializableToLocalDateFunction<T4> name, LocalDate min, LocalDate max,
            BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba4(SerializableToLocalDateTimeFunction<T4> name, LocalDateTime min, LocalDateTime max) {
        return ba(classMapping, name, min, max, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba4(SerializableToLocalDateTimeFunction<T4> name, LocalDateTime min, LocalDateTime max,
            BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba4(SerializableToStringFunction<T4> name, String min, String max) {
        return ba(classMapping, name, min, max, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba4(SerializableToStringFunction<T4> name, String min, String max,
            BiPredicate<String, String> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias4, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba4(SerializableToIntFunction<T4> name, int min, int max) {
        return nba(classMapping, name, min, max, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba4(SerializableToIntFunction<T4> name, int min, int max, BiPredicate<Integer, Integer> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba4(SerializableToLongFunction<T4> name, long min, long max) {
        return nba(classMapping, name, min, max, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba4(SerializableToLongFunction<T4> name, long min, long max, BiPredicate<Long, Long> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba4(SerializableToDoubleFunction<T4> name, double min, double max) {
        return nba(classMapping, name, min, max, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba4(SerializableToDoubleFunction<T4> name, double min, double max,
            BiPredicate<Double, Double> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L nba4(SerializableToNumberFunction<T4, N> name, N min, N max) {
        return nba(classMapping, name, min, max, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L nba4(SerializableToNumberFunction<T4, N> name, N min, N max,
            BiPredicate<N, N> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L nba4(SerializableToDateFunction<T4, D> name, D min, D max) {
        return nba(classMapping, name, min, max, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L nba4(SerializableToDateFunction<T4, D> name, D min, D max,
            BiPredicate<D, D> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L nba4(SerializableToEnumFunction<T4, E> name, E min, E max) {
        return nba(classMapping, name, min, max, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L nba4(SerializableToEnumFunction<T4, E> name, E min, E max,
            BiPredicate<E, E> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba4(SerializableToLocalTimeFunction<T4> name, LocalTime min, LocalTime max) {
        return nba(classMapping, name, min, max, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba4(SerializableToLocalTimeFunction<T4> name, LocalTime min, LocalTime max,
            BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba4(SerializableToLocalDateFunction<T4> name, LocalDate min, LocalDate max) {
        return nba(classMapping, name, min, max, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba4(SerializableToLocalDateFunction<T4> name, LocalDate min, LocalDate max,
            BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba4(SerializableToLocalDateTimeFunction<T4> name, LocalDateTime min, LocalDateTime max) {
        return nba(classMapping, name, min, max, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba4(SerializableToLocalDateTimeFunction<T4> name, LocalDateTime min, LocalDateTime max,
            BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba4(SerializableToStringFunction<T4> name, String min, String max) {
        return nba(classMapping, name, min, max, queryAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba4(SerializableToStringFunction<T4> name, String min, String max,
            BiPredicate<String, String> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias4, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L property(FourArgusFunction<EntityPropertyFunction<T, C, L>, EntityPropertyFunction<T2, C, L>,
            EntityPropertyFunction<T3, C, L>, EntityPropertyFunction<T4, C, L>, L> entitiesPropertyFunction) {
        return entitiesPropertyFunction.apply(new EntityPropertyFunctionImpl<>(0, this, factory),
                new EntityPropertyFunctionImpl<>(1, this, factory), new EntityPropertyFunctionImpl<>(2, this, factory),
                new EntityPropertyFunctionImpl<>(3, this, factory));
    }

    // ********************************************************************
    // private method
    // ********************************************************************

    // ********************************************************************
    // protected method
    // ********************************************************************

}
