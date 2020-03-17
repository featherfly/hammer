
package cn.featherfly.hammer.sqldb.jdbc.operate;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;

import cn.featherfly.common.bean.BeanUtils;
import cn.featherfly.common.db.JdbcUtils;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.db.metadata.DatabaseMetadataManager;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.hammer.mapping.ClassMapping;
import cn.featherfly.hammer.sqldb.Constants;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * <p>
 * 数据库操作的抽象类
 * </p>
 *
 * @param <T> 类型
 * @author zhongj
 * @since 1.0
 * @version 1.0
 */
public abstract class AbstractOperate<T> {

    /**
     * logger
     */
    protected final Logger logger = Constants.LOGGER;

    /**
     * sql 语句
     */
    protected String sql;
    /**
     * jdbc
     */
    protected Jdbc jdbc;
    /**
     * 类型映射
     */
    protected ClassMapping<T> classMapping;
    /**
     * 数据库元数据
     */
    protected DatabaseMetadata meta;
    /**
     * 属性在SQL中出现的位置，即SQL语句中每个问号对应的对象属性
     */
    protected Map<Integer, String> propertyPositions = new HashMap<>(0);

    /**
     * 使用给定数据源以及给定对象映射生成其相应的操作.
     *
     * @param jdbc         jdbc
     * @param classMapping classMapping
     */
    public AbstractOperate(Jdbc jdbc, ClassMapping<T> classMapping) {
        this(jdbc, classMapping, "");
    }

    /**
     * 使用给定数据源以及给定对象生成其相应的操作.
     *
     * @param jdbc         jdbc
     * @param classMapping classMapping
     * @param dataBase     具体库
     */
    public AbstractOperate(Jdbc jdbc, ClassMapping<T> classMapping, String dataBase) {
        if (LangUtils.isEmpty(dataBase)) {
            meta = DatabaseMetadataManager.getDefaultManager().create(jdbc.getDataSource());
        } else {
            meta = DatabaseMetadataManager.getDefaultManager().create(jdbc.getDataSource(), dataBase);
        }
        this.jdbc = jdbc;
        this.classMapping = classMapping;
        initSql();
    }

    /**
     * 使用给定数据源以及给定对象生成其相应的操作.
     *
     * @param jdbc             jdbc
     * @param classMapping     classMapping
     * @param databaseMetadata databaseMetadata
     */
    public AbstractOperate(Jdbc jdbc, ClassMapping<T> classMapping, DatabaseMetadata databaseMetadata) {
        this.jdbc = jdbc;
        this.classMapping = classMapping;
        this.meta = databaseMetadata;
        initSql();
    }

    /**
     * @return 返回sql
     */
    public String getSql() {
        return sql;
    }

    /**
     * <p>
     * 设置预编译参数
     * </p>
     *
     * @param prep   执行SQL的PreparedStatementWrapper
     * @param entity 对象
     */
    protected void setParameter(PreparedStatement prep, T entity) {
        for (Entry<Integer, String> propertyPosition : propertyPositions.entrySet()) {
            JdbcUtils.setParameter(prep, propertyPosition.getKey(),
                    BeanUtils.getProperty(entity, propertyPosition.getValue()));
        }
    }

    public Object[] getParameters(T entity) {
        return getParameters(entity, propertyPositions);
    }

    protected Object[] getParameters(T entity, Map<Integer, String> propertyPositions) {
        Object[] params = new Object[propertyPositions.size()];
        int i = 0;
        for (Entry<Integer, String> propertyPosition : propertyPositions.entrySet()) {
            params[i] = BeanUtils.getProperty(entity, propertyPosition.getValue());
            i++;
        }
        return params;
    }

    /**
     * <p>
     * 设置预编译参数
     * </p>
     *
     * @param prep 执行SQL的PreparedStatementWrapper
     * @param id   主键
     */
    protected void setParameter(PreparedStatement prep, Serializable id) {
        JdbcUtils.setParameter(prep, 1, id);
    }

    /**
     * <p>
     * 设置预编译参数
     * </p>
     *
     * @param prep 执行SQL的PreparedStatementWrapper
     * @param ids  主键列表
     */
    protected void setParameter(PreparedStatement prep, java.util.List<Serializable> ids) {
        int i = 0;
        for (Serializable id : ids) {
            i++;
            JdbcUtils.setParameter(prep, i, id);
        }
    }

    /**
     * <p>
     * 初始化SQL，由具体的实现类来实现
     * </p>
     */
    protected abstract void initSql();
}
