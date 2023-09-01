
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition;

import java.util.Collection;
import java.util.Date;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableToCollectionFunction;
import cn.featherfly.common.function.serializable.SerializableToDateFunction;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction;
import cn.featherfly.common.function.serializable.SerializableToEnumFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.common.function.serializable.SerializableToNumberFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityDatePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityEnumPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityLocalDatePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityLocalDateTimePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityLocalTimePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityNumberPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityPropertyTypeExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityStringPropertyExpression;

/**
 * The Class EntityPropertyTypeExpressionImpl.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <P> the element type
 * @param <F> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class EntityPropertyTypeExpressionImpl<E, P, F extends SerializableFunction<E, P>, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends AbstractMulitiEntityPropertyExpression<E, P, F, C, L>
        implements EntityPropertyTypeExpression<P, C, L> {

    /**
     * Instantiates a new entity property type expression impl.
     *
     * @param index      the index
     * @param name       the name
     * @param expression the expression
     */
    public EntityPropertyTypeExpressionImpl(int index, F name,
            AbstractMulitiEntityConditionExpression<C, L> expression) {
        super(index, name, expression);
    }

    // ****************************************************************************************************************
    //	property
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityNumberPropertyExpression<P, Integer, C, L> property(SerializableToIntFunction<P> name) {
        // IMPLSOON 嵌套对象属性后续来实现
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityNumberPropertyExpression<P, Long, C, L> property(SerializableToLongFunction<P> name) {
        // IMPLSOON 嵌套对象属性后续来实现
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityNumberPropertyExpression<P, Double, C, L> property(SerializableToDoubleFunction<P> name) {
        // IMPLSOON 嵌套对象属性后续来实现
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <PT extends Number> EntityNumberPropertyExpression<P, PT, C, L> property(
            SerializableToNumberFunction<P, PT> name) {
        // IMPLSOON 嵌套对象属性后续来实现
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> EntityDatePropertyExpression<P, R, C, L> property(SerializableToDateFunction<P, R> name) {
        // IMPLSOON 嵌套对象属性后续来实现
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityStringPropertyExpression<P, C, L> property(SerializableToStringFunction<P> name) {
        // IMPLSOON 嵌套对象属性后续来实现
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLocalDatePropertyExpression<P, C, L> property(SerializableToLocalDateFunction<P> name) {
        // IMPLSOON 嵌套对象属性后续来实现
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLocalDateTimePropertyExpression<P, C, L> property(SerializableToLocalDateTimeFunction<P> name) {
        // IMPLSOON 嵌套对象属性后续来实现
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLocalTimePropertyExpression<P, C, L> property(SerializableToLocalTimeFunction<P> name) {
        // IMPLSOON 嵌套对象属性后续来实现
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Enum<R>> EntityEnumPropertyExpression<P, R, C, L> property(
            SerializableToEnumFunction<P, R> name) {
        // IMPLSOON 嵌套对象属性后续来实现
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityPropertyTypeExpression<R, C, L> property(SerializableFunction<P, R> name) {
        // IMPLSOON 嵌套对象属性后续来实现
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Collection<RE>,
            RE> EntityPropertyTypeExpression<RE, C, L> property(SerializableToCollectionFunction<P, R, RE> name) {
        // IMPLSOON 嵌套对象属性后续来实现
        return null;
    }

    // ****************************************************************************************************************
    //  condition
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {
        return expression.expression();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(P value, MatchStrategy queryPolicy) {
        return expression.eq0(index, name, value, queryPolicy, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(P value, MatchStrategy queryPolicy) {
        return expression.ne0(index, name, value, queryPolicy, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(P value) {
        return expression.in0(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(P value) {
        return expression.nin0(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public L le(P value) {
        return expression.le0(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public L lt(P value) {
        return expression.lt0(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public L ge(P value) {
        return expression.ge0(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public L gt(P value) {
        return expression.gt0(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public L sw(String value, MatchStrategy queryPolicy) {
        return expression.sw0(index, name, value, queryPolicy, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public L co(String value, MatchStrategy queryPolicy) {
        return expression.co0(index, name, value, queryPolicy, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public L ew(String value, MatchStrategy queryPolicy) {
        return expression.ew0(index, name, value, queryPolicy, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(String value, MatchStrategy queryPolicy) {
        return expression.lk0(index, name, value, queryPolicy, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L isn(Boolean value) {
        return expression.isn0(index, name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L inn(Boolean value) {
        return expression.inn0(index, name, value);
    }
}
