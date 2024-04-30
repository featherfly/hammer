
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.execute;

import cn.featherfly.common.db.builder.dml.basic.SqlDeleteFromBasicBuilder;
import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroup3;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroupLogic3;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlDeleteRelation;

/**
 * sql repository delete expression 3.
 *
 * @author zhongj
 */
public class RepositorySqlDeleteConditions3 extends AbstractMulitiRepositorySqlExecutableConditionsGroup3<
    DeleteConditionConfig, RepositorySqlDeleteRelation, SqlDeleteFromBasicBuilder> {

    /**
     * Instantiates a new repository sql delete expression 3.
     *
     * @param deleteRelation the delete relation
     */
    public RepositorySqlDeleteConditions3(RepositorySqlDeleteRelation deleteRelation) {
        this(null, deleteRelation);
    }

    /**
     * Instantiates a new repository sql delete expression 3.
     *
     * @param parent         the parent
     * @param deleteRelatoin the delete relatoin
     */
    RepositorySqlDeleteConditions3(RepositoryExecutableConditionsGroupLogic3<DeleteConditionConfig> parent,
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
    protected RepositoryExecutableConditionsGroup3<DeleteConditionConfig> createGroup(
        RepositoryExecutableConditionsGroupLogic3<DeleteConditionConfig> parent) {
        return new RepositorySqlDeleteConditions3(parent, repositoryRelation);
    }
}
