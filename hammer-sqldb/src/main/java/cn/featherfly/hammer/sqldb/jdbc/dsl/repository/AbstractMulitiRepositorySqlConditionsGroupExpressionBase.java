
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository;

import java.util.function.Function;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.operator.LogicOperator;
import cn.featherfly.hammer.config.dsl.ConditionConfig;
import cn.featherfly.hammer.expression.condition.GroupEndExpression;
import cn.featherfly.hammer.expression.condition.GroupExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.sqldb.sql.dml.SqlLogicOperatorExpressionBuilder;

/**
 * sql condition group builder sql条件逻辑组构造器 .
 *
 * @author zhongj
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <C2> the generic type
 * @param <S>  the generic type
 * @param <B>  the generic type
 */
@SuppressWarnings("unchecked")
public abstract class AbstractMulitiRepositorySqlConditionsGroupExpressionBase<C extends GroupExpression<C, L>,
        L extends GroupEndExpression<C, L>, C2 extends ConditionConfig<C2>, S extends RepositorySqlRelation<S, B>,
        B extends SqlBuilder> extends AbstractMulitiRepositorySqlConditionsExpressionBase<C, L, C2, S, B>
        implements LogicExpression<C, L>, GroupExpression<C, L>, GroupEndExpression<C, L> {

    /**
     * Instantiates a new abstract sql condition group expression.
     *
     * @param parent             parent group
     * @param index              the index
     * @param repositoryRelation the repository relation
     * @param conditionConfig    the condition config
     */
    protected AbstractMulitiRepositorySqlConditionsGroupExpressionBase(L parent, int index, S repositoryRelation,
            C2 conditionConfig) {
        super(parent, index, repositoryRelation, conditionConfig);
    }

    /**
     * Gets the root.
     *
     * @return the root
     */
    protected AbstractMulitiRepositorySqlConditionsGroupExpressionBase<C, L, C2, S, B> getRoot() {
        L p = endGroup();
        while (p != p.endGroup()) {
            p = p.endGroup();
        }
        return (AbstractMulitiRepositorySqlConditionsGroupExpressionBase<C, L, C2, S, B>) p;
    }

    /**
     * Creates the group.
     *
     * @param parent the parent
     * @return the c
     */
    protected abstract C createGroup(L parent);

    /**
     * {@inheritDoc}
     */
    @Override
    public C group() {
        C group = createGroup((L) this);
        addCondition(group);
        return group;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L group(Function<C, L> group) {
        C g = group();
        return ((GroupEndExpression<C, L>) group.apply(g)).endGroup();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L endGroup() {
        if (parent != null) {
            return parent;
        } else {
            return (L) this;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public C logic(LogicOperator operator) {
        AssertIllegalArgument.isNotNull(operator, "operator");
        return (C) addCondition(new SqlLogicOperatorExpressionBuilder(operator));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public C and() {
        return (C) addCondition(new SqlLogicOperatorExpressionBuilder(LogicOperator.AND));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L and(Function<C, L> group) {
        return and().group(group);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public C or() {
        return (C) addCondition(new SqlLogicOperatorExpressionBuilder(LogicOperator.OR));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L or(Function<C, L> group) {
        return or().group(group);
    }

    // ********************************************************************
    // private method
    // ********************************************************************

    // ********************************************************************
    // protected method
    // ********************************************************************
}
