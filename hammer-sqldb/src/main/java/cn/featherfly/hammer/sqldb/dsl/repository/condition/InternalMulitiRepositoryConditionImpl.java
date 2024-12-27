
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-04-02 16:23:02
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.repository.condition;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.tuple.Tuple1;
import cn.featherfly.common.tuple.Tuples;
import cn.featherfly.hammer.config.dsl.ConditionConfig;
import cn.featherfly.hammer.sqldb.dsl.repository.AbstractMulitiRepositorySqlConditionsGroupExpressionBase;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlRelation;

/**
 * RepositoryInternalMulitiConditionImpl.
 *
 * @author zhongj
 * @param <C2> the generic type
 * @param <S> the generic type
 * @param <B> the generic type
 */
public class InternalMulitiRepositoryConditionImpl<C2 extends ConditionConfig<C2>,
    S extends RepositorySqlRelation<S, B>, B extends SqlBuilder> extends
    AbstractMulitiRepositorySqlConditionsGroupExpressionBase<InternalMulitiRepositoryConditionImpl<C2, S, B>,
        InternalMulitiRepositoryConditionImpl<C2, S, B>, Tuple1<Integer>, C2, S, B> {

    /**
     * Instantiates a new internal muliti repository condition impl.
     *
     * @param index the index
     * @param repositoryRelation the repository relation
     */
    public InternalMulitiRepositoryConditionImpl(int index, S repositoryRelation) {
        super(null, index, repositoryRelation);
    }

    /**
     * Instantiates a new internal muliti repository condition impl.
     *
     * @param parent the parent
     * @param index the index
     * @param repositoryRelation the repository relation
     */
    InternalMulitiRepositoryConditionImpl(InternalMulitiRepositoryConditionImpl<C2, S, B> parent, int index,
        S repositoryRelation) {
        super(parent, index, repositoryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected InternalMulitiRepositoryConditionImpl<C2, S, B> createGroup(
        InternalMulitiRepositoryConditionImpl<C2, S, B> parent) {
        return new InternalMulitiRepositoryConditionImpl<>(this, index, repositoryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Tuple1<Integer> createTuple() {
        return Tuples.of(0);
    }
}
