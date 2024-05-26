
package cn.featherfly.hammer.sqldb.jdbc;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.sql.DataSource;
import javax.validation.Validation;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.xml.DOMConfigurator;
import org.hibernate.validator.HibernateValidator;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import cn.featherfly.common.bean.PropertyAccessorFactory;
import cn.featherfly.common.db.FieldValueOperator;
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
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.config.HammerConfigImpl;
import cn.featherfly.hammer.entity.EntityPreparer;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Role;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.Order2;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.UserInfo2;
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

    protected static HammerConfig hammerConfig;

    protected static PropertyAccessorFactory propertyAccessorFactory;

    @BeforeSuite
    @Parameters({ "dataBase" })
    public void init(@Optional("mysql") String dataBase) throws IOException {
        DOMConfigurator.configure(ClassLoaderUtils.getResource("log4j_dev.xml", this.getClass()));

        HammerConfigImpl hammerConfigImpl = new HammerConfigImpl(devMode);
        hammerConfigImpl.setValidator(Validation.byProvider(HibernateValidator.class).configure().failFast(false)
            .buildValidatorFactory().getValidator());
        hammerConfig = hammerConfigImpl;

        //        propertyAccessorFactory = new AsmPropertyAccessorFactory(Thread.currentThread().getContextClassLoader());
        propertyAccessorFactory = PROPERTY_ACCESSOR_FACTORY;

        EntityPreparer entityPreparer = EntityPreparer.builder().basePackages("cn.featherfly")
            .propertyAccessorFactory(propertyAccessorFactory).build();
        entityPreparer.prepare();

        sqlTypeMappingManager = new SqlTypeMappingManager();

        initDataBase(dataBase);

        Set<String> basePackages = new HashSet<>();
        basePackages.add("cn.featherfly.hammer");

        configFactory = TplConfigFactoryImpl.builder().prefixes("tpl/").suffixes(".yaml.tpl").basePackages(basePackages)
            .config(hammerConfig.getTemplateConfig())
            .preCompile(new FreemarkerTemplatePreProcessor(hammerConfig.getTemplateConfig())).build();

        jdbcFactory = new JdbcFactoryImpl(dialect, metadata, sqlTypeMappingManager, propertyAccessorFactory);

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
        ds.setUrl(MYSQL_URL);
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUsername(MYSQL_USER);
        ds.setPassword(MYSQL_PWD);
        dataSource = ds;

        // 初始化数据库
        SqlExecutor sqlExecutor = new SqlExecutor(ds);
        sqlExecutor.execute(SqlFile.read(ClassLoaderUtils.getResource("test.mysql.sql", this.getClass())));

        dialect = Dialects.mysql();

        //        jdbc = new SpringJdbcTemplateImpl(ds, dialect);
        //        jdbc = new JdbcImpl(ds, dialect, sqlTypeMappingManager);
        metadata = DatabaseMetadataManager.getDefaultManager().create(ds);
        jdbc = new JdbcSpringImpl(ds, dialect, metadata, sqlTypeMappingManager, propertyAccessorFactory);

        mappingFactory = new JdbcMappingFactoryImpl(metadata, dialect, sqlTypeMappingManager, propertyAccessorFactory);

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
        metadata = DatabaseMetadataManager.getDefaultManager().create(ds);
        jdbc = new JdbcSpringImpl(ds, dialect, metadata, sqlTypeMappingManager, propertyAccessorFactory);

        mappingFactory = new JdbcMappingFactoryImpl(metadata, dialect, sqlTypeMappingManager, propertyAccessorFactory);

    }

    //    @BeforeSuite(groups = "sqlite", dependsOnMethods = "init")
    public void initSQLite() throws IOException {
        System.err.println("initSQLite");
        //        ConstantConfigurator.config("constant.sqlite.yaml");

        String path = new File(UriUtils.linkUri(JdbcTestBase.class.getResource("/").getFile(), "hammer.sqlite3.db"))
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

        dialect = Dialects.sqlite();

        //        jdbc = new SpringJdbcTemplateImpl(ds, dialect);
        metadata = DatabaseMetadataManager.getDefaultManager().create(ds, "main");
        jdbc = new JdbcSpringImpl(ds, dialect, metadata, sqlTypeMappingManager, propertyAccessorFactory);

        mappingFactory = new JdbcMappingFactoryImpl(metadata, dialect, sqlTypeMappingManager, propertyAccessorFactory);

    }

    protected Role role() {
        Role r = new Role();
        r.setName("n_" + Randoms.getInt(100));
        r.setDescp("descp_" + Randoms.getInt(100));
        return r;
    }

    protected Order2 order2() {
        Order2 o = new Order2();
        o.setAppId("appId_" + Randoms.getInt(100));
        o.setNo("no_" + System.currentTimeMillis());
        return o;
    }

    protected UserInfo2 userInfo2() {
        UserInfo2 ui = new UserInfo2();
        ui.setName("name_" + Randoms.getInt(100));
        ui.setDescp("descp_" + Randoms.getInt(100));
        return ui;
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

    protected List<Object> unwrapFieldValueOperators(List<Object> values) {
        return values.stream().map(this::unwrapFieldValueOperator).collect(Collectors.toList());
    }

    protected Object unwrapFieldValueOperator(Object value) {
        return value instanceof FieldValueOperator ? ((FieldValueOperator<?>) value).getValue() : value;
    }

}
