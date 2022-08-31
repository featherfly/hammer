package cn.featherfly.hammer.dml.builder.sql.vo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * User.
 *
 * @author zhongj
 */
public class User {

    private int id;

    private String username;

    @OneToOne
    private UserInfo userInfo;

    @OneToMany
    private List<Device> devices = new ArrayList<>();

    /**
     * get id value
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * set id value
     *
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * get username value
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * set username value
     *
     * @param username username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * get devices value
     *
     * @return devices
     */
    public List<Device> getDevices() {
        return devices;
    }

    /**
     * set devices value
     *
     * @param devices devices
     */
    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    /**
     * get userInfo value
     *
     * @return userInfo
     */
    public UserInfo getUserInfo() {
        return userInfo;
    }

    /**
     * set userInfo value
     *
     * @param userInfo userInfo
     */
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
