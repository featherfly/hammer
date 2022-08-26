
package cn.featherfly.hammer.dml.builder.sql;

import cn.featherfly.hammer.dml.builder.sql.query.UserQuery;
import cn.featherfly.hammer.dml.builder.sql.update.UserUpdate;
import cn.featherfly.hammer.dml.builder.sql.update.UserUpdater;

/**
 * <p>
 * DslTest
 * </p>
 *
 * @author zhongj
 */
public class DslStaticTypeTest {

    public void testQuery() {
        UserQuery userQuery = null;
        // userQuery.find().properties().name().pwd().limit(1)
        // .single(UserQuery.class);

        //        IMPLSOON 后续来修正下面几行
        //        userQuery.find().properties().name().pwd().limit(1).single(UserQuery.class);
        //        userQuery.find().limit(1).single(UserQuery.class);
        //        userQuery.find().where().name().eq("yufei").and().pwd().eq("123456").and().group().age().ge(18).and().age()
        //                .le(30);

    }

    public void testUpdate() {
        UserUpdate userUpdate = null;
        userUpdate.name().set("yufei").age().increase(10).pwd().set("123").execute();

        UserUpdater userUpdater = null;
        userUpdater.update().name().set("yufei").age().increase(10).pwd().set("123").execute();

    }

    public void testDelete() {

    }
}
