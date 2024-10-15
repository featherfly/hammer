
package cn.featherfly.hammer.expression.entity.condition.lk;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple6;

import cn.featherfly.common.function.SixArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityLikeExpression6.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <E6> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityLikeExpression6<E, E2, E3, E4, E5, E6, C extends ConditionExpression,
    L extends LogicExpression<C, L>> extends EntityLikeExpressionBase6<E, E2, E3, E4, E5, E6, C, L> {

    /**
     * like value.
     *
     * @param likeEntityExpressions the like entity expressions
     * @return the LogicExpression
     */
    L lk(Consumer<Tuple6<LikeEntityExpression<E>, LikeEntityExpression<E2>, LikeEntityExpression<E3>,
        LikeEntityExpression<E4>, LikeEntityExpression<E5>, LikeEntityExpression<E6>>> likeEntityExpressions);

    /**
     * like value.
     *
     * @param likeEntityExpressions the like entity expressions
     * @return the LogicExpression
     */
    L lk(SixArgusConsumer<LikeEntityExpression<E>, LikeEntityExpression<E2>, LikeEntityExpression<E3>,
        LikeEntityExpression<E4>, LikeEntityExpression<E5>, LikeEntityExpression<E6>> likeEntityExpressions);

}