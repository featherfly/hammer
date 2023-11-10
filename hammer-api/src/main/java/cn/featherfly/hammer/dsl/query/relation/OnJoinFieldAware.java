
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-01-10 17:43:10
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dsl.query.relation;

import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.repository.Field;

/**
 * The Interface OnJoinFieldAware.
 *
 * @author zhongj
 */
public interface OnJoinFieldAware {

    /**
     * Source field.
     *
     * @param name the name
     * @return the on consumer
     */
    void sourceField(String name);

    /**
     * Source field.
     *
     * @param field the field
     * @return the on consumer
     */
    default void sourceField(Field field) {
        AssertIllegalArgument.isNotNull(field, "field");
        sourceField(field.name());
    }

    /**
     * Join field.
     *
     * @return the string
     */
    String joinField();
}
