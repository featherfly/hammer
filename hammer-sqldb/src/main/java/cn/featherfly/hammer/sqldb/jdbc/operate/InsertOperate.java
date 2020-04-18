package cn.featherfly.hammer.sqldb.jdbc.operate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.featherfly.common.bean.BeanUtils;
import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.JdbcUtils;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * <p>
 * 插入操作
 * </p>
 *
 * @param <T> 对象类型
 * @author zhongj
 * @since 1.0
 * @version 1.0
 */
public class InsertOperate<T> extends AbstractExecuteOperate<T> {

    /**
     * 使用给定数据源以及给定对象生成插入操作.
     *
     * @param jdbc         jdbc
     * @param classMapping classMapping
     */
    public InsertOperate(Jdbc jdbc, ClassMapping<T> classMapping) {
        super(jdbc, classMapping);
    }

    /**
     * 使用给定数据源以及给定对象生成插入操作.
     *
     * @param jdbc         jdbc
     * @param classMapping classMapping
     * @param dataBase     具体库
     */
    public InsertOperate(Jdbc jdbc, ClassMapping<T> classMapping, String dataBase) {
        super(jdbc, classMapping, dataBase);
    }

    /**
     * 使用给定数据源以及给定对象生成插入操作.
     *
     * @param jdbc             the jdbc
     * @param classMapping     the class mapping
     * @param databaseMetadata the database metadata
     */
    public InsertOperate(Jdbc jdbc, ClassMapping<T> classMapping, DatabaseMetadata databaseMetadata) {
        super(jdbc, classMapping, databaseMetadata);
    }

    /**
     * <p>
     * 执行操作. 操作的类型由具体子类构造的不同SQL来区分.
     * </p>
     *
     * @param entity 对象
     * @return 操作影响的数据行数
     */
    @Override
    public int execute(final T entity) {
        return jdbc.execute(con -> {
            List<PropertyMapping> pks = classMapping.getPrivaryKeyPropertyMappings();
            PreparedStatement prep = null;
            if (pks.size() == 1) {
                prep = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            } else {
                prep = con.prepareStatement(sql);
            }
            setParameter(prep, entity);
            logger.debug("execute sql: {}", sql);
            int result = prep.executeUpdate();

            if (pks.size() == 1) {
                PropertyMapping pm = pks.get(0);
                ResultSet res = prep.getGeneratedKeys();
                StringBuilder msg = null;
                if (logger.isDebugEnabled()) {
                    msg = new StringBuilder("自动生成的键值 : ");
                }
                if (res.next()) {
                    Object value = JdbcUtils.getResultSetValue(res, 1, pm.getPropertyType());
                    if (logger.isDebugEnabled()) {
                        msg.append(" ").append(value).append(", ");
                    }
                    BeanUtils.setProperty(entity, pm.getPropertyName(), value);
                }
                if (logger.isDebugEnabled()) {
                    logger.debug(msg.toString());
                }
            }
            prep.close();
            return result;
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initSql() {
        StringBuilder insertSql = new StringBuilder();
        insertSql.append(jdbc.getDialect().getKeywords().insert()).append(Chars.SPACE)
                .append(jdbc.getDialect().getKeywords().into()).append(Chars.SPACE)
                .append(jdbc.getDialect().wrapName(classMapping.getRepositoryName())).append(" ( ");
        List<PropertyMapping> pms = new ArrayList<>();
        for (PropertyMapping pm : classMapping.getPropertyMappings()) {
            if (LangUtils.isEmpty(pm.getPropertyMappings())) {
                insertSql.append(jdbc.getDialect().wrapName(pm.getRepositoryFieldName())).append(",");
                pms.add(pm);
                // propertyPositions.put(pms.size(), pm.getPropertyName());
            } else {
                for (PropertyMapping pm2 : pm.getPropertyMappings()) {
                    insertSql.append(jdbc.getDialect().wrapName(pm2.getRepositoryFieldName())).append(",");
                    pms.add(pm2);
                    // propertyPositions.put(pms.size(), pm.getPropertyName() +
                    // "." + pm2.getPropertyName());
                }
            }
        }
        if (pms.size() > 0) {
            insertSql.deleteCharAt(insertSql.length() - 1);
        }
        insertSql.append(" ) ").append(jdbc.getDialect().getKeywords().values()).append(" ( ");
        int paramNum = 0;
        for (int i = 0; i < pms.size(); i++) {
            PropertyMapping pm = pms.get(i);
            if (pm.isPrimaryKey() && pm.getDefaultValue() != null && !"null".equalsIgnoreCase(pm.getDefaultValue())) {
                insertSql.append(pm.getDefaultValue()).append(",");
            } else {
                paramNum++;
                insertSql.append("?").append(",");
                if (pm.getParent() == null) {
                    propertyPositions.put(paramNum, pm.getPropertyName());
                } else {
                    propertyPositions.put(paramNum, pm.getParent().getPropertyName() + "." + pm.getPropertyName());
                }
            }
        }
        if (pms.size() > 0) {
            insertSql.deleteCharAt(insertSql.length() - 1);
        }
        insertSql.append(" )");
        sql = insertSql.toString();
        logger.debug("sql: {}", sql);
    }
}
