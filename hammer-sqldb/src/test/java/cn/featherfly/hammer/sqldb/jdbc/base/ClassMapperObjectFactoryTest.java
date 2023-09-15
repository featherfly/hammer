
/*
 * All rights Reserved, Designed By zhongj
 * @Title: CoverageTest.java
 * @Package cn.featherfly.hammer.sqldb.jdbc
 * @Description: CoverageTest
 * @author: zhongj
 * @date: 2023-02-09 15:34:09
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.base;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import cn.featherfly.hammer.sqldb.jdbc.ClassMapperObjectFactory;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;

/**
 * ClassMapperObjectFactoryTest.
 *
 * @author zhongj
 */
public class ClassMapperObjectFactoryTest {

    @Test
    public void testCoverage() {
        ClassMapperObjectFactory<User> f = new ClassMapperObjectFactory<>(User.class);
        assertEquals(f.getMappedClass(), User.class);
    }
}
