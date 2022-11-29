
package cn.featherfly.hammer.dml.builder.sql.query;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import cn.featherfly.common.repository.mapping.RowMapper;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.query.QueryWithExpression;

/**
 * <p>
 * UserUpdate
 * </p>
 *
 * @author zhongj
 */
public class UserQueryWith implements
        QueryWithExpression<UserQueryWith, UserQueryWithOn, UserQueryWithEntity, UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> {

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression where() {
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
    public QueryLimitExecutor limit(Integer limit) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryLimitExecutor limit(Integer offset, Integer limit) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryLimitExecutor limit(Page page) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression where(
            Consumer<UserQueryRepositoryConditionGroupExpression> consumer) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryWithOn join(String repositoryName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

}
