
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.field;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryNumberFieldExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.condition.InternalMulitiCondition;

/**
 * number field expression implements.
 *
 * @author zhongj
 * @param <N> the number type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class NumberFieldExpressionMulitiRepositoryImpl<N extends Number, C extends ConditionExpression,
    L extends LogicExpression<C, L>> extends AbstractMulitiRepositoryFieldExpression<C, L>
    implements RepositoryNumberFieldExpression<N, C, L> {

    /**
     * Instantiates a new simple number property expression.
     *
     * @param index      the index
     * @param name       the name
     * @param expression the expression
     */
    public NumberFieldExpressionMulitiRepositoryImpl(AtomicInteger index, String name,
        InternalMulitiCondition<L> expression) {
        super(index, name, expression);
    }

    /**
     * Instantiates a new simple number property expression.
     *
     * @param index      the index
     * @param name       the name
     * @param expression the expression
     */
    public NumberFieldExpressionMulitiRepositoryImpl(int index, String name, InternalMulitiCondition<L> expression) {
        super(index, name, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(N value) {
        return expression.eq(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(N value, IgnoreStrategy ignoreStrategy) {
        return expression.eq(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(N value, Predicate<N> ignoreStrategy) {
        return expression.eq(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(N value) {
        return expression.ne(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(N value, IgnoreStrategy ignoreStrategy) {
        return expression.ne(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(N value, Predicate<N> ignoreStrategy) {
        return expression.ne(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(N value) {
        return expression.in(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(N value, Predicate<N> ignoreStrategy) {
        return expression.in(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(N[] value) {
        return expression.in(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(N[] value, Predicate<N[]> ignoreStrategy) {
        return expression.in(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(N value) {
        return expression.ni(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(N value, Predicate<N> ignoreStrategy) {
        return expression.ni(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(N[] value) {
        return expression.ni(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(N[] value, Predicate<N[]> ignoreStrategy) {
        return expression.ni(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(N value) {
        return expression.le(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(N value, IgnoreStrategy ignoreStrategy) {
        return expression.le(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(N value, Predicate<N> ignoreStrategy) {
        return expression.le(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(N value) {
        return expression.lt(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(N value, IgnoreStrategy ignoreStrategy) {
        return expression.lt(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(N value, Predicate<N> ignoreStrategy) {
        return expression.lt(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(N value) {
        return expression.ge(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(N value, IgnoreStrategy ignoreStrategy) {
        return expression.ge(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(N value, Predicate<N> ignoreStrategy) {
        return expression.ge(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(N value) {
        return expression.gt(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(N value, IgnoreStrategy ignoreStrategy) {
        return expression.gt(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(N value, Predicate<N> ignoreStrategy) {
        return expression.gt(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L isn() {
        return expression.isn(index, name, true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L inn() {
        return expression.inn(index, name, true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L isn(Boolean value) {
        return expression.isn(index, name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L inn(Boolean value) {
        return expression.inn(index, name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(N min, N max) {
        return expression.ba(index, name, min, max, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(N min, N max, IgnoreStrategy ignoreStrategy) {
        return expression.ba(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(N min, N max, BiPredicate<N, N> ignoreStrategy) {
        return expression.ba(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(N min, N max) {
        return expression.nba(index, name, min, max, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(N min, N max, IgnoreStrategy ignoreStrategy) {
        return expression.ba(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(N min, N max, BiPredicate<N, N> ignoreStrategy) {
        return expression.ba(index, name, min, max, ignoreStrategy);
    }
}
