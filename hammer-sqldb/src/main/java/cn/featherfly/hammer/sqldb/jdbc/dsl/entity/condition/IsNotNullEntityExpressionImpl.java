
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EqualsEntityExpressionImpl.java
 * @Package cn.featherfly.hammer.expression.entity.condition.eq
 * @Description: EqualsEntityExpressionImpl
 * @author: zhongj
 * @date: 2023-08-07 17:41:07
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.inn.AbstractIsNotNullEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.inn.IsNotNullEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.inn.IsNotNullEntityPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.inn.MulitiEntityIsNotNullExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlRelation;

/**
 * The Class EqualsEntityExpressionImpl.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class IsNotNullEntityExpressionImpl<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractIsNotNullEntityExpression<E, C, L> implements IsNotNullEntityExpression<E> {

    private JdbcMappingFactory factory;

    private EntitySqlRelation<?, ?> queryRelation;

    /**
     * Instantiates a new checks if is null entity expression impl.
     *
     * @param index         the index
     * @param expression    the expression
     * @param factory       the factory
     * @param queryRelation the query relation
     */
    public IsNotNullEntityExpressionImpl(int index, MulitiEntityIsNotNullExpression<C, L> expression,
            JdbcMappingFactory factory, EntitySqlRelation<?, ?> queryRelation) {
        super(index, expression, queryRelation.getIgnorePolicy());
        this.factory = factory;
        this.queryRelation = queryRelation;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> IsNotNullEntityPropertyExpression<R> property(SerializableFunction<E, R> name) {
        return new IsNotNullEntityPropertyExpressionImpl<>(index, name,
                (MulitiEntityIsNotNullExpressionImpl<C, L>) expression, factory, queryRelation);
    }
}
