
package cn.featherfly.hammer.dml.builder.sql;

import java.util.function.BiFunction;

import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.dml.builder.sql.vo.User;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryFetch;
import cn.featherfly.hammer.dsl.execute.Deleter;
import cn.featherfly.hammer.dsl.query.Query;

/**
 * dsl api invoke test
 *
 * @author zhongj
 */
public class DslEntityMetadataTest {

    private EntityQueryFetch<User> entityQueryFetch;

    Query query = null;

    Deleter deleter = null;

    Repository data = null;

    boolean ignore = true;

    public void entityStaticTypeQuery() {
        // YUFEI_TODO 后续来实现生成静态元数据类型
        //        query.find(User.class) //
        //            .fetch((fetcher, user) -> fetcher.fetch(user.id, user.name).fetch(user.age)) //
        //            .where() //
        //            .id.eq("") //
        //            .and() //
        //            .name.eq("") //
        //            .and() //
        //            .age.gt(18) //
        //            .list();

        //        query.find(User.class) //
        //            .fetch((fetcher, user) -> fetcher.fetch(user.id, user.name).fetch(user.age)) //
        //            .where(e -> e.id.eq("") //
        //                .and() //
        //                .name.eq("") //
        //                .and() //
        //                .age.gt(18) //
        //             ) //
        //            .list(); //

        //        query.find(User.class) //
        //            .join(UserInfo.class).on((e, j) -> j.userId.eq(e.id)) //
        //            .where((e1,e2) -> e1.id.eq("") //
        //                .and() //
        //                .name.eq("") //
        //                .and() //
        //                .age.gt(18) //
        //                .and(e2.username.eq("") //
        //                        .and().gender.eq(0) //
        //                ) //
        //             ) //
        //            .list(); //

        //        query.find(User.class) //
        //            .join(UserInfo.class).on((e, j) -> j.userId.eq(e.id)) //
        //            .where((e1,e2) -> e1.id.eq("") //
        //                .and() //
        //                .name.eq("") //
        //                .and() //
        //                .age.gt(18) //
        //                .and(e2) // 这种应该是没有问题的
        //                .username.eq("") //
        //                .and().gender.eq(0) //
        //             ) //
        //            .list(); //

        //    query.find(User.class) //
        //        .join(UserInfo.class).on((e, j) -> j.userId.eq(e.id)) //
        //        .where() //
        //        .id.eq("") //
        //        .and().name.eq("") //
        //        .and().age.gt(18) //
        //        .and() //
        //        .e2.username.eq("") //
        //        .and().gender.eq(0)
        //        .and().e1.age.gt(18) //
        //        .list(); //

        //    query.find(User.class) //
        //        .join(UserInfo.class).on((e, j) -> j.userId.eq(e.id)) //
        //        .where() //
        //        .id.eq("") //
        //        .and().name.eq("") //
        //        .and().age.gt(18) //
        //        .and((e1,e2) -> e2) // 大致是这样，不确定能否实现
        //        username.eq("") //
        //        .and().gender.eq(0)
        //        .and((e1,e2) -> e1)  // 大致是这样，不确定能否实现
        //        .age.gt(18) //
        //        .list(); //
    }
}

class EntityMetadataCondition {
    public void t() {
        UserMetadata um = new UserMetadata();
        um.and((m1, m2) -> m1);
    }
}

class EntityMetadataCondition2<M1 extends EntityMetadataCondition2<M1, M2>, M2 extends EntityMetadataCondition2<M1, M2>>
    extends EntityMetadataCondition {

    public <R extends EntityMetadataCondition> R and(BiFunction<M1, M2, R> fun) {
        return fun.apply(null, null);
    }
}

class UserMetadata extends EntityMetadataCondition2<UserMetadata, UserMetadata> {
    private int id;

    private String name;
}
