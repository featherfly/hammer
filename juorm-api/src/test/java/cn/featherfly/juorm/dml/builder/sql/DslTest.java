
package cn.featherfly.juorm.dml.builder.sql;

import cn.featherfly.juorm.dsl.Repository;
import cn.featherfly.juorm.dsl.SimpleRepository;
import cn.featherfly.juorm.dsl.execute.Delete;
import cn.featherfly.juorm.dsl.execute.Deleter;
import cn.featherfly.juorm.dsl.execute.Update;
import cn.featherfly.juorm.dsl.execute.Updater;
import cn.featherfly.juorm.dsl.execute.property.PropertyUpdate;
import cn.featherfly.juorm.expression.query.Query;

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

        query.find(data).property("name").where().propertyString("name")
                .eq("yufei").and().propertyNumber("age").lt(18).and().group()
                .propertyNumber("score").gt(80).limit(11, 10)
                .list(DslTest.class);
    }

    public void testUpdate() {
        Updater<Update<?>> updater = null;

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
        Updater<PropertyUpdate<?>> updater = null;

        Repository u = new SimpleRepository("user");

        updater.update(u).property("name").set("yufei").property("pwd")
                .set("123456").propertyNumber("score").increase(10).execute();

    }

    public void testDelete() {
        Deleter<Delete> deleter = null;

        deleter.delete(new SimpleRepository("user")).where().eq("user_id", 18)
                .execute();

        deleter.delete(new SimpleRepository("user")).where().eq("user_id", 18)
                .and().group().lt("age", 18).or().gt("age", 60).execute();

    }
}
