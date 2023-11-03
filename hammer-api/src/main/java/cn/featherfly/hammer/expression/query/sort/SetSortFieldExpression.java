
/*
 * All rights Reserved, Designed By zhongj
 * @Title: Entities.java
 * @Package cn.featherfly.hammer.expression.entity.condition.eq
 * @Description: Entities
 * @author: zhongj
 * @date: 2023-07-18 14:44:18
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.query.sort;

import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;

/**
 * The Interface SetSortFieldExpression.
 *
 * @author zhongj
 */
@FunctionalInterface
public interface SetSortFieldExpression {

    /**
     * set sort(asc or desc) field.
     *
     * @param field the field
     * @return the sets the sort field expression
     */
    SetSortFieldExpression field(String field);

    /**
     * set sort(asc or desc) field.
     *
     * @param fields the fields
     * @return this
     */
    default SetSortFieldExpression field(String... fields) {
        SetSortFieldExpression exp = null;
        for (String field : fields) {
            if (exp == null) {
                exp = field(field);
            } else {
                exp = exp.field(field);
            }
        }
        return Lang.pick(exp, this);
    }

    /**
     * set sort(asc or desc) field.
     *
     * @param fields the fields
     * @return this
     */
    default SetSortFieldExpression field(Field... fields) {
        SetSortFieldExpression exp = null;
        for (Field field : fields) {
            String name = null;
            if (field instanceof AliasField) {
                name = ((AliasField) field).getAliasOrName();
            } else {
                name = field.name();
            }

            if (exp == null) {
                exp = field(name);
            } else {
                exp = exp.field(name);
            }
        }
        return Lang.pick(exp, this);
    }
}
