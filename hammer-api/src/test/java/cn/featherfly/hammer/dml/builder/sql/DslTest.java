
package cn.featherfly.hammer.dml.builder.sql;

import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.hammer.dml.builder.sql.vo.Device;
import cn.featherfly.hammer.dml.builder.sql.vo.Tree;
import cn.featherfly.hammer.dml.builder.sql.vo.User;
import cn.featherfly.hammer.dml.builder.sql.vo.UserInfo;
import cn.featherfly.hammer.dsl.execute.Deleter;
import cn.featherfly.hammer.dsl.execute.Updater;
import cn.featherfly.hammer.dsl.query.Query;
import cn.featherfly.hammer.expression.Repository;
import cn.featherfly.hammer.expression.SimpleRepository;

/**
 * dsl api invoke test
 *
 * @author zhongj
 */
public class DslTest {

    Query query = null;

    Repository data = null;

    public void testQuery() {
        query.find(data).list(DslTest.class);
        query.find(data).limit(10).list(DslTest.class);
        query.find(data).limit(1).single(DslTest.class);

        query.find(data).count();
        query.find(data).property("name").number(Integer.class);
        query.find(data).property("name").integer();
        query.find(data).property("sum(price)").decimal();
        query.find(data).property(AggregateFunction.SUM, "price").decimal();
        query.find(data).sum("price").decimal();
        query.find(data).property(AggregateFunction.COUNT, "id").integer();
        query.find(data).count("id").integer();
        query.find(data).property(AggregateFunction.COUNT, "id").longInt();
        query.find(data).count("id").longInt();

        query.find(data).sum("id").longInt();

        query.find(data).property("count(*)").where().lt("age", 18).longInt();
        query.find(data).property(AggregateFunction.COUNT, "id").where().lt("age", 18).longInt();

        query.find(data).where().lt("age", 18).count();

        query.find(data).property("name").where().eq("", 1).and().lt("age", 18).and().group(t -> t.gt("score", 80))
                .limit(11, 10).list(DslTest.class);

        query.find(data).property("name").where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80)
                .limit(11, 10).list(DslTest.class);

