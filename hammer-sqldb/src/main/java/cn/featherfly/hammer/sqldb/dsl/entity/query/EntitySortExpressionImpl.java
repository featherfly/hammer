
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2025-03-15 18:56:15
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.entity.query;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.repository.builder.dml.SortBuilder;
import cn.featherfly.hammer.expression.entity.query.sort.EntitySortExpression;
import cn.featherfly.hammer.expression.entity.query.sort.EntitySortedExpression;

/**
 * SortExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <S> the generic type
 */
public class EntitySortExpressionImpl<E, S extends EntitySortedExpression<E, S>>
    implements EntitySortExpression<E, S>, EntitySortedExpression<E, S> {

    private final String tableAlias;

    private final SortBuilder sortBuilder;

    /**
     * Instantiates a new entity sort expression impl.
     *
     * @param tableAlias the table alias
     * @param sortBuilder the sort builder
     */
    public EntitySortExpressionImpl(String tableAlias, SortBuilder sortBuilder) {
        super();
        this.tableAlias = tableAlias;
        this.sortBuilder = sortBuilder;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {
        return sortBuilder.build();
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <R> S asc(SerializableFunction<E, R> name) {
        sortBuilder.ascWith(tableAlias, LambdaUtils.getLambdaPropertyName(name));
        return (S) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public S asc(SerializableFunction<E, ?>... names) {
        if (names != null) {
            for (SerializableFunction<E, ?> name : names) {
                asc(name);
            }
        }
        return (S) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <R> S desc(SerializableFunction<E, R> name) {
        sortBuilder.descWith(tableAlias, LambdaUtils.getLambdaPropertyName(name));
        return (S) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public S desc(SerializableFunction<E, ?>... names) {
        if (names != null) {
            for (SerializableFunction<E, ?> name : names) {
                desc(name);
            }
        }
        return (S) this;
    }
}
