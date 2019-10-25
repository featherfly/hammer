package cn.featherfly.juorm.rdb.jdbc.operate;

import java.util.ArrayList;
import java.util.List;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.juorm.mapping.ClassMapping;
import cn.featherfly.juorm.mapping.PropertyMapping;
import cn.featherfly.juorm.rdb.jdbc.Jdbc;

/**
 * <p>
 * 更新操作
 * </p>
 *
 * @param <T> 对象类型
 * @author zhongj
 * @since 1.0
 * @version 1.0
 */
public class UpdateOperate<T> extends AbstractExecuteOperate<T> {

    /**
     * 使用给定数据源以及给定对象生成更新操作.
     *
     * @param jdbc         jdbc
     * @param classMapping classMapping
     */
    public UpdateOperate(Jdbc jdbc, ClassMapping<T> classMapping) {
        super(jdbc, classMapping);
    }

    /**
     * 使用给定数据源以及给定对象生成更新操作.
     *
     * @param jdbc         jdbc
     * @param classMapping classMapping
     * @param dataBase     具体库
     */
    public UpdateOperate(Jdbc jdbc, ClassMapping<T> classMapping, String dataBase) {
        super(jdbc, classMapping, dataBase);
    }

    /**
     * 使用给定数据源以及给定对象生成更新操作.
     *
     * @param jdbc             the jdbc
     * @param classMapping     the class mapping
     * @param databaseMetadata the database metadata
     */
    public UpdateOperate(Jdbc jdbc, ClassMapping<T> classMapping, DatabaseMetadata databaseMetadata) {
        super(jdbc, classMapping, databaseMetadata);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initSql() {
        StringBuilder updateSql = new StringBuilder();
        updateSql.append(jdbc.getDialect().getKeywords().update()).append(Chars.SPACE)
                .append(jdbc.getDialect().wrapName(classMapping.getRepositoryName())).append(Chars.SPACE)
                .append(jdbc.getDialect().getKeywords().set()).append(Chars.SPACE);
        int columnNum = 0;

        List<PropertyMapping> pms = new ArrayList<>();
        for (PropertyMapping propertyMapping : classMapping.getPropertyMappings()) {
            if (LangUtils.isEmpty(propertyMapping.getPropertyMappings())) {
                if (propertyMapping.isPrimaryKey()) {
                    pms.add(propertyMapping);
                } else {
                    updateSql.append(jdbc.getDialect().wrapName(propertyMapping.getRepositoryFieldName()))
                            .append(" = ? ,");
                    columnNum++;
                    propertyPositions.put(columnNum, propertyMapping.getPropertyName());
                }
            } else {
                for (PropertyMapping subPropertyMapping : propertyMapping.getPropertyMappings()) {
                    if (subPropertyMapping.isPrimaryKey()) {
                        pms.add(subPropertyMapping);
                    } else {
                        updateSql.append(jdbc.getDialect().wrapName(subPropertyMapping.getRepositoryFieldName()))
                                .append(" = ? ,");
                        columnNum++;
                        propertyPositions.put(columnNum,
                                propertyMapping.getPropertyName() + Chars.DOT + subPropertyMapping.getPropertyName());
                    }
                }
            }
        }
        if (columnNum > 0) {
            updateSql.deleteCharAt(updateSql.length() - 1);
        }
        int pkNum = 0;
        updateSql.append("where ");
        for (PropertyMapping pm : pms) {
            if (pkNum > 0) {
                updateSql.append(jdbc.getDialect().getKeywords().and()).append(Chars.SPACE);
            }
            updateSql.append(jdbc.getDialect().wrapName(pm.getRepositoryFieldName())).append(" = ? ");
            pkNum++;
            if (pm.getParent() == null) {
                propertyPositions.put(columnNum + pkNum, pm.getPropertyName());
            } else {
                propertyPositions.put(columnNum + pkNum,
                        pm.getParent().getPropertyName() + Chars.DOT + pm.getPropertyName());
            }
        }
        sql = updateSql.toString();
        logger.debug("sql: {}", sql);
    }
}
