
/*
 * All rights Reserved, Designed By zhongj
 * @Title: LikeEntityExpressionImpl.java
 * @Package cn.featherfly.hammer.expression.entity.condition.lk
 * @Description: LikeEntityExpressionImpl
 * @author: zhongj
 * @date: 2023-08-07 17:34:07
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.nl;

import java.util.Collection;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.exception.NotImplementedException;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableToCollectionFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.nl.MulitiNotLikeExpression;
import cn.featherfly.hammer.expression.entity.condition.nl.AbstractNotLikeEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.nl.NotLikeEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.nl.NotLikeEntityPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.nl.NotLikeEntityPropertySetValueExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlRelation;

/**
 * The Class NotLikeEntityExpressionImpl.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class NotLikeEntityExpressionImpl<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractNotLikeEntityExpression<E, C, L> implements NotLikeEntityExpression<E> {

    private JdbcMappingFactory factory;

    private EntitySqlRelation<?, ?> queryRelation;

    /**
     * Instantiates a new end with entity expression impl.
     *
     * @param index         the index
     * @param expression    the expression
     * @param factory       the factory
     * @param queryRelation the query relation
     */
    public NotLikeEntityExpressionImpl(int index, MulitiNotLikeExpression<C, L> expression, JdbcMappingFactory factory,
            EntitySqlRelation<?, ?> queryRelation) {
        super(index, expression, queryRelation.getIgnoreStrategy());
        this.factory = factory;
        this.queryRelation = queryRelation;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> NotLikeEntityPropertyExpression<R> property(SerializableFunction<E, R> name) {
        return new NotLikeEntityPropertyExpressionImpl<>(index, name,
                ((MulitiEntityNotLikeExpressionImpl<C, L>) expression).getHold(), factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Collection<RE>,
            RE> NotLikeEntityPropertyExpression<RE> property(SerializableToCollectionFunction<E, R, RE> name) {
        // IMPLSOON 后续来实现集合类型property
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NotLikeEntityPropertySetValueExpression property(SerializableToStringFunction<E> name) {
        return new NotLikeEntityPropertyExpressionImpl<>(index, name,
                ((MulitiEntityNotLikeExpressionImpl<C, L>) expression).getHold(), factory, queryRelation);
    }
}
