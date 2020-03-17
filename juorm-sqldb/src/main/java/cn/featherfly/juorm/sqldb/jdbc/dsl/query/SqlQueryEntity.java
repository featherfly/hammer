
package cn.featherfly.juorm.sqldb.jdbc.dsl.query;

import java.util.Map;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.juorm.dsl.query.QueryEntity;
import cn.featherfly.juorm.dsl.query.QueryEntityProperties;

/**
 * <p>
 * SqlQueryEntity
 * </p>
 *
 * @author zhongj
 */
public interface SqlQueryEntity extends QueryEntity {

    /**
     * <p>
     * 添加select的列
     * </p>
     * .
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param propertyName propertyName
     * @param aliasName    alias name
     * @return QueryEntityPropertiesExpression
     */
    <T, R> QueryEntityProperties propertyAlias(SerializableFunction<T, R> propertyName, String aliasName);

    /**
     * <p>
     * 添加select的列
     * </p>
     *
     * @param columnName propertyName
     * @param aliasName  alias name
     * @return QueryEntityPropertiesExpression
     */
    QueryEntityProperties propertyAlias(String columnName, String aliasName);

    /**
     * <p>
     * 批量添加select的列
     * </p>
     *
     * @param columnNameMap key is columnName, value is asName
     * @return QueryEntityPropertiesExpression
     */
    QueryEntityProperties propertyAlias(Map<String, String> columnNameMap);

}
