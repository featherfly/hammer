
package cn.featherfly.hammer.sqldb.sql.dml;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.db.FieldValueOperator;
import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.exception.NotImplementedException;
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
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LambdaUtils.SerializableSupplierLambdaInfo;
import cn.featherfly.common.lang.LambdaUtils.SerializedLambdaInfo;
import cn.featherfly.common.operator.ComparisonOperator;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
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
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlRelation.EntityRelationMapping;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.EntityDatePropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.EntityDoublePropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.EntityEnumPropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.EntityIntPropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.EntityLocalDatePropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.EntityLocalDateTimePropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.EntityLocalTimePropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.EntityLongPropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.EntityNumberPropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.EntityStringPropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.EntityTypePropertyExpressionImpl;

/**
 * sql condition group builder sql条件逻辑组构造器 .
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
@SuppressWarnings("unchecked")
public abstract class AbstractEntitySqlConditionExpressionBase<E, ER extends EntitySqlRelation<ER, B>,
        B extends SqlBuilder, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractSqlConditionExpression<C, L> implements ConditionExpression //
        , EntityBetweenExpression<E, C, L>, EntityNotBetweenExpression<E, C, L> //
        , EntityContainsExpression<E, C, L>, EntityNotContainsExpression<E, C, L>//
        , EntityEndWithExpression<E, C, L>, EntityNotEndWithExpression<E, C, L> //
        , EntityEqualsExpression<E, C, L>, EntityIsNotNullExpression<E, C, L>//
        , EntityGreatEqualsExpression<E, C, L>, EntityGreatThanExpression<E, C, L> //
        , EntityInExpression<E, C, L>, EntityNotInExpression<E, C, L>//
        , EntityIsNullExpression<E, C, L>, EntityNotEqualsExpression<E, C, L> //
        , EntityLessEqualsExpression<E, C, L>, EntityLessThanExpression<E, C, L> //
        , EntityStartWithExpression<E, C, L>, EntityNotStartWithExpression<E, C, L>//
        , EntityLikeExpression<E, C, L>, EntityNotLikeExpression<E, C, L>//
        , EntityPropertyExpression<E, C, L> {

    //    /** The type query entity. */
    //    protected EntitySqlQuery<E> entityQuery;

    /** The factory. */
    protected JdbcMappingFactory factory;

    /** The alias manager. */
    protected AliasManager aliasManager;

    /** The class mapping. */
    protected JdbcClassMapping<E> classMapping;

    /** The query alias. */
    protected String queryAlias;

    /** The entity sql relation. */
    protected ER entityRelation;

    /**
     * Instantiates a new abstract sql condition group expression.
     *
     * @param parent         parent group
     * @param factory        the factory
     * @param entityRelation the entity relation
     */
    protected AbstractEntitySqlConditionExpressionBase(L parent, JdbcMappingFactory factory, ER entityRelation) {
        super(parent, entityRelation.getJdbc().getDialect(), entityRelation.getIgnorePolicy());
        this.factory = factory;
        EntityRelationMapping<
                E> erm = (EntityRelationMapping<E>) entityRelation.getEntityRelationMappingTuple().getOrNull0();
        queryAlias = erm.getTableAlias();
        classMapping = erm.getClassMapping();
        aliasManager = entityRelation.getAliasManager();
        ignoreStrategy = entityRelation.getIgnorePolicy();
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
    public <CM extends ClassMapping<T, P>, T, P extends PropertyMapping<P>> CM getClassMapping(int index) {
        return (CM) entityRelation.getEntityRelationMapping(index).getClassMapping();
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L eq(SerializableFunction<E, R> name, R value, MatchStrategy matchStrategy) {
        return eq(classMapping, name, value, queryAlias, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L eq(SerializableFunction<E, R> name, R value, MatchStrategy matchStrategy,
            Predicate<R> ignoreStrategy) {
        return eq(classMapping, name, value, queryAlias, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L eq(SerializableSupplier<R> property, MatchStrategy matchStrategy) {
        return eq(classMapping, property, queryAlias, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L eq(SerializableSupplier<R> property, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy) {
        return eq(classMapping, property, queryAlias, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public < R> L ne(SerializableFunction<E, R> name, R value) {
    //        //        return ne(getPropertyName(name), value);
    //        List<Tuple2<String, Optional<R>>> tuples = supplier(LambdaUtils.getLambdaInfo(name), value);
    //        L l = null;
    //        C c = (C) this;
    //        if (tuples.size() > 1) {
    //            c = group();
    //        }
    //        for (Tuple2<String, Optional<R>> tuple : tuples) {
    //            if (l != null) {
    //                c = l.and();
    //            }
    //            l = c.ne(tuple.get0(), tuple.get1().orElseGet(() -> null));
    //        }
    //        if (tuples.size() > 1) {
    //            l = l.endGroup();
    //        }
    //        return l;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public <R> L ne(SerializableSupplier<R> property) {
    //        //        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //        //        return ne(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    //        List<Tuple2<String, Optional<R>>> tuples = supplier(LambdaUtils.getSerializableSupplierLambdaInfo(property));
    //        L l = null;
    //        C c = (C) this;
    //        if (tuples.size() > 1) {
    //            c = group();
    //        }
    //        for (Tuple2<String, Optional<R>> tuple : tuples) {
    //            if (l != null) {
    //                c = l.and();
    //            }
    //            l = c.ne(tuple.get0(), tuple.get1().orElseGet(() -> null));
    //        }
    //        if (tuples.size() > 1) {
    //            l = l.endGroup();
    //        }
    //        return l;
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ne(SerializableFunction<E, R> name, R value, MatchStrategy matchStrategy) {
        return ne(classMapping, name, value, queryAlias, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ne(SerializableFunction<E, R> name, R value, MatchStrategy matchStrategy,
            Predicate<R> ignoreStrategy) {
        return ne(classMapping, name, value, queryAlias, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ne(SerializableSupplier<R> property, MatchStrategy matchStrategy) {
        return ne(classMapping, property, queryAlias, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ne(SerializableSupplier<R> property, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy) {
        return ne(classMapping, property, queryAlias, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy) {
        return lk(classMapping, name, value, queryAlias, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return lk(classMapping, name, value, queryAlias, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return lk(classMapping, property, queryAlias, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return lk(classMapping, property, queryAlias, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl(SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy) {
        return nl(classMapping, name, value, queryAlias, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl(SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return nl(classMapping, name, value, queryAlias, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return nl(classMapping, property, queryAlias, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nl(classMapping, property, queryAlias, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy) {
        return sw(classMapping, name, value, queryAlias, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return sw(classMapping, name, value, queryAlias, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return sw(classMapping, property, queryAlias, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return sw(classMapping, property, queryAlias, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw(SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy) {
        return nsw(classMapping, name, value, queryAlias, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw(SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return nsw(classMapping, name, value, queryAlias, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return nsw(classMapping, property, queryAlias, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nsw(classMapping, property, queryAlias, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy) {
        return ew(classMapping, name, value, queryAlias, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return ew(classMapping, name, value, queryAlias, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return ew(classMapping, property, queryAlias, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ew(classMapping, property, queryAlias, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L newv(SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy) {
        return newv(classMapping, name, value, queryAlias, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L newv(SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return newv(classMapping, name, value, queryAlias, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L newv(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return newv(classMapping, property, queryAlias, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L newv(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return newv(classMapping, property, queryAlias, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy) {
        return co(classMapping, name, value, queryAlias, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return co(classMapping, name, value, queryAlias, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return co(classMapping, property, queryAlias, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return co(classMapping, property, queryAlias, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco(SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy) {
        return nco(classMapping, name, value, queryAlias, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco(SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return nco(classMapping, name, value, queryAlias, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return nco(classMapping, property, queryAlias, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nco(classMapping, property, queryAlias, matchStrategy, ignoreStrategy);
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
    public <N extends Number> L ge(SerializableFunction<E, N> name, N value) {
        return ge(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ge(SerializableFunction<E, N> name, N value, Predicate<N> ignoreStrategy) {
        return ge(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ge(SerializableFunction<E, D> name, D value) {
        return ge(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ge(SerializableFunction<E, D> name, D value, Predicate<D> ignoreStrategy) {
        return ge(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableFunction<E, LocalTime> name, LocalTime value) {
        return ge(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableFunction<E, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ge(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableFunction<E, LocalDate> name, LocalDate value) {
        return ge(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableFunction<E, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ge(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableFunction<E, LocalDateTime> name, LocalDateTime value) {
        return ge(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableFunction<E, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return ge(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableFunction<E, String> name, String value) {
        return ge(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy) {
        return ge(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L ge(SerializableDateSupplier<R> property) {
        return ge(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L ge(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ge(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L ge(SerializableNumberSupplier<R> property) {
        return ge(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L ge(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ge(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableLocalDateSupplier property) {
        return ge(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return ge(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableLocalTimeSupplier property) {
        return ge(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return ge(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableLocalDateTimeSupplier property) {
        return ge(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return ge(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableStringSupplier property) {
        return ge(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return ge(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableToIntFunction<E> name, int value) {
        return ge(name, value, (Predicate<Integer>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableToIntFunction<E> name, int value, Predicate<Integer> ignoreStrategy) {
        return ge(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableToLongFunction<E> name, long value) {
        return ge(name, value, (Predicate<Long>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableToLongFunction<E> name, long value, Predicate<Long> ignoreStrategy) {
        return ge(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableToDoubleFunction<E> name, double value) {
        return ge(name, value, (Predicate<Double>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableToDoubleFunction<E> name, double value, Predicate<Double> ignoreStrategy) {
        return ge(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableIntSupplier property) {
        return ge(property, (Predicate<Integer>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return ge(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableLongSupplier property) {
        return ge(property, (Predicate<Long>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return ge(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableDoubleSupplier property) {
        return ge(property, (Predicate<Double>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy) {
        return ge(classMapping, property, queryAlias, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L gt(SerializableFunction<E, N> name, N value) {
        return gt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L gt(SerializableFunction<E, N> name, N value, Predicate<N> ignoreStrategy) {
        return gt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L gt(SerializableFunction<E, D> name, D value) {
        return gt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L gt(SerializableFunction<E, D> name, D value, Predicate<D> ignoreStrategy) {
        return gt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableFunction<E, LocalTime> name, LocalTime value) {
        return gt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableFunction<E, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return gt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableFunction<E, LocalDate> name, LocalDate value) {
        return gt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableFunction<E, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return gt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableFunction<E, LocalDateTime> name, LocalDateTime value) {
        return gt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableFunction<E, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return gt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableFunction<E, String> name, String value) {
        return gt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy) {
        return gt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L gt(SerializableNumberSupplier<R> property) {
        return gt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L gt(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return gt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L gt(SerializableDateSupplier<R> property) {
        return gt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L gt(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return gt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableLocalDateSupplier property) {
        return gt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return gt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableLocalTimeSupplier property) {
        return gt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return gt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableLocalDateTimeSupplier property) {
        return gt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return gt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableStringSupplier property) {
        return gt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return gt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableToIntFunction<E> name, int value) {
        return gt(name, value, (Predicate<Integer>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableToIntFunction<E> name, int value, Predicate<Integer> ignoreStrategy) {
        return gt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableToLongFunction<E> name, long value) {
        return gt(name, value, (Predicate<Long>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableToLongFunction<E> name, long value, Predicate<Long> ignoreStrategy) {
        return gt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableToDoubleFunction<E> name, double value) {
        return gt(name, value, (Predicate<Double>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableToDoubleFunction<E> name, double value, Predicate<Double> ignoreStrategy) {
        return gt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableIntSupplier property) {
        return gt(property, (Predicate<Integer>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return gt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableLongSupplier property) {
        return gt(property, (Predicate<Long>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return gt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableDoubleSupplier property) {
        return gt(property, (Predicate<Double>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy) {
        return gt(classMapping, property, queryAlias, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in(SerializableFunction<E, R> name, R value) {
        //        return in(classMapping, name, value, queryAlias, ignoreStrategy);
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in(SerializableFunction<E, R> name, R value, Predicate<R> ignoreStrategy) {
        //        return in(classMapping, name, value, queryAlias, ignoreStrategy);
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in(SerializableFunction<E, R> name, R... value) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in(SerializableFunction<E, R> name, R[] value, Predicate<R[]> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in(SerializableFunction<E, R> name, Collection<R> value) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in(SerializableFunction<E, R> name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in(SerializableSupplier<R> property) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return in(classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), property.get(),
                queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return in(classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), property.get(),
                queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToIntFunction<E> name, int value) {
        //        return in(classMapping, name, value, (Predicate<Integer>) ignoreStrategy);
        return in(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToIntFunction<E> name, int value, Predicate<Integer> ignoreStrategy) {
        return in(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToLongFunction<E> name, long value) {
        //        return in(classMapping, name, value, (Predicate<Long>) ignoreStrategy);
        return in(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToLongFunction<E> name, long value, Predicate<Long> ignoreStrategy) {
        return in(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToIntFunction<E> name, int... value) {
        //        return in(classMapping, name, value, (Predicate<int[]>) ignoreStrategy);
        return in(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToLongFunction<E> name, long... value) {
        //        return in(classMapping, name, value, (Predicate<long[]>) ignoreStrategy);
        return in(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToIntFunction<E> name, int[] value, Predicate<int[]> ignoreStrategy) {
        return in(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(SerializableToLongFunction<E> name, long[] value, Predicate<long[]> ignoreStrategy) {
        return in(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in(SerializableIntSupplier property) {
        return in(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return in(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in(SerializableLongSupplier property) {
        return in(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return in(classMapping, property, queryAlias, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni(SerializableFunction<E, R> name, R value) {
        return ni(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni(SerializableFunction<E, R> name, R value, Predicate<R> ignoreStrategy) {
        return ni(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni(SerializableFunction<E, R> name, R... value) {
        return ni(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni(SerializableFunction<E, R> name, R[] value, Predicate<R[]> ignoreStrategy) {
        return ni(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni(SerializableFunction<E, R> name, Collection<R> value) {
        return ni(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni(SerializableFunction<E, R> name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy) {
        return ni(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni(SerializableSupplier<R> property) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ni(classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), property.get(),
                queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ni(classMapping.getPropertyMapping(info.getSerializedLambdaInfo().getPropertyName()), property.get(),
                queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableToIntFunction<E> name, int value) {
        //        return ni(classMapping, name, value, (Predicate<Integer>) ignoreStrategy);
        return ni(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableToIntFunction<E> name, int value, Predicate<Integer> ignoreStrategy) {
        return ni(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableToLongFunction<E> name, long value) {
        //        return ni(classMapping, name, value, (Predicate<Long>) ignoreStrategy);
        return ni(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableToLongFunction<E> name, long value, Predicate<Long> ignoreStrategy) {
        return ni(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableToIntFunction<E> name, int... value) {
        //        return ni(classMapping, name, value, (Predicate<int[]>) ignoreStrategy);
        return ni(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableToLongFunction<E> name, long... value) {
        //        return ni(classMapping, name, value, (Predicate<long[]>) ignoreStrategy);
        return ni(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableToIntFunction<E> name, int[] value, Predicate<int[]> ignoreStrategy) {
        return ni(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(SerializableToLongFunction<E> name, long[] value, Predicate<long[]> ignoreStrategy) {
        return ni(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni(SerializableIntSupplier property) {
        //        return ni(property, (Predicate<Integer>) ignoreStrategy);
        return ni(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return ni(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni(SerializableLongSupplier property) {
        //        return ni(property, (Predicate<Long>) ignoreStrategy);
        return ni(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return ni(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L inn(SerializableFunction<E, R> name, Boolean value) {
        return inn(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L isn(SerializableFunction<E, R> name, Boolean value) {
        return isn(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L le(SerializableFunction<E, N> name, N value) {
        return le(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L le(SerializableFunction<E, N> name, N value, Predicate<N> ignoreStrategy) {
        return le(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L le(SerializableFunction<E, D> name, D value) {
        return le(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L le(SerializableFunction<E, D> name, D value, Predicate<D> ignoreStrategy) {
        return le(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableFunction<E, LocalTime> name, LocalTime value) {
        return le(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableFunction<E, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return le(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableFunction<E, LocalDate> name, LocalDate value) {
        return le(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableFunction<E, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return le(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableFunction<E, LocalDateTime> name, LocalDateTime value) {
        return le(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableFunction<E, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return le(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableFunction<E, String> name, String value) {
        return le(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy) {
        return le(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L le(SerializableDateSupplier<R> property) {
        return le(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L le(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return le(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L le(SerializableNumberSupplier<R> property) {
        return le(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L le(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return le(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableLocalDateSupplier property) {
        return le(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return le(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableLocalTimeSupplier property) {
        return le(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return le(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableLocalDateTimeSupplier property) {
        return le(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return le(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableStringSupplier property) {
        return le(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return le(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableToIntFunction<E> name, int value) {
        return le(name, value, (Predicate<Integer>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableToIntFunction<E> name, int value, Predicate<Integer> ignoreStrategy) {
        return le(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableToLongFunction<E> name, long value) {
        return le(name, value, (Predicate<Long>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableToLongFunction<E> name, long value, Predicate<Long> ignoreStrategy) {
        return le(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableToDoubleFunction<E> name, double value) {
        return le(name, value, (Predicate<Double>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableToDoubleFunction<E> name, double value, Predicate<Double> ignoreStrategy) {
        return le(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableIntSupplier property) {
        return le(property, (Predicate<Integer>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return le(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableLongSupplier property) {
        return le(property, (Predicate<Long>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return le(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableDoubleSupplier property) {
        return le(property, (Predicate<Double>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy) {
        return le(classMapping, property, queryAlias, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L lt(SerializableFunction<E, N> name, N value) {
        return lt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L lt(SerializableFunction<E, N> name, N value, Predicate<N> ignoreStrategy) {
        return lt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L lt(SerializableFunction<E, D> name, D value) {
        return lt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L lt(SerializableFunction<E, D> name, D value, Predicate<D> ignoreStrategy) {
        return lt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableFunction<E, LocalTime> name, LocalTime value) {
        return lt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableFunction<E, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return lt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableFunction<E, LocalDate> name, LocalDate value) {
        return lt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableFunction<E, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return lt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableFunction<E, LocalDateTime> name, LocalDateTime value) {
        return lt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableFunction<E, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return lt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableFunction<E, String> name, String value) {
        return lt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy) {
        return lt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L lt(SerializableNumberSupplier<R> property) {
        return lt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L lt(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return lt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L lt(SerializableDateSupplier<R> property) {
        return lt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L lt(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return lt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableLocalDateSupplier property) {
        return lt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return lt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableLocalTimeSupplier property) {
        return lt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return lt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableLocalDateTimeSupplier property) {
        return lt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return lt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableStringSupplier property) {
        return lt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return lt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableToIntFunction<E> name, int value) {
        return lt(name, value, (Predicate<Integer>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableToIntFunction<E> name, int value, Predicate<Integer> ignoreStrategy) {
        return lt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableToLongFunction<E> name, long value) {
        return lt(name, value, (Predicate<Long>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableToLongFunction<E> name, long value, Predicate<Long> ignoreStrategy) {
        return lt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableToDoubleFunction<E> name, double value) {
        return lt(name, value, (Predicate<Double>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableToDoubleFunction<E> name, double value, Predicate<Double> ignoreStrategy) {
        return lt(classMapping, name, value, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableIntSupplier property) {
        return lt(property, (Predicate<Integer>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return lt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableLongSupplier property) {
        return lt(property, (Predicate<Long>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return lt(classMapping, property, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableDoubleSupplier property) {
        return lt(property, (Predicate<Double>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy) {
        return lt(classMapping, property, queryAlias, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableToIntFunction<E> name, int min, int max) {
        return ba(classMapping, name, min, max, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableToIntFunction<E> name, int min, int max, BiPredicate<Integer, Integer> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableToLongFunction<E> name, long min, long max) {
        return ba(classMapping, name, min, max, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableToLongFunction<E> name, long min, long max, BiPredicate<Long, Long> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableToDoubleFunction<E> name, double min, double max) {
        return ba(classMapping, name, min, max, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableToDoubleFunction<E> name, double min, double max,
            BiPredicate<Double, Double> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ba(SerializableFunction<E, N> name, N min, N max) {
        return ba(classMapping, name, min, max, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ba(SerializableFunction<E, N> name, N min, N max, BiPredicate<N, N> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ba(SerializableFunction<E, D> name, D min, D max) {
        return ba(classMapping, name, min, max, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ba(SerializableFunction<E, D> name, D min, D max, BiPredicate<D, D> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableFunction<E, LocalTime> name, LocalTime min, LocalTime max) {
        return ba(classMapping, name, min, max, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableFunction<E, LocalTime> name, LocalTime min, LocalTime max,
            BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableFunction<E, LocalDate> name, LocalDate min, LocalDate max) {
        return ba(classMapping, name, min, max, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableFunction<E, LocalDate> name, LocalDate min, LocalDate max,
            BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableFunction<E, LocalDateTime> name, LocalDateTime min, LocalDateTime max) {
        return ba(classMapping, name, min, max, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableFunction<E, LocalDateTime> name, LocalDateTime min, LocalDateTime max,
            BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableFunction<E, String> name, String min, String max) {
        return ba(classMapping, name, min, max, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(SerializableFunction<E, String> name, String min, String max,
            BiPredicate<String, String> ignoreStrategy) {
        return ba(classMapping, name, min, max, queryAlias, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableToIntFunction<E> name, int min, int max) {
        return nba(classMapping, name, min, max, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableToIntFunction<E> name, int min, int max, BiPredicate<Integer, Integer> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableToLongFunction<E> name, long min, long max) {
        return nba(classMapping, name, min, max, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableToLongFunction<E> name, long min, long max, BiPredicate<Long, Long> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableToDoubleFunction<E> name, double min, double max) {
        return nba(classMapping, name, min, max, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableToDoubleFunction<E> name, double min, double max,
            BiPredicate<Double, Double> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L nba(SerializableFunction<E, N> name, N min, N max) {
        return nba(classMapping, name, min, max, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L nba(SerializableFunction<E, N> name, N min, N max, BiPredicate<N, N> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L nba(SerializableFunction<E, D> name, D min, D max) {
        return nba(classMapping, name, min, max, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L nba(SerializableFunction<E, D> name, D min, D max, BiPredicate<D, D> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableFunction<E, LocalTime> name, LocalTime min, LocalTime max) {
        return nba(classMapping, name, min, max, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableFunction<E, LocalTime> name, LocalTime min, LocalTime max,
            BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableFunction<E, LocalDate> name, LocalDate min, LocalDate max) {
        return nba(classMapping, name, min, max, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableFunction<E, LocalDate> name, LocalDate min, LocalDate max,
            BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableFunction<E, LocalDateTime> name, LocalDateTime min, LocalDateTime max) {
        return nba(classMapping, name, min, max, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableFunction<E, LocalDateTime> name, LocalDateTime min, LocalDateTime max,
            BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableFunction<E, String> name, String min, String max) {
        return nba(classMapping, name, min, max, queryAlias, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(SerializableFunction<E, String> name, String min, String max,
            BiPredicate<String, String> ignoreStrategy) {
        return nba(classMapping, name, min, max, queryAlias, ignoreStrategy);
    }

    // ****************************************************************************************************************
    // property
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityTypePropertyExpression<R, C, L> property(SerializableFunction<E, R> name) {
        return new EntityTypePropertyExpressionImpl<>(0, name, this, factory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Collection<RE>,
            RE> EntityTypePropertyExpression<RE, C, L> property(SerializableToCollectionFunction<E, R, RE> name) {
        // IMPLSOON 后续来实现集合类型property
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityIntPropertyExpression<E, C, L> property(SerializableToIntFunction<E> name) {
        return new EntityIntPropertyExpressionImpl<>(0, name, this, factory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLongPropertyExpression<E, C, L> property(SerializableToLongFunction<E> name) {
        return new EntityLongPropertyExpressionImpl<>(0, name, this, factory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityDoublePropertyExpression<E, C, L> property(SerializableToDoubleFunction<E> name) {
        return new EntityDoublePropertyExpressionImpl<>(0, name, this, factory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> EntityNumberPropertyExpression<E, R, C, L> property(
            SerializableToNumberFunction<E, R> name) {
        return new EntityNumberPropertyExpressionImpl<>(0, name, this, factory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityStringPropertyExpression<E, C, L> property(SerializableToStringFunction<E> name) {
        return new EntityStringPropertyExpressionImpl<>(0, name, this, factory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> EntityDatePropertyExpression<E, R, C, L> property(SerializableToDateFunction<E, R> name) {
        return new EntityDatePropertyExpressionImpl<>(0, name, this, factory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLocalDatePropertyExpression<E, C, L> property(SerializableToLocalDateFunction<E> name) {
        return new EntityLocalDatePropertyExpressionImpl<>(0, name, this, factory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLocalDateTimePropertyExpression<E, C, L> property(SerializableToLocalDateTimeFunction<E> name) {
        return new EntityLocalDateTimePropertyExpressionImpl<>(0, name, this, factory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLocalTimePropertyExpression<E, C, L> property(SerializableToLocalTimeFunction<E> name) {
        return new EntityLocalTimePropertyExpressionImpl<>(0, name, this, factory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Enum<R>> EntityEnumPropertyExpression<E, R, C, L> property(
            SerializableToEnumFunction<E, R> name) {
        return new EntityEnumPropertyExpressionImpl<>(0, name, this, factory);
    }

    // ****************************************************************************************************************

    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L expression(String expression, final Map<String, Object> params) {
    //        final Execution execution = SqlUtils.convertNamedParamSql(expression, params);
    //        return expression(execution.getExecution(), execution.getParams());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public L expression(String expression, Object... params) {
    //        return (L) addCondition(new ParamedExpression() {
    //
    //
    //            public String expression() {
    //                return expression;
    //            }
    //
    //
    //            public Object getParam() {
    //                return params;
    //            }
    //        });
    //    }

    /**
     * Sets the ignore strategy.
     *
     * @param ignoreStrategy the ignore strategy
     * @return the c
     */
    public C setIgnoreStrategy(Predicate<?> ignoreStrategy) {
        AssertIllegalArgument.isNotNull(ignoreStrategy, "ignoreStrategy");
        this.ignoreStrategy = ignoreStrategy;
        return (C) this;
    }

    //  /**
    //     * {@inheritDoc}
    //     */
    //
    //    public <R> ObjectExpression<C, L> property(SerializableFunction<E, R> name) {
    //        return property(getPropertyName(name));
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //
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

    //    protected abstract <EC extends EntityConditionsExpression<E, EC, EL>,
    //            EL extends LogicExpression<EC, EL>> EntityConditionsExpression<E, EC, EL> getEntityConditionsExpression();
    //
    //    protected abstract <EC extends EntityConditionsExpression<E, EC, EL>,
    //            EL extends LogicExpression<EC, EL>> EntityConditionsExpression<E, EC,
    //                    EL> createEntityEnumPropertyExpression();

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
                param = Array.newInstance(FieldValueOperator.class, length);
                for (int i = 0; i < length; i++) {
                    //                    Array.set(param, i, new FieldValueOperator(pm.getJavaTypeSqlTypeOperator(), Array.get(value, i)));
                    Array.set(param, i, FieldValueOperator.create(pm, Array.get(value, i)));
                }
            } else if (value instanceof Collection) {
                param = new ArrayList<>();
                for (Object op : (Collection<?>) value) {
                    ((Collection<FieldValueOperator<?>>) param).add(FieldValueOperator.create(pm, op));
                    //                    .add(new FieldValueOperator(pm.getJavaTypeSqlTypeOperator(), op));
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
            MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return eq(classMapping, property, property.get(), queryAlias, matchStrategy, ignoreStrategy);
    }

    protected <R> L eq(JdbcClassMapping<?> classMapping, Serializable property, R value, String queryAlias,
            MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return eq_ne(ComparisonOperator.EQ, classMapping.getPropertyMapping(getPropertyName(property)), value,
                queryAlias, matchStrategy, ignoreStrategy);
    }

    protected <R> L ne(JdbcClassMapping<?> classMapping, SerializableSupplier<R> property, String queryAlias,
            MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return ne(classMapping, property, property.get(), queryAlias, matchStrategy, ignoreStrategy);
    }

    protected <R> L ne(JdbcClassMapping<?> classMapping, Serializable property, R value, String queryAlias,
            MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return eq_ne(ComparisonOperator.NE, classMapping.getPropertyMapping(getPropertyName(property)), value,
                queryAlias, matchStrategy, ignoreStrategy);
    }

    protected abstract <T, R> L eq_ne(ComparisonOperator comparisonOperator, PropertyMapping<?> pm, R value,
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

    protected <T, R> L sw(JdbcClassMapping<?> classMapping, Serializable property, String value, String queryAlias,
            MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return sw(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias, matchStrategy,
                ignoreStrategy);
    }

    protected <T> L sw(JdbcPropertyMapping pm, String value, String queryAlias, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), ComparisonOperator.SW, matchStrategy, queryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    protected L nsw(JdbcClassMapping<?> classMapping, SerializableSupplier<String> property, String queryAlias,
            MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return nsw(classMapping, property, property.get(), queryAlias, matchStrategy, ignoreStrategy);
    }

    protected <T, R> L nsw(JdbcClassMapping<?> classMapping, Serializable property, String value, String queryAlias,
            MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return nsw(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias, matchStrategy,
                ignoreStrategy);
    }

    protected <T> L nsw(JdbcPropertyMapping pm, String value, String queryAlias, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), ComparisonOperator.NSW, matchStrategy, queryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    protected L co(JdbcClassMapping<?> classMapping, SerializableSupplier<String> property, String queryAlias,
            MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return co(classMapping, property, property.get(), queryAlias, matchStrategy, ignoreStrategy);
    }

    protected <T, R> L co(JdbcClassMapping<?> classMapping, Serializable property, String value, String queryAlias,
            MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return co(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias, matchStrategy,
                ignoreStrategy);
    }

    protected <T> L co(JdbcPropertyMapping pm, String value, String queryAlias, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), ComparisonOperator.CO, matchStrategy, queryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    protected L nco(JdbcClassMapping<?> classMapping, SerializableSupplier<String> property, String queryAlias,
            MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return nco(classMapping, property, property.get(), queryAlias, matchStrategy, ignoreStrategy);
    }

    protected <T, R> L nco(JdbcClassMapping<?> classMapping, Serializable property, String value, String queryAlias,
            MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return nco(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias, matchStrategy,
                ignoreStrategy);
    }

    protected <T> L nco(JdbcPropertyMapping pm, String value, String queryAlias, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), ComparisonOperator.NCO, matchStrategy, queryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    protected L ew(JdbcClassMapping<?> classMapping, SerializableSupplier<String> property, String queryAlias,
            MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return ew(classMapping, property, property.get(), queryAlias, matchStrategy, ignoreStrategy);
    }

    protected <T, R> L ew(JdbcClassMapping<?> classMapping, Serializable property, String value, String queryAlias,
            MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return ew(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias, matchStrategy,
                ignoreStrategy);
    }

    protected <T> L ew(JdbcPropertyMapping pm, String value, String queryAlias, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), ComparisonOperator.EW, matchStrategy, queryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    protected L newv(JdbcClassMapping<?> classMapping, SerializableSupplier<String> property, String queryAlias,
            MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return newv(classMapping, property, property.get(), queryAlias, matchStrategy, ignoreStrategy);
    }

    protected <T, R> L newv(JdbcClassMapping<?> classMapping, Serializable property, String value, String queryAlias,
            MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return newv(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias, matchStrategy,
                ignoreStrategy);
    }

    protected <T> L newv(JdbcPropertyMapping pm, String value, String queryAlias, MatchStrategy matchStrategy,
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

    //    protected <T> L in(SerializableToIntFunction<T> name, int value, String queryAlias, Predicate<?> ignoreStrategy) {
    //        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    //    }
    //
    //    protected <T> L in(SerializableToLongFunction<T> name, long value, String queryAlias, Predicate<?> ignoreStrategy) {
    //        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    //    }
    //
    //    protected <T> L in(SerializableToDoubleFunction<T> name, double value, String queryAlias,
    //            Predicate<?> ignoreStrategy) {
    //        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    //    }
    //
    //    protected <T> L in(SerializableToIntFunction<T> name, int[] value, String queryAlias, Predicate<?> ignoreStrategy) {
    //        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    //    }
    //
    //    protected <T> L in(SerializableToLongFunction<T> name, long[] value, String queryAlias, Predicate<?> ignoreStrategy) {
    //        return in(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    //    }

    protected <T> L in(JdbcClassMapping<?> classMapping, SerializableIntSupplier property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return in(classMapping, property, property.getAsInt(), queryAlias, ignoreStrategy);
    }

    protected <T> L in(JdbcClassMapping<?> classMapping, SerializableLongSupplier property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return in(classMapping, property, property.getAsLong(), queryAlias, ignoreStrategy);
    }

    protected <T> L in(JdbcClassMapping<?> classMapping, SerializableDoubleSupplier property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return in(classMapping, property, property.getAsDouble(), queryAlias, ignoreStrategy);
    }

    protected <R> L in(JdbcClassMapping<?> classMapping, SerializableSupplier<R> property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return in(classMapping, property, property.get(), queryAlias, ignoreStrategy);
    }

    protected <T, R> L in(JdbcClassMapping<?> classMapping, Serializable property, R value, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return in(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias, ignoreStrategy);
    }

    protected <T, R> L in(JdbcPropertyMapping pm, R value, String queryAlias, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                getInParam(pm, value), ComparisonOperator.IN, queryAlias, ignoreStrategy));
    }

    //    protected <T, R> L in_ni(boolean in, JdbcPropertyMapping pm, R value, String queryAlias,
    //            Predicate<?> ignoreStrategy) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
    //                getInParam(pm, value), in ? ComparisonOperator.IN : ComparisonOperator.NIN, queryAlias, ignoreStrategy));
    //    }

    // ****************************************************************************************************************

    protected <T> L ni(JdbcClassMapping<?> classMapping, SerializableIntSupplier property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return ni(classMapping, property, property.getAsInt(), queryAlias, ignoreStrategy);
    }

    protected <T> L ni(JdbcClassMapping<?> classMapping, SerializableLongSupplier property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return ni(classMapping, property, property.getAsLong(), queryAlias, ignoreStrategy);
    }

    protected <T> L ni(JdbcClassMapping<?> classMapping, SerializableDoubleSupplier property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return ni(classMapping, property, property.getAsDouble(), queryAlias, ignoreStrategy);
    }

    protected <R> L ni(JdbcClassMapping<?> classMapping, SerializableSupplier<R> property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return ni(classMapping, property, property.get(), queryAlias, ignoreStrategy);
    }

    protected <T, R> L ni(JdbcClassMapping<?> classMapping, Serializable property, R value, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return ni(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias, ignoreStrategy);
    }

    protected <R> L ni(JdbcPropertyMapping pm, R value, String queryAlias, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                getInParam(pm, value), ComparisonOperator.NI, queryAlias, ignoreStrategy));
    }

    protected <T, R> L isn(JdbcClassMapping<?> classMapping, Serializable property, Boolean value, String queryAlias) {
        return isn(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias);
    }

    protected L isn(JdbcPropertyMapping pm, Boolean value, String queryAlias) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(), value,
                ComparisonOperator.ISN, queryAlias, ignoreStrategy));
    }

    protected <T, R> L inn(JdbcClassMapping<?> classMapping, Serializable property, Boolean value, String queryAlias) {
        return inn(classMapping.getPropertyMapping(getPropertyName(property)), value, queryAlias);
    }

    protected L inn(JdbcPropertyMapping pm, Boolean value, String queryAlias) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(), value,
                ComparisonOperator.INN, queryAlias, ignoreStrategy));
    }

    // ********************************************************************

    //    protected <T> L ge(SerializableToIntFunction<T> name, int value, String queryAlias, Predicate<?> ignoreStrategy) {
    //        return ge(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    //    }
    //
    //    protected <T> L ge(SerializableToLongFunction<T> name, long value, String queryAlias, Predicate<?> ignoreStrategy) {
    //        return ge(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    //    }
    //
    //    protected <T> L ge(SerializableToDoubleFunction<T> name, double value, String queryAlias,
    //            Predicate<?> ignoreStrategy) {
    //        return ge(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    //    }
    //
    //    protected <T, V> L ge(SerializableFunction<T, V> name, V value, String queryAlias, Predicate<?> ignoreStrategy) {
    //        return ge(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    //    }

    protected L ge(JdbcClassMapping<?> classMapping, SerializableIntSupplier property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return ge(classMapping, property, property.getAsInt(), queryAlias, ignoreStrategy);
    }

    protected L ge(JdbcClassMapping<?> classMapping, SerializableLongSupplier property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return ge(classMapping, property, property.getAsLong(), queryAlias, ignoreStrategy);
    }

    protected L ge(JdbcClassMapping<?> classMapping, SerializableDoubleSupplier property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return ge(classMapping, property, property.getAsDouble(), queryAlias, ignoreStrategy);
    }

    protected <V> L ge(JdbcClassMapping<?> classMapping, SerializableSupplier<V> property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return ge(classMapping, property, property.get(), queryAlias, ignoreStrategy);
    }

    protected <T, V> L ge(JdbcClassMapping<?> classMapping, Serializable name, V value, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return ge(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    }

    protected <V> L ge(JdbcPropertyMapping pm, V value, String queryAlias, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), ComparisonOperator.GE, queryAlias, ignoreStrategy));
    }

    // ********************************************************************

    protected <T, V> L ba(JdbcClassMapping<?> classMapping, Serializable name, V min, V max, String queryAlias,
            BiPredicate<V, V> ignoreStrategy) {
        return ba(classMapping.getPropertyMapping(getPropertyName(name)), min, max, queryAlias,
                p -> ignoreStrategy.test(min, max));
        //        return ba(classMapping.getPropertyMapping(getPropertyName(name)), min, max, queryAlias, p -> {
        //            Object[] params = (Object[]) p;
        //            return ignoreStrategy.test((V) params[0], (V) params[1]);
        //        });
    }

    protected <T, V> L ba(JdbcClassMapping<?> classMapping, Serializable name, V min, V max, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return ba(classMapping.getPropertyMapping(getPropertyName(name)), min, max, queryAlias, ignoreStrategy);
    }

    protected <V> L ba(JdbcPropertyMapping pm, V min, V max, String queryAlias, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                new FieldValueOperator[] { getFieldValueOperator(pm, min), getFieldValueOperator(pm, max) },
                ComparisonOperator.BA, queryAlias, ignoreStrategy));
    }

    // ********************************************************************

    protected <T, V> L nba(JdbcClassMapping<?> classMapping, Serializable name, V min, V max, String queryAlias,
            BiPredicate<V, V> ignoreStrategy) {
        return nba(classMapping.getPropertyMapping(getPropertyName(name)), min, max, queryAlias,
                p -> ignoreStrategy.test(min, max));
        //        return nba(classMapping.getPropertyMapping(getPropertyName(name)), min, max, queryAlias, p -> {
        //            Object[] params = (Object[]) p;
        //            return ignoreStrategy.test((V) params[0], (V) params[1]);
        //        });
    }

    protected <T, V> L nba(JdbcClassMapping<?> classMapping, Serializable name, V min, V max, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return nba(classMapping.getPropertyMapping(getPropertyName(name)), min, max, queryAlias, ignoreStrategy);
    }

    protected <V> L nba(JdbcPropertyMapping pm, V min, V max, String queryAlias, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                new FieldValueOperator[] { getFieldValueOperator(pm, min), getFieldValueOperator(pm, max) },
                ComparisonOperator.NBA, queryAlias, ignoreStrategy));
    }

    // ********************************************************************

    //    protected <T> L gt(SerializableToIntFunction<T> name, int value, String queryAlias, Predicate<?> ignoreStrategy) {
    //        return gt(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    //    }
    //
    //    protected <T> L gt(SerializableToLongFunction<T> name, long value, String queryAlias, Predicate<?> ignoreStrategy) {
    //        return gt(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    //    }
    //
    //    protected <T> L gt(SerializableToDoubleFunction<T> name, double value, String queryAlias,
    //            Predicate<?> ignoreStrategy) {
    //        return gt(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    //    }
    //
    //    protected <V> L gt(SerializableFunction<E, V> name, V value, String queryAlias, Predicate<?> ignoreStrategy) {
    //        return gt(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    //    }

    protected L gt(JdbcClassMapping<?> classMapping, SerializableIntSupplier property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return gt(classMapping, property, property.getAsInt(), queryAlias, ignoreStrategy);
    }

    protected L gt(JdbcClassMapping<?> classMapping, SerializableLongSupplier property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return gt(classMapping, property, property.getAsLong(), queryAlias, ignoreStrategy);
    }

    protected L gt(JdbcClassMapping<?> classMapping, SerializableDoubleSupplier property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return gt(classMapping, property, property.getAsDouble(), queryAlias, ignoreStrategy);
    }

    protected <V> L gt(JdbcClassMapping<?> classMapping, SerializableSupplier<V> property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return gt(classMapping, property, property.get(), queryAlias, ignoreStrategy);
    }

    protected <T, V> L gt(JdbcClassMapping<?> classMapping, Serializable name, V value, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return gt(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    }

    protected <V> L gt(JdbcPropertyMapping pm, V value, String queryAlias, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), ComparisonOperator.GT, queryAlias, ignoreStrategy));
    }

    // ********************************************************************

    //    protected <T> L le(SerializableToIntFunction<T> name, int value, String queryAlias, Predicate<?> ignoreStrategy) {
    //        return le(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    //    }
    //
    //    protected <T> L le(SerializableToLongFunction<T> name, long value, String queryAlias, Predicate<?> ignoreStrategy) {
    //        return le(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    //    }
    //
    //    protected <T> L le(SerializableToDoubleFunction<T> name, double value, String queryAlias,
    //            Predicate<?> ignoreStrategy) {
    //        return le(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    //    }
    //
    //    protected <V> L le(SerializableFunction<E, V> name, V value, String queryAlias, Predicate<?> ignoreStrategy) {
    //        return le(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    //    }

    protected L le(JdbcClassMapping<?> classMapping, SerializableIntSupplier property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return le(classMapping, property, property.getAsInt(), queryAlias, ignoreStrategy);
    }

    protected L le(JdbcClassMapping<?> classMapping, SerializableLongSupplier property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return le(classMapping, property, property.getAsLong(), queryAlias, ignoreStrategy);
    }

    protected L le(JdbcClassMapping<?> classMapping, SerializableDoubleSupplier property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return le(classMapping, property, property.getAsDouble(), queryAlias, ignoreStrategy);
    }

    protected <V> L le(JdbcClassMapping<?> classMapping, SerializableSupplier<V> property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return le(classMapping, property, property.get(), queryAlias, ignoreStrategy);
    }

    protected <T, V> L le(JdbcClassMapping<?> classMapping, Serializable name, V value, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return le(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    }

    protected <V> L le(JdbcPropertyMapping pm, V value, String queryAlias, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), ComparisonOperator.LE, queryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    //    protected <T> L lt(SerializableToIntFunction<T> name, int value, String queryAlias, Predicate<?> ignoreStrategy) {
    //        return lt(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    //    }
    //
    //    protected <T> L lt(SerializableToLongFunction<T> name, long value, String queryAlias, Predicate<?> ignoreStrategy) {
    //        return lt(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    //    }
    //
    //    protected <T> L lt(SerializableToDoubleFunction<T> name, double value, String queryAlias,
    //            Predicate<?> ignoreStrategy) {
    //        return lt(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    //    }
    //
    //    protected <V> L lt(SerializableFunction<E, V> name, V value, String queryAlias, Predicate<?> ignoreStrategy) {
    //        return lt(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    //    }

    protected L lt(JdbcClassMapping<?> classMapping, SerializableIntSupplier property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return lt(classMapping, property, property.getAsInt(), queryAlias, ignoreStrategy);
    }

    protected L lt(JdbcClassMapping<?> classMapping, SerializableLongSupplier property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return lt(classMapping, property, property.getAsLong(), queryAlias, ignoreStrategy);
    }

    protected L lt(JdbcClassMapping<?> classMapping, SerializableDoubleSupplier property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return lt(classMapping, property, property.getAsDouble(), queryAlias, ignoreStrategy);
    }

    protected <V> L lt(JdbcClassMapping<?> classMapping, SerializableSupplier<V> property, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return lt(classMapping, property, property.get(), queryAlias, ignoreStrategy);
    }

    protected <T, V> L lt(JdbcClassMapping<?> classMapping, Serializable name, V value, String queryAlias,
            Predicate<?> ignoreStrategy) {
        return lt(classMapping.getPropertyMapping(getPropertyName(name)), value, queryAlias, ignoreStrategy);
    }

    protected <V> L lt(JdbcPropertyMapping pm, V value, String queryAlias, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), ComparisonOperator.LT, queryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    /**
     * Supplier.
     *
     * @param <R>   the generic type
     * @param info  the info
     * @param value the value
     * @return the list
     */
    protected <R> List<Tuple2<String, Optional<R>>> supplier(SerializedLambdaInfo info, R value) {
        return supplier(info, value, classMapping);
    }

    /**
     * Supplier.
     *
     * @param <R>  the generic type
     * @param info the info
     * @return the list
     */
    protected <R> List<Tuple2<String, Optional<R>>> supplier(SerializableSupplierLambdaInfo<R> info) {
        return supplier(info, classMapping);
    }

    // ********************************************************************
    // property
    // ********************************************************************

}
