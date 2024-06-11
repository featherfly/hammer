
package cn.featherfly.hammer.sqldb.dsl.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Date;
import java.util.function.BiPredicate;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.CharPredicate;
import cn.featherfly.common.function.ThreeArgusFunction;
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
import cn.featherfly.common.function.serializable.SerializableToEnumFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.common.function.serializable.SerializableToNumberFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LambdaUtils.SerializableSupplierLambdaInfo;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.config.dsl.ConditionConfig;
import cn.featherfly.hammer.expression.condition.GroupEndExpression;
import cn.featherfly.hammer.expression.condition.GroupExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.EntityPropertyExpression;
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
import cn.featherfly.hammer.expression.entity.condition.sw.EntityStartWithExpressionBase3;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlRelation.EntityRelation;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.propery.EntityPropertyOnlyExpressionImpl;

/**
 * sql condition group expression 3. sql条件逻辑组表达式3.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <E3> third filterable entity type
 * @param <C> condition expression
 * @param <L> logic expression
 * @param <C2> condition config
 * @param <ER> entity sql relation
 * @param <B> sql builder
 */
public abstract class AbstractMulitiEntitySqlConditionsGroupExpressionBase3<E1, E2, E3, C extends GroupExpression<C, L>,
    L extends GroupEndExpression<C, L>, C2 extends ConditionConfig<C2>, ER extends EntitySqlRelation<ER, B>,
    B extends SqlBuilder> extends AbstractMulitiEntitySqlConditionsGroupExpressionBase2<E1, E2, C, L, C2, ER, B>
    implements EntityBetweenExpressionBase3<E1, E2, E3, C, L>, EntityNotBetweenExpressionBase3<E1, E2, E3, C, L> //
    , EntityContainsExpressionBase3<E1, E2, E3, C, L>, EntityNotContainsExpressionBase3<E1, E2, E3, C, L> //
    , EntityEndWithExpressionBase3<E1, E2, E3, C, L>, EntityNotEndWithExpressionBase3<E1, E2, E3, C, L>//
    , EntityEqualsExpressionBase3<E1, E2, E3, C, L>, EntityNotEqualsExpressionBase3<E1, E2, E3, C, L>//
    , EntityGreatEqualsExpressionBase3<E1, E2, E3, C, L>, EntityGreatThanExpressionBase3<E1, E2, E3, C, L> //
    , EntityInExpressionBase3<E1, E2, E3, C, L>, EntityNotInExpressionBase3<E1, E2, E3, C, L>//
    , EntityIsNotNullExpressionBase3<E1, E2, E3, C, L>, EntityIsNullExpressionBase3<E1, E2, E3, C, L> //
    , EntityLessEqualsExpressionBase3<E1, E2, E3, C, L>, EntityLessThanExpressionBase3<E1, E2, E3, C, L> //
    , EntityStartWithExpressionBase3<E1, E2, E3, C, L>, EntityNotStartWithExpressionBase3<E1, E2, E3, C, L> //
    , EntityLikeExpressionBase3<E1, E2, E3, C, L>, EntityNotLikeExpressionBase3<E1, E2, E3, C, L>//
    , EntityPropertyExpression3<E1, E2, E3, C, L> {

    /** The class mapping. */
    protected final JdbcClassMapping<E3> classMapping3;

    /** The query alias 3. */
    protected final String tableAlias3;

    /**
     * Instantiates a new abstract entity sql condition group expression base 3.
     *
     * @param parent the parent
     * @param factory the factory
     * @param entitySqlRelation the entity sql relation
     */
    @SuppressWarnings("unchecked")
    protected AbstractMulitiEntitySqlConditionsGroupExpressionBase3(L parent, JdbcMappingFactory factory,
        ER entitySqlRelation) {
        super(parent, factory, entitySqlRelation);
        EntityRelation<?> erm = entitySqlRelation.getEntityRelationTuple().getOrNull2();
        classMapping3 = (JdbcClassMapping<E3>) erm.getClassMapping();
        tableAlias3 = erm.getTableAlias();
    }

    // ****************************************************************************************************************
    //  eq
    // ****************************************************************************************************************

    @Override
    public <R extends Serializable> L eq3(SerializableFunction<E3, R> name, R value) {
        return eq(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <R extends Serializable> L eq3(SerializableFunction<E3, R> name, R value, Predicate<R> ignoreStrategy) {
        return eq(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public <D extends Date> L eq3(SerializableToDateFunction<E3, D> name, D value) {
        return eq(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <D extends Date> L eq3(SerializableToDateFunction<E3, D> name, D value, Predicate<D> ignoreStrategy) {
        return eq(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L eq3(SerializableToDoubleFunction<E3> name, double value) {
        return eq(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L eq3(SerializableToDoubleFunction<E3> name, double value, DoublePredicate ignoreStrategy) {
        return eq(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public <E extends Enum<E>> L eq3(SerializableToEnumFunction<E3, E> name, E value) {
        return eq(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <E extends Enum<E>> L eq3(SerializableToEnumFunction<E3, E> name, E value, Predicate<E> ignoreStrategy) {
        return eq(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L eq3(SerializableToCharFunction<E3> name, char value) {
        return eq(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L eq3(SerializableToCharFunction<E3> name, char value, CharPredicate ignoreStrategy) {
        return eq(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L eq3(SerializableToIntFunction<E3> name, int value) {
        return eq(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L eq3(SerializableToIntFunction<E3> name, int value, IntPredicate ignoreStrategy) {
        return eq(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L eq3(SerializableToLocalDateFunction<E3> name, LocalDate value) {
        return eq(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L eq3(SerializableToLocalDateFunction<E3> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return eq(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L eq3(SerializableToLocalDateTimeFunction<E3> name, LocalDateTime value) {
        return eq(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L eq3(SerializableToLocalDateTimeFunction<E3> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return eq(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L eq3(SerializableToLocalTimeFunction<E3> name, LocalTime value) {
        return eq(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L eq3(SerializableToLocalTimeFunction<E3> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return eq(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L eq3(SerializableToLongFunction<E3> name, long value) {
        return eq(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L eq3(SerializableToLongFunction<E3> name, long value, LongPredicate ignoreStrategy) {
        return eq(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public <N extends Number> L eq3(SerializableToNumberFunction<E3, N> name, N value) {
        return eq(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <N extends Number> L eq3(SerializableToNumberFunction<E3, N> name, N value, Predicate<N> ignoreStrategy) {
        return eq(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L eq3(SerializableToStringFunction<E3> name, String value, MatchStrategy matchStrategy) {
        return eq(classMapping3, name, value, tableAlias3, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L eq3(SerializableToStringFunction<E3> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return eq(classMapping3, name, value, tableAlias3, matchStrategy, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    @Override
    public <D extends Date> L eq3(SerializableDateSupplier<D> property, D value) {
        return eq(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <D extends Date> L eq3(SerializableDateSupplier<D> property, D value, Predicate<D> ignoreStrategy) {
        return eq(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L eq3(SerializableDoubleSupplier property, double value) {
        return eq(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L eq3(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy) {
        return eq(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public <E extends Enum<E>> L eq3(SerializableEnumSupplier<E> property, E value) {
        return eq(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <E extends Enum<E>> L eq3(SerializableEnumSupplier<E> property, E value, Predicate<E> ignoreStrategy) {
        return eq(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L eq3(SerializableBooleanSupplier property, boolean value) {
        return eq(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L eq3(SerializableBoolSupplier property, Boolean value) {
        return eq(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L eq3(SerializableBoolSupplier property, Boolean value, Predicate<Boolean> ignoreStrategy) {
        return eq(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L eq3(SerializableCharSupplier property, char value) {
        return eq(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L eq3(SerializableCharSupplier property, char value, CharPredicate ignoreStrategy) {
        return eq(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L eq3(SerializableIntSupplier property, int value) {
        return eq(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L eq3(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy) {
        return eq(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L eq3(SerializableLocalDateSupplier property, LocalDate value) {
        return eq(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L eq3(SerializableLocalDateSupplier property, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return eq(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L eq3(SerializableLocalDateTimeSupplier property, LocalDateTime value) {
        return eq(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L eq3(SerializableLocalDateTimeSupplier property, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return eq(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L eq3(SerializableLocalTimeSupplier property, LocalTime value) {
        return eq(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L eq3(SerializableLocalTimeSupplier property, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return eq(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L eq3(SerializableLongSupplier property, long value) {
        return eq(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L eq3(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy) {
        return eq(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public <N extends Number> L eq3(SerializableNumberSupplier<N> property, N value) {
        return eq(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <N extends Number> L eq3(SerializableNumberSupplier<N> property, N value, Predicate<N> ignoreStrategy) {
        return eq(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L eq3(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return eq(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L eq3(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return eq(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public <R extends Serializable> L eq3(SerializableSupplier<R> property, R value) {
        return eq(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <R extends Serializable> L eq3(SerializableSupplier<R> property, R value, Predicate<R> ignoreStrategy) {
        return eq(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    // ****************************************************************************************************************
    //  ne
    // ****************************************************************************************************************

    @Override
    public <R extends Serializable> L ne3(SerializableFunction<E3, R> name, R value) {
        return ne(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <R extends Serializable> L ne3(SerializableFunction<E3, R> name, R value, Predicate<R> ignoreStrategy) {
        return ne(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public <D extends Date> L ne3(SerializableToDateFunction<E3, D> name, D value) {
        return ne(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <D extends Date> L ne3(SerializableToDateFunction<E3, D> name, D value, Predicate<D> ignoreStrategy) {
        return ne(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L ne3(SerializableToDoubleFunction<E3> name, double value) {
        return ne(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L ne3(SerializableToDoubleFunction<E3> name, double value, DoublePredicate ignoreStrategy) {
        return ne(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public <E extends Enum<E>> L ne3(SerializableToEnumFunction<E3, E> name, E value) {
        return ne(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <E extends Enum<E>> L ne3(SerializableToEnumFunction<E3, E> name, E value, Predicate<E> ignoreStrategy) {
        return ne(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L ne3(SerializableToIntFunction<E3> name, int value) {
        return ne(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L ne3(SerializableToIntFunction<E3> name, int value, IntPredicate ignoreStrategy) {
        return ne(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L ne3(SerializableToLocalDateFunction<E3> name, LocalDate value) {
        return ne(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L ne3(SerializableToLocalDateFunction<E3> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ne(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L ne3(SerializableToLocalDateTimeFunction<E3> name, LocalDateTime value) {
        return ne(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L ne3(SerializableToLocalDateTimeFunction<E3> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return ne(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L ne3(SerializableToLocalTimeFunction<E3> name, LocalTime value) {
        return ne(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L ne3(SerializableToLocalTimeFunction<E3> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ne(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L ne3(SerializableToLongFunction<E3> name, long value) {
        return ne(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L ne3(SerializableToLongFunction<E3> name, long value, LongPredicate ignoreStrategy) {
        return ne(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public <N extends Number> L ne3(SerializableToNumberFunction<E3, N> name, N value) {
        return ne(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <N extends Number> L ne3(SerializableToNumberFunction<E3, N> name, N value, Predicate<N> ignoreStrategy) {
        return ne(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L ne3(SerializableToStringFunction<E3> name, String value, MatchStrategy matchStrategy) {
        return ne(classMapping3, name, value, tableAlias3, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L ne3(SerializableToStringFunction<E3> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ne(classMapping3, name, value, tableAlias3, matchStrategy, ignoreStrategy);
    }

    @Override
    public <D extends Date> L ne3(SerializableDateSupplier<D> property, D value) {
        return ne(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <D extends Date> L ne3(SerializableDateSupplier<D> property, D value, Predicate<D> ignoreStrategy) {
        return ne(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L ne3(SerializableDoubleSupplier property, double value) {
        return ne(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L ne3(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy) {
        return ne(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public <E extends Enum<E>> L ne3(SerializableEnumSupplier<E> property, E value) {
        return ne(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <E extends Enum<E>> L ne3(SerializableEnumSupplier<E> property, E value, Predicate<E> ignoreStrategy) {
        return ne(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L ne3(SerializableBooleanSupplier property, boolean value) {
        return ne(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L ne3(SerializableBoolSupplier property, Boolean value) {
        return ne(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L ne3(SerializableBoolSupplier property, Boolean value, Predicate<Boolean> ignoreStrategy) {
        return ne(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L ne3(SerializableCharSupplier property, char value) {
        return ne(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L ne3(SerializableCharSupplier property, char value, CharPredicate ignoreStrategy) {
        return ne(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L ne3(SerializableIntSupplier property, int value) {
        return ne(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L ne3(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy) {
        return ne(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L ne3(SerializableLocalDateSupplier property, LocalDate value) {
        return ne(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L ne3(SerializableLocalDateSupplier property, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ne(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L ne3(SerializableLocalDateTimeSupplier property, LocalDateTime value) {
        return ne(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L ne3(SerializableLocalDateTimeSupplier property, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return ne(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L ne3(SerializableLocalTimeSupplier property, LocalTime value) {
        return ne(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L ne3(SerializableLocalTimeSupplier property, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ne(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L ne3(SerializableLongSupplier property, long value) {
        return ne(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L ne3(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy) {
        return ne(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public <N extends Number> L ne3(SerializableNumberSupplier<N> property, N value) {
        return ne(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <N extends Number> L ne3(SerializableNumberSupplier<N> property, N value, Predicate<N> ignoreStrategy) {
        return ne(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L ne3(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return ne(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L ne3(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ne(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public <R extends Serializable> L ne3(SerializableSupplier<R> property, R value) {
        return ne(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <R extends Serializable> L ne3(SerializableSupplier<R> property, R value, Predicate<R> ignoreStrategy) {
        return ne(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L lk3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy) {
        return lk(classMapping3, name, value, tableAlias3, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L lk3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return lk(classMapping3, name, value, tableAlias3, matchStrategy, ignoreStrategy);
    }

    @Override
    public L lk3(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return lk(classMapping3, property, value, tableAlias3, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L lk3(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return lk(classMapping3, property, value, tableAlias3, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L nl3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy) {
        return nl(classMapping3, name, value, tableAlias3, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L nl3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nl(classMapping3, name, value, tableAlias3, matchStrategy, ignoreStrategy);
    }

    @Override
    public L nl3(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return nl(classMapping3, property, value, tableAlias3, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L nl3(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nl(classMapping3, property, value, tableAlias3, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L sw3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy) {
        return sw(classMapping3, name, value, tableAlias3, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L sw3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return sw(classMapping3, name, value, tableAlias3, matchStrategy, ignoreStrategy);
    }

    @Override
    public L sw3(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return sw(classMapping3, property, value, tableAlias3, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L sw3(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return sw(classMapping3, property, value, tableAlias3, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L nsw3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy) {
        return nsw(classMapping3, name, value, tableAlias3, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L nsw3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nsw(classMapping3, name, value, tableAlias3, matchStrategy, ignoreStrategy);
    }

    @Override
    public L nsw3(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return nsw(classMapping3, property, value, tableAlias3, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L nsw3(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nsw(classMapping3, property, value, tableAlias3, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L ew3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy) {
        return ew(classMapping3, name, value, tableAlias3, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L ew3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ew(classMapping3, name, value, tableAlias3, matchStrategy, ignoreStrategy);
    }

    @Override
    public L ew3(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return ew(classMapping3, property, value, tableAlias3, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L ew3(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ew(classMapping3, property, value, tableAlias3, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L new3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy) {
        return newv(classMapping3, name, value, tableAlias3, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L new3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return newv(classMapping3, name, value, tableAlias3, matchStrategy, ignoreStrategy);
    }

    @Override
    public L new3(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return newv(classMapping3, property, value, tableAlias3, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L new3(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return newv(classMapping3, property, value, tableAlias3, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L co3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy) {
        return co(classMapping3, name, value, tableAlias3, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L co3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return co(classMapping3, name, value, tableAlias3, matchStrategy, ignoreStrategy);
    }

    @Override
    public L co3(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return co(classMapping3, property, value, tableAlias3, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L co3(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return co(classMapping3, property, value, tableAlias3, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L nco3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy) {
        return nco(classMapping3, name, value, tableAlias3, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L nco3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nco(classMapping3, name, value, tableAlias3, matchStrategy, ignoreStrategy);
    }

    @Override
    public L nco3(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return nco(classMapping3, property, value, tableAlias3, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L nco3(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nco(classMapping3, property, value, tableAlias3, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L ge3(SerializableFunction<E3, N> name, N value) {
        return ge(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <N extends Number> L ge3(SerializableFunction<E3, N> name, N value, Predicate<N> ignoreStrategy) {
        return ge(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public <E extends Enum<E>> L ge3(SerializableFunction<E3, E> name, E value) {
        return ge(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <E extends Enum<E>> L ge3(SerializableFunction<E3, E> name, E value, Predicate<E> ignoreStrategy) {
        return ge(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L ge3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy) {
        return ge(classMapping3, name, value, tableAlias3, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L ge3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ge(classMapping3, name, value, tableAlias3, matchStrategy, ignoreStrategy);
    }

    @Override
    public <E extends Enum<E>> L ge3(SerializableEnumSupplier<E> property, E value) {
        return ge(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <E extends Enum<E>> L ge3(SerializableEnumSupplier<E> property, E value, Predicate<E> ignoreStrategy) {
        return ge(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L ge3(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return ge(classMapping3, property, matchStrategy, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L ge3(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ge(classMapping3, property, matchStrategy, tableAlias3, ignoreStrategy);
    }

    @Override
    public <D extends Date> L ge3(SerializableFunction<E3, D> name, D value) {
        return ge(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <D extends Date> L ge3(SerializableFunction<E3, D> name, D value, Predicate<D> ignoreStrategy) {
        return ge(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L ge3(SerializableFunction<E3, LocalTime> name, LocalTime value) {
        return ge(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L ge3(SerializableFunction<E3, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ge(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L ge3(SerializableFunction<E3, LocalDate> name, LocalDate value) {
        return ge(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L ge3(SerializableFunction<E3, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ge(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L ge3(SerializableFunction<E3, LocalDateTime> name, LocalDateTime value) {
        return ge(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L ge3(SerializableFunction<E3, LocalDateTime> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return ge(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L ge3(SerializableFunction<E3, String> name, String value) {
        return ge(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L ge3(SerializableFunction<E3, String> name, String value, Predicate<String> ignoreStrategy) {
        return ge(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L ge3(SerializableToIntFunction<E3> name, int value) {
        return ge(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L ge3(SerializableToIntFunction<E3> name, int value, IntPredicate ignoreStrategy) {
        return ge(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L ge3(SerializableToLongFunction<E3> name, long value) {
        return ge(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L ge3(SerializableToLongFunction<E3> name, long value, LongPredicate ignoreStrategy) {
        return ge(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L ge3(SerializableToDoubleFunction<E3> name, double value) {
        return ge(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L ge3(SerializableToDoubleFunction<E3> name, double value, DoublePredicate ignoreStrategy) {
        return ge(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    @Override
    public <D extends Date> L ge3(SerializableDateSupplier<D> property, D value) {
        return ge(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <D extends Date> L ge3(SerializableDateSupplier<D> property, D value, Predicate<D> ignoreStrategy) {
        return ge(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public <N extends Number> L ge3(SerializableNumberSupplier<N> property, N value) {
        return ge(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <N extends Number> L ge3(SerializableNumberSupplier<N> property, N value, Predicate<N> ignoreStrategy) {
        return ge(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L ge3(SerializableLocalDateSupplier property, LocalDate value) {
        return ge(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L ge3(SerializableLocalDateSupplier property, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ge(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L ge3(SerializableLocalTimeSupplier property, LocalTime value) {
        return ge(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L ge3(SerializableLocalTimeSupplier property, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ge(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L ge3(SerializableLocalDateTimeSupplier property, LocalDateTime value) {
        return ge(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L ge3(SerializableLocalDateTimeSupplier property, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return ge(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L ge3(SerializableStringSupplier property, String value) {
        return ge(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L ge3(SerializableStringSupplier property, String value, Predicate<String> ignoreStrategy) {
        return ge(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L ge3(SerializableIntSupplier property, int value) {
        return ge(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L ge3(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy) {
        return ge(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L ge3(SerializableLongSupplier property, long value) {
        return ge(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L ge3(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy) {
        return ge(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L ge3(SerializableDoubleSupplier property, double value) {
        return ge(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L ge3(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy) {
        return ge(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L gt3(SerializableFunction<E3, N> name, N value) {
        return gt(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <N extends Number> L gt3(SerializableFunction<E3, N> name, N value, Predicate<N> ignoreStrategy) {
        return gt(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public <E extends Enum<E>> L gt3(SerializableFunction<E3, E> name, E value) {
        return gt(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <E extends Enum<E>> L gt3(SerializableFunction<E3, E> name, E value, Predicate<E> ignoreStrategy) {
        return gt(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L gt3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy) {
        return gt(classMapping3, name, value, matchStrategy, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L gt3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return gt(classMapping3, name, value, matchStrategy, tableAlias3, ignoreStrategy);
    }

    @Override
    public <D extends Date> L gt3(SerializableFunction<E3, D> name, D value) {
        return gt(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <D extends Date> L gt3(SerializableFunction<E3, D> name, D value, Predicate<D> ignoreStrategy) {
        return gt(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L gt3(SerializableFunction<E3, LocalTime> name, LocalTime value) {
        return gt(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L gt3(SerializableFunction<E3, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return gt(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L gt3(SerializableFunction<E3, LocalDate> name, LocalDate value) {
        return gt(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L gt3(SerializableFunction<E3, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return gt(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L gt3(SerializableFunction<E3, LocalDateTime> name, LocalDateTime value) {
        return gt(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L gt3(SerializableFunction<E3, LocalDateTime> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return gt(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L gt3(SerializableFunction<E3, String> name, String value) {
        return gt(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L gt3(SerializableFunction<E3, String> name, String value, Predicate<String> ignoreStrategy) {
        return gt(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L gt3(SerializableToIntFunction<E3> name, int value) {
        return gt(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L gt3(SerializableToIntFunction<E3> name, int value, IntPredicate ignoreStrategy) {
        return gt(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L gt3(SerializableToLongFunction<E3> name, long value) {
        return gt(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L gt3(SerializableToLongFunction<E3> name, long value, LongPredicate ignoreStrategy) {
        return gt(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L gt3(SerializableToDoubleFunction<E3> name, double value) {
        return gt(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L gt3(SerializableToDoubleFunction<E3> name, double value, DoublePredicate ignoreStrategy) {
        return gt(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    @Override
    public <E extends Enum<E>> L gt3(SerializableEnumSupplier<E> property, E value) {
        return gt(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <E extends Enum<E>> L gt3(SerializableEnumSupplier<E> property, E value, Predicate<E> ignoreStrategy) {
        return gt(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L gt3(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return gt(classMapping3, property, value, matchStrategy, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L gt3(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return gt(classMapping3, property, value, matchStrategy, tableAlias3, ignoreStrategy);
    }

    @Override
    public <N extends Number> L gt3(SerializableNumberSupplier<N> property, N value) {
        return gt(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <N extends Number> L gt3(SerializableNumberSupplier<N> property, N value, Predicate<N> ignoreStrategy) {
        return gt(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public <D extends Date> L gt3(SerializableDateSupplier<D> property, D value) {
        return gt(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <D extends Date> L gt3(SerializableDateSupplier<D> property, D value, Predicate<D> ignoreStrategy) {
        return gt(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L gt3(SerializableLocalDateSupplier property, LocalDate value) {
        return gt(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L gt3(SerializableLocalDateSupplier property, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return gt(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L gt3(SerializableLocalTimeSupplier property, LocalTime value) {
        return gt(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L gt3(SerializableLocalTimeSupplier property, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return gt(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L gt3(SerializableLocalDateTimeSupplier property, LocalDateTime value) {
        return gt(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L gt3(SerializableLocalDateTimeSupplier property, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return gt(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L gt3(SerializableStringSupplier property, String value) {
        return gt(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L gt3(SerializableStringSupplier property, String value, Predicate<String> ignoreStrategy) {
        return gt(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L gt3(SerializableIntSupplier property, int value) {
        return gt(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L gt3(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy) {
        return gt(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L gt3(SerializableLongSupplier property, long value) {
        return gt(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L gt3(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy) {
        return gt(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L gt3(SerializableDoubleSupplier property, double value) {
        return gt(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L gt3(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy) {
        return gt(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L le3(SerializableFunction<E3, N> name, N value) {
        return le(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <N extends Number> L le3(SerializableFunction<E3, N> name, N value, Predicate<N> ignoreStrategy) {
        return le(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public <D extends Date> L le3(SerializableFunction<E3, D> name, D value) {
        return le(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <D extends Date> L le3(SerializableFunction<E3, D> name, D value, Predicate<D> ignoreStrategy) {
        return le(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L le3(SerializableFunction<E3, LocalTime> name, LocalTime value) {
        return le(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L le3(SerializableFunction<E3, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return le(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L le3(SerializableFunction<E3, LocalDate> name, LocalDate value) {
        return le(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L le3(SerializableFunction<E3, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return le(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L le3(SerializableFunction<E3, LocalDateTime> name, LocalDateTime value) {
        return le(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L le3(SerializableFunction<E3, LocalDateTime> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return le(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L le3(SerializableFunction<E3, String> name, String value) {
        return le(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L le3(SerializableFunction<E3, String> name, String value, Predicate<String> ignoreStrategy) {
        return le(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public <E extends Enum<E>> L le3(SerializableFunction<E3, E> name, E value) {
        return le(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <E extends Enum<E>> L le3(SerializableFunction<E3, E> name, E value, Predicate<E> ignoreStrategy) {
        return le(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L le3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy) {
        return le(classMapping3, name, value, matchStrategy, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L le3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return le(classMapping3, name, value, matchStrategy, tableAlias3, ignoreStrategy);
    }

    @Override
    public L le3(SerializableToIntFunction<E3> name, int value) {
        return le(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L le3(SerializableToIntFunction<E3> name, int value, IntPredicate ignoreStrategy) {
        return le(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L le3(SerializableToLongFunction<E3> name, long value) {
        return le(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L le3(SerializableToLongFunction<E3> name, long value, LongPredicate ignoreStrategy) {
        return le(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L le3(SerializableToDoubleFunction<E3> name, double value) {
        return le(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L le3(SerializableToDoubleFunction<E3> name, double value, DoublePredicate ignoreStrategy) {
        return le(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    @Override
    public <E extends Enum<E>> L le3(SerializableEnumSupplier<E> property, E value) {
        return le(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <E extends Enum<E>> L le3(SerializableEnumSupplier<E> property, E value, Predicate<E> ignoreStrategy) {
        return le(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L le3(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return le(classMapping3, property, matchStrategy, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L le3(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return le(classMapping3, property, matchStrategy, tableAlias3, ignoreStrategy);
    }

    @Override
    public <D extends Date> L le3(SerializableDateSupplier<D> property, D value) {
        return le(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <D extends Date> L le3(SerializableDateSupplier<D> property, D value, Predicate<D> ignoreStrategy) {
        return le(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public <N extends Number> L le3(SerializableNumberSupplier<N> property, N value) {
        return le(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <N extends Number> L le3(SerializableNumberSupplier<N> property, N value, Predicate<N> ignoreStrategy) {
        return le(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L le3(SerializableLocalDateSupplier property, LocalDate value) {
        return le(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L le3(SerializableLocalDateSupplier property, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return le(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L le3(SerializableLocalTimeSupplier property, LocalTime value) {
        return le(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L le3(SerializableLocalTimeSupplier property, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return le(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L le3(SerializableLocalDateTimeSupplier property, LocalDateTime value) {
        return le(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L le3(SerializableLocalDateTimeSupplier property, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return le(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L le3(SerializableStringSupplier property, String value) {
        return le(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L le3(SerializableStringSupplier property, String value, Predicate<String> ignoreStrategy) {
        return le(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L le3(SerializableIntSupplier property, int value) {
        return le(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L le3(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy) {
        return le(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L le3(SerializableLongSupplier property, long value) {
        return le(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L le3(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy) {
        return le(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L le3(SerializableDoubleSupplier property, double value) {
        return le(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L le3(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy) {
        return le(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L lt3(SerializableFunction<E3, N> name, N value) {
        return lt(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <N extends Number> L lt3(SerializableFunction<E3, N> name, N value, Predicate<N> ignoreStrategy) {
        return lt(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public <E extends Enum<E>> L lt3(SerializableFunction<E3, E> name, E value) {
        return lt(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <E extends Enum<E>> L lt3(SerializableFunction<E3, E> name, E value, Predicate<E> ignoreStrategy) {
        return lt(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public <D extends Date> L lt3(SerializableFunction<E3, D> name, D value) {
        return lt(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <D extends Date> L lt3(SerializableFunction<E3, D> name, D value, Predicate<D> ignoreStrategy) {
        return lt(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L lt3(SerializableFunction<E3, LocalTime> name, LocalTime value) {
        return lt(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L lt3(SerializableFunction<E3, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return lt(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L lt3(SerializableFunction<E3, LocalDate> name, LocalDate value) {
        return lt(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L lt3(SerializableFunction<E3, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return lt(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L lt3(SerializableFunction<E3, LocalDateTime> name, LocalDateTime value) {
        return lt(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L lt3(SerializableFunction<E3, LocalDateTime> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return lt(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L lt3(SerializableFunction<E3, String> name, String value) {
        return lt(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L lt3(SerializableFunction<E3, String> name, String value, Predicate<String> ignoreStrategy) {
        return lt(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L lt3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy) {
        return lt(classMapping3, name, value, matchStrategy, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L lt3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return lt(classMapping3, name, value, matchStrategy, tableAlias3, ignoreStrategy);
    }

    @Override
    public L lt3(SerializableToIntFunction<E3> name, int value) {
        return lt(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L lt3(SerializableToIntFunction<E3> name, int value, IntPredicate ignoreStrategy) {
        return lt(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L lt3(SerializableToLongFunction<E3> name, long value) {
        return lt(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L lt3(SerializableToLongFunction<E3> name, long value, LongPredicate ignoreStrategy) {
        return lt(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L lt3(SerializableToDoubleFunction<E3> name, double value) {
        return lt(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L lt3(SerializableToDoubleFunction<E3> name, double value, DoublePredicate ignoreStrategy) {
        return lt(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    @Override
    public <E extends Enum<E>> L lt3(SerializableEnumSupplier<E> property, E value) {
        return lt(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <E extends Enum<E>> L lt3(SerializableEnumSupplier<E> property, E value, Predicate<E> ignoreStrategy) {
        return lt(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L lt3(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return lt(classMapping3, property, matchStrategy, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L lt3(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return lt(classMapping3, property, matchStrategy, tableAlias3, ignoreStrategy);
    }

    @Override
    public <R extends Number> L lt3(SerializableNumberSupplier<R> property, R value) {
        return lt(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <R extends Number> L lt3(SerializableNumberSupplier<R> property, R value, Predicate<R> ignoreStrategy) {
        return lt(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public <R extends Date> L lt3(SerializableDateSupplier<R> property, R value) {
        return lt(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <R extends Date> L lt3(SerializableDateSupplier<R> property, R value, Predicate<R> ignoreStrategy) {
        return lt(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L lt3(SerializableLocalDateSupplier property, LocalDate value) {
        return lt(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L lt3(SerializableLocalDateSupplier property, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return lt(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L lt3(SerializableLocalTimeSupplier property, LocalTime value) {
        return lt(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L lt3(SerializableLocalTimeSupplier property, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return lt(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L lt3(SerializableLocalDateTimeSupplier property, LocalDateTime value) {
        return lt(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L lt3(SerializableLocalDateTimeSupplier property, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return lt(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L lt3(SerializableStringSupplier property, String value) {
        return lt(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L lt3(SerializableStringSupplier property, String value, Predicate<String> ignoreStrategy) {
        return lt(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L lt3(SerializableIntSupplier property, int value) {
        return lt(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L lt3(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy) {
        return lt(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L lt3(SerializableLongSupplier property, long value) {
        return lt(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L lt3(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy) {
        return lt(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L lt3(SerializableDoubleSupplier property, double value) {
        return lt(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L lt3(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy) {
        return lt(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <R extends Serializable> L in3(SerializableFunction<E3, R> name, R value) {
        return in(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <R extends Serializable> L in3(SerializableFunction<E3, R> name, R value, Predicate<R> ignoreStrategy) {
        return in(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public <R extends Serializable> L in3(SerializableFunction<E3, R> name, @SuppressWarnings("unchecked") R... value) {
        return in(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <R extends Serializable> L in3(SerializableFunction<E3, R> name, R[] value, Predicate<R[]> ignoreStrategy) {
        return in(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public <R extends Serializable> L in3(SerializableFunction<E3, R> name, Collection<R> value) {
        return in(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <R extends Serializable> L in3(SerializableFunction<E3, R> name, Collection<R> value,
        Predicate<Collection<R>> ignoreStrategy) {
        return in(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L in3(SerializableToStringFunction<E3> name, String value, MatchStrategy matchStrategy) {
        return in(classMapping3, name, value, matchStrategy, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L in3(SerializableToStringFunction<E3> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return in(classMapping3, name, value, matchStrategy, tableAlias3, ignoreStrategy);
    }

    @Override
    public L in3(SerializableToStringFunction<E3> name, String[] value, MatchStrategy matchStrategy) {
        return in(classMapping3, name, value, matchStrategy, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L in3(SerializableToStringFunction<E3> name, String[] value, MatchStrategy matchStrategy,
        Predicate<String[]> ignoreStrategy) {
        return in(classMapping3, name, value, matchStrategy, tableAlias3, ignoreStrategy);
    }

    @Override
    public L in3(SerializableToIntFunction<E3> name, int value) {
        return in(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L in3(SerializableToIntFunction<E3> name, int value, IntPredicate ignoreStrategy) {
        return in(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L in3(SerializableToLongFunction<E3> name, long value) {
        return in(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L in3(SerializableToLongFunction<E3> name, long value, LongPredicate ignoreStrategy) {
        return in(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L in3(SerializableToDoubleFunction<E3> name, double value) {
        return in(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L in3(SerializableToDoubleFunction<E3> name, double value, DoublePredicate ignoreStrategy) {
        return in(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L in3(SerializableToIntFunction<E3> name, int... value) {
        return in(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L in3(SerializableToLongFunction<E3> name, long... value) {
        return in(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L in3(SerializableToDoubleFunction<E3> name, double... value) {
        return in(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L in3(SerializableToDoubleFunction<E3> name, double[] value, Predicate<double[]> ignoreStrategy) {
        return in(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L in3(SerializableToIntFunction<E3> name, int[] value, Predicate<int[]> ignoreStrategy) {
        return in(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L in3(SerializableToLongFunction<E3> name, long[] value, Predicate<long[]> ignoreStrategy) {
        return in(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L in3(SerializableSupplier<R> property, R value) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return in(classMapping3.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), value,
            tableAlias3, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L in3(SerializableSupplier<R> property, @SuppressWarnings("unchecked") R... value) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return in(classMapping3.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), value,
            tableAlias3, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L in3(SerializableSupplier<R> property, R value, Predicate<R> ignoreStrategy) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return in(classMapping3.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), value,
            tableAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L in3(SerializableSupplier<R> property, R[] value, Predicate<R[]> ignoreStrategy) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return in(classMapping3.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), value,
            tableAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in3(SerializableIntSupplier property, int value) {
        return in(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L in3(SerializableIntSupplier property, int... value) {
        return in(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in3(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy) {
        return in(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in3(SerializableIntSupplier property, int[] value, Predicate<int[]> ignoreStrategy) {
        return in(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in3(SerializableLongSupplier property, long value) {
        return in(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L in3(SerializableLongSupplier property, long... value) {
        return in(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in3(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy) {
        return in(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in3(SerializableLongSupplier property, long[] value, Predicate<long[]> ignoreStrategy) {
        return in(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in3(SerializableDoubleSupplier property, double value) {
        return in(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L in3(SerializableDoubleSupplier property, double... value) {
        return in(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in3(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy) {
        return in(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L in3(SerializableDoubleSupplier property, double[] value, Predicate<double[]> ignoreStrategy) {
        return in(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in3(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return in(classMapping3, property, value, matchStrategy, tableAlias3, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in3(SerializableStringSupplier property, String[] value, MatchStrategy matchStrategy) {
        return in(classMapping3, property, value, matchStrategy, tableAlias3, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in3(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return in(classMapping3, property, value, matchStrategy, tableAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in3(SerializableStringSupplier property, String[] value, MatchStrategy matchStrategy,
        Predicate<String[]> ignoreStrategy) {
        return in(classMapping3, property, value, matchStrategy, tableAlias3, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni3(SerializableFunction<E3, R> name, R value) {
        return ni(classMapping3.getPropertyMapping(getPropertyName(name)), value, tableAlias3, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni3(SerializableFunction<E3, R> name, R value, Predicate<R> ignoreStrategy) {
        return ni(classMapping3.getPropertyMapping(getPropertyName(name)), value, tableAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni3(SerializableFunction<E3, R> name, @SuppressWarnings("unchecked") R... value) {
        return ni(classMapping3.getPropertyMapping(getPropertyName(name)), value, tableAlias3, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni3(SerializableFunction<E3, R> name, R[] value, Predicate<R[]> ignoreStrategy) {
        return ni(classMapping3.getPropertyMapping(getPropertyName(name)), value, tableAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni3(SerializableFunction<E3, R> name, Collection<R> value) {
        return ni(classMapping3.getPropertyMapping(getPropertyName(name)), value, tableAlias3,
            getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni3(SerializableFunction<E3, R> name, Collection<R> value,
        Predicate<Collection<R>> ignoreStrategy) {
        return ni(classMapping3.getPropertyMapping(getPropertyName(name)), value, tableAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni3(SerializableToIntFunction<E3> name, int value) {
        return ni(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni3(SerializableToIntFunction<E3> name, int value, IntPredicate ignoreStrategy) {
        return ni(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni3(SerializableToLongFunction<E3> name, long value) {
        return ni(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni3(SerializableToLongFunction<E3> name, long value, LongPredicate ignoreStrategy) {
        return ni(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni3(SerializableToDoubleFunction<E3> name, double value) {
        return ni(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni3(SerializableToDoubleFunction<E3> name, double value, DoublePredicate ignoreStrategy) {
        return ni(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni3(SerializableToIntFunction<E3> name, int... value) {
        return ni(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni3(SerializableToLongFunction<E3> name, long... value) {
        return ni(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni3(SerializableToDoubleFunction<E3> name, double... value) {
        return ni(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni3(SerializableToIntFunction<E3> name, int[] value, Predicate<int[]> ignoreStrategy) {
        return ni(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni3(SerializableToLongFunction<E3> name, long[] value, Predicate<long[]> ignoreStrategy) {
        return ni(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni3(SerializableToDoubleFunction<E3> name, double[] value, Predicate<double[]> ignoreStrategy) {
        return ni(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni3(SerializableSupplier<R> property, R value) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ni(classMapping3.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), value,
            tableAlias3, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni3(SerializableSupplier<R> property, @SuppressWarnings("unchecked") R... value) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ni(classMapping3.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), value,
            tableAlias3, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni3(SerializableSupplier<R> property, R value, Predicate<R> ignoreStrategy) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ni(classMapping3.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), value,
            tableAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni3(SerializableSupplier<R> property, R[] value, Predicate<R[]> ignoreStrategy) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ni(classMapping3.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), value,
            tableAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni3(SerializableIntSupplier property, int value) {
        return ni(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L ni3(SerializableIntSupplier name, int... value) {
        return ni(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni3(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy) {
        return ni(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L ni3(SerializableIntSupplier name, int[] value, Predicate<int[]> ignoreStrategy) {
        return ni(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni3(SerializableLongSupplier property, long value) {
        return ni(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L ni3(SerializableLongSupplier property, long... value) {
        return ni(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni3(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy) {
        return ni(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L ni3(SerializableLongSupplier name, long[] value, Predicate<long[]> ignoreStrategy) {
        return ni(classMapping3, name, value, tableAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni3(SerializableDoubleSupplier property, double value) {
        return ni(classMapping3, property, value, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L ni3(SerializableDoubleSupplier name, double... value) {
        return ni(classMapping3, name, value, tableAlias3, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni3(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy) {
        return ni(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    @Override
    public L ni3(SerializableDoubleSupplier property, double[] value, Predicate<double[]> ignoreStrategy) {
        return ni(classMapping3, property, value, tableAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni3(SerializableToStringFunction<E3> name, String value, MatchStrategy matchStrategy) {
        return ni(classMapping3, name, value, matchStrategy, tableAlias3, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni3(SerializableToStringFunction<E3> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ni(classMapping3, name, value, matchStrategy, tableAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni3(SerializableToStringFunction<E3> name, String[] value, MatchStrategy matchStrategy) {
        return ni(classMapping3, name, value, matchStrategy, tableAlias3, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni3(SerializableToStringFunction<E3> name, String[] value, MatchStrategy matchStrategy,
        Predicate<String[]> ignoreStrategy) {
        return ni(classMapping3, name, value, matchStrategy, tableAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni3(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return ni(classMapping3, property, value, matchStrategy, tableAlias3, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni3(SerializableStringSupplier property, String[] value, MatchStrategy matchStrategy) {
        return ni(classMapping3, property, value, matchStrategy, tableAlias3, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni3(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ni(classMapping3, property, value, matchStrategy, tableAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni3(SerializableStringSupplier property, String[] value, MatchStrategy matchStrategy,
        Predicate<String[]> ignoreStrategy) {
        return ni(classMapping3, property, value, matchStrategy, tableAlias3, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L ba3(SerializableToIntFunction<E3> name, int min, int max) {
        return ba(classMapping3, name, min, max, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L ba3(SerializableToIntFunction<E3> name, int min, int max, BiPredicate<Integer, Integer> ignoreStrategy) {
        return ba(classMapping3, name, min, max, tableAlias3, ignoreStrategy);
    }

    @Override
    public L ba3(SerializableToLongFunction<E3> name, long min, long max) {
        return ba(classMapping3, name, min, max, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L ba3(SerializableToLongFunction<E3> name, long min, long max, BiPredicate<Long, Long> ignoreStrategy) {
        return ba(classMapping3, name, min, max, tableAlias3, ignoreStrategy);
    }

    @Override
    public L ba3(SerializableToDoubleFunction<E3> name, double min, double max) {
        return ba(classMapping3, name, min, max, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L ba3(SerializableToDoubleFunction<E3> name, double min, double max,
        BiPredicate<Double, Double> ignoreStrategy) {
        return ba(classMapping3, name, min, max, tableAlias3, ignoreStrategy);
    }

    @Override
    public <N extends Number> L ba3(SerializableToNumberFunction<E3, N> name, N min, N max) {
        return ba(classMapping3, name, min, max, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <N extends Number> L ba3(SerializableToNumberFunction<E3, N> name, N min, N max,
        BiPredicate<N, N> ignoreStrategy) {
        return ba(classMapping3, name, min, max, tableAlias3, ignoreStrategy);
    }

    @Override
    public <D extends Date> L ba3(SerializableToDateFunction<E3, D> name, D min, D max) {
        return ba(classMapping3, name, min, max, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <D extends Date> L ba3(SerializableToDateFunction<E3, D> name, D min, D max,
        BiPredicate<D, D> ignoreStrategy) {
        return ba(classMapping3, name, min, max, tableAlias3, ignoreStrategy);
    }

    @Override
    public <E extends Enum<E>> L ba3(SerializableToEnumFunction<E3, E> name, E min, E max) {
        return ba(classMapping3, name, min, max, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <E extends Enum<E>> L ba3(SerializableToEnumFunction<E3, E> name, E min, E max,
        BiPredicate<E, E> ignoreStrategy) {
        return ba(classMapping3, name, min, max, tableAlias3, ignoreStrategy);
    }

    @Override
    public L ba3(SerializableToLocalTimeFunction<E3> name, LocalTime min, LocalTime max) {
        return ba(classMapping3, name, min, max, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L ba3(SerializableToLocalTimeFunction<E3> name, LocalTime min, LocalTime max,
        BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return ba(classMapping3, name, min, max, tableAlias3, ignoreStrategy);
    }

    @Override
    public L ba3(SerializableToLocalDateFunction<E3> name, LocalDate min, LocalDate max) {
        return ba(classMapping3, name, min, max, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L ba3(SerializableToLocalDateFunction<E3> name, LocalDate min, LocalDate max,
        BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return ba(classMapping3, name, min, max, tableAlias3, ignoreStrategy);
    }

    @Override
    public L ba3(SerializableToLocalDateTimeFunction<E3> name, LocalDateTime min, LocalDateTime max) {
        return ba(classMapping3, name, min, max, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L ba3(SerializableToLocalDateTimeFunction<E3> name, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return ba(classMapping3, name, min, max, tableAlias3, ignoreStrategy);
    }

    @Override
    public L ba3(SerializableToStringFunction<E3> name, String min, String max) {
        return ba(classMapping3, name, min, max, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L ba3(SerializableToStringFunction<E3> name, String min, String max,
        BiPredicate<String, String> ignoreStrategy) {
        return ba(classMapping3, name, min, max, tableAlias3, ignoreStrategy);
    }

    // --------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ba3(SerializableNumberSupplier<N> property, N min, N max) {
        return ba(classMapping3, property, min, max, tableAlias3, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ba3(SerializableNumberSupplier<N> name, N min, N max,
        BiPredicate<N, N> ignoreStrategy) {
        return ba(classMapping3, name, min, max, tableAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ba3(SerializableDateSupplier<D> property, D min, D max) {
        return ba(classMapping3, property, min, max, tableAlias3, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ba3(SerializableDateSupplier<D> property, D min, D max,
        BiPredicate<D, D> ignoreStrategy) {
        return ba(classMapping3, property, min, max, tableAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba3(SerializableLocalTimeSupplier property, LocalTime min, LocalTime max) {
        return ba(classMapping3, property, min, max, tableAlias3, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba3(SerializableLocalTimeSupplier property, LocalTime min, LocalTime max,
        BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return ba(classMapping3, property, min, max, tableAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba3(SerializableLocalDateSupplier property, LocalDate min, LocalDate max) {
        return ba(classMapping3, property, min, max, tableAlias3, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba3(SerializableLocalDateSupplier property, LocalDate min, LocalDate max,
        BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return ba(classMapping3, property, min, max, tableAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba3(SerializableLocalDateTimeSupplier property, LocalDateTime min, LocalDateTime max) {
        return ba(classMapping3, property, min, max, tableAlias3, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba3(SerializableLocalDateTimeSupplier property, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return ba(classMapping3, property, min, max, tableAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba3(SerializableStringSupplier property, String min, String max) {
        return ba(classMapping3, property, min, max, tableAlias3, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba3(SerializableStringSupplier property, String min, String max,
        BiPredicate<String, String> ignoreStrategy) {
        return ba(classMapping3, property, min, max, tableAlias3, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L nba3(SerializableToIntFunction<E3> name, int min, int max) {
        return nba(classMapping3, name, min, max, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L nba3(SerializableToIntFunction<E3> name, int min, int max, BiPredicate<Integer, Integer> ignoreStrategy) {
        return nba(classMapping3, name, min, max, tableAlias3, ignoreStrategy);
    }

    @Override
    public L nba3(SerializableToLongFunction<E3> name, long min, long max) {
        return nba(classMapping3, name, min, max, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L nba3(SerializableToLongFunction<E3> name, long min, long max, BiPredicate<Long, Long> ignoreStrategy) {
        return nba(classMapping3, name, min, max, tableAlias3, ignoreStrategy);
    }

    @Override
    public L nba3(SerializableToDoubleFunction<E3> name, double min, double max) {
        return nba(classMapping3, name, min, max, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L nba3(SerializableToDoubleFunction<E3> name, double min, double max,
        BiPredicate<Double, Double> ignoreStrategy) {
        return nba(classMapping3, name, min, max, tableAlias3, ignoreStrategy);
    }

    @Override
    public <N extends Number> L nba3(SerializableToNumberFunction<E3, N> name, N min, N max) {
        return nba(classMapping3, name, min, max, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <N extends Number> L nba3(SerializableToNumberFunction<E3, N> name, N min, N max,
        BiPredicate<N, N> ignoreStrategy) {
        return nba(classMapping3, name, min, max, tableAlias3, ignoreStrategy);
    }

    @Override
    public <D extends Date> L nba3(SerializableToDateFunction<E3, D> name, D min, D max) {
        return nba(classMapping3, name, min, max, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <D extends Date> L nba3(SerializableToDateFunction<E3, D> name, D min, D max,
        BiPredicate<D, D> ignoreStrategy) {
        return nba(classMapping3, name, min, max, tableAlias3, ignoreStrategy);
    }

    @Override
    public <E extends Enum<E>> L nba3(SerializableToEnumFunction<E3, E> name, E min, E max) {
        return nba(classMapping3, name, min, max, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public <E extends Enum<E>> L nba3(SerializableToEnumFunction<E3, E> name, E min, E max,
        BiPredicate<E, E> ignoreStrategy) {
        return nba(classMapping3, name, min, max, tableAlias3, ignoreStrategy);
    }

    @Override
    public L nba3(SerializableToLocalTimeFunction<E3> name, LocalTime min, LocalTime max) {
        return nba(classMapping3, name, min, max, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L nba3(SerializableToLocalTimeFunction<E3> name, LocalTime min, LocalTime max,
        BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return nba(classMapping3, name, min, max, tableAlias3, ignoreStrategy);
    }

    @Override
    public L nba3(SerializableToLocalDateFunction<E3> name, LocalDate min, LocalDate max) {
        return nba(classMapping3, name, min, max, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L nba3(SerializableToLocalDateFunction<E3> name, LocalDate min, LocalDate max,
        BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return nba(classMapping3, name, min, max, tableAlias3, ignoreStrategy);
    }

    @Override
    public L nba3(SerializableToLocalDateTimeFunction<E3> name, LocalDateTime min, LocalDateTime max) {
        return nba(classMapping3, name, min, max, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L nba3(SerializableToLocalDateTimeFunction<E3> name, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return nba(classMapping3, name, min, max, tableAlias3, ignoreStrategy);
    }

    @Override
    public L nba3(SerializableToStringFunction<E3> name, String min, String max) {
        return nba(classMapping3, name, min, max, tableAlias3, getIgnoreStrategy());
    }

    @Override
    public L nba3(SerializableToStringFunction<E3> name, String min, String max,
        BiPredicate<String, String> ignoreStrategy) {
        return nba(classMapping3, name, min, max, tableAlias3, ignoreStrategy);
    }

    // --------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L nba3(SerializableNumberSupplier<N> property, N min, N max) {
        return nba(classMapping3, property, min, max, tableAlias3, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L nba3(SerializableNumberSupplier<N> name, N min, N max,
        BiPredicate<N, N> ignoreStrategy) {
        return nba(classMapping3, name, min, max, tableAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L nba3(SerializableDateSupplier<D> property, D min, D max) {
        return nba(classMapping3, property, min, max, tableAlias3, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L nba3(SerializableDateSupplier<D> property, D min, D max,
        BiPredicate<D, D> ignoreStrategy) {
        return nba(classMapping3, property, min, max, tableAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba3(SerializableLocalTimeSupplier property, LocalTime min, LocalTime max) {
        return nba(classMapping3, property, min, max, tableAlias3, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba3(SerializableLocalTimeSupplier property, LocalTime min, LocalTime max,
        BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return nba(classMapping3, property, min, max, tableAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba3(SerializableLocalDateSupplier property, LocalDate min, LocalDate max) {
        return nba(classMapping3, property, min, max, tableAlias3, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba3(SerializableLocalDateSupplier property, LocalDate min, LocalDate max,
        BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return nba(classMapping3, property, min, max, tableAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba3(SerializableLocalDateTimeSupplier property, LocalDateTime min, LocalDateTime max) {
        return nba(classMapping3, property, min, max, tableAlias3, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba3(SerializableLocalDateTimeSupplier property, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return nba(classMapping3, property, min, max, tableAlias3, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba3(SerializableStringSupplier property, String min, String max) {
        return nba(classMapping3, property, min, max, tableAlias3, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba3(SerializableStringSupplier property, String min, String max,
        BiPredicate<String, String> ignoreStrategy) {
        return nba(classMapping3, property, min, max, tableAlias3, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <R> L inn3(SerializableFunction<E3, R> name, Boolean value) {
        return inn(classMapping3, name, value, tableAlias3);
    }

    @Override
    public <R> L inn3(SerializableSupplier<R> name, Boolean value) {
        return inn(classMapping3, name, value, tableAlias3);
    }

    @Override
    public <R> L isn3(SerializableFunction<E3, R> name, Boolean value) {
        return isn(classMapping3, name, value, tableAlias3);
    }

    @Override
    public <R> L isn3(SerializableSupplier<R> name, Boolean value) {
        return isn(classMapping3, name, value, tableAlias3);
    }

    // ****************************************************************************************************************
    // property
    // ****************************************************************************************************************

    @Override
    @SuppressWarnings("unchecked")
    public L property(ThreeArgusFunction<EntityPropertyExpression<E1, ?, ?>, EntityPropertyExpression<E2, ?, ?>,
        EntityPropertyExpression<E3, ?, ?>, LogicExpression<?, ?>> entitiesPropertyFunction) {
        return (L) entitiesPropertyFunction.apply(
            new EntityPropertyOnlyExpressionImpl<>(0, this, factory, entityRelation),
            new EntityPropertyOnlyExpressionImpl<>(1, this, factory, entityRelation),
            new EntityPropertyOnlyExpressionImpl<>(2, this, factory, entityRelation));
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
    protected int getIndex() {
        return 2;
    }
}
