
package cn.featherfly.hammer.sqldb.jdbc.dsl.execute;

import java.util.function.Consumer;

import cn.featherfly.common.db.builder.dml.basic.SqlDeleteFromBasicBuilder;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.hammer.dsl.execute.EntityDelete;
import cn.featherfly.hammer.dsl.execute.EntityExecutableConditionGroupExpression;
import cn.featherfly.hammer.expression.condition.ConditionGroupConfig;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * entity sql delete .
 *
 * @author zhongj
 * @param <E> the element type
 */
public class SqlEntityDelete<E> implements EntityDelete<E> {

    private String tableName;

    private String tableAlias;

    private JdbcClassMapping<E> classMapping;

    private JdbcMappingFactory factory;

    private AliasManager aliasManager;

    private Jdbc jdbc;

    /**
     * Instantiates a new sql delete.
     *
     * @param jdbc         the jdbc
     * @param factory      the factory
     * @param classMapping the class mapping
     */
    public SqlEntityDelete(Jdbc jdbc, JdbcMappingFactory factory, JdbcClassMapping<E> classMapping) {
        this(jdbc, factory, classMapping, new AliasManager());
    }

    /**
     * Instantiates a new sql delete.
     *
     * @param jdbc         the jdbc
     * @param factory      the factory
     * @param classMapping the class mapping
     * @param aliasManager the alias manager
     */
    public SqlEntityDelete(Jdbc jdbc, JdbcMappingFactory factory, JdbcClassMapping<E> classMapping,
            AliasManager aliasManager) {
        this.jdbc = jdbc;
        this.factory = factory;
        this.classMapping = classMapping;
        this.aliasManager = aliasManager;
        tableName = classMapping.getRepositoryName();
        tableAlias = this.aliasManager.put(tableName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityExecutableConditionGroupExpression<E> where() {
        return new SqlEntityDeleteExpression<>(jdbc,
                new SqlDeleteFromBasicBuilder(jdbc.getDialect(), tableName, tableAlias), classMapping, factory,
                aliasManager);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityExecutableConditionGroupExpression<E> where(
            Consumer<ConditionGroupConfig<EntityExecutableConditionGroupExpression<E>>> consumer) {
        SqlEntityDeleteExpression<E> sqlDeleteExpression = new SqlEntityDeleteExpression<>(jdbc,
                new SqlDeleteFromBasicBuilder(jdbc.getDialect(), tableName, tableAlias), classMapping, factory,
                aliasManager);
        if (consumer != null) {
            consumer.accept(sqlDeleteExpression);
        }
        return sqlDeleteExpression;
    }
}
