
/*
 * All rights Reserved, Designed By zhongj
 * @Title: ConpareEntityExpression.java
 * @Package cn.featherfly.hammer.expression.entity.condition
 * @Description: ConpareEntityExpression
 * @author: zhongj
 * @date: 2023-07-19 18:01:19
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition.field;

import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;
import cn.featherfly.hammer.expression.condition.field.value.SetStringFuzzyQueryExpression;

/**
 * The Interface MatchStringFieldExpression.
 *
 * @author zhongj
 */
public interface MatchStringFieldExpression<M extends SetStringFuzzyQueryExpression> {

    /**
     * match string field property expression.
     *
     * @param name the field name
     * @return match string field expression
     */
    M field(String name);

    /**
     * match string field property expression.
     *
     * @param field the field
     * @return match string field expression
     */
    default M field(Field field) {
        return field(field.name());
    }

    /**
     * match string field property expression.
     *
     * @param field the field
     * @return match string field expression
     */
    default M field(AliasField field) {
        return field(field.getAliasOrName());
    }
}
