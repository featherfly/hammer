
package cn.featherfly.hammer.sqldb.jdbc;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.logging.log4j.core.config.Configurator;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import cn.featherfly.common.bean.PropertyAccessorFactory;
import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.repository.id.IdGeneratorManager;
import cn.featherfly.common.tuple.Tuple5;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.config.HammerConfigImpl;
import cn.featherfly.hammer.entity.EntityPreparer;

/**
 * DataSourceTestBase.
 *
 * @author zhongj
 */
public class DataSourceTestBase extends DatabaseTestBase {

    protected static HammerConfig hammerConfig;

    protected static PropertyAccessorFactory propertyAccessorFactory;

    protected static DataSource dataSource;

    protected static Dialect dialect;

    protected static DatabaseMetadata metadata;

    protected static Jdbc jdbc;

    protected static JdbcMappingFactory mappingFactory;

    @BeforeSuite
    @Parameters({ "dataBase", "pool" })
    public void init(@Optional("mysql") String dataBase, @Optional("hikari") String pool) throws IOException {
        Configurator.initialize("log4j2_dev", "log4j2_dev.xml");

        hammerConfig = new HammerConfigImpl(devMode);

        //        propertyAccessorFactory = new AsmPropertyAccessorFactory(Thread.currentThread().getContextClassLoader());
        propertyAccessorFactory = PROPERTY_ACCESSOR_FACTORY;

        EntityPreparer entityPreparer = EntityPreparer.builder().basePackages("cn.featherfly")
            .propertyAccessorFactory(propertyAccessorFactory).build();
        entityPreparer.prepare();

        Tuple5<DataSource, Dialect, DatabaseMetadata, Jdbc, JdbcMappingFactory> t = initDataBase(dataBase, pool,
            new SqlTypeMappingManager(), new IdGeneratorManager(), propertyAccessorFactory);
        dataSource = t.get0();
        dialect = t.get1();
        metadata = t.get2();
        jdbc = t.get3();
        mappingFactory = t.get4();
    }
}
