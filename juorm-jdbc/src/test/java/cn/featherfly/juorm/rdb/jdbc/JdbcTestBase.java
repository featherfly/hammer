
package cn.featherfly.juorm.rdb.jdbc;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.BeforeClass;

import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.db.metadata.DatabaseMetadataManager;
import cn.featherfly.common.lang.ClassLoaderUtils;
import cn.featherfly.juorm.rdb.Constants;
import cn.featherfly.juorm.rdb.jdbc.mapping.MappingFactory;
import cn.featherfly.juorm.rdb.sql.dialect.Dialects;

/**
 * <p>
 * SqlOrmTest
 * </p>
 *
 * @author zhongj
 */
public class JdbcTestBase {

    Jdbc jdbc;

    MappingFactory factory;

    @BeforeClass
    public void beforeClass() {
        DOMConfigurator.configure(ClassLoaderUtils.getResource("log4j.xml", JdbcTestBase.class));
        System.out.println("11112222");
        Constants.LOGGER.debug("test logger");
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/juorm_jdbc");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        jdbc = new Jdbc(dataSource, Dialects.MYSQL);

        DatabaseMetadata metadata = DatabaseMetadataManager.getDefaultManager().create(dataSource);

        factory = new MappingFactory(metadata, Dialects.MYSQL);
    }
}
