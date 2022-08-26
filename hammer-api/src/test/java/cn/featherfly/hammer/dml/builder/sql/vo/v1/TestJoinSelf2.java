
/*
 * All rights Reserved, Designed By zhongj
 * @Title: TestJoin1.java
 * @Package cn.featherfly.hammer.dml.builder.sql.vo
 * @Description: TestJoin1
 * @author: zhongj
 * @date: 2022-11-24 16:38:24
 * @Copyright: 2022 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dml.builder.sql.vo.v1;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableFunction1;
import cn.featherfly.common.lang.function.SerializableFunction2;

/**
 * TestJoin1.
 *
 * @author zhongj
 */
public class TestJoinSelf2<E> {

    public <R3> TestJoin3<E, E, E, R3> join(SerializableFunction<E, R3> property) {
        return new TestJoin3<>();
    }

    public <R3> TestJoin3<E, E, E, R3> join(SerializableFunction1<R3, E> property) {
        return new TestJoin3<>();
    }

    public TestJoinSelf3<E> join(SerializableFunction2<E, E> property) {
        return new TestJoinSelf3<>();
    }
}
