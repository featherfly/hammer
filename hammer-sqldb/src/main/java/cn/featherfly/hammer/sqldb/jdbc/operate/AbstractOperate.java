
package cn.featherfly.hammer.sqldb.jdbc.operate;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.db.FieldValueOperator;
import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * 数据库操作的抽象类.
 *
 * @author zhongj
 * @param <T> entity type
 * @since 0.1.0
 */
public abstract class AbstractOperate<T> {

    /** logger. */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /** jdbc. */
    protected final Jdbc jdbc;

    /** 类型映射. */
    protected final JdbcClassMapping<T> classMapping;

    /** The sql type mapping manager. */
    protected final SqlTypeMappingManager sqlTypeMappingManager;

    /** 数据库元数据. */
    protected final DatabaseMetadata databaseMetadata;

    /** sql 语句. */
    protected String sql;

    /** The properties order by sql with placeholder parameter. */
    protected JdbcPropertyMapping[] paramsPropertyAndMappings;

    /** The pk properties. */
    protected final List<JdbcPropertyMapping> pkProperties = new ArrayList<>();

    /**
     * 使用给定数据源以及给定对象生成其相应的操作.
     *
     * @param jdbc jdbc
     * @param classMapping classMapping
     * @param sqlTypeMappingManager the sql type mapping manager
     * @param databaseMetadata databaseMetadata
     */
    protected AbstractOperate(Jdbc jdbc, JdbcClassMapping<T> classMapping, SqlTypeMappingManager sqlTypeMappingManager,
        DatabaseMetadata databaseMetadata) {
        this.jdbc = jdbc;
        this.classMapping = classMapping;
        this.databaseMetadata = databaseMetadata;
        this.sqlTypeMappingManager = sqlTypeMappingManager;
        for (JdbcPropertyMapping pm : classMapping.getPrimaryKeyPropertyMappings()) {
            pkProperties.add(pm);
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

    //    /**
    //     * 设置预编译参数 .
    //     *
    //     * @param prep    执行SQL的PreparedStatementWrapper
    //     * @param entity  对象
    //     * @param manager the manager
    //     */
    //    protected void setParameter(PreparedStatement prep, T entity, SqlTypeMappingManager manager) {
    //        BeanDescriptor<?> beanDescriptor = BeanDescriptor.getBeanDescriptor(entity.getClass());
    //        for (Entry<Integer, String> propertyPosition : propertyPositions.entrySet()) {
    //            BeanProperty<Object> property = beanDescriptor.getBeanProperty(propertyPosition.getValue());
    //            manager.set(prep, propertyPosition.getKey(), BeanUtils.getProperty(entity, propertyPosition.getValue()),
    //                    property);
    //            //            JdbcUtils.setParameter(prep, propertyPosition.getKey(),
    //            //                    BeanUtils.getProperty(entity, propertyPosition.getValue()));
    //        }
    //    }

    //    /**
    //     * 设置预编译参数 .
    //     *
    //     * @param prep    执行SQL的PreparedStatementWrapper
    //     * @param entity  对象
    //     * @param index   当前对象是第几个设置的
    //     * @param manager the manager
    //     */
    //    protected void setParameter(PreparedStatement prep, T entity, int index, SqlTypeMappingManager manager) {
    //        int len = propertyPositions.size();
    //        BeanDescriptor<?> beanDescriptor = BeanDescriptor.getBeanDescriptor(entity.getClass());
    //        for (Entry<Integer, String> propertyPosition : propertyPositions.entrySet()) {
    //            int position = propertyPosition.getKey() + index * len;
    //            BeanProperty<Object> property = beanDescriptor.getBeanProperty(propertyPosition.getValue());
    //            manager.set(prep, position, BeanUtils.getProperty(entity, propertyPosition.getValue()), property);
    //            //            JdbcUtils.setParameter(prep, position, BeanUtils.getProperty(entity, propertyPosition.getValue()));
    //        }
    //    }

    //    /**
    //     * Sets the parameters.
    //     *
    //     * @param entity  the entity
    //     * @param prep    the prep
    //     * @param manager the manager
    //     * @return the object[]
    //     */
    //    protected Object[] setParameters(T entity, PreparedStatement prep, SqlTypeMappingManager manager) {
    //        return setParameters(entity, propertyPositions, prep, manager);
    //    }
    //
    //    /**
    //     * Sets the parameters.
    //     *
    //     * @param entity            the entity
    //     * @param propertyPositions the property positions
    //     * @param prep              the prep
    //     * @param manager           the manager
    //     * @return the object[]
    //     */
    //    protected Object[] setParameters(T entity, Map<Integer, String> propertyPositions, PreparedStatement prep,
    //            SqlTypeMappingManager manager) {
    //        BeanDescriptor<?> beanDescriptor = BeanDescriptor.getBeanDescriptor(entity.getClass());
    //        Object[] params = new Object[propertyPositions.size()];
    //        int i = 0;
    //        for (Entry<Integer, String> propertyPosition : propertyPositions.entrySet()) {
    //            BeanProperty<Object> property = beanDescriptor.getBeanProperty(propertyPosition.getValue());
    //            Object value = BeanUtils.getProperty(entity, propertyPosition.getValue());
    //            params[i] = value;
    //            i++;
    //            manager.set(prep, i, value, property);
    //        }
    //        return params;
    //    }

    /**
     * Sets the batch parameters.
     *
     * @param entities the entities
     * @param paramsPropertyAndMappings the params property and mappings
     * @param prep the prep
     * @param setArgs the set args
     */
    protected void setBatchParameters(List<T> entities,
        Tuple2<Function<T, Serializable>, JdbcPropertyMapping>[] paramsPropertyAndMappings, PreparedStatement prep,
        Consumer<Serializable[]> setArgs) {
        if (Lang.isEmpty(entities)) {
            return;
        }
        try {
            Serializable[] args = new Serializable[paramsPropertyAndMappings.length];
            for (T entity : entities) {
                for (int i = 0; i < paramsPropertyAndMappings.length; i++) {
                    Tuple2<Function<T, Serializable>, JdbcPropertyMapping> paramMapping = paramsPropertyAndMappings[i];
                    Serializable value = paramMapping.get0().apply(entity);
                    paramMapping.get1().getJavaTypeSqlTypeOperator().set(prep, i + 1, value);
                    args[i] = value;
                }
                setArgs.accept(args);
                prep.addBatch();
            }
            //prep.executeBatch();
        } catch (SQLException e) {
            throw new JdbcException(e);
        }
    }

    /**
     * Gets the parameters.
     *
     * @param entity the entity
     * @return the parameters
     */
    protected Serializable[] getParameters(T entity) {
        return getParameters(entity, paramsPropertyAndMappings);
    }

    /**
     * Gets the parameters.
     *
     * @param entity the entity
     * @param paramsPropertyAndMappings the params property and mappings
     * @return the parameters
     */
    protected Serializable[] getParameters(T entity,
        Tuple2<Function<T, Object>, JdbcPropertyMapping>[] paramsPropertyAndMappings) {
        Serializable[] operators = new Serializable[paramsPropertyAndMappings.length];
        int i = 0;
        for (Tuple2<Function<T, Object>, JdbcPropertyMapping> paramsPropertyAndMapping : paramsPropertyAndMappings) {
            operators[i] = FieldValueOperator.create(paramsPropertyAndMapping.get1(),
                paramsPropertyAndMapping.get0().apply(entity));
            i++;
        }
        return operators;
    }

    /**
     * Gets the parameters.
     *
     * @param entity the entity
     * @param mappings the mappings
     * @return the parameters
     */
    protected Serializable[] getParameters(T entity, JdbcPropertyMapping[] mappings) {
        Serializable[] operators = new Serializable[mappings.length];
        int i = 0;
        for (JdbcPropertyMapping mapping : mappings) {
            //            operators[i] = FieldValueOperator.create(mapping,
            //                propertyAccessor.getPropertyValue(entity, mapping.getPropertyIndexes()));
            operators[i] = FieldValueOperator.create(mapping, mapping.getGetter().apply(entity));
            i++;
        }
        return operators;
    }

    /**
     * Sets the params property and mappings.
     *
     * @param mappings the new params property and mappings
     */
    protected void setParamsPropertyAndMappings(JdbcPropertyMapping[] mappings) {
        paramsPropertyAndMappings = mappings;
    }

    /**
     * 初始化SQL，由具体的实现类来实现.
     */
    protected abstract void initSql();

    /**
     * sssert entity.
     *
     * @param entity entity obj
     */
    protected void assertEntity(T entity) {
        if (entity == null) {
            throw new SqldbHammerException("#entity.null");
        }
    }

    /**
     * Checks if is debug.
     *
     * @return true, if is debug
     */
    protected boolean isDebug() {
        // IMPLSOON 后续使用配置
        return logger.isDebugEnabled();
    }
}
