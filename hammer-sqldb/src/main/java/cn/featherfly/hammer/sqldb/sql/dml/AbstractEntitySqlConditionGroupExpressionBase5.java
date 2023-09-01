
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
import cn.featherfly.common.function.FiveArgusFunction;
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
import cn.featherfly.common.function.serializable.SerializableSupplier5;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction5;
import cn.featherfly.common.function.serializable.SerializableToIntFunction5;
import cn.featherfly.common.function.serializable.SerializableToLongFunction5;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.GroupEndExpression;
import cn.featherfly.hammer.expression.condition.GroupExpression;
import cn.featherfly.hammer.expression.entity.condition.EntityPropertyExpression5;
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
import cn.featherfly.hammer.expression.entity.condition.ne.EntityNotEqualsExpressionBase5;
import cn.featherfly.hammer.expression.entity.condition.nin.EntityNotInExpressionBase5;
import cn.featherfly.hammer.expression.entity.condition.property.EntityPropertyFunction;
import cn.featherfly.hammer.expression.entity.condition.sw.EntityStartWithExpressionBase5;
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
public abstract class AbstractEntitySqlConditionGroupExpressionBase5<E, E2, E3, E4, E5,
        ER extends EntitySqlRelation<ER, B>, B extends SqlBuilder, C extends GroupExpression<C, L>,
        L extends GroupEndExpression<C, L>>
        extends AbstractEntitySqlConditionGroupExpressionBase4<E, E2, E3, E4, ER, B, C, L> implements
        EntityContainsExpressionBase5<E, E2, E3, E4, E5, C, L>, EntityEndWithExpressionBase5<E, E2, E3, E4, E5, C, L>,
        EntityEqualsExpressionBase5<E, E2, E3, E4, E5, C, L>, EntityGreatEqualsExpressionBase5<E, E2, E3, E4, E5, C, L>,
        EntityGreatThanExpressionBase5<E, E2, E3, E4, E5, C, L>, EntityInExpressionBase5<E, E2, E3, E4, E5, C, L>,
        EntityIsNotNullExpressionBase5<E, E2, E3, E4, E5, C, L>, EntityIsNullExpressionBase5<E, E2, E3, E4, E5, C, L>,
        EntityLessEqualsExpressionBase5<E, E2, E3, E4, E5, C, L>,
        EntityLessThanExpressionBase5<E, E2, E3, E4, E5, C, L>, EntityNotEqualsExpressionBase5<E, E2, E3, E4, E5, C, L>,
        EntityNotInExpressionBase5<E, E2, E3, E4, E5, C, L>, EntityStartWithExpressionBase5<E, E2, E3, E4, E5, C, L>,
        EntityLikeExpressionBase5<E, E2, E3, E4, E5, C, L>, EntityPropertyExpression5<E, E2, E3, E4, E5, C, L> {

    /** The class mapping. */
    protected JdbcClassMapping<E5> classMapping5;

    protected String queryAlias5;

    /**
     * Instantiates a new abstract entity sql condition group expression base 4.
     *
     * @param parent            the parent
     * @param factory           the factory
     * @param entitySqlRelation the entity sql relation
     */
    @SuppressWarnings("unchecked")
    protected AbstractEntitySqlConditionGroupExpressionBase5(L parent, JdbcMappingFactory factory,
            ER entitySqlRelation) {
        super(parent, factory, entitySqlRelation);

        EntityRelationMapping<?> erm = entitySqlRelation.getEntityRelationMappingTuple().getOrNull4();
        classMapping5 = (JdbcClassMapping<E5>) erm.getClassMapping();
        queryAlias5 = erm.getTableAlias();
    }

    @Override
    public <R> L eq5(SerializableFunction<E5, R> name, R value, MatchStrategy queryPolicy) {
        return eq(classMapping5, name, value, queryAlias5, queryPolicy, ignoreStrategy);
    }

    @Override
    public <R> L eq5(SerializableFunction<E5, R> name, R value, MatchStrategy queryPolicy, Predicate<R> ignoreStrategy) {
        return eq(classMapping5, name, value, queryAlias5, queryPolicy, ignoreStrategy);
    }

    @Override
    public <R> L eq5(SerializableSupplier5<R> property, MatchStrategy queryPolicy) {
        return eq(classMapping5, property, queryAlias5, queryPolicy, ignoreStrategy);
    }

    @Override
    public <R> L eq5(SerializableSupplier5<R> property, MatchStrategy queryPolicy, Predicate<R> ignoreStrategy) {
        return eq(classMapping5, property, queryAlias5, queryPolicy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <R> L ne5(SerializableFunction<E5, R> name, R value, MatchStrategy queryPolicy) {
        return ne(classMapping5, name, value, queryAlias5, queryPolicy, ignoreStrategy);
    }

    @Override
    public <R> L ne5(SerializableFunction<E5, R> name, R value, MatchStrategy queryPolicy, Predicate<R> ignoreStrategy) {
        return ne(classMapping5, name, value, queryAlias5, queryPolicy, ignoreStrategy);
    }

    @Override
    public <R> L ne5(SerializableSupplier5<R> property, MatchStrategy queryPolicy) {
        return ne(classMapping5, property, queryAlias5, queryPolicy, ignoreStrategy);
    }

    @Override
    public <R> L ne5(SerializableSupplier5<R> property, MatchStrategy queryPolicy, Predicate<R> ignoreStrategy) {
        return ne(classMapping5, property, queryAlias5, queryPolicy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L lk5(SerializableFunction<E5, String> name, String value, MatchStrategy queryPolicy) {
        return lk(classMapping5, name, value, queryAlias5, queryPolicy, ignoreStrategy);
    }

    @Override
    public L lk5(SerializableFunction<E5, String> name, String value, MatchStrategy queryPolicy,
            Predicate<String> ignoreStrategy) {
        return lk(classMapping5, name, value, queryAlias5, queryPolicy, ignoreStrategy);
    }

    @Override
    public L lk5(SerializableStringSupplier property, MatchStrategy queryPolicy) {
        return lk(classMapping5, property, queryAlias5, queryPolicy, ignoreStrategy);
    }

    @Override
    public L lk5(SerializableStringSupplier property, MatchStrategy queryPolicy, Predicate<String> ignoreStrategy) {
        return lk(classMapping5, property, queryAlias5, queryPolicy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L sw5(SerializableFunction<E5, String> name, String value, MatchStrategy queryPolicy) {
        return sw(classMapping5, name, value, queryAlias5, queryPolicy, ignoreStrategy);
    }

    @Override
    public L sw5(SerializableFunction<E5, String> name, String value, MatchStrategy queryPolicy,
            Predicate<String> ignoreStrategy) {
        return sw(classMapping5, name, value, queryAlias5, queryPolicy, ignoreStrategy);
    }

    @Override
    public L sw5(SerializableStringSupplier property, MatchStrategy queryPolicy) {
        return sw(classMapping5, property, queryAlias5, queryPolicy, ignoreStrategy);
    }

    @Override
    public L sw5(SerializableStringSupplier property, MatchStrategy queryPolicy, Predicate<String> ignoreStrategy) {
        return sw(classMapping5, property, queryAlias5, queryPolicy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L ew5(SerializableFunction<E5, String> name, String value, MatchStrategy queryPolicy) {
        return ew(classMapping5, name, value, queryAlias5, queryPolicy, ignoreStrategy);
    }

    @Override
    public L ew5(SerializableFunction<E5, String> name, String value, MatchStrategy queryPolicy,
            Predicate<String> ignoreStrategy) {
        return ew(classMapping5, name, value, queryAlias5, queryPolicy, ignoreStrategy);
    }

    @Override
    public L ew5(SerializableStringSupplier property, MatchStrategy queryPolicy) {
        return ew(classMapping5, property, queryAlias5, queryPolicy, ignoreStrategy);
    }

    @Override
    public L ew5(SerializableStringSupplier property, MatchStrategy queryPolicy, Predicate<String> ignoreStrategy) {
        return ew(classMapping5, property, queryAlias5, queryPolicy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L co5(SerializableFunction<E5, String> name, String value, MatchStrategy queryPolicy) {
        return co(classMapping5, name, value, queryAlias5, queryPolicy, ignoreStrategy);
    }

    @Override
    public L co5(SerializableFunction<E5, String> name, String value, MatchStrategy queryPolicy,
            Predicate<String> ignoreStrategy) {
        return co(classMapping5, name, value, queryAlias5, queryPolicy, ignoreStrategy);
    }

    @Override
    public L co5(SerializableStringSupplier property, MatchStrategy queryPolicy) {
        return co(classMapping5, property, queryAlias5, queryPolicy, ignoreStrategy);
    }

    @Override
    public L co5(SerializableStringSupplier property, MatchStrategy queryPolicy, Predicate<String> ignoreStrategy) {
        return co(classMapping5, property, queryAlias5, queryPolicy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L ge5(SerializableFunction<E5, N> name, N value) {
        return ge(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public <N extends Number> L ge5(SerializableFunction<E5, N> name, N value, Predicate<N> ignoreStrategy) {
        return ge(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public <D extends Date> L ge5(SerializableFunction<E5, D> name, D value) {
        return ge(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public <D extends Date> L ge5(SerializableFunction<E5, D> name, D value, Predicate<D> ignoreStrategy) {
        return ge(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public L ge5(SerializableFunction<E5, LocalTime> name, LocalTime value) {
        return ge(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public L ge5(SerializableFunction<E5, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ge(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public L ge5(SerializableFunction<E5, LocalDate> name, LocalDate value) {
        return ge(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public L ge5(SerializableFunction<E5, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ge(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public L ge5(SerializableFunction<E5, LocalDateTime> name, LocalDateTime value) {
        return ge(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public L ge5(SerializableFunction<E5, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return ge(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public L ge5(SerializableFunction<E5, String> name, String value) {
        return ge(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public L ge5(SerializableFunction<E5, String> name, String value, Predicate<String> ignoreStrategy) {
        return ge(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge5(SerializableToIntFunction5<E5> name, int value) {
        return ge(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge5(SerializableToIntFunction5<E5> name, int value, Predicate<Integer> ignoreStrategy) {
        return ge(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge5(SerializableToLongFunction5<E5> name, long value) {
        return ge(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge5(SerializableToLongFunction5<E5> name, long value, Predicate<Long> ignoreStrategy) {
        return ge(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge5(SerializableToDoubleFunction5<E5> name, double value) {
        return ge(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge5(SerializableToDoubleFunction5<E5> name, double value, Predicate<Double> ignoreStrategy) {
        return ge(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public <R extends Date> L ge5(SerializableDateSupplier<R> property) {
        return ge(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public <R extends Date> L ge5(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ge(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public <R extends Number> L ge5(SerializableNumberSupplier<R> property) {
        return ge(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public <R extends Number> L ge5(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ge(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public L ge5(SerializableLocalDateSupplier property) {
        return ge(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public L ge5(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return ge(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public L ge5(SerializableLocalTimeSupplier property) {
        return ge(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public L ge5(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return ge(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public L ge5(SerializableLocalDateTimeSupplier property) {
        return ge(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public L ge5(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return ge(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public L ge5(SerializableStringSupplier property) {
        return ge(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public L ge5(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return ge(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge5(SerializableIntSupplier property) {
        return ge(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge5(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return ge(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge5(SerializableLongSupplier property) {
        return ge(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge5(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return ge(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge5(SerializableDoubleSupplier property) {
        return ge(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge5(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy) {
        return ge(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L gt5(SerializableFunction<E5, N> name, N value) {
        return gt(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public <N extends Number> L gt5(SerializableFunction<E5, N> name, N value, Predicate<N> ignoreStrategy) {
        return gt(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public <D extends Date> L gt5(SerializableFunction<E5, D> name, D value) {
        return gt(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public <D extends Date> L gt5(SerializableFunction<E5, D> name, D value, Predicate<D> ignoreStrategy) {
        return gt(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public L gt5(SerializableFunction<E5, LocalTime> name, LocalTime value) {
        return gt(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public L gt5(SerializableFunction<E5, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return gt(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public L gt5(SerializableFunction<E5, LocalDate> name, LocalDate value) {
        return gt(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public L gt5(SerializableFunction<E5, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return gt(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public L gt5(SerializableFunction<E5, LocalDateTime> name, LocalDateTime value) {
        return gt(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public L gt5(SerializableFunction<E5, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return gt(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public L gt5(SerializableFunction<E5, String> name, String value) {
        return gt(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public L gt5(SerializableFunction<E5, String> name, String value, Predicate<String> ignoreStrategy) {
        return gt(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt5(SerializableToIntFunction5<E5> name, int value) {
        return gt(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt5(SerializableToIntFunction5<E5> name, int value, Predicate<Integer> ignoreStrategy) {
        return gt(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt5(SerializableToLongFunction5<E5> name, long value) {
        return gt(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt5(SerializableToLongFunction5<E5> name, long value, Predicate<Long> ignoreStrategy) {
        return gt(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt5(SerializableToDoubleFunction5<E5> name, double value) {
        return gt(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt5(SerializableToDoubleFunction5<E5> name, double value, Predicate<Double> ignoreStrategy) {
        return gt(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public <R extends Number> L gt5(SerializableNumberSupplier<R> property) {
        return gt(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public <R extends Number> L gt5(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return gt(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public <R extends Date> L gt5(SerializableDateSupplier<R> property) {
        return gt(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public <R extends Date> L gt5(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return gt(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public L gt5(SerializableLocalDateSupplier property) {
        return gt(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public L gt5(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return gt(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public L gt5(SerializableLocalTimeSupplier property) {
        return gt(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public L gt5(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return gt(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public L gt5(SerializableLocalDateTimeSupplier property) {
        return gt(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public L gt5(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return gt(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public L gt5(SerializableStringSupplier property) {
        return gt(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public L gt5(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return gt(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt5(SerializableIntSupplier property) {
        return gt(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt5(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return gt(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt5(SerializableLongSupplier property) {
        return gt(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt5(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return gt(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt5(SerializableDoubleSupplier property) {
        return gt(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt5(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy) {
        return gt(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L le5(SerializableFunction<E5, N> name, N value) {
        return le(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public <N extends Number> L le5(SerializableFunction<E5, N> name, N value, Predicate<N> ignoreStrategy) {
        return le(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public <D extends Date> L le5(SerializableFunction<E5, D> name, D value) {
        return le(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public <D extends Date> L le5(SerializableFunction<E5, D> name, D value, Predicate<D> ignoreStrategy) {
        return le(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public L le5(SerializableFunction<E5, LocalTime> name, LocalTime value) {
        return le(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public L le5(SerializableFunction<E5, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return le(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public L le5(SerializableFunction<E5, LocalDate> name, LocalDate value) {
        return le(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public L le5(SerializableFunction<E5, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return le(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public L le5(SerializableFunction<E5, LocalDateTime> name, LocalDateTime value) {
        return le(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public L le5(SerializableFunction<E5, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return le(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public L le5(SerializableFunction<E5, String> name, String value) {
        return le(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public L le5(SerializableFunction<E5, String> name, String value, Predicate<String> ignoreStrategy) {
        return le(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public <R extends Date> L le5(SerializableDateSupplier<R> property) {
        return le(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public <R extends Date> L le5(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return le(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public <R extends Number> L le5(SerializableNumberSupplier<R> property) {
        return le(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public <R extends Number> L le5(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return le(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public L le5(SerializableLocalDateSupplier property) {
        return le(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public L le5(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return le(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public L le5(SerializableLocalTimeSupplier property) {
        return le(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public L le5(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return le(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public L le5(SerializableLocalDateTimeSupplier property) {
        return le(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public L le5(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return le(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public L le5(SerializableStringSupplier property) {
        return le(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public L le5(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return le(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le5(SerializableToIntFunction5<E5> name, int value) {
        return le(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le5(SerializableToIntFunction5<E5> name, int value, Predicate<Integer> ignoreStrategy) {
        return le(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le5(SerializableToLongFunction5<E5> name, long value) {
        return le(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le5(SerializableToLongFunction5<E5> name, long value, Predicate<Long> ignoreStrategy) {
        return le(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le5(SerializableToDoubleFunction5<E5> name, double value) {
        return le(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le5(SerializableToDoubleFunction5<E5> name, double value, Predicate<Double> ignoreStrategy) {
        return le(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le5(SerializableIntSupplier property) {
        return le(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le5(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return le(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le5(SerializableLongSupplier property) {
        return le(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le5(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return le(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le5(SerializableDoubleSupplier property) {
        return le(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le5(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy) {
        return le(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L lt5(SerializableFunction<E5, N> name, N value) {
        return lt(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public <N extends Number> L lt5(SerializableFunction<E5, N> name, N value, Predicate<N> ignoreStrategy) {
        return lt(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public <D extends Date> L lt5(SerializableFunction<E5, D> name, D value) {
        return lt(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public <D extends Date> L lt5(SerializableFunction<E5, D> name, D value, Predicate<D> ignoreStrategy) {
        return lt(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public L lt5(SerializableFunction<E5, LocalTime> name, LocalTime value) {
        return lt(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public L lt5(SerializableFunction<E5, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return lt(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public L lt5(SerializableFunction<E5, LocalDate> name, LocalDate value) {
        return lt(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public L lt5(SerializableFunction<E5, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return lt(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public L lt5(SerializableFunction<E5, LocalDateTime> name, LocalDateTime value) {
        return lt(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public L lt5(SerializableFunction<E5, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return lt(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public L lt5(SerializableFunction<E5, String> name, String value) {
        return lt(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public L lt5(SerializableFunction<E5, String> name, String value, Predicate<String> ignoreStrategy) {
        return lt(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public <R extends Number> L lt5(SerializableNumberSupplier<R> property) {
        return lt(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public <R extends Number> L lt5(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return lt(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public <R extends Date> L lt5(SerializableDateSupplier<R> property) {
        return lt(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public <R extends Date> L lt5(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return lt(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public L lt5(SerializableLocalDateSupplier property) {
        return lt(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public L lt5(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return lt(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public L lt5(SerializableLocalTimeSupplier property) {
        return lt(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public L lt5(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return lt(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public L lt5(SerializableLocalDateTimeSupplier property) {
        return lt(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public L lt5(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return lt(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public L lt5(SerializableStringSupplier property) {
        return lt(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public L lt5(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return lt(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt5(SerializableToIntFunction5<E5> name, int value) {
        return lt(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt5(SerializableToIntFunction5<E5> name, int value, Predicate<Integer> ignoreStrategy) {
        return lt(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt5(SerializableToLongFunction5<E5> name, long value) {
        return lt(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt5(SerializableToLongFunction5<E5> name, long value, Predicate<Long> ignoreStrategy) {
        return lt(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt5(SerializableToDoubleFunction5<E5> name, double value) {
        return lt(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt5(SerializableToDoubleFunction5<E5> name, double value, Predicate<Double> ignoreStrategy) {
        return lt(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt5(SerializableIntSupplier property) {
        return lt(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt5(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return lt(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt5(SerializableLongSupplier property) {
        return lt(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt5(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return lt(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt5(SerializableDoubleSupplier property) {
        return lt(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt5(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy) {
        return lt(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <R> L in5(SerializableFunction<E5, R> name, R value) {
        return in(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public <R> L in5(SerializableFunction<E5, R> name, R value, Predicate<R> ignoreStrategy) {
        return in(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public <R> L in5(SerializableFunction<E5, R> name, @SuppressWarnings("unchecked") R... value) {
        return in(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public <R> L in5(SerializableFunction<E5, R> name, R[] value, Predicate<R[]> ignoreStrategy) {
        return in(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public <R> L in5(SerializableFunction<E5, R> name, Collection<R> value) {
        return in(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public <R> L in5(SerializableFunction<E5, R> name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy) {
        return in(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public <R> L in5(SerializableSupplier<R> property) {
        return in(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public <R> L in5(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return in(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in5(SerializableToIntFunction5<E5> name, int value) {
        return in(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in5(SerializableToIntFunction5<E5> name, int value, Predicate<Integer> ignoreStrategy) {
        return in(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in5(SerializableToLongFunction5<E5> name, long value) {
        return in(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in5(SerializableToLongFunction5<E5> name, long value, Predicate<Long> ignoreStrategy) {
        return in(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in5(SerializableToIntFunction5<E5> name, int... value) {
        return in(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in5(SerializableToLongFunction5<E5> name, long... value) {
        return in(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in5(SerializableToIntFunction5<E5> name, int[] value, Predicate<int[]> ignoreStrategy) {
        return in(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in5(SerializableToLongFunction5<E5> name, long[] value, Predicate<long[]> ignoreStrategy) {
        return in(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in5(SerializableIntSupplier property) {
        return in(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in5(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return in(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in5(SerializableLongSupplier property) {
        return in(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in5(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return in(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <R> L nin5(SerializableFunction<E5, R> name, R value) {
        return nin(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public <R> L nin5(SerializableFunction<E5, R> name, R value, Predicate<R> ignoreStrategy) {
        return nin(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public <R> L nin5(SerializableFunction<E5, R> name, @SuppressWarnings("unchecked") R... value) {
        return nin(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public <R> L nin5(SerializableFunction<E5, R> name, R[] value, Predicate<R[]> ignoreStrategy) {
        return nin(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public <R> L nin5(SerializableFunction<E5, R> name, Collection<R> value) {
        return nin(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public <R> L nin5(SerializableFunction<E5, R> name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy) {
        return nin(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    @Override
    public <R> L nin5(SerializableSupplier<R> property) {
        return nin(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    @Override
    public <R> L nin5(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return nin(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin5(SerializableToIntFunction5<E5> name, int value) {
        return nin(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin5(SerializableToIntFunction5<E5> name, int value, Predicate<Integer> ignoreStrategy) {
        return nin(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin5(SerializableToLongFunction5<E5> name, long value) {
        return nin(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin5(SerializableToLongFunction5<E5> name, long value, Predicate<Long> ignoreStrategy) {
        return nin(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin5(SerializableToIntFunction5<E5> name, int... value) {
        return nin(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin5(SerializableToLongFunction5<E5> name, long... value) {
        return nin(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin5(SerializableToIntFunction5<E5> name, int[] value, Predicate<int[]> ignoreStrategy) {
        return nin(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin5(SerializableToLongFunction5<E5> name, long[] value, Predicate<long[]> ignoreStrategy) {
        return nin(classMapping5, name, value, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin5(SerializableIntSupplier property) {
        return nin(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin5(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return nin(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin5(SerializableLongSupplier property) {
        return nin(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin5(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return nin(classMapping5, property, queryAlias5, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <R> L inn5(SerializableFunction<E5, R> name, Boolean value) {
        return inn(classMapping5, name, value, queryAlias5);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L isn5(SerializableFunction<E5, R> name, Boolean value) {
        return isn(classMapping5, name, value, queryAlias5);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L property(FiveArgusFunction<EntityPropertyFunction<E, C, L>, EntityPropertyFunction<E2, C, L>,
            EntityPropertyFunction<E3, C, L>, EntityPropertyFunction<E4, C, L>, EntityPropertyFunction<E5, C, L>,
            L> entitiesPropertyFunction) {
        return entitiesPropertyFunction.apply(new EntityPropertyFunctionImpl<E, C, L>(0, this),
                new EntityPropertyFunctionImpl<E2, C, L>(1, this), new EntityPropertyFunctionImpl<E3, C, L>(2, this),
                new EntityPropertyFunctionImpl<E4, C, L>(3, this), new EntityPropertyFunctionImpl<E5, C, L>(4, this));
    }

    // ********************************************************************
    // private method
    // ********************************************************************

    // ********************************************************************
    // protected method
    // ********************************************************************

}
