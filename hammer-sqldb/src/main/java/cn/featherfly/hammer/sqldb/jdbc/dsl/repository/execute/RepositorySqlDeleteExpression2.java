
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.execute;

import cn.featherfly.common.db.builder.dml.basic.SqlDeleteFromBasicBuilder;
import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroup2;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroupLogic2;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlDeleteRelation;

/**
 * sql repository delete expression 2.
 *
 * @author zhongj
 */
public class RepositorySqlDeleteExpression2 extends AbstractMulitiRepositorySqlExecutableConditionsGroup2<
    DeleteConditionConfig, RepositorySqlDeleteRelation, SqlDeleteFromBasicBuilder> {

    /**
     * Instantiates a new repository sql delete expression 2.
     *
     * @param deleteRelation the delete relation
     */
    public RepositorySqlDeleteExpression2(RepositorySqlDeleteRelation deleteRelation) {
        this(null, deleteRelation);
    }

    /**
     * Instantiates a new repository sql delete expression 2.
     *
     * @param parent         the parent
     * @param deleteRelatoin the delete relatoin
     */
    RepositorySqlDeleteExpression2(RepositoryExecutableConditionsGroupLogic2<DeleteConditionConfig> parent,
        RepositorySqlDeleteRelation deleteRelatoin) {
        super(parent, 0, deleteRelatoin);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {
        return RepositorySqlDeleteExpression.expression(super.expression(), parent, repositoryRelation,
            conditionConfig);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryExecutableConditionsGroup2<DeleteConditionConfig> createGroup(
        RepositoryExecutableConditionsGroupLogic2<DeleteConditionConfig> parent) {
        return new RepositorySqlDeleteExpression2(parent, repositoryRelation);
    }
}
