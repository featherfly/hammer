
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-04-02 16:23:02
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition;

import com.speedment.common.tuple.Tuple1;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.hammer.config.dsl.ConditionConfig;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyLogicExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.AbstractMulitiRepositorySqlConditionsGroupExpressionBase;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlRelation;

/**
 * RepositoryInternalMulitiConditionImpl.
 *
 * @author zhongj
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <C2> the generic type
 * @param <S>  the generic type
 * @param <B>  the generic type
 */
public class InternalMulitiRepositoryFieldOnlyConditionImpl<C2 extends ConditionConfig<C2>,
    S extends RepositorySqlRelation<S, B>, B extends SqlBuilder> extends
    AbstractMulitiRepositorySqlConditionsGroupExpressionBase<RepositoryFieldOnlyExpression,
        RepositoryFieldOnlyLogicExpression, Tuple1<Integer>, C2, S, B>
    implements RepositoryFieldOnlyExpression, RepositoryFieldOnlyLogicExpression {

    /**
     * Instantiates a new internal muliti repository condition impl.
     *
     * @param index              the index
     * @param repositoryRelation the repository relation
     */
    public InternalMulitiRepositoryFieldOnlyConditionImpl(int index, S repositoryRelation) {
        super(null, index, repositoryRelation);
    }

    /**
     * Instantiates a new internal muliti repository condition impl.
     *
     * @param parent             the parent
     * @param index              the index
     * @param repositoryRelation the repository relation
     */
    InternalMulitiRepositoryFieldOnlyConditionImpl(RepositoryFieldOnlyLogicExpression parent, int index,
        S repositoryRelation) {
        super(parent, index, repositoryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryFieldOnlyExpression createGroup(RepositoryFieldOnlyLogicExpression parent) {
        return new InternalMulitiRepositoryFieldOnlyConditionImpl<C2, S, B>(this, index, repositoryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Tuple1<Integer> createTuple() {
        return Tuples.of(0);
    }
}
