
/*
 * All rights Reserved, Designed By zhongj
 * @Title: AbstractEntitySqlExecutionConditionGroupExpression.java
 * @Package cn.featherfly.hammer.sqldb.sql.dml
 * @Description: AbstractEntitySqlExecutionConditionGroupExpression
 * @author: zhongj
 * @date: 2023-07-31 18:29:31
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.sql.dml;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.dsl.execute.EntityExecutableConditionGroupExpression;
import cn.featherfly.hammer.dsl.execute.EntityExecutableConditionGroupLogicExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlRelation;

/**
 * AbstractEntitySqlExecutionConditionGroupExpression.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <ER> the generic type
 * @param <B>  the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public abstract class AbstractEntitySqlExecutableConditionGroupExpression<E, ER extends EntitySqlRelation<ER, B>,
        B extends SqlBuilder, C extends EntityExecutableConditionGroupExpression<E>,
        L extends EntityExecutableConditionGroupLogicExpression<E>> extends
        AbstractEntitySqlConditionGroupExpressionBase<E, ER, B, EntityExecutableConditionGroupExpression<E>,
                EntityExecutableConditionGroupLogicExpression<E>>
        implements EntityExecutableConditionGroupExpression<E>, EntityExecutableConditionGroupLogicExpression<E> {

    /**
     * Instantiates a new abstract entity sql executable condition group
     * expression.
     *
     * @param parent            the parent
     * @param factory           the factory
     * @param sqlPageFactory    the sql page factory
     * @param entitySqlRelation the entity sql relation
     */
    protected AbstractEntitySqlExecutableConditionGroupExpression(L parent, JdbcMappingFactory factory,
            ER entitySqlRelation) {
        super(parent, factory, entitySqlRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int execute() {
        if (parent != null) {
            return parent.execute();
        } else {
            return entityRelation.getJdbc().update(build(), getParams().toArray());
        }
    }
}
