//
//package cn.featherfly.hammer.sqldb.config;
//
//import cn.featherfly.common.db.mapping.JdbcMappingFactory;
//import cn.featherfly.common.db.mapping.JdbcMappingFactoryImpl;
//import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
//import cn.featherfly.common.db.metadata.DatabaseMetadataManager;
//import cn.featherfly.constant.ConstantConfigurator;
//import cn.featherfly.constant.ConstantPool;
//import cn.featherfly.hammer.Hammer;
//import cn.featherfly.hammer.config.Configurator;
//import cn.featherfly.hammer.sqldb.SqldbHammerImpl;
//import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
//import cn.featherfly.hammer.sqldb.jdbc.JdbcSpringImpl;
//import cn.featherfly.hammer.sqldb.tpl.SqlDbTemplateEngine;
//import cn.featherfly.hammer.sqldb.tpl.freemarker.SqldbFreemarkerTemplateEngine;
//import cn.featherfly.hammer.tpl.TplConfigFactory;
//import cn.featherfly.hammer.tpl.TplConfigFactoryImpl;
//
///**
// * SqlDbConfigurator.
// *
// * @author zhongj
// */
//public class SqlDbConfigurator implements Configurator {
//
//    public static final String DEFAULT_FILE_NAME = "hammer.yaml";
//
//    private volatile static SqlDbConfigurator DEFAULT;
//
//    private SqldbHammerImpl sqldbHammer;
//
//    private Jdbc jdbc;
//
//    public SqlDbConfigurator() {
//    }
//
//    /**
//     * get default Configuration
//     *
//     * @return default Configuration
//     */
//    public static SqlDbConfigurator getDefault() {
//        return getDefault(DEFAULT_FILE_NAME);
//    }
//
//    /**
//     * get default Configuration
//     *
//     * @param fileName file name
//     * @return default Configuration
//     */
//    public static SqlDbConfigurator getDefault(String fileName) {
//        if (DEFAULT == null) {
//            synchronized (SqlDbConfigurator.class) {
//                if (DEFAULT == null) {
//                    SqlDbConfigurator configuration = new SqlDbConfigurator();
//                    if (!ConstantPool.isInit()) {
//                        ConstantConfigurator.config(fileName);
//                    }
//                    SqlDbConstant constant = ConstantPool.getDefault().getConstant(SqlDbConstant.class);
//
//                    TplConfigFactory factory = constant.getTplConfigFactory();
//                    if (factory == null) {
//                        factory = new TplConfigFactoryImpl(constant.getTplConfigPrefix(),
//                                constant.getTplConfigSuffix());
//                    }
//
//                    //                    Jdbc jdbc = constant.getJdbc();
//                    //                    if (jdbc == null) {
//                    //                        SqlTypeMappingManager sqlTypeMappingManager = new SqlTypeMappingManager(); // TODO 后续加入配置
//                    //                        jdbc = new JdbcImpl(constant.getDataSource(), constant.getDialect(), sqlTypeMappingManager);
//                    //                    }
//
//                    Jdbc jdbc = new JdbcSpringImpl(constant.getDataSource(), constant.getDialect(),
//                            new SqlTypeMappingManager() /*TODO 后续加入配置*/);
//
//                    @SuppressWarnings("rawtypes")
//                    SqlDbTemplateEngine templateEngine = new SqldbFreemarkerTemplateEngine(factory);
//                    //                    SqlDbTemplateEngine templateEngine = constant.getTemplateEngine();
//                    //                    if (templateEngine == null) {
//                    //                        templateEngine = new SqldbFreemarkerTemplateEngine(factory);
//                    //                    }
//
//                    JdbcMappingFactory mappingFactory = new JdbcMappingFactoryImpl(
//                            DatabaseMetadataManager.getDefaultManager().create(constant.getDataSource()),
//                            constant.getDialect(), jdbc.getSqlTypeMappingManager());
//                    //                    MappingFactory<?> mappingFactory = constant.getMappingFactory();
//                    //                    if (mappingFactory == null) {
//                    //                        mappingFactory = new JdbcMappingFactoryImpl(
//                    //                                DatabaseMetadataManager.getDefaultManager().create(constant.getDataSource()),
//                    //                                constant.getDialect(), sqlTypeMappingManager);
//                    //                    }
//
//                    configuration.sqldbHammer = new SqldbHammerImpl(jdbc, mappingFactory, factory, templateEngine);
//                    configuration.jdbc = jdbc;
//                    DEFAULT = configuration;
//                }
//            }
//        }
//        return DEFAULT;
//    }
//
//    public Jdbc getJdbc() {
//        return jdbc;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public Hammer getHammer() {
//        return sqldbHammer;
//    }
//}
