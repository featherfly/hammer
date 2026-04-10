
package cn.featherfly.hammer.sqldb.dsl.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.common.function.SiConsumer;
import cn.featherfly.common.function.SiFunction;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.data.query.LimitAwareQuery6;
import cn.featherfly.data.query.QueryMapperSetter6;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQuery6;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup6FFFFFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic6FFFFFF;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression6FFFFFF;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression6;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortExpression;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortedExpression;
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
        RepositoryQuerySortExpression6<RepositoryQuerySortedExpression6FFFFFF,
            LimitAwareQuery6<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression6FFFFFF, LimitAwareQuery6<Map<String, Serializable>>>
    implements
    RepositoryQuery6<RepositoryQueryConditionsGroup6FFFFFF, RepositoryQueryConditionsGroupLogic6FFFFFF,
        RepositoryQuerySortExpression6<RepositoryQuerySortedExpression6FFFFFF,
            LimitAwareQuery6<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression6FFFFFF, LimitAwareQuery6<Map<String, Serializable>>>,
    QueryMapperSetter6 {

    /**
     * Instantiates a new abstract repository sql query 6 FFFFFF.
     *
     * @param abstractRepositorySqlQuery the abstract repository sql query
     */
    public AbstractRepositorySqlQuery6FFFFFF(AbstractRepositorySqlQuery6<?, ?, ?, ?, ?, ?> abstractRepositorySqlQuery) {
        super(abstractRepositorySqlQuery);
    }

    /**
     * Instantiates a new abstract repository sql query 6 FFFFFF.
     *
     * @param queryRelation the query relation
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
        SiFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            LogicExpression<?, ?>> repositoriesCondtionFuntion) {
        return where(new RepositorySqlQueryExpression6FFFFFF(queryRelation, sqlPageFactory),
            repositoriesCondtionFuntion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortExpression6<RepositoryQuerySortedExpression6FFFFFF,
        LimitAwareQuery6<Map<String, Serializable>>> sort() {
        return new RepositorySqlQueryExpression6FFFFFF(queryRelation, sqlPageFactory).sort();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <S1 extends RepositorySortedExpression<S1>, S2 extends RepositorySortedExpression<S2>,
        S3 extends RepositorySortedExpression<S3>, S4 extends RepositorySortedExpression<S4>,
        S5 extends RepositorySortedExpression<S5>,
        S6 extends RepositorySortedExpression<S6>> RepositoryQuerySortedExpression6FFFFFF sort(
            SiConsumer<RepositorySortExpression<S1>, RepositorySortExpression<S2>, RepositorySortExpression<S3>,
                RepositorySortExpression<S4>, RepositorySortExpression<S5>,
                RepositorySortExpression<S6>> repositorySortExpresions) {
        return new RepositorySqlQueryExpression6FFFFFF(queryRelation, sqlPageFactory).sort(repositorySortExpresions);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LimitAwareQuery6<Map<String, Serializable>> limit(Limit limit) {
        return new RepositorySqlQueryExpression6FFFFFF(queryRelation, sqlPageFactory).limit(limit);
    }
}
