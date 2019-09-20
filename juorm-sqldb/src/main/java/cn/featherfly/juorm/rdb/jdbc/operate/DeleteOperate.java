package cn.featherfly.juorm.rdb.jdbc.operate;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.juorm.mapping.ClassMapping;
import cn.featherfly.juorm.mapping.PropertyMapping;
import cn.featherfly.juorm.rdb.jdbc.Jdbc;

/**
 * <p>
 * 删除操作
 * </p>
 *
 * @param <T>
 *            对象类型
 * @author zhongj
 * @since 1.0
 * @version 1.0
 */
public class DeleteOperate<T> extends AbstractExecuteOperate<T> {
    /**
     * 使用给定数据源以及给定对象生成删除操作.
     *
     * @param jdbc
     *            jdbc
     * @param classMapping
     *            classMapping
     */
    public DeleteOperate(Jdbc jdbc, ClassMapping<T> classMapping) {
        super(jdbc, classMapping);
    }

    /**
     * 使用给定数据源以及给定对象生成删除操作.
     *
     * @param jdbc
     *            jdbc
     * @param classMapping
     *            classMapping
     * @param dataBase
     *            具体库
     */
    public DeleteOperate(Jdbc jdbc, ClassMapping<T> classMapping,
            String dataBase) {
        super(jdbc, classMapping, dataBase);
    }

    /**
     * @param jdbc
     * @param classMapping
     * @param databaseMetadata
     */
    public DeleteOperate(Jdbc jdbc, ClassMapping<T> classMapping,
            DatabaseMetadata databaseMetadata) {
        super(jdbc, classMapping, databaseMetadata);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initSql() {
        StringBuilder deleteSql = new StringBuilder();
        deleteSql.append(jdbc.getDialect().getKeywords().delete())
                .append(Chars.SPACE)
                .append(jdbc.getDialect().getKeywords().from())
                .append(Chars.SPACE)
                .append(jdbc.getDialect()
                        .wrapName(classMapping.getRepositoryName()))
                .append(Chars.SPACE)
                .append(jdbc.getDialect().getKeywords().where())
                .append(Chars.SPACE);
        int columnNum = 0;
        for (PropertyMapping propertyMapping : classMapping
                .getPropertyMappings()) {
            if (LangUtils.isEmpty(propertyMapping.getPropertyMappings())) {
                if (propertyMapping.isPrimaryKey()) {
                    if (columnNum > 0) {
                        deleteSql.append(jdbc.getDialect().getKeywords().and())
                                .append(Chars.SPACE);
                    }
                    deleteSql
                            .append(jdbc.getDialect().wrapName(
                                    propertyMapping.getRepositoryFieldName()))
                            .append(" = ? ");
                    columnNum++;
                    propertyPositions.put(columnNum,
                            propertyMapping.getPropertyName());
                }
            } else {
                for (PropertyMapping subPropertyMapping : propertyMapping
                        .getPropertyMappings()) {
                    if (subPropertyMapping.isPrimaryKey()) {
                        if (columnNum > 0) {
                            deleteSql.append(
                                    jdbc.getDialect().getKeywords().and())
                                    .append(Chars.SPACE);
                        }
                        deleteSql
                                .append(jdbc.getDialect()
                                        .wrapName(subPropertyMapping
                                                .getRepositoryFieldName()))
                                .append(" = ? ");
                        columnNum++;
                        propertyPositions.put(columnNum,
                                propertyMapping.getPropertyName() + "."
                                        + subPropertyMapping.getPropertyName());
                    }
                }
            }
        }

        sql = deleteSql.toString();
        logger.debug("sql: {}", sql);
    }
}
