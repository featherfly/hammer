/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityGreatEqualsExpression6.java
 * @Package cn.featherfly.hammer.expression.entity.condition.ge
 * @Description: todo (用一句话描述该文件做什么)
 * @author: zhongj
 * @date: 2023年7月20日 下午5:54:27
 * @version V1.0
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */

package cn.featherfly.hammer.expression.entity.condition.nba;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple6;

import cn.featherfly.common.function.SixArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityNotBetweenExpression6.
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
public interface EntityNotBetweenExpression6<E, E2, E3, E4, E5, E6, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityNotBetweenExpressionBase6<E, E2, E3, E4, E5, E6, C, L> {

    /**
     * not between and.
     *
     * @param notBetweenEntityExpressions the not between entity expressions
     * @return the LogicExpression
     */
    L nba(Consumer<Tuple6<NotBetweenEntityExpression<E>, NotBetweenEntityExpression<E2>, NotBetweenEntityExpression<E3>,
            NotBetweenEntityExpression<E4>, NotBetweenEntityExpression<E5>,
            NotBetweenEntityExpression<E6>>> notBetweenEntityExpressions);

    /**
     * not between and.
     *
     * @param notBetweenEntityExpressions the not between entity expressions
     * @return the LogicExpression
     */
    L nba(SixArgusConsumer<NotBetweenEntityExpression<E>, NotBetweenEntityExpression<E2>,
            NotBetweenEntityExpression<E3>, NotBetweenEntityExpression<E4>, NotBetweenEntityExpression<E5>,
            NotBetweenEntityExpression<E6>> notBetweenEntityExpressions);
}