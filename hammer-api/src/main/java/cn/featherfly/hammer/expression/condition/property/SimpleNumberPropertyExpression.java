
package cn.featherfly.hammer.expression.condition.property;

import java.util.function.Predicate;

import cn.featherfly.hammer.expression.condition.ConditionsExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * simple number property expression.
 *
 * @author zhongj
 * @param <N> the number type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class SimpleNumberPropertyExpression<N extends Number, C extends ConditionsExpression<C, L>,
        L extends LogicExpression<C, L>> implements NumberPropertyExpression<N, C, L> {

    private String name;

    private ConditionsExpression<C, L> expression;

    /**
     * Instantiates a new simple number expression.
     *
     * @param name       name
     * @param expression expression
     */
    public SimpleNumberPropertyExpression(String name, ConditionsExpression<C, L> expression) {
        super();
        this.name = name;
        this.expression = expression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(N value) {
        return expression.eq(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(N value, Predicate<N> ignoreStrategy) {
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
    public L ne(N value) {
        return expression.ne(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(N value, Predicate<N> ignoreStrategy) {
        return expression.ne(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(N value) {
        return expression.in(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(N[] value) {
        return expression.in(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L in(N value, Predicate<N> ignoreStrategy) {
        return expression.in(name, value, (v) -> ignoreStrategy.test((N) v));
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L in(N[] value, Predicate<N[]> ignoreStrategy) {
        return expression.in(name, value, (v) -> ignoreStrategy.test((N[]) v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(N value) {
        return expression.nin(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(N[] value) {
        return expression.nin(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nin(N value, Predicate<N> ignoreStrategy) {
        return expression.nin(name, value, (v) -> ignoreStrategy.test((N) v));
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nin(N[] value, Predicate<N[]> ignoreStrategy) {
        return expression.nin(name, value, (v) -> ignoreStrategy.test((N[]) v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(N value) {
        return expression.le(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(N value) {
        return expression.lt(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(N value) {
        return expression.ge(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(N value) {
        return expression.gt(name, value);
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
