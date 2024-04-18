package cn.featherfly.hammer.sqldb.jdbc.dsl.entity;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.ThreeArgusFunction;
import cn.featherfly.hammer.config.dsl.ConditionConfig;
import cn.featherfly.hammer.dsl.entity.EntityOnExpression2;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityPropertyOnlyExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.EntityPropertyOnlyExpressionImpl2;

/**
 * The Class EntitySqlOn2.
 *
 * @author zhongj
 * @param <E1> the generic type
 * @param <E2> the generic type
 * @param <J>  the generic type
 * @param <Q>  the generic type
 * @param <C2> the generic type
 * @param <R>  the generic type
 * @param <B>  the generic type
 */
public class EntitySqlOn2<E1, E2, J, Q, C2 extends ConditionConfig<C2>, R extends EntitySqlRelation<R, B>,
    B extends SqlBuilder> extends AbstractEntitySqlOn<E1, J, Q, R, B> implements EntityOnExpression2<E1, E2, J, Q> {

    /**
     * Instantiates a new abstract entity sql on 1.
     *
     * @param onResult    the on result
     * @param factory     the factory
     * @param sqlRelation the sql relation
     * @param joinType    the join type
     */
    public EntitySqlOn2(Class<J> joinType, Q onResult, JdbcMappingFactory factory, R sqlRelation) {
        super(joinType, onResult, factory, sqlRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Q on(ThreeArgusFunction<EntityPropertyOnlyExpression<E1>, EntityPropertyOnlyExpression<E2>,
        EntityPropertyOnlyExpression<J>, LogicExpression<?, ?>> onExpression) {
        sqlRelation.join(factory.getClassMapping(joinType), () -> onExpression.apply( //
            new EntityPropertyOnlyExpressionImpl2<>(0, factory, sqlRelation)//
            , new EntityPropertyOnlyExpressionImpl2<>(1, factory, sqlRelation) //
            , new EntityPropertyOnlyExpressionImpl2<>(2, factory, sqlRelation) //
        ));
        return onResult;
    }
}
