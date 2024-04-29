
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.execute;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.entity.execute.EntityExecutableConditionGroupExpression6;
import cn.featherfly.hammer.expression.entity.execute.EntityExecutableConditionGroupLogicExpression6;
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
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public abstract class AbstractMulitiEntitySqlExecutableConditionsGroupExpression6<E1, E2, E3, E4, E5, E6,
    C2 extends ExecutableConditionConfig<C2>, ER extends EntitySqlRelation<ER, B>, B extends SqlBuilder,
    C extends EntityExecutableConditionGroupExpression6<E1, E2, E3, E4, E5, E6, C, L, C2>,
    L extends EntityExecutableConditionGroupLogicExpression6<E1, E2, E3, E4, E5, E6, C, L, C2>>
    extends AbstractMulitiEntitySqlConditionsGroupExpression6<E1, E2, E3, E4, E5, E6, C, L, C2, ER, B>
    implements EntityExecutableConditionGroupExpression6<E1, E2, E3, E4, E5, E6, C, L, C2>,
    EntityExecutableConditionGroupLogicExpression6<E1, E2, E3, E4, E5, E6, C, L, C2> {

    /**
     * Instantiates a new abstract entity sql condition group expression 2.
     *
     * @param parent        the parent
     * @param factory       the factory
     * @param queryRelation the relation
     */
    protected AbstractMulitiEntitySqlExecutableConditionsGroupExpression6(L parent, JdbcMappingFactory factory,
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
