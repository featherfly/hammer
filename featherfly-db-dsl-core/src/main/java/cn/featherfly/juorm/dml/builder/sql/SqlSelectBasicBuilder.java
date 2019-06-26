package cn.featherfly.db.dsl.builder.sql;

import java.util.ArrayList;
import java.util.List;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.db.dsl.builder.Builder;

/**
 * <p>
 * sql find builder
 * </p>
 * 
 * @author zhongj
 */
public class AbstractSqlSelectBuilder implements Builder{

    protected String alias;
    
    protected String tableName;
    
    protected boolean buildWithFrom = true;
    
    protected List<String> columns = new ArrayList<>(0);
    
    protected SqlConditionGroup conditionBuilder;
    
    /**
     * @param conditionBuilder conditionBuilder
     */
    public AbstractSqlSelectBuilder(SqlConditionGroup conditionBuilder) {
        this(null, null, conditionBuilder);
    }
    /**
     * @param tableName tableName
     * @param conditionBuilder conditionBuilder
     */
    public AbstractSqlSelectBuilder(String tableName, SqlConditionGroup conditionBuilder) {
        this(tableName, null, conditionBuilder);
    }
    
    /**
     * @param tableName tableName
     * @param alias alias
     * @param conditionBuilder conditionBuilder
     */
    public AbstractSqlSelectBuilder(String tableName, String alias, SqlConditionGroup conditionBuilder) {
        this.alias = alias;
        this.tableName = tableName;
        this.conditionBuilder = conditionBuilder;
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
     * {@inheritDoc}
     */
    @Override
    public String build() {
        StringBuilder select = new StringBuilder();
        select.append("select ");
        for (String column : columns) {
            if (LangUtils.isNotEmpty(alias)) {
                select.append(alias).append(Chars.DOT);
            }
            select.append(column).append(",");
        }
        if (columns.isEmpty()) {
            select.append("*");
        } else {
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
