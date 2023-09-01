
package cn.featherfly.hammer.sqldb.sql.dml;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Date;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
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
import cn.featherfly.common.function.serializable.SerializableSupplier2;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction2;
import cn.featherfly.common.function.serializable.SerializableToIntFunction2;
import cn.featherfly.common.function.serializable.SerializableToLongFunction2;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.GroupEndExpression;
import cn.featherfly.hammer.expression.condition.GroupExpression;
import cn.featherfly.hammer.expression.entity.condition.EntityPropertyExpression2;
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
import cn.featherfly.hammer.expression.entity.condition.property.EntityPropertyFunction;
import cn.featherfly.hammer.expression.entity.condition.sw.EntityStartWithExpressionBase2;
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
public abstract class AbstractEntitySqlConditionGroupExpressionBase2<E, E2, ER extends EntitySqlRelation<ER, B>,
        B extends SqlBuilder, C extends GroupExpression<C, L>, L extends GroupEndExpression<C, L>>
        extends AbstractEntitySqlConditionGroupExpressionBase<E, ER, B, C, L>
        implements EntityContainsExpressionBase2<E, E2, C, L>, EntityEndWithExpressionBase2<E, E2, C, L>,
        EntityEqualsExpressionBase2<E, E2, C, L>, EntityGreatEqualsExpressionBase2<E, E2, C, L>,
        EntityGreatThanExpressionBase2<E, E2, C, L>, EntityInExpressionBase2<E, E2, C, L>,
        EntityIsNotNullExpressionBase2<E, E2, C, L>, EntityIsNullExpressionBase2<E, E2, C, L>,
        EntityLessEqualsExpressionBase2<E, E2, C, L>, EntityLessThanExpressionBase2<E, E2, C, L>,
        EntityNotEqualsExpressionBase2<E, E2, C, L>, EntityNotInExpressionBase2<E, E2, C, L>,
        EntityStartWithExpressionBase2<E, E2, C, L>, EntityLikeExpressionBase2<E, E2, C, L>,
        EntityPropertyExpression2<E, E2, C, L> {

    /** The class mapping. */
    protected JdbcClassMapping<E2> classMapping2;

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
    protected AbstractEntitySqlConditionGroupExpressionBase2(L parent, JdbcMappingFactory factory,
            ER entitySqlRelation) {
        super(parent, factory, entitySqlRelation);

        EntityRelationMapping<?> erm = entitySqlRelation.getEntityRelationMappingTuple().getOrNull1();
        classMapping2 = (JdbcClassMapping<E2>) erm.getClassMapping();
        queryAlias2 = erm.getTableAlias();
    }

    @Override
    public <R> L eq2(SerializableFunction<E2, R> name, R value, MatchStrategy queryPolicy) {
        return eq(classMapping2, name, value, queryAlias2, queryPolicy, ignoreStrategy);
    }

    @Override
    public <R> L eq2(SerializableFunction<E2, R> name, R value, MatchStrategy queryPolicy, Predicate<R> ignoreStrategy) {
        return eq(classMapping2, name, value, queryAlias2, queryPolicy, ignoreStrategy);
    }

    @Override
    public <R> L eq2(SerializableSupplier2<R> property, MatchStrategy queryPolicy) {
        return eq(classMapping2, property, queryAlias2, queryPolicy, ignoreStrategy);
    }

    @Override
    public <R> L eq2(SerializableSupplier2<R> property, MatchStrategy queryPolicy, Predicate<R> ignoreStrategy) {
        return eq(classMapping2, property, queryAlias2, queryPolicy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <R> L ne2(SerializableFunction<E2, R> name, R value, MatchStrategy queryPolicy) {
        return ne(classMapping2, name, value, queryAlias2, queryPolicy, ignoreStrategy);
    }

    @Override
    public <R> L ne2(SerializableFunction<E2, R> name, R value, MatchStrategy queryPolicy, Predicate<R> ignoreStrategy) {
        return ne(classMapping2, name, value, queryAlias2, queryPolicy, ignoreStrategy);
    }

    @Override
    public <R> L ne2(SerializableSupplier2<R> property, MatchStrategy queryPolicy) {
        return ne(classMapping2, property, queryAlias2, queryPolicy, ignoreStrategy);
    }

    @Override
    public <R> L ne2(SerializableSupplier2<R> property, MatchStrategy queryPolicy, Predicate<R> ignoreStrategy) {
        return ne(classMapping2, property, queryAlias2, queryPolicy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L lk2(SerializableFunction<E2, String> name, String value, MatchStrategy queryPolicy) {
        return lk(classMapping2, name, value, queryAlias2, queryPolicy, ignoreStrategy);
    }

    @Override
    public L lk2(SerializableFunction<E2, String> name, String value, MatchStrategy queryPolicy,
            Predicate<String> ignoreStrategy) {
        return lk(classMapping2, name, value, queryAlias2, queryPolicy, ignoreStrategy);
    }

    @Override
    public L lk2(SerializableStringSupplier property, MatchStrategy queryPolicy) {
        return lk(classMapping2, property, queryAlias2, queryPolicy, ignoreStrategy);
    }

    @Override
    public L lk2(SerializableStringSupplier property, MatchStrategy queryPolicy, Predicate<String> ignoreStrategy) {
        return lk(classMapping2, property, queryAlias2, queryPolicy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L sw2(SerializableFunction<E2, String> name, String value, MatchStrategy queryPolicy) {
        return sw(classMapping2, name, value, queryAlias2, queryPolicy, ignoreStrategy);
    }

    @Override
    public L sw2(SerializableFunction<E2, String> name, String value, MatchStrategy queryPolicy,
            Predicate<String> ignoreStrategy) {
        return sw(classMapping2, name, value, queryAlias2, queryPolicy, ignoreStrategy);
    }

    @Override
    public L sw2(SerializableStringSupplier property, MatchStrategy queryPolicy) {
        return sw(classMapping2, property, queryAlias2, queryPolicy, ignoreStrategy);
    }

    @Override
    public L sw2(SerializableStringSupplier property, MatchStrategy queryPolicy, Predicate<String> ignoreStrategy) {
        return sw(classMapping2, property, queryAlias2, queryPolicy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L ew2(SerializableFunction<E2, String> name, String value, MatchStrategy queryPolicy) {
        return ew(classMapping2, name, value, queryAlias2, queryPolicy, ignoreStrategy);
    }

    @Override
    public L ew2(SerializableFunction<E2, String> name, String value, MatchStrategy queryPolicy,
            Predicate<String> ignoreStrategy) {
        return ew(classMapping2, name, value, queryAlias2, queryPolicy, ignoreStrategy);
    }

    @Override
    public L ew2(SerializableStringSupplier property, MatchStrategy queryPolicy) {
        return ew(classMapping2, property, queryAlias2, queryPolicy, ignoreStrategy);
    }

    @Override
    public L ew2(SerializableStringSupplier property, MatchStrategy queryPolicy, Predicate<String> ignoreStrategy) {
        return ew(classMapping2, property, queryAlias2, queryPolicy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L co2(SerializableFunction<E2, String> name, String value, MatchStrategy queryPolicy) {
        return co(classMapping2, name, value, queryAlias2, queryPolicy, ignoreStrategy);
    }

    @Override
    public L co2(SerializableFunction<E2, String> name, String value, MatchStrategy queryPolicy,
            Predicate<String> ignoreStrategy) {
        return co(classMapping2, name, value, queryAlias2, queryPolicy, ignoreStrategy);
    }

    @Override
    public L co2(SerializableStringSupplier property, MatchStrategy queryPolicy) {
        return co(classMapping2, property, queryAlias2, queryPolicy, ignoreStrategy);
    }

    @Override
    public L co2(SerializableStringSupplier property, MatchStrategy queryPolicy, Predicate<String> ignoreStrategy) {
        return co(classMapping2, property, queryAlias2, queryPolicy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L ge2(SerializableFunction<E2, N> name, N value) {
        return ge(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public <N extends Number> L ge2(SerializableFunction<E2, N> name, N value, Predicate<N> ignoreStrategy) {
        return ge(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public <D extends Date> L ge2(SerializableFunction<E2, D> name, D value) {
        return ge(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public <D extends Date> L ge2(SerializableFunction<E2, D> name, D value, Predicate<D> ignoreStrategy) {
        return ge(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public L ge2(SerializableFunction<E2, LocalTime> name, LocalTime value) {
        return ge(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public L ge2(SerializableFunction<E2, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ge(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public L ge2(SerializableFunction<E2, LocalDate> name, LocalDate value) {
        return ge(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public L ge2(SerializableFunction<E2, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ge(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public L ge2(SerializableFunction<E2, LocalDateTime> name, LocalDateTime value) {
        return ge(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public L ge2(SerializableFunction<E2, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return ge(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public L ge2(SerializableFunction<E2, String> name, String value) {
        return ge(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public L ge2(SerializableFunction<E2, String> name, String value, Predicate<String> ignoreStrategy) {
        return ge(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableToIntFunction2<E2> name, int value) {
        return ge(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableToIntFunction2<E2> name, int value, Predicate<Integer> ignoreStrategy) {
        return ge(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableToLongFunction2<E2> name, long value) {
        return ge(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableToLongFunction2<E2> name, long value, Predicate<Long> ignoreStrategy) {
        return ge(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableToDoubleFunction2<E2> name, double value) {
        return ge(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableToDoubleFunction2<E2> name, double value, Predicate<Double> ignoreStrategy) {
        return ge(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public <R extends Date> L ge2(SerializableDateSupplier<R> property) {
        return ge(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public <R extends Date> L ge2(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ge(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public <R extends Number> L ge2(SerializableNumberSupplier<R> property) {
        return ge(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public <R extends Number> L ge2(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ge(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public L ge2(SerializableLocalDateSupplier property) {
        return ge(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public L ge2(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return ge(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public L ge2(SerializableLocalTimeSupplier property) {
        return ge(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public L ge2(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return ge(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public L ge2(SerializableLocalDateTimeSupplier property) {
        return ge(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public L ge2(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return ge(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public L ge2(SerializableStringSupplier property) {
        return ge(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public L ge2(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return ge(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableIntSupplier property) {
        return ge(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return ge(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableLongSupplier property) {
        return ge(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return ge(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableDoubleSupplier property) {
        return ge(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy) {
        return ge(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L gt2(SerializableFunction<E2, N> name, N value) {
        return gt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public <N extends Number> L gt2(SerializableFunction<E2, N> name, N value, Predicate<N> ignoreStrategy) {
        return gt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public <D extends Date> L gt2(SerializableFunction<E2, D> name, D value) {
        return gt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public <D extends Date> L gt2(SerializableFunction<E2, D> name, D value, Predicate<D> ignoreStrategy) {
        return gt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public L gt2(SerializableFunction<E2, LocalTime> name, LocalTime value) {
        return gt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public L gt2(SerializableFunction<E2, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return gt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public L gt2(SerializableFunction<E2, LocalDate> name, LocalDate value) {
        return gt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public L gt2(SerializableFunction<E2, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return gt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public L gt2(SerializableFunction<E2, LocalDateTime> name, LocalDateTime value) {
        return gt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public L gt2(SerializableFunction<E2, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return gt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public L gt2(SerializableFunction<E2, String> name, String value) {
        return gt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public L gt2(SerializableFunction<E2, String> name, String value, Predicate<String> ignoreStrategy) {
        return gt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableToIntFunction2<E2> name, int value) {
        return gt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableToIntFunction2<E2> name, int value, Predicate<Integer> ignoreStrategy) {
        return gt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableToLongFunction2<E2> name, long value) {
        return gt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableToLongFunction2<E2> name, long value, Predicate<Long> ignoreStrategy) {
        return gt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableToDoubleFunction2<E2> name, double value) {
        return gt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableToDoubleFunction2<E2> name, double value, Predicate<Double> ignoreStrategy) {
        return gt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public <R extends Number> L gt2(SerializableNumberSupplier<R> property) {
        return gt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public <R extends Number> L gt2(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return gt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public <R extends Date> L gt2(SerializableDateSupplier<R> property) {
        return gt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public <R extends Date> L gt2(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return gt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public L gt2(SerializableLocalDateSupplier property) {
        return gt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public L gt2(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return gt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public L gt2(SerializableLocalTimeSupplier property) {
        return gt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public L gt2(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return gt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public L gt2(SerializableLocalDateTimeSupplier property) {
        return gt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public L gt2(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return gt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public L gt2(SerializableStringSupplier property) {
        return gt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public L gt2(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return gt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableIntSupplier property) {
        return gt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return gt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableLongSupplier property) {
        return gt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return gt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableDoubleSupplier property) {
        return gt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy) {
        return gt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L le2(SerializableFunction<E2, N> name, N value) {
        return le(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public <N extends Number> L le2(SerializableFunction<E2, N> name, N value, Predicate<N> ignoreStrategy) {
        return le(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public <D extends Date> L le2(SerializableFunction<E2, D> name, D value) {
        return le(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public <D extends Date> L le2(SerializableFunction<E2, D> name, D value, Predicate<D> ignoreStrategy) {
        return le(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public L le2(SerializableFunction<E2, LocalTime> name, LocalTime value) {
        return le(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public L le2(SerializableFunction<E2, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return le(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public L le2(SerializableFunction<E2, LocalDate> name, LocalDate value) {
        return le(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public L le2(SerializableFunction<E2, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return le(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public L le2(SerializableFunction<E2, LocalDateTime> name, LocalDateTime value) {
        return le(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public L le2(SerializableFunction<E2, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return le(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public L le2(SerializableFunction<E2, String> name, String value) {
        return le(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public L le2(SerializableFunction<E2, String> name, String value, Predicate<String> ignoreStrategy) {
        return le(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public <R extends Date> L le2(SerializableDateSupplier<R> property) {
        return le(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public <R extends Date> L le2(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return le(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public <R extends Number> L le2(SerializableNumberSupplier<R> property) {
        return le(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public <R extends Number> L le2(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return le(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public L le2(SerializableLocalDateSupplier property) {
        return le(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public L le2(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return le(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public L le2(SerializableLocalTimeSupplier property) {
        return le(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public L le2(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return le(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public L le2(SerializableLocalDateTimeSupplier property) {
        return le(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public L le2(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return le(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public L le2(SerializableStringSupplier property) {
        return le(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public L le2(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return le(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableToIntFunction2<E2> name, int value) {
        return le(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableToIntFunction2<E2> name, int value, Predicate<Integer> ignoreStrategy) {
        return le(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableToLongFunction2<E2> name, long value) {
        return le(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableToLongFunction2<E2> name, long value, Predicate<Long> ignoreStrategy) {
        return le(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableToDoubleFunction2<E2> name, double value) {
        return le(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableToDoubleFunction2<E2> name, double value, Predicate<Double> ignoreStrategy) {
        return le(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableIntSupplier property) {
        return le(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return le(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableLongSupplier property) {
        return le(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return le(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableDoubleSupplier property) {
        return le(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy) {
        return le(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L lt2(SerializableFunction<E2, N> name, N value) {
        return lt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public <N extends Number> L lt2(SerializableFunction<E2, N> name, N value, Predicate<N> ignoreStrategy) {
        return lt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public <D extends Date> L lt2(SerializableFunction<E2, D> name, D value) {
        return lt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public <D extends Date> L lt2(SerializableFunction<E2, D> name, D value, Predicate<D> ignoreStrategy) {
        return lt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public L lt2(SerializableFunction<E2, LocalTime> name, LocalTime value) {
        return lt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public L lt2(SerializableFunction<E2, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return lt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public L lt2(SerializableFunction<E2, LocalDate> name, LocalDate value) {
        return lt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public L lt2(SerializableFunction<E2, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return lt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public L lt2(SerializableFunction<E2, LocalDateTime> name, LocalDateTime value) {
        return lt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public L lt2(SerializableFunction<E2, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return lt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public L lt2(SerializableFunction<E2, String> name, String value) {
        return lt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public L lt2(SerializableFunction<E2, String> name, String value, Predicate<String> ignoreStrategy) {
        return lt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public <R extends Number> L lt2(SerializableNumberSupplier<R> property) {
        return lt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public <R extends Number> L lt2(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return lt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public <R extends Date> L lt2(SerializableDateSupplier<R> property) {
        return lt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public <R extends Date> L lt2(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return lt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public L lt2(SerializableLocalDateSupplier property) {
        return lt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public L lt2(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return lt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public L lt2(SerializableLocalTimeSupplier property) {
        return lt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public L lt2(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return lt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public L lt2(SerializableLocalDateTimeSupplier property) {
        return lt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public L lt2(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return lt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public L lt2(SerializableStringSupplier property) {
        return lt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public L lt2(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return lt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableToIntFunction2<E2> name, int value) {
        return lt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableToIntFunction2<E2> name, int value, Predicate<Integer> ignoreStrategy) {
        return lt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableToLongFunction2<E2> name, long value) {
        return lt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableToLongFunction2<E2> name, long value, Predicate<Long> ignoreStrategy) {
        return lt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableToDoubleFunction2<E2> name, double value) {
        return lt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableToDoubleFunction2<E2> name, double value, Predicate<Double> ignoreStrategy) {
        return lt(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableIntSupplier property) {
        return lt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return lt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableLongSupplier property) {
        return lt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return lt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableDoubleSupplier property) {
        return lt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy) {
        return lt(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <R> L in2(SerializableFunction<E2, R> name, R value) {
        return in(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public <R> L in2(SerializableFunction<E2, R> name, R value, Predicate<R> ignoreStrategy) {
        return in(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public <R> L in2(SerializableFunction<E2, R> name, @SuppressWarnings("unchecked") R... value) {
        return in(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public <R> L in2(SerializableFunction<E2, R> name, R[] value, Predicate<R[]> ignoreStrategy) {
        return in(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public <R> L in2(SerializableFunction<E2, R> name, Collection<R> value) {
        return in(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public <R> L in2(SerializableFunction<E2, R> name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy) {
        return in(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public <R> L in2(SerializableSupplier<R> property) {
        return in(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public <R> L in2(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return in(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(SerializableToIntFunction2<E2> name, int value) {
        return in(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(SerializableToIntFunction2<E2> name, int value, Predicate<Integer> ignoreStrategy) {
        return in(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(SerializableToLongFunction2<E2> name, long value) {
        return in(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(SerializableToLongFunction2<E2> name, long value, Predicate<Long> ignoreStrategy) {
        return in(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(SerializableToIntFunction2<E2> name, int... value) {
        return in(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(SerializableToLongFunction2<E2> name, long... value) {
        return in(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(SerializableToIntFunction2<E2> name, int[] value, Predicate<int[]> ignoreStrategy) {
        return in(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(SerializableToLongFunction2<E2> name, long[] value, Predicate<long[]> ignoreStrategy) {
        return in(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in2(SerializableIntSupplier property) {
        return in(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in2(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return in(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in2(SerializableLongSupplier property) {
        return in(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in2(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return in(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <R> L nin2(SerializableFunction<E2, R> name, R value) {
        return nin(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public <R> L nin2(SerializableFunction<E2, R> name, R value, Predicate<R> ignoreStrategy) {
        return nin(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public <R> L nin2(SerializableFunction<E2, R> name, @SuppressWarnings("unchecked") R... value) {
        return nin(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public <R> L nin2(SerializableFunction<E2, R> name, R[] value, Predicate<R[]> ignoreStrategy) {
        return nin(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public <R> L nin2(SerializableFunction<E2, R> name, Collection<R> value) {
        return nin(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public <R> L nin2(SerializableFunction<E2, R> name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy) {
        return nin(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    @Override
    public <R> L nin2(SerializableSupplier<R> property) {
        return nin(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    @Override
    public <R> L nin2(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return nin(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin2(SerializableToIntFunction2<E2> name, int value) {
        return nin(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin2(SerializableToIntFunction2<E2> name, int value, Predicate<Integer> ignoreStrategy) {
        return nin(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin2(SerializableToLongFunction2<E2> name, long value) {
        return nin(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin2(SerializableToLongFunction2<E2> name, long value, Predicate<Long> ignoreStrategy) {
        return nin(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin2(SerializableToIntFunction2<E2> name, int... value) {
        return nin(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin2(SerializableToLongFunction2<E2> name, long... value) {
        return nin(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin2(SerializableToIntFunction2<E2> name, int[] value, Predicate<int[]> ignoreStrategy) {
        return nin(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin2(SerializableToLongFunction2<E2> name, long[] value, Predicate<long[]> ignoreStrategy) {
        return nin(classMapping2, name, value, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin2(SerializableIntSupplier property) {
        return nin(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin2(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return nin(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin2(SerializableLongSupplier property) {
        return nin(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin2(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return nin(classMapping2, property, queryAlias2, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <R> L inn2(SerializableFunction<E2, R> name, Boolean value) {
        return inn(classMapping2, name, value, queryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L isn2(SerializableFunction<E2, R> name, Boolean value) {
        return isn(classMapping2, name, value, queryAlias2);
    }

    // ****************************************************************************************************************
    // property
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L property(
            BiFunction<EntityPropertyFunction<E, C, L>, EntityPropertyFunction<E2, C, L>, L> entitiesPropertyFunction) {
        return entitiesPropertyFunction.apply(new EntityPropertyFunctionImpl<E, C, L>(0, this),
                new EntityPropertyFunctionImpl<E2, C, L>(1, this));
    }

    // ********************************************************************
    // private method
    // ********************************************************************

    // ********************************************************************
    // protected method
    // ********************************************************************

}
