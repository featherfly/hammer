
/*
 * All rights Reserved, Designed By zhongj
 * @Title: TestngListener.java
 * @Package cn.featherfly.hammer.sqldb
 * @Description: todo (用一句话描述该文件做什么)
 * @author: zhongj
 * @date: 2021-05-31 18:35:31
 * @Copyright: 2021 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb;

import java.util.List;

import org.testng.IAlterSuiteListener;
import org.testng.xml.XmlSuite;

import cn.featherfly.common.lang.Strings;

/**
 * TestngListener.
 *
 * @author zhongj
 */
public class TestngListener implements IAlterSuiteListener {

    private static final String PARAM_DB_NAME = "dataBase";

    @Override
    public void alter(List<XmlSuite> suites) {
        XmlSuite suite = suites.get(0);
        setDatabaseName(suite, null);
    }

    private void setDatabaseName(XmlSuite suite, String dataBase) {
        String db = suite.getParameter(PARAM_DB_NAME);
        dataBase = db == null ? dataBase : db;
        for (XmlSuite xmlSuite : suite.getChildSuites()) {
            if (db != null) {
                xmlSuite.setName(Strings.format(xmlSuite.getName(), dataBase));
            }
            setDatabaseName(xmlSuite, dataBase);
        }
    }

}
