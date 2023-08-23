
package cn.featherfly.hammer.sqldb.jdbc;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.SqlExecutor;
import cn.featherfly.common.db.SqlFile;
import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.db.dialect.Dialects;
import cn.featherfly.common.db.dialect.PostgreSQLDialect;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.db.mapping.JdbcMappingFactoryImpl;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.db.metadata.DatabaseMetadataManager;
import cn.featherfly.common.lang.ClassLoaderUtils;
import cn.featherfly.common.lang.Randoms;
import cn.featherfly.common.lang.UriUtils;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Role;
import cn.featherfly.hammer.tpl.TplConfigFactory;
import cn.featherfly.hammer.tpl.TplConfigFactoryImpl;
import cn.featherfly.hammer.tpl.freemarker.FreemarkerTemplatePreProcessor;

/**
 * JdbcTestBase.
 *
 * @author zhongj
 */
public class JdbcTestBase extends TestBase {

    private static final String CONFIG_FILE_PATTERN = "constant.%s.yaml";

    public static String configFile = "";

    //    public static final String CONFIG_FILE = "constant.mysql.yaml";
    //    public static final String CONFIG_FILE = "constant.postgresql.yaml";
    //    public static final String CONFIG_FILE = "constant.sqlite.yaml";

    protected static Jdbc jdbc;

    protected static JdbcMappingFactory mappingFactory;

    protected static TplConfigFactory configFactory;

    protected static DatabaseMetadata metadata;

    protected static SqlPageFactory sqlPageFactory = new SimpleSqlPageFactory();

    protected static DataSource dataSource;

    protected static Dialect dialect;

    protected static SqlTypeMappingManager sqlTypeMappingManager;

    protected static JdbcFactory jdbcFactory;

    @BeforeSuite
    @Parameters({ "dataBase" })
    public void init(@Optional("mysql") String dataBase) throws IOException {
        DOMConfigurator.configure(ClassLoaderUtils.getResource("log4j_dev.xml", this.getClass()));

        sqlTypeMappingManager = new SqlTypeMappingManager();

        initDataBase(dataBase);

        Set<String> basePackages = new HashSet<>();
        basePackages.add("cn.featherfly.hammer");

        configFactory = new TplConfigFactoryImpl("tpl/", ".yaml.tpl", basePackages,
                new FreemarkerTemplatePreProcessor());

        jdbcFactory = new JdbcFactoryImpl(dialect, sqlTypeMappingManager);

    }

    public void initDataBase(String dataBase) throws IOException {
        System.err.println("***********************************************");
        System.err.println("***********************************************");
        configFile = String.format(CONFIG_FILE_PATTERN, dataBase);
        switch (dataBase) {
            case "mysql":
                initMysql();
                break;
            case "postgresql":
                initPostgresql();
                break;
            case "sqlite":
                initSQLite();
                break;
            default:
                initMysql();
                configFile = String.format(CONFIG_FILE_PATTERN, "mysql");
                break;
        }
        System.err.println("***********************************************");
        System.err.println("***********************************************");
    }

