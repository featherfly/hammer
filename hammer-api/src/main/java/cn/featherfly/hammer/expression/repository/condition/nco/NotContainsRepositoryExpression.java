
/*
 * All rights Reserved, Designed By zhongj
 * @Title: Entities.java
 * @Package cn.featherfly.hammer.expression.entity.condition.eq
 * @Description: Entities
 * @author: zhongj
 * @date: 2023-07-18 14:44:18
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.repository.condition.nco;

import cn.featherfly.hammer.expression.repository.condition.MatchStringRepositoryExpression;

/**
 * not contains repository expression.
 *
 * @author zhongj
 */
public interface NotContainsRepositoryExpression
    extends MatchStringRepositoryExpression, NotContainsRepositoryFieldExpression {

}
