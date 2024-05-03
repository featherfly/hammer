
package cn.featherfly.hammer.sqldb.dsl.condition.inn;

import java.util.concurrent.atomic.AtomicInteger;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.inn.MulitiIsNotNullExpression;
import cn.featherfly.hammer.sqldb.dsl.condition.AbstractInternalMulitiConditionHolder;
import cn.featherfly.hammer.sqldb.dsl.condition.InternalMulitiCondition;

/**
 * muliti is not null expression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractMulitiIsNotNullExpression<I extends InternalMulitiCondition<L>,
        C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractInternalMulitiConditionHolder<I, C, L> implements MulitiIsNotNullExpression<C, L> {

    /**
     * Instantiates a new muliti is not null expression impl.
     *
     * @param internalMulitiCondition the internal muliti condition
     */
    protected AbstractMulitiIsNotNullExpression(I internalMulitiCondition) {
        super(internalMulitiCondition);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, R> L inn(int index, SerializableFunction<E, R> name, Boolean value) {
        return hold.inn(new AtomicInteger(index), name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L inn(int index, String name, Boolean value) {
        return hold.inn(new AtomicInteger(index), name, value);
    }

}
