package cn.featherfly.hammer.dml.builder.sql.vo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Embedded;
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

    private String pwd;

    private Integer age;

    private Date date;

    private LocalDate localDate;

    private LocalDateTime localDateTime;

    private LocalTime localTime;

    @Embedded
    private Email email;

    @OneToOne
    private UserInfo userInfo;

    @OneToMany
    private List<Device> devices = new ArrayList<>();

    /**
     */
    public User() {
    }

    /**
     * @param id
     */
    public User(int id) {
        super();
        this.id = id;
    }

    public User username(String username) {
        this.username = username;
        return this;
    }

    public String testTwoArgu(Integer age, Integer id) {
        return username;
    }

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

    /**
     * get pwd value
     *
     * @return pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * set pwd value
     *
     * @param pwd pwd
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * get age value
     *
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * set age value
     *
     * @param age age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * get date value
     *
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * set date value
     *
     * @param date date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * get localDate value
     *
     * @return localDate
     */
    public LocalDate getLocalDate() {
        return localDate;
    }

    /**
     * set localDate value
     *
     * @param localDate localDate
     */
    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    /**
     * get localDateTime value
     *
     * @return localDateTime
     */
    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    /**
     * set localDateTime value
     *
     * @param localDateTime localDateTime
     */
    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    /**
     * get localTime value
     *
     * @return localTime
     */
    public LocalTime getLocalTime() {
        return localTime;
    }

    /**
     * set localTime value
     *
     * @param localTime localTime
     */
    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }

    /**
     * get email value
     *
     * @return email
     */
    public Email getEmail() {
        return email;
    }

    /**
     * set email value
     *
     * @param email email
     */
    public void setEmail(Email email) {
        this.email = email;
    }
}
