
package cn.featherfly.hammer.expression.entity.compatible.condition.co;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.StringContainsExpression;
import cn.featherfly.hammer.expression.entity.condition.co.EntityContainsExpression;

/**
 * The Interface EntityContainsCompatibleExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityContainsCompatibleExpression<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityContainsExpression<E, C, L>, StringContainsExpression<C, L> {

    //    /**
    //     * contains value. 包含value.
    //     *
    //     * @param name  参数名称
    //     * @param value 参数值
    //     * @return LogicExpression
    //     */
    //    @Override
    //    default L co(String name, String value) {
    //        return co(name, value, MatchStrategy.AUTO);
    //    }
    //
    //    /**
    //     * contains value. 包含value.
    //     *
    //     * @param name           参数名称
    //     * @param value          参数值
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    @Override
    //    default L co(String name, String value, Predicate<String> ignoreStrategy) {
    //        return co(name, value, MatchStrategy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * contains value. 包含value.
    //     *
    //     * @param name        the name
    //     * @param value       the value
    //     * @param queryPolicy the query policy
    //     * @return the l
    //     */
    //    @Override
    //    L co(String name, String value, MatchStrategy matchStrategy);
    //
    //    /**
    //     * contains value. 包含value.
    //     *
    //     * @param name           the name
    //     * @param value          the value
    //     * @param queryPolicy    the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return the l
    //     */
    //    @Override
    //    L co(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
}