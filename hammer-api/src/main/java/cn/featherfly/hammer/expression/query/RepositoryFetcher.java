
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-17 20:47:17
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.query;

/**
 * repository builder.
 *
 * @author zhongj
 */
public interface RepositoryFetcher {

    /**
     * Name.
     *
     * @param name the name
     * @return the fetch field
     */
    NamedRepository name(String name);
}
