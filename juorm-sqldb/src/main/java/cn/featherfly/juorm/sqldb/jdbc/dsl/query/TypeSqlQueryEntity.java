
package cn.featherfly.juorm.sqldb.jdbc.dsl.query;

import java.util.Map;

import cn.featherfly.juorm.dsl.query.TypeQueryEntity;
import cn.featherfly.juorm.dsl.query.TypeQueryEntityProperties;

/**
 * <p>
 * SqlQueryEntity
 * </p>
 *
 * @author zhongj
 */
public interface TypeSqlQueryEntity extends TypeQueryEntity {

    /**
     * <p>
     * 添加select的列
     * </p>
     *
     * @param columnName propertyName
     * @param asName     alias name
     * @return QueryEntityPropertiesExpression
     */
    TypeQueryEntityProperties propertyAlias(String columnName, String asName);

    /**
     * <p>
     * 批量添加select的列
     * </p>
     *
     * @param columnNameMap key is columnName, value is asName
     * @return QueryEntityPropertiesExpression
     */
    TypeQueryEntityProperties propertyAlias(Map<String, String> columnNameMap);

}
