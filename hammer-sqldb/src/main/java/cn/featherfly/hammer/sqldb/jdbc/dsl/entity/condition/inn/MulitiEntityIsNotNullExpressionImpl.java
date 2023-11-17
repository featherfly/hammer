
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.inn;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.condition.inn.AbstractMulitiIsNotNullExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.InternalMulitiEntityCondition;

/**
 * The Class MulitiEntityIsNotNullExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class MulitiEntityIsNotNullExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractMulitiIsNotNullExpression<InternalMulitiEntityCondition<L>, C, L> {

    /**
     * Instantiates a new muliti entity is not null expression impl.
     *
     * @param proxy the proxy
     */
    public MulitiEntityIsNotNullExpressionImpl(InternalMulitiEntityCondition<L> proxy) {
        super(proxy);
    }

}
