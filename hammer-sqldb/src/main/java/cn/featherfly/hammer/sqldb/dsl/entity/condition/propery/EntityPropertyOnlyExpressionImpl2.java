
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityPropertyFunctionImpl.java
 * @Description: EntityPropertyFunctionImpl
 * @author: zhongj
 * @date: 2023-08-21 18:00:21
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.entity.condition.propery;

import java.util.function.Function;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.config.dsl.ConditionConfig;
import cn.featherfly.hammer.expression.entity.condition.property.EntityPropertyOnlyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityPropertyOnlyLogicExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlRelation;

/**
 * entity property function only impl.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C2> the generic type
 * @param <S> the generic type
 * @param <B> the generic type
 */
public class EntityPropertyOnlyExpressionImpl2<E, C2 extends ConditionConfig<C2>, S extends EntitySqlRelation<S, B>,
    B extends SqlBuilder> extends
    EntityPropertyExpressionImpl2<E, EntityPropertyOnlyExpression<E>, EntityPropertyOnlyLogicExpression<E>, C2, S, B>
    implements EntityPropertyOnlyExpression<E> {

    /**
     * Instantiates a new entity property only expression impl 2.
     *
     * @param index the index
     * @param factory the factory
     * @param relation the relation
     */
    public EntityPropertyOnlyExpressionImpl2(int index, JdbcMappingFactory factory, S relation) {
        super(index, factory, relation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityPropertyOnlyExpression<E> group() {
        return expression.group();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityPropertyOnlyLogicExpression<E> group(
        Function<EntityPropertyOnlyExpression<E>, EntityPropertyOnlyLogicExpression<E>> group) {
        return expression.group(group);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityPropertyOnlyLogicExpression<E> ignore(boolean ignorable,
        Function<EntityPropertyOnlyExpression<E>, EntityPropertyOnlyLogicExpression<E>> conditionExpressions) {
        return expression.ignore(ignorable, conditionExpressions);
    }
}
