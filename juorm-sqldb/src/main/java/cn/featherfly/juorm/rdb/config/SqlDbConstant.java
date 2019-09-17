
package cn.featherfly.juorm.rdb.config;

import javax.sql.DataSource;

import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.db.metadata.DatabaseMetadataManager;
import cn.featherfly.constant.annotation.Constant;
import cn.featherfly.constant.annotation.ConstantClass;
import cn.featherfly.juorm.config.JuormConstant;
import cn.featherfly.juorm.rdb.jdbc.Jdbc;
import cn.featherfly.juorm.rdb.jdbc.SpringJdbcTemplateImpl;
import cn.featherfly.juorm.rdb.jdbc.mapping.JdbcMappingFactory;
import cn.featherfly.juorm.rdb.sql.dialect.Dialect;
import cn.featherfly.juorm.rdb.sql.dialect.Dialects;

/**
 * <p>
 * SqlDbConstant
 * </p>
 * <p>
 * 2019-08-26
 * </p>
 *
 * @author zhongj
 */
// FIXME 这里还是有一些问题，依赖设置时，被依赖项不会更新
@ConstantClass(value = "JuormSqlDb初始化配置")
public class SqlDbConstant extends JuormConstant {

    private SqlDbConstant() {
    }

    @Constant("database dataSource")
    private DataSource dataSource;
    @Constant("database dialect")
    private Dialect dialect = Dialects.MYSQL;
    @Constant("database metadata")
    private DatabaseMetadata metadata;
    @Constant("object mapping factory")
    private JdbcMappingFactory mappingFactory;
    @Constant("jdbc operator")
    private Jdbc jdbc;

    /**
     * 返回dialect
     *
     * @return dialect
     */
    public Dialect getDialect() {
        return dialect;
    }

    /**
     * 返回databaseMetadata
     *
     * @return databaseMetadata
     */
    public DatabaseMetadata getMetadata() {
        if (metadata == null) {
            synchronized (this) {
                if (metadata == null && dataSource != null) {
                    metadata = DatabaseMetadataManager.getDefaultManager().create(dataSource);
                }
            }
        }
        return metadata;
    }

    /**
     * 返回mappingFactory
     *
     * @return mappingFactory
     */
    public JdbcMappingFactory getMappingFactory() {
        if (mappingFactory == null) {
            synchronized (this) {
                if (mappingFactory == null && getMetadata() != null) {
                    mappingFactory = new JdbcMappingFactory(getMetadata(), getDialect());
                }
            }
        }
        return mappingFactory;
    }

    /**
     * 返回dataSource
     *
     * @return dataSource
     */
    public DataSource getDataSource() {
        return dataSource;
    }

    /**
     * 返回jdbc
     *
     * @return jdbc
     */
    public Jdbc getJdbc() {
        if (jdbc == null) {
            synchronized (this) {
                if (jdbc == null && getDataSource() != null) {
                    jdbc = new SpringJdbcTemplateImpl(getDataSource(), getDialect());
                }
            }
        }
        return jdbc;
    }
}
