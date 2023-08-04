
package cn.featherfly.hammer.dml.builder.sql;

import java.util.Collection;
import java.util.List;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuple3;
import com.speedment.common.tuple.Tuple4;
import com.speedment.common.tuple.TupleBuilder;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.lang.CollectionUtils;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableFunction4;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.common.lang.function.StringSupplier;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.common.repository.SimpleRepository;
import cn.featherfly.hammer.dml.builder.sql.vo.Device;
import cn.featherfly.hammer.dml.builder.sql.vo.Student2;
import cn.featherfly.hammer.dml.builder.sql.vo.Tree;
import cn.featherfly.hammer.dml.builder.sql.vo.Tree2;
import cn.featherfly.hammer.dml.builder.sql.vo.User;
import cn.featherfly.hammer.dml.builder.sql.vo.User2;
import cn.featherfly.hammer.dml.builder.sql.vo.UserInfo;
import cn.featherfly.hammer.dml.builder.sql.vo.UserInfo2;
import cn.featherfly.hammer.dsl.execute.Deleter;
import cn.featherfly.hammer.dsl.execute.Updater;
import cn.featherfly.hammer.dsl.query.Query;
import cn.featherfly.hammer.dsl.query.type.EntityQueryConditionGroup;
import cn.featherfly.hammer.dsl.query.type.EntityQueryConditionGroup2;
import cn.featherfly.hammer.dsl.query.type.EntityQueryConditionGroupLogic;
import cn.featherfly.hammer.dsl.query.type.EntityQueryConditionGroupLogic2;
import cn.featherfly.hammer.expression.entity.condition.EntityPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.EntityPropertyExpression2;

/**
 * dsl api invoke test
 *
 * @author zhongj
 */
public class DslTest {

    Query query = null;

    Repository data = null;

    boolean ignore = true;

    public static void main(String[] args) {
        System.out.println(Tuple2.getter0().apply(Tuples.of(1, 2)));
        System.out.println(Tuple2.getter1().apply(Tuples.of(1, 2)));

        User user = new User();
        Tuple2<Integer, String> t2 = Tuples.of(user.getAge(), user.getPwd());
        t2 = Tuples.toTuple(User::getAge, User::getPwd).apply(user);
        t2 = TupleBuilder.builder().add(1).add("str").build();
    }

    public void testQuery() {
        query.find(data).list(User.class);
        query.find(data).limit(10).list(User.class);
        query.find(data).limit(1).single(User.class);

        query.find("user").sort();

        query.find(data).count();
        query.find(data).property("name").number(Integer.class);
        query.find(data).fetch("name").number(Integer.class);
        query.find(data).property("name").integer();
        query.find(data).fetch("name").integer();
        query.find(data).property("sum(price)").decimal();
        query.find(data).fetch("sum(price)").decimal();
        query.find(data).property(AggregateFunction.SUM, "price").decimal();
        query.find(data).fetch(AggregateFunction.SUM, "price").decimal();
        query.find(data).sum("price").decimal();
        query.find(data).property(AggregateFunction.COUNT, "id").integer();
        query.find(data).fetch(AggregateFunction.COUNT, "id").integer();
        query.find(data).count("id").integer();
        query.find(data).property(AggregateFunction.COUNT, "id").longInt();
        query.find(data).fetch(AggregateFunction.COUNT, "id").longInt();
        query.find(data).count("id").longInt();

        query.find(data).sum("id").longInt();

        query.find(data).property("count(*)").where().lt("age", 18).longInt();
        query.find(data).property(AggregateFunction.COUNT, "id").where().lt("age", 18).longInt();

        query.find(data).where().lt("age", 18).count();

        query.find(data).property("name").where().eq("", 1).and().lt("age", 18).and().group(t -> t.gt("score", 80))
                .limit(11, 10).list(User.class);

        query.find(data).property("name").where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80)
                .limit(11, 10).list(User.class);

