
package cn.featherfly.hammer.dml.builder.sql;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableFunction2;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.dml.builder.sql.vo.Device;
import cn.featherfly.hammer.dml.builder.sql.vo.Email;
import cn.featherfly.hammer.dml.builder.sql.vo.Tree;
import cn.featherfly.hammer.dml.builder.sql.vo.Tree2;
import cn.featherfly.hammer.dml.builder.sql.vo.User;
import cn.featherfly.hammer.dml.builder.sql.vo.User2;
import cn.featherfly.hammer.dml.builder.sql.vo.UserInfo;
import cn.featherfly.hammer.dml.builder.sql.vo.UserInfo2;
import cn.featherfly.hammer.dsl.query.Query;

/**
 * dsl api invoke test
 *
 * @author zhongj
 */
public class DslEntityConditionOtherTest {

    Query query = null;

    Repository data = null;

    boolean ignore = true;

    public void testEntityQueryJoinConditionIsn() {
        // value property
        query.find(UserInfo.class).join(User::getUserInfo).where().property(UserInfo::getId).isn().list();
        query.find(UserInfo.class).join(User::getUserInfo).where().property(UserInfo::getId).isn(true).list();

        // Embedded Object property
        query.find(User.class).join(User::getUserInfo).where().property(User::getEmail).isn().list(); // use and with object all none empty property
        query.find(User.class).join(User::getUserInfo).where().property(User::getEmail).isn(true).list(); // use and with object all none empty property
        query.find(User.class).join(User::getUserInfo).where().property(User::getEmail).property(Email::getName).isn()
                .and().property(User::getEmail).property(Email::getHost).isn().list();
        query.find(User.class).join(User::getUserInfo).where().property(User::getEmail).property(Email::getName)
                .isn(true).and().property(User::getEmail).property(Email::getHost).isn(true).list();

        // OneToOne or ManyToOne Object property
        query.find(User.class).join(User::getUserInfo).where().property(User::getUserInfo).property(UserInfo::getName)
                .isn().list();
        query.find(User.class).join(User::getUserInfo).where().property(User::getUserInfo).property(UserInfo::getName)
                .isn(true).list();
        // use property mapping with foreign key
        query.find(User.class).join(User::getUserInfo).where().property(User::getUserInfo).isn().list();
        query.find(User.class).join(User::getUserInfo).where().property(User::getUserInfo).isn(true).list();
        // 上面和下面是一样的效果
        query.find(User.class).join(User::getUserInfo).where().property(User::getUserInfo).property(UserInfo::getId)
                .isn().list();
        query.find(User.class).join(User::getUserInfo).where().property(User::getUserInfo).property(UserInfo::getId)
                .isn(true).list();

        // OneToMany Object property YUFEI_TODO 暂时还未想到功能逻辑
        //        query.find(User.class).join(User::getUserInfo).where().property(User::getDevices).property(Device::getCode)
        //                .isn("device-001").list();
        //        query.find(User.class).join(User::getUserInfo).where()
        //                .isn((e0, e1) -> e0.property(User::getDevices).property(Device::getCode).value("device-001")).list();
        //        query.find(Tree.class).join(Tree::getParent).where().isn((e0, e1) -> e0.property(Tree::getChildren)
        //                .property(Tree::getChildren).property(Tree::getName).value("tree-001")).list();
        //        query.find(Tree.class).join(Tree::getParent).where().isn((e0, e1) -> e0.property(Tree::getChildren)
        //                .property(Tree::getChildren).property(Tree::getChildren).property(Tree::getName).value("tree-001"))
        //                .list();

        query.find(UserInfo.class).join(User::getUserInfo).where()
                .isn(es -> es.get0().property(UserInfo::getName).value()).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
                .isn((e0, e1) -> e0.property(UserInfo::getName).value()).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
                .isn(es -> es.get1().property(User::getUserInfo).property(UserInfo::getName).value(true)).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
                .isn((e0, e1) -> e1.property(User::getUserInfo).property(UserInfo::getName).value(true)).list();

        query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId).fetch().where()
                .isn(es -> es.get0().accept(User2::getUsername)).and().isn(es -> es.get1().accept(UserInfo2::getName))
                .list();

