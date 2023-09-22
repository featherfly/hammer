
/*
 * All rights Reserved, Designed By zhongj
 * @Title: ContainsEntityExpressionImpl.java
 * @Package cn.featherfly.hammer.expression.entity.condition.co
 * @Description: ContainsEntityExpressionImpl
 * @author: zhongj
 * @date: 2023-07-28 16:46:28
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition;

import java.util.Collection;
import java.util.function.Predicate;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.exception.NotImplementedException;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableToCollectionFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.nco.AbstractNotContainsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.nco.MulitiEntityNotContainsExpression;
import cn.featherfly.hammer.expression.entity.condition.nco.NotContainsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.nco.NotContainsEntityPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.nco.NotContainsEntityPropertySetValueExpression;

/**
 * NotContainsEntityExpressionImpl.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class NotContainsEntityExpressionImpl<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractNotContainsEntityExpression<E, C, L> implements NotContainsEntityExpression<E> {

    private JdbcMappingFactory factory;

    /**
     * Instantiates a new contains entity expression impl.
     *
     * @param index          the index
     * @param expression     the expression
     * @param ignoreStrategy the ignore strategy
     * @param factory        the factory
     */
    public NotContainsEntityExpressionImpl(int index, MulitiEntityNotContainsExpression<C, L> expression,
            Predicate<?> ignoreStrategy, JdbcMappingFactory factory) {
        super(index, expression, ignoreStrategy);
        this.factory = factory;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> NotContainsEntityPropertyExpression<R> property(SerializableFunction<E, R> name) {
        return new NotContainsEntityPropertyExpressionImpl<>(index, name,
                (MulitiEntityNotContainsExpressionImpl<C, L>) expression, factory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Collection<RE>,
            RE> NotContainsEntityPropertyExpression<RE> property(SerializableToCollectionFunction<E, R, RE> name) {
        // IMPLSOON 未实现property
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NotContainsEntityPropertySetValueExpression property(SerializableToStringFunction<E> name) {
        return new NotContainsEntityPropertyExpressionImpl<>(index, name,
                (MulitiEntityNotContainsExpressionImpl<C, L>) expression, factory);
    }
}
