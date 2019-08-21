
package cn.featherfly.juorm.rdb.jdbc.dsl.type;

import java.util.List;

import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.juorm.rdb.jdbc.dsl.query.SqlQueryConditionGroupExpression;

/**
 * <p>
 * TypeQueryConditionGroupExpression
 * </p>
 *
 * @author zhongj
 */
public abstract class TypeQueryConditionGroupExpression<E, Q extends TypeQueryConditionGroupExpression<E, Q>> {

    private Q parent;

    protected Class<E> type;

    protected SqlQueryConditionGroupExpression queryConditionGroupExpression;

    /**
     * @param queryConditionGroupExpression
     * @param parent
     */
    public TypeQueryConditionGroupExpression(SqlQueryConditionGroupExpression queryConditionGroupExpression, Q parent) {
        super();
        this.type = ClassUtils.getSuperClassGenricType(this.getClass());
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

    public TypeQueryExecutor<E> limit(Integer limit) {
        return new TypeQueryExecutor<>(type, queryConditionGroupExpression.limit(limit));
    }

    /**
     * {@inheritDoc}
     */
    public TypeQueryExecutor<E> limit(Integer offset, Integer limit) {
        return new TypeQueryExecutor<>(type, queryConditionGroupExpression.limit(offset, limit));
    }

    /**
     * {@inheritDoc}
     */
    public TypeQueryExecutor<E> limit(Page page) {
        return new TypeQueryExecutor<>(type, queryConditionGroupExpression.limit(page));
    }

    protected abstract Q createChild(SqlQueryConditionGroupExpression queryConditionGroupExpression, Q parent);
}