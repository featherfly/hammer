
package cn.featherfly.hammer.sqldb.jdbc;

import static org.testng.Assert.assertEquals;

import java.time.LocalDateTime;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.db.mapping.JdbcMappingException;
import cn.featherfly.common.lang.Randoms;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.sqldb.SqldbHammerImpl;
import cn.featherfly.hammer.sqldb.jdbc.vo.order.AliPayOrder;
import cn.featherfly.hammer.sqldb.jdbc.vo.order.Order;
import cn.featherfly.hammer.sqldb.jdbc.vo.order.WechatPayOrder;

/**
 * <p>
 * SqlOrmTest
 * </p>
 *
 * @author zhongj
 */
public class HammerJdbcTestSpec extends JdbcTestBase {

    protected Hammer hammer;

    @BeforeClass
    void before() {
        hammer = new SqldbHammerImpl(jdbc, mappingFactory, configFactory);
    }

    @Test(expectedExceptions = JdbcMappingException.class)
    public void testMulitiEmbedded() {
        Order order = null;

        Order wechatOrder = new Order();
        wechatOrder.setNo(Randoms.getString(32));

        WechatPayOrder wechatPayOrder = new WechatPayOrder();
        wechatPayOrder.setAppId("wx:appid");
        wechatPayOrder.setPackageValue("wx_package_value=1234");
        wechatPayOrder.setPackageExpireTime(LocalDateTime.now());

        wechatOrder.setWechatOrder(wechatPayOrder);

        hammer.save(wechatOrder);

        order = hammer.get(wechatOrder.getId(), Order.class);

        assertEquals(order.getId(), wechatOrder.getId());
        assertEquals(order.getNo(), wechatOrder.getNo());
        assertEquals(order.getWechatOrder().getAppId(), wechatOrder.getWechatOrder().getAppId());
        assertEquals(order.getWechatOrder().getPackageValue(), wechatOrder.getWechatOrder().getPackageValue());
        //        assertEquals(order.getWechatOrder().getPackageExpireTime(),
        //                wechatOrder.getWechatOrder().getPackageExpireTime());

        Order aliOrder = new Order();
        aliOrder.setNo(Randoms.getString(32));

        AliPayOrder aliPayOrder = new AliPayOrder();
        aliPayOrder.setAppId("wx:alipay");
        aliPayOrder.setTradeNo("alipay:no:" + Randoms.getString(6));

        aliOrder.setAlipayOrder(aliPayOrder);

        hammer.save(aliOrder);

        order = hammer.get(aliOrder.getId(), Order.class);
        assertEquals(order.getId(), aliOrder.getId());
        assertEquals(order.getNo(), aliOrder.getNo());
        assertEquals(order.getAlipayOrder().getAppId(), aliOrder.getAlipayOrder().getAppId());
        assertEquals(order.getAlipayOrder().getTradeNo(), aliOrder.getAlipayOrder().getTradeNo());
    }
}
