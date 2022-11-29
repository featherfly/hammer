
package cn.featherfly.hammer.sqldb.jdbc.dsl.execute;

import java.util.function.Consumer;
import java.util.function.Predicate;

import cn.featherfly.common.db.FieldValueOperator;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableFunction2;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.common.repository.IgnorePolicy;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.hammer.dsl.execute.EntityExecutableConditionGroupExpression;
import cn.featherfly.hammer.dsl.execute.EntityExecutableConditionGroupLogicExpression;
import cn.featherfly.hammer.dsl.execute.EntityExecutableUpdate;
import cn.featherfly.hammer.dsl.execute.EntityUpdateNumberValueImpl;
import cn.featherfly.hammer.dsl.execute.EntityUpdateValueImpl;
import cn.featherfly.hammer.expression.condition.ConditionGroupConfig;
import cn.featherfly.hammer.expression.execute.EntityUpdateNumberValueExpression;
import cn.featherfly.hammer.expression.execute.EntityUpdateValueExpression;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * sql entity executable update .
 *
 * @author zhongj
 * @param <E> the element type
 */
public class SqlEntityExecutableUpdate<E> extends AbstractSqlExecutableUpdate<SqlEntityExecutableUpdate<E>>
        implements SqlEntityUpdate<E>, EntityExecutableUpdate<E> {

    private JdbcClassMapping<E> classMapping;

    private JdbcMappingFactory factory;

    private AliasManager aliasManager;

    /**
     * Instantiates a new sql entity executable update.
     *
     * @param jdbc         the jdbc
     * @param classMapping the class mapping
     * @param factory      the factory
     */
    public SqlEntityExecutableUpdate(Jdbc jdbc, JdbcClassMapping<E> classMapping, JdbcMappingFactory factory) {
        this(jdbc, classMapping, factory, new AliasManager());
    }

    /**
     * Instantiates a new sql entity executable update.
     *
     * @param jdbc         the jdbc
     * @param classMapping the class mapping
     * @param factory      the factory
     * @param aliasManager the alias manager
     */
    public SqlEntityExecutableUpdate(Jdbc jdbc, JdbcClassMapping<E> classMapping, JdbcMappingFactory factory,
            AliasManager aliasManager) {
        this(jdbc, classMapping, factory, aliasManager, IgnorePolicy.NONE);
    }

    /**
     * Instantiates a new sql entity executable update.
     *
     * @param jdbc         the jdbc
     * @param classMapping the class mapping
     * @param factory      the factory
     * @param aliasManager the alias manager
     * @param ignorePolicy the ignore policy
     */
    public SqlEntityExecutableUpdate(Jdbc jdbc, JdbcClassMapping<E> classMapping, JdbcMappingFactory factory,
            AliasManager aliasManager, Predicate<Object> ignorePolicy) {
        super(classMapping.getRepositoryName(), jdbc, ignorePolicy);
        this.classMapping = classMapping;
        this.factory = factory;
        if (aliasManager == null) {
            this.aliasManager = new AliasManager();
        } else {
            this.aliasManager = aliasManager;
        }
        builder.setAlias(this.aliasManager.put(classMapping.getRepositoryName()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityExecutableUpdate<E> set(SerializableFunction<E, R> name, R value) {
        JdbcPropertyMapping pm = classMapping.getPropertyMapping(getPropertyName(name));
        return _set(pm.getRepositoryFieldName(), FieldValueOperator.craete(pm, value));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityExecutableUpdate<E> set(SerializableSupplier<R> property) {
        JdbcPropertyMapping pm = classMapping.getPropertyMapping(getPropertyName(property));
        return _set(pm.getRepositoryFieldName(), FieldValueOperator.craete(pm, property.get()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityExecutableUpdate<E> set(Consumer<EntityExecutableUpdate<E>> consumer) {
        consumer.accept(this);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> EntityExecutableUpdate<E> increase(SerializableFunction<E, R> name, R value) {
        // YUFEI_TODO 这里没有实现参数转换为FieldValueOperator
        JdbcPropertyMapping pm = classMapping.getPropertyMapping(getPropertyName(name));
        return _increase(pm.getRepositoryFieldName(), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> EntityExecutableUpdate<E> increase(SerializableSupplier<N> property) {
        // YUFEI_TODO 这里没有实现参数转换为FieldValueOperator
        JdbcPropertyMapping pm = classMapping.getPropertyMapping(getPropertyName(property));
        return _increase(pm.getRepositoryFieldName(), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityUpdateValueExpression<E, R, EntityExecutableUpdate<E>, EntityExecutableConditionGroupExpression<E>, EntityExecutableConditionGroupLogicExpression<E>> property(
            SerializableFunction<E, R> name) {
        return new EntityUpdateValueImpl<>(name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> EntityUpdateNumberValueExpression<E, R, EntityExecutableUpdate<E>, EntityExecutableConditionGroupExpression<E>, EntityExecutableConditionGroupLogicExpression<E>> property(
            SerializableFunction2<E, R> name) {
        return new EntityUpdateNumberValueImpl<>(name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityExecutableConditionGroupExpression<E> where() {
        return new SqlEntityUpdateExpression<>(jdbc, builder, classMapping, factory, aliasManager);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityExecutableConditionGroupExpression<E> where(
            Consumer<ConditionGroupConfig<EntityExecutableConditionGroupExpression<E>>> consumer) {
        SqlEntityUpdateExpression<E> sqlUpdateExpression = new SqlEntityUpdateExpression<>(jdbc, builder, classMapping,
                factory, aliasManager);
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
        return new SqlEntityUpdateExpression<>(jdbc, builder, classMapping, factory, aliasManager).execute();
    }
}
