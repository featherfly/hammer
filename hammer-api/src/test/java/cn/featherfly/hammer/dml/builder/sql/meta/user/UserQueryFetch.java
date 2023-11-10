
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-10 18:04:10
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dml.builder.sql.meta.user;

import cn.featherfly.hammer.dml.builder.sql.meta.QueryFetch;

/**
 * Query.
 *
 * @author zhongj
 */
public interface UserQueryFetch extends QueryFetch<UserTableQueryable, UserTableFilterable, UserQueryFetch,
        UserTableFilterable, UserTableFilterable, UserTableLogic> {

    //    void field(OneArguFunction<UserTableQueryable, Field> fetchField);

    //    void fields(Function<UserTableQueryable, Field[]> fetchField);
    //    void field(ToArrayFunction<UserTableQueryable, Field> fetchField);

    //    default void fetch(OneArguFunction<UserTableQueryable, Field> fetchField) {
    //        field(fetchField);
    //    }

    //    default void fetch(ToArrayFunction<UserTableQueryable, Field> fetchField) {
    //        field(fetchField);
    //    }

}
