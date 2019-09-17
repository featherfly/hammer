
package cn.featherfly.juorm.rdb.jdbc.dsl.execute;

import cn.featherfly.juorm.dsl.execute.Delete;
import cn.featherfly.juorm.dsl.execute.ExecutableConditionGroupExpression;
import cn.featherfly.juorm.expression.Repository;
import cn.featherfly.juorm.rdb.jdbc.Jdbc;
import cn.featherfly.juorm.rdb.jdbc.mapping.ClassMapping;
import cn.featherfly.juorm.rdb.sql.dml.builder.basic.SqlDeleteFromBasicBuilder;

/**
 * <p>
 * SqlDelete
 * </p>
 * .
 *
 * @author zhongj
 */
public class SqlDelete implements Delete {

    private String tableName;

    private ClassMapping<?> classMapping;

    private Jdbc jdbc;

    /**
     * Instantiates a new sql delete.
     *
     * @param tableName the table name
     * @param jdbc      the jdbc
     */
    public SqlDelete(String tableName, Jdbc jdbc) {
        this.tableName = tableName;
        this.jdbc = jdbc;
    }

    /**
     * Instantiates a new sql delete.
     *
     * @param classMapping the class mapping
     * @param jdbc         the jdbc
     */
    public SqlDelete(ClassMapping<?> classMapping, Jdbc jdbc) {
        this.jdbc = jdbc;
        this.classMapping = classMapping;
        tableName = classMapping.getTableName();
    }

    /**
     * Instantiates a new sql delete.
     *
     * @param repository repository
     * @param jdbc       jdbc
     */
    public SqlDelete(Repository repository, Jdbc jdbc) {
        this(repository.name(), jdbc);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExecutableConditionGroupExpression where() {
        return new SqlDeleteExpression(jdbc, new SqlDeleteFromBasicBuilder(jdbc.getDialect(), tableName), classMapping);
    }
}
