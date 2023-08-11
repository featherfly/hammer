
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
import cn.featherfly.common.lang.function.SerializableDateSupplier;
import cn.featherfly.common.lang.function.SerializableDoubleSupplier;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableIntSupplier;
import cn.featherfly.common.lang.function.SerializableLocalDateSupplier;
import cn.featherfly.common.lang.function.SerializableLocalDateTimeSupplier;
import cn.featherfly.common.lang.function.SerializableLocalTimeSupplier;
import cn.featherfly.common.lang.function.SerializableLongSupplier;
import cn.featherfly.common.lang.function.SerializableNumberSupplier;
import cn.featherfly.common.lang.function.SerializableStringSupplier;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.common.lang.function.SerializableSupplier3;
import cn.featherfly.common.lang.function.SerializableToDoubleFunction3;
import cn.featherfly.common.lang.function.SerializableToIntFunction3;
import cn.featherfly.common.lang.function.SerializableToLongFunction3;
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
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlRelation.EntityRelationMapping;

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

        EntityRelationMapping<?> erm = entitySqlRelation.getEntityRelationMappingTuple().getOrNull2();
        classMapping3 = (JdbcClassMapping<E3>) erm.getClassMapping();
        queryAlias3 = erm.getTableAlias();
    }

    @Override
    public <R> L eq3(SerializableFunction<E3, R> name, R value, QueryPolicy queryPolicy) {
        return eq(classMapping3, name, value, queryAlias3, queryPolicy, ignoreStrategy);
    }

    @Override
    public <R> L eq3(SerializableFunction<E3, R> name, R value, QueryPolicy queryPolicy, Predicate<R> ignoreStrategy) {
        return eq(classMapping3, name, value, queryAlias3, queryPolicy, ignoreStrategy);
    }

    @Override
    public <R> L eq3(SerializableSupplier3<R> property, QueryPolicy queryPolicy) {
        return eq(classMapping3, property, queryAlias3, queryPolicy, ignoreStrategy);
    }

    @Override
    public <R> L eq3(SerializableSupplier3<R> property, QueryPolicy queryPolicy, Predicate<R> ignoreStrategy) {
        return eq(classMapping3, property, queryAlias3, queryPolicy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <R> L ne3(SerializableFunction<E3, R> name, R value, QueryPolicy queryPolicy) {
        return ne(classMapping3, name, value, queryAlias3, queryPolicy, ignoreStrategy);
    }

    @Override
    public <R> L ne3(SerializableFunction<E3, R> name, R value, QueryPolicy queryPolicy, Predicate<R> ignoreStrategy) {
        return ne(classMapping3, name, value, queryAlias3, queryPolicy, ignoreStrategy);
    }

    @Override
    public <R> L ne3(SerializableSupplier3<R> property, QueryPolicy queryPolicy) {
        return ne(classMapping3, property, queryAlias3, queryPolicy, ignoreStrategy);
    }

    @Override
    public <R> L ne3(SerializableSupplier3<R> property, QueryPolicy queryPolicy, Predicate<R> ignoreStrategy) {
        return ne(classMapping3, property, queryAlias3, queryPolicy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L lk3(SerializableFunction<E3, String> name, String value, QueryPolicy queryPolicy) {
        return lk(classMapping3, name, value, queryAlias3, queryPolicy, ignoreStrategy);
    }

    @Override
    public L lk3(SerializableFunction<E3, String> name, String value, QueryPolicy queryPolicy,
            Predicate<String> ignoreStrategy) {
        return lk(classMapping3, name, value, queryAlias3, queryPolicy, ignoreStrategy);
    }

    @Override
    public L lk3(SerializableStringSupplier property, QueryPolicy queryPolicy) {
        return lk(classMapping3, property, queryAlias3, queryPolicy, ignoreStrategy);
    }

    @Override
    public L lk3(SerializableStringSupplier property, QueryPolicy queryPolicy, Predicate<String> ignoreStrategy) {
        return lk(classMapping3, property, queryAlias3, queryPolicy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L sw3(SerializableFunction<E3, String> name, String value, QueryPolicy queryPolicy) {
        return sw(classMapping3, name, value, queryAlias3, queryPolicy, ignoreStrategy);
    }

    @Override
    public L sw3(SerializableFunction<E3, String> name, String value, QueryPolicy queryPolicy,
            Predicate<String> ignoreStrategy) {
        return sw(classMapping3, name, value, queryAlias3, queryPolicy, ignoreStrategy);
    }

    @Override
    public L sw3(SerializableStringSupplier property, QueryPolicy queryPolicy) {
        return sw(classMapping3, property, queryAlias3, queryPolicy, ignoreStrategy);
    }

    @Override
    public L sw3(SerializableStringSupplier property, QueryPolicy queryPolicy, Predicate<String> ignoreStrategy) {
        return sw(classMapping3, property, queryAlias3, queryPolicy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L ew3(SerializableFunction<E3, String> name, String value, QueryPolicy queryPolicy) {
        return ew(classMapping3, name, value, queryAlias3, queryPolicy, ignoreStrategy);
    }

    @Override
    public L ew3(SerializableFunction<E3, String> name, String value, QueryPolicy queryPolicy,
            Predicate<String> ignoreStrategy) {
        return ew(classMapping3, name, value, queryAlias3, queryPolicy, ignoreStrategy);
    }

    @Override
    public L ew3(SerializableStringSupplier property, QueryPolicy queryPolicy) {
        return ew(classMapping3, property, queryAlias3, queryPolicy, ignoreStrategy);
    }

    @Override
    public L ew3(SerializableStringSupplier property, QueryPolicy queryPolicy, Predicate<String> ignoreStrategy) {
        return ew(classMapping3, property, queryAlias3, queryPolicy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L co3(SerializableFunction<E3, String> name, String value, QueryPolicy queryPolicy) {
        return co(classMapping3, name, value, queryAlias3, queryPolicy, ignoreStrategy);
    }

    @Override
    public L co3(SerializableFunction<E3, String> name, String value, QueryPolicy queryPolicy,
            Predicate<String> ignoreStrategy) {
        return co(classMapping3, name, value, queryAlias3, queryPolicy, ignoreStrategy);
    }

    @Override
    public L co3(SerializableStringSupplier property, QueryPolicy queryPolicy) {
        return co(classMapping3, property, queryAlias3, queryPolicy, ignoreStrategy);
    }

    @Override
    public L co3(SerializableStringSupplier property, QueryPolicy queryPolicy, Predicate<String> ignoreStrategy) {
        return co(classMapping3, property, queryAlias3, queryPolicy, ignoreStrategy);
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
    public <R> L nin3(SerializableFunction<E3, R> name, R value) {
        return nin(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public <R> L nin3(SerializableFunction<E3, R> name, R value, Predicate<R> ignoreStrategy) {
        return nin(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public <R> L nin3(SerializableFunction<E3, R> name, @SuppressWarnings("unchecked") R... value) {
        return nin(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public <R> L nin3(SerializableFunction<E3, R> name, R[] value, Predicate<R[]> ignoreStrategy) {
        return nin(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public <R> L nin3(SerializableFunction<E3, R> name, Collection<R> value) {
        return nin(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public <R> L nin3(SerializableFunction<E3, R> name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy) {
        return nin(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    @Override
    public <R> L nin3(SerializableSupplier<R> property) {
        return nin(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    @Override
    public <R> L nin3(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return nin(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin3(SerializableToIntFunction3<E3> name, int value) {
        return nin(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin3(SerializableToIntFunction3<E3> name, int value, Predicate<Integer> ignoreStrategy) {
        return nin(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin3(SerializableToLongFunction3<E3> name, long value) {
        return nin(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin3(SerializableToLongFunction3<E3> name, long value, Predicate<Long> ignoreStrategy) {
        return nin(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin3(SerializableToIntFunction3<E3> name, int... value) {
        return nin(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin3(SerializableToLongFunction3<E3> name, long... value) {
        return nin(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin3(SerializableToIntFunction3<E3> name, int[] value, Predicate<int[]> ignoreStrategy) {
        return nin(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin3(SerializableToLongFunction3<E3> name, long[] value, Predicate<long[]> ignoreStrategy) {
        return nin(classMapping3, name, value, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin3(SerializableIntSupplier property) {
        return nin(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin3(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return nin(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin3(SerializableLongSupplier property) {
        return nin(classMapping3, property, queryAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin3(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return nin(classMapping3, property, queryAlias3, ignoreStrategy);
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

    // ********************************************************************
    // private method
    // ********************************************************************

    // ********************************************************************
    // protected method
    // ********************************************************************

}
