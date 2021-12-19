
package cn.featherfly.hammer.sqldb.jdbc.dsl.execute;

import java.util.function.Consumer;

import cn.featherfly.common.db.builder.dml.basic.SqlDeleteFromBasicBuilder;
import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.hammer.dsl.execute.Delete;
import cn.featherfly.hammer.dsl.execute.ExecutableConditionGroupExpression;
import cn.featherfly.hammer.expression.Repository;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

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
        tableName = classMapping.getRepositoryName();
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

    /**
     * {@inheritDoc}
     */
    @Override
    public ExecutableConditionGroupExpression where(Consumer<ExecutableConditionGroupExpression> consumer) {
        SqlDeleteExpression sqlDeleteExpression = new SqlDeleteExpression(jdbc,
                new SqlDeleteFromBasicBuilder(jdbc.getDialect(), tableName), classMapping);
        if (consumer != null) {
            consumer.accept(sqlDeleteExpression);
        }
        return sqlDeleteExpression;
    }
}
