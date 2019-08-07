
package cn.featherfly.juorm.rdb.jdbc.mapping;

import java.util.HashMap;
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
    public static String getSelectSql(ClassMapping<?> classMapping,
            Dialect dialect) {
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

    public static String getSelectSql(ClassMapping<?> classMapping,
            String alias, Dialect dialect) {
        StringBuilder selectSql = new StringBuilder();
        selectSql.append("select ");
        selectSql.append(getSelectColumnsSql(classMapping, alias, dialect));
        selectSql.append(" from ").append(classMapping.getTableName());
        return selectSql.toString();
    }

    public static String getSelectColumnsSql(ClassMapping<?> classMapping,
            String alias, Dialect dialect) {
        StringBuilder selectSql = new StringBuilder();
        int columnNum = 0;
        for (PropertyMapping propertyMapping : classMapping
                .getPropertyMappings()) {
            if (LangUtils.isEmpty(propertyMapping.getPropertyMappings())) {
                if (StringUtils.isNotBlank(alias)) {
                    selectSql.append(alias).append(".")
                            .append(dialect
                                    .wrapName(propertyMapping.getColumnName()))
                            .append(" ")
                            .append(propertyMapping.getPropertyName())
                            .append(",");
                } else {
                    selectSql
                            .append(dialect
                                    .wrapName(propertyMapping.getColumnName()))
                            .append(" ")
                            .append(propertyMapping.getPropertyName())
                            .append(",");
                }
                columnNum++;
            } else {
                for (PropertyMapping pm : propertyMapping
                        .getPropertyMappings()) {
                    if (StringUtils.isNotBlank(alias)) {
                        selectSql.append(alias).append(".")
                                .append(dialect.wrapName(pm.getColumnName()))
                                .append(" ")
                                .append(dialect.wrapName(
                                        propertyMapping.getPropertyName() + "."
                                                + pm.getPropertyName()))
                                .append(",");
                    } else {
                        selectSql.append(dialect.wrapName(pm.getColumnName()))
                                .append(" ")
                                .append(dialect.wrapName(
                                        propertyMapping.getPropertyName() + "."
                                                + pm.getPropertyName()))
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

    public static Map<String, String> getSelectColumns(
            ClassMapping<?> classMapping) {
        Map<String, String> columns = new HashMap<>();
        for (PropertyMapping propertyMapping : classMapping
                .getPropertyMappings()) {
            if (LangUtils.isEmpty(propertyMapping.getPropertyMappings())) {
                columns.put(propertyMapping.getColumnName(),
                        propertyMapping.getPropertyName());
            } else {
                for (PropertyMapping pm : propertyMapping
                        .getPropertyMappings()) {
                    columns.put(pm.getColumnName(),
                            propertyMapping.getPropertyName() + "."
                                    + pm.getPropertyName());
                }
            }
        }
        return columns;
    }

}
