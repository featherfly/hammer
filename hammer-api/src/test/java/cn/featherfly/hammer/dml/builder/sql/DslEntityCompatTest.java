
package cn.featherfly.hammer.dml.builder.sql;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.lang.CollectionUtils;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.operator.SortOperator;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.dml.builder.sql.vo.User;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryFetch;
import cn.featherfly.hammer.dsl.execute.Deleter;
import cn.featherfly.hammer.dsl.query.Query;

/**
 * dsl api invoke test
 *
 * @author zhongj
 */
public class DslEntityCompatTest {

    private EntityQueryFetch<User> entityQueryFetch;

    User user;

    Query query = null;

    Deleter deleter = null;

    Repository data = null;

    boolean ignore = true;

    public void entityCompatibleQueryFetchOne() {
        LocalDateTime localDateTime = null;
        LocalDate localDate = null;
        LocalTime localTime = null;
        Date date = null;
        Number number = null;
        Long count = null;
        Integer i = null;

        query.find(User.class).compat().fetch("localDateTime") //
            .fetch("localDate").list();
        query.find(User.class).compat().fetch("localDateTime") //
            .fetch("localDate").limit(1).single();

        query.find(User.class).compat().count();

        query.find(User.class).compat().count("localDateTime").list(); // FIXME 不应该能够调用list
        query.find(User.class).compat().count("localDateTime").value(); // NOIMPL 后续来实现

        user = query.find(User.class).compat().fetch("localDateTime").limit(1).single();
        user = query.find(User.class).compat().fetch("localDateTime").limit(1).unique();
        localDateTime = (LocalDateTime) query.find(User.class).compat().fetch("localDateTime").limit(1).value();
        // FIXME 使用下面这个替代上面
        // localDateTime = (LocalDateTime) query.find(User.class).compat().fetch("localDateTime").limit(1).spread().single();
        // localDateTime = (LocalDateTime) query.find(User.class).compat().fetch("localDateTime").limit(1).spread().unique();
        user = query.find(User.class).compat().fetch(User::getLocalDateTime).limit(1).single();
        user = query.find(User.class).compat().fetch(User::getLocalDateTime).limit(1).unique();
        localDateTime = query.find(User.class).compat().fetch(User::getLocalDateTime).limit(1).value();
        // FIXME 使用下面这个替代上面
        // localDateTime = query.find(User.class).compat().fetch(User::getLocalDateTime).limit(1).spread().single();
        // localDateTime = query.find(User.class).compat().fetch(User::getLocalDateTime).limit(1).spread().unique();

        localDateTime = (LocalDateTime) query.find(User.class).compat().fetch("localDateTime").limit(1).value();
        // IMPLSOON 后续所有的的查询都在最终获取方法(list, single, unique, pagination)前加入mapper方法
        // 在fetch一行数据一个属性（字段）时，如果能拿到具体类型，则使用只有value方法的exectutor，如果不能拿到类型，则加入intValue,longValue那一系列方法的executor，如果再mapper了，则返回value executor
        // localDateTime = (LocalDateTime) query.find(User.class).compat().fetch("localDateTime").limit(1).mapper(LocalDateTime.class).value();
        localDateTime = query.find(User.class).compat().fetch("localDateTime", LocalDateTime.class).limit(1).value();
        localDateTime = query.find(User.class).compat().fetch(User::getLocalDateTime).limit(1).value();
        localDate = (LocalDate) query.find(User.class).compat().fetch("localDate").limit(1).value();
        localDate = query.find(User.class).compat().fetch("localDate", LocalDate.class).limit(1).value();
        localDate = query.find(User.class).compat().fetch(User::getLocalDate).limit(1).value();
        localTime = (LocalTime) query.find(User.class).compat().fetch("localTime").limit(1).value();
        localTime = query.find(User.class).compat().fetch("localTime", LocalTime.class).limit(1).value();
        localTime = query.find(User.class).compat().fetch(User::getLocalTime).limit(1).value();
        date = (Date) query.find(User.class).compat().fetch("date").limit(1).value();
        date = query.find(User.class).compat().fetch("date", Date.class).limit(1).value();
        date = query.find(User.class).compat().fetch(User::getDate).limit(1).value();

        query.find(User.class).compat().where().eq("id", 1);

        localDateTime = (LocalDateTime) query.find(User.class).compat().fetch("localDateTime").where()
            .eq(User::getId, 1).value();
        localDateTime = query.find(User.class).compat().fetch("localDateTime", LocalDateTime.class).where()
            .eq(User::getId, 1).value();
        localDateTime = query.find(User.class).compat().fetch(User::getLocalDateTime).where().eq(User::getId, 1)
            .value();
        localDate = (LocalDate) query.find(User.class).compat().fetch("localDate").where().eq("id", 1).value();
        localDate = query.find(User.class).compat().fetch("localDate", LocalDate.class).where().eq("id", 1).value();
        localDate = query.find(User.class).compat().fetch(User::getLocalDate).where().eq(User::getId, 1).value();
        localTime = (LocalTime) query.find(User.class).compat().fetch("localTime").where().eq("id", 1).value();
        localTime = query.find(User.class).compat().fetch("localTime", LocalTime.class).where().eq("id", 1).value();
        localTime = query.find(User.class).compat().fetch(User::getLocalTime).where().eq(User::getId, 1).value();
        date = (Date) query.find(User.class).compat().fetch("date").where().eq("id", 1).value();
        date = query.find(User.class).compat().fetch("date", Date.class).where().eq("id", 1).value();
        date = query.find(User.class).compat().fetch(User::getDate).where().eq(User::getId, 1).value();

        PaginationResults<
            Date> pagination = query.find(User.class).compat().fetch(User::getDate).limit(1).valuePagination();

        List<LocalDateTime> localDateTimeList = query.find(User.class).compat().fetch(User::getLocalDateTime)
            .valueList();
        List<LocalDate> localDateList = query.find(User.class).compat().fetch(User::getLocalDate).valueList();
        List<LocalTime> localTimeList = query.find(User.class).compat().fetch(User::getLocalTime).valueList();
        List<Date> dateList = query.find(User.class).compat().fetch(User::getDate).valueList();
        //        dateList = query.find(User.class).fetch(User::getDate).list();

        localDateTimeList = query.find(User.class).compat().fetch(User::getLocalDateTime).where().eq(User::getId, 1)
            .valueList();
        localDateList = query.find(User.class).compat().fetch(User::getLocalDate).where().eq(User::getId, 1)
            .valueList();
        localTimeList = query.find(User.class).compat().fetch(User::getLocalTime).where().eq(User::getId, 1)
            .valueList();
        dateList = query.find(User.class).compat().fetch(User::getDate).where().eq(User::getId, 1).valueList();
        //        dateList = query.find(User.class).fetch(User::getDate).where().eq(User::getId, 1).list();

        query.find(User.class).compat().fetch("age").list();
        query.find(User.class).compat().fetch(User::getAge).value();
        // YUFEI_TODO 后续区实现使用了分组函数才能使用.value()返回一条数据，相当于分组函数的作用和limit一样（用于筛选就能调用返回一条数据的方法）
        number = query.find(User.class).compat().avg("age").single();
        number = query.find(User.class).compat().avg("age").unique();
        number = query.find(User.class).compat().avg("age").value();
        i = query.find(User.class).compat().avg(User::getAge).single();
        i = query.find(User.class).compat().avg(User::getAge).unique();
        i = query.find(User.class).compat().avg(User::getAge).value();
        number = query.find(User.class).compat().min("age").single();
        number = query.find(User.class).compat().min("age").unique();
        number = query.find(User.class).compat().min("age").value();
        i = query.find(User.class).compat().min(User::getAge).single();
        i = query.find(User.class).compat().min(User::getAge).unique();
        i = query.find(User.class).compat().min(User::getAge).value();

        // IMPLSOON 后续加入expand()方法用于在fetch后进行值映射
        //        query.find(User.class).compat().min(User::getAge).spread().single();
        //        query.find(User.class).compat().min(User::getAge).expand().unique();

        query.find(User.class).compat().max("age").value();
        query.find(User.class).compat().max(User::getAge).value();
        query.find(User.class).compat().count("age").value();
        query.find(User.class).compat().count(User::getAge).value();
        query.find(User.class).compat().fetch(AggregateFunction.AVG, "age").value();
        query.find(User.class).compat().fetch(AggregateFunction.AVG, User::getAge).value();
        query.find(User.class).compat().fetch(AggregateFunction.SUM, "age").value();
        query.find(User.class).compat().fetch(AggregateFunction.SUM, User::getAge).value();

        //
        query.find(User.class).compat().avg("age").where().eq("age", 5).single();
        query.find(User.class).compat().avg(User::getAge).where().eq(User::getAge, 5).single();

        // sort
        query.find(User.class).compat().avg("age").where().eq("age", 5).sort().asc("age");
        query.find(User.class).compat().avg(User::getAge).where().eq(User::getAge, 5).sort().asc(User::getAge);

        // IMPLSOON 加入fetch映射
        // int year = query.find(User.class).fetch(User::getLocalDateTime).getYear().where().eq(User::getId, 1).value();
        // Tuple3<Integer, String, String> user = query.find(User.class)
        //   .fetch(User::getId, User::getName).fetch(f -> f.property(User::getLocalDateTime).format("%Y-%M-%d"))
        //   .where().eq(User::getId, 1).singleTuple();
        // Tuple3<Integer, String, LocalDateTime> user = query.find(User.class).fetch(User::getId, User::getName, User::getLocalDateTime)
        //   .where().eq(User::getId, 1).singleTuple();
        // query.find("user").fetch("c1", "c2", "c3", "c4").limit(1)
        //   .singleTuple(int.class, int.class, long.class, String.class);
    }

