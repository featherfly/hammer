
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-10 18:04:10
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dml.builder.sql.meta.user;

import java.util.function.BiConsumer;
import java.util.function.Function;

import cn.featherfly.common.repository.Field;
import cn.featherfly.hammer.dsl.query.QueryFetchedFields;

/**
 * UserQueryFetchImpl.
 *
 * @author zhongj
 */
public class UserQueryFetchImpl implements UserQueryFetch {

    private QueryFetchedFields queryFetchedFields;

    private UserTableQueryable userTableQueryable;

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryFetch field(Function<UserTableQueryable, Field> fetchField) {
        queryFetchedFields.fetch(fetchField.apply(userTableQueryable));
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryFetch fields(Function<UserTableQueryable, Field[]> fetchField) {
        queryFetchedFields.fetch(fetchField.apply(userTableQueryable));
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserTableFilterable where() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryFetch fetch(BiConsumer<UserQueryFetch, UserTableQueryable> fetcher) {
        fetcher.accept(this, userTableQueryable);
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryFetch field(Field... fetchFields) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

}
