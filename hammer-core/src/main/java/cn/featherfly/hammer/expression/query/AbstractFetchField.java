
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-21 12:09:21
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.query;

import java.util.function.Consumer;

import cn.featherfly.common.operator.Function;
import cn.featherfly.common.repository.QueryableField;

/**
 * AbstractFetchField.
 *
 * @author zhongj
 * @param <F> the generic type
 */
public abstract class AbstractFetchField<F extends Function> implements QueryableField {

    private String name;

    private String alias;

    private boolean distinct;

    private F function;

    private Consumer<QueryableField> consumer;

    /**
     * Instantiates a new abstract fetch field.
     *
     * @param consumer the consumer
     * @param distinct the distinct
     */
    protected AbstractFetchField(Consumer<QueryableField> consumer, boolean distinct) {
        this(consumer, (F) null, distinct);
    }

    /**
     * Instantiates a new abstract fetch field.
     *
     * @param consumer the consumer
     * @param name     the name
     */
    protected AbstractFetchField(Consumer<QueryableField> consumer, String name) {
        this(consumer, name, false);
    }

    /**
     * Instantiates a new abstract fetch field.
     *
     * @param consumer the consumer
     * @param name     the name
     * @param distinct the distinct
     */
    protected AbstractFetchField(Consumer<QueryableField> consumer, String name, boolean distinct) {
        this(consumer, name, null, distinct);
    }

    /**
     * Instantiates a new abstract fetch field.
     *
     * @param consumer the consumer
     * @param name     the name
     * @param alias    the alias
     */
    protected AbstractFetchField(Consumer<QueryableField> consumer, String name, String alias) {
        this(consumer, name, alias, false);
    }

    /**
     * Instantiates a new abstract fetch field.
     *
     * @param consumer the consumer
     * @param name     the name
     * @param alias    the alias
     * @param distinct the distinct
     */
    protected AbstractFetchField(Consumer<QueryableField> consumer, String name, String alias, boolean distinct) {
        this(consumer, null, name, alias, distinct);
    }

    /**
     * Instantiates a new abstract fetch field.
     *
     * @param consumer the consumer
     * @param function the function
     */
    protected AbstractFetchField(Consumer<QueryableField> consumer, F function) {
        this(consumer, function, null, null);
    }

    /**
     * Instantiates a new abstract fetch field.
     *
     * @param consumer the consumer
     * @param function the function
     * @param distinct the distinct
     */
    protected AbstractFetchField(Consumer<QueryableField> consumer, F function, boolean distinct) {
        this(consumer, function, null, null, distinct);
    }

    /**
     * Instantiates a new abstract fetch field.
     *
     * @param consumer the consumer
     * @param function the function
     * @param name     the name
     */
    protected AbstractFetchField(Consumer<QueryableField> consumer, F function, String name) {
        this(consumer, function, name, null);
    }

    /**
     * Instantiates a new abstract fetch field.
     *
     * @param consumer the consumer
     * @param function the function
     * @param name     the name
     * @param alias    the alias
     */
    protected AbstractFetchField(Consumer<QueryableField> consumer, F function, String name, String alias) {
        this(consumer, function, name, alias, false);
    }

    /**
     * Instantiates a new abstract fetch field.
     *
     * @param consumer the consumer
     * @param function the function
     * @param name     the name
     * @param distinct the distinct
     */
    protected AbstractFetchField(Consumer<QueryableField> consumer, F function, String name, boolean distinct) {
        this(consumer, function, name, null, distinct);
    }

    /**
     * Instantiates a new abstract fetch field.
     *
     * @param consumer the consumer
     * @param function the function
     * @param name     the name
     * @param alias    the alias
     * @param distinct the distinct
     */
    protected AbstractFetchField(Consumer<QueryableField> consumer, F function, String name, String alias,
            boolean distinct) {
        super();
        this.name = name;
        this.alias = alias;
        this.distinct = distinct;
        this.function = function;
        consumer.accept(this);
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
    protected Consumer<QueryableField> getConsumer() {
        return consumer;
    }
}
