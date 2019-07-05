
package cn.featherfly.juorm.rdb.jdbc;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.juorm.Juorm;
import cn.featherfly.juorm.dsl.execute.Delete;
import cn.featherfly.juorm.dsl.execute.Update;
import cn.featherfly.juorm.dsl.query.QueryEntity;
import cn.featherfly.juorm.rdb.jdbc.dsl.execute.SqlDeleter;
import cn.featherfly.juorm.rdb.jdbc.dsl.execute.SqlUpdater;
import cn.featherfly.juorm.rdb.jdbc.dsl.query.SqlQuery;
import cn.featherfly.juorm.rdb.jdbc.mapping.ClassMapping;
import cn.featherfly.juorm.rdb.jdbc.mapping.MappingFactory;
import cn.featherfly.juorm.rdb.jdbc.operate.DeleteOperate;
import cn.featherfly.juorm.rdb.jdbc.operate.GetOperate;
import cn.featherfly.juorm.rdb.jdbc.operate.InsertOperate;
import cn.featherfly.juorm.rdb.jdbc.operate.UpdateOperate;

/**
 * <p>
 * JuormSqlImpl
 * </p>
 *
 * @author zhongj
 */
public class JuormJdbcImpl implements Juorm {

    private Jdbc jdbc;

    private MappingFactory mappingFactory;

    private Validator validator;

    private Map<Class<?>, InsertOperate<?>> insertOperates = new HashMap<>();
    private Map<Class<?>, UpdateOperate<?>> updateOperates = new HashMap<>();
    private Map<Class<?>, GetOperate<?>> getOperates = new HashMap<>();
    private Map<Class<?>, DeleteOperate<?>> deleteOperates = new HashMap<>();

    /**
     *
     */
    public JuormJdbcImpl(Jdbc jdbc, MappingFactory mappingFactory) {
        this.jdbc = jdbc;
        this.mappingFactory = mappingFactory;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int save(E entity) {
        if (entity == null) {
            return 0;
        }
        @SuppressWarnings("unchecked")
        InsertOperate<E> insert = (InsertOperate<E>) insertOperates.get(entity);
        if (insert == null) {
            @SuppressWarnings("unchecked")
            ClassMapping<E> mapping = (ClassMapping<E>) mappingFactory.getClassMapping(entity.getClass());
            insert = new InsertOperate<>(jdbc, mapping);
            insertOperates.put(entity.getClass(), insert);
        }
        validate(entity);
        return insert.execute(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int save(List<E> entities) {
        // YUFEI_TODO 后续加入InsertBatchOperate优化为sql批量插入
        int size = 0;
        if (LangUtils.isNotEmpty(entities)) {
            for (E e : entities) {
                size += save(e);
            }
        }
        return size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int update(E entity) {
        if (entity == null) {
            return 0;
        }
        @SuppressWarnings("unchecked")
        UpdateOperate<E> update = (UpdateOperate<E>) updateOperates.get(entity);
        if (update == null) {
            @SuppressWarnings("unchecked")
            ClassMapping<E> mapping = (ClassMapping<E>) mappingFactory.getClassMapping(entity.getClass());
            update = new UpdateOperate<>(jdbc, mapping);
            updateOperates.put(entity.getClass(), update);
        }
        validate(entity);
        return update.execute(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int update(List<E> entities) {
        int size = 0;
        if (LangUtils.isNotEmpty(entities)) {
            for (E e : entities) {
                size += update(e);
            }
        }
        return size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int update(E entity, IgnorePolicy ignorePolicy) {
        switch (ignorePolicy) {
            case EMPTY:
                // TODO 添加实现
                return 0;
            case NULL:
                // TODO 添加实现
                return 0;

            default:
                return update(entity);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int update(List<E> entities, IgnorePolicy ignorePolicy) {
        int size = 0;
        if (LangUtils.isNotEmpty(entities)) {
            for (E e : entities) {
                size += update(e, ignorePolicy);
            }
        }
        return size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int merge(E entity) {
        return update(entity, IgnorePolicy.EMPTY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int merge(List<E> entities) {
        int size = 0;
        if (LangUtils.isNotEmpty(entities)) {
            for (E e : entities) {
                size += merge(e);
            }
        }
        return size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int delete(E entity) {
        if (entity == null) {
            return 0;
        }
        @SuppressWarnings("unchecked")
        DeleteOperate<E> delete = (DeleteOperate<E>) deleteOperates.get(entity);
        if (delete == null) {
            @SuppressWarnings("unchecked")
            ClassMapping<E> mapping = (ClassMapping<E>) mappingFactory.getClassMapping(entity.getClass());
            delete = new DeleteOperate<>(jdbc, mapping);
            deleteOperates.put(entity.getClass(), delete);
        }
        return delete.execute(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int delete(List<E> entities) {
        // YUFEI_TODO 后续加入DeleteBatchOperate优化为sql批量删除
        int size = 0;
        if (LangUtils.isNotEmpty(entities)) {
            for (E e : entities) {
                size += delete(e);
            }
        }
        return size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E get(Serializable id, Class<E> type) {
        if (id == null || type == null) {
            return null;
        }
        GetOperate<E> get = getOperate(type);
        return get.get(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E get(E entity) {
        if (entity == null) {
            return null;
        }
        @SuppressWarnings("unchecked")
        GetOperate<E> get = (GetOperate<E>) getOperate(entity.getClass());
        return get.get(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> QueryEntity query(Class<E> entityType) {
        SqlQuery query = new SqlQuery(jdbc);
        ClassMapping<E> mapping = mappingFactory.getClassMapping(entityType);
        return query.find(mapping.getTableName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> Update update(Class<E> entityType) {
        SqlUpdater updater = new SqlUpdater(jdbc);
        ClassMapping<E> mapping = mappingFactory.getClassMapping(entityType);
        return updater.update(mapping.getTableName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> Delete delete(Class<E> entityType) {
        SqlDeleter deleter = new SqlDeleter(jdbc);
        ClassMapping<E> mapping = mappingFactory.getClassMapping(entityType);
        return deleter.delete(mapping.getTableName());
    }

    private <E> void validate(E entity) {
        if (validator != null) {
            Set<ConstraintViolation<E>> cons = validator.validate(entity);
            if (LangUtils.isNotEmpty(cons)) {
                StringBuilder errorMessage = new StringBuilder();
                for (ConstraintViolation<E> constraintViolation : cons) {
                    errorMessage.append(constraintViolation.getMessage()).append(",");
                }
                throw new JuormJdbcException(errorMessage.toString());
            }
        }
    }

    private <E> GetOperate<E> getOperate(Class<E> entityType) {
        @SuppressWarnings("unchecked")
        GetOperate<E> get = (GetOperate<E>) getOperates.get(entityType);
        if (get == null) {
            ClassMapping<E> mapping = mappingFactory.getClassMapping(entityType);
            get = new GetOperate<>(jdbc, mapping);
            getOperates.put(entityType.getClass(), get);
        }
        return get;
    }
}
