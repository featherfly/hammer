
package cn.featherfly.hammer.dml.builder.sql;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.lang.CollectionUtils;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.dml.builder.sql.vo.Student2;
import cn.featherfly.hammer.dml.builder.sql.vo.Tree;
import cn.featherfly.hammer.dml.builder.sql.vo.User;
import cn.featherfly.hammer.dml.builder.sql.vo.User2;
import cn.featherfly.hammer.dml.builder.sql.vo.UserInfo;
import cn.featherfly.hammer.dml.builder.sql.vo.UserInfo2;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryFetch;
import cn.featherfly.hammer.dsl.execute.Deleter;
import cn.featherfly.hammer.dsl.execute.Updater;
import cn.featherfly.hammer.dsl.query.Query;

/**
 * dsl api invoke test
 *
 * @author zhongj
 */
public class DslTest {

    private EntityQueryFetch<User> entityQueryFetch;

    Query query = null;

    Deleter deleter = null;

    Repository data = null;

    boolean ignore = true;

    //    public static void main(String[] args) {
    //        System.out.println(Tuple2.getter0().apply(Tuples.of(1, 2)));
    //        System.out.println(Tuple2.getter1().apply(Tuples.of(1, 2)));
    //        User user = new User();
    //        Tuple2<Integer, String> t2 = Tuples.of(user.getAge(), user.getPwd());
    //        t2 = Tuples.toTuple(User::getAge, User::getPwd).apply(user);
    //        t2 = TupleBuilder.builder().add(1).add("str").build();
    //    }

    //    public void testQueryJoin() {
    //        query.find("user").relate("user_info").on("user_id").fetch().relate("role").on("id", "user_role", "role_id")
    //                .fetch();
    //        query.find("user").relate("user_info").on("user_id").relate("role").on("id", "user_role", "role_id").fetch();
    //
    //        query.find("user").relate("user_info").on("user_id").where();
    //        query.find("user").relate("user_info").on("user_id").fetch().where();
    //        query.find("user").relate("user_info").on("user_id").relate("user_role").on("user_id", "id").relate("role")
    //                .on("id", "user_role", "role_id").fetch();
    //
    //        query.find("user").relate("user_info").on("user_id").fetch("name").fetch();
    //
    //        query.find("user").relate("user_info").on("user_id").fetch("name").relate("user_role").on("user_id", "id")
    //                .relate("role").on("id", "user_role", "role_id").fetch();
    //
    //        query.find("user").relate("user_info").on("user_id").where().eq("id", 1).intValue();
    //    }

    public void entityQueryFetchOne() {
        LocalDateTime localDateTime = null;
        LocalDate localDate = null;
        LocalTime localTime = null;
        Date date = null;
        //      localDateTime = query.find(User.class).fetch(User::getLocalDateTime).limit(1).single();
        //        localDateTime = query.find(User.class).fetch(User::getLocalDateTime).limit(1).unique();
        localDateTime = query.find(User.class).fetch(User::getLocalDateTime).limit(1).value();
        //        localDate = query.find(User.class).fetch(User::getLocalDate).limit(1).single();
        //        localDate = query.find(User.class).fetch(User::getLocalDate).limit(1).unique();
        localDate = query.find(User.class).fetch(User::getLocalDate).limit(1).value();
        //        localTime = query.find(User.class).fetch(User::getLocalTime).limit(1).single();
        //        localTime = query.find(User.class).fetch(User::getLocalTime).limit(1).unique();
        localTime = query.find(User.class).fetch(User::getLocalTime).limit(1).value();
        //        date = query.find(User.class).fetch(User::getDate).limit(1).single();
        //        date = query.find(User.class).fetch(User::getDate).limit(1).unique();
        date = query.find(User.class).fetch(User::getDate).limit(1).value();

        localDateTime = query.find(User.class).fetch(User::getLocalDateTime).where().eq(User::getId, 1).value();
        localDate = query.find(User.class).fetch(User::getLocalDate).where().eq(User::getId, 1).value();
        localTime = query.find(User.class).fetch(User::getLocalTime).where().eq(User::getId, 1).value();
        date = query.find(User.class).fetch(User::getDate).where().eq(User::getId, 1).value();

        localDateTime = query.find(User.class).fetch(User::getLocalDateTime).limit(1).value();
        localDate = query.find(User.class).fetch(User::getLocalDate).limit(1).value();
        localTime = query.find(User.class).fetch(User::getLocalTime).limit(1).value();
        date = query.find(User.class).fetch(User::getDate).limit(1).value();
        PaginationResults<Date> pagination = query.find(User.class).fetch(User::getDate).limit(1).valuePagination();

        List<LocalDateTime> localDateTimeList = query.find(User.class).fetch(User::getLocalDateTime).valueList();
        List<LocalDate> localDateList = query.find(User.class).fetch(User::getLocalDate).valueList();
        List<LocalTime> localTimeList = query.find(User.class).fetch(User::getLocalTime).valueList();
        List<Date> dateList = query.find(User.class).fetch(User::getDate).valueList();
        //        dateList = query.find(User.class).fetch(User::getDate).list();

        localDateTimeList = query.find(User.class).fetch(User::getLocalDateTime).where().eq(User::getId, 1).valueList();
        localDateList = query.find(User.class).fetch(User::getLocalDate).where().eq(User::getId, 1).valueList();
        localTimeList = query.find(User.class).fetch(User::getLocalTime).where().eq(User::getId, 1).valueList();
        dateList = query.find(User.class).fetch(User::getDate).where().eq(User::getId, 1).valueList();
        //        dateList = query.find(User.class).fetch(User::getDate).where().eq(User::getId, 1).list();
    }

