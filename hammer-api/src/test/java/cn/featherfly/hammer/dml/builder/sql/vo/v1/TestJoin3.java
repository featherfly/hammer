
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

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableFunction1;
import cn.featherfly.common.function.serializable.SerializableFunction2;
import cn.featherfly.common.function.serializable.SerializableFunction3;
import cn.featherfly.common.function.serializable.SerializableFunction4;
import cn.featherfly.common.function.serializable.SerializableFunction5;
import cn.featherfly.common.function.serializable.SerializableFunction6;
import cn.featherfly.common.function.serializable.SerializableFunction7;
import cn.featherfly.common.function.serializable.SerializableFunction8;

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

    public <R4> TestJoin4<E, R1, R2, R3, R4> join(SerializableFunction3<R1, R4> property) {
        return new TestJoin4<>();
    }

    public <R4> TestJoin4<E, R1, R2, R3, R4> join(SerializableFunction4<R4, R1> property) {
        return new TestJoin4<>();
    }

    public TestJoin4<E, R1, R2, R3, R1> join(SerializableFunction5<R1, R1> property) {
        return new TestJoin4<>();
    }

    public <R4> TestJoin4<E, R1, R2, R3, R4> join(SerializableFunction6<R2, R4> property) {
        return new TestJoin4<>();
    }

    public <R4> TestJoin4<E, R1, R2, R3, R4> join(SerializableFunction7<R4, R2> property) {
        return new TestJoin4<>();
    }

    public TestJoin4<E, R1, R2, R3, R1> join(SerializableFunction8<R2, R2> property) {
        return new TestJoin4<>();
    }
}
