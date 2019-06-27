
package cn.featherfly.juorm.sql.dml.builder.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.juorm.dml.builder.Builder;
import cn.featherfly.juorm.sql.dialect.Dialect;
import cn.featherfly.juorm.sql.dialect.Dialect.Keyworld;
import cn.featherfly.juorm.sql.model.ParamedColumnElement;
import cn.featherfly.juorm.sql.model.UpdateColumnElement;

/**
 * <p>
 * SqlUpdateSetBasicBuilder
 * </p>
 *
 * @author zhongj
 */
public class SqlUpdateSetBasicBuilder implements Builder {

    private String tableName;

    private String alias;

    private List<ParamedColumnElement> params = new ArrayList<>();

    private Dialect dialect;

    public SqlUpdateSetBasicBuilder(Dialect dialect) {
        this(dialect, null);
    }

    public SqlUpdateSetBasicBuilder(Dialect dialect, String tableName) {
        this(dialect, tableName, null);
    }

    public SqlUpdateSetBasicBuilder(Dialect dialect, String tableName, String alias) {
        this.tableName = tableName;
        this.alias = alias;
        this.dialect = dialect;
    }

    public SqlUpdateSetBasicBuilder setValue(String columnName, Object value) {
        params.add(new UpdateColumnElement(dialect, columnName, value, alias));
        return this;
    }

    // public SqlUpdateSetBasicBuilder setValue(String columnName, Object value,
    // String tableAlias) {
    // params.add(new ParamedColumnElement(dialect, columnName, tableAlias,
    // value));
    // return this;
    // }

    public List<Object> getParams() {
        return params.stream().map(ParamedColumnElement::getParam).collect(Collectors.toList());
    }

    /**
     * 设置tableName
     *
     * @param tableName tableName
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * 返回tableName
     *
     * @return tableName
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 返回alias
     *
     * @return alias
     */
    public String getAlias() {
        return alias;
    }

    /**
     * 设置alias
     *
     * @param alias alias
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String build() {
        StringBuilder select = new StringBuilder();
        Keyworld keyworld = dialect.getKeywords();
        select.append(keyworld.update()).append(Chars.SPACE).append(dialect.buildTableSql(tableName, alias))
                .append(Chars.SPACE).append(keyworld.set());
        // TODO 判断tableName paramMap 为空 抛出异常
        params.forEach(c -> {
            select.append(Chars.SPACE).append(c.toSql()).append(Chars.COMMA);
        });
        select.deleteCharAt(select.length() - 1);
        return select.toString();
    }

}
