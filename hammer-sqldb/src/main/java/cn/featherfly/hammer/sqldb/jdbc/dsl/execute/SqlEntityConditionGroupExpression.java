
package cn.featherfly.hammer.sqldb.jdbc.dsl.execute;

import java.util.function.Predicate;

import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.hammer.dsl.execute.EntityExecutableConditionGroupExpression;
import cn.featherfly.hammer.dsl.execute.EntityExecutableConditionGroupLogicExpression;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.dsl.query.EntitySqlQuery;
import cn.featherfly.hammer.sqldb.sql.dml.AbstractEntitySqlConditionGroupExpression;

/**
 * sql condition group builder sql条件逻辑组构造器 .
 *
 * @author zhongj
 * @param <E> the element type
 */
public class SqlEntityConditionGroupExpression<E> extends
        AbstractEntitySqlConditionGroupExpression<E, EntityExecutableConditionGroupExpression<E>,
                EntityExecutableConditionGroupLogicExpression<E>>
        implements EntityExecutableConditionGroupExpression<E>, EntityExecutableConditionGroupLogicExpression<E> {

    /**
     * Instantiates a new sql condition group expression.
     *
     * @param jdbc         jdbc
     * @param classMapping classMapping
     * @param factory      the factory
     * @param aliasManager the alias manager
     * @param ignorePolicy the ignore policy
     */
    public SqlEntityConditionGroupExpression(Jdbc jdbc, JdbcClassMapping<E> classMapping, JdbcMappingFactory factory,
            AliasManager aliasManager, Predicate<Object> ignorePolicy) {
        this(jdbc, null, classMapping, factory, aliasManager, ignorePolicy);
    }

    /**
     * Instantiates a new sql condition group expression.
     *
     * @param jdbc         jdbc
     * @param alias        the alias
     * @param classMapping classMapping
     * @param factory      the factory
     * @param aliasManager the alias manager
     * @param ignorePolicy the ignore policy
     */
    public SqlEntityConditionGroupExpression(Jdbc jdbc, String alias, JdbcClassMapping<E> classMapping,
            JdbcMappingFactory factory, AliasManager aliasManager, Predicate<Object> ignorePolicy) {
        this(jdbc, null, alias, classMapping, factory, aliasManager, ignorePolicy);
    }

    /**
     * Instantiates a new sql condition group expression.
     *
     * @param jdbc         jdbc
     * @param parent       parent group
     * @param queryAlias   queryAlias
     * @param classMapping classMapping
     * @param factory      the factory
     * @param aliasManager the alias manager
     * @param ignorePolicy the ignore policy
     */
    SqlEntityConditionGroupExpression(Jdbc jdbc, EntityExecutableConditionGroupLogicExpression<E> parent,
            String queryAlias, JdbcClassMapping<E> classMapping, JdbcMappingFactory factory, AliasManager aliasManager,
            Predicate<Object> ignorePolicy) {
        // 删除，和更新不需要分页
        super(parent, jdbc.getDialect(), null, queryAlias, classMapping, factory, aliasManager, null, ignorePolicy);
        this.jdbc = jdbc;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int execute() {
        if (parent != null) {
            return parent.execute();
        } else {
            return jdbc.update(build(), getParams().toArray());
        }
    }

    // ********************************************************************
    // property
    // ********************************************************************

    /** The jdbc. */
    protected Jdbc jdbc;

    /**
     * {@inheritDoc}
     */
    @Override
    protected EntityExecutableConditionGroupExpression<E> createGroup(
            EntityExecutableConditionGroupLogicExpression<E> parent, String queryAlias,
            EntitySqlQuery<E> entityQueryEntity) {
        return new SqlEntityConditionGroupExpression<>(jdbc, parent, queryAlias, classMapping, factory, aliasManager,
                ignorePolicy);
    }
}
