
package cn.featherfly.juorm.rdb.tpl.mapper;

import java.util.HashSet;
import java.util.Set;

import javax.sql.DataSource;

import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.db.metadata.DatabaseMetadataManager;
import cn.featherfly.common.lang.ClassLoaderUtils;
import cn.featherfly.constant.ConstantConfigurator;
import cn.featherfly.juorm.rdb.jdbc.Jdbc;
import cn.featherfly.juorm.rdb.jdbc.JdbcTestBase;
import cn.featherfly.juorm.rdb.jdbc.JuormJdbcImpl;
import cn.featherfly.juorm.rdb.jdbc.SpringJdbcTemplateImpl;
import cn.featherfly.juorm.rdb.jdbc.mapping.JdbcMappingFactory;
import cn.featherfly.juorm.rdb.sql.dialect.Dialects;
import cn.featherfly.juorm.tpl.TplConfigFactory;
import cn.featherfly.juorm.tpl.TplConfigFactoryImpl;
import cn.featherfly.juorm.tpl.mapper.DynamicTplExecutorScanSpringRegistor;
import cn.featherfly.juorm.tpl.mapper.DynamicTplExecutorSpringRegistor;

/**
 * <p>
 * Appconfig
 * </p>
 * <p>
 * 2019-08-15
 * </p>
 *
 * @author zhongj
 */
@Configuration
public class Appconfig {

    @Bean
    public DynamicTplExecutorSpringRegistor tplDynamicExecutorSpringRegistor() {
        Set<String> packages = new HashSet<>();
        packages.add("cn.featherfly");
        //packages.add("你需要扫描的包路径");
        DynamicTplExecutorScanSpringRegistor registor = new DynamicTplExecutorScanSpringRegistor(packages, "juorm");
        return registor;
    }

    @Bean
    public JuormJdbcImpl juorm(DataSource dataSource) {
        DOMConfigurator.configure(ClassLoaderUtils.getResource("log4j.xml", JdbcTestBase.class));

        ConstantConfigurator.config(JdbcTestBase.configFile);

        //        BasicDataSource dataSource = new BasicDataSource();
        //        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/juorm_jdbc");
        //        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        //        dataSource.setUsername("root");
        //        dataSource.setPassword("123456");

        Jdbc jdbc = new SpringJdbcTemplateImpl(dataSource, Dialects.MYSQL);
        DatabaseMetadata metadata = DatabaseMetadataManager.getDefaultManager().create(dataSource);

        JdbcMappingFactory mappingFactory = new JdbcMappingFactory(metadata, Dialects.MYSQL);

        TplConfigFactory configFactory = new TplConfigFactoryImpl("tpl/");

        JuormJdbcImpl juorm = new JuormJdbcImpl(jdbc, mappingFactory, configFactory);
        return juorm;
    }

    //    @Bean("cacheManager")
    //    public CacheManager cacheManager() {
    //        return new TestCacheManager();
    //    }

}
