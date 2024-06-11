
package cn.featherfly.hammer.dml.builder.sql;

import java.util.List;
import java.util.function.Consumer;

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

    // ----------------------------------------------------------------------------------------------------------------

    List<String> list;
    List<Integer> intList;
    List<String> strList;
    int i;
    String str;
    Integer integer;

    public void query() {
        query.find(data).list(User.class);
        query.find(data).limit(10).list(User.class);
        query.find(data).limit(1).single(User.class);

        query.find("user").sort();

        list = query.find(data).field("name").list();
        list = query.find(data).field("name").list(String.class);

        // FIXME 没有进行条件帅选就能进行唯一值返回是错误的
        // 因为统计函数可能返回唯一值，所以这里还需要再考虑如何实现，先这样，由用户自行决定返回结果是单值还是多值
        query.find(data).field("name").number(Integer.class);
        query.find(data).field("name").intNumber();
        query.find(data).field("name").intValue();

        //
        query.find(data).field("name").limit(1).number(Integer.class);
        query.find(data).field("name").limit(1).intNumber();
        query.find(data).field("name").limit(1).intValue();
        str = query.find(data).field("name").limit(1).value();
        query.find(data).field("name").limit(1).single(Integer.class);
        query.find(data).field("name").where().eq("id", 1).single(Integer.class);
        query.find(data).field("name").where().eq("id", 1).number(Integer.class);
        //        query.find(data).where().eq("id", 1).number(Integer.class);

        query.find(data).max("age").number(Integer.class);
        // FIXME 使用了统计函数，则没有进行分组，就只有一行数据
        query.find(data).max("age").list(Integer.class);

        query.find(data).count();
        query.find(data).field("name").number(Integer.class);
        query.find(data).fetch("name").number(Integer.class);
        query.find(data).field("name").intNumber();
        query.find(data).fetch("name").intNumber();
        query.find(data).field("sum(price)").decimal();
        query.find(data).fetch("sum(price)").decimal();
        query.find(data).field(AggregateFunction.SUM, "price").decimal();
        query.find(data).fetch(AggregateFunction.SUM, "price").decimal();
        query.find(data).sum("price").decimal();
        query.find(data).field(AggregateFunction.COUNT, "id").intNumber();
        query.find(data).fetch(AggregateFunction.COUNT, "id").intNumber();
        query.find(data).count("id").intNumber();
        query.find(data).field(AggregateFunction.COUNT, "id").longNumber();
        query.find(data).fetch(AggregateFunction.COUNT, "id").longNumber();
        query.find(data).count("id").longNumber();

        query.find(data).sum("id").longNumber();

        query.find(data).field("count(*)").where().lt("age", 18).longNumber();
        query.find(data).field(AggregateFunction.COUNT, "id").where().lt("age", 18).longNumber();

        query.find(data).where().lt("age", 18).count();

        query.find(data).field("name").where().eq("", 1).and().lt("age", 18).and().group(t -> t.gt("score", 80))
            .limit(11, 10).list(User.class);

        query.find(data).field("name").where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80).limit(11, 10)
            .list(User.class);

        query.find(data).where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80).single(User.class);

        query.find(data).field("name").where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80).limit(11, 10)
            .list(User.class);

        query.find(data).field("name").where().field("").eq(1).and().field("age").lt(18).and().group().field("score")
            .gt(80).limit(11, 10).list(User.class);

        query.find(data).where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80).sort().asc("name")
            .list(User.class);

        User user = null;
        user = query.find(data).where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80).sort().asc("name")
            .limit(1).single(User.class);
        user = query.find(data).where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80).sort().asc("name")
            .limit(1).<@Enhance User>single(User.class);
    }

    public void queryFetch() {
        Integer integer;

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
        integer = queryFetch.count("id").value(); // 统计函数可能返回唯一值
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

        integer = queryFetch.max("age").value();
        str = queryFetch.field("name").limit(1).value();

        intList = queryFetch.max("age").list();
        strList = queryFetch.field("name").limit(1).list();

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
            .field((q, f) -> q.field( //
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

    public void queryJoin() {
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
        query.find("user") //
            .join("user_info").on("user_id").fetch() //
            .join("role").on((r1, r2, j) -> j.field("id").eq(r2.field("user_id"))).fetch() //
            .sort() //
            .asc((s1, s2, s3) -> s1.field("a").field("b"));
        //        query.find("user") //
        //        .join("user_info").on("user_id").fetch() //
        //        .join2("role").on("id", "role_id").fetch() //
        //        .sort() //
        //        .asc((s1, s2, s3) -> s1.field("a").field("b"));
    }
}