    public void entityQueryFetchMoreThanOne() {
        Object[] values = null;
        Tuple2<LocalDateTime, Integer> valuesTuple = null;

        // IMPLSOON value array
        //        values = query.find(User.class).fetch(User::getLocalDateTime).fetch(User::getId).limit(1).values();
        // IMPLSOON value tuple
        //        valuesTuple = query.find(User.class).fetch(User::getLocalDateTime).fetch(User::getId).limit(1).tuple();
    }

    public void testEntityQuery() {
        query.find(User.class).list();
        query.find(User.class).count();
        query.find(User.class).limit(10).list();
        query.find(User.class).limit(1).single();
        //        query.find(User.class).where().lt("age", 18).count();

        query.find(User.class).sort();

        query.find(User.class).where().eq(User::getAge, 5).count();

        query.find(User.class).where().eq(User::getAge, 5).list();

        query.find(User.class).avg(User::getAge).where().eq(User::getAge, 5).single();

        query.find(User.class).fetch(User::getAge).value();
        // YUFEI_TODO 后续区实现使用了分组函数才能使用.value()返回一条数据，相当于分组函数的作用和limit一样（用于筛选就能调用返回一条数据的方法）
        query.find(User.class).avg(User::getAge).value();
        query.find(User.class).sum(User::getAge).value();
        query.find(User.class).min(User::getAge).value();
        query.find(User.class).max(User::getAge).value();
        query.find(User.class).count(User::getAge).value();
        query.find(User.class).fetch(AggregateFunction.AVG, User::getAge).value();
        query.find(User.class).property(AggregateFunction.SUM, User::getAge).value();

        // sort
        query.find(User.class).sort().asc(User::getAge);

        query.find(User.class).avg(User::getAge).where().eq(User::getAge, 5).sort().asc(User::getAge);

        // fetch
        query.find(User.class).property(User::getUserInfo); // IMPLSOON 这个方法调用后，直接关联查询
        query.find(User.class).fetch(User::getUserInfo); // IMPLSOON 这个方法调用后，直接关联查询

        // query.find(User.class).property("name").number(Integer.class);
        // query.find(User.class).property("name").intNumber();
        // query.find(User.class).property("sum(price)").decimal();
        // query.find(User.class).property("count(*)").where().lt("age",
        // 18).longNumber();

        // query.find("user").relate("user_role").on("user_id").relate("role").on("id",
        // "user_role", "role_id").fetch()

        // 错误
        //        query.find(User.class).property("name").where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80)
        //                .limit(11, 10).list();

        query.find(User.class).property(User::getUsername).where().eq(User::getId, 1).and().group().gt(User::getAge, 18)
            .and().lt(User::getAge, 80).limit(11, 10).list();
        query.find(User.class).fetch(User::getUsername).where().eq(User::getId, 1).and().group().gt(User::getAge, 18)
            .and().lt(User::getAge, 80).limit(11, 10).list();

        query.find(User.class).where().eq(User::getId, 1).and().group().gt(User::getAge, 18).and().lt(User::getAge, 80)
            .limit(11, 10).list();

        // in
        User user = new User();
        Collection<Integer> numbers = CollectionUtils.list(1, 2, 3);

        query.find(User.class).where().in(User::getId, 1).list();
        query.find(User.class).where().in(User::getId, 1, IgnoreStrategy.NONE).list();
        query.find(User.class).where().in(User::getId, 1, 2).list();
        query.find(User.class).where().in(User::getId, new int[] { 1, 2 }).list();
        query.find(User.class).where().in((SerializableFunction<User, Integer>) User::getId, new Integer[] { 1, 2 })
            .list();
        query.find(User.class).where().in(User::getId, new Integer[] { 1, 2 }, (Integer[] es) -> false).list();

        query.find(User.class).where().in(User::getAge, 1).list();
        query.find(User.class).where().in(User::getAge, 1, IgnoreStrategy.NONE).list();

        query.find(User.class).where().in(User::getAge, 1, 2).list(); // int...values
        query.find(User.class).where().in(User::getAge, new Integer(1), new Integer(2)).list(); // int...values
        query.find(User.class).where().in(User::getAge, new int[] { 1, 2 }, (int[] es) -> false).list(); // int[] values, Predicate<int[]> ignoreStrategy

        query.find(User.class).where().in((SerializableFunction<User, Integer>) User::getAge, 1, 2).list(); // R...values
        query.find(User.class).where()
            .in((SerializableFunction<User, Integer>) User::getAge, new Integer(1), new Integer(2)).list(); // R...values
        query.find(User.class).where().in((SerializableFunction<User, Integer>) User::getAge, new Integer[] { 1, 2 }) // R[] values
            .list();

        query.find(User.class).where().in(User::getAge, new Integer[] { 1, 2 }, (Integer[] es) -> false).list(); // R[] values, Predicate<R[]> ignoreStrategy

        query.find(User.class).where().in((SerializableFunction<User, Integer>) User::getAge, numbers).list(); // Collection<R>
        query.find(User.class).where()
            .in((SerializableFunction<User, Integer>) User::getAge, CollectionUtils.list(1, 2, 3)).list(); // Collection<R>

        query.find(User.class).where().in(User::getAge, numbers, (Collection<Integer> e) -> false).list(); // Collection<R> values, Predicate<Collection<R>> ignoreStrategy
        query.find(User.class).where().in(User::getAge, CollectionUtils.list(1, 2, 3), (Collection<Integer> e) -> false)
            .list(); // Collection<R> values, Predicate<Collection<R>> ignoreStrategy

        query.find(User.class).where().in(User::getPwd, "a", "b").list();
        query.find(User.class).where().in(User::getPwd, new String[] { "a", "b" }).list();

        query.find(User.class).where().in(user::getId).list();
        query.find(User.class).where().in((SerializableSupplier<Integer>) user::getAge).list();

        //        query.find(User.class).where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80).single();

        //        query.find(User.class).property("name").where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80)
        //                .limit(11, 10).list();

        //        query.find(User.class).property("name").where().property("").eq(1).and().property("age").lt(18).and().group()
        //                .property("score").gt(80).limit(11, 10).list();

        //        query.find(User.class).where().eq(User::getId, 1).and().lt("age", 18).and().group().gt("score", 80).sort()
        //                .asc("name").limit(2).list();

        // 错误调用
        //        query.find(User.class).where().eq(User::getId, 1).and().eq(DslStaticTypeTest::toString, "").single();
        query.find(User.class).where().co(User::getUsername, "").and().configure(c -> c.setIgnoreStrategy(null))
            .co((SerializableStringSupplier) null).single();
        query.find(User.class).where().configure(c -> c.setIgnoreStrategy(null)).co(User::toString, "").and()
            .co((SerializableStringSupplier) null).list();

        // TODO 如果后续加入编译期增强，则在使用注解标注泛型方法（例如find）
        // 目的是使得各种判断和类型匹配在编译期就处理完成，而不是在运行期就在获取
        /*
         1. co(User::getName, "")替换为co("name", "")，或者BeanPropertyValue）
         2. co(User::getName, "")替换为co(BeanPropertyValue)
         3. co(User::getName, "")替换为co(RepositoryFieldValue)
            此参数需要在编译期就搞好所有中间过程，即在jdbc设置时，不去使用SqlTypeMappingManager进行类型判断
         */
        user = query.<@Enhance User>find(User.class).where().co(User::getUsername, "").and()
            .configure(c -> c.setIgnoreStrategy(null)).co((SerializableStringSupplier) null).single();
        user = query.find(User.class).where().co(User::getUsername, "").and().configure(c -> c.setIgnoreStrategy(null))
            .co((SerializableStringSupplier) null).single();

        //        Function<Class<User>, EntityQueryFetchExpression> f = @Enhance query::find;
        //        f.apply(User.class).where().co(User::getUsername, "").and().co((SerializableStringSupplier) null).single();
    }

