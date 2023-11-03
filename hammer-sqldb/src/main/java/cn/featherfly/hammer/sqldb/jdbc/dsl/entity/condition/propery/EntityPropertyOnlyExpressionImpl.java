
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityPropertyFunctionImpl.java
 * @Description: EntityPropertyFunctionImpl
 * @author: zhongj
 * @date: 2023-08-21 18:00:21
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.expression.entity.condition.property.EntityPropertyOnlyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityPropertyOnlyLogicExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.InternalMulitiEntityCondition;

/**
 * entity property function only impl.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class EntityPropertyOnlyExpressionImpl<E>
        extends EntityPropertyExpressionImpl<E, EntityPropertyOnlyExpression<E>, EntityPropertyOnlyLogicExpression<E>>
        implements EntityPropertyOnlyExpression<E> {

    /**
     * Instantiates a new entity property function impl.
     *
     * @param index         the index
     * @param expression    the expression
     * @param factory       the factory
     * @param queryRelation the query relation
     */
    @SuppressWarnings("unchecked")
    public EntityPropertyOnlyExpressionImpl(int index, InternalMulitiEntityCondition<?> expression,
            JdbcMappingFactory factory, EntitySqlRelation<?, ?> queryRelation) {
        super(index, (InternalMulitiEntityCondition<EntityPropertyOnlyLogicExpression<E>>) expression, factory,
                queryRelation);
    }
}
