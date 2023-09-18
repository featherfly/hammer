
package cn.featherfly.hammer.expression.condition.property;

import java.util.function.Predicate;

import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionsExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * simple enum property expression.
 *
 * @author zhongj
 */
public class SimpleEnumPropertyExpression<E extends Enum<E>, C extends ConditionsExpression<C, L>,
        L extends LogicExpression<C, L>> implements EnumPropertyExpression<E, C, L> {

    private String name;

    private ConditionsExpression<C, L> expression;

    /**
     * @param name       name
     * @param expression expression
     */
    public SimpleEnumPropertyExpression(String name, ConditionsExpression<C, L> expression) {
        super();
        this.name = name;
        this.expression = expression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(E value) {
        return expression.eq(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(E value, IgnoreStrategy ignoreStrategy) {
        return expression.eq(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(E value, Predicate<E> ignoreStrategy) {
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
    public L ne(E value) {
        return expression.ne(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(E value, IgnoreStrategy ignoreStrategy) {
        return expression.ne(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(E value, Predicate<E> ignoreStrategy) {
        return expression.ne(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(E value) {
        return expression.in(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(E value, IgnoreStrategy ignoreStrategy) {
        return expression.in(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L in(E value, Predicate<E> ignoreStrategy) {
        return expression.in(name, value, (v) -> ignoreStrategy.test((E) v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(E[] value) {
        return expression.in(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(E[] value, IgnoreStrategy ignoreStrategy) {
        return expression.in(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L in(E[] value, Predicate<E[]> ignoreStrategy) {
        return expression.in(name, value, (v) -> ignoreStrategy.test((E[]) v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(E value) {
        return expression.ni(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(E value, IgnoreStrategy ignoreStrategy) {
        return expression.ni(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ni(E value, Predicate<E> ignoreStrategy) {
        return expression.ni(name, value, (v) -> ignoreStrategy.test((E) v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(E[] value) {
        return expression.ni(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(E[] value, IgnoreStrategy ignoreStrategy) {
        return expression.ni(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ni(E[] value, Predicate<E[]> ignoreStrategy) {
        return expression.ni(name, value, (v) -> ignoreStrategy.test((E[]) v));
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

}
