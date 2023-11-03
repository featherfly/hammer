package cn.featherfly.hammer.expression.repository.condition.nl;

import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.nl.MulitiNotLikeExpression;
import cn.featherfly.hammer.expression.repository.condition.AbstractRepositoryIndexableConditionExpression;
import cn.featherfly.hammer.expression.repository.condition.MatchStringRepositoryFieldExpression;

/**
 * The Class AbstractNotLikeRepositoryExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractNotLikeRepositoryExpression<C extends ConditionExpression,
    L extends LogicExpression<C, L>>
    extends AbstractRepositoryIndexableConditionExpression<MulitiNotLikeExpression<C, L>>
    implements NotLikeRepositoryExpression {

    /** The field name. */
    protected String fieldName;

    /**
     * Instantiates a new abstract not like repository expression.
     *
     * @param index          the index
     * @param expression     the expression
     * @param ignoreStrategy the ignore strategy
     */
    protected AbstractNotLikeRepositoryExpression(int index, MulitiNotLikeExpression<C, L> expression,
        Predicate<Object> ignoreStrategy) {
        this(index, null, expression, ignoreStrategy);
    }

    /**
     * Instantiates a new abstract not like repository expression.
     *
     * @param index          the index
     * @param fieldName      the field name
     * @param expression     the expression
     * @param ignoreStrategy the ignore strategy
     */
    protected AbstractNotLikeRepositoryExpression(int index, String fieldName, MulitiNotLikeExpression<C, L> expression,
        Predicate<Object> ignoreStrategy) {
        super(index, expression, ignoreStrategy);
        this.fieldName = fieldName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        expression.nl(index, name, value, matchStrategy, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public MatchStringRepositoryFieldExpression field(String name) {
        fieldName = name;
        return this;
        // 因为只能调用一次field，所以不用去创建新对象
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(String value, MatchStrategy matchStrategy) {
        expression.nl(index, fieldName, value, matchStrategy, getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        expression.nl(index, fieldName, value, matchStrategy, ignoreStrategy);
    }
}
