
package cn.featherfly.juorm.tpl.mapper;

import java.io.Serializable;
import java.util.List;

import cn.featherfly.juorm.GenericJuorm;
import cn.featherfly.juorm.Juorm;
import cn.featherfly.juorm.Juorm.IgnorePolicy;
import cn.featherfly.juorm.dsl.execute.Delete;
import cn.featherfly.juorm.dsl.execute.Update;
import cn.featherfly.juorm.dsl.query.TypeQueryEntity;

/**
 * <p>
 * UserMapperImpl
 * </p>
 * <p>
 * 2019-08-14
 * </p>
 *
 * @author zhongj
 */
public class BasedGenericJuormTplExecutor<E> implements GenericJuorm<E> {

    protected Juorm juorm;

    private Class<E> type;

    /**
     * @param juorm juorm
     * @param type  type
     */
    public BasedGenericJuormTplExecutor(Juorm juorm, Class<E> type) {
        this.juorm = juorm;
        this.type = type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Delete delete() {
        return juorm.delete(type);
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
    public int delete(@SuppressWarnings("unchecked") E... entities) {
        return juorm.delete(entities);
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
    public int delete(Serializable id) {
        return juorm.delete(id, type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int deleteIds(Serializable... ids) {
        int result = 0;
        for (Serializable id : ids) {
            result += delete(id);
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int deleteIds(List<Serializable> ids) {
        int result = 0;
        for (Serializable id : ids) {
            result += delete(id);
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E get(Serializable id) {
        return juorm.get(id, type);
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
    public int merge(@SuppressWarnings("unchecked") E... entities) {
        return juorm.merge(entities);
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
    public TypeQueryEntity query() {
        return juorm.query(type);
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
    public int save(@SuppressWarnings("unchecked") E... entities) {
        return juorm.save(entities);
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
    public Update update() {
        return juorm.update(type);
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
    public int update(@SuppressWarnings("unchecked") E... entities) {
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
    public int update(List<E> entities) {
        return juorm.update(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int update(List<E> entities, IgnorePolicy ignorePolicy) {
        return juorm.update(entities, ignorePolicy);
    }
}
