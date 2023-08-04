package cn.featherfly.hammer.dml.builder.sql.vo;

import javax.persistence.ManyToOne;

/**
 * UserInfo.
 *
 * @author zhongj
 */
public class UserInfo {

    private int id;

    private String name;

    private int age;

    @ManyToOne
    private User user;

    /**
     * Instantiates a new user info.
     */
    public UserInfo() {
    }

    /**
     * Instantiates a new user info.
     *
     * @param id the id
     */
    public UserInfo(int id) {
        super();
        this.id = id;
    }

    /**
     * Instantiates a new user info.
     *
     * @param id   the id
     * @param name the name
     * @param age  the age
     */
    public UserInfo(int id, String name, int age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }

    /**
     * Instantiates a new user info.
     *
     * @param id   the id
     * @param name the name
     * @param age  the age
     * @param user the user
     */
    public UserInfo(int id, String name, int age, User user) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.user = user;
    }

    /**
     * get id value.
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * set id value.
     *
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * get name value.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * set name value.
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get age value.
     *
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * set age value.
     *
     * @param age age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * get user value.
     *
     * @return user
     */
    public User getUser() {
        return user;
    }

    /**
     * set user value.
     *
     * @param user user
     */
    public void setUser(User user) {
        this.user = user;
    }

}
