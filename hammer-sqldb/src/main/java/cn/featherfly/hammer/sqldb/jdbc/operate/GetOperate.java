package cn.featherfly.hammer.sqldb.jdbc.operate;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import cn.featherfly.common.bean.BeanUtils;
import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.common.repository.mapping.RowMapper;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * <p>
 * 根据ID读取操作
 * </p>
 * .
 *
 * @author zhongj
 * @version 1.0
 * @param <T> 对象类型
 * @since 1.0
 */
public class GetOperate<T> extends AbstractQueryOperate<T> {

    /**
     * 使用给定数据源以及给定对象生成读取操作.
     *
     * @param jdbc                  jdbc
     * @param classMapping          classMapping
     * @param sqlTypeMappingManager the sql type mapping manager
     */
    public GetOperate(Jdbc jdbc, ClassMapping<T> classMapping, SqlTypeMappingManager sqlTypeMappingManager) {
        super(jdbc, classMapping, sqlTypeMappingManager);
    }

    /**
     * 使用给定数据源以及给定对象生成读取操作.
     *
     * @param jdbc                  jdbc
     * @param classMapping          classMapping
     * @param sqlTypeMappingManager the sql type mapping manager
     * @param dataBase              具体库
     */
    public GetOperate(Jdbc jdbc, ClassMapping<T> classMapping, SqlTypeMappingManager sqlTypeMappingManager,
            String dataBase) {
        super(jdbc, classMapping, sqlTypeMappingManager, dataBase);
    }

    /**
     * 使用给定数据源以及给定对象生成读取操作.
     *
     * @param jdbc                  the jdbc
     * @param classMapping          the class mapping
     * @param sqlTypeMappingManager the sql type mapping manager
     * @param databaseMetadata      the database metadata
     */
    public GetOperate(Jdbc jdbc, ClassMapping<T> classMapping, SqlTypeMappingManager sqlTypeMappingManager,
            DatabaseMetadata databaseMetadata) {
        super(jdbc, classMapping, sqlTypeMappingManager, databaseMetadata);
    }

    private List<PropertyMapping> pkPms;

    /**
     * <p>
     * 返回对象的id值.如果传入对象为空或没有主键标示属性，则返回空.
     * </p>
     *
     * @param entity 对象
     * @return id值
     */
    public Serializable getId(T entity) {
        if (entity == null) {
            return null;
        }
        if (pkPms.size() == 1) {
            return (Serializable) BeanUtils.getProperty(entity, pkPms.get(0).getPropertyName());
        } else if (pkPms.size() > 1) {
            throw new SqldbHammerException("multy id defined in entity [" + entity.getClass().getName()
                    + "], you can invoke getIds(entity) method instead");
        } else {
            logger.debug("no id defined in entity {}", entity.getClass().getName());
            return null;
        }
    }

    /**
     * <p>
     * 返回对象的id值列表,主要用于复合主键.如果传入对象为空或没有主键标示属性，则返回空.
     * </p>
     *
     * @param entity 对象
     * @return id值列表
     */
    public List<Serializable> getIds(T entity) {
        if (entity == null) {
            return null;
        }
        return pkPms.stream()
                .map(p -> (Serializable) BeanUtils.getProperty(entity, ClassMappingUtils.getPropertyAliasName(p)))
                .collect(Collectors.toList());
    }

    /**
     * <p>
     * 返回指定ID的对象.
     * </p>
     *
     * @param id 对象唯一标识
     * @return 指定ID的对象
     */
    public T get(final Serializable id) {
        if (id == null) {
            throw new SqldbHammerException("#get.id.null");
        }
        return jdbc.querySingle(sql, (RowMapper<T>) (res, rowNum) -> mapRow(res, rowNum), id);
    }

    /**
     * <p>
     * 返回指定ID的对象.
     * </p>
     *
     * @param entity 包含id值得entity对象，支持复合主键
     * @return 指定ids的对象
     */
    public T get(final T entity) {
        if (entity == null) {
            throw new SqldbHammerException("#get.id.null");
        }
        List<Serializable> ids = getIds(entity);
        if (Lang.isEmpty(ids)) {
            throw new SqldbHammerException("#get.id.null");
        }
        return jdbc.querySingle(sql, (RowMapper<T>) (res, rowNum) -> mapRow(res, rowNum), ids.toArray());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initSql() {
        sql = ClassMappingUtils.getSelectByIdSql(classMapping, jdbc.getDialect());
        pkPms = classMapping.getPrivaryKeyPropertyMappings();
        logger.debug("sql: {}", sql);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String initCondition() {
        // 重写了initSql，此方法在此类已经没用了
        return "";
    }
}
