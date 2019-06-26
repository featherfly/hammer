
package cn.featherfly.juorm.sql.dml.builder;

import java.util.Collection;

import cn.featherfly.juorm.dml.builder.Builder;

/**
 * <p>
 * SelectBuilder
 * </p>
 *
 * @author zhongj
 */
public interface SelectBuilder extends Builder {
       
    /**
     * <p>
     * 添加select的列
     * </p>
     * @param columnName columnName
     * @return SelectBuilder
     */
    SelectBuilder select(String columnName) ;
    /**
     * <p>
     * 批量添加select的列
     * </p>
     * @param columnNames columnNames
     * @return SelectBuilder
     */
    SelectBuilder select(String...columnNames);
    /**
     * <p>
     * 批量添加select的列
     * </p>
     * @param columnNames columnNames
     * @return SelectBuilder
     */
    SelectBuilder select(Collection<String> columnNames) ;

    /**
     * <p>
     * 进入条件表达式
     * </p>
     * 
     * @param target tableName
     * @return ConditionBuilder
     */
    SqlConditionBuilder from(String tableName);
    
    /**
     * <p>
     * 进入条件表达式
     * </p>
     * 
     * @param target tableName
     * @param alias alias
     * @return ConditionBuilder
     */
    SqlConditionBuilder from(String tableName, String alias);
}
