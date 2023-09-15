
package cn.featherfly.hammer.sqldb.jdbc.dsl.execute;

import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.repository.AliasRepository;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.dsl.execute.ExecutableConditionGroup;
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
        this(tableName, jdbc, IgnoreStrategy.NONE);
    }

    /**
     * Instantiates a new sql executable update.
     *
     * @param tableName      tableName
     * @param jdbc           jdbc
     * @param ignoreStrategy the ignore strategy
     */
    public SqlExecutableUpdate(String tableName, Jdbc jdbc, Predicate<?> ignoreStrategy) {
        super(tableName, jdbc, ignoreStrategy);
    }

    /**
     * Instantiates a new sql executable update.
     *
     * @param tableName      tableName
     * @param tableAlias     the table alias
     * @param jdbc           jdbc
     * @param ignoreStrategy the ignore strategy
     */
    public SqlExecutableUpdate(String tableName, String tableAlias, Jdbc jdbc, Predicate<?> ignoreStrategy) {
        super(tableName, tableAlias, jdbc, ignoreStrategy);
    }

    /**
     * Instantiates a new sql executable update.
     *
     * @param repository the repository
     * @param jdbc       the jdbc
     */
    public SqlExecutableUpdate(Repository repository, Jdbc jdbc) {
        this(repository, jdbc, IgnoreStrategy.NONE);
    }

    /**
     * Instantiates a new sql executable update.
     *
     * @param repository     the repository
     * @param jdbc           the jdbc
     * @param ignoreStrategy the ignore strategy
     */
    public SqlExecutableUpdate(Repository repository, Jdbc jdbc, Predicate<?> ignoreStrategy) {
        this(repository.name(), jdbc, ignoreStrategy);
    }

    /**
     * Instantiates a new sql executable update.
     *
     * @param repository the repository
     * @param jdbc       the jdbc
     */
    public SqlExecutableUpdate(AliasRepository repository, Jdbc jdbc) {
        this(repository, jdbc, IgnoreStrategy.NONE);
    }

    /**
     * Instantiates a new sql executable update.
     *
     * @param repository     the repository
     * @param jdbc           the jdbc
     * @param ignoreStrategy the ignore strategy
     */
    public SqlExecutableUpdate(AliasRepository repository, Jdbc jdbc, Predicate<?> ignoreStrategy) {
        this(repository.name(), repository.alias(), jdbc, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlExecutableUpdate set(String name, Object value) {
        // ENHANCE 后续使用FieldValueOperator，需要完善基础JavaTypeSqlTypeOperator类型
        return _set(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExecutableUpdate set(BooleanSupplier setable, String name, Object value) {
        if (setable.getAsBoolean()) {
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
        // ENHANCE 后续使用FieldValueOperator，需要完善基础JavaTypeSqlTypeOperator类型
        return _set(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> ExecutableUpdate set(BooleanSupplier setable, SerializableFunction<T, R> name, R value) {
        if (setable.getAsBoolean()) {
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
        // ENHANCE 后续使用FieldValueOperator，需要完善基础JavaTypeSqlTypeOperator类型
        return _set(getPropertyName(property), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> ExecutableUpdate set(BooleanSupplier setable, SerializableSupplier<R> property) {
        if (setable.getAsBoolean()) {
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
        // ENHANCE 后续使用FieldValueOperator，需要完善基础JavaTypeSqlTypeOperator类型
        return _increase(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R extends Number> ExecutableUpdate increase(BooleanSupplier setable, SerializableFunction<T, R> name,
            R value) {
        if (setable.getAsBoolean()) {
            return increase(name, value);
        } else {
            return this;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> ExecutableUpdate increase(BooleanSupplier increaseable, String name, N value) {
        if (increaseable.getAsBoolean()) {
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
        // ENHANCE 后续使用FieldValueOperator，需要完善基础JavaTypeSqlTypeOperator类型
        return _increase(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> ExecutableUpdate increase(SerializableSupplier<N> property) {
        // ENHANCE 后续使用FieldValueOperator，需要完善基础JavaTypeSqlTypeOperator类型
        return _increase(getPropertyName(property), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> ExecutableUpdate increase(BooleanSupplier increaseable,
            SerializableSupplier<N> property) {
        if (increaseable.getAsBoolean()) {
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
    public ExecutableConditionGroup where() {
        return new SqlUpdateExpression(jdbc, builder);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExecutableConditionGroup where(Consumer<ConditionGroupConfig<ExecutableConditionGroup>> consumer) {
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
