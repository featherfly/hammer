
package cn.featherfly.hammer.sqldb.dsl.repository.query;

import java.util.List;

import cn.featherfly.common.tuple.Tuple6;

import cn.featherfly.common.function.SixArgusFunction;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQuery6;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup6FFFFFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic6FFFFFF;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor6;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression6;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * AbstractRepositorySqlQuery6FFFFFF.
 *
 * @author zhongj
 * @param <R> the element type
 */
public abstract class AbstractRepositorySqlQuery6FFFFFF<R extends RepositoryQueryRelateExpression<R>> extends
    AbstractRepositorySqlQuery6<R, RepositoryQueryConditionsGroup6FFFFFF, RepositoryQueryConditionsGroupLogic6FFFFFF,
        RepositoryQuerySortExpression6<QueryLimitExecutor6>, QueryLimitExecutor6>
    implements RepositoryQuery6<RepositoryQueryConditionsGroup6FFFFFF, RepositoryQueryConditionsGroupLogic6FFFFFF,
        RepositoryQuerySortExpression6<QueryLimitExecutor6>, QueryLimitExecutor6>,
    QueryLimitExecutor6 {

    /**
     * Instantiates a new abstract repository sql query 6 FFFFFF.
     *
     * @param abstractRepositorySqlQuery the abstract repository sql query
     */
    public AbstractRepositorySqlQuery6FFFFFF(AbstractRepositorySqlQuery6<?, ?, ?, ?, ?> abstractRepositorySqlQuery) {
        super(abstractRepositorySqlQuery);
    }

    /**
     * Instantiates a new abstract repository sql query 6 FFFFFF.
     *
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    protected AbstractRepositorySqlQuery6FFFFFF(RepositorySqlQueryRelation queryRelation,
        SqlPageFactory sqlPageFactory) {
        super(queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionsGroup6FFFFFF where() {
        return new RepositorySqlQueryExpression6FFFFFF(queryRelation, sqlPageFactory);
        //        // YUFEI_TEST 测试代码，后续删除, RepositorySqlQueryExpression6FFFFFF实例化太慢
        //        Timer timer = Timer.start();
        //        if (Constants.DEBUG) {
        //            Console.log("create RepositorySqlQueryExpression6FFFFFF start {}", System.currentTimeMillis());
        //        }
        //        RepositoryQueryConditionsGroup6FFFFFF where = new RepositorySqlQueryExpression6FFFFFF(queryRelation,
        //            sqlPageFactory);
        //        if (Constants.DEBUG) {
        //            Console.log("where use time {}", timer.stop());
        //            Console.log("create RepositorySqlQueryExpression6FFFFFF end {}", System.currentTimeMillis());
        //
        //            Console.log("{} end at time {}", this.getClass().getName(), System.currentTimeMillis());
        //        }
        //        return where;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionsGroupLogic6FFFFFF where(
        SixArgusFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            LogicExpression<?, ?>> repositoriesCondtionFuntion) {
        return where(new RepositorySqlQueryExpression6FFFFFF(queryRelation, sqlPageFactory),
            repositoriesCondtionFuntion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortExpression6<QueryLimitExecutor6> sort() {
        return new RepositorySqlQueryExpression6FFFFFF(queryRelation, sqlPageFactory).sort();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2, E3, E4, E5, E6> List<Tuple6<E1, E2, E3, E4, E5, E6>> list(
        Tuple6<String, String, String, String, String, String> prefixes, Class<E1> type1, Class<E2> type2,
        Class<E3> type3, Class<E4> type4, Class<E5> type5, Class<E6> type6) {
        return new RepositorySqlQueryExpression6FFFFFF(queryRelation, sqlPageFactory).list(prefixes, type1, type2,
            type3, type4, type5, type6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2, E3, E4, E5, E6> Tuple6<E1, E2, E3, E4, E5, E6> single(
        Tuple6<String, String, String, String, String, String> prefixes, Class<E1> type1, Class<E2> type2,
        Class<E3> type3, Class<E4> type4, Class<E5> type5, Class<E6> type6) {
        return new RepositorySqlQueryExpression6FFFFFF(queryRelation, sqlPageFactory).single(prefixes, type1, type2,
            type3, type4, type5, type6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2, E3, E4, E5, E6> Tuple6<E1, E2, E3, E4, E5, E6> unique(
        Tuple6<String, String, String, String, String, String> prefixes, Class<E1> type1, Class<E2> type2,
        Class<E3> type3, Class<E4> type4, Class<E5> type5, Class<E6> type6) {
        return new RepositorySqlQueryExpression6FFFFFF(queryRelation, sqlPageFactory).unique(prefixes, type1, type2,
            type3, type4, type5, type6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2, E3, E4, E5, E6> PaginationResults<Tuple6<E1, E2, E3, E4, E5, E6>> pagination(
        Tuple6<String, String, String, String, String, String> prefixes, Class<E1> type1, Class<E2> type2,
        Class<E3> type3, Class<E4> type4, Class<E5> type5, Class<E6> type6) {
        return new RepositorySqlQueryExpression6FFFFFF(queryRelation, sqlPageFactory).pagination(prefixes, type1, type2,
            type3, type4, type5, type6);
    }
}
