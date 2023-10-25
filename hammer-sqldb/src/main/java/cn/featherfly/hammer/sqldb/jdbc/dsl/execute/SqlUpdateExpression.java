
package cn.featherfly.hammer.sqldb.jdbc.dsl.execute;

import java.util.ArrayList;
import java.util.List;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.builder.dml.basic.SqlUpdateSetBasicBuilder;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * SqlDeleteExpression .
 *
 * @author zhongj
 */
public class SqlUpdateExpression extends SqlExecutableConditionGroupExpression<UpdateConditionConfig> {

    private SqlUpdateSetBasicBuilder builder;

    /**
     * Instantiates a new sql update expression.
     *
     * @param jdbc                  the jdbc
     * @param builder               the builder
     * @param updateConditionConfig the update condition config
     */
    public SqlUpdateExpression(Jdbc jdbc, SqlUpdateSetBasicBuilder builder,
            UpdateConditionConfig updateConditionConfig) {
        super(jdbc, builder.getAlias(), updateConditionConfig);
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
                switch (((UpdateConditionConfig) conditionConfig).getEmptyConditionStrategy()) {
                    case EXCEPTION:
                        throw new SqldbHammerException("empty condition for update");
                    case NON_EXECUTION:
                        return null;
                    case EXECUTION:
                        return builder.build();
                    default:
                        return builder.build();
                }
            } else {
                try {
                    return builder.build() + Chars.SPACE + jdbc.getDialect().getKeywords().where() + Chars.SPACE
                            + condition;
                } catch (JdbcException e) {
                    // no value to set, use NON_EXECUTION strategy
                    return null;
                }
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
