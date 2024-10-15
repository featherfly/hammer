
package cn.featherfly.hammer.expression.entity.condition.le;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple5;

import cn.featherfly.common.function.FiveArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityLessEqualsExpression5.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityLessEqualsExpression5<E, E2, E3, E4, E5, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityLessEqualsExpressionBase5<E, E2, E3, E4, E5, C, L> {

    /**
     * less and equals. 小于等于.
     *
     * @param lessEqualsEntityExpressions the less equals entity expressions
     * @return the LogicExpression
     */
    L le(Consumer<Tuple5<LessEqualsEntityExpression<E>, LessEqualsEntityExpression<E2>, LessEqualsEntityExpression<E3>,
            LessEqualsEntityExpression<E4>, LessEqualsEntityExpression<E5>>> lessEqualsEntityExpressions);

    /**
     * less and equals. 小于等于.
     *
     * @param lessEqualsEntityExpressions the less equals entity expressions
     * @return the LogicExpression
     */
    L le(FiveArgusConsumer<LessEqualsEntityExpression<E>, LessEqualsEntityExpression<E2>,
            LessEqualsEntityExpression<E3>, LessEqualsEntityExpression<E4>,
            LessEqualsEntityExpression<E5>> lessEqualsEntityExpressions);
}