
package cn.featherfly.hammer.dml.builder.sql;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.common.repository.SimpleRepository;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.common.tuple.Tuple2;
import cn.featherfly.common.tuple.Tuple3;
import cn.featherfly.common.tuple.Tuple4;
import cn.featherfly.common.tuple.Tuple5;
import cn.featherfly.common.tuple.Tuple6;
import cn.featherfly.hammer.dml.builder.sql.vo.User;
import cn.featherfly.hammer.dsl.query.Query;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryFetch;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryValue;
import cn.featherfly.hammer.expression.query.FetchField;

/**
 * dsl api invoke test
 *
 * @author zhongj
 */
public class DslRepositoryQueryTest {

    Query query = null;

    Repository data = null;

    boolean ignore = true;

    Map<String, Serializable> map = null;
    List<Map<String, Serializable>> listMap = null;
    Iterable<Map<String, Serializable>> iterMap = null;
    PaginationResults<Map<String, Serializable>> pageMap = null;

    User user = null;
    List<User> listUser = null;
    Iterable<User> iterUser = null;
    PaginationResults<User> pageUser = null;

    Tuple2<User, User> user2 = null;
    List<Tuple2<User, User>> listUser2 = null;
    Iterable<Tuple2<User, User>> iterUser2 = null;
    PaginationResults<Tuple2<User, User>> pageUser2 = null;

    Tuple3<User, User, User> user3 = null;
    List<Tuple3<User, User, User>> listUser3 = null;
    Iterable<Tuple3<User, User, User>> iterUser3 = null;
    PaginationResults<Tuple3<User, User, User>> pageUser3 = null;

    Tuple4<User, User, User, User> user4 = null;
    List<Tuple4<User, User, User, User>> listUser4 = null;
    Iterable<Tuple4<User, User, User, User>> iterUser4 = null;
    PaginationResults<Tuple4<User, User, User, User>> pageUser4 = null;

    Tuple5<User, User, User, User, User> user5 = null;
    List<Tuple5<User, User, User, User, User>> listUser5 = null;
    Iterable<Tuple5<User, User, User, User, User>> iterUser5 = null;
    PaginationResults<Tuple5<User, User, User, User, User>> pageUser5 = null;

    Tuple6<User, User, User, User, User, User> user6 = null;
    List<Tuple6<User, User, User, User, User, User>> listUser6 = null;
    Iterable<Tuple6<User, User, User, User, User, User>> iterUser6 = null;
    PaginationResults<Tuple6<User, User, User, User, User, User>> pageUser6 = null;

    // ----------------------------------------------------------------------------------------------------------------

    List<String> list;
    List<Integer> intList;
    List<String> strList;
    int i;
    String str;
    Integer integer;

    public void query() {
        iterMap = query.find(data).each();
        listMap = query.find(data).list();
        iterMap = query.find(data).limit(21, 10).each();
        listMap = query.find(data).limit(21, 10).list();
        pageMap = query.find(data).limit(21, 10).pagination();
        map = query.find(data).limit(1).single();

        //        query.find(data).list(User.class);
        //        query.find(data).limit(10).list(User.class);
        //        query.find(data).limit(1).single(User.class);
        iterUser = query.find(data).mapper(User.class).each();
        listUser = query.find(data).mapper(User.class).list();
        iterUser = query.find(data).limit(21, 10).mapper(User.class).each();
        listUser = query.find(data).limit(21, 10).mapper(User.class).list();
        pageUser = query.find(data).limit(21, 10).mapper(User.class).pagination();
        user = query.find(data).limit(1).mapper(User.class).single();

        iterMap = query.find(data).where().eq("id", 1).each();
        listMap = query.find(data).where().eq("id", 1).list();
        iterMap = query.find(data).where().eq("id", 1).limit(21, 10).each();
        listMap = query.find(data).where().eq("id", 1).limit(21, 10).list();
        pageMap = query.find(data).where().eq("id", 1).limit(21, 10).pagination();
        map = query.find(data).where().eq("id", 1).limit(1).single();

        iterUser = query.find(data).where().eq("id", 1).mapper(User.class).each();
        listUser = query.find(data).where().eq("id", 1).mapper(User.class).list();
        iterUser = query.find(data).where().eq("id", 1).limit(21, 10).mapper(User.class).each();
        listUser = query.find(data).where().eq("id", 1).limit(21, 10).mapper(User.class).list();
        pageUser = query.find(data).where().eq("id", 1).limit(21, 10).mapper(User.class).pagination();
        user = query.find(data).where().eq("id", 1).limit(1).mapper(User.class).single();
    }

    public void queryFetch() {
        list = query.find(data).fetch("name").list();
        //        list = query.find(data).fetch("name").list(String.class);
        list = query.find(data).fetch("name").mapper(String.class).list();

        // FIXME 没有进行条件帅选就能进行唯一值返回是错误的
        // 因为统计函数可能返回唯一值，所以这里还需要再考虑如何实现，先这样，由用户自行决定返回结果是单值还是多值
        query.find(data).fetch("name").number(Integer.class);
        query.find(data).fetch("name").intNumber();
        query.find(data).fetch("name").intValue();

        //
        query.find(data).fetch("name").limit(1).number(Integer.class);
        query.find(data).fetch("name").limit(1).intNumber();
        query.find(data).fetch("name").limit(1).intValue();
        str = query.find(data).fetch("name").limit(1).value();
        query.find(data).fetch("name").limit(1).single(Integer.class);
        query.find(data).fetch("name").where().eq("id", 1).single(Integer.class);
        query.find(data).fetch("name").where().eq("id", 1).number(Integer.class);
    }

