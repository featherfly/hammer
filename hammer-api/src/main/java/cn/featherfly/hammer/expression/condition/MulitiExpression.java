
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-03-13 14:52:13
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition;

import java.util.List;

/**
 * MulitiExpression.
 *
 * @author zhongj
 */
public interface MulitiExpression {

    /**
     * Gets the expressions.
     *
     * @return the expressions
     */
    List<Expression> getExpressions();
}
