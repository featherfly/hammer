
package cn.featherfly.hammer.sqldb.dsl.execute;

import java.util.function.Predicate;

import cn.featherfly.common.db.FieldValueOperator;
import cn.featherfly.common.db.builder.dml.basic.SqlUpdateSetBasicBuilder;
import cn.featherfly.common.db.builder.model.UpdateColumnElement.SetType;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.hammer.config.dsl.UpdateConfig;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * SqlExecutableUpdate .
 *
 * @author zhongj
 * @param <U> the generic type
 */
public abstract class AbstractSqlExecutableUpdate<U extends AbstractSqlExecutableUpdate<U>> {

    /** The jdbc. */
    protected Jdbc jdbc;

    /** The builder. */
    protected SqlUpdateSetBasicBuilder builder;

    /** The update config. */
    protected UpdateConfig updateConfig;

    /** The alias manager. */
    protected AliasManager aliasManager;

    /**
     * Instantiates a new sql executable update.
     *
     * @param tableName tableName
     * @param jdbc jdbc
     * @param aliasManager the alias manager
     * @param updateConfig the update config
     */
    protected AbstractSqlExecutableUpdate(String tableName, Jdbc jdbc, AliasManager aliasManager,
        UpdateConfig updateConfig) {
        this(tableName, null, jdbc, aliasManager, updateConfig);
    }

    /**
     * Instantiates a new sql executable update.
     *
     * @param tableName tableName
     * @param tableAlias the table alias
     * @param jdbc jdbc
     * @param aliasManager the alias manager
     * @param updateConfig the update config
     */
    protected AbstractSqlExecutableUpdate(String tableName, String tableAlias, Jdbc jdbc, AliasManager aliasManager,
        UpdateConfig updateConfig) {
        this.jdbc = jdbc;
        this.aliasManager = aliasManager;
        this.updateConfig = updateConfig;
        if (Lang.isEmpty(tableAlias)) {
            tableAlias = aliasManager.put(tableName);
        }
        // 都是用*SqlUpdateRelation来初始化Builder了
        //        builder = new SqlUpdateSetBasicBuilder(jdbc.getDialect(), tableName, tableAlias,
        //            v -> this.updateConfig.getSetValueIgnoreStrategy().test(v));
        //        builder = new SqlUpdateSetBasicBuilder(jdbc.getDialect(), tableName, tableAlias, this::test);
    }

    /**
     * Instantiates a new sql executable update.
     *
     * @param tableName tableName
     * @param tableAlias the table alias
     * @param jdbc jdbc
     * @param aliasManager the alias manager
     * @param updateConfig the update config
     * @param builder the builder
     */
    protected AbstractSqlExecutableUpdate(String tableName, String tableAlias, Jdbc jdbc, AliasManager aliasManager,
        UpdateConfig updateConfig, SqlUpdateSetBasicBuilder builder) {
        this.jdbc = jdbc;
        this.aliasManager = aliasManager;
        this.updateConfig = updateConfig.clone();
        if (Lang.isEmpty(tableAlias)) {
            tableAlias = aliasManager.put(tableName);
        }
        builder = new SqlUpdateSetBasicBuilder(jdbc.getDialect(), tableName, tableAlias,
            v -> this.updateConfig.getSetValueIgnoreStrategy().test(v));
        //        builder = new SqlUpdateSetBasicBuilder(jdbc.getDialect(), tableName, tableAlias, this::test);
        // YUFEI_TEST 需要测试这个逻辑
    }

    /**
     * Sets value.
     *
     * @param <V> the value type
     * @param name the name
     * @param value the value
     * @return the u
     */
    @SuppressWarnings("unchecked")
    protected <V> U set0(String name, FieldValueOperator<V> value) {
        builder.setValue(name, value);
        return (U) this;
    }

    /**
     * Sets value.
     *
     * @param name the name
     * @param value the value
     * @param setIgnoreStrategy the set ignore strategy
     * @return the u
     */
    @SuppressWarnings("unchecked")
    protected U set0(String name, FieldValueOperator<?> value, Predicate<? extends Object> setIgnoreStrategy) {
        builder.setValue(name, value, setIgnoreStrategy);
        return (U) this;
    }

    /**
     * Sets value.
     *
     * @param <O> the generic type
     * @param name the name
     * @param value the value
     * @return the u
     */
    protected <O> U set0(String name, O value) {
        return set0(name, value, updateConfig.getSetValueIgnoreStrategy()::test);
    }

    /**
     * Sets value.
     *
     * @param <O> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return the u
     */
    protected <O> U set0(String name, O value, Predicate<O> ignoreStrategy) {
        return set0(name, FieldValueOperator.create(value), ignoreStrategy);
        //        builder.setIgnoreStrategy(ignoreStrategy);
        //        if (ignoreStrategy.test(value)) { // ignore, 忽略
        //            return (U) this;
        //        } else {
        //            return set0(name, FieldValueOperator.create(value));
        //        }
    }

    /**
     * Increase.
     *
     * @param <N> the number type
     * @param name the name
     * @param value the value
     * @return the u
     */
    @SuppressWarnings("unchecked")
    protected <N extends Number> U increase0(String name, FieldValueOperator<N> value) {
        builder.setValue(name, value, SetType.INCR);
        return (U) this;
    }

    /**
     * Increase.
     *
     * @param <N> the number type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return the u
     */
    @SuppressWarnings("unchecked")
    protected <N extends Number> U increase0(String name, FieldValueOperator<N> value, Predicate<?> ignoreStrategy) {
        builder.setValue(name, value, SetType.INCR, ignoreStrategy);
        return (U) this;
    }

    /**
     * Increase.
     *
     * @param <N> the number type
     * @param name the name
     * @param value the value
     * @return the u
     */
    protected <N extends Number> U increase0(String name, N value) {
        return increase0(name, value, updateConfig.getSetValueIgnoreStrategy()::test);
    }

    /**
     * Increase.
     *
     * @param <N> the number type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return the u
     */
    protected <N extends Number> U increase0(String name, N value, Predicate<N> ignoreStrategy) {
        return increase0(name, FieldValueOperator.create(value), ignoreStrategy);
        //        builder.setIgnoreStrategy(ignoreStrategy);
        //        if (ignoreStrategy.test(value)) { // ignore, 忽略
        //            return (U) this;
        //        } else {
        //            return increase0(name, FieldValueOperator.create(value));
        //        }
    }

    /**
     * Gets the property name.
     *
     * @param <T> the generic type
     * @param <R> the generic type
     * @param name the name
     * @return the property name
     */
    protected <T, R> String getPropertyName(SerializableFunction<T, R> name) {
        return LambdaUtils.getLambdaPropertyName(name);
    }

    /**
     * Gets the property name.
     *
     * @param <R> the generic type
     * @param name the name
     * @return the property name
     */
    protected <R> String getPropertyName(SerializableSupplier<R> name) {
        return LambdaUtils.getLambdaPropertyName(name);
    }
}
