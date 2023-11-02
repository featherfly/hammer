package cn.featherfly.hammer.sqldb.jdbc.operate;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.bean.BeanUtils;
import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.FieldValueOperator;
import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.JdbcUtils;
import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.db.metadata.ResultSetConcurrency;
import cn.featherfly.common.db.metadata.ResultSetType;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * The Class UpdateFetchOperate.
 *
 * @author zhongj
 * @param <T> entity type
 * @since 0.7.0
 */
public class UpdateFetchOperate<T> extends AbstractOperate<T> implements ExecuteFetchOperate<T> {

    private boolean supportsResultSetUpdatable;

    private List<JdbcPropertyMapping> pkPms;

    // ----------------------------------------------------------------------------------------------------------------

    private GetOperate<T> getOperate;

    private UpdateOperate<T> updateOperate;

    private Consumer<String> doLock;

    private Consumer<String> doUnLock;

    private boolean priorityUseDatabaseRowLock = true;

    /**
     * Instantiates a new update fetch operate.
     *
     * @param jdbc                  the jdbc
     * @param classMapping          the class mapping
     * @param sqlTypeMappingManager the sql type mapping manager
     * @param databaseMetadata      the database metadata
     * @param getOperate            the get operate
     * @param updateOperate         the update operate
     * @param doLock                the do lock
     * @param doUnLock              the do un lock
     */
    public UpdateFetchOperate(Jdbc jdbc, JdbcClassMapping<T> classMapping, SqlTypeMappingManager sqlTypeMappingManager,
            DatabaseMetadata databaseMetadata, GetOperate<T> getOperate, UpdateOperate<T> updateOperate,
            Consumer<String> doLock, Consumer<String> doUnLock) {
        this(jdbc, classMapping, sqlTypeMappingManager, databaseMetadata, getOperate, updateOperate, doLock, doUnLock,
                true);
    }

    /**
     * Instantiates a new update fetch operate.
     *
     * @param jdbc                       the jdbc
     * @param classMapping               the class mapping
     * @param sqlTypeMappingManager      the sql type mapping manager
     * @param databaseMetadata           the database metadata
     * @param getOperate                 the get operate
     * @param updateOperate              the update operate
     * @param doLock                     the do lock
     * @param doUnLock                   the do un lock
     * @param priorityUseDatabaseRowLock the priority use database row lock
     */
    public UpdateFetchOperate(Jdbc jdbc, JdbcClassMapping<T> classMapping, SqlTypeMappingManager sqlTypeMappingManager,
            DatabaseMetadata databaseMetadata, GetOperate<T> getOperate, UpdateOperate<T> updateOperate,
            Consumer<String> doLock, Consumer<String> doUnLock, boolean priorityUseDatabaseRowLock) {
        super(jdbc, classMapping, sqlTypeMappingManager, databaseMetadata);
        this.getOperate = getOperate;
        this.updateOperate = updateOperate;
        this.doLock = doLock;
        this.doUnLock = doUnLock;
        this.priorityUseDatabaseRowLock = priorityUseDatabaseRowLock;

    }

