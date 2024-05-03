
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntitySqlQueryRelated.java
 * @Description: EntitySqlQueryRelated
 * @author: zhongj
 * @date: 2023-08-11 16:23:11
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.entity;

import java.util.function.BiFunction;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.config.dsl.ConditionConfig;
import cn.featherfly.hammer.dsl.entity.EntityOnExpression1;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityPropertyOnlyExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.propery.EntityPropertyOnlyExpressionImpl2;

/**
 * The Class EntitySqlOn1.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <J>  the generic type
 * @param <Q>  the generic type
 * @param <C2> the generic type
 * @param <R>  the generic type
 * @param <B>  the generic type
 */
public class EntitySqlOn1<E, J, Q, C2 extends ConditionConfig<C2>, R extends EntitySqlRelation<R, B>,
    B extends SqlBuilder> extends AbstractEntitySqlOn<E, J, Q, R, B> implements EntityOnExpression1<E, J, Q> {

    /**
     * Instantiates a new abstract entity sql on 1.
     *
     * @param onResult    the on result
     * @param factory     the factory
     * @param sqlRelation the sql relation
     * @param joinType    the join type
     */
    public EntitySqlOn1(Class<J> joinType, Q onResult, JdbcMappingFactory factory, R sqlRelation) {
        super(joinType, onResult, factory, sqlRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Q on(BiFunction<EntityPropertyOnlyExpression<E>, EntityPropertyOnlyExpression<J>,
        LogicExpression<?, ?>> onExpression) {
        sqlRelation.join(factory.getClassMapping(joinType), () -> onExpression.apply( //
            new EntityPropertyOnlyExpressionImpl2<>(0, factory, sqlRelation)//
            , new EntityPropertyOnlyExpressionImpl2<>(1, factory, sqlRelation) //
        ));
        return onResult;
    }
}
