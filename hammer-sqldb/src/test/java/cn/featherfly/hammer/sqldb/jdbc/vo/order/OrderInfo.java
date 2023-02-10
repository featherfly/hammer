package cn.featherfly.hammer.sqldb.jdbc.vo.order;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.featherfly.hammer.sqldb.jdbc.vo.User;
import cn.featherfly.hammer.sqldb.jdbc.vo.User1;
import cn.featherfly.hammer.sqldb.jdbc.vo.User2;
import cn.featherfly.hammer.sqldb.jdbc.vo.User3;
import cn.featherfly.hammer.sqldb.jdbc.vo.UserInfo;

/**
 * The type Order.
 *
 * @author zhongj
 */
@Table(name = "order_info")
public class OrderInfo {

    @Id
    private Long id;

    private String descp;

    @ManyToOne
    @Column(name = "order_id")
    private Order2 order;

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
     * get descp value
     *
     * @return descp
     */
    public String getDescp() {
        return descp;
    }

    /**
     * set descp value
     *
     * @param descp descp
     */
    public void setDescp(String descp) {
        this.descp = descp;
    }

    /**
     * get order value
     *
     * @return order
     */
    public Order2 getOrder() {
        return order;
    }

    /**
     * set order value
     *
     * @param order order
     */
    public void setOrder(Order2 order) {
        this.order = order;
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

}
