
package cn.featherfly.juorm.rdb.jdbc.dsl.query;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.juorm.dml.AliasManager;
import cn.featherfly.juorm.dsl.query.RepositoryTypeQueryConditionGroupLogicExpression;
import cn.featherfly.juorm.mapping.ClassMapping;
import cn.featherfly.juorm.rdb.jdbc.Jdbc;
import cn.featherfly.juorm.rdb.sql.dml.builder.basic.SqlSelectBasicBuilder;

/**
 * <p>
 * SqlDeleteExpression
 * </p>
 * .
 *
 * @author zhongj
 */
public class RepositoryTypeSqlQueryExpression extends RepositoryTypeSqlQueryConditionGroupExpression {

    private SqlSelectBasicBuilder selectBuilder;

    /**
     * Instantiates a new sql query expression.
     *
     * @param jdbc          the jdbc
     * @param aliasManager  aliasManager
     * @param classMapping  the class mapping
     * @param selectBuilder the select builder
     */
    public RepositoryTypeSqlQueryExpression(Jdbc jdbc, AliasManager aliasManager, ClassMapping<?> classMapping,
            SqlSelectBasicBuilder selectBuilder) {
        super(jdbc, aliasManager, selectBuilder.getTableAlias(), classMapping);
        this.selectBuilder = selectBuilder;
    }

    /**
     * @param jdbc
     * @param aliasManager aliasManager
     * @param parent
     * @param queryAlias
     * @param classMapping
     */
    RepositoryTypeSqlQueryExpression(Jdbc jdbc, AliasManager aliasManager,
            RepositoryTypeQueryConditionGroupLogicExpression parent, String queryAlias, ClassMapping<?> classMapping) {
        super(jdbc, aliasManager, parent, queryAlias, classMapping);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryTypeSqlQueryConditionGroupExpression createGroup(
            RepositoryTypeQueryConditionGroupLogicExpression parent, String queryAlias) {
        selectBuilder.setTableAlias(queryAlias);
        return new RepositoryTypeSqlQueryExpression(jdbc, aliasManager, parent, queryAlias, classMapping);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String build() {
        String result = "";
        if (selectBuilder != null) {
            result = selectBuilder.build();
        }
        String condition = super.build();
        if (LangUtils.isNotEmpty(condition)) {
            result = result + Chars.SPACE + condition;
        }
        return result;
    }
}