    public void query2() {
        // FIXME 没有进行条件帅选就能进行唯一值返回是错误的
        // 因为统计函数可能返回唯一值，所以这里还需要再考虑如何实现，先这样，由用户自行决定返回结果是单值还是多值
        query.find(data).fetch("name").number(Integer.class);
        query.find(data).fetch("name").intNumber();
        query.find(data).fetch("name").intValue();

        //
        query.find(data).fetch("name").limit(1).number(Integer.class);
        query.find(data).fetch("name").limit(1).intNumber();
        query.find(data).fetch("name").limit(1).intValue();
        str = query.find(data).fetch("name").limit(1).value();
        query.find(data).fetch("name").limit(1).single(Integer.class);
        query.find(data).fetch("name").where().eq("id", 1).single(Integer.class);
        query.find(data).fetch("name").where().eq("id", 1).number(Integer.class);
        //        query.find(data).where().eq("id", 1).number(Integer.class);

        query.find(data).max("age").number(Integer.class);
        // FIXME 使用了统计函数，则没有进行分组，就只有一行数据
        query.find(data).max("age").mapper(Integer.class).list();

        query.find(data).count();
        //        query.find(data).field("name").number(Integer.class);
        query.find(data).fetch("name").number(Integer.class);
        //        query.find(data).field("name").intNumber();
        query.find(data).fetch("name").intNumber();
        //        query.find(data).field("sum(price)").decimal();
        query.find(data).fetch("sum(price)").decimal();
        //        query.find(data).field(AggregateFunction.SUM, "price").decimal();
        query.find(data).fetch(AggregateFunction.SUM, "price").decimal();
        query.find(data).sum("price").decimal();
        //        query.find(data).field(AggregateFunction.COUNT, "id").intNumber();
        query.find(data).fetch(AggregateFunction.COUNT, "id").intNumber();
        query.find(data).count("id").intNumber();
        //        query.find(data).field(AggregateFunction.COUNT, "id").longNumber();
        query.find(data).fetch(AggregateFunction.COUNT, "id").longNumber();
        query.find(data).count("id").longNumber();

        query.find(data).sum("id").longNumber();

        query.find(data).fetch("count(*)").where().lt("age", 18).longNumber();
        query.find(data).fetch(AggregateFunction.COUNT, "id").where().lt("age", 18).longNumber();

        query.find(data).where().lt("age", 18).count();

        query.find(data).where().eq("", 1).and().lt("age", 18).and().group(t -> t.gt("score", 80)).limit(11, 10)
            .mapper(User.class).list();
        query.find(data).fetch("name").where().eq("", 1).and().lt("age", 18).and().group(t -> t.gt("score", 80))
            .limit(11, 10).mapper(User.class).list();

        query.find(data).where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80).limit(11, 10)
            .mapper(User.class).list();
        query.find(data).fetch("name").where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80).limit(11, 10)
            .mapper(User.class).list();

        query.find(data).where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80).mapper(User.class)
            .single();
        query.find(data).fetch("name").where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80)
            .mapper(User.class).single();

        query.find(data).where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80).limit(11, 10)
            .mapper(User.class).list();
        query.find(data).fetch("name").where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80).limit(11, 10)
            .mapper(User.class).list();

        query.find(data).where().field("").eq(1).and().field("age").lt(18).and().group().field("score").gt(80)
            .limit(11, 10).mapper(User.class).list();
        query.find(data).fetch("name").where().field("").eq(1).and().field("age").lt(18).and().group().field("score")
            .gt(80).limit(11, 10).mapper(User.class).list();

        query.find(data).where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80).sort().asc("name")
            .mapper(User.class).list();
        query.find(data).fetch("name").where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80).sort()
            .asc("name").mapper(User.class).list();

        query.find(data).join("").on("").where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80) //
            .sort().asc2("name") //
            .mapper(User.class).list();
        query.find(data).join("").on("").join("").on("") //
            .where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80) //
            .sort().asc3("name") //
            .mapper(User.class).list();
        query.find(data).join("").on("").join("").on("").join("").on("") //
            .where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80)//
            .sort().asc4("name") //
            .mapper(User.class).list();
        query.find(data).join("").on("").join("").on("").join("").on("").join("").on("") //
            .where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80) //
            .sort().asc5("name") //
            .mapper(User.class).list();
        query.find(data).join("").on("").join("").on("").join("").on("").join("").on("").join("").on("")//
            .where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80)//
            .sort().asc6("name") //
            .mapper(User.class).list();

        User user = null;
        user = query.find(data).where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80).sort().asc("name")
            .limit(1).mapper(User.class).single();
        user = query.find(data).where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80).sort().asc("name")
            .limit(1).<@Enhance User>mapper(User.class).single();
    }

    public void queryFetch2() {
        Integer integer;

        RepositoryQueryFetch queryFetch = null;
        RepositoryQueryValue queryValue = null;
        queryFetch.mapper(User.class).list();
        //        queryFetch.limit(10).list(User.class);
        queryFetch.limit(10).mapper(User.class).list();
        queryFetch.limit(1).mapper(User.class).single();
        queryFetch.sort();

        // 因为统计函数可能返回唯一值，所以这里还需要再考虑如何实现，先这样，由用户自行决定返回结果是单值还是多值
        queryFetch.fetch("name").number(Integer.class);
        queryFetch.fetch("name").intValue();
        queryFetch.fetch("name").list();
        integer = queryFetch.count("id").value(); // 统计函数可能返回唯一值
        //        query.fetch("name").limit(1).number(Integer.class);
        queryFetch.fetch("name").limit(1).intValue();
        queryFetch.fetch("name").limit(1).value(Integer.class);
        queryFetch.fetch("name").limit(1).single(Integer.class);
        queryFetch.fetch("name").where().eq("id", 1).single(Integer.class);
        queryFetch.fetch("name").where().eq("id", 1).number(Integer.class);
        //        queryFetch.where().eq("id", 1).number(Integer.class); // 这个是错误的，因为是返回多个数据

        queryFetch.max("age").number(Integer.class);
        // FIXME 使用了统计函数，则没有进行分组，就只有一行数据
        queryFetch.max("age").mapper(Integer.class).list();

        integer = queryFetch.max("age").value();
        str = queryFetch.fetch("name").limit(1).value();

        intList = queryFetch.max("age").list();
        strList = queryFetch.fetch("name").limit(1).list();

        queryFetch.fetch(
            (f, b) -> f.fetch(b.name("a"), b.distinct().name("b"), b.avg().distinct().name("a"), b.sum(true, "b"))
                .fetch(b.sum().distinct().name("c")));

        queryFetch.count();
        //        queryFetch.field("name").number(Integer.class);
        queryFetch.fetch("name").number(Integer.class);
        //        queryFetch.field("name").intNumber();
        queryFetch.fetch("name").intNumber();
        //        queryFetch.field("sum(price)").decimal();
        queryFetch.fetch("sum(price)").decimal();
        //        queryFetch.field(AggregateFunction.SUM, "price").decimal();
        queryFetch.fetch(AggregateFunction.SUM, "price").decimal();
        queryFetch.sum("price").decimal();
        //        queryFetch.field(AggregateFunction.COUNT, "id").intNumber();
        queryFetch.fetch(AggregateFunction.COUNT, "id").intNumber();
        queryFetch.count("id").intNumber();
        //        queryFetch.field(AggregateFunction.COUNT, "id").longNumber();
        queryFetch.fetch(AggregateFunction.COUNT, "id").longNumber();
        queryFetch.count("id").intNumber();

        queryFetch.sum("id").longNumber();

        queryFetch.fetch("count(*)").where().lt("age", 18).longNumber();
        queryFetch.fetch(AggregateFunction.COUNT, "id").where().lt("age", 18).longNumber();

        queryFetch.fetch("id").fetch("name").fetch("age").distinct("username");

        queryFetch.where().lt("age", 18).count();

        // FIXME 这里不应该可以直接调用endGroup,endGroup方法应该是group()方法调用后才能调用
        queryFetch.where().eq("", 1).endGroup();

        queryFetch.where().eq("", 1).and().group().eq("", 1).endGroup();
        // FIXME  这里的endGroup是错误的
        queryFetch.where().eq("", 1).and().group().eq("", 1).endGroup().endGroup();

        queryFetch.where().eq("", 1).and().group().group().eq("", 1).endGroup().endGroup();
        // FIXME  这里的endGroup是错误的
        queryFetch.where().eq("", 1).and().group().group().eq("", 1).endGroup().endGroup().endGroup();

        queryFetch.fetch("name").where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80).endGroup()
            .limit(11, 10).mapper(User.class).list();

        queryFetch.fetch("name").where().eq("", 1).and().lt("age", 18).and().group(t -> t.gt("score", 80)).limit(11, 10)
            .mapper(User.class).list();

        queryFetch.fetch("name").where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80).limit(11, 10)
            .mapper(User.class).list();

        queryFetch.where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80).mapper(User.class).single();

        queryFetch.fetch("name").where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80).limit(11, 10)
            .mapper(User.class).list();

        queryFetch.fetch("name").where().field("");

        query.find("user") //
            .fetch((Consumer<FetchField>) f -> f.name("password")) //
            .list();
        query.find("user") //
            .fetch(f -> {
                f.name("password");
                f.name("age");
                f.name("password").as("pwd");
                f.distinct().name("username").as("uname");
                f.avg().distinct().name("age").as("a");
                f.avg().name("age").as("a");
                f.avg("age").distinct();
            }) //
            .list();

        query.find("user") //
            .fetch((q, f) -> q.fetch( //
                f.name("username") //
                , f.name("password") //
                , f.name("age") //
                , f.name("password").as("pwd") //
                , f.distinct().name("username").as("uname") //
                , f.avg().name("age").as("a") //
                , f.avg().distinct().name("age").as("a") //
                , f.avg("age").as("a") //
                , f.avg("age").distinct().as("a") //
                , f.avg(true, "age").as("a")) //
            ) //
            .sort().asc("age") //
            .list();
        query.find("user") //
            .fetch((q, f) -> q.fetch(f.name("username")) //
                .fetch(f.name("password")) //
                .fetch(f.name("age")) //
                .fetch(f.name("password").as("pwd")) //
                .fetch(f.distinct().name("username").as("uname")) //
                .fetch(f.avg().distinct().name("age").as("a")) //
                .fetch(f.avg().name("age").as("a")) //
                .fetch(f.avg("age").distinct()) //
            ) //
            .sort().asc("age") //
            .list();

        queryFetch.fetch("name").where().field("").eq(1).and().field("age").lt(18).and().group().field("score").gt(80)
            .limit(11, 10).mapper(User.class).list();
        queryFetch.fetch("name").where().field("").eq(1).and().field("age").lt(18).and().group().field("score").gt(80)
            .limit(11, 10).mapper(User.class).list();

        queryFetch.where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80).sort().asc("name")
            .mapper(User.class).list();

        User user = null;
        user = queryFetch.where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80).sort().asc("name")
            .limit(1).mapper(User.class).single();
        user = queryFetch.where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80).sort().asc("name")
            .limit(1).<@Enhance User>mapper(User.class).single();
    }

    public void queryJoin1() {
        user = query.find("user")                           //
            .join("user_info").on("user_id")                //
            .mapper(User.class)                             //
            .single();
        user = query.find("user")                           //
            .join("user_info").on("user_id")                //
            .mapper(User.class)                             //
            .unique();
        listUser = query.find("user")                       //
            .join("user_info").on("user_id")                //
            .mapper(User.class)                             //
            .list();

        user = query.find("user")                           //
            .join("user_info").on("user_id")                //
            .limit(1)                                       //
            .mapper(User.class)                             //
            .single();
        user = query.find("user")                           //
            .join("user_info").on("user_id")                //
            .limit(1)                                       //
            .mapper(User.class)                             //
            .unique();
        listUser = query.find("user")                       //
            .join("user_info").on("user_id")                //
            .limit(10)                                      //
            .mapper(User.class)                             //
            .list();
        pageUser = query.find("user")                       //
            .join("user_info").on("user_id")                //
            .limit(10)                                      //
            .mapper(User.class)                             //
            .pagination();

        listUser2 = query.find("user")                      //
            .join("user_info").on("user_id").fetch()        //
            .mapper(User.class, User.class)                 //
            .list();
        listUser2 = query.find("user")                      //
            .join("user_info").on("user_id").fetch()        //
            .limit(10)                                      //
            .mapper(User.class, User.class)                 //
            .list();

        listUser = query.find("user")                       //
            .join("user_info").on("user_id")                //
            .where()                                        //
            .eq("id", 1)                                    //
            .mapper(User.class)                             //
            .list();
        user = query.find("user")                           //
            .join("user_info").on("user_id")                //
            .where()                                        //
            .eq("id", 1)                                    //
            .mapper(User.class)                             //
            .single();
        user = query.find("user")                          //
            .join("user_info").on("user_id")                //
            .where()                                        //
            .eq("id", 1)                                    //
            .mapper(User.class)                             //
            .unique();

        listUser2 = query.find("user")                      //
            .join("user_info").on("user_id").fetch()        //
            .where()                                        //
            .eq("id", 1)                                    //
            .mapper(User.class, User.class)                 //
            .list();
        user2 = query.find("user")                          //
            .join("user_info").on("user_id").fetch()        //
            .where()                                        //
            .eq("id", 1)                                    //
            .mapper(User.class, User.class)                 //
            .single();
        user2 = query.find("user")                          //
            .join("user_info").on("user_id").fetch()        //
            .where()                                        //
            .eq("id", 1)                                    //
            .mapper(User.class, User.class)                 //
            .unique();

        user2 = query.find("user")                          //
            .join("user_info").on("user_id").fetch()        //
            .where()                                        //
            .eq("id", 1)                                    //
            .limit(1)                                       //
            .mapper(User.class, User.class)                 //
            .single();
        user2 = query.find("user")                          //
            .join("user_info").on("user_id").fetch()        //
            .where()                                        //
            .eq("id", 1)                                    //
            .limit(1)                                       //
            .mapper(User.class, User.class)                 //
            .unique();
        listUser2 = query.find("user")                      //
            .join("user_info").on("user_id").fetch()        //
            .where()                                        //
            .eq("id", 1)                                    //
            .limit(10)                                      //
            .mapper(User.class, User.class)                 //
            .list();
        pageUser2 = query.find("user")                      //
            .join("user_info").on("user_id").fetch()        //
            .where()                                        //
            .eq("id", 1)                                    //
            .limit(10)                                      //
            .mapper(User.class, User.class)                 //
            .pagination();
    }

    public void queryJoin2() {
        user = query.find("user")                           //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .mapper(User.class)                             //
            .single();
        user = query.find("user")                           //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .mapper(User.class)                             //
            .unique();
        listUser = query.find("user")                       //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .mapper(User.class)                             //
            .list();

        user = query.find("user")                           //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .limit(1)                                       //
            .mapper(User.class)                             //
            .single();
        user = query.find("user")                           //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .limit(1)                                       //
            .mapper(User.class)                             //
            .unique();
        listUser = query.find("user")                       //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .limit(10)                                      //
            .mapper(User.class)                             //
            .list();
        pageUser = query.find("user")                       //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .limit(10)                                      //
            .mapper(User.class)                             //
            .pagination();

        listUser2 = query.find("user")                      //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id").fetch()        //
            .mapper(User.class, User.class)                 //
            .list();
        listUser2 = query.find("user")                      //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id").fetch()        //
            .limit(10)                                      //
            .mapper(User.class, User.class)                 //
            .list();
        user2 = query.find("user")                          //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id").fetch()        //
            .limit(1)                                       //
            .mapper(User.class, User.class)                 //
            .single();
        user2 = query.find("user")                          //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id").fetch()        //
            .limit(1)                                       //
            .mapper(User.class, User.class)                 //
            .unique();

        listUser2 = query.find("user")                      //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id")                //
            .mapper(User.class, User.class)                 //
            .list();
        listUser2 = query.find("user")                      //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id")                //
            .limit(10)                                      //
            .mapper(User.class, User.class)                 //
            .list();
        user2 = query.find("user")                          //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id")                //
            .limit(1)                                       //
            .mapper(User.class, User.class)                 //
            .single();
        user2 = query.find("user")                          //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id")                //
            .limit(1)                                       //
            .mapper(User.class, User.class)                 //
            .unique();

        listUser3 = query.find("user")                      //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .mapper(User.class, User.class, User.class)     //
            .list();
        listUser3 = query.find("user")                      //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .limit(10)                                      //
            .mapper(User.class, User.class, User.class)     //
            .list();
        user3 = query.find("user")                          //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .limit(1)                                       //
            .mapper(User.class, User.class, User.class)     //
            .single();
        user3 = query.find("user")                          //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .limit(1)                                       //
            .mapper(User.class, User.class, User.class)     //
            .unique();

        listUser3 = query.find("user")                      //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .where()                                        //
            .eq("id", 1)                                    //
            .mapper(User.class, User.class, User.class)     //
            .list();
        user3 = query.find("user")                          //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .where()                                        //
            .eq("id", 1)                                    //
            .mapper(User.class, User.class, User.class)     //
            .single();
        user3 = query.find("user")                          //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .where()                                        //
            .eq("id", 1)                                    //
            .mapper(User.class, User.class, User.class)     //
            .unique();

        user2 = query.find("user")                          //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id").fetch()        //
            .where()                                        //
            .eq("id", 1)                                    //
            .limit(1)                                       //
            .mapper(User.class, User.class)                 //
            .single();
        user2 = query.find("user")                          //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id").fetch()        //
            .where()                                        //
            .eq("id", 1)                                    //
            .limit(1)                                       //
            .mapper(User.class, User.class)                 //
            .unique();
        listUser2 = query.find("user")                      //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id").fetch()        //
            .where()                                        //
            .eq("id", 1)                                    //
            .limit(10)                                      //
            .mapper(User.class, User.class)                 //
            .list();
        pageUser2 = query.find("user")                      //
            .join("user_info").on("user_id")               //
            .join("user_info").on("user_id").fetch()        //
            .where()                                        //
            .eq("id", 1)                                    //
            .limit(10)                                      //
            .mapper(User.class, User.class)                 //
            .pagination();

        user2 = query.find("user")                          //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id")                //
            .where()                                        //
            .eq("id", 1)                                    //
            .limit(1)                                       //
            .mapper(User.class, User.class)                 //
            .single();
        user2 = query.find("user")                          //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id")                //
            .where()                                        //
            .eq("id", 1)                                    //
            .limit(1)                                       //
            .mapper(User.class, User.class)                 //
            .unique();
        listUser2 = query.find("user")                      //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id")                //
            .where()                                        //
            .eq("id", 1)                                    //
            .limit(10)                                      //
            .mapper(User.class, User.class)                 //
            .list();
        pageUser2 = query.find("user")                      //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id")                //
            .where()                                        //
            .eq("id", 1)                                    //
            .limit(10)                                      //
            .mapper(User.class, User.class)                 //
            .pagination();

        user3 = query.find("user")                          //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .where()                                        //
            .eq("id", 1)                                    //
            .limit(1)                                       //
            .mapper(User.class, User.class, User.class)     //
            .single();
        user3 = query.find("user")                          //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .where()                                        //
            .eq("id", 1)                                    //
            .limit(1)                                       //
            .mapper(User.class, User.class, User.class)     //
            .unique();
        listUser3 = query.find("user")                      //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .where()                                        //
            .eq("id", 1)                                    //
            .limit(10)                                      //
            .mapper(User.class, User.class, User.class)     //
            .list();
        pageUser3 = query.find("user")                      //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .where()                                        //
            .eq("id", 1)                                    //
            .limit(10)                                      //
            .mapper(User.class, User.class, User.class)     //
            .pagination();
    }

    public void queryJoin6() {
        user = query.find("user")                           //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .mapper(User.class)                             //
            .single();
        user = query.find("user")                           //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .mapper(User.class)                             //
            .unique();
        listUser = query.find("user")                       //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .mapper(User.class)                             //
            .list();

        user = query.find("user")                           //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .limit(1)                                       //
            .mapper(User.class)                             //
            .single();
        user = query.find("user")                           //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .limit(1)                                       //
            .mapper(User.class)                             //
            .unique();
        listUser = query.find("user")                       //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .limit(10)                                      //
            .mapper(User.class)                             //
            .list();
        pageUser = query.find("user")                       //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .limit(10)                                      //
            .mapper(User.class)                             //
            .pagination();

        listUser2 = query.find("user")                      //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id").fetch()        //
            .mapper(User.class, User.class)                 //
            .list();
        listUser2 = query.find("user")                      //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id").fetch()        //
            .limit(10)                                      //
            .mapper(User.class, User.class)                 //
            .list();
        user2 = query.find("user")                          //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id").fetch()        //
            .limit(1)                                       //
            .mapper(User.class, User.class)                 //
            .single();
        user2 = query.find("user")                          //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id").fetch()        //
            .limit(1)                                       //
            .mapper(User.class, User.class)                 //
            .unique();

        listUser2 = query.find("user")                      //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id")                //
            .mapper(User.class, User.class)                 //
            .list();
        listUser2 = query.find("user")                      //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id")                //
            .limit(10)                                      //
            .mapper(User.class, User.class)                 //
            .list();
        user2 = query.find("user")                          //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id")                //
            .limit(1)                                       //
            .mapper(User.class, User.class)                 //
            .single();
        user2 = query.find("user")                          //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id")                //
            .limit(1)                                       //
            .mapper(User.class, User.class)                 //
            .unique();

        listUser6 = query.find("user")                      //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .mapper(User.class, User.class, User.class, User.class, User.class, User.class) //
            .list();
        listUser6 = query.find("user")                      //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .limit(10)                                      //
            .mapper(User.class, User.class, User.class, User.class, User.class, User.class) //
            .list();
        user6 = query.find("user")                          //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .limit(1)                                       //
            .mapper(User.class, User.class, User.class, User.class, User.class, User.class) //
            .single();
        user6 = query.find("user")                          //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .limit(1)                                       //
            .mapper(User.class, User.class, User.class, User.class, User.class, User.class) //
            .unique();

        listUser6 = query.find("user")                      //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .where()                                        //
            .eq("id", 1)                                    //
            .mapper(User.class, User.class, User.class, User.class, User.class, User.class) //
            .list();
        user6 = query.find("user")                          //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .where()                                        //
            .eq("id", 1)                                    //
            .mapper(User.class, User.class, User.class, User.class, User.class, User.class) //
            .single();
        user6 = query.find("user")                          //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .where()                                        //
            .eq("id", 1)                                    //
            .mapper(User.class, User.class, User.class, User.class, User.class, User.class) //
            .unique();

        user2 = query.find("user")                          //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .where()                                        //
            .eq("id", 1)                                    //
            .limit(1)                                       //
            .mapper(User.class, User.class)                 //
            .single();
        user2 = query.find("user")                          //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .where()                                        //
            .eq("id", 1)                                    //
            .limit(1)                                       //
            .mapper(User.class, User.class)                 //
            .unique();
        listUser2 = query.find("user")                      //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .where()                                        //
            .eq("id", 1)                                    //
            .limit(10)                                      //
            .mapper(User.class, User.class)                 //
            .list();
        pageUser2 = query.find("user")                      //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .where()                                        //
            .eq("id", 1)                                    //
            .limit(10)                                      //
            .mapper(User.class, User.class)                 //
            .pagination();

        user2 = query.find("user")                          //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .where()                                        //
            .eq("id", 1)                                    //
            .limit(1)                                       //
            .mapper(User.class, User.class)                 //
            .single();
        user2 = query.find("user")                          //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .where()                                        //
            .eq("id", 1)                                    //
            .limit(1)                                       //
            .mapper(User.class, User.class)                 //
            .unique();
        listUser2 = query.find("user")                      //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .where()                                        //
            .eq("id", 1)                                    //
            .limit(10)                                      //
            .mapper(User.class, User.class)                 //
            .list();
        pageUser2 = query.find("user")                      //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .where()                                        //
            .eq("id", 1)                                    //
            .limit(10)                                      //
            .mapper(User.class, User.class)                 //
            .pagination();

        user2 = query.find("user")                          //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .where()                                        //
            .eq("id", 1)                                    //
            .limit(1)                                       //
            .mapper(User.class, User.class)                 //
            .single();
        user2 = query.find("user")                          //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .where()                                        //
            .eq("id", 1)                                    //
            .limit(1)                                       //
            .mapper(User.class, User.class)                 //
            .unique();
        listUser2 = query.find("user")                      //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .where()                                        //
            .eq("id", 1)                                    //
            .limit(10)                                      //
            .mapper(User.class, User.class)                 //
            .list();
        pageUser2 = query.find("user")                      //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .where()                                        //
            .eq("id", 1)                                    //
            .limit(10)                                      //
            .mapper(User.class, User.class)                 //
            .pagination();

        user2 = query.find("user")                          //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id")                //
            .where()                                        //
            .eq("id", 1)                                    //
            .limit(1)                                       //
            .mapper(User.class, User.class)                 //
            .single();
        user2 = query.find("user")                          //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id")                //
            .where()                                        //
            .eq("id", 1)                                    //
            .limit(1)                                       //
            .mapper(User.class, User.class)                 //
            .unique();
        listUser2 = query.find("user")                      //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id")                //
            .where()                                        //
            .eq("id", 1)                                    //
            .limit(10)                                      //
            .mapper(User.class, User.class)                 //
            .list();
        pageUser2 = query.find("user")                      //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id")                //
            .where()                                        //
            .eq("id", 1)                                    //
            .limit(10)                                      //
            .mapper(User.class, User.class)                 //
            .pagination();

        user2 = query.find("user")                          //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id").fetch()        //
            .where()                                        //
            .eq("id", 1)                                    //
            .limit(1)                                       //
            .mapper(User.class, User.class)                 //
            .single();
        user2 = query.find("user")                          //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id").fetch()        //
            .where()                                        //
            .eq("id", 1)                                    //
            .limit(1)                                       //
            .mapper(User.class, User.class)                 //
            .unique();
        listUser2 = query.find("user")                      //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id").fetch()        //
            .where()                                        //
            .eq("id", 1)                                    //
            .limit(10)                                      //
            .mapper(User.class, User.class)                 //
            .list();
        pageUser2 = query.find("user")                      //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id")                //
            .join("user_info").on("user_id").fetch()        //
            .where()                                        //
            .eq("id", 1)                                    //
            .limit(10)                                      //
            .mapper(User.class, User.class)                 //
            .pagination();

        user6 = query.find("user")                          //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .where()                                        //
            .eq("id", 1)                                    //
            .limit(1)                                       //
            .mapper(User.class, User.class, User.class, User.class, User.class, User.class) //
            .single();
        user6 = query.find("user")                          //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .where()                                        //
            .eq("id", 1)                                    //
            .limit(1)                                       //
            .mapper(User.class, User.class, User.class, User.class, User.class, User.class) //
            .unique();
        listUser6 = query.find("user")                      //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .where()                                        //
            .eq("id", 1)                                    //
            .limit(10)                                      //
            .mapper(User.class, User.class, User.class, User.class, User.class, User.class) //
            .list();
        pageUser6 = query.find("user")                      //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .join("user_info").on("user_id").fetch()        //
            .where()                                        //
            .eq("id", 1)                                    //
            .limit(10)                                      //
            .mapper(User.class, User.class, User.class, User.class, User.class, User.class) //
            .pagination();
    }

    public void queryJoin0() {
        Repository repo = new SimpleRepository("user");

        query.find("user") //
            .join("user_info").on("user_id") //
            .join("role").on((r1, r2, j) -> j.field("id").eq(r2.field("role_id")));

        query.find("user") //
            .join("user_info").on("user_id") //
            .join("role").on((r1, r2, j) -> j.field("id").eq(r2.field("role_id")));

        //        query.find("user") //
        //                .join("user_info").on("user_id") //
        //                .join2("role").on("id", "role_id");
        //
        //        query.find("user") //
        //                .join("user_info").on("user_id") //
        //                .join(rs -> rs.get1(), "role").on("id", "role_id");
        //        query.find("user") //
        //                .join("user_info").on("user_id") //
        //                .join(rs -> rs.get1(), repo).on("id", "role_id");
        //
        //        query.find("user") //
        //                .join("user_info").on("user_id") //
        //                .join(Tuple2::get1, "role").on("id", "role_id");
        //        query.find("user") //
        //                .join("user_info").on("user_id") //
        //                .join(Tuple2::get1, repo).on("id", "role_id");
        //
        //        query.find("user") //
        //                .join("user_info").on("user_id") //
        //                .join(rs -> rs.get1().accept("role")).on("id", "role_id");
        //        query.find("user") //
        //                .join("user_info").on("user_id") //
        //                .join(rs -> rs.get1().accept(repo)).on("id", "role_id");
        //
        //        query.find("user") //
        //                .join("user_info").on("user_id") //
        //                .join((r0, r1) -> r1.accept("role")).on("id", "role_id");
        //        query.find("user") //
        //                .join("user_info").on("user_id") //
        //                .join((r0, r1) -> r1.accept(repo)).on("id", "role_id");
        //
        //        // ----------------------------------------------------------------------------------------------------------------
        //
        //        query.find("user") //
        //                //                .join("user_info").on("user_id") //
        //                .join("user_info").on(t -> t.joinField("user_id")) //
        //                // .join((r0, r1) -> r1.apply(repo)).on("id", "role_id");
        //                // .join((r0, r1) -> r1.apply(repo)).on((Consumer<OnFields>) t -> t.joinField("id").sourceField("role_id"));
        //                .join((r0, r1) -> r1.accept(repo)).on(t -> t.joinField("id").sourceField("role_id"));
        //
        //        // ----------------------------------------------------------------------------------------------------------------
        //
        //        query.find("user") //
        //                .join("user_info").on("user_id").fetch() //
        //                .join2("role").on("id", "role_id").fetch();
        //
        //        query.find("user") //
        //                .join("user_info").on("user_id").fetch() //
        //                .join(rs -> rs.get1(), "role").on("id", "role_id").fetch();
        //        query.find("user") //
        //                .join("user_info").on("user_id").fetch() //
        //                .join(Tuple2::get1, "role").on("id", "role_id").fetch();
        //        query.find("user") //
        //                .join("user_info").on("user_id").fetch() //
        //                .join(Tuple2::get1, repo).on("id", "role_id").fetch();
        //
        //        query.find("user") //
        //                .join("user_info").on("user_id").fetch() //
        //                .join(rs -> rs.get1().apply("role")).on("id", "role_id").fetch();
        //        query.find("user") //
        //                .join("user_info").on("user_id").fetch() //
        //                .join(rs -> rs.get1().apply(repo)).on("id", "role_id").fetch();
    }

    public void queryJoinFetchFields() {
        //      query.find("user").join("user_info").on("user_id").join("role").on("id", "user_role", "role_id").fetch();
        query.find("user").join("user_info").on("user_id").join("role").on("id", "role_id").fetch();

        query.find("user").join("user_info").on("user_id").where();
        query.find("user").join("user_info").on("user_id").fetch().where();

        query.find("user") //
            .join("user_info").on("user_id") //
            .join("user_role").on("user_id", "id") //
            .join("role").on((r1, r2, r3, j) -> j.field("id").eq(r3.field("role_id"))).fetch();
        //        query.find("user").join("user_info").on("user_id") //
        //        .join("user_role").on("user_id", "id") //
        //        .join3("role").on("id", "role_id").fetch();

        //        query.find("user").join("user_info").on("user_id") //
        //                .join("user_role").on("user_id", "id") //
        //                .join(rs -> rs.get2().apply("role")).on("id", "role_id").fetch();
        //        query.find("user").join("user_info").on("user_id") //
        //                .join("user_role").on("user_id", "id") //
        //                .join((r1, r2, r3) -> r3.apply("role")).on("id", "role_id").fetch();

        // ----------------------------------------------------------------------------------------------------------------
        //        query.find("user").join("user_info").on((j, r) -> j.field("id").eq(r.field("role_id"))) //
        //                .join("user_role").on("user_id", "id") //
        //                .join("role").on((r1, r2, r3, j) -> j.field("id").eq(r3.field("role_id"))).fetch();
        //
        //        query.find("user").join("user_info").on("user_id") //
        //                .join("user_role").on("user_id", "id") //
        //                .join("role").on((j, rs) -> j.field("id").eq(rs.get2().field("role_id"))).fetch();
        // ----------------------------------------------------------------------------------------------------------------

        //        query.find("user").join("user_info").on("user_id") //
        //                .join("user_role").on("user_id", "id") //
        //                .join(rs -> rs.get2(), "role").on("id", "role_id").fetch();
        //        query.find("user").join("user_info").on("user_id") //
        //                .join("user_role").on("user_id", "id") //
        //                .join((r1, r2, r3) -> r3, "role").on("id", "role_id").fetch();

        // IMPLSOON 后续来实现这种api
        query.find("user") // r1
            .join("user_info").on("user_id") // r2
            .join("user_role").on("user_id", "id") // r3
            .join("role").on((r1, r2, r3, r4) -> r3.field("role_id").eq(r4.field("id"))).fetch(); // r4
        //        query.find("user") // r1
        //                .join("user_info").on("user_id") // r2
        //                .join("user_role").on("user_id", "id") // r3
        //                .join("role").on("id", (r1, r2, r3) -> r3.field("role_id")).fetch(); //r4

        query.find("user").join("user_info").on("user_id").fetch("name").fetch();

        //        query.find("user").join("user_info").on("user_id").fetch("name") //
        //                .join("user_role").on("user_id", "id") //
        //                .join3("role").on("id", "role_id").fetch();

        //        query.find("user").join("user_info").on("user_id").where().eq("id", 1).intValue();

        query.find("order") //
            .join("order").on("id", "parent_id") //
            .join("user").on("id", "create_user") //
            .join("user").on("id", "update_user") //
            .join("user_info").on("id", "user_info") //
            .join("user").on("id", "user1") //
            .where() //
            .eq("no", "") //
            .and().eq("no", "") //
            .limit(1) //
            .single();

        query.find("order") //
            .join("order").on("id", "parent_id") //
            .join("user").on("id", "create_user") //
            .join("user").on("id", "update_user") //
            .join("user_info").on("id", "user_info") //
            .join("user").on("id", "user1") //
            .where() //
            .eq((t1, t2, t3, t4, t5, t6) -> t1.field("no").value("")) //
            .and().eq((t1, t2, t3, t4, t5, t6) -> t1.accept("no", "")) //
            .limit(1) //
            .single();

        query.find("order") //
            .join("order").on("id", "parent_id") //
            .join("user").on("id", "create_user") //
            .join("user").on("id", "update_user") //
            .join("user_info").on("id", "user_info") //
            .join("user").on("id", "user1") //
            .where() //
            .field((t1, t2, t3, t4, t5, t6) -> t1.field("no").eq("").and().field("no").eq("") //
                .and(t3.field("name").eq("")) //
            ) //
            .and().eq((t1, t2, t3, t4, t5, t6) -> t1.accept("no", "")) //
            .limit(1) //
            .single();
    }

    void t() {
        query.find("order") //
            .join("order").on("id", "parent_id") //
            .join("user").on("id", "create_user") //
            .join("user").on("id", "update_user") //
            .join("user_info").on("id", "user_info") //
            .join("user").on("id", "user1");

        query.find("order") //
            .join("order").on("id", "parent_id") //
            .join("user").on("id", "create_user").fetch() //
            .join("user").on("id", "update_user") //
            .join("user_info").on("id", "user_info").fetch() //
            .join("user").on("id", "user1");
    }

    public void querySort() {
        listMap = query.find("user") //
            .sort().asc("age") //
            .list();
        // FIXME 这里不应该能够直接single,unique，因为没有条件也没有limit
        map = query.find("user") //
            .sort().asc("age") //
            .single();
        map = query.find("user") //
            .sort().asc("age") //
            .unique();
        // 这里不应该能够直接pagination，因为没有limit
        //        pageMap = query.find("user") //
        //            .sort().asc("age") //
        //            .pagination();

        listUser = query.find("user")   //
            .sort().asc("age")          //
            .mapper(User.class)         //
            .list();
        // FIXME 这里不应该能够直接single unique，因为没有条件也没有limit
        user = query.find("user")       //
            .sort().asc("age")          //
            .mapper(User.class)         //
            .single();
        user = query.find("user")       //
            .sort().asc("age")          //
            .mapper(User.class)         //
            .unique();
        // 这里不应该能够直接pagination，因为没有limit
        //        user = query.find("user")       //
        //            .sort().asc("age")          //
        //            .mapper(User.class)         //
        //            .pagination();

        listMap = query.find("user")    //
            .sort().asc("age")          //
            .limit(10)                  //
            .list();
        map = query.find("user")        //
            .sort().asc("age")          //
            .limit(1)                   //
            .single();
        pageMap = query.find("user")    //
            .sort().asc("age")          //
            .limit(10)                  //
            .pagination();

        listUser = query.find("user")   //
            .sort().asc("age")          //
            .limit(10)                  //
            .mapper(User.class)         //
            .list();
        // FIXME 这里不应该能够直接single unique，因为没有条件也没有limit
        user = query.find("user")       //
            .sort().asc("age")          //
            .limit(1)                   //
            .mapper(User.class)         //
            .single();
        user = query.find("user")       //
            .sort().asc("age")          //
            .limit(1)                   //
            .mapper(User.class)         //
            .unique();
        // 这里不应该能够直接pagination，因为没有limit
        pageUser = query.find("user")       //
            .sort().asc("age")          //
            .limit(10)                  //
            .mapper(User.class)         //
            .pagination();

        listMap = query.find("user") //
            .where().eq("id", 1) //
            .sort().asc("age") //
            .list();
        map = query.find("user") //
            .where().eq("id", 1) //
            .sort().asc("age") //
            .single();
        // 这里不应该能够直接pagination，因为没有limit
        //        pageMap = query.find("user") //
        //            .where().eq("id", 1) //
        //            .sort().asc("age") //
        //            .pagination();

        listUser = query.find("user")   //
            .where().eq("id", 1)        //
            .sort().asc("age")          //
            .mapper(User.class)         //
            .list();
        // FIXME 这里不应该能够直接single unique，因为没有条件也没有limit
        user = query.find("user")       //
            .where().eq("id", 1)        //
            .sort().asc("age")          //
            .mapper(User.class)         //
            .single();
        user = query.find("user")       //
            .where().eq("id", 1)        //
            .sort().asc("age")          //
            .mapper(User.class)         //
            .unique();
        // 这里不应该能够直接pagination，因为没有limit
        //        pageUser = query.find("user")   //
        //            .where().eq("id", 1)        //
        //            .sort().asc("age")          //
        //            .mapper(User.class)         //
        //            .pagination();

        listMap = query.find("user")    //
            .where().eq("id", 1)        //
            .sort().asc("age")          //
            .limit(10)                  //
            .list();
        map = query.find("user")        //
            .where().eq("id", 1)        //
            .sort().asc("age")          //
            .limit(1)                   //
            .single();
        pageMap = query.find("user")    //
            .where().eq("id", 1)        //
            .sort().asc("age")          //
            .limit(10)                  //
            .pagination();

        listUser = query.find("user")   //
            .where().eq("id", 1)        //
            .sort().asc("age")          //
            .limit(10)                  //
            .mapper(User.class)         //
            .list();
        user = query.find("user")       //
            .where().eq("id", 1)        //
            .sort().asc("age")          //
            .limit(1)                   //
            .mapper(User.class)         //
            .single();
        user = query.find("user")       //
            .where().eq("id", 1)        //
            .sort().asc("age")          //
            .limit(1)                   //
            .mapper(User.class)         //
            .unique();
        // 这里不应该能够直接pagination，因为没有limit
        pageUser = query.find("user")   //
            .where().eq("id", 1)        //
            .sort().asc("age")          //
            .limit(10)                  //
            .mapper(User.class)         //
            .pagination();
    }

    public void querySort2() {
        listUser = query.find("user") //
            .join("user_info").on("user_id") //
            .join("role").on((r1, r2, j) -> j.field("id").eq(r2.field("user_id"))) //
            .sort() //
            .asc((s1, s2, s3) -> s1.field("a").field("b")) //
            .mapper(User.class) //
            .list();

        listUser2 = query.find("user") //
            .join("user_info").on("user_id").fetch() //
            .join("role").on((r1, r2, j) -> j.field("id").eq(r2.field("user_id"))) //
            .sort() //
            .asc((s1, s2, s3) -> s1.field("a").field("b")) //
            .mapper(User.class, User.class) //
            .list();

        listUser2 = query.find("user") //
            .join("user_info").on("user_id") //
            .join("role").on((r1, r2, j) -> j.field("id").eq(r2.field("user_id"))).fetch() //
            .sort() //
            .asc((s1, s2, s3) -> s1.field("a").field("b")) //
            .mapper(User.class, User.class) //
            .list();

        listUser3 = query.find("user") //
            .join("user_info").on("user_id").fetch() //
            .join("role").on((r1, r2, j) -> j.field("id").eq(r2.field("user_id"))).fetch() //
            .sort() //
            .asc((s1, s2, s3) -> s1.field("a").field("b")) //
            .mapper(User.class, User.class, User.class) //
            .list();

        // --------

        listUser = query.find("user") //
            .join("user_info").on("user_id") //
            .join("role").on((r1, r2, j) -> j.field("id").eq(r2.field("user_id"))) //
            .sort((s1, s2, s3) -> s1.asc("a", "b")) //
            .mapper(User.class) //
            .list();

        listUser2 = query.find("user") //
            .join("user_info").on("user_id").fetch() //
            .join("role").on((r1, r2, j) -> j.field("id").eq(r2.field("user_id"))) //
            .sort((s1, s2, s3) -> s1.asc("a", "b")) //
            .mapper(User.class, User.class) //
            .list();

        listUser2 = query.find("user") //
            .join("user_info").on("user_id") //
            .join("role").on((r1, r2, j) -> j.field("id").eq(r2.field("user_id"))).fetch() //
            .sort((s1, s2, s3) -> s1.asc("a", "b")) //
            .mapper(User.class, User.class) //
            .list();

        listUser3 = query.find("user") //
            .join("user_info").on("user_id").fetch() //
            .join("role").on((r1, r2, j) -> j.field("id").eq(r2.field("user_id"))).fetch() //
            .sort((s1, s2, s3) -> s1.asc("a", "b")) //
            .mapper(User.class, User.class, User.class) //
            .list();
    }
}
