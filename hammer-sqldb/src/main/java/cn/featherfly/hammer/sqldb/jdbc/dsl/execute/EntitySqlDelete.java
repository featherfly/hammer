
package cn.featherfly.hammer.sqldb.jdbc.dsl.execute;

import java.util.function.Consumer;

import cn.featherfly.common.db.builder.dml.basic.SqlDeleteFromBasicBuilder;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.hammer.dsl.execute.EntityDelete;
import cn.featherfly.hammer.dsl.execute.EntityExecutableConditionGroupExpression;
import cn.featherfly.hammer.expression.condition.ConditionGroupConfig;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * entity sql delete .
 *
 * @author zhongj
 */
public class EntitySqlDelete<E> implements EntityDelete<E> {

    private String tableName;

    private JdbcClassMapping<E> classMapping;

    private Jdbc jdbc;

    /**
     * Instantiates a new sql delete.
     *
     * @param classMapping the class mapping
     * @param jdbc         the jdbc
     */
    public EntitySqlDelete(JdbcClassMapping<E> classMapping, Jdbc jdbc) {
        this.jdbc = jdbc;
        this.classMapping = classMapping;
        tableName = classMapping.getRepositoryName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityExecutableConditionGroupExpression<E> where() {
        return new EntitySqlDeleteExpression<>(jdbc, new SqlDeleteFromBasicBuilder(jdbc.getDialect(), tableName),
                classMapping, null, null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityExecutableConditionGroupExpression<E> where(
            Consumer<ConditionGroupConfig<EntityExecutableConditionGroupExpression<E>>> consumer) {
        EntitySqlDeleteExpression<E> sqlDeleteExpression = new EntitySqlDeleteExpression<>(jdbc,
                new SqlDeleteFromBasicBuilder(jdbc.getDialect(), tableName), classMapping, null, null);
        if (consumer != null) {
            consumer.accept(sqlDeleteExpression);
        }
        return sqlDeleteExpression;
    }
}
