
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EndWithEntityExpressionImpl.java
 * @Package cn.featherfly.hammer.expression.entity.ewndition.ew
 * @Description: EndWithEntityExpressionImpl
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
import cn.featherfly.hammer.expression.entity.condition.ew.AbstractEndWithEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.ew.EndWithEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.ew.EndWithEntityPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ew.EndWithEntityPropertySetValueExpression;
import cn.featherfly.hammer.expression.entity.condition.ew.MulitiEntityEndWithExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlRelation;

/**
 * The Class EndWithEntityExpressionImpl.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class EndWithEntityExpressionImpl<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractEndWithEntityExpression<E, C, L> implements EndWithEntityExpression<E> {

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
    public EndWithEntityExpressionImpl(int index, MulitiEntityEndWithExpression<C, L> expression,
            JdbcMappingFactory factory, EntitySqlRelation<?, ?> queryRelation) {
        super(index, expression, queryRelation.getIgnorePolicy());
        this.factory = factory;
        this.queryRelation = queryRelation;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EndWithEntityPropertyExpression<R> property(SerializableFunction<E, R> name) {
        return new EndWithEntityPropertyExpressionImpl<>(index, name,
                (MulitiEntityEndWithExpressionImpl<C, L>) expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Collection<RE>,
            RE> EndWithEntityPropertyExpression<RE> property(SerializableToCollectionFunction<E, R, RE> name) {
        // IMPLSOON 后续来实现集合类型property
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EndWithEntityPropertySetValueExpression property(SerializableToStringFunction<E> name) {
        return new EndWithEntityPropertyExpressionImpl<>(index, name,
                (MulitiEntityEndWithExpressionImpl<C, L>) expression, factory, queryRelation);
    }

}
