
package cn.featherfly.hammer.expression.condition.property;

import java.time.LocalDateTime;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionsExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * simple local date time property expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class SimpleLocalDateTimePropertyExpression<C extends ConditionsExpression<C, L>,
        L extends LogicExpression<C, L>> implements LocalDateTimePropertyExpression<C, L> {

    private String name;

    private ConditionsExpression<C, L> expression;

    /**
     * Instantiates a new simple local date time property expression.
     *
     * @param name       name
     * @param expression expression
     */
    public SimpleLocalDateTimePropertyExpression(String name, ConditionsExpression<C, L> expression) {
        super();
        this.name = name;
        this.expression = expression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(LocalDateTime value) {
        return expression.eq(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return expression.eq(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return expression.eq(name, value, ignoreStrategy);
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
        return expression.ne(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return expression.ne(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return expression.ne(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(LocalDateTime value) {
        return expression.in(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return expression.in(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return expression.in(name, value, v -> ignoreStrategy.test((LocalDateTime) v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(LocalDateTime[] value) {
        return expression.in(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(LocalDateTime[] value, IgnoreStrategy ignoreStrategy) {
        return expression.in(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(LocalDateTime[] value, Predicate<LocalDateTime[]> ignoreStrategy) {
        return expression.ni(name, value, v -> ignoreStrategy.test((LocalDateTime[]) v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(LocalDateTime value) {
        return expression.ni(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return expression.ni(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return expression.ni(name, value, v -> ignoreStrategy.test((LocalDateTime) v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(LocalDateTime[] value) {
        return expression.ni(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(LocalDateTime[] value, IgnoreStrategy ignoreStrategy) {
        return expression.ni(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(LocalDateTime[] value, Predicate<LocalDateTime[]> ignoreStrategy) {
        return expression.ni(name, value, v -> ignoreStrategy.test((LocalDateTime[]) v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(LocalDateTime value) {
        return expression.le(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return expression.le(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return expression.le(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(LocalDateTime value) {
        return expression.lt(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return expression.lt(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return expression.lt(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(LocalDateTime value) {
        return expression.ge(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return expression.ge(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return expression.ge(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(LocalDateTime value) {
        return expression.gt(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return expression.gt(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return expression.gt(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L isn() {
        return expression.isn(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L inn() {
        return expression.inn(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L isn(Boolean value) {
        return expression.isn(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L inn(Boolean value) {
        return expression.inn(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(LocalDateTime min, LocalDateTime max) {
        return expression.ba(name, min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(LocalDateTime min, LocalDateTime max, IgnoreStrategy ignoreStrategy) {
        return expression.ba(name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(LocalDateTime min, LocalDateTime max, BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return expression.ba(name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(LocalDateTime min, LocalDateTime max) {
        return expression.nba(name, min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(LocalDateTime min, LocalDateTime max, IgnoreStrategy ignoreStrategy) {
        return expression.nba(name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(LocalDateTime min, LocalDateTime max, BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return expression.nba(name, min, max, ignoreStrategy);
    }

}