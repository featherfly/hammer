
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
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression1;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryDelete;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryDelete2;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroup;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroupLogic;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.execute.RepositoryDeleteExpression;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlDeleteRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlOn1;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.field.RepositoryFieldOnlyExpressionImpl;

/**
 * sql repository delete .
 *
 * @author zhongj
 */
public class RepositorySqlDelete implements RepositoryDelete {

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
        this(jdbc, tableName, null, aliasManager, metadata, deleteConfig);
    }

    /**
     * Instantiates a new repository sql delete.
     *
     * @param jdbc         the jdbc
     * @param tableName    the table name
     * @param tableAlias   the table alias
     * @param aliasManager the alias manager
     * @param metadata     the metadata
     * @param deleteConfig the delete config
     */
    public RepositorySqlDelete(Jdbc jdbc, String tableName, String tableAlias, AliasManager aliasManager,
        DatabaseMetadata metadata, DeleteConfig deleteConfig) {
        if (aliasManager == null) {
            aliasManager = new AliasManager();
        }
        //        if (Lang.isNotEmpty(tableAlias)) {
        //            aliasManager.put(tableName, tableAlias);
        //        } else {
        //            aliasManager.put(tableName);
        //        }
        repositoryDeleteRelation = new RepositorySqlDeleteRelation(jdbc, aliasManager, metadata, deleteConfig.clone())
            .addFilterable(tableName, tableAlias);
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
        this(jdbc, repository.name(), null, aliasManager, metadata, deleteConfig);
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
        this(jdbc, repository.name(), repository.alias(), aliasManager, metadata, deleteConfig);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryExecutableConditionsGroup<DeleteConditionConfig> where() {
        return new RepositorySqlDeleteConditions(repositoryDeleteRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryExecutableConditionsGroupLogic<DeleteConditionConfig> where(
        Function<RepositoryFieldOnlyExpression, LogicExpression<?, ?>> filterable) {
        RepositorySqlDeleteConditions sqlDeleteExpression = (RepositorySqlDeleteConditions) where();
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
    public RepositoryDeleteExpression<RepositoryExecutableConditionsGroup<DeleteConditionConfig>,
        RepositoryExecutableConditionsGroupLogic<DeleteConditionConfig>> configure(Consumer<DeleteConfig> configure) {
        if (configure != null) {
            configure.accept(repositoryDeleteRelation.getConfig());
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryOnExpression1<RepositoryDelete2> join(Repository repository) {
        return new RepositorySqlOn1<RepositoryDelete2, DeleteConditionConfig, RepositorySqlDeleteRelation,
            SqlDeleteFromBasicBuilder>(repository, new RepositorySqlDelete2(repositoryDeleteRelation),
                repositoryDeleteRelation);
    }
}
