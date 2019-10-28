
package cn.featherfly.juorm.rdb.jdbc.dsl.execute;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.juorm.mapping.ClassMapping;
import cn.featherfly.juorm.rdb.jdbc.Jdbc;
import cn.featherfly.juorm.rdb.sql.dml.builder.basic.SqlDeleteFromBasicBuilder;

/**
 * <p>
 * SqlDeleteExpression
 * </p>
 * .
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
    public SqlDeleteExpression(Jdbc jdbc, SqlDeleteFromBasicBuilder builder, ClassMapping<?> classMapping) {
        super(jdbc, null, classMapping);
        this.builder = builder;
    }

    /**
     * Instantiates a new sql delete expression.
     *
     * @param jdbc    the jdbc
     * @param builder the builder
     */
    public SqlDeleteExpression(Jdbc jdbc, SqlDeleteFromBasicBuilder builder) {
        this(jdbc, builder, null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String build() {
        return builder.build() + Chars.SPACE + jdbc.getDialect().getKeywords().where() + Chars.SPACE + super.build();
    }
}
