
package cn.featherfly.hammer.dml.builder.sql.query;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.repository.mapping.RowMapper;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.query.QueryRelateEntityExpression;

/**
 * The Class UserQueryWithEntity.
 *
 * @author zhongj
 */
public class UserQueryWithEntity implements QueryRelateEntityExpression<UserQueryWith, UserQueryWithOn,
        UserQueryWithEntity, UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> {

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
    public UserQueryWith fetch() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryWithEntity fetch(String propertyName) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryWithEntity fetch(String... propertyNames) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryWithEntity fetch(SerializableFunction<T, R> propertyName) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T,
            R> UserQueryWithEntity fetch(@SuppressWarnings("unchecked") SerializableFunction<T, R>... propertyNames) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryWithEntity fetch(Collection<String> propertyNames) {

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
