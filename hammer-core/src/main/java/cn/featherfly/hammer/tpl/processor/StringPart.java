
package cn.featherfly.hammer.tpl.processor;

/**
 * <p>
 * StringPart
 * </p>
 *
 * @author zhongj
 */
public class StringPart {

    private int start;

    private int end;

    private String value;

    /**
     * @param start
     * @param end
     * @param value
     */
    public StringPart(int start, int end, String value) {
        super();
        this.start = start;
        this.end = end;
        this.value = value;
    }

    /**
     * 返回start
     * 
     * @return start
     */
    public int getStart() {
        return start;
    }

    /**
     * 返回end
     * 
     * @return end
     */
    public int getEnd() {
        return end;
    }

    /**
     * 返回value
     * 
     * @return value
     */
    public String getValue() {
        return value;
    }

}
