
package cn.featherfly.hammer.sqldb.jdbc.operate;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.featherfly.common.bean.BeanDescriptor;
import cn.featherfly.common.bean.BeanProperty;
import cn.featherfly.common.bean.BeanPropertyValue;
import cn.featherfly.common.bean.BeanUtils;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.db.metadata.DatabaseMetadataManager;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * 数据库操作的抽象类.
 *
 * @author zhongj
 * @version 0.1.0
 * @since 0.1.0
 * @param <T> 类型
 */
public abstract class AbstractOperate<T> {

    /** logger. */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /** sql 语句. */
    protected String sql;

    /** jdbc. */
    protected Jdbc jdbc;

    /** 类型映射. */
    protected JdbcClassMapping<T> classMapping;

    /** The bean descriptor. */
    protected BeanDescriptor<T> beanDescriptor;

    /** The sql type mapping manager. */
    protected SqlTypeMappingManager sqlTypeMappingManager;

    /** 数据库元数据. */
    protected DatabaseMetadata meta;

    /** 属性在SQL中出现的位置，即SQL语句中每个问号对应的对象属性. */
    protected Map<Integer, String> propertyPositions = new HashMap<>(0);

    /** The pk properties. */
    protected List<BeanProperty<Serializable>> pkProperties = new ArrayList<>();

    /**
     * 使用给定数据源以及给定对象映射生成其相应的操作.
     *
     * @param jdbc                  jdbc
     * @param classMapping          classMapping
     * @param sqlTypeMappingManager the sql type mapping manager
     */
    public AbstractOperate(Jdbc jdbc, JdbcClassMapping<T> classMapping, SqlTypeMappingManager sqlTypeMappingManager) {
        this(jdbc, classMapping, sqlTypeMappingManager, "");
    }

    /**
     * 使用给定数据源以及给定对象生成其相应的操作.
     *
     * @param jdbc                  jdbc
     * @param classMapping          classMapping
     * @param sqlTypeMappingManager the sql type mapping manager
     * @param dataBase              具体库
     */
    public AbstractOperate(Jdbc jdbc, JdbcClassMapping<T> classMapping, SqlTypeMappingManager sqlTypeMappingManager,
            String dataBase) {
        if (Lang.isEmpty(dataBase)) {
            meta = DatabaseMetadataManager.getDefaultManager().create(jdbc.getDataSource());
        } else {
            meta = DatabaseMetadataManager.getDefaultManager().create(jdbc.getDataSource(), dataBase);
        }
        this.jdbc = jdbc;
        this.classMapping = classMapping;
        if (sqlTypeMappingManager == null) {
            this.sqlTypeMappingManager = new SqlTypeMappingManager();
        } else {
            this.sqlTypeMappingManager = sqlTypeMappingManager;
        }
        init();
    }

    /**
     * 使用给定数据源以及给定对象生成其相应的操作.
     *
     * @param jdbc                  jdbc
     * @param classMapping          classMapping
     * @param databaseMetadata      databaseMetadata
     * @param sqlTypeMappingManager the sql type mapping manager
     */
    public AbstractOperate(Jdbc jdbc, JdbcClassMapping<T> classMapping, SqlTypeMappingManager sqlTypeMappingManager,
            DatabaseMetadata databaseMetadata) {
        this.jdbc = jdbc;
        this.classMapping = classMapping;
        this.meta = databaseMetadata;
        if (sqlTypeMappingManager == null) {
            this.sqlTypeMappingManager = new SqlTypeMappingManager();
        } else {
            this.sqlTypeMappingManager = sqlTypeMappingManager;
        }
        init();
    }

    @SuppressWarnings("unchecked")
    private void init() {
        beanDescriptor = (BeanDescriptor<T>) BeanDescriptor.getBeanDescriptor(classMapping.getType());
        for (JdbcPropertyMapping pm : classMapping.getPrivaryKeyPropertyMappings()) {
            pkProperties.add(
                    BeanDescriptor.getBeanDescriptor(classMapping.getType()).getBeanProperty(pm.getPropertyFullName()));
        }
        initSql();
    }

