
package cn.featherfly.hammer.sqldb.dsl.repository.execute;

import java.util.function.BiFunction;
import java.util.function.Consumer;

import cn.featherfly.common.db.builder.dml.basic.SqlDeleteFromBasicBuilder;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.config.dsl.DeleteConfig;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression2;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryDelete2;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryDelete3;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroup2;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroupLogic2;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.execute.RepositoryDeleteExpression2;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlDeleteRelation;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlOn2;
import cn.featherfly.hammer.sqldb.dsl.repository.condition.field.RepositoryFieldOnlyExpressionImpl;

/**
 * sql repository delete .
 *
 * @author zhongj
 */
public class RepositorySqlDelete2 implements RepositoryDelete2 {

    private RepositorySqlDeleteRelation repositoryDeleteRelation;

    /**
     * Instantiates a new sql delete.
     *
     * @param repositoryDeleteRelation the repository delete relation
     */
    public RepositorySqlDelete2(RepositorySqlDeleteRelation repositoryDeleteRelation) {
        this.repositoryDeleteRelation = repositoryDeleteRelation;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryExecutableConditionsGroup2<DeleteConditionConfig> where() {
        return new RepositorySqlDeleteConditions2(repositoryDeleteRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryExecutableConditionsGroupLogic2<DeleteConditionConfig> where(
        BiFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, LogicExpression<?, ?>> filterable) {
        RepositorySqlDeleteConditions2 sqlDeleteExpression = (RepositorySqlDeleteConditions2) where();
        if (filterable != null) {
            // filterable.apply(sqlDeleteExpression);
            sqlDeleteExpression
                .addCondition(filterable.apply(new RepositoryFieldOnlyExpressionImpl<>(0, repositoryDeleteRelation),
                    new RepositoryFieldOnlyExpressionImpl<>(1, repositoryDeleteRelation)));
        }
        return sqlDeleteExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryDeleteExpression2<RepositoryExecutableConditionsGroup2<DeleteConditionConfig>,
        RepositoryExecutableConditionsGroupLogic2<DeleteConditionConfig>> configure(Consumer<DeleteConfig> configure) {
        if (configure != null) {
            configure.accept(repositoryDeleteRelation.getConfig());
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryOnExpression2<RepositoryDelete3> join(Repository repository) {
        return new RepositorySqlOn2<RepositoryDelete3, DeleteConditionConfig, RepositorySqlDeleteRelation,
            SqlDeleteFromBasicBuilder>(repository, new RepositorySqlDelete3(repositoryDeleteRelation),
                repositoryDeleteRelation);
    }
}
