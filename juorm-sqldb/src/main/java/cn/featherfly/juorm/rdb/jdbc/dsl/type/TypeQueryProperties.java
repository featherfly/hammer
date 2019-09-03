
package cn.featherfly.juorm.rdb.jdbc.dsl.type;

import cn.featherfly.juorm.rdb.jdbc.dsl.query.SqlQueryEntityProperties;
import cn.featherfly.juorm.rdb.jdbc.mapping.JdbcMappingFactory;

/**
 * <p>
 * TypeQueryEntity
 * </p>
 * .
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <Q> the generic type
 */
public abstract class TypeQueryProperties<E, C extends TypeQueryConditionGroupExpression<E, C>,
        Q extends TypeQueryProperties<E, C, Q>> extends TypeQueryEntity<E, C, Q> {

    /** The query entity properties. */
    private SqlQueryEntityProperties queryEntityProperties;

    /**
     * Instantiates a new type query properties.
     *
     * @param queryEntityProperties the query entity properties
     * @param mappingFactory        the mapping factory
     */
    public TypeQueryProperties(SqlQueryEntityProperties queryEntityProperties, JdbcMappingFactory mappingFactory) {
        super(queryEntityProperties, mappingFactory);
        this.queryEntityProperties = queryEntityProperties;
    }

    /**
     * Property.
     *
     * @param propertyName the property name
     * @return the q
     */
    @SuppressWarnings("unchecked")
    public Q property(String propertyName) {
        queryEntityProperties.property(propertyName);
        setProperty = true;
        return (Q) this;
    }

    /**
     * Property.
     *
     * @param columnName the column name
     * @param asName     the as name
     * @return the q
     */
    @SuppressWarnings("unchecked")
    public Q property(String columnName, String asName) {
        queryEntityProperties.propertyAlias(columnName, asName);
        setProperty = true;
        return (Q) this;
    }

}
