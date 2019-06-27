
package cn.featherfly.juorm.dml.builder.sql;

import cn.featherfly.juorm.dsl.query.Data;
import cn.featherfly.juorm.dsl.query.Query;

/**
 * <p>
 * DslTest
 * </p>
 *
 * @author zhongj
 */
public class DslTest {

    public void testQuery() {
        Query query = null;
        Data data = null;

        query.find(data).list(DslTest.class);
        query.find(data).limit(10).list(DslTest.class);
        query.find(data).limit(1).single(DslTest.class);

        query.find(data).property("name").number(Integer.class);
        query.find(data).property("name").integer();
        query.find(data).property("sum(price)").decimal();

        query.find(data).property("count(*)").where().lt("age", 18).longInt();

        query.find(data).property("name").where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80)
                .limit(11, 10).list(DslTest.class);

        query.find(data).where().eq("", 1).and().lt("age", 18).and().group().gt("score", 80).single(DslTest.class);

    }
}
