
package cn.featherfly.hammer.sqldb.dsl.repository.execute;

import cn.featherfly.common.db.builder.dml.basic.SqlDeleteFromBasicBuilder;
import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroup6;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroupLogic6;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlDeleteRelation;

/**
 * sql repository delete expression 6.
 *
 * @author zhongj
 */
public class RepositorySqlDeleteConditions6 extends AbstractMulitiRepositorySqlExecutableConditionsGroup6<
    DeleteConditionConfig, RepositorySqlDeleteRelation, SqlDeleteFromBasicBuilder> {

    /**
     * Instantiates a new repository sql delete expression 6.
     *
     * @param deleteRelation the delete relation
     */
    public RepositorySqlDeleteConditions6(RepositorySqlDeleteRelation deleteRelation) {
        this(null, deleteRelation);
    }

    /**
     * Instantiates a new repository sql delete expression 6.
     *
     * @param parent         the parent
     * @param deleteRelatoin the delete relatoin
     */
    RepositorySqlDeleteConditions6(RepositoryExecutableConditionsGroupLogic6<DeleteConditionConfig> parent,
        RepositorySqlDeleteRelation deleteRelatoin) {
        super(parent, 0, deleteRelatoin);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {
        return RepositorySqlDeleteConditions.expression(super.expression(), parent, repositoryRelation,
            conditionConfig);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryExecutableConditionsGroup6<DeleteConditionConfig> createGroup(
        RepositoryExecutableConditionsGroupLogic6<DeleteConditionConfig> parent) {
        return new RepositorySqlDeleteConditions6(parent, repositoryRelation);
    }
}
