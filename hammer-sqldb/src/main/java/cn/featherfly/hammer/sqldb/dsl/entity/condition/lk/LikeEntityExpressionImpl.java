
/*
 * All rights Reserved, Designed By zhongj
 * @Title: LikeEntityExpressionImpl.java
 * @Package cn.featherfly.hammer.expression.entity.condition.lk
 * @Description: LikeEntityExpressionImpl
 * @author: zhongj
 * @date: 2023-08-07 17:34:07
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.entity.condition.lk;

import java.util.Collection;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.exception.NotImplementedException;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableToCollectionFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.lk.MulitiLikeExpression;
import cn.featherfly.hammer.expression.entity.condition.lk.AbstractLikeEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.lk.LikeEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.lk.LikeEntityPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.lk.LikeEntityPropertySetValueExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlRelation;

/**
 * The Class LikeEntityExpressionImpl.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class LikeEntityExpressionImpl<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractLikeEntityExpression<E, C, L> implements LikeEntityExpression<E> {

    private JdbcMappingFactory factory;

    private EntitySqlRelation<?,?> queryRelation;

    /**
     * Instantiates a new end with entity expression impl.
     *
     * @param index         the index
     * @param expression    the expression
     * @param factory       the factory
     * @param queryRelation the query relation
     */
    public LikeEntityExpressionImpl(int index, MulitiLikeExpression<C, L> expression, JdbcMappingFactory factory,
            EntitySqlRelation<?,?> queryRelation) {
        super(index, expression, queryRelation.getIgnoreStrategy());
        this.factory = factory;
        this.queryRelation = queryRelation;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> LikeEntityPropertyExpression<R> property(SerializableFunction<E, R> name) {
        return new LikeEntityPropertyExpressionImpl<>(index, name,
                ((MulitiEntityLikeExpressionImpl<C, L>) expression).getHold(), factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Collection<RE>,
            RE> LikeEntityPropertyExpression<RE> property(SerializableToCollectionFunction<E, R, RE> name) {
        // IMPLSOON 后续来实现集合类型property
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LikeEntityPropertySetValueExpression property(SerializableToStringFunction<E> name) {
        return new LikeEntityPropertyExpressionImpl<>(index, name,
                ((MulitiEntityLikeExpressionImpl<C, L>) expression).getHold(), factory, queryRelation);
    }

}
