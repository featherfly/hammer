
package cn.featherfly.juorm.rdb.jdbc.dsl.query;

import java.util.Map;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.juorm.dsl.query.QueryWithEntity;

/**
 * <p>
 * SqlQueryWithEntity
 * </p>
 *
 * @author zhongj
 */
public interface SqlQueryWithEntity extends QueryWithEntity {
    /**
     * <p>
     * 添加select的列
     * </p>
     *
     * @param columnName propertyName
     * @param asName     alias name
     * @return QueryWithEntity
     */
    <T, R> QueryWithEntity propertyAlias(SerializableFunction<T, R> propertyName, String alias);

    /**
     * <p>
     * 添加select的列
     * </p>
     *
     * @param columnName propertyName
     * @param asName     alias name
     * @return QueryWithEntity
     */
    QueryWithEntity propertyAlias(String columnName, String asName);

    /**
     * <p>
     * 批量添加select的列
     * </p>
     *
     * @param columnNameMap key is columnName, value is asName
     * @return QueryWithEntity
     */
    QueryWithEntity propertyAlias(Map<String, String> columnNameMap);
}