    public void entityCompatibleQueryFetchMoreThanOne() {
        //        Object[] values = null;
        //        Tuple2<LocalDateTime, Integer> valuesTuple = null;
        //
        //        // IMPLSOON value array
        //        //        values = query.find(User.class).fetch(User::getLocalDateTime).fetch(User::getId).limit(1).values();
        //        // IMPLSOON value tuple
        //        //        valuesTuple = query.find(User.class).fetch(User::getLocalDateTime).fetch(User::getId).limit(1).tuple();
    }

    @SuppressWarnings("unchecked")
    public void entityCompatibleQuery() {
        query.find(User.class).compat().list();
        query.find(User.class).compat().count();
        query.find(User.class).compat().limit(10).list();
        query.find(User.class).compat().limit(1).single();
        //        query.find(User.class).where().lt("age", 18).count();

        query.find(User.class).compat().where().ba(User::getAge, 5, 10).count();
        query.find(User.class).compat().where().ba("age", 5, 10).count();
        query.find(User.class).compat().where().ba(User::getAge, 5, 10).list();
        query.find(User.class).compat().where().ba("age", 5, 10).list();

        query.find(User.class).compat().where().co(User::getUsername, "y").count();
        query.find(User.class).compat().where().co("username", "y").count();
        query.find(User.class).compat().where().co(User::getUsername, "y").list();
        query.find(User.class).compat().where().co("username", "y").list();

        query.find(User.class).compat().where().eq(User::getAge, 5).count();
        query.find(User.class).compat().where().eq("age", 5).count();
        query.find(User.class).compat().where().eq(User::getAge, 5).list();
        query.find(User.class).compat().where().eq("age", 5).list();

        query.find(User.class).compat().where().ew(User::getUsername, "y").count();
        query.find(User.class).compat().where().ew("username", "y").count();
        query.find(User.class).compat().where().ew(User::getUsername, "y").list();
        query.find(User.class).compat().where().ew("username", "y").list();

        query.find(User.class).compat().where().ge(User::getAge, 5).count();
        query.find(User.class).compat().where().ge("age", 5).count();
        query.find(User.class).compat().where().ge(User::getAge, 5).list();
        query.find(User.class).compat().where().ge("age", 5).list();

        query.find(User.class).compat().where().gt(User::getAge, 5).count();
        query.find(User.class).compat().where().gt("age", 5).count();
        query.find(User.class).compat().where().gt(User::getAge, 5).list();
        query.find(User.class).compat().where().gt("age", 5).list();

        query.find(User.class).compat().where().in(User::getAge, 5).count();
        query.find(User.class).compat().where().in("age", 5).count();
        query.find(User.class).compat().where().in(User::getAge, 5).list();
        query.find(User.class).compat().where().in("age", 5).list();

        query.find(User.class).compat().where().inn(User::getAge).count();
        query.find(User.class).compat().where().inn("age").count();
        query.find(User.class).compat().where().inn(User::getAge).list();
        query.find(User.class).compat().where().inn("age").list();

        query.find(User.class).compat().where().le(User::getAge, 5).count();
        query.find(User.class).compat().where().le("age", 5).count();
        query.find(User.class).compat().where().le(User::getAge, 5).list();
        query.find(User.class).compat().where().le("age", 5).list();

        query.find(User.class).compat().where().lk(User::getUsername, "y").count();
        query.find(User.class).compat().where().lk("username", "y").count();
        query.find(User.class).compat().where().lk(User::getUsername, "y").list();
        query.find(User.class).compat().where().lk("username", "y").list();

        query.find(User.class).compat().where().lt(User::getAge, 5).count();
        query.find(User.class).compat().where().lt("age", 5).count();
        query.find(User.class).compat().where().lt(User::getAge, 5).list();
        query.find(User.class).compat().where().lt("age", 5).list();

        query.find(User.class).compat().where().nba(User::getAge, 5, 10).count();
        query.find(User.class).compat().where().nba("age", 5, 10).count();
        query.find(User.class).compat().where().nba(User::getAge, 5, 10).list();
        query.find(User.class).compat().where().nba("age", 5, 10).list();

        query.find(User.class).compat().where().nco(User::getUsername, "y").count();
        query.find(User.class).compat().where().nco("username", "y").count();
        query.find(User.class).compat().where().nco(User::getUsername, "y").list();
        query.find(User.class).compat().where().nco("username", "y").list();

        query.find(User.class).compat().where().ne(User::getAge, 5).count();
        query.find(User.class).compat().where().ne("age", 5).count();
        query.find(User.class).compat().where().ne(User::getAge, 5).list();
        query.find(User.class).compat().where().ne("age", 5).list();

        query.find(User.class).compat().where().newv(User::getUsername, "y").count();
        query.find(User.class).compat().where().newv("username", "y").count();
        query.find(User.class).compat().where().newv(User::getUsername, "y").list();
        query.find(User.class).compat().where().newv("username", "y").list();

        query.find(User.class).compat().where().ni(User::getAge, 5).count();
        query.find(User.class).compat().where().ni("age", 5).count();
        query.find(User.class).compat().where().ni(User::getAge, 5).list();
        query.find(User.class).compat().where().ni("age", 5).list();

        query.find(User.class).compat().where().nl(User::getUsername, "y").count();
        query.find(User.class).compat().where().nl("username", "y").count();
        query.find(User.class).compat().where().nl(User::getUsername, "y").list();
        query.find(User.class).compat().where().nl("username", "y").list();

        query.find(User.class).compat().where().nsw(User::getUsername, "y").count();
        query.find(User.class).compat().where().nsw("username", "y").count();
        query.find(User.class).compat().where().nsw(User::getUsername, "y").list();
        query.find(User.class).compat().where().nsw("username", "y").list();

        query.find(User.class).compat().where().sw(User::getUsername, "y").count();
        query.find(User.class).compat().where().sw("username", "y").count();
        query.find(User.class).compat().where().sw(User::getUsername, "y").list();
        query.find(User.class).compat().where().sw("username", "y").list();

        // query.find(User.class).compat().property(AggregateFunction.SUM, User::getAge).value(); // 删掉property方法

        // sort
        query.find(User.class).compat().sort();
        query.find(User.class).compat().where().co("username", "z").sort().asc("age");
        query.find(User.class).compat().sort().asc("age");
        query.find(User.class).compat().sort().asc(User::getAge);
        query.find(User.class).compat().where().co("username", "z").sort().desc("age");
        query.find(User.class).compat().sort().desc("age");
        query.find(User.class).compat().sort().desc(User::getAge);
        query.find(User.class).compat().where().co("username", "z").sort().order(SortOperator.ASC, "age");
        query.find(User.class).compat().sort().order(SortOperator.ASC, "age");
        query.find(User.class).compat().sort().order(SortOperator.ASC, User::getAge);

        query.find(User.class).compat().where().co("username", "z").sort().asc("age", "username");
        query.find(User.class).compat().sort().asc("age", "username");
        query.find(User.class).compat().sort().asc(User::getAge, User::getUsername);
        query.find(User.class).compat().where().co("username", "z").sort().desc("age", "username");
        query.find(User.class).compat().sort().desc("age", "username");
        query.find(User.class).compat().sort().desc(User::getAge, User::getUsername);
        query.find(User.class).compat().where().co("username", "z").sort().order(SortOperator.ASC, "age", "username");
        query.find(User.class).compat().sort().order(SortOperator.ASC, "age", "username");
        query.find(User.class).compat().sort().order(SortOperator.ASC, User::getAge, User::getUsername);

        query.find(User.class).compat().where().co("username", "z").sort().asc("age").desc("username");
        query.find(User.class).compat().sort().asc("age").desc("username");
        query.find(User.class).compat().where().co("username", "z").sort().asc("age", "id").desc("username");
        query.find(User.class).compat().sort().asc("age", "id").desc("username");
        query.find(User.class).compat().where().co("username", "z").sort().asc(User::getAge).desc("username");
        query.find(User.class).compat().sort().asc(User::getAge).desc("username");

        // fetch
        query.find(User.class).compat().fetch(User::getUserInfo);
        query.find(User.class).compat().fetch("userInfo"); // IMPLSOON 这个方法调用后，直接关联查询

        //        query.find(User.class).compat().property(User::getUsername).where().eq(User::getId, 1).and().group().gt(User::getAge, 18)
        //            .and().lt(User::getAge, 80).limit(11, 10).list(); // 删掉property方法
        query.find(User.class).compat().fetch(User::getUsername).where().eq(User::getId, 1).and().group()
            .gt(User::getAge, 18).and().lt(User::getAge, 80).limit(11, 10).list();

        query.find(User.class).compat().where().eq(User::getId, 1).and().group().gt(User::getAge, 18).and()
            .lt(User::getAge, 80).limit(11, 10).list();

        // in
        User user = new User();
        Collection<Integer> numbers = CollectionUtils.list(1, 2, 3);

        query.find(User.class).compat().where().in(User::getId, 1).list();
        query.find(User.class).compat().where().in(User::getId, 1, IgnoreStrategy.NONE).list();
        query.find(User.class).compat().where().in(User::getId, 1, 2).list();
        query.find(User.class).compat().where().in(User::getId, new int[] { 1, 2 }).list();
        query.find(User.class).compat().where()
            .in((SerializableFunction<User, Integer>) User::getId, new Integer[] { 1, 2 }).list();
        query.find(User.class).compat().where().in(User::getId, new Integer[] { 1, 2 }, (Integer[] es) -> false).list();

        query.find(User.class).compat().where().in(User::getAge, 1).list();
        query.find(User.class).compat().where().in(User::getAge, 1, IgnoreStrategy.NONE).list();

        query.find(User.class).compat().where().in(User::getAge, 1, 2).list(); // int...values
        query.find(User.class).compat().where().in(User::getAge, new Integer(1), new Integer(2)).list(); // int...values
        query.find(User.class).compat().where().in(User::getAge, new int[] { 1, 2 }, (int[] es) -> false).list(); // int[] values, Predicate<int[]> ignoreStrategy

        query.find(User.class).compat().where().in((SerializableFunction<User, Integer>) User::getAge, 1, 2).list(); // R...values
        query.find(User.class).compat().where()
            .in((SerializableFunction<User, Integer>) User::getAge, new Integer(1), new Integer(2)).list(); // R...values
        query.find(User.class).compat().where()
            .in((SerializableFunction<User, Integer>) User::getAge, new Integer[] { 1, 2 }) // R[] values
            .list();

        query.find(User.class).compat().where().in(User::getAge, new Integer[] { 1, 2 }, (Integer[] es) -> false)
            .list(); // R[] values, Predicate<R[]> ignoreStrategy

        query.find(User.class).compat().where().in((SerializableFunction<User, Integer>) User::getAge, numbers).list(); // Collection<R>
        query.find(User.class).compat().where()
            .in((SerializableFunction<User, Integer>) User::getAge, CollectionUtils.list(1, 2, 3)).list(); // Collection<R>

        query.find(User.class).compat().where().in(User::getAge, numbers, (Collection<Integer> e) -> false).list(); // Collection<R> values, Predicate<Collection<R>> ignoreStrategy
        query.find(User.class).compat().where()
            .in(User::getAge, CollectionUtils.list(1, 2, 3), (Collection<Integer> e) -> false).list(); // Collection<R> values, Predicate<Collection<R>> ignoreStrategy

        query.find(User.class).compat().where().in(User::getPwd, "a", "b").list();
        query.find(User.class).compat().where().in(User::getPwd, new String[] { "a", "b" }).list();

        query.find(User.class).compat().where().in(user::getId).list();
        query.find(User.class).compat().where().in((SerializableSupplier<Integer>) user::getAge).list();

        //        query.find(User.class).compat().where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80).single();

        //        query.find(User.class).compat().property("name").where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80)
        //                .limit(11, 10).list();

        // property
        query.find(User.class).compat().where().property(User::getId).eq(1) //
            .and().property(User::getAge).lt(18) //
            .and().group().property(User::getAge).gt(80) //
            .limit(11, 10) //
            .list();
        query.find(User.class).compat().where().property("id").eq(1) //
            .and().group() //
            .property("age").lt(18).or().property("age").gt(80) //
            .limit(11, 10) //
            .list();
    }
}
