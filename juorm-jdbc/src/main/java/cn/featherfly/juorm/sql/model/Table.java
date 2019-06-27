
package cn.featherfly.juorm.sql.model;

/**
 * <p>
 * Column
 * </p>
 *
 * @author zhongj
 */
public class Table {

    private String name;

    private String alias;

    /**
     * @param name
     */
    public Table(String name) {
        this(name, null);
    }

    /**
     * @param name
     * @param alias
     */
    public Table(String name, String alias) {
        super();
        this.name = name;
        this.alias = alias;
    }

    /**
     * 返回name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置name
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 返回tableAlias
     *
     * @return tableAlias
     */
    public String getAlias() {
        return alias;
    }

    /**
     * 设置tableAlias
     *
     * @param alias tableAlias
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }
}
