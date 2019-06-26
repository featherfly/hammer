package cn.featherfly.juorm.sql.dml.builder;
//
//package builder.sql;
//
//import java.util.Collection;
//
//import builder.Builder;
//import builder.ConditionBuilder;
//import builder.SelectBuilder;
//
///**
// * <p>
// * SqlBuilder
// * </p>
// * 
// * @author zhongj
// */
//public class SqlBuilder implements Builder{
//    
//    private SelectBuilder selectBuilder;
//
//    private ConditionBuilder conditionBuilder;
//    
//    /**
//     */
//    public SqlBuilder() {
//        this(null);
//    }
//    
//    /**
//     * 
//     * @param tableName tableName
//     */
//    public SqlBuilder(String tableName) {
//        this(tableName, null);
//    }
//    /**
//     * @param tableName tableName
//     * @param alias alias
//     */
//    public SqlBuilder(String tableName, String alias) {
//        selectBuilder = new SelectBuilder(tableName, alias);
//        conditionBuilder = new ConditionBuilder(alias);
////        conditionBuilder.setBuildWithWhere(true);
//    }
//    
//    /**
//     * <p>
//     * 批量添加select的列
//     * </p>
//     * @param columnNames columnNames
//     * @return this
//     */
//    public ConditionBuilder select(String...columnNames) {
//        selectBuilder.select(columnNames);
//        return conditionBuilder;
//    }
//    /**
//     * <p>
//     * 批量添加select的列
//     * </p>
//     * @param columnNames columnNames
//     * @return this
//     */
//    public ConditionBuilder select(Collection<String> columnNames) {
//        selectBuilder.select(columnNames);
//        return conditionBuilder;
//    }
//    
//    /**
//     * 返回selectBuilder
//     * @return selectBuilder
//     */
//    public SelectBuilder getSelectBuilder() {
//        return selectBuilder;
//    }
//
//    /**
//     * 返回conditionBuilder
//     * @return conditionBuilder
//     */
//    public ConditionBuilder getConditionBuilder() {
//        return conditionBuilder;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public String build() {
//        return (selectBuilder.build() + " " + conditionBuilder.build()).trim();
//    }
//
//}