        query.find(data).where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80).single(User.class);

        query.find(data).property("name").where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80)
                .limit(11, 10).list(User.class);

        query.find(data).property("name").where().property("").eq(1).and().property("age").lt(18).and().group()
                .property("score").gt(80).limit(11, 10).list(User.class);

        query.find(data).where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80).sort().asc("name")
                .list(User.class);

        query.find(data).where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80).sort().asc("name").limit(2)
                .list(User.class);
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

        query.find("user").relate("user_info").on("user_id").where().eq("id", 1).intValue();
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

        query.find(User.class).avg(User::getAge).where().eq(User::getAge, 5).integer();

        query.find(User.class).avg(User::getAge).integer();

        // sort
        query.find(User.class).sort().asc(User::getAge);

        query.find(User.class).avg(User::getAge).where().eq(User::getAge, 5).sort().asc(User::getAge);

        // fetch
        query.find(User.class).property(User::getUserInfo); // IMPLSOON 这个方法调用后，直接关联查询
        query.find(User.class).fetch(User::getUserInfo); // IMPLSOON 这个方法调用后，直接关联查询

        // query.find(User.class).property("name").number(Integer.class);
        // query.find(User.class).property("name").integer();
        // query.find(User.class).property("sum(price)").decimal();
        // query.find(User.class).property("count(*)").where().lt("age",
        // 18).longInt();

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
        query.find(User.class).where().in((SerializableFunction<User, String>) User::getPwd, new String[] { "a", "b" })
                .list();

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
        query.find(User.class).where().co(User::getUsername, "").and().setIgnoreStrategy(null).co((StringSupplier) null)
                .single();
        query.find(User.class).where().setIgnoreStrategy(null).co(User::toString, "").and().co((StringSupplier) null)
                .list();

        // TODO 如果后续加入编译期增强，则在使用注解标注泛型方法（例如find）
        // 目的是使得各种判断和类型匹配在编译期就处理完成，而不是在运行期就在获取
        /*
         1. co(User::getName, "")替换为co("name", "")，或者BeanPropertyValue）
         2. co(User::getName, "")替换为co(BeanPropertyValue)
         3. co(User::getName, "")替换为co(RepositoryFieldValue)
            此参数需要在编译期就搞好所有中间过程，即在jdbc设置时，不去使用SqlTypeMappingManager进行类型判断
         */
        user = query.<@Enhance User>find(User.class).where().co(User::getUsername, "").and().setIgnoreStrategy(null)
                .co((StringSupplier) null).single();
    }

    public void testEntityQueryJoinOrm() {
        //        query.find(User.class).with(User::getId).where().list();
        //        query.find(User.class).join(User::getId).where().eq(User::getId, 1).list();
        //        query.find(User.class).join(User::getId).fetch().where().eq(User::getId, 1).list();

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
        query.find(User.class).join(User::getUserInfo).join(UserInfo::getUser).join(User::getDevices);

        query.find(User.class).join(User::getUserInfo).join(es -> es.get1(),
                (SerializableFunction4<UserInfo, User>) UserInfo::getUser); // 编译无法确定参数，需要使用强制类型转换
        query.find(User.class).join(User::getUserInfo).join2(UserInfo::getUser); // 使用join[number]不会出现类型无法匹配的情况

        //        query.find(User.class).join(User::getUserInfo).join(es -> es.get1().apply(UserInfo::getUser)); // IMPLSOON 后续加入这种方式
        //        query.find(User.class).join(User::getUserInfo).joinable(es -> es.get1().join(UserInfo::getUser)); //后续加入这种方式

        //  join 关联对象返回
        List<User> userList = query.find(User.class).join(User::getUserInfo).list();
        userList = query.find(User.class).join(User::getUserInfo).fetch().list();
        // use.userInfo的属性可以作为查询条件
        User user = query.find(User.class).join(User::getUserInfo).where().eq(User::getId, 1).and()
                .eq(es -> es.get1().accept(UserInfo::getId, 1)).single();
        // 不仅use.userInfo的属性可以作为查询条件，并且返回期查询属性并映射到user.userInfo
        user = query.find(User.class).join(User::getUserInfo).fetch().where().eq(es -> es.get0().accept(User::getId, 1))
                .and().eq(es -> es.get1().accept(UserInfo::getId, 1)).single();

        //  join 关联对象返回
        //      UserInfo userInfo = query.find(UserInfo.class).join(User::getUserInfo).fetch().where().eq(UserInfo::getId, 1)
        //      .and().eq(es -> es.get1(), User::getId, 1).single();
        //      userInfo = query.find(UserInfo.class).join(User::getUserInfo).where().eq(UserInfo::getId, 1).and()
        //      .eq(es -> es.get1(), User::getId, 1).single();
        UserInfo userInfo = query.find(UserInfo.class).join(User::getUserInfo).fetch().where().eq(UserInfo::getId, 1)
                .and().eq(es -> es.get1().accept(User::getId, 1)).single();
        userInfo = query.find(UserInfo.class).join(User::getUserInfo).where().eq(UserInfo::getId, 1).and()
                .eq(es -> es.get1().accept(User::getId, 1)).single();
        userInfo = query.find(UserInfo.class).join(User::getUserInfo).where().eq(UserInfo::getId, 1).and()
                .eq2(User::getId, 1).single();
        //        Tuple2<User, Device> list2 = query.find(User.class).join(User::getUserInfo).join(User::getDevices).fetch()
        //                .join(User::getDevices).list();
        //        Tuple2<User, UserInfo, Device> list3 = query.find(User.class).join(User::getUserInfo).fetch()
        //                .join(User::getDevices).fetch().join(User::getDevices).list();

        query.find(UserInfo.class).where().property(UserInfo::getId).eq(1).list();

        query.find(UserInfo.class).join(User::getUserInfo).where().property(UserInfo::getId).eq(1).list();
        query.find(UserInfo.class).join(User::getUserInfo).where().property((e0, e1) -> e0.apply(UserInfo::getId).eq(1))
                .and().eq(UserInfo::getId, 1).list();

        query.find(User.class).join(User::getUserInfo).join2(UserInfo::getUser).where()
                .property((e0, e1, e2) -> e1.apply(UserInfo::getId).eq(1)).and().eq3(User::getId, 1).list();

        query.find(Tree.class).join(Tree::getParent).list();
        query.find(Tree.class).join(Tree::getParent).fetch().list();

        query.find(Tree.class).join(Tree::getParent).join(Tree::getParent).list();
        query.find(Tree.class).join(Tree::getParent).fetch().join(Tree::getParent).list();
        query.find(Tree.class).join(Tree::getParent).join(Tree::getParent).fetch().list();
        query.find(Tree.class).join(Tree::getParent).fetch().join(Tree::getParent).fetch().list();

        query.find(Tree.class).join(Tree::getParent).join(Tree::getParent).join(Tree::getParent).list();
        query.find(Tree.class).join(Tree::getParent).join(Tree::getParent).fetch().join(Tree::getParent).list();
        query.find(Tree.class).join(Tree::getParent).fetch().join(Tree::getParent).join(Tree::getParent).list();
        query.find(Tree.class).join(Tree::getParent).fetch().join(Tree::getParent).fetch().join(Tree::getParent).list();
        query.find(Tree.class).join(Tree::getParent).fetch().join(Tree::getParent).fetch().join(Tree::getParent).fetch()
                .list();

        //        query.find(Tree.class).join(Tree::getParent).join(es -> es.get1(), Tree::getParent); //编译报错

        query.find(Tree.class).join(Tree::getParent).fetch().join(Tree::getParent).fetch().join(Tree::getParent).fetch()
                .join(Tree::getParent).fetch().list();

        query.find(Tree.class).join(Tree::getParent).join(Tree::getParent).join(Tree::getParent).where().eq(Tree::getId,
                1);
        query.find(Tree.class).join(Tree::getParent).join(Tree::getParent).join(Tree::getParent).where()
                .eq2(Tree::getId, 1);
        query.find(Tree.class).join(Tree::getParent).join(Tree::getParent).join(Tree::getParent).where()
                .eq3(Tree::getId, 1);

        // 当多个参数为同一类型时
        query.find(Tree.class).join(Tree::getParent).join(Tree::getParent).join(Tree::getParent).where()
                .eq(es -> es.get0().accept(Tree::getId, 1));
        query.find(Tree.class).join(Tree::getParent).fetch().join(Tree::getParent).join(Tree::getParent).where()
                .eq(es -> es.get1().accept(Tree::getId, 1));
        query.find(Tree.class).join(Tree::getParent).fetch().join(Tree::getParent).fetch().join(Tree::getParent).where()
                .eq(es -> es.get2().accept(Tree::getId, 1));

        // select * from tree t1 join tree t2 on t1.id = t2.parent_id join tree t3 on t1.id = t3.parent_id
        query.find(Tree.class).join(Tree::getParent).join(Tree::getParent);

        query.find(Tree.class).join(Tree::getParent).join(Tree::getUser).join3(User::getUserInfo);

        query.find(Tree.class).join(Tree::getParent).join(Tree::getParent).join(Tree::getParent);

        // YUFEI_TODO 目前强类型关联查询先实现5级join
        //        query.find(Tree.class).join(Tree::getParent).join(Tree::getParent).join(Tree::getParent).join(Tree::getParent)
        //                .join(Tree::getParent).join(Tree::getParent).join(Tree::getParent).join(Tree::getParent)
        //                .join(Tree::getParent);

        // with join的api定义规则
        /*
         // select * from tree t1 join tree t2 on t1.id = t2.parent_id join tree t3 on t2.id = t3.parent_id
         query.find(Tree.class).join(Tree::getParent).join(t -> t.get1() , Tree::getParent);
         //  t为Tuple类型，有几个可以join的对象就是有几个对象的tuple
        //  这里表示和 tree t2 进行join，所以join tree t3 on t2.id = t3.parent_id
        // 这种实现可能会导致编译出错（例如自关联 Tree::getParent这种）
        // 所以就算实现了相应的方法，也要保留join join1 join2这种不会导致编译报错的方法实现

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
    }

    public void testEntityQueryJoin() {
        UserInfo2 ui = null;
        Tuple2<UserInfo2, User2> tupleUserInfoUser = null;
        User2 user = null;
        Tuple2<User2, UserInfo2> tupleUserUserInfo = null;
        Tree2 tree = null;
        Tuple2<Tree2, Tree2> tuple2Tree2 = null;
        Tuple3<Tree2, Tree2, Tree2> tuple3Tree2 = null;
        Tuple4<Tree2, Tree2, Tree2, Tree2> tuple4Tree2 = null;

        //  join 多对象返回
        ui = query.find(UserInfo2.class).join(UserInfo2::getUserId, User2.class).limit(1).single();
        ui = query.find(UserInfo2.class).join(UserInfo2::getUserId, User2::getId).limit(1).single();
        //        ui = query.find(UserInfo2.class).join(UserInfo2::getUserId, User2.class, User2::getId).limit(1).single();

        tupleUserInfoUser = query.find(UserInfo2.class).join(UserInfo2::getUserId, User2.class).fetch().limit(1)
                .single();
        tupleUserInfoUser = query.find(UserInfo2.class).join(UserInfo2::getUserId, User2::getId).fetch().limit(1)
                .single();

        tree = query.find(Tree2.class).join(Tree2::getParentId, Tree2.class).limit(1).single();
        tree = query.find(Tree2.class).join(Tree2::getParentId, Tree2::getId).limit(1).single();
        // 这里会调用join(SerializableFunction3<E, E> propertyName),所以需要强制类型转换
        tree = query.find(Tree2.class).join((SerializableFunction4<Tree2, Integer>) Tree2::getParentId).limit(1)
                .single();

        // 2
        tree = query.find(Tree2.class).join(Tree2::getParentId, Tree2.class).join(Tree2::getParentId, Tree2.class)
                .limit(1).single();
        tree = query.find(Tree2.class).join(Tree2::getParentId, Tree2.class).join2(Tree2::getParentId, Tree2.class)
                .limit(1).single();
        tree = query.find(Tree2.class).join(Tree2::getParentId, Tree2::getId).join(Tree2::getParentId, Tree2::getId)
                .limit(1).single();
        tree = query.find(Tree2.class).join(Tree2::getParentId, Tree2::getId).join2(Tree2::getParentId, Tree2::getId)
                .limit(1).single();
        tree = query.find(Tree2.class).join(Tree2::getParentId).join(Tree2::getParentId).limit(1).single();
        tree = query.find(Tree2.class).join(Tree2::getParentId).join2(Tree2::getParentId).limit(1).single();

        tuple2Tree2 = query.find(Tree2.class).join(Tree2::getParentId, Tree2.class).fetch().limit(1).single();
        tuple2Tree2 = query.find(Tree2.class).join(Tree2::getParentId, Tree2::getId).fetch().limit(1).single();
        // 这里会调用join(SerializableFunction3<E, E> propertyName),所以需要强制类型转换
        tuple2Tree2 = query.find(Tree2.class).join((SerializableFunction4<Tree2, Integer>) Tree2::getParentId).fetch()
                .limit(1).single();

        tuple3Tree2 = query.find(Tree2.class).join(Tree2::getParentId, Tree2.class).fetch()
                .join(Tree2::getParentId, Tree2.class).fetch().limit(1).single();
        tuple3Tree2 = query.find(Tree2.class).join(Tree2::getParentId, Tree2.class).fetch()
                .join2(Tree2::getParentId, Tree2.class).fetch().limit(1).single();
        tuple3Tree2 = query.find(Tree2.class).join(Tree2::getParentId, Tree2::getId).fetch()
                .join(Tree2::getParentId, Tree2::getId).fetch().limit(1).single();
        tuple3Tree2 = query.find(Tree2.class).join(Tree2::getParentId, Tree2::getId).fetch()
                .join2(Tree2::getParentId, Tree2::getId).fetch().limit(1).single();
        tuple3Tree2 = query.find(Tree2.class).join((SerializableFunction4<Tree2, Integer>) Tree2::getParentId).fetch()
                .join((SerializableFunction4<Tree2, Integer>) Tree2::getParentId).fetch().limit(1).single();
        tuple3Tree2 = query.find(Tree2.class).join((SerializableFunction4<Tree2, Integer>) Tree2::getParentId).fetch()
                .join2((SerializableFunction4<Tree2, Integer>) Tree2::getParentId).fetch().limit(1).single();

        // 3
        tree = query.find(Tree2.class).join(Tree2::getParentId, Tree2.class).join(Tree2::getParentId, Tree2.class)
                .join(Tree2::getParentId, Tree2.class).limit(1).single();
        tree = query.find(Tree2.class).join(Tree2::getParentId, Tree2.class).join(Tree2::getParentId, Tree2.class)
                .join2(Tree2::getParentId, Tree2.class).limit(1).single();
        tree = query.find(Tree2.class).join(Tree2::getParentId, Tree2::getId).join2(Tree2::getParentId, Tree2::getId)
                .join(Tree2::getParentId, Tree2::getId).limit(1).single();
        tree = query.find(Tree2.class).join(Tree2::getParentId, Tree2::getId).join2(Tree2::getParentId, Tree2::getId)
                .join2(Tree2::getParentId, Tree2::getId).limit(1).single();

        tree = query.find(Tree2.class).join(Tree2::getParentId).join(Tree2::getParentId).join(Tree2::getParentId)
                .limit(1).single();
        tree = query.find(Tree2.class).join(Tree2::getParentId).join2(Tree2::getParentId).join2(Tree2::getParentId)
                .limit(1).single();

        tuple4Tree2 = query.find(Tree2.class).join(Tree2::getParentId, Tree2.class).fetch()
                .join(Tree2::getParentId, Tree2.class).fetch().join(Tree2::getParentId, Tree2.class).fetch().limit(1)
                .single();
        tuple4Tree2 = query.find(Tree2.class).join(Tree2::getParentId, Tree2.class).fetch()
                .join2(Tree2::getParentId, Tree2.class).fetch().join2(Tree2::getParentId, Tree2.class).fetch().limit(1)
                .single();
        tuple4Tree2 = query.find(Tree2.class).join(Tree2::getParentId, Tree2::getId).fetch()
                .join(Tree2::getParentId, Tree2::getId).fetch().join(Tree2::getParentId, Tree2::getId).fetch().limit(1)
                .single();
        tuple4Tree2 = query.find(Tree2.class).join(Tree2::getParentId, Tree2::getId).fetch()
                .join2(Tree2::getParentId, Tree2::getId).fetch().join2(Tree2::getParentId, Tree2::getId).fetch()
                .limit(1).single();
        tuple4Tree2 = query.find(Tree2.class).join((SerializableFunction4<Tree2, Integer>) Tree2::getParentId).fetch()
                .join((SerializableFunction4<Tree2, Integer>) Tree2::getParentId).fetch()
                .join((SerializableFunction4<Tree2, Integer>) Tree2::getParentId).fetch().limit(1).single();
        tuple4Tree2 = query.find(Tree2.class).join((SerializableFunction4<Tree2, Integer>) Tree2::getParentId).fetch()
                .join2((SerializableFunction4<Tree2, Integer>) Tree2::getParentId).fetch()
                .join2((SerializableFunction4<Tree2, Integer>) Tree2::getParentId).fetch().limit(1).single();

        //        tupleTreeTree = query.find(Tree2.class).join(Tree2::getParentId, Tree2.class, Tree2::getId).fetch().limit(1).single();

        //        user = query.find(User2.class).join(UserInfo2::getUserId, User2.class).limit(1).single();
        //        user = query.find(User2.class).join(UserInfo2::getUserId, User2.class, User2::getId).limit(1).single();
        //        tupleUserUserInfo = query.find(User2.class).join(UserInfo2::getUserId, User2.class).fetch().limit(1).single();
        //        tupleUserUserInfo = query.find(User2.class).join(UserInfo2::getUserId, User2.class, User2::getId).fetch()
        //                .limit(1).single();
        user = query.find(User2.class).join(UserInfo2::getUserId).limit(1).single();
        tupleUserUserInfo = query.find(User2.class).join(User2::getId, UserInfo2::getUserId).fetch().limit(1).single();
        tupleUserUserInfo = query.find(User2.class).join(UserInfo2::getUserId).fetch().limit(1).single();

        User u = query.find(User.class).join(UserInfo::getUser).fetch().limit(1).single();

        query.find(User2.class).join(UserInfo2::getUserId).fetch().where().eq(es -> es.get0().accept(User2::getId, 1))
                .and().eq(es -> es.get1().accept(UserInfo2::getName, "yufei")).list();

        query.find(User2.class).join(UserInfo2::getUserId).fetch().where().eq((e0, e1) -> e0.accept(User2::getId, 1))
                .and().eq((e0, e1) -> e1.accept(UserInfo2::getName, "yufei")).list();

        query.find(Tree2.class).join((SerializableFunction4<Tree2, Integer>) Tree2::getParentId).fetch()
                .join2((SerializableFunction4<Tree2, Integer>) Tree2::getParentId).fetch()
                .join2((SerializableFunction4<Tree2, Integer>) Tree2::getParentId).fetch().where()
                .eq(es -> es.get0().accept(Tree2::getId, 1)).and().eq((e0, e1, e2, e3) -> e3.accept(Tree2::getId, 1))
                .list();

        query.find(User2.class).join(UserInfo2::getUserId).where().eq(User2::getId, 1).single();

        query.find(User2.class).fetch(User2::getUsername).where().eq(User2::getId, 1).string();
        // IMPLSOON join以后就没有单值返回了
        // query.find(User2.class).fetch(User2::getUsername).join(UserInfo2::getUserId).where().eq(User2::getId, 1).string();

    }

    public void testEntityQuerySort() {
        query.find(User2.class).sort().asc(User2::getAge);
        query.find(User2.class).sort().asc(User2::getAge).asc(User2::getId);
        query.find(User2.class).sort().asc(User2::getAge, User2::getId);

        query.find(User2.class).sort().desc(User2::getAge);
        query.find(User2.class).sort().desc(User2::getAge).desc(User2::getId);
        query.find(User2.class).sort().desc(User2::getAge, User2::getId);

        query.find(User2.class).join(UserInfo2::getUserId).sort().asc(es -> es.get0(), User2::getAge);
        query.find(User2.class).join(UserInfo2::getUserId).sort().asc(User2::getAge);

        query.find(User2.class).join(UserInfo2::getUserId).sort().asc(es -> es.get1(), UserInfo2::getAge);
        query.find(User2.class).join(UserInfo2::getUserId).sort().asc2(UserInfo2::getAge);

        query.find(Student2.class).join(Student2::getUserId, User.class).join2(User::getUserInfo).sort()
                .asc(Student2::getId).asc(qs -> qs.get1(), User::getAge);
        query.find(Student2.class).join(Student2::getUserId, User.class).join2(User::getUserInfo).sort()
                .asc(Student2::getId).asc2(User::getAge);

        //                query.find(User.class).join(Student2::getUserId).fetch().join2(User::getUserInfo).fetch().list();

        query.find(Student2.class).join(Student2::getUserId, User.class).join2(User::getUserInfo).sort()
                .asc(Student2::getId).asc(qs -> qs.get2(), UserInfo::getAge);
        query.find(Student2.class).join(Student2::getUserId, User.class).fetch().join2(User::getUserInfo).fetch().sort()
                .asc(Student2::getId).asc(qs -> qs.get2(), UserInfo::getAge);
        query.find(Student2.class).join(Student2::getUserId, User.class).join2(User::getUserInfo).sort()
                .asc(Student2::getId).asc3(UserInfo::getAge);
        query.find(Student2.class).join(Student2::getUserId, User.class).fetch().join2(User::getUserInfo).fetch().sort()
                .asc(Student2::getId).asc3(UserInfo::getAge);

        query.find(Student2.class).join(Student2::getUserId, User.class).join2(User::getUserInfo).sort()
                .asc(qs -> qs.get2(), UserInfo::getAge).asc(Student2::getId);
        query.find(Student2.class).join(Student2::getUserId, User.class).join2(User::getUserInfo).sort()
                .asc3(UserInfo::getAge).asc(Student2::getId);

        query.find(Student2.class).join(Student2::getUserId, User.class).join2(User::getUserInfo).sort()
                .asc(qs -> qs.get2(), UserInfo::getAge, UserInfo::getName).asc(Student2::getId);

        query.find(Student2.class).join(Student2::getUserId, User.class).sort().asc(qs -> qs.get1(), User::getId)
                .asc((e0, e1) -> e0.accept(Student2::getId).accept(Student2::getName, Student2::getTeacherId))
                .desc((e0, e1) -> e0.accept(Student2::getId).accept(Student2::getName, Student2::getTeacherId))
                .asc2(User::getUsername);

        query.find(Tree.class).join(Tree::getParent).join(Tree::getParent).join(Tree::getParent).join(Tree::getParent)
                .sort().asc((e0, e1, e2, e3, e4) -> e0.accept(Tree::getId)).asc5(Tree::getName);

        // IMPLSOON 目前join只能join4次，第五次的接口还未加入join方法
        //        query.find(Tree.class).join(Tree::getParent).join(Tree::getParent).join(Tree::getParent).join(Tree::getParent)
        //                .join(Tree::getParent).sort().asc((e0, e1, e2, e3, e4) -> e0.accept(Tree::getId)).asc5(Tree::getName);
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

        updater.update(r).set(() -> name.equals("yufei"), "name", name);
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
        });

        updater.update(User.class).set(() -> name.equals("yufei"), User::getUsername, name);
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

        deleter.delete(User.class).where().eq(User::getId, 18).execute();
        deleter.delete(User.class).where().property(User::getId).eq(18).execute();

    }

    //    void testJoinApiStyle() {
    //        Tuple2<Function<SerializableFunction<User, String>, SerializableFunction<User, String>>,
    //                Function<SerializableFunction<User, Integer>, SerializableFunction<User, Integer>>> tuple2;
    //        tuple2.get0().apply(User::getUsername);
    //
    //        Tuple2<Consumer<SerializableFunction<User, ?>>, Consumer<SerializableFunction<UserInfo, ?>>> t2;
    //        t2.get0().accept(User::getUserInfo);
    //
    //        Function<Tuple2<Consumer<SerializableFunction<User, ?>>, Consumer<SerializableFunction<UserInfo, ?>>>,
    //                SerializableFunction<User, ?>> t21 = es -> es.get0().accept(User::getUserInfo);
    //
    //        Function<Tuple2<Consumer<SerializableFunction<User, ?>>, Consumer<SerializableFunction<UserInfo, ?>>>,
    //                SerializableFunction<UserInfo, ?>> t22;
    //
    //        Function<
    //                Tuple2<Function<SerializableFunction<User, ?>, SerializableFunction<User, ?>>,
    //                        Function<SerializableFunction<UserInfo, ?>, SerializableFunction<UserInfo, ?>>>,
    //                SerializableFunction<User, ?>> f21 = es -> es.get0().apply(User::getUserInfo);
    //
    //        Function<
    //                Tuple2<Function<SerializableFunction<User, ?>, SerializableFunction<User, ?>>,
    //                        Function<SerializableFunction<UserInfo, ?>, SerializableFunction<UserInfo, ?>>>,
    //                SerializableFunction<UserInfo, ?>> f22 = es -> es.get1().apply(UserInfo::getUser);
    //        f22.apply(Tuples.of(null, null));
    //
    //        Function<
    //                Tuple2<Function<SerializableFunction<User, ?>, QueryEntityRepository<User>>,
    //                        Function<SerializableFunction<UserInfo, ?>, QueryEntityRepository<UserInfo>>>,
    //                QueryEntityRepository<User>> f31 = es -> es.get0().apply(User::getUserInfo);
    //        f31.apply(Tuples.of(null, null)).getType();
    //
    //        Function<
    //                Tuple2<Function<SerializableFunction<User, ?>, QueryEntityRepository<User>>,
    //                        Function<SerializableFunction<UserInfo, ?>, QueryEntityRepository<UserInfo>>>,
    //                QueryEntityRepository<UserInfo>> f32 = es -> es.get1().apply(UserInfo::getUser);
    //        f32.apply(Tuples.of(null, null)).getType();
    //
    //        Function<
    //                Tuple2<Function<SerializableFunction<User, ?>, QueryEntityRepository<User>>,
    //                        Function<SerializableFunction<UserInfo, ?>, QueryEntityRepository<UserInfo>>>,
    //                Tuple2<SerializableFunction<User, ?>, QueryEntityRepository<User>>> f41 = es -> Tuples
    //                        .of(User::getUserInfo, es.get0().apply(User::getUserInfo));
    //        f41.apply(Tuples.of(null, null));
    //
    //        Function<
    //                Tuple2<Function<SerializableFunction<User, ?>, QueryEntityRepository<User>>,
    //                        Function<SerializableFunction<UserInfo, ?>, QueryEntityRepository<UserInfo>>>,
    //                Tuple2<SerializableFunction<User, ?>,
    //                        QueryEntityRepository<UserInfo>>> f42 = es -> es.get1().apply(UserInfo::getUser);
    //
    //        Function<Tuple2<QueryEntityRepository<User>, QueryEntityRepository<UserInfo>>,
    //                QueryEntityRepository<User>> qs1 = es -> es.get0();
    //        Function<Tuple2<QueryEntityRepository<User>, QueryEntityRepository<UserInfo>>,
    //                QueryEntityRepository<UserInfo>> qs2 = es -> es.get1();
    //        qs1.apply(Tuples.of(null, null));
    //    }

    //    void testJoinApiStyle2() {
    //        join(qs -> qs.get0(), User::getUserInfo);
    //        //        join(qs -> qs.get0(), UserInfo::getUser); // 必须强制类型转换
    //        join(qs -> qs.get0(), (SerializableFunction2<UserInfo, User>) UserInfo::getUser);
    //        //        join(qs -> qs.get1(), UserInfo::getUser); // 必须强制类型转换
    //        join(qs -> qs.get1(), (SerializableFunction4<UserInfo, User>) UserInfo::getUser);
    //
    //        join((Function1<
    //                Tuple2<Function<SerializableFunction<User, UserInfo>,
    //                        Tuple2<SerializableFunction<User, UserInfo>, QueryEntityRepository<User>>>,
    //                        Function<SerializableFunction<UserInfo, UserInfo>,
    //                                Tuple2<SerializableFunction<UserInfo, UserInfo>, QueryEntityRepository<UserInfo>>>>,
    //                Tuple2<SerializableFunction<User, UserInfo>, QueryEntityRepository<User>>>) es -> es.get0()
    //                        .apply(User::getUserInfo));
    //
    //        join((Function4<
    //                Tuple2<Function<SerializableFunction<User, User>,
    //                        Tuple2<SerializableFunction<User, User>, QueryEntityRepository<User>>>,
    //                        Function<SerializableFunction<UserInfo, User>,
    //                                Tuple2<SerializableFunction<UserInfo, User>, QueryEntityRepository<UserInfo>>>>,
    //                Tuple2<SerializableFunction<UserInfo, User>, QueryEntityRepository<UserInfo>>>) es -> es.get1()
    //                        .apply(UserInfo::getUser));
    //
    //    }

    void t() {
        EntityPropertyExpression<User, EntityQueryConditionGroup<User>, EntityQueryConditionGroupLogic<User>> pe = null;
        pe.property(User::getId).gt(1).and().property(User::getAge).eq(1).and().property(User::getUsername).co("yi");

        EntityPropertyExpression2<User, UserInfo, EntityQueryConditionGroup2<User, UserInfo, User>,
                EntityQueryConditionGroupLogic2<User, UserInfo, User>> pe2 = null;
        pe.property(User::getId).gt(1).and().property(User::getAge).eq(1).and().property(User::getUsername).co("yi");
    }

    /*
    // 编译报错
    void join(Function<
            Tuple2<Function<SerializableFunction<User, ?>, QueryEntityRepository<User>>,
                    Function<SerializableFunction<UserInfo, ?>, QueryEntityRepository<UserInfo>>>,
            QueryEntityRepository<User>> join) {
    
    }
    void join(Function<
            Tuple2<Function<SerializableFunction<User, ?>, QueryEntityRepository<User>>,
                    Function<SerializableFunction<UserInfo, ?>, QueryEntityRepository<UserInfo>>>,
            QueryEntityRepository<UserInfo>> join) {
    }*/

    //    <R> void join(Function<Tuple2<QueryEntityRepository<User>, QueryEntityRepository<UserInfo>>,
    //            QueryEntityRepository<User>> qs, SerializableFunction1<User, R> property) {
    //        System.out.println("join User UserInfo <User,R> -> User");
    //        QueryEntityRepository<User> qer = qs.apply(Tuples.of(null, null));
    //    }
    //
    //    <R> void join(Function<Tuple2<QueryEntityRepository<User>, QueryEntityRepository<UserInfo>>,
    //            QueryEntityRepository<User>> qs, SerializableFunction2<R, User> property) {
    //        System.out.println("join User UserInfo <R, User> -> User");
    //        QueryEntityRepository<User> qer = qs.apply(Tuples.of(null, null));
    //    }
    //
    //    <R> void join(Function<Tuple2<QueryEntityRepository<User>, QueryEntityRepository<UserInfo>>,
    //            QueryEntityRepository<UserInfo>> qs, SerializableFunction4<UserInfo, R> property) {
    //        System.out.println("join User UserInfo <UserInfo,R> -> UserInfo");
    //        QueryEntityRepository<UserInfo> qer = qs.apply(Tuples.of(null, null));
    //    }
    //
    //    <R> void relate(Function1<Tuple2<
    //            Function<SerializableFunction<User, R>, Tuple2<SerializableFunction<User, R>, QueryEntityRepository<User>>>,
    //            Function<SerializableFunction<UserInfo, R>,
    //                    Tuple2<SerializableFunction<UserInfo, R>, QueryEntityRepository<UserInfo>>>>,
    //            Tuple2<SerializableFunction<User, R>, QueryEntityRepository<User>>> join) {
    //        System.out.println("relate User UserInfo <User,R> -> User");
    //        Tuple2<SerializableFunction<User, R>,
    //                QueryEntityRepository<User>> t = join.apply(Tuples.of(f -> null, t2 -> null));
    //        //        LambdaUtils.getLambdaInfo(t.getType());
    //    }
    //
    //    <R> void relate(Function2<
    //            Tuple2<Function<SerializableFunction<R, User>, QueryEntityRepository<User>>,
    //                    Function<SerializableFunction<R, UserInfo>, QueryEntityRepository<UserInfo>>>,
    //            QueryEntityRepository<User>> join) {
    //        System.out.println("relate User UserInfo <R,User> -> User");
    //        QueryEntityRepository<User> t = join.apply(Tuples.of(f -> null, t2 -> null));
    //        //        LambdaUtils.getLambdaInfo(t.getType());
    //    }
    //
    //    <R> void relate(Function4<
    //            Tuple2<Function<SerializableFunction<User, R>, QueryEntityRepository<User>>,
    //                    Function<SerializableFunction<UserInfo, R>, QueryEntityRepository<UserInfo>>>,
    //            QueryEntityRepository<UserInfo>> join) {
    //        System.out.println("relate User UserInfo <UserInfo,R> -> UserInfo");
    //
    //        QueryEntityRepository<UserInfo> t = join.apply(Tuples.of(f -> null, t2 -> null));
    //        //        LambdaUtils.getLambdaInfo(t.get0());
    //    }

    //    <R> void join(Function1<Tuple2<
    //            Function<SerializableFunction<User, R>, Tuple2<SerializableFunction<User, R>, QueryEntityRepository<User>>>,
    //            Function<SerializableFunction<UserInfo, R>,
    //                    Tuple2<SerializableFunction<UserInfo, R>, QueryEntityRepository<UserInfo>>>>,
    //            Tuple2<SerializableFunction<User, R>, QueryEntityRepository<User>>> join) {
    //        System.out.println("join User UserInfo <User,R> -> User");
    //        Tuple2<SerializableFunction<User, R>,
    //                QueryEntityRepository<User>> t = join.apply(Tuples.of(f -> null, t2 -> null));
    //        LambdaUtils.getLambdaInfo(t.get0());
    //        //        t.get1().getType();
    //    }
    //
    //    <R> void join(Function2<Tuple2<
    //            Function<SerializableFunction<R, User>, Tuple2<SerializableFunction<R, User>, QueryEntityRepository<User>>>,
    //            Function<SerializableFunction<R, UserInfo>,
    //                    Tuple2<SerializableFunction<R, UserInfo>, QueryEntityRepository<UserInfo>>>>,
    //            Tuple2<SerializableFunction<R, User>, QueryEntityRepository<User>>> join) {
    //        System.out.println("join User UserInfo <R,User> -> User");
    //        Tuple2<SerializableFunction<R, User>,
    //                QueryEntityRepository<User>> t = join.apply(Tuples.of(f -> null, t2 -> null));
    //        LambdaUtils.getLambdaInfo(t.get0());
    //    }
    //
    //    <R> void join(Function3<
    //            Tuple2<Function<SerializableFunction<User, User>,
    //                    Tuple2<SerializableFunction<User, User>, QueryEntityRepository<User>>>,
    //                    Function<SerializableFunction<UserInfo, UserInfo>, QueryEntityRepository<UserInfo>>>,
    //            Tuple2<SerializableFunction<User, User>, QueryEntityRepository<User>>> join) {
    //        System.out.println("join User UserInfo <User,User>-> User");
    //        Tuple2<SerializableFunction<User, User>,
    //                QueryEntityRepository<User>> t = join.apply(Tuples.of(f -> null, t2 -> null));
    //        LambdaUtils.getLambdaInfo(t.get0());
    //    }
    //
    //    <R> void join(Function4<Tuple2<
    //            Function<SerializableFunction<User, R>, Tuple2<SerializableFunction<User, R>, QueryEntityRepository<User>>>,
    //            Function<SerializableFunction<UserInfo, R>,
    //                    Tuple2<SerializableFunction<UserInfo, R>, QueryEntityRepository<UserInfo>>>>,
    //            Tuple2<SerializableFunction<UserInfo, R>, QueryEntityRepository<UserInfo>>> join) {
    //        System.out.println("join User UserInfo <UserInfo,R> -> UserInfo");
    //        Tuple2<SerializableFunction<UserInfo, R>,
    //                QueryEntityRepository<UserInfo>> t = join.apply(Tuples.of(f -> null, t2 -> null));
    //        LambdaUtils.getLambdaInfo(t.get0());
    //    }
    //
    //    <R> void join(Function5<Tuple2<
    //            Function<SerializableFunction<R, User>, Tuple2<SerializableFunction<R, User>, QueryEntityRepository<User>>>,
    //            Function<SerializableFunction<R, UserInfo>,
    //                    Tuple2<SerializableFunction<R, UserInfo>, QueryEntityRepository<UserInfo>>>>,
    //            Tuple2<SerializableFunction<R, UserInfo>, QueryEntityRepository<UserInfo>>> join) {
    //        System.out.println("join User UserInfo <R,UserInfo> -> UserInfo");
    //        Tuple2<SerializableFunction<R, UserInfo>,
    //                QueryEntityRepository<UserInfo>> t = join.apply(Tuples.of(f -> null, t2 -> null));
    //        LambdaUtils.getLambdaInfo(t.get0());
    //    }
    //
    //    <R> void join(Function6<
    //            Tuple2<Function<SerializableFunction<User, User>,
    //                    Tuple2<SerializableFunction<User, User>, QueryEntityRepository<User>>>,
    //                    Function<SerializableFunction<UserInfo, UserInfo>,
    //                            Tuple2<SerializableFunction<UserInfo, UserInfo>, QueryEntityRepository<UserInfo>>>>,
    //            Tuple2<SerializableFunction<UserInfo, UserInfo>, QueryEntityRepository<UserInfo>>> join) {
    //        System.out.println("join User UserInfo <UserInfo,UserInfo>-> UserInfo");
    //        Tuple2<SerializableFunction<UserInfo, UserInfo>,
    //                QueryEntityRepository<UserInfo>> t = join.apply(Tuples.of(f -> null, t2 -> null));
    //        LambdaUtils.getLambdaInfo(t.get0());
    //    }
}
