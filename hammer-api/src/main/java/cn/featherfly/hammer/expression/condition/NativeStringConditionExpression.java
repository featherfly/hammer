
/*
 * All rights Reserved, Designed By zhongj
 * @Title: StringConditionExpression.java
 * @Package cn.featherfly.hammer.expression.condition
 * @Description: StringConditionExpression
 * @author: zhongj
 * @date: 2022-08-10 18:35:10
 * @Copyright: 2022 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.repository.Params;

/**
 * native string condition expression.
 * such as: SQL, JSON and so on
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface NativeStringConditionExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends ConditionExpression {

    /**
     * expression short alias.
     *
     * @param expression the expression
     * @return LogicExpression
     */
    default L expr(String expression) {
        return expression(expression, ArrayUtils.EMPTY_SERIALIZABLE_ARRAY);
    }

    /**
     * Expression.
     *
     * @param expression the expression
     * @param params the params
     * @return LogicExpression
     */
    default L expr(String expression, Params params) {
        return expr(expression, (Map<String, Serializable>) params);
    }

    /**
     * expression short alias.
     *
     * @param expression the expression
     * @param params the params
     * @return LogicExpression
     */
    default L expr(String expression, Map<String, Serializable> params) {
        return expression(expression, params);
    }

    /**
     * expression short alias.
     *
     * @param expression the expression
     * @param params the params
     * @return LogicExpression
     */
    default L expr(String expression, Serializable... params) {
        return expression(expression, params);
    }

    /**
     * Expression.
     *
     * @param expression the expression
     * @return LogicExpression
     */
    default L expression(String expression) {
        return expression(expression, ArrayUtils.EMPTY_SERIALIZABLE_ARRAY);
    }

    /**
     * Expression.
     *
     * @param expression the expression
     * @param params the params
     * @return LogicExpression
     */
    default L expression(String expression, Params params) {
        return expression(expression, (Map<String, Serializable>) params);
    }

    /**
     * Expression.
     *
     * @param expression the expression
     * @param params the params
     * @return LogicExpression
     */
    L expression(String expression, Map<String, Serializable> params);

    /**
     * Expression.
     *
     * @param expression the expression
     * @param params the params
     * @return LogicExpression
     */
    L expression(String expression, Serializable... params);
}
