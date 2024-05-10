
package cn.featherfly.hammer.tpl.mapper;

import java.io.Serializable;
import java.util.List;
import java.util.function.UnaryOperator;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.lang.CollectionUtils;
import cn.featherfly.common.operator.LogicOperator;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.GenericHammer;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.dsl.entity.execute.EntityDelete;
import cn.featherfly.hammer.dsl.entity.execute.EntityUpdate;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryFetch;

/**
 * BasedTplGenericHammer.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <ID> the generic type
 */
public class BasedTplGenericHammer<E, ID extends Serializable> extends AbstractBasedHammer
        implements GenericHammer<E, ID> {

    /** The hammer. */
    protected final Hammer hammer;

    private final Class<E> type;

    /**
     * Instantiates a new based tpl generic hammer.
     *
     * @param hammer       hammer
     * @param type         type
     * @param hammerConfig the hammer config
     */
    public BasedTplGenericHammer(Hammer hammer, Class<E> type, HammerConfig hammerConfig) {
        super(hammer.template(), hammerConfig);
        this.hammer = hammer;
        this.type = type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityDelete<E> delete() {
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
    public int[] delete(@SuppressWarnings("unchecked") E... entities) {
        return hammer.delete(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int[] delete(List<E> entities) {
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
    public int[] deleteIds(@SuppressWarnings("unchecked") ID... ids) {
        return hammer.delete(ids, type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int[] deleteIds(List<ID> ids) {
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
    public <R> E get(Serializable id, SerializableFunction<E, R> fetchProperty) {
        return hammer.get(id, type, fetchProperty);
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
    public int merge(E entity) {
        return hammer.merge(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int[] merge(@SuppressWarnings("unchecked") E... entities) {
        return hammer.merge(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int[] merge(List<E> entities) {
        return hammer.merge(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryFetch<E> query() {
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
    public int[] save(@SuppressWarnings("unchecked") E... entities) {
        return hammer.save(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int[] save(E[] entities, int batchSize) {
        return hammer.save(entities, batchSize);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int[] save(List<E> entities) {
        return hammer.save(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int[] save(List<E> entities, int batchSize) {
        return hammer.save(entities, batchSize);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityUpdate<E> update() {
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
    public E updateFetch(Serializable id, UnaryOperator<E> updateOperator) {
        return hammer.updateFetch(id, type, updateOperator);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E updateFetch(E entity, UnaryOperator<E> updateOperator) {
        return hammer.updateFetch(entity, updateOperator);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int[] update(@SuppressWarnings("unchecked") E... entities) {
        return hammer.update(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int update(E entity, IgnoreStrategy ignoreStrategy) {
        return hammer.update(entity, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int[] update(List<E> entities) {
        return hammer.update(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int[] update(List<E> entities, int batchSize) {
        return hammer.update(entities, batchSize);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int[] update(List<E> entities, IgnoreStrategy ignoreStrategy) {
        return hammer.update(entities, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E querySingle(SerializableSupplier<?>... propertyValues) {
        return hammer.querySingle(type, propertyValues);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<E> queryList(SerializableSupplier<?>... propertyValues) {
        return hammer.queryList(type, propertyValues);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<E> queryList(LogicOperator operator, SerializableSupplier<?>... propertyValues) {
        return hammer.queryList(type, operator, propertyValues);
    }
}
