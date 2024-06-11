
package cn.featherfly.hammer.expression.entity.condition.lk;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple5;

import cn.featherfly.common.function.FiveArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityLikeExpression5.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityLikeExpression5<E, E2, E3, E4, E5, C extends ConditionExpression,
    L extends LogicExpression<C, L>> extends EntityLikeExpressionBase5<E, E2, E3, E4, E5, C, L> {

    /**
     * like value.
     *
     * @param likeEntityExpressions the like entity expressions
     * @return the LogicExpression
     */
    L lk(Consumer<Tuple5<LikeEntityExpression<E>, LikeEntityExpression<E2>, LikeEntityExpression<E3>,
        LikeEntityExpression<E4>, LikeEntityExpression<E5>>> likeEntityExpressions);

    /**
     * like value.
     *
     * @param likeEntityExpressions the like entity expressions
     * @return the LogicExpression
     */
    L lk(FiveArgusConsumer<LikeEntityExpression<E>, LikeEntityExpression<E2>, LikeEntityExpression<E3>,
        LikeEntityExpression<E4>, LikeEntityExpression<E5>> likeEntityExpressions);

}