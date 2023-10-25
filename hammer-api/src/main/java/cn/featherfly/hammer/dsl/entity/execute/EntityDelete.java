
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityDelete.java
 * @Package cn.featherfly.hammer.dsl.execute
 * @Description: EntityDelete
 * @author: zhongj
 * @date: 2022-11-28 15:41:28
 * @Copyright: 2022 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dsl.entity.execute;

import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.expression.entity.execute.EntityDeleteExpression;

/**
 * EntityDelete.
 *
 * @author zhongj
 */
public interface EntityDelete<E>
        extends EntityDeleteExpression<E, EntityExecutableConditionGroup<E, DeleteConditionConfig>,
                EntityExecutableConditionGroupLogic<E, DeleteConditionConfig>> {

}
