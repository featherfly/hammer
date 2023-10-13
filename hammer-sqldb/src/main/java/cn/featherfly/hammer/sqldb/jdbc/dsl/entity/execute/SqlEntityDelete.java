
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.execute;

import java.util.function.Consumer;

import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.hammer.dsl.entity.execute.EntityDelete;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroup;
import cn.featherfly.hammer.expression.condition.ConditionGroupConfig;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlDeleteRelation;

/**
 * entity sql delete .
 *
 * @author zhongj
 * @param <E> the element type
 */
public class SqlEntityDelete<E> implements EntityDelete<E> {

    //    private String tableName;

    //    private String tableAlias;

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
        //        tableName = classMapping.getRepositoryName();
        //        tableAlias = this.aliasManager.put(tableName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityExecutableConditionGroup<E> where() {
        return createSqlDeleteExpression();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityExecutableConditionGroup<E> where(
            Consumer<ConditionGroupConfig<EntityExecutableConditionGroup<E>>> consumer) {
        SqlEntityDeleteExpression<E> sqlDeleteExpression = createSqlDeleteExpression();

        if (consumer != null) {
            consumer.accept(sqlDeleteExpression);
        }
        return sqlDeleteExpression;
    }

    // ****************************************************************************************************************
    //
    // ****************************************************************************************************************

    private SqlEntityDeleteExpression<E> createSqlDeleteExpression() {
        return new SqlEntityDeleteExpression<>(factory,
                new EntitySqlDeleteRelation(jdbc, aliasManager, IgnoreStrategy.EMPTY).addFilterable(classMapping));
    }
}
