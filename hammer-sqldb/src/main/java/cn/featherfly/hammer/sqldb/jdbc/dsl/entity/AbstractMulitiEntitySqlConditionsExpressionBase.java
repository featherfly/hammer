
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.db.FieldValueOperator;
import cn.featherfly.common.db.SqlUtils;
import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.exception.NotImplementedException;
import cn.featherfly.common.function.CharPredicate;
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
import cn.featherfly.common.function.serializable.SerializableToCollectionFunction;
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
import cn.featherfly.common.lang.LambdaUtils.SerializedLambdaInfo;
import cn.featherfly.common.operator.ComparisonOperator;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.Execution;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.hammer.config.dsl.ConditionConfig;
import cn.featherfly.hammer.expression.condition.ConditionConfigureExpression;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.NativeStringConditionExpression;
import cn.featherfly.hammer.expression.condition.ParamedExpression;
import cn.featherfly.hammer.expression.entity.condition.EntityPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ba.EntityBetweenExpression;
import cn.featherfly.hammer.expression.entity.condition.co.EntityContainsExpression;
import cn.featherfly.hammer.expression.entity.condition.eq.EntityEqualsExpression;
import cn.featherfly.hammer.expression.entity.condition.ew.EntityEndWithExpression;
import cn.featherfly.hammer.expression.entity.condition.ge.EntityGreatEqualsExpression;
import cn.featherfly.hammer.expression.entity.condition.gt.EntityGreatThanExpression;
import cn.featherfly.hammer.expression.entity.condition.in.EntityInExpression;
import cn.featherfly.hammer.expression.entity.condition.inn.EntityIsNotNullExpression;
import cn.featherfly.hammer.expression.entity.condition.isn.EntityIsNullExpression;
import cn.featherfly.hammer.expression.entity.condition.le.EntityLessEqualsExpression;
import cn.featherfly.hammer.expression.entity.condition.lk.EntityLikeExpression;
import cn.featherfly.hammer.expression.entity.condition.lt.EntityLessThanExpression;
import cn.featherfly.hammer.expression.entity.condition.nba.EntityNotBetweenExpression;
import cn.featherfly.hammer.expression.entity.condition.nco.EntityNotContainsExpression;
import cn.featherfly.hammer.expression.entity.condition.ne.EntityNotEqualsExpression;
import cn.featherfly.hammer.expression.entity.condition.newv.EntityNotEndWithExpression;
import cn.featherfly.hammer.expression.entity.condition.ni.EntityNotInExpression;
import cn.featherfly.hammer.expression.entity.condition.nl.EntityNotLikeExpression;
import cn.featherfly.hammer.expression.entity.condition.nsw.EntityNotStartWithExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityDatePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityDoublePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityEnumPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityIntPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityLocalDatePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityLocalDateTimePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityLocalTimePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityLongPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityNumberPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityStringPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityTypePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.sw.EntityStartWithExpression;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlRelation.EntityRelationMapping;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.AbstractMulitiEntityConditionExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.EntityDatePropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.EntityDoublePropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.EntityEnumPropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.EntityIntPropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.EntityLocalDatePropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.EntityLocalDateTimePropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.EntityLocalTimePropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.EntityLongPropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.EntityNumberPropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.EntityStringPropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.EntityTypePropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.sql.dml.SqlConditionExpressionBuilder;

