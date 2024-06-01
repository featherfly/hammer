
package cn.featherfly.hammer.sqldb.dsl.entity.execute;

import java.io.Serializable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import cn.featherfly.common.bean.BeanDescriptor;
import cn.featherfly.common.bean.BeanUtils;
import cn.featherfly.common.db.FieldValueOperator;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.function.serializable.SerializableToNumberFunction;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.config.dsl.UpdateConfig;
import cn.featherfly.hammer.dsl.entity.EntityOnExpression1;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroup;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroupLogic;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableUpdate;
import cn.featherfly.hammer.dsl.entity.execute.EntityUpdate2;
import cn.featherfly.hammer.dsl.entity.execute.EntityUpdateNestedValueImpl;
import cn.featherfly.hammer.dsl.entity.execute.EntityUpdateNumberValueImpl;
import cn.featherfly.hammer.dsl.entity.execute.EntityUpdateValueImpl;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.EntityConditionsGroupExpression;
import cn.featherfly.hammer.expression.entity.execute.EntityUpdateExpression;
import cn.featherfly.hammer.expression.entity.execute.EntityUpdateSetExpression;
import cn.featherfly.hammer.expression.execute.UpdateNumberValueExpression;
import cn.featherfly.hammer.expression.execute.UpdateValueExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlConditionsGroupExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlOn1;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlUpdateRelation;
import cn.featherfly.hammer.sqldb.dsl.execute.AbstractSqlExecutableUpdate;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * sql entity executable update .
 *
 * @author zhongj
 * @param <E> the element type
 */
