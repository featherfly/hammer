
package cn.featherfly.juorm.jdbc.mapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Id;

import cn.featherfly.common.bean.BeanDescriptor;
import cn.featherfly.common.bean.BeanProperty;
import cn.featherfly.common.bean.matcher.BeanPropertyAnnotationMatcher;
import cn.featherfly.common.bean.matcher.BeanPropertyNameRegexMatcher;
import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.metadata.ColumnMetadata;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.db.metadata.TableMetadata;
import cn.featherfly.common.enums.Logic;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.common.lang.SystemPropertyUtils;
import cn.featherfly.common.lang.WordUtils;
import cn.featherfly.juorm.jdbc.Constants;
import cn.featherfly.juorm.jdbc.JuormJdbcException;
import cn.featherfly.juorm.mapping.ClassNameConversion;
import cn.featherfly.juorm.mapping.PropertyNameConversion;
import cn.featherfly.juorm.sql.dialect.Dialect;

/**
 * <p>
 * MapperFactory
 * </p>
 *
 * @author zhongj
 */
public class MappingFactory {

    private final Map<Class<?>, ClassMapping<?>> mappedTypes = new HashMap<>();

    private DatabaseMetadata metadata;

    private Dialect dialect;

    private List<ClassNameConversion> classNameConversions = new ArrayList<>();

    private List<PropertyNameConversion> propertyNameConversions = new ArrayList<>();

    /**
     * @param metadata DatabaseMetadata
     * @param dialect  dialect
     */
    public MappingFactory(DatabaseMetadata metadata, Dialect dialect) {
        super();
        this.metadata = metadata;
        this.dialect = dialect;
    }

    /**
     * 返回classNameConversions
     *
     * @return classNameConversions
     */
    public List<ClassNameConversion> getClassNameConversions() {
        return classNameConversions;
    }

    /**
     * 设置classNameConversions
     *
     * @param classNameConversions classNameConversions
     */
    public void setClassNameConversions(List<ClassNameConversion> classNameConversions) {
        this.classNameConversions = classNameConversions;
    }

    /**
     * 返回propertyNameConversions
     *
     * @return propertyNameConversions
     */
    public List<PropertyNameConversion> getPropertyNameConversions() {
        return propertyNameConversions;
    }

    /**
     * 设置propertyNameConversions
     *
     * @param propertyNameConversions propertyNameConversions
     */
    public void setPropertyNameConversions(List<PropertyNameConversion> propertyNameConversions) {
        this.propertyNameConversions = propertyNameConversions;
    }

    /**
     * 返回metadata
     *
     * @return metadata
     */
    public DatabaseMetadata getMetadata() {
        return metadata;
    }

    public <T> ClassMapping<T> getClassMapping(Class<T> type) {
        @SuppressWarnings("unchecked")
        ClassMapping<T> classMapping = (ClassMapping<T>) mappedTypes.get(type);
        if (classMapping == null) {
            classMapping = createClassMapping(type);
            mappedTypes.put(type, classMapping);
        }
        return classMapping;
    }

    private <T> ClassMapping<T> createClassMapping(Class<T> type) {
        Map<String, PropertyMapping> tableMapping = new HashMap<>();

        StringBuilder logInfo = new StringBuilder();
        //          // 从对象中读取有Column的列，找到显示映射，使用scan扫描
        BeanDescriptor<T> bd = BeanDescriptor.getBeanDescriptor(type);
        String tableName = getMappingTableName(type);
        tableName = dialect.convertTableOrColumnName(tableName);

        if (Constants.LOGGER.isDebugEnabled()) {
            logInfo.append(
                    String.format("###%s类%s映射到表%s", SystemPropertyUtils.getLineSeparator(), type.getName(), tableName));
        }

        Collection<BeanProperty<?>> bps = bd
                .findBeanPropertys(new BeanPropertyAnnotationMatcher(Logic.OR, Column.class, Id.class));
        boolean findPk = false;
        for (BeanProperty<?> beanProperty : bps) {
            if (mappingWithJpa(beanProperty, tableMapping, logInfo)) {
                findPk = true;
            }
        }
        if (!findPk) {
            throw new JuormJdbcException("#id.map.not.exists", new Object[] { type.getName() });
        }

        TableMetadata tm = metadata.getTable(tableName);
        if (tm == null) {
            throw new JuormJdbcException("#talbe.not.exists", new Object[] { tableName });
        }
        for (ColumnMetadata cmd : tm.getColumns()) {
            mappingFromColumnMetadata(bd, tableMapping, cmd, logInfo);
        }
        if (Constants.LOGGER.isDebugEnabled()) {
            Constants.LOGGER.debug(logInfo.toString());
        }
        // 形成映射对象
        ClassMapping<T> classMapping = new ClassMapping<>(type, tableName);
        classMapping.addPropertyMappings(tableMapping.values());
        return classMapping;
    }

