package cn.featherfly.hammer.sqldb.jdbc.operate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import cn.featherfly.common.bean.BeanUtils;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.hammer.mapping.ClassMapping;
import cn.featherfly.hammer.mapping.PropertyMapping;
import cn.featherfly.hammer.mapping.RowMapper;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.mapping.ClassMappingUtils;

/**
 * <p>
 * 根据ID读取操作
 * </p>
 *
 * @param <T> 对象类型
 * @author zhongj
 * @since 1.0
 * @version 1.0
 */
public class GetOperate<T> extends AbstractQueryOperate<T> {

    /**
     * 使用给定数据源以及给定对象生成读取操作.
     *
     * @param jdbc         jdbc
     * @param classMapping classMapping
     */
    public GetOperate(Jdbc jdbc, ClassMapping<T> classMapping) {
        super(jdbc, classMapping);
    }

    /**
     * 使用给定数据源以及给定对象生成读取操作.
     *
     * @param jdbc         jdbc
     * @param classMapping classMapping
     * @param dataBase     具体库
     */
    public GetOperate(Jdbc jdbc, ClassMapping<T> classMapping, String dataBase) {
        super(jdbc, classMapping, dataBase);
    }

    /**
     * 使用给定数据源以及给定对象生成读取操作.
     *
     * @param jdbc             the jdbc
     * @param classMapping     the class mapping
     * @param databaseMetadata the database metadata
     */
    public GetOperate(Jdbc jdbc, ClassMapping<T> classMapping, DatabaseMetadata databaseMetadata) {
        super(jdbc, classMapping, databaseMetadata);
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
        return jdbc.querySingle(sql, new Object[] { id }, (RowMapper<T>) (res, rowNum) -> mapRow(res, rowNum));
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
        if (LangUtils.isEmpty(ids)) {
            throw new SqldbHammerException("#get.id.null");
        }
        return jdbc.querySingle(sql, ids.toArray(), (RowMapper<T>) (res, rowNum) -> mapRow(res, rowNum));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String initCondition() {
        pkPms = new ArrayList<>();
        StringBuilder condition = new StringBuilder();
        int columnNum = 0;
        for (PropertyMapping propertyMapping : classMapping.getPropertyMappings()) {
            if (propertyMapping.getPropertyMappings().isEmpty()) {
                columnNum = setPk(condition, columnNum, propertyMapping);
            } else {
                for (PropertyMapping subPropertyMapping : propertyMapping.getPropertyMappings()) {
                    columnNum = setPk(condition, columnNum, subPropertyMapping);
                }
            }
        }
        logger.debug("condition -> " + condition.toString());
        return condition.toString();
    }

    /**
     * <p>
     * 方法的说明
     * </p>
     *
     * @param condition
     * @param columnNum
     * @param pm
     * @return
     */
    private int setPk(StringBuilder condition, int columnNum, PropertyMapping pm) {
        if (pm.isPrimaryKey()) {
            if (columnNum > 0) {
                condition.append("and ");
            }
            condition.append(jdbc.getDialect().wrapName(pm.getRepositoryFieldName())).append(" = ? ");
            columnNum++;
            propertyPositions.put(columnNum, ClassMappingUtils.getPropertyAliasName(pm));
            // 设置主键值
            pkPms.add(pm);
        }
        return columnNum;
    }
}
