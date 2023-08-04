
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
import cn.featherfly.common.lang.function.SerializableSupplier2;
import cn.featherfly.common.lang.function.SerializableToDoubleFunction2;
import cn.featherfly.common.lang.function.SerializableToIntFunction2;
import cn.featherfly.common.lang.function.SerializableToLongFunction2;
import cn.featherfly.common.lang.function.StringSupplier;
import cn.featherfly.common.operator.QueryOperator.QueryPolicy;
import cn.featherfly.hammer.expression.condition.GroupEndExpression;
import cn.featherfly.hammer.expression.condition.GroupExpression;
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
import cn.featherfly.hammer.expression.entity.condition.ne.EntityNotEqualsExpressionBase2;
import cn.featherfly.hammer.expression.entity.condition.nin.EntityNotInExpressionBase2;
import cn.featherfly.hammer.expression.entity.condition.sw.EntityStartWithExpressionBase2;
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
public abstract class AbstractEntitySqlConditionGroupExpressionBase2<E, E2, ER extends EntitySqlRelation<ER, B>,
        B extends SqlBuilder, C extends GroupExpression<C, L>, L extends GroupEndExpression<C, L>>
        extends AbstractEntitySqlConditionGroupExpressionBase<E, ER, B, C, L>
        implements EntityContainsExpressionBase2<E, E2, C, L>, EntityEndWithExpressionBase2<E, E2, C, L>,
        EntityEqualsExpressionBase2<E, E2, C, L>, EntityGreatEqualsExpressionBase2<E, E2, C, L>,
        EntityGreatThanExpressionBase2<E, E2, C, L>, EntityInExpressionBase2<E, E2, C, L>,
        EntityIsNotNullExpressionBase2<E, E2, C, L>, EntityIsNullExpressionBase2<E, E2, C, L>,
        EntityLessEqualsExpressionBase2<E, E2, C, L>, EntityLessThanExpressionBase2<E, E2, C, L>,
        EntityNotEqualsExpressionBase2<E, E2, C, L>, EntityNotInExpressionBase2<E, E2, C, L>,
        EntityStartWithExpressionBase2<E, E2, C, L>, EntityLikeExpressionBase2<E, E2, C, L> {

    /** The class mapping. */
    protected JdbcClassMapping<E2> classMapping2;

    /** The query alias. */
    private String queryAlias2;

    /**
     * Instantiates a new abstract entity sql condition group expression base 2.
     *
     * @param parent            the parent
     * @param factory           the factory
     * @param entitySqlRelation the entity sql relation
     */
    @SuppressWarnings("unchecked")
    protected AbstractEntitySqlConditionGroupExpressionBase2(L parent, JdbcMappingFactory factory,
            ER entitySqlRelation) {
        super(parent, factory, entitySqlRelation);

        classMapping2 = (JdbcClassMapping<E2>) entitySqlRelation.getEntityRelationMappingTuple().getOrNull1()
                .getClassMapping();
        queryAlias2 = entitySqlRelation.getEntityRelationMappingTuple().getOrNull1().getTableAlias();
    }

    @Override
    public <R> L eq2(SerializableFunction<E2, R> name, R value, QueryPolicy queryPolicy) {
        return eq(name, value, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public <R> L eq2(SerializableFunction<E2, R> name, R value, QueryPolicy queryPolicy, Predicate<R> ignoreStrategy) {
        return eq(name, value, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public <R> L eq2(SerializableSupplier2<R> property, QueryPolicy queryPolicy) {
        return eq(property, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public <R> L eq2(SerializableSupplier2<R> property, QueryPolicy queryPolicy, Predicate<R> ignoreStrategy) {
        return eq(property, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <R> L ne2(SerializableFunction<E2, R> name, R value, QueryPolicy queryPolicy) {
        return ne(name, value, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public <R> L ne2(SerializableFunction<E2, R> name, R value, QueryPolicy queryPolicy, Predicate<R> ignoreStrategy) {
        return ne(name, value, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public <R> L ne2(SerializableSupplier2<R> property, QueryPolicy queryPolicy) {
        return ne(property, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public <R> L ne2(SerializableSupplier2<R> property, QueryPolicy queryPolicy, Predicate<R> ignoreStrategy) {
        return ne(property, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L lk2(SerializableFunction<E2, String> name, String value, QueryPolicy queryPolicy) {
        return lk(name, value, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public L lk2(SerializableFunction<E2, String> name, String value, QueryPolicy queryPolicy,
            Predicate<String> ignoreStrategy) {
        return lk(name, value, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public L lk2(StringSupplier property, QueryPolicy queryPolicy) {
        return lk(property, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public L lk2(StringSupplier property, QueryPolicy queryPolicy, Predicate<String> ignoreStrategy) {
        return lk(property, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L sw2(SerializableFunction<E2, String> name, String value, QueryPolicy queryPolicy) {
        return sw(name, value, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public L sw2(SerializableFunction<E2, String> name, String value, QueryPolicy queryPolicy,
            Predicate<String> ignoreStrategy) {
        return sw(name, value, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public L sw2(StringSupplier property, QueryPolicy queryPolicy) {
        return sw(property, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public L sw2(StringSupplier property, QueryPolicy queryPolicy, Predicate<String> ignoreStrategy) {
        return sw(property, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L ew2(SerializableFunction<E2, String> name, String value, QueryPolicy queryPolicy) {
        return ew(name, value, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public L ew2(SerializableFunction<E2, String> name, String value, QueryPolicy queryPolicy,
            Predicate<String> ignoreStrategy) {
        return ew(name, value, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public L ew2(StringSupplier property, QueryPolicy queryPolicy) {
        return ew(property, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public L ew2(StringSupplier property, QueryPolicy queryPolicy, Predicate<String> ignoreStrategy) {
        return ew(property, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L co2(SerializableFunction<E2, String> name, String value, QueryPolicy queryPolicy) {
        return co(name, value, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public L co2(SerializableFunction<E2, String> name, String value, QueryPolicy queryPolicy,
            Predicate<String> ignoreStrategy) {
        return co(name, value, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public L co2(StringSupplier property, QueryPolicy queryPolicy) {
        return co(property, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public L co2(StringSupplier property, QueryPolicy queryPolicy, Predicate<String> ignoreStrategy) {
        return co(property, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L ge2(SerializableFunction<E2, N> name, N value) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <N extends Number> L ge2(SerializableFunction<E2, N> name, N value, Predicate<N> ignoreStrategy) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <D extends Date> L ge2(SerializableFunction<E2, D> name, D value) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <D extends Date> L ge2(SerializableFunction<E2, D> name, D value, Predicate<D> ignoreStrategy) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge2(SerializableFunction<E2, LocalTime> name, LocalTime value) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge2(SerializableFunction<E2, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge2(SerializableFunction<E2, LocalDate> name, LocalDate value) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge2(SerializableFunction<E2, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge2(SerializableFunction<E2, LocalDateTime> name, LocalDateTime value) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge2(SerializableFunction<E2, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge2(SerializableFunction<E2, String> name, String value) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge2(SerializableFunction<E2, String> name, String value, Predicate<String> ignoreStrategy) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableToIntFunction2<E2> name, int value) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableToIntFunction2<E2> name, int value, Predicate<Integer> ignoreStrategy) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableToLongFunction2<E2> name, long value) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableToLongFunction2<E2> name, long value, Predicate<Long> ignoreStrategy) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableToDoubleFunction2<E2> name, double value) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableToDoubleFunction2<E2> name, double value, Predicate<Double> ignoreStrategy) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Date> L ge2(DateSupplier<R> property) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Date> L ge2(DateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Number> L ge2(NumberSupplier<R> property) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Number> L ge2(NumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge2(LocalDateSupplier property) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge2(LocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge2(LocalTimeSupplier property) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge2(LocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge2(LocalDateTimeSupplier property) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge2(LocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge2(StringSupplier property) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge2(StringSupplier property, Predicate<String> ignoreStrategy) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableIntSupplier property) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableLongSupplier property) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableDoubleSupplier property) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L gt2(SerializableFunction<E2, N> name, N value) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <N extends Number> L gt2(SerializableFunction<E2, N> name, N value, Predicate<N> ignoreStrategy) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <D extends Date> L gt2(SerializableFunction<E2, D> name, D value) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <D extends Date> L gt2(SerializableFunction<E2, D> name, D value, Predicate<D> ignoreStrategy) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt2(SerializableFunction<E2, LocalTime> name, LocalTime value) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt2(SerializableFunction<E2, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt2(SerializableFunction<E2, LocalDate> name, LocalDate value) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt2(SerializableFunction<E2, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt2(SerializableFunction<E2, LocalDateTime> name, LocalDateTime value) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt2(SerializableFunction<E2, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt2(SerializableFunction<E2, String> name, String value) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt2(SerializableFunction<E2, String> name, String value, Predicate<String> ignoreStrategy) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableToIntFunction2<E2> name, int value) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableToIntFunction2<E2> name, int value, Predicate<Integer> ignoreStrategy) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableToLongFunction2<E2> name, long value) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableToLongFunction2<E2> name, long value, Predicate<Long> ignoreStrategy) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableToDoubleFunction2<E2> name, double value) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableToDoubleFunction2<E2> name, double value, Predicate<Double> ignoreStrategy) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Number> L gt2(NumberSupplier<R> property) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Number> L gt2(NumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Date> L gt2(DateSupplier<R> property) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Date> L gt2(DateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt2(LocalDateSupplier property) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt2(LocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt2(LocalTimeSupplier property) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt2(LocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt2(LocalDateTimeSupplier property) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt2(LocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt2(StringSupplier property) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt2(StringSupplier property, Predicate<String> ignoreStrategy) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableIntSupplier property) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableLongSupplier property) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableDoubleSupplier property) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L le2(SerializableFunction<E2, N> name, N value) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <N extends Number> L le2(SerializableFunction<E2, N> name, N value, Predicate<N> ignoreStrategy) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <D extends Date> L le2(SerializableFunction<E2, D> name, D value) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <D extends Date> L le2(SerializableFunction<E2, D> name, D value, Predicate<D> ignoreStrategy) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le2(SerializableFunction<E2, LocalTime> name, LocalTime value) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le2(SerializableFunction<E2, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le2(SerializableFunction<E2, LocalDate> name, LocalDate value) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le2(SerializableFunction<E2, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le2(SerializableFunction<E2, LocalDateTime> name, LocalDateTime value) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le2(SerializableFunction<E2, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le2(SerializableFunction<E2, String> name, String value) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le2(SerializableFunction<E2, String> name, String value, Predicate<String> ignoreStrategy) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Date> L le2(DateSupplier<R> property) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Date> L le2(DateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Number> L le2(NumberSupplier<R> property) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Number> L le2(NumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le2(LocalDateSupplier property) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le2(LocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le2(LocalTimeSupplier property) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le2(LocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le2(LocalDateTimeSupplier property) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le2(LocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le2(StringSupplier property) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le2(StringSupplier property, Predicate<String> ignoreStrategy) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableToIntFunction2<E2> name, int value) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableToIntFunction2<E2> name, int value, Predicate<Integer> ignoreStrategy) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableToLongFunction2<E2> name, long value) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableToLongFunction2<E2> name, long value, Predicate<Long> ignoreStrategy) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableToDoubleFunction2<E2> name, double value) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableToDoubleFunction2<E2> name, double value, Predicate<Double> ignoreStrategy) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableIntSupplier property) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableLongSupplier property) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableDoubleSupplier property) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L lt2(SerializableFunction<E2, N> name, N value) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <N extends Number> L lt2(SerializableFunction<E2, N> name, N value, Predicate<N> ignoreStrategy) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <D extends Date> L lt2(SerializableFunction<E2, D> name, D value) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <D extends Date> L lt2(SerializableFunction<E2, D> name, D value, Predicate<D> ignoreStrategy) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt2(SerializableFunction<E2, LocalTime> name, LocalTime value) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt2(SerializableFunction<E2, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt2(SerializableFunction<E2, LocalDate> name, LocalDate value) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt2(SerializableFunction<E2, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt2(SerializableFunction<E2, LocalDateTime> name, LocalDateTime value) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt2(SerializableFunction<E2, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt2(SerializableFunction<E2, String> name, String value) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt2(SerializableFunction<E2, String> name, String value, Predicate<String> ignoreStrategy) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Number> L lt2(NumberSupplier<R> property) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Number> L lt2(NumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Date> L lt2(DateSupplier<R> property) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Date> L lt2(DateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt2(LocalDateSupplier property) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt2(LocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt2(LocalTimeSupplier property) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt2(LocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt2(LocalDateTimeSupplier property) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt2(LocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt2(StringSupplier property) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt2(StringSupplier property, Predicate<String> ignoreStrategy) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableToIntFunction2<E2> name, int value) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableToIntFunction2<E2> name, int value, Predicate<Integer> ignoreStrategy) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableToLongFunction2<E2> name, long value) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableToLongFunction2<E2> name, long value, Predicate<Long> ignoreStrategy) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableToDoubleFunction2<E2> name, double value) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableToDoubleFunction2<E2> name, double value, Predicate<Double> ignoreStrategy) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableIntSupplier property) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableLongSupplier property) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableDoubleSupplier property) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <R> L in2(SerializableFunction<E2, R> name, R value) {
        return in(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R> L in2(SerializableFunction<E2, R> name, R value, Predicate<R> ignoreStrategy) {
        return in(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R> L in2(SerializableFunction<E2, R> name, @SuppressWarnings("unchecked") R... value) {
        return in(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R> L in2(SerializableFunction<E2, R> name, R[] value, Predicate<R[]> ignoreStrategy) {
        return in(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R> L in2(SerializableFunction<E2, R> name, Collection<R> value) {
        return in(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R> L in2(SerializableFunction<E2, R> name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy) {
        return in(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R> L in2(SerializableSupplier<R> property) {
        return in(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R> L in2(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return in(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(SerializableToIntFunction2<E2> name, int value) {
        return in(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(SerializableToIntFunction2<E2> name, int value, Predicate<Integer> ignoreStrategy) {
        return in(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(SerializableToLongFunction2<E2> name, long value) {
        return in(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(SerializableToLongFunction2<E2> name, long value, Predicate<Long> ignoreStrategy) {
        return in(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(SerializableToIntFunction2<E2> name, int... value) {
        return in(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(SerializableToLongFunction2<E2> name, long... value) {
        return in(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(SerializableToIntFunction2<E2> name, int[] value, Predicate<int[]> ignoreStrategy) {
        return in(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(SerializableToLongFunction2<E2> name, long[] value, Predicate<long[]> ignoreStrategy) {
        return in(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in2(SerializableIntSupplier property) {
        return in(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in2(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return in(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in2(SerializableLongSupplier property) {
        return in(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in2(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return in(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <R> L nin2(SerializableFunction<E2, R> name, R value) {
        return nin(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R> L nin2(SerializableFunction<E2, R> name, R value, Predicate<R> ignoreStrategy) {
        return nin(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R> L nin2(SerializableFunction<E2, R> name, @SuppressWarnings("unchecked") R... value) {
        return nin(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R> L nin2(SerializableFunction<E2, R> name, R[] value, Predicate<R[]> ignoreStrategy) {
        return nin(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R> L nin2(SerializableFunction<E2, R> name, Collection<R> value) {
        return nin(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R> L nin2(SerializableFunction<E2, R> name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy) {
        return nin(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R> L nin2(SerializableSupplier<R> property) {
        return nin(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R> L nin2(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return nin(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin2(SerializableToIntFunction2<E2> name, int value) {
        return nin(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin2(SerializableToIntFunction2<E2> name, int value, Predicate<Integer> ignoreStrategy) {
        return nin(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin2(SerializableToLongFunction2<E2> name, long value) {
        return nin(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin2(SerializableToLongFunction2<E2> name, long value, Predicate<Long> ignoreStrategy) {
        return nin(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin2(SerializableToIntFunction2<E2> name, int... value) {
        return nin(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin2(SerializableToLongFunction2<E2> name, long... value) {
        return nin(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin2(SerializableToIntFunction2<E2> name, int[] value, Predicate<int[]> ignoreStrategy) {
        return nin(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin2(SerializableToLongFunction2<E2> name, long[] value, Predicate<long[]> ignoreStrategy) {
        return nin(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin2(SerializableIntSupplier property) {
        return nin(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin2(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return nin(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin2(SerializableLongSupplier property) {
        return nin(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin2(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return nin(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <R> L inn2(SerializableFunction<E2, R> name, Boolean value) {
        return inn(name, value, getCurrentQueryAlias());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L isn2(SerializableFunction<E2, R> name, Boolean value) {
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
        return queryAlias2;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    protected <T> JdbcClassMapping<T> getCurrentClassMapping() {
        return (JdbcClassMapping<T>) classMapping2;
    }
}
