
package cn.featherfly.hammer.sqldb.dsl.repository.query;

import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup2F;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic2F;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression2;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * repository sql query expression 2F.
 *
 * @author zhongj
 */
public class RepositorySqlQueryExpression2 extends
    AbstractMulitiRepositorySqlQueryConditionsGroupExpression2<RepositoryQueryConditionsGroup2F,
        RepositoryQueryConditionsGroupLogic2F, RepositoryQuerySortExpression2<QueryLimitExecutor>, QueryLimitExecutor>
    implements RepositoryQueryConditionsGroup2F, RepositoryQueryConditionsGroupLogic2F {

    /**
     * Instantiates a new sql query expression.
     *
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    public RepositorySqlQueryExpression2(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        this(null, queryRelation, sqlPageFactory);
    }

    /**
     * Instantiates a new repository sql query expression.
     *
     * @param parent         the parent
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    RepositorySqlQueryExpression2(RepositoryQueryConditionsGroupLogic2F parent,
        RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        // first level
        super(parent, 0, queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryConditionsGroup2F createGroup(RepositoryQueryConditionsGroupLogic2F parent) {
        return new RepositorySqlQueryExpression2(parent, repositoryRelation, sqlPageFactory);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public String expression() {
    //        String condition = super.expression();
    //        if (parent == null) {
    //            String result = repositoryRelation.buildSelectSql();
    //            String sort = getRootSortBuilder().build();
    //            if (Lang.isEmpty(condition)) {
    //                return result + Chars.SPACE + sort;
    //            } else {
    //                return result + Chars.SPACE + dialect.getKeywords().where() + Chars.SPACE + condition + Chars.SPACE
    //                        + sort;
    //            }
    //        } else {
    //            return condition;
    //        }
    //
    //        //        String result = "";
    //        //        if (repositoryRelation.getBuilder() != null) {
    //        //            result = repositoryRelation.getBuilder().build((tableName, tableAlias) -> repositoryRelation.getBuilder()
    //        //                    .getDefaultTableAlias().equals(tableAlias));
    //        //        }
    //        //        String condition = super.expression();
    //        //        if (Lang.isNotEmpty(condition)) {
    //        //            // result = result + Chars.SPACE +
    //        //            // jdbc.getDialect().getKeywords().where() + Chars.SPACE +
    //        //            // condition;
    //        //            result = result + Chars.SPACE + condition;
    //        //        }
    //        //        return result;
    //    }

}
