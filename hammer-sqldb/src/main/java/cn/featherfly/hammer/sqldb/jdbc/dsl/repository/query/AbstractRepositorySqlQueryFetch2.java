
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query;

import java.util.List;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor2;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.AbstractMulitiRepositorySqlQueryConditionsGroupExpression2;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlQueryRelation;

/**
 * AbstractRepositorySqlQueryFetch2.
 *
 * @author zhongj
 */
public abstract class AbstractRepositorySqlQueryFetch2 extends
        AbstractMulitiRepositorySqlQueryConditionsGroupExpression2<AbstractRepositorySqlQueryFetch2,
                AbstractRepositorySqlQueryFetch2, AbstractRepositorySqlQueryFetch2, QueryLimitExecutor2>
        implements QueryLimitExecutor2 {

    /**
     * Instantiates a new sql query expression.
     *
     * @param repositoryRelation the repository relation
     * @param index              the index
     * @param sqlPageFactory     the sql page factory
     * @param conditionConfig    the condition config
     * @param selectBuilder      the select builder
     */
    protected AbstractRepositorySqlQueryFetch2(RepositorySqlQueryRelation repositoryRelation, int index,
            SqlPageFactory sqlPageFactory, QueryConditionConfig conditionConfig, SqlSelectBasicBuilder selectBuilder) {
        this(null, index, repositoryRelation, sqlPageFactory, conditionConfig);
    }

    /**
     * Instantiates a new repository sql query expression.
     *
     * @param parent             the parent
     * @param index              the index
     * @param repositoryRelation the repository relation
     * @param sqlPageFactory     the sql page factory
     * @param conditionConfig    the condition config
     */
    protected AbstractRepositorySqlQueryFetch2(AbstractRepositorySqlQueryFetch2 parent, int index,
            RepositorySqlQueryRelation repositoryRelation, SqlPageFactory sqlPageFactory,
            QueryConditionConfig conditionConfig) {
        super(parent, index, repositoryRelation, sqlPageFactory, conditionConfig);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2> List<Tuple2<E1, E2>> list(Tuple2<String, String> prefixes, Class<E1> type1, Class<E2> type2) {
        return repositorySqlQueryConditionGroupQuery.list(prefixes, type1, type2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2> Tuple2<E1, E2> single(Tuple2<String, String> prefixes, Class<E1> type1, Class<E2> type2) {
        return repositorySqlQueryConditionGroupQuery.single(prefixes, type1, type2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2> Tuple2<E1, E2> unique(Tuple2<String, String> prefixes, Class<E1> type1, Class<E2> type2) {
        return repositorySqlQueryConditionGroupQuery.unique(prefixes, type1, type2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2> PaginationResults<Tuple2<E1, E2>> pagination(Tuple2<String, String> prefixes, Class<E1> type1,
            Class<E2> type2) {
        return repositorySqlQueryConditionGroupQuery.pagination(prefixes, type1, type2);
    }
}
