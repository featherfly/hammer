
package cn.featherfly.hammer.sqldb.jdbc;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import cn.featherfly.common.bean.PropertyAccessorFactory;
import cn.featherfly.common.db.FieldValueOperator;
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
import cn.featherfly.common.repository.id.IdGeneratorManager;
import cn.featherfly.common.tuple.Tuple5;
import cn.featherfly.common.tuple.Tuples;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Role;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.Order2;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.UserInfo2;

/**
 * DatabaseTestBase.
 *
 * @author zhongj
 */
public class DatabaseTestBase extends TestBase {

    private static final String CONFIG_FILE_PATTERN = "constant.%s.yaml";

    public static String configFile = "";

    private DataSource dataSource;

    private Dialect dialect;

    private DatabaseMetadata metadata;

    private Jdbc jdbc;

    private JdbcMappingFactory mappingFactory;

    protected Tuple5<DataSource, Dialect, DatabaseMetadata, Jdbc, JdbcMappingFactory> initDataBase(String dataBase,
        String pool, SqlTypeMappingManager sqlTypeMappingManager, IdGeneratorManager idGeneratorManager,
        PropertyAccessorFactory propertyAccessorFactory) throws IOException {
        System.err.println("***********************************************");
        System.err.println("***********************************************");
        configFile = String.format(CONFIG_FILE_PATTERN, dataBase);
        Tuple5<DataSource, Dialect, DatabaseMetadata, Jdbc, JdbcMappingFactory> result;
        switch (dataBase) {
            case "mysql":
                result = initMysql(sqlTypeMappingManager, idGeneratorManager, propertyAccessorFactory);
                break;
            case "postgresql":
                result = initPostgresql(sqlTypeMappingManager, idGeneratorManager, propertyAccessorFactory);
                break;
            case "sqlite":
                result = initSQLite(sqlTypeMappingManager, idGeneratorManager, propertyAccessorFactory);
                break;
            default:
                configFile = String.format(CONFIG_FILE_PATTERN, "mysql");
                result = initMysql(sqlTypeMappingManager, idGeneratorManager, propertyAccessorFactory);
                break;
        }
        System.err.println("***********************************************");
        System.err.println("***********************************************");
        return result;
    }

    protected Tuple5<DataSource, Dialect, DatabaseMetadata, Jdbc, JdbcMappingFactory> initMysql(
        SqlTypeMappingManager sqlTypeMappingManager, IdGeneratorManager idGeneratorManager,
        PropertyAccessorFactory propertyAccessorFactory) throws IOException {
        System.err.println("initMysql");

        jdbcUrl = MYSQL_URL;
        jdbcDriverName = "com.mysql.cj.jdbc.Driver";
        jdbcUsername = MYSQL_USER;
        jdbcPassword = MYSQL_PWD;
        dataSource = initDataSource();

        // 初始化数据库
        SqlExecutor sqlExecutor = new SqlExecutor(dataSource);
        sqlExecutor.execute(SqlFile.read(ClassLoaderUtils.getResource("test.mysql.sql", this.getClass())));

        dialect = Dialects.mysql();

        metadata = DatabaseMetadataManager.getDefaultManager().create(dataSource);
        jdbc = new JdbcSpringImpl(dataSource, dialect, metadata, sqlTypeMappingManager, propertyAccessorFactory);

        mappingFactory = new JdbcMappingFactoryImpl(metadata, dialect, sqlTypeMappingManager, idGeneratorManager,
            propertyAccessorFactory);

        // factory.getClassNameConversions().add(new ClassNameJpaConversion());
        // factory.getClassNameConversions().add(new
        // ClassNameUnderlineConversion());
        // factory.getPropertyNameConversions().add(new
        // PropertyNameJpaConversion());
        // factory.getPropertyNameConversions().add(new
        // PropertyNameUnderlineConversion());

        return Tuples.of(dataSource, dialect, metadata, jdbc, mappingFactory);
    }

    protected Tuple5<DataSource, Dialect, DatabaseMetadata, Jdbc, JdbcMappingFactory> initPostgresql(
        SqlTypeMappingManager sqlTypeMappingManager, IdGeneratorManager idGeneratorManager,
        PropertyAccessorFactory propertyAccessorFactory) throws IOException {
        System.err.println("initPostgresql");

        //        ds.setUrl("jdbc:postgresql://localhost:5432/hammer_jdbc");
        jdbcUrl = "jdbc:postgresql://::1:5432/hammer_jdbc"; // install postgresql in wsl with docker
        jdbcDriverName = "com.mysql.cj.jdbc.Driver";
        jdbcUsername = "postgres";
        jdbcPassword = "123456";

        dataSource = initDataSource();

        // 初始化数据库
        SqlExecutor sqlExecutor = new SqlExecutor(dataSource);
        sqlExecutor.execute(SqlFile.read(ClassLoaderUtils.getResource("test.postgresql.sql", this.getClass())));

        PostgreSQLDialect postgreSQLDialect = new PostgreSQLDialect();
        //        postgreSQLDialect.setTableAndColumnNameUppercase(StringConverter.UPPER_CASE);
        dialect = postgreSQLDialect;

        metadata = DatabaseMetadataManager.getDefaultManager().create(dataSource);
        jdbc = new JdbcSpringImpl(dataSource, dialect, metadata, sqlTypeMappingManager, propertyAccessorFactory);

        mappingFactory = new JdbcMappingFactoryImpl(metadata, dialect, sqlTypeMappingManager, idGeneratorManager,
            propertyAccessorFactory);

        return Tuples.of(dataSource, dialect, metadata, jdbc, mappingFactory);
    }

    protected Tuple5<DataSource, Dialect, DatabaseMetadata, Jdbc, JdbcMappingFactory> initSQLite(
        SqlTypeMappingManager sqlTypeMappingManager, IdGeneratorManager idGeneratorManager,
        PropertyAccessorFactory propertyAccessorFactory) throws IOException {
        System.err.println("initSQLite");

        String path = new File(UriUtils.linkUri(JdbcTestBase.class.getResource("/").getFile(), "hammer.sqlite3.db"))
            .getPath();
        System.out.println(path);
        jdbcUrl = "jdbc:sqlite:" + path;
        jdbcDriverName = "org.sqlite.JDBC";
        dataSource = initDataSource();

        // 初始化数据库
        SqlExecutor sqlExecutor = new SqlExecutor(dataSource);
        sqlExecutor.execute(SqlFile.read(ClassLoaderUtils.getResource("test.sqlite.sql", this.getClass())));

        dialect = Dialects.sqlite();

        metadata = DatabaseMetadataManager.getDefaultManager().create(dataSource, "main");
        jdbc = new JdbcSpringImpl(dataSource, dialect, metadata, sqlTypeMappingManager, propertyAccessorFactory);

        mappingFactory = new JdbcMappingFactoryImpl(metadata, dialect, sqlTypeMappingManager, idGeneratorManager,
            propertyAccessorFactory);

        return Tuples.of(dataSource, dialect, metadata, jdbc, mappingFactory);
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

    protected List<Object> unwrapFieldValueOperators(List<Object> values) {
        return values.stream().map(this::unwrapFieldValueOperator).collect(Collectors.toList());
    }

    protected Object unwrapFieldValueOperator(Object value) {
        return value instanceof FieldValueOperator ? ((FieldValueOperator<?>) value).getValue() : value;
    }
}
