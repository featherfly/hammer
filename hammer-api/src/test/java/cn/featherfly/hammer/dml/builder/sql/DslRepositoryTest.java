
package cn.featherfly.hammer.dml.builder.sql;

import cn.featherfly.common.repository.Repository;
import cn.featherfly.common.repository.SimpleRepository;
import cn.featherfly.hammer.dsl.execute.Deleter;
import cn.featherfly.hammer.dsl.execute.Updater;
import cn.featherfly.hammer.dsl.query.Query;

/**
 * dsl api invoke test
 *
 * @author zhongj
 */
public class DslRepositoryTest {

    Query query = null;

    Updater updater = null;

    Deleter deleter = null;

    String strRepo = "user";

    Repository repo = new SimpleRepository(strRepo);

    boolean ignore = true;

    public void testPropertyUpdate() {
        updater.update(strRepo) //
                .field("name").set("yufei") //
                .field("pwd").set("123456") //
                .fieldAsNumber("score").increase(10) //
                .execute();

        updater.update(repo) //
                .field("name").set("yufei", v -> !v.equals("yufei")) //
                .field("pwd").set("123456") //
                .fieldAsNumber("score").increase(10, v -> v == null) //
                .execute();
    }

    public void testUpdate() {
        Repository u = new SimpleRepository("user");
        Repository r = new SimpleRepository("role");

        updater.update(u).set("name", "yufei").set("pwd", "123456").increase("score", 10).execute();

        updater.update(u).set("name", "yufei").execute();

        updater.update(r).set("name", "yufei").where().eq("user_id", 18).and().group().lt("age", 18).or().gt("age", 60)
                .execute();

        updater.update(r).set("name", "yufei").where().eq("user_id", 18).execute();

        String name = "yufei";

        updater.update(r).set(t -> {
            if (name.equals("yufei")) {
                t.set("name", name);
            }
        });

        updater.update(r).set("name", name, v -> v.equals("yufei"));
    }

    public void testDelete() {
        deleter.delete(strRepo).where().eq("user_id", 18).execute();
        deleter.delete(repo).where().eq("user_id", 18).execute();

        deleter.delete(repo).where() //
                .eq("user_id", 18) //
                .and() //
                .group() //
                .lt("age", 18) //
                .or() //
                .gt("age", 60) //
                .execute();
    }
}
