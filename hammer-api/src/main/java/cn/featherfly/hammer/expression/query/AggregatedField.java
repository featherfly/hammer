
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-21 13:07:21
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.query;

import cn.featherfly.common.repository.Aliasable;
import cn.featherfly.common.repository.Distinctive;

/**
 * AggregatedField.
 *
 * @author zhongj
 */
public interface AggregatedField
        extends AggregateFunctionField, Aliasable<AggregatedAliasedField>, Distinctive<AggregateDistinctNameAware> {

}
