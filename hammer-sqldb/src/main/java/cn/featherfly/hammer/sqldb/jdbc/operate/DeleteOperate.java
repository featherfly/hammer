package cn.featherfly.hammer.sqldb.jdbc.operate;

import java.io.Serializable;
import java.sql.PreparedStatement;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * <p>
 * 删除操作
 * </p>
 *
 * @param <T> 对象类型
 * @author zhongj
 * @since 1.0
 * @version 1.0
 */
public class DeleteOperate<T> extends AbstractExecuteOperate<T> {
    /**
     * 使用给定数据源以及给定对象生成删除操作.
     *
     * @param jdbc         jdbc
     * @param classMapping classMapping
     */
    public DeleteOperate(Jdbc jdbc, ClassMapping<T> classMapping) {
        super(jdbc, classMapping);
    }

    /**
     * 使用给定数据源以及给定对象生成删除操作.
     *
     * @param jdbc         jdbc
     * @param classMapping classMapping
     * @param dataBase     具体库
     */
    public DeleteOperate(Jdbc jdbc, ClassMapping<T> classMapping, String dataBase) {
        super(jdbc, classMapping, dataBase);
    }

    /**
     * 使用给定数据源以及给定对象生成删除操作.
     *
     * @param jdbc             the jdbc
     * @param classMapping     the class mapping
     * @param databaseMetadata the database metadata
     */
    public DeleteOperate(Jdbc jdbc, ClassMapping<T> classMapping, DatabaseMetadata databaseMetadata) {
        super(jdbc, classMapping, databaseMetadata);
    }

    /**
     * <p>
     * 删除指定id
     * </p>
     *
     * @param id id
     * @return 操作影响的数据行数
     */
    public int delete(Serializable id) {
        return jdbc.execute(con -> {
            PreparedStatement prep = null;
            prep = con.prepareStatement(sql);
            setParameter(prep, id);
            logger.debug("execute sql: {}", sql);
            int result = prep.executeUpdate();
            prep.close();
            return result;
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initSql() {
        StringBuilder deleteSql = new StringBuilder();
        deleteSql.append(jdbc.getDialect().getKeywords().delete()).append(Chars.SPACE)
                .append(jdbc.getDialect().getKeywords().from()).append(Chars.SPACE)
                .append(jdbc.getDialect().wrapName(classMapping.getRepositoryName())).append(Chars.SPACE)
                .append(jdbc.getDialect().getKeywords().where()).append(Chars.SPACE);
        int columnNum = 0;
        for (PropertyMapping propertyMapping : classMapping.getPropertyMappings()) {
            if (LangUtils.isEmpty(propertyMapping.getPropertyMappings())) {
                if (propertyMapping.isPrimaryKey()) {
                    if (columnNum > 0) {
                        deleteSql.append(jdbc.getDialect().getKeywords().and()).append(Chars.SPACE);
                    }
                    deleteSql.append(jdbc.getDialect().wrapName(propertyMapping.getRepositoryFieldName()))
                            .append(" = ? ");
                    columnNum++;
                    propertyPositions.put(columnNum, propertyMapping.getPropertyName());
                }
            } else {
                for (PropertyMapping subPropertyMapping : propertyMapping.getPropertyMappings()) {
                    if (subPropertyMapping.isPrimaryKey()) {
                        if (columnNum > 0) {
                            deleteSql.append(jdbc.getDialect().getKeywords().and()).append(Chars.SPACE);
                        }
                        deleteSql.append(jdbc.getDialect().wrapName(subPropertyMapping.getRepositoryFieldName()))
                                .append(" = ? ");
                        columnNum++;
                        propertyPositions.put(columnNum,
                                propertyMapping.getPropertyName() + "." + subPropertyMapping.getPropertyName());
                    }
                }
            }
        }

        sql = deleteSql.toString();
        logger.debug("sql: {}", sql);
    }
}
