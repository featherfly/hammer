package cn.featherfly.juorm.jdbc.mapping;

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
}
