
package cn.featherfly.hammer.dml.builder.sql;

import cn.featherfly.common.lang.function.SerializableFunction2;
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
public class DslEntityConditionStringTest {

    Query query = null;

    Repository data = null;

    boolean ignore = true;

    public void testEntityQueryJoinConditionCo() {
        // value property
        query.find(UserInfo.class).join(User::getUserInfo).where().property(UserInfo::getName).co("yufei").list();

        // Embedded Object property
        query.find(User.class).join(User::getUserInfo).where().property(User::getEmail).property(Email::getName)
                .co("name").and().property(User::getEmail).property(Email::getHost).co("host").list();

        // OneToOne or ManyToOne Object property
        query.find(User.class).join(User::getUserInfo).where().property(User::getUserInfo).property(UserInfo::getName)
                .co("yufei").list();

        // OneToMany Object property
        query.find(User.class).join(User::getUserInfo).where().property(User::getDevices).property(Device::getCode)
                .co("device-001").list();
        query.find(User.class).join(User::getUserInfo).where()
                .co((e0, e1) -> e0.property(User::getDevices).property(Device::getCode).value("device-001")).list();
        query.find(Tree.class).join(Tree::getParent).where().co((e0, e1) -> e0.property(Tree::getChildren)
                .property(Tree::getChildren).property(Tree::getName).value("tree-001")).list();
        query.find(Tree.class).join(Tree::getParent).where().co((e0, e1) -> e0.property(Tree::getChildren)
                .property(Tree::getChildren).property(Tree::getChildren).property(Tree::getName).value("tree-001"))
                .list();

        query.find(UserInfo.class).join(User::getUserInfo).where().co(UserInfo::getName, "yufei", value -> ignore)
                .list();

        query.find(UserInfo.class).join(User::getUserInfo).where()
                .co(es -> es.get0().property(UserInfo::getName).value("yufei")).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
                .co((e0, e1) -> e0.property(UserInfo::getName).value("yufei")).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
                .co(es -> es.get1().property(User::getUserInfo).property(UserInfo::getName).value("yufei")).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
                .co((e0, e1) -> e1.property(User::getUserInfo).property(UserInfo::getName).value("yufei")).list();

        query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId).fetch().where()
                .co(es -> es.get0().accept(User2::getUsername, "yufei")).and()
                .co(es -> es.get1().accept(UserInfo2::getName, "yufei")).list();

