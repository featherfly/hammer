
package cn.featherfly.hammer.sqldb.jdbc.dsl.execute;

import java.util.function.Predicate;

import cn.featherfly.common.db.FieldValueOperator;
import cn.featherfly.common.db.builder.dml.basic.SqlUpdateSetBasicBuilder;
import cn.featherfly.common.db.builder.model.UpdateColumnElement.SetType;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * SqlExecutableUpdate .
 *
 * @author zhongj
 */
public abstract class AbstractSqlExecutableUpdate<U extends AbstractSqlExecutableUpdate<U>> {

    protected Jdbc jdbc;

    protected SqlUpdateSetBasicBuilder builder;

    /**
     * Instantiates a new sql executable update.
     *
     * @param tableName      tableName
     * @param jdbc           jdbc
     * @param ignoreStrategy the ignore strategy
     */
    public AbstractSqlExecutableUpdate(String tableName, Jdbc jdbc, Predicate<?> ignoreStrategy) {
        this(tableName, null, jdbc, ignoreStrategy);
    }

    /**
     * Instantiates a new sql executable update.
     *
     * @param tableName      tableName
     * @param tableAlias     the table alias
     * @param jdbc           jdbc
     * @param ignoreStrategy the ignore strategy
     */
    public AbstractSqlExecutableUpdate(String tableName, String tableAlias, Jdbc jdbc, Predicate<?> ignoreStrategy) {
        this.jdbc = jdbc;
        builder = new SqlUpdateSetBasicBuilder(jdbc.getDialect(), tableName, tableAlias, ignoreStrategy);
    }

    @SuppressWarnings("unchecked")
    protected U _set(String name, FieldValueOperator<?> value) {
        builder.setValue(name, value);
        return (U) this;
    }

    @SuppressWarnings("unchecked")
    protected U _set(String name, Object value) {
        // ENHANCE 后续完善了基础类型FieldValueOperator后，需要删除此方法
        builder.setValue(name, value);
        return (U) this;
    }

    @SuppressWarnings("unchecked")
    protected <N extends Number> U _increase(String name, FieldValueOperator<N> value) {
        builder.setValue(name, value, SetType.INCR);
        return (U) this;
    }

    @SuppressWarnings("unchecked")
    protected <N extends Number> U _increase(String name, N value) {
        // ENHANCE 后续完善了基础类型FieldValueOperator后，需要删除此方法
        builder.setValue(name, value, SetType.INCR);
        return (U) this;
    }

    protected <T, R> String getPropertyName(SerializableFunction<T, R> name) {
        return LambdaUtils.getLambdaPropertyName(name);
    }

    protected <T, R> String getPropertyName(SerializableSupplier<R> name) {
        return LambdaUtils.getLambdaPropertyName(name);
    }
}
