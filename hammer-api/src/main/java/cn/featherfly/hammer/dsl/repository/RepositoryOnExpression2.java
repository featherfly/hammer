/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-17 18:27:17
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dsl.repository;

import cn.featherfly.common.function.ThreeArgusFunction;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;

/**
 * repository on expression2.
 *
 * @author zhongj
 * @param <O> on result type
 */
public interface RepositoryOnExpression2<O> extends RepositoryOnExpression<O> {
    /**
     * on.
     *
     * @param expression the expression. <br>
     *                   <ol>
     *                   <li>filterable repository field expresion
     *                   <li>filterable or joined repository field expresion
     *                   <li>current join repository field expression
     *                   <li>return logic expression
     *                   </ol>
     * @return the RepositoryQueryRelateExpression
     */
    O on(ThreeArgusFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
        LogicExpression<?, ?>> expression);
}
