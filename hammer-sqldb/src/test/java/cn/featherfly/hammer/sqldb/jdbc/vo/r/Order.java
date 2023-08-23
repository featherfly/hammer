package cn.featherfly.hammer.sqldb.jdbc.vo.r;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import cn.featherfly.hammer.sqldb.jdbc.vo.r.order.OrderInfo;

/**
 * The type Order.
 *
 * @author zhongj
 */
@Table(name = "order")
public class Order {

    @Id
    private Long id;

    private String no; //订单编号

    private String appKey;

    private String appId;

    // 微信支付相关 --------------------------------------------------------

    @Column(name = "wx_package")
    private String packageValue;

    @Column(name = "wx_package_expire_time")
    private LocalDateTime packageExpireTime;

    // 微信支付相关 --------------------------------------------------------

    // 支付宝相关 --------------------------------------------------------

    @Column(name = "alipay_trade_no")
    private String tradeNo;

    @ManyToOne
    @Column(name = "parent_id")
    private Order parent;

    @ManyToOne
    @Column(name = "create_user")
    private User createUser;

    @ManyToOne
    @Column(name = "update_user")
    private User updateUser;

    @ManyToOne
    @Column(name = "user_info")
    private UserInfo userInoInfo;

    @ManyToOne
    @Column(name = "user1")
    private User1 user1;

    @ManyToOne
    @Column(name = "user2")
    private User2 user2;

    @ManyToOne
    @Column(name = "user3")
    private User3 user3;

    @OneToMany(mappedBy = "order")
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    @Transient
    private List<OrderInfo> infos = new ArrayList<>();

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

    /**
     * get appId value
     *
     * @return appId
     */
    public String getAppId() {
        return appId;
    }

    /**
     * set appId value
     *
     * @param appId appId
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * get packageValue value
     *
     * @return packageValue
     */
    public String getPackageValue() {
        return packageValue;
    }

    /**
     * set packageValue value
     *
     * @param packageValue packageValue
     */
    public void setPackageValue(String packageValue) {
        this.packageValue = packageValue;
    }

    /**
     * get packageExpireTime value
     *
     * @return packageExpireTime
     */
    public LocalDateTime getPackageExpireTime() {
        return packageExpireTime;
    }

    /**
     * set packageExpireTime value
     *
     * @param packageExpireTime packageExpireTime
     */
    public void setPackageExpireTime(LocalDateTime packageExpireTime) {
        this.packageExpireTime = packageExpireTime;
    }

    /**
     * get tradeNo value
     *
     * @return tradeNo
     */
    public String getTradeNo() {
        return tradeNo;
    }

    /**
     * set tradeNo value
     *
     * @param tradeNo tradeNo
     */
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    /**
     * get userInoInfo value
     *
     * @return userInoInfo
     */
    public UserInfo getUserInoInfo() {
        return userInoInfo;
    }

    /**
     * set userInoInfo value
     *
     * @param userInoInfo userInoInfo
     */
    public void setUserInoInfo(UserInfo userInoInfo) {
        this.userInoInfo = userInoInfo;
    }

    /**
     * get user1 value
     *
     * @return user1
     */
    public User1 getUser1() {
        return user1;
    }

    /**
     * set user1 value
     *
     * @param user1 user1
     */
    public void setUser1(User1 user1) {
        this.user1 = user1;
    }

    /**
     * get user2 value
     *
     * @return user2
     */
    public User2 getUser2() {
        return user2;
    }

    /**
     * set user2 value
     *
     * @param user2 user2
     */
    public void setUser2(User2 user2) {
        this.user2 = user2;
    }

    /**
     * get user3 value
     *
     * @return user3
     */
    public User3 getUser3() {
        return user3;
    }

    /**
     * set user3 value
     *
     * @param user3 user3
     */
    public void setUser3(User3 user3) {
        this.user3 = user3;
    }

    /**
     * get infos value
     *
     * @return infos
     */
    public List<OrderInfo> getInfos() {
        return infos;
    }

    /**
     * set infos value
     *
     * @param infos infos
     */
    public void setInfos(List<OrderInfo> infos) {
        this.infos = infos;
    }

    /**
     * get parent value
     *
     * @return parent
     */
    public Order getParent() {
        return parent;
    }

    /**
     * set parent value
     *
     * @param parent parent
     */
    public void setParent(Order parent) {
        this.parent = parent;
    }

}
