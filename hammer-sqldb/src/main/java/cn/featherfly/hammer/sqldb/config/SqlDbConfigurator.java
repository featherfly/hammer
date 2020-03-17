
package cn.featherfly.hammer.sqldb.config;

import cn.featherfly.constant.ConstantConfigurator;
import cn.featherfly.constant.ConstantPool;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.config.Configurator;
import cn.featherfly.hammer.sqldb.SqldbHammerImpl;
import cn.featherfly.hammer.sqldb.tpl.SqlDbTemplateEngine;
import cn.featherfly.hammer.sqldb.tpl.freemarker.SqldbFreemarkerTemplateEngine;
import cn.featherfly.hammer.tpl.TplConfigFactory;
import cn.featherfly.hammer.tpl.TplConfigFactoryImpl;

/**
 * <p>
 * Configurator
 * </p>
 *
 * @author zhongj
 */
public class SqlDbConfigurator implements Configurator {

    private static SqlDbConfigurator DEFAULT;

    private SqldbHammerImpl sqldbHammer;

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

                    configuration.sqldbHammer = new SqldbHammerImpl(constant.getJdbc(), constant.getMappingFactory(),
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
    public Hammer getHammer() {
        return sqldbHammer;
    }

    public SqlDbConstant getConstant() {
        return constant;
    }
}
