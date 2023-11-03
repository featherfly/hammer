
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-03-13 15:31:13
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query;

import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlConditionsGroupExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;

/**
 * EntitySqlQueryConditionsGroup.
 *
 * @author zhongj
 * @param <E> the element type
 */
public class EntitySqlQueryConditionsGroupExpression<E> extends
        EntitySqlConditionsGroupExpression<E, EntitySqlQueryRelation, SqlSelectBasicBuilder,
                EntitySqlQueryConditionsGroupExpression<E>, EntitySqlQueryConditionsGroupExpression<E>,
                QueryConditionConfig> {

    /**
     * Instantiates a new entity sql query conditions group expression.
     *
     * @param parent            the parent
     * @param index             the index
     * @param factory           the factory
     * @param entitySqlRelation the entity sql relation
     */
    public EntitySqlQueryConditionsGroupExpression(EntitySqlQueryConditionsGroupExpression<E> parent, int index,
            JdbcMappingFactory factory, EntitySqlQueryRelation entitySqlRelation) {
        super(parent, index, factory, entitySqlRelation);
    }

    /**
     * Instantiates a new entity sql query conditions group expression.
     *
     * @param index             the index
     * @param factory           the factory
     * @param entitySqlRelation the entity sql relation
     */
    public EntitySqlQueryConditionsGroupExpression(int index, JdbcMappingFactory factory,
            EntitySqlQueryRelation entitySqlRelation) {
        super(index, factory, entitySqlRelation);
    }

}
