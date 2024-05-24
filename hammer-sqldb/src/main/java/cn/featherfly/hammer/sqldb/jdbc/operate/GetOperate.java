package cn.featherfly.hammer.sqldb.jdbc.operate;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.bean.PropertyAccessor;
import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.Strings;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * 根据ID读取操作.
 *
 * @author zhongj
 * @param <T> 对象类型
 * @since 0.1.0
 */
public class GetOperate<T> extends AbstractQueryOperate<T> {

    /**
     * 使用给定数据源以及给定对象生成读取操作.
     *
     * @param jdbc the jdbc
     * @param classMapping the class mapping
     * @param sqlTypeMappingManager the sql type mapping manager
     * @param databaseMetadata the database metadata
     * @param propertyAccessor the property accessor
     */
    public GetOperate(Jdbc jdbc, JdbcClassMapping<T> classMapping, SqlTypeMappingManager sqlTypeMappingManager,
        DatabaseMetadata databaseMetadata, PropertyAccessor<T> propertyAccessor) {
        super(jdbc, classMapping, sqlTypeMappingManager, databaseMetadata, propertyAccessor);
    }

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
        if (pkProperties.size() == 1) {
            return pkProperties.get(0).get0().apply(entity);
        } else if (pkProperties.size() > 1) {
            throw new SqldbHammerException("multy id defined in entity [" + entity.getClass().getName()
                + "], you can invoke getIds(entity) method instead");
        } else {
            logger.debug("no id defined in entity {}", entity.getClass().getName());
            return null;
        }
    }

    /**
     * 返回对象的id值列表,主要用于复合主键.如果传入对象为空或没有主键标示属性，则返回空列表.
     *
     * @param entity 对象
     * @return id值列表
     */
    public List<Serializable> getIds(T entity) {
        if (entity == null) {
            return Collections.emptyList();
        }
        return pkProperties.stream().map(property -> {
            return property.get0().apply(entity);
        }).collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T execute(final Serializable id) {
        return get(id);
    }

    /**
     * 返回指定ID的对象.
     *
     * @param id 对象唯一标识
     * @return 指定ID的对象
     */
    public T get(final Serializable id) {
        return get(id, false);
    }

    /**
     * 返回指定ID的对象.
     *
     * @param id 对象唯一标识
     * @param forUpdate the for update
     * @return 指定ID的对象
     */
    public T get(final Serializable id, boolean forUpdate) {
        assertId(id);
        if (forUpdate) {
            if (databaseMetadata.getFeatures().supportsSelectForUpdate()) {
                return jdbc.querySingle(sql + " for update", this::mapRow, id);
            } else {
                // TODO 后续加入行为可配置策略
                throw new SqldbHammerException(Strings.format("unsupport [select...for update] with database {} - {}",
                    databaseMetadata.getProductName(), databaseMetadata.getProductVersion()));
            }
        } else {
            return jdbc.querySingle(sql, this::mapRow, id);
        }
    }

    /**
     * 返回指定ID的对象.
     *
     * @param entity 包含id值得entity对象，支持复合主键
     * @return 指定ids的对象
     */
    public T get(final T entity) {
        return get(entity, false);
    }

    /**
     * 返回指定ID的对象.
     *
     * @param entity 包含id值得entity对象，支持复合主键
     * @param forUpdate the for update
     * @return 指定ids的对象
     */
    public T get(final T entity, boolean forUpdate) {
        if (forUpdate) {
            return jdbc.querySingle(sql + " for update", this::mapRow, assertAndGetIds(entity));
        } else {
            return jdbc.querySingle(sql, this::mapRow, assertAndGetIds(entity));
        }
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    protected void initSql() {
        sql = ClassMappingUtils.getSelectByPkSql(classMapping, jdbc.getDialect());
        paramsPropertyAndMappings = pkProperties.toArray(new Tuple2[pkProperties.size()]);
        logger.debug("sql: {}", sql);
    }

    /**
     * Assert id.
     *
     * @param id the id
     */
    protected void assertId(Object id) {
        if (Lang.isEmpty(id)) {
            throw new SqldbHammerException("#get.id.null");
        }
    }

    /**
     * Assert and get ids.
     *
     * @param entity the entity
     * @return the object[]
     */
    protected Object[] assertAndGetIds(T entity) {
        assertEntity(entity);
        List<Serializable> ids = getIds(entity);
        assertId(ids);
        return ids.toArray();
    }
}
