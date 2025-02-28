
package cn.featherfly.hammer.dml.builder.sql;

import java.util.function.IntPredicate;

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
public class DslEntityConditionCompareTest {

    Query query = null;

    Repository data = null;

    boolean ignore = true;

    public void testEntityQueryJoinConditionEq() {
        // value property
        query.find(UserInfo.class) //
            .join(User::getUserInfo) //
            .where() //
            .property(UserInfo::getId).eq(1) //
            .list();

        // Embedded Object property
        query.find(User.class) //
            .join(User::getUserInfo) //
            .where() //
            .property(User::getEmail).eq(new Email("name", "host")) //
            .list(); // use and with object all none empty property
        query.find(User.class) //
            .join(User::getUserInfo) //
            .where() //
            .property(User::getEmail).property(Email::getName).eq("name") //
            .and() //
            .property(User::getEmail).property(Email::getHost).eq("host") //
            .list();

        // OneToOne or ManyToOne Object property
        query.find(User.class) //
            .join(User::getUserInfo) //
            .where() //
            .property(User::getUserInfo).property(UserInfo::getName).eq("yufei") //
            .list();
        query.find(User.class) //
            .join(User::getUserInfo) //
            .where() //
            .property(User::getUserInfo).eq(new UserInfo(1, "yufei", 18)) //
            .list(); // use and with object all none empty property

        // OneToMany Object property
        query.find(User.class) //
            .join(User::getUserInfo) //
            .where() //
            .property(User::getDevices).property(Device::getCode).eq("device-001") //
            .list();
        query.find(User.class) //
            .join(User::getUserInfo) //
            .where().eq((e0, e1) -> e0.property(User::getDevices).property(Device::getCode).value("device-001")) //
            .list();
        query.find(Tree.class) //
            .join(Tree::getParent) //
            .where() //
            .eq((e0, e1) -> e0.property(Tree::getChildren).property(Tree::getChildren).property(Tree::getName)
                .value("tree-001")) //
            .list();
        query.find(Tree.class) //
            .join(Tree::getParent) //
            .where()
            .eq((e0, e1) -> e0.property(Tree::getChildren).property(Tree::getChildren).property(Tree::getChildren)
                .property(Tree::getName).value("tree-001")) //
            .list();

        query.find(UserInfo.class) //
            .join(User::getUserInfo) //
            .where().eq(UserInfo::getId, 1, (IntPredicate) value -> ignore) //
            .list();

        query.find(UserInfo.class) //
            .join(User::getUserInfo) //
            .where() //
            .eq(es -> es.get0().property(UserInfo::getId).value(1)) //
            .list();
        query.find(UserInfo.class) //
            .join(User::getUserInfo) //
            .where() //
            .eq((e0, e1) -> e0.property(UserInfo::getId).value(1)) //
            .list();
        query.find(UserInfo.class) //
            .join(User::getUserInfo) //
            .where().eq(es -> es.get1().property(User::getUserInfo).property(UserInfo::getId).value(1)) //
            .list();
        query.find(UserInfo.class) //
            .join(User::getUserInfo) //
            .where().eq((e0, e1) -> e1.property(User::getUserInfo).property(UserInfo::getId).value(1)) //
            .list();

        query.find(User2.class) //
            .join(UserInfo2.class).on(UserInfo2::getUserId).fetch() //
            .where() //
            .eq(es -> es.get0().accept(User2::getId, 1)) //
            .and() //
            .eq(es -> es.get1().accept(UserInfo2::getName, "yufei")) //
            .list();

        query.find(User2.class) //
            .join(UserInfo2.class).on(UserInfo2::getUserId).fetch() //
            .where() //
            .eq((e0, e1) -> e0.accept(User2::getId, 1)) //
            .and() //
            .eq((e0, e1) -> e1.accept(UserInfo2::getName, "yufei")) //
            .list();

        query.find(Tree2.class).join(Tree2.class).on(Tree2::getId, Tree2::getParentId).fetch() //
            .join(Tree2.class).on((e1, e2, j) -> e2.property(Tree2::getId).eq(j.property(Tree2::getParentId))).fetch() //
            .join(Tree2.class).on((e1, e2, e3, j) -> e2.property(Tree2::getId).eq(j.property(Tree2::getParentId)))
            .fetch() //
            .where().eq(es -> es.get0().accept(Tree2::getId, 1)).and()
            .eq((e0, e1, e2, e3) -> e3.accept(Tree2::getId, 1)).list();
    }

