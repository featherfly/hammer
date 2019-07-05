
package cn.featherfly.juorm.rdb.jdbc;

import java.util.List;

import cn.featherfly.juorm.Juorm;
import cn.featherfly.juorm.dsl.execute.Delete;
import cn.featherfly.juorm.dsl.execute.Update;
import cn.featherfly.juorm.dsl.query.QueryEntity;

/**
 * <p>
 * JuormSqlImpl
 * </p>
 *
 * @author zhongj
 */
public class JuormJdbcImpl implements Juorm {

    private Jdbc jdbc;

    /**
     *
     */
    public JuormJdbcImpl(Jdbc jdbc) {
        this.jdbc = jdbc;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int save(E entity) {
        // YUFEI_TODO Auto-generated method stub
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int save(List<E> entities) {
        // YUFEI_TODO Auto-generated method stub
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int update(E entity) {
        // YUFEI_TODO Auto-generated method stub
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int update(List<E> entities) {
        // YUFEI_TODO Auto-generated method stub
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int update(E entity, IgnorePolicy ignorePolicy) {
        // YUFEI_TODO Auto-generated method stub
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int update(List<E> entities, IgnorePolicy ignorePolicy) {
        // YUFEI_TODO Auto-generated method stub
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int merge(E entity) {
        // YUFEI_TODO Auto-generated method stub
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int merge(List<E> entities) {
        // YUFEI_TODO Auto-generated method stub
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int delete(E entity) {
        // YUFEI_TODO Auto-generated method stub
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int delete(List<E> entities) {
        // YUFEI_TODO Auto-generated method stub
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> QueryEntity query(Class<E> entityType) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> Update update(Class<E> entityType) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> Delete delete(Class<E> entityType) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

}
