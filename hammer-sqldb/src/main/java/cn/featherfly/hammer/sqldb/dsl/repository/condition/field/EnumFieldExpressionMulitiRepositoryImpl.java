
package cn.featherfly.hammer.sqldb.dsl.repository.condition.field;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryEnumFieldExpression;
import cn.featherfly.hammer.sqldb.dsl.condition.InternalMulitiCondition;

/**
 * enum field expression implements.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class EnumFieldExpressionMulitiRepositoryImpl<E extends Enum<E>, C extends ConditionExpression,
    L extends LogicExpression<C, L>> extends AbstractMulitiRepositoryFieldExpression<C, L>
    implements RepositoryEnumFieldExpression<E, C, L> {

    /**
     * Instantiates a new simple enum property expression.
     *
     * @param index      the index
     * @param name       the name
     * @param expression the expression
     */
    public EnumFieldExpressionMulitiRepositoryImpl(int index, String name, InternalMulitiCondition<L> expression) {
        super(new AtomicInteger(index), name, expression);
    }

    /**
     * Instantiates a new simple enum property expression.
     *
     * @param index      the index
     * @param name       the name
     * @param expression the expression
     */
    public EnumFieldExpressionMulitiRepositoryImpl(AtomicInteger index, String name,
        InternalMulitiCondition<L> expression) {
        super(index, name, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(E value) {
        return expression.eq(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(E value, IgnoreStrategy ignoreStrategy) {
        return expression.eq(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(E value, Predicate<E> ignoreStrategy) {
        return expression.eq(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(E value) {
        return expression.ne(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(E value, IgnoreStrategy ignoreStrategy) {
        return expression.ne(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(E value, Predicate<E> ignoreStrategy) {
        return expression.ne(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(E value) {
        return expression.in(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(E value, Predicate<E> ignoreStrategy) {
        return expression.in(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(E[] value) {
        return expression.in(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(E[] value, Predicate<E[]> ignoreStrategy) {
        return expression.in(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(E value) {
        return expression.ni(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(E value, Predicate<E> ignoreStrategy) {
        return expression.ni(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(E[] value) {
        return expression.ni(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(E[] value, Predicate<E[]> ignoreStrategy) {
        return expression.ni(index, name, value, ignoreStrategy);
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

}
