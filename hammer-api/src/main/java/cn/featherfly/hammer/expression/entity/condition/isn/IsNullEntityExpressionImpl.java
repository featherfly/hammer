
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EqualsEntityExpressionImpl.java
 * @Package cn.featherfly.hammer.expression.entity.condition.eq
 * @Description: EqualsEntityExpressionImpl
 * @author: zhongj
 * @date: 2023-08-07 17:41:07
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition.isn;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.AbstractConditionEntityExpression;

/**
 * The Class EqualsEntityExpressionImpl.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class IsNullEntityExpressionImpl<E, C extends ConditionExpression, L extends LogicExpression<C, L>> extends
        AbstractConditionEntityExpression<MulitiEntityIsNullExpression<C, L>> implements IsNullEntityExpression<E> {

    /**
     * Instantiates a new checks if is null entity expression impl.
     *
     * @param index      the index
     * @param expression the expression
     */
    public IsNullEntityExpressionImpl(int index, MulitiEntityIsNullExpression<C, L> expression) {
        super(index, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> IsNullEntityPropertyExpression<E, R> property(SerializableFunction<E, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> void accept(SerializableFunction<E, R> property, Boolean value) {
        expression.isn(index, property, value);
    }

}
