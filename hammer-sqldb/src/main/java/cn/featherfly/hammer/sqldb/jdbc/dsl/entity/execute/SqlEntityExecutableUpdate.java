
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.execute;

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
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroup;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroupLogic;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableUpdate;
import cn.featherfly.hammer.dsl.entity.execute.EntityUpdateNestedValueImpl;
import cn.featherfly.hammer.dsl.entity.execute.EntityUpdateNumberValueImpl;
import cn.featherfly.hammer.dsl.entity.execute.EntityUpdateValueImpl;
import cn.featherfly.hammer.expression.condition.ConditionGroupConfig;
import cn.featherfly.hammer.expression.entity.execute.EntityUpdateNumberValueExpression;
import cn.featherfly.hammer.expression.entity.execute.EntityUpdateSetExpression;
import cn.featherfly.hammer.expression.entity.execute.EntityUpdateValueExpression;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlUpdateRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.execute.AbstractSqlExecutableUpdate;

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

    //    private AliasManager aliasManager;

    private EntitySqlUpdateRelation relation;

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
        this(jdbc, classMapping, factory, aliasManager, IgnoreStrategy.EMPTY);
    }

    /**
     * Instantiates a new sql entity executable update.
     *
     * @param jdbc           the jdbc
     * @param classMapping   the class mapping
     * @param factory        the factory
     * @param aliasManager   the alias manager
     * @param ignoreStrategy the ignore strategy
     */
    public SqlEntityExecutableUpdate(Jdbc jdbc, JdbcClassMapping<E> classMapping, JdbcMappingFactory factory,
            AliasManager aliasManager, Predicate<?> ignoreStrategy) {
        this(jdbc, classMapping, factory, aliasManager, ignoreStrategy, IgnoreStrategy.NONE);
    }

    /**
     * Instantiates a new sql entity executable update.
     *
     * @param jdbc              the jdbc
     * @param classMapping      the class mapping
     * @param factory           the factory
     * @param aliasManager      the alias manager
     * @param ignoreStrategy    the ignore strategy
     * @param setIgnoreStrategy the set ignore strategy
     */
    public SqlEntityExecutableUpdate(Jdbc jdbc, JdbcClassMapping<E> classMapping, JdbcMappingFactory factory,
            AliasManager aliasManager, Predicate<?> ignoreStrategy, Predicate<?> setIgnoreStrategy) {
        super(classMapping.getRepositoryName(), jdbc, ignoreStrategy);
        this.classMapping = classMapping;
        this.factory = factory;
        //        this.aliasManager = aliasManager;
        //        builder.setAlias(this.aliasManager.put(classMapping.getRepositoryName()));

        relation = new EntitySqlUpdateRelation(jdbc, aliasManager, ignoreStrategy, setIgnoreStrategy)
                .addFilterable(classMapping);
        builder = relation.getBuilder();

    }

    /**
     * {@inheritDoc}
     */
    @Override
    //    public EntityExecutableUpdate<E> set(Consumer<EntityExecutableUpdate<E>> consumer) {
    public EntityExecutableUpdate<E> set(Consumer<EntityUpdateSetExpression<E, EntityExecutableUpdate<E>,
            EntityExecutableConditionGroup<E>, EntityExecutableConditionGroupLogic<E>>> consumer) {
        consumer.accept(this);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityExecutableUpdate<E> set(SerializableFunction<E, R> name, R value) {
        return set0(classMapping.getPropertyMapping(getPropertyName(name)), value);
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
            return set0(pm, value);
        }
        String npn = getPropertyName(nestedProperty);
        JdbcPropertyMapping spm = pm.getPropertyMapping(npn);
        return set0(spm, FieldValueOperator.create(spm, value));
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
        return set0(classMapping.getPropertyMapping(getPropertyName(property)), property.get());
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
            return set0(pm, property.get());
        }
        String npn = getPropertyName(nestedProperty);
        JdbcPropertyMapping spm = pm.getPropertyMapping(npn);
        return set0(spm, FieldValueOperator.create(spm, BeanUtils.getProperty(property.get(), npn)));
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
        JdbcPropertyMapping pm = classMapping.getPropertyMapping(getPropertyName(name));
        return _increase(pm.getRepositoryFieldName(), FieldValueOperator.create(pm, value));
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
        JdbcPropertyMapping pm = classMapping.getPropertyMapping(getPropertyName(property));
        return _increase(pm.getRepositoryFieldName(), FieldValueOperator.create(pm, property.get()));
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
    public <R> EntityUpdateValueExpression<E, R, EntityExecutableUpdate<E>, EntityExecutableConditionGroup<E>,
            EntityExecutableConditionGroupLogic<E>> property(SerializableFunction<E, R> property) {
        return new EntityUpdateValueImpl<>(property, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R,
            O> EntityUpdateValueExpression<E, O, EntityExecutableUpdate<E>, EntityExecutableConditionGroup<E>,
                    EntityExecutableConditionGroupLogic<E>> property(SerializableFunction<E, R> property,
                            SerializableFunction<R, O> nestedProperty) {
        return new EntityUpdateNestedValueImpl<>(property, nestedProperty, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> EntityUpdateNumberValueExpression<E, R, EntityExecutableUpdate<E>,
            EntityExecutableConditionGroup<E>, EntityExecutableConditionGroupLogic<E>> property(
                    SerializableFunction2<E, R> name) {
        return new EntityUpdateNumberValueImpl<>(name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityExecutableConditionGroup<E> where() {
        return createSqlUpdateExpression();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityExecutableConditionGroup<E> where(
            Consumer<ConditionGroupConfig<EntityExecutableConditionGroup<E>>> consumer) {
        SqlEntityUpdateExpression<E> sqlUpdateExpression = createSqlUpdateExpression();
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
        return createSqlUpdateExpression().execute();
    }

    private SqlEntityExecutableUpdate<E> set0(JdbcPropertyMapping pm, FieldValueOperator<?> value) {
        return _set(pm.getRepositoryFieldName(), value);
    }

    private SqlEntityExecutableUpdate<E> set0(JdbcPropertyMapping pm, Object value) {
        if (value == null) {
            return _set(pm.getRepositoryFieldName(), null);
        }

        //        if (pm.isEmbeddable()) {
        if (Lang.isNotEmpty(pm.getPropertyMappings())) {
            if (ClassUtils.isParent(pm.getPropertyType(), value.getClass())) {
                BeanDescriptor<?> bd = BeanDescriptor.getBeanDescriptor(value.getClass());
                for (JdbcPropertyMapping spm : pm.getPropertyMappings()) {
                    Object ov = bd.getBeanProperty(spm.getPropertyName()).getValue(value);
                    set0(spm, FieldValueOperator.create(spm, ov));
                }
            } else {
                for (JdbcPropertyMapping spm : pm.getPropertyMappings()) {
                    if (ClassUtils.isParent(spm.getPropertyType(), value.getClass())) {
                        set0(spm, FieldValueOperator.create(spm, value));
                    }
                }
            }
            return this;
        } else {
            return set0(pm, FieldValueOperator.create(pm, value));
        }
    }

    private SqlEntityUpdateExpression<E> createSqlUpdateExpression() {
        return new SqlEntityUpdateExpression<>(factory, relation);
    }
}
