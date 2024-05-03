
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityPropertyFunctionImpl.java
 * @Description: EntityPropertyFunctionImpl
 * @author: zhongj
 * @date: 2023-08-21 18:00:21
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.repository.condition.field;

import java.util.function.Function;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.hammer.config.dsl.ConditionConfig;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyLogicExpression;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlRelation;

/**
 * repository field only impl.
 *
 * @author zhongj
 * @param <C2> the generic type
 * @param <S>  the generic type
 * @param <B>  the generic type
 */
public class RepositoryFieldOnlyExpressionImpl<C2 extends ConditionConfig<C2>, S extends RepositorySqlRelation<S, B>,
        B extends SqlBuilder> extends
        RepositoryFieldExpressionImpl<RepositoryFieldOnlyExpression, RepositoryFieldOnlyLogicExpression, C2, S, B>
        implements RepositoryFieldOnlyExpression {

    /**
     * Instantiates a new repository field only expression impl.
     *
     * @param index              the index
     * @param repositoryRelation the repository relation
     */
    public RepositoryFieldOnlyExpressionImpl(int index, S repositoryRelation) {
        super(index, repositoryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryFieldOnlyExpression group() {
        return expression.group();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryFieldOnlyLogicExpression group(
            Function<RepositoryFieldOnlyExpression, RepositoryFieldOnlyLogicExpression> group) {
        return expression.group(group);
    }
}
