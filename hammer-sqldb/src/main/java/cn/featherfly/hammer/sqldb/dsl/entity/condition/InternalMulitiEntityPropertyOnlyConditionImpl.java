
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-04-02 16:23:02
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.entity.condition;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.config.dsl.ConditionConfig;
import cn.featherfly.hammer.expression.entity.condition.property.EntityPropertyOnlyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityPropertyOnlyLogicExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.AbstractMulitiEntitySqlConditionsGroupExpressionBase;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlRelation;

/**
 * InternalMulitiEntityPropertyOnlyConditionImpl.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C2> the generic type
 * @param <S> the generic type
 * @param <B> the generic type
 */
public class InternalMulitiEntityPropertyOnlyConditionImpl<E, C2 extends ConditionConfig<C2>,
    S extends EntitySqlRelation<S, B>, B extends SqlBuilder> extends
    AbstractMulitiEntitySqlConditionsGroupExpressionBase<E, EntityPropertyOnlyExpression<E>,
        EntityPropertyOnlyLogicExpression<E>, C2, S, B>
    implements EntityPropertyOnlyExpression<E>, EntityPropertyOnlyLogicExpression<E> {

    /**
     * Instantiates a new internal muliti repository condition impl.
     *
     * @param factory the factory
     * @param entitySqlRelation the entity sql relation
     */
    public InternalMulitiEntityPropertyOnlyConditionImpl(JdbcMappingFactory factory, S entitySqlRelation) {
        super(null, factory, entitySqlRelation);
    }

    /**
     * Instantiates a new internal muliti repository condition impl.
     *
     * @param parent the parent
     * @param index the index
     */
    private InternalMulitiEntityPropertyOnlyConditionImpl(EntityPropertyOnlyLogicExpression<E> parent,
        JdbcMappingFactory factory, S entitySqlRelation) {
        super(parent, factory, entitySqlRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected EntityPropertyOnlyExpression<E> createGroup(EntityPropertyOnlyLogicExpression<E> parent) {
        return new InternalMulitiEntityPropertyOnlyConditionImpl<>(parent, factory, entityRelation);
    }
}
