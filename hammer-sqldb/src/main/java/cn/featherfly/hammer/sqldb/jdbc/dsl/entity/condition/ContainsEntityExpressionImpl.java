
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

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.exception.NotImplementedException;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableToCollectionFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.co.AbstractContainsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.co.ContainsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.co.ContainsEntityPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.co.ContainsEntityPropertySetValueExpression;
import cn.featherfly.hammer.expression.entity.condition.co.MulitiEntityContainsExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlRelation;

/**
 * ContainsEntityExpressionImpl.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class ContainsEntityExpressionImpl<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractContainsEntityExpression<E, C, L> implements ContainsEntityExpression<E> {

    private JdbcMappingFactory factory;

    private EntitySqlRelation<?, ?> queryRelation;

    /**
     * Instantiates a new contains entity expression impl.
     *
     * @param index         the index
     * @param expression    the expression
     * @param factory       the factory
     * @param queryRelation the query relation
     */
    public ContainsEntityExpressionImpl(int index, MulitiEntityContainsExpression<C, L> expression,
            JdbcMappingFactory factory, EntitySqlRelation<?, ?> queryRelation) {
        super(index, expression, queryRelation.getIgnorePolicy());
        this.factory = factory;
        this.queryRelation = queryRelation;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> ContainsEntityPropertyExpression<R> property(SerializableFunction<E, R> name) {
        return new ContainsEntityPropertyExpressionImpl<>(index, name,
                (MulitiEntityContainsExpressionImpl<C, L>) expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Collection<RE>,
            RE> ContainsEntityPropertyExpression<RE> property(SerializableToCollectionFunction<E, R, RE> name) {
        // IMPLSOON 后续来实现集合类型property
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ContainsEntityPropertySetValueExpression property(SerializableToStringFunction<E> name) {
        return new ContainsEntityPropertyExpressionImpl<>(index, name,
                (MulitiEntityContainsExpressionImpl<C, L>) expression, factory, queryRelation);
    }
}
