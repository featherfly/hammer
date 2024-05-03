
/*
 * All rights Reserved, Designed By zhongj
 * @Title: StartWithEntityExpressionImpl.java
 * @Package cn.featherfly.hammer.expression.entity.swndition.sw
 * @Description: StartWithEntityExpressionImpl
 * @author: zhongj
 * @date: 2023-07-28 16:46:28
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.entity.condition.nsw;

import java.util.Collection;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.exception.NotImplementedException;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableToCollectionFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.nsw.MulitiNotStartWithExpression;
import cn.featherfly.hammer.expression.entity.condition.nsw.AbstractNotStartWithEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.nsw.NotStartWithEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.nsw.NotStartWithEntityPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.nsw.NotStartWithEntityPropertySetValueExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlRelation;

/**
 * NotStartWithEntityExpressionImpl.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class NotStartWithEntityExpressionImpl<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractNotStartWithEntityExpression<E, C, L> implements NotStartWithEntityExpression<E> {

    /** The factory. */
    private JdbcMappingFactory factory;

    /** The query relation. */
    private EntitySqlRelation<?,?> queryRelation;

    /**
     * Instantiates a new start with entity expression impl.
     *
     * @param index         the index
     * @param expression    the expression
     * @param factory       the factory
     * @param queryRelation the query relation
     */
    public NotStartWithEntityExpressionImpl(int index, MulitiNotStartWithExpression<C, L> expression,
            JdbcMappingFactory factory, EntitySqlRelation<?,?> queryRelation) {
        super(index, expression, queryRelation.getIgnoreStrategy());
        this.factory = factory;
        this.queryRelation = queryRelation;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> NotStartWithEntityPropertyExpression<R> property(SerializableFunction<E, R> name) {
        return new NotStartWithEntityPropertyExpressionImpl<>(index, name,
                ((MulitiEntityNotStartWithExpressionImpl<C, L>) expression).getHold(), factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Collection<RE>,
            RE> NotStartWithEntityPropertyExpression<RE> property(SerializableToCollectionFunction<E, R, RE> name) {
        // IMPLSOON 后续来实现集合类型property
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NotStartWithEntityPropertySetValueExpression property(SerializableToStringFunction<E> name) {
        return new NotStartWithEntityPropertyExpressionImpl<>(index, name,
                ((MulitiEntityNotStartWithExpressionImpl<C, L>) expression).getHold(), factory, queryRelation);
    }
}
