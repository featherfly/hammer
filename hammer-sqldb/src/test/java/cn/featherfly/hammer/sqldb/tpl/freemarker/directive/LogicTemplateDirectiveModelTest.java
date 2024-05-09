
/*
 * All rights Reserved, Designed By zhongj
 * @Title: AndTemplateDirectiveModelTest.java
 * @Package cn.featherfly.hammer.sqldb.tpl.freemarker.directive
 * @Description: todo (用一句话描述该文件做什么)
 * @author: zhongj
 * @date: 2021-08-11 11:48:11
 * @Copyright: 2021 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.tpl.freemarker.directive;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.annotations.Test;

import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.hammer.tpl.supports.ConditionParamsManager;

/**
 * AndTemplateDirectiveModelTest.
 *
 * @author zhongj
 */
public class LogicTemplateDirectiveModelTest {
    //  private static final Pattern CONDITION_PATTERN = Pattern.compile(
    //            "(\\w*\\.?[\\[`'\"]?\\w+[\\]`'\"]?) *(([=><]|<>|!=|>=|<=|!>|!<| like | in | is ) *(:\\w+|\\?)|(between) +(:\\w+|\\?) *(and) *(:\\w+|\\?))",
    //            Pattern.CASE_INSENSITIVE);

    Pattern conditionPattern;

    Method getParamName;

    AndTemplateDirectiveModel templateDirectiveModel = new AndTemplateDirectiveModel(
            new ConditionParamsManager(i -> "argu" + i));

    public LogicTemplateDirectiveModelTest()
            throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException, SecurityException {
        Field field = ClassUtils.getField(LogicTemplateDirectiveModel.class, "CONDITION_PATTERN");
        field.setAccessible(true);
        conditionPattern = (Pattern) field.get(LogicTemplateDirectiveModel.class);

        getParamName = LogicTemplateDirectiveModel.class.getDeclaredMethod("getParamName", String.class, String.class);
        getParamName.setAccessible(true);
    }

    private String getParamName(String name, String condition)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        return (String) getParamName.invoke(templateDirectiveModel, name, condition);
    }

    @Test
    public void testConditionPattern() {
        Matcher m = null;

        m = conditionPattern.matcher("user_id = :userId");
        assertTrue(m.matches());
        m = conditionPattern.matcher("`user_id` = :userId");
        assertTrue(m.matches());

        m = conditionPattern.matcher("'user_id' = :userId");
        assertTrue(m.matches());

        m = conditionPattern.matcher("\"user_id\" = :userId");
        assertTrue(m.matches());

        m = conditionPattern.matcher("[user_id] = :userId");
        assertTrue(m.matches());

        m = conditionPattern.matcher("u.user_id = :userId");
        assertTrue(m.matches());

        m = conditionPattern.matcher("u.`user_id` = :userId");
        assertTrue(m.matches());

        m = conditionPattern.matcher("u.\"user_id\" = :userId");
        assertTrue(m.matches());

        m = conditionPattern.matcher("u.'user_id' = :userId");
        assertTrue(m.matches());

        m = conditionPattern.matcher("u.[user_id] = :userId");
        assertTrue(m.matches());
    }

    @Test
    public void testGetParamName() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String name = getParamName(null, "ids in :ids");
        assertEquals(name, "ids");
    }
}
