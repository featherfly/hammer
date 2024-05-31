
package cn.featherfly.hammer.tpl.mapper;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.common.repository.ParamedExecutionExecutorEx;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.dsl.entity.execute.EntityDelete;
import cn.featherfly.hammer.dsl.entity.execute.EntityUpdate;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryFetch;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryDelete;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryUpdate;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryFetch;
import cn.featherfly.hammer.tpl.TplExecuteId;
import cn.featherfly.hammer.tpl.TplExecuteIdBuilder;
import cn.featherfly.hammer.tpl.TplExecutor;

/**
 * BasedTplHammer.
 *
 * @author zhongj
 */
public class BasedTplHammer extends AbstractBasedHammer implements Hammer {

    /** The hammer. */
    protected final Hammer hammer;

    /**
     * Instantiates a new based hammer tpl executor.
     *
     * @param hammer the hammer
     * @param hammerConfig the hammer config
     */
    public BasedTplHammer(Hammer hammer, HammerConfig hammerConfig) {
        super(hammer.template(), hammerConfig);
        this.hammer = hammer;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryDelete delete(String repository) {
        return hammer.delete(repository);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> EntityDelete<E> delete(Class<E> entityType) {
        return hammer.delete(entityType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int delete(Serializable id, Class<E> entityType) {
        return hammer.delete(id, entityType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int delete(E entity) {
        return hammer.delete(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int[] delete(@SuppressWarnings("unchecked") E... entities) {
        return hammer.delete(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int[] delete(List<E> entities) {
        return hammer.delete(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E load(E entity) {
        return hammer.load(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E get(E entity) {
        return hammer.load(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E get(Serializable id, Class<E> type) {
        return hammer.get(id, type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int merge(E entity) {
        return hammer.merge(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int[] merge(@SuppressWarnings("unchecked") E... entities) {
        return hammer.merge(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int[] merge(List<E> entities) {
        return hammer.merge(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> EntityQueryFetch<E> query(Class<E> entityType) {
        return hammer.query(entityType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryFetch query(String repository) {
        return hammer.query(repository);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryFetch query(Repository repository) {
        return hammer.query(repository);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int save(E entity) {
        return hammer.save(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int[] save(@SuppressWarnings("unchecked") E... entities) {
        return hammer.save(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int[] save(E[] entities, int batchSize) {
        return hammer.save(entities, batchSize);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int[] save(List<E> entities) {
        return hammer.save(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int[] save(List<E> entities, int batchSize) {
        return hammer.save(entities, batchSize);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryUpdate update(String repository) {
        return hammer.update(repository);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> EntityUpdate<E> update(Class<E> entityType) {
        return hammer.update(entityType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int update(E entity) {
        return hammer.update(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int[] update(@SuppressWarnings("unchecked") E... entities) {
        return hammer.update(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int[] update(E[] entities, int batchSize) {
        return hammer.update(entities, batchSize);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int update(E entity, IgnoreStrategy ignoreStrategy) {
        return hammer.update(entity, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int[] update(List<E> entities) {
        return hammer.update(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int[] update(List<E> entities, int batchSize) {
        return hammer.update(entities, batchSize);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int[] update(List<E> entities, IgnoreStrategy ignoreStrategy) {
        return hammer.update(entities, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int[] delete(Serializable[] ids, Class<E> entityType) {
        return hammer.delete(ids, entityType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, I extends Serializable> int[] delete(List<I> ids, Class<E> entityType) {
        return hammer.delete(ids, entityType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> get(Class<E> type, Serializable... ids) {
        return hammer.get(type, ids);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> get(Class<E> type, List<Serializable> ids) {
        return hammer.get(type, ids);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, R> E get(Serializable id, Class<E> type, SerializableFunction<E, R> fetchProperty) {
        return hammer.get(id, type, fetchProperty);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int saveOrUpdate(E entity) {
        return hammer.saveOrUpdate(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int saveOrUpdate(E entity, Predicate<E> updatable) {
        return hammer.saveOrUpdate(entity, updatable);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E updateFetch(Serializable id, Class<E> type, UnaryOperator<E> updateOperator) {
        return hammer.updateFetch(id, type, updateOperator);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E updateFetch(E entity, UnaryOperator<E> updateOperator) {
        return hammer.updateFetch(entity, updateOperator);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryUpdate update(Repository repository) {
        return hammer.update(repository);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryDelete delete(Repository repository) {
        return hammer.delete(repository);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParamedExecutionExecutorEx dml(String execution, Map<String, Serializable> params) {
        return hammer.dml(execution, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParamedExecutionExecutorEx dml(String execution, Serializable... params) {
        return hammer.dml(execution, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TplExecutor template() {
        return hammer.template();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParamedExecutionExecutorEx template(String templateContent, Map<String, Serializable> params) {
        return hammer.template(templateContent, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParamedExecutionExecutorEx template(Function<TplExecuteIdBuilder, TplExecuteId> tplExecuteIdBuilder,
        Map<String, Serializable> params) {
        return hammer.template(tplExecuteIdBuilder, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParamedExecutionExecutorEx template(TplExecuteId tplExecuteId, Map<String, Serializable> params) {
        return hammer.template(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParamedExecutionExecutorEx template(String tplExecuteId, Serializable... params) {
        return hammer.template(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParamedExecutionExecutorEx template(Function<TplExecuteIdBuilder, TplExecuteId> tplExecuteIdBuilder,
        Serializable... params) {
        return hammer.template(tplExecuteIdBuilder, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParamedExecutionExecutorEx template(TplExecuteId tplExecuteId, Serializable... params) {
        return hammer.template(tplExecuteId, params);
    }
}
