
/*
 * All rights Reserved, Designed By zhongj
 * @Title: TestJoin1.java
 * @Package cn.featherfly.hammer.dml.builder.sql.vo
 * @Description: TestJoin1
 * @author: zhongj
 * @date: 2022-11-24 16:38:24
 * @Copyright: 2022 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dml.builder.sql.vo.v0;

import cn.featherfly.hammer.dml.builder.sql.vo.Tree;
import cn.featherfly.hammer.dml.builder.sql.vo.User;
import cn.featherfly.hammer.dml.builder.sql.vo.UserInfo;

/**
 * TestJoin1.
 *
 * @author zhongj
 */
public class TestJoin4<E, R1, R2, R3, R4> {

    public static void main(String[] args) {
        TestJoin<Tree> testJoin = new TestJoin<>();
        testJoin.join(Tree::getParent).join(Tree::getParent);
        testJoin.join(Tree::getParent).join1(Tree::getParent).join(Tree::getUser);
        testJoin.join(Tree::getParent).join(Tree::getUser).join2(User::getUserInfo);
        testJoin.join(Tree::getUser).join1(UserInfo::getUser).join1(Tree::getUser);
    }
}
