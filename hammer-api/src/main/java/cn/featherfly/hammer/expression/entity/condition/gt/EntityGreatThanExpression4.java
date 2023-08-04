
package cn.featherfly.hammer.expression.entity.condition.gt;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple4;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityGreatThanExpression4.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityGreatThanExpression4<E, E2, E3, E4, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityGreatThanExpressionBase4<E, E2, E3, E4, C, L> {

    /**
     * great than. 大于.
     *
     * @param greatThanEntityExpressions the great than entity expressions
     * @return the LogicExpression
     */
    L gt(Consumer<Tuple4<GreatThanEntityExpression<E>, GreatThanEntityExpression<E2>, GreatThanEntityExpression<E3>,
            GreatThanEntityExpression<E4>>> greatThanEntityExpressions);

    /**
     * great than. 大于.
     *
     * @param greatThanEntityExpressions the great than entity expressions
     * @return the LogicExpression
     */
    L gt(FourArgusConsumer<GreatThanEntityExpression<E>, GreatThanEntityExpression<E2>, GreatThanEntityExpression<E3>,
            GreatThanEntityExpression<E4>> greatThanEntityExpressions);
}