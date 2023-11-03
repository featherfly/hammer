
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EndWithEntityExpressionImpl.java
 * @Package cn.featherfly.hammer.expression.entity.ewndition.ew
 * @Description: EndWithEntityExpressionImpl
 * @author: zhongj
 * @date: 2023-07-28 16:46:28
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.newv;

import java.util.Collection;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.exception.NotImplementedException;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableToCollectionFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.newv.MulitiNotEndWithExpression;
import cn.featherfly.hammer.expression.entity.condition.newv.AbstractNotEndWithEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.newv.NotEndWithEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.newv.NotEndWithEntityPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.newv.NotEndWithEntityPropertySetValueExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlRelation;

/**
 * The Class NotEndWithEntityExpressionImpl.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class NotEndWithEntityExpressionImpl<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractNotEndWithEntityExpression<E, C, L> implements NotEndWithEntityExpression<E> {

    /** The factory. */
    private JdbcMappingFactory factory;

    /** The query relation. */
    private EntitySqlRelation<?, ?> queryRelation;

    /**
     * Instantiates a new end with entity expression impl.
     *
     * @param index         the index
     * @param expression    the expression
     * @param factory       the factory
     * @param queryRelation the query relation
     */
    public NotEndWithEntityExpressionImpl(int index, MulitiNotEndWithExpression<C, L> expression,
            JdbcMappingFactory factory, EntitySqlRelation<?, ?> queryRelation) {
        super(index, expression, queryRelation.getIgnoreStrategy());
        this.factory = factory;
        this.queryRelation = queryRelation;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> NotEndWithEntityPropertyExpression<R> property(SerializableFunction<E, R> name) {
        return new NotEndWithEntityPropertyExpressionImpl<>(index, name,
                ((MulitiEntityNotEndWithExpressionImpl<C, L>) expression).getHold(), factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Collection<RE>,
            RE> NotEndWithEntityPropertyExpression<RE> property(SerializableToCollectionFunction<E, R, RE> name) {
        // IMPLSOON 后续来实现集合类型property
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NotEndWithEntityPropertySetValueExpression property(SerializableToStringFunction<E> name) {
        return new NotEndWithEntityPropertyExpressionImpl<>(index, name,
                ((MulitiEntityNotEndWithExpressionImpl<C, L>) expression).getHold(), factory, queryRelation);
    }
}
