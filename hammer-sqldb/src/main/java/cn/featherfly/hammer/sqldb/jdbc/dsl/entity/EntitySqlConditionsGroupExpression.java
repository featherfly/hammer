
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-03-13 14:39:13
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.config.dsl.ConditionConfig;
import cn.featherfly.hammer.expression.condition.MulitiExpression;
import cn.featherfly.hammer.expression.entity.EntityConditionGroupExpression;
import cn.featherfly.hammer.expression.entity.EntityConditionGroupLogicExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlRelation.EntityRelation;

/**
 * MulitiEntitySqlConditionsGroupExpression.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <ER> the generic type
 * @param <B>  the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <C2> the generic type
 */
public class EntitySqlConditionsGroupExpression<E, C extends EntityConditionGroupExpression<E, C, L>,
    L extends EntityConditionGroupLogicExpression<E, C, L>, C2 extends ConditionConfig<C2>,
    ER extends EntitySqlRelation<ER, B>, B extends SqlBuilder>
    extends AbstractMulitiEntitySqlConditionsGroupExpressionBase<E, C, L, C2, ER, B>
    implements EntityConditionGroupExpression<E, C, L>, EntityConditionGroupLogicExpression<E, C, L>, MulitiExpression {

    /**
     * Instantiates a new muliti entity sql conditions group expression.
     *
     * @param index             the index
     * @param factory           the factory
     * @param entitySqlRelation the entity sql relation
     */
    public EntitySqlConditionsGroupExpression(int index, JdbcMappingFactory factory, ER entitySqlRelation) {
        this(null, index, factory, entitySqlRelation);
    }

    /**
     * Instantiates a new muliti entity sql conditions group expression.
     *
     * @param parent            the parent
     * @param index             the index
     * @param factory           the factory
     * @param entitySqlRelation the entity sql relation
     */
    public EntitySqlConditionsGroupExpression(L parent, int index, JdbcMappingFactory factory, ER entitySqlRelation) {
        super(parent, factory, entitySqlRelation);
        this.index = index;
        @SuppressWarnings("unchecked")
        EntityRelation<E> erm = (EntityRelation<E>) entityRelation.getEntityRelation(index);
        tableAlias = erm.getTableAlias();
        classMapping = erm.getClassMapping();
        aliasManager = entityRelation.getAliasManager();
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    protected C createGroup(L parent) {
        return (C) new EntitySqlConditionsGroupExpression<>((L) this, index, factory, entityRelation);
    }
}
