
package cn.featherfly.hammer.sqldb.tpl.mapper;

import java.util.HashSet;
import java.util.Set;

import javax.sql.DataSource;
import javax.validation.Validation;

import org.apache.logging.log4j.core.config.Configurator;
import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.db.dialect.Dialects;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.db.mapping.JdbcMappingFactoryImpl;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.db.metadata.DatabaseMetadataManager;
import cn.featherfly.common.repository.id.IdGeneratorManager;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.config.HammerConfigImpl;
import cn.featherfly.hammer.sqldb.SqldbHammerImpl;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.JdbcSpringImpl;
import cn.featherfly.hammer.sqldb.jdbc.JdbcTestBase;
import cn.featherfly.hammer.tpl.TplConfigFactory;
import cn.featherfly.hammer.tpl.TplConfigFactoryImpl;
import cn.featherfly.hammer.tpl.mapper.DynamicTplExecutorScanSpringRegistor;
import cn.featherfly.hammer.tpl.mapper.DynamicTplExecutorSpringRegistor;
import cn.featherfly.validation.JavaxValidator;

/**
 * Appconfig.
 *
 * @author zhongj
 */
@Configuration
@EnableTransactionManagement
public class Appconfig extends JdbcTestBase {

    @Bean
    public HammerConfig hammerConfig() {
        return new HammerConfigImpl(devMode);
    }

    @Bean
    public DynamicTplExecutorSpringRegistor tplDynamicExecutorSpringRegistor() {
        Set<String> packages = new HashSet<>();
        packages.add("cn.featherfly");
        //packages.add("你需要扫描的包路径");
        DynamicTplExecutorScanSpringRegistor registor = new DynamicTplExecutorScanSpringRegistor(packages, "hammer",
            "hammerConfig");
        //        registor.setClassLoader(classLoader);
        return registor;
    }

    @Bean
    public DataSource DataSource() {
        return initDataSource();
    }

    @Bean
    public SqldbHammerImpl hammer(DataSource dataSource) {
        Configurator.initialize("log4j2_dev", "log4j2_dev.xml");

        //        ConstantConfigurator.config(JdbcTestBase.configFile);
        //        ConstantConfigurator.config();

        propertyAccessorFactory = PROPERTY_ACCESSOR_FACTORY;

        DatabaseMetadata metadata = DatabaseMetadataManager.getDefaultManager().create(dataSource);
        Dialect dialect = Dialects.mysql();

        HammerConfigImpl hammerConfigImpl = new HammerConfigImpl(devMode);
        hammerConfigImpl.setValidator(new JavaxValidator(Validation.byProvider(HibernateValidator.class).configure()
            .failFast(false).buildValidatorFactory().getValidator()));
        hammerConfig = hammerConfigImpl;

        Jdbc jdbc = new JdbcSpringImpl(dataSource, dialect, metadata, propertyAccessorFactory);

        JdbcMappingFactory mappingFactory = new JdbcMappingFactoryImpl(metadata, dialect, new SqlTypeMappingManager(),
            new IdGeneratorManager(), propertyAccessorFactory);

        Set<String> basePackages = new HashSet<>();
        basePackages.add("cn.featherfly.hammer.sqldb.tpl.mapper");
        TplConfigFactory configFactory = TplConfigFactoryImpl.builder().prefixes("tpl/").suffixes(".yaml.tpl")
            .basePackages(basePackages).config(hammerConfig.getTemplateConfig()).build();

        SqldbHammerImpl hammer = SqldbHammerImpl
            .builder(jdbc, mappingFactory, configFactory, propertyAccessorFactory, hammerConfig).build();
        return hammer;
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    //    @Bean("cacheManager")
    //    public CacheManager cacheManager() {
    //        return new TestCacheManager();
    //    }

}
