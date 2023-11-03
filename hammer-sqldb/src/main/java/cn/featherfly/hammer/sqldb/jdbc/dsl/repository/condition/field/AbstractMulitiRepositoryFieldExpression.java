
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.field;

import java.util.concurrent.atomic.AtomicInteger;

import cn.featherfly.common.repository.AliasRepository;
import cn.featherfly.common.repository.FieldAware;
import cn.featherfly.common.repository.RepositoryAwareField;
import cn.featherfly.common.repository.RepositoryAwareFieldImpl;
import cn.featherfly.common.repository.SimpleAliasRepository;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.condition.InternalMulitiCondition;

/**
 * The Class AbstractMulitiRepositoryFieldExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractMulitiRepositoryFieldExpression<C extends ConditionExpression,
        L extends LogicExpression<C, L>> implements FieldAware<RepositoryAwareField<AliasRepository>> {

    /** The index. */
    protected AtomicInteger index;

    /** The name. */
    protected String name;

    /** The expression. */
    protected InternalMulitiCondition<L> expression;

    protected final RepositoryAwareField<AliasRepository> field;

    //    /** The repository relation. */
    //    protected RepositorySqlRelation<?, ?> repositoryRelation;

    /**
     * Instantiates a new abstract muliti repository field expression.
     *
     * @param index      the index
     * @param name       the name
     * @param expression the expression
     */
    protected AbstractMulitiRepositoryFieldExpression(int index, String name, InternalMulitiCondition<L> expression) {
        this(new AtomicInteger(index), name, expression);
    }

    /**
     * Instantiates a new abstract muliti repository field expression.
     *
     * @param index      the index
     * @param name       the name
     * @param expression the expression
     */
    protected AbstractMulitiRepositoryFieldExpression(AtomicInteger index, String name,
            InternalMulitiCondition<L> expression) {
        this.index = index;
        this.name = name;
        this.expression = expression;
        field = new RepositoryAwareFieldImpl<>(name,
                new SimpleAliasRepository(null, expression.getAlias(index.intValue())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryAwareField<AliasRepository> field() {
        return field;
    }
}