    /**
     * Gets the sql.
     *
     * @return 返回sql
     */
    public String getSql() {
        return sql;
    }

    /**
     * <p>
     * 设置预编译参数
     * </p>
     * .
     *
     * @param prep    执行SQL的PreparedStatementWrapper
     * @param entity  对象
     * @param manager the manager
     */
    protected void setParameter(PreparedStatement prep, T entity, SqlTypeMappingManager manager) {
        BeanDescriptor<?> beanDescriptor = BeanDescriptor.getBeanDescriptor(entity.getClass());
        for (Entry<Integer, String> propertyPosition : propertyPositions.entrySet()) {
            BeanProperty<Object> property = beanDescriptor.getBeanProperty(propertyPosition.getValue());
            manager.set(prep, propertyPosition.getKey(), BeanUtils.getProperty(entity, propertyPosition.getValue()),
                    property);
            //            JdbcUtils.setParameter(prep, propertyPosition.getKey(),
            //                    BeanUtils.getProperty(entity, propertyPosition.getValue()));
        }
    }

    /**
     * <p>
     * 设置预编译参数
     * </p>
     * .
     *
     * @param prep    执行SQL的PreparedStatementWrapper
     * @param entity  对象
     * @param index   当前对象是第几个设置的
     * @param manager the manager
     */
    protected void setParameter(PreparedStatement prep, T entity, int index, SqlTypeMappingManager manager) {
        int len = propertyPositions.size();
        BeanDescriptor<?> beanDescriptor = BeanDescriptor.getBeanDescriptor(entity.getClass());
        for (Entry<Integer, String> propertyPosition : propertyPositions.entrySet()) {
            int position = propertyPosition.getKey() + index * len;
            BeanProperty<Object> property = beanDescriptor.getBeanProperty(propertyPosition.getValue());
            manager.set(prep, position, BeanUtils.getProperty(entity, propertyPosition.getValue()), property);
            //            JdbcUtils.setParameter(prep, position, BeanUtils.getProperty(entity, propertyPosition.getValue()));
        }
    }

    /**
     * Sets the parameters.
     *
     * @param entity  the entity
     * @param prep    the prep
     * @param manager the manager
     * @return the object[]
     */
    protected Object[] setParameters(T entity, PreparedStatement prep, SqlTypeMappingManager manager) {
        return setParameters(entity, propertyPositions, prep, manager);
    }

    /**
     * Sets the parameters.
     *
     * @param entity            the entity
     * @param propertyPositions the property positions
     * @param prep              the prep
     * @param manager           the manager
     * @return the object[]
     */
    protected Object[] setParameters(T entity, Map<Integer, String> propertyPositions, PreparedStatement prep,
            SqlTypeMappingManager manager) {
        BeanDescriptor<?> beanDescriptor = BeanDescriptor.getBeanDescriptor(entity.getClass());
        Object[] params = new Object[propertyPositions.size()];
        int i = 0;
        for (Entry<Integer, String> propertyPosition : propertyPositions.entrySet()) {
            BeanProperty<Object> property = beanDescriptor.getBeanProperty(propertyPosition.getValue());
            Object value = BeanUtils.getProperty(entity, propertyPosition.getValue());
            params[i] = value;
            i++;
            manager.set(prep, i, value, property);
        }
        return params;
    }

