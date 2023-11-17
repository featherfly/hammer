
/*
 * All rights Reserved, Designed By zhongj
 * @Title: ConpareEntityExpression.java
 * @Package cn.featherfly.hammer.expression.entity.condition
 * @Description: ConpareEntityExpression
 * @author: zhongj
 * @date: 2023-07-19 18:01:19
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.repository.condition;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.hammer.expression.condition.field.MatchStringFieldExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetStringFuzzyQueryExpression;

/**
 * The Interface MatchStringRepositoryFieldExpression.
 *
 * @author zhongj
 */
public interface MatchStringRepositoryFieldExpression
        extends MatchStringFieldExpression<MatchStringRepositoryFieldExpression>, SetStringFuzzyQueryExpression {

    /**
     * match string repository field expression.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name the name
     * @return match string repository field expression
     */
    default <T, R> MatchStringRepositoryFieldExpression field(SerializableFunction<T, R> name) {
        return field(LambdaUtils.getLambdaPropertyName(name));
    }
}
