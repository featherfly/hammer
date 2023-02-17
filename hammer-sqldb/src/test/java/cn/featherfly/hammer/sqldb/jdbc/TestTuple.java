
/*
 * All rights Reserved, Designed By zhongj
 * @Title: TestTuple.java
 * @Package cn.featherfly.hammer.sqldb.jdbc
 * @Description: TestTuple
 * @author: zhongj
 * @date: 2023-02-17 16:10:17
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc;

import java.util.List;
import java.util.stream.Collectors;

import com.speedment.common.tuple.Tuple;
import com.speedment.common.tuple.Tuple3;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.Strings;

/**
 * TestTuple.
 *
 * @author zhongj
 */
public class TestTuple {
    /**
     * Query single.
     *
     * @param sql  sql
     * @param args args
     * @return map
     */
    @SuppressWarnings("unchecked")
    <E extends Tuple> E querySingle(String sql, Object... params) {
        return (E) Tuples.of("aa", "bb", 1);
    }

    public static void main(String[] args) {
        TestTuple t = new TestTuple();
        Tuple3<String, String, Integer> result = t.querySingle("");
        System.out.println(result.get0());
        System.out.println(result.get1());
        System.out.println(result.get2());

        List<Object> list = result.stream().collect(Collectors.toList());
        Lang.each(list, (e, i) -> System.out.println(Strings.format("index[{0}] value[{1}]", i, e)));

        Tuple3<String, Integer, String> result2 = t.querySingle("");
        System.out.println(result2.get0());
        Integer i = result2.get1();
        System.out.println(i);
        System.out.println(result2.get2());
    }
}
