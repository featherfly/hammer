
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.execute;

import java.util.function.Consumer;

import cn.featherfly.common.db.builder.dml.basic.SqlDeleteFromBasicBuilder;
import cn.featherfly.common.function.ThreeArgusFunction;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.config.dsl.DeleteConfig;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression3;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryDelete3;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryDelete4;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroup3;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroupLogic3;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.execute.RepositoryDeleteExpression3;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlDeleteRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlOn3;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.field.RepositoryFieldOnlyExpressionImpl;

/**
 * sql repository delete .
 *
 * @author zhongj
 */
public class RepositorySqlDelete3 implements RepositoryDelete3 {

    private RepositorySqlDeleteRelation repositoryDeleteRelation;

    /**
     * Instantiates a new sql delete.
     *
     * @param repositoryDeleteRelation the repository delete relation
     */
    public RepositorySqlDelete3(RepositorySqlDeleteRelation repositoryDeleteRelation) {
        this.repositoryDeleteRelation = repositoryDeleteRelation;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryExecutableConditionsGroup3<DeleteConditionConfig> where() {
        return new RepositorySqlDeleteConditions3(repositoryDeleteRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryExecutableConditionsGroupLogic3<DeleteConditionConfig> where(
        ThreeArgusFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            LogicExpression<?, ?>> filterable) {
        RepositorySqlDeleteConditions3 sqlDeleteExpression = (RepositorySqlDeleteConditions3) where();
        if (filterable != null) {
            // filterable.apply(sqlDeleteExpression);
            sqlDeleteExpression
                .addCondition(filterable.apply(new RepositoryFieldOnlyExpressionImpl<>(0, repositoryDeleteRelation) //
                    , new RepositoryFieldOnlyExpressionImpl<>(1, repositoryDeleteRelation) //
                    , new RepositoryFieldOnlyExpressionImpl<>(2, repositoryDeleteRelation) //
                ));
        }
        return sqlDeleteExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryDeleteExpression3<RepositoryExecutableConditionsGroup3<DeleteConditionConfig>,
        RepositoryExecutableConditionsGroupLogic3<DeleteConditionConfig>> configure(Consumer<DeleteConfig> configure) {
        if (configure != null) {
            configure.accept(repositoryDeleteRelation.getConfig());
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryOnExpression3<RepositoryDelete4> join(Repository repository) {
        return new RepositorySqlOn3<RepositoryDelete4, DeleteConditionConfig, RepositorySqlDeleteRelation,
            SqlDeleteFromBasicBuilder>(repository, new RepositorySqlDelete4(repositoryDeleteRelation),
                repositoryDeleteRelation);
    }
}
