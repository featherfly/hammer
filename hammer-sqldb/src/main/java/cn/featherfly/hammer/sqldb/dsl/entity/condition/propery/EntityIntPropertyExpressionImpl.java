
package cn.featherfly.hammer.sqldb.dsl.entity.condition.propery;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.db.builder.model.ArithmeticColumnElement;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.operator.CalculationOperator;
import cn.featherfly.common.operator.Function;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.field.NumberFieldExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityIntPropertyExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlRelation;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.AbstractMulitiEntityPropertyExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.InternalMulitiEntityCondition;

/**
 * entity int property expression implements.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class EntityIntPropertyExpressionImpl<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends AbstractMulitiEntityPropertyExpression<E, C, L> implements EntityIntPropertyExpression<C, L> {

    /**
     * Instantiates a new entity int property expression impl.
     *
     * @param index the index
     * @param propertyList the property list
     * @param expression the expression
     * @param factory the factory
     * @param queryRelation the query relation
     */
    public EntityIntPropertyExpressionImpl(int index, List<Serializable> propertyList,
        InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
        EntitySqlRelation<?, ?> queryRelation) {
        super(new AtomicInteger(index), propertyList, expression, factory, queryRelation);
    }

    /**
     * Instantiates a new entity int property expression impl.
     *
     * @param index the index
     * @param propertyList the property list
     * @param function the function
     * @param argus the argus
     * @param expression the expression
     * @param factory the factory
     * @param queryRelation the query relation
     */
    public EntityIntPropertyExpressionImpl(int index, List<Serializable> propertyList,
        Function function, Object[] argus, InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
        EntitySqlRelation<?, ?> queryRelation) {
        super(new AtomicInteger(index), propertyList, function, argus, expression, factory, queryRelation);
    }

    /**
     * Instantiates a new entity int property expression impl.
     *
     * @param index the index
     * @param propertyList the property list
     * @param expression the expression
     * @param factory the factory
     * @param queryRelation the query relation
     */
    public EntityIntPropertyExpressionImpl(AtomicInteger index, List<Serializable> propertyList,
        InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
        EntitySqlRelation<?, ?> queryRelation) {
        super(index, propertyList, expression, factory, queryRelation);
    }

    /**
     * Instantiates a new entity int property expression impl.
     *
     * @param index the index
     * @param propertyList the property list
     * @param function the function
     * @param argus the argus
     * @param expression the expression
     * @param factory the factory
     * @param queryRelation the query relation
     */
    public EntityIntPropertyExpressionImpl(AtomicInteger index, List<Serializable> propertyList, Function function,
        Object[] argus, InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
        EntitySqlRelation<?, ?> queryRelation) {
        super(index, propertyList, function, argus, expression, factory, queryRelation);
    }

    /**
     * Instantiates a new entity int property expression impl.
     *
     * @param index the index
     * @param name the name
     * @param expression the expression
     * @param factory the factory
     * @param queryRelation the query relation
     */
    public EntityIntPropertyExpressionImpl(int index, SerializableToIntFunction<E> name,
        InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
        EntitySqlRelation<?, ?> queryRelation) {
        super(new AtomicInteger(index), name, expression, factory, queryRelation);
    }

    /**
     * Instantiates a new entity int property expression impl.
     *
     * @param index the index
     * @param name the name
     * @param function the function
     * @param argus the argus
     * @param expression the expression
     * @param factory the factory
     * @param queryRelation the query relation
     */
    public EntityIntPropertyExpressionImpl(int index, SerializableToIntFunction<E> name,
        Function function, Object[] argus, InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
        EntitySqlRelation<?, ?> queryRelation) {
        super(new AtomicInteger(index), name, function, argus, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Integer value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.in(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Integer value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.in(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Integer value, Predicate<Integer> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.in(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Integer[] value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.in(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Integer[] value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.in(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Integer[] value, Predicate<Integer[]> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.in(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Collection<Integer> value, Predicate<Collection<Integer>> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.in(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(Integer value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ni(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(Integer value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ni(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(Integer value, Predicate<Integer> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ni(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(Integer[] value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ni(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(Integer[] value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ni(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(Integer[] value, Predicate<Integer[]> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ni(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(Collection<Integer> value, Predicate<Collection<Integer>> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ni(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(Integer value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.le(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(Integer value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.le(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(Integer value, Predicate<Integer> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.le(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(Integer value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.lt(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(Integer value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.lt(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(Integer value, Predicate<Integer> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.lt(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(Integer value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ge(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(Integer value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ge(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(Integer value, Predicate<Integer> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ge(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(Integer value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.gt(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(Integer value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.gt(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(Integer value, Predicate<Integer> ignoreStrategy) {
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
    public L eq(Integer value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.eq(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(Integer value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.eq(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(Integer value, Predicate<Integer> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.eq(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(Integer value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ne(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(Integer value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ne(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(Integer value, Predicate<Integer> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ne(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(Integer min, Integer max) {
        PropertyMapping<?> pm = getPropertyMapping(Lang.ifNull(min, max));
        return expression.ba(index, pm, getColumnElement(pm), min, max,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(Integer min, Integer max, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(Lang.ifNull(min, max));
        return expression.ba(index, pm, getColumnElement(pm), min, max,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(Integer min, Integer max, BiPredicate<Integer, Integer> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(Lang.ifNull(min, max));
        return expression.ba(index, pm, getColumnElement(pm), min, max,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(Integer min, Integer max) {
        PropertyMapping<?> pm = getPropertyMapping(Lang.ifNull(min, max));
        return expression.nba(index, pm, getColumnElement(pm), min, max,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(Integer min, Integer max, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(Lang.ifNull(min, max));
        return expression.nba(index, pm, getColumnElement(pm), min, max,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(Integer min, Integer max, BiPredicate<Integer, Integer> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(Lang.ifNull(min, max));
        return expression.nba(index, pm, getColumnElement(pm), min, max,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NumberFieldExpression<Integer, C, L> add(Integer value) {
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
    public NumberFieldExpression<Integer, C, L> subtract(Integer value) {
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
    public NumberFieldExpression<Integer, C, L> multiply(Integer value) {
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
    public NumberFieldExpression<Integer, C, L> divide(Integer value) {
        if (arithmeticColumnElement.get() == null) {
            arithmeticColumnElement = () -> new ArithmeticColumnElement(expression.getJdbc().getDialect(),
                getPropertyMapping(value).getRepositoryFieldName(), CalculationOperator.DIVIDE, value);
        } else {
            arithmeticColumnElement.get().add(CalculationOperator.DIVIDE, value);
        }
        return this;
    }
}
