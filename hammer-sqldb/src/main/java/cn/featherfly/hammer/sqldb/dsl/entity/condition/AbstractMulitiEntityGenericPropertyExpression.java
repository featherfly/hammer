
package cn.featherfly.hammer.sqldb.dsl.entity.condition;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.operator.Function;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlRelation;

/**
 * The Class AbstractMulitiEntityPropertyExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <P> the element type
 * @param <F> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractMulitiEntityGenericPropertyExpression<E, P, F extends SerializableFunction<E, P>,
    C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends AbstractMulitiEntityPropertyExpression<E, C, L> {

    /**
     * Instantiates a new abstract muliti entity generic property expression.
     *
     * @param index the index
     * @param name the name
     * @param expression the expression
     * @param factory the factory
     * @param queryRelation the query relation
     */
    protected AbstractMulitiEntityGenericPropertyExpression(AtomicInteger index, F name,
        InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
        EntitySqlRelation<?, ?> queryRelation) {
        super(index, name, expression, factory, queryRelation);
    }

    /**
     * Instantiates a new abstract muliti entity generic property expression.
     *
     * @param index the index
     * @param propertyList the property list
     * @param function the function
     * @param argus the argus
     * @param expression the expression
     * @param factory the factory
     * @param queryRelation the query relation
     */
    protected AbstractMulitiEntityGenericPropertyExpression(AtomicInteger index, List<Serializable> propertyList,
        Function function, Object[] argus, InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
        EntitySqlRelation<?, ?> queryRelation) {
        super(index, propertyList, function, argus, expression, factory, queryRelation);
    }

    /**
     * Instantiates a new abstract muliti entity generic property expression.
     *
     * @param index the index
     * @param name the name
     * @param function the function
     * @param argus the argus
     * @param expression the expression
     * @param factory the factory
     * @param queryRelation the query relation
     */
    protected AbstractMulitiEntityGenericPropertyExpression(AtomicInteger index, Serializable name, Function function,
        Object[] argus, InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
        EntitySqlRelation<?, ?> queryRelation) {
        super(index, name, function, argus, expression, factory, queryRelation);
    }

    /**
     * Instantiates a new abstract muliti entity generic property expression.
     *
     * @param index the index
     * @param name the name
     * @param expression the expression
     * @param factory the factory
     * @param queryRelation the query relation
     */
    protected AbstractMulitiEntityGenericPropertyExpression(AtomicInteger index, Serializable name,
        InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
        EntitySqlRelation<?, ?> queryRelation) {
        super(index, name, expression, factory, queryRelation);
    }

    /**
     * Instantiates a new abstract muliti entity generic property expression.
     *
     * @param index the index
     * @param propertyList the property list
     * @param expression the expression
     * @param factory the factory
     * @param queryRelation the query relation
     */
    protected AbstractMulitiEntityGenericPropertyExpression(AtomicInteger index, List<Serializable> propertyList,
        InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
        EntitySqlRelation<?, ?> queryRelation) {
        super(index, propertyList, expression, factory, queryRelation);
    }
}
