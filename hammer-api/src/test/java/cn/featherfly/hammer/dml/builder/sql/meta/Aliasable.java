
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-10 18:01:10
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dml.builder.sql.meta;

/**
 * Aliasable.
 *
 * @author zhongj
 * @param <A> the generic type
 */
public interface Aliasable<A> {

    /**
     * Alias.
     *
     * @param alias the alias
     * @return the a
     */
    A alias(String alias);

}