public class EntitySqlExecutableUpdate<E> extends AbstractSqlExecutableUpdate<EntitySqlExecutableUpdate<E>>
    implements EntitySqlUpdate<E>, EntityExecutableUpdate<E> {

    JdbcClassMapping<E> classMapping;

    JdbcMappingFactory factory;

    EntitySqlUpdateRelation relation;

    /**
     * Instantiates a new sql entity executable update.
     *
     * @param jdbc the jdbc
     * @param classMapping the class mapping
     * @param factory the factory
     * @param updateConfig the update config
     */
    public EntitySqlExecutableUpdate(Jdbc jdbc, JdbcClassMapping<E> classMapping, JdbcMappingFactory factory,
        UpdateConfig updateConfig) {
        this(jdbc, classMapping, factory, updateConfig, new AliasManager());
    }

    /**
     * Instantiates a new sql entity executable update.
     *
     * @param jdbc the jdbc
     * @param classMapping the class mapping
     * @param factory the factory
     * @param updateConfig the update config
     * @param aliasManager the alias manager
     */
    public EntitySqlExecutableUpdate(Jdbc jdbc, JdbcClassMapping<E> classMapping, JdbcMappingFactory factory,
        UpdateConfig updateConfig, AliasManager aliasManager) {
        super(classMapping.getRepositoryName(), jdbc, aliasManager, updateConfig);
        this.classMapping = classMapping;
        this.factory = factory;
        // 使用 this.updateConfig 是因为是在父类中设置的已经是克隆的副本（用于configure()单独配置当前表达式生效）
        relation = new EntitySqlUpdateRelation(jdbc, aliasManager, this.updateConfig).addFilterable(classMapping);
        // addFilterable 初始化builder
        builder = relation.getBuilder();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityExecutableUpdate<E> set(Consumer<EntityUpdateSetExpression<E, EntityExecutableUpdate<E>,
        EntityExecutableConditionGroup<E, UpdateConditionConfig>,
        EntityExecutableConditionGroupLogic<E, UpdateConditionConfig>>> consumer) {
        consumer.accept(this);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> EntityExecutableUpdate<E> set(SerializableFunction<E, R> name, R value) {
        return set0(name, value, updateConfig.getSetValueIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> EntityExecutableUpdate<E> set(SerializableFunction<E, R> name, R value,
        Predicate<R> ignoreStrategy) {
        return set0(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, O extends Serializable> EntityExecutableUpdate<E> set(SerializableFunction<E, R> property,
        SerializableFunction<R, O> nestedProperty, O value) {
        return set0(property, nestedProperty, value, updateConfig.getSetValueIgnoreStrategy()::test);
        //        JdbcPropertyMapping pm = classMapping.getPropertyMapping(getPropertyName(property));
        //        if (value == null) {
        //            return set0(pm, value);
        //        }
        //        String npn = getPropertyName(nestedProperty);
        //        JdbcPropertyMapping spm = pm.getPropertyMapping(npn);
        //        return set0(spm, FieldValueOperator.create(spm, value));

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
    public <R, O extends Serializable> EntityExecutableUpdate<E> set(SerializableFunction<E, R> property,
        SerializableFunction<R, O> nestedProperty, O value, Predicate<O> ignoreStrategy) {
        return set0(property, nestedProperty, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> EntityExecutableUpdate<E> set(SerializableSupplier<R> property) {
        //        return set0(classMapping.getPropertyMapping(getPropertyName(property)), property.get());
        return set0(property, property.get(), updateConfig.getSetValueIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> EntityExecutableUpdate<E> set(SerializableSupplier<R> property,
        Predicate<R> ignoreStrategy) {
        return set0(property, property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, O extends Serializable> EntityExecutableUpdate<E> set(SerializableSupplier<R> property,
        SerializableFunction<R, O> nestedProperty) {
        return setSupplier(property, nestedProperty, updateConfig.getSetValueIgnoreStrategy()::test);
        //        JdbcPropertyMapping pm = classMapping.getPropertyMapping(getPropertyName(property));
        //        if (property.get() == null) {
        //            return set0(pm, property.get());
        //        }
        //        String npn = getPropertyName(nestedProperty);
        //        JdbcPropertyMapping spm = pm.getPropertyMapping(npn);
        //        return set0(spm, FieldValueOperator.create(spm, BeanUtils.getProperty(property.get(), npn)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, O extends Serializable> EntityExecutableUpdate<E> set(SerializableSupplier<R> property,
        SerializableFunction<R, O> nestedProperty, Predicate<O> ignoreStrategy) {
        return setSupplier(property, nestedProperty, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> EntityExecutableUpdate<E> increase(SerializableFunction<E, R> name, R value) {
        return increase0(name, value, updateConfig.getSetValueIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> EntityExecutableUpdate<E> increase(SerializableFunction<E, N> property, N value,
        Predicate<N> ignoreStrategy) {
        return increase0(property, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, N extends Number> EntityExecutableUpdate<E> increase(SerializableFunction<E, R> property,
        SerializableFunction<R, N> nestedProperty, N value) {
        return increase0(property, nestedProperty, value, updateConfig.getSetValueIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, N extends Number> EntityExecutableUpdate<E> increase(SerializableFunction<E, R> property,
        SerializableFunction<R, N> nestedProperty, N value, Predicate<N> ignoreStrategy) {
        return increase0(property, nestedProperty, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> EntityExecutableUpdate<E> increase(SerializableSupplier<N> property) {
        return increase0(property, property.get(), updateConfig.getSetValueIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> EntityExecutableUpdate<E> increase(SerializableSupplier<N> property,
        Predicate<N> ignoreStrategy) {
        return increase0(property, property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, N extends Number> EntityExecutableUpdate<E> increase(SerializableSupplier<R> property,
        SerializableFunction<R, N> nestedProperty) {
        return increase0(property, nestedProperty, updateConfig.getSetValueIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, N extends Number> EntityExecutableUpdate<E> increase(SerializableSupplier<R> property,
        SerializableFunction<R, N> nestedProperty, Predicate<N> ignoreStrategy) {
        return increase0(property, nestedProperty, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> UpdateValueExpression<R, EntityExecutableUpdate<E>,
        EntityExecutableConditionGroup<E, UpdateConditionConfig>,
        EntityExecutableConditionGroupLogic<E, UpdateConditionConfig>> property(SerializableFunction<E, R> property) {
        return new EntityUpdateValueImpl<>(property, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <P,
        V extends Serializable> UpdateValueExpression<V, EntityExecutableUpdate<E>,
            EntityExecutableConditionGroup<E, UpdateConditionConfig>,
            EntityExecutableConditionGroupLogic<E, UpdateConditionConfig>> property(SerializableFunction<E, P> property,
                SerializableFunction<P, V> nestedProperty) {
        return new EntityUpdateNestedValueImpl<>(property, nestedProperty, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UpdateNumberValueExpression<N, EntityExecutableUpdate<E>,
        EntityExecutableConditionGroup<E, UpdateConditionConfig>,
        EntityExecutableConditionGroupLogic<E, UpdateConditionConfig>> property(
            SerializableToNumberFunction<E, N> property) {
        return new EntityUpdateNumberValueImpl<>(property, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityExecutableConditionGroup<E, UpdateConditionConfig> where() {
        return createSqlUpdateExpression();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityExecutableConditionGroupLogic<E, UpdateConditionConfig> where(
        Function<EntityConditionsGroupExpression<E, ?, ?>, LogicExpression<?, ?>> function) {
        EntitySqlUpdateConditions<E> sqlUpdateExpression = createSqlUpdateExpression();
        if (function != null) {
            sqlUpdateExpression
                .addCondition(function.apply(new EntitySqlConditionsGroupExpression<>(0, factory, relation)));
        }
        return sqlUpdateExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityUpdateExpression<E, EntityExecutableUpdate<E>,
        EntityExecutableConditionGroup<E, UpdateConditionConfig>,
        EntityExecutableConditionGroupLogic<E, UpdateConditionConfig>> configure(Consumer<UpdateConfig> configure) {
        if (configure != null) {
            configure.accept(updateConfig);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int execute() {
        return createSqlUpdateExpression().execute();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <J> EntityOnExpression1<E, J, EntityUpdate2<E, J>> join(Class<J> joinType) {
        return new EntitySqlOn1<>(joinType, new EntitySqlExecutableUpdate2<>(this), factory, relation);
    }

    // ----------------------------------------------------------------------------------------------------------------

    private <R> EntityExecutableUpdate<E> set0(Serializable name, R value, Predicate<R> ignoreStrategy) {
        builder.setIgnoreStrategy(ignoreStrategy);
        if (ignoreStrategy.test(value)) {// ignore, 忽略
            return this;
        } else {
            return set0(classMapping.getPropertyMapping(getPropertyName(name)), value);
        }
    }

    private <R, O> EntityExecutableUpdate<E> set0(SerializableFunction<E, R> property,
        SerializableFunction<R, O> nestedProperty, O value, Predicate<O> ignoreStrategy) {
        builder.setIgnoreStrategy(ignoreStrategy);
        if (ignoreStrategy.test(value)) { // ignore, 忽略
            return this;
        }
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

    private <R, O> EntityExecutableUpdate<E> setSupplier(SerializableSupplier<R> property,
        SerializableFunction<R, O> nestedProperty, Predicate<O> ignoreStrategy) {
        boolean enableNull = false;
        if (property.get() == null) {
            builder.setIgnoreStrategy(ignoreStrategy);
            if (ignoreStrategy.test(null)) {
                return this;
            } else {
                // not ignore null
                enableNull = true;
            }
        }
        JdbcPropertyMapping pm = classMapping.getPropertyMapping(getPropertyName(property));
        String npn = getPropertyName(nestedProperty);
        JdbcPropertyMapping spm = pm.getPropertyMapping(npn);

        if (enableNull) {
            // set null value
            return set0(spm, FieldValueOperator.create(spm, null));
        }

        @SuppressWarnings("unchecked")
        O value = (O) BeanUtils.getProperty(property.get(), npn);
        builder.setIgnoreStrategy(ignoreStrategy);
        if (ignoreStrategy.test(value)) { // 忽略
            return this;
        }
        return set0(spm, FieldValueOperator.create(spm, value));
    }

    private <R> EntitySqlExecutableUpdate<E> set0(JdbcPropertyMapping pm, R value) {
        if (value == null) {
            return set0(pm.getRepositoryFieldName(), (FieldValueOperator<R>) null);
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

    private EntitySqlExecutableUpdate<E> set0(JdbcPropertyMapping pm, FieldValueOperator<?> value) {
        return set0(pm.getRepositoryFieldName(), value);
    }

    // ----------------------------------------------------------------------------------------------------------------

    private <N extends Number> EntityExecutableUpdate<E> increase0(Serializable name, N value,
        Predicate<N> ignoreStrategy) {
        builder.setIgnoreStrategy(ignoreStrategy);
        if (ignoreStrategy.test(value)) {// ignore, 忽略
            return this;
        } else {
            return increase0(classMapping.getPropertyMapping(getPropertyName(name)), value);
        }
    }

    private <R, N extends Number> EntityExecutableUpdate<E> increase0(SerializableFunction<E, R> property,
        SerializableFunction<R, N> nestedProperty, N value, Predicate<N> ignoreStrategy) {
        builder.setIgnoreStrategy(ignoreStrategy);
        if (ignoreStrategy.test(value)) { // ignore, 忽略
            return this;
        }
        JdbcPropertyMapping pm = classMapping.getPropertyMapping(getPropertyName(property));
        if (value == null) {
            return increase0(pm, value);
        }
        String npn = getPropertyName(nestedProperty);
        JdbcPropertyMapping spm = pm.getPropertyMapping(npn);
        return increase0(spm, FieldValueOperator.create(spm, value));
    }

    private <R, N extends Number> EntityExecutableUpdate<E> increase0(SerializableSupplier<R> property,
        SerializableFunction<R, N> nestedProperty, Predicate<N> ignoreStrategy) {
        boolean enableNull = false;
        if (property.get() == null) {
            builder.setIgnoreStrategy(ignoreStrategy);
            if (ignoreStrategy.test(null)) {
                return this;
            } else {
                // not ignore null
                enableNull = true;
            }
        }
        JdbcPropertyMapping pm = classMapping.getPropertyMapping(getPropertyName(property));
        String npn = getPropertyName(nestedProperty);
        JdbcPropertyMapping spm = pm.getPropertyMapping(npn);

        if (enableNull) {
            // set null value
            return increase0(spm, FieldValueOperator.create(spm, null));
        }

        @SuppressWarnings("unchecked")
        N value = (N) BeanUtils.getProperty(property.get(), npn);
        builder.setIgnoreStrategy(ignoreStrategy);
        if (ignoreStrategy.test(value)) { // 忽略
            return this;
        }
        return increase0(spm, FieldValueOperator.create(spm, value));
    }

    private <N extends Number> EntitySqlExecutableUpdate<E> increase0(JdbcPropertyMapping pm, N value) {
        if (value == null) {
            return increase0(pm.getRepositoryFieldName(), (FieldValueOperator<N>) null);
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
            return increase0(pm, FieldValueOperator.create(pm, value));
        }
    }

    private <N extends Number> EntitySqlExecutableUpdate<E> increase0(JdbcPropertyMapping pm,
        FieldValueOperator<N> value) {
        return increase0(pm.getRepositoryFieldName(), value);
    }

    private EntitySqlUpdateConditions<E> createSqlUpdateExpression() {
        return new EntitySqlUpdateConditions<>(factory, relation);
    }

    private String getPropertyName(Serializable name) {
        return LambdaUtils.getLambdaPropertyName(name);
    }
}
