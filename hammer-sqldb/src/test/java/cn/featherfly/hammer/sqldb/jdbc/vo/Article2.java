
package cn.featherfly.hammer.sqldb.jdbc.vo;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <p>
 * Article
 * </p>
 *
 * @author zhongj
 */
@Entity
@Table(name = "cms_article2")
public class Article2 {
    @Id
    private Integer id;

    private String title;

    private Long[] content;

    private Content content2;

    private Content content3;

    private List<Long> content4;

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
     * get content2 value
     *
     * @return content2
     */
    public Content getContent2() {
        return content2;
    }

    /**
     * set content2 value
     *
     * @param content2 content2
     */
    public void setContent2(Content content2) {
        this.content2 = content2;
    }

    /**
     * get content3 value
     *
     * @return content3
     */
    public Content getContent3() {
        return content3;
    }

    /**
     * set content3 value
     *
     * @param content3 content3
     */
    public void setContent3(Content content3) {
        this.content3 = content3;
    }

    /**
     * get content value
     *
     * @return content
     */
    public Long[] getContent() {
        return content;
    }

    /**
     * set content value
     *
     * @param content content
     */
    public void setContent(Long[] content) {
        this.content = content;
    }

    /**
     * get content4 value
     *
     * @return content4
     */
    public List<Long> getContent4() {
        return content4;
    }

    /**
     * set content4 value
     *
     * @param content4 content4
     */
    public void setContent4(List<Long> content4) {
        this.content4 = content4;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Article2 [id=" + id + ", title=" + title + ", content=" + Arrays.toString(content) + ", content2="
                + content2 + ", content3=" + content3 + ", content4=" + content4 + "]";
    }
}
