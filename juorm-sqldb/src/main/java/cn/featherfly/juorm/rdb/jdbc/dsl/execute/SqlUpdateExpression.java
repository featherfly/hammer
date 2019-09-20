
package cn.featherfly.juorm.rdb.jdbc.dsl.execute;

import java.util.ArrayList;
import java.util.List;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.juorm.mapping.ClassMapping;
import cn.featherfly.juorm.rdb.jdbc.Jdbc;
import cn.featherfly.juorm.rdb.sql.dml.builder.basic.SqlUpdateSetBasicBuilder;

/**
 * <p>
 * SqlDeleteExpression
 * </p>
 * .
 *
 * @author zhongj
 */
public class SqlUpdateExpression extends SqlConditionGroupExpression {

    private SqlUpdateSetBasicBuilder builder;

    /**
     * Instantiates a new sql update expression.
     *
     * @param jdbc    the jdbc
     * @param builder the builder
     */
    public SqlUpdateExpression(Jdbc jdbc, SqlUpdateSetBasicBuilder builder) {
        this(jdbc, builder, null);
    }

    /**
     * Instantiates a new sql update expression.
     *
     * @param jdbc         the jdbc
     * @param builder      the builder
     * @param classMapping the class mapping
     */
    public SqlUpdateExpression(Jdbc jdbc, SqlUpdateSetBasicBuilder builder, ClassMapping<?> classMapping) {
        super(jdbc, null, classMapping);
        this.builder = builder;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String build() {
        return builder.build() + Chars.SPACE + jdbc.getDialect().getKeywords().where() + Chars.SPACE + super.build();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Object> getParams() {
        List<Object> params = new ArrayList<>();
        params.addAll(builder.getParams());
        params.addAll(super.getParams());
        return params;
    }
}
