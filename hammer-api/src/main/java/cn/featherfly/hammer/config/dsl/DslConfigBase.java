
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-10-23 15:52:23
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.config.dsl;

/**
 * The Interface DslConfigBase.
 *
 * @author zhongj
 * @param <C>  the generic type
 * @param <C2> the generic ConditionConfig type
 */
public interface DslConfigBase<C extends DslConfigBase<C, C2>, C2 extends ConditionConfig<C2>>
        extends ConditionConfig<C2> {

    /**
     * Clone.
     *
     * @return the c
     */
    C clone();
}
