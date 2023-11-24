
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor2;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.AbstractMulitiRepositorySqlQueryConditionsGroupExpression2;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlQueryRelation;

/**
 * repository sql query expression .
 *
 * @author zhongj
 */
public class RepositorySqlQueryExpression2
        extends AbstractMulitiRepositorySqlQueryConditionsGroupExpression2<RepositorySqlQueryExpression2,
                RepositorySqlQueryExpression2, RepositorySqlQueryExpression2, QueryLimitExecutor2> {

    /**
     * Instantiates a new sql query expression.
     *
     * @param repositoryRelation the repository relation
     * @param sqlPageFactory     the sql page factory
     * @param conditionConfig    the condition config
     * @param selectBuilder      the select builder
     */
    public RepositorySqlQueryExpression2(RepositorySqlQueryRelation repositoryRelation, SqlPageFactory sqlPageFactory,
            QueryConditionConfig conditionConfig) {
        this(null, repositoryRelation, sqlPageFactory, conditionConfig);
    }

    /**
     * Instantiates a new repository sql query expression.
     *
     * @param parent             the parent
     * @param repositoryRelation the repository relation
     * @param sqlPageFactory     the sql page factory
     * @param conditionConfig    the condition config
     */
    RepositorySqlQueryExpression2(RepositorySqlQueryExpression2 parent, RepositorySqlQueryRelation repositoryRelation,
            SqlPageFactory sqlPageFactory, QueryConditionConfig conditionConfig) {
        // first level
        super(parent, 0, repositoryRelation, sqlPageFactory, conditionConfig);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositorySqlQueryExpression2 createGroup(RepositorySqlQueryExpression2 parent) {
        return new RepositorySqlQueryExpression2(parent, repositoryRelation, sqlPageFactory, conditionConfig);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {
        String condition = super.expression();
        if (parent == null) {
            String result = repositoryRelation.buildSelectSql();
            String sort = getRootSortBuilder().build();
            if (Lang.isEmpty(condition)) {
                return result + Chars.SPACE + sort;
            } else {
                return result + Chars.SPACE + dialect.getKeywords().where() + Chars.SPACE + condition + Chars.SPACE
                        + sort;
            }
        } else {
            return condition;
        }

        //        String result = "";
        //        if (repositoryRelation.getBuilder() != null) {
        //            result = repositoryRelation.getBuilder().build((tableName, tableAlias) -> repositoryRelation.getBuilder()
        //                    .getDefaultTableAlias().equals(tableAlias));
        //        }
        //        String condition = super.expression();
        //        if (Lang.isNotEmpty(condition)) {
        //            // result = result + Chars.SPACE +
        //            // jdbc.getDialect().getKeywords().where() + Chars.SPACE +
        //            // condition;
        //            result = result + Chars.SPACE + condition;
        //        }
        //        return result;
    }
}
