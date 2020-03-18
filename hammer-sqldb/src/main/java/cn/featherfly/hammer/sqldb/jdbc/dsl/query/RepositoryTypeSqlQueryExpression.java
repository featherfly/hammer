
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LambdaUtils.SerializedLambdaInfo;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.hammer.dml.AliasManager;
import cn.featherfly.hammer.dsl.query.RepositoryTypeQueryConditionGroupExpression;
import cn.featherfly.hammer.dsl.query.RepositoryTypeQueryConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.condition.property.DateExpression;
import cn.featherfly.hammer.expression.condition.property.EnumExpression;
import cn.featherfly.hammer.expression.condition.property.NumberExpression;
import cn.featherfly.hammer.expression.condition.property.ObjectExpression;
import cn.featherfly.hammer.expression.condition.property.RepositorySimpleDateExpression;
import cn.featherfly.hammer.expression.condition.property.RepositorySimpleEnumExpression;
import cn.featherfly.hammer.expression.condition.property.RepositorySimpleNumberExpression;
import cn.featherfly.hammer.expression.condition.property.RepositorySimpleObjectExpression;
import cn.featherfly.hammer.expression.condition.property.RepositorySimpleStringExpression;
import cn.featherfly.hammer.expression.condition.property.StringExpression;
import cn.featherfly.hammer.mapping.ClassMapping;
import cn.featherfly.hammer.mapping.MappingFactory;
import cn.featherfly.hammer.operator.QueryOperator;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.mapping.ClassMappingUtils;
import cn.featherfly.hammer.sqldb.sql.dml.SqlConditionExpressionBuilder;
import cn.featherfly.hammer.sqldb.sql.dml.builder.basic.SqlSelectBasicBuilder;

/**
 * <p>
 * SqlDeleteExpression
 * </p>
 * .
 *
 * @author zhongj
 */
public class RepositoryTypeSqlQueryExpression extends RepositoryTypeSqlQueryConditionGroupExpression {

    private SqlSelectBasicBuilder selectBuilder;

    /**
     * Instantiates a new sql query expression.
     *
     * @param jdbc          the jdbc
     * @param factory       MappingFactory
     * @param aliasManager  aliasManager
     * @param classMapping  the class mapping
     * @param selectBuilder the select builder
     */
    public RepositoryTypeSqlQueryExpression(Jdbc jdbc, MappingFactory factory, AliasManager aliasManager,
            ClassMapping<?> classMapping, SqlSelectBasicBuilder selectBuilder) {
        super(jdbc, factory, aliasManager, selectBuilder.getTableAlias(), classMapping);
        this.selectBuilder = selectBuilder;
    }

