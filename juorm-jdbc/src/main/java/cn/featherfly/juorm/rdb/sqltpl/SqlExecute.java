
package cn.featherfly.juorm.rdb.sqltpl;

/**
 * <p>
 * Config
 * </p>
 * 
 * @author zhongj
 */
public class SqlExecute {

    public static enum Type {
        LIST, PAGE, PAGINATION, EXECUTE
    }

    private Type type = Type.LIST;

    private String query;

    private String count;

    /**
     * 返回query
     * 
     * @return query
     */
    public String getQuery() {
        return query;
    }

    /**
     * 设置query
     * 
     * @param query
     *            query
     */
    public void setQuery(String query) {
        this.query = query;
    }

    /**
     * 返回count
     * 
     * @return count
     */
    public String getCount() {
        return count;
    }

    /**
     * 设置count
     * 
     * @param count
     *            count
     */
    public void setCount(String count) {
        this.count = count;
    }

    /**
     * 返回type
     * 
     * @return type
     */
    public Type getType() {
        return type;
    }

    /**
     * 设置type
     * 
     * @param type
     *            type
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Config [type=" + type + ", query=" + query + ", count=" + count
                + "]";
    }
}
