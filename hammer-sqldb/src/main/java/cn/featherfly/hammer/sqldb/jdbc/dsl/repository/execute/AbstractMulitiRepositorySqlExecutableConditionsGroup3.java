
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.execute;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroup3;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroupLogic3;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.AbstractMulitiRepositorySqlConditionsGroupExpression3;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlRelation;

/**
 * sql condition group expression3. sql条件逻辑组表达式3.
 *
 * @author zhongj
 * @param <T> the element type
 * @param <R> the generic type
 * @param <B> the generic type
 * @param <C> the generic type
 */
public abstract class AbstractMulitiRepositorySqlExecutableConditionsGroup3<C2 extends ExecutableConditionConfig<C2>,
    S extends RepositorySqlRelation<S, B>, B extends SqlBuilder> extends
    AbstractMulitiRepositorySqlConditionsGroupExpression3<RepositoryExecutableConditionsGroup3<C2>,
        RepositoryExecutableConditionsGroupLogic3<C2>, C2, S, B>
    implements RepositoryExecutableConditionsGroup3<C2>, RepositoryExecutableConditionsGroupLogic3<C2> {

    /**
     * Instantiates a new abstract muliti sql repository executable conditions
     * group 3.
     *
     * @param parent             the parent
     * @param index              the index
     * @param repositoryRelation the repository relation
     */
    protected AbstractMulitiRepositorySqlExecutableConditionsGroup3(
        RepositoryExecutableConditionsGroupLogic3<C2> parent, int index, S repositoryRelation) {
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
