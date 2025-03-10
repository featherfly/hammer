
package cn.featherfly.hammer.sqldb.config;

import javax.sql.DataSource;

import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.db.dialect.Dialects;
import cn.featherfly.constant.annotation.Constant;
import cn.featherfly.constant.annotation.ConstantClass;
import cn.featherfly.hammer.config.HammerConstant;

/**
 * <p>
 * SqlDbConstant
 * </p>
 *
 * @author zhongj
 */
// FIXME 这里还是有一些问题，依赖设置时，被依赖项不会更新
@ConstantClass(value = "HammerSqlDb初始化配置")
public class SqlDbConstant extends HammerConstant {

    private SqlDbConstant() {
    }

    @Constant("database dataSource")
    private DataSource dataSource;
    @Constant("database dialect")
    private Dialect dialect = Dialects.mysql();
    //    @Constant("database metadata")
    //    private DatabaseMetadata metadata;
    //    @Constant("object mapping factory")
    //    private JdbcMappingFactory mappingFactory;
    //    @Constant("jdbc operator")
    //    private Jdbc jdbc;

    //    @Constant(value = "template processor")
    //    @SuppressWarnings("rawtypes")
    //    private SqlDbTemplateEngine templateEngine;

    /**
     * 返回dialect
     *
     * @return dialect
     */
    public Dialect getDialect() {
        return dialect;
    }

    //    /**
    //     * 返回databaseMetadata
    //     *
    //     * @return databaseMetadata
    //     */
    //    public DatabaseMetadata getMetadata() {
    //        if (metadata == null) {
    //            synchronized (this) {
    //                if (metadata == null && dataSource != null) {
    //                    metadata = DatabaseMetadataManager.getDefaultManager().create(dataSource);
    //                }
    //            }
    //        }
    //        return metadata;
    //    }

    //    /**
    //     * 返回mappingFactory
    //     *
    //     * @return mappingFactory
    //     */
    //    public JdbcMappingFactory getMappingFactory() {
    //        if (mappingFactory == null) {
    //            synchronized (this) {
    //                if (mappingFactory == null && getMetadata() != null) {
    //                    mappingFactory = new JdbcMappingFactoryImpl(getMetadata(), getDialect());
    //                }
    //            }
    //        }
    //        return mappingFactory;
    //    }

    //    /**
    //     * 返回templateEngine
    //     *
    //     * @return templateEngine
    //     */
    //    @SuppressWarnings("rawtypes")
    //    public SqlDbTemplateEngine getTemplateEngine() {
    //        //        if (templateProcessor == null) {
    //        //            synchronized (this) {
    //        //                if (templateProcessor == null && getTplConfigFactory() != null) {
    //        //                    templateProcessor = new FreemarkerTemplateProcessor(getTplConfigFactory());
    //        //                }
    //        //            }
    //        //        }
    //        return templateEngine;
    //    }

    /**
     * 返回dataSource
     *
     * @return dataSource
     */
    public DataSource getDataSource() {
        return dataSource;
    }

    //    /**
    //     * 返回jdbc
    //     *
    //     * @return jdbc
    //     */
    //    public Jdbc getJdbc() {
    //        if (jdbc == null) {
    //            synchronized (this) {
    //                if (jdbc == null && getDataSource() != null) {
    //                    //                    jdbc = new SpringJdbcTemplateImpl(getDataSource(), getDialect());
    //                    jdbc = new JdbcImpl(getDataSource(), getDialect(), new SqlTypeMappingManager());
    //                }
    //            }
    //        }
    //        return jdbc;
    //    }
}
