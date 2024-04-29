
/*
 * All rights Reserved, Designed By zhongj
 * @Title: RepositorySqlOn5.java
 * @Package cn.featherfly.hammer.sqldb.jdbc.dsl.repository
 * @author: zhongj
 * @date: 2024-04-29 19:19:29
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.function.FiveArgusFunction;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.config.dsl.ConditionConfig;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression4;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.field.RepositoryFieldOnlyExpressionImpl;

/**
 * repository join four times on.
 *
 * @author zhongj
 * @param <O>  on result type
 * @param <C5> condition config
 * @param <R>  repository sql relation
 * @param <B>  sql builder
 */
public class RepositorySqlOn4<O, C5 extends ConditionConfig<C5>, R extends RepositorySqlRelation<R, B>,
    B extends SqlBuilder> extends AbstractRepositorySqlOn<O, R, B> implements RepositoryOnExpression4<O> {

    /**
     * Instantiates a new repository sql on 4.
     *
     * @param joinTable   the join table
     * @param onResult    the on result
     * @param sqlRelation the sql relation
     */
    public RepositorySqlOn4(String joinTable, O onResult, R sqlRelation) {
        super(joinTable, onResult, sqlRelation);
    }

    /**
     * Instantiates a new repository sql on 4.
     *
     * @param repository  the repository
     * @param onResult    the on result
     * @param sqlRelation the sql relation
     */
    public RepositorySqlOn4(Repository repository, O onResult, R sqlRelation) {
        super(repository, onResult, sqlRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public O on(
        FiveArgusFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, LogicExpression<?, ?>> onExpression) {
        sqlRelation.join(joinTable, () -> onExpression.apply( //
            new RepositoryFieldOnlyExpressionImpl<>(0, sqlRelation)//
            , new RepositoryFieldOnlyExpressionImpl<>(1, sqlRelation)//
            , new RepositoryFieldOnlyExpressionImpl<>(2, sqlRelation) //
            , new RepositoryFieldOnlyExpressionImpl<>(3, sqlRelation) //
            , new RepositoryFieldOnlyExpressionImpl<>(4, sqlRelation) //
        ));
        return onResult;
    }
}