    /**
     * Sets the batch parameters.
     *
     * @param entities          the entities
     * @param propertyPositions the property positions
     * @param prep              the prep
     * @param manager           the manager
     * @return the object[]
     */
    protected Object[] setBatchParameters(List<T> entities, Map<Integer, String> propertyPositions,
            PreparedStatement prep, SqlTypeMappingManager manager) {
        if (Lang.isEmpty(entities)) {
            return new Object[] {};
        }
        BeanDescriptor<?> beanDescriptor = BeanDescriptor.getBeanDescriptor(entities.get(0).getClass());
        Object[] params = new Object[propertyPositions.size()];
        int pkNum = propertyPositions.size() / entities.size();
        int i = 0;
        T entity = null;
        for (Entry<Integer, String> propertyPosition : propertyPositions.entrySet()) {
            if (i % pkNum == 0) {
                entity = entities.get(i / pkNum);
            }
            params[i] = BeanUtils.getProperty(entity, propertyPosition.getValue());
            BeanProperty<Object> property = beanDescriptor.getBeanProperty(propertyPosition.getValue());
            manager.set(prep, i + 1, params[i], property);
            i++;
        }
        return params;
    }

    /**
     * Gets the parameters.
     *
     * @param entity the entity
     * @return the parameters
     */
    public BeanPropertyValue<?>[] getParameters(T entity) {
        return getParameters(entity, propertyPositions);
    }

    //    /**
    //     * Gets the parameters.
    //     *
    //     * @param entity            the entity
    //     * @param propertyPositions the property positions
    //     * @return the parameters
    //     */
    //    protected Object[] getParameters(T entity, Map<Integer, String> propertyPositions) {
    //        Object[] params = new Object[propertyPositions.size()];
    //        int i = 0;
    //        for (Entry<Integer, String> propertyPosition : propertyPositions.entrySet()) {
    //            params[i] = BeanUtils.getProperty(entity, propertyPosition.getValue());
    //            i++;
    //        }
    //        return params;
    //    }

    /**
     * Gets the parameters.
     *
     * @param entity            the entity
     * @param propertyPositions the property positions
     * @return the parameters
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected BeanPropertyValue<?>[] getParameters(T entity, Map<Integer, String> propertyPositions) {
        /* TODO  这里后续可以优化为 BeanPropertyValue为EntityBeanPropertyValue,  EntityBeanPropertyValue带有已注册的Mapper
                       然后sql执行时，直接绕过TypeManager不在去找java类型和sql类型的映射关系
                       此举可以加速实体类型的数据库操作速度
        */
        BeanPropertyValue<?>[] bpvs = new BeanPropertyValue[propertyPositions.size()];
        int i = 0;
        for (Entry<Integer, String> propertyPosition : propertyPositions.entrySet()) {
            // ENHANCE 下面这个逻辑后续可以用map优化，缓存下来
            BeanProperty<?> bp = beanDescriptor.getBeanProperty(propertyPosition.getValue());
            bpvs[i] = new BeanPropertyValue(bp, BeanUtils.getProperty(entity, propertyPosition.getValue()));
            i++;
        }
        return bpvs;
    }

    /**
     * <p>
     * 设置预编译参数
     * </p>
     * .
     *
     * @param prep    执行SQL的PreparedStatementWrapper
     * @param id      主键
     * @param manager the manager
     */
    protected void setParameter(PreparedStatement prep, Serializable id, SqlTypeMappingManager manager) {
        manager.set(prep, 1, id, pkProperties.get(0));
        //        JdbcUtils.setParameter(prep, 1, id);
    }

    /**
     * <p>
     * 设置预编译参数
     * </p>
     * .
     *
     * @param prep    执行SQL的PreparedStatementWrapper
     * @param ids     主键列表
     * @param manager the manager
     */
    protected void setParameter(PreparedStatement prep, java.util.List<Serializable> ids,
            SqlTypeMappingManager manager) {
        int i = 0;
        for (Serializable id : ids) {
            i++;
            manager.set(prep, i, id, pkProperties.get(i - 1));
            //            JdbcUtils.setParameter(prep, i, id);
        }
    }

    /**
     * 初始化SQL，由具体的实现类来实现.
     */
    protected abstract void initSql();
}
