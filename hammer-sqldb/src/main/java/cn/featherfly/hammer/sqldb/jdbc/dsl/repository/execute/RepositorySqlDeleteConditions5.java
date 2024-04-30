
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.execute;

import cn.featherfly.common.db.builder.dml.basic.SqlDeleteFromBasicBuilder;
import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroup5;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroupLogic5;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlDeleteRelation;

/**
 * sql repository delete expression 5.
 *
 * @author zhongj
 */
public class RepositorySqlDeleteConditions5 extends AbstractMulitiRepositorySqlExecutableConditionsGroup5<
    DeleteConditionConfig, RepositorySqlDeleteRelation, SqlDeleteFromBasicBuilder> {

    /**
     * Instantiates a new repository sql delete expression 5.
     *
     * @param deleteRelation the delete relation
     */
    public RepositorySqlDeleteConditions5(RepositorySqlDeleteRelation deleteRelation) {
        this(null, deleteRelation);
    }

    /**
     * @param parent         the parent
     * @param deleteRelatoin the delete relatoin
     */
    RepositorySqlDeleteConditions5(RepositoryExecutableConditionsGroupLogic5<DeleteConditionConfig> parent,
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
    protected RepositoryExecutableConditionsGroup5<DeleteConditionConfig> createGroup(
        RepositoryExecutableConditionsGroupLogic5<DeleteConditionConfig> parent) {
        return new RepositorySqlDeleteConditions5(parent, repositoryRelation);
    }
}
