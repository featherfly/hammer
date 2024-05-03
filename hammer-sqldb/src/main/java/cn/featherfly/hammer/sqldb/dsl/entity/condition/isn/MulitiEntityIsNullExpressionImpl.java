
package cn.featherfly.hammer.sqldb.dsl.entity.condition.isn;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.sqldb.dsl.condition.isn.AbstractMulitiIsNullExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.InternalMulitiEntityCondition;

/**
 * The Class MulitiEntityIsNullExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class MulitiEntityIsNullExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractMulitiIsNullExpression<InternalMulitiEntityCondition<L>, C, L> {

    /**
     * Instantiates a new muliti entity is null expression impl.
     *
     * @param proxy the proxy
     */
    public MulitiEntityIsNullExpressionImpl(InternalMulitiEntityCondition<L> proxy) {
        super(proxy);
    }
}
