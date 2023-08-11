//
//package cn.featherfly.hammer.sqldb.jdbc.dsl.query;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.util.Date;
//import java.util.function.Predicate;
//
//import com.speedment.common.tuple.Tuple2;
//import com.speedment.common.tuple.Tuples;
//
//import cn.featherfly.common.constant.Chars;
//import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
//import cn.featherfly.common.db.mapping.ClassMappingUtils;
//import cn.featherfly.common.db.mapping.JdbcClassMapping;
//import cn.featherfly.common.db.mapping.JdbcMappingFactory;
//import cn.featherfly.common.lang.ClassUtils;
//import cn.featherfly.common.lang.LambdaUtils;
//import cn.featherfly.common.lang.LambdaUtils.SerializedLambdaInfo;
//import cn.featherfly.common.lang.Lang;
//import cn.featherfly.common.lang.function.SerializableToDateFunction;
//import cn.featherfly.common.lang.function.SerializableToLocalDateFunction;
//import cn.featherfly.common.lang.function.SerializableToLocalDateTimeFunction;
//import cn.featherfly.common.lang.function.SerializableToLocalTimeFunction;
//import cn.featherfly.common.lang.function.SerializableToNumberFunction;
//import cn.featherfly.common.lang.function.SerializableToStringFunction;
//import cn.featherfly.common.lang.function.SerializableFunction;
//import cn.featherfly.common.operator.QueryOperator;
//import cn.featherfly.common.repository.builder.AliasManager;
//import cn.featherfly.hammer.dsl.query.RepositoryTypeQueryConditionGroupExpression;
//import cn.featherfly.hammer.dsl.query.RepositoryTypeQueryConditionGroupLogicExpression;
//import cn.featherfly.hammer.expression.condition.property.ObjectExpression;
//import cn.featherfly.hammer.expression.condition.property.RepositorySimpleObjectExpression;
//import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
//import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
//import cn.featherfly.hammer.sqldb.sql.dml.SqlConditionExpressionBuilder;
//
///**
// * SqlDeleteExpression .
// *
// * @author zhongj
// */
//public class RepositoryTypeSqlQueryExpression extends RepositoryTypeSqlQueryConditionGroupExpression {
//
//    private SqlSelectBasicBuilder selectBuilder;
//
//    /**
//     * Instantiates a new sql query expression.
//     *
//     * @param jdbc           the jdbc
//     * @param factory        MappingFactory
//     * @param sqlPageFactory the sql page factory
//     * @param aliasManager   aliasManager
//     * @param classMapping   the class mapping
//     * @param selectBuilder  the select builder
//     * @param ignoreStrategy   the ignore strategy
//     */
//    public RepositoryTypeSqlQueryExpression(Jdbc jdbc, JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
//            AliasManager aliasManager, JdbcClassMapping<?> classMapping, SqlSelectBasicBuilder selectBuilder,
//            Predicate<Object> ignoreStrategy) {
//        //        super(jdbc, factory, aliasManager, selectBuilder.getTableAlias(), sqlPageFactory, classMapping, ignoreStrategy);
//        super(jdbc, factory, aliasManager, "", sqlPageFactory, classMapping, ignoreStrategy);
//        this.selectBuilder = selectBuilder;
//    }
//
//    /**
//     * Instantiates a new repository type sql query expression.
//     *
//     * @param parent         the parent
//     * @param jdbc           the jdbc
//     * @param factory        MappingFactory
//     * @param aliasManager   aliasManager
//     * @param queryAlias     the query alias
//     * @param sqlPageFactory the sql page factory
//     * @param classMapping   the class mapping
//     * @param ignoreStrategy   the ignore strategy
//     */
//    RepositoryTypeSqlQueryExpression(RepositoryTypeQueryConditionGroupLogicExpression parent, Jdbc jdbc,
//            JdbcMappingFactory factory, AliasManager aliasManager, String queryAlias, SqlPageFactory sqlPageFactory,
//            JdbcClassMapping<?> classMapping, Predicate<Object> ignoreStrategy) {
//        super(parent, jdbc, factory, aliasManager, queryAlias, sqlPageFactory, classMapping, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    protected RepositoryTypeSqlQueryConditionGroupExpression createGroup(
//            RepositoryTypeQueryConditionGroupLogicExpression parent, String queryAlias) {
//        //        selectBuilder.setTableAlias(queryAlias);
//        return new RepositoryTypeSqlQueryExpression(parent, jdbc, factory, aliasManager, queryAlias, sqlPageFactory,
//                classMapping, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public String build() {
//        String result = "";
//        if (selectBuilder != null) {
//            result = selectBuilder.build();
//        }
//        String condition = super.build();
//        if (Lang.isNotEmpty(condition)) {
//            result = result + Chars.SPACE + condition;
//        }
//        return result;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T, R> RepositoryTypeQueryConditionGroupLogicExpression eq(SerializableFunction<T, R> name, R value) {
//        return addCondition(name, value, QueryOperator.EQ);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T, R> RepositoryTypeQueryConditionGroupLogicExpression ne(SerializableFunction<T, R> name, R value) {
//        return addCondition(name, value, QueryOperator.NE);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T> RepositoryTypeQueryConditionGroupLogicExpression sw(SerializableToStringFunction<T> name, String value) {
//        return addCondition(name, value, QueryOperator.SW);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T> RepositoryTypeQueryConditionGroupLogicExpression ew(SerializableToStringFunction<T> name, String value) {
//        return addCondition(name, value, QueryOperator.EW);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T> RepositoryTypeQueryConditionGroupLogicExpression co(SerializableToStringFunction<T> name, String value) {
//        return addCondition(name, value, QueryOperator.CO);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T, D extends Date> RepositoryTypeQueryConditionGroupLogicExpression ge(SerializableToDateFunction<T, D> name,
//            D value) {
//        return addCondition(name, value, QueryOperator.GE);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T> RepositoryTypeQueryConditionGroupLogicExpression ge(SerializableToLocalDateFunction<T> name, LocalDate value) {
//        return addCondition(name, value, QueryOperator.GE);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T> RepositoryTypeQueryConditionGroupLogicExpression ge(SerializableToLocalDateTimeFunction<T> name,
//            LocalDateTime value) {
//        return addCondition(name, value, QueryOperator.GE);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T> RepositoryTypeQueryConditionGroupLogicExpression ge(SerializableToLocalTimeFunction<T> name, LocalTime value) {
//        return addCondition(name, value, QueryOperator.GE);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T, N extends Number> RepositoryTypeQueryConditionGroupLogicExpression ge(SerializableToNumberFunction<T, N> name,
//            N value) {
//        return addCondition(name, value, QueryOperator.GE);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T> RepositoryTypeQueryConditionGroupLogicExpression ge(SerializableToStringFunction<T> name, String value) {
//        return addCondition(name, value, QueryOperator.GE);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T, D extends Date> RepositoryTypeQueryConditionGroupLogicExpression gt(SerializableToDateFunction<T, D> name,
//            D value) {
//        return addCondition(name, value, QueryOperator.GT);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T> RepositoryTypeQueryConditionGroupLogicExpression gt(SerializableToLocalDateFunction<T> name, LocalDate value) {
//        return addCondition(name, value, QueryOperator.GT);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T> RepositoryTypeQueryConditionGroupLogicExpression gt(SerializableToLocalDateTimeFunction<T> name,
//            LocalDateTime value) {
//        return addCondition(name, value, QueryOperator.GT);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T> RepositoryTypeQueryConditionGroupLogicExpression gt(SerializableToLocalTimeFunction<T> name, LocalTime value) {
//        return addCondition(name, value, QueryOperator.GT);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T, N extends Number> RepositoryTypeQueryConditionGroupLogicExpression gt(SerializableToNumberFunction<T, N> name,
//            N value) {
//        return addCondition(name, value, QueryOperator.GT);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T> RepositoryTypeQueryConditionGroupLogicExpression gt(SerializableToStringFunction<T> name, String value) {
//        return addCondition(name, value, QueryOperator.GT);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T, R> RepositoryTypeQueryConditionGroupLogicExpression in(SerializableFunction<T, R> name, Object value) {
//        return addCondition(name, value, QueryOperator.IN);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T, R> RepositoryTypeQueryConditionGroupLogicExpression inn(SerializableFunction<T, R> name) {
//        return inn(name, true);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T, R> RepositoryTypeQueryConditionGroupLogicExpression inn(SerializableFunction<T, R> name, Boolean value) {
//        return addCondition(name, value, QueryOperator.INN);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T, R> RepositoryTypeQueryConditionGroupLogicExpression isn(SerializableFunction<T, R> name) {
//        return isn(name, true);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T, R> RepositoryTypeQueryConditionGroupLogicExpression isn(SerializableFunction<T, R> name, Boolean value) {
//        return addCondition(name, value, QueryOperator.ISN);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T, D extends Date> RepositoryTypeQueryConditionGroupLogicExpression le(SerializableToDateFunction<T, D> name,
//            D value) {
//        return addCondition(name, value, QueryOperator.LE);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T> RepositoryTypeQueryConditionGroupLogicExpression le(SerializableToLocalDateFunction<T> name, LocalDate value) {
//        return addCondition(name, value, QueryOperator.LE);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T> RepositoryTypeQueryConditionGroupLogicExpression le(SerializableToLocalDateTimeFunction<T> name,
//            LocalDateTime value) {
//        return addCondition(name, value, QueryOperator.LE);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T> RepositoryTypeQueryConditionGroupLogicExpression le(SerializableToLocalTimeFunction<T> name, LocalTime value) {
//        return addCondition(name, value, QueryOperator.LE);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T, N extends Number> RepositoryTypeQueryConditionGroupLogicExpression le(SerializableToNumberFunction<T, N> name,
//            N value) {
//        return addCondition(name, value, QueryOperator.LE);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T> RepositoryTypeQueryConditionGroupLogicExpression le(SerializableToStringFunction<T> name, String value) {
//        return addCondition(name, value, QueryOperator.LE);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T, D extends Date> RepositoryTypeQueryConditionGroupLogicExpression lt(SerializableToDateFunction<T, D> name,
//            D value) {
//        return addCondition(name, value, QueryOperator.LT);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T> RepositoryTypeQueryConditionGroupLogicExpression lt(SerializableToLocalDateFunction<T> name, LocalDate value) {
//        return addCondition(name, value, QueryOperator.LT);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T> RepositoryTypeQueryConditionGroupLogicExpression lt(SerializableToLocalDateTimeFunction<T> name,
//            LocalDateTime value) {
//        return addCondition(name, value, QueryOperator.LT);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T> RepositoryTypeQueryConditionGroupLogicExpression lt(SerializableToLocalTimeFunction<T> name, LocalTime value) {
//        return addCondition(name, value, QueryOperator.LT);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T, N extends Number> RepositoryTypeQueryConditionGroupLogicExpression lt(SerializableToNumberFunction<T, N> name,
//            N value) {
//        return addCondition(name, value, QueryOperator.LT);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T> RepositoryTypeQueryConditionGroupLogicExpression lt(SerializableToStringFunction<T> name, String value) {
//        return addCondition(name, value, QueryOperator.LT);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T, R> RepositoryTypeQueryConditionGroupLogicExpression nin(SerializableFunction<T, R> name, Object value) {
//        return addCondition(name, value, QueryOperator.NIN);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T,
//            R> ObjectExpression<RepositoryTypeQueryConditionGroupExpression, RepositoryTypeQueryConditionGroupLogicExpression> property(
//                    SerializableFunction<T, R> name) {
//        Tuple2<String, String> tableNameAndColumnName = getTableAliasAndColumnName(name);
//        return new RepositorySimpleObjectExpression<>(tableNameAndColumnName.get0(), tableNameAndColumnName.get1(),
//                this);
//    }
//
//    // ***********************************************************************************
//
//    private <T, R> RepositoryTypeQueryConditionGroupLogicExpression addCondition(SerializableFunction<T, R> name,
//            Object value, QueryOperator queryOperator) {
//        Tuple2<String, String> tableNameAndColumnName = getTableAliasAndColumnName(name);
//        return (RepositoryTypeQueryConditionGroupLogicExpression) addCondition(
//                new SqlConditionExpressionBuilder(dialect, tableNameAndColumnName.get1(), value, queryOperator,
//                        aliasManager.getAlias(tableNameAndColumnName.get0()), ignoreStrategy));
//    }
//
//    private <T, R> Tuple2<String, String> getTableAliasAndColumnName(SerializableFunction<T, R> name) {
//        SerializedLambdaInfo joinInfo = LambdaUtils.getLambdaInfo(name);
//        String propertyName = joinInfo.getPropertyName();
//        String tableName = factory.getClassMapping(ClassUtils.forName(joinInfo.getMethodInstanceClassName()))
//                .getRepositoryName();
//        return Tuples.of(tableName, ClassMappingUtils.getColumnName(propertyName, classMapping));
//    }
//
//}
