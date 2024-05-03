
package cn.featherfly.hammer.sqldb.dsl.entity.execute;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.builder.dml.basic.SqlDeleteFromBasicBuilder;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroup;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroupLogic;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlDeleteRelation;

/**
 * entity sql delete conditions .
 *
 * @author zhongj
 * @param <E> the delete type
 */
public class EntitySqlDeleteConditions<E> extends AbstractMulitiEntitySqlExecutableConditionsGroup<E,
    EntitySqlDeleteRelation, SqlDeleteFromBasicBuilder, DeleteConditionConfig> {

    /**
     * Instantiates a new entity sql delete expression.
     *
     * @param factory        the factory
     * @param entityRelation the entity relation
     */
    public EntitySqlDeleteConditions(JdbcMappingFactory factory, EntitySqlDeleteRelation entityRelation) {
        this(null, factory, entityRelation);
    }

    /**
     * Instantiates a new sql entity delete expression.
     *
     * @param parent         the parent
     * @param factory        the factory
     * @param entityRelation the entity relation
     */
    EntitySqlDeleteConditions(EntityExecutableConditionGroupLogic<E, DeleteConditionConfig> parent,
        JdbcMappingFactory factory, EntitySqlDeleteRelation entityRelation) {
        super(parent, factory, entityRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {
        return expression(super.expression(), parent, entityRelation, conditionConfig);
        //        // TODO 后续加入设置参数，是否允许无条件筛选参数的删除操作（因为无条件帅选参数删除是危险操作），默认为不允许
        //        // 当前没有参数返回的0
        //        String condition = super.expression();
        //        if (parent == null) {
        //            if (Lang.isEmpty(condition)) {
        //                switch (conditionConfig.getEmptyConditionStrategy()) {
        //                    case EXCEPTION:
        //                        throw new SqldbHammerException("empty condition");
        //                    case NON_EXECUTION:
        //                        return null;
        //                    case EXECUTION:
        //                        return entityRelation.getBuilder().build();
        //                    default:
        //                        return entityRelation.getBuilder().build();
        //                }
        //            } else {
        //                return entityRelation.getBuilder().build() + Chars.SPACE
        //                    + entityRelation.getJdbc().getDialect().getKeywords().where() + Chars.SPACE + condition;
        //            }
        //        } else {
        //            return condition;
        //        }

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
    protected EntityExecutableConditionGroup<E, DeleteConditionConfig> createGroup(
        EntityExecutableConditionGroupLogic<E, DeleteConditionConfig> parent) {
        return new EntitySqlDeleteConditions<>(parent, factory, entityRelation);
    }

    static String expression(String condition, LogicExpression<?, ?> parent, EntitySqlDeleteRelation relation,
        DeleteConditionConfig conditionConfig) {
        // TODO 后续加入设置参数，是否允许无条件筛选参数的删除操作（因为无条件帅选参数删除是危险操作），默认为不允许
        // 当前没有参数返回的0
        if (parent == null) {
            if (Lang.isEmpty(condition)) {
                switch (conditionConfig.getEmptyConditionStrategy()) {
                    case EXCEPTION:
                        throw new SqldbHammerException("empty condition");
                    case NON_EXECUTION:
                        return null;
                    case EXECUTION:
                        return relation.getBuilder().build();
                    default:
                        return relation.getBuilder().build();
                }
            } else {
                return relation.getBuilder().build() + Chars.SPACE
                    + relation.getJdbc().getDialect().getKeywords().where() + Chars.SPACE + condition;
            }
        } else {
            return condition;
        }
    }
}
