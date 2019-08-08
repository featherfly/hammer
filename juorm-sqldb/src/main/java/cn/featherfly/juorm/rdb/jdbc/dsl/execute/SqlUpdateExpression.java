
package cn.featherfly.juorm.rdb.jdbc.dsl.execute;

import java.util.ArrayList;
import java.util.List;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.juorm.rdb.jdbc.Jdbc;
import cn.featherfly.juorm.rdb.jdbc.mapping.ClassMapping;
import cn.featherfly.juorm.rdb.sql.dml.builder.basic.SqlUpdateSetBasicBuilder;

/**
 * <p>
 * SqlDeleteExpression
 * </p>
 *
 * @author zhongj
 */
public class SqlUpdateExpression extends SqlConditionGroupExpression {

    private SqlUpdateSetBasicBuilder builder;

    /**
     * @param jdbc
     * @param builder
     */
    public SqlUpdateExpression(Jdbc jdbc, SqlUpdateSetBasicBuilder builder) {
        this(jdbc, builder, null);
    }

    /**
     * @param jdbc
     * @param builder
     * @param classMapping
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
