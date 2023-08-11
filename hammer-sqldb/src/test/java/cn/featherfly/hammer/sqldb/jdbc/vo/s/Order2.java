package cn.featherfly.hammer.sqldb.jdbc.vo.s;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The type Order.
 *
 * @author zhongj
 */
@Table(name = "order")
public class Order2 {

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

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "create_user")
    private Integer createUser;

    @Column(name = "update_user")
    private Integer updateUser;

    @Column(name = "user_info")
    private Integer userInfo;

    @Column(name = "user1")
    private Integer user1;

    @Column(name = "user2")
    private Integer user2;

    @Column(name = "user3")
    private Integer user3;

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
     * get parentId value
     *
     * @return parentId
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * set parentId value
     *
     * @param parentId parentId
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * get createUser value
     *
     * @return createUser
     */
    public Integer getCreateUser() {
        return createUser;
    }

    /**
     * set createUser value
     *
     * @param createUser createUser
     */
    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    /**
     * get updateUser value
     *
     * @return updateUser
     */
    public Integer getUpdateUser() {
        return updateUser;
    }

    /**
     * set updateUser value
     *
     * @param updateUser updateUser
     */
    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * get userInfo value
     *
     * @return userInfo
     */
    public Integer getUserInfo() {
        return userInfo;
    }

    /**
     * set userInfo value
     *
     * @param userInfo userInfo
     */
    public void setUserInfo(Integer userInfo) {
        this.userInfo = userInfo;
    }

    /**
     * get user1 value
     *
     * @return user1
     */
    public Integer getUser1() {
        return user1;
    }

    /**
     * set user1 value
     *
     * @param user1 user1
     */
    public void setUser1(Integer user1) {
        this.user1 = user1;
    }

    /**
     * get user2 value
     *
     * @return user2
     */
    public Integer getUser2() {
        return user2;
    }

    /**
     * set user2 value
     *
     * @param user2 user2
     */
    public void setUser2(Integer user2) {
        this.user2 = user2;
    }

    /**
     * get user3 value
     *
     * @return user3
     */
    public Integer getUser3() {
        return user3;
    }

    /**
     * set user3 value
     *
     * @param user3 user3
     */
    public void setUser3(Integer user3) {
        this.user3 = user3;
    }

}
