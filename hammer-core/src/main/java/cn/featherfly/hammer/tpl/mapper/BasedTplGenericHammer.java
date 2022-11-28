
package cn.featherfly.hammer.tpl.mapper;

import java.io.Serializable;
import java.util.List;
import java.util.function.Function;

import cn.featherfly.common.lang.CollectionUtils;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.common.operator.LogicOperator;
import cn.featherfly.common.repository.IgnorePolicy;
import cn.featherfly.hammer.GenericHammer;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.dsl.execute.EntityDelete;
import cn.featherfly.hammer.dsl.execute.Update;
import cn.featherfly.hammer.dsl.query.type.EntityQueryEntity;

/**
 * BasedTplGenericHammer.
 *
 * @author zhongj
 */
public class BasedTplGenericHammer<E, ID extends Serializable> implements GenericHammer<E, ID> {

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
    public EntityQueryEntity<E> query() {
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

    /**
     * {@inheritDoc}
     */
    @Override
    public E getLockUpdate(Serializable id, Function<E, E> updateFunction) {
        return hammer.getLockUpdate(id, type, updateFunction);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E loadLockUpdate(E entity, Function<E, E> updateFunction) {
        return hammer.loadLockUpdate(entity, updateFunction);
    }
}
