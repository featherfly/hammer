
package cn.featherfly.hammer.expression.condition.property;

import java.util.Date;
import java.util.function.Predicate;

import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionsExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * simple date property expression.
 *
 * @author zhongj
 */
public class SimpleDatePropertyExpression<D extends Date, C extends ConditionsExpression<C, L>,
        L extends LogicExpression<C, L>> implements DatePropertyExpression<D, C, L> {

    private String name;

    private ConditionsExpression<C, L> expression;

    /**
     * @param name       name
     * @param expression expression
     */
    public SimpleDatePropertyExpression(String name, ConditionsExpression<C, L> expression) {
        super();
        this.name = name;
        this.expression = expression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(D value) {
        return expression.eq(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(D value, IgnoreStrategy ignoreStrategy) {
        return expression.eq(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(D value, Predicate<D> ignoreStrategy) {
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
    public L ne(Date value) {
        return expression.ne(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(D value, IgnoreStrategy ignoreStrategy) {
        return expression.ne(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(D value, Predicate<D> ignoreStrategy) {
        return expression.ne(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Date value) {
        return expression.in(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(D value, IgnoreStrategy ignoreStrategy) {
        return expression.in(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L in(D value, Predicate<D> ignoreStrategy) {
        return expression.in(name, value, (v) -> ignoreStrategy.test((D) v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(D[] value) {
        return expression.in(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(D[] value, IgnoreStrategy ignoreStrategy) {
        return expression.in(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L in(D[] value, Predicate<D[]> ignoreStrategy) {
        return expression.ni(name, value, (v) -> ignoreStrategy.test((D[]) v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(Date value) {
        return expression.ni(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(D value, IgnoreStrategy ignoreStrategy) {
        return expression.ni(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ni(D value, Predicate<D> ignoreStrategy) {
        return expression.ni(name, value, (v) -> ignoreStrategy.test((D) v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(D[] value) {
        return expression.ni(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(D[] value, IgnoreStrategy ignoreStrategy) {
        return expression.ni(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ni(D[] value, Predicate<D[]> ignoreStrategy) {
        return expression.ni(name, value, (v) -> ignoreStrategy.test((D[]) v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(Date value) {
        return expression.le(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(D value, IgnoreStrategy ignoreStrategy) {
        return expression.le(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(D value, Predicate<D> ignoreStrategy) {
        return expression.le(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(Date value) {
        return expression.lt(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(D value, IgnoreStrategy ignoreStrategy) {
        return expression.lt(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(D value, Predicate<D> ignoreStrategy) {
        return expression.lt(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(Date value) {
        return expression.ge(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(D value, IgnoreStrategy ignoreStrategy) {
        return expression.ge(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(D value, Predicate<D> ignoreStrategy) {
        return expression.ge(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(Date value) {
        return expression.gt(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(D value, IgnoreStrategy ignoreStrategy) {
        return expression.gt(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(D value, Predicate<D> ignoreStrategy) {
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

}
