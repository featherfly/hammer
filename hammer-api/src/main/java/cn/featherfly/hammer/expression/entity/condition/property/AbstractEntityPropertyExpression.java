
package cn.featherfly.hammer.expression.entity.condition.property;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.EntityConditionsExpression;

/**
 * abstract entity property expression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <R> the generic type
 * @param <F> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractEntityPropertyExpression<E, R, F extends SerializableFunction<E, R>,
        C extends EntityConditionsExpression<E, C, L>, L extends LogicExpression<C, L>> {

    /** The name. */
    protected F name;

    /** The expression. */
    protected EntityConditionsExpression<E, C, L> expression;

    /**
     * Instantiates a new repository simple date expression.
     *
     * @param name       property name
     * @param expression expression
     */
    protected AbstractEntityPropertyExpression(F name, EntityConditionsExpression<E, C, L> expression) {
        super();
        this.name = name;
        this.expression = expression;
    }
}
