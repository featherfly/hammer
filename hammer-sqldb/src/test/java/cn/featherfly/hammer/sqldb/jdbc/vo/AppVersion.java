package cn.featherfly.hammer.sqldb.jdbc.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.featherfly.common.model.app.Platform;
import cn.featherfly.common.model.app.Version;

/**
 * 应用程序.
 *
 * @author zhongj
 */
@Table
public class AppVersion implements Version {

    @Id
    private Long id;

    @ManyToOne
    @Column(name = "app_id")
    private App app;

    private Platform platform;

    // 版本号，用于比较
    private Long version;

    // 版本号，用于展示
    private String versionCode;

    // 版本描述
    private String descp;

    //发行日期
    private Date releaseDate;

    // 下载地址
    private String url;

    private String storeKey;

    @Override
    public String name() {
        return getVersionCode();
    }

    @Override
    public Long value() {
        return getVersion();
    }

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
     * get app value
     *
     * @return app
     */
    public App getApp() {
        return app;
    }

    /**
     * set app value
     *
     * @param app app
     */
    public void setApp(App app) {
        this.app = app;
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
     * get version value
     *
     * @return version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * set version value
     *
     * @param version version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * get versionCode value
     *
     * @return versionCode
     */
    public String getVersionCode() {
        return versionCode;
    }

    /**
     * set versionCode value
     *
     * @param versionCode versionCode
     */
    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
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
     * get releaseDate value
     *
     * @return releaseDate
     */
    public Date getReleaseDate() {
        return releaseDate;
    }

    /**
     * set releaseDate value
     *
     * @param releaseDate releaseDate
     */
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * get url value
     *
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * set url value
     *
     * @param url url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * get storeKey value
     *
     * @return storeKey
     */
    public String getStoreKey() {
        return storeKey;
    }

    /**
     * set storeKey value
     *
     * @param storeKey storeKey
     */
    public void setStoreKey(String storeKey) {
        this.storeKey = storeKey;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "AppVersion [id=" + id + ", app=" + app + ", platform=" + platform + ", version=" + version
                + ", versionCode=" + versionCode + ", descp=" + descp + ", releaseDate=" + releaseDate + ", url=" + url
                + ", storeKey=" + storeKey + "]";
    }
}
