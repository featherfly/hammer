
package cn.featherfly.hammer.sqldb.jdbc.dsl.condition.isn;

import java.util.concurrent.atomic.AtomicInteger;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.isn.MulitiIsNullExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.condition.AbstractInternalMulitiConditionHolder;
import cn.featherfly.hammer.sqldb.jdbc.dsl.condition.InternalMulitiCondition;

/**
 * abstract muliti is null expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractMulitiIsNullExpression<I extends InternalMulitiCondition<L>,
        C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractInternalMulitiConditionHolder<I, C, L> implements MulitiIsNullExpression<C, L> {

    /**
     * Instantiates a new muliti is null expression impl.
     *
     * @param internalMulitiCondition the internal muliti condition
     */
    protected AbstractMulitiIsNullExpression(I internalMulitiCondition) {
        super(internalMulitiCondition);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, R> L isn(int index, SerializableFunction<E, R> name, Boolean value) {
        return hold.isn(new AtomicInteger(index), name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L isn(int index, String name, Boolean value) {
        return hold.isn(new AtomicInteger(index), name, value);
    }

}
