
package cn.featherfly.juorm.jdbc.dsl.execute;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.juorm.jdbc.Jdbc;
import cn.featherfly.juorm.sql.dml.builder.basic.SqlDeleteFromBasicBuilder;

/**
 * <p>
 * SqlDeleteExpression
 * </p>
 *
 * @author zhongj
 */
public class SqlDeleteExpression extends SqlConditionGroupExpression {

    private SqlDeleteFromBasicBuilder builder;

    /**
     * @param jdbc
     */
    public SqlDeleteExpression(Jdbc jdbc, String tableName) {
        super(jdbc);
        builder = new SqlDeleteFromBasicBuilder(jdbc.getDialect(), tableName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String build() {
        return builder.build() + Chars.SPACE + jdbc.getDialect().getKeywords().where() + Chars.SPACE + super.build();
    }
}
