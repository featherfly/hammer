
package cn.featherfly.hammer.dml.builder.sql;

import java.util.List;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuple3;
import com.speedment.common.tuple.Tuple4;

import cn.featherfly.common.function.serializable.SerializableFunction2;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.dml.builder.sql.vo.Device;
import cn.featherfly.hammer.dml.builder.sql.vo.Tree;
import cn.featherfly.hammer.dml.builder.sql.vo.Tree2;
import cn.featherfly.hammer.dml.builder.sql.vo.User;
import cn.featherfly.hammer.dml.builder.sql.vo.User2;
import cn.featherfly.hammer.dml.builder.sql.vo.UserInfo;
import cn.featherfly.hammer.dml.builder.sql.vo.UserInfo2;
import cn.featherfly.hammer.dsl.execute.Deleter;
import cn.featherfly.hammer.dsl.query.Query;

/**
 * dsl api invoke test
 *
 * @author zhongj
 */
public class DslEntityJoinTest {

    Query query = null;

    Deleter deleter = null;

    Repository data = null;

    boolean ignore = true;

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

        //        TODO 暂时先取消了join()多条件的重载方法
        //        query.find(User.class).join(User::getUserInfo).join(es -> es.get1(),
        //                (SerializableFunction4<UserInfo, User>) UserInfo::getUser); // 编译无法确定参数，需要使用强制类型转换
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
        Tuple2<UserInfo, User> tuple2 = query.find(UserInfo.class).join(User::getUserInfo).fetch().where()
            .eq(UserInfo::getId, 1).and().eq(es -> es.get1().accept(User::getId, 1)).single();
        UserInfo userInfo = query.find(UserInfo.class).join(User::getUserInfo).where().eq(UserInfo::getId, 1).and()
            .eq(es -> es.get1().accept(User::getId, 1)).single();
        userInfo = query.find(UserInfo.class).join(User::getUserInfo).where().eq(UserInfo::getId, 1).and()
            .eq2(User::getId, 1).single();
        //        Tuple2<User, Device> list2 = query.find(User.class).join(User::getUserInfo).join(User::getDevices).fetch()
        //                .join(User::getDevices).list();
        //        Tuple2<User, UserInfo, Device> list3 = query.find(User.class).join(User::getUserInfo).fetch()
        //                .join(User::getDevices).fetch().join(User::getDevices).list();

        query.find(UserInfo.class).where().property(UserInfo::getId).eq(1).list();

        query.find(UserInfo.class).join(User::getUserInfo).where().property(UserInfo::getId).eq(1).list();

        query.find(UserInfo.class).join(User::getUserInfo).where( //
            (e0, e1) -> e0.property(UserInfo::getId).eq(1) //
                .and().property(UserInfo::getId).eq(1) //
                .and(e1.property(User::getAge).ba(5, 20)) //
        ).list();
        query.find(UserInfo.class).join(User::getUserInfo).where( //
            (e0, e1) -> e0.property(UserInfo::getId).eq(1) //
                .and().eq(UserInfo::getId, 1) //
                .and(e1.property(User::getAge).ba(5, 20)) //
        ).list();
        query.find(UserInfo.class).join(User::getUserInfo).where( //
            (e0, e1) -> e0.property(UserInfo::getId).eq(1) //
                .and(e0.property(UserInfo::getId).eq(1)) //
                .and(e1.property(User::getAge).ba(5, 20)) //
        ).list();

        //        query.find(UserInfo.class).join(User::getUserInfo).where( //
        //                (e0, e1) -> e0.property(UserInfo::getId).eq(1) //
        //                        .and().property(UserInfo::getId).eq(1) //
        //                        .and().ba2(User::getAge, 5, 20) // 此API不再有效
        //        ).list();

        query.find(UserInfo.class).join(User::getUserInfo).where( //
            (e0, e1) -> e0.property(UserInfo::getId).eq(1) //
                .and(e1.property(User::getAge).ba(5, 20))) //
            .and().eq(UserInfo::getId, 1) //
            .list();

