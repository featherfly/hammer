
package cn.featherfly.hammer.sqldb.dsl.repository.execute;

import java.util.function.Consumer;

import cn.featherfly.common.function.SixArgusFunction;
import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.config.dsl.DeleteConfig;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryDelete6;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroup6;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroupLogic6;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.execute.RepositoryDeleteExpression6;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlDeleteRelation;
import cn.featherfly.hammer.sqldb.dsl.repository.condition.field.RepositoryFieldOnlyExpressionImpl;

/**
 * sql repository delete .
 *
 * @author zhongj
 */
public class RepositorySqlDelete6 implements RepositoryDelete6 {

    private RepositorySqlDeleteRelation repositoryDeleteRelation;

    /**
     * Instantiates a new sql delete.
     *
     * @param repositoryDeleteRelation the repository delete relation
     */
    public RepositorySqlDelete6(RepositorySqlDeleteRelation repositoryDeleteRelation) {
        this.repositoryDeleteRelation = repositoryDeleteRelation;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryExecutableConditionsGroup6<DeleteConditionConfig> where() {
        return new RepositorySqlDeleteConditions6(repositoryDeleteRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryExecutableConditionsGroupLogic6<DeleteConditionConfig> where(
        SixArgusFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            LogicExpression<?, ?>> filterable) {
        RepositorySqlDeleteConditions6 sqlDeleteExpression = (RepositorySqlDeleteConditions6) where();
        if (filterable != null) {
            // filterable.apply(sqlDeleteExpression);
            sqlDeleteExpression
                .addCondition(filterable.apply(new RepositoryFieldOnlyExpressionImpl<>(0, repositoryDeleteRelation) //
                    , new RepositoryFieldOnlyExpressionImpl<>(1, repositoryDeleteRelation) //
                    , new RepositoryFieldOnlyExpressionImpl<>(2, repositoryDeleteRelation) //
                    , new RepositoryFieldOnlyExpressionImpl<>(3, repositoryDeleteRelation) //
                    , new RepositoryFieldOnlyExpressionImpl<>(4, repositoryDeleteRelation) //
                    , new RepositoryFieldOnlyExpressionImpl<>(5, repositoryDeleteRelation) //
                ));
        }
        return sqlDeleteExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryDeleteExpression6<RepositoryExecutableConditionsGroup6<DeleteConditionConfig>,
        RepositoryExecutableConditionsGroupLogic6<DeleteConditionConfig>> configure(Consumer<DeleteConfig> configure) {
        if (configure != null) {
            configure.accept(repositoryDeleteRelation.getConfig());
        }
        return this;
    }
}
