
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-10 16:02:10
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dml.builder.sql.meta;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.field.StringFieldExpression;

/**
 * StringField.
 *
 * @author zhongj
 */
public interface FilterableStringField<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends StringFieldExpression<C, L>, StringField {
    //        , Aliasable<FilterableStringAliasField<C, L>> {

    //    @Override
    //    void eq(String value);
    //
    //    @Override
    //    void ne(String value);
    //
    //    @Override
    //    void lk(String value);
    //
    //    @Override
    //    void nl(String value);
    //
    //    @Override
    //    void sw(String value);
    //
    //    @Override
    //    void nsw(String value);
    //
    //    @Override
    //    void ew(String value);
    //
    //    @Override
    //    void newv(String value);
    //
    //    @Override
    //    void co(String value);
    //
    //    @Override
    //    void nco(String value);
    //
    //    @Override
    //    void in(String... values);
    //
    //    @Override
    //    void ni(String... values);
}
