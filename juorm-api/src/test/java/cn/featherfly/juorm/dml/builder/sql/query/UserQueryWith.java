
package cn.featherfly.juorm.dml.builder.sql.query;

import java.util.List;
import java.util.Map;

import cn.featherfly.common.structure.page.Page;
import cn.featherfly.juorm.expression.query.QueryExecutor;
import cn.featherfly.juorm.expression.query.QueryWithExpression;
import cn.featherfly.juorm.mapping.RowMapper;

/**
 * <p>
 * UserUpdate
 * </p>
 *
 * @author zhongj
 */
public class UserQueryWith implements
        QueryWithExpression<UserQueryWith, UserQueryWithOn, UserQueryWithEntity, UserQueryConditionGroupExpression, UserQueryConditionGroupExpression> {

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression where() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryWithOn with(String repositoryName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(Class<E> type) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(RowMapper<E> rowMapper) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryExecutor limit(Integer limit) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryExecutor limit(Integer offset, Integer limit) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryExecutor limit(Page page) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryWithOn with(Class<T> repositoryType) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

}
