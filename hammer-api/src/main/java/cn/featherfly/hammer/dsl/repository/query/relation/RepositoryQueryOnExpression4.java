/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-17 18:27:17
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dsl.repository.query.relation;

import cn.featherfly.common.function.FiveArgusFunction;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;

/**
 * repository query related expression4.
 *
 * @author zhongj
 * @param <Q> the generic type
 * @param <F> the generic type
 */
public interface RepositoryQueryOnExpression4<Q extends RepositoryQueryRelateExpression<F>, F>
        extends RepositoryQueryOnExpression<Q, F> {

    /**
     * on.
     *
     * @param expression the expression.<br/>
     *                   <ol>
     *                   <li>query repository field expresion
     *                   <li>query or joined repository field expresion
     *                   <li>query or joined repository field expresion
     *                   <li>query or joined repository field expresion
     *                   <li>current join repository field expression
     *                   <li>return logic expression
     *                   </ol>
     * @return the RepositoryQueryRelateExpression
     */
    Q on(FiveArgusFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, LogicExpression<?, ?>> expression);
}
