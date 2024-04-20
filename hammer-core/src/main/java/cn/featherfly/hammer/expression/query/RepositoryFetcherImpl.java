
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-04-20 12:25:20
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.query;

import cn.featherfly.common.repository.AliasRepository;
import cn.featherfly.common.repository.SimpleAliasRepository;

/**
 * RepositoryFetcherImpl.
 *
 * @author zhongj
 */
public class RepositoryFetcherImpl implements RepositoryFetcher {

    /**
     * {@inheritDoc}
     */
    @Override
    public NamedRepository name(String name) {
        return new NamedRepository() {

            @Override
            public AliasRepository alias(String alias) {
                return new SimpleAliasRepository(name, alias);
            }

            @Override
            public String name() {
                return name;
            }
        };
    }
}
