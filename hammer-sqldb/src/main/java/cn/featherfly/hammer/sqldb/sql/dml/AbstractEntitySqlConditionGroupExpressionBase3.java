
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
import cn.featherfly.common.lang.function.SerializableSupplier3;
import cn.featherfly.common.lang.function.SerializableToDoubleFunction3;
import cn.featherfly.common.lang.function.SerializableToIntFunction3;
import cn.featherfly.common.lang.function.SerializableToLongFunction3;
import cn.featherfly.common.lang.function.StringSupplier;
import cn.featherfly.common.operator.QueryOperator.QueryPolicy;
import cn.featherfly.hammer.expression.condition.GroupEndExpression;
import cn.featherfly.hammer.expression.condition.GroupExpression;
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
import cn.featherfly.hammer.expression.entity.condition.ne.EntityNotEqualsExpressionBase3;
import cn.featherfly.hammer.expression.entity.condition.nin.EntityNotInExpressionBase3;
import cn.featherfly.hammer.expression.entity.condition.sw.EntityStartWithExpressionBase3;
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
public abstract class AbstractEntitySqlConditionGroupExpressionBase3<E, E2, E3, ER extends EntitySqlRelation<ER, B>,
        B extends SqlBuilder, C extends GroupExpression<C, L>, L extends GroupEndExpression<C, L>>
        extends AbstractEntitySqlConditionGroupExpressionBase2<E, E2, ER, B, C, L>
        implements EntityContainsExpressionBase3<E, E2, E3, C, L>, EntityEndWithExpressionBase3<E, E2, E3, C, L>,
        EntityEqualsExpressionBase3<E, E2, E3, C, L>, EntityGreatEqualsExpressionBase3<E, E2, E3, C, L>,
        EntityGreatThanExpressionBase3<E, E2, E3, C, L>, EntityInExpressionBase3<E, E2, E3, C, L>,
        EntityIsNotNullExpressionBase3<E, E2, E3, C, L>, EntityIsNullExpressionBase3<E, E2, E3, C, L>,
        EntityLessEqualsExpressionBase3<E, E2, E3, C, L>, EntityLessThanExpressionBase3<E, E2, E3, C, L>,
        EntityNotEqualsExpressionBase3<E, E2, E3, C, L>, EntityNotInExpressionBase3<E, E2, E3, C, L>,
        EntityStartWithExpressionBase3<E, E2, E3, C, L>, EntityLikeExpressionBase3<E, E2, E3, C, L> {

    /** The class mapping. */
    protected JdbcClassMapping<E3> classMapping3;

    private String queryAlias3;

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

        classMapping3 = (JdbcClassMapping<E3>) entitySqlRelation.getEntityRelationMappingTuple().getOrNull3()
                .getClassMapping();
        queryAlias3 = entitySqlRelation.getEntityRelationMappingTuple().getOrNull3().getTableAlias();
    }

    @Override
    public <R> L eq3(SerializableFunction<E3, R> name, R value, QueryPolicy queryPolicy) {
        return eq(name, value, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public <R> L eq3(SerializableFunction<E3, R> name, R value, QueryPolicy queryPolicy, Predicate<R> ignoreStrategy) {
        return eq(name, value, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public <R> L eq3(SerializableSupplier3<R> property, QueryPolicy queryPolicy) {
        return eq(property, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public <R> L eq3(SerializableSupplier3<R> property, QueryPolicy queryPolicy, Predicate<R> ignoreStrategy) {
        return eq(property, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <R> L ne3(SerializableFunction<E3, R> name, R value, QueryPolicy queryPolicy) {
        return ne(name, value, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public <R> L ne3(SerializableFunction<E3, R> name, R value, QueryPolicy queryPolicy, Predicate<R> ignoreStrategy) {
        return ne(name, value, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public <R> L ne3(SerializableSupplier3<R> property, QueryPolicy queryPolicy) {
        return ne(property, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public <R> L ne3(SerializableSupplier3<R> property, QueryPolicy queryPolicy, Predicate<R> ignoreStrategy) {
        return ne(property, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L lk3(SerializableFunction<E3, String> name, String value, QueryPolicy queryPolicy) {
        return lk(name, value, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public L lk3(SerializableFunction<E3, String> name, String value, QueryPolicy queryPolicy,
            Predicate<String> ignoreStrategy) {
        return lk(name, value, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public L lk3(StringSupplier property, QueryPolicy queryPolicy) {
        return lk(property, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public L lk3(StringSupplier property, QueryPolicy queryPolicy, Predicate<String> ignoreStrategy) {
        return lk(property, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L sw3(SerializableFunction<E3, String> name, String value, QueryPolicy queryPolicy) {
        return sw(name, value, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public L sw3(SerializableFunction<E3, String> name, String value, QueryPolicy queryPolicy,
            Predicate<String> ignoreStrategy) {
        return sw(name, value, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public L sw3(StringSupplier property, QueryPolicy queryPolicy) {
        return sw(property, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public L sw3(StringSupplier property, QueryPolicy queryPolicy, Predicate<String> ignoreStrategy) {
        return sw(property, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L ew3(SerializableFunction<E3, String> name, String value, QueryPolicy queryPolicy) {
        return ew(name, value, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public L ew3(SerializableFunction<E3, String> name, String value, QueryPolicy queryPolicy,
            Predicate<String> ignoreStrategy) {
        return ew(name, value, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public L ew3(StringSupplier property, QueryPolicy queryPolicy) {
        return ew(property, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public L ew3(StringSupplier property, QueryPolicy queryPolicy, Predicate<String> ignoreStrategy) {
        return ew(property, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L co3(SerializableFunction<E3, String> name, String value, QueryPolicy queryPolicy) {
        return co(name, value, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public L co3(SerializableFunction<E3, String> name, String value, QueryPolicy queryPolicy,
            Predicate<String> ignoreStrategy) {
        return co(name, value, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public L co3(StringSupplier property, QueryPolicy queryPolicy) {
        return co(property, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    @Override
    public L co3(StringSupplier property, QueryPolicy queryPolicy, Predicate<String> ignoreStrategy) {
        return co(property, getCurrentQueryAlias(), queryPolicy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L ge3(SerializableFunction<E3, N> name, N value) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <N extends Number> L ge3(SerializableFunction<E3, N> name, N value, Predicate<N> ignoreStrategy) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <D extends Date> L ge3(SerializableFunction<E3, D> name, D value) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <D extends Date> L ge3(SerializableFunction<E3, D> name, D value, Predicate<D> ignoreStrategy) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge3(SerializableFunction<E3, LocalTime> name, LocalTime value) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge3(SerializableFunction<E3, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge3(SerializableFunction<E3, LocalDate> name, LocalDate value) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge3(SerializableFunction<E3, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge3(SerializableFunction<E3, LocalDateTime> name, LocalDateTime value) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge3(SerializableFunction<E3, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge3(SerializableFunction<E3, String> name, String value) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge3(SerializableFunction<E3, String> name, String value, Predicate<String> ignoreStrategy) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge3(SerializableToIntFunction3<E3> name, int value) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge3(SerializableToIntFunction3<E3> name, int value, Predicate<Integer> ignoreStrategy) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge3(SerializableToLongFunction3<E3> name, long value) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge3(SerializableToLongFunction3<E3> name, long value, Predicate<Long> ignoreStrategy) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge3(SerializableToDoubleFunction3<E3> name, double value) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge3(SerializableToDoubleFunction3<E3> name, double value, Predicate<Double> ignoreStrategy) {
        return ge(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Date> L ge3(DateSupplier<R> property) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Date> L ge3(DateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Number> L ge3(NumberSupplier<R> property) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Number> L ge3(NumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge3(LocalDateSupplier property) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge3(LocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge3(LocalTimeSupplier property) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge3(LocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge3(LocalDateTimeSupplier property) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge3(LocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge3(StringSupplier property) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L ge3(StringSupplier property, Predicate<String> ignoreStrategy) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge3(SerializableIntSupplier property) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge3(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge3(SerializableLongSupplier property) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge3(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge3(SerializableDoubleSupplier property) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge3(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy) {
        return ge(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L gt3(SerializableFunction<E3, N> name, N value) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <N extends Number> L gt3(SerializableFunction<E3, N> name, N value, Predicate<N> ignoreStrategy) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <D extends Date> L gt3(SerializableFunction<E3, D> name, D value) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <D extends Date> L gt3(SerializableFunction<E3, D> name, D value, Predicate<D> ignoreStrategy) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt3(SerializableFunction<E3, LocalTime> name, LocalTime value) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt3(SerializableFunction<E3, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt3(SerializableFunction<E3, LocalDate> name, LocalDate value) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt3(SerializableFunction<E3, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt3(SerializableFunction<E3, LocalDateTime> name, LocalDateTime value) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt3(SerializableFunction<E3, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt3(SerializableFunction<E3, String> name, String value) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt3(SerializableFunction<E3, String> name, String value, Predicate<String> ignoreStrategy) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt3(SerializableToIntFunction3<E3> name, int value) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt3(SerializableToIntFunction3<E3> name, int value, Predicate<Integer> ignoreStrategy) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt3(SerializableToLongFunction3<E3> name, long value) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt3(SerializableToLongFunction3<E3> name, long value, Predicate<Long> ignoreStrategy) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt3(SerializableToDoubleFunction3<E3> name, double value) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt3(SerializableToDoubleFunction3<E3> name, double value, Predicate<Double> ignoreStrategy) {
        return gt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Number> L gt3(NumberSupplier<R> property) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Number> L gt3(NumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Date> L gt3(DateSupplier<R> property) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Date> L gt3(DateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt3(LocalDateSupplier property) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt3(LocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt3(LocalTimeSupplier property) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt3(LocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt3(LocalDateTimeSupplier property) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt3(LocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt3(StringSupplier property) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L gt3(StringSupplier property, Predicate<String> ignoreStrategy) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt3(SerializableIntSupplier property) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt3(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt3(SerializableLongSupplier property) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt3(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt3(SerializableDoubleSupplier property) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt3(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy) {
        return gt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L le3(SerializableFunction<E3, N> name, N value) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <N extends Number> L le3(SerializableFunction<E3, N> name, N value, Predicate<N> ignoreStrategy) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <D extends Date> L le3(SerializableFunction<E3, D> name, D value) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <D extends Date> L le3(SerializableFunction<E3, D> name, D value, Predicate<D> ignoreStrategy) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le3(SerializableFunction<E3, LocalTime> name, LocalTime value) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le3(SerializableFunction<E3, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le3(SerializableFunction<E3, LocalDate> name, LocalDate value) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le3(SerializableFunction<E3, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le3(SerializableFunction<E3, LocalDateTime> name, LocalDateTime value) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le3(SerializableFunction<E3, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le3(SerializableFunction<E3, String> name, String value) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le3(SerializableFunction<E3, String> name, String value, Predicate<String> ignoreStrategy) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Date> L le3(DateSupplier<R> property) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Date> L le3(DateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Number> L le3(NumberSupplier<R> property) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Number> L le3(NumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le3(LocalDateSupplier property) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le3(LocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le3(LocalTimeSupplier property) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le3(LocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le3(LocalDateTimeSupplier property) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le3(LocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le3(StringSupplier property) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L le3(StringSupplier property, Predicate<String> ignoreStrategy) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le3(SerializableToIntFunction3<E3> name, int value) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le3(SerializableToIntFunction3<E3> name, int value, Predicate<Integer> ignoreStrategy) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le3(SerializableToLongFunction3<E3> name, long value) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le3(SerializableToLongFunction3<E3> name, long value, Predicate<Long> ignoreStrategy) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le3(SerializableToDoubleFunction3<E3> name, double value) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le3(SerializableToDoubleFunction3<E3> name, double value, Predicate<Double> ignoreStrategy) {
        return le(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le3(SerializableIntSupplier property) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le3(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le3(SerializableLongSupplier property) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le3(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le3(SerializableDoubleSupplier property) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le3(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy) {
        return le(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L lt3(SerializableFunction<E3, N> name, N value) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <N extends Number> L lt3(SerializableFunction<E3, N> name, N value, Predicate<N> ignoreStrategy) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <D extends Date> L lt3(SerializableFunction<E3, D> name, D value) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <D extends Date> L lt3(SerializableFunction<E3, D> name, D value, Predicate<D> ignoreStrategy) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt3(SerializableFunction<E3, LocalTime> name, LocalTime value) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt3(SerializableFunction<E3, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt3(SerializableFunction<E3, LocalDate> name, LocalDate value) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt3(SerializableFunction<E3, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt3(SerializableFunction<E3, LocalDateTime> name, LocalDateTime value) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt3(SerializableFunction<E3, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt3(SerializableFunction<E3, String> name, String value) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt3(SerializableFunction<E3, String> name, String value, Predicate<String> ignoreStrategy) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Number> L lt3(NumberSupplier<R> property) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Number> L lt3(NumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Date> L lt3(DateSupplier<R> property) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R extends Date> L lt3(DateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt3(LocalDateSupplier property) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt3(LocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt3(LocalTimeSupplier property) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt3(LocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt3(LocalDateTimeSupplier property) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt3(LocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt3(StringSupplier property) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public L lt3(StringSupplier property, Predicate<String> ignoreStrategy) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt3(SerializableToIntFunction3<E3> name, int value) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt3(SerializableToIntFunction3<E3> name, int value, Predicate<Integer> ignoreStrategy) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt3(SerializableToLongFunction3<E3> name, long value) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt3(SerializableToLongFunction3<E3> name, long value, Predicate<Long> ignoreStrategy) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt3(SerializableToDoubleFunction3<E3> name, double value) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt3(SerializableToDoubleFunction3<E3> name, double value, Predicate<Double> ignoreStrategy) {
        return lt(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt3(SerializableIntSupplier property) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt3(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt3(SerializableLongSupplier property) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt3(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt3(SerializableDoubleSupplier property) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt3(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy) {
        return lt(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <R> L in3(SerializableFunction<E3, R> name, R value) {
        return in(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R> L in3(SerializableFunction<E3, R> name, R value, Predicate<R> ignoreStrategy) {
        return in(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R> L in3(SerializableFunction<E3, R> name, @SuppressWarnings("unchecked") R... value) {
        return in(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R> L in3(SerializableFunction<E3, R> name, R[] value, Predicate<R[]> ignoreStrategy) {
        return in(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R> L in3(SerializableFunction<E3, R> name, Collection<R> value) {
        return in(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R> L in3(SerializableFunction<E3, R> name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy) {
        return in(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R> L in3(SerializableSupplier<R> property) {
        return in(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R> L in3(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return in(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in3(SerializableToIntFunction3<E3> name, int value) {
        return in(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in3(SerializableToIntFunction3<E3> name, int value, Predicate<Integer> ignoreStrategy) {
        return in(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in3(SerializableToLongFunction3<E3> name, long value) {
        return in(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in3(SerializableToLongFunction3<E3> name, long value, Predicate<Long> ignoreStrategy) {
        return in(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in3(SerializableToIntFunction3<E3> name, int... value) {
        return in(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in3(SerializableToLongFunction3<E3> name, long... value) {
        return in(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in3(SerializableToIntFunction3<E3> name, int[] value, Predicate<int[]> ignoreStrategy) {
        return in(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in3(SerializableToLongFunction3<E3> name, long[] value, Predicate<long[]> ignoreStrategy) {
        return in(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in3(SerializableIntSupplier property) {
        return in(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in3(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return in(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in3(SerializableLongSupplier property) {
        return in(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in3(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return in(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <R> L nin3(SerializableFunction<E3, R> name, R value) {
        return nin(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R> L nin3(SerializableFunction<E3, R> name, R value, Predicate<R> ignoreStrategy) {
        return nin(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R> L nin3(SerializableFunction<E3, R> name, @SuppressWarnings("unchecked") R... value) {
        return nin(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R> L nin3(SerializableFunction<E3, R> name, R[] value, Predicate<R[]> ignoreStrategy) {
        return nin(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R> L nin3(SerializableFunction<E3, R> name, Collection<R> value) {
        return nin(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R> L nin3(SerializableFunction<E3, R> name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy) {
        return nin(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R> L nin3(SerializableSupplier<R> property) {
        return nin(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    @Override
    public <R> L nin3(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return nin(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin3(SerializableToIntFunction3<E3> name, int value) {
        return nin(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin3(SerializableToIntFunction3<E3> name, int value, Predicate<Integer> ignoreStrategy) {
        return nin(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin3(SerializableToLongFunction3<E3> name, long value) {
        return nin(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin3(SerializableToLongFunction3<E3> name, long value, Predicate<Long> ignoreStrategy) {
        return nin(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin3(SerializableToIntFunction3<E3> name, int... value) {
        return nin(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin3(SerializableToLongFunction3<E3> name, long... value) {
        return nin(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin3(SerializableToIntFunction3<E3> name, int[] value, Predicate<int[]> ignoreStrategy) {
        return nin(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin3(SerializableToLongFunction3<E3> name, long[] value, Predicate<long[]> ignoreStrategy) {
        return nin(name, value, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin3(SerializableIntSupplier property) {
        return nin(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin3(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return nin(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin3(SerializableLongSupplier property) {
        return nin(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin3(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return nin(property, getCurrentQueryAlias(), ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <R> L inn3(SerializableFunction<E3, R> name, Boolean value) {
        return inn(name, value, getCurrentQueryAlias());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L isn3(SerializableFunction<E3, R> name, Boolean value) {
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
        return queryAlias3;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    protected <T> JdbcClassMapping<T> getCurrentClassMapping() {
        return (JdbcClassMapping<T>) classMapping3;
    }
}
