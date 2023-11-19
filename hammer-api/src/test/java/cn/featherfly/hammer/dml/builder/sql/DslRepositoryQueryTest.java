
package cn.featherfly.hammer.dml.builder.sql;

import java.util.List;

import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.dml.builder.sql.vo.User;
import cn.featherfly.hammer.dsl.query.Query;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryFetch;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryValue;

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
        RepositoryQueryFetch queryFetch;
        RepositoryQueryValue queryValue;
        queryFetch.list(User.class);
        queryFetch.limit(10).list(User.class);
        queryFetch.limit(1).single(User.class);
        queryFetch.sort();

        // FIXME 没有进行条件帅选就能进行唯一值返回是错误的
        queryFetch.field("name").number(Integer.class);
        queryFetch.field("name").intValue();
        //        query.field("name").limit(1).number(Integer.class);
        queryFetch.field("name").limit(1).intValue();
        queryFetch.field("name").limit(1).value(Integer.class);
        queryFetch.field("name").limit(1).single(Integer.class);
        queryFetch.field("name").where().eq("id", 1).single(Integer.class);
        queryFetch.field("name").where().eq("id", 1).number(Integer.class);
        queryFetch.where().eq("id", 1).number(Integer.class); // 这个是错误的，因为是返回多个数据

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

        queryFetch.where().lt("age", 18).count();

        queryFetch.field("name").where().eq("", 1).and().lt("age", 18).and().group(t -> t.gt("score", 80)).limit(11, 10)
                .list(User.class);

        queryFetch.field("name").where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80).limit(11, 10)
                .list(User.class);

        queryFetch.where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80).single(User.class);

        queryFetch.field("name").where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80).limit(11, 10)
                .list(User.class);

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
}
