
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-21 12:09:21
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.query;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.repository.QueryableField;

/**
 * FetchFieldImpl.
 *
 * @author zhongj
 */
public class FetchFieldImpl implements FetchField {

    private List<QueryableField> fields = new ArrayList<>();

    private BiConsumer<Integer, QueryableField> addField;

    private int index = 0;

    /**
     * Instantiates a new fetch field impl.
     */
    public FetchFieldImpl() {
        addField = (i, f) -> {
            AssertIllegalArgument.isNotEmpty(f.name(), "field name is empty, please set name(\"field name\")");
            if (fields.size() > i) {
                fields.set(i, f);
            } else {
                fields.add(i, f);
            }
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DistinctAware distinct(boolean distinct) {
        DistinctAware distinctAware = new DistinctAwareImpl(index, addField, distinct);
        index++;
        return distinctAware;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NameAware name(String name) {
        NameAware nameAware = new NameAwareImpl(index, addField, name);
        index++;
        return nameAware;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AggregateAware aggregate(AggregateFunction aggregateFunction) {
        AggregateAware aggregateAware = new AggregateAwareImpl(index, addField, aggregateFunction);
        index++;
        return aggregateAware;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AggregatedField aggregate(AggregateFunction aggregateFunction, String name) {
        AggregatedField aggregatedField = new AggregatedFieldImpl(index, addField, aggregateFunction, name);
        index++;
        return aggregatedField;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AggregateDistinctNameAware aggregate(boolean distinct, AggregateFunction aggregateFunction, String name) {
        AggregateDistinctNameAware aggregateDistinctNameAware = new AggregateDistinctNameAwareImpl(index, addField,
                distinct, aggregateFunction, name);
        index++;
        return aggregateDistinctNameAware;
    }

    /**
     * Gets the fields.
     *
     * @return the fields
     */
    public List<QueryableField> getFields() {
        return fields;
    }
}
