
package cn.featherfly.hammer.sqldb.jdbc.dsl.execute;

import java.util.function.Predicate;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.builder.dml.basic.SqlDeleteFromBasicBuilder;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.repository.IgnorePolicy;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * SqlDeleteExpression .
 *
 * @author zhongj
 * @param <E> the element type
 */
public class EntitySqlDeleteExpression<E> extends EntitySqlConditionGroupExpression<E> {

    private SqlDeleteFromBasicBuilder builder;

    /**
     * Instantiates a new sql delete expression.
     *
     * @param jdbc         the jdbc
     * @param builder      the builder
     * @param classMapping the class mapping
     * @param factory      the factory
     * @param aliasManager the alias manager
     */
    public EntitySqlDeleteExpression(Jdbc jdbc, SqlDeleteFromBasicBuilder builder, JdbcClassMapping<E> classMapping,
            JdbcMappingFactory factory, AliasManager aliasManager) {
        this(jdbc, builder, classMapping, factory, aliasManager, IgnorePolicy.EMPTY);
    }

    /**
     * Instantiates a new entity sql delete expression.
     *
     * @param jdbc         the jdbc
     * @param builder      the builder
     * @param classMapping the class mapping
     * @param factory      the factory
     * @param aliasManager the alias manager
     * @param ignorePolicy the ignore policy
     */
    public EntitySqlDeleteExpression(Jdbc jdbc, SqlDeleteFromBasicBuilder builder, JdbcClassMapping<E> classMapping,
            JdbcMappingFactory factory, AliasManager aliasManager, Predicate<Object> ignorePolicy) {
        // ENHANCE 删除暂时没有支持别名
        super(jdbc, classMapping, factory, aliasManager, ignorePolicy);
        this.builder = builder;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String build() {
        return builder.build() + Chars.SPACE + jdbc.getDialect().getKeywords().where() + Chars.SPACE + super.build();
    }
}
