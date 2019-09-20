
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
    <T, R> QueryWithEntity fetchAlias(SerializableFunction<T, R> columnName, String alias);

    /**
     * <p>
     * 添加select的列
     * </p>
     *
     * @param columnName propertyName
     * @param asName     alias name
     * @return QueryWithEntity
     */
    QueryWithEntity fetchAlias(String columnName, String asName);

    /**
     * <p>
     * 批量添加select的列
     * </p>
     *
     * @param columnNameMap key is columnName, value is asName
     * @return QueryWithEntity
     */
    QueryWithEntity fetchAlias(Map<String, String> columnNameMap);
}
