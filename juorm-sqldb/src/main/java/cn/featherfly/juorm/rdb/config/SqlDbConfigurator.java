
package cn.featherfly.juorm.rdb.config;

import cn.featherfly.constant.ConstantConfigurator;
import cn.featherfly.constant.ConstantPool;
import cn.featherfly.juorm.Juorm;
import cn.featherfly.juorm.config.Configurator;
import cn.featherfly.juorm.rdb.jdbc.JuormJdbcImpl;
import cn.featherfly.juorm.rdb.tpl.SqlDbTemplateEngine;
import cn.featherfly.juorm.rdb.tpl.freemarker.SqldbFreemarkerTemplateEngine;
import cn.featherfly.juorm.tpl.TplConfigFactory;
import cn.featherfly.juorm.tpl.TplConfigFactoryImpl;

/**
 * <p>
 * Configurator
 * </p>
 * <p>
 * 2019-08-26
 * </p>
 *
 * @author zhongj
 */
public class SqlDbConfigurator implements Configurator {

    private static SqlDbConfigurator DEFAULT;

    private JuormJdbcImpl juormJdbc;

    private SqlDbConstant constant;

    public SqlDbConfigurator() {
    }

    /**
     * get default Configuration
     *
     * @return default Configuration
     */
    public static SqlDbConfigurator getDefault() {
        return getDefault(ConstantConfigurator.DEFAULT_FILE);
    }

    /**
     * get default Configuration
     *
     * @param fileName file name
     * @return default Configuration
     */
    public static SqlDbConfigurator getDefault(String fileName) {
        if (DEFAULT == null) {
            synchronized (SqlDbConfigurator.class) {
                if (DEFAULT == null) {
                    SqlDbConfigurator configuration = new SqlDbConfigurator();
                    if (!ConstantPool.isInit()) {
                        ConstantConfigurator.config(fileName);
                    }
                    SqlDbConstant constant = ConstantPool.getDefault().getConstant(SqlDbConstant.class);

                    TplConfigFactory factory = constant.getTplConfigFactory();
                    if (factory == null) {
                        factory = new TplConfigFactoryImpl(constant.getTplConfigPrefix(),
                                constant.getTplConfigSuffix());
                    }

                    @SuppressWarnings("rawtypes")
                    SqlDbTemplateEngine processor = constant.getTemplateEngine();
                    if (processor == null) {
                        processor = new SqldbFreemarkerTemplateEngine(factory);
                    }

                    configuration.juormJdbc = new JuormJdbcImpl(constant.getJdbc(), constant.getMappingFactory(),
                            factory, processor);
                    configuration.constant = constant;
                    DEFAULT = configuration;
                }
            }
        }
        return DEFAULT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Juorm getJuorm() {
        return juormJdbc;
    }

    public SqlDbConstant getConstant() {
        return constant;
    }
}
