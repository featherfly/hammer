
package cn.featherfly.hammer.sqldb.jdbc.dsl.execute;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.repository.AliasRepository;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.config.dsl.UpdateConfig;
import cn.featherfly.hammer.dsl.execute.ExecutableConditionGroup;
import cn.featherfly.hammer.dsl.execute.ExecutableConditionGroupLogic;
import cn.featherfly.hammer.dsl.execute.ExecutableUpdate;
import cn.featherfly.hammer.dsl.execute.UpdateNumberValue;
import cn.featherfly.hammer.dsl.execute.UpdateNumberValueImpl;
import cn.featherfly.hammer.dsl.execute.UpdateValue;
import cn.featherfly.hammer.dsl.execute.UpdateValueImpl;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.execute.UpdateExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlUpdateRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.field.RepositoryFieldOnlyExpressionImpl;

/**
 * SqlExecutableUpdate .
 *
 * @author zhongj
 */
public class SqlExecutableUpdate extends AbstractSqlExecutableUpdate<SqlExecutableUpdate>
    implements SqlUpdate, ExecutableUpdate {

    protected RepositorySqlUpdateRelation repositoryRelation;

    /**
     * Instantiates a new sql executable update.
     *
     * @param tableName      tableName
     * @param jdbc           jdbc
     * @param aliasManager   the alias manager
     * @param updateRelation the update relation
     * @param updateConfig   the update config
     */
    public SqlExecutableUpdate(String tableName, Jdbc jdbc, AliasManager aliasManager,
        DatabaseMetadata databaseMetadata, UpdateConfig updateConfig) {
        this(tableName, null, jdbc, aliasManager, databaseMetadata, updateConfig);
    }

    /**
     * Instantiates a new sql executable update.
     *
     * @param tableName      tableName
     * @param tableAlias     the table alias
     * @param jdbc           jdbc
     * @param aliasManager   the alias manager
     * @param updateRelation the update relation
     * @param updateConfig   the update config
     */
    public SqlExecutableUpdate(String tableName, String tableAlias, Jdbc jdbc, AliasManager aliasManager,
        DatabaseMetadata databaseMetadata, UpdateConfig updateConfig) {
        super(tableName, tableAlias, jdbc, aliasManager, updateConfig);
        repositoryRelation = new RepositorySqlUpdateRelation(jdbc, aliasManager, databaseMetadata, updateConfig);
    }

    /**
     * Instantiates a new sql executable update.
     *
     * @param repository     the repository
     * @param jdbc           the jdbc
     * @param aliasManager   the alias manager
     * @param updateRelation the update relation
     * @param updateConfig   the update config
     */
    public SqlExecutableUpdate(Repository repository, Jdbc jdbc, AliasManager aliasManager,
        DatabaseMetadata databaseMetadata, UpdateConfig updateConfig) {
        this(repository.name(), jdbc, aliasManager, databaseMetadata, updateConfig);
    }

    /**
     * Instantiates a new sql executable update.
     *
     * @param repository     the repository
     * @param jdbc           the jdbc
     * @param aliasManager   the alias manager
     * @param updateRelation the update relation
     * @param updateConfig   the update config
     */
    public SqlExecutableUpdate(AliasRepository repository, Jdbc jdbc, AliasManager aliasManager,
        DatabaseMetadata databaseMetadata, UpdateConfig updateConfig) {
        this(repository.name(), repository.alias(), jdbc, aliasManager, databaseMetadata, updateConfig);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlExecutableUpdate set(String name, Object value) {
        return set0(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExecutableUpdate set(String name, Object value, Predicate<Object> ignoreStrategy) {
        return set0(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> ExecutableUpdate set(SerializableFunction<T, R> name, R value) {
        return set0(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> ExecutableUpdate set(SerializableFunction<T, R> name, R value, Predicate<R> ignoreStrategy) {
        return set0(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> ExecutableUpdate set(SerializableSupplier<R> property) {
        return set0(getPropertyName(property), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> ExecutableUpdate set(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return set0(getPropertyName(property), property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExecutableUpdate set(Consumer<ExecutableUpdate> consumer) {
        consumer.accept(this);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> SqlExecutableUpdate increase(String name, N value) {
        return increase0(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> ExecutableUpdate increase(SerializableFunction<T, N> name, N value,
        Predicate<N> ignoreStrategy) {
        return increase0(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> ExecutableUpdate increase(String name, N value, Predicate<N> ignoreStrategy) {
        return increase0(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R extends Number> ExecutableUpdate increase(SerializableFunction<T, R> name, R value) {
        return increase0(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> ExecutableUpdate increase(SerializableSupplier<N> property) {
        return increase0(getPropertyName(property), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> ExecutableUpdate increase(SerializableSupplier<N> property, Predicate<N> ignoreStrategy) {
        return increase0(getPropertyName(property), property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UpdateValue property(String name) {
        return new UpdateValueImpl(name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UpdateNumberValue propertyNumber(String name) {
        return new UpdateNumberValueImpl(name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UpdateValue property(SerializableFunction<T, R> name) {
        return property(LambdaUtils.getLambdaPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R extends Number> UpdateNumberValue propertyNumber(SerializableFunction<T, R> name) {
        return propertyNumber(LambdaUtils.getLambdaPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExecutableConditionGroup<UpdateConditionConfig> where() {
        return new SqlUpdateExpression(jdbc, builder, repositoryRelation, updateConfig);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExecutableConditionGroupLogic<UpdateConditionConfig> where(
        Function<RepositoryFieldOnlyExpression, LogicExpression<?, ?>> filterable) {
        SqlUpdateExpression sqlUpdateExpression = new SqlUpdateExpression(jdbc, builder, repositoryRelation,
            updateConfig);
        if (filterable != null) {
            //filterable.apply(sqlUpdateExpression);
            sqlUpdateExpression
                .addCondition(filterable.apply(new RepositoryFieldOnlyExpressionImpl<>(0, repositoryRelation)));
        }
        return sqlUpdateExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int execute() {
        return new SqlUpdateExpression(jdbc, builder, repositoryRelation, updateConfig).execute();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UpdateExpression<ExecutableUpdate, ExecutableConditionGroup<UpdateConditionConfig>,
        ExecutableConditionGroupLogic<UpdateConditionConfig>, UpdateValue, UpdateNumberValue> configure(
            Consumer<UpdateConfig> configure) {
        if (configure != null) {
            configure.accept(updateConfig);
        }
        return this;
    }
}
