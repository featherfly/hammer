
/*
 * All rights Reserved, Designed By zhongj
 * @Title: RepositorySqlOn2.java
 * @Package cn.featherfly.hammer.sqldb.jdbc.dsl.repository
 * @author: zhongj
 * @date: 2024-04-29 19:19:29
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.repository;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.function.ThreeArgusFunction;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.config.dsl.ConditionConfig;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression2;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.sqldb.dsl.repository.condition.field.RepositoryFieldOnlyExpressionImpl;

/**
 * repository join twice on.
 *
 * @author zhongj
 * @param <O>  on result type
 * @param <C2> condition config
 * @param <R>  repository sql relation
 * @param <B>  sql builder
 */
public class RepositorySqlOn2<O, C2 extends ConditionConfig<C2>, R extends RepositorySqlRelation<R, B>,
    B extends SqlBuilder> extends AbstractRepositorySqlOn<O, R, B> implements RepositoryOnExpression2<O> {

    /**
     * Instantiates a new repository sql on 2.
     *
     * @param joinTable   the join table
     * @param onResult    the on result
     * @param sqlRelation the sql relation
     */
    public RepositorySqlOn2(String joinTable, O onResult, R sqlRelation) {
        super(joinTable, onResult, sqlRelation);
    }

    /**
     * Instantiates a new repository sql on 2.
     *
     * @param repository  the repository
     * @param onResult    the on result
     * @param sqlRelation the sql relation
     */
    public RepositorySqlOn2(Repository repository, O onResult, R sqlRelation) {
        super(repository, onResult, sqlRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public O on(ThreeArgusFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
        RepositoryFieldOnlyExpression, LogicExpression<?, ?>> onExpression) {
        sqlRelation.join(joinTable, () -> onExpression.apply( //
            new RepositoryFieldOnlyExpressionImpl<>(0, sqlRelation)//
            , new RepositoryFieldOnlyExpressionImpl<>(1, sqlRelation)//
            , new RepositoryFieldOnlyExpressionImpl<>(2, sqlRelation) //
        ));
        return onResult;
    }
}