        query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId).fetch().where()
                .co((e0, e1) -> e0.accept(User2::getUsername, "yufei")).and()
                .co((e0, e1) -> e1.accept(UserInfo2::getName, "yufei")).list();

        query.find(Tree2.class).join(Tree2.class).on(Tree2::getId, Tree2::getParentId).fetch().join2(Tree2.class)
                .on((SerializableFunction2<Tree2, Integer>) Tree2::getParentId).fetch().join2(Tree2.class)
                .on((SerializableFunction2<Tree2, Integer>) Tree2::getParentId).fetch().where()
                .co(es -> es.get0().accept(Tree2::getName, "yufei")).and()
                .co((e0, e1, e2, e3) -> e3.accept(Tree2::getName, "yufei")).list();
    }

    public void testEntityQueryJoinConditionEw() {
        // value property
        query.find(UserInfo.class).join(User::getUserInfo).where().property(UserInfo::getName).ew("yufei").list();

        // Embedded Object property
        query.find(User.class).join(User::getUserInfo).where().property(User::getEmail).property(Email::getName)
                .ew("name").and().property(User::getEmail).property(Email::getHost).ew("host").list();

        // OneToOne or ManyToOne Object property
        query.find(User.class).join(User::getUserInfo).where().property(User::getUserInfo).property(UserInfo::getName)
                .ew("yufei").list();

        // OneToMany Object property
        query.find(User.class).join(User::getUserInfo).where().property(User::getDevices).property(Device::getCode)
                .ew("device-001").list();
        query.find(User.class).join(User::getUserInfo).where()
                .ew((e0, e1) -> e0.property(User::getDevices).property(Device::getCode).value("device-001")).list();
        query.find(Tree.class).join(Tree::getParent).where().ew((e0, e1) -> e0.property(Tree::getChildren)
                .property(Tree::getChildren).property(Tree::getName).value("tree-001")).list();
        query.find(Tree.class).join(Tree::getParent).where().ew((e0, e1) -> e0.property(Tree::getChildren)
                .property(Tree::getChildren).property(Tree::getChildren).property(Tree::getName).value("tree-001"))
                .list();

        query.find(UserInfo.class).join(User::getUserInfo).where().ew(UserInfo::getName, "yufei", value -> ignore)
                .list();

        query.find(UserInfo.class).join(User::getUserInfo).where()
                .ew(es -> es.get0().property(UserInfo::getName).value("yufei")).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
                .ew((e0, e1) -> e0.property(UserInfo::getName).value("yufei")).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
                .ew(es -> es.get1().property(User::getUserInfo).property(UserInfo::getName).value("yufei")).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
                .ew((e0, e1) -> e1.property(User::getUserInfo).property(UserInfo::getName).value("yufei")).list();

        query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId).fetch().where()
                .ew(es -> es.get0().accept(User2::getUsername, "yufei")).and()
                .ew(es -> es.get1().accept(UserInfo2::getName, "yufei")).list();

        query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId).fetch().where()
                .ew((e0, e1) -> e0.accept(User2::getUsername, "yufei")).and()
                .ew((e0, e1) -> e1.accept(UserInfo2::getName, "yufei")).list();

        query.find(Tree2.class).join(Tree2.class).on(Tree2::getId, Tree2::getParentId).fetch().join2(Tree2.class)
                .on((SerializableFunction2<Tree2, Integer>) Tree2::getParentId).fetch().join2(Tree2.class)
                .on((SerializableFunction2<Tree2, Integer>) Tree2::getParentId).fetch().where()
                .ew(es -> es.get0().accept(Tree2::getName, "yufei")).and()
                .ew((e0, e1, e2, e3) -> e3.accept(Tree2::getName, "yufei")).list();
    }

    public void testEntityQueryJoinConditionSw() {
        // value property
        query.find(UserInfo.class).join(User::getUserInfo).where().property(UserInfo::getName).sw("yufei").list();

        // Embedded Object property
        query.find(User.class).join(User::getUserInfo).where().property(User::getEmail).property(Email::getName)
                .sw("name").and().property(User::getEmail).property(Email::getHost).sw("host").list();

        // OneToOne or ManyToOne Object property
        query.find(User.class).join(User::getUserInfo).where().property(User::getUserInfo).property(UserInfo::getName)
                .sw("yufei").list();

        // OneToMany Object property
        query.find(User.class).join(User::getUserInfo).where().property(User::getDevices).property(Device::getCode)
                .sw("device-001").list();
        query.find(User.class).join(User::getUserInfo).where()
                .sw((e0, e1) -> e0.property(User::getDevices).property(Device::getCode).value("device-001")).list();
        query.find(Tree.class).join(Tree::getParent).where().sw((e0, e1) -> e0.property(Tree::getChildren)
                .property(Tree::getChildren).property(Tree::getName).value("tree-001")).list();
        query.find(Tree.class).join(Tree::getParent).where().sw((e0, e1) -> e0.property(Tree::getChildren)
                .property(Tree::getChildren).property(Tree::getChildren).property(Tree::getName).value("tree-001"))
                .list();

        query.find(UserInfo.class).join(User::getUserInfo).where().sw(UserInfo::getName, "yufei", value -> ignore)
                .list();

        query.find(UserInfo.class).join(User::getUserInfo).where()
                .sw(es -> es.get0().property(UserInfo::getName).value("yufei")).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
                .sw((e0, e1) -> e0.property(UserInfo::getName).value("yufei")).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
                .sw(es -> es.get1().property(User::getUserInfo).property(UserInfo::getName).value("yufei")).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
                .sw((e0, e1) -> e1.property(User::getUserInfo).property(UserInfo::getName).value("yufei")).list();

        query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId).fetch().where()
                .sw(es -> es.get0().accept(User2::getUsername, "yufei")).and()
                .sw(es -> es.get1().accept(UserInfo2::getName, "yufei")).list();

        query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId).fetch().where()
                .sw((e0, e1) -> e0.accept(User2::getUsername, "yufei")).and()
                .sw((e0, e1) -> e1.accept(UserInfo2::getName, "yufei")).list();

        query.find(Tree2.class).join(Tree2.class).on(Tree2::getId, Tree2::getParentId).fetch().join2(Tree2.class)
                .on((SerializableFunction2<Tree2, Integer>) Tree2::getParentId).fetch().join2(Tree2.class)
                .on((SerializableFunction2<Tree2, Integer>) Tree2::getParentId).fetch().where()
                .sw(es -> es.get0().accept(Tree2::getName, "yufei")).and()
                .sw((e0, e1, e2, e3) -> e3.accept(Tree2::getName, "yufei")).list();
    }

    public void testEntityQueryJoinConditionLk() {
        // value property
        query.find(UserInfo.class).join(User::getUserInfo).where().property(UserInfo::getName).lk("yufei").list();

        // Embedded Object property
        query.find(User.class).join(User::getUserInfo).where().property(User::getEmail).property(Email::getName)
                .lk("name").and().property(User::getEmail).property(Email::getHost).lk("host").list();

        // OneToOne or ManyToOne Object property
        query.find(User.class).join(User::getUserInfo).where().property(User::getUserInfo).property(UserInfo::getName)
                .lk("yufei").list();

        // OneToMany Object property
        query.find(User.class).join(User::getUserInfo).where().property(User::getDevices).property(Device::getCode)
                .lk("device-001").list();
        query.find(User.class).join(User::getUserInfo).where()
                .lk((e0, e1) -> e0.property(User::getDevices).property(Device::getCode).value("device-001")).list();
        query.find(Tree.class).join(Tree::getParent).where().lk((e0, e1) -> e0.property(Tree::getChildren)
                .property(Tree::getChildren).property(Tree::getName).value("tree-001")).list();
        query.find(Tree.class).join(Tree::getParent).where().lk((e0, e1) -> e0.property(Tree::getChildren)
                .property(Tree::getChildren).property(Tree::getChildren).property(Tree::getName).value("tree-001"))
                .list();

        query.find(UserInfo.class).join(User::getUserInfo).where().lk(UserInfo::getName, "yufei", value -> ignore)
                .list();

        query.find(UserInfo.class).join(User::getUserInfo).where()
                .lk(es -> es.get0().property(UserInfo::getName).value("yufei")).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
                .lk((e0, e1) -> e0.property(UserInfo::getName).value("yufei")).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
                .lk(es -> es.get1().property(User::getUserInfo).property(UserInfo::getName).value("yufei")).list();
        query.find(UserInfo.class).join(User::getUserInfo).where()
                .lk((e0, e1) -> e1.property(User::getUserInfo).property(UserInfo::getName).value("yufei")).list();

        query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId).fetch().where()
                .lk(es -> es.get0().accept(User2::getUsername, "yufei")).and()
                .lk(es -> es.get1().accept(UserInfo2::getName, "yufei")).list();

        query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId).fetch().where()
                .lk((e0, e1) -> e0.accept(User2::getUsername, "yufei")).and()
                .lk((e0, e1) -> e1.accept(UserInfo2::getName, "yufei")).list();

        query.find(Tree2.class).join(Tree2.class).on(Tree2::getId, Tree2::getParentId).fetch().join2(Tree2.class)
                .on((SerializableFunction2<Tree2, Integer>) Tree2::getParentId).fetch().join2(Tree2.class)
                .on((SerializableFunction2<Tree2, Integer>) Tree2::getParentId).fetch().where()
                .lk(es -> es.get0().accept(Tree2::getName, "yufei")).and()
                .lk((e0, e1, e2, e3) -> e3.accept(Tree2::getName, "yufei")).list();
    }
}
