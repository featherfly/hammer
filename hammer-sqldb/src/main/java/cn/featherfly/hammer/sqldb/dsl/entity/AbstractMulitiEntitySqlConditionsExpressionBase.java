
package cn.featherfly.hammer.sqldb.dsl.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.db.FieldValueOperator;
import cn.featherfly.common.db.SqlUtils;
import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.builder.model.ColumnElement;
import cn.featherfly.common.db.dialect.Join;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.exception.NotImplementedException;
import cn.featherfly.common.exception.UnsupportedException;
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
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.Str;
import cn.featherfly.common.operator.ComparisonOperator;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.Execution;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.common.repository.mapping.PropertyMapping.Mode;
import cn.featherfly.common.tuple.Tuple2;
import cn.featherfly.hammer.config.dsl.ConditionConfig;
import cn.featherfly.hammer.expression.condition.ConditionConfigureExpression;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.NativeStringConditionExpression;
import cn.featherfly.hammer.expression.condition.ParamedExpression;
import cn.featherfly.hammer.expression.entity.EntityConditionGroupExpression;
import cn.featherfly.hammer.expression.entity.EntityConditionGroupLogicExpression;
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
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlRelation.EntityRelation;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.AbstractMulitiEntityConditionExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.propery.EntityDatePropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.propery.EntityDoublePropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.propery.EntityEnumPropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.propery.EntityIntPropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.propery.EntityLocalDatePropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.propery.EntityLocalDateTimePropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.propery.EntityLocalTimePropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.propery.EntityLongPropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.propery.EntityNumberPropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.propery.EntityStringPropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.propery.EntityTypePropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.sql.dml.SqlConditionExpressionBuilder;

/**
 * abstract muliti entity sql condition expression base.
 *
 * @author zhongj
 * @param <E1> filterable entity type 1
 * @param <C> condition expression
 * @param <L> logic expression
 * @param <CC> condition config
 * @param <ER> entity sql relation
 * @param <B> sql builder
 */
