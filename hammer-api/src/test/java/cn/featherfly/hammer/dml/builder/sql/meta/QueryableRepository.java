
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-10 18:06:10
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dml.builder.sql.meta;

import cn.featherfly.common.repository.AliasRepository;
import cn.featherfly.common.repository.Aliasable;
import cn.featherfly.common.repository.Repository;

/**
 * FilterableRepository.
 *
 * @author zhongj
 */
public interface QueryableRepository extends Repository, Aliasable<AliasRepository> {

}
