
package cn.featherfly.hammer.expression.entity.condition.in;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple6;

import cn.featherfly.common.function.SixArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityInExpression5.
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
public interface EntityInExpression6<E, E2, E3, E4, E5, E6, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityInExpressionBase6<E, E2, E3, E4, E5, E6, C, L> {

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param inEntityExpressions the in entity expressions
     * @return the LogicExpression
     */
    L in(Consumer<Tuple6<InEntityExpression<E>, InEntityExpression<E2>, InEntityExpression<E3>, InEntityExpression<E4>,
            InEntityExpression<E5>, InEntityExpression<E6>>> inEntityExpressions);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param inEntityExpressions the in entity expressions
     * @return the LogicExpression
     */
    L in(SixArgusConsumer<InEntityExpression<E>, InEntityExpression<E2>, InEntityExpression<E3>, InEntityExpression<E4>,
            InEntityExpression<E5>, InEntityExpression<E6>> inEntityExpressions);
}