
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-21 12:09:21
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.query;

import java.util.function.BiConsumer;

import cn.featherfly.common.operator.Function;
import cn.featherfly.common.repository.QueryableField;

/**
 * AbstractFetchField.
 *
 * @author zhongj
 * @param <F> the generic type
 */
public abstract class AbstractFetchField<F extends Function> implements QueryableField {

    private int index;

    private String name;

    private String alias;

    private boolean distinct;

    private F function;

    private BiConsumer<Integer, QueryableField> consumer;

    /**
     * Instantiates a new abstract fetch field.
     *
     * @param index    the index
     * @param consumer the consumer
     * @param distinct the distinct
     */
    protected AbstractFetchField(int index, BiConsumer<Integer, QueryableField> consumer, boolean distinct) {
        this(index, consumer, (F) null, distinct);
    }

    /**
     * Instantiates a new abstract fetch field.
     *
     * @param index    the index
     * @param consumer the consumer
     * @param name     the name
     */
    protected AbstractFetchField(int index, BiConsumer<Integer, QueryableField> consumer, String name) {
        this(index, consumer, name, false);
    }

    /**
     * Instantiates a new abstract fetch field.
     *
     * @param index    the index
     * @param consumer the consumer
     * @param name     the name
     * @param distinct the distinct
     */
    protected AbstractFetchField(int index, BiConsumer<Integer, QueryableField> consumer, String name,
            boolean distinct) {
        this(index, consumer, name, null, distinct);
    }

    /**
     * Instantiates a new abstract fetch field.
     *
     * @param index    the index
     * @param consumer the consumer
     * @param name     the name
     * @param alias    the alias
     */
    protected AbstractFetchField(int index, BiConsumer<Integer, QueryableField> consumer, String name, String alias) {
        this(index, consumer, name, alias, false);
    }

    /**
     * Instantiates a new abstract fetch field.
     *
     * @param index    the index
     * @param consumer the consumer
     * @param name     the name
     * @param alias    the alias
     * @param distinct the distinct
     */
    protected AbstractFetchField(int index, BiConsumer<Integer, QueryableField> consumer, String name, String alias,
            boolean distinct) {
        this(index, consumer, null, name, alias, distinct);
    }

    /**
     * Instantiates a new abstract fetch field.
     *
     * @param index    the index
     * @param consumer the consumer
     * @param function the function
     */
    protected AbstractFetchField(int index, BiConsumer<Integer, QueryableField> consumer, F function) {
        this(index, consumer, function, null, null);
    }

    /**
     * Instantiates a new abstract fetch field.
     *
     * @param index    the index
     * @param consumer the consumer
     * @param function the function
     * @param distinct the distinct
     */
    protected AbstractFetchField(int index, BiConsumer<Integer, QueryableField> consumer, F function,
            boolean distinct) {
        this(index, consumer, function, null, null, distinct);
    }

    /**
     * Instantiates a new abstract fetch field.
     *
     * @param index    the index
     * @param consumer the consumer
     * @param function the function
     * @param name     the name
     */
    protected AbstractFetchField(int index, BiConsumer<Integer, QueryableField> consumer, F function, String name) {
        this(index, consumer, function, name, null);
    }

    /**
     * Instantiates a new abstract fetch field.
     *
     * @param index    the index
     * @param consumer the consumer
     * @param function the function
     * @param name     the name
     * @param alias    the alias
     */
    protected AbstractFetchField(int index, BiConsumer<Integer, QueryableField> consumer, F function, String name,
            String alias) {
        this(index, consumer, function, name, alias, false);
    }

    /**
     * Instantiates a new abstract fetch field.
     *
     * @param index    the index
     * @param consumer the consumer
     * @param function the function
     * @param name     the name
     * @param distinct the distinct
     */
    protected AbstractFetchField(int index, BiConsumer<Integer, QueryableField> consumer, F function, String name,
            boolean distinct) {
        this(index, consumer, function, name, null, distinct);
    }

    /**
     * Instantiates a new abstract fetch field.
     *
     * @param index    the index
     * @param consumer the consumer
     * @param function the function
     * @param name     the name
     * @param alias    the alias
     * @param distinct the distinct
     */
    protected AbstractFetchField(int index, BiConsumer<Integer, QueryableField> consumer, F function, String name,
            String alias, boolean distinct) {
        super();
        this.name = name;
        this.alias = alias;
        this.distinct = distinct;
        this.function = function;

        this.index = index;
        this.consumer = consumer;
        consumer.accept(index, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String name() {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String alias() {
        return alias;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public F function() {
        return function;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * Gets the consumer.
     *
     * @return the consumer
     */
    protected BiConsumer<Integer, QueryableField> getConsumer() {
        return consumer;
    }

    /**
     * Gets the index.
     *
     * @return the index
     */
    protected int getIndex() {
        return index;
    }

}
