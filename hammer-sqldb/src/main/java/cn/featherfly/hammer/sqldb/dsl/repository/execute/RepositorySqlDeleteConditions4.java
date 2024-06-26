
package cn.featherfly.hammer.sqldb.dsl.repository.execute;

import cn.featherfly.common.db.builder.dml.basic.SqlDeleteFromBasicBuilder;
import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroup4;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroupLogic4;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlDeleteRelation;

/**
 * sql repository delete expression 4.
 *
 * @author zhongj
 */
public class RepositorySqlDeleteConditions4 extends AbstractMulitiRepositorySqlExecutableConditionsGroup4<
    DeleteConditionConfig, RepositorySqlDeleteRelation, SqlDeleteFromBasicBuilder> {

    /**
     * Instantiates a new repository sql delete expression 4.
     *
     * @param deleteRelation the delete relation
     */
    public RepositorySqlDeleteConditions4(RepositorySqlDeleteRelation deleteRelation) {
        this(null, deleteRelation);
    }

    /**
     * @param parent         the parent
     * @param deleteRelatoin the delete relatoin
     */
    RepositorySqlDeleteConditions4(RepositoryExecutableConditionsGroupLogic4<DeleteConditionConfig> parent,
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
    protected RepositoryExecutableConditionsGroup4<DeleteConditionConfig> createGroup(
        RepositoryExecutableConditionsGroupLogic4<DeleteConditionConfig> parent) {
        return new RepositorySqlDeleteConditions4(parent, repositoryRelation);
    }
}
