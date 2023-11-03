
/*
 * All rights Reserved, Designed By zhongj
 * @Title: MulitiEntityConditionExpression.java
 * @Package cn.featherfly.hammer.expression.entity.condition
 * @Description: MulitiEntityConditionExpression
 * @author: zhongj
 * @date: 2023-07-28 19:18:28
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition;

import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.hammer.expression.condition.MulitiRepositoryExpression;

/**
 * muliti entity condition expression.
 *
 * @author zhongj
 */
public interface MulitiEntityConditionExpression extends MulitiRepositoryExpression {

    /**
     * Gets the class mapping.
     *
     * @param <M>   the generic type
     * @param <T>   the generic type
     * @param <P>   the generic type
     * @param index the index
     * @return the class mapping
     */
    <M extends ClassMapping<T, P>, T, P extends PropertyMapping<P>> M getClassMapping(int index);
}
