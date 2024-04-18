
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.execute;

import java.util.function.Consumer;
import java.util.function.Function;

import cn.featherfly.common.db.builder.dml.basic.SqlDeleteFromBasicBuilder;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.repository.AliasRepository;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.config.dsl.DeleteConfig;
import cn.featherfly.hammer.dsl.execute.ExecutableConditionGroup;
import cn.featherfly.hammer.dsl.execute.ExecutableConditionGroupLogic;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryDelete;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.execute.RepositoryDeleteExpression;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.dsl.execute.SqlDeleteExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlDeleteRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.field.RepositoryFieldOnlyExpressionImpl;

/**
 * sql repository delete .
 *
 * @author zhongj
 */
public class RepositorySqlDelete implements RepositoryDelete {

    private String tableName;

    private RepositorySqlDeleteRelation repositoryDeleteRelation;

    /**
     * Instantiates a new sql delete.
     *
     * @param jdbc         the jdbc
     * @param tableName    the table name
     * @param metadata     the metadata
     * @param deleteConfig the delete config
     */
    public RepositorySqlDelete(Jdbc jdbc, String tableName, DatabaseMetadata metadata, DeleteConfig deleteConfig) {
        this(jdbc, tableName, null, metadata, deleteConfig);
    }

    /**
     * Instantiates a new sql delete.
     *
     * @param jdbc         the jdbc
     * @param tableName    the table name
     * @param aliasManager the alias manager
     * @param metadata     the metadata
     * @param deleteConfig the delete config
     */
    public RepositorySqlDelete(Jdbc jdbc, String tableName, AliasManager aliasManager, DatabaseMetadata metadata,
        DeleteConfig deleteConfig) {
        this.tableName = tableName;
        repositoryDeleteRelation = new RepositorySqlDeleteRelation(jdbc,
            aliasManager == null ? new AliasManager() : aliasManager, metadata, deleteConfig.clone());
    }

    /**
     * Instantiates a new sql delete.
     *
     * @param jdbc         jdbc
     * @param repository   repository
     * @param metadata     the metadata
     * @param deleteConfig the delete config
     */
    public RepositorySqlDelete(Jdbc jdbc, Repository repository, DatabaseMetadata metadata, DeleteConfig deleteConfig) {
        this(jdbc, repository, null, metadata, deleteConfig);
    }

    /**
     * Instantiates a new sql delete.
     *
     * @param jdbc         jdbc
     * @param repository   repository
     * @param aliasManager the alias manager
     * @param metadata     the metadata
     * @param deleteConfig the delete config
     */
    public RepositorySqlDelete(Jdbc jdbc, Repository repository, AliasManager aliasManager, DatabaseMetadata metadata,
        DeleteConfig deleteConfig) {
        this(jdbc, repository.name(), aliasManager, metadata, deleteConfig);
    }

    /**
     * Instantiates a new sql delete.
     *
     * @param jdbc         jdbc
     * @param repository   repository
     * @param metadata     the metadata
     * @param deleteConfig the delete config
     */
    public RepositorySqlDelete(Jdbc jdbc, AliasRepository repository, DatabaseMetadata metadata,
        DeleteConfig deleteConfig) {
        this(jdbc, repository, null, metadata, deleteConfig);
    }

    /**
     * Instantiates a new sql delete.
     *
     * @param jdbc         jdbc
     * @param repository   repository
     * @param aliasManager the alias manager
     * @param metadata     the metadata
     * @param deleteConfig the delete config
     */
    public RepositorySqlDelete(Jdbc jdbc, AliasRepository repository, AliasManager aliasManager,
        DatabaseMetadata metadata, DeleteConfig deleteConfig) {
        tableName = repository.name();
        repositoryDeleteRelation = new RepositorySqlDeleteRelation(jdbc,
            aliasManager == null ? new AliasManager() : aliasManager, metadata, deleteConfig.clone());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExecutableConditionGroup<DeleteConditionConfig> where() {
        Jdbc jdbc = repositoryDeleteRelation.getJdbc();
        return new SqlDeleteExpression(jdbc, new SqlDeleteFromBasicBuilder(jdbc.getDialect(), tableName, "tableAlias"),
            repositoryDeleteRelation, repositoryDeleteRelation.getConfig());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExecutableConditionGroupLogic<DeleteConditionConfig> where(
        Function<RepositoryFieldOnlyExpression, LogicExpression<?, ?>> filterable) {
        SqlDeleteExpression sqlDeleteExpression = (SqlDeleteExpression) where();
        if (filterable != null) {
            // filterable.apply(sqlDeleteExpression);
            sqlDeleteExpression
                .addCondition(filterable.apply(new RepositoryFieldOnlyExpressionImpl<>(0, repositoryDeleteRelation)));
        }
        return sqlDeleteExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryDeleteExpression<ExecutableConditionGroup<DeleteConditionConfig>,
        ExecutableConditionGroupLogic<DeleteConditionConfig>> configure(Consumer<DeleteConfig> configure) {
        if (configure != null) {
            configure.accept(repositoryDeleteRelation.getConfig());
        }
        return this;
    }
}