        query.find(UserInfo.class).join(User::getUserInfo).where() //
            .property((e0, e1) -> e0.property(UserInfo::getId).eq(1) //
                .and(e1.property(User::getAge).ba(5, 20))) //
            .and().eq(UserInfo::getId, 1) //
            .list();
        query.find(UserInfo.class).join(User::getUserInfo).where() //
            .eq(UserInfo::getId, 1) //
            .and().ba2(User::getAge, 5, 20) //
            .and().eq(UserInfo::getId, 1) //
            .list();

        query.find(UserInfo.class).join(User::getUserInfo).where() //
            .property((e0, e1) -> e0.property(UserInfo::getId).eq(1).and().property(UserInfo::getName).eq("userInfo")) //
            // YUFEI_TODO 后续加入实体编译期 逻辑织入，类似lombok，像下面这样
            // .property((e0, e1) -> e0.id.eq(1).and().username.eq("userInfo"))
            .and().eq(UserInfo::getId, 1).list();

        query.find(User.class).join(User::getUserInfo).join2(UserInfo::getUser).where()
            .property((e0, e1, e2) -> e1.property(UserInfo::getId).eq(1)).and().eq3(User::getId, 1).list();

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

        // 目前强类型关联查询先实现5级join
        query.find(Tree.class).join(Tree::getParent).join(Tree::getParent).join(Tree::getParent).join(Tree::getParent)
            //                .join(Tree::getParent).join(Tree::getParent).join(Tree::getParent).join(Tree::getParent)
            .join(Tree::getParent);