    private boolean initSupportsResultSetUpdatable() {
        supportsResultSetUpdatable = meta.getFeatures().supportsResultSetConcurrency(ResultSetType.FORWARD_ONLY,
                ResultSetConcurrency.CONCUR_UPDATABLE);
        return supportsResultSetUpdatable;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initSql() {
        if (initSupportsResultSetUpdatable()) {
            sql = ClassMappingUtils.getSelectByPkSql(classMapping, jdbc.getDialect());
            pkPms = classMapping.getPrivaryKeyPropertyMappings();
            logger.debug("sql: {}", sql);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T execute(Serializable id, UnaryOperator<T> updateOperator, boolean lock) {
        if (supportsResultSetUpdatable) {
            // driver support update ResultSet
            getOperate.assertId(id);
            return executeResultSetUpdatable(lock, updateOperator, () -> getLockKey(id), id);
        } else {
            return executeCustom(lock, updateOperator, () -> getLockKey(id),
                    forUpdate -> getOperate.get(id, forUpdate));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T execute(T entity, UnaryOperator<T> updateOperator, boolean lock) {
        if (supportsResultSetUpdatable) {
            // driver support update ResultSet
            getOperate.assertId(entity);
            return executeResultSetUpdatable(lock, updateOperator, () -> getLockKey(entity), getIdsAsArgus(entity));
        } else {
            return executeCustom(lock, updateOperator, () -> getLockKey(entity),
                    forUpdate -> getOperate.get(entity, forUpdate));
        }
    }

    private T executeCustom(boolean lock, UnaryOperator<T> updateOperator, Supplier<String> keySupplier,
            Function<Boolean, T> entitySupplier) {
        if (lock) {
            if (priorityUseDatabaseRowLock && meta.getFeatures().supportsSelectForUpdate()) {
                // database support select ... for update
                //                T result = updateOperator.apply(getOperate.get(id, true));
                return executeCustom(updateOperator.apply(entitySupplier.apply(true)));
            } else {
                // database do not support select ... for update, use custom lock
                String key = keySupplier.get();
                try {
                    doLock.accept(key);
                    //                    T result = updateOperator.apply(getOperate.get(id));
                    //                    T result = updateOperator.apply(entitySupplier.apply(false));
                    //                    updateOperate.execute(result);
                    //                    return result;
                    return executeCustom(updateOperator.apply(entitySupplier.apply(false)));
                } finally {
                    doUnLock.accept(key);
                }
            }
        } else {
            //            T result = updateOperator.apply(getOperate.get(id));
            //            T result = updateOperator.apply(entitySupplier.apply(false));
            //            updateOperate.execute(result);
            //            return result;
            return executeCustom(updateOperator.apply(entitySupplier.apply(false)));
        }
    }

    private T executeCustom(T result) {
        updateOperate.execute(result);
        return result;
    }

    private T executeResultSetUpdatable(boolean lock, UnaryOperator<T> updateOperator, Supplier<String> keySupplier,
            Object... args) {
        if (lock) {
            if (priorityUseDatabaseRowLock && meta.getFeatures().supportsSelectForUpdate()) {
                Tuple2<T, Integer> result = jdbc.querySingleUpdate(sql + jdbc.getDialect().getKeyword(" for update"),
                        getOperate::mapRow, (res, e) -> {
                            return updateResultSet(res, updateOperator.apply(e));
                        }, args);
                return result.get0();
            } else {
                String key = keySupplier.get();
                try {
                    doLock.accept(key);
                    return executeResultSetUpdatable(updateOperator, args).get0();
                } finally {
                    doUnLock.accept(key);
                }
            }
        } else {
            return executeResultSetUpdatable(updateOperator, args).get0();
        }
    }

    private Tuple2<T, Integer> executeResultSetUpdatable(UnaryOperator<T> updateOperator, Object... args) {
        return jdbc.querySingleUpdate(sql, getOperate::mapRow, (res, e) -> {
            return updateResultSet(res, updateOperator.apply(e));
        }, args);
    }

    private int updateResultSet(ResultSet res, T updateEntity) {
        int index = 1;
        for (JdbcPropertyMapping propertyMapping : classMapping.getPropertyMappings()) {
            if (propertyMapping.getPropertyMappings().isEmpty()) {
                // YUFEI_TEST 后续来测试
                index = updateValue(res, updateEntity, index, propertyMapping);
            } else {
                for (JdbcPropertyMapping subPropertyMapping : propertyMapping.getPropertyMappings()) {
                    // YUFEI_TEST 后续来测试
                    index = updateValue(res, updateEntity, index, subPropertyMapping);
                }
            }
        }
        try {
            res.updateRow();
            return 1;
        } catch (SQLException e) {
            throw new JdbcException(e);
        }
    }

    private int updateValue(ResultSet res, T mappedObject, int index, JdbcPropertyMapping propertyMapping) {
        Object value = BeanUtils.getProperty(mappedObject, propertyMapping.getPropertyFullName());
        JdbcUtils.setParameter(res, index, FieldValueOperator.create(propertyMapping, value));
        index++;
        return index;
    }

    private String getLockKey(Serializable id) {
        return classMapping.getRepositoryName().toLowerCase() + ":" + id;
    }

    private String getLockKey(T entity) {
        List<Serializable> ids = getOperate.getIds(entity);
        if (ids.size() == 1) {
            return getLockKey(ids.get(0));
        } else {
            StringBuilder key = new StringBuilder(classMapping.getRepositoryName().toLowerCase());
            key.append("[");
            for (JdbcPropertyMapping pkPm : pkPms) {
                key.append(pkPm.getRepositoryFieldName().toLowerCase()).append(Chars.COMMA_CHAR);
            }
            key.deleteCharAt(key.length() - 1);
            key.append("]:");
            for (Serializable id : ids) {
                key.append(id).append(Chars.COMMA_CHAR);
            }
            key.deleteCharAt(key.length() - 1);
            return key.toString();
        }
    }

    private Object[] getIdsAsArgus(T entity) {
        return getOperate.getIds(entity).toArray();
    }
}
