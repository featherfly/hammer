
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

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableFunction1;
import cn.featherfly.common.lang.function.SerializableFunction2;

/**
 * TestJoin1.
 *
 * @author zhongj
 */
public class TestJoin2<E, R1, R2> {

    public <R3> TestJoin3<E, R1, R2, R3> join(SerializableFunction<E, R3> property) {
        return new TestJoin3<>();
    }

    public <R3> TestJoin3<E, R1, R2, R3> join(SerializableFunction1<R3, E> property) {
        return new TestJoin3<>();
    }

    public TestJoin3<E, R1, R2, E> join(SerializableFunction2<E, E> property) {
        return new TestJoin3<>();
    }

    public <R3> TestJoin3<E, R1, R2, R3> join1(SerializableFunction<R1, R3> property) {
        return new TestJoin3<>();
    }

    public <R3> TestJoin3<E, R1, R2, R3> join1(SerializableFunction1<R3, R1> property) {
        return new TestJoin3<>();
    }

    public TestJoin3<E, R1, R2, R1> join1(SerializableFunction2<R1, R1> property) {
        return new TestJoin3<>();
    }

    public <R3> TestJoin3<E, R1, R2, R3> join2(SerializableFunction<R2, R3> property) {
        return new TestJoin3<>();
    }

    public <R3> TestJoin3<E, R1, R2, R3> join2(SerializableFunction1<R3, R2> property) {
        return new TestJoin3<>();
    }

    public TestJoin3<E, R1, R2, R1> join2(SerializableFunction2<R2, R2> property) {
        return new TestJoin3<>();
    }
}
