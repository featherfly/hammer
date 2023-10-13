
package cn.featherfly.hammer.sqldb.jdbc.dsl.execute;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.builder.dml.basic.SqlDeleteFromBasicBuilder;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * SqlDeleteExpression .
 *
 * @author zhongj
 */
public class SqlDeleteExpression extends SqlExecutableConditionGroupExpression<DeleteConditionConfig> {

    private SqlDeleteFromBasicBuilder builder;

    /**
     * Instantiates a new sql delete expression.
     *
     * @param jdbc                  the jdbc
     * @param builder               the builder
     * @param deleteConditionConfig the delete condition config
     */
    public SqlDeleteExpression(Jdbc jdbc, SqlDeleteFromBasicBuilder builder,
            DeleteConditionConfig deleteConditionConfig) {
        super(jdbc, builder.getTableAlias(), deleteConditionConfig);
        this.builder = builder;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String build() {
        String condition = super.build();
        if (parent == null) {
            if (Lang.isEmpty(condition)) {
                switch (((DeleteConditionConfig) conditionConfig).getEmptyConditionStrategy()) {
                    case EXCEPTION:
                        throw new SqldbHammerException("empty condition for delete");
                    case NON_EXECUTION:
                        return null;
                    case EXECUTION:
                        return builder.build();
                    default:
                        return builder.build();
                }
            } else {
                return builder.build() + Chars.SPACE + jdbc.getDialect().getKeywords().where() + Chars.SPACE
                        + condition;
            }
        } else {
            return condition;
        }

        //        String condition = super.build();
        //        if (Strings.isEmpty(condition)) {
        //            return builder.build();
        //        } else {
        //            return builder.build() + Chars.SPACE + jdbc.getDialect().getKeywords().where() + Chars.SPACE + condition;
        //        }
    }
}