        query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId).fetch().where()
                .isn((e0, e1) -> e0.accept(User2::getUsername)).and().isn((e0, e1) -> e1.accept(UserInfo2::getName))
                .list();

        query.find(Tree2.class).join(Tree2.class).on(Tree2::getId, Tree2::getParentId).fetch().join2(Tree2.class)
                .on((SerializableFunction2<Tree2, Integer>) Tree2::getParentId).fetch().join2(Tree2.class)
                .on((SerializableFunction2<Tree2, Integer>) Tree2::getParentId).fetch().where()
                .isn(es -> es.get0().accept(Tree2::getName)).and().isn((e0, e1, e2, e3) -> e3.accept(Tree2::getName))
                .list();
    }

    public void testEntityQueryJoinConditionInn() {
        // value property
        query.find(UserInfo.class).join(User::getUserInfo).where().property(UserInfo::getId).inn().list();
        query.find(UserInfo.class).join(User::getUserInfo).where().property(UserInfo::getId).inn(true).list();

        // Embedded Object property
        query.find(User.class).join(User::getUserInfo).where().property(User::getEmail).inn().list(); // use and with object all none empty property
        query.find(User.class).join(User::getUserInfo).where().property(User::getEmail).inn(true).list(); // use and with object all none empty property
        query.find(User.class).join(User::getUserInfo).where().property(User::getEmail).property(Email::getName).inn()
                .and().property(User::getEmail).property(Email::getHost).inn().list();
        query.find(User.class).join(User::getUserInfo).where().property(User::getEmail).property(Email::getName)
                .inn(true).and().property(User::getEmail).property(Email::getHost).inn(true).list();

        // OneToOne or ManyToOne Object property
        query.find(User.class).join(User::getUserInfo).where().property(User::getUserInfo).property(UserInfo::getName)
                .inn().list();
        query.find(User.class).join(User::getUserInfo).where().property(User::getUserInfo).property(UserInfo::getName)
                .inn(true).list();
        // use property mapping with foreign key
        query.find(User.class).join(User::getUserInfo).where().property(User::getUserInfo).inn().list();
        query.find(User.class).join(User::getUserInfo).where().property(User::getUserInfo).inn(true).list();
        // 上面和下面是一样的效果
        query.find(User.class).join(User::getUserInfo).where().property(User::getUserInfo).property(UserInfo::getId)
                .inn().list();
        query.find(User.class).join(User::getUserInfo).where().property(User::getUserInfo).property(UserInfo::getId)
                .inn(true).list();

        // OneToMany Object property YUFEI_TODO 暂时还未想到功能逻辑
        //        query.find(User.class).join(User::getUserInfo).where().property(User::getDevices).property(Device::getCode)
        //                .inn("device-001").list();
        //        query.find(User.class).join(User::getUserInfo).where()
        //                .inn((e0, e1) -> e0.property(User::getDevices).property(Device::getCode).value("device-001")).list();
        //        query.find(Tree.class).join(Tree::getParent).where().inn((e0, e1) -> e0.property(Tree::getChildren)
        //                .property(Tree::getChildren).property(Tree::getName).value("tree-001")).list();
        //        query.find(Tree.class).join(Tree::getParent).where().inn((e0, e1) -> e0.property(Tree::getChildren)
        //                .property(Tree::getChildren).property(Tree::getChildren).property(Tree::getName).value("tree-001"))
        //                .list();

        query.find(UserInfo.class).join(User::getUserInfo).where()
                .inn(es -> es.get0().property(UserInfo::getName).value()).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
                .inn((e0, e1) -> e0.property(UserInfo::getName).value()).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
                .inn(es -> es.get1().property(User::getUserInfo).property(UserInfo::getName).value(true)).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
                .inn((e0, e1) -> e1.property(User::getUserInfo).property(UserInfo::getName).value(true)).list();

        query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId).fetch().where()
                .inn(es -> es.get0().accept(User2::getUsername)).and().inn(es -> es.get1().accept(UserInfo2::getName))
                .list();

        query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId).fetch().where()
                .inn((e0, e1) -> e0.accept(User2::getUsername)).and().inn((e0, e1) -> e1.accept(UserInfo2::getName))
                .list();

        query.find(Tree2.class).join(Tree2.class).on(Tree2::getId, Tree2::getParentId).fetch().join2(Tree2.class)
                .on((SerializableFunction2<Tree2, Integer>) Tree2::getParentId).fetch().join2(Tree2.class)
                .on((SerializableFunction2<Tree2, Integer>) Tree2::getParentId).fetch().where()
                .inn(es -> es.get0().accept(Tree2::getName)).and().inn((e0, e1, e2, e3) -> e3.accept(Tree2::getName))
                .list();
    }

    public void testEntityQueryJoinConditionIn() {
        // value property
        query.find(UserInfo.class).join(User::getUserInfo).where().property(UserInfo::getName).in("yufei").list();

        // Embedded Object property
        query.find(User.class).join(User::getUserInfo).where().property(User::getEmail).property(Email::getName)
                .in("name").and().property(User::getEmail).property(Email::getHost).in("host").list();

        // OneToOne or ManyToOne Object property
        query.find(User.class).join(User::getUserInfo).where().property(User::getUserInfo).property(UserInfo::getName)
                .in("yufei").list();

        // OneToMany Object property
        query.find(User.class).join(User::getUserInfo).where().property(User::getDevices).property(Device::getCode)
                .in("device-001").list();
        query.find(User.class).join(User::getUserInfo).where()
                .in((e0, e1) -> e0.property(User::getDevices).property(Device::getCode).value("device-001")).list();
        query.find(Tree.class).join(Tree::getParent).where().in((e0, e1) -> e0.property(Tree::getChildren)
                .property(Tree::getChildren).property(Tree::getName).value("tree-001")).list();
        query.find(Tree.class).join(Tree::getParent).where().in((e0, e1) -> e0.property(Tree::getChildren)
                .property(Tree::getChildren).property(Tree::getChildren).property(Tree::getName).value("tree-001"))
                .list();

        query.find(UserInfo.class).join(User::getUserInfo).where().property(UserInfo::getId).in(1).list();

        query.find(UserInfo.class).join(User::getUserInfo).where().property(UserInfo::getUser).property(User::getId)
                .in(1).list();

        query.find(User.class).join(User::getUserInfo).where().in(User::getAge, new Integer(18)).list();
        query.find(User.class).join(User::getUserInfo).where().in(User::getAge, new Integer(18), value -> ignore)
                .list();
        query.find(User.class).join(User::getUserInfo).where().in(User::getAge, 18).list();
        query.find(User.class).join(User::getUserInfo).where().in(User::getAge, (Integer) 18).list();
        //        query.find(User.class).join(User::getUserInfo).where().in(User::getAge, 18, value -> ignore).list();// 编译报错
        query.find(User.class).join(User::getUserInfo).where().in(User::getAge, (Integer) 18, value -> ignore).list();

        query.find(UserInfo.class).join(User::getUserInfo).where().in(UserInfo::getId, 1).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
                .in((SerializableToIntFunction<UserInfo>) UserInfo::getId, 1, value -> ignore).list();
        query.find(UserInfo.class).join(User::getUserInfo).where().in(UserInfo::getId, (Integer) 1, value -> ignore)
                .list();

        query.find(User.class).join(User::getUserInfo).where().in(User::getId, 1, 2).list();
        query.find(User.class).join(User::getUserInfo).where().in(User::getId, new int[] { 1, 2 }, value -> ignore)
                .list();

        query.find(User.class).join(User::getUserInfo).where().in(User::getAge, 1, 2).list();
        query.find(User.class).join(User::getUserInfo).where().in(User::getAge, Integer.valueOf(1), Integer.valueOf(2))
                .list();
        query.find(User.class).join(User::getUserInfo).where()
                .in((SerializableFunction<User, Integer>) User::getAge, 1, 2).list();
        query.find(User.class).join(User::getUserInfo).where()
                .in((SerializableFunction<User, Integer>) User::getAge, new Integer[] { 1, 2 }).list();
        query.find(User.class).join(User::getUserInfo).where()
                .in(User::getAge, new Integer[] { 1, 2 }, (Integer[] value) -> ignore).list();

        query.find(UserInfo.class).join(User::getUserInfo).where()
                .in(es -> es.get0().property(UserInfo::getId).value(1)).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
                .in(es -> es.get0().property(UserInfo::getId).value(1, value -> ignore)).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
                .in(es -> es.get0().property(UserInfo::getId).value(1, 2)).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
                .in(es -> es.get0().property(UserInfo::getId).value(new int[] { 1, 2 })).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
                .in(es -> es.get0().property(UserInfo::getId).value(new int[] { 1, 2 }, value -> ignore)).list();

        query.find(User.class).join(User::getUserInfo).where().in(es -> es.get0().property(User::getId).value(1))
                .list();
        query.find(User.class).join(User::getUserInfo).where().in(es -> es.get0().property(User::getId).value(1, 2))
                .list();
        query.find(User.class).join(User::getUserInfo).where().in(es -> es.get0().property(User::getAge).value(1))
                .list();
        query.find(User.class).join(User::getUserInfo).where().in(es -> es.get0().property(User::getAge).value(1, 2))
                .list();
        query.find(User.class).join(User::getUserInfo).where()
                .in(es -> es.get0().property(User::getDate).value(new Date())).list();
        query.find(User.class).join(User::getUserInfo).where()
                .in(es -> es.get0().property(User::getDate).value(new Date(), new Date())).list();
        query.find(User.class).join(User::getUserInfo).where()
                .in(es -> es.get0().property(User::getUsername).value("yufei")).list();
        query.find(User.class).join(User::getUserInfo).where()
                .in(es -> es.get0().property(User::getUsername).value("yufei", "featherfly")).list();
        query.find(User.class).join(User::getUserInfo).where()
                .in(es -> es.get0().property(User::getLocalDateTime).value(LocalDateTime.now())).list();
        query.find(User.class).join(User::getUserInfo).where()
                .in(es -> es.get0().property(User::getLocalDateTime).value(LocalDateTime.now(), LocalDateTime.now()))
                .list();
        query.find(User.class).join(User::getUserInfo).where()
                .in(es -> es.get0().property(User::getLocalDate).value(LocalDate.now())).list();
        query.find(User.class).join(User::getUserInfo).where()
                .in(es -> es.get0().property(User::getLocalDate).value(LocalDate.now(), LocalDate.now())).list();
        query.find(User.class).join(User::getUserInfo).where()
                .in(es -> es.get0().property(User::getLocalTime).value(LocalTime.now())).list();
        query.find(User.class).join(User::getUserInfo).where()
                .in(es -> es.get0().property(User::getLocalTime).value(LocalTime.now(), LocalTime.now())).list();

        //        query.find(User.class).join(User::getUserInfo).where()
        //                .in(es -> es.get0().property(UserInfo::getId).value(new Integer[] { 1, 2 }, value -> ignore)).list();

        query.find(UserInfo.class).join(User::getUserInfo).where()
                .in(es -> es.get0().property(UserInfo::getId).value(1)).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
                .in(es -> es.get0().property(UserInfo::getId).value(1)).list();

        query.find(UserInfo.class).join(User::getUserInfo).where().in((e0, e1) -> e0.property(UserInfo::getId).value(1))
                .list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
                .in(es -> es.get1().property(User::getUserInfo).property(UserInfo::getId).value(1)).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
                .in((e0, e1) -> e1.property(User::getUserInfo).property(UserInfo::getId).value(1)).list();

        query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId).fetch().where()
                .in(es -> es.get0().accept(User2::getId, 1)).and()
                .in(es -> es.get1().accept(UserInfo2::getName, "yufei")).list();

        query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId).fetch().where()
                .in((e0, e1) -> e0.accept(User2::getId, 1)).and().in((e0, e1) -> e1.accept(UserInfo2::getName, "yufei"))
                .list();

        query.find(Tree2.class).join(Tree2.class).on(Tree2::getId, Tree2::getParentId).fetch().join2(Tree2.class)
                .on((SerializableFunction2<Tree2, Integer>) Tree2::getParentId).fetch().join2(Tree2.class)
                .on((SerializableFunction2<Tree2, Integer>) Tree2::getParentId).fetch().where()
                .in(es -> es.get0().accept(Tree2::getId, 1)).and().in((e0, e1, e2, e3) -> e3.accept(Tree2::getId, 1))
                .list();
    }

    public void testEntityQueryJoinConditionNin() {
        // value property
        query.find(UserInfo.class).join(User::getUserInfo).where().property(UserInfo::getName).ni("yufei").list();

        // Embedded Object property
        query.find(User.class).join(User::getUserInfo).where().property(User::getEmail).property(Email::getName)
                .ni("name").and().property(User::getEmail).property(Email::getHost).ni("host").list();

        // OneToOne or ManyToOne Object property
        query.find(User.class).join(User::getUserInfo).where().property(User::getUserInfo).property(UserInfo::getName)
                .ni("yufei").list();

        // OneToMany Object property
        query.find(User.class).join(User::getUserInfo).where().property(User::getDevices).property(Device::getCode)
                .ni("device-001").list();
        query.find(User.class).join(User::getUserInfo).where()
                .ni((e0, e1) -> e0.property(User::getDevices).property(Device::getCode).value("device-001")).list();
        query.find(Tree.class).join(Tree::getParent).where().ni((e0, e1) -> e0.property(Tree::getChildren)
                .property(Tree::getChildren).property(Tree::getName).value("tree-001")).list();
        query.find(Tree.class).join(Tree::getParent).where().ni((e0, e1) -> e0.property(Tree::getChildren)
                .property(Tree::getChildren).property(Tree::getChildren).property(Tree::getName).value("tree-001"))
                .list();

        query.find(UserInfo.class).join(User::getUserInfo).where().property(UserInfo::getId).ni(1).list();

        query.find(UserInfo.class).join(User::getUserInfo).where().property(UserInfo::getUser).property(User::getId)
                .ni(1).list();

        query.find(User.class).join(User::getUserInfo).where().ni(User::getAge, new Integer(18)).list();
        query.find(User.class).join(User::getUserInfo).where().ni(User::getAge, new Integer(18), value -> ignore)
                .list();
        query.find(User.class).join(User::getUserInfo).where().ni(User::getAge, 18).list();
        query.find(User.class).join(User::getUserInfo).where().ni(User::getAge, (Integer) 18).list();
        //        query.find(User.class).join(User::getUserInfo).where().ni(User::getAge, 18, value -> ignore).list();// 编译报错
        query.find(User.class).join(User::getUserInfo).where().ni(User::getAge, (Integer) 18, value -> ignore).list();

        query.find(UserInfo.class).join(User::getUserInfo).where().ni(UserInfo::getId, 1).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
                .ni((SerializableToIntFunction<UserInfo>) UserInfo::getId, 1, value -> ignore).list();
        query.find(UserInfo.class).join(User::getUserInfo).where().ni(UserInfo::getId, (Integer) 1, value -> ignore)
                .list();

        query.find(User.class).join(User::getUserInfo).where().ni(User::getId, 1, 2).list();
        query.find(User.class).join(User::getUserInfo).where().ni(User::getId, new int[] { 1, 2 }, value -> ignore)
                .list();

        query.find(User.class).join(User::getUserInfo).where().ni(User::getAge, 1, 2).list();
        query.find(User.class).join(User::getUserInfo).where().ni(User::getAge, Integer.valueOf(1), Integer.valueOf(2))
                .list();
        query.find(User.class).join(User::getUserInfo).where()
                .ni((SerializableFunction<User, Integer>) User::getAge, 1, 2).list();
        query.find(User.class).join(User::getUserInfo).where()
                .ni((SerializableFunction<User, Integer>) User::getAge, new Integer[] { 1, 2 }).list();
        query.find(User.class).join(User::getUserInfo).where()
                .ni(User::getAge, new Integer[] { 1, 2 }, (Integer[] value) -> ignore).list();

        query.find(UserInfo.class).join(User::getUserInfo).where()
                .ni(es -> es.get0().property(UserInfo::getId).value(1)).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
                .ni(es -> es.get0().property(UserInfo::getId).value(1, value -> ignore)).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
                .ni(es -> es.get0().property(UserInfo::getId).value(1, 2)).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
                .ni(es -> es.get0().property(UserInfo::getId).value(new int[] { 1, 2 })).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
                .ni(es -> es.get0().property(UserInfo::getId).value(new int[] { 1, 2 }, value -> ignore)).list();

        query.find(User.class).join(User::getUserInfo).where().ni(es -> es.get0().property(User::getId).value(1))
                .list();
        query.find(User.class).join(User::getUserInfo).where().ni(es -> es.get0().property(User::getId).value(1, 2))
                .list();
        query.find(User.class).join(User::getUserInfo).where().ni(es -> es.get0().property(User::getAge).value(1))
                .list();
        query.find(User.class).join(User::getUserInfo).where().ni(es -> es.get0().property(User::getAge).value(1, 2))
                .list();
        query.find(User.class).join(User::getUserInfo).where()
                .ni(es -> es.get0().property(User::getDate).value(new Date())).list();
        query.find(User.class).join(User::getUserInfo).where()
                .ni(es -> es.get0().property(User::getDate).value(new Date(), new Date())).list();
        query.find(User.class).join(User::getUserInfo).where()
                .ni(es -> es.get0().property(User::getUsername).value("yufei")).list();
        query.find(User.class).join(User::getUserInfo).where()
                .ni(es -> es.get0().property(User::getUsername).value("yufei", "featherfly")).list();
        query.find(User.class).join(User::getUserInfo).where()
                .ni(es -> es.get0().property(User::getLocalDateTime).value(LocalDateTime.now())).list();
        query.find(User.class).join(User::getUserInfo).where()
                .ni(es -> es.get0().property(User::getLocalDateTime).value(LocalDateTime.now(), LocalDateTime.now()))
                .list();
        query.find(User.class).join(User::getUserInfo).where()
                .ni(es -> es.get0().property(User::getLocalDate).value(LocalDate.now())).list();
        query.find(User.class).join(User::getUserInfo).where()
                .ni(es -> es.get0().property(User::getLocalDate).value(LocalDate.now(), LocalDate.now())).list();
        query.find(User.class).join(User::getUserInfo).where()
                .ni(es -> es.get0().property(User::getLocalTime).value(LocalTime.now())).list();
        query.find(User.class).join(User::getUserInfo).where()
                .ni(es -> es.get0().property(User::getLocalTime).value(LocalTime.now(), LocalTime.now())).list();

        //        query.find(User.class).join(User::getUserInfo).where()
        //                .ni(es -> es.get0().property(UserInfo::getId).value(new Integer[] { 1, 2 }, value -> ignore)).list();

        query.find(UserInfo.class).join(User::getUserInfo).where()
                .ni(es -> es.get0().property(UserInfo::getId).value(1)).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
                .ni(es -> es.get0().property(UserInfo::getId).value(1)).list();

        query.find(UserInfo.class).join(User::getUserInfo).where().ni((e0, e1) -> e0.property(UserInfo::getId).value(1))
                .list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
                .ni(es -> es.get1().property(User::getUserInfo).property(UserInfo::getId).value(1)).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
                .ni((e0, e1) -> e1.property(User::getUserInfo).property(UserInfo::getId).value(1)).list();

        query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId).fetch().where()
                .ni(es -> es.get0().accept(User2::getId, 1)).and()
                .ni(es -> es.get1().accept(UserInfo2::getName, "yufei")).list();

        query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId).fetch().where()
                .ni((e0, e1) -> e0.accept(User2::getId, 1)).and().ni((e0, e1) -> e1.accept(UserInfo2::getName, "yufei"))
                .list();

        query.find(Tree2.class).join(Tree2.class).on(Tree2::getId, Tree2::getParentId).fetch().join2(Tree2.class)
                .on((SerializableFunction2<Tree2, Integer>) Tree2::getParentId).fetch().join2(Tree2.class)
                .on((SerializableFunction2<Tree2, Integer>) Tree2::getParentId).fetch().where()
                .ni(es -> es.get0().accept(Tree2::getId, 1)).and().ni((e0, e1, e2, e3) -> e3.accept(Tree2::getId, 1))
                .list();
    }

}
