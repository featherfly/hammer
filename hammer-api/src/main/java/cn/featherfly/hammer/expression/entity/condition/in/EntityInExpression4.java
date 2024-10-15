
package cn.featherfly.hammer.expression.entity.condition.in;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple4;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityInExpression4.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityInExpression4<E, E2, E3, E4, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityInExpressionBase4<E, E2, E3, E4, C, L> {

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param inEntityExpressions the in entity expressions
     * @return the LogicExpression
     */
    L in(Consumer<Tuple4<InEntityExpression<E>, InEntityExpression<E2>, InEntityExpression<E3>, InEntityExpression<E4>>> inEntityExpressions);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param inEntityExpressions the in entity expressions
     * @return the LogicExpression
     */
    L in(FourArgusConsumer<InEntityExpression<E>, InEntityExpression<E2>, InEntityExpression<E3>, InEntityExpression<E4>> inEntityExpressions);
}