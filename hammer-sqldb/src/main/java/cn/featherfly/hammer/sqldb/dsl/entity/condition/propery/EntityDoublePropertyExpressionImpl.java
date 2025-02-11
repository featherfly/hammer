
package cn.featherfly.hammer.sqldb.dsl.entity.condition.propery;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.db.builder.model.ArithmeticColumnElement;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.operator.CalculationOperator;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.field.NumberFieldExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityDoublePropertyExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlRelation;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.AbstractMulitiEntityPropertyExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.InternalMulitiEntityCondition;

/**
 * entity double property expression implements.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class EntityDoublePropertyExpressionImpl<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends AbstractMulitiEntityPropertyExpression<E, C, L> implements EntityDoublePropertyExpression<C, L> {

    /**
     * Instantiates a new entity double property expression impl.
     *
     * @param index the index
     * @param propertyList the property list
     * @param expression the expression
     * @param factory the factory
     * @param queryRelation the query relation
     */
    public EntityDoublePropertyExpressionImpl(int index, List<Serializable> propertyList,
        InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
        EntitySqlRelation<?, ?> queryRelation) {
        super(new AtomicInteger(index), propertyList, expression, factory, queryRelation);
    }

    /**
     * Instantiates a new entity double property expression impl.
     *
     * @param index the index
     * @param propertyList the property list
     * @param expression the expression
     * @param factory the factory
     * @param queryRelation the query relation
     */
    public EntityDoublePropertyExpressionImpl(AtomicInteger index, List<Serializable> propertyList,
        InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
        EntitySqlRelation<?, ?> queryRelation) {
        super(index, propertyList, expression, factory, queryRelation);
    }

    /**
     * Instantiates a new entity double property expression impl.
     *
     * @param index the index
     * @param name the name
     * @param expression the expression
     * @param factory the factory
     * @param queryRelation the query relation
     */
    public EntityDoublePropertyExpressionImpl(int index, SerializableToDoubleFunction<E> name,
        InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
        EntitySqlRelation<?, ?> queryRelation) {
        super(new AtomicInteger(index), name, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Double value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.in(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Double value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.in(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Double value, Predicate<Double> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.in(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Double[] value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.in(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Double[] value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.in(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Double[] value, Predicate<Double[]> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.in(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Collection<Double> value, Predicate<Collection<Double>> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.in(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(Double value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ni(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(Double value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ni(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(Double value, Predicate<Double> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ni(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(Double[] value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ni(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(Double[] value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ni(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(Double[] value, Predicate<Double[]> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ni(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(Collection<Double> value, Predicate<Collection<Double>> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ni(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(Double value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.le(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(Double value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.le(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(Double value, Predicate<Double> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.le(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(Double value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.lt(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(Double value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.lt(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(Double value, Predicate<Double> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.lt(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(Double value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ge(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(Double value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ge(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(Double value, Predicate<Double> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ge(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(Double value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.gt(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(Double value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.gt(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(Double value, Predicate<Double> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.gt(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L isn(Boolean value) {
        return expression.isn(index, getPropertyMapping(value), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L inn(Boolean value) {
        return expression.inn(index, getPropertyMapping(value), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(Double value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.eq(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(Double value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.eq(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(Double value, Predicate<Double> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.eq(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(Double value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ne(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(Double value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ne(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(Double value, Predicate<Double> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ne(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(Double min, Double max) {
        PropertyMapping<?> pm = getPropertyMapping(Lang.ifNull(min, max));
        return expression.ba(index, pm, getColumnElement(pm), min, max,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(Double min, Double max, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(Lang.ifNull(min, max));
        return expression.ba(index, pm, getColumnElement(pm), min, max,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(Double min, Double max, BiPredicate<Double, Double> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(Lang.ifNull(min, max));
        return expression.ba(index, pm, getColumnElement(pm), min, max,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(Double min, Double max) {
        PropertyMapping<?> pm = getPropertyMapping(Lang.ifNull(min, max));
        return expression.nba(index, pm, getColumnElement(pm), min, max,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(Double min, Double max, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(Lang.ifNull(min, max));
        return expression.nba(index, pm, getColumnElement(pm), min, max,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(Double min, Double max, BiPredicate<Double, Double> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(Lang.ifNull(min, max));
        return expression.nba(index, pm, getColumnElement(pm), min, max,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NumberFieldExpression<Double, C, L> add(Double value) {
        if (arithmeticColumnElement.get() == null) {
            arithmeticColumnElement = () -> new ArithmeticColumnElement(expression.getJdbc().getDialect(),
                getPropertyMapping(value).getRepositoryFieldName(), CalculationOperator.PLUS, value);
        } else {
            arithmeticColumnElement.get().add(CalculationOperator.PLUS, value);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NumberFieldExpression<Double, C, L> subtract(Double value) {
        if (arithmeticColumnElement.get() == null) {
            arithmeticColumnElement = () -> new ArithmeticColumnElement(expression.getJdbc().getDialect(),
                getPropertyMapping(value).getRepositoryFieldName(), CalculationOperator.SUBTRACT, value);
        } else {
            arithmeticColumnElement.get().add(CalculationOperator.SUBTRACT, value);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NumberFieldExpression<Double, C, L> multiply(Double value) {
        if (arithmeticColumnElement.get() == null) {
            arithmeticColumnElement = () -> new ArithmeticColumnElement(expression.getJdbc().getDialect(),
                getPropertyMapping(value).getRepositoryFieldName(), CalculationOperator.MULTIPLY, value);
        } else {
            arithmeticColumnElement.get().add(CalculationOperator.MULTIPLY, value);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NumberFieldExpression<Double, C, L> divide(Double value) {
        if (arithmeticColumnElement.get() == null) {
            arithmeticColumnElement = () -> new ArithmeticColumnElement(expression.getJdbc().getDialect(),
                getPropertyMapping(value).getRepositoryFieldName(), CalculationOperator.DIVIDE, value);
        } else {
            arithmeticColumnElement.get().add(CalculationOperator.DIVIDE, value);
        }
        return this;
    }
}
