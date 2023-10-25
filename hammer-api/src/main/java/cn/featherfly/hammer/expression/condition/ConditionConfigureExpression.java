package cn.featherfly.hammer.expression.condition;

import java.util.function.Consumer;

import cn.featherfly.hammer.config.dsl.ConditionConfig;

/**
 * The Interface ConditionConfigureExpression.
 *
 * @author zhongj
 * @param <C>  the condition expression type
 * @param <C2> the ConditionConfig type
 */
public interface ConditionConfigureExpression<C, C2 extends ConditionConfig<C2>> {

    /**
     * Configure.
     *
     * @param configure the configure
     * @return the c
     */
    C configure(Consumer<C2> configure);

    //    /**
    //     * Gets the ignore strategy.
    //     *
    //     * @return the ignore strategy
    //     */
    //    Predicate<?> getIgnoreStrategy();
    //
    //    /**
    //     * Sets the ignore strategy.
    //     *
    //     * @param ignoreStrategy the new ignore strategy
    //     * @return the ConditionGroupConfig
    //     */
    //    C setIgnoreStrategy(Predicate<?> ignoreStrategy);
}
