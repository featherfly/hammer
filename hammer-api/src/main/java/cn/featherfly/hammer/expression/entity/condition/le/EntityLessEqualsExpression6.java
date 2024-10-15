
package cn.featherfly.hammer.expression.entity.condition.le;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple6;

import cn.featherfly.common.function.SixArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityLessEqualsExpression6.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <E6> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityLessEqualsExpression6<E, E2, E3, E4, E5, E6, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityLessEqualsExpressionBase6<E, E2, E3, E4, E5, E6, C, L> {

    /**
     * less and equals. 小于等于.
     *
     * @param lessEqualsEntityExpressions the less equals entity expressions
     * @return the LogicExpression
     */
    L le(Consumer<Tuple6<LessEqualsEntityExpression<E>, LessEqualsEntityExpression<E2>, LessEqualsEntityExpression<E3>,
            LessEqualsEntityExpression<E4>, LessEqualsEntityExpression<E5>,
            LessEqualsEntityExpression<E6>>> lessEqualsEntityExpressions);

    /**
     * less and equals. 小于等于.
     *
     * @param lessEqualsEntityExpressions the less equals entity expressions
     * @return the LogicExpression
     */
    L le(SixArgusConsumer<LessEqualsEntityExpression<E>, LessEqualsEntityExpression<E2>, LessEqualsEntityExpression<E3>,
            LessEqualsEntityExpression<E4>, LessEqualsEntityExpression<E5>,
            LessEqualsEntityExpression<E6>> lessEqualsEntityExpressions);
}