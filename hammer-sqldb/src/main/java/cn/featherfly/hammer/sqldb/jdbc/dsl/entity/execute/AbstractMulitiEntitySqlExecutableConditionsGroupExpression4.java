
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.execute;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.entity.execute.EntityExecutableConditionGroupExpression4;
import cn.featherfly.hammer.expression.entity.execute.EntityExecutableConditionGroupLogicExpression4;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.AbstractMulitiEntitySqlConditionsGroupExpression4;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlRelation;

/**
 * sql condition group expression4. 条件逻辑组表达式4.
 *
 * @author zhongj
 * @param <E1> the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <C2> the generic type
 * @param <ER> the generic type
 * @param <B>  the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public abstract class AbstractMulitiEntitySqlExecutableConditionsGroupExpression4<E1, E2, E3, E4,
    C2 extends ExecutableConditionConfig<C2>, ER extends EntitySqlRelation<ER, B>, B extends SqlBuilder,
    C extends EntityExecutableConditionGroupExpression4<E1, E2, E3, E4, C, L, C2>,
    L extends EntityExecutableConditionGroupLogicExpression4<E1, E2, E3, E4, C, L, C2>>
    extends AbstractMulitiEntitySqlConditionsGroupExpression4<E1, E2, E3, E4, C, L, C2, ER, B>
    implements EntityExecutableConditionGroupExpression4<E1, E2, E3, E4, C, L, C2>,
    EntityExecutableConditionGroupLogicExpression4<E1, E2, E3, E4, C, L, C2> {

    /**
     * Instantiates a new abstract entity sql condition group expression 2.
     *
     * @param parent        the parent
     * @param factory       the factory
     * @param queryRelation the relation
     */
    protected AbstractMulitiEntitySqlExecutableConditionsGroupExpression4(L parent, JdbcMappingFactory factory,
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