    public void testEntityQueryJoinConditionNe() {
        // value property
        query.find(UserInfo.class).join(User::getUserInfo).where().property(UserInfo::getId).ne(1).list();

        // Embedded Object property
        query.find(User.class).join(User::getUserInfo).where().property(User::getEmail).ne(new Email("name", "host"))
            .list(); // use and with object all none empty property
        query.find(User.class).join(User::getUserInfo).where().property(User::getEmail).property(Email::getName)
            .ne("name").and().property(User::getEmail).property(Email::getHost).ne("host").list();

        // OneToOne or ManyToOne Object property
        query.find(User.class).join(User::getUserInfo).where().property(User::getUserInfo).property(UserInfo::getName)
            .ne("yufei").list();
        query.find(User.class).join(User::getUserInfo).where().property(User::getUserInfo)
            .ne(new UserInfo(1, "yufei", 18)).list(); // use and with object all none empty property

        // OneToMany Object property
        query.find(User.class).join(User::getUserInfo).where().property(User::getDevices).property(Device::getCode)
            .ne("device-001").list();
        query.find(User.class).join(User::getUserInfo).where()
            .ne((e0, e1) -> e0.property(User::getDevices).property(Device::getCode).value("device-001")).list();
        query.find(Tree.class).join(Tree::getParent).where().ne((e0, e1) -> e0.property(Tree::getChildren)
            .property(Tree::getChildren).property(Tree::getName).value("tree-001")).list();
        query
            .find(Tree.class).join(Tree::getParent).where().ne((e0, e1) -> e0.property(Tree::getChildren)
                .property(Tree::getChildren).property(Tree::getChildren).property(Tree::getName).value("tree-001"))
            .list();

        query.find(UserInfo.class).join(User::getUserInfo).where()
            .ne(UserInfo::getId, 1, (IntPredicate) value -> ignore).list();

        query.find(UserInfo.class).join(User::getUserInfo).where()
            .ne(es -> es.get0().property(UserInfo::getId).value(1)).list();
        query.find(UserInfo.class).join(User::getUserInfo).where().ne((e0, e1) -> e0.property(UserInfo::getId).value(1))
            .list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
            .ne(es -> es.get1().property(User::getUserInfo).property(UserInfo::getId).value(1)).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
            .ne((e0, e1) -> e1.property(User::getUserInfo).property(UserInfo::getId).value(1)).list();

        query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId).fetch().where()
            .ne(es -> es.get0().accept(User2::getId, 1)).and().ne(es -> es.get1().accept(UserInfo2::getName, "yufei"))
            .list();

