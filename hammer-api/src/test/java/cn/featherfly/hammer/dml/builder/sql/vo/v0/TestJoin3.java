
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

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableFunction1;
import cn.featherfly.common.function.serializable.SerializableFunction2;

/**
 * TestJoin1.
 *
 * @author zhongj
 */
public class TestJoin3<E, R1, R2, R3> {

    public <R4> TestJoin4<E, R1, R2, R3, R4> join(SerializableFunction<E, R4> property) {
        return new TestJoin4<>();
    }

    public <R4> TestJoin4<E, R1, R2, R3, R4> join(SerializableFunction1<R4, E> property) {
        return new TestJoin4<>();
    }

    public TestJoin4<E, R1, R2, R3, E> join(SerializableFunction2<E, E> property) {
        return new TestJoin4<>();
    }

    public <R4> TestJoin4<E, R1, R2, R3, R4> join1(SerializableFunction<R1, R4> property) {
        return new TestJoin4<>();
    }

    public <R4> TestJoin4<E, R1, R2, R3, R4> join1(SerializableFunction1<R4, R1> property) {
        return new TestJoin4<>();
    }

    public TestJoin4<E, R1, R2, R3, R1> join1(SerializableFunction2<R1, R1> property) {
        return new TestJoin4<>();
    }

    public <R4> TestJoin4<E, R1, R2, R3, R4> join2(SerializableFunction<R2, R4> property) {
        return new TestJoin4<>();
    }

    public <R4> TestJoin4<E, R1, R2, R3, R4> join2(SerializableFunction1<R4, R2> property) {
        return new TestJoin4<>();
    }

    public TestJoin4<E, R1, R2, R3, R2> join2(SerializableFunction2<R2, R2> property) {
        return new TestJoin4<>();
    }

    public <R4> TestJoin4<E, R1, R2, R3, R4> join3(SerializableFunction<R3, R4> property) {
        return new TestJoin4<>();
    }

    public <R4> TestJoin4<E, R1, R2, R3, R4> join3(SerializableFunction1<R4, R3> property) {
        return new TestJoin4<>();
    }

    public TestJoin4<E, R1, R2, R3, R3> join3(SerializableFunction2<R3, R3> property) {
        return new TestJoin4<>();
    }
}
