
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import java.util.Map;

import cn.featherfly.hammer.dsl.query.EntityQueryEntity;
import cn.featherfly.hammer.dsl.query.EntityQueryEntityProperties;

/**
 * The Interface EntitySqlQueryEntity.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface EntitySqlQueryEntity<E> extends EntityQueryEntity<E> {

    /**
     * <p>
     * 添加select的列
     * </p>
     * .
     *
     * @param columnName propertyName
     * @param asName     alias name
     * @return QueryEntityPropertiesExpression
     */
    EntityQueryEntityProperties<E> propertyAlias(String columnName, String asName);

    /**
     * <p>
     * 批量添加select的列
     * </p>
     * .
     *
     * @param columnNameMap key is columnName, value is asName
     * @return QueryEntityPropertiesExpression
     */
    EntityQueryEntityProperties<E> propertyAlias(Map<String, String> columnNameMap);

}
