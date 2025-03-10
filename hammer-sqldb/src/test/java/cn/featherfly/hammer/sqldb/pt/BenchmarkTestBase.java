
package cn.featherfly.hammer.sqldb.pt;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.core.config.Configurator;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.SqlExecutor;
import cn.featherfly.common.db.SqlFile;
import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.db.dialect.Dialects;
import cn.featherfly.common.db.dialect.PostgreSQLDialect;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.db.metadata.DatabaseMetadataManager;
import cn.featherfly.common.lang.ClassLoaderUtils;
import cn.featherfly.common.lang.SystemPropertyUtils;
import cn.featherfly.common.lang.UriUtils;

/**
 * JdbcTestBase.
 *
 * @author zhongj
 */
public abstract class BenchmarkTestBase {

    protected DataSource dataSource;

    protected Dialect dialect;

    protected DatabaseMetadata metadata;

    @BeforeSuite
    @Parameters({ "dataBase", "url" })
    public void init(@Optional("mysql") String dataBase,
        @Optional("jdbc:mysql://127.0.0.1:3306/hammer_jdbc?rewriteBatchedStatements=true&characterEncoding=utf8&useUnicode=true&useSSL=false&allowPublicKeyRetrieval=true") String url)
        throws IOException {
        Configurator.initialize("log4j2_none", "log4j2_none.xml");

        initDataBase(dataBase, url);

        metadata = DatabaseMetadataManager.getDefaultManager().reCreate(dataSource);

        //        System.err.println(url);
        System.err.println("jdk " + SystemPropertyUtils.getJavaVersion());
        System.err.println("supportsBatchUpdates = " + metadata.getFeatures().supportsBatchUpdates());
    }

    public void initDataBase(String dataBase, String url) throws IOException {
        System.err.println("***********************************************");
        System.err.println("***********************************************");
        //        configFile = String.format(CONFIG_FILE_PATTERN, dataBase);
        switch (dataBase) {
            case "mysql":
                initMysql(url);
                break;
            case "postgresql":
                initPostgresql(url);
                break;
            case "sqlite":
                initSQLite(url);
                break;
            default:
                initMysql(url);
                //                configFile = String.format(CONFIG_FILE_PATTERN, "mysql");
                break;
        }
        System.err.println("***********************************************");
        System.err.println("***********************************************");
    }

    //    @BeforeSuite(groups = "mysql", dependsOnMethods = "init")
    public void initMysql(String url) throws IOException {
        System.err.println("initMysql");
        //        ConstantConfigurator.config();
        //        ConstantConfigurator.config("constant.mysql.yaml");

        BasicDataSource ds = new BasicDataSource();
        //        ds.setUrl("jdbc:mysql://127.0.0.1:3306/hammer_jdbc?characterEncoding=utf8&useUnicode=true&useSSL=false");
        ds.setUrl(url);
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUsername("root");
        ds.setPassword("123456");
        dataSource = ds;

        // 初始化数据库
        SqlExecutor sqlExecutor = new SqlExecutor(ds);
        sqlExecutor.execute(SqlFile.read(ClassLoaderUtils.getResource("test.mysql.sql", this.getClass())));

        dialect = Dialects.mysql();
    }

    //    @BeforeSuite(groups = "postgresql", dependsOnMethods = "init")
    public void initPostgresql(String url) throws IOException {
        System.err.println("initPostgresql");
        //        ConstantConfigurator.config("constant.postgresql.yaml");

        BasicDataSource ds = new BasicDataSource();
        //        ds.setUrl("jdbc:postgresql://localhost:5432/hammer_jdbc");
        //        ds.setUrl("jdbc:postgresql://::1:5432/hammer_jdbc"); // install postgresql in wsl with docker
        ds.setUrl(url); // install postgresql in wsl with docker
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUsername("postgres");
        ds.setPassword("123456");
        dataSource = ds;

        //        PostgreSQLDialect postgreSQLDialect = Dialects.POSTGRESQL;
        //        postgreSQLDialect.setTableAndColumnNameUppercase(false);
        //        jdbc = new SpringJdbcTemplateImpl(dataSource, postgreSQLDialect);

        // 初始化数据库
        SqlExecutor sqlExecutor = new SqlExecutor(ds);
        //        sqlExecutor
        //                .execute(new File(ClassLoaderUtils.getResource("test.postgresql.sql", JdbcTestBase.class).getFile()));
        sqlExecutor.execute(SqlFile.read(ClassLoaderUtils.getResource("test.postgresql.sql", this.getClass())));

        PostgreSQLDialect postgreSQLDialect = new PostgreSQLDialect();
        //        postgreSQLDialect.setTableAndColumnNameUppercase(StringConverter.UPPER_CASE);
        dialect = postgreSQLDialect;
    }

    //    @BeforeSuite(groups = "sqlite", dependsOnMethods = "init")
    public void initSQLite(String url) throws IOException {
        System.err.println("initSQLite");
        //        ConstantConfigurator.config("constant.sqlite.yaml");

        String path = new File(UriUtils.linkUri(this.getClass().getResource("/").getFile(), "hammer.sqlite3.db"))
            .getPath();
        System.out.println(path);
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("org.sqlite.JDBC");
        ds.setUrl("jdbc:sqlite:" + path);
        //        dataSource.setUsername("root");
        //        dataSource.setPassword("123456");
        dataSource = ds;

        // 初始化数据库
        SqlExecutor sqlExecutor = new SqlExecutor(ds);
        //        sqlExecutor.execute(new File(ClassLoaderUtils.getResource("test.sqlite.sql", JdbcTestBase.class).getFile()));
        sqlExecutor.execute(SqlFile.read(ClassLoaderUtils.getResource("test.sqlite.sql", this.getClass())));

        dialect = Dialects.sqlite();

    }

    protected Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new JdbcException(e);
        }
    }

}
