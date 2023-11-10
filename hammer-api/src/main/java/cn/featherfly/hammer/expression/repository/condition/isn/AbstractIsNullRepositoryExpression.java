
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EqualsEntityExpressionImpl.java
 * @Package cn.featherfly.hammer.expression.entity.condition.eq
 * @Description: EqualsEntityExpressionImpl
 * @author: zhongj
 * @date: 2023-08-07 17:41:07
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.repository.condition.isn;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.hammer.expression.condition.AbstractConditionExpression;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.isn.MulitiIsNullExpression;

/**
 * The Class AbstractIsNullRepositoryExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractIsNullRepositoryExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractConditionExpression<MulitiIsNullExpression<C, L>> implements IsNullRepositoryExpression {

    /**
     * Instantiates a new abstract is null entity expression.
     *
     * @param index          the index
     * @param expression     the expression
     * @param ignoreStrategy the ignore strategy
     */
    protected AbstractIsNullRepositoryExpression(int index, MulitiIsNullExpression<C, L> expression,
            Predicate<?> ignoreStrategy) {
        super(index, expression, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(String name, Boolean value) {
        expression.isn(index, name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, R> void accept(SerializableFunction<E, R> property, Boolean value) {
        expression.isn(index, property, value);
    }

}
