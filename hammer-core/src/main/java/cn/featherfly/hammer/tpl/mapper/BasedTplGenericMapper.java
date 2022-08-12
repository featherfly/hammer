
package cn.featherfly.hammer.tpl.mapper;

import java.io.Serializable;
import java.util.List;

import cn.featherfly.common.lang.CollectionUtils;
import cn.featherfly.common.repository.IgnorePolicy;
import cn.featherfly.hammer.GenericMapper;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.dsl.execute.Delete;
import cn.featherfly.hammer.dsl.execute.Update;
import cn.featherfly.hammer.dsl.query.TypeQueryEntity;

/**
 * <p>
 * BasedTplGenericHammer
 * </p>
 * .
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <ID> the generic type
 */
public class BasedTplGenericMapper<E, ID extends Serializable> implements GenericMapper<E, ID> {

    /** The hammer. */
    protected Hammer hammer;

    private Class<E> type;

    /**
     * Instantiates a new based tpl generic mapper.
     *
     * @param hammer hammer
     * @param type   type
     */
    public BasedTplGenericMapper(Hammer hammer, Class<E> type) {
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
    public int delete(ID id) {
        return hammer.delete(id, type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int deleteIds(@SuppressWarnings("unchecked") ID... ids) {
        return hammer.delete(ids, type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int deleteIds(List<ID> ids) {
        return hammer.delete(ids, type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E get(ID id) {
        return hammer.get(id, type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<E> get(@SuppressWarnings("unchecked") ID... ids) {
        return hammer.get(type, ids);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<E> get(List<ID> ids) {
        return get(CollectionUtils.toArray(ids));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E load(E entity) {
        return hammer.load(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E merge(E entity) {
        hammer.merge(entity);
        return load(entity);
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
    public E save(E entity) {
        hammer.save(entity);
        return entity;
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
    public E update(E entity) {
        hammer.update(entity);
        return entity;
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
    public E update(E entity, IgnorePolicy ignorePolicy) {
        hammer.update(entity, ignorePolicy);
        if (ignorePolicy == IgnorePolicy.NONE) {
            return entity;
        } else {
            return load(entity);
        }
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
