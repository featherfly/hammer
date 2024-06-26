
package cn.featherfly.hammer.sqldb.dsl.entity.execute;

import java.util.function.Consumer;
import java.util.function.Function;

import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.config.dsl.DeleteConfig;
import cn.featherfly.hammer.dsl.entity.EntityOnExpression1;
import cn.featherfly.hammer.dsl.entity.execute.EntityDelete;
import cn.featherfly.hammer.dsl.entity.execute.EntityDelete2;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroup;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroupLogic;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.EntityConditionsGroupExpression;
import cn.featherfly.hammer.expression.entity.execute.EntityDeleteExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlConditionsGroupExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlDeleteRelation;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlOn1;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * entity sql delete .
 *
 * @author zhongj
 * @param <E> the element type
 */
public class EntitySqlDelete<E> implements EntityDelete<E> {

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
    public EntitySqlDelete(Jdbc jdbc, JdbcMappingFactory factory, JdbcClassMapping<E> classMapping,
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
    public EntitySqlDelete(Jdbc jdbc, JdbcMappingFactory factory, JdbcClassMapping<E> classMapping,
        DeleteConfig deleteConfig, AliasManager aliasManager) {
        this.factory = factory;
        this.deleteConfig = deleteConfig.clone();
        //        tableName = classMapping.getRepositoryName();
        //        tableAlias = this.aliasManager.put(tableName);

        // 使用 this.updateConfig 是因为this.updateConfig是克隆的副本（用于configure()单独配置当前表达式生效）
        relation = new EntitySqlDeleteRelation(jdbc, aliasManager, this.deleteConfig).addFilterable(classMapping);
        // addFilterable 初始化builder
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public <J> EntityOnExpression1<E, J, EntityDelete2<E, J>> join(Class<J> joinType) {
        return new EntitySqlOn1<>(joinType, new EntitySqlDelete2<>(factory, relation), factory, relation);
    }

    // ----------------------------------------------------------------------------------------------------------------

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
        EntitySqlDeleteConditions<E> sqlDeleteExpression = createSqlDeleteExpression();
        if (function != null) {
            sqlDeleteExpression
                .addCondition(function.apply(new EntitySqlConditionsGroupExpression<>(0, factory, relation)));
        }
        return sqlDeleteExpression;
    }

    // ****************************************************************************************************************
    //
    // ****************************************************************************************************************

    private EntitySqlDeleteConditions<E> createSqlDeleteExpression() {
        return new EntitySqlDeleteConditions<>(factory, relation);
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
