
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.execute;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroup5;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroupLogic5;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.AbstractMulitiEntitySqlConditionsGroupExpression5;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlRelation;

/**
 * sql condition group expression5. 条件逻辑组表达式5.
 *
 * @author zhongj
 * @param <E1> the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <C2> the generic type
 * @param <ER> the generic type
 * @param <B>  the generic type
 */
public abstract class AbstractMulitiEntitySqlExecutableConditionsGroup5<E1, E2, E3, E4, E5,
    C2 extends ExecutableConditionConfig<C2>, ER extends EntitySqlRelation<ER, B>, B extends SqlBuilder> extends
    AbstractMulitiEntitySqlConditionsGroupExpression5<E1, E2, E3, E4, E5,
        EntityExecutableConditionGroup5<E1, E2, E3, E4, E5, C2>,
        EntityExecutableConditionGroupLogic5<E1, E2, E3, E4, E5, C2>, C2, ER, B>
    implements EntityExecutableConditionGroup5<E1, E2, E3, E4, E5, C2>,
    EntityExecutableConditionGroupLogic5<E1, E2, E3, E4, E5, C2> {

    /**
     * Instantiates a new abstract muliti entity sql executable conditions group
     * 5.
     *
     * @param parent        the parent
     * @param factory       the factory
     * @param queryRelation the relation
     */
    protected AbstractMulitiEntitySqlExecutableConditionsGroup5(
        EntityExecutableConditionGroupLogic5<E1, E2, E3, E4, E5, C2> parent, JdbcMappingFactory factory,
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
