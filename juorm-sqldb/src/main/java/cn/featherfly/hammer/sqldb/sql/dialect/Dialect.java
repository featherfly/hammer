package cn.featherfly.hammer.sqldb.sql.dialect;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.hammer.dml.builder.BuilderException;
import cn.featherfly.hammer.operator.AggregateFunction;
import cn.featherfly.hammer.operator.Function;
import cn.featherfly.hammer.operator.LogicOperator;
import cn.featherfly.hammer.operator.SortOperator;
import cn.featherfly.hammer.sqldb.sql.model.TableElement;

/**
 * <p>
 * 数据库方言的接口.
 * </p>
 *
 * @author zhongj
 */
public interface Dialect extends cn.featherfly.common.db.dialect.Dialect {

    /**
     * get converted keywords
     *
     * @param keywords
     *            sql keywords
     * @return sql key words
     */
    default String getKeyword(SortOperator keywords) {
        if (isKeywordsUppercase()) {
            return keywords.toString();
        } else {
            return keywords.toString().toLowerCase();
        }
    }

    /**
     * get converted keywords
     *
     * @param keywords
     *            sql keywords
     * @return sql key words
     */
    default String getKeyword(LogicOperator keywords) {
        if (isKeywordsUppercase()) {
            return keywords.toString();
        } else {
            return keywords.toString().toLowerCase();
        }
    }

    /**
     * get converted aggregate function
     *
     * @param function
     *            aggregate function
     * @return sql aggregate function
     */
    default String getFunction(Function function) {
        if (isKeywordsUppercase()) {
            return function.toString().toUpperCase();
        } else {
            return function.toString().toLowerCase();
        }
    }

    /**
     * build sql for table
     *
     * @param table
     *            table
     * @return sql
     */
    default String buildTableSql(TableElement table) {
        return buildTableSql(table.getName(), table.getAlias());
    }

    /**
     * build sql for column with aggregate function
     *
     * @param columnName
     *            columnName
     * @param function
     *            function
     * @return sql
     */
    default String buildColumnSql(String columnName, Function function) {
        return buildColumnSql(columnName, null, function);
    }

    /**
     * build sql for column with aggregate function
     *
     * @param columnName
     *            columnName
     * @param aggregateFunction
     *            aggregateFunction
     * @return sql
     */
    default String buildColumnSql(String columnName,
            AggregateFunction aggregateFunction) {
        return buildColumnSql(columnName, null, aggregateFunction);
    }

    /**
     * build sql for column with aggregate function
     *
     * @param columnName
     *            columnName
     * @param tableAlias
     *            tableAlias
     * @return sql
     */
    default String buildColumnSql(String columnName, String tableAlias) {
        return buildColumnSql(columnName, tableAlias, null, null);
    }

    /**
     * build sql for column with aggregate function
     *
     * @param columnName
     *            columnName
     * @param tableAlias
     *            tableAlias
     * @param asName
     *            asName
     * @return sql
     */
    default String buildColumnSql(String columnName, String tableAlias,
            String asName) {
        return buildColumnSql(columnName, tableAlias, null, asName);
    }

    /**
     * build sql for column with tableAlias and aggregate function
     *
     * @param columnName
     *            columnName
     * @param tableAlias
     *            tableAlias
     * @param aggregateFunction
     *            aggregateFunction
     * @return sql
     */
    default String buildColumnSql(String columnName, String tableAlias,
            AggregateFunction aggregateFunction) {
        return buildColumnSql(columnName, tableAlias, aggregateFunction, null);
    }

    /**
     * build sql for column with tableAlias and aggregate function
     *
     * @param columnName
     *            columnName
     * @param tableAlias
     *            tableAlias
     * @param aggregateFunction
     *            aggregateFunction
     * @param asName
     *            asName
     * @return sql
     */
    default String buildColumnSql(String columnName, String tableAlias,
            AggregateFunction aggregateFunction, String asName) {
        String column = columnName;
        if (!Chars.STAR.equals(columnName)) {
            column = wrapName(convertTableOrColumnName(columnName));
        }
        if (LangUtils.isNotEmpty(tableAlias)
                && !Chars.STAR.equals(columnName)) {
            column = tableAlias + Chars.DOT + column;
        }
        if (aggregateFunction != null) {
            switch (aggregateFunction) {
            case DISTINCT:
                column = getFunction(aggregateFunction) + Chars.SPACE + column;
                break;
            default:
                column = getFunction(aggregateFunction) + Chars.PAREN_L + column
                        + Chars.PAREN_R;
            }
        }
        if (LangUtils.isNotEmpty(asName)) {
            column = column + Chars.SPACE + wrapName(asName);
        }
        return column;
    }

    /**
     * build sql for column with tableAlias and aggregate function
     *
     * @param columnName
     *            columnName
     * @param tableAlias
     *            tableAlias
     * @param function
     *            function
     * @return sql
     */
    default String buildColumnSql(String columnName, String tableAlias,
            Function function) {
        if (function instanceof AggregateFunction) {
            return buildColumnSql(columnName, tableAlias,
                    (AggregateFunction) function);
        }
        // TODO 后续添加其他实现
        throw new BuilderException("只实现了 AggregateFunction");
    }
}