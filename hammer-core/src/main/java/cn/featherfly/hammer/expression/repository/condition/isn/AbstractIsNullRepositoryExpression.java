
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-17 15:50:17
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.repository.condition.isn;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetValueIsNullOrIsNotNullExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetValueIsNullOrIsNotNullExpressionImpl;
import cn.featherfly.hammer.expression.condition.isn.MulitiIsNullExpression;
import cn.featherfly.hammer.expression.repository.condition.AbstractRepositoryIndexableConditionExpression;

/**
 * abstract is null repository expression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractIsNullRepositoryExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends AbstractRepositoryIndexableConditionExpression<MulitiIsNullExpression<C, L>>
    implements IsNullRepositoryExpression {

    /**
     * Instantiates a new abstract is null entity expression.
     *
     * @param index          the index
     * @param expression     the expression
     * @param ignoreStrategy the ignore strategy
     */
    protected AbstractIsNullRepositoryExpression(int index, MulitiIsNullExpression<C, L> expression,
        Predicate<Object> ignoreStrategy) {
        super(index, expression, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetValueIsNullOrIsNotNullExpression field(String name) {
        return new SetValueIsNullOrIsNotNullExpressionImpl(v -> expression.isn(index, name, v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> SetValueIsNullOrIsNotNullExpression field(SerializableFunction<T, R> name) {
        return new SetValueIsNullOrIsNotNullExpressionImpl(v -> expression.isn(index, name, v));
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
