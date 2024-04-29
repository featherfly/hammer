
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.execute;

import com.speedment.common.tuple.Tuple1;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroup;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroupLogic;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.AbstractMulitiRepositorySqlConditionsGroupExpressionBase;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlRelation;

/**
 * sql condition group expression. sql条件逻辑组表达式.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <S> the generic type
 * @param <B> the generic type
 */
public abstract class AbstractMulitiRepositorySqlExecutableConditionsGroup<C extends ExecutableConditionConfig<C>,
    S extends RepositorySqlRelation<S, B>, B extends SqlBuilder> extends
    AbstractMulitiRepositorySqlConditionsGroupExpressionBase<RepositoryExecutableConditionsGroup<C>,
        RepositoryExecutableConditionsGroupLogic<C>, Tuple1<Integer>, C, S, B>
    implements RepositoryExecutableConditionsGroup<C>, RepositoryExecutableConditionsGroupLogic<C> {

    /**
     * Instantiates a new abstract muliti sql repository executable conditions
     * group .
     *
     * @param parent             the parent
     * @param index              the index
     * @param repositoryRelation the repository relation
     */
    protected AbstractMulitiRepositorySqlExecutableConditionsGroup(RepositoryExecutableConditionsGroupLogic<C> parent,
        int index, S repositoryRelation) {
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

    /**
     * {@inheritDoc}
     */
    @Override
    protected Tuple1<Integer> createTuple() {
        return Tuples.of(0);
    }
}
