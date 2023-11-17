
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-17 20:47:17
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.query;

/**
 * The Interface FetchField.
 *
 * @author zhongj
 */
public interface FetchField {

    /**
     * Name.
     *
     * @param name the name
     * @return the fetch field
     */
    FetchField name(String name);

    /**
     * Alias.
     *
     * @param alias the alias
     * @return the fetch field
     */
    FetchField alias(String alias);

    FetchField distinct(boolean distinct);
}
