
package cn.featherfly.hammer.sqldb.jdbc;

import java.io.File;
import java.io.IOException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.logging.log4j.core.config.Configurator;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import cn.featherfly.common.bean.PropertyAccessorFactory;
import cn.featherfly.common.db.SqlExecutor;
import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.db.dialect.Dialects;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.db.mapping.JdbcMappingFactoryImpl;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.db.metadata.DatabaseMetadataManager;
import cn.featherfly.common.lang.ClassLoaderUtils;
import cn.featherfly.common.lang.Randoms;
import cn.featherfly.common.lang.UriUtils;
import cn.featherfly.common.repository.id.IdGeneratorManager;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.config.HammerConfigImpl;
import cn.featherfly.hammer.entity.EntityPreparer;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Role;

/**
 * DataSourceTestBase.
 *
 * @author zhongj
 */
public class DataSourceTestBase extends TestBase {

    private static final String CONFIG_FILE_PATTERN = "constant.%s.yaml";

    public static String configFile = "";

    protected DataSource ds;

    //    public static final String CONFIG_FILE = "constant.mysql.yaml";
    //    public static final String CONFIG_FILE = "constant.postgresql.yaml";
    //    public static final String CONFIG_FILE = "constant.sqlite.yaml";

    protected static Dialect dialect;

    protected static Jdbc jdbc;

    protected static JdbcMappingFactory mappingFactory;

    protected static DatabaseMetadata metadata;

    protected static HammerConfig hammerConfig;

    protected static PropertyAccessorFactory propertyAccessorFactory;

    @BeforeSuite
    @Parameters({ "dataBase" })
    public void init(@Optional("mysql") String dataBase) throws IOException {
        Configurator.initialize("log4j2_dev", "log4j2_dev.xml");

        hammerConfig = new HammerConfigImpl(devMode);

        //        propertyAccessorFactory = new AsmPropertyAccessorFactory(Thread.currentThread().getContextClassLoader());
        propertyAccessorFactory = PROPERTY_ACCESSOR_FACTORY;

        EntityPreparer entityPreparer = EntityPreparer.builder().basePackages("cn.featherfly")
            .propertyAccessorFactory(propertyAccessorFactory).build();
        entityPreparer.prepare();

        initDataBase(dataBase);
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

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(MYSQL_URL);
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername(MYSQL_USER);
        dataSource.setPassword(MYSQL_PWD);

        // 初始化数据库
        SqlExecutor sqlExecutor = new SqlExecutor(dataSource);
        sqlExecutor
            .execute(new File(ClassLoaderUtils.getResource("test.mysql.sql", DataSourceTestBase.class).getFile()));

        ds = dataSource;

        dialect = Dialects.mysql();
        jdbc = new JdbcSpringImpl(dataSource, dialect, metadata, propertyAccessorFactory);
        metadata = DatabaseMetadataManager.getDefaultManager().create(dataSource);

        mappingFactory = new JdbcMappingFactoryImpl(metadata, dialect, new SqlTypeMappingManager(),
            new IdGeneratorManager(), propertyAccessorFactory);
    }

    //    @BeforeSuite(groups = "postgresql", dependsOnMethods = "init")
    public void initPostgresql() throws IOException {
        System.err.println("postgresql");
        //        ConstantConfigurator.config("constant.postgresql.yaml");

        BasicDataSource dataSource = new BasicDataSource();
        //        dataSource.setUrl("jdbc:postgresql://localhost:5432/hammer_jdbc");
        dataSource.setUrl("jdbc:postgresql://::1:5432/hammer_jdbc"); // install postgresql in wsl with docker
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("123456");

        // 初始化数据库
        SqlExecutor sqlExecutor = new SqlExecutor(dataSource);
        sqlExecutor
            .execute(new File(ClassLoaderUtils.getResource("test.postgresql.sql", DataSourceTestBase.class).getFile()));

        ds = dataSource;

        dialect = Dialects.postgresql();
        jdbc = new JdbcSpringImpl(dataSource, dialect, metadata, propertyAccessorFactory);
        metadata = DatabaseMetadataManager.getDefaultManager().create(dataSource);

        mappingFactory = new JdbcMappingFactoryImpl(metadata, dialect, new SqlTypeMappingManager(),
            new IdGeneratorManager(), propertyAccessorFactory);
    }

    //    @BeforeSuite(groups = "sqlite", dependsOnMethods = "init")
    public void initSQLite() throws IOException {
        System.err.println("sqlite");
        //        ConstantConfigurator.config("constant.sqlite.yaml");

        String path = new File(UriUtils.linkUri(this.getClass().getResource("/").getFile(), "hammer.sqlite3.db"))
            .getPath();
        System.out.println(path);
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.sqlite.JDBC");
        dataSource.setUrl("jdbc:sqlite:" + path);
        //        dataSource.setUsername("root");
        //        dataSource.setPassword("123456");

        // 初始化数据库
        SqlExecutor sqlExecutor = new SqlExecutor(dataSource);
        sqlExecutor
            .execute(new File(ClassLoaderUtils.getResource("test.sqlite.sql", DataSourceTestBase.class).getFile()));

        ds = dataSource;

        dialect = Dialects.sqlite();
        jdbc = new JdbcSpringImpl(dataSource, dialect, metadata, propertyAccessorFactory);
        metadata = DatabaseMetadataManager.getDefaultManager().create(dataSource, "main");

        mappingFactory = new JdbcMappingFactoryImpl(metadata, dialect, new SqlTypeMappingManager(),
            new IdGeneratorManager(), propertyAccessorFactory);
    }

    Role role() {
        Role r = new Role();
        r.setName("n_" + Randoms.getInt(100));
        r.setDescp("descp_" + Randoms.getInt(100));
        return r;
    }
}
