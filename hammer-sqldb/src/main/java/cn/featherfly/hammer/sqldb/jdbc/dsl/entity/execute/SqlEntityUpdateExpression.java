
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.execute;

import java.util.ArrayList;
import java.util.List;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.builder.dml.basic.SqlUpdateSetBasicBuilder;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.hammer.dsl.execute.EntityExecutableConditionGroupExpression;
import cn.featherfly.hammer.dsl.execute.EntityExecutableConditionGroupLogicExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlUpdateRelation;

/**
 * sql entity update expression .
 *
 * @author zhongj
 * @param <E> the element type
 */
public class SqlEntityUpdateExpression<E> extends
        AbstractSqlEntityExecutableConditionGroupExpression<E, EntitySqlUpdateRelation, SqlUpdateSetBasicBuilder> {

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
    SqlEntityUpdateExpression(EntityExecutableConditionGroupLogicExpression<E> parent, JdbcMappingFactory factory,
            EntitySqlUpdateRelation entityRelation) {
        super(parent, factory, entityRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String build() {
        if (entityRelation.getBuilder().getParams().isEmpty()) {
            return null;
        }
        // YUFEI_TODO 后续加入设置参数，是否允许无条件筛选参数的更新操作（因为无条件帅选参数更新是危险操作）
        //        if (Lang.isEmpty(getParams())) {
        //            return null;
        //        }
        String condition = super.build();
        if (parent == null) {
            if (Lang.isEmpty(condition)) {
                return entityRelation.getBuilder().build();
            } else {
                return entityRelation.getBuilder().build() + Chars.SPACE
                        + entityRelation.getJdbc().getDialect().getKeywords().where() + Chars.SPACE + condition;
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
    protected EntityExecutableConditionGroupExpression<E> createGroup(
            EntityExecutableConditionGroupLogicExpression<E> parent) {
        return new SqlEntityUpdateExpression<>(parent, factory, entityRelation);
    }
}
