
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.execute;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.builder.dml.basic.SqlDeleteFromBasicBuilder;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroup;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroupLogic;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlDeleteRelation;

/**
 * SqlDeleteExpression .
 *
 * @author zhongj
 * @param <E> the element type
 */
public class SqlEntityDeleteExpression<E> extends
        AbstractSqlEntityExecutableConditionGroupExpression<E, EntitySqlDeleteRelation, SqlDeleteFromBasicBuilder> {

    /**
     * Instantiates a new entity sql delete expression.
     *
     * @param factory        the factory
     * @param entityRelation the entity relation
     */
    public SqlEntityDeleteExpression(JdbcMappingFactory factory, EntitySqlDeleteRelation entityRelation) {
        // ENHANCE 删除暂时没有支持别名
        super(null, factory, entityRelation);
    }

    /**
     * Instantiates a new sql entity delete expression.
     *
     * @param parent         the parent
     * @param factory        the factory
     * @param entityRelation the entity relation
     */
    SqlEntityDeleteExpression(EntityExecutableConditionGroupLogic<E> parent, JdbcMappingFactory factory,
            EntitySqlDeleteRelation entityRelation) {
        super(parent, factory, entityRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String build() {
        // YUFEI_TODO 后续加入设置参数，是否允许无条件筛选参数的删除操作（因为无条件帅选参数删除是危险操作），默认为不允许
        if (Lang.isEmpty(getParams())) {
            return null;
        }
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
        //        String condition = super.build();
        //        if (Strings.isEmpty(condition)) {
        //            return entityRelation.getBuilder().build();
        //        } else {
        //            //            return entityRelation.getBuilder().build() + Chars.SPACE
        //            //                    + entityRelation.getJdbc().getDialect().getKeywords().where() + Chars.SPACE + condition;
        //            return entityRelation.getBuilder().build() + Chars.SPACE + condition;
        //        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected EntityExecutableConditionGroup<E> createGroup(
            EntityExecutableConditionGroupLogic<E> parent) {
        return new SqlEntityDeleteExpression<>(parent, factory, entityRelation);
    }
}
