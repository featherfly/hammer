
package cn.featherfly.hammer.sqldb.dsl.type;

import java.util.List;

import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractMulitiRepositorySqlQueryConditionsGroupExpression;

/**
 * StaticTypeQueryConditionGroupExpression.
 *
 * @author zhongj
 */
public abstract class StaticTypeQueryConditionGroupExpression<E,
    Q extends StaticTypeQueryConditionGroupExpression<E, Q>> {

    private Q parent;

    protected Class<E> type;

    protected AbstractMulitiRepositorySqlQueryConditionsGroupExpression queryConditionGroupExpression;

    /**
     * @param queryConditionGroupExpression queryConditionGroupExpression
     * @param parent                        parent
     */
    public StaticTypeQueryConditionGroupExpression(
        AbstractMulitiRepositorySqlQueryConditionsGroupExpression queryConditionGroupExpression, Q parent) {
        super();
        type = ClassUtils.getSuperClassGenericType(this.getClass());
        this.queryConditionGroupExpression = queryConditionGroupExpression;
        this.parent = parent;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public Q group() {
        return createChild(queryConditionGroupExpression, (Q) this);
    }

    /**
     * {@inheritDoc}
     */
    public Q endGroup() {
        return parent;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public Q and() {
        queryConditionGroupExpression.and();
        return (Q) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public Q or() {
        queryConditionGroupExpression.or();
        return (Q) this;
    }

    public List<E> list() {
        return queryConditionGroupExpression.list(type);
    }

    public E single() {
        return queryConditionGroupExpression.single(type);
    }

    public StaticTypeQueryExecutor<E> limit(Integer limit) {
        return new StaticTypeQueryExecutor<>(type, queryConditionGroupExpression.limit(limit));
    }

    /**
     * {@inheritDoc}
     */
    public StaticTypeQueryExecutor<E> limit(Integer offset, Integer limit) {
        return new StaticTypeQueryExecutor<>(type, queryConditionGroupExpression.limit(offset, limit));
    }

    /**
     * {@inheritDoc}
     */
    public StaticTypeQueryExecutor<E> limit(Page page) {
        return new StaticTypeQueryExecutor<>(type, queryConditionGroupExpression.limit(page));
    }

    protected abstract Q createChild(
        AbstractMulitiRepositorySqlQueryConditionsGroupExpression queryConditionGroupExpression, Q parent);
}
