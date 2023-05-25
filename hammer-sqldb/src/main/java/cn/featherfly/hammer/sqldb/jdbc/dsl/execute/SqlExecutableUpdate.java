
package cn.featherfly.hammer.sqldb.jdbc.dsl.execute;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.common.repository.AliasRepository;
import cn.featherfly.common.repository.IgnorePolicy;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.dsl.execute.ExecutableConditionGroupExpression;
import cn.featherfly.hammer.dsl.execute.ExecutableUpdate;
import cn.featherfly.hammer.dsl.execute.UpdateNumberValue;
import cn.featherfly.hammer.dsl.execute.UpdateNumberValueImpl;
import cn.featherfly.hammer.dsl.execute.UpdateValue;
import cn.featherfly.hammer.dsl.execute.UpdateValueImpl;
import cn.featherfly.hammer.expression.condition.ConditionGroupConfig;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * SqlExecutableUpdate .
 *
 * @author zhongj
 */
public class SqlExecutableUpdate extends AbstractSqlExecutableUpdate<SqlExecutableUpdate>
        implements SqlUpdate, ExecutableUpdate {

    /**
     * Instantiates a new sql executable update.
     *
     * @param tableName tableName
     * @param jdbc      jdbc
     */
    public SqlExecutableUpdate(String tableName, Jdbc jdbc) {
        this(tableName, jdbc, IgnorePolicy.NONE);
    }

    /**
     * Instantiates a new sql executable update.
     *
     * @param tableName    tableName
     * @param jdbc         jdbc
     * @param ignorePolicy the ignore policy
     */
    public SqlExecutableUpdate(String tableName, Jdbc jdbc, Predicate<Object> ignorePolicy) {
        super(tableName, jdbc, ignorePolicy);
    }

    /**
     * Instantiates a new sql executable update.
     *
     * @param tableName    tableName
     * @param tableAlias   the table alias
     * @param jdbc         jdbc
     * @param ignorePolicy the ignore policy
     */
    public SqlExecutableUpdate(String tableName, String tableAlias, Jdbc jdbc, Predicate<Object> ignorePolicy) {
        super(tableName, tableAlias, jdbc, ignorePolicy);
    }

    /**
     * Instantiates a new sql executable update.
     *
     * @param repository the repository
     * @param jdbc       the jdbc
     */
    public SqlExecutableUpdate(Repository repository, Jdbc jdbc) {
        this(repository, jdbc, IgnorePolicy.NONE);
    }

    /**
     * Instantiates a new sql executable update.
     *
     * @param repository   the repository
     * @param jdbc         the jdbc
     * @param ignorePolicy the ignore policy
     */
    public SqlExecutableUpdate(Repository repository, Jdbc jdbc, Predicate<Object> ignorePolicy) {
        this(repository.name(), jdbc, ignorePolicy);
    }

    /**
     * Instantiates a new sql executable update.
     *
     * @param repository the repository
     * @param jdbc       the jdbc
     */
    public SqlExecutableUpdate(AliasRepository repository, Jdbc jdbc) {
        this(repository, jdbc, IgnorePolicy.NONE);
    }

    /**
     * Instantiates a new sql executable update.
     *
     * @param repository   the repository
     * @param jdbc         the jdbc
     * @param ignorePolicy the ignore policy
     */
    public SqlExecutableUpdate(AliasRepository repository, Jdbc jdbc, Predicate<Object> ignorePolicy) {
        this(repository.name(), repository.alias(), jdbc, ignorePolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlExecutableUpdate set(String name, Object value) {
        return _set(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExecutableUpdate set(Supplier<Boolean> whether, String name, Object value) {
        if (Lang.isTrue(whether.get())) {
            return set(name, value);
        } else {
            return this;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> ExecutableUpdate set(SerializableFunction<T, R> name, R value) {
        return _set(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> ExecutableUpdate set(Supplier<Boolean> whether, SerializableFunction<T, R> name, R value) {
        if (Lang.isTrue(whether.get())) {
            return set(name, value);
        } else {
            return this;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> ExecutableUpdate set(SerializableSupplier<R> property) {
        return _set(getPropertyName(property), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> ExecutableUpdate set(Supplier<Boolean> whether, SerializableSupplier<R> property) {
        if (Lang.isTrue(whether.get())) {
            return set(property);
        } else {
            return this;
        }
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
        return _increase(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R extends Number> ExecutableUpdate increase(Supplier<Boolean> whether, SerializableFunction<T, R> name,
            R value) {
        if (Lang.isTrue(whether.get())) {
            return increase(name, value);
        } else {
            return this;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> ExecutableUpdate increase(Supplier<Boolean> whether, String name, N value) {
        if (Lang.isTrue(whether.get())) {
            return increase(name, value);
        } else {
            return this;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R extends Number> ExecutableUpdate increase(SerializableFunction<T, R> name, R value) {
        return _increase(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> ExecutableUpdate increase(SerializableSupplier<N> property) {
        return _increase(getPropertyName(property), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> ExecutableUpdate increase(Supplier<Boolean> whether, SerializableSupplier<N> property) {
        if (Lang.isTrue(whether.get())) {
            return increase(property);
        } else {
            return this;
        }
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
    public ExecutableConditionGroupExpression where() {
        return new SqlUpdateExpression(jdbc, builder);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExecutableConditionGroupExpression where(
            Consumer<ConditionGroupConfig<ExecutableConditionGroupExpression>> consumer) {
        SqlUpdateExpression sqlUpdateExpression = new SqlUpdateExpression(jdbc, builder);
        if (consumer != null) {
            consumer.accept(sqlUpdateExpression);
        }
        return sqlUpdateExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int execute() {
        return new SqlUpdateExpression(jdbc, builder).execute();
    }
}
