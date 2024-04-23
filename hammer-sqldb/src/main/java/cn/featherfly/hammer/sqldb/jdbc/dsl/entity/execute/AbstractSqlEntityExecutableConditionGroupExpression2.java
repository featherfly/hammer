
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.execute;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroup2;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroupLogic2;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlRelation;

/**
 * sql condition group builder sql条件逻辑组构造器 .
 *
 * @author zhongj
 * @param <T> the element type
 * @param <R> the generic type
 * @param <B> the generic type
 * @param <C> the generic type
 */
public abstract class AbstractSqlEntityExecutableConditionGroupExpression2<T1, T2,
    C2 extends ExecutableConditionConfig<C2>, ER extends EntitySqlRelation<ER, B>, B extends SqlBuilder> extends
    AbstractMulitiEntitySqlExecutableConditionsGroupExpression2<T1, T2, C2, ER, B,
        EntityExecutableConditionGroup2<T1, T2, C2>, EntityExecutableConditionGroupLogic2<T1, T2, C2>>
    implements EntityExecutableConditionGroup2<T1, T2, C2>, EntityExecutableConditionGroupLogic2<T1, T2, C2> {

    /**
     * Instantiates a new sql entity condition group expression.
     *
     * @param parent         the parent
     * @param factory        the factory
     * @param entityRelation the entity relation
     */
    protected AbstractSqlEntityExecutableConditionGroupExpression2(
        EntityExecutableConditionGroupLogic2<T1, T2, C2> parent, JdbcMappingFactory factory, ER entityRelation) {
        // 删除，和更新不需要分页
        super(parent, factory, entityRelation);
    }

    // ********************************************************************
    // property
    // ********************************************************************
}