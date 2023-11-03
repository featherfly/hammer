
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-10 16:02:10
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dml.builder.sql.meta;

import cn.featherfly.common.repository.Alias;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.field.StringFieldExpression;

/**
 * FilterableStringAliasField.
 *
 * @author zhongj
 */
public interface FilterableStringAliasField<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends StringFieldExpression<C, L>, StringField, Alias {

}
