
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.exception.NotImplementedException;
import cn.featherfly.common.function.serializable.SerializableFunction;
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
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
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

/**
 * entity Type property expression implements.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <P> the element type
 * @param <F> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class EntityTypePropertyExpressionImpl<E, P, F extends SerializableFunction<E, P>, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends AbstractMulitiEntityGenericPropertyExpression<E, P, F, C, L>
        implements EntityTypePropertyExpression<P, C, L> {

    /**
     * Instantiates a new entity property type expression impl.
     *
     * @param index      the index
     * @param name       the name
     * @param expression the expression
     * @param factory    the factory
     */
    public EntityTypePropertyExpressionImpl(int index, F name, AbstractMulitiEntityConditionExpression<C, L> expression,
            JdbcMappingFactory factory) {
        super(index, name, expression, factory);
    }

    /**
     * Instantiates a new entity property type expression impl.
     *
     * @param index        the index
     * @param propertyList the property list
     * @param expression   the expression
     * @param factory      the factory
     */
    public EntityTypePropertyExpressionImpl(int index, List<Serializable> propertyList,
            AbstractMulitiEntityConditionExpression<C, L> expression, JdbcMappingFactory factory) {
        super(index, propertyList, expression, factory);
    }

    // ****************************************************************************************************************
    //	property
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityIntPropertyExpression<P, C, L> property(SerializableToIntFunction<P> name) {
        propertyList.add(name);
        return new EntityIntPropertyExpressionImpl<>(index, propertyList, expression, factory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLongPropertyExpression<P, C, L> property(SerializableToLongFunction<P> name) {
        propertyList.add(name);
        return new EntityLongPropertyExpressionImpl<>(index, propertyList, expression, factory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityDoublePropertyExpression<P, C, L> property(SerializableToDoubleFunction<P> name) {
        propertyList.add(name);
        return new EntityDoublePropertyExpressionImpl<>(index, propertyList, expression, factory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <PT extends Number> EntityNumberPropertyExpression<P, PT, C, L> property(
            SerializableToNumberFunction<P, PT> name) {
        propertyList.add(name);
        return new EntityNumberPropertyExpressionImpl<>(index, propertyList, expression, factory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> EntityDatePropertyExpression<P, R, C, L> property(SerializableToDateFunction<P, R> name) {
        propertyList.add(name);
        return new EntityDatePropertyExpressionImpl<>(index, propertyList, expression, factory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityStringPropertyExpression<P, C, L> property(SerializableToStringFunction<P> name) {
        propertyList.add(name);
        return new EntityStringPropertyExpressionImpl<>(index, propertyList, expression, factory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLocalDatePropertyExpression<P, C, L> property(SerializableToLocalDateFunction<P> name) {
        propertyList.add(name);
        return new EntityLocalDatePropertyExpressionImpl<>(index, propertyList, expression, factory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLocalDateTimePropertyExpression<P, C, L> property(SerializableToLocalDateTimeFunction<P> name) {
        propertyList.add(name);
        return new EntityLocalDateTimePropertyExpressionImpl<>(index, propertyList, expression, factory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLocalTimePropertyExpression<P, C, L> property(SerializableToLocalTimeFunction<P> name) {
        propertyList.add(name);
        return new EntityLocalTimePropertyExpressionImpl<>(index, propertyList, expression, factory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Enum<R>> EntityEnumPropertyExpression<P, R, C, L> property(
            SerializableToEnumFunction<P, R> name) {
        propertyList.add(name);
        return new EntityEnumPropertyExpressionImpl<>(index, propertyList, expression, factory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityTypePropertyExpression<R, C, L> property(SerializableFunction<P, R> name) {
        propertyList.add(name);
        return new EntityTypePropertyExpressionImpl<>(index, propertyList, expression, factory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Collection<RE>,
            RE> EntityTypePropertyExpression<RE, C, L> property(SerializableToCollectionFunction<P, R, RE> name) {
        // IMPLSOON 后续来实现集合类型property
        throw new NotImplementedException();
    }

    // ****************************************************************************************************************
    //  condition
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {
        return expression.expression();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(P value, MatchStrategy matchStrategy) {
        return expression.eq0(index, getPropertyMapping(value), value, matchStrategy, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(P value, MatchStrategy matchStrategy) {
        return expression.ne0(index, getPropertyMapping(value), value, matchStrategy, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(P value) {
        return expression.in0(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(P value, Predicate<P> ignoreStrategy) {
        return expression.in0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(P value, IgnoreStrategy ignoreStrategy) {
        return expression.in0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(P[] value) {
        return expression.in0(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(P[] value, IgnoreStrategy ignoreStrategy) {
        return expression.in0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(P[] value, Predicate<P[]> ignoreStrategy) {
        return expression.in0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(P value) {
        return expression.ni0(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(P value, IgnoreStrategy ignoreStrategy) {
        return expression.ni0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(P value, Predicate<P> ignoreStrategy) {
        return expression.ni0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(P[] value) {
        return expression.ni0(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(P[] value, IgnoreStrategy ignoreStrategy) {
        return expression.ni0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(P[] value, Predicate<P[]> ignoreStrategy) {
        return expression.ni0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public L le(P value) {
        return expression.le0(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(P value, IgnoreStrategy ignoreStrategy) {
        return expression.le0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(P value, Predicate<P> ignoreStrategy) {
        return expression.le0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public L lt(P value) {
        return expression.lt0(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(P value, IgnoreStrategy ignoreStrategy) {
        return expression.lt0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(P value, Predicate<P> ignoreStrategy) {
        return expression.lt0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public L ge(P value) {
        return expression.ge0(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(P value, IgnoreStrategy ignoreStrategy) {
        return expression.ge0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(P value, Predicate<P> ignoreStrategy) {
        return expression.ge0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public L gt(P value) {
        return expression.gt0(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(P value, IgnoreStrategy ignoreStrategy) {
        return expression.gt0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(P value, Predicate<P> ignoreStrategy) {
        return expression.gt0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(String value, MatchStrategy matchStrategy) {
        return expression.sw0(index, getPropertyMapping(value), value, matchStrategy, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return expression.sw0(index, getPropertyMapping(value), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return expression.sw0(index, getPropertyMapping(value), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String value, MatchStrategy matchStrategy) {
        return expression.co0(index, getPropertyMapping(value), value, matchStrategy, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return expression.co0(index, getPropertyMapping(value), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return expression.co0(index, getPropertyMapping(value), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String value, MatchStrategy matchStrategy) {
        return expression.ew0(index, getPropertyMapping(value), value, matchStrategy, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return expression.ew0(index, getPropertyMapping(value), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return expression.ew0(index, getPropertyMapping(value), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(String value, MatchStrategy matchStrategy) {
        return expression.lk0(index, getPropertyMapping(value), value, matchStrategy, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return expression.lk0(index, getPropertyMapping(value), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return expression.lk0(index, getPropertyMapping(value), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L isn(Boolean value) {
        return expression.isn0(index, getPropertyMapping(value), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L inn(Boolean value) {
        return expression.inn0(index, getPropertyMapping(value), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(P value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return expression.eq0(index, getPropertyMapping(value), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(P value, MatchStrategy matchStrategy, Predicate<P> ignoreStrategy) {
        return expression.eq0(index, getPropertyMapping(value), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(P value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return expression.ne0(index, getPropertyMapping(value), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(P value, MatchStrategy matchStrategy, Predicate<P> ignoreStrategy) {
        return expression.ne0(index, getPropertyMapping(value), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(P min, P max) {
        return expression.ba0(index, getPropertyMapping(Lang.pick(min, max)), min, max, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(P min, P max, IgnoreStrategy ignoreStrategy) {
        return expression.ba0(index, getPropertyMapping(Lang.pick(min, max)), min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(P min, P max, BiPredicate<P, P> ignoreStrategy) {
        return expression.ba0(index, getPropertyMapping(Lang.pick(min, max)), min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(P min, P max) {
        return expression.nba0(index, getPropertyMapping(Lang.pick(min, max)), min, max,
                expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(P min, P max, IgnoreStrategy ignoreStrategy) {
        return expression.nba0(index, getPropertyMapping(Lang.pick(min, max)), min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(P min, P max, BiPredicate<P, P> ignoreStrategy) {
        return expression.nba0(index, getPropertyMapping(Lang.pick(min, max)), min, max, ignoreStrategy);
    }

}
