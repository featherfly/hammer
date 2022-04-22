package cn.featherfly.hammer.sqldb.jdbc.vo.order;

import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * The type Order.
 *
 * @author zhongj
 */
@Table
public class Order extends AbstractOrder {

    @Transient
    @Override
    public OrderType getType() {
        return OrderType.TRADE;
    }
}
