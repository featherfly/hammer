
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query;

import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryValueConditionsGroup;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryValueConditionsGroupLogic;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlQueryRelation;

/**
 * repository sql query expression .
 *
 * @author zhongj
 */
public class RepositorySqlQueryValueExpression extends AbstractMulitiRepositorySqlQueryValueConditionsGroupExpression {

    /**
     * Instantiates a new repository sql query value expression.
     *
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    public RepositorySqlQueryValueExpression(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        this(null, queryRelation, sqlPageFactory);
    }

    /**
     * Instantiates a new repository sql query value expression.
     *
     * @param parent         the parent
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    public RepositorySqlQueryValueExpression(RepositoryQueryValueConditionsGroupLogic parent,
            RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        super(parent, 0, queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryValueConditionsGroup createGroup(RepositoryQueryValueConditionsGroupLogic parent) {
        return new RepositorySqlQueryValueExpression(parent, repositoryRelation, sqlPageFactory);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public long count() {
    //        selectBuilder.clearColumns().addColumn(AggregateFunction.COUNT, Chars.STAR);
    //        return longValue();
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public String expression() {
    //        String result = "";
    //        if (selectBuilder != null) {
    //            result = selectBuilder
    //                    .build((tableName, tableAlias) -> selectBuilder.getDefaultTableAlias().equals(tableAlias));
    //        }
    //        String condition = super.expression();
    //        if (Lang.isNotEmpty(condition)) {
    //            // result = result + Chars.SPACE +
    //            // jdbc.getDialect().getKeywords().where() + Chars.SPACE +
    //            // condition;
    //            result = result + Chars.SPACE + condition;
    //        }
    //        return result;
    //    }
}
