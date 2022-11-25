
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
import cn.featherfly.common.lang.function.SerializableFunction3;
import cn.featherfly.common.lang.function.SerializableFunction4;
import cn.featherfly.common.lang.function.SerializableFunction5;

/**
 * TestJoin1.
 *
 * @author zhongj
 */
public class TestJoin1<E, R1> {

    public <R2> TestJoin2<E, R1, R2> join(SerializableFunction<E, R2> property) {
        return new TestJoin2<>();
    }

    public <R2> TestJoin2<E, R1, R2> join(SerializableFunction1<R2, E> property) {
        return new TestJoin2<>();
    }

    public TestJoin2<E, R1, E> join(SerializableFunction2<E, E> property) {
        return new TestJoin2<>();
    }

    public <R2> TestJoin2<E, R1, R2> join(SerializableFunction3<R1, R2> property) {
        return new TestJoin2<>();
    }

    public <R2> TestJoin2<E, R1, R2> join(SerializableFunction4<R2, R1> property) {
        return new TestJoin2<>();
    }

    public TestJoin2<E, R1, R1> join(SerializableFunction5<R1, R1> property) {
        return new TestJoin2<>();
    }
}
