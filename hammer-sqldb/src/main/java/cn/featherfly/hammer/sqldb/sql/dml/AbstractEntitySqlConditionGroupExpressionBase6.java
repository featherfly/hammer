
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
import cn.featherfly.common.function.SixArgusFunction;
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
import cn.featherfly.common.function.serializable.SerializableSupplier6;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction6;
import cn.featherfly.common.function.serializable.SerializableToIntFunction6;
import cn.featherfly.common.function.serializable.SerializableToLongFunction6;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.GroupEndExpression;
import cn.featherfly.hammer.expression.condition.GroupExpression;
import cn.featherfly.hammer.expression.entity.condition.EntityPropertyExpression6;
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
import cn.featherfly.hammer.expression.entity.condition.ne.EntityNotEqualsExpressionBase6;
import cn.featherfly.hammer.expression.entity.condition.nin.EntityNotInExpressionBase6;
import cn.featherfly.hammer.expression.entity.condition.property.EntityPropertyFunction;
import cn.featherfly.hammer.expression.entity.condition.sw.EntityStartWithExpressionBase6;
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
public abstract class AbstractEntitySqlConditionGroupExpressionBase6<E, E2, E3, E4, E5, E6,
        ER extends EntitySqlRelation<ER, B>, B extends SqlBuilder, C extends GroupExpression<C, L>,
        L extends GroupEndExpression<C, L>>
        extends AbstractEntitySqlConditionGroupExpressionBase5<E, E2, E3, E4, E5, ER, B, C, L>
        implements EntityContainsExpressionBase6<E, E2, E3, E4, E5, E6, C, L>,
        EntityEndWithExpressionBase6<E, E2, E3, E4, E5, E6, C, L>,
        EntityEqualsExpressionBase6<E, E2, E3, E4, E5, E6, C, L>,
        EntityGreatEqualsExpressionBase6<E, E2, E3, E4, E5, E6, C, L>,
        EntityGreatThanExpressionBase6<E, E2, E3, E4, E5, E6, C, L>,
        EntityInExpressionBase6<E, E2, E3, E4, E5, E6, C, L>,
        EntityIsNotNullExpressionBase6<E, E2, E3, E4, E5, E6, C, L>,
        EntityIsNullExpressionBase6<E, E2, E3, E4, E5, E6, C, L>,
        EntityLessEqualsExpressionBase6<E, E2, E3, E4, E5, E6, C, L>,
        EntityLessThanExpressionBase6<E, E2, E3, E4, E5, E6, C, L>,
        EntityNotEqualsExpressionBase6<E, E2, E3, E4, E5, E6, C, L>,
        EntityNotInExpressionBase6<E, E2, E3, E4, E5, E6, C, L>,
        EntityStartWithExpressionBase6<E, E2, E3, E4, E5, E6, C, L>,
        EntityLikeExpressionBase6<E, E2, E3, E4, E5, E6, C, L>, EntityPropertyExpression6<E, E2, E3, E4, E5, E6, C, L> {

    /** The class mapping. */
    protected JdbcClassMapping<E6> classMapping6;

    protected String queryAlias6;

    /**
     * Instantiates a new abstract entity sql condition group expression base 4.
     *
     * @param parent            the parent
     * @param factory           the factory
     * @param entitySqlRelation the entity sql relation
     */
    @SuppressWarnings("unchecked")
    protected AbstractEntitySqlConditionGroupExpressionBase6(L parent, JdbcMappingFactory factory,
            ER entitySqlRelation) {
        super(parent, factory, entitySqlRelation);

        EntityRelationMapping<?> erm = entitySqlRelation.getEntityRelationMappingTuple().getOrNull5();
        classMapping6 = (JdbcClassMapping<E6>) erm.getClassMapping();
        queryAlias6 = erm.getTableAlias();
    }

    @Override
    public <R> L eq6(SerializableFunction<E6, R> name, R value, MatchStrategy matchStrategy) {
        return eq(classMapping6, name, value, queryAlias6, matchStrategy, ignoreStrategy);
    }

    @Override
    public <R> L eq6(SerializableFunction<E6, R> name, R value, MatchStrategy matchStrategy,
            Predicate<R> ignoreStrategy) {
        return eq(classMapping6, name, value, queryAlias6, matchStrategy, ignoreStrategy);
    }

    @Override
    public <R> L eq6(SerializableSupplier6<R> property, MatchStrategy matchStrategy) {
        return eq(classMapping6, property, queryAlias6, matchStrategy, ignoreStrategy);
    }

    @Override
    public <R> L eq6(SerializableSupplier6<R> property, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy) {
        return eq(classMapping6, property, queryAlias6, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <R> L ne6(SerializableFunction<E6, R> name, R value, MatchStrategy matchStrategy) {
        return ne(classMapping6, name, value, queryAlias6, matchStrategy, ignoreStrategy);
    }

    @Override
    public <R> L ne6(SerializableFunction<E6, R> name, R value, MatchStrategy matchStrategy,
            Predicate<R> ignoreStrategy) {
        return ne(classMapping6, name, value, queryAlias6, matchStrategy, ignoreStrategy);
    }

    @Override
    public <R> L ne6(SerializableSupplier6<R> property, MatchStrategy matchStrategy) {
        return ne(classMapping6, property, queryAlias6, matchStrategy, ignoreStrategy);
    }

    @Override
    public <R> L ne6(SerializableSupplier6<R> property, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy) {
        return ne(classMapping6, property, queryAlias6, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L lk6(SerializableFunction<E6, String> name, String value, MatchStrategy matchStrategy) {
        return lk(classMapping6, name, value, queryAlias6, matchStrategy, ignoreStrategy);
    }

    @Override
    public L lk6(SerializableFunction<E6, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return lk(classMapping6, name, value, queryAlias6, matchStrategy, ignoreStrategy);
    }

    @Override
    public L lk6(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return lk(classMapping6, property, queryAlias6, matchStrategy, ignoreStrategy);
    }

    @Override
    public L lk6(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return lk(classMapping6, property, queryAlias6, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L sw6(SerializableFunction<E6, String> name, String value, MatchStrategy matchStrategy) {
        return sw(classMapping6, name, value, queryAlias6, matchStrategy, ignoreStrategy);
    }

    @Override
    public L sw6(SerializableFunction<E6, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return sw(classMapping6, name, value, queryAlias6, matchStrategy, ignoreStrategy);
    }

    @Override
    public L sw6(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return sw(classMapping6, property, queryAlias6, matchStrategy, ignoreStrategy);
    }

    @Override
    public L sw6(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return sw(classMapping6, property, queryAlias6, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L ew6(SerializableFunction<E6, String> name, String value, MatchStrategy matchStrategy) {
        return ew(classMapping6, name, value, queryAlias6, matchStrategy, ignoreStrategy);
    }

    @Override
    public L ew6(SerializableFunction<E6, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return ew(classMapping6, name, value, queryAlias6, matchStrategy, ignoreStrategy);
    }

    @Override
    public L ew6(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return ew(classMapping6, property, queryAlias6, matchStrategy, ignoreStrategy);
    }

    @Override
    public L ew6(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ew(classMapping6, property, queryAlias6, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L co6(SerializableFunction<E6, String> name, String value, MatchStrategy matchStrategy) {
        return co(classMapping6, name, value, queryAlias6, matchStrategy, ignoreStrategy);
    }

    @Override
    public L co6(SerializableFunction<E6, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return co(classMapping6, name, value, queryAlias6, matchStrategy, ignoreStrategy);
    }

    @Override
    public L co6(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return co(classMapping6, property, queryAlias6, matchStrategy, ignoreStrategy);
    }

    @Override
    public L co6(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return co(classMapping6, property, queryAlias6, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L ge6(SerializableFunction<E6, N> name, N value) {
        return ge(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public <N extends Number> L ge6(SerializableFunction<E6, N> name, N value, Predicate<N> ignoreStrategy) {
        return ge(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public <D extends Date> L ge6(SerializableFunction<E6, D> name, D value) {
        return ge(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public <D extends Date> L ge6(SerializableFunction<E6, D> name, D value, Predicate<D> ignoreStrategy) {
        return ge(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public L ge6(SerializableFunction<E6, LocalTime> name, LocalTime value) {
        return ge(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public L ge6(SerializableFunction<E6, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ge(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public L ge6(SerializableFunction<E6, LocalDate> name, LocalDate value) {
        return ge(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public L ge6(SerializableFunction<E6, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ge(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public L ge6(SerializableFunction<E6, LocalDateTime> name, LocalDateTime value) {
        return ge(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public L ge6(SerializableFunction<E6, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return ge(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public L ge6(SerializableFunction<E6, String> name, String value) {
        return ge(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public L ge6(SerializableFunction<E6, String> name, String value, Predicate<String> ignoreStrategy) {
        return ge(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableToIntFunction6<E6> name, int value) {
        return ge(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableToIntFunction6<E6> name, int value, Predicate<Integer> ignoreStrategy) {
        return ge(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableToLongFunction6<E6> name, long value) {
        return ge(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableToLongFunction6<E6> name, long value, Predicate<Long> ignoreStrategy) {
        return ge(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableToDoubleFunction6<E6> name, double value) {
        return ge(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableToDoubleFunction6<E6> name, double value, Predicate<Double> ignoreStrategy) {
        return ge(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public <R extends Date> L ge6(SerializableDateSupplier<R> property) {
        return ge(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public <R extends Date> L ge6(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ge(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public <R extends Number> L ge6(SerializableNumberSupplier<R> property) {
        return ge(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public <R extends Number> L ge6(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ge(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public L ge6(SerializableLocalDateSupplier property) {
        return ge(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public L ge6(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return ge(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public L ge6(SerializableLocalTimeSupplier property) {
        return ge(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public L ge6(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return ge(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public L ge6(SerializableLocalDateTimeSupplier property) {
        return ge(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public L ge6(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return ge(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public L ge6(SerializableStringSupplier property) {
        return ge(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public L ge6(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return ge(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableIntSupplier property) {
        return ge(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return ge(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableLongSupplier property) {
        return ge(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return ge(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableDoubleSupplier property) {
        return ge(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy) {
        return ge(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L gt6(SerializableFunction<E6, N> name, N value) {
        return gt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public <N extends Number> L gt6(SerializableFunction<E6, N> name, N value, Predicate<N> ignoreStrategy) {
        return gt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public <D extends Date> L gt6(SerializableFunction<E6, D> name, D value) {
        return gt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public <D extends Date> L gt6(SerializableFunction<E6, D> name, D value, Predicate<D> ignoreStrategy) {
        return gt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public L gt6(SerializableFunction<E6, LocalTime> name, LocalTime value) {
        return gt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public L gt6(SerializableFunction<E6, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return gt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public L gt6(SerializableFunction<E6, LocalDate> name, LocalDate value) {
        return gt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public L gt6(SerializableFunction<E6, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return gt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public L gt6(SerializableFunction<E6, LocalDateTime> name, LocalDateTime value) {
        return gt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public L gt6(SerializableFunction<E6, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return gt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public L gt6(SerializableFunction<E6, String> name, String value) {
        return gt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public L gt6(SerializableFunction<E6, String> name, String value, Predicate<String> ignoreStrategy) {
        return gt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableToIntFunction6<E6> name, int value) {
        return gt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableToIntFunction6<E6> name, int value, Predicate<Integer> ignoreStrategy) {
        return gt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableToLongFunction6<E6> name, long value) {
        return gt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableToLongFunction6<E6> name, long value, Predicate<Long> ignoreStrategy) {
        return gt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableToDoubleFunction6<E6> name, double value) {
        return gt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableToDoubleFunction6<E6> name, double value, Predicate<Double> ignoreStrategy) {
        return gt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public <R extends Number> L gt6(SerializableNumberSupplier<R> property) {
        return gt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public <R extends Number> L gt6(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return gt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public <R extends Date> L gt6(SerializableDateSupplier<R> property) {
        return gt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public <R extends Date> L gt6(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return gt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public L gt6(SerializableLocalDateSupplier property) {
        return gt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public L gt6(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return gt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public L gt6(SerializableLocalTimeSupplier property) {
        return gt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public L gt6(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return gt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public L gt6(SerializableLocalDateTimeSupplier property) {
        return gt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public L gt6(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return gt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public L gt6(SerializableStringSupplier property) {
        return gt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public L gt6(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return gt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableIntSupplier property) {
        return gt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return gt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableLongSupplier property) {
        return gt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return gt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableDoubleSupplier property) {
        return gt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy) {
        return gt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L le6(SerializableFunction<E6, N> name, N value) {
        return le(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public <N extends Number> L le6(SerializableFunction<E6, N> name, N value, Predicate<N> ignoreStrategy) {
        return le(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public <D extends Date> L le6(SerializableFunction<E6, D> name, D value) {
        return le(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public <D extends Date> L le6(SerializableFunction<E6, D> name, D value, Predicate<D> ignoreStrategy) {
        return le(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public L le6(SerializableFunction<E6, LocalTime> name, LocalTime value) {
        return le(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public L le6(SerializableFunction<E6, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return le(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public L le6(SerializableFunction<E6, LocalDate> name, LocalDate value) {
        return le(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public L le6(SerializableFunction<E6, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return le(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public L le6(SerializableFunction<E6, LocalDateTime> name, LocalDateTime value) {
        return le(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public L le6(SerializableFunction<E6, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return le(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public L le6(SerializableFunction<E6, String> name, String value) {
        return le(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public L le6(SerializableFunction<E6, String> name, String value, Predicate<String> ignoreStrategy) {
        return le(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public <R extends Date> L le6(SerializableDateSupplier<R> property) {
        return le(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public <R extends Date> L le6(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return le(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public <R extends Number> L le6(SerializableNumberSupplier<R> property) {
        return le(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public <R extends Number> L le6(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return le(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public L le6(SerializableLocalDateSupplier property) {
        return le(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public L le6(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return le(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public L le6(SerializableLocalTimeSupplier property) {
        return le(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public L le6(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return le(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public L le6(SerializableLocalDateTimeSupplier property) {
        return le(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public L le6(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return le(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public L le6(SerializableStringSupplier property) {
        return le(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public L le6(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return le(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableToIntFunction6<E6> name, int value) {
        return le(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableToIntFunction6<E6> name, int value, Predicate<Integer> ignoreStrategy) {
        return le(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableToLongFunction6<E6> name, long value) {
        return le(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableToLongFunction6<E6> name, long value, Predicate<Long> ignoreStrategy) {
        return le(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableToDoubleFunction6<E6> name, double value) {
        return le(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableToDoubleFunction6<E6> name, double value, Predicate<Double> ignoreStrategy) {
        return le(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableIntSupplier property) {
        return le(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return le(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableLongSupplier property) {
        return le(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return le(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableDoubleSupplier property) {
        return le(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy) {
        return le(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L lt6(SerializableFunction<E6, N> name, N value) {
        return lt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public <N extends Number> L lt6(SerializableFunction<E6, N> name, N value, Predicate<N> ignoreStrategy) {
        return lt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public <D extends Date> L lt6(SerializableFunction<E6, D> name, D value) {
        return lt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public <D extends Date> L lt6(SerializableFunction<E6, D> name, D value, Predicate<D> ignoreStrategy) {
        return lt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public L lt6(SerializableFunction<E6, LocalTime> name, LocalTime value) {
        return lt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public L lt6(SerializableFunction<E6, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return lt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public L lt6(SerializableFunction<E6, LocalDate> name, LocalDate value) {
        return lt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public L lt6(SerializableFunction<E6, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return lt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public L lt6(SerializableFunction<E6, LocalDateTime> name, LocalDateTime value) {
        return lt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public L lt6(SerializableFunction<E6, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return lt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public L lt6(SerializableFunction<E6, String> name, String value) {
        return lt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public L lt6(SerializableFunction<E6, String> name, String value, Predicate<String> ignoreStrategy) {
        return lt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public <R extends Number> L lt6(SerializableNumberSupplier<R> property) {
        return lt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public <R extends Number> L lt6(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return lt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public <R extends Date> L lt6(SerializableDateSupplier<R> property) {
        return lt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public <R extends Date> L lt6(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return lt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public L lt6(SerializableLocalDateSupplier property) {
        return lt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public L lt6(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return lt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public L lt6(SerializableLocalTimeSupplier property) {
        return lt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public L lt6(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return lt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public L lt6(SerializableLocalDateTimeSupplier property) {
        return lt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public L lt6(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return lt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public L lt6(SerializableStringSupplier property) {
        return lt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public L lt6(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return lt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableToIntFunction6<E6> name, int value) {
        return lt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableToIntFunction6<E6> name, int value, Predicate<Integer> ignoreStrategy) {
        return lt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableToLongFunction6<E6> name, long value) {
        return lt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableToLongFunction6<E6> name, long value, Predicate<Long> ignoreStrategy) {
        return lt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableToDoubleFunction6<E6> name, double value) {
        return lt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableToDoubleFunction6<E6> name, double value, Predicate<Double> ignoreStrategy) {
        return lt(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableIntSupplier property) {
        return lt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return lt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableLongSupplier property) {
        return lt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return lt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableDoubleSupplier property) {
        return lt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy) {
        return lt(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <R> L in6(SerializableFunction<E6, R> name, R value) {
        return in(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public <R> L in6(SerializableFunction<E6, R> name, R value, Predicate<R> ignoreStrategy) {
        return in(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public <R> L in6(SerializableFunction<E6, R> name, @SuppressWarnings("unchecked") R... value) {
        return in(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public <R> L in6(SerializableFunction<E6, R> name, R[] value, Predicate<R[]> ignoreStrategy) {
        return in(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public <R> L in6(SerializableFunction<E6, R> name, Collection<R> value) {
        return in(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public <R> L in6(SerializableFunction<E6, R> name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy) {
        return in(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public <R> L in6(SerializableSupplier<R> property) {
        return in(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public <R> L in6(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return in(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in6(SerializableToIntFunction6<E6> name, int value) {
        return in(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in6(SerializableToIntFunction6<E6> name, int value, Predicate<Integer> ignoreStrategy) {
        return in(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in6(SerializableToLongFunction6<E6> name, long value) {
        return in(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in6(SerializableToLongFunction6<E6> name, long value, Predicate<Long> ignoreStrategy) {
        return in(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in6(SerializableToIntFunction6<E6> name, int... value) {
        return in(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in6(SerializableToLongFunction6<E6> name, long... value) {
        return in(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in6(SerializableToIntFunction6<E6> name, int[] value, Predicate<int[]> ignoreStrategy) {
        return in(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in6(SerializableToLongFunction6<E6> name, long[] value, Predicate<long[]> ignoreStrategy) {
        return in(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in6(SerializableIntSupplier property) {
        return in(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in6(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return in(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in6(SerializableLongSupplier property) {
        return in(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in6(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return in(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <R> L nin6(SerializableFunction<E6, R> name, R value) {
        return nin(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public <R> L nin6(SerializableFunction<E6, R> name, R value, Predicate<R> ignoreStrategy) {
        return nin(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public <R> L nin6(SerializableFunction<E6, R> name, @SuppressWarnings("unchecked") R... value) {
        return nin(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public <R> L nin6(SerializableFunction<E6, R> name, R[] value, Predicate<R[]> ignoreStrategy) {
        return nin(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public <R> L nin6(SerializableFunction<E6, R> name, Collection<R> value) {
        return nin(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public <R> L nin6(SerializableFunction<E6, R> name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy) {
        return nin(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    @Override
    public <R> L nin6(SerializableSupplier<R> property) {
        return nin(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    @Override
    public <R> L nin6(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return nin(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin6(SerializableToIntFunction6<E6> name, int value) {
        return nin(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin6(SerializableToIntFunction6<E6> name, int value, Predicate<Integer> ignoreStrategy) {
        return nin(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin6(SerializableToLongFunction6<E6> name, long value) {
        return nin(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin6(SerializableToLongFunction6<E6> name, long value, Predicate<Long> ignoreStrategy) {
        return nin(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin6(SerializableToIntFunction6<E6> name, int... value) {
        return nin(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin6(SerializableToLongFunction6<E6> name, long... value) {
        return nin(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin6(SerializableToIntFunction6<E6> name, int[] value, Predicate<int[]> ignoreStrategy) {
        return nin(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin6(SerializableToLongFunction6<E6> name, long[] value, Predicate<long[]> ignoreStrategy) {
        return nin(classMapping6, name, value, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin6(SerializableIntSupplier property) {
        return nin(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin6(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return nin(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin6(SerializableLongSupplier property) {
        return nin(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin6(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return nin(classMapping6, property, queryAlias6, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <R> L inn6(SerializableFunction<E6, R> name, Boolean value) {
        return inn(classMapping6, name, value, queryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L isn6(SerializableFunction<E6, R> name, Boolean value) {
        return isn(classMapping6, name, value, queryAlias6);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L property(SixArgusFunction<EntityPropertyFunction<E, C, L>, EntityPropertyFunction<E2, C, L>,
            EntityPropertyFunction<E3, C, L>, EntityPropertyFunction<E4, C, L>, EntityPropertyFunction<E5, C, L>,
            EntityPropertyFunction<E6, C, L>, L> entitiesPropertyFunction) {
        return entitiesPropertyFunction.apply(new EntityPropertyFunctionImpl<>(0, this, factory),
                new EntityPropertyFunctionImpl<>(1, this, factory), new EntityPropertyFunctionImpl<>(2, this, factory),
                new EntityPropertyFunctionImpl<>(3, this, factory), new EntityPropertyFunctionImpl<>(4, this, factory),
                new EntityPropertyFunctionImpl<>(5, this, factory));
    }

    // ********************************************************************
    // private method
    // ********************************************************************

    // ********************************************************************
    // protected method
    // ********************************************************************

}
