
package cn.featherfly.hammer.sqldb.jdbc;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.TestInstance;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import cn.featherfly.common.bean.AsmPropertyAccessorFactory;
import cn.featherfly.common.bean.PropertyAccessorFactory;
import cn.featherfly.common.db.wrapper.CascadedCloseDataSource;
import cn.featherfly.common.lang.Timer;
import cn.featherfly.common.lang.debug.TableMessage;
import cn.featherfly.common.structure.ChainMapImpl;
import cn.featherfly.common.structure.ChainSetImpl;
import cn.featherfly.common.tuple.Tuple3;
import cn.featherfly.common.tuple.Tuples;

/**
 * TestBase.
 *
 * @author zhongj
 */
public class TestBase {

    protected String name1 = "羽飞";
    protected String username1 = "yufei";

    protected String name2 = "翼";
    protected String username2 = "featherfly";
    protected int age2 = 5;

    public boolean devMode = true;

    // 高版本mysql-connector已经不需要serverTimezone=CTT
    // "jdbc:mysql://127.0.0.1:3306/hammer_jdbc?serverTimezone=CTT&characterEncoding=utf8&useUnicode=true&useSSL=false"
    protected static final String MYSQL_URL =
        "jdbc:mysql://127.0.0.1:3306/hammer_jdbc?rewriteBatchedStatements=true&characterEncoding=utf8&useUnicode=true&useSSL=false&allowPublicKeyRetrieval=true";
    protected static final String MYSQL_USER = "root";
    protected static final String MYSQL_PWD = "123456";

    protected static String jdbcDriverName;
    protected static String jdbcUrl;
    protected static String jdbcUsername;
    protected static String jdbcPassword;

    private boolean cascadeWrpper = false;

    protected static final PropertyAccessorFactory PROPERTY_ACCESSOR_FACTORY = new AsmPropertyAccessorFactory(
        Thread.currentThread().getContextClassLoader());

    @BeforeSuite
    @Parameters({ "devMode" })
    public void _beforeSuite(@Optional("mysql") boolean devMode) throws IOException {
        this.devMode = devMode;
    }

    @BeforeTest
    public void _beforeTest() {
        System.err
            .println("currentThread: " + Thread.currentThread().getId() + " - " + Thread.currentThread().getName());
    }

    Timer timer;

    static final Map<String, List<Tuple3<String, String, Long>>> TEST_INFOS = new LinkedHashMap<>();

    //    List<Tuple3<String, String, Long>> testInfo = new ArrayList<>();

    static final Map<String, TableMessage> MESSAGES = new LinkedHashMap<>();

    @BeforeMethod
    public void _beforeMethod() {
        timer = Timer.start();
    }

    @AfterMethod
    public void _afterMethod(@TestInstance Method method) {
        long time = timer.stop();
        String type = this.getClass().getName();
        TEST_INFOS.get(type).add(Tuples.of(type, method.getName(), time));
        //        System.err.println(Str.format("use time {0}", time));
    }

    @BeforeClass
    public void _beforeClass() {
        TEST_INFOS.put(this.getClass().getName(), new ArrayList<>());
    }

    @AfterClass
    public void _afterClass() {
        String type = this.getClass().getName();
        TableMessage tableMessage = new TableMessage(
            new ChainSetImpl<String>(new LinkedHashSet<>()).addChain("class", "method", "time"));
        for (Tuple3<String, String, Long> testInfo : TEST_INFOS.get(type)) {
            tableMessage.addRow(new ChainMapImpl<String, Object>().putChain("class", testInfo.get0())
                .putChain("method", testInfo.get1()).putChain("time", testInfo.get2()));
        }
        MESSAGES.put(type, tableMessage);
        //        System.err.println(tableMessage.toString());
    }

    @AfterSuite
    @Parameters("showTime")
    public void _afterSuite(@Optional("true") boolean showTime) {
        if (showTime) {
            for (Entry<String, TableMessage> entry : MESSAGES.entrySet()) {
                System.err.println(entry.getValue());
            }
        }
    }

    protected DataSource initDataSource() {
        return initDataSource("dbcp");
    }

    protected DataSource initDataSource(String pool) {
        DataSource dataSource = null;
        switch (pool) {
            case "dbcp":
                dataSource = initDbcp();
                break;
            case "hikari":
                dataSource = initHikari();
                break;
            default:
                dataSource = initDbcp();
        }
        if (cascadeWrpper) {
            return new CascadedCloseDataSource(dataSource);
        } else {
            return dataSource;
        }
    }

    private DataSource initDbcp() {
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(jdbcUrl);
        ds.setDriverClassName(jdbcDriverName);
        ds.setUsername(jdbcUsername);
        ds.setPassword(jdbcPassword);
        return ds;
    }

    private DataSource initHikari() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(jdbcUrl);
        config.setDriverClassName(jdbcDriverName);
        config.setUsername(jdbcUsername);
        config.setPassword(jdbcPassword);
        return new HikariDataSource(config);
    }
}
