
/*
 * All rights Reserved, Designed By zhongj
 * @Title: HammerBenchmark.java
 * @Description: HammerBenchmark
 * @author: zhongj
 * @date: 2023-08-23 15:44:23
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.pt;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Validation;

import org.hibernate.validator.HibernateValidator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.db.mapping.JdbcMappingFactoryImpl;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.db.metadata.DatabaseMetadataManager;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.config.HammerConfigImpl;
import cn.featherfly.hammer.sqldb.SqldbHammerImpl;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.JdbcSpringImpl;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.UserInfo2;
import cn.featherfly.hammer.tpl.TplConfigFactory;
import cn.featherfly.hammer.tpl.TplConfigFactoryImpl;
import cn.featherfly.hammer.tpl.freemarker.FreemarkerTemplatePreProcessor;

/**
 * HammerBenchmark.
 *
 * @author zhongj
 */
@Test
public class HammerBenchmark extends AbstractBenchmark {

    protected Jdbc jdbc;

    //    protected JdbcFactory jdbcFactory;

    protected Hammer hammer;

    @BeforeClass
    public void before() {
        Set<String> basePackages = new HashSet<>();
        basePackages.add("cn.featherfly.hammer");

        SqlTypeMappingManager sqlTypeMappingManager = new SqlTypeMappingManager();

        TplConfigFactory configFactory = TplConfigFactoryImpl.builder().prefixes("tpl/").suffixes(".yaml.tpl")
                .basePackages(basePackages).preCompile(new FreemarkerTemplatePreProcessor()).build();

        //        SqlPageFactory sqlPageFactory = new SimpleSqlPageFactory();

        //        jdbcFactory = new JdbcFactoryImpl(dialect, sqlTypeMappingManager);

        DatabaseMetadata metadata = DatabaseMetadataManager.getDefaultManager().create(dataSource);
        jdbc = new JdbcSpringImpl(dataSource, dialect, metadata, sqlTypeMappingManager);

        JdbcMappingFactory mappingFactory = new JdbcMappingFactoryImpl(metadata, dialect, sqlTypeMappingManager);

        HammerConfigImpl hammerConfig = new HammerConfigImpl();
        hammerConfig.setValidator(Validation.byProvider(HibernateValidator.class).configure().failFast(false)
                .buildValidatorFactory().getValidator());

        hammer = new SqldbHammerImpl(jdbc, mappingFactory, configFactory, hammerConfig);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void doInsertOne(UserInfo2 userInfo) {
        hammer.save(userInfo);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    protected void doInsertOne(List<UserInfo2> userInfos) {
    //        for (UserInfo2 userInfo : userInfos) {
    //            doInsertOne(userInfo);
    //        }
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void doInsertBatch(List<UserInfo2> userInfos) {
        hammer.save(userInfos);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getName() {
        return "hammer";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected UserInfo2 doSelectById(Serializable id) {
        return hammer.get(id, UserInfo2.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected List<UserInfo2> doSelectById(Serializable... ids) {
        return hammer.get(UserInfo2.class, ids);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected int[] doDeleteById(boolean batch, Serializable... ids) {
        if (batch) {
            return hammer.delete(ids, UserInfo2.class);
        } else {
            int[] res = new int[ids.length];
            for (int i = 0; i < res.length; i++) {
                res[i] = hammer.delete(ids[i], UserInfo2.class);
            }
            return res;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected int[] doUpdateById(boolean batch, Serializable... ids) {
        UserInfo2[] uis = new UserInfo2[ids.length];
        int i = 0;
        for (Serializable id : ids) {
            UserInfo2 ui = userInfo();
            ui.setId((Integer) id);
            uis[i] = ui;
            i++;
        }
        return hammer.update(uis);
    }
}