        // with join的api定义规则
        /*
         // select * from tree t1 join tree t2 on t1.id = t2.parent_id join tree t3 on t2.id = t3.parent_id
         query.find(Tree.class).join(Tree::getParent).join(t -> t.get1() , Tree::getParent);
         //  t为Tuple类型，有几个可以join的对象就是有几个对象的tuple
        //  这里表示和 tree t2 进行join，所以join tree t3 on t2.id = t3.parent_id
        // 这种实现可能会导致编译出错（例如自关联 Tree::getParent这种）
        // 所以就算实现了相应的方法，也要保留join join1 join2这种不会导致编译报错的方法实现
        
        // join的api定义规则，此方案应该是不能实现，因为传入参数无法区分，所以返回参数也无法确定
        /*
         // select * from tree t1 join tree t2 on t1.id = t2.parent_id join tree t3 on t2.id = t3.parent_id
         query.find(Tree.class).join(Tree::getParent).join(es -> {
             //  t为Tuple类型，有几个可以join的对象就是有几个对象的tuple
             //  这里表示和 tree t2 进行join，所以join tree t3 on t2.id = t3.parent_id
             es.get1().join(Tree::getParent);
         });
        
         // 可以先实现下面这种方式，因为这种方式不需要多个返回结果类型，在现有结构上就能实现，废案
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

        // join on
        user = query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId).limit(1).single();
        tupleUserUserInfo = query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId).fetch().limit(1)
            .single();

        //  join 多对象返回
        ui = query.find(UserInfo2.class).join(User2.class).on(UserInfo2::getUserId).limit(1).single();
        ui = query.find(UserInfo2.class).join(User2.class).on(UserInfo2::getUserId, User2::getId).limit(1).single();
        //        ui = query.find(UserInfo2.class).join(UserInfo2::getUserId, User2.class, User2::getId).limit(1).single();

        tupleUserInfoUser = query.find(UserInfo2.class).join(User2.class).on(UserInfo2::getUserId).fetch().limit(1)
            .single();
        tupleUserInfoUser = query.find(UserInfo2.class).join(User2.class).on(UserInfo2::getUserId, User2::getId).fetch()
            .limit(1).single();

        tree = query.find(Tree2.class).join(Tree2.class).on(Tree2::getId, Tree2::getParentId).limit(1).single();
        tree = query.find(Tree2.class).join(Tree2.class).on(Tree2::getParentId, Tree2::getId).limit(1).single();
        // 这里会调用join(SerializableUnaryOperator1<E> propertyName),所以需要强制类型转换
        //        tree = query.find(Tree2.class).join(Tree2.class).on(Tree2::getId,Tree2::getParentId).limit(1)
        //                .single();

        // 2
        tree = query.find(Tree2.class).join(Tree2.class).on(Tree2::getId, Tree2::getParentId).join(Tree2.class)
            .on(Tree2::getId, Tree2::getParentId).limit(1).single();
        tree = query.find(Tree2.class).join(Tree2.class).on(Tree2::getId, Tree2::getParentId).join2(Tree2.class)
            .on(Tree2::getId, Tree2::getParentId).limit(1).single();
        tree = query.find(Tree2.class).join(Tree2.class).on(Tree2::getId, Tree2::getParentId).join2(Tree2.class)
            .on(Tree2::getId, Tree2::getParentId).limit(1).single();
        tree = query.find(Tree2.class).join(Tree2.class).on(Tree2::getId, Tree2::getParentId).join(Tree2.class)
            .on(Tree2::getParentId, Tree2::getId).limit(1).single();
        tree = query.find(Tree2.class).join(Tree2.class).on(Tree2::getId, Tree2::getParentId).join(Tree2.class)
            .on((SerializableFunction2<Tree2, Integer>) Tree2::getParentId).limit(1).single();
        tree = query.find(Tree2.class).join(Tree2.class).on(Tree2::getId, Tree2::getParentId).join2(Tree2.class)
            .on((SerializableFunction2<Tree2, Integer>) Tree2::getParentId).limit(1).single();

        tuple2Tree2 = query.find(Tree2.class).join(Tree2.class).on(Tree2::getId, Tree2::getParentId).fetch().limit(1)
            .single();
        tuple2Tree2 = query.find(Tree2.class).join(Tree2.class).on(Tree2::getId, Tree2::getParentId).fetch().limit(1)
            .single();
        // 这里会调用join(SerializableUnaryOperator1<E> propertyName),所以需要强制类型转换
        tuple2Tree2 = query.find(Tree2.class).join(Tree2.class).on(Tree2::getId, Tree2::getParentId).fetch().limit(1)
            .single();

        tuple3Tree2 = query.find(Tree2.class).join(Tree2.class).on(Tree2::getId, Tree2::getParentId).fetch()
            .join(Tree2.class).on(Tree2::getId, Tree2::getParentId).fetch().limit(1).single();
        tuple3Tree2 = query.find(Tree2.class).join(Tree2.class).on(Tree2::getId, Tree2::getParentId).fetch()
            .join(Tree2.class).on(Tree2::getId, Tree2::getParentId).fetch().limit(1).single();
        tuple3Tree2 = query.find(Tree2.class).join(Tree2.class).on(Tree2::getId, Tree2::getParentId).fetch()
            .join2(Tree2.class).on(Tree2::getId, Tree2::getParentId).fetch().limit(1).single();
        tuple3Tree2 = query.find(Tree2.class).join(Tree2.class).on(Tree2::getId, Tree2::getParentId).fetch()
            .join(Tree2.class).on(Tree2::getParentId, Tree2::getId).fetch().limit(1).single();
        tuple3Tree2 = query.find(Tree2.class).join(Tree2.class).on(Tree2::getId, Tree2::getParentId).fetch()
            .join(Tree2.class).on((SerializableFunction2<Tree2, Integer>) Tree2::getParentId).fetch().limit(1).single();
        tuple3Tree2 = query.find(Tree2.class).join(Tree2.class).on(Tree2::getId, Tree2::getParentId).fetch()
            .join2(Tree2.class).on((SerializableFunction2<Tree2, Integer>) Tree2::getParentId).fetch().limit(1)
            .single();

        // 3
        tree = query.find(Tree2.class).join(Tree2.class).on(Tree2::getId, Tree2::getParentId).join(Tree2.class)
            .on(Tree2::getId, Tree2::getParentId).join(Tree2.class).on(Tree2::getId, Tree2::getParentId).limit(1)
            .single();
        tree = query.find(Tree2.class).join(Tree2.class).on(Tree2::getId, Tree2::getParentId).join(Tree2.class)
            .on(Tree2::getId, Tree2::getParentId).join(Tree2.class).on(Tree2::getId, Tree2::getParentId).limit(1)
            .single();
        tree = query.find(Tree2.class).join(Tree2.class).on(Tree2::getId, Tree2::getParentId).join(Tree2.class)
            .on(Tree2::getParentId, Tree2::getId).join2(Tree2.class).on(Tree2::getId, Tree2::getParentId).limit(1)
            .single();
        tree = query.find(Tree2.class).join(Tree2.class).on(Tree2::getId, Tree2::getParentId).join(Tree2.class)
            .on(Tree2::getParentId, Tree2::getId).join(Tree2.class).on(Tree2::getParentId, Tree2::getId).limit(1)
            .single();

        tree = query.find(Tree2.class) //
            .join(Tree2.class).on(Tree2::getId, Tree2::getParentId) //
            .join(Tree2.class).on((SerializableFunction2<Tree2, Integer>) Tree2::getParentId) //
            .join(Tree2.class).on((SerializableFunction2<Tree2, Integer>) Tree2::getParentId) //
            .limit(1).single();
        tree = query.find(Tree2.class)//
            .join(Tree2.class).on(Tree2::getId, Tree2::getParentId)//
            .join2(Tree2.class).on((SerializableFunction2<Tree2, Integer>) Tree2::getParentId) //
            .join2(Tree2.class).on((SerializableFunction2<Tree2, Integer>) Tree2::getParentId) //
            .limit(1).single();

        tuple4Tree2 = query.find(Tree2.class).join(Tree2.class).on(Tree2::getId, Tree2::getParentId).fetch()
            .join(Tree2.class).on(Tree2::getId, Tree2::getParentId).fetch().join(Tree2.class)
            .on(Tree2::getId, Tree2::getParentId).fetch().limit(1).single();
        tuple4Tree2 = query.find(Tree2.class).join(Tree2.class).on(Tree2::getId, Tree2::getParentId).fetch()
            .join(Tree2.class).on(Tree2::getId, Tree2::getParentId).fetch().join(Tree2.class)
            .on(Tree2::getId, Tree2::getParentId).fetch().limit(1).single();
        tuple4Tree2 = query.find(Tree2.class).join(Tree2.class).on(Tree2::getId, Tree2::getParentId).fetch()
            .join2(Tree2.class).on(Tree2::getId, Tree2::getParentId).fetch().join2(Tree2.class)
            .on(Tree2::getId, Tree2::getParentId).fetch().limit(1).single();
        tuple4Tree2 = query.find(Tree2.class).join(Tree2.class).on(Tree2::getId, Tree2::getParentId).fetch()
            .join(Tree2.class).on(Tree2::getParentId, Tree2::getId).fetch().join(Tree2.class)
            .on(Tree2::getParentId, Tree2::getId).fetch().limit(1).single();
        tuple4Tree2 = query.find(Tree2.class) //
            .join(Tree2.class).on(Tree2::getId, Tree2::getParentId).fetch() //
            .join(Tree2.class).on((SerializableFunction2<Tree2, Integer>) Tree2::getParentId).fetch() //
            .join(Tree2.class).on((SerializableFunction2<Tree2, Integer>) Tree2::getParentId).fetch() //
            .limit(1).single();
        tuple4Tree2 = query.find(Tree2.class) //
            .join(Tree2.class).on(Tree2::getId, Tree2::getParentId).fetch() //
            .join2(Tree2.class).on((SerializableFunction2<Tree2, Integer>) Tree2::getParentId).fetch() //
            .join2(Tree2.class).on((SerializableFunction2<Tree2, Integer>) Tree2::getParentId).fetch() //
            .limit(1).single();

        //        tupleTreeTree = query.find(Tree2.class).join(Tree2::getParentId, Tree2.class, Tree2::getId).fetch().limit(1).single();

        //        user = query.find(User2.class).join(UserInfo2::getUserId, User2.class).limit(1).single();
        //        user = query.find(User2.class).join(UserInfo2::getUserId, User2.class, User2::getId).limit(1).single();
        //        tupleUserUserInfo = query.find(User2.class).join(UserInfo2::getUserId, User2.class).fetch().limit(1).single();
        //        tupleUserUserInfo = query.find(User2.class).join(UserInfo2::getUserId, User2.class, User2::getId).fetch()
        //                .limit(1).single();
        user = query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId).limit(1).single();
        tupleUserUserInfo = query.find(User2.class) //
            .join(UserInfo2.class).on(User2::getId, UserInfo2::getUserId).fetch() //
            .limit(1).single();
        tupleUserUserInfo = query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId).fetch().limit(1)
            .single();

        Tuple2<User, UserInfo> tuple2 = query.find(User.class).join(UserInfo::getUser).fetch().limit(1).single();

        query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId).fetch().where()
            .eq(es -> es.get0().accept(User2::getId, 1)).and().eq(es -> es.get1().accept(UserInfo2::getName, "yufei"))
            .list();

        query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId).fetch().where()
            .eq((e0, e1) -> e0.accept(User2::getId, 1)).and().eq((e0, e1) -> e1.accept(UserInfo2::getName, "yufei"))
            .list();

        query.find(Tree2.class) //
            .join(Tree2.class).on(Tree2::getId, Tree2::getParentId).fetch() //
            .join2(Tree2.class).on((SerializableFunction2<Tree2, Integer>) Tree2::getParentId).fetch() //
            .join2(Tree2.class).on((SerializableFunction2<Tree2, Integer>) Tree2::getParentId).fetch() //
            .where() //
            .eq(es -> es.get0().accept(Tree2::getId, 1)) //
            .and() //
            .eq((e0, e1, e2, e3) -> e3.accept(Tree2::getId, 1)) //
            .list();

        query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId).where().eq(User2::getId, 1).single();

        String username = query.find(User2.class).fetch(User2::getUsername).where().eq(User2::getId, 1).value();

        // 多查询对象，使用property IMPLSOON 未实现
        ui = query.find(UserInfo2.class).join(User2.class).on(UserInfo2::getUserId, User2::getId).where()
            .eq((e1, e2) -> e1.property(UserInfo2::getName).value("name")).single();

        // IMPLSOON join以后就没有单值返回了
        // query.find(User2.class).fetch(User2::getUsername).join(UserInfo2::getUserId).where().eq(User2::getId, 1).string();

        // TODO 后续实现on的其他条件判断（如a<>b, a<b and c>d）
        //        tree = query.find(Tree2.class).join(Tree2.class).on(Tree2::getId,  Tree2::getParentId)

        // TODO 后续把join(Class).on()的api定义修改为
        //        on((j, e1, e2, e3) -> j.property("user").eq(e3.property("id")));
        //        on((j, es) -> j.property("user").eq(es.get2().property("id")));
    }

    public void testEntityQueryJoin2() {

        query.find(UserInfo.class) //
            .join(UserInfo::getUser) //
            .where() //
            .ba((e0, e1) -> e1.accept(User::getAge, 18, 22)) //
            .and() //
            .ba((e0, e1) -> e1.property(User::getAge).value(18, 22)) //
            .and() //
            .ba((e0, e1) -> e0.property(UserInfo::getUser).accept(User::getAge, 18, 22)) //
            //                .and() //
            //                .ba((e0, e1) -> e0.property(UserInfo::getUser).value(18, 22)) //
            .and() //
            .ba((e0, e1) -> e0.property(UserInfo::getUser).property(User::getAge).value(18, 22)) //
            .list();

        query.find(UserInfo.class) //
            .join(UserInfo::getUser) //
            .where() //
            .nba((e0, e1) -> e1.accept(User::getAge, 18, 22)) //
            .and() //
            .nba((e0, e1) -> e1.property(User::getAge).value(18, 22)) //
            .and() //
            .nba((e0, e1) -> e0.property(UserInfo::getUser).accept(User::getAge, 18, 22)) //
            .and() //
            .nba((e0, e1) -> e0.property(UserInfo::getUser).property(User::getAge).value(18, 22)) //
            .list();

        query.find(UserInfo.class).join(UserInfo::getUser).where() //
            .ge((e0, e1) -> e1.accept(User::getAge, 18)) //
            .and() //
            .ge((e0, e1) -> e1.property(User::getAge).value(18)) //
            .and() //
            .ge((e0, e1) -> e0.property(UserInfo::getUser).accept(User::getAge, 18)) //
            //                .and() //
            //                .ge((e0, e1) -> e0.property(UserInfo::getUser).value(18)) //
            .and() //
            .ge((e0, e1) -> e0.property(UserInfo::getUser).property(User::getAge).value(8)) //
            .list();

        query.find(UserInfo.class).join(UserInfo::getUser).where() //
            .gt((e0, e1) -> e1.accept(User::getAge, 18)) //
            .and() //
            .gt((e0, e1) -> e1.property(User::getAge).value(18)) //
            .and() //
            .gt((e0, e1) -> e0.property(UserInfo::getUser).accept(User::getAge, 18)) //
            .and() //
            .gt((e0, e1) -> e0.property(UserInfo::getUser).property(User::getAge).value(8)) //
            .list();

        query.find(UserInfo.class).join(UserInfo::getUser).where() //
            .le((e0, e1) -> e1.accept(User::getAge, 18)) //
            .and() //
            .le((e0, e1) -> e1.property(User::getAge).value(18)) //
            .and() //
            .le((e0, e1) -> e0.property(UserInfo::getUser).accept(User::getAge, 18)) //
            .and() //
            .le((e0, e1) -> e0.property(UserInfo::getUser).property(User::getAge).value(8)) //
            .list();

        query.find(UserInfo.class).join(UserInfo::getUser).where() //
            .lt((e0, e1) -> e1.accept(User::getAge, 18)) //
            .and() //
            .lt((e0, e1) -> e1.property(User::getAge).value(18)) //
            .and() //
            .lt((e0, e1) -> e0.property(UserInfo::getUser).accept(User::getAge, 18)) //
            .and() //
            .lt((e0, e1) -> e0.property(UserInfo::getUser).property(User::getAge).value(8)) //
            .list();

        query.find(UserInfo.class).join(UserInfo::getUser).where() //
            .co((e0, e1) -> e1.accept(User::getUsername, "")) //
            .and() //
            .co((e0, e1) -> e1.property(User::getUsername).value("")) //
            .and() //
            .co((e0, e1) -> e0.property(UserInfo::getUser).accept(User::getUsername, "")) //
            //                .and() //
            //                .co((e0, e1) -> e0.property(UserInfo::getUser).value("")) //
            .and() //
            .co((e0, e1) -> e0.property(UserInfo::getUser).property(User::getUsername).value("")) //
            .list();

        query.find(UserInfo.class).join(UserInfo::getUser).where() //
            .nco((e0, e1) -> e1.accept(User::getUsername, "")) //
            .and() //
            .nco((e0, e1) -> e1.property(User::getUsername).value("")) //
            .and() //
            .nco((e0, e1) -> e0.property(UserInfo::getUser).accept(User::getUsername, "")) //
            .and() //
            .nco((e0, e1) -> e0.property(UserInfo::getUser).property(User::getUsername).value("")) //
            .list();

        query.find(UserInfo.class).join(UserInfo::getUser).where() //
            .sw((e0, e1) -> e1.accept(User::getUsername, "")) //
            .and() //
            .sw((e0, e1) -> e1.property(User::getUsername).value("")) //
            .and() //
            .sw((e0, e1) -> e0.property(UserInfo::getUser).accept(User::getUsername, "")) //
            .and() //
            .sw((e0, e1) -> e0.property(UserInfo::getUser).property(User::getUsername).value("")) //
            .list();

        query.find(UserInfo.class).join(UserInfo::getUser).where() //
            .nsw((e0, e1) -> e1.accept(User::getUsername, "")) //
            .and() //
            .nsw((e0, e1) -> e1.property(User::getUsername).value("")) //
            .and() //
            .nsw((e0, e1) -> e0.property(UserInfo::getUser).accept(User::getUsername, "")) //
            .and() //
            .nsw((e0, e1) -> e0.property(UserInfo::getUser).property(User::getUsername).value("")) //
            .list();

        query.find(UserInfo.class).join(UserInfo::getUser).where() //
            .ew((e0, e1) -> e1.accept(User::getUsername, "")) //
            .and() //
            .ew((e0, e1) -> e1.property(User::getUsername).value("")) //
            .and() //
            .ew((e0, e1) -> e0.property(UserInfo::getUser).accept(User::getUsername, "")) //
            .and() //
            .ew((e0, e1) -> e0.property(UserInfo::getUser).property(User::getUsername).value("")) //
            .list();

        query.find(UserInfo.class).join(UserInfo::getUser).where() //
            .newv((e0, e1) -> e1.accept(User::getUsername, "")) //
            .and() //
            .newv((e0, e1) -> e1.property(User::getUsername).value("")) //
            .and() //
            .newv((e0, e1) -> e0.property(UserInfo::getUser).accept(User::getUsername, "")) //
            .and() //
            .newv((e0, e1) -> e0.property(UserInfo::getUser).property(User::getUsername).value("")) //
            .list();

        query.find(UserInfo.class).join(UserInfo::getUser).where() //
            .lk((e0, e1) -> e1.accept(User::getUsername, "")) //
            .and() //
            .lk((e0, e1) -> e1.property(User::getUsername).value("")) //
            .and() //
            .lk((e0, e1) -> e0.property(UserInfo::getUser).accept(User::getUsername, "")) //
            .and() //
            .lk((e0, e1) -> e0.property(UserInfo::getUser).property(User::getUsername).value("")) //
            .list();

        query.find(UserInfo.class).join(UserInfo::getUser).where() //
            .nl((e0, e1) -> e1.accept(User::getUsername, "")) //
            .and() //
            .nl((e0, e1) -> e1.property(User::getUsername).value("")) //
            .and() //
            .nl((e0, e1) -> e0.property(UserInfo::getUser).accept(User::getUsername, "")) //
            .and() //
            .nl((e0, e1) -> e0.property(UserInfo::getUser).property(User::getUsername).value("")) //
            .list();

        query.find(UserInfo.class).join(UserInfo::getUser).where() //
            .eq((e0, e1) -> e1.accept(User::getUsername, "")) //
            .and() //
            .eq((e0, e1) -> e1.property(User::getUsername).value("")) //
            .and() //
            .eq((e0, e1) -> e0.property(UserInfo::getUser).accept(User::getUsername, "")) //
            .and() //
            .eq((e0, e1) -> e0.property(UserInfo::getUser).property(User::getUsername).value("")) //
            .and() //
            .eq((e0, e1) -> e0.property(UserInfo::getUser).value(new User(1))) //
            .list();

        query.find(UserInfo.class).join(UserInfo::getUser).where() //
            .ne((e0, e1) -> e1.accept(User::getUsername, "")) //
            .and() //
            .ne((e0, e1) -> e1.property(User::getUsername).value("")) //
            .and() //
            .ne((e0, e1) -> e0.property(UserInfo::getUser).accept(User::getUsername, "")) //
            .and() //
            .ne((e0, e1) -> e0.property(UserInfo::getUser).property(User::getUsername).value("")) //
            .list();
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

    //    void t() {
    //        EntityPropertyExpression<User, EntityQueryConditionGroup<User>, EntityQueryConditionGroupLogic<User>> pe = null;
    //        pe.property(User::getId).gt(1).and().property(User::getAge).eq(1).and().property(User::getUsername).co("yi");
    //
    //        EntityPropertyExpression2<User, UserInfo, EntityQueryConditionGroup2<User, UserInfo, User>,
    //                EntityQueryConditionGroupLogic2<User, UserInfo, User>> pe2 = null;
    //        pe.property(User::getId).gt(1).and().property(User::getAge).eq(1).and().property(User::getUsername).co("yi");
    //    }

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
