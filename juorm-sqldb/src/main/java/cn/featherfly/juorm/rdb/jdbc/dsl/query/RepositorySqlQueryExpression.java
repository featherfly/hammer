
package cn.featherfly.juorm.rdb.jdbc.dsl.query;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.juorm.dml.AliasManager;
import cn.featherfly.juorm.dsl.query.RepositoryQueryConditionGroupExpression;
import cn.featherfly.juorm.dsl.query.RepositoryQueryConditionGroupLogicExpression;
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
public class RepositorySqlQueryExpression extends RepositorySqlQueryConditionGroupExpression {

    private SqlSelectBasicBuilder selectBuilder;

    /**
     * Instantiates a new sql query expression.
     *
     * @param jdbc          the jdbc
     * @param aliasManager  aliasManager
     * @param selectBuilder the select builder
     */
    public RepositorySqlQueryExpression(Jdbc jdbc, AliasManager aliasManager, SqlSelectBasicBuilder selectBuilder) {
        super(jdbc, aliasManager, selectBuilder.getTableAlias());
        this.selectBuilder = selectBuilder;
    }

    /**
     * Instantiates a new sql query expression.
     *
     * @param jdbc          the jdbc
     * @param aliasManager  aliasManager
     * @param classMapping  the class mapping
     * @param selectBuilder the select builder
     */
    public RepositorySqlQueryExpression(Jdbc jdbc, AliasManager aliasManager, ClassMapping<?> classMapping,
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
    RepositorySqlQueryExpression(Jdbc jdbc, AliasManager aliasManager,
            RepositoryQueryConditionGroupLogicExpression parent, String queryAlias, ClassMapping<?> classMapping) {
        super(jdbc, aliasManager, parent, queryAlias, classMapping);
    }

    /**
     * Instantiates a new sql query expression.
     *
     * @param jdbc         the jdbc
     * @param aliasManager aliasManager
     * @param queryAlias   the query alias
     */
    public RepositorySqlQueryExpression(Jdbc jdbc, AliasManager aliasManager, String queryAlias) {
        super(jdbc, aliasManager, queryAlias);
    }

    /**
     * Instantiates a new sql query expression.
     *
     * @param jdbc         jdbc
     * @param aliasManager aliasManager
     */
    public RepositorySqlQueryExpression(Jdbc jdbc, AliasManager aliasManager) {
        super(jdbc, aliasManager);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryConditionGroupExpression createGroup(RepositoryQueryConditionGroupLogicExpression parent,
            String queryAlias) {
        selectBuilder.setTableAlias(queryAlias);
        return new RepositorySqlQueryExpression(jdbc, aliasManager, parent, queryAlias, classMapping);
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
            //            result = result + Chars.SPACE + jdbc.getDialect().getKeywords().where() + Chars.SPACE + condition;
            result = result + Chars.SPACE + condition;
        }
        return result;
    }
}
