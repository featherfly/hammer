
package cn.featherfly.hammer.dml.builder.sql;

import cn.featherfly.hammer.dsl.execute.Deleter;
import cn.featherfly.hammer.dsl.execute.Updater;
import cn.featherfly.hammer.dsl.query.Query;
import cn.featherfly.hammer.expression.Repository;
import cn.featherfly.hammer.expression.SimpleRepository;
import cn.featherfly.hammer.operator.AggregateFunction;

/**
 * <p>
 * DslTest
 * </p>
 *
 * @author zhongj
 */
public class DslTest {

    public void testQuery() {
        Query query = null;
        Repository data = null;

        query.find(data).list(DslTest.class);
        query.find(data).limit(10).list(DslTest.class);
        query.find(data).limit(1).single(DslTest.class);

        query.find(data).count();
        query.find(data).property("name").number(Integer.class);
        query.find(data).property("name").integer();
        query.find(data).property("sum(price)").decimal();
        query.find(data).property("price", AggregateFunction.SUM).decimal();
        query.find(data).property("id", AggregateFunction.COUNT).integer();
        query.find(data).property("id", AggregateFunction.COUNT).longInt();

        query.find(data).property("count(*)").where().lt("age", 18).longInt();
        query.find(data).property("id", AggregateFunction.COUNT).where()
                .lt("age", 18).longInt();

        query.find(data).where().lt("age", 18).count();

        query.find(data).property("name").where().eq("", 1).and().lt("age", 18)
                .and().group().gt("score", 80).limit(11, 10)
                .list(DslTest.class);

        query.find(data).where().eq("", 1).and().lt("age", 18).and().group()
                .gt("score", 80).single(DslTest.class);

        query.find(data).property("name").where().eq("", 1).and().lt("age", 18)
                .and().group().gt("score", 80).limit(11, 10)
                .list(DslTest.class);

        query.find(data).property("name").where().property("").eq(1).and()
                .property("age").lt(18).and().group().property("score").gt(80)
                .limit(11, 10).list(DslTest.class);

        query.find(data).where().eq("", 1).and().lt("age", 18).and().group()
                .gt("score", 80).sort().asc("name").list(DslTest.class);

        query.find(data).where().eq("", 1).and().lt("age", 18).and().group()
                .gt("score", 80).sort().asc("name").limit(2)
                .list(DslTest.class);

        query.find(DslTest.class).list();
        query.find(DslTest.class).count();
        query.find(DslTest.class).limit(10).list();
        query.find(DslTest.class).limit(1).single();
        query.find(DslTest.class).where().lt("age", 18).count();
        // query.find(DslTest.class).property("name").number(Integer.class);
        // query.find(DslTest.class).property("name").integer();
        // query.find(DslTest.class).property("sum(price)").decimal();
        // query.find(DslTest.class).property("count(*)").where().lt("age",
        // 18).longInt();

        query.find("user").with("user_info").on("user_id").fetch().with("role")
                .on("id", "user_role", "role_id").fetch();
        query.find("user").with("user_info").on("user_id").with("role")
                .on("id", "user_role", "role_id").fetch();

        query.find("user").with("user_info").on("user_id").where();
        query.find("user").with("user_info").on("user_id").fetch().where();
        query.find("user").with("user_info").on("user_id").with("user_role")
                .on("user_id", "id").with("role")
                .on("id", "user_role", "role_id").fetch();

        query.find("user").with("user_info").on("user_id").fetch("name")
                .fetch();

        query.find("user").with("user_info").on("user_id").fetch("name")
                .with("user_role").on("user_id", "id").with("role")
                .on("id", "user_role", "role_id").fetch();

        // query.find("user").with("user_role").on("user_id").with("role").on("id",
        // "user_role", "role_id").fetch()

        query.find(DslTest.class).property("name").where().eq("", 1).and()
                .lt("age", 18).and().group().gt("score", 80).limit(11, 10)
                .list();

        query.find(DslTest.class).where().eq("", 1).and().lt("age", 18).and()
                .group().gt("score", 80).single();

        query.find(DslTest.class).property("name").where().eq("", 1).and()
                .lt("age", 18).and().group().gt("score", 80).limit(11, 10)
                .list();

        query.find(DslTest.class).property("name").where().property("").eq(1)
                .and().property("age").lt(18).and().group().property("score")
                .gt(80).limit(11, 10).list();

        query.find(DslTest.class).where().eq("", 1).and().lt("age", 18).and()
                .group().gt("score", 80).sort().asc("name").limit(2).list();
    }

    public void testUpdate() {
        Updater updater = null;

        Repository u = new SimpleRepository("user");
        Repository r = new SimpleRepository("role");

        updater.update(u).set("name", "yufei").set("pwd", "123456")
                .increase("score", 10).execute();

        updater.update(u).set("name", "yufei").execute();

        updater.update(r).set("name", "yufei").where().eq("user_id", 18).and()
                .group().lt("age", 18).or().gt("age", 60).execute();

        updater.update(r).set("name", "yufei").where().eq("user_id", 18)
                .execute();

    }

    public void testPropertyUpdate() {
        Updater updater = null;

        Repository u = new SimpleRepository("user");

        updater.update(u).property("name").set("yufei").property("pwd")
                .set("123456").propertyNumber("score").increase(10).execute();

    }

    public void testDelete() {
        Deleter deleter = null;

        deleter.delete(new SimpleRepository("user")).where().eq("user_id", 18)
                .execute();

        deleter.delete(new SimpleRepository("user")).where().eq("user_id", 18)
                .and().group().lt("age", 18).or().gt("age", 60).execute();

    }
}
