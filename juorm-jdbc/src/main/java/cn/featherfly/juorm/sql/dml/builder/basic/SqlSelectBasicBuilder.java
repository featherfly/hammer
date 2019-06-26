package cn.featherfly.juorm.sql.dml.builder.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.juorm.dml.builder.Builder;

/**
 * <p>
 * sql find builder
 * </p>
 * 
 * @author zhongj
 */
public class SqlSelectBasicBuilder implements Builder{

    protected String alias;
    
    protected String tableName;
    
    protected boolean buildWithFrom = true;
    
    protected List<String> columns = new ArrayList<>(0);
    
    /**
     */
    public SqlSelectBasicBuilder() {
        this(null);
    }
    
    /**
     * @param tableName tableName
     */
    public SqlSelectBasicBuilder(String tableName) {
        this(tableName, null);
    }
    
    /**
     * @param tableName tableName
     * @param alias alias
     */
    public SqlSelectBasicBuilder(String tableName, String alias) {
        this.alias = alias;
        this.tableName = tableName;
    }
    
    /**
     * @param tableName tableName
     * @param alias alias
     * @param selectColumns selectColumns
     */
    public SqlSelectBasicBuilder(String tableName, String alias, String... selectColumns) {
        this.alias = alias;
        this.tableName = tableName;
    }
        
    /**
     * 返回alias
     * @return alias
     */
    public String getAlias() {
        return alias;
    }

    /**
     * 设置alias
     * @param alias alias
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * 返回tableName
     * @return tableName
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 设置tableName
     * @param tableName tableName
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * 返回buildWithFrom
     * @return buildWithFrom
     */
    public boolean isBuildWithFrom() {
        return buildWithFrom;
    }

    /**
     * 设置buildWithFrom
     * @param buildWithFrom buildWithFrom
     */
    public void setBuildWithFrom(boolean buildWithFrom) {
        this.buildWithFrom = buildWithFrom;
    }
    /**
     * add column
     * @param column column
     * @return this
     */
    public SqlSelectBasicBuilder addSelectColumn(String column) {
        columns.add(column);
        return this;
    }
    /**
     * addColumns
     * @param columns columns
     * @return this
     */
    public SqlSelectBasicBuilder addSelectColumns(String...columns) {
        for (String c : columns) {
            addSelectColumn(c);
        }
        return this;
    }
    /**
     * addColumns
     * @param columns columns
     * @return this
     */
    public SqlSelectBasicBuilder addSelectColumns(Collection<String> columns) {
        for (String c : columns) {
            addSelectColumn(c);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String build() {
        StringBuilder select = new StringBuilder();
        select.append("select");
        if (columns.isEmpty()) {
            select.append(" ");
            if (LangUtils.isNotEmpty(alias)) {
                select.append(alias).append(Chars.DOT);
            }
            select.append("*");
        } else {
            for (String column : columns) {
                select.append(" ");
                if (LangUtils.isNotEmpty(alias)) {
                    select.append(alias).append(Chars.DOT);
                }
                select.append(column).append(",");
            }
            select.deleteCharAt(select.length() - 1);
        }
        if (buildWithFrom) {
            AssertIllegalArgument.isNotEmpty(tableName, "buildWithFrom=true时，tableName不能为空");
            select.append(" from ").append(tableName);
            if (LangUtils.isNotEmpty(alias)) {
                select.append(" ").append(alias);
            }
        }
        return select.toString();
    }
}
