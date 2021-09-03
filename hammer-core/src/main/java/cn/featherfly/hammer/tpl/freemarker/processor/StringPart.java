
package cn.featherfly.hammer.tpl.freemarker.processor;

/**
 * <p>
 * StringPart
 * </p>
 * .
 *
 * @author zhongj
 */
public class StringPart {

    private int start;

    private int end;

    private String value;

    /**
     * Instantiates a new string part.
     *
     * @param start the start
     * @param end   the end
     * @param value the value
     */
    public StringPart(int start, int end, String value) {
        super();
        this.start = start;
        this.end = end;
        this.value = value;
    }

    /**
     * 返回start.
     *
     * @return start
     */
    public int getStart() {
        return start;
    }

    /**
     * 返回end.
     *
     * @return end
     */
    public int getEnd() {
        return end;
    }

    /**
     * 返回value.
     *
     * @return value
     */
    public String getValue() {
        return value;
    }

}
