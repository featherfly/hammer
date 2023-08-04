
package cn.featherfly.hammer.expression.entity.condition.le;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple4;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityLessEqualsExpression4.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityLessEqualsExpression4<E, E2, E3, E4, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityLessEqualsExpressionBase4<E, E2, E3, E4, C, L> {

    /**
     * less and equals. 小于等于.
     *
     * @param lessEqualsEntityExpressions the less equals entity expressions
     * @return the LogicExpression
     */
    L le(Consumer<Tuple4<LessEqualsEntityExpression<E>, LessEqualsEntityExpression<E2>, LessEqualsEntityExpression<E3>,
            LessEqualsEntityExpression<E4>>> lessEqualsEntityExpressions);

    /**
     * less and equals. 小于等于.
     *
     * @param lessEqualsEntityExpressions the less equals entity expressions
     * @return the LogicExpression
     */
    L le(FourArgusConsumer<LessEqualsEntityExpression<E>, LessEqualsEntityExpression<E2>,
            LessEqualsEntityExpression<E3>, LessEqualsEntityExpression<E4>> lessEqualsEntityExpressions);
}