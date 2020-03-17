package cn.featherfly.hammer.sqldb.jdbc.operate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.featherfly.common.bean.BeanUtils;
import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.hammer.mapping.ClassMapping;
import cn.featherfly.hammer.mapping.PropertyMapping;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.mapping.ClassMappingUtils;

/**
 * <p>
 * 合并操作
 * </p>
 *
 * @param <T> 对象类型
 * @author zhongj
 * @since 1.0
 * @version 1.0
 */
public class MergeOperate<T> extends AbstractOperate<T> {
    /**
     * 使用给定数据源以及给定对象生成更新操作.
     *
     * @param jdbc         jdbc
     * @param classMapping classMapping
     */
    public MergeOperate(Jdbc jdbc, ClassMapping<T> classMapping) {
        super(jdbc, classMapping);
    }

    /**
     * 使用给定数据源以及给定对象生成更新操作.
     *
     * @param jdbc         jdbc
     * @param classMapping classMapping
     * @param dataBase     具体库
     */
    public MergeOperate(Jdbc jdbc, ClassMapping<T> classMapping, String dataBase) {
        super(jdbc, classMapping, dataBase);
    }

    /**
     * 使用给定数据源以及给定对象生成更新操作.
     *
     * @param jdbc             the jdbc
     * @param classMapping     the class mapping
     * @param databaseMetadata the database metadata
     */
    public MergeOperate(Jdbc jdbc, ClassMapping<T> classMapping, DatabaseMetadata databaseMetadata) {
        super(jdbc, classMapping, databaseMetadata);
    }

    /**
     * <p>
     * 合并操作，将传入对象的非空字段更新进数据库（忽略null）.
     * </p>
     *
     * @param entity   对象
     * @param onlyNull only null
     * @return 操作影响的数据行数
     */
    public int execute(final T entity, boolean onlyNull) {
        Map<Integer, String> propertyPositions = new HashMap<>();
        String sql = getDynamicSql(entity, propertyPositions, onlyNull);
        return jdbc.update(sql, getParameters(entity, propertyPositions));
    }

    private String getDynamicSql(T entity, Map<Integer, String> propertyPositions, boolean onlyNull) {
        StringBuilder updateSql = new StringBuilder();
        updateSql.append(jdbc.getDialect().getKeywords().update()).append(Chars.SPACE)
                .append(jdbc.getDialect().wrapName(classMapping.getRepositoryName())).append(Chars.SPACE)
                .append(jdbc.getDialect().getKeywords().set()).append(Chars.SPACE);
        int columnNum = 0;
        List<PropertyMapping> pkms = new ArrayList<>();
        for (PropertyMapping propertyMapping : classMapping.getPropertyMappings()) {
            if (propertyMapping.getPropertyMappings().isEmpty()) {
                // 如果为空忽略 ignore when null
                if (checkNullOrEmpty(entity, propertyMapping, onlyNull)) {
                    continue;
                }
                if (propertyMapping.isPrimaryKey()) {
                    pkms.add(propertyMapping);
                } else {
                    columnNum = set(entity, propertyMapping, updateSql, propertyPositions, columnNum);
                }
            } else {
                for (PropertyMapping subPropertyMapping : propertyMapping.getPropertyMappings()) {
                    if (checkNullOrEmpty(entity, subPropertyMapping, onlyNull)) {
                        continue;
                    }
                    if (subPropertyMapping.isPrimaryKey()) {
                        pkms.add(subPropertyMapping);
                    } else {
                        columnNum = set(entity, subPropertyMapping, updateSql, propertyPositions, columnNum);
                    }
                }
            }
        }
        if (columnNum > 0) {
            updateSql.deleteCharAt(updateSql.length() - 1);
        }
        int pkNum = 0;
        updateSql.append(jdbc.getDialect().getKeywords().where()).append(Chars.SPACE);
        for (PropertyMapping pm : pkms) {
            if (pkNum > 0) {
                updateSql.append(jdbc.getDialect().getKeywords().and()).append(Chars.SPACE);
            }
            updateSql.append(jdbc.getDialect().wrapName(pm.getRepositoryFieldName())).append(" = ? ");
            pkNum++;
            propertyPositions.put(columnNum + pkNum, ClassMappingUtils.getPropertyAliasName(pm));
        }
        sql = updateSql.toString();
        return updateSql.toString();
    }

    private boolean checkNullOrEmpty(T entity, PropertyMapping propertyMapping, boolean onlyNull) {
        String pn = ClassMappingUtils.getPropertyAliasName(propertyMapping);
        if (onlyNull) {
            return BeanUtils.getProperty(entity, pn) == null;
        } else {
            return LangUtils.isEmpty(BeanUtils.getProperty(entity, pn));
        }
    }

    private int set(T entity, PropertyMapping propertyMapping, StringBuilder updateSql,
            Map<Integer, String> propertyPositions, int columnNum) {
        updateSql.append(jdbc.getDialect().wrapName(propertyMapping.getRepositoryFieldName())).append(" = ? ,");
        columnNum++;
        propertyPositions.put(columnNum, ClassMappingUtils.getPropertyAliasName(propertyMapping));
        return columnNum;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initSql() {
        // 不需要实现
    }
}
