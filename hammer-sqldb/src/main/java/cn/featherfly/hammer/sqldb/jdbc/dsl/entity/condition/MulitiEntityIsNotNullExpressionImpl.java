
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition;

import java.util.concurrent.atomic.AtomicInteger;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.inn.MulitiEntityIsNotNullExpression;

/**
 * The Class MulitiEntityIsNotNullExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class MulitiEntityIsNotNullExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends MulitiEntityConditionExpressionProxy<C, L> implements MulitiEntityIsNotNullExpression<C, L> {

    /**
     * Instantiates a new muliti entity is not null expression impl.
     *
     * @param proxy the proxy
     */
    public MulitiEntityIsNotNullExpressionImpl(AbstractMulitiEntityConditionExpression<C, L> proxy) {
        super(proxy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, R> L inn(int index, SerializableFunction<E, R> name, Boolean value) {
        return proxy.inn0(new AtomicInteger(index), name, value);
    }

}
