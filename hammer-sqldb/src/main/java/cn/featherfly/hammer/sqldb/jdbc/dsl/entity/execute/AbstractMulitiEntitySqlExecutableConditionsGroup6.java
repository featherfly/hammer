
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.execute;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroup6;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroupLogic6;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.AbstractMulitiEntitySqlConditionsGroupExpression6;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlRelation;

/**
 * sql condition group expression6. 条件逻辑组表达式6.
 *
 * @author zhongj
 * @param <E1> the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <E6> the generic type
 * @param <C2> the generic type
 * @param <ER> the generic type
 * @param <B>  the generic type
 */
public abstract class AbstractMulitiEntitySqlExecutableConditionsGroup6<E1, E2, E3, E4, E5, E6,
    C2 extends ExecutableConditionConfig<C2>, ER extends EntitySqlRelation<ER, B>, B extends SqlBuilder> extends
    AbstractMulitiEntitySqlConditionsGroupExpression6<E1, E2, E3, E4, E5, E6,
        EntityExecutableConditionGroup6<E1, E2, E3, E4, E5, E6, C2>,
        EntityExecutableConditionGroupLogic6<E1, E2, E3, E4, E5, E6, C2>, C2, ER, B>
    implements EntityExecutableConditionGroup6<E1, E2, E3, E4, E5, E6, C2>,
    EntityExecutableConditionGroupLogic6<E1, E2, E3, E4, E5, E6, C2> {

    /**
     * Instantiates a new abstract muliti entity sql executable conditions group
     * 6.
     *
     * @param parent        the parent
     * @param factory       the factory
     * @param queryRelation the relation
     */
    protected AbstractMulitiEntitySqlExecutableConditionsGroup6(
        EntityExecutableConditionGroupLogic6<E1, E2, E3, E4, E5, E6, C2> parent, JdbcMappingFactory factory,
        ER queryRelation) {
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