/**
 * abstract muliti entity sql condition expression base.
 *
 * @author zhongj
 * @param <T> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
@SuppressWarnings("unchecked")
public abstract class AbstractMulitiEntitySqlConditionsExpressionBase<T, ER extends EntitySqlRelation<ER, B>,
    B extends SqlBuilder, C extends ConditionExpression, L extends LogicExpression<C, L>,
    C2 extends ConditionConfig<C2>> extends AbstractMulitiEntityConditionExpression<C, L, C2>
    implements EntityBetweenExpression<T, C, L>, EntityNotBetweenExpression<T, C, L> //
    , EntityContainsExpression<T, C, L>, EntityNotContainsExpression<T, C, L>//
    , EntityEndWithExpression<T, C, L>, EntityNotEndWithExpression<T, C, L> //
    , EntityEqualsExpression<T, C, L>, EntityIsNotNullExpression<T, C, L>//
    , EntityGreatEqualsExpression<T, C, L>, EntityGreatThanExpression<T, C, L> //
    , EntityInExpression<T, C, L>, EntityNotInExpression<T, C, L>//
    , EntityIsNullExpression<T, C, L>, EntityNotEqualsExpression<T, C, L> //
    , EntityLessEqualsExpression<T, C, L>, EntityLessThanExpression<T, C, L> //
    , EntityStartWithExpression<T, C, L>, EntityNotStartWithExpression<T, C, L>//
    , EntityLikeExpression<T, C, L>, EntityNotLikeExpression<T, C, L>//
    , EntityPropertyExpression<T, C, L>, NativeStringConditionExpression<C, L> //
    , ConditionConfigureExpression<C, C2> {

    /** The factory. */
    protected JdbcMappingFactory factory;

    /** The alias manager. */
    protected AliasManager aliasManager;

    /** The class mapping. */
    protected JdbcClassMapping<T> classMapping;

    /** The table alias. */
    protected String tableAlias;

    /** The entity sql relation. */
    protected ER entityRelation;

    protected int index;

    /**
     * Instantiates a new abstract sql condition group expression.
     *
     * @param parent         parent group
     * @param factory        the factory
     * @param entityRelation the entity relation
     */
    protected AbstractMulitiEntitySqlConditionsExpressionBase(L parent, JdbcMappingFactory factory, ER entityRelation) {
        super(parent, entityRelation.getJdbc().getDialect(), entityRelation.getConfig());
        this.factory = factory;
        EntityRelationMapping<
            T> erm = (EntityRelationMapping<T>) entityRelation.getEntityRelationMappingTuple().getOrNull0();
        tableAlias = erm.getTableAlias();
        classMapping = erm.getClassMapping();
        aliasManager = entityRelation.getAliasManager();
        this.entityRelation = entityRelation;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAlias(int index) {
        return entityRelation.getEntityRelationMapping(index).getTableAlias();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <M extends ClassMapping<E, P>, E, P extends PropertyMapping<P>> M getClassMapping(int index) {
        return (M) entityRelation.getEntityRelationMapping(index).getClassMapping();
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L eq(SerializableFunction<T, R> name, R value) {
        return eq(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L eq(SerializableFunction<T, R> name, R value, Predicate<R> ignoreStrategy) {
        return eq(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableToCharFunction<T> name, char value) {
        return eq(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableToCharFunction<T> name, char value, CharPredicate ignoreStrategy) {
        return eq(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableToIntFunction<T> name, int value) {
        return eq(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableToIntFunction<T> name, int value, IntPredicate ignoreStrategy) {
        return eq(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableToLongFunction<T> name, long value) {
        return eq(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableToLongFunction<T> name, long value, LongPredicate ignoreStrategy) {
        return eq(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableToDoubleFunction<T> name, double value) {
        return eq(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableToDoubleFunction<T> name, double value, DoublePredicate ignoreStrategy) {
        return eq(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L eq(SerializableToNumberFunction<T, N> name, N value) {
        return eq(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L eq(SerializableToNumberFunction<T, N> name, N value, Predicate<N> ignoreStrategy) {
        return eq(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L eq(SerializableToDateFunction<T, D> name, D value) {
        return eq(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L eq(SerializableToDateFunction<T, D> name, D value, Predicate<D> ignoreStrategy) {
        return eq(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L eq(SerializableToEnumFunction<T, E> name, E value) {
        return eq(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L eq(SerializableToEnumFunction<T, E> name, E value, Predicate<E> ignoreStrategy) {
        return eq(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableToLocalDateFunction<T> name, LocalDate value) {
        return eq(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableToLocalDateFunction<T> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return eq(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value) {
        return eq(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return eq(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableToLocalTimeFunction<T> name, LocalTime value) {
        return eq(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableToLocalTimeFunction<T> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return eq(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy) {
        return eq(classMapping, name, value, tableAlias, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return eq(classMapping, name, value, tableAlias, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L eq(SerializableSupplier<R> property) {
        return eq(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L eq(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return eq(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableBooleanSupplier propertyValue) {
        return eq(classMapping, propertyValue, propertyValue.getAsBoolean(), tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableBoolSupplier propertyValue) {
        return eq(classMapping, propertyValue, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableBoolSupplier propertyValue, Predicate<Boolean> ignoreStrategy) {
        return eq(classMapping, propertyValue, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableCharSupplier property) {
        return eq(classMapping, property, property.getAsChar(), tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableCharSupplier property, CharPredicate ignoreStrategy) {
        return eq(classMapping, property, property.getAsChar(), tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableIntSupplier property) {
        return eq(classMapping, property, property.getAsInt(), tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return eq(classMapping, property, property.getAsInt(), tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableDoubleSupplier property) {
        return eq(classMapping, property, property.getAsDouble(), tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return eq(classMapping, property, property.getAsDouble(), tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableLongSupplier property) {
        return eq(classMapping, property, property.getAsLong(), tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return eq(classMapping, property, property.getAsLong(), tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L eq(SerializableNumberSupplier<R> property) {
        return eq(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L eq(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return eq(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L eq(SerializableDateSupplier<R> property) {
        return eq(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L eq(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return eq(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L eq(SerializableEnumSupplier<E> property) {
        return eq(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L eq(SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy) {
        return eq(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableLocalDateSupplier property) {
        return eq(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return eq(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableLocalDateTimeSupplier property) {
        return eq(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return eq(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableLocalTimeSupplier property) {
        return eq(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return eq(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return eq(classMapping, property, tableAlias, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return eq(classMapping, property, tableAlias, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ne(SerializableFunction<T, R> name, R value) {
        return ne(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ne(SerializableFunction<T, R> name, R value, Predicate<R> ignoreStrategy) {
        return ne(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableBooleanSupplier propertyValue) {
        return ne(classMapping, propertyValue, propertyValue.getAsBoolean(), tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableBoolSupplier propertyValue) {
        return ne(classMapping, propertyValue, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableBoolSupplier propertyValue, Predicate<Boolean> ignoreStrategy) {
        return ne(classMapping, propertyValue, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableToIntFunction<T> name, int value) {
        return ne(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableToIntFunction<T> name, int value, IntPredicate ignoreStrategy) {
        return ne(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableToDoubleFunction<T> name, double value) {
        return ne(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableToLongFunction<T> name, long value) {
        return ne(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableToLongFunction<T> name, long value, LongPredicate ignoreStrategy) {
        return ne(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ne(SerializableToNumberFunction<T, N> name, N value) {
        return ne(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ne(SerializableToNumberFunction<T, N> name, N value, Predicate<N> ignoreStrategy) {
        return ne(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ne(SerializableToEnumFunction<T, E> name, E value) {
        return ne(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ne(SerializableToEnumFunction<T, E> name, E value, Predicate<E> ignoreStrategy) {
        return ne(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ne(SerializableToDateFunction<T, D> name, D value) {
        return ne(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ne(SerializableToDateFunction<T, D> name, D value, Predicate<D> ignoreStrategy) {
        return ne(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableToDoubleFunction<T> name, double value, DoublePredicate ignoreStrategy) {
        return ne(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableToLocalDateFunction<T> name, LocalDate value) {
        return ne(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableToLocalDateFunction<T> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ne(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value) {
        return ne(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return ne(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableToLocalTimeFunction<T> name, LocalTime value) {
        return ne(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableToLocalTimeFunction<T> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ne(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy) {
        return ne(classMapping, name, value, tableAlias, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ne(classMapping, name, value, tableAlias, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ne(SerializableSupplier<R> property) {
        return ne(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ne(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ne(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableCharSupplier property) {
        return ne(classMapping, property, property.get(), tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableCharSupplier property, CharPredicate ignoreStrategy) {
        return ne(classMapping, property, property.get(), tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableIntSupplier property) {
        return ne(classMapping, property, property.getAsInt(), tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return ne(classMapping, property, property.getAsInt(), tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableLongSupplier property) {
        return ne(classMapping, property, property.getAsLong(), tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return ne(classMapping, property, property.getAsLong(), tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableDoubleSupplier property) {
        return ne(classMapping, property, property.getAsDouble(), tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return ne(classMapping, property, property.getAsDouble(), tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L ne(SerializableNumberSupplier<R> property) {
        return ne(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L ne(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ne(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ne(SerializableEnumSupplier<E> property) {
        return ne(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ne(SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy) {
        return ne(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L ne(SerializableDateSupplier<R> property) {
        return ne(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L ne(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ne(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableLocalDateSupplier property) {
        return ne(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return ne(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableLocalDateTimeSupplier property) {
        return ne(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return ne(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableLocalTimeSupplier property) {
        return ne(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return ne(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return ne(classMapping, property, tableAlias, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ne(classMapping, property, tableAlias, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(SerializableFunction<T, String> name, String value, MatchStrategy matchStrategy) {
        return lk(classMapping, name, value, tableAlias, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(SerializableFunction<T, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return lk(classMapping, name, value, tableAlias, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return lk(classMapping, property, tableAlias, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return lk(classMapping, property, tableAlias, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl(SerializableFunction<T, String> name, String value, MatchStrategy matchStrategy) {
        return nl(classMapping, name, value, tableAlias, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl(SerializableFunction<T, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nl(classMapping, name, value, tableAlias, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return nl(classMapping, property, tableAlias, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nl(classMapping, property, tableAlias, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(SerializableFunction<T, String> name, String value, MatchStrategy matchStrategy) {
        return sw(classMapping, name, value, tableAlias, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(SerializableFunction<T, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return sw(classMapping, name, value, tableAlias, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return sw(classMapping, property, tableAlias, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return sw(classMapping, property, tableAlias, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw(SerializableFunction<T, String> name, String value, MatchStrategy matchStrategy) {
        return nsw(classMapping, name, value, tableAlias, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw(SerializableFunction<T, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nsw(classMapping, name, value, tableAlias, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return nsw(classMapping, property, tableAlias, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nsw(classMapping, property, tableAlias, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(SerializableFunction<T, String> name, String value, MatchStrategy matchStrategy) {
        return ew(classMapping, name, value, tableAlias, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(SerializableFunction<T, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ew(classMapping, name, value, tableAlias, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return ew(classMapping, property, tableAlias, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ew(classMapping, property, tableAlias, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L newv(SerializableFunction<T, String> name, String value, MatchStrategy matchStrategy) {
        return newv(classMapping, name, value, tableAlias, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L newv(SerializableFunction<T, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return newv(classMapping, name, value, tableAlias, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L newv(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return newv(classMapping, property, tableAlias, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L newv(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return newv(classMapping, property, tableAlias, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(SerializableFunction<T, String> name, String value, MatchStrategy matchStrategy) {
        return co(classMapping, name, value, tableAlias, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(SerializableFunction<T, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return co(classMapping, name, value, tableAlias, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return co(classMapping, property, tableAlias, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return co(classMapping, property, tableAlias, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco(SerializableFunction<T, String> name, String value, MatchStrategy matchStrategy) {
        return nco(classMapping, name, value, tableAlias, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco(SerializableFunction<T, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nco(classMapping, name, value, tableAlias, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return nco(classMapping, property, tableAlias, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nco(classMapping, property, tableAlias, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public <N extends Number> L ge(String name, N value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        ComparisonOperator.GE, queryAlias, ignoreStrategy));
    //    }

    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public <D extends Date> L ge(String name, D value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        ComparisonOperator.GE, queryAlias, ignoreStrategy));
    //    }

    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L ge(String name, LocalTime value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        ComparisonOperator.GE, queryAlias, ignoreStrategy));
    //    }

    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L ge(String name, LocalDate value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        ComparisonOperator.GE, queryAlias, ignoreStrategy));
    //    }

    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L ge(String name, LocalDateTime value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        ComparisonOperator.GE, queryAlias, ignoreStrategy));
    //    }

    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L ge(String name, String value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        ComparisonOperator.GE, queryAlias, ignoreStrategy));
    //    }

    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public <N extends Number> L gt(String name, N value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        ComparisonOperator.GT, queryAlias, ignoreStrategy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public <D extends Date> L gt(String name, D value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        ComparisonOperator.GT, queryAlias, ignoreStrategy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L gt(String name, LocalTime value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        ComparisonOperator.GT, queryAlias, ignoreStrategy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L gt(String name, LocalDate value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        ComparisonOperator.GT, queryAlias, ignoreStrategy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L gt(String name, LocalDateTime value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        ComparisonOperator.GT, queryAlias, ignoreStrategy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L gt(String name, String value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        ComparisonOperator.GT, queryAlias, ignoreStrategy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L in(String name, Object value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        ComparisonOperator.IN, queryAlias, ignoreStrategy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L inn(String name) {
    //        return inn(name, true);
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L inn(String name, Boolean value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        ComparisonOperator.INN, queryAlias, ignoreStrategy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L isn(String name) {
    //        return isn(name, true);
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L isn(String name, Boolean value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        ComparisonOperator.ISN, queryAlias, ignoreStrategy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public <N extends Number> L le(String name, N value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        ComparisonOperator.LE, queryAlias, ignoreStrategy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public <D extends Date> L le(String name, D value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        ComparisonOperator.LE, queryAlias, ignoreStrategy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L le(String name, LocalTime value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        ComparisonOperator.LE, queryAlias, ignoreStrategy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L le(String name, LocalDate value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        ComparisonOperator.LE, queryAlias, ignoreStrategy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L le(String name, LocalDateTime value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        ComparisonOperator.LE, queryAlias, ignoreStrategy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L le(String name, String value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        ComparisonOperator.LE, queryAlias, ignoreStrategy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public <N extends Number> L lt(String name, N value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        ComparisonOperator.LT, queryAlias, ignoreStrategy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public <D extends Date> L lt(String name, D value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        ComparisonOperator.LT, queryAlias, ignoreStrategy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L lt(String name, LocalTime value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        ComparisonOperator.LT, queryAlias, ignoreStrategy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L lt(String name, LocalDate value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        ComparisonOperator.LT, queryAlias, ignoreStrategy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L lt(String name, LocalDateTime value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        ComparisonOperator.LT, queryAlias, ignoreStrategy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L lt(String name, String value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        ComparisonOperator.LT, queryAlias, ignoreStrategy));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L ni(String name, Object value) {
    //        return (L) addCondition(
    //                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
    //                        ComparisonOperator.NIN, queryAlias, ignoreStrategy));
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ge(SerializableFunction<T, N> name, N value) {
        return ge(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ge(SerializableFunction<T, N> name, N value, Predicate<N> ignoreStrategy) {
        return ge(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ge(SerializableFunction<T, D> name, D value) {
        return ge(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ge(SerializableFunction<T, D> name, D value, Predicate<D> ignoreStrategy) {
        return ge(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableFunction<T, LocalTime> name, LocalTime value) {
        return ge(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableFunction<T, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ge(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableFunction<T, LocalDate> name, LocalDate value) {
        return ge(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableFunction<T, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ge(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableFunction<T, LocalDateTime> name, LocalDateTime value) {
        return ge(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableFunction<T, LocalDateTime> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return ge(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ge(SerializableFunction<T, E> name, E value) {
        return ge(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ge(SerializableFunction<T, E> name, E value, Predicate<E> ignoreStrategy) {
        return ge(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableFunction<T, String> name, String value, MatchStrategy matchStrategy) {
        return ge(classMapping, name, value, tableAlias, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableFunction<T, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ge(classMapping, name, value, tableAlias, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L ge(SerializableDateSupplier<R> property) {
        return ge(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L ge(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ge(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L ge(SerializableNumberSupplier<R> property) {
        return ge(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L ge(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ge(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableLocalDateSupplier property) {
        return ge(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return ge(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableLocalTimeSupplier property) {
        return ge(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return ge(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableLocalDateTimeSupplier property) {
        return ge(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return ge(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ge(SerializableEnumSupplier<E> property) {
        return ge(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ge(SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy) {
        return ge(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return ge(classMapping, property, matchStrategy, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ge(classMapping, property, matchStrategy, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableToIntFunction<T> name, int value) {
        return ge(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableToIntFunction<T> name, int value, IntPredicate ignoreStrategy) {
        return ge(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableToLongFunction<T> name, long value) {
        return ge(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableToLongFunction<T> name, long value, LongPredicate ignoreStrategy) {
        return ge(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableToDoubleFunction<T> name, double value) {
        return ge(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableToDoubleFunction<T> name, double value, DoublePredicate ignoreStrategy) {
        return ge(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableIntSupplier property) {
        return ge(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return ge(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableLongSupplier property) {
        return ge(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return ge(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableDoubleSupplier property) {
        return ge(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return ge(classMapping, property, tableAlias, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L gt(SerializableFunction<T, N> name, N value) {
        return gt(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L gt(SerializableFunction<T, N> name, N value, Predicate<N> ignoreStrategy) {
        return gt(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L gt(SerializableFunction<T, E> name, E value) {
        return gt(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L gt(SerializableFunction<T, E> name, E value, Predicate<E> ignoreStrategy) {
        return gt(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L gt(SerializableFunction<T, D> name, D value) {
        return gt(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L gt(SerializableFunction<T, D> name, D value, Predicate<D> ignoreStrategy) {
        return gt(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableFunction<T, LocalTime> name, LocalTime value) {
        return gt(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableFunction<T, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return gt(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableFunction<T, LocalDate> name, LocalDate value) {
        return gt(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableFunction<T, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return gt(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableFunction<T, LocalDateTime> name, LocalDateTime value) {
        return gt(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableFunction<T, LocalDateTime> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return gt(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableFunction<T, String> name, String value, MatchStrategy matchStrategy) {
        return gt(classMapping, name, value, matchStrategy, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableFunction<T, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return gt(classMapping, name, value, matchStrategy, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L gt(SerializableNumberSupplier<R> property) {
        return gt(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L gt(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return gt(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L gt(SerializableEnumSupplier<E> property) {
        return gt(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L gt(SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy) {
        return gt(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L gt(SerializableDateSupplier<R> property) {
        return gt(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L gt(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return gt(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableLocalDateSupplier property) {
        return gt(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return gt(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableLocalTimeSupplier property) {
        return gt(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return gt(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableLocalDateTimeSupplier property) {
        return gt(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return gt(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return gt(classMapping, property, matchStrategy, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return gt(classMapping, property, matchStrategy, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableToIntFunction<T> name, int value) {
        return gt(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableToIntFunction<T> name, int value, IntPredicate ignoreStrategy) {
        return gt(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableToLongFunction<T> name, long value) {
        return gt(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableToLongFunction<T> name, long value, LongPredicate ignoreStrategy) {
        return gt(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableToDoubleFunction<T> name, double value) {
        return gt(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableToDoubleFunction<T> name, double value, DoublePredicate ignoreStrategy) {
        return gt(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableIntSupplier property) {
        return gt(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return gt(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableLongSupplier property) {
        return gt(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return gt(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableDoubleSupplier property) {
        return gt(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return gt(classMapping, property, tableAlias, ignoreStrategy);
    }

    // ****************************************************************************************************************

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <R extends Serializable> L in(SerializableFunction<T, R> name, R value) {
    //        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, getIgnoreStrategy());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <R extends Serializable> L in(SerializableFunction<T, R> name, R value, Predicate<R> ignoreStrategy) {
    //        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, ignoreStrategy);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <R extends Serializable> L in(SerializableFunction<T, R> name, R... value) {
    //        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, getIgnoreStrategy());
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L in(SerializableFunction<T, R> name, R[] value, Predicate<R[]> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L in(SerializableFunction<T, N> name, N value) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L in(SerializableFunction<T, N> name, N value, Predicate<N> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L in(SerializableFunction<T, N> name, N[] value) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L in(SerializableFunction<T, N> name, N[] value, Predicate<N[]> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableFunction<T, Integer> name, int... value) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableFunction<T, Integer> name, int[] value, Predicate<int[]> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableFunction<T, Long> name, long... value) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableFunction<T, Long> name, long[] value, Predicate<long[]> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L in(SerializableFunction<T, D> name, D value) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L in(SerializableFunction<T, D> name, D value, Predicate<D> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L in(SerializableFunction<T, D> name, D... value) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L in(SerializableFunction<T, D> name, D[] value, Predicate<D[]> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L in(SerializableFunction<T, E> name, E value) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L in(SerializableFunction<T, E> name, E value, Predicate<E> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L in(SerializableFunction<T, E> name, E... value) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L in(SerializableFunction<T, E> name, E[] value, Predicate<E[]> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToLocalDateTimeFunction<T> name, LocalDateTime... value) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToLocalDateTimeFunction<T> name, LocalDateTime[] value,
        Predicate<LocalDateTime[]> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToLocalDateFunction<T> name, LocalDate value) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToLocalDateFunction<T> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToLocalDateFunction<T> name, LocalDate... value) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToLocalDateFunction<T> name, LocalDate[] value, Predicate<LocalDate[]> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToLocalTimeFunction<T> name, LocalTime value) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToLocalTimeFunction<T> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToLocalTimeFunction<T> name, LocalTime... value) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToLocalTimeFunction<T> name, LocalTime[] value, Predicate<LocalTime[]> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToStringFunction<T> name, String value) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToStringFunction<T> name, String value, Predicate<String> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToStringFunction<T> name, String... value) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToStringFunction<T> name, String[] value, Predicate<String[]> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy) {
        return in(classMapping, name, value, matchStrategy, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return in(classMapping, name, value, matchStrategy, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToStringFunction<T> name, String[] value, MatchStrategy matchStrategy) {
        return in(classMapping, name, value, matchStrategy, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToStringFunction<T> name, String[] value, MatchStrategy matchStrategy,
        Predicate<String[]> ignoreStrategy) {
        return in(classMapping, name, value, matchStrategy, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L in(SerializableFunction<T, R> name, Collection<R> value) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L in(SerializableFunction<T, R> name, Collection<R> value,
        Predicate<Collection<R>> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L in(SerializableSupplier<R> property) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return in(classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), property.get(),
            tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L in(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return in(classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), property.get(),
            tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToIntFunction<T> name, int value) {
        return in(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToIntFunction<T> name, int value, IntPredicate ignoreStrategy) {
        return in(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToIntFunction<T> name, int... value) {
        return in(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToIntFunction<T> name, int[] value, Predicate<int[]> ignoreStrategy) {
        return in(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToLongFunction<T> name, long value) {
        return in(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToLongFunction<T> name, long value, LongPredicate ignoreStrategy) {
        return in(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToLongFunction<T> name, long... value) {
        return in(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToLongFunction<T> name, long[] value, Predicate<long[]> ignoreStrategy) {
        return in(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToDoubleFunction<T> name, double value) {
        return in(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToDoubleFunction<T> name, double value, DoublePredicate ignoreStrategy) {
        return in(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToDoubleFunction<T> name, double... value) {
        return in(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToDoubleFunction<T> name, double[] value, Predicate<double[]> ignoreStrategy) {
        return in(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L in(SerializableFunction<T, Integer> name, int... value) {
    //        return in(classMapping, name, value, tableAlias, getIgnoreStrategy());
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L in(SerializableFunction<T, Long> name, long... value) {
    //        return in(classMapping, name, value, tableAlias, getIgnoreStrategy());
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L in(SerializableFunction<T, Integer> name, int[] value, Predicate<int[]> ignoreStrategy) {
    //        return in(classMapping, name, value, tableAlias, ignoreStrategy);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L in(SerializableFunction<T, Long> name, long[] value, Predicate<long[]> ignoreStrategy) {
    //        return in(classMapping, name, value, tableAlias, ignoreStrategy);
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableIntSupplier property) {
        return in(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return in(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableLongSupplier property) {
        return in(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return in(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableDoubleSupplier property) {
        return in(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return in(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return in(classMapping, property, property.get(), matchStrategy, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return in(classMapping, property, property.get(), matchStrategy, tableAlias, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni(SerializableFunction<T, R> name, R value) {
        return ni(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni(SerializableFunction<T, R> name, R value, Predicate<R> ignoreStrategy) {
        return ni(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni(SerializableFunction<T, R> name, R... value) {
        return ni(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni(SerializableFunction<T, R> name, R[] value, Predicate<R[]> ignoreStrategy) {
        return ni(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni(SerializableFunction<T, R> name, Collection<R> value) {
        return ni(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni(SerializableFunction<T, R> name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy) {
        return ni(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni(SerializableSupplier<R> property) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ni(classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), property.get(),
            tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ni(classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), property.get(),
            tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableToIntFunction<T> name, int value) {
        return ni(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableToIntFunction<T> name, int value, IntPredicate ignoreStrategy) {
        return ni(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableToLongFunction<T> name, long value) {
        return ni(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableToLongFunction<T> name, long value, LongPredicate ignoreStrategy) {
        return ni(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableToDoubleFunction<T> name, double value) {
        return ni(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableToDoubleFunction<T> name, double value, DoublePredicate ignoreStrategy) {
        return ni(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableToIntFunction<T> name, int... value) {
        return ni(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableToLongFunction<T> name, long... value) {
        return ni(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableToDoubleFunction<T> name, double... value) {
        return ni(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableToIntFunction<T> name, int[] value, Predicate<int[]> ignoreStrategy) {
        return ni(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableToLongFunction<T> name, long[] value, Predicate<long[]> ignoreStrategy) {
        return ni(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableToDoubleFunction<T> name, double[] value, Predicate<double[]> ignoreStrategy) {
        return ni(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableIntSupplier property) {
        return ni(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return ni(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableLongSupplier property) {
        return ni(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return ni(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableDoubleSupplier property) {
        return ni(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return ni(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy) {
        return ni(classMapping, name, value, matchStrategy, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ni(classMapping, name, value, matchStrategy, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableToStringFunction<T> name, String[] value, MatchStrategy matchStrategy) {
        return ni(classMapping, name, value, matchStrategy, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableToStringFunction<T> name, String[] value, MatchStrategy matchStrategy,
        Predicate<String[]> ignoreStrategy) {
        return ni(classMapping, name, value, matchStrategy, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return ni(classMapping, property, property.get(), matchStrategy, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ni(classMapping, property, property.get(), matchStrategy, tableAlias, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L inn(SerializableFunction<T, R> name, Boolean value) {
        return inn(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L isn(SerializableFunction<T, R> name, Boolean value) {
        return isn(classMapping.getPropertyMapping(getPropertyName(name)), value, tableAlias);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L le(SerializableFunction<T, N> name, N value) {
        return le(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L le(SerializableFunction<T, N> name, N value, Predicate<N> ignoreStrategy) {
        return le(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L le(SerializableFunction<T, E> name, E value) {
        return le(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L le(SerializableFunction<T, E> name, E value, Predicate<E> ignoreStrategy) {
        return le(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L le(SerializableFunction<T, D> name, D value) {
        return le(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L le(SerializableFunction<T, D> name, D value, Predicate<D> ignoreStrategy) {
        return le(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableFunction<T, LocalTime> name, LocalTime value) {
        return le(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableFunction<T, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return le(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableFunction<T, LocalDate> name, LocalDate value) {
        return le(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableFunction<T, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return le(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableFunction<T, LocalDateTime> name, LocalDateTime value) {
        return le(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableFunction<T, LocalDateTime> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return le(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableFunction<T, String> name, String value, MatchStrategy matchStrategy) {
        return le(classMapping, name, value, matchStrategy, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableFunction<T, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return le(classMapping, name, value, matchStrategy, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L le(SerializableDateSupplier<R> property) {
        return le(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L le(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return le(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L le(SerializableNumberSupplier<R> property) {
        return le(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L le(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return le(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L le(SerializableEnumSupplier<E> property) {
        return le(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L le(SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy) {
        return le(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableLocalDateSupplier property) {
        return le(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return le(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableLocalTimeSupplier property) {
        return le(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return le(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableLocalDateTimeSupplier property) {
        return le(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return le(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return le(classMapping, property, matchStrategy, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return le(classMapping, property, matchStrategy, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableToIntFunction<T> name, int value) {
        return le(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableToIntFunction<T> name, int value, IntPredicate ignoreStrategy) {
        return le(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableToLongFunction<T> name, long value) {
        return le(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableToLongFunction<T> name, long value, LongPredicate ignoreStrategy) {
        return le(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableToDoubleFunction<T> name, double value) {
        return le(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableToDoubleFunction<T> name, double value, DoublePredicate ignoreStrategy) {
        return le(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableIntSupplier property) {
        return le(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return le(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableLongSupplier property) {
        return le(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return le(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableDoubleSupplier property) {
        return le(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return le(classMapping, property, tableAlias, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L lt(SerializableFunction<T, N> name, N value) {
        return lt(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L lt(SerializableFunction<T, N> name, N value, Predicate<N> ignoreStrategy) {
        return lt(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L lt(SerializableFunction<T, E> name, E value) {
        return lt(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L lt(SerializableFunction<T, E> name, E value, Predicate<E> ignoreStrategy) {
        return lt(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L lt(SerializableFunction<T, D> name, D value) {
        return lt(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L lt(SerializableFunction<T, D> name, D value, Predicate<D> ignoreStrategy) {
        return lt(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableFunction<T, LocalTime> name, LocalTime value) {
        return lt(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableFunction<T, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return lt(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableFunction<T, LocalDate> name, LocalDate value) {
        return lt(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableFunction<T, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return lt(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableFunction<T, LocalDateTime> name, LocalDateTime value) {
        return lt(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableFunction<T, LocalDateTime> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return lt(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableFunction<T, String> name, String value, MatchStrategy matchStrategy) {
        return lt(classMapping, name, value, matchStrategy, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableFunction<T, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return lt(classMapping, name, value, matchStrategy, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L lt(SerializableNumberSupplier<R> property) {
        return lt(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L lt(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return lt(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L lt(SerializableEnumSupplier<E> property) {
        return lt(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L lt(SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy) {
        return lt(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L lt(SerializableDateSupplier<R> property) {
        return lt(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L lt(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return lt(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableLocalDateSupplier property) {
        return lt(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return lt(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableLocalTimeSupplier property) {
        return lt(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return lt(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableLocalDateTimeSupplier property) {
        return lt(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return lt(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return lt(classMapping, property, matchStrategy, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return lt(classMapping, property, matchStrategy, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableToIntFunction<T> name, int value) {
        return lt(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableToIntFunction<T> name, int value, IntPredicate ignoreStrategy) {
        return lt(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableToLongFunction<T> name, long value) {
        return lt(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableToLongFunction<T> name, long value, LongPredicate ignoreStrategy) {
        return lt(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableToDoubleFunction<T> name, double value) {
        return lt(classMapping, name, value, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableToDoubleFunction<T> name, double value, DoublePredicate ignoreStrategy) {
        return lt(classMapping, name, value, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableIntSupplier property) {
        return lt(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return lt(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableLongSupplier property) {
        return lt(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return lt(classMapping, property, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableDoubleSupplier property) {
        return lt(classMapping, property, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return lt(classMapping, property, tableAlias, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableToIntFunction<T> name, int min, int max) {
        return ba(classMapping, name, min, max, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableToIntFunction<T> name, int min, int max, BiPredicate<Integer, Integer> ignoreStrategy) {
        return ba(classMapping, name, min, max, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableToLongFunction<T> name, long min, long max) {
        return ba(classMapping, name, min, max, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableToLongFunction<T> name, long min, long max, BiPredicate<Long, Long> ignoreStrategy) {
        return ba(classMapping, name, min, max, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableToDoubleFunction<T> name, double min, double max) {
        return ba(classMapping, name, min, max, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableToDoubleFunction<T> name, double min, double max,
        BiPredicate<Double, Double> ignoreStrategy) {
        return ba(classMapping, name, min, max, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ba(SerializableToNumberFunction<T, N> name, N min, N max) {
        return ba(classMapping, name, min, max, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ba(SerializableToNumberFunction<T, N> name, N min, N max,
        BiPredicate<N, N> ignoreStrategy) {
        return ba(classMapping, name, min, max, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ba(SerializableToDateFunction<T, D> name, D min, D max) {
        return ba(classMapping, name, min, max, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ba(SerializableToDateFunction<T, D> name, D min, D max,
        BiPredicate<D, D> ignoreStrategy) {
        return ba(classMapping, name, min, max, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ba(SerializableToEnumFunction<T, E> name, E min, E max) {
        return ba(classMapping, name, min, max, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ba(SerializableToEnumFunction<T, E> name, E min, E max,
        BiPredicate<E, E> ignoreStrategy) {
        return ba(classMapping, name, min, max, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableToLocalTimeFunction<T> name, LocalTime min, LocalTime max) {
        return ba(classMapping, name, min, max, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableToLocalTimeFunction<T> name, LocalTime min, LocalTime max,
        BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return ba(classMapping, name, min, max, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableToLocalDateFunction<T> name, LocalDate min, LocalDate max) {
        return ba(classMapping, name, min, max, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableToLocalDateFunction<T> name, LocalDate min, LocalDate max,
        BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return ba(classMapping, name, min, max, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableToLocalDateTimeFunction<T> name, LocalDateTime min, LocalDateTime max) {
        return ba(classMapping, name, min, max, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableToLocalDateTimeFunction<T> name, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return ba(classMapping, name, min, max, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableToStringFunction<T> name, String min, String max) {
        return ba(classMapping, name, min, max, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableToStringFunction<T> name, String min, String max,
        BiPredicate<String, String> ignoreStrategy) {
        return ba(classMapping, name, min, max, tableAlias, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableToIntFunction<T> name, int min, int max) {
        return nba(classMapping, name, min, max, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableToIntFunction<T> name, int min, int max, BiPredicate<Integer, Integer> ignoreStrategy) {
        return nba(classMapping, name, min, max, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableToLongFunction<T> name, long min, long max) {
        return nba(classMapping, name, min, max, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableToLongFunction<T> name, long min, long max, BiPredicate<Long, Long> ignoreStrategy) {
        return nba(classMapping, name, min, max, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableToDoubleFunction<T> name, double min, double max) {
        return nba(classMapping, name, min, max, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableToDoubleFunction<T> name, double min, double max,
        BiPredicate<Double, Double> ignoreStrategy) {
        return nba(classMapping, name, min, max, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L nba(SerializableToNumberFunction<T, N> name, N min, N max) {
        return nba(classMapping, name, min, max, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L nba(SerializableToNumberFunction<T, N> name, N min, N max,
        BiPredicate<N, N> ignoreStrategy) {
        return nba(classMapping, name, min, max, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L nba(SerializableToDateFunction<T, D> name, D min, D max) {
        return nba(classMapping, name, min, max, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L nba(SerializableToDateFunction<T, D> name, D min, D max,
        BiPredicate<D, D> ignoreStrategy) {
        return nba(classMapping, name, min, max, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L nba(SerializableToEnumFunction<T, E> name, E min, E max) {
        return nba(classMapping, name, min, max, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L nba(SerializableToEnumFunction<T, E> name, E min, E max,
        BiPredicate<E, E> ignoreStrategy) {
        return nba(classMapping, name, min, max, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableToLocalTimeFunction<T> name, LocalTime min, LocalTime max) {
        return nba(classMapping, name, min, max, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableToLocalTimeFunction<T> name, LocalTime min, LocalTime max,
        BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return nba(classMapping, name, min, max, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableToLocalDateFunction<T> name, LocalDate min, LocalDate max) {
        return nba(classMapping, name, min, max, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableToLocalDateFunction<T> name, LocalDate min, LocalDate max,
        BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return nba(classMapping, name, min, max, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableToLocalDateTimeFunction<T> name, LocalDateTime min, LocalDateTime max) {
        return nba(classMapping, name, min, max, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableToLocalDateTimeFunction<T> name, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return nba(classMapping, name, min, max, tableAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableToStringFunction<T> name, String min, String max) {
        return nba(classMapping, name, min, max, tableAlias, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableToStringFunction<T> name, String min, String max,
        BiPredicate<String, String> ignoreStrategy) {
        return nba(classMapping, name, min, max, tableAlias, ignoreStrategy);
    }

    // ****************************************************************************************************************
    // property
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityTypePropertyExpression<R, C, L> property(SerializableFunction<T, R> name) {
        return new EntityTypePropertyExpressionImpl<>(index, name, this, factory, entityRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Collection<E>,
        E> EntityTypePropertyExpression<E, C, L> property(SerializableToCollectionFunction<T, R, E> name) {
        // IMPLSOON 后续来实现集合类型property
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityIntPropertyExpression<T, C, L> property(SerializableToIntFunction<T> name) {
        return new EntityIntPropertyExpressionImpl<>(index, name, this, factory, entityRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLongPropertyExpression<T, C, L> property(SerializableToLongFunction<T> name) {
        return new EntityLongPropertyExpressionImpl<>(index, name, this, factory, entityRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityDoublePropertyExpression<T, C, L> property(SerializableToDoubleFunction<T> name) {
        return new EntityDoublePropertyExpressionImpl<>(index, name, this, factory, entityRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <
        R extends Number> EntityNumberPropertyExpression<T, R, C, L> property(SerializableToNumberFunction<T, R> name) {
        return new EntityNumberPropertyExpressionImpl<>(index, name, this, factory, entityRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityStringPropertyExpression<T, C, L> property(SerializableToStringFunction<T> name) {
        return new EntityStringPropertyExpressionImpl<>(index, name, this, factory, entityRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> EntityDatePropertyExpression<T, R, C, L> property(SerializableToDateFunction<T, R> name) {
        return new EntityDatePropertyExpressionImpl<>(index, name, this, factory, entityRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLocalDatePropertyExpression<T, C, L> property(SerializableToLocalDateFunction<T> name) {
        return new EntityLocalDatePropertyExpressionImpl<>(index, name, this, factory, entityRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLocalDateTimePropertyExpression<T, C, L> property(SerializableToLocalDateTimeFunction<T> name) {
        return new EntityLocalDateTimePropertyExpressionImpl<>(index, name, this, factory, entityRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLocalTimePropertyExpression<T, C, L> property(SerializableToLocalTimeFunction<T> name) {
        return new EntityLocalTimePropertyExpressionImpl<>(index, name, this, factory, entityRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <
        R extends Enum<R>> EntityEnumPropertyExpression<T, R, C, L> property(SerializableToEnumFunction<T, R> name) {
        return new EntityEnumPropertyExpressionImpl<>(index, name, this, factory, entityRelation);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L expression(String expression, final Map<String, Object> params) {
        final Execution execution = SqlUtils.convertNamedParamSql(expression, params);
        return expression(execution.getExecution(), execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L expression(String expression, Object... params) {
        return (L) addCondition(new ParamedExpression() {

            @Override
            public String expression() {
                return expression;
            }

            @Override
            public Object getParam() {
                return params;
            }
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public C configure(Consumer<C2> configure) {
        if (configure != null) {
            configure.accept(conditionConfig);
        }
        return (C) this;
    }

    //
    //    public <R> ObjectExpression<C, L> property(SerializableFunction<T, R> name) {
    //        return property(getPropertyName(name));
    //    }

    //    public ObjectExpression<C, L> property(String name) {
    //        // IMPLSOON 这里后续来实现
    //        return null;
    //        //        return new SimpleObjectExpression<C, L>(ClassMappingUtils.getColumnName(name, classMapping), this);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public StringExpression<C, L> propertyString(String name) {
    //        return new SimpleStringExpression<>(ClassMappingUtils.getColumnName(name, classMapping), this);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public NumberExpression<C, L> propertyNumber(String name) {
    //        return new SimpleNumberExpression<>(ClassMappingUtils.getColumnName(name, classMapping), this);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public DateExpression<C, L> propertyDate(String name) {
    //        return new SimpleDateExpression<>(ClassMappingUtils.getColumnName(name, classMapping), this);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public EnumExpression<C, L> propertyEnum(String name) {
    //        return new SimpleEnumExpression<>(ClassMappingUtils.getColumnName(name, classMapping), this);
    //    }

    // ********************************************************************
    // protected method
    // ********************************************************************

    // ********************************************************************

    /**
     * Gets the field value operator.
     *
     * @param <R>   the generic type
     * @param pm    the pm
     * @param value the value
     * @return the field value operator
     */
    protected <R> FieldValueOperator<R> getFieldValueOperator(JdbcPropertyMapping pm, R value) {
        return value == null ? null : FieldValueOperator.create(pm, value);
    }

    /**
     * Gets the in param.
     *
     * @param pm    the pm
     * @param value the value
     * @return the in param
     */
    protected Object getInParam(JdbcPropertyMapping pm, Object value) {
        Object param = null;
        if (value != null) {
            if (value.getClass().isArray()) {
                int length = Array.getLength(value);
                //                param = Array.newInstance(FieldValueOperator.class, length);
                param = new FieldValueOperator[length];
                for (int i = 0; i < length; i++) {
                    if (value.getClass() == int[].class) {
                        Array.set(param, i, FieldValueOperator.create(pm, Array.getInt(value, i)));
                    } else if (value.getClass() == long[].class) {
                        Array.set(param, i, FieldValueOperator.create(pm, Array.getLong(value, i)));
                    } else if (value.getClass() == boolean[].class) {
                        Array.set(param, i, FieldValueOperator.create(pm, Array.getBoolean(value, i)));
                    } /* else if (value.getClass() == char[].class) {
                        Array.set(param, i, FieldValueOperator.create(pm, (byte) Array.getChar(value, i)));
                        // database don't support getChar
                      } */ else if (value.getClass() == byte[].class) {
                        Array.set(param, i, FieldValueOperator.create(pm, Array.getByte(value, i)));
                    } else if (value.getClass() == short[].class) {
                        Array.set(param, i, FieldValueOperator.create(pm, Array.getShort(value, i)));
                    } else if (value.getClass() == double[].class) {
                        Array.set(param, i, FieldValueOperator.create(pm, Array.getDouble(value, i)));
                    } else if (value.getClass() == float[].class) {
                        Array.set(param, i, FieldValueOperator.create(pm, Array.getFloat(value, i)));
                    } else {
                        Array.set(param, i, FieldValueOperator.create(pm, Array.get(value, i)));
                    }
                }
            } else if (value instanceof Collection) {
                param = new ArrayList<>();
                for (Object op : (Collection<?>) value) {
                    ((Collection<FieldValueOperator<?>>) param).add(FieldValueOperator.create(pm, op));
                }
            } else if (!(value instanceof FieldValueOperator)) {
                param = FieldValueOperator.create(pm, value);
            } else {
                param = value;
            }
        }
        return param;
    }

    // ********************************************************************

    protected <R> L eq(JdbcClassMapping<?> classMapping, SerializableSupplier<R> property, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return eq(classMapping, property, property.get(), queryAlias, MatchStrategy.AUTO, ignoreStrategy);
    }

    protected <R> L eq(JdbcClassMapping<?> classMapping, SerializableSupplier<R> property, String queryAlias,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return eq(classMapping, property, property.get(), queryAlias, matchStrategy, ignoreStrategy);
    }

    protected L eq(JdbcClassMapping<?> classMapping, Serializable property, int value, String queryAlias,
        IntPredicate ignoreStrategy) {
        return eqOrNe(ComparisonOperator.EQ, classMapping.getPropertyMapping(getPropertyName(property)), value,
            queryAlias, MatchStrategy.AUTO, v -> ignoreStrategy.test((Integer) v));
    }

    protected L eq(JdbcClassMapping<?> classMapping, Serializable property, int value, String queryAlias,
        CharPredicate ignoreStrategy) {
        return eqOrNe(ComparisonOperator.EQ, classMapping.getPropertyMapping(getPropertyName(property)), value,
            queryAlias, MatchStrategy.AUTO, v -> ignoreStrategy.test((Character) v));
    }

    protected L eq(JdbcClassMapping<?> classMapping, Serializable property, long value, String queryAlias,
        LongPredicate ignoreStrategy) {
        return eqOrNe(ComparisonOperator.EQ, classMapping.getPropertyMapping(getPropertyName(property)), value,
            queryAlias, MatchStrategy.AUTO, v -> ignoreStrategy.test((Long) v));
    }

    protected L eq(JdbcClassMapping<?> classMapping, Serializable property, double value, String queryAlias,
        DoublePredicate ignoreStrategy) {
        return eqOrNe(ComparisonOperator.EQ, classMapping.getPropertyMapping(getPropertyName(property)), value,
            queryAlias, MatchStrategy.AUTO, v -> ignoreStrategy.test((Double) v));
    }

    protected L eq(JdbcClassMapping<?> classMapping, Serializable property, char value, String queryAlias,
        CharPredicate ignoreStrategy) {
        return eqOrNe(ComparisonOperator.EQ, classMapping.getPropertyMapping(getPropertyName(property)), value,
            queryAlias, MatchStrategy.AUTO, v -> ignoreStrategy.test((Character) v));
    }

    protected <R> L eq(JdbcClassMapping<?> classMapping, Serializable property, R value, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return eq(classMapping, property, value, queryAlias, MatchStrategy.AUTO, ignoreStrategy);
    }

    protected <R> L eq(JdbcClassMapping<?> classMapping, Serializable property, R value, String queryAlias,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return eqOrNe(ComparisonOperator.EQ, classMapping.getPropertyMapping(getPropertyName(property)), value,
            queryAlias, matchStrategy, ignoreStrategy);
    }

    protected <R> L ne(JdbcClassMapping<?> classMapping, SerializableSupplier<R> property, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return ne(classMapping, property, property.get(), queryAlias, MatchStrategy.AUTO, ignoreStrategy);
    }

    protected <R> L ne(JdbcClassMapping<?> classMapping, SerializableSupplier<R> property, String queryAlias,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return ne(classMapping, property, property.get(), queryAlias, matchStrategy, ignoreStrategy);
    }

    protected L ne(JdbcClassMapping<?> classMapping, Serializable property, char value, String queryAlias,
        CharPredicate ignoreStrategy) {
        return eqOrNe(ComparisonOperator.NE, classMapping.getPropertyMapping(getPropertyName(property)), value,
            queryAlias, MatchStrategy.AUTO, v -> ignoreStrategy.test((Character) v));
    }

    protected L ne(JdbcClassMapping<?> classMapping, Serializable property, int value, String queryAlias,
        IntPredicate ignoreStrategy) {
        return eqOrNe(ComparisonOperator.NE, classMapping.getPropertyMapping(getPropertyName(property)), value,
            queryAlias, MatchStrategy.AUTO, v -> ignoreStrategy.test((Integer) v));
    }

    protected L ne(JdbcClassMapping<?> classMapping, Serializable property, int value, String queryAlias,
        CharPredicate ignoreStrategy) {
        return eqOrNe(ComparisonOperator.NE, classMapping.getPropertyMapping(getPropertyName(property)), value,
            queryAlias, MatchStrategy.AUTO, v -> ignoreStrategy.test((Character) v));
    }

    protected L ne(JdbcClassMapping<?> classMapping, Serializable property, long value, String queryAlias,
        LongPredicate ignoreStrategy) {
        return eqOrNe(ComparisonOperator.NE, classMapping.getPropertyMapping(getPropertyName(property)), value,
            queryAlias, MatchStrategy.AUTO, v -> ignoreStrategy.test((Long) v));
    }

    protected L ne(JdbcClassMapping<?> classMapping, Serializable property, double value, String queryAlias,
        DoublePredicate ignoreStrategy) {
        return eqOrNe(ComparisonOperator.NE, classMapping.getPropertyMapping(getPropertyName(property)), value,
            queryAlias, MatchStrategy.AUTO, v -> ignoreStrategy.test((Double) v));
    }

    protected <R> L ne(JdbcClassMapping<?> classMapping, Serializable property, R value, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return ne(classMapping, property, value, queryAlias, MatchStrategy.AUTO, ignoreStrategy);
    }

    protected <R> L ne(JdbcClassMapping<?> classMapping, Serializable property, R value, String queryAlias,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return eqOrNe(ComparisonOperator.NE, classMapping.getPropertyMapping(getPropertyName(property)), value,
            queryAlias, matchStrategy, ignoreStrategy);
    }

    protected abstract <R> L eqOrNe(ComparisonOperator comparisonOperator, PropertyMapping<?> pm, R value,
        String queryAlias, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    //    protected <T, R> L eq_ne(ComparisonOperator comparisonOperator, JdbcPropertyMapping pm, R value, String queryAlias,
    //            MatchStrategy matchStrategy, Predicate<R> ignoreStrategy) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
    //                getFieldValueOperator(pm, value), comparisonOperator, matchStrategy, queryAlias, ignoreStrategy));
    //    }

    // ****************************************************************************************************************

    protected L sw(JdbcClassMapping<?> classMapping, SerializableSupplier<String> property, String queryAlias,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return sw(classMapping, property, property.get(), queryAlias, matchStrategy, ignoreStrategy);
    }

    protected L sw(JdbcClassMapping<?> classMapping, Serializable property, String value, String queryAlias,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return sw(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias, matchStrategy,
            ignoreStrategy);
    }

    protected L sw(JdbcPropertyMapping pm, String value, String queryAlias, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
            getFieldValueOperator(pm, value), ComparisonOperator.SW, matchStrategy, queryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    protected L nsw(JdbcClassMapping<?> classMapping, SerializableSupplier<String> property, String queryAlias,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return nsw(classMapping, property, property.get(), queryAlias, matchStrategy, ignoreStrategy);
    }

    protected L nsw(JdbcClassMapping<?> classMapping, Serializable property, String value, String queryAlias,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return nsw(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias, matchStrategy,
            ignoreStrategy);
    }

    protected L nsw(JdbcPropertyMapping pm, String value, String queryAlias, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
            getFieldValueOperator(pm, value), ComparisonOperator.NSW, matchStrategy, queryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    protected L co(JdbcClassMapping<?> classMapping, SerializableSupplier<String> property, String queryAlias,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return co(classMapping, property, property.get(), queryAlias, matchStrategy, ignoreStrategy);
    }

    protected L co(JdbcClassMapping<?> classMapping, Serializable property, String value, String queryAlias,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return co(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias, matchStrategy,
            ignoreStrategy);
    }

    protected L co(JdbcPropertyMapping pm, String value, String queryAlias, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
            getFieldValueOperator(pm, value), ComparisonOperator.CO, matchStrategy, queryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    protected L nco(JdbcClassMapping<?> classMapping, SerializableSupplier<String> property, String queryAlias,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return nco(classMapping, property, property.get(), queryAlias, matchStrategy, ignoreStrategy);
    }

    protected L nco(JdbcClassMapping<?> classMapping, Serializable property, String value, String queryAlias,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return nco(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias, matchStrategy,
            ignoreStrategy);
    }

    protected L nco(JdbcPropertyMapping pm, String value, String queryAlias, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
            getFieldValueOperator(pm, value), ComparisonOperator.NCO, matchStrategy, queryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    protected L ew(JdbcClassMapping<?> classMapping, SerializableSupplier<String> property, String queryAlias,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return ew(classMapping, property, property.get(), queryAlias, matchStrategy, ignoreStrategy);
    }

    protected L ew(JdbcClassMapping<?> classMapping, Serializable property, String value, String queryAlias,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return ew(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias, matchStrategy,
            ignoreStrategy);
    }

    protected L ew(JdbcPropertyMapping pm, String value, String queryAlias, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
            getFieldValueOperator(pm, value), ComparisonOperator.EW, matchStrategy, queryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    protected L newv(JdbcClassMapping<?> classMapping, SerializableSupplier<String> property, String queryAlias,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return newv(classMapping, property, property.get(), queryAlias, matchStrategy, ignoreStrategy);
    }

    protected L newv(JdbcClassMapping<?> classMapping, Serializable property, String value, String queryAlias,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return newv(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias, matchStrategy,
            ignoreStrategy);
    }

    protected L newv(JdbcPropertyMapping pm, String value, String queryAlias, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
            getFieldValueOperator(pm, value), ComparisonOperator.NEW, matchStrategy, queryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    protected L lk(JdbcClassMapping<?> classMapping, SerializableSupplier<String> property, String queryAlias,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return lk(classMapping, property, property.get(), queryAlias, matchStrategy, ignoreStrategy);
    }

    protected L lk(JdbcClassMapping<?> classMapping, Serializable property, String value, String queryAlias,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return lk(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias, matchStrategy,
            ignoreStrategy);
    }

    protected L lk(JdbcPropertyMapping pm, String value, String queryAlias, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
            getFieldValueOperator(pm, value), ComparisonOperator.LK, matchStrategy, queryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    protected L nl(JdbcClassMapping<?> classMapping, SerializableSupplier<String> property, String queryAlias,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return nl(classMapping, property, property.get(), queryAlias, matchStrategy, ignoreStrategy);
    }

    protected L nl(JdbcClassMapping<?> classMapping, Serializable property, String value, String queryAlias,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return nl(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias, matchStrategy,
            ignoreStrategy);
    }

    protected L nl(JdbcPropertyMapping pm, String value, String queryAlias, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
            getFieldValueOperator(pm, value), ComparisonOperator.NL, matchStrategy, queryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    protected L in(JdbcClassMapping<?> classMapping, SerializableIntSupplier property, String queryAlias,
        IntPredicate ignoreStrategy) {
        return in(classMapping, property, property.getAsInt(), queryAlias, v -> ignoreStrategy.test((Integer) v));
    }

    protected L in(JdbcClassMapping<?> classMapping, SerializableIntSupplier property, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return in(classMapping, property, property.getAsInt(), queryAlias, ignoreStrategy);
    }

    protected L in(JdbcClassMapping<?> classMapping, SerializableLongSupplier property, String queryAlias,
        LongPredicate ignoreStrategy) {
        return in(classMapping, property, property.getAsLong(), queryAlias, v -> ignoreStrategy.test((Long) v));
    }

    protected L in(JdbcClassMapping<?> classMapping, SerializableLongSupplier property, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return in(classMapping, property, property.getAsLong(), queryAlias, ignoreStrategy);
    }

    protected L in(JdbcClassMapping<?> classMapping, SerializableDoubleSupplier property, String queryAlias,
        DoublePredicate ignoreStrategy) {
        return in(classMapping, property, property.getAsDouble(), queryAlias, v -> ignoreStrategy.test((Double) v));
    }

    protected L in(JdbcClassMapping<?> classMapping, SerializableDoubleSupplier property, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return in(classMapping, property, property.getAsDouble(), queryAlias, ignoreStrategy);
    }

    protected <R> L in(JdbcClassMapping<?> classMapping, SerializableSupplier<R> property, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return in(classMapping, property, property.get(), queryAlias, ignoreStrategy);
    }

    protected L in(JdbcClassMapping<?> classMapping, SerializableToIntFunction<?> property, int value,
        String queryAlias, IntPredicate ignoreStrategy) {
        return in(classMapping, (Serializable) property, value, queryAlias, v -> ignoreStrategy.test((Integer) v));
    }

    protected L in(JdbcClassMapping<?> classMapping, SerializableToLongFunction<?> property, long value,
        String queryAlias, LongPredicate ignoreStrategy) {
        return in(classMapping, (Serializable) property, value, queryAlias, v -> ignoreStrategy.test((Long) v));
    }

    protected L in(JdbcClassMapping<?> classMapping, SerializableToDoubleFunction<?> property, double value,
        String queryAlias, DoublePredicate ignoreStrategy) {
        return in(classMapping, (Serializable) property, value, queryAlias, v -> ignoreStrategy.test((Double) v));
    }

    protected <S> L in(JdbcClassMapping<?> classMapping, Serializable property, S value, MatchStrategy matchStrategy,
        String queryAlias, Predicate<?> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(property)), value, matchStrategy, queryAlias,
            ignoreStrategy);
    }

    protected <R> L in(JdbcClassMapping<?> classMapping, Serializable property, R value, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias, ignoreStrategy);
    }

    protected <R> L in(JdbcPropertyMapping pm, R value, String queryAlias, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
            getInParam(pm, value), ComparisonOperator.IN, queryAlias, ignoreStrategy));
    }

    protected <R> L in(JdbcPropertyMapping pm, R value, MatchStrategy matchStrategy, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
            getInParam(pm, value), ComparisonOperator.IN, matchStrategy, queryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    protected L ni(JdbcClassMapping<?> classMapping, SerializableIntSupplier property, String queryAlias,
        IntPredicate ignoreStrategy) {
        return ni(classMapping, property, property.getAsInt(), queryAlias, v -> ignoreStrategy.test((Integer) v));
    }

    protected L ni(JdbcClassMapping<?> classMapping, SerializableIntSupplier property, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return ni(classMapping, property, property.getAsInt(), queryAlias, ignoreStrategy);
    }

    protected L ni(JdbcClassMapping<?> classMapping, SerializableLongSupplier property, String queryAlias,
        LongPredicate ignoreStrategy) {
        return ni(classMapping, property, property.getAsLong(), queryAlias, v -> ignoreStrategy.test((Long) v));
    }

    protected L ni(JdbcClassMapping<?> classMapping, SerializableLongSupplier property, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return ni(classMapping, property, property.getAsLong(), queryAlias, ignoreStrategy);
    }

    protected L ni(JdbcClassMapping<?> classMapping, SerializableDoubleSupplier property, String queryAlias,
        DoublePredicate ignoreStrategy) {
        return ni(classMapping, property, property.getAsDouble(), queryAlias, v -> ignoreStrategy.test((Long) v));
    }

    protected L ni(JdbcClassMapping<?> classMapping, SerializableDoubleSupplier property, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return ni(classMapping, property, property.getAsDouble(), queryAlias, ignoreStrategy);
    }

    protected <R> L ni(JdbcClassMapping<?> classMapping, SerializableSupplier<R> property, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return ni(classMapping, property, property.get(), queryAlias, ignoreStrategy);
    }

    protected L ni(JdbcClassMapping<?> classMapping, SerializableToIntFunction<?> property, int value,
        String queryAlias, IntPredicate ignoreStrategy) {
        return ni(classMapping, (Serializable) property, value, queryAlias, v -> ignoreStrategy.test((Integer) v));
    }

    protected L ni(JdbcClassMapping<?> classMapping, SerializableToLongFunction<?> property, long value,
        String queryAlias, LongPredicate ignoreStrategy) {
        return ni(classMapping, (Serializable) property, value, queryAlias, v -> ignoreStrategy.test((Long) v));
    }

    protected L ni(JdbcClassMapping<?> classMapping, SerializableToDoubleFunction<?> property, double value,
        String queryAlias, DoublePredicate ignoreStrategy) {
        return ni(classMapping, (Serializable) property, value, queryAlias, v -> ignoreStrategy.test((Double) v));
    }

    protected <R> L ni(JdbcClassMapping<?> classMapping, Serializable property, R value, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return ni(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias, ignoreStrategy);
    }

    protected <R> L ni(JdbcClassMapping<?> classMapping, Serializable property, R value, MatchStrategy matchStrategy,
        String queryAlias, Predicate<?> ignoreStrategy) {
        return ni(classMapping.getPropertyMapping(getPropertyName(property)), value, matchStrategy, queryAlias,
            ignoreStrategy);
    }

    protected <R> L ni(JdbcPropertyMapping pm, R value, String queryAlias, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
            getInParam(pm, value), ComparisonOperator.NI, queryAlias, ignoreStrategy));
    }

    protected <R> L ni(JdbcPropertyMapping pm, R value, MatchStrategy matchStrategy, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
            getInParam(pm, value), ComparisonOperator.NI, matchStrategy, queryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    protected L isn(JdbcClassMapping<?> classMapping, Serializable property, Boolean value, String queryAlias) {
        return isn(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias);
    }

    protected L isn(JdbcPropertyMapping pm, Boolean value, String queryAlias) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(), value,
            ComparisonOperator.ISN, queryAlias, getIgnoreStrategy()));
    }

    protected L inn(JdbcClassMapping<?> classMapping, Serializable property, Boolean value, String queryAlias) {
        return inn(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias);
    }

    protected L inn(JdbcPropertyMapping pm, Boolean value, String queryAlias) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(), value,
            ComparisonOperator.INN, queryAlias, getIgnoreStrategy()));
    }

    // ********************************************************************

    protected L ge(JdbcClassMapping<?> classMapping, SerializableIntSupplier property, String queryAlias,
        IntPredicate ignoreStrategy) {
        return ge(classMapping, property, property.getAsInt(), queryAlias, v -> ignoreStrategy.test((Integer) v));
    }

    protected L ge(JdbcClassMapping<?> classMapping, SerializableIntSupplier property, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return ge(classMapping, property, property.getAsInt(), queryAlias, ignoreStrategy);
    }

    protected L ge(JdbcClassMapping<?> classMapping, SerializableLongSupplier property, String queryAlias,
        LongPredicate ignoreStrategy) {
        return ge(classMapping, property, property.getAsLong(), queryAlias, v -> ignoreStrategy.test((Long) v));
    }

    protected L ge(JdbcClassMapping<?> classMapping, SerializableLongSupplier property, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return ge(classMapping, property, property.getAsLong(), queryAlias, ignoreStrategy);
    }

    protected L ge(JdbcClassMapping<?> classMapping, SerializableDoubleSupplier property, String queryAlias,
        DoublePredicate ignoreStrategy) {
        return ge(classMapping, property, property.getAsDouble(), queryAlias, v -> ignoreStrategy.test((Double) v));
    }

    protected L ge(JdbcClassMapping<?> classMapping, SerializableDoubleSupplier property, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return ge(classMapping, property, property.getAsDouble(), queryAlias, ignoreStrategy);
    }

    protected <V> L ge(JdbcClassMapping<?> classMapping, SerializableSupplier<V> property, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return ge(classMapping, property, property.get(), queryAlias, ignoreStrategy);
    }

    protected L ge(JdbcClassMapping<?> classMapping, SerializableStringSupplier property, MatchStrategy matchStrategy,
        String queryAlias, Predicate<?> ignoreStrategy) {
        return ge(classMapping, property, property.get(), matchStrategy, queryAlias, ignoreStrategy);
    }

    protected L ge(JdbcClassMapping<?> classMapping, SerializableToIntFunction<?> name, int value, String queryAlias,
        IntPredicate ignoreStrategy) {
        return ge(classMapping, (Serializable) name, value, queryAlias, v -> ignoreStrategy.test((Integer) v));
    }

    protected L ge(JdbcClassMapping<?> classMapping, SerializableToIntFunction<?> name, int value, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return ge(classMapping, (Serializable) name, value, queryAlias, ignoreStrategy);
    }

    protected L ge(JdbcClassMapping<?> classMapping, SerializableToLongFunction<?> name, long value, String queryAlias,
        LongPredicate ignoreStrategy) {
        return ge(classMapping, (Serializable) name, value, queryAlias, v -> ignoreStrategy.test((Long) v));
    }

    protected L ge(JdbcClassMapping<?> classMapping, SerializableToLongFunction<?> name, long value, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return ge(classMapping, (Serializable) name, value, queryAlias, ignoreStrategy);
    }

    protected L ge(JdbcClassMapping<?> classMapping, SerializableToDoubleFunction<?> name, double value,
        String queryAlias, DoublePredicate ignoreStrategy) {
        return ge(classMapping, (Serializable) name, value, queryAlias, v -> ignoreStrategy.test((Double) v));
    }

    protected L ge(JdbcClassMapping<?> classMapping, SerializableToDoubleFunction<?> name, double value,
        String queryAlias, Predicate<?> ignoreStrategy) {
        return ge(classMapping, (Serializable) name, value, queryAlias, ignoreStrategy);
    }

    protected <V> L ge(JdbcClassMapping<?> classMapping, Serializable name, V value, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return ge(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    }

    protected <V> L ge(JdbcClassMapping<?> classMapping, Serializable name, V value, String queryAlias,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return ge(classMapping.getPropertyMapping(getPropertyName(name)), value, matchStrategy, queryAlias,
            ignoreStrategy);
    }

    protected <V> L ge(JdbcClassMapping<?> classMapping, Serializable name, V value, MatchStrategy matchStrategy,
        String queryAlias, Predicate<?> ignoreStrategy) {
        return ge(classMapping.getPropertyMapping(getPropertyName(name)), value, matchStrategy, queryAlias,
            ignoreStrategy);
    }

    protected <V> L ge(JdbcPropertyMapping pm, V value, String queryAlias, Predicate<?> ignoreStrategy) {
        return ge(pm, value, MatchStrategy.AUTO, queryAlias, ignoreStrategy);
    }

    protected <V> L ge(JdbcPropertyMapping pm, V value, MatchStrategy matchStrategy, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
            getFieldValueOperator(pm, value), ComparisonOperator.GE, matchStrategy, queryAlias, ignoreStrategy));
    }

    // ********************************************************************

    protected <V> L ba(JdbcClassMapping<?> classMapping, Serializable name, V min, V max, String queryAlias,
        BiPredicate<V, V> ignoreStrategy) {
        return ba(classMapping.getPropertyMapping(getPropertyName(name)), min, max, queryAlias,
            p -> ignoreStrategy.test(min, max));
    }

    protected <V> L ba(JdbcClassMapping<?> classMapping, Serializable name, V min, V max, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return ba(classMapping.getPropertyMapping(getPropertyName(name)), min, max, queryAlias, ignoreStrategy);
    }

    protected <V> L ba(JdbcPropertyMapping pm, V min, V max, String queryAlias, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
            new FieldValueOperator[] { getFieldValueOperator(pm, min), getFieldValueOperator(pm, max) },
            ComparisonOperator.BA, queryAlias, ignoreStrategy));
    }

    // ********************************************************************

    protected <V> L nba(JdbcClassMapping<?> classMapping, Serializable name, V min, V max, String queryAlias,
        BiPredicate<V, V> ignoreStrategy) {
        return nba(classMapping.getPropertyMapping(getPropertyName(name)), min, max, queryAlias,
            p -> ignoreStrategy.test(min, max));
    }

    protected <V> L nba(JdbcClassMapping<?> classMapping, Serializable name, V min, V max, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return nba(classMapping.getPropertyMapping(getPropertyName(name)), min, max, queryAlias, ignoreStrategy);
    }

    protected <V> L nba(JdbcPropertyMapping pm, V min, V max, String queryAlias, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
            new FieldValueOperator[] { getFieldValueOperator(pm, min), getFieldValueOperator(pm, max) },
            ComparisonOperator.NBA, queryAlias, ignoreStrategy));
    }

    // ********************************************************************

    protected L gt(JdbcClassMapping<?> classMapping, SerializableIntSupplier property, String queryAlias,
        IntPredicate ignoreStrategy) {
        return gt(classMapping, property, property.getAsInt(), queryAlias, v -> ignoreStrategy.test((Integer) v));
    }

    protected L gt(JdbcClassMapping<?> classMapping, SerializableIntSupplier property, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return gt(classMapping, property, property.getAsInt(), queryAlias, ignoreStrategy);
    }

    protected L gt(JdbcClassMapping<?> classMapping, SerializableLongSupplier property, String queryAlias,
        LongPredicate ignoreStrategy) {
        return gt(classMapping, property, property.getAsLong(), queryAlias, v -> ignoreStrategy.test((Long) v));
    }

    protected L gt(JdbcClassMapping<?> classMapping, SerializableLongSupplier property, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return gt(classMapping, property, property.getAsLong(), queryAlias, ignoreStrategy);
    }

    protected L gt(JdbcClassMapping<?> classMapping, SerializableDoubleSupplier property, String queryAlias,
        DoublePredicate ignoreStrategy) {
        return gt(classMapping, property, property.getAsDouble(), queryAlias, v -> ignoreStrategy.test((Double) v));
    }

    protected L gt(JdbcClassMapping<?> classMapping, SerializableDoubleSupplier property, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return gt(classMapping, property, property.getAsDouble(), queryAlias, ignoreStrategy);
    }

    protected <V> L gt(JdbcClassMapping<?> classMapping, SerializableSupplier<V> property, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return gt(classMapping, property, property.get(), queryAlias, ignoreStrategy);
    }

    protected L gt(JdbcClassMapping<?> classMapping, SerializableStringSupplier property, MatchStrategy matchStrategy,
        String queryAlias, Predicate<?> ignoreStrategy) {
        return gt(classMapping, property, property.get(), matchStrategy, queryAlias, ignoreStrategy);
    }

    protected L gt(JdbcClassMapping<?> classMapping, SerializableToIntFunction<?> name, int value, String queryAlias,
        IntPredicate ignoreStrategy) {
        return gt(classMapping, (Serializable) name, value, queryAlias, v -> ignoreStrategy.test((Integer) v));
    }

    protected L gt(JdbcClassMapping<?> classMapping, SerializableToIntFunction<?> name, int value, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return gt(classMapping, (Serializable) name, value, queryAlias, ignoreStrategy);
    }

    protected L gt(JdbcClassMapping<?> classMapping, SerializableToLongFunction<?> name, long value, String queryAlias,
        LongPredicate ignoreStrategy) {
        return gt(classMapping, (Serializable) name, value, queryAlias, v -> ignoreStrategy.test((Long) v));
    }

    protected L gt(JdbcClassMapping<?> classMapping, SerializableToLongFunction<?> name, long value, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return gt(classMapping, (Serializable) name, value, queryAlias, ignoreStrategy);
    }

    protected L gt(JdbcClassMapping<?> classMapping, SerializableToDoubleFunction<?> name, double value,
        String queryAlias, DoublePredicate ignoreStrategy) {
        return gt(classMapping, (Serializable) name, value, queryAlias, v -> ignoreStrategy.test((Double) v));
    }

    protected L gt(JdbcClassMapping<?> classMapping, SerializableToDoubleFunction<?> name, double value,
        String queryAlias, Predicate<?> ignoreStrategy) {
        return gt(classMapping, (Serializable) name, value, queryAlias, ignoreStrategy);
    }

    protected <V> L gt(JdbcClassMapping<?> classMapping, Serializable name, V value, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return gt(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    }

    protected L gt(JdbcClassMapping<?> classMapping, Serializable name, String value, MatchStrategy matchStrategy,
        String queryAlias, Predicate<?> ignoreStrategy) {
        return gt(classMapping.getPropertyMapping(getPropertyName(name)), value, matchStrategy, queryAlias,
            ignoreStrategy);
    }

    protected <V> L gt(JdbcPropertyMapping pm, V value, String queryAlias, Predicate<?> ignoreStrategy) {
        return gt(pm, value, MatchStrategy.AUTO, queryAlias, ignoreStrategy);
    }

    protected <V> L gt(JdbcPropertyMapping pm, V value, MatchStrategy matchStrategy, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
            getFieldValueOperator(pm, value), ComparisonOperator.GT, matchStrategy, queryAlias, ignoreStrategy));
    }

    // ********************************************************************

    protected L le(JdbcClassMapping<?> classMapping, SerializableIntSupplier property, String queryAlias,
        IntPredicate ignoreStrategy) {
        return le(classMapping, property, property.getAsInt(), queryAlias, v -> ignoreStrategy.test((Integer) v));
    }

    protected L le(JdbcClassMapping<?> classMapping, SerializableIntSupplier property, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return le(classMapping, property, property.getAsInt(), queryAlias, ignoreStrategy);
    }

    protected L le(JdbcClassMapping<?> classMapping, SerializableLongSupplier property, String queryAlias,
        LongPredicate ignoreStrategy) {
        return le(classMapping, property, property.getAsLong(), queryAlias, v -> ignoreStrategy.test((Long) v));
    }

    protected L le(JdbcClassMapping<?> classMapping, SerializableLongSupplier property, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return le(classMapping, property, property.getAsLong(), queryAlias, ignoreStrategy);
    }

    protected L le(JdbcClassMapping<?> classMapping, SerializableDoubleSupplier property, String queryAlias,
        DoublePredicate ignoreStrategy) {
        return le(classMapping, property, property.getAsDouble(), queryAlias, v -> ignoreStrategy.test((Double) v));
    }

    protected L le(JdbcClassMapping<?> classMapping, SerializableDoubleSupplier property, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return le(classMapping, property, property.getAsDouble(), queryAlias, ignoreStrategy);
    }

    protected <V> L le(JdbcClassMapping<?> classMapping, SerializableSupplier<V> property, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return le(classMapping, property, property.get(), queryAlias, ignoreStrategy);
    }

    protected L le(JdbcClassMapping<?> classMapping, SerializableStringSupplier property, MatchStrategy matchStrategy,
        String queryAlias, Predicate<?> ignoreStrategy) {
        return le(classMapping, property, property.get(), matchStrategy, queryAlias, ignoreStrategy);
    }

    protected <V> L le(JdbcClassMapping<?> classMapping, Serializable name, V value, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return le(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    }

    protected <V> L le(JdbcClassMapping<?> classMapping, Serializable name, V value, MatchStrategy matchStrategy,
        String queryAlias, Predicate<?> ignoreStrategy) {
        return le(classMapping.getPropertyMapping(getPropertyName(name)), value, matchStrategy, queryAlias,
            ignoreStrategy);
    }

    protected L le(JdbcClassMapping<?> classMapping, SerializableToIntFunction<?> name, int value, String queryAlias,
        IntPredicate ignoreStrategy) {
        return le(classMapping, (Serializable) name, value, queryAlias, v -> ignoreStrategy.test((Integer) v));
    }

    protected L le(JdbcClassMapping<?> classMapping, SerializableToIntFunction<?> name, int value, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return le(classMapping, (Serializable) name, value, queryAlias, ignoreStrategy);
    }

    protected L le(JdbcClassMapping<?> classMapping, SerializableToLongFunction<?> name, long value, String queryAlias,
        LongPredicate ignoreStrategy) {
        return le(classMapping, (Serializable) name, value, queryAlias, v -> ignoreStrategy.test((Long) v));
    }

    protected L le(JdbcClassMapping<?> classMapping, SerializableToLongFunction<?> name, long value, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return le(classMapping, (Serializable) name, value, queryAlias, ignoreStrategy);
    }

    protected L le(JdbcClassMapping<?> classMapping, SerializableToDoubleFunction<?> name, double value,
        String queryAlias, DoublePredicate ignoreStrategy) {
        return le(classMapping, (Serializable) name, value, queryAlias, v -> ignoreStrategy.test((Double) v));
    }

    protected L le(JdbcClassMapping<?> classMapping, SerializableToDoubleFunction<?> name, double value,
        String queryAlias, Predicate<?> ignoreStrategy) {
        return le(classMapping, (Serializable) name, value, queryAlias, ignoreStrategy);
    }

    protected <V> L le(JdbcPropertyMapping pm, V value, String queryAlias, Predicate<?> ignoreStrategy) {
        return le(pm, value, MatchStrategy.AUTO, queryAlias, ignoreStrategy);
    }

    protected <V> L le(JdbcPropertyMapping pm, V value, MatchStrategy matchStrategy, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
            getFieldValueOperator(pm, value), ComparisonOperator.LE, matchStrategy, queryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    protected L lt(JdbcClassMapping<?> classMapping, SerializableIntSupplier property, String queryAlias,
        IntPredicate ignoreStrategy) {
        return lt(classMapping, property, property.getAsInt(), queryAlias, v -> ignoreStrategy.test((Integer) v));
    }

    protected L lt(JdbcClassMapping<?> classMapping, SerializableIntSupplier property, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return lt(classMapping, property, property.getAsInt(), queryAlias, ignoreStrategy);
    }

    protected L lt(JdbcClassMapping<?> classMapping, SerializableLongSupplier property, String queryAlias,
        LongPredicate ignoreStrategy) {
        return lt(classMapping, property, property.getAsLong(), queryAlias, v -> ignoreStrategy.test((Long) v));
    }

    protected L lt(JdbcClassMapping<?> classMapping, SerializableLongSupplier property, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return lt(classMapping, property, property.getAsLong(), queryAlias, ignoreStrategy);
    }

    protected L lt(JdbcClassMapping<?> classMapping, SerializableDoubleSupplier property, String queryAlias,
        DoublePredicate ignoreStrategy) {
        return lt(classMapping, property, property.getAsDouble(), queryAlias, v -> ignoreStrategy.test((Double) v));
    }

    protected L lt(JdbcClassMapping<?> classMapping, SerializableDoubleSupplier property, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return lt(classMapping, property, property.getAsDouble(), queryAlias, ignoreStrategy);
    }

    protected <V> L lt(JdbcClassMapping<?> classMapping, SerializableSupplier<V> property, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return lt(classMapping, property, property.get(), queryAlias, ignoreStrategy);
    }

    protected L lt(JdbcClassMapping<?> classMapping, SerializableStringSupplier property, MatchStrategy matchStrategy,
        String queryAlias, Predicate<?> ignoreStrategy) {
        return lt(classMapping, property, property.get(), matchStrategy, queryAlias, ignoreStrategy);
    }

    protected <V> L lt(JdbcClassMapping<?> classMapping, Serializable name, V value, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return lt(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    }

    protected <V> L lt(JdbcClassMapping<?> classMapping, Serializable name, V value, MatchStrategy matchStrategy,
        String queryAlias, Predicate<?> ignoreStrategy) {
        return lt(classMapping.getPropertyMapping(getPropertyName(name)), value, matchStrategy, queryAlias,
            ignoreStrategy);
    }

    protected L lt(JdbcClassMapping<?> classMapping, SerializableToIntFunction<?> name, int value, String queryAlias,
        IntPredicate ignoreStrategy) {
        return lt(classMapping, (Serializable) name, value, queryAlias, v -> ignoreStrategy.test((Integer) v));
    }

    protected L lt(JdbcClassMapping<?> classMapping, SerializableToIntFunction<?> name, int value, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return lt(classMapping, (Serializable) name, value, queryAlias, ignoreStrategy);
    }

    protected L lt(JdbcClassMapping<?> classMapping, SerializableToLongFunction<?> name, long value, String queryAlias,
        LongPredicate ignoreStrategy) {
        return lt(classMapping, (Serializable) name, value, queryAlias, v -> ignoreStrategy.test((Long) v));
    }

    protected L lt(JdbcClassMapping<?> classMapping, SerializableToLongFunction<?> name, long value, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return lt(classMapping, (Serializable) name, value, queryAlias, ignoreStrategy);
    }

    protected L lt(JdbcClassMapping<?> classMapping, SerializableToDoubleFunction<?> name, double value,
        String queryAlias, DoublePredicate ignoreStrategy) {
        return lt(classMapping, (Serializable) name, value, queryAlias, v -> ignoreStrategy.test((Double) v));
    }

    protected L lt(JdbcClassMapping<?> classMapping, SerializableToDoubleFunction<?> name, double value,
        String queryAlias, Predicate<?> ignoreStrategy) {
        return lt(classMapping, (Serializable) name, value, queryAlias, ignoreStrategy);
    }

    protected <V> L lt(JdbcPropertyMapping pm, V value, String queryAlias, Predicate<?> ignoreStrategy) {
        return lt(pm, value, MatchStrategy.AUTO, queryAlias, ignoreStrategy);
    }

    protected <V> L lt(JdbcPropertyMapping pm, V value, MatchStrategy matchStrategy, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
            getFieldValueOperator(pm, value), ComparisonOperator.LT, matchStrategy, queryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    /**
     * Supplier.
     *
     * @param <R>   the generic type
     * @param info  the info
     * @param value the value
     * @return LogicExpressionist
     */
    protected <R> List<Tuple2<String, Optional<R>>> supplier(SerializedLambdaInfo info, R value) {
        return supplier(info, value, classMapping);
    }

    /**
     * Supplier.
     *
     * @param <R>  the generic type
     * @param info the info
     * @return LogicExpressionist
     */
    protected <R> List<Tuple2<String, Optional<R>>> supplier(SerializableSupplierLambdaInfo<R> info) {
        return supplier(info, classMapping);
    }

    // ********************************************************************
    // property
    // ********************************************************************

    /**
     * Gets the entity relation.
     *
     * @return the entity relation
     */
    public ER getEntityRelation() {
        return entityRelation;
    }

    @Override
    public Jdbc getJdbc() {
        return entityRelation.getJdbc();
    }
}