
package cn.featherfly.hammer.dml.builder.sql.query;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import cn.featherfly.common.repository.mapping.RowMapper;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.query.QueryRelateExpression;

/**
 * <p>
 * UserUpdate
 * </p>
 *
 * @author zhongj
 */
public class UserQueryWith implements QueryRelateExpression<UserQueryWith, UserQueryWithOn, UserQueryWithEntity,
        UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> {

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression where() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(Class<E> type) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(RowMapper<E> rowMapper) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryLimitExecutor limit(Integer limit) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryLimitExecutor limit(Integer offset, Integer limit) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryLimitExecutor limit(Page page) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression where(
            Consumer<UserQueryRepositoryConditionGroupExpression> consumer) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryWithOn join(String repositoryName) {

        return null;
    }

}
