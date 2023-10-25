
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.execute;

import java.util.ArrayList;
import java.util.List;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.builder.dml.basic.SqlUpdateSetBasicBuilder;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroup;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroupLogic;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlUpdateRelation;

/**
 * sql entity update expression .
 *
 * @author zhongj
 * @param <E> the element type
 */
public class SqlEntityUpdateExpression<E> extends AbstractSqlEntityExecutableConditionGroupExpression<E,
        EntitySqlUpdateRelation, SqlUpdateSetBasicBuilder, UpdateConditionConfig> {

    /**
     * Instantiates a new sql entity update expression.
     *
     * @param factory        the factory
     * @param entityRelation the entity relation
     */
    public SqlEntityUpdateExpression(JdbcMappingFactory factory, EntitySqlUpdateRelation entityRelation) {
        // ENHANCE 删除暂时没有支持别名
        this(null, factory, entityRelation);
    }

    /**
     * Instantiates a new sql entity update expression.
     *
     * @param parent         the parent
     * @param factory        the factory
     * @param entityRelation the entity relation
     */
    SqlEntityUpdateExpression(EntityExecutableConditionGroupLogic<E, UpdateConditionConfig> parent,
            JdbcMappingFactory factory, EntitySqlUpdateRelation entityRelation) {
        super(parent, factory, entityRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String build() {
        String condition = super.build();
        if (parent == null) {
            if (Lang.isEmpty(condition)) {
                switch (((UpdateConditionConfig) conditionConfig).getEmptyConditionStrategy()) {
                    case EXCEPTION:
                        throw new SqldbHammerException("empty condition");
                    case NON_EXECUTION:
                        return null;
                    case EXECUTION:
                        return entityRelation.getBuilder().build();
                    default:
                        return entityRelation.getBuilder().build();
                }
            } else {
                try {
                    return entityRelation.getBuilder().build() + Chars.SPACE
                            + entityRelation.getJdbc().getDialect().getKeywords().where() + Chars.SPACE + condition;
                } catch (JdbcException e) {
                    // no value to set, use NON_EXECUTION strategy
                    return null;
                }
            }
        } else {
            return condition;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Object> getParams() {
        List<Object> params = new ArrayList<>();
        if (parent == null) {
            params.addAll(entityRelation.getBuilder().getParams());
        }
        params.addAll(super.getParams());
        return params;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected EntityExecutableConditionGroup<E, UpdateConditionConfig> createGroup(
            EntityExecutableConditionGroupLogic<E, UpdateConditionConfig> parent) {
        return new SqlEntityUpdateExpression<>(parent, factory, entityRelation);
    }
}
