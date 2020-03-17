
package cn.featherfly.hammer.sqldb.jdbc.vo;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * <p>
 * Article
 * </p>
 *
 * @author zhongj
 */
@Entity(name = "cms_article")
public class Article {
    @Id
    private Integer id;

    private String title;

    private String content;

    /**
     * 返回id
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 返回title
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置title
     *
     * @param title title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 返回content
     *
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置content
     *
     * @param content content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Article [id=" + id + ", title=" + title + ", content=" + content + "]";
    }

}
