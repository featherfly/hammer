package cn.featherfly.hammer.sqldb.jdbc.vo.r.order;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;

/**
 * The type abstract Order.
 *
 * @author zhongj
 */
public abstract class AbstractOrder {

    @Id
    private Long id;

    private String no; //订单编号

    private String appKey;

    // 微信支付相关 --------------------------------------------------------

    @Embedded
    private WechatPayOrder wechatOrder;

    //    private String appId;
    //
    //    private String wxTransactionId;
    //
    //    private String wxRefundId;
    //
    //    private String wxPrepayId;
    //
    //    private Date wxPrepayIdExpireTime;

    // 微信支付相关 --------------------------------------------------------

    // 支付宝相关 --------------------------------------------------------

    //    private String alipayTradeNo;

    @Embedded
    private AliPayOrder alipayOrder;

    @ManyToOne
    @Column(name = "create_user")
    private User createUser;

    @ManyToOne
    @Column(name = "update_user")
    private User updateUser;

    public abstract OrderType getType();

    /**
     * get id value
     *
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * set id value
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * get no value
     *
     * @return no
     */
    public String getNo() {
        return no;
    }

    /**
     * set no value
     *
     * @param no no
     */
    public void setNo(String no) {
        this.no = no;
    }

    /**
     * get appKey value
     *
     * @return appKey
     */
    public String getAppKey() {
        return appKey;
    }

    /**
     * set appKey value
     *
     * @param appKey appKey
     */
    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    /**
     * get wechatOrder value
     *
     * @return wechatOrder
     */
    public WechatPayOrder getWechatOrder() {
        return wechatOrder;
    }

    /**
     * set wechatOrder value
     *
     * @param wechatOrder wechatOrder
     */
    public void setWechatOrder(WechatPayOrder wechatOrder) {
        this.wechatOrder = wechatOrder;
    }

    /**
     * get alipayOrder value
     *
     * @return alipayOrder
     */
    public AliPayOrder getAlipayOrder() {
        return alipayOrder;
    }

    /**
     * set alipayOrder value
     *
     * @param alipayOrder alipayOrder
     */
    public void setAlipayOrder(AliPayOrder alipayOrder) {
        this.alipayOrder = alipayOrder;
    }

    /**
     * get createUser value
     *
     * @return createUser
     */
    public User getCreateUser() {
        return createUser;
    }

    /**
     * set createUser value
     *
     * @param createUser createUser
     */
    public void setCreateUser(User createUser) {
        this.createUser = createUser;
    }

    /**
     * get updateUser value
     *
     * @return updateUser
     */
    public User getUpdateUser() {
        return updateUser;
    }

    /**
     * set updateUser value
     *
     * @param updateUser updateUser
     */
    public void setUpdateUser(User updateUser) {
        this.updateUser = updateUser;
    }
}
