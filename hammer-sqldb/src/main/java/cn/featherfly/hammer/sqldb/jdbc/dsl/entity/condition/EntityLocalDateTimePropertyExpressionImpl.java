
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityLocalDateTimePropertyExpression;

/**
 * entity LocalDateTime property expression implements.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class EntityLocalDateTimePropertyExpressionImpl<E, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends
        AbstractMulitiEntityGenericPropertyExpression<E, LocalDateTime, SerializableFunction<E, LocalDateTime>, C, L>
        implements EntityLocalDateTimePropertyExpression<E, C, L> {

    /**
     * Instantiates a new entity local date time property expression impl.
     *
     * @param index        the index
     * @param propertyList the property list
     * @param expression   the expression
     * @param factory      the factory
     */
    public EntityLocalDateTimePropertyExpressionImpl(int index, List<Serializable> propertyList,
            AbstractMulitiEntityConditionExpression<C, L> expression, JdbcMappingFactory factory) {
        super(index, propertyList, expression, factory);
    }

    /**
     * Instantiates a new entity local date time property expression impl.
     *
     * @param index      the index
     * @param name       the name
     * @param expression the expression
     * @param factory    the factory
     */
    public EntityLocalDateTimePropertyExpressionImpl(int index, SerializableFunction<E, LocalDateTime> name,
            AbstractMulitiEntityConditionExpression<C, L> expression, JdbcMappingFactory factory) {
        super(index, name, expression, factory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(LocalDateTime value) {
        return expression.eq0(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return expression.eq0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return expression.eq0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

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
    public L ne(LocalDateTime value) {
        return expression.ne0(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return expression.ne0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return expression.ne0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(LocalDateTime value) {
        return expression.in0(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return expression.in0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return expression.in0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(LocalDateTime[] value) {
        return expression.in0(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(LocalDateTime[] value, IgnoreStrategy ignoreStrategy) {
        return expression.in0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(LocalDateTime[] value, Predicate<LocalDateTime[]> ignoreStrategy) {
        return expression.in0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(LocalDateTime value) {
        return expression.ni0(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return expression.ni0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return expression.ni0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(LocalDateTime[] value) {
        return expression.ni0(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(LocalDateTime[] value, IgnoreStrategy ignoreStrategy) {
        return expression.ni0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(LocalDateTime[] value, Predicate<LocalDateTime[]> ignoreStrategy) {
        return expression.ni0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(LocalDateTime value) {
        return expression.le0(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return expression.le0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return expression.le0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(LocalDateTime value) {
        return expression.lt0(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return expression.lt0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return expression.lt0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(LocalDateTime value) {
        return expression.ge0(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return expression.ge0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return expression.ge0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(LocalDateTime value) {
        return expression.gt0(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return expression.gt0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return expression.gt0(index, getPropertyMapping(value), value, ignoreStrategy);
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
    public L ba(LocalDateTime min, LocalDateTime max) {
        return expression.ba0(index, getPropertyMapping(Lang.pick(min, max)), min, max, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(LocalDateTime min, LocalDateTime max, IgnoreStrategy ignoreStrategy) {
        return expression.ba0(index, getPropertyMapping(Lang.pick(min, max)), min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(LocalDateTime min, LocalDateTime max, BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return expression.ba0(index, getPropertyMapping(Lang.pick(min, max)), min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(LocalDateTime min, LocalDateTime max) {
        return expression.nba0(index, getPropertyMapping(Lang.pick(min, max)), min, max,
                expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(LocalDateTime min, LocalDateTime max, IgnoreStrategy ignoreStrategy) {
        return expression.nba0(index, getPropertyMapping(Lang.pick(min, max)), min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(LocalDateTime min, LocalDateTime max, BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return expression.nba0(index, getPropertyMapping(Lang.pick(min, max)), min, max, ignoreStrategy);
    }
}
