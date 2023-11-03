
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

import cn.featherfly.common.db.dialect.Dialects;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.db.mapping.JdbcMappingFactoryImpl;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.db.metadata.DatabaseMetadataManager;
import cn.featherfly.common.lang.ClassLoaderUtils;
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
    public DynamicTplExecutorSpringRegistor tplDynamicExecutorSpringRegistor() {
        Set<String> packages = new HashSet<>();
        packages.add("cn.featherfly");
        //packages.add("你需要扫描的包路径");
        DynamicTplExecutorScanSpringRegistor registor = new DynamicTplExecutorScanSpringRegistor(packages, "hammer");
        //        registor.setClassLoader(classLoader);
        return registor;
    }

    @Bean
    public DataSource DataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        //        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/hammer_jdbc?useUnicode=true&characterEncoding=UTF-8");
        //        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        //        dataSource.setUrl(
        //                "jdbc:mysql://127.0.0.1:3306/hammer_jdbc?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false");
        //        dataSource.setUrl(
        //                "jdbc:mysql://127.0.0.1:3306/hammer_jdbc?serverTimezone=CTT&characterEncoding=utf8&useUnicode=true&useSSL=false");
        // 高版本mysql-connector已经不需要serverTimezone=CTT
        dataSource
                .setUrl("jdbc:mysql://127.0.0.1:3306/hammer_jdbc?characterEncoding=utf8&useUnicode=true&useSSL=false");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        return dataSource;
    }

    @Bean
    public SqldbHammerImpl hammer(DataSource dataSource) {
        DOMConfigurator.configure(ClassLoaderUtils.getResource("log4j_dev.xml", JdbcTestBase.class));

        //        ConstantConfigurator.config(JdbcTestBase.configFile);
        //        ConstantConfigurator.config();

        Jdbc jdbc = new JdbcSpringImpl(dataSource, Dialects.MYSQL, metadata);
        DatabaseMetadata metadata = DatabaseMetadataManager.getDefaultManager().create(dataSource);

        JdbcMappingFactory mappingFactory = new JdbcMappingFactoryImpl(metadata, Dialects.MYSQL);

        Set<String> basePackages = new HashSet<>();
        basePackages.add("cn.featherfly.hammer.sqldb.tpl.mapper");
        TplConfigFactory configFactory = new TplConfigFactoryImpl("tpl/", ".yaml.tpl", basePackages);

        SqldbHammerImpl hammer = new SqldbHammerImpl(jdbc, mappingFactory, configFactory, hammerConfig);
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
