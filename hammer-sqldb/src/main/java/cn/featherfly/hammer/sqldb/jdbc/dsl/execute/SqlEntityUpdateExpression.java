
package cn.featherfly.hammer.sqldb.jdbc.dsl.execute;

import java.util.ArrayList;
import java.util.List;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.builder.dml.basic.SqlUpdateSetBasicBuilder;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.lang.Strings;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * sql entity update expression .
 *
 * @author zhongj
 * @param <E> the element type
 */
public class SqlEntityUpdateExpression<E> extends SqlEntityConditionGroupExpression<E> {

    private SqlUpdateSetBasicBuilder builder;

    /**
     * Instantiates a new sql entity update expression.
     *
     * @param jdbc         the jdbc
     * @param builder      the builder
     * @param classMapping the class mapping
     * @param factory      the factory
     * @param aliasManager the alias manager
     */
    public SqlEntityUpdateExpression(Jdbc jdbc, SqlUpdateSetBasicBuilder builder, JdbcClassMapping<E> classMapping,
            JdbcMappingFactory factory, AliasManager aliasManager) {
        // ENHANCE 删除暂时没有支持别名
        super(jdbc, classMapping, factory, aliasManager, builder.getIgnorePolicy());
        this.builder = builder;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String build() {
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
