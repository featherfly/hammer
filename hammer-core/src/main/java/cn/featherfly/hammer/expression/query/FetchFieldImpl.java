
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
import java.util.function.Consumer;

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

    private Consumer<QueryableField> addField;

    private int index = 0;

    /**
     * Instantiates a new fetch field impl.
     */
    public FetchFieldImpl() {
        addField = (f) -> {
            AssertIllegalArgument.isNotEmpty(f.name(), "field name is empty, please set name(\"field name\")");
            fields.add(index, f);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DistinctAware distinct(boolean distinct) {
        DistinctAware distinctAware = new DistinctAwareImpl(addField, distinct);
        index++;
        return distinctAware;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NameAware name(String name) {
        NameAware nameAware = new NameAwareImpl(addField, name);
        index++;
        return nameAware;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AggregateAware aggregate(AggregateFunction aggregateFunction) {
        AggregateAware aggregateAware = new AggregateAwareImpl(addField, aggregateFunction);
        index++;
        return aggregateAware;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AggregatedField aggregate(AggregateFunction aggregateFunction, String name) {
        AggregatedField aggregatedField = new AggregatedFieldImpl(addField, aggregateFunction, name);
        index++;
        return aggregatedField;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AggregateDistinctNameAware aggregate(boolean distinct, AggregateFunction aggregateFunction, String name) {
        AggregateDistinctNameAware aggregateDistinctNameAware = new AggregateDistinctNameAwareImpl(addField, distinct,
                aggregateFunction, name);
        index++;
        return aggregateDistinctNameAware;
    }

    public List<QueryableField> getFields() {
        return fields;
    }
}
