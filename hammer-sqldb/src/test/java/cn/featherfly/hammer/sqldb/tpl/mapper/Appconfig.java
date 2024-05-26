
package cn.featherfly.hammer.sqldb.tpl.mapper;

import java.util.HashSet;
import java.util.Set;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.db.mapping.JdbcMappingFactoryImpl;
import cn.featherfly.common.lang.ClassLoaderUtils;
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
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(MYSQL_URL);
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername(MYSQL_USER);
        dataSource.setPassword(MYSQL_PWD);
        return dataSource;
    }

    @Bean
    public SqldbHammerImpl hammer(DataSource dataSource) {
        DOMConfigurator.configure(ClassLoaderUtils.getResource("log4j_dev.xml", JdbcTestBase.class));

        //        ConstantConfigurator.config(JdbcTestBase.configFile);
        //        ConstantConfigurator.config();

        //        DatabaseMetadata metadata = DatabaseMetadataManager.getDefaultManager().create(dataSource);
        //        Dialect dialect = Dialects.mysql();

        Jdbc jdbc = new JdbcSpringImpl(dataSource, dialect, metadata, propertyAccessorFactory);

        JdbcMappingFactory mappingFactory = new JdbcMappingFactoryImpl(metadata, dialect, propertyAccessorFactory);

        Set<String> basePackages = new HashSet<>();
        basePackages.add("cn.featherfly.hammer.sqldb.tpl.mapper");
        TplConfigFactory configFactory = TplConfigFactoryImpl.builder().prefixes("tpl/").suffixes(".yaml.tpl")
            .basePackages(basePackages).config(hammerConfig.getTemplateConfig()).build();

        SqldbHammerImpl hammer = new SqldbHammerImpl(jdbc, mappingFactory, configFactory, propertyAccessorFactory,
            hammerConfig);
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
