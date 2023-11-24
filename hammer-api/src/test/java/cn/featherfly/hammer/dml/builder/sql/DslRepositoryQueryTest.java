
package cn.featherfly.hammer.dml.builder.sql;

import java.util.List;
import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.common.repository.SimpleRepository;
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

    //    public static void main(String[] args) {
    //        System.out.println(Tuple2.getter0().apply(Tuples.of(1, 2)));
    //        System.out.println(Tuple2.getter1().apply(Tuples.of(1, 2)));
    //        User user = new User();
    //        Tuple2<Integer, String> t2 = Tuples.of(user.getAge(), user.getPwd());
    //        t2 = Tuples.toTuple(User::getAge, User::getPwd).apply(user);
    //        t2 = TupleBuilder.builder().add(1).add("str").build();
    //    }

    public void testQuery() {
        Integer i;
        String s;
        List<Integer> il;
        List<String> sl;
        Query query = null;
        query.find("").list(User.class);
        query.find("").list(User.class);
        query.find("").limit(10).list(User.class);
        query.find("").limit(1).single(User.class);
        query.find("").sort();

        RepositoryQueryFetch queryFetch = null;
        RepositoryQueryValue queryValue = null;
        queryFetch.list(User.class);
        queryFetch.limit(10).list(User.class);
        queryFetch.limit(1).single(User.class);
        queryFetch.sort();

        // 因为统计函数可能返回唯一值，所以这里还需要再考虑如何实现，先这样，由用户自行决定返回结果是单值还是多值
        queryFetch.field("name").number(Integer.class);
        queryFetch.field("name").intValue();
        queryFetch.field("name").list();
        i = queryFetch.count("id").value(); // 统计函数可能返回唯一值
        //        query.field("name").limit(1).number(Integer.class);
        queryFetch.field("name").limit(1).intValue();
        queryFetch.field("name").limit(1).value(Integer.class);
        queryFetch.field("name").limit(1).single(Integer.class);
        queryFetch.field("name").where().eq("id", 1).single(Integer.class);
        queryFetch.field("name").where().eq("id", 1).number(Integer.class);
        //        queryFetch.where().eq("id", 1).number(Integer.class); // 这个是错误的，因为是返回多个数据

        queryFetch.max("age").number(Integer.class);
        // FIXME 使用了统计函数，则没有进行分组，就只有一行数据
        queryFetch.max("age").list(Integer.class);

        i = queryFetch.max("age").value();
        s = queryFetch.field("name").limit(1).value();

        il = queryFetch.max("age").list();
        sl = queryFetch.field("name").limit(1).list();

        queryFetch.count();
        queryFetch.field("name").number(Integer.class);
        queryFetch.fetch("name").number(Integer.class);
        queryFetch.field("name").intNumber();
        queryFetch.fetch("name").intNumber();
        queryFetch.field("sum(price)").decimal();
        queryFetch.fetch("sum(price)").decimal();
        queryFetch.field(AggregateFunction.SUM, "price").decimal();
        queryFetch.fetch(AggregateFunction.SUM, "price").decimal();
        queryFetch.sum("price").decimal();
        queryFetch.field(AggregateFunction.COUNT, "id").intNumber();
        queryFetch.fetch(AggregateFunction.COUNT, "id").intNumber();
        queryFetch.count("id").intNumber();
        queryFetch.field(AggregateFunction.COUNT, "id").longNumber();
        queryFetch.fetch(AggregateFunction.COUNT, "id").longNumber();
        queryFetch.count("id").intNumber();

        queryFetch.sum("id").longNumber();

        queryFetch.field("count(*)").where().lt("age", 18).longNumber();
        queryFetch.field(AggregateFunction.COUNT, "id").where().lt("age", 18).longNumber();

        queryFetch.field("id").field("name").field("age").distinct("username");

        queryFetch.where().lt("age", 18).count();

        // FIXME 这里不应该可以直接调用endGroup,endGroup方法应该是group()方法调用后才能调用
        queryFetch.where().eq("", 1).endGroup();

        queryFetch.where().eq("", 1).and().group().eq("", 1).endGroup();
        // FIXME  这里的endGroup是错误的
        queryFetch.where().eq("", 1).and().group().eq("", 1).endGroup().endGroup();

        queryFetch.where().eq("", 1).and().group().group().eq("", 1).endGroup().endGroup();
        // FIXME  这里的endGroup是错误的
        queryFetch.where().eq("", 1).and().group().group().eq("", 1).endGroup().endGroup().endGroup();

        queryFetch.field("name").where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80).endGroup()
                .limit(11, 10).list(User.class);

        queryFetch.field("name").where().eq("", 1).and().lt("age", 18).and().group(t -> t.gt("score", 80)).limit(11, 10)
                .list(User.class);

        queryFetch.field("name").where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80).limit(11, 10)
                .list(User.class);

        queryFetch.where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80).single(User.class);

        queryFetch.field("name").where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80).limit(11, 10)
                .list(User.class);

        queryFetch.field("name").where().field("");

        query.find("user") //
                .field((Consumer<FetchField>) f -> f.name("password")) //
                .list();
        query.find("user") //
                .field(f -> {
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
                .field((q, f) -> q.fields( //
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
                .field((q, f) -> q.field(f.name("username")) //
                        .field(f.name("password")) //
                        .field(f.name("age")) //
                        .field(f.name("password").as("pwd")) //
                        .field(f.distinct().name("username").as("uname")) //
                        .field(f.avg().distinct().name("age").as("a")) //
                        .field(f.avg().name("age").as("a")) //
                        .field(f.avg("age").distinct()) //
                ) //
                .sort().asc("age") //
                .list();

        queryFetch.field("name").where().field("").eq(1).and().field("age").lt(18).and().group().field("score").gt(80)
                .limit(11, 10).list(User.class);
        queryFetch.field("name").where().field("").eq(1).and().field("age").lt(18).and().group().field("score").gt(80)
                .limit(11, 10).list(User.class);

        queryFetch.where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80).sort().asc("name")
                .list(User.class);

        User user = null;
        user = queryFetch.where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80).sort().asc("name")
                .limit(1).single(User.class);
        user = queryFetch.where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80).sort().asc("name")
                .limit(1).<@Enhance User>single(User.class);
    }

    public void testQueryJoin() {
        Repository repo = new SimpleRepository("field");

        query.find("user") //
                .join("user_info").on("user_id") //
                .join2("role").on("id", "role_id");

        query.find("user") //
                .join("user_info").on("user_id") //
                .join(rs -> rs.get1(), "role").on("id", "role_id");
        query.find("user") //
                .join("user_info").on("user_id") //
                .join(rs -> rs.get1(), repo).on("id", "role_id");

        query.find("user") //
                .join("user_info").on("user_id") //
                .join(Tuple2::get1, "role").on("id", "role_id");
        query.find("user") //
                .join("user_info").on("user_id") //
                .join(Tuple2::get1, repo).on("id", "role_id");

        query.find("user") //
                .join("user_info").on("user_id") //
                .join(rs -> rs.get1().apply("role")).on("id", "role_id");
        query.find("user") //
                .join("user_info").on("user_id") //
                .join(rs -> rs.get1().apply(repo)).on("id", "role_id");

        query.find("user") //
                .join("user_info").on("user_id") //
                .join((r0, r1) -> r1.apply("role")).on("id", "role_id");
        query.find("user") //
                .join("user_info").on("user_id") //
                .join((r0, r1) -> r1.apply(repo)).on("id", "role_id");

        // ----------------------------------------------------------------------------------------------------------------

        query.find("user") //
                //                .join("user_info").on("user_id") //
                .join("user_info").on(t -> t.joinField("user_id")) //
                // .join((r0, r1) -> r1.apply(repo)).on("id", "role_id");
                // .join((r0, r1) -> r1.apply(repo)).on((Consumer<OnFields>) t -> t.joinField("id").sourceField("role_id"));
                .join((r0, r1) -> r1.apply(repo)).on(t -> t.joinField("id").sourceField("role_id"));

        // ----------------------------------------------------------------------------------------------------------------

        query.find("user") //
                .join("user_info").on("user_id").fetch() //
                .join2("role").on("id", "role_id").fetch();

        query.find("user") //
                .join("user_info").on("user_id").fetch() //
                .join(rs -> rs.get1(), "role").on("id", "role_id").fetch();
        query.find("user") //
                .join("user_info").on("user_id").fetch() //
                .join(Tuple2::get1, "role").on("id", "role_id").fetch();
        query.find("user") //
                .join("user_info").on("user_id").fetch() //
                .join(Tuple2::get1, repo).on("id", "role_id").fetch();

        query.find("user") //
                .join("user_info").on("user_id").fetch() //
                .join(rs -> rs.get1().apply("role")).on("id", "role_id").fetch();
        query.find("user") //
                .join("user_info").on("user_id").fetch() //
                .join(rs -> rs.get1().apply(repo)).on("id", "role_id").fetch();

        // ----------------------------------------------------------------------------------------------------------------

        //        query.find("user").join("user_info").on("user_id").join("role").on("id", "user_role", "role_id").fetch();
        query.find("user").join("user_info").on("user_id").join("role").on("id", "role_id").fetch();

        query.find("user").join("user_info").on("user_id").where();
        query.find("user").join("user_info").on("user_id").fetch().where();
        query.find("user").join("user_info").on("user_id").join("user_role").on("user_id", "id").join("role")
                .on("id", "user_role", "role_id").fetch();

        query.find("user").join("user_info").on("user_id").fetch("name").fetch();

        query.find("user").join("user_info").on("user_id").fetch("name").join("user_role").on("user_id", "id")
                .join("role").on("id", "user_role", "role_id").fetch();

        query.find("user").join("user_info").on("user_id").where().eq("id", 1).intValue();
    }

    public void testQuerySort() {
        query.find("user") //
                .join("user_info").on("user_id").fetch() //
                .join2("role").on("id", "role_id").fetch() //
                .sort() //
                .asc((s1, s2, s3) -> s1.field("a").field("b"));
    }
}
