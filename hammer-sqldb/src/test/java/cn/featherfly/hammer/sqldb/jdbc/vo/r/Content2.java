
package cn.featherfly.hammer.sqldb.jdbc.vo.r;

/**
 * Content2.
 *
 * @author zhongj
 */
public class Content2 extends Content {

    /**
     *
     */
    private static final long serialVersionUID = 7751149901859290661L;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Content2 [descp=" + getDescp() + ", img=" + getImg() + "]";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Content2 other = (Content2) obj;
        if (getDescp() == null) {
            if (other.getDescp() != null) {
                return false;
            }
        } else if (!getDescp().equals(other.getDescp())) {
            return false;
        }
        if (getImg() == null) {
            if (other.getImg() != null) {
                return false;
            }
        } else if (!getImg().equals(other.getImg())) {
            return false;
        }
        return true;
    }
}
