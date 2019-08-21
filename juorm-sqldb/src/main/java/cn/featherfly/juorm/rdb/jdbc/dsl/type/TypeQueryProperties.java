
package cn.featherfly.juorm.rdb.jdbc.dsl.type;

import cn.featherfly.juorm.rdb.jdbc.dsl.query.SqlQueryEntityProperties;
import cn.featherfly.juorm.rdb.jdbc.mapping.JdbcMappingFactory;

/**
 * <p>
 * TypeQueryEntity
 * </p>
 *
 * @author zhongj
 */
public abstract class TypeQueryProperties<E, C extends TypeQueryConditionGroupExpression<E, C>,
        Q extends TypeQueryProperties<E, C, Q>> extends TypeQueryEntity<E, C, Q> {

    private SqlQueryEntityProperties queryEntityProperties;

    /**
     * @param queryEntityProperties
     * @param mappingFactory
     */
    public TypeQueryProperties(SqlQueryEntityProperties queryEntityProperties, JdbcMappingFactory mappingFactory) {
        super(queryEntityProperties, mappingFactory);
        this.queryEntityProperties = queryEntityProperties;
    }

    @SuppressWarnings("unchecked")
    public Q property(String propertyName) {
        queryEntityProperties.property(propertyName);
        setProperty = true;
        return (Q) this;
    }

    @SuppressWarnings("unchecked")
    public Q property(String columnName, String asName) {
        queryEntityProperties.propertyAlias(columnName, asName);
        setProperty = true;
        return (Q) this;
    }

}
