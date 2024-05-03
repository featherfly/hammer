
package cn.featherfly.hammer.sqldb.dsl.repository.execute;

import java.util.function.Consumer;

import cn.featherfly.common.db.builder.dml.basic.SqlDeleteFromBasicBuilder;
import cn.featherfly.common.function.FourArgusFunction;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.config.dsl.DeleteConfig;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression4;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryDelete4;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryDelete5;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroup4;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroupLogic4;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.execute.RepositoryDeleteExpression4;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlDeleteRelation;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlOn4;
import cn.featherfly.hammer.sqldb.dsl.repository.condition.field.RepositoryFieldOnlyExpressionImpl;

/**
 * sql repository delete .
 *
 * @author zhongj
 */
public class RepositorySqlDelete4 implements RepositoryDelete4 {

    private RepositorySqlDeleteRelation repositoryDeleteRelation;

    /**
     * Instantiates a new sql delete.
     *
     * @param repositoryDeleteRelation the repository delete relation
     */
    public RepositorySqlDelete4(RepositorySqlDeleteRelation repositoryDeleteRelation) {
        this.repositoryDeleteRelation = repositoryDeleteRelation;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryExecutableConditionsGroup4<DeleteConditionConfig> where() {
        return new RepositorySqlDeleteConditions4(repositoryDeleteRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryExecutableConditionsGroupLogic4<DeleteConditionConfig> where(
        FourArgusFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            RepositoryFieldOnlyExpression, LogicExpression<?, ?>> filterable) {
        RepositorySqlDeleteConditions4 sqlDeleteExpression = (RepositorySqlDeleteConditions4) where();
        if (filterable != null) {
            // filterable.apply(sqlDeleteExpression);
            sqlDeleteExpression
                .addCondition(filterable.apply(new RepositoryFieldOnlyExpressionImpl<>(0, repositoryDeleteRelation) //
                    , new RepositoryFieldOnlyExpressionImpl<>(1, repositoryDeleteRelation) //
                    , new RepositoryFieldOnlyExpressionImpl<>(2, repositoryDeleteRelation) //
                    , new RepositoryFieldOnlyExpressionImpl<>(3, repositoryDeleteRelation) //
                ));
        }
        return sqlDeleteExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryDeleteExpression4<RepositoryExecutableConditionsGroup4<DeleteConditionConfig>,
        RepositoryExecutableConditionsGroupLogic4<DeleteConditionConfig>> configure(Consumer<DeleteConfig> configure) {
        if (configure != null) {
            configure.accept(repositoryDeleteRelation.getConfig());
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryOnExpression4<RepositoryDelete5> join(Repository repository) {
        return new RepositorySqlOn4<RepositoryDelete5, DeleteConditionConfig, RepositorySqlDeleteRelation,
            SqlDeleteFromBasicBuilder>(repository, new RepositorySqlDelete5(repositoryDeleteRelation),
                repositoryDeleteRelation);
    }
}
