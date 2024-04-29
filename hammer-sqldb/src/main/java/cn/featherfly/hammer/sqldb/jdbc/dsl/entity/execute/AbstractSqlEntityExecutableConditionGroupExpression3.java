
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.execute;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroup3;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroupLogic3;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlRelation;

/**
 * sql condition group expression3. sql条件逻辑组表达式3 .
 *
 * @author zhongj
 * @param <T> the element type
 * @param <R> the generic type
 * @param <B> the generic type
 * @param <C> the generic type
 */
public abstract class AbstractSqlEntityExecutableConditionGroupExpression3<T1, T2, T3,
    C2 extends ExecutableConditionConfig<C2>, ER extends EntitySqlRelation<ER, B>, B extends SqlBuilder> extends
    AbstractMulitiEntitySqlExecutableConditionsGroupExpression3<T1, T2, T3, C2, ER, B,
        EntityExecutableConditionGroup3<T1, T2, T3, C2>, EntityExecutableConditionGroupLogic3<T1, T2, T3, C2>>
    implements EntityExecutableConditionGroup3<T1, T2, T3, C2>, EntityExecutableConditionGroupLogic3<T1, T2, T3, C2> {

    /**
     * Instantiates a new sql entity condition group expression.
     *
     * @param parent         the parent
     * @param factory        the factory
     * @param entityRelation the entity relation
     */
    protected AbstractSqlEntityExecutableConditionGroupExpression3(
        EntityExecutableConditionGroupLogic3<T1, T2, T3, C2> parent, JdbcMappingFactory factory, ER entityRelation) {
        // 删除，和更新不需要分页
        super(parent, factory, entityRelation);
    }

    // ********************************************************************
    // property
    // ********************************************************************
}
