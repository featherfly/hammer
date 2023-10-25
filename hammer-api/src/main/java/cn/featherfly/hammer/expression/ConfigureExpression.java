package cn.featherfly.hammer.expression;

import java.util.function.Consumer;

import cn.featherfly.hammer.config.dsl.ConditionConfig;
import cn.featherfly.hammer.config.dsl.DslConfigBase;

/**
 * The Interface ConfigureExpression.
 *
 * @author zhongj
 * @param <C>  the condition expression type
 * @param <C1> the DslConfigBase type
 * @param <C2> the ConditionConfig type
 */
public interface ConfigureExpression<C, C1 extends DslConfigBase<C1, C2>, C2 extends ConditionConfig<C2>> {

    /**
     * Configure.
     *
     * @param configure the configure
     * @return the expression
     */
    C configure(Consumer<C1> configure);
}
