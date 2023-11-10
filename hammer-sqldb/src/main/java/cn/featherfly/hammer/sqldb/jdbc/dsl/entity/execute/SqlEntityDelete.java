
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.execute;

import java.util.function.Consumer;
import java.util.function.Function;

import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.config.dsl.DeleteConfig;
import cn.featherfly.hammer.dsl.entity.execute.EntityDelete;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroup;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroupLogic;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.EntityConditionsGroupExpression;
import cn.featherfly.hammer.expression.entity.execute.EntityDeleteExpression;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlConditionsGroupExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlDeleteRelation;

/**
 * entity sql delete .
 *
 * @author zhongj
 * @param <E> the element type
 */
public class SqlEntityDelete<E> implements EntityDelete<E> {

    private JdbcMappingFactory factory;

    private EntitySqlDeleteRelation relation;

    private DeleteConfig deleteConfig;

    /**
     * Instantiates a new sql delete.
     *
     * @param jdbc         the jdbc
     * @param factory      the factory
     * @param classMapping the class mapping
     * @param deleteConfig the delete config
     */
    public SqlEntityDelete(Jdbc jdbc, JdbcMappingFactory factory, JdbcClassMapping<E> classMapping,
        DeleteConfig deleteConfig) {
        this(jdbc, factory, classMapping, deleteConfig, new AliasManager());
    }

    /**
     * Instantiates a new sql delete.
     *
     * @param jdbc         the jdbc
     * @param factory      the factory
     * @param classMapping the class mapping
     * @param deleteConfig the delete config
     * @param aliasManager the alias manager
     */
    public SqlEntityDelete(Jdbc jdbc, JdbcMappingFactory factory, JdbcClassMapping<E> classMapping,
        DeleteConfig deleteConfig, AliasManager aliasManager) {
        this.factory = factory;
        this.deleteConfig = deleteConfig.clone();
        //        tableName = classMapping.getRepositoryName();
        //        tableAlias = this.aliasManager.put(tableName);

        // 使用 this.updateConfig 是因为this.updateConfig是克隆的副本（用于configure()单独配置当前表达式生效）
        relation = new EntitySqlDeleteRelation(jdbc, aliasManager, this.deleteConfig).addFilterable(classMapping);
        // addFilterable 初始化builder
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityExecutableConditionGroup<E, DeleteConditionConfig> where() {
        return createSqlDeleteExpression();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityExecutableConditionGroupLogic<E, DeleteConditionConfig> where(
        Function<EntityConditionsGroupExpression<E, ?, ?>, LogicExpression<?, ?>> function) {
        SqlEntityDeleteExpression<E> sqlDeleteExpression = createSqlDeleteExpression();
        if (function != null) {
            if (function != null) {
                sqlDeleteExpression
                    .addCondition(function.apply(new EntitySqlConditionsGroupExpression<>(0, factory, relation)));
            }
        }
        return sqlDeleteExpression;
    }

    // ****************************************************************************************************************
    //
    // ****************************************************************************************************************

    private SqlEntityDeleteExpression<E> createSqlDeleteExpression() {
        return new SqlEntityDeleteExpression<>(factory, relation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityDeleteExpression<E, EntityExecutableConditionGroup<E, DeleteConditionConfig>,
        EntityExecutableConditionGroupLogic<E, DeleteConditionConfig>> configure(Consumer<DeleteConfig> configure) {
        if (configure != null) {
            configure.accept(deleteConfig);
        }
        return this;
    }
}
