
package cn.featherfly.hammer.sqldb.dsl.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.common.function.FoConsumer;
import cn.featherfly.common.function.FoFunction;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.data.query.LimitAwareQuery2;
import cn.featherfly.data.query.QueryMapperSetter2;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQuery4;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup4FF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic4FF;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression4FF;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression4;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortExpression;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortedExpression;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * AbstractRepositorySqlQuery4.
 *
 * @author zhongj
 * @param <R> the element type
 */
public abstract class AbstractRepositorySqlQuery4FF<R extends RepositoryQueryRelateExpression<R>> extends
    AbstractRepositorySqlQuery4<R, RepositoryQueryConditionsGroup4FF, RepositoryQueryConditionsGroupLogic4FF,
        RepositoryQuerySortExpression4<RepositoryQuerySortedExpression4FF, LimitAwareQuery2<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression4FF, LimitAwareQuery2<Map<String, Serializable>>>
    implements
    RepositoryQuery4<RepositoryQueryConditionsGroup4FF, RepositoryQueryConditionsGroupLogic4FF,
        RepositoryQuerySortExpression4<RepositoryQuerySortedExpression4FF, LimitAwareQuery2<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression4FF, LimitAwareQuery2<Map<String, Serializable>>>,
    QueryMapperSetter2 {

    /**
     * Instantiates a new abstract repository sql query 4 FF.
     *
     * @param abstractRepositorySqlQuery the abstract repository sql query
     */
    public AbstractRepositorySqlQuery4FF(AbstractRepositorySqlQuery4<?, ?, ?, ?, ?, ?> abstractRepositorySqlQuery) {
        super(abstractRepositorySqlQuery);
    }

    /**
     * Instantiates a new abstract repository sql query 4 FF.
     *
     * @param queryRelation the query relation
     * @param sqlPageFactory the sql page factory
     */
    protected AbstractRepositorySqlQuery4FF(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        super(queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionsGroup4FF where() {
        return new RepositorySqlQueryExpression4FF(queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionsGroupLogic4FF where(
        FoFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            RepositoryFieldOnlyExpression, LogicExpression<?, ?>> repositoriesCondtionFuntion) {
        return where(new RepositorySqlQueryExpression4FF(queryRelation, sqlPageFactory), repositoriesCondtionFuntion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortExpression4<RepositoryQuerySortedExpression4FF,
        LimitAwareQuery2<Map<String, Serializable>>> sort() {
        return new RepositorySqlQueryExpression4FF(queryRelation, sqlPageFactory).sort();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <S1 extends RepositorySortedExpression<S1>, S2 extends RepositorySortedExpression<S2>,
        S3 extends RepositorySortedExpression<S3>,
        S4 extends RepositorySortedExpression<S4>> RepositoryQuerySortedExpression4FF sort(
            FoConsumer<RepositorySortExpression<S1>, RepositorySortExpression<S2>, RepositorySortExpression<S3>,
                RepositorySortExpression<S4>> repositorySortExpresions) {
        return new RepositorySqlQueryExpression4FF(queryRelation, sqlPageFactory).sort(repositorySortExpresions);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LimitAwareQuery2<Map<String, Serializable>> limit(Limit limit) {
        return new RepositorySqlQueryExpression4FF(queryRelation, sqlPageFactory).limit(limit);
    }
}
