package cn.featherfly.juorm.jdbc.mapping;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 类映射
 * </p>
 *
 * @param <T> 类型
 * @author zhongj
 * @since 1.0
 * @version 1.0
 */
public class ClassMapping<T> {

    /**
     * @param type      类型
     * @param tableName 表名
     */
    public ClassMapping(Class<T> type, String tableName) {
        this.type = type;
        this.tableName = tableName;
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
        return propertyMappings.get(propertyName);
    }

    /**
     * <p>
     * 返回所有属性映射
     * </p>
     *
     * @return 所有属性映射
     */
    public Collection<PropertyMapping> getPropertyMappings() {
        return propertyMappings.values();
    }

    /**
     * <p>
     * 返回所有主键属性映射
     * </p>
     *
     * @return 所有属性映射
     */
    public Collection<PropertyMapping> getPrivaryKeyPropertyMappings() {
        return propertyMappings.values().stream().filter(p -> p.isPrimaryKey()).collect(Collectors.toList());
    }

    // ********************************************************************
    //
    // ********************************************************************

    void addPropertyMapping(PropertyMapping propertyMapping) {
        propertyMappings.put(propertyMapping.getPropertyName(), propertyMapping);
    }

    void addPropertyMappings(Collection<PropertyMapping> propertyMappings) {
        for (PropertyMapping propertyMapping : propertyMappings) {
            addPropertyMapping(propertyMapping);
        }
    }

    // ********************************************************************
    //
    // ********************************************************************

    private Map<String, PropertyMapping> propertyMappings = new HashMap<>(0);

    private String tableName;

    private Class<?> type;

    /**
     * @return 返回tableName
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * @return 返回type
     */
    public Class<?> getType() {
        return type;
    }
}
