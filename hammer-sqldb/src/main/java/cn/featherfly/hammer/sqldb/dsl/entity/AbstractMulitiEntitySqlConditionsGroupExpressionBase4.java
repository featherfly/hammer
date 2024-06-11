
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
import cn.featherfly.common.function.FourArgusFunction;
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
import cn.featherfly.hammer.expression.entity.condition.sw.EntityStartWithExpressionBase4;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlRelation.EntityRelation;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.propery.EntityPropertyOnlyExpressionImpl;

/**
 * sql condition group expression 4. sql条件逻辑组表达式4.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <E3> third filterable entity type
 * @param <E4> fouth filterable entity type
 * @param <C> condition expression
 * @param <L> logic expression
 * @param <C2> condition config
 * @param <ER> entity sql relation
 * @param <B> sql builder
 */
public abstract class AbstractMulitiEntitySqlConditionsGroupExpressionBase4<E1, E2, E3, E4,
    C extends GroupExpression<C, L>, L extends GroupEndExpression<C, L>, C2 extends ConditionConfig<C2>,
    ER extends EntitySqlRelation<ER, B>, B extends SqlBuilder>
    extends AbstractMulitiEntitySqlConditionsGroupExpressionBase3<E1, E2, E3, C, L, C2, ER, B>
    implements EntityBetweenExpressionBase4<E1, E2, E3, E4, C, L>, EntityNotBetweenExpressionBase4<E1, E2, E3, E4, C, L> //
    , EntityContainsExpressionBase4<E1, E2, E3, E4, C, L>, EntityNotContainsExpressionBase4<E1, E2, E3, E4, C, L> //
    , EntityEndWithExpressionBase4<E1, E2, E3, E4, C, L>, EntityNotEndWithExpressionBase4<E1, E2, E3, E4, C, L> //
    , EntityEqualsExpressionBase4<E1, E2, E3, E4, C, L>, EntityNotEqualsExpressionBase4<E1, E2, E3, E4, C, L>//
    , EntityGreatEqualsExpressionBase4<E1, E2, E3, E4, C, L>, EntityGreatThanExpressionBase4<E1, E2, E3, E4, C, L> //
    , EntityInExpressionBase4<E1, E2, E3, E4, C, L>, EntityNotInExpressionBase4<E1, E2, E3, E4, C, L> //
    , EntityIsNotNullExpressionBase4<E1, E2, E3, E4, C, L>, EntityIsNullExpressionBase4<E1, E2, E3, E4, C, L> //
    , EntityLessEqualsExpressionBase4<E1, E2, E3, E4, C, L>, EntityLessThanExpressionBase4<E1, E2, E3, E4, C, L> //
    , EntityStartWithExpressionBase4<E1, E2, E3, E4, C, L>, EntityNotStartWithExpressionBase4<E1, E2, E3, E4, C, L> //
    , EntityLikeExpressionBase4<E1, E2, E3, E4, C, L>, EntityNotLikeExpressionBase4<E1, E2, E3, E4, C, L>//
    , EntityPropertyExpression4<E1, E2, E3, E4, C, L> {

    /** The class mapping. */
    protected final JdbcClassMapping<E4> classMapping4;

    /** The table alias 4. */
    protected final String tableAlias4;

    /**
     * Instantiates a new abstract entity sql condition group expression base 4.
     *
     * @param parent the parent
     * @param factory the factory
     * @param entitySqlRelation the entity sql relation
     */
    @SuppressWarnings("unchecked")
    protected AbstractMulitiEntitySqlConditionsGroupExpressionBase4(L parent, JdbcMappingFactory factory,
        ER entitySqlRelation) {
        super(parent, factory, entitySqlRelation);

        EntityRelation<?> erm = entitySqlRelation.getEntityRelationTuple().getOrNull3();
        classMapping4 = (JdbcClassMapping<E4>) erm.getClassMapping();
        tableAlias4 = erm.getTableAlias();
    }

    // ****************************************************************************************************************
    //  eq
    // ****************************************************************************************************************

    @Override
    public <R extends Serializable> L eq4(SerializableFunction<E4, R> name, R value) {
        return eq(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <R extends Serializable> L eq4(SerializableFunction<E4, R> name, R value, Predicate<R> ignoreStrategy) {
        return eq(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public <D extends Date> L eq4(SerializableToDateFunction<E4, D> name, D value) {
        return eq(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <D extends Date> L eq4(SerializableToDateFunction<E4, D> name, D value, Predicate<D> ignoreStrategy) {
        return eq(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L eq4(SerializableToDoubleFunction<E4> name, double value) {
        return eq(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L eq4(SerializableToDoubleFunction<E4> name, double value, DoublePredicate ignoreStrategy) {
        return eq(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public <E extends Enum<E>> L eq4(SerializableToEnumFunction<E4, E> name, E value) {
        return eq(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <E extends Enum<E>> L eq4(SerializableToEnumFunction<E4, E> name, E value, Predicate<E> ignoreStrategy) {
        return eq(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L eq4(SerializableToCharFunction<E4> name, char value) {
        return eq(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L eq4(SerializableToCharFunction<E4> name, char value, CharPredicate ignoreStrategy) {
        return eq(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L eq4(SerializableToIntFunction<E4> name, int value) {
        return eq(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L eq4(SerializableToIntFunction<E4> name, int value, IntPredicate ignoreStrategy) {
        return eq(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L eq4(SerializableToLocalDateFunction<E4> name, LocalDate value) {
        return eq(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L eq4(SerializableToLocalDateFunction<E4> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return eq(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L eq4(SerializableToLocalDateTimeFunction<E4> name, LocalDateTime value) {
        return eq(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L eq4(SerializableToLocalDateTimeFunction<E4> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return eq(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L eq4(SerializableToLocalTimeFunction<E4> name, LocalTime value) {
        return eq(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L eq4(SerializableToLocalTimeFunction<E4> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return eq(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L eq4(SerializableToLongFunction<E4> name, long value) {
        return eq(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L eq4(SerializableToLongFunction<E4> name, long value, LongPredicate ignoreStrategy) {
        return eq(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public <N extends Number> L eq4(SerializableToNumberFunction<E4, N> name, N value) {
        return eq(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <N extends Number> L eq4(SerializableToNumberFunction<E4, N> name, N value, Predicate<N> ignoreStrategy) {
        return eq(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L eq4(SerializableToStringFunction<E4> name, String value, MatchStrategy matchStrategy) {
        return eq(classMapping4, name, value, tableAlias4, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L eq4(SerializableToStringFunction<E4> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return eq(classMapping4, name, value, tableAlias4, matchStrategy, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    @Override
    public <D extends Date> L eq4(SerializableDateSupplier<D> property, D value) {
        return eq(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <D extends Date> L eq4(SerializableDateSupplier<D> property, D value, Predicate<D> ignoreStrategy) {
        return eq(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L eq4(SerializableDoubleSupplier property, double value) {
        return eq(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L eq4(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy) {
        return eq(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public <E extends Enum<E>> L eq4(SerializableEnumSupplier<E> property, E value) {
        return eq(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <E extends Enum<E>> L eq4(SerializableEnumSupplier<E> property, E value, Predicate<E> ignoreStrategy) {
        return eq(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L eq4(SerializableBooleanSupplier property, boolean value) {
        return eq(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L eq4(SerializableBoolSupplier property, Boolean value) {
        return eq(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L eq4(SerializableBoolSupplier property, Boolean value, Predicate<Boolean> ignoreStrategy) {
        return eq(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L eq4(SerializableCharSupplier property, char value) {
        return eq(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L eq4(SerializableCharSupplier property, char value, CharPredicate ignoreStrategy) {
        return eq(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L eq4(SerializableIntSupplier property, int value) {
        return eq(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L eq4(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy) {
        return eq(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L eq4(SerializableLocalDateSupplier property, LocalDate value) {
        return eq(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L eq4(SerializableLocalDateSupplier property, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return eq(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L eq4(SerializableLocalDateTimeSupplier property, LocalDateTime value) {
        return eq(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L eq4(SerializableLocalDateTimeSupplier property, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return eq(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L eq4(SerializableLocalTimeSupplier property, LocalTime value) {
        return eq(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L eq4(SerializableLocalTimeSupplier property, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return eq(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L eq4(SerializableLongSupplier property, long value) {
        return eq(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L eq4(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy) {
        return eq(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public <N extends Number> L eq4(SerializableNumberSupplier<N> property, N value) {
        return eq(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <N extends Number> L eq4(SerializableNumberSupplier<N> property, N value, Predicate<N> ignoreStrategy) {
        return eq(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L eq4(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return eq(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L eq4(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return eq(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public <R extends Serializable> L eq4(SerializableSupplier<R> property, R value) {
        return eq(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <R extends Serializable> L eq4(SerializableSupplier<R> property, R value, Predicate<R> ignoreStrategy) {
        return eq(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    // ****************************************************************************************************************
    //  ne
    // ****************************************************************************************************************

    @Override
    public <R extends Serializable> L ne4(SerializableFunction<E4, R> name, R value) {
        return ne(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <R extends Serializable> L ne4(SerializableFunction<E4, R> name, R value, Predicate<R> ignoreStrategy) {
        return ne(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public <D extends Date> L ne4(SerializableToDateFunction<E4, D> name, D value) {
        return ne(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <D extends Date> L ne4(SerializableToDateFunction<E4, D> name, D value, Predicate<D> ignoreStrategy) {
        return ne(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L ne4(SerializableToDoubleFunction<E4> name, double value) {
        return ne(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L ne4(SerializableToDoubleFunction<E4> name, double value, DoublePredicate ignoreStrategy) {
        return ne(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public <E extends Enum<E>> L ne4(SerializableToEnumFunction<E4, E> name, E value) {
        return ne(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <E extends Enum<E>> L ne4(SerializableToEnumFunction<E4, E> name, E value, Predicate<E> ignoreStrategy) {
        return ne(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L ne4(SerializableToIntFunction<E4> name, int value) {
        return ne(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L ne4(SerializableToIntFunction<E4> name, int value, IntPredicate ignoreStrategy) {
        return ne(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L ne4(SerializableToLocalDateFunction<E4> name, LocalDate value) {
        return ne(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L ne4(SerializableToLocalDateFunction<E4> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ne(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L ne4(SerializableToLocalDateTimeFunction<E4> name, LocalDateTime value) {
        return ne(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L ne4(SerializableToLocalDateTimeFunction<E4> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return ne(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L ne4(SerializableToLocalTimeFunction<E4> name, LocalTime value) {
        return ne(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L ne4(SerializableToLocalTimeFunction<E4> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ne(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L ne4(SerializableToLongFunction<E4> name, long value) {
        return ne(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L ne4(SerializableToLongFunction<E4> name, long value, LongPredicate ignoreStrategy) {
        return ne(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public <N extends Number> L ne4(SerializableToNumberFunction<E4, N> name, N value) {
        return ne(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <N extends Number> L ne4(SerializableToNumberFunction<E4, N> name, N value, Predicate<N> ignoreStrategy) {
        return ne(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L ne4(SerializableToStringFunction<E4> name, String value, MatchStrategy matchStrategy) {
        return ne(classMapping4, name, value, tableAlias4, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L ne4(SerializableToStringFunction<E4> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ne(classMapping4, name, value, tableAlias4, matchStrategy, ignoreStrategy);
    }

    @Override
    public <D extends Date> L ne4(SerializableDateSupplier<D> property, D value) {
        return ne(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <D extends Date> L ne4(SerializableDateSupplier<D> property, D value, Predicate<D> ignoreStrategy) {
        return ne(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L ne4(SerializableDoubleSupplier property, double value) {
        return ne(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L ne4(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy) {
        return ne(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public <E extends Enum<E>> L ne4(SerializableEnumSupplier<E> property, E value) {
        return ne(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <E extends Enum<E>> L ne4(SerializableEnumSupplier<E> property, E value, Predicate<E> ignoreStrategy) {
        return ne(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L ne4(SerializableBooleanSupplier property, boolean value) {
        return ne(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L ne4(SerializableBoolSupplier property, Boolean value) {
        return ne(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L ne4(SerializableBoolSupplier property, Boolean value, Predicate<Boolean> ignoreStrategy) {
        return ne(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L ne4(SerializableCharSupplier property, char value) {
        return ne(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L ne4(SerializableCharSupplier property, char value, CharPredicate ignoreStrategy) {
        return ne(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L ne4(SerializableIntSupplier property, int value) {
        return ne(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L ne4(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy) {
        return ne(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L ne4(SerializableLocalDateSupplier property, LocalDate value) {
        return ne(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L ne4(SerializableLocalDateSupplier property, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ne(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L ne4(SerializableLocalDateTimeSupplier property, LocalDateTime value) {
        return ne(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L ne4(SerializableLocalDateTimeSupplier property, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return ne(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L ne4(SerializableLocalTimeSupplier property, LocalTime value) {
        return ne(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L ne4(SerializableLocalTimeSupplier property, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ne(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L ne4(SerializableLongSupplier property, long value) {
        return ne(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L ne4(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy) {
        return ne(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public <N extends Number> L ne4(SerializableNumberSupplier<N> property, N value) {
        return ne(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <N extends Number> L ne4(SerializableNumberSupplier<N> property, N value, Predicate<N> ignoreStrategy) {
        return ne(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L ne4(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return ne(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L ne4(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ne(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public <R extends Serializable> L ne4(SerializableSupplier<R> property, R value) {
        return ne(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <R extends Serializable> L ne4(SerializableSupplier<R> property, R value, Predicate<R> ignoreStrategy) {
        return ne(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L lk4(SerializableFunction<E4, String> name, String value, MatchStrategy matchStrategy) {
        return lk(classMapping4, name, value, tableAlias4, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L lk4(SerializableFunction<E4, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return lk(classMapping4, name, value, tableAlias4, matchStrategy, ignoreStrategy);
    }

    @Override
    public L lk4(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return lk(classMapping4, property, value, tableAlias4, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L lk4(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return lk(classMapping4, property, value, tableAlias4, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L nl4(SerializableFunction<E4, String> name, String value, MatchStrategy matchStrategy) {
        return nl(classMapping4, name, value, tableAlias4, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L nl4(SerializableFunction<E4, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nl(classMapping4, name, value, tableAlias4, matchStrategy, ignoreStrategy);
    }

    @Override
    public L nl4(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return nl(classMapping4, property, value, tableAlias4, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L nl4(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nl(classMapping4, property, value, tableAlias4, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L sw4(SerializableFunction<E4, String> name, String value, MatchStrategy matchStrategy) {
        return sw(classMapping4, name, value, tableAlias4, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L sw4(SerializableFunction<E4, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return sw(classMapping4, name, value, tableAlias4, matchStrategy, ignoreStrategy);
    }

    @Override
    public L sw4(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return sw(classMapping4, property, value, tableAlias4, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L sw4(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return sw(classMapping4, property, value, tableAlias4, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L nsw4(SerializableFunction<E4, String> name, String value, MatchStrategy matchStrategy) {
        return nsw(classMapping4, name, value, tableAlias4, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L nsw4(SerializableFunction<E4, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nsw(classMapping4, name, value, tableAlias4, matchStrategy, ignoreStrategy);
    }

    @Override
    public L nsw4(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return nsw(classMapping4, property, value, tableAlias4, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L nsw4(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nsw(classMapping4, property, value, tableAlias4, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L ew4(SerializableFunction<E4, String> name, String value, MatchStrategy matchStrategy) {
        return ew(classMapping4, name, value, tableAlias4, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L ew4(SerializableFunction<E4, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ew(classMapping4, name, value, tableAlias4, matchStrategy, ignoreStrategy);
    }

    @Override
    public L ew4(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return ew(classMapping4, property, value, tableAlias4, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L ew4(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ew(classMapping4, property, value, tableAlias4, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L new4(SerializableFunction<E4, String> name, String value, MatchStrategy matchStrategy) {
        return newv(classMapping4, name, value, tableAlias4, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L new4(SerializableFunction<E4, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return newv(classMapping4, name, value, tableAlias4, matchStrategy, ignoreStrategy);
    }

    @Override
    public L new4(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return newv(classMapping4, property, value, tableAlias4, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L new4(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return newv(classMapping4, property, value, tableAlias4, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L co4(SerializableFunction<E4, String> name, String value, MatchStrategy matchStrategy) {
        return co(classMapping4, name, value, tableAlias4, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L co4(SerializableFunction<E4, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return co(classMapping4, name, value, tableAlias4, matchStrategy, ignoreStrategy);
    }

    @Override
    public L co4(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return co(classMapping4, property, value, tableAlias4, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L co4(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return co(classMapping4, property, value, tableAlias4, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L nco4(SerializableFunction<E4, String> name, String value, MatchStrategy matchStrategy) {
        return nco(classMapping4, name, value, tableAlias4, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L nco4(SerializableFunction<E4, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nco(classMapping4, name, value, tableAlias4, matchStrategy, ignoreStrategy);
    }

    @Override
    public L nco4(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return nco(classMapping4, property, value, tableAlias4, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L nco4(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nco(classMapping4, property, value, tableAlias4, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L ge4(SerializableFunction<E4, N> name, N value) {
        return ge(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <N extends Number> L ge4(SerializableFunction<E4, N> name, N value, Predicate<N> ignoreStrategy) {
        return ge(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public <E extends Enum<E>> L ge4(SerializableFunction<E4, E> name, E value) {
        return ge(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <E extends Enum<E>> L ge4(SerializableFunction<E4, E> name, E value, Predicate<E> ignoreStrategy) {
        return ge(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L ge4(SerializableFunction<E4, String> name, String value, MatchStrategy matchStrategy) {
        return ge(classMapping4, name, value, tableAlias4, matchStrategy, getIgnoreStrategy());
    }

    @Override
    public L ge4(SerializableFunction<E4, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ge(classMapping4, name, value, tableAlias4, matchStrategy, ignoreStrategy);
    }

    @Override
    public <E extends Enum<E>> L ge4(SerializableEnumSupplier<E> property, E value) {
        return ge(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <E extends Enum<E>> L ge4(SerializableEnumSupplier<E> property, E value, Predicate<E> ignoreStrategy) {
        return ge(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L ge4(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return ge(classMapping4, property, matchStrategy, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L ge4(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ge(classMapping4, property, matchStrategy, tableAlias4, ignoreStrategy);
    }

    @Override
    public <D extends Date> L ge4(SerializableFunction<E4, D> name, D value) {
        return ge(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <D extends Date> L ge4(SerializableFunction<E4, D> name, D value, Predicate<D> ignoreStrategy) {
        return ge(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L ge4(SerializableFunction<E4, LocalTime> name, LocalTime value) {
        return ge(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L ge4(SerializableFunction<E4, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ge(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L ge4(SerializableFunction<E4, LocalDate> name, LocalDate value) {
        return ge(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L ge4(SerializableFunction<E4, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ge(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L ge4(SerializableFunction<E4, LocalDateTime> name, LocalDateTime value) {
        return ge(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L ge4(SerializableFunction<E4, LocalDateTime> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return ge(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L ge4(SerializableFunction<E4, String> name, String value) {
        return ge(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L ge4(SerializableFunction<E4, String> name, String value, Predicate<String> ignoreStrategy) {
        return ge(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L ge4(SerializableToIntFunction<E4> name, int value) {
        return ge(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L ge4(SerializableToIntFunction<E4> name, int value, IntPredicate ignoreStrategy) {
        return ge(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L ge4(SerializableToLongFunction<E4> name, long value) {
        return ge(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L ge4(SerializableToLongFunction<E4> name, long value, LongPredicate ignoreStrategy) {
        return ge(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L ge4(SerializableToDoubleFunction<E4> name, double value) {
        return ge(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L ge4(SerializableToDoubleFunction<E4> name, double value, DoublePredicate ignoreStrategy) {
        return ge(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    @Override
    public <D extends Date> L ge4(SerializableDateSupplier<D> property, D value) {
        return ge(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <D extends Date> L ge4(SerializableDateSupplier<D> property, D value, Predicate<D> ignoreStrategy) {
        return ge(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public <N extends Number> L ge4(SerializableNumberSupplier<N> property, N value) {
        return ge(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <N extends Number> L ge4(SerializableNumberSupplier<N> property, N value, Predicate<N> ignoreStrategy) {
        return ge(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L ge4(SerializableLocalDateSupplier property, LocalDate value) {
        return ge(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L ge4(SerializableLocalDateSupplier property, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ge(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L ge4(SerializableLocalTimeSupplier property, LocalTime value) {
        return ge(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L ge4(SerializableLocalTimeSupplier property, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ge(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L ge4(SerializableLocalDateTimeSupplier property, LocalDateTime value) {
        return ge(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L ge4(SerializableLocalDateTimeSupplier property, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return ge(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L ge4(SerializableStringSupplier property, String value) {
        return ge(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L ge4(SerializableStringSupplier property, String value, Predicate<String> ignoreStrategy) {
        return ge(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L ge4(SerializableIntSupplier property, int value) {
        return ge(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L ge4(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy) {
        return ge(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L ge4(SerializableLongSupplier property, long value) {
        return ge(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L ge4(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy) {
        return ge(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L ge4(SerializableDoubleSupplier property, double value) {
        return ge(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L ge4(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy) {
        return ge(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L gt4(SerializableFunction<E4, N> name, N value) {
        return gt(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <N extends Number> L gt4(SerializableFunction<E4, N> name, N value, Predicate<N> ignoreStrategy) {
        return gt(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public <E extends Enum<E>> L gt4(SerializableFunction<E4, E> name, E value) {
        return gt(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <E extends Enum<E>> L gt4(SerializableFunction<E4, E> name, E value, Predicate<E> ignoreStrategy) {
        return gt(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L gt4(SerializableFunction<E4, String> name, String value, MatchStrategy matchStrategy) {
        return gt(classMapping4, name, value, matchStrategy, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L gt4(SerializableFunction<E4, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return gt(classMapping4, name, value, matchStrategy, tableAlias4, ignoreStrategy);
    }

    @Override
    public <D extends Date> L gt4(SerializableFunction<E4, D> name, D value) {
        return gt(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <D extends Date> L gt4(SerializableFunction<E4, D> name, D value, Predicate<D> ignoreStrategy) {
        return gt(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L gt4(SerializableFunction<E4, LocalTime> name, LocalTime value) {
        return gt(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L gt4(SerializableFunction<E4, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return gt(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L gt4(SerializableFunction<E4, LocalDate> name, LocalDate value) {
        return gt(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L gt4(SerializableFunction<E4, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return gt(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L gt4(SerializableFunction<E4, LocalDateTime> name, LocalDateTime value) {
        return gt(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L gt4(SerializableFunction<E4, LocalDateTime> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return gt(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L gt4(SerializableFunction<E4, String> name, String value) {
        return gt(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L gt4(SerializableFunction<E4, String> name, String value, Predicate<String> ignoreStrategy) {
        return gt(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L gt4(SerializableToIntFunction<E4> name, int value) {
        return gt(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L gt4(SerializableToIntFunction<E4> name, int value, IntPredicate ignoreStrategy) {
        return gt(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L gt4(SerializableToLongFunction<E4> name, long value) {
        return gt(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L gt4(SerializableToLongFunction<E4> name, long value, LongPredicate ignoreStrategy) {
        return gt(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L gt4(SerializableToDoubleFunction<E4> name, double value) {
        return gt(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L gt4(SerializableToDoubleFunction<E4> name, double value, DoublePredicate ignoreStrategy) {
        return gt(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    @Override
    public <E extends Enum<E>> L gt4(SerializableEnumSupplier<E> property, E value) {
        return gt(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <E extends Enum<E>> L gt4(SerializableEnumSupplier<E> property, E value, Predicate<E> ignoreStrategy) {
        return gt(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L gt4(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return gt(classMapping4, property, value, matchStrategy, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L gt4(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return gt(classMapping4, property, value, matchStrategy, tableAlias4, ignoreStrategy);
    }

    @Override
    public <N extends Number> L gt4(SerializableNumberSupplier<N> property, N value) {
        return gt(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <N extends Number> L gt4(SerializableNumberSupplier<N> property, N value, Predicate<N> ignoreStrategy) {
        return gt(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public <D extends Date> L gt4(SerializableDateSupplier<D> property, D value) {
        return gt(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <D extends Date> L gt4(SerializableDateSupplier<D> property, D value, Predicate<D> ignoreStrategy) {
        return gt(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L gt4(SerializableLocalDateSupplier property, LocalDate value) {
        return gt(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L gt4(SerializableLocalDateSupplier property, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return gt(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L gt4(SerializableLocalTimeSupplier property, LocalTime value) {
        return gt(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L gt4(SerializableLocalTimeSupplier property, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return gt(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L gt4(SerializableLocalDateTimeSupplier property, LocalDateTime value) {
        return gt(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L gt4(SerializableLocalDateTimeSupplier property, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return gt(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L gt4(SerializableStringSupplier property, String value) {
        return gt(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L gt4(SerializableStringSupplier property, String value, Predicate<String> ignoreStrategy) {
        return gt(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L gt4(SerializableIntSupplier property, int value) {
        return gt(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L gt4(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy) {
        return gt(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L gt4(SerializableLongSupplier property, long value) {
        return gt(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L gt4(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy) {
        return gt(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L gt4(SerializableDoubleSupplier property, double value) {
        return gt(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L gt4(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy) {
        return gt(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L le4(SerializableFunction<E4, N> name, N value) {
        return le(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <N extends Number> L le4(SerializableFunction<E4, N> name, N value, Predicate<N> ignoreStrategy) {
        return le(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public <D extends Date> L le4(SerializableFunction<E4, D> name, D value) {
        return le(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <D extends Date> L le4(SerializableFunction<E4, D> name, D value, Predicate<D> ignoreStrategy) {
        return le(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L le4(SerializableFunction<E4, LocalTime> name, LocalTime value) {
        return le(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L le4(SerializableFunction<E4, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return le(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L le4(SerializableFunction<E4, LocalDate> name, LocalDate value) {
        return le(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L le4(SerializableFunction<E4, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return le(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L le4(SerializableFunction<E4, LocalDateTime> name, LocalDateTime value) {
        return le(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L le4(SerializableFunction<E4, LocalDateTime> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return le(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L le4(SerializableFunction<E4, String> name, String value) {
        return le(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L le4(SerializableFunction<E4, String> name, String value, Predicate<String> ignoreStrategy) {
        return le(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public <E extends Enum<E>> L le4(SerializableFunction<E4, E> name, E value) {
        return le(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <E extends Enum<E>> L le4(SerializableFunction<E4, E> name, E value, Predicate<E> ignoreStrategy) {
        return le(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L le4(SerializableFunction<E4, String> name, String value, MatchStrategy matchStrategy) {
        return le(classMapping4, name, value, matchStrategy, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L le4(SerializableFunction<E4, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return le(classMapping4, name, value, matchStrategy, tableAlias4, ignoreStrategy);
    }

    @Override
    public L le4(SerializableToIntFunction<E4> name, int value) {
        return le(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L le4(SerializableToIntFunction<E4> name, int value, IntPredicate ignoreStrategy) {
        return le(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L le4(SerializableToLongFunction<E4> name, long value) {
        return le(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L le4(SerializableToLongFunction<E4> name, long value, LongPredicate ignoreStrategy) {
        return le(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L le4(SerializableToDoubleFunction<E4> name, double value) {
        return le(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L le4(SerializableToDoubleFunction<E4> name, double value, DoublePredicate ignoreStrategy) {
        return le(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    @Override
    public <E extends Enum<E>> L le4(SerializableEnumSupplier<E> property, E value) {
        return le(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <E extends Enum<E>> L le4(SerializableEnumSupplier<E> property, E value, Predicate<E> ignoreStrategy) {
        return le(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L le4(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return le(classMapping4, property, matchStrategy, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L le4(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return le(classMapping4, property, matchStrategy, tableAlias4, ignoreStrategy);
    }

    @Override
    public <D extends Date> L le4(SerializableDateSupplier<D> property, D value) {
        return le(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <D extends Date> L le4(SerializableDateSupplier<D> property, D value, Predicate<D> ignoreStrategy) {
        return le(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public <N extends Number> L le4(SerializableNumberSupplier<N> property, N value) {
        return le(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <N extends Number> L le4(SerializableNumberSupplier<N> property, N value, Predicate<N> ignoreStrategy) {
        return le(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L le4(SerializableLocalDateSupplier property, LocalDate value) {
        return le(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L le4(SerializableLocalDateSupplier property, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return le(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L le4(SerializableLocalTimeSupplier property, LocalTime value) {
        return le(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L le4(SerializableLocalTimeSupplier property, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return le(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L le4(SerializableLocalDateTimeSupplier property, LocalDateTime value) {
        return le(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L le4(SerializableLocalDateTimeSupplier property, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return le(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L le4(SerializableStringSupplier property, String value) {
        return le(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L le4(SerializableStringSupplier property, String value, Predicate<String> ignoreStrategy) {
        return le(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L le4(SerializableIntSupplier property, int value) {
        return le(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L le4(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy) {
        return le(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L le4(SerializableLongSupplier property, long value) {
        return le(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L le4(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy) {
        return le(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L le4(SerializableDoubleSupplier property, double value) {
        return le(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L le4(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy) {
        return le(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <N extends Number> L lt4(SerializableFunction<E4, N> name, N value) {
        return lt(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <N extends Number> L lt4(SerializableFunction<E4, N> name, N value, Predicate<N> ignoreStrategy) {
        return lt(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public <E extends Enum<E>> L lt4(SerializableFunction<E4, E> name, E value) {
        return lt(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <E extends Enum<E>> L lt4(SerializableFunction<E4, E> name, E value, Predicate<E> ignoreStrategy) {
        return lt(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public <D extends Date> L lt4(SerializableFunction<E4, D> name, D value) {
        return lt(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <D extends Date> L lt4(SerializableFunction<E4, D> name, D value, Predicate<D> ignoreStrategy) {
        return lt(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L lt4(SerializableFunction<E4, LocalTime> name, LocalTime value) {
        return lt(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L lt4(SerializableFunction<E4, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return lt(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L lt4(SerializableFunction<E4, LocalDate> name, LocalDate value) {
        return lt(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L lt4(SerializableFunction<E4, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return lt(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L lt4(SerializableFunction<E4, LocalDateTime> name, LocalDateTime value) {
        return lt(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L lt4(SerializableFunction<E4, LocalDateTime> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return lt(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L lt4(SerializableFunction<E4, String> name, String value) {
        return lt(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L lt4(SerializableFunction<E4, String> name, String value, Predicate<String> ignoreStrategy) {
        return lt(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L lt4(SerializableFunction<E4, String> name, String value, MatchStrategy matchStrategy) {
        return lt(classMapping4, name, value, matchStrategy, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L lt4(SerializableFunction<E4, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return lt(classMapping4, name, value, matchStrategy, tableAlias4, ignoreStrategy);
    }

    @Override
    public L lt4(SerializableToIntFunction<E4> name, int value) {
        return lt(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L lt4(SerializableToIntFunction<E4> name, int value, IntPredicate ignoreStrategy) {
        return lt(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L lt4(SerializableToLongFunction<E4> name, long value) {
        return lt(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L lt4(SerializableToLongFunction<E4> name, long value, LongPredicate ignoreStrategy) {
        return lt(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L lt4(SerializableToDoubleFunction<E4> name, double value) {
        return lt(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L lt4(SerializableToDoubleFunction<E4> name, double value, DoublePredicate ignoreStrategy) {
        return lt(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    @Override
    public <E extends Enum<E>> L lt4(SerializableEnumSupplier<E> property, E value) {
        return lt(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <E extends Enum<E>> L lt4(SerializableEnumSupplier<E> property, E value, Predicate<E> ignoreStrategy) {
        return lt(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L lt4(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return lt(classMapping4, property, matchStrategy, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L lt4(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return lt(classMapping4, property, matchStrategy, tableAlias4, ignoreStrategy);
    }

    @Override
    public <R extends Number> L lt4(SerializableNumberSupplier<R> property, R value) {
        return lt(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <R extends Number> L lt4(SerializableNumberSupplier<R> property, R value, Predicate<R> ignoreStrategy) {
        return lt(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public <R extends Date> L lt4(SerializableDateSupplier<R> property, R value) {
        return lt(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <R extends Date> L lt4(SerializableDateSupplier<R> property, R value, Predicate<R> ignoreStrategy) {
        return lt(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L lt4(SerializableLocalDateSupplier property, LocalDate value) {
        return lt(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L lt4(SerializableLocalDateSupplier property, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return lt(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L lt4(SerializableLocalTimeSupplier property, LocalTime value) {
        return lt(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L lt4(SerializableLocalTimeSupplier property, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return lt(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L lt4(SerializableLocalDateTimeSupplier property, LocalDateTime value) {
        return lt(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L lt4(SerializableLocalDateTimeSupplier property, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return lt(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L lt4(SerializableStringSupplier property, String value) {
        return lt(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L lt4(SerializableStringSupplier property, String value, Predicate<String> ignoreStrategy) {
        return lt(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L lt4(SerializableIntSupplier property, int value) {
        return lt(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L lt4(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy) {
        return lt(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L lt4(SerializableLongSupplier property, long value) {
        return lt(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L lt4(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy) {
        return lt(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L lt4(SerializableDoubleSupplier property, double value) {
        return lt(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L lt4(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy) {
        return lt(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <R extends Serializable> L in4(SerializableFunction<E4, R> name, R value) {
        return in(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <R extends Serializable> L in4(SerializableFunction<E4, R> name, R value, Predicate<R> ignoreStrategy) {
        return in(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public <R extends Serializable> L in4(SerializableFunction<E4, R> name, @SuppressWarnings("unchecked") R... value) {
        return in(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <R extends Serializable> L in4(SerializableFunction<E4, R> name, R[] value, Predicate<R[]> ignoreStrategy) {
        return in(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public <R extends Serializable> L in4(SerializableFunction<E4, R> name, Collection<R> value) {
        return in(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <R extends Serializable> L in4(SerializableFunction<E4, R> name, Collection<R> value,
        Predicate<Collection<R>> ignoreStrategy) {
        return in(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L in4(SerializableToStringFunction<E4> name, String value, MatchStrategy matchStrategy) {
        return in(classMapping4, name, value, matchStrategy, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L in4(SerializableToStringFunction<E4> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return in(classMapping4, name, value, matchStrategy, tableAlias4, ignoreStrategy);
    }

    @Override
    public L in4(SerializableToStringFunction<E4> name, String[] value, MatchStrategy matchStrategy) {
        return in(classMapping4, name, value, matchStrategy, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L in4(SerializableToStringFunction<E4> name, String[] value, MatchStrategy matchStrategy,
        Predicate<String[]> ignoreStrategy) {
        return in(classMapping4, name, value, matchStrategy, tableAlias4, ignoreStrategy);
    }

    @Override
    public L in4(SerializableToIntFunction<E4> name, int value) {
        return in(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L in4(SerializableToIntFunction<E4> name, int value, IntPredicate ignoreStrategy) {
        return in(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L in4(SerializableToLongFunction<E4> name, long value) {
        return in(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L in4(SerializableToLongFunction<E4> name, long value, LongPredicate ignoreStrategy) {
        return in(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L in4(SerializableToDoubleFunction<E4> name, double value) {
        return in(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L in4(SerializableToDoubleFunction<E4> name, double value, DoublePredicate ignoreStrategy) {
        return in(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L in4(SerializableToIntFunction<E4> name, int... value) {
        return in(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L in4(SerializableToLongFunction<E4> name, long... value) {
        return in(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L in4(SerializableToDoubleFunction<E4> name, double... value) {
        return in(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L in4(SerializableToDoubleFunction<E4> name, double[] value, Predicate<double[]> ignoreStrategy) {
        return in(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L in4(SerializableToIntFunction<E4> name, int[] value, Predicate<int[]> ignoreStrategy) {
        return in(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L in4(SerializableToLongFunction<E4> name, long[] value, Predicate<long[]> ignoreStrategy) {
        return in(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L in4(SerializableSupplier<R> property, R value) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return in(classMapping4.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), value,
            tableAlias4, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L in4(SerializableSupplier<R> property, @SuppressWarnings("unchecked") R... value) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return in(classMapping4.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), value,
            tableAlias4, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L in4(SerializableSupplier<R> property, R value, Predicate<R> ignoreStrategy) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return in(classMapping4.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), value,
            tableAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L in4(SerializableSupplier<R> property, R[] value, Predicate<R[]> ignoreStrategy) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return in(classMapping4.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), value,
            tableAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in4(SerializableIntSupplier property, int value) {
        return in(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L in4(SerializableIntSupplier property, int... value) {
        return in(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in4(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy) {
        return in(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in4(SerializableIntSupplier property, int[] value, Predicate<int[]> ignoreStrategy) {
        return in(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in4(SerializableLongSupplier property, long value) {
        return in(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L in4(SerializableLongSupplier property, long... value) {
        return in(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in4(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy) {
        return in(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in4(SerializableLongSupplier property, long[] value, Predicate<long[]> ignoreStrategy) {
        return in(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in4(SerializableDoubleSupplier property, double value) {
        return in(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L in4(SerializableDoubleSupplier property, double... value) {
        return in(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in4(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy) {
        return in(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L in4(SerializableDoubleSupplier property, double[] value, Predicate<double[]> ignoreStrategy) {
        return in(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in4(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return in(classMapping4, property, value, matchStrategy, tableAlias4, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in4(SerializableStringSupplier property, String[] value, MatchStrategy matchStrategy) {
        return in(classMapping4, property, value, matchStrategy, tableAlias4, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in4(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return in(classMapping4, property, value, matchStrategy, tableAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in4(SerializableStringSupplier property, String[] value, MatchStrategy matchStrategy,
        Predicate<String[]> ignoreStrategy) {
        return in(classMapping4, property, value, matchStrategy, tableAlias4, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni4(SerializableFunction<E4, R> name, R value) {
        return ni(classMapping4.getPropertyMapping(getPropertyName(name)), value, tableAlias4, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni4(SerializableFunction<E4, R> name, R value, Predicate<R> ignoreStrategy) {
        return ni(classMapping4.getPropertyMapping(getPropertyName(name)), value, tableAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni4(SerializableFunction<E4, R> name, @SuppressWarnings("unchecked") R... value) {
        return ni(classMapping4.getPropertyMapping(getPropertyName(name)), value, tableAlias4, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni4(SerializableFunction<E4, R> name, R[] value, Predicate<R[]> ignoreStrategy) {
        return ni(classMapping4.getPropertyMapping(getPropertyName(name)), value, tableAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni4(SerializableFunction<E4, R> name, Collection<R> value) {
        return ni(classMapping4.getPropertyMapping(getPropertyName(name)), value, tableAlias4,
            getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni4(SerializableFunction<E4, R> name, Collection<R> value,
        Predicate<Collection<R>> ignoreStrategy) {
        return ni(classMapping4.getPropertyMapping(getPropertyName(name)), value, tableAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni4(SerializableToIntFunction<E4> name, int value) {
        return ni(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni4(SerializableToIntFunction<E4> name, int value, IntPredicate ignoreStrategy) {
        return ni(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni4(SerializableToLongFunction<E4> name, long value) {
        return ni(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni4(SerializableToLongFunction<E4> name, long value, LongPredicate ignoreStrategy) {
        return ni(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni4(SerializableToDoubleFunction<E4> name, double value) {
        return ni(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni4(SerializableToDoubleFunction<E4> name, double value, DoublePredicate ignoreStrategy) {
        return ni(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni4(SerializableToIntFunction<E4> name, int... value) {
        return ni(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni4(SerializableToLongFunction<E4> name, long... value) {
        return ni(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni4(SerializableToDoubleFunction<E4> name, double... value) {
        return ni(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni4(SerializableToIntFunction<E4> name, int[] value, Predicate<int[]> ignoreStrategy) {
        return ni(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni4(SerializableToLongFunction<E4> name, long[] value, Predicate<long[]> ignoreStrategy) {
        return ni(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni4(SerializableToDoubleFunction<E4> name, double[] value, Predicate<double[]> ignoreStrategy) {
        return ni(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni4(SerializableSupplier<R> property, R value) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ni(classMapping4.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), value,
            tableAlias4, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni4(SerializableSupplier<R> property, @SuppressWarnings("unchecked") R... value) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ni(classMapping4.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), value,
            tableAlias4, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni4(SerializableSupplier<R> property, R value, Predicate<R> ignoreStrategy) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ni(classMapping4.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), value,
            tableAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni4(SerializableSupplier<R> property, R[] value, Predicate<R[]> ignoreStrategy) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ni(classMapping4.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), value,
            tableAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni4(SerializableIntSupplier property, int value) {
        return ni(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L ni4(SerializableIntSupplier name, int... value) {
        return ni(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni4(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy) {
        return ni(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L ni4(SerializableIntSupplier name, int[] value, Predicate<int[]> ignoreStrategy) {
        return ni(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni4(SerializableLongSupplier property, long value) {
        return ni(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L ni4(SerializableLongSupplier property, long... value) {
        return ni(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni4(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy) {
        return ni(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L ni4(SerializableLongSupplier name, long[] value, Predicate<long[]> ignoreStrategy) {
        return ni(classMapping4, name, value, tableAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni4(SerializableDoubleSupplier property, double value) {
        return ni(classMapping4, property, value, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L ni4(SerializableDoubleSupplier name, double... value) {
        return ni(classMapping4, name, value, tableAlias4, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni4(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy) {
        return ni(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    @Override
    public L ni4(SerializableDoubleSupplier property, double[] value, Predicate<double[]> ignoreStrategy) {
        return ni(classMapping4, property, value, tableAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni4(SerializableToStringFunction<E4> name, String value, MatchStrategy matchStrategy) {
        return ni(classMapping4, name, value, matchStrategy, tableAlias4, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni4(SerializableToStringFunction<E4> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ni(classMapping4, name, value, matchStrategy, tableAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni4(SerializableToStringFunction<E4> name, String[] value, MatchStrategy matchStrategy) {
        return ni(classMapping4, name, value, matchStrategy, tableAlias4, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni4(SerializableToStringFunction<E4> name, String[] value, MatchStrategy matchStrategy,
        Predicate<String[]> ignoreStrategy) {
        return ni(classMapping4, name, value, matchStrategy, tableAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni4(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return ni(classMapping4, property, value, matchStrategy, tableAlias4, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni4(SerializableStringSupplier property, String[] value, MatchStrategy matchStrategy) {
        return ni(classMapping4, property, value, matchStrategy, tableAlias4, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni4(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ni(classMapping4, property, value, matchStrategy, tableAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni4(SerializableStringSupplier property, String[] value, MatchStrategy matchStrategy,
        Predicate<String[]> ignoreStrategy) {
        return ni(classMapping4, property, value, matchStrategy, tableAlias4, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L ba4(SerializableToIntFunction<E4> name, int min, int max) {
        return ba(classMapping4, name, min, max, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L ba4(SerializableToIntFunction<E4> name, int min, int max, BiPredicate<Integer, Integer> ignoreStrategy) {
        return ba(classMapping4, name, min, max, tableAlias4, ignoreStrategy);
    }

    @Override
    public L ba4(SerializableToLongFunction<E4> name, long min, long max) {
        return ba(classMapping4, name, min, max, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L ba4(SerializableToLongFunction<E4> name, long min, long max, BiPredicate<Long, Long> ignoreStrategy) {
        return ba(classMapping4, name, min, max, tableAlias4, ignoreStrategy);
    }

    @Override
    public L ba4(SerializableToDoubleFunction<E4> name, double min, double max) {
        return ba(classMapping4, name, min, max, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L ba4(SerializableToDoubleFunction<E4> name, double min, double max,
        BiPredicate<Double, Double> ignoreStrategy) {
        return ba(classMapping4, name, min, max, tableAlias4, ignoreStrategy);
    }

    @Override
    public <N extends Number> L ba4(SerializableToNumberFunction<E4, N> name, N min, N max) {
        return ba(classMapping4, name, min, max, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <N extends Number> L ba4(SerializableToNumberFunction<E4, N> name, N min, N max,
        BiPredicate<N, N> ignoreStrategy) {
        return ba(classMapping4, name, min, max, tableAlias4, ignoreStrategy);
    }

    @Override
    public <D extends Date> L ba4(SerializableToDateFunction<E4, D> name, D min, D max) {
        return ba(classMapping4, name, min, max, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <D extends Date> L ba4(SerializableToDateFunction<E4, D> name, D min, D max,
        BiPredicate<D, D> ignoreStrategy) {
        return ba(classMapping4, name, min, max, tableAlias4, ignoreStrategy);
    }

    @Override
    public <E extends Enum<E>> L ba4(SerializableToEnumFunction<E4, E> name, E min, E max) {
        return ba(classMapping4, name, min, max, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <E extends Enum<E>> L ba4(SerializableToEnumFunction<E4, E> name, E min, E max,
        BiPredicate<E, E> ignoreStrategy) {
        return ba(classMapping4, name, min, max, tableAlias4, ignoreStrategy);
    }

    @Override
    public L ba4(SerializableToLocalTimeFunction<E4> name, LocalTime min, LocalTime max) {
        return ba(classMapping4, name, min, max, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L ba4(SerializableToLocalTimeFunction<E4> name, LocalTime min, LocalTime max,
        BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return ba(classMapping4, name, min, max, tableAlias4, ignoreStrategy);
    }

    @Override
    public L ba4(SerializableToLocalDateFunction<E4> name, LocalDate min, LocalDate max) {
        return ba(classMapping4, name, min, max, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L ba4(SerializableToLocalDateFunction<E4> name, LocalDate min, LocalDate max,
        BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return ba(classMapping4, name, min, max, tableAlias4, ignoreStrategy);
    }

    @Override
    public L ba4(SerializableToLocalDateTimeFunction<E4> name, LocalDateTime min, LocalDateTime max) {
        return ba(classMapping4, name, min, max, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L ba4(SerializableToLocalDateTimeFunction<E4> name, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return ba(classMapping4, name, min, max, tableAlias4, ignoreStrategy);
    }

    @Override
    public L ba4(SerializableToStringFunction<E4> name, String min, String max) {
        return ba(classMapping4, name, min, max, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L ba4(SerializableToStringFunction<E4> name, String min, String max,
        BiPredicate<String, String> ignoreStrategy) {
        return ba(classMapping4, name, min, max, tableAlias4, ignoreStrategy);
    }

    // --------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ba4(SerializableNumberSupplier<N> property, N min, N max) {
        return ba(classMapping4, property, min, max, tableAlias4, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ba4(SerializableNumberSupplier<N> name, N min, N max,
        BiPredicate<N, N> ignoreStrategy) {
        return ba(classMapping4, name, min, max, tableAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ba4(SerializableDateSupplier<D> property, D min, D max) {
        return ba(classMapping4, property, min, max, tableAlias4, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ba4(SerializableDateSupplier<D> property, D min, D max,
        BiPredicate<D, D> ignoreStrategy) {
        return ba(classMapping4, property, min, max, tableAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba4(SerializableLocalTimeSupplier property, LocalTime min, LocalTime max) {
        return ba(classMapping4, property, min, max, tableAlias4, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba4(SerializableLocalTimeSupplier property, LocalTime min, LocalTime max,
        BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return ba(classMapping4, property, min, max, tableAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba4(SerializableLocalDateSupplier property, LocalDate min, LocalDate max) {
        return ba(classMapping4, property, min, max, tableAlias4, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba4(SerializableLocalDateSupplier property, LocalDate min, LocalDate max,
        BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return ba(classMapping4, property, min, max, tableAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba4(SerializableLocalDateTimeSupplier property, LocalDateTime min, LocalDateTime max) {
        return ba(classMapping4, property, min, max, tableAlias4, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba4(SerializableLocalDateTimeSupplier property, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return ba(classMapping4, property, min, max, tableAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba4(SerializableStringSupplier property, String min, String max) {
        return ba(classMapping4, property, min, max, tableAlias4, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba4(SerializableStringSupplier property, String min, String max,
        BiPredicate<String, String> ignoreStrategy) {
        return ba(classMapping4, property, min, max, tableAlias4, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public L nba4(SerializableToIntFunction<E4> name, int min, int max) {
        return nba(classMapping4, name, min, max, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L nba4(SerializableToIntFunction<E4> name, int min, int max, BiPredicate<Integer, Integer> ignoreStrategy) {
        return nba(classMapping4, name, min, max, tableAlias4, ignoreStrategy);
    }

    @Override
    public L nba4(SerializableToLongFunction<E4> name, long min, long max) {
        return nba(classMapping4, name, min, max, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L nba4(SerializableToLongFunction<E4> name, long min, long max, BiPredicate<Long, Long> ignoreStrategy) {
        return nba(classMapping4, name, min, max, tableAlias4, ignoreStrategy);
    }

    @Override
    public L nba4(SerializableToDoubleFunction<E4> name, double min, double max) {
        return nba(classMapping4, name, min, max, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L nba4(SerializableToDoubleFunction<E4> name, double min, double max,
        BiPredicate<Double, Double> ignoreStrategy) {
        return nba(classMapping4, name, min, max, tableAlias4, ignoreStrategy);
    }

    @Override
    public <N extends Number> L nba4(SerializableToNumberFunction<E4, N> name, N min, N max) {
        return nba(classMapping4, name, min, max, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <N extends Number> L nba4(SerializableToNumberFunction<E4, N> name, N min, N max,
        BiPredicate<N, N> ignoreStrategy) {
        return nba(classMapping4, name, min, max, tableAlias4, ignoreStrategy);
    }

    @Override
    public <D extends Date> L nba4(SerializableToDateFunction<E4, D> name, D min, D max) {
        return nba(classMapping4, name, min, max, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <D extends Date> L nba4(SerializableToDateFunction<E4, D> name, D min, D max,
        BiPredicate<D, D> ignoreStrategy) {
        return nba(classMapping4, name, min, max, tableAlias4, ignoreStrategy);
    }

    @Override
    public <E extends Enum<E>> L nba4(SerializableToEnumFunction<E4, E> name, E min, E max) {
        return nba(classMapping4, name, min, max, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public <E extends Enum<E>> L nba4(SerializableToEnumFunction<E4, E> name, E min, E max,
        BiPredicate<E, E> ignoreStrategy) {
        return nba(classMapping4, name, min, max, tableAlias4, ignoreStrategy);
    }

    @Override
    public L nba4(SerializableToLocalTimeFunction<E4> name, LocalTime min, LocalTime max) {
        return nba(classMapping4, name, min, max, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L nba4(SerializableToLocalTimeFunction<E4> name, LocalTime min, LocalTime max,
        BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return nba(classMapping4, name, min, max, tableAlias4, ignoreStrategy);
    }

    @Override
    public L nba4(SerializableToLocalDateFunction<E4> name, LocalDate min, LocalDate max) {
        return nba(classMapping4, name, min, max, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L nba4(SerializableToLocalDateFunction<E4> name, LocalDate min, LocalDate max,
        BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return nba(classMapping4, name, min, max, tableAlias4, ignoreStrategy);
    }

    @Override
    public L nba4(SerializableToLocalDateTimeFunction<E4> name, LocalDateTime min, LocalDateTime max) {
        return nba(classMapping4, name, min, max, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L nba4(SerializableToLocalDateTimeFunction<E4> name, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return nba(classMapping4, name, min, max, tableAlias4, ignoreStrategy);
    }

    @Override
    public L nba4(SerializableToStringFunction<E4> name, String min, String max) {
        return nba(classMapping4, name, min, max, tableAlias4, getIgnoreStrategy());
    }

    @Override
    public L nba4(SerializableToStringFunction<E4> name, String min, String max,
        BiPredicate<String, String> ignoreStrategy) {
        return nba(classMapping4, name, min, max, tableAlias4, ignoreStrategy);
    }

    // --------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L nba4(SerializableNumberSupplier<N> property, N min, N max) {
        return nba(classMapping4, property, min, max, tableAlias4, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L nba4(SerializableNumberSupplier<N> name, N min, N max,
        BiPredicate<N, N> ignoreStrategy) {
        return nba(classMapping4, name, min, max, tableAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L nba4(SerializableDateSupplier<D> property, D min, D max) {
        return nba(classMapping4, property, min, max, tableAlias4, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L nba4(SerializableDateSupplier<D> property, D min, D max,
        BiPredicate<D, D> ignoreStrategy) {
        return nba(classMapping4, property, min, max, tableAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba4(SerializableLocalTimeSupplier property, LocalTime min, LocalTime max) {
        return nba(classMapping4, property, min, max, tableAlias4, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba4(SerializableLocalTimeSupplier property, LocalTime min, LocalTime max,
        BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return nba(classMapping4, property, min, max, tableAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba4(SerializableLocalDateSupplier property, LocalDate min, LocalDate max) {
        return nba(classMapping4, property, min, max, tableAlias4, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba4(SerializableLocalDateSupplier property, LocalDate min, LocalDate max,
        BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return nba(classMapping4, property, min, max, tableAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba4(SerializableLocalDateTimeSupplier property, LocalDateTime min, LocalDateTime max) {
        return nba(classMapping4, property, min, max, tableAlias4, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba4(SerializableLocalDateTimeSupplier property, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return nba(classMapping4, property, min, max, tableAlias4, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba4(SerializableStringSupplier property, String min, String max) {
        return nba(classMapping4, property, min, max, tableAlias4, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba4(SerializableStringSupplier property, String min, String max,
        BiPredicate<String, String> ignoreStrategy) {
        return nba(classMapping4, property, min, max, tableAlias4, ignoreStrategy);
    }

    // ****************************************************************************************************************

    @Override
    public <R> L inn4(SerializableFunction<E4, R> name, Boolean value) {
        return inn(classMapping4, name, value, tableAlias4);
    }

    @Override
    public <R> L inn4(SerializableSupplier<R> name, Boolean value) {
        return inn(classMapping4, name, value, tableAlias4);
    }

    @Override
    public <R> L isn4(SerializableFunction<E4, R> name, Boolean value) {
        return isn(classMapping4, name, value, tableAlias4);
    }

    @Override
    public <R> L isn4(SerializableSupplier<R> name, Boolean value) {
        return isn(classMapping4, name, value, tableAlias4);
    }

    // ****************************************************************************************************************
    // property
    // ****************************************************************************************************************
    @Override
    @SuppressWarnings("unchecked")
    public L property(FourArgusFunction<EntityPropertyExpression<E1, ?, ?>, EntityPropertyExpression<E2, ?, ?>,
        EntityPropertyExpression<E3, ?, ?>, EntityPropertyExpression<E4, ?, ?>,
        LogicExpression<?, ?>> entitiesPropertyFunction) {
        return (L) entitiesPropertyFunction.apply(
            new EntityPropertyOnlyExpressionImpl<>(0, this, factory, entityRelation),
            new EntityPropertyOnlyExpressionImpl<>(1, this, factory, entityRelation),
            new EntityPropertyOnlyExpressionImpl<>(2, this, factory, entityRelation),
            new EntityPropertyOnlyExpressionImpl<>(3, this, factory, entityRelation));
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
        return 3;
    }
}
