
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
 * The Interface OnFields.
 *
 * @author zhongj
 */
public interface OnFieldBuilder {

    /**
     * Join field.
     *
     * @param name the name
     * @return the on source field
     */
    OnJoinFieldAware joinField(String name);

    /**
     * Join field.
     *
     * @param field the field
     * @return the on source field
     */
    default OnJoinFieldAware joinField(Field field) {
        AssertIllegalArgument.isNotNull(field, "field");
        return joinField(field.name());
    }

    /**
     * Source field.
     *
     * @param name the name
     * @return the on join field
     */
    OnSourceFieldAware sourceField(String name);

    /**
     * Source field.
     *
     * @param field the field
     * @return the on join field
     */
    default OnSourceFieldAware sourceField(Field field) {
        AssertIllegalArgument.isNotNull(field, "field");
        return sourceField(field.name());
    }
}
