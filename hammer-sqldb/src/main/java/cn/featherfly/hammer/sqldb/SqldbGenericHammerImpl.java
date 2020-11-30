
package cn.featherfly.hammer.sqldb;

import java.util.List;

import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.hammer.GenericHammer;
import cn.featherfly.hammer.Hammer.IgnorePolicy;
import cn.featherfly.hammer.dsl.execute.Delete;
import cn.featherfly.hammer.dsl.execute.Update;
import cn.featherfly.hammer.dsl.query.TypeQueryEntity;

/**
 * <p>
 * SqldbGenericHammerImpl
 * </p>
 *
 * @author zhongj
 */
public abstract class SqldbGenericHammerImpl<E> implements GenericHammer<E> {

    private Class<E> type;

    private SqldbHammerImpl hammer;

    /**
     * @param hammer hammer
     */
    public SqldbGenericHammerImpl(SqldbHammerImpl hammer) {
        this.hammer = hammer;
        type = ClassUtils.getSuperClassGenericType(this.getClass());
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
    public int save(List<E> entities) {
        return hammer.save(entities);
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
    public int update(List<E> entities) {
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
    public int update(List<E> entities, IgnorePolicy ignorePolicy) {
        return hammer.update(entities, ignorePolicy);
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
    public int merge(List<E> entities) {
        return hammer.merge(entities);
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
    public int delete(List<E> entities) {
        return hammer.delete(entities);
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
    public Update update() {
        return hammer.update(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Delete delete() {
        return hammer.delete(type);
    }

}
