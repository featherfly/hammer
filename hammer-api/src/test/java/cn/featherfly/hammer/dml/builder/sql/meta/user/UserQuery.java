
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-10 18:04:10
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dml.builder.sql.meta.user;

import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.hammer.dml.builder.sql.meta.Query;
import cn.featherfly.hammer.dml.builder.sql.meta.RepositoryQuery;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup;

import java.util.function.Function;

/**
 * Query.
 *
 * @author zhongj
 */
public class UserQuery implements RepositoryQuery<UserTableQueryable, UserTableFilterable, UserQueryFetch,
    UserTableFilterable, UserTableFilterable, UserTableLogic> {

    public static final UserQuery DEFAULT = new UserQuery();

    UserTableQueryable queryable;

    UserTableFilterable filterable;

    public static final String NAME = "user";

    private UserQuery() {
    }

    public void init(AliasManager aliasManager, RepositoryQueryConditionsGroup queryCondition) {
        String alias = aliasManager.getAlias(NAME);
        queryable = new UserTableQueryable();
        filterable = new UserTableFilterable(alias, queryCondition);
    }

    public static void main(String[] args) {
        Query query = null;

        UserQuery userQuery = UserQuery.DEFAULT;

        query.find(userQuery) //
            .fetch((fetcher, user) -> fetcher.field( // select
                user.name, // user0.name
                user.password.alias("pwd")) // user0.password as pwd
            ) // select end
            .where().age.in(null);

        query.find(userQuery) //
            .field(user -> user.name) // user0.name
            .field(user -> user.password.alias("pwd") // user0.password as pwd
            )// select end
            .where();

        query.find(userQuery) //
            .fields(user -> new Field[] { //
                user.name, // user0.name
                user.password.alias("pwd") // user0.password as pwd
            })// select end
            .where();

        query.find(userQuery) //
            .field(// select
                userQuery.queryable.name, // user0.name
                userQuery.queryable.password // user0.password as pwd
            ) // select end
            .where();

        query.find(userQuery).where() //
            .name.eq("zj") //
            .and().group().name.eq("zj") //
            .and().password.eq("123").endGroup() //
            .list();
        query.find(userQuery).where() //
            .name.eq("zj")//
            .and().group().name.eq("zj") //
            .and().password.eq("123") //
            .list();

        query.find(userQuery).where()//
            .name.eq("zj") //
            .and().group(g -> g.name.eq("zj")//
                .and().password.eq("123"))//
            .list();
        query.find(userQuery).where() //
            .name.eq("zj") //
            .and((Function<UserTableFilterable, UserTableLogic>) g -> g.name.eq("zj") //
                .and().password.eq("123") //
            ).list();

        query.find(userQuery).where().name.eq("zj").and().password.eq("123").single();
        query.find(userQuery).where().name.eq("zj").and().password.eq("123").limit(1).single();
        query.find(userQuery).where().name.eq("zj").and().password.alias("pwd").eq("123").limit(1).single();

        query.find(userQuery).where().alias("");

        query.find(userQuery).where().name.eq("zj").and().password.eq("123").unique();
        query.find(userQuery).where().name.eq("zj").and().password.eq("123").limit(1).unique();

        query.find(userQuery).where().name.eq("zj").and().password.eq("123").list();
        query.find(userQuery).where().name.eq("zj").and().password.eq("123").limit(10).list();

        query.find(userQuery).where().name.eq("zj").and().password.eq("123").limit(10).pagination();
    }
}