        query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId).fetch().where()
            .ne((e0, e1) -> e0.accept(User2::getId, 1)).and().ne((e0, e1) -> e1.accept(UserInfo2::getName, "yufei"))
            .list();

        query.find(Tree2.class).join(Tree2.class).on(Tree2::getId, Tree2::getParentId).fetch() //
            .join(Tree2.class).on((e1, e2, j) -> e2.property(Tree2::getId).eq(j.property(Tree2::getParentId))).fetch() //
            .join(Tree2.class).on((e1, e2, e3, j) -> e2.property(Tree2::getId).eq(j.property(Tree2::getParentId)))
            .fetch() //
            .where().ne(es -> es.get0().accept(Tree2::getId, 1)).and()
            .ne((e0, e1, e2, e3) -> e3.accept(Tree2::getId, 1)).list();
    }

    public void testEntityQueryJoinConditionGe() {
        // value property
        query.find(UserInfo.class) //
            .join(User::getUserInfo) //
            .where() //
            .property(UserInfo::getName).ge("yufei") //
            .list();

        // Embedded Object property
        query.find(User.class) //
            .join(User::getUserInfo) //
            .where() //
            .property(User::getEmail).property(Email::getName).ge("name") //
            .and() //
            .property(User::getEmail).property(Email::getHost).ge("host") //
            .list();

        // OneToOne or ManyToOne Object property
        query.find(User.class).join(User::getUserInfo).where().property(User::getUserInfo).property(UserInfo::getName)
            .ge("yufei").list();

        // OneToMany Object property
        query.find(User.class).join(User::getUserInfo).where().property(User::getDevices).property(Device::getCode)
            .ge("device-001").list();
        query.find(User.class).join(User::getUserInfo).where()
            .ge((e0, e1) -> e0.property(User::getDevices).property(Device::getCode).value("device-001")).list();
        query.find(Tree.class).join(Tree::getParent).where().ge((e0, e1) -> e0.property(Tree::getChildren)
            .property(Tree::getChildren).property(Tree::getName).value("tree-001")).list();
        query
            .find(Tree.class).join(Tree::getParent).where().ge((e0, e1) -> e0.property(Tree::getChildren)
                .property(Tree::getChildren).property(Tree::getChildren).property(Tree::getName).value("tree-001"))
            .list();

        query.find(UserInfo.class).join(User::getUserInfo).where().property(UserInfo::getId).ge(1).list();

        query.find(UserInfo.class).join(User::getUserInfo).where() //
            .property(UserInfo::getUser).property(User::getId).ge(1) //
            .list();

        query.find(UserInfo.class).join(User::getUserInfo).where() //
            .property(UserInfo::getUser, propUser -> {
                propUser.property(User::getId).eq(1).and().ge(User::getAge, 1);
            }) //
            .list();

        query.find(UserInfo.class).join(User::getUserInfo).where()
            .ge((SerializableToIntFunction<UserInfo>) UserInfo::getId, 1, value -> ignore).list();
        query.find(UserInfo.class).join(User::getUserInfo).where().ge(UserInfo::getId, (Integer) 1, value -> ignore)
            .list();

        query.find(UserInfo.class).join(User::getUserInfo).where()
            .ge(es -> es.get0().property(UserInfo::getId).value(1)).list();
        query.find(User.class).join(User::getUserInfo).where()
            .ge(es -> es.get0().property(User::getUsername).value("1")).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
            .ge(es -> es.get0().property(UserInfo::getUser).property(User::getId).value(1)).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
            .ge(es -> es.get0().property(UserInfo::getUser).property(User::getUsername).value("1")).list();

        query.find(UserInfo.class).join(User::getUserInfo).where().ge(
            es -> es.get0().property(UserInfo::getUser).property(User::getUserInfo).property(UserInfo::getId).value(1))
            .list();

        query.find(UserInfo.class).join(User::getUserInfo).where().ge((e0, e1) -> e0.property(UserInfo::getId).value(1))
            .list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
            .ge(es -> es.get1().property(User::getUserInfo).property(UserInfo::getId).value(1)).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
            .ge((e0, e1) -> e1.property(User::getUserInfo).property(UserInfo::getId).value(1)).list();

        query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId).fetch().where()
            .ge(es -> es.get0().accept(User2::getId, 1)).and().ge(es -> es.get1().accept(UserInfo2::getName, "yufei"))
            .list();

        query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId).fetch().where()
            .ge((e0, e1) -> e0.accept(User2::getId, 1)).and().ge((e0, e1) -> e1.accept(UserInfo2::getName, "yufei"))
            .list();

        query.find(Tree2.class).join(Tree2.class).on(Tree2::getId, Tree2::getParentId).fetch() //
            .join(Tree2.class).on((e1, e2, j) -> e2.property(Tree2::getId).eq(j.property(Tree2::getParentId))).fetch() //
            .join(Tree2.class).on((e1, e2, e3, j) -> e2.property(Tree2::getId).eq(j.property(Tree2::getParentId)))
            .fetch() //
            .where().ge(es -> es.get0().accept(Tree2::getId, 1)).and()
            .ge((e0, e1, e2, e3) -> e3.accept(Tree2::getId, 1)).list();
    }

    public void testEntityQueryJoinConditionGt() {
        // value property
        query.find(UserInfo.class).join(User::getUserInfo).where().property(UserInfo::getName).gt("yufei").list();

        // Embedded Object property
        query.find(User.class).join(User::getUserInfo).where().property(User::getEmail).property(Email::getName)
            .gt("name").and().property(User::getEmail).property(Email::getHost).gt("host").list();

        // OneToOne or ManyToOne Object property
        query.find(User.class).join(User::getUserInfo).where().property(User::getUserInfo).property(UserInfo::getName)
            .gt("yufei").list();

        // OneToMany Object property
        query.find(User.class).join(User::getUserInfo).where().property(User::getDevices).property(Device::getCode)
            .gt("device-001").list();
        query.find(User.class).join(User::getUserInfo).where()
            .gt((e0, e1) -> e0.property(User::getDevices).property(Device::getCode).value("device-001")).list();
        query.find(Tree.class).join(Tree::getParent).where().gt((e0, e1) -> e0.property(Tree::getChildren)
            .property(Tree::getChildren).property(Tree::getName).value("tree-001")).list();
        query
            .find(Tree.class).join(Tree::getParent).where().gt((e0, e1) -> e0.property(Tree::getChildren)
                .property(Tree::getChildren).property(Tree::getChildren).property(Tree::getName).value("tree-001"))
            .list();

        query.find(UserInfo.class).join(User::getUserInfo).where().property(UserInfo::getId).gt(1).list();

        query.find(UserInfo.class).join(User::getUserInfo).where().property(UserInfo::getUser).property(User::getId)
            .gt(1).list();

        query.find(UserInfo.class).join(User::getUserInfo).where()
            .gt((SerializableToIntFunction<UserInfo>) UserInfo::getId, 1, value -> ignore).list();
        query.find(UserInfo.class).join(User::getUserInfo).where().gt(UserInfo::getId, (Integer) 1, value -> ignore)
            .list();

        query.find(UserInfo.class).join(User::getUserInfo).where()
            .gt(es -> es.get0().property(UserInfo::getId).value(1)).list();
        query.find(User.class).join(User::getUserInfo).where()
            .gt(es -> es.get0().property(User::getUsername).value("1")).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
            .gt(es -> es.get0().property(UserInfo::getUser).property(User::getId).value(1)).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
            .gt(es -> es.get0().property(UserInfo::getUser).property(User::getUsername).value("1")).list();

        query.find(UserInfo.class).join(User::getUserInfo).where().gt(
            es -> es.get0().property(UserInfo::getUser).property(User::getUserInfo).property(UserInfo::getId).value(1))
            .list();

        query.find(UserInfo.class).join(User::getUserInfo).where().gt((e0, e1) -> e0.property(UserInfo::getId).value(1))
            .list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
            .gt(es -> es.get1().property(User::getUserInfo).property(UserInfo::getId).value(1)).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
            .gt((e0, e1) -> e1.property(User::getUserInfo).property(UserInfo::getId).value(1)).list();

        query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId).fetch().where()
            .gt(es -> es.get0().accept(User2::getId, 1)).and().gt(es -> es.get1().accept(UserInfo2::getName, "yufei"))
            .list();

        query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId).fetch().where()
            .gt((e0, e1) -> e0.accept(User2::getId, 1)).and().gt((e0, e1) -> e1.accept(UserInfo2::getName, "yufei"))
            .list();

        query.find(Tree2.class).join(Tree2.class).on(Tree2::getId, Tree2::getParentId).fetch() //
            .join(Tree2.class).on((e1, e2, j) -> e2.property(Tree2::getId).eq(j.property(Tree2::getParentId))).fetch() //
            .join(Tree2.class).on((e1, e2, e3, j) -> e2.property(Tree2::getId).eq(j.property(Tree2::getParentId)))
            .fetch() //
            .where().gt(es -> es.get0().accept(Tree2::getId, 1)).and()
            .gt((e0, e1, e2, e3) -> e3.accept(Tree2::getId, 1)).list();
    }

    public void testEntityQueryJoinConditionLe() {
        // value property
        query.find(UserInfo.class).join(User::getUserInfo).where().property(UserInfo::getName).le("yufei").list();

        // Embedded Object property
        query.find(User.class).join(User::getUserInfo).where().property(User::getEmail).property(Email::getName)
            .le("name").and().property(User::getEmail).property(Email::getHost).le("host").list();

        // OneToOne or ManyToOne Object property
        query.find(User.class).join(User::getUserInfo).where().property(User::getUserInfo).property(UserInfo::getName)
            .le("yufei").list();

        // OneToMany Object property
        query.find(User.class).join(User::getUserInfo).where().property(User::getDevices).property(Device::getCode)
            .le("device-001").list();
        query.find(User.class).join(User::getUserInfo).where()
            .le((e0, e1) -> e0.property(User::getDevices).property(Device::getCode).value("device-001")).list();
        query.find(Tree.class).join(Tree::getParent).where().le((e0, e1) -> e0.property(Tree::getChildren)
            .property(Tree::getChildren).property(Tree::getName).value("tree-001")).list();
        query
            .find(Tree.class).join(Tree::getParent).where().le((e0, e1) -> e0.property(Tree::getChildren)
                .property(Tree::getChildren).property(Tree::getChildren).property(Tree::getName).value("tree-001"))
            .list();

        query.find(UserInfo.class).join(User::getUserInfo).where().property(UserInfo::getId).le(1).list();

        query.find(UserInfo.class).join(User::getUserInfo).where().property(UserInfo::getUser).property(User::getId)
            .le(1).list();

        query.find(UserInfo.class).join(User::getUserInfo).where()
            .le((SerializableToIntFunction<UserInfo>) UserInfo::getId, 1, value -> ignore).list();
        query.find(UserInfo.class).join(User::getUserInfo).where().le(UserInfo::getId, (Integer) 1, value -> ignore)
            .list();

        query.find(UserInfo.class).join(User::getUserInfo).where()
            .le(es -> es.get0().property(UserInfo::getId).value(1)).list();
        query.find(User.class).join(User::getUserInfo).where()
            .le(es -> es.get0().property(User::getUsername).value("1")).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
            .le(es -> es.get0().property(UserInfo::getUser).property(User::getId).value(1)).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
            .le(es -> es.get0().property(UserInfo::getUser).property(User::getUsername).value("1")).list();

        query.find(UserInfo.class).join(User::getUserInfo).where().le(
            es -> es.get0().property(UserInfo::getUser).property(User::getUserInfo).property(UserInfo::getId).value(1))
            .list();

        query.find(UserInfo.class).join(User::getUserInfo).where().le((e0, e1) -> e0.property(UserInfo::getId).value(1))
            .list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
            .le(es -> es.get1().property(User::getUserInfo).property(UserInfo::getId).value(1)).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
            .le((e0, e1) -> e1.property(User::getUserInfo).property(UserInfo::getId).value(1)).list();

        query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId).fetch().where()
            .le(es -> es.get0().accept(User2::getId, 1)).and().le(es -> es.get1().accept(UserInfo2::getName, "yufei"))
            .list();

        query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId).fetch().where()
            .le((e0, e1) -> e0.accept(User2::getId, 1)).and().le((e0, e1) -> e1.accept(UserInfo2::getName, "yufei"))
            .list();

        query.find(Tree2.class).join(Tree2.class).on(Tree2::getId, Tree2::getParentId).fetch() //
            .join(Tree2.class).on((e1, e2, j) -> e2.property(Tree2::getId).eq(j.property(Tree2::getParentId))).fetch() //
            .join(Tree2.class).on((e1, e2, e3, j) -> e2.property(Tree2::getId).eq(j.property(Tree2::getParentId)))
            .fetch() //
            .where().le(es -> es.get0().accept(Tree2::getId, 1)).and()
            .le((e0, e1, e2, e3) -> e3.accept(Tree2::getId, 1)).list();
    }

    public void testEntityQueryJoinConditionLt() {
        // value property
        query.find(UserInfo.class).join(User::getUserInfo).where().property(UserInfo::getName).lt("yufei").list();

        // Embedded Object property
        query.find(User.class).join(User::getUserInfo).where().property(User::getEmail).property(Email::getName)
            .lt("name").and().property(User::getEmail).property(Email::getHost).lt("host").list();

        // OneToOne or ManyToOne Object property
        query.find(User.class).join(User::getUserInfo).where().property(User::getUserInfo).property(UserInfo::getName)
            .lt("yufei").list();

        // OneToMany Object property
        query.find(User.class).join(User::getUserInfo).where().property(User::getDevices).property(Device::getCode)
            .lt("device-001").list();
        query.find(User.class).join(User::getUserInfo).where()
            .lt((e0, e1) -> e0.property(User::getDevices).property(Device::getCode).value("device-001")).list();
        query.find(Tree.class).join(Tree::getParent).where().lt((e0, e1) -> e0.property(Tree::getChildren)
            .property(Tree::getChildren).property(Tree::getName).value("tree-001")).list();
        query
            .find(Tree.class).join(Tree::getParent).where().lt((e0, e1) -> e0.property(Tree::getChildren)
                .property(Tree::getChildren).property(Tree::getChildren).property(Tree::getName).value("tree-001"))
            .list();

        query.find(UserInfo.class).join(User::getUserInfo).where().property(UserInfo::getId).lt(1).list();

        query.find(UserInfo.class).join(User::getUserInfo).where().property(UserInfo::getUser).property(User::getId)
            .lt(1).list();

        query.find(UserInfo.class).join(User::getUserInfo).where()
            .lt((SerializableToIntFunction<UserInfo>) UserInfo::getId, 1, value -> ignore).list();
        query.find(UserInfo.class).join(User::getUserInfo).where().lt(UserInfo::getId, (Integer) 1, value -> ignore)
            .list();

        query.find(UserInfo.class).join(User::getUserInfo).where()
            .lt(es -> es.get0().property(UserInfo::getId).value(1)).list();
        query.find(User.class).join(User::getUserInfo).where()
            .lt(es -> es.get0().property(User::getUsername).value("1")).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
            .lt(es -> es.get0().property(UserInfo::getUser).property(User::getId).value(1)).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
            .lt(es -> es.get0().property(UserInfo::getUser).property(User::getUsername).value("1")).list();

        query.find(UserInfo.class).join(User::getUserInfo).where().lt(
            es -> es.get0().property(UserInfo::getUser).property(User::getUserInfo).property(UserInfo::getId).value(1))
            .list();

        query.find(UserInfo.class).join(User::getUserInfo).where().lt((e0, e1) -> e0.property(UserInfo::getId).value(1))
            .list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
            .lt(es -> es.get1().property(User::getUserInfo).property(UserInfo::getId).value(1)).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
            .lt((e0, e1) -> e1.property(User::getUserInfo).property(UserInfo::getId).value(1)).list();

        query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId).fetch().where()
            .lt(es -> es.get0().accept(User2::getId, 1)).and().lt(es -> es.get1().accept(UserInfo2::getName, "yufei"))
            .list();

        query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId).fetch().where()
            .lt((e0, e1) -> e0.accept(User2::getId, 1)).and().lt((e0, e1) -> e1.accept(UserInfo2::getName, "yufei"))
            .list();

        query.find(Tree2.class).join(Tree2.class).on(Tree2::getId, Tree2::getParentId).fetch() //
            .join(Tree2.class).on((e1, e2, j) -> e2.property(Tree2::getId).eq(j.property(Tree2::getParentId))).fetch() //
            .join(Tree2.class).on((e1, e2, e3, j) -> e2.property(Tree2::getId).eq(j.property(Tree2::getParentId)))
            .fetch() //
            .where().lt(es -> es.get0().accept(Tree2::getId, 1)).and()
            .lt((e0, e1, e2, e3) -> e3.accept(Tree2::getId, 1)).list();
    }
}
