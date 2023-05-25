
package cn.featherfly.hammer.sqldb.jdbc.dsl.execute;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

import cn.featherfly.common.bean.BeanDescriptor;
import cn.featherfly.common.bean.BeanUtils;
import cn.featherfly.common.db.FieldValueOperator;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableFunction2;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.common.repository.IgnorePolicy;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.hammer.dsl.execute.EntityExecutableConditionGroupExpression;
import cn.featherfly.hammer.dsl.execute.EntityExecutableConditionGroupLogicExpression;
import cn.featherfly.hammer.dsl.execute.EntityExecutableUpdate;
import cn.featherfly.hammer.dsl.execute.EntityUpdateNestedValueImpl;
import cn.featherfly.hammer.dsl.execute.EntityUpdateNumberValueImpl;
import cn.featherfly.hammer.dsl.execute.EntityUpdateValueImpl;
import cn.featherfly.hammer.expression.condition.ConditionGroupConfig;
import cn.featherfly.hammer.expression.execute.EntityUpdateNumberValueExpression;
import cn.featherfly.hammer.expression.execute.EntityUpdateSetExpression;
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
        this.aliasManager = aliasManager;
        builder.setAlias(this.aliasManager.put(classMapping.getRepositoryName()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    //    public EntityExecutableUpdate<E> set(Consumer<EntityExecutableUpdate<E>> consumer) {
    public EntityExecutableUpdate<E> set(Consumer<EntityUpdateSetExpression<E, EntityExecutableUpdate<E>,
            EntityExecutableConditionGroupExpression<E>, EntityExecutableConditionGroupLogicExpression<E>>> consumer) {
        consumer.accept(this);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityExecutableUpdate<E> set(SerializableFunction<E, R> name, R value) {
        return _set(classMapping.getPropertyMapping(getPropertyName(name)), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityExecutableUpdate<E> set(Supplier<Boolean> whether, SerializableFunction<E, R> property, R value) {
        if (Lang.isTrue(whether.get())) {
            return set(property, value);
        } else {
            return this;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, O> EntityExecutableUpdate<E> set(SerializableFunction<E, R> property,
            SerializableFunction<R, O> nestedProperty, O value) {
        JdbcPropertyMapping pm = classMapping.getPropertyMapping(getPropertyName(property));
        if (value == null) {
            return _set(pm.getRepositoryFieldName(), value);
        }
        String npn = getPropertyName(nestedProperty);
        JdbcPropertyMapping spm = pm.getPropertyMapping(npn);
        return _set(spm, FieldValueOperator.create(spm, value));
        //        if (spm != null) {
        //            return _set(spm, FieldValueOperator.craete(spm, value));
        //        } else {
        //            throw new SqldbHammerException(String.format("can not find mapping for property {0}.{1} for entity {2}",
        //                    pm.getPropertyName(), npn, classMapping.getType().getName()));
        //        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, O> EntityExecutableUpdate<E> set(Supplier<Boolean> whether, SerializableFunction<E, R> property,
            SerializableFunction<R, O> nestedProperty, O value) {
        if (Lang.isTrue(whether.get())) {
            return set(property, nestedProperty, value);
        } else {
            return this;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityExecutableUpdate<E> set(SerializableSupplier<R> property) {
        return _set(classMapping.getPropertyMapping(getPropertyName(property)), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityExecutableUpdate<E> set(Supplier<Boolean> whether, SerializableSupplier<R> property) {
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
    public <R, O> EntityExecutableUpdate<E> set(SerializableSupplier<R> property,
            SerializableFunction<R, O> nestedProperty) {
        JdbcPropertyMapping pm = classMapping.getPropertyMapping(getPropertyName(property));
        if (property.get() == null) {
            return _set(pm.getRepositoryFieldName(), property.get());
        }
        String npn = getPropertyName(nestedProperty);
        JdbcPropertyMapping spm = pm.getPropertyMapping(npn);
        return _set(spm, FieldValueOperator.create(spm, BeanUtils.getProperty(property.get(), npn)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, O> EntityExecutableUpdate<E> set(Supplier<Boolean> whether, SerializableSupplier<R> property,
            SerializableFunction<R, O> nestedProperty) {
        if (Lang.isTrue(whether.get())) {
            return set(property, nestedProperty);
        } else {
            return this;
        }
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
    public <R extends Number> EntityExecutableUpdate<E> increase(Supplier<Boolean> whether,
            SerializableFunction<E, R> property, R value) {
        if (Lang.isTrue(whether.get())) {
            return increase(property, value);
        } else {
            return this;
        }
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
    public <N extends Number> EntityExecutableUpdate<E> increase(Supplier<Boolean> whether,
            SerializableSupplier<N> property) {
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
    public <R> EntityUpdateValueExpression<E, R, EntityExecutableUpdate<E>, EntityExecutableConditionGroupExpression<E>,
            EntityExecutableConditionGroupLogicExpression<E>> property(SerializableFunction<E, R> property) {
        return new EntityUpdateValueImpl<>(property, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R,
            O> EntityUpdateValueExpression<E, O, EntityExecutableUpdate<E>, EntityExecutableConditionGroupExpression<E>,
                    EntityExecutableConditionGroupLogicExpression<E>> property(SerializableFunction<E, R> property,
                            SerializableFunction<R, O> nestedProperty) {
        return new EntityUpdateNestedValueImpl<>(property, nestedProperty, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> EntityUpdateNumberValueExpression<E, R, EntityExecutableUpdate<E>,
            EntityExecutableConditionGroupExpression<E>, EntityExecutableConditionGroupLogicExpression<E>> property(
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

    private SqlEntityExecutableUpdate<E> _set(JdbcPropertyMapping pm, Object value) {
        if (value == null) {
            return _set(pm.getRepositoryFieldName(), value);
        }

        //        if (pm.isEmbeddable()) {
        if (Lang.isNotEmpty(pm.getPropertyMappings())) {
            if (ClassUtils.isParent(pm.getPropertyType(), value.getClass())) {
                BeanDescriptor<?> bd = BeanDescriptor.getBeanDescriptor(value.getClass());
                for (JdbcPropertyMapping spm : pm.getPropertyMappings()) {
                    Object ov = bd.getBeanProperty(spm.getPropertyName()).getValue(value);
                    _set(spm, FieldValueOperator.create(spm, ov));
                }
            } else {
                for (JdbcPropertyMapping spm : pm.getPropertyMappings()) {
                    if (ClassUtils.isParent(spm.getPropertyType(), value.getClass())) {
                        _set(spm, FieldValueOperator.create(spm, value));
                    }
                }
            }
            return this;
        } else {
            return _set(pm.getRepositoryFieldName(), FieldValueOperator.create(pm, value));
        }
    }
}
