
package cn.featherfly.hammer.sqldb.dsl.repository.execute;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroup6;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroupLogic6;
import cn.featherfly.hammer.sqldb.dsl.repository.AbstractMulitiRepositorySqlConditionsGroupExpression6;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlRelation;

/**
 * sql condition group expression6. sql条件逻辑组表达式6.
 *
 * @author zhongj
 * @param <C2> the generic type
 * @param <S>  the generic type
 * @param <B>  the generic type
 */
public abstract class AbstractMulitiRepositorySqlExecutableConditionsGroup6<C2 extends ExecutableConditionConfig<C2>,
    S extends RepositorySqlRelation<S, B>, B extends SqlBuilder> extends
    AbstractMulitiRepositorySqlConditionsGroupExpression6<RepositoryExecutableConditionsGroup6<C2>,
        RepositoryExecutableConditionsGroupLogic6<C2>, C2, S, B>
    implements RepositoryExecutableConditionsGroup6<C2>, RepositoryExecutableConditionsGroupLogic6<C2> {

    /**
     * Instantiates a new abstract muliti sql repository executable conditions
     * group 6.
     *
     * @param parent             the parent
     * @param index              the index
     * @param repositoryRelation the repository relation
     */
    protected AbstractMulitiRepositorySqlExecutableConditionsGroup6(
        RepositoryExecutableConditionsGroupLogic6<C2> parent, int index, S repositoryRelation) {
        // 删除，和更新不需要分页
        super(parent, index, repositoryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int execute() {
        if (parent != null) {
            return parent.execute();
        } else {
            return repositoryRelation.getJdbc().update(expression(), getParams().toArray());
        }
    }
}
