/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-27 19:17:27
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.repository.query.relation;

import java.util.function.BiFunction;
import java.util.function.Consumer;

import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression1;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.dsl.repository.condition.field.RepositoryFieldOnlyExpressionImpl;

/**
 * repository sql query join on 1.
 *
 * @author zhongj
 * @param <Q> the generic type
 * @param <F> the generic type
 */
public class RepositorySqlQueryOn1<Q extends RepositoryQueryRelateExpression<F>, F>
    extends AbstractRepositorySqlQueryOn<Q, F> implements RepositoryOnExpression1<Q> {

    /**
     * Instantiates a new repository sql query on 1.
     *
     * @param queryRelate   the query relate
     * @param queryRelation the query relation
     * @param repository    the repository
     * @param onConsumer    the on consumer
     */
    public RepositorySqlQueryOn1(Q queryRelate, RepositorySqlQueryRelation queryRelation, Repository repository,
        Consumer<Q> onConsumer) {
        super(queryRelate, queryRelation, repository, onConsumer);
    }

    /**
     * Instantiates a new repository sql query on 1.
     *
     * @param queryRelate         the query relate
     * @param queryRelation       the query relation
     * @param joinRepository      the join repository
     * @param joinRepositoryAlias the join repository alias
     * @param onConsumer          the on consumer
     */
    public RepositorySqlQueryOn1(Q queryRelate, RepositorySqlQueryRelation queryRelation, String joinRepository,
        String joinRepositoryAlias, Consumer<Q> onConsumer) {
        super(queryRelate, queryRelation, joinRepository, joinRepositoryAlias, onConsumer);
    }

    /**
     * Instantiates a new entity sql query related.
     *
     * @param queryRelate    the query relate
     * @param queryRelation  the query relation
     * @param joinRepository the repository
     */
    public RepositorySqlQueryOn1(Q queryRelate, RepositorySqlQueryRelation queryRelation, String joinRepository) {
        super(queryRelate, queryRelation, joinRepository);
    }

    /**
     * Instantiates a new entity sql query related.
     *
     * @param queryRelate    the query relate
     * @param queryRelation  the query relation
     * @param joinRepository the repository
     * @param onConsumer     the on consumer
     */
    public RepositorySqlQueryOn1(Q queryRelate, RepositorySqlQueryRelation queryRelation, String joinRepository,
        Consumer<Q> onConsumer) {
        super(queryRelate, queryRelation, joinRepository, onConsumer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Q on(
        BiFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, LogicExpression<?, ?>> onExpression) {
        queryRelation.join(joinRepository, () -> onExpression.apply( //
            new RepositoryFieldOnlyExpressionImpl<>(0, queryRelation) //
            , new RepositoryFieldOnlyExpressionImpl<>(1, queryRelation) //
        ));
        return queryRelate;
    }
}