    private boolean mappingWithJpa(BeanProperty<?> beanProperty, Map<String, PropertyMapping> tableMapping,
            StringBuilder logInfo) {
        PropertyMapping mapping = new PropertyMapping();
        String columnName = getMappingColumnName(beanProperty);
        mapping.setColumnName(columnName.toUpperCase());

        columnName = dialect.convertTableOrColumnName(columnName);
        mapping.setColumnName(columnName);
        mapping.setPropertyName(beanProperty.getName());
        mapping.setPropertyType(beanProperty.getType());

        boolean hasPk = beanProperty.hasAnnotation(Id.class);
        mapping.setPrimaryKey(hasPk);
        tableMapping.put(mapping.getColumnName(), mapping);

        if (Constants.LOGGER.isDebugEnabled()) {
            logInfo.append(String.format("%s###\t%s -> %s", SystemPropertyUtils.getLineSeparator(),
                    mapping.getPropertyName(), mapping.getColumnName()));
        }
        return hasPk;
    }

    private <T> void mappingFromColumnMetadata(BeanDescriptor<T> bd, Map<String, PropertyMapping> tableMapping,
            ColumnMetadata cmd, StringBuilder logInfo) {
        if (!tableMapping.containsKey(cmd.getName())) {
            // 转换下划线，并使用驼峰
            String columnName = cmd.getName().toLowerCase();
            String propertyName = WordUtils.parseToUpperFirst(columnName, Chars.UNDER_LINE.charAt(0));
            BeanProperty<?> beanProperty = bd.findBeanProperty(new BeanPropertyNameRegexMatcher(propertyName));
            if (beanProperty != null) {
                PropertyMapping mapping = new PropertyMapping();
                mapping.setPropertyType(beanProperty.getType());
                mapping.setPropertyName(propertyName);
                mapping.setColumnName(columnName.toUpperCase());
                mapping.setPrimaryKey(cmd.isPrimaryKey());
                tableMapping.put(mapping.getColumnName(), mapping);
                if (Constants.LOGGER.isDebugEnabled()) {
                    logInfo.append(String.format("%s###\t%s -> %s", SystemPropertyUtils.getLineSeparator(),
                            mapping.getPropertyName(), mapping.getColumnName()));
                }
            } else {
                if (Constants.LOGGER.isDebugEnabled()) {
                    logInfo.append(String.format("%s\t没有属性 -> %s [列%s的隐式映射]", SystemPropertyUtils.getLineSeparator(),
                            propertyName, cmd.getName()));
                }
            }
        }
    }

    private String getMappingTableName(Class<?> type) {
        String tableName = null;
        for (ClassNameConversion classNameConversion : classNameConversions) {
            tableName = classNameConversion.getMappingName(type);
            if (LangUtils.isNotEmpty(tableName)) {
                return tableName;
            }
        }
        return type.getSimpleName();
    }

    private String getMappingColumnName(BeanProperty<?> type) {
        String columnName = null;
        for (PropertyNameConversion propertyNameConversion : propertyNameConversions) {
            columnName = propertyNameConversion.getMappingName(type);
            if (LangUtils.isNotEmpty(columnName)) {
                return columnName;
            }
        }
        return type.getName();
    }

}