    /**
     * @param jdbc
     * @param factory      MappingFactory
     * @param aliasManager aliasManager
     * @param parent
     * @param queryAlias
     * @param classMapping
     */
    RepositoryTypeSqlQueryExpression(Jdbc jdbc, MappingFactory factory, AliasManager aliasManager,
            RepositoryTypeQueryConditionGroupLogicExpression parent, String queryAlias, ClassMapping<?> classMapping) {
        super(jdbc, factory, aliasManager, parent, queryAlias, classMapping);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryTypeSqlQueryConditionGroupExpression createGroup(
            RepositoryTypeQueryConditionGroupLogicExpression parent, String queryAlias) {
        selectBuilder.setTableAlias(queryAlias);
        return new RepositoryTypeSqlQueryExpression(jdbc, factory, aliasManager, parent, queryAlias, classMapping);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String build() {
        String result = "";
        if (selectBuilder != null) {
            result = selectBuilder.build();
        }
        String condition = super.build();
        if (LangUtils.isNotEmpty(condition)) {
            result = result + Chars.SPACE + condition;
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositoryTypeQueryConditionGroupLogicExpression eq(SerializableFunction<T, R> name, Object value) {
        return addCondition(name, value, QueryOperator.EQ);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositoryTypeQueryConditionGroupLogicExpression ne(SerializableFunction<T, R> name, Object value) {
        return addCondition(name, value, QueryOperator.NE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositoryTypeQueryConditionGroupLogicExpression sw(SerializableFunction<T, R> name, String value) {
        return addCondition(name, value, QueryOperator.SW);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositoryTypeQueryConditionGroupLogicExpression ew(SerializableFunction<T, R> name, String value) {
        return addCondition(name, value, QueryOperator.EW);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositoryTypeQueryConditionGroupLogicExpression co(SerializableFunction<T, R> name, String value) {
        return addCondition(name, value, QueryOperator.CO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R, D extends Date> RepositoryTypeQueryConditionGroupLogicExpression ge(SerializableFunction<T, R> name,
            D value) {
        return addCondition(name, value, QueryOperator.GE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositoryTypeQueryConditionGroupLogicExpression ge(SerializableFunction<T, R> name,
            LocalDate value) {
        return addCondition(name, value, QueryOperator.GE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositoryTypeQueryConditionGroupLogicExpression ge(SerializableFunction<T, R> name,
            LocalDateTime value) {
        return addCondition(name, value, QueryOperator.GE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositoryTypeQueryConditionGroupLogicExpression ge(SerializableFunction<T, R> name,
            LocalTime value) {
        return addCondition(name, value, QueryOperator.GE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R, N extends Number> RepositoryTypeQueryConditionGroupLogicExpression ge(SerializableFunction<T, R> name,
            N value) {
        return addCondition(name, value, QueryOperator.GE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositoryTypeQueryConditionGroupLogicExpression ge(SerializableFunction<T, R> name, String value) {
        return addCondition(name, value, QueryOperator.GE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R, D extends Date> RepositoryTypeQueryConditionGroupLogicExpression gt(SerializableFunction<T, R> name,
            D value) {
        return addCondition(name, value, QueryOperator.GT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositoryTypeQueryConditionGroupLogicExpression gt(SerializableFunction<T, R> name,
            LocalDate value) {
        return addCondition(name, value, QueryOperator.GT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositoryTypeQueryConditionGroupLogicExpression gt(SerializableFunction<T, R> name,
            LocalDateTime value) {
        return addCondition(name, value, QueryOperator.GT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositoryTypeQueryConditionGroupLogicExpression gt(SerializableFunction<T, R> name,
            LocalTime value) {
        return addCondition(name, value, QueryOperator.GT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R, N extends Number> RepositoryTypeQueryConditionGroupLogicExpression gt(SerializableFunction<T, R> name,
            N value) {
        return addCondition(name, value, QueryOperator.GT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositoryTypeQueryConditionGroupLogicExpression gt(SerializableFunction<T, R> name, String value) {
        return addCondition(name, value, QueryOperator.GT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositoryTypeQueryConditionGroupLogicExpression in(SerializableFunction<T, R> name, Object value) {
        return addCondition(name, value, QueryOperator.IN);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositoryTypeQueryConditionGroupLogicExpression inn(SerializableFunction<T, R> name) {
        return addCondition(name, null, QueryOperator.INN);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositoryTypeQueryConditionGroupLogicExpression isn(SerializableFunction<T, R> name) {
        return addCondition(name, null, QueryOperator.ISN);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R, D extends Date> RepositoryTypeQueryConditionGroupLogicExpression le(SerializableFunction<T, R> name,
            D value) {
        return addCondition(name, value, QueryOperator.LE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositoryTypeQueryConditionGroupLogicExpression le(SerializableFunction<T, R> name,
            LocalDate value) {
        return addCondition(name, value, QueryOperator.LE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositoryTypeQueryConditionGroupLogicExpression le(SerializableFunction<T, R> name,
            LocalDateTime value) {
        return addCondition(name, value, QueryOperator.LE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositoryTypeQueryConditionGroupLogicExpression le(SerializableFunction<T, R> name,
            LocalTime value) {
        return addCondition(name, value, QueryOperator.LE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R, N extends Number> RepositoryTypeQueryConditionGroupLogicExpression le(SerializableFunction<T, R> name,
            N value) {
        return addCondition(name, value, QueryOperator.LE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositoryTypeQueryConditionGroupLogicExpression le(SerializableFunction<T, R> name, String value) {
        return addCondition(name, value, QueryOperator.LE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R, D extends Date> RepositoryTypeQueryConditionGroupLogicExpression lt(SerializableFunction<T, R> name,
            D value) {
        return addCondition(name, value, QueryOperator.LT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositoryTypeQueryConditionGroupLogicExpression lt(SerializableFunction<T, R> name,
            LocalDate value) {
        return addCondition(name, value, QueryOperator.LT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositoryTypeQueryConditionGroupLogicExpression lt(SerializableFunction<T, R> name,
            LocalDateTime value) {
        return addCondition(name, value, QueryOperator.LT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositoryTypeQueryConditionGroupLogicExpression lt(SerializableFunction<T, R> name,
            LocalTime value) {
        return addCondition(name, value, QueryOperator.LT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R, N extends Number> RepositoryTypeQueryConditionGroupLogicExpression lt(SerializableFunction<T, R> name,
            N value) {
        return addCondition(name, value, QueryOperator.LT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositoryTypeQueryConditionGroupLogicExpression lt(SerializableFunction<T, R> name, String value) {
        return addCondition(name, value, QueryOperator.LT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositoryTypeQueryConditionGroupLogicExpression nin(SerializableFunction<T, R> name, Object value) {
        return addCondition(name, value, QueryOperator.NIN);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T,
            R> ObjectExpression<RepositoryTypeQueryConditionGroupExpression, RepositoryTypeQueryConditionGroupLogicExpression> property(
                    SerializableFunction<T, R> name) {
        Tuple2<String, String> tableNameAndColumnName = getTableAliasAndColumnName(name);
        return new RepositorySimpleObjectExpression<>(tableNameAndColumnName.get0(), tableNameAndColumnName.get1(),
                this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> StringExpression<RepositoryTypeQueryConditionGroupExpression, RepositoryTypeQueryConditionGroupLogicExpression> propertyString(
            SerializableFunction<T, String> name) {
        Tuple2<String, String> tableNameAndColumnName = getTableAliasAndColumnName(name);
        return new RepositorySimpleStringExpression<>(tableNameAndColumnName.get0(), tableNameAndColumnName.get1(),
                this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T,
            R extends Date> DateExpression<RepositoryTypeQueryConditionGroupExpression, RepositoryTypeQueryConditionGroupLogicExpression> propertyDate(
                    SerializableFunction<T, R> name) {
        Tuple2<String, String> tableNameAndColumnName = getTableAliasAndColumnName(name);
        return new RepositorySimpleDateExpression<>(tableNameAndColumnName.get0(), tableNameAndColumnName.get1(), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T,
            R extends Enum<?>> EnumExpression<RepositoryTypeQueryConditionGroupExpression, RepositoryTypeQueryConditionGroupLogicExpression> propertyEnum(
                    SerializableFunction<T, R> name) {
        Tuple2<String, String> tableNameAndColumnName = getTableAliasAndColumnName(name);
        return new RepositorySimpleEnumExpression<>(tableNameAndColumnName.get0(), tableNameAndColumnName.get1(), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T,
            R extends Number> NumberExpression<RepositoryTypeQueryConditionGroupExpression, RepositoryTypeQueryConditionGroupLogicExpression> propertyNumber(
                    SerializableFunction<T, R> name) {
        Tuple2<String, String> tableNameAndColumnName = getTableAliasAndColumnName(name);
        return new RepositorySimpleNumberExpression<>(tableNameAndColumnName.get0(), tableNameAndColumnName.get1(),
                this);
    }

    // ***********************************************************************************

    private <T, R> RepositoryTypeQueryConditionGroupLogicExpression addCondition(SerializableFunction<T, R> name,
            Object value, QueryOperator queryOperator) {
        Tuple2<String, String> tableNameAndColumnName = getTableAliasAndColumnName(name);
        return (RepositoryTypeQueryConditionGroupLogicExpression) addCondition(
                new SqlConditionExpressionBuilder(dialect, tableNameAndColumnName.get1(), value, queryOperator,
                        aliasManager.getAlias(tableNameAndColumnName.get0())));
    }

    private <T, R> Tuple2<String, String> getTableAliasAndColumnName(SerializableFunction<T, R> name) {
        SerializedLambdaInfo joinInfo = LambdaUtils.getLambdaInfo(name);
        String propertyName = joinInfo.getPropertyName();
        String tableName = factory.getClassMapping(ClassUtils.forName(joinInfo.getMethodInstanceClassName()))
                .getRepositoryName();
        return Tuples.of(tableName, ClassMappingUtils.getColumnName(propertyName, classMapping));
    }

}
