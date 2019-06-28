
package cn.featherfly.juorm.dml.builder.sql;

import cn.featherfly.juorm.dsl.Repository;
import cn.featherfly.juorm.dsl.SimpleRepository;
import cn.featherfly.juorm.dsl.execute.Deleter;
import cn.featherfly.juorm.dsl.execute.Updater;
import cn.featherfly.juorm.dsl.query.Query;

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

        query.find(data).property("name").number(Integer.class);
        query.find(data).property("name").integer();
        query.find(data).property("sum(price)").decimal();

        query.find(data).property("count(*)").where().lt("age", 18).longInt();

        query.find(data).property("name").where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80)
                .limit(11, 10).list(DslTest.class);

        query.find(data).where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80).single(DslTest.class);

        query.find(data).property("name").where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80)
                .limit(11, 10).list(DslTest.class);
    }

    public void testUpdate() {
        Updater updater = null;

        Repository u = new SimpleRepository("user");
        Repository r = new SimpleRepository("role");

        updater.update(u).set("name", "yufei").set("pwd", "123456").increase("score", 10).execute();

        updater.update(u).set("name", "yufei").execute();

        updater.update(r).set("name", "yufei").where().eq("user_id", 18).and().group().lt("age", 18).or().gt("age", 60)
                .execute();

        updater.update(r).set("name", "yufei").where().eq("user_id", 18).execute();

    }

    public void testDelete() {
        Deleter deleter = null;

        deleter.delete(new SimpleRepository("user")).where().eq("user_id", 18).execute();

        deleter.delete(new SimpleRepository("user")).where().eq("user_id", 18).and().group().lt("age", 18).or()
                .gt("age", 60).execute();

    }
}
