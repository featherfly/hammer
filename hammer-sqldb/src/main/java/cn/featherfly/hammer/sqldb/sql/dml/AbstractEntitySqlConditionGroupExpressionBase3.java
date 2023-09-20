
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
import cn.featherfly.common.function.ThreeArgusFunction;
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
import cn.featherfly.common.function.serializable.SerializableSupplier3;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction3;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction3;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction3;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.GroupEndExpression;
import cn.featherfly.hammer.expression.condition.GroupExpression;
import cn.featherfly.hammer.expression.entity.condition.EntityPropertyExpression3;
import cn.featherfly.hammer.expression.entity.condition.ba.EntityBetweenExpressionBase3;
import cn.featherfly.hammer.expression.entity.condition.co.EntityContainsExpressionBase3;
import cn.featherfly.hammer.expression.entity.condition.eq.EntityEqualsExpressionBase3;
import cn.featherfly.hammer.expression.entity.condition.ew.EntityEndWithExpressionBase3;
import cn.featherfly.hammer.expression.entity.condition.ge.EntityGreatEqualsExpressionBase3;
import cn.featherfly.hammer.expression.entity.condition.gt.EntityGreatThanExpressionBase3;
import cn.featherfly.hammer.expression.entity.condition.in.EntityInExpressionBase3;
import cn.featherfly.hammer.expression.entity.condition.inn.EntityIsNotNullExpressionBase3;
import cn.featherfly.hammer.expression.entity.condition.isn.EntityIsNullExpressionBase3;
import cn.featherfly.hammer.expression.entity.condition.le.EntityLessEqualsExpressionBase3;
import cn.featherfly.hammer.expression.entity.condition.lk.EntityLikeExpressionBase3;
import cn.featherfly.hammer.expression.entity.condition.lt.EntityLessThanExpressionBase3;
import cn.featherfly.hammer.expression.entity.condition.nba.EntityNotBetweenExpressionBase3;
import cn.featherfly.hammer.expression.entity.condition.nco.EntityNotContainsExpressionBase3;
import cn.featherfly.hammer.expression.entity.condition.ne.EntityNotEqualsExpressionBase3;
import cn.featherfly.hammer.expression.entity.condition.newv.EntityNotEndWithExpressionBase3;
import cn.featherfly.hammer.expression.entity.condition.ni.EntityNotInExpressionBase3;
import cn.featherfly.hammer.expression.entity.condition.nl.EntityNotLikeExpressionBase3;
import cn.featherfly.hammer.expression.entity.condition.nsw.EntityNotStartWithExpressionBase3;
import cn.featherfly.hammer.expression.entity.condition.property.EntityPropertyFunction;
import cn.featherfly.hammer.expression.entity.condition.sw.EntityStartWithExpressionBase3;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlRelation.EntityRelationMapping;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.EntityPropertyFunctionImpl;

