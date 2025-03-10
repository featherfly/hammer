
package cn.featherfly.hammer.sqldb.dsl.repository;

import java.util.function.Function;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.lang.Console;
import cn.featherfly.common.operator.LogicOperator;
import cn.featherfly.common.tuple.Tuple;
import cn.featherfly.hammer.config.dsl.ConditionConfig;
import cn.featherfly.hammer.expression.condition.GroupEndExpression;
import cn.featherfly.hammer.expression.condition.GroupExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.sqldb.Constants;
import cn.featherfly.hammer.sqldb.sql.dml.SqlLogicOperatorExpressionBuilder;

/**
 * sql condition group builder sql条件逻辑组构造器 .
 *
 * @author zhongj
 * @param <C> condition expression
 * @param <L> logic expression
 * @param <T> filterable repository index tuple type
 * @param <C2> condition config
 * @param <S> repository sql relation
 * @param <B> sql builder
 */
@SuppressWarnings("unchecked")
public abstract class AbstractMulitiRepositorySqlConditionsGroupExpressionBase<C extends GroupExpression<C, L>,
    L extends GroupEndExpression<C, L>, T extends Tuple, C2 extends ConditionConfig<C2>,
    S extends RepositorySqlRelation<S, B>, B extends SqlBuilder>
    extends AbstractMulitiRepositorySqlConditionsExpressionBase<C, L, T, C2, S, B>
    implements GroupExpression<C, L>, GroupEndExpression<C, L> {

    /**
     * Instantiates a new abstract sql condition group expression.
     *
     * @param parent parent group
     * @param index the index
     * @param repositoryRelation the repository relation
     */
    protected AbstractMulitiRepositorySqlConditionsGroupExpressionBase(L parent, int index, S repositoryRelation) {
        super(parent, index, repositoryRelation);
        if (Constants.DEBUG) {
            Console.log("{} end at time {}", this.getClass().getName(), System.currentTimeMillis());
        }
    }

    /**
     * Gets the root.
     *
     * @return the root
     */
    protected AbstractMulitiRepositorySqlConditionsGroupExpressionBase<C, L, T, C2, S, B> getRoot() {
        L p = endGroup();
        while (p != p.endGroup()) {
            p = p.endGroup();
        }
        return (AbstractMulitiRepositorySqlConditionsGroupExpressionBase<C, L, T, C2, S, B>) p;
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
        return group.apply(g).endGroup();
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
    public L ignore(boolean ignorable, Function<C, L> conditionExpressions) {
        if (!ignorable && conditionExpressions != null) {
            return conditionExpressions.apply((C) this);
        }
        return (L) this;
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public C logic(LogicOperator operator) {
    //        AssertIllegalArgument.isNotNull(operator, "operator");
    //        return (C) addCondition(new SqlLogicOperatorExpressionBuilder(operator));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L logic(LogicOperator operator, LogicExpression<?, ?> logicExpression) {
    //        logic(operator);
    //        return (L) addCondition(logicExpression);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L logic(LogicOperator operator, Function<C, L> group) {
    //        return logic(operator).group(group);
    //    }

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
    public L and(LogicExpression<?, ?> logicExpression) {
        and();
        return (L) addCondition(logicExpression);
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
    public L or(LogicExpression<?, ?> logicExpression) {
        or();
        return (L) addCondition(logicExpression);
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
