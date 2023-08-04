
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import cn.featherfly.hammer.dsl.query.type.EntityQueryFetch;

/**
 * The Interface EntitySqlQueryEntity.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface EntitySqlQueryEntity<E> extends EntitySqlQuery<E>, EntityQueryFetch<E> {

    //    /**
    //     * 添加select的列.
    //     *
    //     * @param property property
    //     * @param asName   alias name
    //     * @return QueryEntityPropertiesExpression
    //     */
    //    <R> EntityQueryEntityProperties<E> propertyAlias(SerializableFunction<E, R> property, String asName);
    //
    //    /**
    //     * 批量添加select的列.
    //     *
    //     * @param columnNameMap key is columnName, value is asName
    //     * @return QueryEntityPropertiesExpression
    //     */
    //    <R> EntityQueryEntityProperties<E> propertyAlias(Map<SerializableFunction<E, R>, String> columnNameMap);

}
