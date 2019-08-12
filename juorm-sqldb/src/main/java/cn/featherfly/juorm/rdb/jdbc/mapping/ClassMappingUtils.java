
package cn.featherfly.juorm.rdb.jdbc.mapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.common.lang.StringUtils;
import cn.featherfly.juorm.rdb.sql.dialect.Dialect;

/**
 * <p>
 * ClassMappingUtils
 * </p>
 *
 * @author zhongj
 */
public class ClassMappingUtils {
    public static String getSelectSql(ClassMapping<?> classMapping, Dialect dialect) {
        // StringBuilder selectSql = new StringBuilder();
        // selectSql.append("select ");
        // int columnNum = 0;
        // for (PropertyMapping propertyMapping :
        // classMapping.getPropertyMappings()) {
        // selectSql.append(propertyMapping.getColumnName()).append(" as
        // ").append(propertyMapping.getPropertyName())
        // .append(",");
        // columnNum++;
        // }
        // if (columnNum > 0) {
        // selectSql.deleteCharAt(selectSql.length() - 1);
        // }
        // selectSql.append(" from ").append(classMapping.getTableName());
        // return selectSql.toString();
        return getSelectSql(classMapping, null, dialect);
    }

    public static String getSelectSql(ClassMapping<?> classMapping, String alias, Dialect dialect) {
        StringBuilder selectSql = new StringBuilder();
        selectSql.append("select ");
        selectSql.append(getSelectColumnsSql(classMapping, alias, dialect));
        selectSql.append(" from ").append(classMapping.getTableName());
        return selectSql.toString();
    }

    public static String getSelectColumnsSql(ClassMapping<?> classMapping, String alias, Dialect dialect) {
        StringBuilder selectSql = new StringBuilder();
        int columnNum = 0;
        for (PropertyMapping propertyMapping : classMapping.getPropertyMappings()) {
            if (LangUtils.isEmpty(propertyMapping.getPropertyMappings())) {
                if (StringUtils.isNotBlank(alias)) {
                    selectSql.append(alias).append(".").append(dialect.wrapName(propertyMapping.getColumnName()))
                            .append(" ").append(dialect.wrapName(propertyMapping.getPropertyName())).append(",");
                } else {
                    selectSql.append(dialect.wrapName(propertyMapping.getColumnName())).append(" ")
                            .append(dialect.wrapName(propertyMapping.getPropertyName())).append(",");
                }
                columnNum++;
            } else {
                for (PropertyMapping pm : propertyMapping.getPropertyMappings()) {
                    if (StringUtils.isNotBlank(alias)) {
                        selectSql.append(alias).append(".").append(dialect.wrapName(pm.getColumnName())).append(" ")
                                .append(dialect
                                        .wrapName(propertyMapping.getPropertyName() + "." + pm.getPropertyName()))
                                .append(",");
                    } else {
                        selectSql.append(dialect.wrapName(pm.getColumnName())).append(" ")
                                .append(dialect
                                        .wrapName(propertyMapping.getPropertyName() + "." + pm.getPropertyName()))
                                .append(",");
                    }
                    columnNum++;
                }
            }
        }
        if (columnNum > 0) {
            selectSql.deleteCharAt(selectSql.length() - 1);
        }
        return selectSql.toString();
    }

    public static Map<String, String> getSelectColumns(ClassMapping<?> classMapping) {
        Map<String, String> columns = new HashMap<>();
        for (PropertyMapping propertyMapping : classMapping.getPropertyMappings()) {
            if (LangUtils.isEmpty(propertyMapping.getPropertyMappings())) {
                columns.put(propertyMapping.getColumnName(), propertyMapping.getPropertyName());
            } else {
                for (PropertyMapping pm : propertyMapping.getPropertyMappings()) {
                    columns.put(pm.getColumnName(), propertyMapping.getPropertyName() + "." + pm.getPropertyName());
                }
            }
        }
        return columns;
    }

    /**
     * 根据传入name获取对应的columnName
     *
     * @param name         property name or column name
     * @param classMapping classMapping
     * @return columnName
     */
    public static String getColumnName(String name, ClassMapping<?> classMapping) {
        if (classMapping != null && LangUtils.isNotEmpty(name)) {
            if (name.contains(".")) {
                String[] names = name.split("\\.");
                return getNestedColumnName(names, classMapping);
            } else {
                return getSimpleColumnName(name, classMapping);
            }
        }
        return name;
    }

    private static String getSimpleColumnName(String name, ClassMapping<?> classMapping) {
        PropertyMapping pm = classMapping.getPropertyMapping(name);
        if (pm != null) {
            return pm.getColumnName();
        }
        return name;
    }

    private static String getNestedColumnName(String[] names, ClassMapping<?> classMapping) {
        PropertyMapping pm = null;
        for (String n : names) {
            if (pm == null) {
                pm = classMapping.getPropertyMapping(n);
            } else {
                pm = pm.getPropertyMapping(n);
            }
        }
        if (pm != null) {
            return pm.getColumnName();
        } else {
            return null;
        }
    }

    /**
     * 根据传入name获取对应的columnName array
     *
     * @param classMapping classMapping
     * @param names        property name or column name array
     * @return columnNames
     */
    public static String[] getColumnNames(ClassMapping<?> classMapping, String... names) {
        if (classMapping != null) {
            List<String> newNames = new ArrayList<>();
            for (String name : names) {
                newNames.add(getColumnName(name, classMapping));
            }
            return newNames.toArray(new String[] {});
            //            return CollectionUtils.toArray(newNames, String.class);
        }
        return names;
    }

    /**
     * 根据传入name获取对应的columnName array
     *
     * @param classMapping classMapping
     * @param names        property name or column name collection
     * @return columnNames
     */
    public static String[] getColumnNames(ClassMapping<?> classMapping, Collection<String> names) {
        if (names == null) {
            names = new ArrayList<>();
        }
        return getColumnNames(classMapping, names.toArray(new String[] {}));
    }

}
