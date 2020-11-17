
package cn.featherfly.hammer.tpl.mapper;

import java.io.Serializable;
import java.util.List;

import cn.featherfly.hammer.GenericHammer;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.Hammer.IgnorePolicy;
import cn.featherfly.hammer.dsl.execute.Delete;
import cn.featherfly.hammer.dsl.execute.Update;
import cn.featherfly.hammer.dsl.query.TypeQueryEntity;

/**
 * <p>
 * BasedTplGenericHammer
 * </p>
 *
 * @author zhongj
 */
public class BasedTplGenericHammer<E> implements GenericHammer<E> {

    protected Hammer hammer;

    private Class<E> type;

    /**
     * @param hammer hammer
     * @param type   type
     */
    public BasedTplGenericHammer(Hammer hammer, Class<E> type) {
        this.hammer = hammer;
        this.type = type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Delete delete() {
        return hammer.delete(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int delete(E entity) {
        return hammer.delete(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int delete(@SuppressWarnings("unchecked") E... entities) {
        return hammer.delete(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int delete(List<E> entities) {
        return hammer.delete(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int delete(Serializable id) {
        return hammer.delete(id, type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int deleteIds(Serializable... ids) {
        return hammer.delete(ids, type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int deleteIds(List<Serializable> ids) {
        return hammer.delete(ids, type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E get(Serializable id) {
        return hammer.get(id, type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int merge(E entity) {
        return hammer.merge(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int merge(@SuppressWarnings("unchecked") E... entities) {
        return hammer.merge(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int merge(List<E> entities) {
        return hammer.merge(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQueryEntity query() {
        return hammer.query(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int save(E entity) {
        return hammer.save(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int save(@SuppressWarnings("unchecked") E... entities) {
        return hammer.save(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int save(List<E> entities) {
        return hammer.save(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Update update() {
        return hammer.update(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int update(E entity) {
        return hammer.update(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int update(@SuppressWarnings("unchecked") E... entities) {
        return hammer.update(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int update(E entity, IgnorePolicy ignorePolicy) {
        return hammer.update(entity, ignorePolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int update(List<E> entities) {
        return hammer.update(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int update(List<E> entities, IgnorePolicy ignorePolicy) {
        return hammer.update(entities, ignorePolicy);
    }
}
