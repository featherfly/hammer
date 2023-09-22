
/*
 * All rights Reserved, Designed By zhongj
 * @Title: StartWithEntityExpressionImpl.java
 * @Package cn.featherfly.hammer.expression.entity.swndition.sw
 * @Description: StartWithEntityExpressionImpl
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
import cn.featherfly.hammer.expression.entity.condition.sw.AbstractStartWithEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.sw.MulitiEntityStartWithExpression;
import cn.featherfly.hammer.expression.entity.condition.sw.StartWithEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.sw.StartWithEntityPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.sw.StartWithEntityPropertySetValueExpression;

/**
 * StartWithEntityExpressionImpl.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class StartWithEntityExpressionImpl<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractStartWithEntityExpression<E, C, L> implements StartWithEntityExpression<E> {

    private JdbcMappingFactory factory;

    /**
     * Instantiates a new start with entity expression impl.
     *
     * @param index          the index
     * @param expression     the expression
     * @param ignoreStrategy the ignore strategy
     * @param factory        the factory
     */
    public StartWithEntityExpressionImpl(int index, MulitiEntityStartWithExpression<C, L> expression,
            Predicate<?> ignoreStrategy, JdbcMappingFactory factory) {
        super(index, expression, ignoreStrategy);
        this.factory = factory;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> StartWithEntityPropertyExpression<R> property(SerializableFunction<E, R> name) {
        return new StartWithEntityPropertyExpressionImpl<>(index, name,
                (MulitiEntityStartWithExpressionImpl<C, L>) expression, factory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Collection<RE>,
            RE> StartWithEntityPropertyExpression<RE> property(SerializableToCollectionFunction<E, R, RE> name) {
        // IMPLSOON 未实现property
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StartWithEntityPropertySetValueExpression property(SerializableToStringFunction<E> name) {
        return new StartWithEntityPropertyExpressionImpl<>(index, name,
                (MulitiEntityStartWithExpressionImpl<C, L>) expression, factory);
    }
}
