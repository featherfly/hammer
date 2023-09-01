//
//package cn.featherfly.hammer.sqldb.jdbc.dsl.query;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.function.Consumer;
//import java.util.function.Predicate;
//
//import cn.featherfly.common.lang.ClassUtils;
//import cn.featherfly.common.lang.LambdaUtils;
//import cn.featherfly.common.lang.LambdaUtils.SerializedLambdaInfo;
//import cn.featherfly.common.function.serializable.SerializableFunction;
//import cn.featherfly.common.function.serializable.SerializableSupplier;
//import cn.featherfly.common.repository.builder.AliasManager;
//import cn.featherfly.common.repository.mapping.ClassMapping;
//import cn.featherfly.common.repository.mapping.MappingFactory;
//import cn.featherfly.common.repository.mapping.PropertyMapping;
//import cn.featherfly.common.structure.page.Page;
//import cn.featherfly.hammer.dsl.query.TypeQueryConditionGroupExpression;
//import cn.featherfly.hammer.dsl.query.TypeQueryEntityProperties;
//import cn.featherfly.hammer.dsl.query.TypeQueryWithEntity;
//import cn.featherfly.hammer.expression.condition.ConditionGroupConfig;
//import cn.featherfly.hammer.expression.query.TypeQueryLimitExecutor;
//import cn.featherfly.hammer.sqldb.SqldbHammerException;
//import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
//import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
//
///**
// * <p>
// * SqlQueryProperties
// * </p>
// * .
// *
// * @author zhongj
// */
//public class TypeSqlQueryEntityProperties extends AbstractSqlQueryEntityProperties<TypeSqlQueryEntityProperties>
//        implements TypeSqlQueryEntity, TypeQueryEntityProperties {
//
//    /** The type sql query withs. */
//    List<TypeSqlQueryWith> typeSqlQueryWiths = new ArrayList<>();
//
//    /**
//     * Instantiates a new type sql query entity properties.
//     *
//     * @param jdbc           jdbc
//     * @param classMapping   classMapping
//     * @param factory        the factory
//     * @param sqlPageFactory the sql page factory
//     * @param aliasManager   aliasManager
//     * @param ignoreStrategy   the ignore strategy
//     */
//    public TypeSqlQueryEntityProperties(Jdbc jdbc, JdbcClassMapping<?> classMapping, JdbcMappingFactory factory,
//            SqlPageFactory sqlPageFactory, AliasManager aliasManager, Predicate<Object> ignoreStrategy) {
//        super(jdbc, classMapping, factory, sqlPageFactory, aliasManager, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public TypeQueryConditionGroupExpression where() {
//        return new TypeSqlQueryExpression(jdbc, classMapping, this, factory, sqlPageFactory, aliasManager,
//                selectBuilder, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public TypeQueryConditionGroupExpression where(
//            Consumer<ConditionGroupConfig<TypeQueryConditionGroupExpression>> consumer) {
//        TypeSqlQueryExpression typeSqlQueryExpression = new TypeSqlQueryExpression(jdbc, classMapping, this, factory,
//                sqlPageFactory, aliasManager, selectBuilder, ignoreStrategy);
//        if (consumer != null) {
//            consumer.accept(typeSqlQueryExpression);
//        }
//        return typeSqlQueryExpression;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <E> List<E> list() {
//        return new TypeSqlQueryExpression(jdbc, classMapping, this, factory, sqlPageFactory, aliasManager,
//                selectBuilder, ignoreStrategy).list();
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public TypeQueryLimitExecutor limit(Integer limit) {
//        return new TypeSqlQueryExpression(jdbc, classMapping, this, factory, sqlPageFactory, aliasManager,
//                selectBuilder, ignoreStrategy).limit(limit);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public TypeQueryLimitExecutor limit(Integer offset, Integer limit) {
//        return new TypeSqlQueryExpression(jdbc, classMapping, this, factory, sqlPageFactory, aliasManager,
//                selectBuilder, ignoreStrategy).limit(offset, limit);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public TypeQueryLimitExecutor limit(Page page) {
//        return new TypeSqlQueryExpression(jdbc, classMapping, this, factory, sqlPageFactory, aliasManager,
//                selectBuilder, ignoreStrategy).limit(page);
//    }
//
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //    @Override
//    //    public Long count() {
//    //        return new SqlQueryExpression(jdbc, sqlPageFactory, classMapping,
//    //                selectBuilder.addColumn(Chars.STAR, AggregateFunction.COUNT), ignoreStrategy).longInt();
//    //    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T> TypeQueryWithEntity with(SerializableSupplier<T> propertyName) {
//        SerializedLambdaInfo joinInfo = LambdaUtils.getLambdaInfo(propertyName);
//        return with(joinInfo);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T, R> TypeQueryWithEntity with(SerializableFunction<T, R> propertyName) {
//        SerializedLambdaInfo joinInfo = LambdaUtils.getLambdaInfo(propertyName);
//        return with(joinInfo);
//    }
//
//    private TypeQueryWithEntity with(SerializedLambdaInfo joinInfo) {
//        TypeSqlQueryWith typeSqlQueryWith = with(classMapping, selectBuilder.getTableAlias(), joinInfo);
//        if (typeSqlQueryWith != null) {
//            return typeSqlQueryWith;
//        }
//
//        for (TypeSqlQueryWith with : typeSqlQueryWiths) {
//            if (classMapping != with.joinTypeClassMapping) {
//                typeSqlQueryWith = with(with.joinTypeClassMapping, with.joinTableAlias, joinInfo);
//                if (typeSqlQueryWith != null) {
//                    return typeSqlQueryWith;
//                }
//            }
//            if (classMapping != with.conditionTypeClassMapping) {
//                typeSqlQueryWith = with(with.conditionTypeClassMapping, with.conditionTableAlias, joinInfo);
//                if (typeSqlQueryWith != null) {
//                    return typeSqlQueryWith;
//                }
//            }
//        }
//        throw new SqldbHammerException("there is no relation find for lambda property -> "
//                + joinInfo.getMethodInstanceClassName() + "." + joinInfo.getMethodName());
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T, R> TypeQueryWithEntity with(SerializableFunction<T, R> propertyName, int index) {
//        if (index <= 0) {
//            throw new SqldbHammerException("index must > 0");
//        }
//        if (index > typeSqlQueryWiths.size()) {
//            throw new SqldbHammerException("index must < invoke with method times");
//        }
//        SerializedLambdaInfo joinInfo = LambdaUtils.getLambdaInfo(propertyName);
//        TypeSqlQueryWith with = typeSqlQueryWiths.get(index - 1);
//        return with(with.joinTypeClassMapping, with.joinTableAlias, joinInfo);
//    }
//
//    private TypeSqlQueryWith with(JdbcClassMapping<?> cm, String tableAlias, SerializedLambdaInfo joinInfo) {
//        String name = joinInfo.getPropertyName();
//        if (cm.getType().getName().equals(joinInfo.getMethodInstanceClassName())) {
//            // 表示是查找对象的属性，可以连表查询，也可以查询返回到查询对象的指定属性上
//            JdbcClassMapping<?> joinClassMapping = factory.getClassMapping(joinInfo.getPropertyType());
//            PropertyMapping pm = cm.getPropertyMapping(name);
//            TypeSqlQueryWith typeSqlQueryWith = new TypeSqlQueryWith(this, aliasManager, factory, sqlPageFactory, cm,
//                    tableAlias, pm.getRepositoryFieldName(), joinClassMapping,
//                    getPkMapping(joinClassMapping).getRepositoryFieldName(), name, ignoreStrategy);
//            typeSqlQueryWiths.add(typeSqlQueryWith);
//            return typeSqlQueryWith;
//        } else if (ClassUtils.isParent(cm.getType(), joinInfo.getPropertyType())) {
//            // 表示是查找对象是with对象的属性，可以进行连表查询，但是不能返回到查询对象上，因为没有指明返回对象属性
//            JdbcClassMapping<?> joinClassMapping = factory
//                    .getClassMapping(ClassUtils.forName(joinInfo.getMethodInstanceClassName()));
//            PropertyMapping pm = joinClassMapping.getPropertyMapping(name);
//
//            TypeSqlQueryWith typeSqlQueryWith = new TypeSqlQueryWith(this, aliasManager, factory, sqlPageFactory, cm,
//                    tableAlias, getIdName(), joinClassMapping, pm.getRepositoryFieldName(), ignoreStrategy);
//            typeSqlQueryWiths.add(typeSqlQueryWith);
//            return typeSqlQueryWith;
//        } else {
//            return null;
//        }
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    protected String getIdName() {
//        return getPkMapping(classMapping).getRepositoryFieldName();
//    }
//
//    private PropertyMapping getPkMapping(JdbcClassMapping<?> classMapping) {
//        if (classMapping.getPrivaryKeyPropertyMappings().size() > 1) {
//            throw new SqldbHammerException(String.format("there is more than one privary key property in type(%s)",
//                    classMapping.getType().getName()));
//        } else if (classMapping.getPrivaryKeyPropertyMappings().size() == 0) {
//            throw new SqldbHammerException(
//                    String.format("there is no privary key property in type(%s)", classMapping.getType().getName()));
//        }
//        return classMapping.getPrivaryKeyPropertyMappings().get(0);
//    }
//}
