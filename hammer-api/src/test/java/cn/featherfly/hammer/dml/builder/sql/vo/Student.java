
/*
 * All rights Reserved, Designed By zhongj
 * @Title: Student.java
 * @Package cn.featherfly.hammer.dml.builder.sql.vo
 * @Description: Student
 * @author: zhongj
 * @date: 2023-07-12 16:08:12
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dml.builder.sql.vo;

/**
 * Student.
 *
 * @author zhongj
 */
public class Student {

    private Integer id;

    private String name;

    private User user;

    private Teacher teacher;

    /**
     * get id value
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * set id value
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * get name value
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * set name value
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get user value
     *
     * @return user
     */
    public User getUser() {
        return user;
    }

    /**
     * set user value
     *
     * @param user user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * get teacher value
     *
     * @return teacher
     */
    public Teacher getTeacher() {
        return teacher;
    }

    /**
     * set teacher value
     *
     * @param teacher teacher
     */
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

}
