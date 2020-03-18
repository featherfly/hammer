
package cn.featherfly.hammer.sqldb.tpl.mapper;

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
import cn.featherfly.hammer.sqldb.SqldbHammerImpl;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.JdbcTestBase;
import cn.featherfly.hammer.sqldb.jdbc.SpringJdbcTemplateImpl;
import cn.featherfly.hammer.sqldb.jdbc.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.sqldb.sql.dialect.Dialects;
import cn.featherfly.hammer.tpl.TplConfigFactory;
import cn.featherfly.hammer.tpl.TplConfigFactoryImpl;
import cn.featherfly.hammer.tpl.mapper.DynamicTplExecutorScanSpringRegistor;
import cn.featherfly.hammer.tpl.mapper.DynamicTplExecutorSpringRegistor;

/**
 * <p>
 * Appconfig
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
        DynamicTplExecutorScanSpringRegistor registor = new DynamicTplExecutorScanSpringRegistor(packages, "hammer");
        return registor;
    }

    @Bean
    public SqldbHammerImpl hammer(DataSource dataSource) {
        DOMConfigurator.configure(ClassLoaderUtils.getResource("log4j.xml", JdbcTestBase.class));

        //        ConstantConfigurator.config(JdbcTestBase.configFile);
        ConstantConfigurator.config();

        //        BasicDataSource dataSource = new BasicDataSource();
        //        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/hammer_jdbc");
        //        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        //        dataSource.setUsername("root");
        //        dataSource.setPassword("123456");

        Jdbc jdbc = new SpringJdbcTemplateImpl(dataSource, Dialects.MYSQL);
        DatabaseMetadata metadata = DatabaseMetadataManager.getDefaultManager().create(dataSource);

        JdbcMappingFactory mappingFactory = new JdbcMappingFactory(metadata, Dialects.MYSQL);

        TplConfigFactory configFactory = new TplConfigFactoryImpl("tpl/");

        SqldbHammerImpl hammer = new SqldbHammerImpl(jdbc, mappingFactory, configFactory);
        return hammer;
    }

    //    @Bean("cacheManager")
    //    public CacheManager cacheManager() {
    //        return new TestCacheManager();
    //    }

}
