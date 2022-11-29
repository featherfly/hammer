
package cn.featherfly.hammer.sqldb.jdbc.dsl.execute;

import java.util.function.Predicate;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.builder.dml.basic.SqlDeleteFromBasicBuilder;
import cn.featherfly.common.repository.IgnorePolicy;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * SqlDeleteExpression .
 *
 * @author zhongj
 */
public class SqlDeleteExpression extends SqlConditionGroupExpression {

    private SqlDeleteFromBasicBuilder builder;

    /**
     * Instantiates a new sql delete expression.
     *
     * @param jdbc         the jdbc
     * @param builder      the builder
     * @param classMapping the class mapping
     */
    public SqlDeleteExpression(Jdbc jdbc, SqlDeleteFromBasicBuilder builder) {
        this(jdbc, builder, IgnorePolicy.NONE);
    }

    /**
     * Instantiates a new sql delete expression.
     *
     * @param jdbc         the jdbc
     * @param builder      the builder
     * @param ignorePolicy the ignore policy
     */
    public SqlDeleteExpression(Jdbc jdbc, SqlDeleteFromBasicBuilder builder, Predicate<Object> ignorePolicy) {
        super(jdbc, builder.getTableAlias(), ignorePolicy);
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
