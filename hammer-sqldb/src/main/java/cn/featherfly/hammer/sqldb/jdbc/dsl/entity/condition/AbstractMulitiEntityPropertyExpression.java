
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Class AbstractMulitiEntityPropertyExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <P> the element type
 * @param <F> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractMulitiEntityPropertyExpression<E, P, F extends SerializableFunction<E, P>,
        C extends ConditionExpression, L extends LogicExpression<C, L>> {

    /** The index. */
    protected int index;

    /** The name. */
    protected F name;

    /** The expression. */
    protected AbstractMulitiEntityConditionExpression<C, L> expression;

    /**
     * Instantiates a new entity property type expression impl.
     *
     * @param index          the index
     * @param name           the name
     * @param ignoreStrategy the ignore strategy
     * @param expression     the expression
     */
    protected AbstractMulitiEntityPropertyExpression(int index, F name,
            AbstractMulitiEntityConditionExpression<C, L> expression) {
        super();
        this.index = index;
        this.name = name;
        this.expression = expression;
    }
}
