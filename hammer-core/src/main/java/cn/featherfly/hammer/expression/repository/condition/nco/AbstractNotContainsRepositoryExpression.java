
package cn.featherfly.hammer.expression.repository.condition.nco;

import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.nco.MulitiNotContainsExpression;
import cn.featherfly.hammer.expression.repository.condition.AbstractRepositoryIndexableConditionExpression;
import cn.featherfly.hammer.expression.repository.condition.MatchStringRepositoryFieldExpression;

/**
 * abstract not contains repository expression.
 *
 * @author zhongj
 * @param <T> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractNotContainsRepositoryExpression<C extends ConditionExpression,
    L extends LogicExpression<C, L>>
    extends AbstractRepositoryIndexableConditionExpression<MulitiNotContainsExpression<C, L>>
    implements NotContainsRepositoryExpression {

    /** The field name. */
    protected String fieldName;

    /**
     * Instantiates a new abstract contains entity expression.
     *
     * @param index          the index
     * @param expression     the expression
     * @param ignoreStrategy the ignore strategy
     */
    protected AbstractNotContainsRepositoryExpression(int index, MulitiNotContainsExpression<C, L> expression,
        Predicate<Object> ignoreStrategy) {
        this(index, null, expression, ignoreStrategy);
    }

    /**
     * Instantiates a new abstract contains entity expression.
     *
     * @param index          the index
     * @param fieldName      the field name
     * @param expression     the expression
     * @param ignoreStrategy the ignore strategy
     */
    protected AbstractNotContainsRepositoryExpression(int index, String fieldName,
        MulitiNotContainsExpression<C, L> expression, Predicate<Object> ignoreStrategy) {
        super(index, expression, ignoreStrategy);
        this.fieldName = fieldName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        expression.nco(index, name, value, matchStrategy, ignoreStrategy);
    }

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
        expression.nco(index, fieldName, value, matchStrategy, getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        expression.nco(index, fieldName, value, matchStrategy, ignoreStrategy);
    }
}
