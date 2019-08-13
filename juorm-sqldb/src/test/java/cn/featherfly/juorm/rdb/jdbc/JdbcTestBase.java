
package cn.featherfly.juorm.rdb.jdbc;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.BeforeClass;

import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.db.metadata.DatabaseMetadataManager;
import cn.featherfly.common.lang.ClassLoaderUtils;
import cn.featherfly.common.lang.RandomUtils;
import cn.featherfly.constant.ConstantConfigurator;
import cn.featherfly.juorm.rdb.jdbc.mapping.MappingFactory;
import cn.featherfly.juorm.rdb.jdbc.vo.Role;
import cn.featherfly.juorm.rdb.sql.dialect.Dialects;

/**
 * <p>
 * SqlOrmTest
 * </p>
 *
 * @author zhongj
 */
public class JdbcTestBase {

    protected Jdbc jdbc;

    protected MappingFactory factory;

    @BeforeClass
    public void beforeClassMySql() {
        DOMConfigurator.configure(ClassLoaderUtils.getResource("log4j.xml", JdbcTestBase.class));

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/juorm_jdbc");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        jdbc = new SpringJdbcTemplateImpl(dataSource, Dialects.MYSQL);
        DatabaseMetadata metadata = DatabaseMetadataManager.getDefaultManager().create(dataSource);

        factory = new MappingFactory(metadata, Dialects.MYSQL);

        // factory.getClassNameConversions().add(new ClassNameJpaConversion());
        // factory.getClassNameConversions().add(new
        // ClassNameUnderlineConversion());
        // factory.getPropertyNameConversions().add(new
        // PropertyNameJpaConversion());
        // factory.getPropertyNameConversions().add(new
        // PropertyNameUnderlineConversion());

        ConstantConfigurator.config();
    }

    //    @BeforeClass
    public void beforeClassPostgresql() {
        DOMConfigurator.configure(ClassLoaderUtils.getResource("log4j.xml", JdbcTestBase.class));
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/juorm_jdbc");
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("123456");

        //        PostgreSQLDialect postgreSQLDialect = Dialects.POSTGRESQL;
        //        postgreSQLDialect.setTableAndColumnNameUppercase(false);
        //        jdbc = new SpringJdbcTemplateImpl(dataSource, postgreSQLDialect);
        jdbc = new SpringJdbcTemplateImpl(dataSource, Dialects.POSTGRESQL);
        DatabaseMetadata metadata = DatabaseMetadataManager.getDefaultManager().create(dataSource, "juorm_jdbc");

        factory = new MappingFactory(metadata, Dialects.POSTGRESQL);
        // factory.getClassNameConversions().add(new ClassNameJpaConversion());
        // factory.getClassNameConversions().add(new
        // ClassNameUnderlineConversion());
        // factory.getPropertyNameConversions().add(new
        // PropertyNameJpaConversion());
        // factory.getPropertyNameConversions().add(new
        // PropertyNameUnderlineConversion());

        ConstantConfigurator.config();
    }

    Role role() {
        Role r = new Role();
        r.setName("n_" + RandomUtils.getRandomInt(100));
        r.setDescp("descp_" + RandomUtils.getRandomInt(100));
        return r;
    }
}
