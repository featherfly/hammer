
package cn.featherfly.juorm.sqldb.jdbc;

import java.util.List;

import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.juorm.GenericJuorm;
import cn.featherfly.juorm.Juorm.IgnorePolicy;
import cn.featherfly.juorm.dsl.execute.Delete;
import cn.featherfly.juorm.dsl.execute.Update;
import cn.featherfly.juorm.dsl.query.TypeQueryEntity;

/**
 * <p>
 * GenericJuormJdbcImpl
 * </p>
 *
 * @author zhongj
 */
public abstract class GenericJuormJdbcImpl<E> implements GenericJuorm<E> {

    private Class<E> type;

    private JuormJdbcImpl juorm;

    /**
     * @param juorm juorm
     */
    public GenericJuormJdbcImpl(JuormJdbcImpl juorm) {
        this.juorm = juorm;
        type = ClassUtils.getSuperClassGenricType(this.getClass());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int save(E entity) {
        return juorm.save(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int save(List<E> entities) {
        return juorm.save(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int update(E entity) {
        return juorm.update(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int update(List<E> entities) {
        return juorm.update(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int update(E entity, IgnorePolicy ignorePolicy) {
        return juorm.update(entity, ignorePolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int update(List<E> entities, IgnorePolicy ignorePolicy) {
        return juorm.update(entities, ignorePolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int merge(E entity) {
        return juorm.merge(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int merge(List<E> entities) {
        return juorm.merge(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int delete(E entity) {
        return juorm.delete(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int delete(List<E> entities) {
        return juorm.delete(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQueryEntity query() {
        return juorm.query(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Update update() {
        return juorm.update(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Delete delete() {
        return juorm.delete(type);
    }

}
