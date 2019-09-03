package cn.featherfly.juorm.rdb.jdbc.mapping;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 属性与列的映射对象
 * </p>
 *
 * @author zhongj
 * @since 1.0
 * @version 1.0
 */
public class PropertyMapping {

    /**
     */
    public PropertyMapping() {

    }

    private String propertyName;

    private String columnName;

    private Class<?> propertyType;

    private boolean primaryKey;

    private String defaultValue;

    //    private String propertyPath;

    private Map<String, PropertyMapping> propertyMappings = new HashMap<>(0);

    private PropertyMapping parent;

    PropertyMapping add(PropertyMapping propertyMapping) {
        propertyMapping.parent = this;
        propertyMappings.put(propertyMapping.getColumnName(), propertyMapping);
        return this;
    }

    /**
     * @return 返回propertyType
     */
    public Class<?> getPropertyType() {
        return propertyType;
    }

    /**
     * @param propertyType 设置propertyType
     */
    public void setPropertyType(Class<?> propertyType) {
        this.propertyType = propertyType;
    }

    /**
     * @return 返回primaryKey
     */
    public boolean isPrimaryKey() {
        return primaryKey;
    }

    /**
     * @param primaryKey 设置primaryKey
     */
    public void setPrimaryKey(boolean primaryKey) {
        this.primaryKey = primaryKey;
    }

    /**
     * @return 返回propertyName
     */
    public String getPropertyName() {
        return propertyName;
    }

    /**
     * @param propertyName 设置propertyName
     */
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    /**
     * @return 返回columnName
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * @param columnName 设置columnName
     */
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    //    /**
    //     * 返回propertyPath
    //     *
    //     * @return propertyPath
    //     */
    //    public String getPropertyPath() {
    //        return propertyPath;
    //    }
    //
    //    /**
    //     * 设置propertyPath
    //     *
    //     * @param propertyPath propertyPath
    //     */
    //    public void setPropertyPath(String propertyPath) {
    //        this.propertyPath = propertyPath;
    //    }

    /**
     * 返回defaultValue
     *
     * @return defaultValue
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     * 设置defaultValue
     *
     * @param defaultValue defaultValue
     */
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    /**
     * 返回parent
     *
     * @return parent
     */
    public PropertyMapping getParent() {
        return parent;
    }

    /**
     * 返回PropertyMappings
     *
     * @return PropertyMappings
     */
    public Collection<PropertyMapping> getPropertyMappings() {
        return propertyMappings.values();
    }

    /**
     * <p>
     * 返回指定属性名称的属性映射. 没有找到返回null.
     * </p>
     *
     * @param propertyName 属性名称
     * @return 属性映射对象
     */
    public PropertyMapping getPropertyMapping(String propertyName) {
        for (PropertyMapping pm : propertyMappings.values()) {
            if (pm.getPropertyName().equals(propertyName)) {
                return pm;
            }
        }
        return null;
    }

    /**
     * <p>
     * 通过持久化字段（数据库字段）的名称返回指定属性映射. 没有找到返回null.
     * </p>
     *
     * @param persitField 持久化字段（数据库字段）
     * @return PropertyMapping
     */
    public PropertyMapping getPropertyMappingByPersitField(String persitField) {
        return propertyMappings.get(persitField);
    }
}
