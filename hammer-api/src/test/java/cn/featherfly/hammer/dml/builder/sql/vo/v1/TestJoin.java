
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

/**
 * TestJoin.
 *
 * @author zhongj
 */
public class TestJoin<E> {

    public <R1> TestJoin1<E, R1> join(SerializableFunction<E, R1> property) {
        return new TestJoin1<>();
    }

    public TestJoinSelf1<E> join(SerializableFunction1<E, E> property) {
        return new TestJoinSelf1<>();
    }
}
