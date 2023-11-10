package cn.featherfly.hammer.expression.repository.condition.ew;

import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.ew.MulitiEndWithExpression;
import cn.featherfly.hammer.expression.repository.condition.AbstractRepositoryIndexableConditionExpression;
import cn.featherfly.hammer.expression.repository.condition.MatchStringRepositoryFieldExpression;

/**
 * The Class AbstractEndWithRepositoryExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractEndWithRepositoryExpression<C extends ConditionExpression,
    L extends LogicExpression<C, L>>
    extends AbstractRepositoryIndexableConditionExpression<MulitiEndWithExpression<C, L>>
    implements EndWithRepositoryExpression {

    /** The field name. */
    protected String fieldName;

    /**
     * Instantiates a new abstract end with repository expression.
     *
     * @param index          the index
     * @param expression     the expression
     * @param ignoreStrategy the ignore strategy
     */
    protected AbstractEndWithRepositoryExpression(int index, MulitiEndWithExpression<C, L> expression,
        Predicate<Object> ignoreStrategy) {
        this(index, null, expression, ignoreStrategy);
    }

    /**
     * Instantiates a new abstract end with repository expression.
     *
     * @param index          the index
     * @param fieldName      the field name
     * @param expression     the expression
     * @param ignoreStrategy the ignore strategy
     */
    protected AbstractEndWithRepositoryExpression(int index, String fieldName, MulitiEndWithExpression<C, L> expression,
        Predicate<Object> ignoreStrategy) {
        super(index, expression, ignoreStrategy);
        this.fieldName = fieldName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        expression.ew(index, name, value, matchStrategy, ignoreStrategy);
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
        expression.ew(index, fieldName, value, matchStrategy, getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        expression.ew(index, fieldName, value, matchStrategy, ignoreStrategy);
    }
}
