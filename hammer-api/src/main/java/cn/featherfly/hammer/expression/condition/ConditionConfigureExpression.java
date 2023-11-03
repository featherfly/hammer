package cn.featherfly.hammer.expression.condition;

import java.util.function.Consumer;

import cn.featherfly.hammer.config.dsl.ConditionConfig;

/**
 * condition configure expression.
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
     * @return the condition expression
     */
    C configure(Consumer<C2> configure);
}
