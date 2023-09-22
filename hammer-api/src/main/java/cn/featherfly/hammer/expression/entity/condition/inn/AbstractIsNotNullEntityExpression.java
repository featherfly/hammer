
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EqualsEntityExpressionImpl.java
 * @Package cn.featherfly.hammer.expression.entity.condition.eq
 * @Description: EqualsEntityExpressionImpl
 * @author: zhongj
 * @date: 2023-08-07 17:41:07
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition.inn;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.AbstractConditionEntityExpression;

/**
 * The Class AbstractIsNotNullEntityExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractIsNotNullEntityExpression<E, C extends ConditionExpression,
        L extends LogicExpression<C, L>>
        extends AbstractConditionEntityExpression<MulitiEntityIsNotNullExpression<C, L>>
        implements IsNotNullEntityExpression<E> {

    /**
     * Instantiates a new abstract is not null entity expression.
     *
     * @param index          the index
     * @param expression     the expression
     * @param ignoreStrategy the ignore strategy
     */
    protected AbstractIsNotNullEntityExpression(int index, MulitiEntityIsNotNullExpression<C, L> expression,
            Predicate<?> ignoreStrategy) {
        super(index, expression, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> void accept(SerializableFunction<E, R> property, Boolean value) {
        expression.isn(index, property, value);
    }

}