    //    @BeforeSuite(groups = "mysql", dependsOnMethods = "init")
    public void initMysql() throws IOException {
        System.err.println("initMysql");
        //        ConstantConfigurator.config();
        //        ConstantConfigurator.config("constant.mysql.yaml");

        BasicDataSource ds = new BasicDataSource();
        //        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/hammer_jdbc?useUnicode=true&characterEncoding=UTF-8");
        //        ds.setUrl(
        //                "jdbc:mysql://127.0.0.1:3306/hammer_jdbc?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false");
        //        ds.setUrl(
        //                "jdbc:mysql://127.0.0.1:3306/hammer_jdbc?serverTimezone=CTT&characterEncoding=utf8&useUnicode=true&useSSL=false");
        // 高版本mysql-connector已经不需要serverTimezone=CTT
        ds.setUrl("jdbc:mysql://127.0.0.1:3306/hammer_jdbc?characterEncoding=utf8&useUnicode=true&useSSL=false");
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUsername("root");
        ds.setPassword("123456");
        dataSource = ds;

        // 初始化数据库
        SqlExecutor sqlExecutor = new SqlExecutor(ds);
        sqlExecutor.execute(SqlFile.read(ClassLoaderUtils.getResource("test.mysql.sql", this.getClass())));

        dialect = Dialects.MYSQL;

        //        jdbc = new SpringJdbcTemplateImpl(ds, dialect);
        //        jdbc = new JdbcImpl(ds, dialect, sqlTypeMappingManager);
        jdbc = new JdbcSpringImpl(ds, dialect, sqlTypeMappingManager);
        metadata = DatabaseMetadataManager.getDefaultManager().create(ds);

        mappingFactory = new JdbcMappingFactoryImpl(metadata, dialect, sqlTypeMappingManager);

        // factory.getClassNameConversions().add(new ClassNameJpaConversion());
        // factory.getClassNameConversions().add(new
        // ClassNameUnderlineConversion());
        // factory.getPropertyNameConversions().add(new
        // PropertyNameJpaConversion());
        // factory.getPropertyNameConversions().add(new
        // PropertyNameUnderlineConversion());
    }

    //    @BeforeSuite(groups = "postgresql", dependsOnMethods = "init")
    public void initPostgresql() throws IOException {
        System.err.println("initPostgresql");
        //        ConstantConfigurator.config("constant.postgresql.yaml");

        BasicDataSource ds = new BasicDataSource();
        //        ds.setUrl("jdbc:postgresql://localhost:5432/hammer_jdbc");
        ds.setUrl("jdbc:postgresql://::1:5432/hammer_jdbc"); // install postgresql in wsl with docker
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
        //                .execute(new File(ClassLoaderUtils.getResource("test.postgresql.sql", this.getClass()).getFile()));
        sqlExecutor.execute(SqlFile.read(ClassLoaderUtils.getResource("test.postgresql.sql", this.getClass())));

        PostgreSQLDialect postgreSQLDialect = new PostgreSQLDialect();
        //        postgreSQLDialect.setTableAndColumnNameUppercase(StringConverter.UPPER_CASE);
        dialect = postgreSQLDialect;

        //        jdbc = new SpringJdbcTemplateImpl(ds, dialect);
        jdbc = new JdbcSpringImpl(ds, dialect, sqlTypeMappingManager);
        metadata = DatabaseMetadataManager.getDefaultManager().create(ds);

        mappingFactory = new JdbcMappingFactoryImpl(metadata, dialect, sqlTypeMappingManager);

    }

    //    @BeforeSuite(groups = "sqlite", dependsOnMethods = "init")
    public void initSQLite() throws IOException {
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
        //        sqlExecutor.execute(new File(ClassLoaderUtils.getResource("test.sqlite.sql", this.getClass()).getFile()));
        sqlExecutor.execute(SqlFile.read(ClassLoaderUtils.getResource("test.sqlite.sql", this.getClass())));

        dialect = Dialects.SQLITE;

        //        jdbc = new SpringJdbcTemplateImpl(ds, dialect);
        jdbc = new JdbcSpringImpl(ds, dialect, sqlTypeMappingManager);
        metadata = DatabaseMetadataManager.getDefaultManager().create(ds, "main");

        mappingFactory = new JdbcMappingFactoryImpl(metadata, dialect, sqlTypeMappingManager);

    }

    protected Role role() {
        Role r = new Role();
        r.setName("n_" + Randoms.getInt(100));
        r.setDescp("descp_" + Randoms.getInt(100));
        return r;
    }

    protected List<Role> roles(int size) {
        List<Role> roles = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            roles.add(role());
        }
        return roles;
    }

    protected int sum(int array[]) {
        int size = 0;
        for (int i : array) {
            size += i;
        }
        return size;
    }

    protected Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new JdbcException(e);
        }
    }

}
