
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-21 13:07:21
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.query;

import cn.featherfly.common.repository.AliasRepository;
import cn.featherfly.common.repository.Aliasable;
import cn.featherfly.common.repository.Repository;

/**
 * NamedRepository.
 *
 * @author zhongj
 */
public interface NamedRepository extends Repository, Aliasable<AliasRepository> {

}
