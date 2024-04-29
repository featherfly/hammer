
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.execute;

import java.util.function.Consumer;

import cn.featherfly.common.db.builder.dml.basic.SqlDeleteFromBasicBuilder;
import cn.featherfly.common.function.FiveArgusFunction;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.config.dsl.DeleteConfig;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression5;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryDelete5;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryDelete6;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroup5;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroupLogic5;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.execute.RepositoryDeleteExpression5;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlDeleteRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlOn5;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.field.RepositoryFieldOnlyExpressionImpl;

/**
 * sql repository delete .
 *
 * @author zhongj
 */
public class RepositorySqlDelete5 implements RepositoryDelete5 {

    private RepositorySqlDeleteRelation repositoryDeleteRelation;

    /**
     * Instantiates a new sql delete.
     *
     * @param repositoryDeleteRelation the repository delete relation
     */
    public RepositorySqlDelete5(RepositorySqlDeleteRelation repositoryDeleteRelation) {
        this.repositoryDeleteRelation = repositoryDeleteRelation;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryExecutableConditionsGroup5<DeleteConditionConfig> where() {
        return new RepositorySqlDeleteExpression5(repositoryDeleteRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryExecutableConditionsGroupLogic5<DeleteConditionConfig> where(
        FiveArgusFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, LogicExpression<?, ?>> filterable) {
        RepositorySqlDeleteExpression5 sqlDeleteExpression = (RepositorySqlDeleteExpression5) where();
        if (filterable != null) {
            // filterable.apply(sqlDeleteExpression);
            sqlDeleteExpression
                .addCondition(filterable.apply(new RepositoryFieldOnlyExpressionImpl<>(0, repositoryDeleteRelation) //
                    , new RepositoryFieldOnlyExpressionImpl<>(1, repositoryDeleteRelation) //
                    , new RepositoryFieldOnlyExpressionImpl<>(2, repositoryDeleteRelation) //
                    , new RepositoryFieldOnlyExpressionImpl<>(3, repositoryDeleteRelation) //
                    , new RepositoryFieldOnlyExpressionImpl<>(4, repositoryDeleteRelation) //
                ));
        }
        return sqlDeleteExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryDeleteExpression5<RepositoryExecutableConditionsGroup5<DeleteConditionConfig>,
        RepositoryExecutableConditionsGroupLogic5<DeleteConditionConfig>> configure(Consumer<DeleteConfig> configure) {
        if (configure != null) {
            configure.accept(repositoryDeleteRelation.getConfig());
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryOnExpression5<RepositoryDelete6> join(Repository repository) {
        return new RepositorySqlOn5<RepositoryDelete6, DeleteConditionConfig, RepositorySqlDeleteRelation,
            SqlDeleteFromBasicBuilder>(repository, new RepositorySqlDelete6(repositoryDeleteRelation),
                repositoryDeleteRelation);
    }
}
