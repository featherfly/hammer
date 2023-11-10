
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
 * The Interface OnJoinField.
 *
 * @author zhongj
 */
public interface OnSourceFieldAware {

    /**
     * Join field.
     *
     * @param name the name
     */
    void joinField(String name);

    /**
     * Join field.
     *
     * @param field the field
     */
    default void joinField(Field field) {
        AssertIllegalArgument.isNotNull(field, "field");
        joinField(field.name());
    }

    /**
     * Source field.
     *
     * @return the string
     */
    String sourceField();
}