    public void testEntityQuerySort() {
        query.find(User2.class).sort().asc(User2::getAge);
        query.find(User2.class).sort().asc(User2::getAge).asc(User2::getId);
        query.find(User2.class).sort().asc(User2::getAge, User2::getId);

        query.find(User2.class).sort().desc(User2::getAge);
        query.find(User2.class).sort().desc(User2::getAge).desc(User2::getId);
        query.find(User2.class).sort().desc(User2::getAge, User2::getId);

        //        query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId).sort().asc(es -> es.get0(), User2::getAge);
        query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId).sort()
            .asc((e1, e2) -> e1.property(User2::getAge));
        query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId).sort().asc(User2::getAge);

        //        query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId).sort().asc(es -> es.get1(), UserInfo2::getAge);
        query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId).sort()
            .asc((e1, e2) -> e2.property(UserInfo2::getAge));
        query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId).sort().asc2(UserInfo2::getAge);

        //        query.find(Student2.class).join(User.class).on(Student2::getUserId).join2(User::getUserInfo).sort()
        //        .asc(Student2::getId).asc(qs -> qs.get1(), User::getAge);
        query.find(Student2.class).join(User.class).on(Student2::getUserId).join2(User::getUserInfo).sort()
            .asc(Student2::getId).asc((e1, e2, e3) -> e3.property(UserInfo::getAge));
        query.find(Student2.class).join(User.class).on(Student2::getUserId).join2(User::getUserInfo).sort()
            .asc(Student2::getId).asc2(User::getAge);

        //                query.find(User.class).join(Student2::getUserId).fetch().join2(User::getUserInfo).fetch().list();

        //        query.find(Student2.class).join(User.class).on(Student2::getUserId).join2(User::getUserInfo).sort()
        //                .asc(Student2::getId).asc(qs -> qs.get2(), UserInfo::getAge);
        query.find(Student2.class).join(User.class).on(Student2::getUserId).join2(User::getUserInfo).sort()
            .asc(Student2::getId).asc((e1, e2, e3) -> e3.property(UserInfo::getAge));
        //        query.find(Student2.class).join(User.class).on(Student2::getUserId).fetch().join2(User::getUserInfo).fetch()
        //                .sort().asc(Student2::getId).asc(qs -> qs.get2(), UserInfo::getAge);
        query.find(Student2.class).join(User.class).on(Student2::getUserId).fetch().join2(User::getUserInfo).fetch()
            .sort().asc(Student2::getId).asc((e1, e2, e3) -> e3.property(UserInfo::getAge));
        query.find(Student2.class).join(User.class).on(Student2::getUserId).join2(User::getUserInfo).sort()
            .asc(Student2::getId).asc3(UserInfo::getAge);
        query.find(Student2.class).join(User.class).on(Student2::getUserId).fetch().join2(User::getUserInfo).fetch()
            .sort().asc(Student2::getId).asc3(UserInfo::getAge);

        //        query.find(Student2.class).join(User.class).on(Student2::getUserId).join2(User::getUserInfo).sort()
        //                .asc(qs -> qs.get2(), UserInfo::getAge).asc(Student2::getId);
        query.find(Student2.class).join(User.class).on(Student2::getUserId).join2(User::getUserInfo).sort()
            .asc((e1, e2, e3) -> e3.property(UserInfo::getAge)).asc(Student2::getId);
        query.find(Student2.class).join(User.class).on(Student2::getUserId).join2(User::getUserInfo).sort()
            .asc3(UserInfo::getAge).asc(Student2::getId);

        //        query.find(Student2.class).join(User.class).on(Student2::getUserId).join2(User::getUserInfo).sort()
        //                .asc(qs -> qs.get2(), UserInfo::getAge, UserInfo::getName).asc(Student2::getId);
        query.find(Student2.class).join(User.class).on(Student2::getUserId).join2(User::getUserInfo).sort()
            .asc((e1, e2, e3) -> e3.property(UserInfo::getAge, UserInfo::getName)).asc(Student2::getId);
        query.find(Student2.class).join(User.class).on(Student2::getUserId).join2(User::getUserInfo).sort()
            .asc((e1, e2, e3) -> e3.property(UserInfo::getAge).property(UserInfo::getName)).asc(Student2::getId);

        //        query.find(Student2.class).join(User.class).on(Student2::getUserId).sort().asc(qs -> qs.get1(), User::getId)
        //                .asc((e0, e1) -> e0.property(Student2::getId).property(Student2::getName, Student2::getTeacherId))
        //                .desc((e0, e1) -> e0.property(Student2::getId).property(Student2::getName, Student2::getTeacherId))
        //                .asc2(User::getUsername);
        query.find(Student2.class).join(User.class).on(Student2::getUserId).sort()
            .asc((e1, e2) -> e2.property(User::getId))
            .asc((e0, e1) -> e0.property(Student2::getId).property(Student2::getName, Student2::getTeacherId))
            .desc((e0, e1) -> e0.property(Student2::getId).property(Student2::getName, Student2::getTeacherId))
            .asc2(User::getUsername);

        query.find(Tree.class).join(Tree::getParent).join(Tree::getParent).join(Tree::getParent).join(Tree::getParent)
            .sort().asc((e0, e1, e2, e3, e4) -> e0.property(Tree::getId)).asc5(Tree::getName);

        query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId).fetch() //
            .where() //
            .ba((e0, e1) -> e0.accept(User2::getAge, 18, 22)) //
            .and() //
            .ba((e0, e1) -> e1.property(UserInfo2::getAge).value(18, 22, (min, max) -> false)) //
            .and() //
            .ba((e0, e1) -> e1.property(UserInfo2::getAge).value(18, 22, (min, max) -> false)) //
            .list();

        //        query.find(Tree.class).join(Tree::getParent).join(Tree::getParent).join(Tree::getParent).join(Tree::getParent)
        //                .join(Tree::getParent).sort().asc((e0, e1, e2, e3, e4) -> e0.accept(Tree::getId)).asc5(Tree::getName);
    }

    public void testEntityUpdate() {
        Updater updater = null;

        updater.update(User.class).set(User::getUsername, "yufei").set(User::getPwd, "123456")
            .increase(User::getAge, 10).execute();

        updater.update(User.class).set(User::getUsername, "yufei").set(User::getPwd, "123456")
            .increase(User::getAge, 10).where().property(User::getId).eq(1);

        updater.update(User.class).set(User::getUsername, "yufei").where().eq(User::getId, 18).and().group()
            .lt(User::getAge, 18).or().gt(User::getAge, 60).execute();

        updater.update(User.class).property(User::getAge).increase(10).property(User::getUsername).set("yufei")
            .execute();

        String name = "yufei";

        updater.update(User.class).set(t -> {
            if (name.equals("yufei")) {
                t.set(User::getUsername, name);
            }
        }).execute();
        updater.update(User.class).set(User::getUsername, name, v -> !v.equals("yufei")).execute();

        updater.update(User.class).set(User::getUsername, name).execute();
        updater.update(User.class).set(User::getUsername, name).where().eq(User::getId, 1).execute();

        updater.update(User.class).increase(User::getAge, 1).execute();
        updater.update(User.class).increase(User::getAge, 1, v -> v == null).execute();
        updater.update(User.class).increase(User::getAge, 1).where().eq(User::getId, 1).execute();
        updater.update(User.class).increase(User::getAge, 1, v -> v == null).where().eq(User::getId, 1).execute();
    }

    public void testDelete() {

        deleter.delete(User.class).where().eq(User::getId, 18).execute();
        deleter.delete(User.class).where().property(User::getId).eq(18).execute();
    }
}
