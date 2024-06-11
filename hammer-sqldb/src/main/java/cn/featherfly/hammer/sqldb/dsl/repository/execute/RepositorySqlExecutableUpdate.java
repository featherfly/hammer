
package cn.featherfly.hammer.sqldb.dsl.repository.execute;

import java.io.Serializable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import cn.featherfly.common.db.builder.dml.basic.SqlUpdateSetBasicBuilder;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableNumberSupplier;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.repository.AliasRepository;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.config.dsl.UpdateConfig;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression1;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroup;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroupLogic;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableUpdate;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryUpdate2;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryUpdateNumberValueImpl;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryUpdateValueImpl;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.execute.UpdateNumberValueExpression;
import cn.featherfly.hammer.expression.execute.UpdateValueExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.execute.RepositoryUpdateExpression;
import cn.featherfly.hammer.sqldb.dsl.execute.AbstractSqlExecutableUpdate;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlOn1;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlUpdateRelation;
import cn.featherfly.hammer.sqldb.dsl.repository.condition.field.RepositoryFieldOnlyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * repository sql executable update .
 *
 * @author zhongj
 */
public class RepositorySqlExecutableUpdate extends AbstractSqlExecutableUpdate<RepositorySqlExecutableUpdate>
    implements RepositorySqlUpdate, RepositoryExecutableUpdate {

    /** The update relation. */
    protected RepositorySqlUpdateRelation updateRelation;

    /**
     * Instantiates a new sql executable update.
     *
     * @param tableName tableName
     * @param jdbc jdbc
     * @param aliasManager the alias manager
     * @param databaseMetadata the database metadata
     * @param updateConfig the update config
     */
    public RepositorySqlExecutableUpdate(String tableName, Jdbc jdbc, AliasManager aliasManager,
        DatabaseMetadata databaseMetadata, UpdateConfig updateConfig) {
        this(tableName, null, jdbc, aliasManager, databaseMetadata, updateConfig);
    }

    /**
     * Instantiates a new sql executable update.
     *
     * @param tableName tableName
     * @param tableAlias the table alias
     * @param jdbc jdbc
     * @param aliasManager the alias manager
     * @param databaseMetadata the database metadata
     * @param updateConfig the update config
     */
    public RepositorySqlExecutableUpdate(String tableName, String tableAlias, Jdbc jdbc, AliasManager aliasManager,
        DatabaseMetadata databaseMetadata, UpdateConfig updateConfig) {
        super(tableName, tableAlias, jdbc, aliasManager, updateConfig);
        updateRelation = new RepositorySqlUpdateRelation(jdbc, aliasManager, databaseMetadata, updateConfig)
            .addFilterable(tableName, tableAlias);
        // addFilterable 初始化builder
        builder = updateRelation.getBuilder();
    }

    /**
     * Instantiates a new sql executable update.
     *
     * @param repository the repository
     * @param jdbc the jdbc
     * @param aliasManager the alias manager
     * @param databaseMetadata the database metadata
     * @param updateConfig the update config
     */
    public RepositorySqlExecutableUpdate(Repository repository, Jdbc jdbc, AliasManager aliasManager,
        DatabaseMetadata databaseMetadata, UpdateConfig updateConfig) {
        this(repository.name(), jdbc, aliasManager, databaseMetadata, updateConfig);
    }

    /**
     * Instantiates a new sql executable update.
     *
     * @param repository the repository
     * @param jdbc the jdbc
     * @param aliasManager the alias manager
     * @param databaseMetadata the database metadata
     * @param updateConfig the update config
     */
    public RepositorySqlExecutableUpdate(AliasRepository repository, Jdbc jdbc, AliasManager aliasManager,
        DatabaseMetadata databaseMetadata, UpdateConfig updateConfig) {
        this(repository.name(), repository.alias(), jdbc, aliasManager, databaseMetadata, updateConfig);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <V> RepositorySqlExecutableUpdate set(String name, V value) {
        return set0(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <V> RepositoryExecutableUpdate set(String name, V value, Predicate<V> ignoreStrategy) {
        return set0(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositoryExecutableUpdate set(SerializableFunction<T, R> name, R value) {
        return set0(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositoryExecutableUpdate set(SerializableFunction<T, R> name, R value,
        Predicate<R> ignoreStrategy) {
        return set0(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> RepositoryExecutableUpdate set(SerializableSupplier<R> property) {
        return set0(getPropertyName(property), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> RepositoryExecutableUpdate set(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return set0(getPropertyName(property), property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryExecutableUpdate set(Consumer<RepositoryExecutableUpdate> consumer) {
        consumer.accept(this);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> RepositorySqlExecutableUpdate increase(String name, N value) {
        return increase0(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> RepositoryExecutableUpdate increase(SerializableFunction<T, N> name, N value,
        Predicate<N> ignoreStrategy) {
        return increase0(getPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> RepositoryExecutableUpdate increase(String name, N value, Predicate<N> ignoreStrategy) {
        return increase0(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R extends Number> RepositoryExecutableUpdate increase(SerializableFunction<T, R> name, R value) {
        return increase0(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> RepositoryExecutableUpdate increase(SerializableNumberSupplier<N> property) {
        return increase0(getPropertyName(property), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> RepositoryExecutableUpdate increase(SerializableNumberSupplier<N> property,
        Predicate<N> ignoreStrategy) {
        return increase0(getPropertyName(property), property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UpdateValueExpression<Serializable, RepositoryExecutableUpdate,
        RepositoryExecutableConditionsGroup<UpdateConditionConfig>,
        RepositoryExecutableConditionsGroupLogic<UpdateConditionConfig>> field(String name) {
        return new RepositoryUpdateValueImpl<>(name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UpdateNumberValueExpression<Number, RepositoryExecutableUpdate,
        RepositoryExecutableConditionsGroup<UpdateConditionConfig>,
        RepositoryExecutableConditionsGroupLogic<UpdateConditionConfig>> fieldAsNumber(String name) {
        return new RepositoryUpdateNumberValueImpl<>(name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T,
        R extends Serializable> UpdateValueExpression<R, RepositoryExecutableUpdate,
            RepositoryExecutableConditionsGroup<UpdateConditionConfig>,
            RepositoryExecutableConditionsGroupLogic<UpdateConditionConfig>> field(SerializableFunction<T, R> name) {
        return new RepositoryUpdateValueImpl<>(LambdaUtils.getLambdaPropertyName(name), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T,
        R extends Number> UpdateNumberValueExpression<R, RepositoryExecutableUpdate,
            RepositoryExecutableConditionsGroup<UpdateConditionConfig>,
            RepositoryExecutableConditionsGroupLogic<UpdateConditionConfig>> fieldAsNumber(
                SerializableFunction<T, R> name) {
        return new RepositoryUpdateNumberValueImpl<>(LambdaUtils.getLambdaPropertyName(name), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryExecutableConditionsGroup<UpdateConditionConfig> where() {
        return new RepositorySqlUpdateConditions(updateRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryExecutableConditionsGroupLogic<UpdateConditionConfig> where(
        Function<RepositoryFieldOnlyExpression, LogicExpression<?, ?>> filterable) {
        RepositorySqlUpdateConditions sqlUpdateExpression = new RepositorySqlUpdateConditions(updateRelation);
        if (filterable != null) {
            //filterable.apply(sqlUpdateExpression);
            sqlUpdateExpression
                .addCondition(filterable.apply(new RepositoryFieldOnlyExpressionImpl<>(0, updateRelation)));
        }
        return sqlUpdateExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int execute() {
        return new RepositorySqlUpdateConditions(updateRelation).execute();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryUpdateExpression<RepositoryExecutableUpdate,
        RepositoryExecutableConditionsGroup<UpdateConditionConfig>,
        RepositoryExecutableConditionsGroupLogic<UpdateConditionConfig>> configure(Consumer<UpdateConfig> configure) {
        if (configure != null) {
            configure.accept(updateConfig);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryOnExpression1<RepositoryUpdate2> join(Repository repository) {
        return new RepositorySqlOn1<RepositoryUpdate2, UpdateConditionConfig, RepositorySqlUpdateRelation,
            SqlUpdateSetBasicBuilder>(repository, new RepositorySqlExecutableUpdate2(this), updateRelation);
    }

}
