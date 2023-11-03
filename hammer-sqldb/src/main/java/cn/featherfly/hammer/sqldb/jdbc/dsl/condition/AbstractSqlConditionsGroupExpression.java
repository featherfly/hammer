/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-15 15:20:15
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.condition;

import java.util.function.Function;

import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.operator.LogicOperator;
import cn.featherfly.hammer.config.dsl.ConditionConfig;
import cn.featherfly.hammer.expression.condition.GroupEndExpression;
import cn.featherfly.hammer.expression.condition.GroupExpression;

/**
 * abstract sqldb condition expression.
 *
 * @author zhongj
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <C2> the generic type
 */
@SuppressWarnings("unchecked")
public abstract class AbstractSqlConditionsGroupExpression<C extends GroupExpression<C, L>,
        L extends GroupEndExpression<C, L>, C2 extends ConditionConfig<C2>>
        extends AbstractSqlConditionsExpression<C, L, C2> implements GroupExpression<C, L>, GroupEndExpression<C, L> {

    /**
     * Instantiates a new abstract sqldb muliti condition expression.
     *
     * @param parent          the parent
     * @param dialect         the dialect
     * @param repositoryAlias the repository alias
     * @param conditionConfig the condition config
     */
    protected AbstractSqlConditionsGroupExpression(L parent, Dialect dialect, String repositoryAlias,
            C2 conditionConfig) {
        super(parent, dialect, repositoryAlias, conditionConfig);
    }

    // ********************************************************************
    //
    // ********************************************************************

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
     * Creates the group.
     *
     * @param parent the parent
     * @return the c
     */
    protected abstract C createGroup(L parent);

    /**
     * Gets the root.
     *
     * @return the root
     */
    protected AbstractSqlConditionsGroupExpression<C, L, C2> getRoot() {
        L p = endGroup();
        //        L p2 = p.endGroup();
        //        while (p != p2) {
        while (p != p.endGroup()) {
            p = p.endGroup();
        }
        return (AbstractSqlConditionsGroupExpression<C, L, C2>) p;
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
    public L logic(LogicOperator logicOperator, Function<C, L> group) {
        return logic(logicOperator).group(group);
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
    public L or(Function<C, L> group) {
        return or().group(group);
    }
}
