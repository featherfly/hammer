
package cn.featherfly.hammer.sqldb.dsl.repository.execute;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroup4;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroupLogic4;
import cn.featherfly.hammer.sqldb.dsl.repository.AbstractMulitiRepositorySqlConditionsGroupExpression4;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlRelation;

/**
 * sql condition group expression4. sql条件逻辑组表达式4.
 *
 * @author zhongj
 * @param <C2> the generic type
 * @param <S>  the generic type
 * @param <B>  the generic type
 */
public abstract class AbstractMulitiRepositorySqlExecutableConditionsGroup4<C2 extends ExecutableConditionConfig<C2>,
        S extends RepositorySqlRelation<S, B>, B extends SqlBuilder> extends
        AbstractMulitiRepositorySqlConditionsGroupExpression4<RepositoryExecutableConditionsGroup4<C2>, RepositoryExecutableConditionsGroupLogic4<C2>, C2, S, B>
        implements RepositoryExecutableConditionsGroup4<C2>, RepositoryExecutableConditionsGroupLogic4<C2> {

    /**
     * Instantiates a new abstract muliti sql repository executable conditions group 4.
     *
     * @param parent             the parent
     * @param index              the index
     * @param repositoryRelation the repository relation
     */
    protected AbstractMulitiRepositorySqlExecutableConditionsGroup4(
            RepositoryExecutableConditionsGroupLogic4<C2> parent, int index, S repositoryRelation) {
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
