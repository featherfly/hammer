
package cn.featherfly.hammer.sqldb.sql.model;

import org.testng.annotations.Test;

import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.hammer.operator.QueryOperator;
import cn.featherfly.hammer.sqldb.sql.dialect.Dialects;
import cn.featherfly.hammer.sqldb.sql.model.ConditionColumnElement;

/**
 * <p>
 * ConditionColumnElementTest
 * </p>
 *
 * @author zhongj
 */
public class ConditionColumnElementTest {

    void print(ConditionColumnElement c) {
        System.out.println(c);
        System.out.println(c.getParam());
    }

    @Test
    void test() {
        ConditionColumnElement c = new ConditionColumnElement(Dialects.MYSQL, "username", "yufei", QueryOperator.EQ);
        print(c);
        c = new ConditionColumnElement(Dialects.MYSQL, "username", "yufei", QueryOperator.EQ, "u");
        print(c);
        c = new ConditionColumnElement(Dialects.MYSQL, "age", 18, QueryOperator.LT);
        print(c);
        c = new ConditionColumnElement(Dialects.MYSQL, "age", 18, QueryOperator.LT, "u");
        print(c);
        c = new ConditionColumnElement(Dialects.MYSQL, "age", 19, QueryOperator.LE);
        print(c);
        c = new ConditionColumnElement(Dialects.MYSQL, "age", 19, QueryOperator.LE, "u");
        print(c);
        c = new ConditionColumnElement(Dialects.MYSQL, "age", 17, QueryOperator.GE);
        print(c);
        c = new ConditionColumnElement(Dialects.MYSQL, "age", 17, QueryOperator.GE, "u");
        print(c);
        c = new ConditionColumnElement(Dialects.MYSQL, "age", 16, QueryOperator.GT);
        print(c);
        c = new ConditionColumnElement(Dialects.MYSQL, "age", 16, QueryOperator.GT, "u");
        print(c);
        c = new ConditionColumnElement(Dialects.MYSQL, "age", 15, QueryOperator.NE);
        print(c);
        c = new ConditionColumnElement(Dialects.MYSQL, "age", 15, QueryOperator.NE, "u");
        print(c);
        c = new ConditionColumnElement(Dialects.MYSQL, "name", "yi", QueryOperator.CO);
        print(c);
        c = new ConditionColumnElement(Dialects.MYSQL, "name", "yi", QueryOperator.CO, "u");
        print(c);
        c = new ConditionColumnElement(Dialects.MYSQL, "name", "fea", QueryOperator.SW);
        print(c);
        c = new ConditionColumnElement(Dialects.MYSQL, "name", "fea", QueryOperator.SW, "u");
        print(c);
        c = new ConditionColumnElement(Dialects.MYSQL, "name", "fly", QueryOperator.EW);
        print(c);
        c = new ConditionColumnElement(Dialects.MYSQL, "name", "fly", QueryOperator.EW, "u");
        print(c);
        c = new ConditionColumnElement(Dialects.MYSQL, "mobile", "132", QueryOperator.ISN);
        print(c);
        c = new ConditionColumnElement(Dialects.MYSQL, "mobile", "132", QueryOperator.ISN, "u");
        print(c);
        c = new ConditionColumnElement(Dialects.MYSQL, "mobile", "189", QueryOperator.INN);
        print(c);
        c = new ConditionColumnElement(Dialects.MYSQL, "mobile", "189", QueryOperator.INN, "u");
        print(c);
        c = new ConditionColumnElement(Dialects.MYSQL, "tag", ArrayUtils.toList(new String[] { "a", "b" }),
                QueryOperator.IN);
        print(c);
        c = new ConditionColumnElement(Dialects.MYSQL, "tag", ArrayUtils.toList(new String[] { "a", "b" }),
                QueryOperator.IN, "u");
        print(c);
        c = new ConditionColumnElement(Dialects.MYSQL, "tag", ArrayUtils.toList(new String[] { "c", "d" }),
                QueryOperator.NIN);
        print(c);
        c = new ConditionColumnElement(Dialects.MYSQL, "tag", ArrayUtils.toList(new String[] { "c", "d" }),
                QueryOperator.NIN, "u");
        print(c);
    }
}