        query.find(data).where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80).single(DslTest.class);

        query.find(data).property("name").where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80)
                .limit(11, 10).list(DslTest.class);

        query.find(data).property("name").where().property("").eq(1).and().property("age").lt(18).and().group()
                .property("score").gt(80).limit(11, 10).list(DslTest.class);

        query.find(data).where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80).sort().asc("name")
                .list(DslTest.class);

        query.find(data).where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80).sort().asc("name").limit(2)
                .list(DslTest.class);
    }

    public void testQueryJoin() {
        query.find("user").relate("user_info").on("user_id").fetch().relate("role").on("id", "user_role", "role_id")
                .fetch();
        query.find("user").relate("user_info").on("user_id").relate("role").on("id", "user_role", "role_id").fetch();

        query.find("user").relate("user_info").on("user_id").where();
        query.find("user").relate("user_info").on("user_id").fetch().where();
        query.find("user").relate("user_info").on("user_id").relate("user_role").on("user_id", "id").relate("role")
                .on("id", "user_role", "role_id").fetch();

        query.find("user").relate("user_info").on("user_id").fetch("name").fetch();

        query.find("user").relate("user_info").on("user_id").fetch("name").relate("user_role").on("user_id", "id")
                .relate("role").on("id", "user_role", "role_id").fetch();
    }

    public void testTypeQuery() {
        query.find(DslTest.class).list();
        query.find(DslTest.class).count();
        query.find(DslTest.class).limit(10).list();
        query.find(DslTest.class).limit(1).single();
        //        query.find(DslTest.class).where().lt("age", 18).count();

        // query.find(DslTest.class).property("name").number(Integer.class);
        // query.find(DslTest.class).property("name").integer();
        // query.find(DslTest.class).property("sum(price)").decimal();
        // query.find(DslTest.class).property("count(*)").where().lt("age",
        // 18).longInt();

        // query.find("user").relate("user_role").on("user_id").relate("role").on("id",
        // "user_role", "role_id").fetch()

        // 错误
        //        query.find(DslTest.class).property("name").where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80)
        //                .limit(11, 10).list();
        query.find(DslTest.class).property(DslTest::getName).where().eq(DslTest::getId, 1).and().lt(DslTest::getAge, 18)
                .and().group().gt(DslTest::getPrice, 80).limit(11, 10).list();

        query.find(DslTest.class).where().eq(DslTest::getId, 1).and().lt(DslTest::getAge, 18).and().group()
                .gt(DslTest::getPrice, 80).limit(11, 10).list();

        //        query.find(DslTest.class).where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80).single();

        //        query.find(DslTest.class).property("name").where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80)
        //                .limit(11, 10).list();

        //        query.find(DslTest.class).property("name").where().property("").eq(1).and().property("age").lt(18).and().group()
        //                .property("score").gt(80).limit(11, 10).list();

        //        query.find(DslTest.class).where().eq(DslTest::getId, 1).and().lt("age", 18).and().group().gt("score", 80).sort()
        //                .asc("name").limit(2).list();

        // 错误调用
        //        query.find(DslTest.class).where().eq(DslTest::getId, 1).and().eq(DslStaticTypeTest::toString, "").single();
        query.find(DslTest.class).where().co(DslTest::getName, "").and().setIgnorePolicy(null).co(null).single();
        query.find(DslTest.class).where().setIgnorePolicy(null).co(DslTest::toString, "").and().co(null).list();

        // TODO 如果后续加入编译期增强，则在使用注解标注泛型方法（例如find）
        // 目的是使得各种判断和类型匹配在编译期就处理完成，而不是在运行期就在获取
        /*
         1. co(DslTest::getName, "")替换为co("name", "")，或者BeanPropertyValue）
         2. co(DslTest::getName, "")替换为co(BeanPropertyValue)
         3. co(DslTest::getName, "")替换为co(RepositoryFieldValue)
            此参数需要在编译期就搞好所有中间过程，即在jdbc设置时，不去使用SqlTypeMappingManager进行类型判断
         */
        DslTest test = query.<@Enhance DslTest>find(DslTest.class).where().co(DslTest::getName, "").and()
                .setIgnorePolicy(null).co(null).single();
    }

    public void testTypeQueryJoin() {
        // IMPLSOON 这里的where()后没有list等方法
        //        query.find(DslTest.class).with(DslTest::getId).where().list();
        query.find(DslTest.class).join(DslTest::getId).where().eq(DslTest::getId, 1).list();
        query.find(DslTest.class).join(DslTest::getId).fetch().where().eq(DslTest::getId, 1).list();

        // select * from user u join userinfo ui on u.id = ui.user_id
        query.find(User.class).join(User::getUserInfo);
        // select * from user u join userinfo ui on u.id = ui.user_id
        query.find(User.class).join(UserInfo::getUser);
        // select * from user u join device d on u.id = d.user_id
        query.find(User.class).join(User::getDevices);
        // select * from user u join device d on u.id = d.user_id
        query.find(User.class).join(Device::getUser);

        // with(Function)，都是和find的对象进行关联
        // select * from user u join userinfo ui on u.id = ui.user_id join device d on u.id = d.user_id
        query.find(User.class).join(User::getUserInfo).join(User::getDevices);
        // select * from user u join userinfo ui on u.id = ui.user_id join device d on u.id = d.user_id join user u2 on ui.user_id = u2.id
        query.find(User.class).join(User::getUserInfo).join(User::getDevices).join(UserInfo::getUser);

        // select * from tree t1 join tree t2 on t1.id = t2.parent_id join tree t3 on t1.id = t3.parent_id
        query.find(Tree.class).join(Tree::getParent).join(Tree::getParent);

        query.find(Tree.class).join(Tree::getParent).join(Tree::getUser).join2(User::getUserInfo);

        query.find(Tree.class).join(Tree::getParent).join(Tree::getParent).join(Tree::getParent);

        // IMPLSOON with join的api定义规则
        /*
         // select * from tree t1 join tree t2 on t1.id = t2.parent_id join tree t3 on t2.id = t3.parent_id
         query.find(Tree.class).join(Tree::getParent).join(t -> {
             //  t为Tuple类型，有几个可以join的对象就是有几个对象的tuple
             //  这里表示和 tree t2 进行join，所以join tree t3 on t2.id = t3.parent_id
             t.get1().join(Tree::getParent);
         });
         // IMPLSOON 可以先实现下面这种方式，因为这种方式不需要多个返回结果类型，在现有结构上就能实现
         query.find(Tree.class).join(Tree::getParent, t -> {
           //  这里表示和 tree t2 进行join，所以join tree t3 on t2.id = t3.parent_id
           // 也就是t2有多个关联可以在这里进行全部操作
           t.join(Tree::getParent)
               .join(Tree::getParent);
         });
         */

        // IMPLSOON with join的api定义规则
        /*
         // select * from tree t1 join tree t2 on t1.id = t2.parent_id join tree t3 on t2.id = t3.parent_id
         query.find(Tree.class).with(Tree::getParent).with(t -> {
             //  t为Tuple类型，有几个可以join的对象就是有几个对象的tuple
             //  这里表示和 tree t2 进行join，所以join tree t3 on t2.id = t3.parent_id
             t.get1().with(Tree::getParent);
         });
         // IMPLSOON 可以先实现下面这种方式，因为这种方式不需要多个返回结果类型，在现有结构上就能实现
         query.find(Tree.class).with(Tree::getParent, t -> {
           //  这里表示和 tree t2 进行join，所以join tree t3 on t2.id = t3.parent_id
           // 也就是t2有多个关联可以在这里进行全部操作
           t.with(Tree::getParent)
               .with(Tree::getParent);
         });
         */
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

        String name = "yufei";

        updater.update(r).set(t -> {
            if (name.equals("yufei")) {
                t.set("name", name);
            }
        });
    }

    public void testPropertyUpdate() {
        Updater updater = null;

        Repository u = new SimpleRepository("user");

        updater.update(u).property("name").set("yufei").property("pwd").set("123456").propertyNumber("score")
                .increase(10).execute();

    }

    public void testDelete() {
        Deleter deleter = null;

        deleter.delete(new SimpleRepository("user")).where().eq("user_id", 18).execute();

        deleter.delete(new SimpleRepository("user")).where().eq("user_id", 18).and().group().lt("age", 18).or()
                .gt("age", 60).execute();

    }

    private int id;

    private int age;

    private String name;

    private double price;

    /**
     * get id value
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * set id value
     *
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * get age value
     *
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * set age value
     *
     * @param age age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * get name value
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * set name value
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get price value
     *
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * set price value
     *
     * @param price price
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
