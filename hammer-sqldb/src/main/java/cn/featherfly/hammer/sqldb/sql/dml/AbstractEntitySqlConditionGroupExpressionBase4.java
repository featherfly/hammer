
package cn.featherfly.hammer.sqldb.sql.dml;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Date;
import java.util.function.Predicate;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.lang.function.DateSupplier;
import cn.featherfly.common.lang.function.LocalDateSupplier;
import cn.featherfly.common.lang.function.LocalDateTimeSupplier;
import cn.featherfly.common.lang.function.LocalTimeSupplier;
import cn.featherfly.common.lang.function.NumberSupplier;
import cn.featherfly.common.lang.function.SerializableDoubleSupplier;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableIntSupplier;
import cn.featherfly.common.lang.function.SerializableLongSupplier;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.common.lang.function.SerializableSupplier4;
import cn.featherfly.common.lang.function.SerializableToDoubleFunction4;
import cn.featherfly.common.lang.function.SerializableToIntFunction4;
import cn.featherfly.common.lang.function.SerializableToLongFunction4;
import cn.featherfly.common.lang.function.StringSupplier;
import cn.featherfly.common.operator.QueryOperator.QueryPolicy;
import cn.featherfly.hammer.expression.condition.GroupEndExpression;
import cn.featherfly.hammer.expression.condition.GroupExpression;
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
import cn.featherfly.hammer.expression.entity.condition.ne.EntityNotEqualsExpressionBase4;
import cn.featherfly.hammer.expression.entity.condition.nin.EntityNotInExpressionBase4;
import cn.featherfly.hammer.expression.entity.condition.sw.EntityStartWithExpressionBase4;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlRelation;

