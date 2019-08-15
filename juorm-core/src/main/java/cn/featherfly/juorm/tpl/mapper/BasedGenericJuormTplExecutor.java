
package cn.featherfly.juorm.tpl.mapper;

import java.io.Serializable;
import java.util.List;

import cn.featherfly.juorm.GenericJuorm;
import cn.featherfly.juorm.Juorm;
import cn.featherfly.juorm.Juorm.IgnorePolicy;
import cn.featherfly.juorm.dsl.execute.Delete;
import cn.featherfly.juorm.dsl.execute.Update;
import cn.featherfly.juorm.dsl.query.QueryEntity;

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
     * @param juorm
     * @param type
     */
    public BasedGenericJuormTplExecutor(Juorm juorm, Class<E> type) {
        this.juorm = juorm;
        this.type = type;
    }

    /**
     * @param entity
     * @return
     * @see cn.featherfly.juorm.Juorm#save(java.lang.Object)
     */
    @Override
    public int save(E entity) {
        return juorm.save(entity);
    }

    /**
     * @param entities
     * @return
     * @see cn.featherfly.juorm.Juorm#save(java.util.List)
     */
    @Override
    public int save(List<E> entities) {
        return juorm.save(entities);
    }

    /**
     * @param entity
     * @return
     * @see cn.featherfly.juorm.Juorm#update(java.lang.Object)
     */
    @Override
    public int update(E entity) {
        return juorm.update(entity);
    }

    /**
     * @param entities
     * @return
     * @see cn.featherfly.juorm.Juorm#update(java.util.List)
     */
    @Override
    public int update(List<E> entities) {
        return juorm.update(entities);
    }

    /**
     * @param entity
     * @param ignorePolicy
     * @return
     * @see cn.featherfly.juorm.Juorm#update(java.lang.Object,
     *      cn.featherfly.juorm.Juorm.IgnorePolicy)
     */
    @Override
    public int update(E entity, IgnorePolicy ignorePolicy) {
        return juorm.update(entity, ignorePolicy);
    }

    /**
     * @param entities
     * @param ignorePolicy
     * @return
     * @see cn.featherfly.juorm.Juorm#update(java.util.List,
     *      cn.featherfly.juorm.Juorm.IgnorePolicy)
     */
    @Override
    public int update(List<E> entities, IgnorePolicy ignorePolicy) {
        return juorm.update(entities, ignorePolicy);
    }

    /**
     * @param entity
     * @return
     * @see cn.featherfly.juorm.Juorm#merge(java.lang.Object)
     */
    @Override
    public int merge(E entity) {
        return juorm.merge(entity);
    }

    /**
     * @param entities
     * @return
     * @see cn.featherfly.juorm.Juorm#merge(java.util.List)
     */
    @Override
    public int merge(List<E> entities) {
        return juorm.merge(entities);
    }

    /**
     * @param entity
     * @return
     * @see cn.featherfly.juorm.Juorm#delete(java.lang.Object)
     */
    @Override
    public int delete(E entity) {
        return juorm.delete(entity);
    }

    /**
     * @param entities
     * @return
     * @see cn.featherfly.juorm.Juorm#delete(java.util.List)
     */
    @Override
    public int delete(List<E> entities) {
        return juorm.delete(entities);
    }

    /**
     * @param id
     * @return
     * @see cn.featherfly.juorm.Juorm#get(java.io.Serializable, java.lang.Class)
     */
    @Override
    public E get(Serializable id) {
        return juorm.get(id, type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryEntity query() {
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
