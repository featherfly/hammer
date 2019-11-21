
package cn.featherfly.juorm.rdb.jdbc;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import cn.featherfly.common.db.SqlExecutor;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.db.metadata.DatabaseMetadataManager;
import cn.featherfly.common.lang.ClassLoaderUtils;
import cn.featherfly.common.lang.RandomUtils;
import cn.featherfly.constant.ConstantConfigurator;
import cn.featherfly.juorm.rdb.jdbc.mapping.JdbcMappingFactory;
import cn.featherfly.juorm.rdb.jdbc.vo.Role;
import cn.featherfly.juorm.rdb.sql.dialect.Dialects;
import cn.featherfly.juorm.tpl.TplConfigFactory;
import cn.featherfly.juorm.tpl.TplConfigFactoryImpl;

/**
 * <p>
 * SqlOrmTest
 * </p>
 *
 * @author zhongj
 */
public class JdbcTestBase {

    private static final String CONFIG_FILE_PATTERN = "constant.%s.yaml";

    public static String configFile = "";

    //    public static final String CONFIG_FILE = "constant.mysql.yaml";
    //    public static final String CONFIG_FILE = "constant.postgresql.yaml";
    //    public static final String CONFIG_FILE = "constant.sqlite.yaml";

    protected static Jdbc jdbc;

    protected static JdbcMappingFactory mappingFactory;

    protected static TplConfigFactory configFactory;

    protected static DatabaseMetadata metadata;

    @BeforeSuite
    @Parameters({ "dataBase" })
    public void init(@Optional("mysql") String dataBase) throws IOException {
        DOMConfigurator.configure(ClassLoaderUtils.getResource("log4j.xml", JdbcTestBase.class));
        initDataBase(dataBase);
    }

    public void initDataBase(String dataBase) throws IOException {
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
    }

    //    @BeforeSuite(groups = "mysql", dependsOnMethods = "init")
    public void initMysql() throws IOException {
        ConstantConfigurator.config("constant.mysql.yaml");

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/juorm_jdbc");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        // 初始化数据库
        SqlExecutor sqlExecutor = new SqlExecutor(dataSource);
        sqlExecutor.execute(new File(ClassLoaderUtils.getResource("test.mysql.sql", JdbcTestBase.class).getFile()));

        jdbc = new SpringJdbcTemplateImpl(dataSource, Dialects.MYSQL);
        metadata = DatabaseMetadataManager.getDefaultManager().create(dataSource);

        mappingFactory = new JdbcMappingFactory(metadata, Dialects.MYSQL);

        // factory.getClassNameConversions().add(new ClassNameJpaConversion());
        // factory.getClassNameConversions().add(new
        // ClassNameUnderlineConversion());
        // factory.getPropertyNameConversions().add(new
        // PropertyNameJpaConversion());
        // factory.getPropertyNameConversions().add(new
        // PropertyNameUnderlineConversion());

        configFactory = new TplConfigFactoryImpl("tpl/");

    }

    //    @BeforeSuite(groups = "postgresql", dependsOnMethods = "init")
    public void initPostgresql() {
        //        ConstantConfigurator.config(CONFIG_FILE);
        ConstantConfigurator.config("constant.postgresql.yaml");

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/juorm_jdbc");
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("123456");

        //        PostgreSQLDialect postgreSQLDialect = Dialects.POSTGRESQL;
        //        postgreSQLDialect.setTableAndColumnNameUppercase(false);
        //        jdbc = new SpringJdbcTemplateImpl(dataSource, postgreSQLDialect);
        jdbc = new SpringJdbcTemplateImpl(dataSource, Dialects.POSTGRESQL);
        metadata = DatabaseMetadataManager.getDefaultManager().create(dataSource, "juorm_jdbc");

        mappingFactory = new JdbcMappingFactory(metadata, Dialects.POSTGRESQL);

        configFactory = new TplConfigFactoryImpl("tpl/");
    }

    //    @BeforeSuite(groups = "sqlite", dependsOnMethods = "init")
    public void initSQLite() {
        //        ConstantConfigurator.config(CONFIG_FILE);
        ConstantConfigurator.config("constant.sqlite.yaml");

        URL url = ClassLoaderUtils.getResource("juorm.sqlite3", this.getClass());
        System.out.println(url);
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.sqlite.JDBC");
        dataSource.setUrl("jdbc:sqlite:" + new File(url.getPath()));
        //        dataSource.setUsername("root");
        //        dataSource.setPassword("123456");

        jdbc = new SpringJdbcTemplateImpl(dataSource, Dialects.SQLITE);
        metadata = DatabaseMetadataManager.getDefaultManager().create(dataSource, "main");

        mappingFactory = new JdbcMappingFactory(metadata, Dialects.SQLITE);

        // factory.getClassNameConversions().add(new ClassNameJpaConversion());
        // factory.getClassNameConversions().add(new
        // ClassNameUnderlineConversion());
        // factory.getPropertyNameConversions().add(new
        // PropertyNameJpaConversion());
        // factory.getPropertyNameConversions().add(new
        // PropertyNameUnderlineConversion());

        configFactory = new TplConfigFactoryImpl("tpl/");
    }

    Role role() {
        Role r = new Role();
        r.setName("n_" + RandomUtils.getRandomInt(100));
        r.setDescp("descp_" + RandomUtils.getRandomInt(100));
        return r;
    }
}
