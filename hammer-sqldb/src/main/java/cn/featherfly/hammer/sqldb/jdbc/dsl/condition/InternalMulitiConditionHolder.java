
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-16 15:07:16
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.condition;

/**
 * InternalMulitiConditionHolder.
 *
 * @author zhongj
 * @param <I> the generic type
 * @param <L> the generic type
 */
public interface InternalMulitiConditionHolder<I extends InternalMulitiCondition<L>, L> {

    /**
     * Gets the hold internal muliti condition.
     *
     * @return the internal muliti condition
     */
    I getHold();
}