@SuppressWarnings("unchecked")
public abstract class AbstractMulitiEntitySqlConditionsExpressionBase<E1, C extends ConditionExpression,
    L extends LogicExpression<C, L>, CC extends ConditionConfig<CC>, ER extends EntitySqlRelation<ER, B>,
    B extends SqlBuilder> extends AbstractMulitiEntityConditionExpression<C, L, CC>
    implements EntityBetweenExpression<E1, C, L>, EntityNotBetweenExpression<E1, C, L> //
    , EntityContainsExpression<E1, C, L>, EntityNotContainsExpression<E1, C, L>//
    , EntityEndWithExpression<E1, C, L>, EntityNotEndWithExpression<E1, C, L> //
    , EntityEqualsExpression<E1, C, L>, EntityIsNotNullExpression<E1, C, L>//
    , EntityGreatEqualsExpression<E1, C, L>, EntityGreatThanExpression<E1, C, L> //
    , EntityInExpression<E1, C, L>, EntityNotInExpression<E1, C, L>//
    , EntityIsNullExpression<E1, C, L>, EntityNotEqualsExpression<E1, C, L> //
    , EntityLessEqualsExpression<E1, C, L>, EntityLessThanExpression<E1, C, L> //
    , EntityStartWithExpression<E1, C, L>, EntityNotStartWithExpression<E1, C, L>//
    , EntityLikeExpression<E1, C, L>, EntityNotLikeExpression<E1, C, L>//
    , EntityPropertyExpression<E1, C, L>, NativeStringConditionExpression<C, L> //
    , ConditionConfigureExpression<C, CC> {

    /** The factory. */
    protected final JdbcMappingFactory factory;

    /** The alias manager. */
    protected AliasManager aliasManager;

    /** The class mapping. */
    protected JdbcClassMapping<E1> classMapping;

    /** The table alias. */
    protected String tableAlias;

    /** The entity sql relation. */
    protected final ER entityRelation;

    /** The index. */
    protected int index;

    protected List<Serializable> propertyList = new ArrayList<>();

    /**
     * Instantiates a new abstract sql condition group expression.
     *
     * @param parent parent group
     * @param factory the factory
     * @param entityRelation the entity relation
     */
    protected AbstractMulitiEntitySqlConditionsExpressionBase(L parent, JdbcMappingFactory factory, ER entityRelation) {
        super(parent, entityRelation.getJdbc().getDialect(), entityRelation.getConfig());
        this.factory = factory;
        EntityRelation<E1> erm = (EntityRelation<E1>) entityRelation.getEntityRelationTuple().getOrNull0();
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
        return entityRelation.getEntityRelation(index).getTableAlias();
    }

    protected String getAlias() {
        return getAlias(index);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <M extends ClassMapping<E, P>, E, P extends PropertyMapping<P>> M getClassMapping(int index) {
        return (M) entityRelation.getEntityRelation(index).getClassMapping();
    }

    protected JdbcClassMapping<Object> getClassMapping() {
        return getClassMapping(index);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L eq(SerializableFunction<E1, R> name, R value) {
        return eq(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L eq(SerializableFunction<E1, R> name, R value, Predicate<R> ignoreStrategy) {
        return eq(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableToCharFunction<E1> name, char value) {
        return eq(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableToCharFunction<E1> name, char value, CharPredicate ignoreStrategy) {
        return eq(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableToIntFunction<E1> name, int value) {
        return eq(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableToIntFunction<E1> name, int value, IntPredicate ignoreStrategy) {
        return eq(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableToLongFunction<E1> name, long value) {
        return eq(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableToLongFunction<E1> name, long value, LongPredicate ignoreStrategy) {
        return eq(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableToDoubleFunction<E1> name, double value) {
        return eq(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableToDoubleFunction<E1> name, double value, DoublePredicate ignoreStrategy) {
        return eq(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L eq(SerializableToNumberFunction<E1, N> name, N value) {
        return eq(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L eq(SerializableToNumberFunction<E1, N> name, N value, Predicate<N> ignoreStrategy) {
        return eq(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L eq(SerializableToDateFunction<E1, D> name, D value) {
        return eq(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L eq(SerializableToDateFunction<E1, D> name, D value, Predicate<D> ignoreStrategy) {
        return eq(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L eq(SerializableToEnumFunction<E1, E> name, E value) {
        return eq(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L eq(SerializableToEnumFunction<E1, E> name, E value, Predicate<E> ignoreStrategy) {
        return eq(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableToLocalDateFunction<E1> name, LocalDate value) {
        return eq(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableToLocalDateFunction<E1> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return eq(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableToLocalDateTimeFunction<E1> name, LocalDateTime value) {
        return eq(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableToLocalDateTimeFunction<E1> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return eq(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableToLocalTimeFunction<E1> name, LocalTime value) {
        return eq(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableToLocalTimeFunction<E1> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return eq(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableToStringFunction<E1> name, String value, MatchStrategy matchStrategy) {
        return eq(getClassMapping(), name, value, getAlias(), matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableToStringFunction<E1> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return eq(getClassMapping(), name, value, getAlias(), matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L eq(SerializableSupplier<R> property, R value) {
        return eq(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L eq(SerializableSupplier<R> property, R value, Predicate<R> ignoreStrategy) {
        return eq(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableBooleanSupplier property, boolean value) {
        return eq(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableBoolSupplier property, Boolean value) {
        return eq(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableBoolSupplier property, Boolean value, Predicate<Boolean> ignoreStrategy) {
        return eq(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableCharSupplier property, char value) {
        return eq(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableCharSupplier property, char value, CharPredicate ignoreStrategy) {
        return eq(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableIntSupplier property, int value) {
        return eq(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy) {
        return eq(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableDoubleSupplier property, double value) {
        return eq(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy) {
        return eq(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableLongSupplier property, long value) {
        return eq(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy) {
        return eq(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L eq(SerializableNumberSupplier<N> property, N value) {
        return eq(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L eq(SerializableNumberSupplier<N> property, N value, Predicate<N> ignoreStrategy) {
        return eq(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L eq(SerializableDateSupplier<D> property, D value) {
        return eq(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L eq(SerializableDateSupplier<D> property, D value, Predicate<D> ignoreStrategy) {
        return eq(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L eq(SerializableEnumSupplier<E> property, E value) {
        return eq(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L eq(SerializableEnumSupplier<E> property, E value, Predicate<E> ignoreStrategy) {
        return eq(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableLocalDateSupplier property, LocalDate value) {
        return eq(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableLocalDateSupplier property, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return eq(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableLocalDateTimeSupplier property, LocalDateTime value) {
        return eq(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableLocalDateTimeSupplier property, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return eq(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableLocalTimeSupplier property, LocalTime value) {
        return eq(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableLocalTimeSupplier property, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return eq(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return eq(getClassMapping(), property, value, getAlias(), matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return eq(getClassMapping(), property, value, getAlias(), matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ne(SerializableFunction<E1, R> name, R value) {
        return ne(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ne(SerializableFunction<E1, R> name, R value, Predicate<R> ignoreStrategy) {
        return ne(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableToIntFunction<E1> name, int value) {
        return ne(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableToIntFunction<E1> name, int value, IntPredicate ignoreStrategy) {
        return ne(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableToDoubleFunction<E1> name, double value) {
        return ne(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableToLongFunction<E1> name, long value) {
        return ne(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableToLongFunction<E1> name, long value, LongPredicate ignoreStrategy) {
        return ne(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ne(SerializableToNumberFunction<E1, N> name, N value) {
        return ne(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ne(SerializableToNumberFunction<E1, N> name, N value, Predicate<N> ignoreStrategy) {
        return ne(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ne(SerializableToEnumFunction<E1, E> name, E value) {
        return ne(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ne(SerializableToEnumFunction<E1, E> name, E value, Predicate<E> ignoreStrategy) {
        return ne(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ne(SerializableToDateFunction<E1, D> name, D value) {
        return ne(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ne(SerializableToDateFunction<E1, D> name, D value, Predicate<D> ignoreStrategy) {
        return ne(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableToDoubleFunction<E1> name, double value, DoublePredicate ignoreStrategy) {
        return ne(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableToLocalDateFunction<E1> name, LocalDate value) {
        return ne(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableToLocalDateFunction<E1> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ne(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableToLocalDateTimeFunction<E1> name, LocalDateTime value) {
        return ne(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableToLocalDateTimeFunction<E1> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return ne(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableToLocalTimeFunction<E1> name, LocalTime value) {
        return ne(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableToLocalTimeFunction<E1> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ne(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableToStringFunction<E1> name, String value, MatchStrategy matchStrategy) {
        return ne(getClassMapping(), name, value, getAlias(), matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableToStringFunction<E1> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ne(getClassMapping(), name, value, getAlias(), matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableBooleanSupplier property, boolean value) {
        return ne(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableBoolSupplier property, Boolean value) {
        return ne(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableBoolSupplier property, Boolean value, Predicate<Boolean> ignoreStrategy) {
        return ne(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ne(SerializableSupplier<R> property, R value) {
        return ne(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ne(SerializableSupplier<R> property, R value, Predicate<R> ignoreStrategy) {
        return ne(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableCharSupplier property, char value) {
        return ne(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableCharSupplier property, char value, CharPredicate ignoreStrategy) {
        return ne(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableIntSupplier property, int value) {
        return ne(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy) {
        return ne(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableLongSupplier property, long value) {
        return ne(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy) {
        return ne(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableDoubleSupplier property, double value) {
        return ne(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy) {
        return ne(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ne(SerializableNumberSupplier<N> property, N value) {
        return ne(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ne(SerializableNumberSupplier<N> property, N value, Predicate<N> ignoreStrategy) {
        return ne(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ne(SerializableEnumSupplier<E> property, E value) {
        return ne(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ne(SerializableEnumSupplier<E> property, E value, Predicate<E> ignoreStrategy) {
        return ne(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ne(SerializableDateSupplier<D> property, D value) {
        return ne(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ne(SerializableDateSupplier<D> property, D value, Predicate<D> ignoreStrategy) {
        return ne(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableLocalDateSupplier property, LocalDate value) {
        return ne(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableLocalDateSupplier property, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ne(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableLocalDateTimeSupplier property, LocalDateTime value) {
        return ne(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableLocalDateTimeSupplier property, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return ne(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableLocalTimeSupplier property, LocalTime value) {
        return ne(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableLocalTimeSupplier property, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ne(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return ne(getClassMapping(), property, value, getAlias(), matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ne(getClassMapping(), property, value, getAlias(), matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(SerializableFunction<E1, String> name, String value, MatchStrategy matchStrategy) {
        return lk(getClassMapping(), name, value, getAlias(), matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(SerializableFunction<E1, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return lk(getClassMapping(), name, value, getAlias(), matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return lk(getClassMapping(), property, value, getAlias(), matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return lk(getClassMapping(), property, value, getAlias(), matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl(SerializableFunction<E1, String> name, String value, MatchStrategy matchStrategy) {
        return nl(getClassMapping(), name, value, getAlias(), matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl(SerializableFunction<E1, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nl(getClassMapping(), name, value, getAlias(), matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return nl(getClassMapping(), property, value, getAlias(), matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nl(getClassMapping(), property, value, getAlias(), matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(SerializableFunction<E1, String> name, String value, MatchStrategy matchStrategy) {
        return sw(getClassMapping(), name, value, getAlias(), matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(SerializableFunction<E1, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return sw(getClassMapping(), name, value, getAlias(), matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return sw(getClassMapping(), property, value, getAlias(), matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return sw(getClassMapping(), property, value, getAlias(), matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw(SerializableFunction<E1, String> name, String value, MatchStrategy matchStrategy) {
        return nsw(getClassMapping(), name, value, getAlias(), matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw(SerializableFunction<E1, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nsw(getClassMapping(), name, value, getAlias(), matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return nsw(getClassMapping(), property, value, getAlias(), matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nsw(getClassMapping(), property, value, getAlias(), matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(SerializableFunction<E1, String> name, String value, MatchStrategy matchStrategy) {
        return ew(getClassMapping(), name, value, getAlias(), matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(SerializableFunction<E1, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ew(getClassMapping(), name, value, getAlias(), matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return ew(getClassMapping(), property, value, getAlias(), matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ew(getClassMapping(), property, value, getAlias(), matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L newv(SerializableFunction<E1, String> name, String value, MatchStrategy matchStrategy) {
        return newv(getClassMapping(), name, value, getAlias(), matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L newv(SerializableFunction<E1, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return newv(getClassMapping(), name, value, getAlias(), matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L newv(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return newv(getClassMapping(), property, value, getAlias(), matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L newv(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return newv(getClassMapping(), property, value, getAlias(), matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(SerializableFunction<E1, String> name, String value, MatchStrategy matchStrategy) {
        return co(getClassMapping(), name, value, getAlias(), matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(SerializableFunction<E1, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return co(getClassMapping(), name, value, getAlias(), matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return co(getClassMapping(), property, value, getAlias(), matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return co(getClassMapping(), property, value, getAlias(), matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco(SerializableFunction<E1, String> name, String value, MatchStrategy matchStrategy) {
        return nco(getClassMapping(), name, value, getAlias(), matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco(SerializableFunction<E1, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nco(getClassMapping(), name, value, getAlias(), matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return nco(getClassMapping(), property, value, getAlias(), matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nco(getClassMapping(), property, value, getAlias(), matchStrategy, ignoreStrategy);
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
    public <N extends Number> L ge(SerializableFunction<E1, N> name, N value) {
        return ge(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ge(SerializableFunction<E1, N> name, N value, Predicate<N> ignoreStrategy) {
        return ge(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ge(SerializableFunction<E1, D> name, D value) {
        return ge(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ge(SerializableFunction<E1, D> name, D value, Predicate<D> ignoreStrategy) {
        return ge(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableFunction<E1, LocalTime> name, LocalTime value) {
        return ge(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableFunction<E1, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ge(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableFunction<E1, LocalDate> name, LocalDate value) {
        return ge(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableFunction<E1, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ge(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableFunction<E1, LocalDateTime> name, LocalDateTime value) {
        return ge(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableFunction<E1, LocalDateTime> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return ge(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ge(SerializableFunction<E1, E> name, E value) {
        return ge(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ge(SerializableFunction<E1, E> name, E value, Predicate<E> ignoreStrategy) {
        return ge(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableFunction<E1, String> name, String value, MatchStrategy matchStrategy) {
        return ge(getClassMapping(), name, value, getAlias(), matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableFunction<E1, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ge(getClassMapping(), name, value, getAlias(), matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableToIntFunction<E1> name, int value) {
        return ge(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableToIntFunction<E1> name, int value, IntPredicate ignoreStrategy) {
        return ge(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableToLongFunction<E1> name, long value) {
        return ge(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableToLongFunction<E1> name, long value, LongPredicate ignoreStrategy) {
        return ge(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableToDoubleFunction<E1> name, double value) {
        return ge(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableToDoubleFunction<E1> name, double value, DoublePredicate ignoreStrategy) {
        return ge(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ge(SerializableDateSupplier<D> property, D value) {
        return ge(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ge(SerializableDateSupplier<D> property, D value, Predicate<D> ignoreStrategy) {
        return ge(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ge(SerializableNumberSupplier<N> property, N value) {
        return ge(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ge(SerializableNumberSupplier<N> property, N value, Predicate<N> ignoreStrategy) {
        return ge(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableLocalDateSupplier property, LocalDate value) {
        return ge(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableLocalDateSupplier property, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ge(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableLocalTimeSupplier property, LocalTime value) {
        return ge(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableLocalTimeSupplier property, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ge(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableLocalDateTimeSupplier property, LocalDateTime value) {
        return ge(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableLocalDateTimeSupplier property, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return ge(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ge(SerializableEnumSupplier<E> property, E value) {
        return ge(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ge(SerializableEnumSupplier<E> property, E value, Predicate<E> ignoreStrategy) {
        return ge(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return ge(getClassMapping(), property, value, matchStrategy, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ge(getClassMapping(), property, value, matchStrategy, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableIntSupplier property, int value) {
        return ge(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy) {
        return ge(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableLongSupplier property, long value) {
        return ge(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy) {
        return ge(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableDoubleSupplier property, double value) {
        return ge(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy) {
        return ge(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L gt(SerializableFunction<E1, N> name, N value) {
        return gt(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L gt(SerializableFunction<E1, N> name, N value, Predicate<N> ignoreStrategy) {
        return gt(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L gt(SerializableFunction<E1, E> name, E value) {
        return gt(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L gt(SerializableFunction<E1, E> name, E value, Predicate<E> ignoreStrategy) {
        return gt(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L gt(SerializableFunction<E1, D> name, D value) {
        return gt(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L gt(SerializableFunction<E1, D> name, D value, Predicate<D> ignoreStrategy) {
        return gt(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableFunction<E1, LocalTime> name, LocalTime value) {
        return gt(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableFunction<E1, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return gt(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableFunction<E1, LocalDate> name, LocalDate value) {
        return gt(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableFunction<E1, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return gt(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableFunction<E1, LocalDateTime> name, LocalDateTime value) {
        return gt(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableFunction<E1, LocalDateTime> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return gt(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableFunction<E1, String> name, String value, MatchStrategy matchStrategy) {
        return gt(getClassMapping(), name, value, matchStrategy, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableFunction<E1, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return gt(getClassMapping(), name, value, matchStrategy, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableToIntFunction<E1> name, int value) {
        return gt(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableToIntFunction<E1> name, int value, IntPredicate ignoreStrategy) {
        return gt(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableToLongFunction<E1> name, long value) {
        return gt(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableToLongFunction<E1> name, long value, LongPredicate ignoreStrategy) {
        return gt(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableToDoubleFunction<E1> name, double value) {
        return gt(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableToDoubleFunction<E1> name, double value, DoublePredicate ignoreStrategy) {
        return gt(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L gt(SerializableNumberSupplier<N> property, N value) {
        return gt(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L gt(SerializableNumberSupplier<N> property, N value, Predicate<N> ignoreStrategy) {
        return gt(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L gt(SerializableEnumSupplier<E> property, E value) {
        return gt(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L gt(SerializableEnumSupplier<E> property, E value, Predicate<E> ignoreStrategy) {
        return gt(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L gt(SerializableDateSupplier<D> property, D value) {
        return gt(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L gt(SerializableDateSupplier<D> property, D value, Predicate<D> ignoreStrategy) {
        return gt(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableLocalDateSupplier property, LocalDate value) {
        return gt(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableLocalDateSupplier property, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return gt(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableLocalTimeSupplier property, LocalTime value) {
        return gt(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableLocalTimeSupplier property, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return gt(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableLocalDateTimeSupplier property, LocalDateTime value) {
        return gt(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableLocalDateTimeSupplier property, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return gt(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return gt(getClassMapping(), property, value, matchStrategy, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return gt(getClassMapping(), property, value, matchStrategy, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableIntSupplier property, int value) {
        return gt(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy) {
        return gt(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableLongSupplier property, long value) {
        return gt(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy) {
        return gt(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableDoubleSupplier property, double value) {
        return gt(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy) {
        return gt(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L in(SerializableFunction<E1, R> name, R[] value, Predicate<R[]> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L in(SerializableFunction<E1, N> name, N value) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, getAlias(), getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L in(SerializableFunction<E1, N> name, N value, Predicate<N> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L in(SerializableFunction<E1, N> name, N[] value) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, getAlias(), getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L in(SerializableFunction<E1, N> name, N[] value, Predicate<N[]> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableFunction<E1, Integer> name, int... value) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableFunction<E1, Integer> name, int[] value, Predicate<int[]> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableFunction<E1, Long> name, long... value) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableFunction<E1, Long> name, long[] value, Predicate<long[]> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L in(SerializableFunction<E1, D> name, D value) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L in(SerializableFunction<E1, D> name, D value, Predicate<D> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L in(SerializableFunction<E1, D> name, D... value) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L in(SerializableFunction<E1, D> name, D[] value, Predicate<D[]> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L in(SerializableFunction<E1, E> name, E value) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L in(SerializableFunction<E1, E> name, E value, Predicate<E> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L in(SerializableFunction<E1, E> name, E... value) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L in(SerializableFunction<E1, E> name, E[] value, Predicate<E[]> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToLocalDateTimeFunction<E1> name, LocalDateTime value) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToLocalDateTimeFunction<E1> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToLocalDateTimeFunction<E1> name, LocalDateTime... value) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToLocalDateTimeFunction<E1> name, LocalDateTime[] value,
        Predicate<LocalDateTime[]> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToLocalDateFunction<E1> name, LocalDate value) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToLocalDateFunction<E1> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToLocalDateFunction<E1> name, LocalDate... value) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToLocalDateFunction<E1> name, LocalDate[] value, Predicate<LocalDate[]> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToLocalTimeFunction<E1> name, LocalTime value) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToLocalTimeFunction<E1> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToLocalTimeFunction<E1> name, LocalTime... value) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToLocalTimeFunction<E1> name, LocalTime[] value, Predicate<LocalTime[]> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToStringFunction<E1> name, String value) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToStringFunction<E1> name, String value, Predicate<String> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToStringFunction<E1> name, String... value) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToStringFunction<E1> name, String[] value, Predicate<String[]> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToStringFunction<E1> name, String value, MatchStrategy matchStrategy) {
        return in(getClassMapping(), name, value, matchStrategy, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToStringFunction<E1> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return in(getClassMapping(), name, value, matchStrategy, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToStringFunction<E1> name, String[] value, MatchStrategy matchStrategy) {
        return in(getClassMapping(), name, value, matchStrategy, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToStringFunction<E1> name, String[] value, MatchStrategy matchStrategy,
        Predicate<String[]> ignoreStrategy) {
        return in(getClassMapping(), name, value, matchStrategy, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L in(SerializableFunction<E1, R> name, Collection<R> value) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, getAlias(), getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L in(SerializableFunction<E1, R> name, Collection<R> value,
        Predicate<Collection<R>> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToIntFunction<E1> name, int value) {
        return in(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToIntFunction<E1> name, int value, IntPredicate ignoreStrategy) {
        return in(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToIntFunction<E1> name, int... value) {
        return in(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToIntFunction<E1> name, int[] value, Predicate<int[]> ignoreStrategy) {
        return in(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToLongFunction<E1> name, long value) {
        return in(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToLongFunction<E1> name, long value, LongPredicate ignoreStrategy) {
        return in(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToLongFunction<E1> name, long... value) {
        return in(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToLongFunction<E1> name, long[] value, Predicate<long[]> ignoreStrategy) {
        return in(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToDoubleFunction<E1> name, double value) {
        return in(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToDoubleFunction<E1> name, double value, DoublePredicate ignoreStrategy) {
        return in(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToDoubleFunction<E1> name, double... value) {
        return in(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToDoubleFunction<E1> name, double[] value, Predicate<double[]> ignoreStrategy) {
        return in(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L in(SerializableSupplier<R> property, R value) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return in(classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), value, getAlias(),
            getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L in(SerializableSupplier<R> property, R... value) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return in(classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), value, getAlias(),
            getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L in(SerializableSupplier<R> property, R value, Predicate<R> ignoreStrategy) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return in(classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), value, getAlias(),
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L in(SerializableSupplier<R> property, R[] value, Predicate<R[]> ignoreStrategy) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return in(classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), value, getAlias(),
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableIntSupplier property, int value) {
        return in(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    @Override
    public L in(SerializableIntSupplier property, int... value) {
        return in(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy) {
        return in(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableIntSupplier property, int[] value, Predicate<int[]> ignoreStrategy) {
        return in(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableLongSupplier property, long value) {
        return in(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    @Override
    public L in(SerializableLongSupplier property, long... value) {
        return in(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy) {
        return in(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableLongSupplier property, long[] value, Predicate<long[]> ignoreStrategy) {
        return in(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableDoubleSupplier property, double value) {
        return in(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    @Override
    public L in(SerializableDoubleSupplier property, double... value) {
        return in(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy) {
        return in(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    @Override
    public L in(SerializableDoubleSupplier property, double[] value, Predicate<double[]> ignoreStrategy) {
        return in(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return in(getClassMapping(), property, value, matchStrategy, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableStringSupplier property, String[] value, MatchStrategy matchStrategy) {
        return in(getClassMapping(), property, value, matchStrategy, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return in(getClassMapping(), property, value, matchStrategy, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableStringSupplier property, String[] value, MatchStrategy matchStrategy,
        Predicate<String[]> ignoreStrategy) {
        return in(getClassMapping(), property, value, matchStrategy, getAlias(), ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni(SerializableFunction<E1, R> name, R value) {
        return ni(classMapping.getPropertyMapping(getPropertyName(name)), value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni(SerializableFunction<E1, R> name, R value, Predicate<R> ignoreStrategy) {
        return ni(classMapping.getPropertyMapping(getPropertyName(name)), value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni(SerializableFunction<E1, R> name, R... value) {
        return ni(classMapping.getPropertyMapping(getPropertyName(name)), value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni(SerializableFunction<E1, R> name, R[] value, Predicate<R[]> ignoreStrategy) {
        return ni(classMapping.getPropertyMapping(getPropertyName(name)), value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni(SerializableFunction<E1, R> name, Collection<R> value) {
        return ni(classMapping.getPropertyMapping(getPropertyName(name)), value, getAlias(), getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni(SerializableFunction<E1, R> name, Collection<R> value,
        Predicate<Collection<R>> ignoreStrategy) {
        return ni(classMapping.getPropertyMapping(getPropertyName(name)), value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableToIntFunction<E1> name, int value) {
        return ni(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableToIntFunction<E1> name, int value, IntPredicate ignoreStrategy) {
        return ni(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableToLongFunction<E1> name, long value) {
        return ni(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableToLongFunction<E1> name, long value, LongPredicate ignoreStrategy) {
        return ni(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableToDoubleFunction<E1> name, double value) {
        return ni(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableToDoubleFunction<E1> name, double value, DoublePredicate ignoreStrategy) {
        return ni(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableToIntFunction<E1> name, int... value) {
        return ni(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableToLongFunction<E1> name, long... value) {
        return ni(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableToDoubleFunction<E1> name, double... value) {
        return ni(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableToIntFunction<E1> name, int[] value, Predicate<int[]> ignoreStrategy) {
        return ni(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableToLongFunction<E1> name, long[] value, Predicate<long[]> ignoreStrategy) {
        return ni(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableToDoubleFunction<E1> name, double[] value, Predicate<double[]> ignoreStrategy) {
        return ni(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni(SerializableSupplier<R> property, R value) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ni(classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), value, getAlias(),
            getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni(SerializableSupplier<R> property, R... value) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ni(classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), value, getAlias(),
            getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni(SerializableSupplier<R> property, R value, Predicate<R> ignoreStrategy) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ni(classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), value, getAlias(),
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni(SerializableSupplier<R> property, R[] value, Predicate<R[]> ignoreStrategy) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ni(classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), value, getAlias(),
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableIntSupplier property, int value) {
        return ni(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    @Override
    public L ni(SerializableIntSupplier name, int... value) {
        return ni(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy) {
        return ni(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    @Override
    public L ni(SerializableIntSupplier name, int[] value, Predicate<int[]> ignoreStrategy) {
        return ni(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableLongSupplier property, long value) {
        return ni(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    @Override
    public L ni(SerializableLongSupplier property, long... value) {
        return ni(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy) {
        return ni(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    @Override
    public L ni(SerializableLongSupplier name, long[] value, Predicate<long[]> ignoreStrategy) {
        return ni(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableDoubleSupplier property, double value) {
        return ni(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    @Override
    public L ni(SerializableDoubleSupplier name, double... value) {
        return ni(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy) {
        return ni(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    @Override
    public L ni(SerializableDoubleSupplier property, double[] value, Predicate<double[]> ignoreStrategy) {
        return ni(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableToStringFunction<E1> name, String value, MatchStrategy matchStrategy) {
        return ni(getClassMapping(), name, value, matchStrategy, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableToStringFunction<E1> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ni(getClassMapping(), name, value, matchStrategy, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableToStringFunction<E1> name, String[] value, MatchStrategy matchStrategy) {
        return ni(getClassMapping(), name, value, matchStrategy, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableToStringFunction<E1> name, String[] value, MatchStrategy matchStrategy,
        Predicate<String[]> ignoreStrategy) {
        return ni(getClassMapping(), name, value, matchStrategy, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return ni(getClassMapping(), property, value, matchStrategy, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableStringSupplier property, String[] value, MatchStrategy matchStrategy) {
        return ni(getClassMapping(), property, value, matchStrategy, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ni(getClassMapping(), property, value, matchStrategy, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableStringSupplier property, String[] value, MatchStrategy matchStrategy,
        Predicate<String[]> ignoreStrategy) {
        return ni(getClassMapping(), property, value, matchStrategy, getAlias(), ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L inn(SerializableFunction<E1, R> name, Boolean value) {
        return inn(getClassMapping().getPropertyMapping(getPropertyName(name)), value, getAlias());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L inn(SerializableSupplier<R> name, Boolean value) {
        return inn(getClassMapping().getPropertyMapping(getPropertyName(name)), value, getAlias());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L isn(SerializableFunction<E1, R> name, Boolean value) {
        return isn(getClassMapping().getPropertyMapping(getPropertyName(name)), value, getAlias());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L isn(SerializableSupplier<R> name, Boolean value) {
        return isn(getClassMapping().getPropertyMapping(getPropertyName(name)), value, getAlias());
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L le(SerializableFunction<E1, N> name, N value) {
        return le(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L le(SerializableFunction<E1, N> name, N value, Predicate<N> ignoreStrategy) {
        return le(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L le(SerializableFunction<E1, E> name, E value) {
        return le(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L le(SerializableFunction<E1, E> name, E value, Predicate<E> ignoreStrategy) {
        return le(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L le(SerializableFunction<E1, D> name, D value) {
        return le(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L le(SerializableFunction<E1, D> name, D value, Predicate<D> ignoreStrategy) {
        return le(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableFunction<E1, LocalTime> name, LocalTime value) {
        return le(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableFunction<E1, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return le(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableFunction<E1, LocalDate> name, LocalDate value) {
        return le(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableFunction<E1, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return le(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableFunction<E1, LocalDateTime> name, LocalDateTime value) {
        return le(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableFunction<E1, LocalDateTime> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return le(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableFunction<E1, String> name, String value, MatchStrategy matchStrategy) {
        return le(getClassMapping(), name, value, matchStrategy, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableFunction<E1, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return le(getClassMapping(), name, value, matchStrategy, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableToIntFunction<E1> name, int value) {
        return le(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableToIntFunction<E1> name, int value, IntPredicate ignoreStrategy) {
        return le(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableToLongFunction<E1> name, long value) {
        return le(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableToLongFunction<E1> name, long value, LongPredicate ignoreStrategy) {
        return le(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableToDoubleFunction<E1> name, double value) {
        return le(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableToDoubleFunction<E1> name, double value, DoublePredicate ignoreStrategy) {
        return le(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L le(SerializableDateSupplier<D> property, D value) {
        return le(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L le(SerializableDateSupplier<R> property, R value, Predicate<R> ignoreStrategy) {
        return le(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L le(SerializableNumberSupplier<N> property, N value) {
        return le(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L le(SerializableNumberSupplier<N> property, N value, Predicate<N> ignoreStrategy) {
        return le(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L le(SerializableEnumSupplier<E> property, E value) {
        return le(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L le(SerializableEnumSupplier<E> property, E value, Predicate<E> ignoreStrategy) {
        return le(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableLocalDateSupplier property, LocalDate value) {
        return le(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableLocalDateSupplier property, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return le(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableLocalTimeSupplier property, LocalTime value) {
        return le(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableLocalTimeSupplier property, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return le(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableLocalDateTimeSupplier property, LocalDateTime value) {
        return le(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableLocalDateTimeSupplier property, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return le(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return le(getClassMapping(), property, value, matchStrategy, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return le(getClassMapping(), property, value, matchStrategy, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableIntSupplier property, int value) {
        return le(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy) {
        return le(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableLongSupplier property, long value) {
        return le(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy) {
        return le(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableDoubleSupplier property, double value) {
        return le(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy) {
        return le(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L lt(SerializableFunction<E1, N> name, N value) {
        return lt(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L lt(SerializableFunction<E1, N> name, N value, Predicate<N> ignoreStrategy) {
        return lt(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L lt(SerializableFunction<E1, E> name, E value) {
        return lt(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L lt(SerializableFunction<E1, E> name, E value, Predicate<E> ignoreStrategy) {
        return lt(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L lt(SerializableFunction<E1, D> name, D value) {
        return lt(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L lt(SerializableFunction<E1, D> name, D value, Predicate<D> ignoreStrategy) {
        return lt(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableFunction<E1, LocalTime> name, LocalTime value) {
        return lt(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableFunction<E1, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return lt(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableFunction<E1, LocalDate> name, LocalDate value) {
        return lt(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableFunction<E1, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return lt(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableFunction<E1, LocalDateTime> name, LocalDateTime value) {
        return lt(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableFunction<E1, LocalDateTime> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return lt(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableFunction<E1, String> name, String value, MatchStrategy matchStrategy) {
        return lt(getClassMapping(), name, value, matchStrategy, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableFunction<E1, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return lt(getClassMapping(), name, value, matchStrategy, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableToIntFunction<E1> name, int value) {
        return lt(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableToIntFunction<E1> name, int value, IntPredicate ignoreStrategy) {
        return lt(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableToLongFunction<E1> name, long value) {
        return lt(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableToLongFunction<E1> name, long value, LongPredicate ignoreStrategy) {
        return lt(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableToDoubleFunction<E1> name, double value) {
        return lt(getClassMapping(), name, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableToDoubleFunction<E1> name, double value, DoublePredicate ignoreStrategy) {
        return lt(getClassMapping(), name, value, getAlias(), ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L lt(SerializableNumberSupplier<N> property, N value) {
        return lt(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L lt(SerializableNumberSupplier<N> property, N value, Predicate<N> ignoreStrategy) {
        return lt(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L lt(SerializableEnumSupplier<E> property, E value) {
        return lt(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L lt(SerializableEnumSupplier<E> property, E value, Predicate<E> ignoreStrategy) {
        return lt(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L lt(SerializableDateSupplier<D> property, D value) {
        return lt(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L lt(SerializableDateSupplier<D> property, D value, Predicate<D> ignoreStrategy) {
        return lt(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableLocalDateSupplier property, LocalDate value) {
        return lt(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableLocalDateSupplier property, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return lt(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableLocalTimeSupplier property, LocalTime value) {
        return lt(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableLocalTimeSupplier property, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return lt(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableLocalDateTimeSupplier property, LocalDateTime value) {
        return lt(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableLocalDateTimeSupplier property, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return lt(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return lt(getClassMapping(), property, value, matchStrategy, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return lt(getClassMapping(), property, value, matchStrategy, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableIntSupplier property, int value) {
        return lt(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy) {
        return lt(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableLongSupplier property, long value) {
        return lt(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy) {
        return lt(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableDoubleSupplier property, double value) {
        return lt(getClassMapping(), property, value, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy) {
        return lt(getClassMapping(), property, value, getAlias(), ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableToIntFunction<E1> name, int min, int max) {
        return ba(getClassMapping(), name, min, max, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableToIntFunction<E1> name, int min, int max, BiPredicate<Integer, Integer> ignoreStrategy) {
        return ba(getClassMapping(), name, min, max, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableToLongFunction<E1> name, long min, long max) {
        return ba(getClassMapping(), name, min, max, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableToLongFunction<E1> name, long min, long max, BiPredicate<Long, Long> ignoreStrategy) {
        return ba(getClassMapping(), name, min, max, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableToDoubleFunction<E1> name, double min, double max) {
        return ba(getClassMapping(), name, min, max, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableToDoubleFunction<E1> name, double min, double max,
        BiPredicate<Double, Double> ignoreStrategy) {
        return ba(getClassMapping(), name, min, max, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ba(SerializableToNumberFunction<E1, N> name, N min, N max) {
        return ba(getClassMapping(), name, min, max, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ba(SerializableToNumberFunction<E1, N> name, N min, N max,
        BiPredicate<N, N> ignoreStrategy) {
        return ba(getClassMapping(), name, min, max, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ba(SerializableToDateFunction<E1, D> name, D min, D max) {
        return ba(getClassMapping(), name, min, max, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ba(SerializableToDateFunction<E1, D> name, D min, D max,
        BiPredicate<D, D> ignoreStrategy) {
        return ba(getClassMapping(), name, min, max, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ba(SerializableToEnumFunction<E1, E> name, E min, E max) {
        return ba(getClassMapping(), name, min, max, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ba(SerializableToEnumFunction<E1, E> name, E min, E max,
        BiPredicate<E, E> ignoreStrategy) {
        return ba(getClassMapping(), name, min, max, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableToLocalTimeFunction<E1> name, LocalTime min, LocalTime max) {
        return ba(getClassMapping(), name, min, max, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableToLocalTimeFunction<E1> name, LocalTime min, LocalTime max,
        BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return ba(getClassMapping(), name, min, max, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableToLocalDateFunction<E1> name, LocalDate min, LocalDate max) {
        return ba(getClassMapping(), name, min, max, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableToLocalDateFunction<E1> name, LocalDate min, LocalDate max,
        BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return ba(getClassMapping(), name, min, max, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableToLocalDateTimeFunction<E1> name, LocalDateTime min, LocalDateTime max) {
        return ba(getClassMapping(), name, min, max, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableToLocalDateTimeFunction<E1> name, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return ba(getClassMapping(), name, min, max, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableToStringFunction<E1> name, String min, String max) {
        return ba(getClassMapping(), name, min, max, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableToStringFunction<E1> name, String min, String max,
        BiPredicate<String, String> ignoreStrategy) {
        return ba(getClassMapping(), name, min, max, getAlias(), ignoreStrategy);
    }

    // --------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ba(SerializableNumberSupplier<N> property, N min, N max) {
        return ba(getClassMapping(), property, min, max, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ba(SerializableNumberSupplier<N> name, N min, N max, BiPredicate<N, N> ignoreStrategy) {
        return ba(getClassMapping(), name, min, max, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ba(SerializableDateSupplier<D> property, D min, D max) {
        return ba(getClassMapping(), property, min, max, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ba(SerializableDateSupplier<D> property, D min, D max, BiPredicate<D, D> ignoreStrategy) {
        return ba(getClassMapping(), property, min, max, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableLocalTimeSupplier property, LocalTime min, LocalTime max) {
        return ba(getClassMapping(), property, min, max, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableLocalTimeSupplier property, LocalTime min, LocalTime max,
        BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return ba(getClassMapping(), property, min, max, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableLocalDateSupplier property, LocalDate min, LocalDate max) {
        return ba(getClassMapping(), property, min, max, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableLocalDateSupplier property, LocalDate min, LocalDate max,
        BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return ba(getClassMapping(), property, min, max, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableLocalDateTimeSupplier property, LocalDateTime min, LocalDateTime max) {
        return ba(getClassMapping(), property, min, max, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableLocalDateTimeSupplier property, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return ba(getClassMapping(), property, min, max, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableStringSupplier property, String min, String max) {
        return ba(getClassMapping(), property, min, max, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableStringSupplier property, String min, String max,
        BiPredicate<String, String> ignoreStrategy) {
        return ba(getClassMapping(), property, min, max, getAlias(), ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableToIntFunction<E1> name, int min, int max) {
        return nba(getClassMapping(), name, min, max, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableToIntFunction<E1> name, int min, int max, BiPredicate<Integer, Integer> ignoreStrategy) {
        return nba(getClassMapping(), name, min, max, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableToLongFunction<E1> name, long min, long max) {
        return nba(getClassMapping(), name, min, max, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableToLongFunction<E1> name, long min, long max, BiPredicate<Long, Long> ignoreStrategy) {
        return nba(getClassMapping(), name, min, max, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableToDoubleFunction<E1> name, double min, double max) {
        return nba(getClassMapping(), name, min, max, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableToDoubleFunction<E1> name, double min, double max,
        BiPredicate<Double, Double> ignoreStrategy) {
        return nba(getClassMapping(), name, min, max, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L nba(SerializableToNumberFunction<E1, N> name, N min, N max) {
        return nba(getClassMapping(), name, min, max, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L nba(SerializableToNumberFunction<E1, N> name, N min, N max,
        BiPredicate<N, N> ignoreStrategy) {
        return nba(getClassMapping(), name, min, max, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L nba(SerializableToDateFunction<E1, D> name, D min, D max) {
        return nba(getClassMapping(), name, min, max, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L nba(SerializableToDateFunction<E1, D> name, D min, D max,
        BiPredicate<D, D> ignoreStrategy) {
        return nba(getClassMapping(), name, min, max, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L nba(SerializableToEnumFunction<E1, E> name, E min, E max) {
        return nba(getClassMapping(), name, min, max, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L nba(SerializableToEnumFunction<E1, E> name, E min, E max,
        BiPredicate<E, E> ignoreStrategy) {
        return nba(getClassMapping(), name, min, max, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableToLocalTimeFunction<E1> name, LocalTime min, LocalTime max) {
        return nba(getClassMapping(), name, min, max, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableToLocalTimeFunction<E1> name, LocalTime min, LocalTime max,
        BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return nba(getClassMapping(), name, min, max, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableToLocalDateFunction<E1> name, LocalDate min, LocalDate max) {
        return nba(getClassMapping(), name, min, max, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableToLocalDateFunction<E1> name, LocalDate min, LocalDate max,
        BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return nba(getClassMapping(), name, min, max, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableToLocalDateTimeFunction<E1> name, LocalDateTime min, LocalDateTime max) {
        return nba(getClassMapping(), name, min, max, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableToLocalDateTimeFunction<E1> name, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return nba(getClassMapping(), name, min, max, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableToStringFunction<E1> name, String min, String max) {
        return nba(getClassMapping(), name, min, max, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableToStringFunction<E1> name, String min, String max,
        BiPredicate<String, String> ignoreStrategy) {
        return nba(getClassMapping(), name, min, max, getAlias(), ignoreStrategy);
    }

    // --------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L nba(SerializableNumberSupplier<N> property, N min, N max) {
        return nba(getClassMapping(), property, min, max, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L nba(SerializableNumberSupplier<N> name, N min, N max,
        BiPredicate<N, N> ignoreStrategy) {
        return nba(getClassMapping(), name, min, max, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L nba(SerializableDateSupplier<D> property, D min, D max) {
        return nba(getClassMapping(), property, min, max, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L nba(SerializableDateSupplier<D> property, D min, D max,
        BiPredicate<D, D> ignoreStrategy) {
        return nba(getClassMapping(), property, min, max, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableLocalTimeSupplier property, LocalTime min, LocalTime max) {
        return nba(getClassMapping(), property, min, max, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableLocalTimeSupplier property, LocalTime min, LocalTime max,
        BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return nba(getClassMapping(), property, min, max, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableLocalDateSupplier property, LocalDate min, LocalDate max) {
        return nba(getClassMapping(), property, min, max, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableLocalDateSupplier property, LocalDate min, LocalDate max,
        BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return nba(getClassMapping(), property, min, max, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableLocalDateTimeSupplier property, LocalDateTime min, LocalDateTime max) {
        return nba(getClassMapping(), property, min, max, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableLocalDateTimeSupplier property, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return nba(getClassMapping(), property, min, max, getAlias(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableStringSupplier property, String min, String max) {
        return nba(getClassMapping(), property, min, max, getAlias(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableStringSupplier property, String min, String max,
        BiPredicate<String, String> ignoreStrategy) {
        return nba(getClassMapping(), property, min, max, getAlias(), ignoreStrategy);
    }

    // ****************************************************************************************************************
    // property
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityTypePropertyExpression<R, C, L> property(SerializableFunction<E1, R> name) {
        return new EntityTypePropertyExpressionImpl<>(index, name, this, factory, entityRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, C2 extends EntityConditionGroupExpression<R, C2, L2>,
        L2 extends EntityConditionGroupLogicExpression<R, C2, L2>> L property(SerializableFunction<E1, R> name,
            Consumer<EntityTypePropertyExpression<R, C2, L2>> entityTypePropertyExpressionConsumer) {
        //        // IMPLSOON 后续来实现内嵌类型property
        //        throw new NotImplementedException();

        final int i = index;
        index++;
        entityTypePropertyExpressionConsumer.accept((EntityTypePropertyExpression<R, C2,
            L2>) new EntityTypePropertyExpressionImpl<>(i, name, this,
                factory, entityRelation));
        index--;

        //        property(name);
        //        index++;
        //        entityTypePropertyExpressionConsumer.accept((EntityConditionsGroupExpression<R, C2,
        //            L2>) this);
        //        index--;

        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Collection<E>,
        E> EntityTypePropertyExpression<E, C, L> property(SerializableToCollectionFunction<E1, R, E> name) {
        // IMPLSOON 后续来实现集合类型property
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityIntPropertyExpression<C, L> property(SerializableToIntFunction<E1> name) {
        return new EntityIntPropertyExpressionImpl<>(index, name, this, factory, entityRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLongPropertyExpression<C, L> property(SerializableToLongFunction<E1> name) {
        return new EntityLongPropertyExpressionImpl<>(index, name, this, factory, entityRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityDoublePropertyExpression<C, L> property(SerializableToDoubleFunction<E1> name) {
        return new EntityDoublePropertyExpressionImpl<>(index, name, this, factory, entityRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <
        R extends Number> EntityNumberPropertyExpression<R, C, L> property(SerializableToNumberFunction<E1, R> name) {
        return new EntityNumberPropertyExpressionImpl<>(index, name, this, factory, entityRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityStringPropertyExpression<C, L> property(SerializableToStringFunction<E1> name) {
        return new EntityStringPropertyExpressionImpl<>(index, name, this, factory, entityRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> EntityDatePropertyExpression<R, C, L> property(SerializableToDateFunction<E1, R> name) {
        return new EntityDatePropertyExpressionImpl<>(index, name, this, factory, entityRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLocalDatePropertyExpression<C, L> property(SerializableToLocalDateFunction<E1> name) {
        return new EntityLocalDatePropertyExpressionImpl<>(index, name, this, factory, entityRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLocalDateTimePropertyExpression<C, L> property(SerializableToLocalDateTimeFunction<E1> name) {
        return new EntityLocalDateTimePropertyExpressionImpl<>(index, name, this, factory, entityRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLocalTimePropertyExpression<C, L> property(SerializableToLocalTimeFunction<E1> name) {
        return new EntityLocalTimePropertyExpressionImpl<>(index, name, this, factory, entityRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Enum<R>> EntityEnumPropertyExpression<R, C, L> property(SerializableToEnumFunction<E1, R> name) {
        return new EntityEnumPropertyExpressionImpl<>(index, name, this, factory, entityRelation);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L expression(String expression, final Map<String, Serializable> params) {
        final Execution execution = SqlUtils.convertNamedParamSql(expression, params);
        return expression(execution.getExecution(), execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L expression(String expression, Serializable... params) {
        return (L) addCondition(new ParamedExpression() {

            @Override
            public String expression() {
                final Map<String, Object> argus = new HashMap<>();
                Lang.each(getEntityRelation().getFilterableEntityRelations(), (m, index) -> {
                    argus.put("" + index, m.getTableAlias());
                    argus.put("as" + index, m.getTableAlias());
                });
                return Str.format(expression, argus);
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
    public C configure(Consumer<CC> configure) {
        if (configure != null) {
            configure.accept(conditionConfig);
        }
        return (C) this;
    }

    // ********************************************************************
    // protected method
    // ********************************************************************

    // ********************************************************************

    /**
     * Gets the field value operator.
     *
     * @param <R> the generic type
     * @param pm the pm
     * @param value the value
     * @return the field value operator
     */
    protected <R extends Serializable> FieldValueOperator<R> getFieldValueOperator(JdbcPropertyMapping pm, R value) {
        return value == null ? null : FieldValueOperator.create(pm, value);
    }

    /**
     * Gets the in param.
     *
     * @param pm the pm
     * @param value the value
     * @return the in param
     */
    protected Object getInParam(JdbcPropertyMapping pm, Object value) {
        return SqlUtils.flatParamToFieldValueOperator(value, pm);
        //        Object param = null;
        //        if (value != null) {
        //            if (value.getClass().isArray()) {
        //                int length = Array.getLength(value);
        //                //                param = Array.newInstance(FieldValueOperator.class, length);
        //                param = new FieldValueOperator[length];
        //                for (int i = 0; i < length; i++) {
        //                    if (value.getClass() == int[].class) {
        //                        Array.set(param, i, FieldValueOperator.create(pm, Array.getInt(value, i)));
        //                    } else if (value.getClass() == long[].class) {
        //                        Array.set(param, i, FieldValueOperator.create(pm, Array.getLong(value, i)));
        //                    } else if (value.getClass() == boolean[].class) {
        //                        Array.set(param, i, FieldValueOperator.create(pm, Array.getBoolean(value, i)));
        //                    } /*
        //                       * else if (value.getClass() == char[].class) {
        //                       * Array.set(param, i, FieldValueOperator.create(pm, (byte)
        //                       * Array.getChar(value, i)));
        //                       * // database don't support getChar
        //                       * }
        //                       */ else if (value.getClass() == byte[].class) {
        //                        Array.set(param, i, FieldValueOperator.create(pm, Array.getByte(value, i)));
        //                    } else if (value.getClass() == short[].class) {
        //                        Array.set(param, i, FieldValueOperator.create(pm, Array.getShort(value, i)));
        //                    } else if (value.getClass() == double[].class) {
        //                        Array.set(param, i, FieldValueOperator.create(pm, Array.getDouble(value, i)));
        //                    } else if (value.getClass() == float[].class) {
        //                        Array.set(param, i, FieldValueOperator.create(pm, Array.getFloat(value, i)));
        //                    } else {
        //                        Array.set(param, i, FieldValueOperator.create(pm, Array.get(value, i)));
        //                    }
        //                }
        //            } else if (value instanceof Collection) {
        //                param = new ArrayList<>();
        //                for (Object op : (Collection<?>) value) {
        //                    ((Collection<FieldValueOperator<?>>) param).add(FieldValueOperator.create(pm, op));
        //                }
        //            } else if (!(value instanceof FieldValueOperator)) {
        //                param = FieldValueOperator.create(pm, value);
        //            } else {
        //                param = value;
        //            }
        //        }
        //        return param;
    }

    // ********************************************************************

    /**
     * Eq.
     *
     * @param classMapping the class mapping
     * @param property the property
     * @param value the value
     * @param queryAlias the query alias
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L eq(JdbcClassMapping<?> classMapping, Serializable property, int value, String queryAlias,
        IntPredicate ignoreStrategy) {
        return eqOrNe(ComparisonOperator.EQ, classMapping.getPropertyMapping(getPropertyName(property)), null, value,
            queryAlias, MatchStrategy.AUTO, v -> ignoreStrategy.test((Integer) v));
    }

    /**
     * Eq.
     *
     * @param classMapping the class mapping
     * @param property the property
     * @param value the value
     * @param queryAlias the query alias
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L eq(JdbcClassMapping<?> classMapping, Serializable property, int value, String queryAlias,
        CharPredicate ignoreStrategy) {
        return eqOrNe(ComparisonOperator.EQ, classMapping.getPropertyMapping(getPropertyName(property)), null, value,
            queryAlias, MatchStrategy.AUTO, v -> ignoreStrategy.test((Character) v));
    }

    /**
     * Eq.
     *
     * @param classMapping the class mapping
     * @param property the property
     * @param value the value
     * @param queryAlias the query alias
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L eq(JdbcClassMapping<?> classMapping, Serializable property, long value, String queryAlias,
        LongPredicate ignoreStrategy) {
        return eqOrNe(ComparisonOperator.EQ, classMapping.getPropertyMapping(getPropertyName(property)), null, value,
            queryAlias, MatchStrategy.AUTO, v -> ignoreStrategy.test((Long) v));
    }

    /**
     * Eq.
     *
     * @param classMapping the class mapping
     * @param property the property
     * @param value the value
     * @param queryAlias the query alias
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L eq(JdbcClassMapping<?> classMapping, Serializable property, double value, String queryAlias,
        DoublePredicate ignoreStrategy) {
        return eqOrNe(ComparisonOperator.EQ, classMapping.getPropertyMapping(getPropertyName(property)), null, value,
            queryAlias, MatchStrategy.AUTO, v -> ignoreStrategy.test((Double) v));
    }

    /**
     * Eq.
     *
     * @param classMapping the class mapping
     * @param property the property
     * @param value the value
     * @param queryAlias the query alias
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L eq(JdbcClassMapping<?> classMapping, Serializable property, char value, String queryAlias,
        CharPredicate ignoreStrategy) {
        return eqOrNe(ComparisonOperator.EQ, classMapping.getPropertyMapping(getPropertyName(property)), null, value,
            queryAlias, MatchStrategy.AUTO, v -> ignoreStrategy.test((Character) v));
    }

    /**
     * Eq.
     *
     * @param <R> the generic type
     * @param classMapping the class mapping
     * @param property the property
     * @param value the value
     * @param queryAlias the query alias
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <R> L eq(JdbcClassMapping<?> classMapping, Serializable property, R value, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return eq(classMapping, property, value, queryAlias, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * Eq.
     *
     * @param <R> the generic type
     * @param classMapping the class mapping
     * @param property the property
     * @param value the value
     * @param queryAlias the query alias
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <R> L eq(JdbcClassMapping<?> classMapping, Serializable property, R value, String queryAlias,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return eqOrNe(ComparisonOperator.EQ, classMapping.getPropertyMapping(getPropertyName(property)), null, value,
            queryAlias, matchStrategy, ignoreStrategy);
    }

    /**
     * Ne.
     *
     * @param classMapping the class mapping
     * @param property the property
     * @param value the value
     * @param queryAlias the query alias
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L ne(JdbcClassMapping<?> classMapping, Serializable property, char value, String queryAlias,
        CharPredicate ignoreStrategy) {
        return eqOrNe(ComparisonOperator.NE, classMapping.getPropertyMapping(getPropertyName(property)), null, value,
            queryAlias, MatchStrategy.AUTO, v -> ignoreStrategy.test((Character) v));
    }

    /**
     * Ne.
     *
     * @param classMapping the class mapping
     * @param property the property
     * @param value the value
     * @param queryAlias the query alias
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L ne(JdbcClassMapping<?> classMapping, Serializable property, int value, String queryAlias,
        IntPredicate ignoreStrategy) {
        return eqOrNe(ComparisonOperator.NE, classMapping.getPropertyMapping(getPropertyName(property)), null, value,
            queryAlias, MatchStrategy.AUTO, v -> ignoreStrategy.test((Integer) v));
    }

    /**
     * Ne.
     *
     * @param classMapping the class mapping
     * @param property the property
     * @param value the value
     * @param queryAlias the query alias
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L ne(JdbcClassMapping<?> classMapping, Serializable property, int value, String queryAlias,
        CharPredicate ignoreStrategy) {
        return eqOrNe(ComparisonOperator.NE, classMapping.getPropertyMapping(getPropertyName(property)), null, value,
            queryAlias, MatchStrategy.AUTO, v -> ignoreStrategy.test((Character) v));
    }

    /**
     * Ne.
     *
     * @param classMapping the class mapping
     * @param property the property
     * @param value the value
     * @param queryAlias the query alias
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L ne(JdbcClassMapping<?> classMapping, Serializable property, long value, String queryAlias,
        LongPredicate ignoreStrategy) {
        return eqOrNe(ComparisonOperator.NE, classMapping.getPropertyMapping(getPropertyName(property)), null, value,
            queryAlias, MatchStrategy.AUTO, v -> ignoreStrategy.test((Long) v));
    }

    /**
     * Ne.
     *
     * @param classMapping the class mapping
     * @param property the property
     * @param value the value
     * @param queryAlias the query alias
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L ne(JdbcClassMapping<?> classMapping, Serializable property, double value, String queryAlias,
        DoublePredicate ignoreStrategy) {
        return eqOrNe(ComparisonOperator.NE, classMapping.getPropertyMapping(getPropertyName(property)), null, value,
            queryAlias, MatchStrategy.AUTO, v -> ignoreStrategy.test((Double) v));
    }

    /**
     * Ne.
     *
     * @param <R> the generic type
     * @param classMapping the class mapping
     * @param property the property
     * @param value the value
     * @param queryAlias the query alias
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <R> L ne(JdbcClassMapping<?> classMapping, Serializable property, R value, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return ne(getClassMapping(), property, value, queryAlias, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * Ne.
     *
     * @param <R> the generic type
     * @param classMapping the class mapping
     * @param property the property
     * @param value the value
     * @param queryAlias the query alias
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <R> L ne(JdbcClassMapping<?> classMapping, Serializable property, R value, String queryAlias,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return eqOrNe(ComparisonOperator.NE, classMapping.getPropertyMapping(getPropertyName(property)), null, value,
            queryAlias, matchStrategy, ignoreStrategy);
    }

    /**
     * Eq or ne.
     *
     * @param <R> the generic type
     * @param comparisonOperator the comparison operator
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param queryAlias the query alias
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected abstract <R> L eqOrNe(ComparisonOperator comparisonOperator, PropertyMapping<?> pm,
        ColumnElement name, R value, String queryAlias, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    //    protected <T, R> L eq_ne(ComparisonOperator comparisonOperator, JdbcPropertyMapping pm, R value, String queryAlias,
    //            MatchStrategy matchStrategy, Predicate<R> ignoreStrategy) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
    //                getFieldValueOperator(pm, value), comparisonOperator, matchStrategy, queryAlias, ignoreStrategy));
    //    }

    // ****************************************************************************************************************

    /**
     * Sw.
     *
     * @param classMapping the class mapping
     * @param property the property
     * @param value the value
     * @param queryAlias the query alias
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L sw(JdbcClassMapping<?> classMapping, Serializable property, String value, String queryAlias,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return sw(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias, matchStrategy,
            ignoreStrategy);
    }

    /**
     * Sw.
     *
     * @param pm the pm
     * @param value the value
     * @param queryAlias the query alias
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L sw(JdbcPropertyMapping pm, String value, String queryAlias, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
            getFieldValueOperator(pm, value), ComparisonOperator.SW, matchStrategy, queryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    /**
     * Nsw.
     *
     * @param classMapping the class mapping
     * @param property the property
     * @param value the value
     * @param queryAlias the query alias
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L nsw(JdbcClassMapping<?> classMapping, Serializable property, String value, String queryAlias,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return nsw(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias, matchStrategy,
            ignoreStrategy);
    }

    /**
     * Nsw.
     *
     * @param pm the pm
     * @param value the value
     * @param queryAlias the query alias
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L nsw(JdbcPropertyMapping pm, String value, String queryAlias, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
            getFieldValueOperator(pm, value), ComparisonOperator.NSW, matchStrategy, queryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    /**
     * Co.
     *
     * @param classMapping the class mapping
     * @param property the property
     * @param value the value
     * @param queryAlias the query alias
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L co(JdbcClassMapping<?> classMapping, Serializable property, String value, String queryAlias,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return co(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias, matchStrategy,
            ignoreStrategy);
    }

    /**
     * Co.
     *
     * @param pm the pm
     * @param value the value
     * @param queryAlias the query alias
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L co(JdbcPropertyMapping pm, String value, String queryAlias, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
            getFieldValueOperator(pm, value), ComparisonOperator.CO, matchStrategy, queryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    /**
     * Nco.
     *
     * @param classMapping the class mapping
     * @param property the property
     * @param value the value
     * @param queryAlias the query alias
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L nco(JdbcClassMapping<?> classMapping, Serializable property, String value, String queryAlias,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return nco(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias, matchStrategy,
            ignoreStrategy);
    }

    /**
     * Nco.
     *
     * @param pm the pm
     * @param value the value
     * @param queryAlias the query alias
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L nco(JdbcPropertyMapping pm, String value, String queryAlias, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
            getFieldValueOperator(pm, value), ComparisonOperator.NCO, matchStrategy, queryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    /**
     * Ew.
     *
     * @param classMapping the class mapping
     * @param property the property
     * @param value the value
     * @param queryAlias the query alias
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L ew(JdbcClassMapping<?> classMapping, Serializable property, String value, String queryAlias,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return ew(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias, matchStrategy,
            ignoreStrategy);
    }

    /**
     * Ew.
     *
     * @param pm the pm
     * @param value the value
     * @param queryAlias the query alias
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L ew(JdbcPropertyMapping pm, String value, String queryAlias, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
            getFieldValueOperator(pm, value), ComparisonOperator.EW, matchStrategy, queryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    /**
     * Newv.
     *
     * @param classMapping the class mapping
     * @param property the property
     * @param value the value
     * @param queryAlias the query alias
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L newv(JdbcClassMapping<?> classMapping, Serializable property, String value, String queryAlias,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return newv(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias, matchStrategy,
            ignoreStrategy);
    }

    /**
     * Newv.
     *
     * @param pm the pm
     * @param value the value
     * @param queryAlias the query alias
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L newv(JdbcPropertyMapping pm, String value, String queryAlias, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
            getFieldValueOperator(pm, value), ComparisonOperator.NEW, matchStrategy, queryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    /**
     * Lk.
     *
     * @param classMapping the class mapping
     * @param property the property
     * @param value the value
     * @param queryAlias the query alias
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L lk(JdbcClassMapping<?> classMapping, Serializable property, String value, String queryAlias,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return lk(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias, matchStrategy,
            ignoreStrategy);
    }

    /**
     * Lk.
     *
     * @param pm the pm
     * @param value the value
     * @param queryAlias the query alias
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L lk(JdbcPropertyMapping pm, String value, String queryAlias, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
            getFieldValueOperator(pm, value), ComparisonOperator.LK, matchStrategy, queryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    /**
     * Nl.
     *
     * @param classMapping the class mapping
     * @param property the property
     * @param value the value
     * @param queryAlias the query alias
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L nl(JdbcClassMapping<?> classMapping, Serializable property, String value, String queryAlias,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return nl(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias, matchStrategy,
            ignoreStrategy);
    }

    /**
     * Nl.
     *
     * @param pm the pm
     * @param value the value
     * @param queryAlias the query alias
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L nl(JdbcPropertyMapping pm, String value, String queryAlias, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
            getFieldValueOperator(pm, value), ComparisonOperator.NL, matchStrategy, queryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    protected <S> L in(JdbcClassMapping<?> classMapping, Serializable property, int value, String queryAlias,
        IntPredicate ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias,
            v -> ignoreStrategy.test((Integer) v));
    }

    protected <S> L in(JdbcClassMapping<?> classMapping, Serializable property, long value, String queryAlias,
        LongPredicate ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias,
            v -> ignoreStrategy.test((Long) v));
    }

    protected <S> L in(JdbcClassMapping<?> classMapping, Serializable property, double value, String queryAlias,
        DoublePredicate ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias,
            v -> ignoreStrategy.test((Double) v));
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

    /**
     * In.
     *
     * @param <R> the generic type
     * @param pm the pm
     * @param value the value
     * @param queryAlias the query alias
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <R> L in(JdbcPropertyMapping pm, R value, String queryAlias, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
            getInParam(pm, value), ComparisonOperator.IN, queryAlias, ignoreStrategy));
    }

    /**
     * In.
     *
     * @param <R> the generic type
     * @param pm the pm
     * @param value the value
     * @param matchStrategy the match strategy
     * @param queryAlias the query alias
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <R> L in(JdbcPropertyMapping pm, R value, MatchStrategy matchStrategy, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
            getInParam(pm, value), ComparisonOperator.IN, matchStrategy, queryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    protected <S> L ni(JdbcClassMapping<?> classMapping, Serializable property, int value, String queryAlias,
        IntPredicate ignoreStrategy) {
        return ni(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias,
            v -> ignoreStrategy.test((Integer) v));
    }

    protected <S> L ni(JdbcClassMapping<?> classMapping, Serializable property, long value, String queryAlias,
        LongPredicate ignoreStrategy) {
        return ni(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias,
            v -> ignoreStrategy.test((Long) v));
    }

    protected <S> L ni(JdbcClassMapping<?> classMapping, Serializable property, double value, String queryAlias,
        DoublePredicate ignoreStrategy) {
        return ni(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias,
            v -> ignoreStrategy.test((Double) v));
    }

    /**
     * Ni.
     *
     * @param <R> the generic type
     * @param classMapping the class mapping
     * @param property the property
     * @param value the value
     * @param queryAlias the query alias
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <R> L ni(JdbcClassMapping<?> classMapping, Serializable property, R value, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return ni(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias, ignoreStrategy);
    }

    /**
     * Ni.
     *
     * @param <R> the generic type
     * @param classMapping the class mapping
     * @param property the property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param queryAlias the query alias
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <R> L ni(JdbcClassMapping<?> classMapping, Serializable property, R value, MatchStrategy matchStrategy,
        String queryAlias, Predicate<?> ignoreStrategy) {
        return ni(classMapping.getPropertyMapping(getPropertyName(property)), value, matchStrategy, queryAlias,
            ignoreStrategy);
    }

    /**
     * Ni.
     *
     * @param <R> the generic type
     * @param pm the pm
     * @param value the value
     * @param queryAlias the query alias
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <R> L ni(JdbcPropertyMapping pm, R value, String queryAlias, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
            getInParam(pm, value), ComparisonOperator.NI, queryAlias, ignoreStrategy));
    }

    /**
     * Ni.
     *
     * @param <R> the generic type
     * @param pm the pm
     * @param value the value
     * @param matchStrategy the match strategy
     * @param queryAlias the query alias
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <R> L ni(JdbcPropertyMapping pm, R value, MatchStrategy matchStrategy, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
            getInParam(pm, value), ComparisonOperator.NI, matchStrategy, queryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    /**
     * Isn.
     *
     * @param classMapping the class mapping
     * @param property the property
     * @param value the value
     * @param queryAlias the query alias
     * @return the l
     */
    protected L isn(JdbcClassMapping<?> classMapping, Serializable property, Boolean value, String queryAlias) {
        return isn(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias);
    }

    /**
     * Isn.
     *
     * @param pm the pm
     * @param value the value
     * @param queryAlias the query alias
     * @return the l
     */
    protected L isn(JdbcPropertyMapping pm, Boolean value, String queryAlias) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(), value,
            ComparisonOperator.ISN, queryAlias, getIgnoreStrategy()));
    }

    /**
     * Inn.
     *
     * @param classMapping the class mapping
     * @param property the property
     * @param value the value
     * @param queryAlias the query alias
     * @return the l
     */
    protected L inn(JdbcClassMapping<?> classMapping, Serializable property, Boolean value, String queryAlias) {
        return inn(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias);
    }

    /**
     * Inn.
     *
     * @param pm the pm
     * @param value the value
     * @param queryAlias the query alias
     * @return the l
     */
    protected L inn(JdbcPropertyMapping pm, Boolean value, String queryAlias) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(), value,
            ComparisonOperator.INN, queryAlias, getIgnoreStrategy()));
    }

    // ********************************************************************

    protected <V> L ge(JdbcClassMapping<?> classMapping, Serializable name, int value, String queryAlias,
        IntPredicate ignoreStrategy) {
        return ge(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias,
            v -> ignoreStrategy.test((Integer) v));
    }

    protected <V> L ge(JdbcClassMapping<?> classMapping, Serializable name, long value, String queryAlias,
        LongPredicate ignoreStrategy) {
        return ge(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias,
            v -> ignoreStrategy.test((Long) v));
    }

    protected <V> L ge(JdbcClassMapping<?> classMapping, Serializable name, double value, String queryAlias,
        DoublePredicate ignoreStrategy) {
        return ge(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias,
            v -> ignoreStrategy.test((Double) v));
    }

    /**
     * Ge.
     *
     * @param <V> the value type
     * @param classMapping the class mapping
     * @param name the name
     * @param value the value
     * @param queryAlias the query alias
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <V> L ge(JdbcClassMapping<?> classMapping, Serializable name, V value, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return ge(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    }

    /**
     * Ge.
     *
     * @param <V> the value type
     * @param classMapping the class mapping
     * @param name the name
     * @param value the value
     * @param queryAlias the query alias
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <V> L ge(JdbcClassMapping<?> classMapping, Serializable name, V value, String queryAlias,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return ge(classMapping.getPropertyMapping(getPropertyName(name)), value, matchStrategy, queryAlias,
            ignoreStrategy);
    }

    /**
     * Ge.
     *
     * @param <V> the value type
     * @param classMapping the class mapping
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param queryAlias the query alias
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <V> L ge(JdbcClassMapping<?> classMapping, Serializable name, V value, MatchStrategy matchStrategy,
        String queryAlias, Predicate<?> ignoreStrategy) {
        return ge(classMapping.getPropertyMapping(getPropertyName(name)), value, matchStrategy, queryAlias,
            ignoreStrategy);
    }

    /**
     * Ge.
     *
     * @param <V> the value type
     * @param pm the pm
     * @param value the value
     * @param queryAlias the query alias
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <V> L ge(JdbcPropertyMapping pm, V value, String queryAlias, Predicate<?> ignoreStrategy) {
        return ge(pm, value, MatchStrategy.AUTO, queryAlias, ignoreStrategy);
    }

    /**
     * Ge.
     *
     * @param <V> the value type
     * @param pm the pm
     * @param value the value
     * @param matchStrategy the match strategy
     * @param queryAlias the query alias
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <V> L ge(JdbcPropertyMapping pm, V value, MatchStrategy matchStrategy, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
            getFieldValueOperator(pm, value), ComparisonOperator.GE, matchStrategy, queryAlias, ignoreStrategy));
    }

    // ********************************************************************

    /**
     * Ba.
     *
     * @param <V> the value type
     * @param classMapping the class mapping
     * @param name the name
     * @param min the min
     * @param max the max
     * @param queryAlias the query alias
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <V extends Serializable> L ba(JdbcClassMapping<?> classMapping, Serializable name, V min, V max,
        String queryAlias, BiPredicate<V, V> ignoreStrategy) {
        return ba(classMapping.getPropertyMapping(getPropertyName(name)), min, max, queryAlias,
            p -> ignoreStrategy.test(p[0], p[1]));
    }

    /**
     * Ba.
     *
     * @param <V> the value type
     * @param classMapping the class mapping
     * @param name the name
     * @param min the min
     * @param max the max
     * @param queryAlias the query alias
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <V extends Serializable> L ba(JdbcClassMapping<?> classMapping, Serializable name, V min, V max,
        String queryAlias, Predicate<Object> ignoreStrategy) {
        return ba(classMapping.getPropertyMapping(getPropertyName(name)), min, max, queryAlias,
            p -> ignoreStrategy.test(p));
    }

    /**
     * Ba.
     *
     * @param <V> the value type
     * @param pm the pm
     * @param min the min
     * @param max the max
     * @param queryAlias the query alias
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <V extends Serializable> L ba(JdbcPropertyMapping pm, V min, V max, String queryAlias,
        Predicate<V[]> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
            new FieldValueOperator[] { getFieldValueOperator(pm, min), getFieldValueOperator(pm, max) },
            ComparisonOperator.BA, queryAlias, ignoreStrategy));
    }

    // ********************************************************************

    /**
     * Nba.
     *
     * @param <V> the value type
     * @param classMapping the class mapping
     * @param name the name
     * @param min the min
     * @param max the max
     * @param queryAlias the query alias
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <V extends Serializable> L nba(JdbcClassMapping<?> classMapping, Serializable name, V min, V max,
        String queryAlias, BiPredicate<V, V> ignoreStrategy) {
        return nba(classMapping.getPropertyMapping(getPropertyName(name)), min, max, queryAlias,
            p -> ignoreStrategy.test(min, max));
    }

    /**
     * Nba.
     *
     * @param <V> the value type
     * @param classMapping the class mapping
     * @param name the name
     * @param min the min
     * @param max the max
     * @param queryAlias the query alias
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <V extends Serializable> L nba(JdbcClassMapping<?> classMapping, Serializable name, V min, V max,
        String queryAlias, Predicate<?> ignoreStrategy) {
        return nba(classMapping.getPropertyMapping(getPropertyName(name)), min, max, queryAlias, ignoreStrategy);
    }

    /**
     * Nba.
     *
     * @param <V> the value type
     * @param pm the pm
     * @param min the min
     * @param max the max
     * @param queryAlias the query alias
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <V extends Serializable> L nba(JdbcPropertyMapping pm, V min, V max, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
            new FieldValueOperator[] { getFieldValueOperator(pm, min), getFieldValueOperator(pm, max) },
            ComparisonOperator.NBA, queryAlias, ignoreStrategy));
    }

    // ********************************************************************

    protected <V> L gt(JdbcClassMapping<?> classMapping, Serializable name, int value, String queryAlias,
        IntPredicate ignoreStrategy) {
        return gt(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias,
            v -> ignoreStrategy.test((Integer) v));
    }

    protected <V> L gt(JdbcClassMapping<?> classMapping, Serializable name, long value, String queryAlias,
        LongPredicate ignoreStrategy) {
        return gt(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias,
            v -> ignoreStrategy.test((Long) v));
    }

    protected <V> L gt(JdbcClassMapping<?> classMapping, Serializable name, double value, String queryAlias,
        DoublePredicate ignoreStrategy) {
        return gt(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias,
            v -> ignoreStrategy.test((Double) v));
    }

    /**
     * Gt.
     *
     * @param <V> the value type
     * @param classMapping the class mapping
     * @param name the name
     * @param value the value
     * @param queryAlias the query alias
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <V> L gt(JdbcClassMapping<?> classMapping, Serializable name, V value, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return gt(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    }

    /**
     * Gt.
     *
     * @param classMapping the class mapping
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param queryAlias the query alias
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L gt(JdbcClassMapping<?> classMapping, Serializable name, String value, MatchStrategy matchStrategy,
        String queryAlias, Predicate<?> ignoreStrategy) {
        return gt(classMapping.getPropertyMapping(getPropertyName(name)), value, matchStrategy, queryAlias,
            ignoreStrategy);
    }

    /**
     * Gt.
     *
     * @param <V> the value type
     * @param pm the pm
     * @param value the value
     * @param queryAlias the query alias
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <V> L gt(JdbcPropertyMapping pm, V value, String queryAlias, Predicate<?> ignoreStrategy) {
        return gt(pm, value, MatchStrategy.AUTO, queryAlias, ignoreStrategy);
    }

    /**
     * Gt.
     *
     * @param <V> the value type
     * @param pm the pm
     * @param value the value
     * @param matchStrategy the match strategy
     * @param queryAlias the query alias
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <V> L gt(JdbcPropertyMapping pm, V value, MatchStrategy matchStrategy, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
            getFieldValueOperator(pm, value), ComparisonOperator.GT, matchStrategy, queryAlias, ignoreStrategy));
    }

    // ********************************************************************

    protected <V> L le(JdbcClassMapping<?> classMapping, Serializable name, int value, String queryAlias,
        IntPredicate ignoreStrategy) {
        return le(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias,
            v -> ignoreStrategy.test((Integer) v));
    }

    protected <V> L le(JdbcClassMapping<?> classMapping, Serializable name, long value, String queryAlias,
        LongPredicate ignoreStrategy) {
        return le(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias,
            v -> ignoreStrategy.test((Long) v));
    }

    protected <V> L le(JdbcClassMapping<?> classMapping, Serializable name, double value, String queryAlias,
        DoublePredicate ignoreStrategy) {
        return le(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias,
            v -> ignoreStrategy.test((Double) v));
    }

    /**
     * Le.
     *
     * @param <V> the value type
     * @param classMapping the class mapping
     * @param name the name
     * @param value the value
     * @param queryAlias the query alias
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <V> L le(JdbcClassMapping<?> classMapping, Serializable name, V value, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return le(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    }

    /**
     * Le.
     *
     * @param <V> the value type
     * @param classMapping the class mapping
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param queryAlias the query alias
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <V> L le(JdbcClassMapping<?> classMapping, Serializable name, V value, MatchStrategy matchStrategy,
        String queryAlias, Predicate<?> ignoreStrategy) {
        return le(classMapping.getPropertyMapping(getPropertyName(name)), value, matchStrategy, queryAlias,
            ignoreStrategy);
    }

    /**
     * Le.
     *
     * @param <V> the value type
     * @param pm the pm
     * @param value the value
     * @param queryAlias the query alias
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <V> L le(JdbcPropertyMapping pm, V value, String queryAlias, Predicate<?> ignoreStrategy) {
        return le(pm, value, MatchStrategy.AUTO, queryAlias, ignoreStrategy);
    }

    /**
     * Le.
     *
     * @param <V> the value type
     * @param pm the pm
     * @param value the value
     * @param matchStrategy the match strategy
     * @param queryAlias the query alias
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <V> L le(JdbcPropertyMapping pm, V value, MatchStrategy matchStrategy, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
            getFieldValueOperator(pm, value), ComparisonOperator.LE, matchStrategy, queryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    protected <V> L lt(JdbcClassMapping<?> classMapping, Serializable name, int value, String queryAlias,
        IntPredicate ignoreStrategy) {
        return lt(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias,
            v -> ignoreStrategy.test((Integer) v));
    }

    protected <V> L lt(JdbcClassMapping<?> classMapping, Serializable name, long value, String queryAlias,
        LongPredicate ignoreStrategy) {
        return lt(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias,
            v -> ignoreStrategy.test((Long) v));
    }

    protected <V> L lt(JdbcClassMapping<?> classMapping, Serializable name, double value, String queryAlias,
        DoublePredicate ignoreStrategy) {
        return lt(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias,
            v -> ignoreStrategy.test((Double) v));
    }

    /**
     * Lt.
     *
     * @param <V> the value type
     * @param classMapping the class mapping
     * @param name the name
     * @param value the value
     * @param queryAlias the query alias
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <V> L lt(JdbcClassMapping<?> classMapping, Serializable name, V value, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return lt(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    }

    /**
     * Lt.
     *
     * @param <V> the value type
     * @param classMapping the class mapping
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param queryAlias the query alias
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <V> L lt(JdbcClassMapping<?> classMapping, Serializable name, V value, MatchStrategy matchStrategy,
        String queryAlias, Predicate<?> ignoreStrategy) {
        return lt(classMapping.getPropertyMapping(getPropertyName(name)), value, matchStrategy, queryAlias,
            ignoreStrategy);
    }

    /**
     * Lt.
     *
     * @param <V> the value type
     * @param pm the pm
     * @param value the value
     * @param queryAlias the query alias
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <V> L lt(JdbcPropertyMapping pm, V value, String queryAlias, Predicate<?> ignoreStrategy) {
        return lt(pm, value, MatchStrategy.AUTO, queryAlias, ignoreStrategy);
    }

    /**
     * Lt.
     *
     * @param <V> the value type
     * @param pm the pm
     * @param value the value
     * @param matchStrategy the match strategy
     * @param queryAlias the query alias
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <V> L lt(JdbcPropertyMapping pm, V value, MatchStrategy matchStrategy, String queryAlias,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
            getFieldValueOperator(pm, value), ComparisonOperator.LT, matchStrategy, queryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    /**
     * Supplier.
     *
     * @param <R> the generic type
     * @param info the info
     * @param value the value
     * @return LogicExpressionist
     */
    protected <R> List<Tuple2<String, Optional<R>>> supplier(SerializedLambdaInfo info, R value) {
        return supplier(info, value, classMapping);
    }

    /**
     * Supplier.
     *
     * @param <R> the generic type
     * @param info the info
     * @return LogicExpressionist
     */
    protected <R> List<Tuple2<String, Optional<R>>> supplier(SerializableSupplierLambdaInfo<R> info) {
        return supplier(info, classMapping);
    }

    protected PropertyMapping<?> getPropertyMapping(int index, Object value) {
        if (propertyList.size() == 1) {
            ClassMapping<?, JdbcPropertyMapping> classMapping = getClassMapping(index);
            return classMapping.getPropertyMapping(LambdaUtils.getLambdaPropertyName(propertyList.get(0)));
        } else if (propertyList.size() == 2) {
            ClassMapping<?, JdbcPropertyMapping> classMapping = getClassMapping(index);
            JdbcPropertyMapping pm = classMapping
                .getPropertyMapping(LambdaUtils.getLambdaPropertyName(propertyList.get(0)));
            if (value == null) {
                // ENHANCE 这个查询值为null则直接返回对象映射的逻辑后续考虑是否合理
                return pm;
            }

            SerializedLambdaInfo propertyInfo = LambdaUtils.getLambdaInfo(propertyList.get(1));
            String pn = propertyInfo.getPropertyName();
            if (pm.getMode() == Mode.EMBEDDED) {
                JdbcPropertyMapping spm = pm.getPropertyMapping(pn);
                if (spm == null) {
                    throw new SqldbHammerException(Str.format("no property mapping found for {0}.{1}.{2}",
                        classMapping.getType().getSimpleName(), pm.getPropertyFullName(), pn));
                }
                return spm;
            } else if (Mode.MANY_TO_ONE == pm.getMode()) {
                // } else if (Mode.MANY_TO_ONE == pm.getMode() || Mode.ONE_TO_ONE == pm.getMode()) {
                // YUFEI_TEST 需要测试ONE_TO_ONE
                JdbcPropertyMapping spm = pm.getPropertyMapping(pn);
                if (spm != null) {
                    return spm;
                } else {
                    JdbcClassMapping<?> cm = factory.getClassMapping(pm.getPropertyType());
                    // 这里需要join，在条件设置中需要判断对象是否已经join，如果没有join，则需要在设置查询参数时，先join
                    // 所以需要在条件中记录已经join的对象关系来判断是否需要join
                    spm = cm.getPropertyMapping(pn);
                    if (spm != null) {
                        entityRelation.join(Join.LEFT_JOIN, index, pm.getPropertyName(), cm, false);
                        return spm;
                    } else {
                        throw new SqldbHammerException(
                            Str.format("no property mapping found for {0}.{1}", cm.getType().getSimpleName(), pn));
                    }
                }
            } else if (pm.getMode() == Mode.ONE_TO_MANY) {
                // IMPLSOON 未实现一对多
                // 在条件设置中需要判断对象是否已经join，如果没有join，则需要在设置查询参数时，先join
                // 所以需要在条件中记录已经join的对象关系来判断是否需要join
                throw new NotImplementedException();
            } else if (pm.getMode() == Mode.SINGLE) {
                // YUFEI_TEST 待测试，propertyList.size() > 1 时 propertyList.get(0)就不应该是Mode.SINGLE，所以应该永远进不了这个逻辑
                throw new NotImplementedException();
            }
            throw new UnsupportedException();
        } else {
            // IMPLSOON 未实现，出现多次对象嵌套，只可能出现在关联对象的情况即，即多次获取ManyToOne(OneToOne)的属性
            // 例如： order.getOwner().getUserInfo().getAddress().getNo()  -  order > user > user_info > address.no
            throw new NotImplementedException();
        }
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

    /**
     * {@inheritDoc}
     */
    @Override
    public Jdbc getJdbc() {
        return entityRelation.getJdbc();
    }
}