/**
 * sql condition group builder sql条件逻辑组构造器 .
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public abstract class AbstractEntitySqlConditionGroupExpressionBase4<E, E2, E3, E4, ER extends EntitySqlRelation<ER, B>,
        B extends SqlBuilder, C extends GroupExpression<C, L>, L extends GroupEndExpression<C, L>>
        extends AbstractEntitySqlConditionGroupExpressionBase3<E, E2, E3, ER, B, C, L> implements
        EntityContainsExpressionBase4<E, E2, E3, E4, C, L>, EntityEndWithExpressionBase4<E, E2, E3, E4, C, L>,
        EntityEqualsExpressionBase4<E, E2, E3, E4, C, L>, EntityGreatEqualsExpressionBase4<E, E2, E3, E4, C, L>,
        EntityGreatThanExpressionBase4<E, E2, E3, E4, C, L>, EntityInExpressionBase4<E, E2, E3, E4, C, L>,
        EntityIsNotNullExpressionBase4<E, E2, E3, E4, C, L>, EntityIsNullExpressionBase4<E, E2, E3, E4, C, L>,
        EntityLessEqualsExpressionBase4<E, E2, E3, E4, C, L>, EntityLessThanExpressionBase4<E, E2, E3, E4, C, L>,
        EntityNotEqualsExpressionBase4<E, E2, E3, E4, C, L>, EntityNotInExpressionBase4<E, E2, E3, E4, C, L>,
        EntityStartWithExpressionBase4<E, E2, E3, E4, C, L>, EntityLikeExpressionBase4<E, E2, E3, E4, C, L> {

    /** The class mapping. */
    protected JdbcClassMapping<E4> classMapping4;

    private String queryAlias4;

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

        classMapping4 = (JdbcClassMapping<E4>) entitySqlRelation.getEntityRelationMappingTuple().getOrNull4()
                .getClassMapping();
        queryAlias4 = entitySqlRelation.getEntityRelationMappingTuple().getOrNull4().getTableAlias();
    }

    @Override
    public <R> L eq4(SerializableFunction<E4, R> name, R value, QueryPolicy queryPolicy) {
        return eq(name, value, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public <R> L eq4(SerializableFunction<E4, R> name, R value, QueryPolicy queryPolicy, Predicate<R> ignoreStrategy) {
        return eq(name, value, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public <R> L eq4(SerializableSupplier4<R> property, QueryPolicy queryPolicy) {
        return eq(property, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public <R> L eq4(SerializableSupplier4<R> property, QueryPolicy queryPolicy, Predicate<R> ignoreStrategy) {
        return eq(property, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <R> L ne4(SerializableFunction<E4, R> name, R value, QueryPolicy queryPolicy) {
        return ne(name, value, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public <R> L ne4(SerializableFunction<E4, R> name, R value, QueryPolicy queryPolicy, Predicate<R> ignoreStrategy) {
        return ne(name, value, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public <R> L ne4(SerializableSupplier4<R> property, QueryPolicy queryPolicy) {
        return ne(property, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public <R> L ne4(SerializableSupplier4<R> property, QueryPolicy queryPolicy, Predicate<R> ignoreStrategy) {
        return ne(property, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L lk4(SerializableFunction<E4, String> name, String value, QueryPolicy queryPolicy) {
        return lk(name, value, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public L lk4(SerializableFunction<E4, String> name, String value, QueryPolicy queryPolicy,
            Predicate<String> ignoreStrategy) {
        return lk(name, value, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public L lk4(StringSupplier property, QueryPolicy queryPolicy) {
        return lk(property, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public L lk4(StringSupplier property, QueryPolicy queryPolicy, Predicate<String> ignoreStrategy) {
        return lk(property, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L sw4(SerializableFunction<E4, String> name, String value, QueryPolicy queryPolicy) {
        return sw(name, value, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public L sw4(SerializableFunction<E4, String> name, String value, QueryPolicy queryPolicy,
            Predicate<String> ignoreStrategy) {
        return sw(name, value, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public L sw4(StringSupplier property, QueryPolicy queryPolicy) {
        return sw(property, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public L sw4(StringSupplier property, QueryPolicy queryPolicy, Predicate<String> ignoreStrategy) {
        return sw(property, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L ew4(SerializableFunction<E4, String> name, String value, QueryPolicy queryPolicy) {
        return ew(name, value, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public L ew4(SerializableFunction<E4, String> name, String value, QueryPolicy queryPolicy,
            Predicate<String> ignoreStrategy) {
        return ew(name, value, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public L ew4(StringSupplier property, QueryPolicy queryPolicy) {
        return ew(property, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public L ew4(StringSupplier property, QueryPolicy queryPolicy, Predicate<String> ignoreStrategy) {
        return ew(property, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L co4(SerializableFunction<E4, String> name, String value, QueryPolicy queryPolicy) {
        return co(name, value, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public L co4(SerializableFunction<E4, String> name, String value, QueryPolicy queryPolicy,
            Predicate<String> ignoreStrategy) {
        return co(name, value, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public L co4(StringSupplier property, QueryPolicy queryPolicy) {
        return co(property, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public L co4(StringSupplier property, QueryPolicy queryPolicy, Predicate<String> ignoreStrategy) {
        return co(property, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L ge4(SerializableFunction<E4, N> name, N value) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <N extends Number> L ge4(SerializableFunction<E4, N> name, N value, Predicate<N> ignoreStrategy) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <D extends Date> L ge4(SerializableFunction<E4, D> name, D value) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <D extends Date> L ge4(SerializableFunction<E4, D> name, D value, Predicate<D> ignoreStrategy) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge4(SerializableFunction<E4, LocalTime> name, LocalTime value) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge4(SerializableFunction<E4, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge4(SerializableFunction<E4, LocalDate> name, LocalDate value) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge4(SerializableFunction<E4, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge4(SerializableFunction<E4, LocalDateTime> name, LocalDateTime value) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge4(SerializableFunction<E4, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge4(SerializableFunction<E4, String> name, String value) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge4(SerializableFunction<E4, String> name, String value, Predicate<String> ignoreStrategy) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge4(SerializableToIntFunction4<E4> name, int value) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge4(SerializableToIntFunction4<E4> name, int value, Predicate<Integer> ignoreStrategy) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge4(SerializableToLongFunction4<E4> name, long value) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge4(SerializableToLongFunction4<E4> name, long value, Predicate<Long> ignoreStrategy) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge4(SerializableToDoubleFunction4<E4> name, double value) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge4(SerializableToDoubleFunction4<E4> name, double value, Predicate<Double> ignoreStrategy) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Date> L ge4(DateSupplier<R> property) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Date> L ge4(DateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Number> L ge4(NumberSupplier<R> property) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Number> L ge4(NumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge4(LocalDateSupplier property) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge4(LocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge4(LocalTimeSupplier property) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge4(LocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge4(LocalDateTimeSupplier property) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge4(LocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge4(StringSupplier property) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge4(StringSupplier property, Predicate<String> ignoreStrategy) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge4(SerializableIntSupplier property) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge4(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge4(SerializableLongSupplier property) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge4(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge4(SerializableDoubleSupplier property) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge4(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L gt4(SerializableFunction<E4, N> name, N value) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <N extends Number> L gt4(SerializableFunction<E4, N> name, N value, Predicate<N> ignoreStrategy) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <D extends Date> L gt4(SerializableFunction<E4, D> name, D value) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <D extends Date> L gt4(SerializableFunction<E4, D> name, D value, Predicate<D> ignoreStrategy) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt4(SerializableFunction<E4, LocalTime> name, LocalTime value) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt4(SerializableFunction<E4, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt4(SerializableFunction<E4, LocalDate> name, LocalDate value) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt4(SerializableFunction<E4, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt4(SerializableFunction<E4, LocalDateTime> name, LocalDateTime value) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt4(SerializableFunction<E4, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt4(SerializableFunction<E4, String> name, String value) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt4(SerializableFunction<E4, String> name, String value, Predicate<String> ignoreStrategy) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt4(SerializableToIntFunction4<E4> name, int value) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt4(SerializableToIntFunction4<E4> name, int value, Predicate<Integer> ignoreStrategy) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt4(SerializableToLongFunction4<E4> name, long value) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt4(SerializableToLongFunction4<E4> name, long value, Predicate<Long> ignoreStrategy) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt4(SerializableToDoubleFunction4<E4> name, double value) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt4(SerializableToDoubleFunction4<E4> name, double value, Predicate<Double> ignoreStrategy) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Number> L gt4(NumberSupplier<R> property) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Number> L gt4(NumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Date> L gt4(DateSupplier<R> property) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Date> L gt4(DateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt4(LocalDateSupplier property) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt4(LocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt4(LocalTimeSupplier property) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt4(LocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt4(LocalDateTimeSupplier property) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt4(LocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt4(StringSupplier property) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt4(StringSupplier property, Predicate<String> ignoreStrategy) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt4(SerializableIntSupplier property) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt4(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt4(SerializableLongSupplier property) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt4(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt4(SerializableDoubleSupplier property) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt4(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L le4(SerializableFunction<E4, N> name, N value) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <N extends Number> L le4(SerializableFunction<E4, N> name, N value, Predicate<N> ignoreStrategy) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <D extends Date> L le4(SerializableFunction<E4, D> name, D value) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <D extends Date> L le4(SerializableFunction<E4, D> name, D value, Predicate<D> ignoreStrategy) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le4(SerializableFunction<E4, LocalTime> name, LocalTime value) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le4(SerializableFunction<E4, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le4(SerializableFunction<E4, LocalDate> name, LocalDate value) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le4(SerializableFunction<E4, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le4(SerializableFunction<E4, LocalDateTime> name, LocalDateTime value) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le4(SerializableFunction<E4, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le4(SerializableFunction<E4, String> name, String value) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le4(SerializableFunction<E4, String> name, String value, Predicate<String> ignoreStrategy) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Date> L le4(DateSupplier<R> property) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Date> L le4(DateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Number> L le4(NumberSupplier<R> property) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Number> L le4(NumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le4(LocalDateSupplier property) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le4(LocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le4(LocalTimeSupplier property) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le4(LocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le4(LocalDateTimeSupplier property) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le4(LocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le4(StringSupplier property) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le4(StringSupplier property, Predicate<String> ignoreStrategy) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le4(SerializableToIntFunction4<E4> name, int value) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le4(SerializableToIntFunction4<E4> name, int value, Predicate<Integer> ignoreStrategy) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le4(SerializableToLongFunction4<E4> name, long value) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le4(SerializableToLongFunction4<E4> name, long value, Predicate<Long> ignoreStrategy) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le4(SerializableToDoubleFunction4<E4> name, double value) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le4(SerializableToDoubleFunction4<E4> name, double value, Predicate<Double> ignoreStrategy) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le4(SerializableIntSupplier property) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le4(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le4(SerializableLongSupplier property) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le4(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le4(SerializableDoubleSupplier property) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le4(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L lt4(SerializableFunction<E4, N> name, N value) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <N extends Number> L lt4(SerializableFunction<E4, N> name, N value, Predicate<N> ignoreStrategy) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <D extends Date> L lt4(SerializableFunction<E4, D> name, D value) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <D extends Date> L lt4(SerializableFunction<E4, D> name, D value, Predicate<D> ignoreStrategy) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt4(SerializableFunction<E4, LocalTime> name, LocalTime value) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt4(SerializableFunction<E4, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt4(SerializableFunction<E4, LocalDate> name, LocalDate value) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt4(SerializableFunction<E4, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt4(SerializableFunction<E4, LocalDateTime> name, LocalDateTime value) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt4(SerializableFunction<E4, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt4(SerializableFunction<E4, String> name, String value) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt4(SerializableFunction<E4, String> name, String value, Predicate<String> ignoreStrategy) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Number> L lt4(NumberSupplier<R> property) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Number> L lt4(NumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Date> L lt4(DateSupplier<R> property) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Date> L lt4(DateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt4(LocalDateSupplier property) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt4(LocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt4(LocalTimeSupplier property) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt4(LocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt4(LocalDateTimeSupplier property) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt4(LocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt4(StringSupplier property) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt4(StringSupplier property, Predicate<String> ignoreStrategy) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt4(SerializableToIntFunction4<E4> name, int value) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt4(SerializableToIntFunction4<E4> name, int value, Predicate<Integer> ignoreStrategy) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt4(SerializableToLongFunction4<E4> name, long value) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt4(SerializableToLongFunction4<E4> name, long value, Predicate<Long> ignoreStrategy) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt4(SerializableToDoubleFunction4<E4> name, double value) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt4(SerializableToDoubleFunction4<E4> name, double value, Predicate<Double> ignoreStrategy) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt4(SerializableIntSupplier property) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt4(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt4(SerializableLongSupplier property) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt4(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt4(SerializableDoubleSupplier property) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt4(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <R> L in4(SerializableFunction<E4, R> name, R value) {
        return in(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R> L in4(SerializableFunction<E4, R> name, R value, Predicate<R> ignoreStrategy) {
        return in(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R> L in4(SerializableFunction<E4, R> name, @SuppressWarnings("unchecked") R... value) {
        return in(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R> L in4(SerializableFunction<E4, R> name, R[] value, Predicate<R[]> ignoreStrategy) {
        return in(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R> L in4(SerializableFunction<E4, R> name, Collection<R> value) {
        return in(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R> L in4(SerializableFunction<E4, R> name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy) {
        return in(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R> L in4(SerializableSupplier<R> property) {
        return in(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R> L in4(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return in(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in4(SerializableToIntFunction4<E4> name, int value) {
        return in(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in4(SerializableToIntFunction4<E4> name, int value, Predicate<Integer> ignoreStrategy) {
        return in(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in4(SerializableToLongFunction4<E4> name, long value) {
        return in(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in4(SerializableToLongFunction4<E4> name, long value, Predicate<Long> ignoreStrategy) {
        return in(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in4(SerializableToIntFunction4<E4> name, int... value) {
        return in(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in4(SerializableToLongFunction4<E4> name, long... value) {
        return in(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in4(SerializableToIntFunction4<E4> name, int[] value, Predicate<int[]> ignoreStrategy) {
        return in(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in4(SerializableToLongFunction4<E4> name, long[] value, Predicate<long[]> ignoreStrategy) {
        return in(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in4(SerializableIntSupplier property) {
        return in(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in4(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return in(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in4(SerializableLongSupplier property) {
        return in(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in4(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return in(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <R> L nin4(SerializableFunction<E4, R> name, R value) {
        return nin(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R> L nin4(SerializableFunction<E4, R> name, R value, Predicate<R> ignoreStrategy) {
        return nin(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R> L nin4(SerializableFunction<E4, R> name, @SuppressWarnings("unchecked") R... value) {
        return nin(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R> L nin4(SerializableFunction<E4, R> name, R[] value, Predicate<R[]> ignoreStrategy) {
        return nin(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R> L nin4(SerializableFunction<E4, R> name, Collection<R> value) {
        return nin(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R> L nin4(SerializableFunction<E4, R> name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy) {
        return nin(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R> L nin4(SerializableSupplier<R> property) {
        return nin(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R> L nin4(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return nin(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin4(SerializableToIntFunction4<E4> name, int value) {
        return nin(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin4(SerializableToIntFunction4<E4> name, int value, Predicate<Integer> ignoreStrategy) {
        return nin(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin4(SerializableToLongFunction4<E4> name, long value) {
        return nin(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin4(SerializableToLongFunction4<E4> name, long value, Predicate<Long> ignoreStrategy) {
        return nin(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin4(SerializableToIntFunction4<E4> name, int... value) {
        return nin(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin4(SerializableToLongFunction4<E4> name, long... value) {
        return nin(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin4(SerializableToIntFunction4<E4> name, int[] value, Predicate<int[]> ignoreStrategy) {
        return nin(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin4(SerializableToLongFunction4<E4> name, long[] value, Predicate<long[]> ignoreStrategy) {
        return nin(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin4(SerializableIntSupplier property) {
        return nin(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin4(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return nin(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin4(SerializableLongSupplier property) {
        return nin(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin4(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return nin(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <R> L inn4(SerializableFunction<E4, R> name, Boolean value) {
        return inn(name, value, getCurrentQueryAlias());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L isn4(SerializableFunction<E4, R> name, Boolean value) {
        return isn(name, value, getCurrentQueryAlias());
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
    protected String getCurrentQueryAlias() {
        return queryAlias4;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    protected <T> JdbcClassMapping<T> getCurrentClassMapping() {
        return (JdbcClassMapping<T>) classMapping4;
    }
}
