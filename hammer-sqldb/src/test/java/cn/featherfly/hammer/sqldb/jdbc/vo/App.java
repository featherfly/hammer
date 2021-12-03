package cn.featherfly.hammer.sqldb.jdbc.vo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.featherfly.common.model.app.Platform;

/**
 * 应用程序.
 *
 * @author zhongj
 */
@Table(name = "app", indexes = { @Index(columnList = "code,platform", unique = true) })
public class App {

    @Id
    private Long id;

    private String code;

    private String name;

    private String descp;

    private Platform platform;

    @ManyToOne
    @Column(name = "last_version")
    private AppVersion lastVersion;

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
     * get code value
     *
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * set code value
     *
     * @param code code
     */
    public void setCode(String code) {
        this.code = code;
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
     * get platform value
     *
     * @return platform
     */
    public Platform getPlatform() {
        return platform;
    }

    /**
     * set platform value
     *
     * @param platform platform
     */
    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    /**
     * get lastVersion value
     *
     * @return lastVersion
     */
    public AppVersion getLastVersion() {
        return lastVersion;
    }

    /**
     * set lastVersion value
     *
     * @param lastVersion lastVersion
     */
    public void setLastVersion(AppVersion lastVersion) {
        this.lastVersion = lastVersion;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "App [id=" + id + ", code=" + code + ", name=" + name + ", descp=" + descp + ", platform=" + platform
                + ", lastVersion=" + lastVersion + "]";
    }

}
