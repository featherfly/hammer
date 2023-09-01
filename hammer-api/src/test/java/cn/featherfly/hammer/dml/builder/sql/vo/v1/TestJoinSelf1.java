
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
public class TestJoinSelf1<E> {

    public <R2> TestJoin2<E, E, R2> join(SerializableFunction<E, R2> property) {
        return new TestJoin2<>();
    }

    public <R2> TestJoin2<E, E, R2> join(SerializableFunction1<R2, E> property) {
        return new TestJoin2<>();
    }

    public TestJoinSelf2<E> join(SerializableFunction2<E, E> property) {
        return new TestJoinSelf2<>();
    }
}
