
package cn.featherfly.hammer.sqldb.dsl.entity.execute;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroup3;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroupLogic3;
import cn.featherfly.hammer.sqldb.dsl.entity.AbstractMulitiEntitySqlConditionsGroupExpression3;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlRelation;

/**
 * sql condition group expression3. 条件逻辑组表达式3.
 *
 * @author zhongj
 * @param <E1> the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <C2> the generic type
 * @param <ER> the generic type
 * @param <B>  the generic type
 */
public abstract class AbstractMulitiEntitySqlExecutableConditionsGroup3<E1, E2, E3,
    C2 extends ExecutableConditionConfig<C2>, ER extends EntitySqlRelation<ER, B>, B extends SqlBuilder> extends
    AbstractMulitiEntitySqlConditionsGroupExpression3<E1, E2, E3, EntityExecutableConditionGroup3<E1, E2, E3, C2>,
        EntityExecutableConditionGroupLogic3<E1, E2, E3, C2>, C2, ER, B>
    implements EntityExecutableConditionGroup3<E1, E2, E3, C2>, EntityExecutableConditionGroupLogic3<E1, E2, E3, C2> {

    /**
     * Instantiates a new abstract muliti entity sql executable conditions group
     * 3.
     *
     * @param parent        the parent
     * @param factory       the factory
     * @param queryRelation the relation
     */
    protected AbstractMulitiEntitySqlExecutableConditionsGroup3(
        EntityExecutableConditionGroupLogic3<E1, E2, E3, C2> parent, JdbcMappingFactory factory, ER queryRelation) {
        super(parent, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int execute() {
        if (parent != null) {
            return parent.execute();
        } else {
            return entityRelation.getJdbc().update(expression(), getParams().toArray());
        }
    }
}