/**
 * sql condition group builder sql条件逻辑组构造器 .
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public abstract class AbstractEntitySqlConditionGroupExpressionBase3<E, E2, E3, ER extends EntitySqlRelation<ER, B>,
        B extends SqlBuilder, C extends GroupExpression<C, L>, L extends GroupEndExpression<C, L>>
        extends AbstractEntitySqlConditionGroupExpressionBase2<E, E2, ER, B, C, L>
        implements EntityBetweenExpressionBase3<E, E2, E3, C, L>, EntityNotBetweenExpressionBase3<E, E2, E3, C, L> //
        , EntityContainsExpressionBase3<E, E2, E3, C, L>, EntityNotContainsExpressionBase3<E, E2, E3, C, L> //
        , EntityEndWithExpressionBase3<E, E2, E3, C, L>, EntityNotEndWithExpressionBase3<E, E2, E3, C, L>//
        , EntityEqualsExpressionBase3<E, E2, E3, C, L>, EntityNotEqualsExpressionBase3<E, E2, E3, C, L>//
        , EntityGreatEqualsExpressionBase3<E, E2, E3, C, L>, EntityGreatThanExpressionBase3<E, E2, E3, C, L> //
        , EntityInExpressionBase3<E, E2, E3, C, L>, EntityNotInExpressionBase3<E, E2, E3, C, L>//
        , EntityIsNotNullExpressionBase3<E, E2, E3, C, L>, EntityIsNullExpressionBase3<E, E2, E3, C, L> //
        , EntityLessEqualsExpressionBase3<E, E2, E3, C, L>, EntityLessThanExpressionBase3<E, E2, E3, C, L> //
        , EntityStartWithExpressionBase3<E, E2, E3, C, L>, EntityNotStartWithExpressionBase3<E, E2, E3, C, L> //
        , EntityLikeExpressionBase3<E, E2, E3, C, L>, EntityNotLikeExpressionBase3<E, E2, E3, C, L>//
        , EntityPropertyExpression3<E, E2, E3, C, L> {

    /** The class mapping. */
    protected JdbcClassMapping<E3> classMapping3;

    protected String queryAlias3;

    /**
     * Instantiates a new abstract entity sql condition group expression base 3.
     *
     * @param parent            the parent
     * @param factory           the factory
     * @param entitySqlRelation the entity sql relation
     */
    @SuppressWarnings("unchecked")
    protected AbstractEntitySqlConditionGroupExpressionBase3(L parent, JdbcMappingFactory factory,
            ER entitySqlRelation) {
        super(parent, factory, entitySqlRelation);

        EntityRelationMapping<?> erm = entitySqlRelation.getEntityRelationMappingTuple().getOrNull2();
        classMapping3 = (JdbcClassMapping<E3>) erm.getClassMapping();
        queryAlias3 = erm.getTableAlias();
    }

    @Override
    public <R> L eq3(SerializableFunction<E3, R> name, R value, MatchStrategy matchStrategy) {
        return eq(classMapping3, name, value, queryAlias3, matchStrategy, ignoreStrategy);
    }

    @Override
    public <R> L eq3(SerializableFunction<E3, R> name, R value, MatchStrategy matchStrategy,
            Predicate<R> ignoreStrategy) {
        return eq(classMapping3, name, value, queryAlias3, matchStrategy, ignoreStrategy);
    }

    @Override
    public <R> L eq3(SerializableSupplier3<R> property, MatchStrategy matchStrategy) {
        return eq(classMapping3, property, queryAlias3, matchStrategy, ignoreStrategy);
    }

    @Override
    public <R> L eq3(SerializableSupplier3<R> property, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy) {
        return eq(classMapping3, property, queryAlias3, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <R> L ne3(SerializableFunction<E3, R> name, R value, MatchStrategy matchStrategy) {
        return ne(classMapping3, name, value, queryAlias3, matchStrategy, ignoreStrategy);
    }

    @Override
    public <R> L ne3(SerializableFunction<E3, R> name, R value, MatchStrategy matchStrategy,
            Predicate<R> ignoreStrategy) {
        return ne(classMapping3, name, value, queryAlias3, matchStrategy, ignoreStrategy);
    }

    @Override
    public <R> L ne3(SerializableSupplier3<R> property, MatchStrategy matchStrategy) {
        return ne(classMapping3, property, queryAlias3, matchStrategy, ignoreStrategy);
    }

    @Override
    public <R> L ne3(SerializableSupplier3<R> property, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy) {
        return ne(classMapping3, property, queryAlias3, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L lk3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy) {
        return lk(classMapping3, name, value, queryAlias3, matchStrategy, ignoreStrategy);
    }

    @Override
    public L lk3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return lk(classMapping3, name, value, queryAlias3, matchStrategy, ignoreStrategy);
    }

    @Override
    public L lk3(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return lk(classMapping3, property, queryAlias3, matchStrategy, ignoreStrategy);
    }

    @Override
    public L lk3(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return lk(classMapping3, property, queryAlias3, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L nl3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy) {
        return nl(classMapping3, name, value, queryAlias3, matchStrategy, ignoreStrategy);
    }

    @Override
    public L nl3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return nl(classMapping3, name, value, queryAlias3, matchStrategy, ignoreStrategy);
    }

    @Override
    public L nl3(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return nl(classMapping3, property, queryAlias3, matchStrategy, ignoreStrategy);
    }

    @Override
    public L nl3(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nl(classMapping3, property, queryAlias3, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L sw3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy) {
        return sw(classMapping3, name, value, queryAlias3, matchStrategy, ignoreStrategy);
    }

    @Override
    public L sw3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return sw(classMapping3, name, value, queryAlias3, matchStrategy, ignoreStrategy);
    }

    @Override
    public L sw3(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return sw(classMapping3, property, queryAlias3, matchStrategy, ignoreStrategy);
    }

    @Override
    public L sw3(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return sw(classMapping3, property, queryAlias3, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L nsw3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy) {
        return nsw(classMapping3, name, value, queryAlias3, matchStrategy, ignoreStrategy);
    }

    @Override
    public L nsw3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return nsw(classMapping3, name, value, queryAlias3, matchStrategy, ignoreStrategy);
    }

    @Override
    public L nsw3(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return nsw(classMapping3, property, queryAlias3, matchStrategy, ignoreStrategy);
    }

    @Override
    public L nsw3(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nsw(classMapping3, property, queryAlias3, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L ew3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy) {
        return ew(classMapping3, name, value, queryAlias3, matchStrategy, ignoreStrategy);
    }

    @Override
    public L ew3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return ew(classMapping3, name, value, queryAlias3, matchStrategy, ignoreStrategy);
    }

    @Override
    public L ew3(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return ew(classMapping3, property, queryAlias3, matchStrategy, ignoreStrategy);
    }

    @Override
    public L ew3(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ew(classMapping3, property, queryAlias3, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L new3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy) {
        return newv(classMapping3, name, value, queryAlias3, matchStrategy, ignoreStrategy);
    }

    @Override
    public L new3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return newv(classMapping3, name, value, queryAlias3, matchStrategy, ignoreStrategy);
    }

    @Override
    public L new3(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return newv(classMapping3, property, queryAlias3, matchStrategy, ignoreStrategy);
    }

    @Override
    public L new3(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return newv(classMapping3, property, queryAlias3, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L co3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy) {
        return co(classMapping3, name, value, queryAlias3, matchStrategy, ignoreStrategy);
    }

    @Override
    public L co3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return co(classMapping3, name, value, queryAlias3, matchStrategy, ignoreStrategy);
    }

    @Override
    public L co3(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return co(classMapping3, property, queryAlias3, matchStrategy, ignoreStrategy);
    }

    @Override
    public L co3(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return co(classMapping3, property, queryAlias3, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L nco3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy) {
        return nco(classMapping3, name, value, queryAlias3, matchStrategy, ignoreStrategy);
    }

    @Override
    public L nco3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return nco(classMapping3, name, value, queryAlias3, matchStrategy, ignoreStrategy);
    }

    @Override
    public L nco3(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return nco(classMapping3, property, queryAlias3, matchStrategy, ignoreStrategy);
    }

    @Override
    public L nco3(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nco(classMapping3, property, queryAlias3, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L ge3(SerializableFunction<E3, N> name, N value) {
        return ge(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public <N extends Number> L ge3(SerializableFunction<E3, N> name, N value, Predicate<N> ignoreStrategy) {
        return ge(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public <D extends Date> L ge3(SerializableFunction<E3, D> name, D value) {
        return ge(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public <D extends Date> L ge3(SerializableFunction<E3, D> name, D value, Predicate<D> ignoreStrategy) {
        return ge(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public L ge3(SerializableFunction<E3, LocalTime> name, LocalTime value) {
        return ge(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public L ge3(SerializableFunction<E3, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ge(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public L ge3(SerializableFunction<E3, LocalDate> name, LocalDate value) {
        return ge(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public L ge3(SerializableFunction<E3, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ge(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public L ge3(SerializableFunction<E3, LocalDateTime> name, LocalDateTime value) {
        return ge(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public L ge3(SerializableFunction<E3, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return ge(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public L ge3(SerializableFunction<E3, String> name, String value) {
        return ge(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public L ge3(SerializableFunction<E3, String> name, String value, Predicate<String> ignoreStrategy) {
        return ge(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge3(SerializableToIntFunction3<E3> name, int value) {
        return ge(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge3(SerializableToIntFunction3<E3> name, int value, Predicate<Integer> ignoreStrategy) {
        return ge(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge3(SerializableToLongFunction3<E3> name, long value) {
        return ge(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge3(SerializableToLongFunction3<E3> name, long value, Predicate<Long> ignoreStrategy) {
        return ge(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge3(SerializableToDoubleFunction3<E3> name, double value) {
        return ge(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge3(SerializableToDoubleFunction3<E3> name, double value, Predicate<Double> ignoreStrategy) {
        return ge(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public <R extends Date> L ge3(SerializableDateSupplier<R> property) {
        return ge(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public <R extends Date> L ge3(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ge(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public <R extends Number> L ge3(SerializableNumberSupplier<R> property) {
        return ge(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public <R extends Number> L ge3(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ge(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public L ge3(SerializableLocalDateSupplier property) {
        return ge(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public L ge3(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return ge(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public L ge3(SerializableLocalTimeSupplier property) {
        return ge(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public L ge3(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return ge(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public L ge3(SerializableLocalDateTimeSupplier property) {
        return ge(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public L ge3(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return ge(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public L ge3(SerializableStringSupplier property) {
        return ge(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public L ge3(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return ge(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge3(SerializableIntSupplier property) {
        return ge(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge3(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return ge(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge3(SerializableLongSupplier property) {
        return ge(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge3(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return ge(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge3(SerializableDoubleSupplier property) {
        return ge(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge3(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy) {
        return ge(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L gt3(SerializableFunction<E3, N> name, N value) {
        return gt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public <N extends Number> L gt3(SerializableFunction<E3, N> name, N value, Predicate<N> ignoreStrategy) {
        return gt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public <D extends Date> L gt3(SerializableFunction<E3, D> name, D value) {
        return gt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public <D extends Date> L gt3(SerializableFunction<E3, D> name, D value, Predicate<D> ignoreStrategy) {
        return gt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public L gt3(SerializableFunction<E3, LocalTime> name, LocalTime value) {
        return gt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public L gt3(SerializableFunction<E3, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return gt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public L gt3(SerializableFunction<E3, LocalDate> name, LocalDate value) {
        return gt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public L gt3(SerializableFunction<E3, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return gt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public L gt3(SerializableFunction<E3, LocalDateTime> name, LocalDateTime value) {
        return gt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public L gt3(SerializableFunction<E3, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return gt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public L gt3(SerializableFunction<E3, String> name, String value) {
        return gt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public L gt3(SerializableFunction<E3, String> name, String value, Predicate<String> ignoreStrategy) {
        return gt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt3(SerializableToIntFunction3<E3> name, int value) {
        return gt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt3(SerializableToIntFunction3<E3> name, int value, Predicate<Integer> ignoreStrategy) {
        return gt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt3(SerializableToLongFunction3<E3> name, long value) {
        return gt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt3(SerializableToLongFunction3<E3> name, long value, Predicate<Long> ignoreStrategy) {
        return gt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt3(SerializableToDoubleFunction3<E3> name, double value) {
        return gt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt3(SerializableToDoubleFunction3<E3> name, double value, Predicate<Double> ignoreStrategy) {
        return gt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public <R extends Number> L gt3(SerializableNumberSupplier<R> property) {
        return gt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public <R extends Number> L gt3(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return gt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public <R extends Date> L gt3(SerializableDateSupplier<R> property) {
        return gt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public <R extends Date> L gt3(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return gt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public L gt3(SerializableLocalDateSupplier property) {
        return gt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public L gt3(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return gt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public L gt3(SerializableLocalTimeSupplier property) {
        return gt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public L gt3(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return gt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public L gt3(SerializableLocalDateTimeSupplier property) {
        return gt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public L gt3(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return gt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public L gt3(SerializableStringSupplier property) {
        return gt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public L gt3(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return gt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt3(SerializableIntSupplier property) {
        return gt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt3(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return gt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt3(SerializableLongSupplier property) {
        return gt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt3(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return gt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt3(SerializableDoubleSupplier property) {
        return gt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt3(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy) {
        return gt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L le3(SerializableFunction<E3, N> name, N value) {
        return le(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public <N extends Number> L le3(SerializableFunction<E3, N> name, N value, Predicate<N> ignoreStrategy) {
        return le(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public <D extends Date> L le3(SerializableFunction<E3, D> name, D value) {
        return le(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public <D extends Date> L le3(SerializableFunction<E3, D> name, D value, Predicate<D> ignoreStrategy) {
        return le(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public L le3(SerializableFunction<E3, LocalTime> name, LocalTime value) {
        return le(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public L le3(SerializableFunction<E3, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return le(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public L le3(SerializableFunction<E3, LocalDate> name, LocalDate value) {
        return le(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public L le3(SerializableFunction<E3, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return le(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public L le3(SerializableFunction<E3, LocalDateTime> name, LocalDateTime value) {
        return le(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public L le3(SerializableFunction<E3, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return le(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public L le3(SerializableFunction<E3, String> name, String value) {
        return le(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public L le3(SerializableFunction<E3, String> name, String value, Predicate<String> ignoreStrategy) {
        return le(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public <R extends Date> L le3(SerializableDateSupplier<R> property) {
        return le(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public <R extends Date> L le3(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return le(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public <R extends Number> L le3(SerializableNumberSupplier<R> property) {
        return le(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public <R extends Number> L le3(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return le(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public L le3(SerializableLocalDateSupplier property) {
        return le(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public L le3(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return le(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public L le3(SerializableLocalTimeSupplier property) {
        return le(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public L le3(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return le(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public L le3(SerializableLocalDateTimeSupplier property) {
        return le(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public L le3(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return le(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public L le3(SerializableStringSupplier property) {
        return le(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public L le3(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return le(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le3(SerializableToIntFunction3<E3> name, int value) {
        return le(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le3(SerializableToIntFunction3<E3> name, int value, Predicate<Integer> ignoreStrategy) {
        return le(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le3(SerializableToLongFunction3<E3> name, long value) {
        return le(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le3(SerializableToLongFunction3<E3> name, long value, Predicate<Long> ignoreStrategy) {
        return le(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le3(SerializableToDoubleFunction3<E3> name, double value) {
        return le(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le3(SerializableToDoubleFunction3<E3> name, double value, Predicate<Double> ignoreStrategy) {
        return le(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le3(SerializableIntSupplier property) {
        return le(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le3(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return le(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le3(SerializableLongSupplier property) {
        return le(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le3(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return le(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le3(SerializableDoubleSupplier property) {
        return le(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le3(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy) {
        return le(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L lt3(SerializableFunction<E3, N> name, N value) {
        return lt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public <N extends Number> L lt3(SerializableFunction<E3, N> name, N value, Predicate<N> ignoreStrategy) {
        return lt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public <D extends Date> L lt3(SerializableFunction<E3, D> name, D value) {
        return lt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public <D extends Date> L lt3(SerializableFunction<E3, D> name, D value, Predicate<D> ignoreStrategy) {
        return lt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public L lt3(SerializableFunction<E3, LocalTime> name, LocalTime value) {
        return lt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public L lt3(SerializableFunction<E3, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return lt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public L lt3(SerializableFunction<E3, LocalDate> name, LocalDate value) {
        return lt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public L lt3(SerializableFunction<E3, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return lt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public L lt3(SerializableFunction<E3, LocalDateTime> name, LocalDateTime value) {
        return lt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public L lt3(SerializableFunction<E3, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return lt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public L lt3(SerializableFunction<E3, String> name, String value) {
        return lt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public L lt3(SerializableFunction<E3, String> name, String value, Predicate<String> ignoreStrategy) {
        return lt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public <R extends Number> L lt3(SerializableNumberSupplier<R> property) {
        return lt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public <R extends Number> L lt3(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return lt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public <R extends Date> L lt3(SerializableDateSupplier<R> property) {
        return lt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public <R extends Date> L lt3(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return lt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public L lt3(SerializableLocalDateSupplier property) {
        return lt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public L lt3(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return lt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public L lt3(SerializableLocalTimeSupplier property) {
        return lt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public L lt3(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return lt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public L lt3(SerializableLocalDateTimeSupplier property) {
        return lt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public L lt3(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return lt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public L lt3(SerializableStringSupplier property) {
        return lt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public L lt3(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return lt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt3(SerializableToIntFunction3<E3> name, int value) {
        return lt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt3(SerializableToIntFunction3<E3> name, int value, Predicate<Integer> ignoreStrategy) {
        return lt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt3(SerializableToLongFunction3<E3> name, long value) {
        return lt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt3(SerializableToLongFunction3<E3> name, long value, Predicate<Long> ignoreStrategy) {
        return lt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt3(SerializableToDoubleFunction3<E3> name, double value) {
        return lt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt3(SerializableToDoubleFunction3<E3> name, double value, Predicate<Double> ignoreStrategy) {
        return lt(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt3(SerializableIntSupplier property) {
        return lt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt3(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return lt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt3(SerializableLongSupplier property) {
        return lt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt3(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return lt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt3(SerializableDoubleSupplier property) {
        return lt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt3(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy) {
        return lt(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <R> L in3(SerializableFunction<E3, R> name, R value) {
        return in(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public <R> L in3(SerializableFunction<E3, R> name, R value, Predicate<R> ignoreStrategy) {
        return in(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public <R> L in3(SerializableFunction<E3, R> name, @SuppressWarnings("unchecked") R... value) {
        return in(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public <R> L in3(SerializableFunction<E3, R> name, R[] value, Predicate<R[]> ignoreStrategy) {
        return in(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public <R> L in3(SerializableFunction<E3, R> name, Collection<R> value) {
        return in(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public <R> L in3(SerializableFunction<E3, R> name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy) {
        return in(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public <R> L in3(SerializableSupplier<R> property) {
        return in(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public <R> L in3(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return in(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in3(SerializableToIntFunction3<E3> name, int value) {
        return in(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in3(SerializableToIntFunction3<E3> name, int value, Predicate<Integer> ignoreStrategy) {
        return in(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in3(SerializableToLongFunction3<E3> name, long value) {
        return in(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in3(SerializableToLongFunction3<E3> name, long value, Predicate<Long> ignoreStrategy) {
        return in(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in3(SerializableToIntFunction3<E3> name, int... value) {
        return in(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in3(SerializableToLongFunction3<E3> name, long... value) {
        return in(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in3(SerializableToIntFunction3<E3> name, int[] value, Predicate<int[]> ignoreStrategy) {
        return in(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in3(SerializableToLongFunction3<E3> name, long[] value, Predicate<long[]> ignoreStrategy) {
        return in(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in3(SerializableIntSupplier property) {
        return in(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in3(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return in(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in3(SerializableLongSupplier property) {
        return in(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in3(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return in(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <R> L ni3(SerializableFunction<E3, R> name, R value) {
        return ni(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public <R> L ni3(SerializableFunction<E3, R> name, R value, Predicate<R> ignoreStrategy) {
        return ni(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public <R> L ni3(SerializableFunction<E3, R> name, @SuppressWarnings("unchecked") R... value) {
        return ni(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public <R> L ni3(SerializableFunction<E3, R> name, R[] value, Predicate<R[]> ignoreStrategy) {
        return ni(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public <R> L ni3(SerializableFunction<E3, R> name, Collection<R> value) {
        return ni(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public <R> L ni3(SerializableFunction<E3, R> name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy) {
        return ni(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public <R> L ni3(SerializableSupplier<R> property) {
        return ni(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public <R> L ni3(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ni(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni3(SerializableToIntFunction3<E3> name, int value) {
        return ni(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni3(SerializableToIntFunction3<E3> name, int value, Predicate<Integer> ignoreStrategy) {
        return ni(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni3(SerializableToLongFunction3<E3> name, long value) {
        return ni(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni3(SerializableToLongFunction3<E3> name, long value, Predicate<Long> ignoreStrategy) {
        return ni(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni3(SerializableToIntFunction3<E3> name, int... value) {
        return ni(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni3(SerializableToLongFunction3<E3> name, long... value) {
        return ni(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni3(SerializableToIntFunction3<E3> name, int[] value, Predicate<int[]> ignoreStrategy) {
        return ni(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni3(SerializableToLongFunction3<E3> name, long[] value, Predicate<long[]> ignoreStrategy) {
        return ni(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni3(SerializableIntSupplier property) {
        return ni(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni3(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return ni(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni3(SerializableLongSupplier property) {
        return ni(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni3(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return ni(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <R> L inn3(SerializableFunction<E3, R> name, Boolean value) {
        return inn(classMapping3, name, value, queryAlias3);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L isn3(SerializableFunction<E3, R> name, Boolean value) {
        return isn(classMapping3, name, value, queryAlias3);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba3(SerializableToIntFunction<E3> name, int min, int max) {
        return ba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba3(SerializableToIntFunction<E3> name, int min, int max, BiPredicate<Integer, Integer> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba3(SerializableToLongFunction<E3> name, long min, long max) {
        return ba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba3(SerializableToLongFunction<E3> name, long min, long max, BiPredicate<Long, Long> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba3(SerializableToDoubleFunction<E3> name, double min, double max) {
        return ba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba3(SerializableToDoubleFunction<E3> name, double min, double max,
            BiPredicate<Double, Double> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ba3(SerializableFunction<E3, N> name, N min, N max) {
        return ba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ba3(SerializableFunction<E3, N> name, N min, N max, BiPredicate<N, N> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ba3(SerializableFunction<E3, D> name, D min, D max) {
        return ba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ba3(SerializableFunction<E3, D> name, D min, D max, BiPredicate<D, D> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba3(SerializableFunction<E3, LocalTime> name, LocalTime min, LocalTime max) {
        return ba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba3(SerializableFunction<E3, LocalTime> name, LocalTime min, LocalTime max,
            BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba3(SerializableFunction<E3, LocalDate> name, LocalDate min, LocalDate max) {
        return ba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba3(SerializableFunction<E3, LocalDate> name, LocalDate min, LocalDate max,
            BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba3(SerializableFunction<E3, LocalDateTime> name, LocalDateTime min, LocalDateTime max) {
        return ba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba3(SerializableFunction<E3, LocalDateTime> name, LocalDateTime min, LocalDateTime max,
            BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba3(SerializableFunction<E3, String> name, String min, String max) {
        return ba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba3(SerializableFunction<E3, String> name, String min, String max,
            BiPredicate<String, String> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba3(SerializableToIntFunction<E3> name, int min, int max) {
        return nba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba3(SerializableToIntFunction<E3> name, int min, int max, BiPredicate<Integer, Integer> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba3(SerializableToLongFunction<E3> name, long min, long max) {
        return nba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba3(SerializableToLongFunction<E3> name, long min, long max, BiPredicate<Long, Long> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba3(SerializableToDoubleFunction<E3> name, double min, double max) {
        return nba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba3(SerializableToDoubleFunction<E3> name, double min, double max,
            BiPredicate<Double, Double> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L nba3(SerializableFunction<E3, N> name, N min, N max) {
        return nba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L nba3(SerializableFunction<E3, N> name, N min, N max, BiPredicate<N, N> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L nba3(SerializableFunction<E3, D> name, D min, D max) {
        return nba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L nba3(SerializableFunction<E3, D> name, D min, D max, BiPredicate<D, D> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba3(SerializableFunction<E3, LocalTime> name, LocalTime min, LocalTime max) {
        return nba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba3(SerializableFunction<E3, LocalTime> name, LocalTime min, LocalTime max,
            BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba3(SerializableFunction<E3, LocalDate> name, LocalDate min, LocalDate max) {
        return nba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba3(SerializableFunction<E3, LocalDate> name, LocalDate min, LocalDate max,
            BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba3(SerializableFunction<E3, LocalDateTime> name, LocalDateTime min, LocalDateTime max) {
        return nba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba3(SerializableFunction<E3, LocalDateTime> name, LocalDateTime min, LocalDateTime max,
            BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba3(SerializableFunction<E3, String> name, String min, String max) {
        return nba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba3(SerializableFunction<E3, String> name, String min, String max,
            BiPredicate<String, String> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias3, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L property(ThreeArgusFunction<EntityPropertyFunction<E, C, L>, EntityPropertyFunction<E2, C, L>,
            EntityPropertyFunction<E3, C, L>, L> entitiesPropertyFunction) {
        return entitiesPropertyFunction.apply(new EntityPropertyFunctionImpl<>(0, this, factory),
                new EntityPropertyFunctionImpl<>(1, this, factory), new EntityPropertyFunctionImpl<>(2, this, factory));
    }

    // ********************************************************************
    // private method
    // ********************************************************************

    // ********************************************************************
    // protected method
    // ********************************************************************

}
