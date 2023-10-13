
/*
 * All rights Reserved, Designed By zhongj
 * @Title: Benchmark.java
 * @Description: Benchmark
 * @author: zhongj
 * @date: 2023-08-23 15:37:23
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.pt;

/**
 * Benchmark.
 *
 * @author zhongj
 */
public interface Benchmark {

    void testInsertOne();

    void testInsertOneMulitiTimes();

    void testInsertBatch();

    void testSelectById();

    void testSelectByIdMulitiTimes();
}
