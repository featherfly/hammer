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
        this.columnName = columnName.toUpperCase();
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
}
