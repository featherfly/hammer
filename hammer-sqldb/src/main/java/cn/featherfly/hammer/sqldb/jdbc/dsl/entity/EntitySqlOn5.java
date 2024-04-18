
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.SixArgusFunction;
import cn.featherfly.hammer.config.dsl.ConditionConfig;
import cn.featherfly.hammer.dsl.entity.EntityOnExpression5;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityPropertyOnlyExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.EntityPropertyOnlyExpressionImpl2;

/**
 * The Class EntitySqlOn5.
 *
 * @author zhongj
 * @param <E1> the generic type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <J>  the generic type
 * @param <Q>  the generic type
 * @param <C2> the generic type
 * @param <R>  the generic type
 * @param <B>  the generic type
 */
public class EntitySqlOn5<E1, E2, E3, E4, E5, J, Q, C2 extends ConditionConfig<C2>, R extends EntitySqlRelation<R, B>,
    B extends SqlBuilder> extends AbstractEntitySqlOn<E1, J, Q, R, B>
    implements EntityOnExpression5<E1, E2, E3, E4, E5, J, Q> {

    /**
     * Instantiates a new abstract entity sql on 1.
     *
     * @param onResult    the on result
     * @param factory     the factory
     * @param sqlRelation the sql relation
     * @param joinType    the join type
     */
    public EntitySqlOn5(Class<J> joinType, Q onResult, JdbcMappingFactory factory, R sqlRelation) {
        super(joinType, onResult, factory, sqlRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Q on(SixArgusFunction<EntityPropertyOnlyExpression<E1>, EntityPropertyOnlyExpression<E2>,
        EntityPropertyOnlyExpression<E3>, EntityPropertyOnlyExpression<E4>, EntityPropertyOnlyExpression<E5>,
        EntityPropertyOnlyExpression<J>, LogicExpression<?, ?>> onExpression) {
        sqlRelation.join(factory.getClassMapping(joinType), () -> onExpression.apply( //
            new EntityPropertyOnlyExpressionImpl2<>(0, factory, sqlRelation)//
            , new EntityPropertyOnlyExpressionImpl2<>(1, factory, sqlRelation) //
            , new EntityPropertyOnlyExpressionImpl2<>(2, factory, sqlRelation) //
            , new EntityPropertyOnlyExpressionImpl2<>(3, factory, sqlRelation) //
            , new EntityPropertyOnlyExpressionImpl2<>(4, factory, sqlRelation) //
            , new EntityPropertyOnlyExpressionImpl2<>(5, factory, sqlRelation) //
        ));
        return onResult;
    }
}
