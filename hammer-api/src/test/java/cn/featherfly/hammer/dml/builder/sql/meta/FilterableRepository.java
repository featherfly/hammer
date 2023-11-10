
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-10 18:06:10
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dml.builder.sql.meta;

import cn.featherfly.common.repository.AliasRepository;
import cn.featherfly.hammer.expression.condition.ConditionExpression;

/**
 * FilterableRepository.
 *
 * @author zhongj
 */
public interface FilterableRepository extends AliasRepository, ConditionExpression {

}
