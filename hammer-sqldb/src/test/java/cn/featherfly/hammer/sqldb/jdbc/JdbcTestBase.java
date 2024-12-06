
package cn.featherfly.hammer.sqldb.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.sql.DataSource;
import javax.validation.Validation;

import org.apache.logging.log4j.core.config.Configurator;
import org.hibernate.validator.HibernateValidator;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import cn.featherfly.common.bean.PropertyAccessorFactory;
import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.repository.id.IdGeneratorManager;
import cn.featherfly.common.tuple.Tuple5;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.config.HammerConfigImpl;
import cn.featherfly.hammer.entity.EntityPreparer;
import cn.featherfly.hammer.sqldb.tpl.freemarker.SqldbFreemarkerTemplateProcessEnv;
import cn.featherfly.hammer.tpl.TplConfigFactory;
import cn.featherfly.hammer.tpl.TplConfigFactoryImpl;
import cn.featherfly.hammer.tpl.freemarker.FreemarkerTemplatePreProcessor;
import cn.featherfly.validation.JavaxValidator;

/**
 * JdbcTestBase.
 *
 * @author zhongj
 */
public class JdbcTestBase extends DatabaseTestBase {

    protected static DataSource dataSource;

    protected static Dialect dialect;

    protected static DatabaseMetadata metadata;

    protected static Jdbc jdbc;

    protected static JdbcMappingFactory mappingFactory;

    //

    protected static TplConfigFactory configFactory;

    protected static SqlPageFactory sqlPageFactory = new SimpleSqlPageFactory();

    protected static SqlTypeMappingManager sqlTypeMappingManager;

    protected static IdGeneratorManager idGeneratorManager;

    protected static JdbcFactory jdbcFactory;

    protected static HammerConfig hammerConfig;

    protected static PropertyAccessorFactory propertyAccessorFactory;

    protected static SqldbFreemarkerTemplateProcessEnv sharedTemplateProcessEnv = new SqldbFreemarkerTemplateProcessEnv(
        true);

    @BeforeSuite
    @Parameters({ "dataBase", "pool" })
    public void init(@Optional("mysql") String dataBase, @Optional("hikari") String pool) throws IOException {
        Configurator.initialize("log4j2_dev", "log4j2_dev.xml");

        HammerConfigImpl hammerConfigImpl = new HammerConfigImpl(devMode);
        hammerConfigImpl.setValidator(new JavaxValidator(Validation.byProvider(HibernateValidator.class).configure()
            .failFast(false).buildValidatorFactory().getValidator()));
        hammerConfig = hammerConfigImpl;

        propertyAccessorFactory = PROPERTY_ACCESSOR_FACTORY;

        EntityPreparer entityPreparer = EntityPreparer.builder().basePackages("cn.featherfly")
            .propertyAccessorFactory(propertyAccessorFactory).build();
        entityPreparer.prepare();

        sqlTypeMappingManager = new SqlTypeMappingManager();
        idGeneratorManager = new IdGeneratorManager();

        Tuple5<DataSource, Dialect, DatabaseMetadata, Jdbc, JdbcMappingFactory> t = initDataBase(dataBase, pool,
            sqlTypeMappingManager, idGeneratorManager, propertyAccessorFactory);
        dataSource = t.get0();
        dialect = t.get1();
        metadata = t.get2();
        jdbc = t.get3();
        mappingFactory = t.get4();

        Set<String> basePackages = new HashSet<>();
        basePackages.add("cn.featherfly.hammer");

        configFactory = TplConfigFactoryImpl.builder().prefixes("tpl/").suffixes(".yaml.tpl").basePackages(basePackages)
            .config(hammerConfig.getTemplateConfig())
            .preCompile(new FreemarkerTemplatePreProcessor(hammerConfig.getTemplateConfig())).build();

        jdbcFactory = new JdbcFactoryImpl(dialect, metadata, sqlTypeMappingManager, propertyAccessorFactory);

        sharedTemplateProcessEnv.setMappingFactory(mappingFactory);
        sharedTemplateProcessEnv.setConfigFactory(configFactory);
        sharedTemplateProcessEnv.setTemplateConfig(hammerConfig.getTemplateConfig());
    }

    protected Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new JdbcException(e);
        }
    }
}
