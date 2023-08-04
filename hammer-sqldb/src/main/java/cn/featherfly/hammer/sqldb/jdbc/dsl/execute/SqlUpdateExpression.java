
package cn.featherfly.hammer.sqldb.jdbc.dsl.execute;

import java.util.ArrayList;
import java.util.List;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.builder.dml.basic.SqlUpdateSetBasicBuilder;
import cn.featherfly.common.lang.Strings;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * SqlDeleteExpression .
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
        super(jdbc, builder.getAlias(), builder.getIgnoreStrategy());
        this.builder = builder;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String build() {
        // YUFEI_TODO 后续加入策略
        if (builder.getParams().isEmpty()) {
            return null;
        }
        String condition = super.build();
        if (Strings.isEmpty(condition)) {
            return builder.build();
        } else {
            return builder.build() + Chars.SPACE + jdbc.getDialect().getKeywords().where() + Chars.SPACE + condition;
        }
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
