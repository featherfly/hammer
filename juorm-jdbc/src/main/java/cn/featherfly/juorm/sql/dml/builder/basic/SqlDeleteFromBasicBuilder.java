
package cn.featherfly.juorm.sql.dml.builder.basic;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.juorm.jdbc.dsl.execute.SqlBuilder;
import cn.featherfly.juorm.sql.dialect.Dialect;

/**
 * <p>
 * SqlUpdateSetBasicBuilder
 * </p>
 *
 * @author zhongj
 */
public class SqlDeleteFromBasicBuilder implements SqlBuilder {

    private String tableName;

    private Dialect dialect;

    public SqlDeleteFromBasicBuilder(Dialect dialect) {
        this(dialect, null);
    }

    public SqlDeleteFromBasicBuilder(Dialect dialect, String tableName) {
        this.tableName = tableName;
        this.dialect = dialect;
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
     * {@inheritDoc}
     */
    @Override
    public String build() {
        StringBuilder deleteSql = new StringBuilder();
        return deleteSql.append(dialect.getKeywords().deleteFrom()).append(Chars.SPACE)
                .append(dialect.buildTableSql(tableName)).toString();
    }

}
