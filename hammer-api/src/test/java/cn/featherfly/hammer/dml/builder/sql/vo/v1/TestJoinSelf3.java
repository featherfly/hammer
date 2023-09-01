
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

/**
 * TestJoin1.
 *
 * @author zhongj
 */
public class TestJoinSelf3<E> {

    public <R4> TestJoin4<E, E, E, E, R4> join(SerializableFunction<E, R4> property) {
        return new TestJoin4<>();
    }

    public <R4> TestJoin4<E, E, E, E, R4> join(SerializableFunction1<R4, E> property) {
        return new TestJoin4<>();
    }

    public TestJoin4<E, E, E, E, E> join(SerializableFunction2<E, E> property) {
        return new TestJoin4<>();
    }
}
