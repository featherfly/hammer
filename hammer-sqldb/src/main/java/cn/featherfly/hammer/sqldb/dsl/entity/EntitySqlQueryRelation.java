
package cn.featherfly.hammer.sqldb.dsl.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

import org.apache.commons.lang3.ArrayUtils;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuple3;
import com.speedment.common.tuple.Tuple4;
import com.speedment.common.tuple.Tuple5;
import com.speedment.common.tuple.Tuple6;
import com.speedment.common.tuple.Tuple7;
import com.speedment.common.tuple.Tuple8;
import com.speedment.common.tuple.Tuple9;

import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectJoinOnBasicBuilder;
import cn.featherfly.common.db.dialect.Join;
import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.hammer.config.dsl.DslQueryConfig;
import cn.featherfly.hammer.expression.condition.Expression;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.mapper.TupleEntityRowMapper;

/**
 * abstract entity sql query entity properties.
 *
 * @author zhongj
 */
public class EntitySqlQueryRelation extends EntitySqlRelation<EntitySqlQueryRelation, SqlSelectBasicBuilder> {

    /** The select builder. */
    private SqlSelectBasicBuilder selectBuilder;

    private Map<Integer, EntityRelation<?>> entityQueryFetchMapping = new HashMap<>();

    private Set<String> queryFetchAlias = new HashSet<>();

    /**
     * Instantiates a new abstract sql query entity properties.
     *
     * @param jdbc the jdbc
     * @param aliasManager aliasManager
     * @param queryConfig the query config
     */
    public EntitySqlQueryRelation(Jdbc jdbc, AliasManager aliasManager, DslQueryConfig queryConfig) {
        super(jdbc, aliasManager, queryConfig);
    }

    /**
     * add a query mapping.
     *
     * @param classMapping the class mapping
     * @return the entity sql query relation
     */
    public EntitySqlQueryRelation query(JdbcClassMapping<?> classMapping) {
        return addFilterable(classMapping);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> EntitySqlQueryRelation join(JdbcClassMapping<T> joinClassMapping, Supplier<Expression> onExpression) {
        AssertIllegalArgument.isNotNull(joinClassMapping, "joinClassMapping");
        addFilterable(joinClassMapping);
        EntityRelation<?> jerm = getEntityRelation(index - 1);
        SqlSelectJoinOnBasicBuilder selectJoinOnBasicBuilder = getBuilder().join2(joinClassMapping,
            jerm.getTableAlias(), onExpression.get().expression());
        jerm.selectJoinOnBasicBuilder = selectJoinOnBasicBuilder;
        return this;
    }

    /**
     * Join.
     *
     * @param sourceIndex the source index
     * @param propertyName the property name
     * @param joinClassMapping the join class mapping
     * @param joinPropertyName the join property name
     * @param returnType the return type
     * @return the EntitySqlQueryRelation
     */
    @Override
    public EntitySqlQueryRelation join(int sourceIndex, String propertyName, JdbcClassMapping<?> joinClassMapping,
        String joinPropertyName, boolean returnType) {
        AssertIllegalArgument.isNotNull(propertyName, "propertyName");
        AssertIllegalArgument.isNotNull(joinClassMapping, "joinClassMapping");
        AssertIllegalArgument.isNotNull(joinPropertyName, "joinPropertyName");
        EntityRelation<?> erm = getEntityRelation(sourceIndex);
        if (returnType) {
            addFilterable(sourceIndex, propertyName, joinClassMapping, joinPropertyName);
        } else {
            addFilterable(sourceIndex, propertyName, joinClassMapping, joinPropertyName, true);
        }
        //        else if (Lang.isNotEmpty(erm.getFullJoinPropertyName())) {
        //            //            addFilterable(sourceIndex, erm.getJoinFromPropertyName() + "." + propertyName, joinClassMapping,
        //            //                joinPropertyName);
        //            // 因为使用了joinFromPropertyIndexes
        //            addFilterable(sourceIndex, propertyName, joinClassMapping, joinPropertyName, true);
        //        } else {
        //            addFilterable(sourceIndex, propertyName, joinClassMapping, joinPropertyName, true);
        //        }

        // join entity relation
        EntityRelation<?> jerm = getEntityRelation(index - 1);

        String joinRelation = erm.getClassMapping().getType().getSimpleName() + "[" + erm.getTableAlias() + "]."
            + jerm.getJoinFromPropertyName();

        if (returnType || !joinedRelations.contains(joinRelation)) {
            joinedRelations.add(joinRelation);
            SqlSelectJoinOnBasicBuilder selectJoinOnBasicBuilder = join0(erm.getTableAlias(),
                erm.getClassMapping().getPropertyMapping(propertyName).getRepositoryFieldName(), joinClassMapping,
                jerm.getTableAlias(), joinClassMapping.getPropertyMapping(joinPropertyName).getRepositoryFieldName());
            jerm.selectJoinOnBasicBuilder = selectJoinOnBasicBuilder;
        }

        EntityRelation<?> first = getEntityRelation(0);
        if (first.getFetchPropertyMappings().isEmpty()) { // join first time
            for (JdbcPropertyMapping pm : first.getClassMapping().getPropertyMappingLeafNodes()) {
                first.addFetchPropertyMapping(pm.getPropertyIndexes(), pm);
            }
        }
        return this;
    }

    private SqlSelectJoinOnBasicBuilder join0(String tableAlias, String columnName,
        JdbcClassMapping<?> joinClassMapping, String joinTableAlias, String joinTableColumnName) {
        return getBuilder().join(Join.INNER_JOIN, tableAlias, columnName, joinClassMapping, joinTableAlias,
            joinTableColumnName);
    }

    private void fetch(EntityRelation<?> erm) {
        for (JdbcPropertyMapping pm : erm.getClassMapping().getPropertyMappingLeafNodes()) {
            erm.addFetchPropertyMapping(ArrayUtils.addAll(erm.getJoinFromPropertyIndexes(), pm.getPropertyIndexes()),
                pm);
        }
    }

    /**
     * fetch join.
     *
     * @param index the index
     * @return the entity sql query relation
     */
    public EntitySqlQueryRelation fetch(int index) {
        AssertIllegalArgument.isGe(index, 0, "fetch entity index");
        AssertIllegalArgument.isLt(index, entityFilterableMappingTuple.degree(), "fetch entity index");
        EntityRelation<?> erm = getEntityRelation(index);
        entityQueryFetchMapping.put(entityQueryFetchMapping.size(), erm);
        queryFetchAlias.add(erm.getTableAlias());

        if (index > 0) {
            erm.selectJoinOnBasicBuilder.fetch();
            fetch(erm);
        }

        return this;
    }

    /**
     * Fetch property.
     *
     * @param index the index
     * @return the entity sql query relation
     */
    public EntitySqlQueryRelation fetchProperty(int index) {
        AssertIllegalArgument.isGe(index, 0, "fetch entity index");
        AssertIllegalArgument.isLt(index, entityFilterableMappingTuple.degree(), "fetch entity index");
        EntityRelation<?> erm = getEntityRelation(index);
        queryFetchAlias.add(erm.getTableAlias());
        if (index > 0) {
            // YUFEI_TODO 因为现在join fetch没有做单个property fetch,所以先这样，后续加入fetch property再来处理逻辑
            fetch(erm);
            erm.selectJoinOnBasicBuilder.fetch((prefixTableAlias, alias) -> {
                if (prefixTableAlias) {
                    return erm.getFullJoinPropertyName(prefixTableAlias);
                    //                    EntityRelation<?> ser = erm.getJoinFrom();
                    //                    return ser.getTableAlias() + Chars.DOT_CHAR + ser.getJoinPropertyName();
                } else {
                    return erm.getFullJoinPropertyName();
                }
            });
        }
        return this;
    }

    /**
     * Fetch property.
     *
     * @param index the index
     * @param propertyName the property name
     * @return the entity sql query relation
     */
    public EntitySqlQueryRelation fetchProperty(int index, String propertyName) {
        return fetchProperty(index, false, propertyName);
    }

    /**
     * Fetch property.
     *
     * @param index the index
     * @param distinct the distinct
     * @param propertyName the property name
     * @return the entity sql query relation
     */
    public EntitySqlQueryRelation fetchProperty(int index, boolean distinct, String propertyName) {
        AssertIllegalArgument.isGe(index, 0, "fetch entity index");
        AssertIllegalArgument.isLt(index, entityFilterableMappingTuple.degree(), "fetch entity index");
        EntityRelation<?> erm = getEntityRelation(index);
        queryFetchAlias.add(erm.getTableAlias());
        if (index == 0) {
            Tuple2<String, String> columnAndProperty = ClassMappingUtils.getColumnAndPropertyName(propertyName,
                erm.getClassMapping());
            getBuilder().addColumn(distinct, columnAndProperty.get0(), columnAndProperty.get1());
            JdbcPropertyMapping pm = erm.classMapping.getPropertyMapping(propertyName);
            erm.addFetchPropertyMapping(pm.getPropertyIndexes(), pm);
        } else if (index > 0) {
            Tuple2<String, String> columnAndProperty = ClassMappingUtils.getColumnAndPropertyName(propertyName,
                erm.getClassMapping());
            erm.selectJoinOnBasicBuilder.fetch(distinct, columnAndProperty.get0(), columnAndProperty.get1());

            EntityRelation<?> ser = erm.getJoinFrom();
            for (JdbcPropertyMapping pm : erm.getClassMapping().getPropertyMappingLeafNodes()) {
                ser.addFetchPropertyMapping(
                    ArrayUtils.addAll(ser.getJoinFromPropertyIndexes(), pm.getPropertyIndexes()), pm);
            }
        }
        return this;
    }

    /**
     * Fetch property.
     *
     * @param index the index
     * @param distinct the distinct
     * @param propertyName the property name
     * @return the entity sql query relation
     */
    public EntitySqlQueryRelation fetchProperty(int index, AggregateFunction aggregateFunction, String propertyName) {
        return fetchProperty(index, aggregateFunction, false, propertyName, null);
    }

    /**
     * Fetch property.
     *
     * @param index the index
     * @param distinct the distinct
     * @param propertyName the property name
     * @return the entity sql query relation
     */
    public EntitySqlQueryRelation fetchProperty(int index, AggregateFunction aggregateFunction, String propertyName,
        String alias) {
        return fetchProperty(index, aggregateFunction, false, propertyName, alias);
    }

    /**
     * Fetch property.
     *
     * @param index the index
     * @param distinct the distinct
     * @param propertyName the property name
     * @return the entity sql query relation
     */
    public EntitySqlQueryRelation fetchProperty(int index, AggregateFunction aggregateFunction, boolean distinct,
        String propertyName) {
        return fetchProperty(index, aggregateFunction, distinct, propertyName, null);
    }

    /**
     * Fetch property.
     *
     * @param index the index
     * @param distinct the distinct
     * @param propertyName the property name
     * @return the entity sql query relation
     */
    public EntitySqlQueryRelation fetchProperty(int index, AggregateFunction aggregateFunction, boolean distinct,
        String propertyName, String alias) {
        AssertIllegalArgument.isGe(index, 0, "fetch entity index");
        AssertIllegalArgument.isLt(index, entityFilterableMappingTuple.degree(), "fetch entity index");
        EntityRelation<?> erm = getEntityRelation(index);
        queryFetchAlias.add(erm.getTableAlias());
        if (index == 0) {
            Tuple2<String, String> columnAndProperty = ClassMappingUtils.getColumnAndPropertyName(propertyName,
                erm.getClassMapping());
            alias = Lang.ifEmpty(alias, columnAndProperty.get1());
            getBuilder().addColumn(aggregateFunction, distinct, columnAndProperty.get0(), columnAndProperty.get1());
            JdbcPropertyMapping pm = erm.classMapping.getPropertyMapping(propertyName);
            erm.addFetchPropertyMapping(pm.getPropertyIndexes(), pm);
        } else if (index > 0) {
            Tuple2<String, String> columnAndProperty = ClassMappingUtils.getColumnAndPropertyName(propertyName,
                erm.getClassMapping());
            erm.selectJoinOnBasicBuilder.fetch(aggregateFunction, distinct, columnAndProperty.get0(),
                columnAndProperty.get1());

            EntityRelation<?> ser = erm.getJoinFrom();
            for (JdbcPropertyMapping pm : erm.getClassMapping().getPropertyMappingLeafNodes()) {
                ser.addFetchPropertyMapping(
                    ArrayUtils.addAll(ser.getJoinFromPropertyIndexes(), pm.getPropertyIndexes()), pm);
            }
        }
        return this;
    }

    /**
     * Checks if is return tuple.
     *
     * @return true, if is return tuple
     */
    public boolean isReturnTuple() {
        return entityQueryFetchMapping.size() > 1;
    }

    /**
     * Gets the result type.
     *
     * @return the result type
     */
    public Class<?> getResultType() {
        switch (entityQueryFetchMapping.size()) {
            case 1:
                return entityFilterableMappingTuple.getOrNull0().getClassMapping().getType();
            case 2:
                return Tuple2.class;
            case 3:
                return Tuple3.class;
            case 4:
                return Tuple4.class;
            case 5:
                return Tuple5.class;
            case 6:
                return Tuple6.class;
            case 7:
                return Tuple7.class;
            case 8:
                return Tuple8.class;
            case 9:
                return Tuple9.class;
            default:
                throw new SqldbHammerException("entity query fetch times must be 1-9");
        }
    }

    /**
     * Builds the select sql.
     *
     * @return the string
     */
    public String buildSelectCountSql() {
        return jdbc.getDialect().getKeywords().select() + " " + jdbc.getDialect().getKeywords().count() + "(*) "
            + jdbc.getDialect().getKeywords().from() + " " + getEntityRelation(0).getClassMapping().getRepositoryName()
            + " " + getEntityRelation(0).getTableAlias();
    }

    /**
     * Builds the select sql.
     *
     * @return the string
     */
    public String buildSelectSql() {
        return buildSelectSql(true);
    }

    /**
     * Builds the select sql.
     *
     * @param withFrom the with from
     * @return the string
     */
    public String buildSelectSql(boolean withFrom) {
        return selectBuilder.setColumnAliasPrefixTableAlias(isReturnTuple())
            .build((tableName, tableAlias) -> queryFetchAlias.contains(tableAlias), withFrom);
    }

    /**
     * Single tuple.
     *
     * @param <R> the generic type
     * @param sql the sql
     * @param params the params
     * @return the r
     */
    @SuppressWarnings("unchecked")
    public <R> R single(String sql, Serializable[] params) {
        switch (entityQueryFetchMapping.size()) {
            case 1:
                return (R) jdbc.querySingle(sql, entityQueryFetchMapping.get(0).getMapper(), params);
            case 2:
                return (R) jdbc.querySingle(sql, new TupleEntityRowMapper<>(entityQueryFetchMapping.get(0).getMapper(),
                    entityQueryFetchMapping.get(1).getMapper()), params);
            case 3:
                return (R) jdbc.querySingle(sql,
                    new TupleEntityRowMapper<>(entityQueryFetchMapping.get(0).getMapper(),
                        entityQueryFetchMapping.get(1).getMapper(), entityQueryFetchMapping.get(2).getMapper()),
                    params);
            case 4:
                return (R) jdbc.querySingle(sql,
                    new TupleEntityRowMapper<>(entityQueryFetchMapping.get(0).getMapper(),
                        entityQueryFetchMapping.get(1).getMapper(), entityQueryFetchMapping.get(2).getMapper(),
                        entityQueryFetchMapping.get(3).getMapper()),
                    params);
            case 5:
                return (R) jdbc.querySingle(sql,
                    new TupleEntityRowMapper<>(entityQueryFetchMapping.get(0).getMapper(),
                        entityQueryFetchMapping.get(1).getMapper(), entityQueryFetchMapping.get(2).getMapper(),
                        entityQueryFetchMapping.get(3).getMapper(), entityQueryFetchMapping.get(4).getMapper()),
                    params);
            case 6:
                return (R) jdbc.querySingle(sql,
                    new TupleEntityRowMapper<>(entityQueryFetchMapping.get(0).getMapper(),
                        entityQueryFetchMapping.get(1).getMapper(), entityQueryFetchMapping.get(2).getMapper(),
                        entityQueryFetchMapping.get(3).getMapper(), entityQueryFetchMapping.get(4).getMapper(),
                        entityQueryFetchMapping.get(5).getMapper()),
                    params);
            default:
                throw new SqldbHammerException("entity query fetch times must be 2-6");
        }
    }

    /**
     * Unique tuple.
     *
     * @param <R> the generic type
     * @param sql the sql
     * @param params the params
     * @return the r
     */
    @SuppressWarnings("unchecked")
    public <R> R unique(String sql, Serializable[] params) {
        switch (entityQueryFetchMapping.size()) {
            case 1:
                return (R) jdbc.queryUnique(sql, entityQueryFetchMapping.get(0).getMapper(), params);
            case 2:
                return (R) jdbc.queryUnique(sql, new TupleEntityRowMapper<>(entityQueryFetchMapping.get(0).getMapper(),
                    entityQueryFetchMapping.get(1).getMapper()), params);
            case 3:
                return (R) jdbc.queryUnique(sql,
                    new TupleEntityRowMapper<>(entityQueryFetchMapping.get(0).getMapper(),
                        entityQueryFetchMapping.get(1).getMapper(), entityQueryFetchMapping.get(2).getMapper()),
                    params);
            case 4:
                return (R) jdbc.queryUnique(sql,
                    new TupleEntityRowMapper<>(entityQueryFetchMapping.get(0).getMapper(),
                        entityQueryFetchMapping.get(1).getMapper(), entityQueryFetchMapping.get(2).getMapper(),
                        entityQueryFetchMapping.get(3).getMapper()),
                    params);
            case 5:
                return (R) jdbc.queryUnique(sql,
                    new TupleEntityRowMapper<>(entityQueryFetchMapping.get(0).getMapper(),
                        entityQueryFetchMapping.get(1).getMapper(), entityQueryFetchMapping.get(2).getMapper(),
                        entityQueryFetchMapping.get(3).getMapper(), entityQueryFetchMapping.get(4).getMapper()),
                    params);
            case 6:
                return (R) jdbc.queryUnique(sql,
                    new TupleEntityRowMapper<>(entityQueryFetchMapping.get(0).getMapper(),
                        entityQueryFetchMapping.get(1).getMapper(), entityQueryFetchMapping.get(2).getMapper(),
                        entityQueryFetchMapping.get(3).getMapper(), entityQueryFetchMapping.get(4).getMapper(),
                        entityQueryFetchMapping.get(5).getMapper()),
                    params);
            default:
                throw new SqldbHammerException("entity query fetch times must be 2-6");
        }
    }

    /**
     * List tuple.
     *
     * @param <R> the generic type
     * @param sql the sql
     * @param params the params
     * @return LogicExpressionist
     */
    @SuppressWarnings("unchecked")
    public <R> List<R> list(String sql, Serializable[] params) {
        switch (entityQueryFetchMapping.size()) {
            case 1:
                return (List<R>) jdbc.queryList(sql, entityQueryFetchMapping.get(0).getMapper(), params);
            case 2:
                return (List<R>) jdbc.queryList(sql, new TupleEntityRowMapper<>(
                    entityQueryFetchMapping.get(0).getMapper(), entityQueryFetchMapping.get(1).getMapper()), params);
            case 3:
                return (List<R>) jdbc.queryList(sql,
                    new TupleEntityRowMapper<>(entityQueryFetchMapping.get(0).getMapper(),
                        entityQueryFetchMapping.get(1).getMapper(), entityQueryFetchMapping.get(2).getMapper()),
                    params);
            case 4:
                return (List<R>) jdbc.queryList(sql,
                    new TupleEntityRowMapper<>(entityQueryFetchMapping.get(0).getMapper(),
                        entityQueryFetchMapping.get(1).getMapper(), entityQueryFetchMapping.get(2).getMapper(),
                        entityQueryFetchMapping.get(3).getMapper()),
                    params);
            case 5:
                return (List<R>) jdbc.queryList(sql,
                    new TupleEntityRowMapper<>(entityQueryFetchMapping.get(0).getMapper(),
                        entityQueryFetchMapping.get(1).getMapper(), entityQueryFetchMapping.get(2).getMapper(),
                        entityQueryFetchMapping.get(3).getMapper(), entityQueryFetchMapping.get(4).getMapper()),
                    params);
            case 6:
                return (List<R>) jdbc.queryList(sql,
                    new TupleEntityRowMapper<>(entityQueryFetchMapping.get(0).getMapper(),
                        entityQueryFetchMapping.get(1).getMapper(), entityQueryFetchMapping.get(2).getMapper(),
                        entityQueryFetchMapping.get(3).getMapper(), entityQueryFetchMapping.get(4).getMapper(),
                        entityQueryFetchMapping.get(5).getMapper()),
                    params);
            default:
                throw new SqldbHammerException("entity query fetch times must be 2-6");
        }
    }

    // ****************************************************************************************************************
    //	protected method
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initBuilder(EntityRelation<?> erm) {
        selectBuilder = new SqlSelectBasicBuilder(jdbc.getDialect(), erm.classMapping, erm.tableAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlSelectBasicBuilder getBuilder() {
        return selectBuilder;
    }

    // ********************************************************************
    //  private method
    // ********************************************************************

    //  private Tuple getFetchAliasTuple() {
    //        switch (entityQueryFetchMapping.size()) {
    //            case 2:
    //                return Tuples.of(entityQueryFetchMapping.get(0).tableAlias, entityQueryFetchMapping.get(1).tableAlias);
    //            case 3:
    //                return Tuples.of(entityQueryFetchMapping.get(0).tableAlias, entityQueryFetchMapping.get(1).tableAlias,
    //                        entityQueryFetchMapping.get(2).tableAlias);
    //            case 4:
    //                return Tuples.of(entityQueryFetchMapping.get(0).tableAlias, entityQueryFetchMapping.get(1).tableAlias,
    //                        entityQueryFetchMapping.get(2).tableAlias, entityQueryFetchMapping.get(3).tableAlias);
    //            case 5:
    //                return Tuples.of(entityQueryFetchMapping.get(0).tableAlias, entityQueryFetchMapping.get(1).tableAlias,
    //                        entityQueryFetchMapping.get(2).tableAlias, entityQueryFetchMapping.get(3).tableAlias,
    //                        entityQueryFetchMapping.get(4).tableAlias);
    //            case 6:
    //                return Tuples.of(entityQueryFetchMapping.get(0).tableAlias, entityQueryFetchMapping.get(1).tableAlias,
    //                        entityQueryFetchMapping.get(2).tableAlias, entityQueryFetchMapping.get(3).tableAlias,
    //                        entityQueryFetchMapping.get(4).tableAlias, entityQueryFetchMapping.get(5).tableAlias);
    //            case 7:
    //                return Tuples.of(entityQueryFetchMapping.get(0).tableAlias, entityQueryFetchMapping.get(1).tableAlias,
    //                        entityQueryFetchMapping.get(2).tableAlias, entityQueryFetchMapping.get(3).tableAlias,
    //                        entityQueryFetchMapping.get(4).tableAlias, entityQueryFetchMapping.get(5).tableAlias,
    //                        entityQueryFetchMapping.get(6).tableAlias);
    //            case 8:
    //                return Tuples.of(entityQueryFetchMapping.get(0).tableAlias, entityQueryFetchMapping.get(1).tableAlias,
    //                        entityQueryFetchMapping.get(2).tableAlias, entityQueryFetchMapping.get(3).tableAlias,
    //                        entityQueryFetchMapping.get(4).tableAlias, entityQueryFetchMapping.get(5).tableAlias,
    //                        entityQueryFetchMapping.get(6).tableAlias, entityQueryFetchMapping.get(7).tableAlias);
    //            case 9:
    //                return Tuples.of(entityQueryFetchMapping.get(0).tableAlias, entityQueryFetchMapping.get(1).tableAlias,
    //                        entityQueryFetchMapping.get(2).tableAlias, entityQueryFetchMapping.get(3).tableAlias,
    //                        entityQueryFetchMapping.get(4).tableAlias, entityQueryFetchMapping.get(5).tableAlias,
    //                        entityQueryFetchMapping.get(6).tableAlias, entityQueryFetchMapping.get(7).tableAlias,
    //                        entityQueryFetchMapping.get(8).tableAlias);
    //            default:
    //                throw new SqldbHammerException("entity query fetch times must be 2-9");
    //        }
    //    }

    //    private Tuple2<String, String> getFetchAliasTuple2() {
    //        if (entityQueryFetchMapping.size() == 2) {
    //            return Tuples.of(entityQueryFetchMapping.get(0).tableAlias + ".",
    //                entityQueryFetchMapping.get(1).tableAlias + ".");
    //        }
    //        throw new SqldbHammerException("entity query fetch times must be 2");
    //    }
    //
    //    private Tuple3<String, String, String> getFetchAliasTuple3() {
    //        if (entityQueryFetchMapping.size() == 3) {
    //            return Tuples.of(entityQueryFetchMapping.get(0).tableAlias + ".",
    //                entityQueryFetchMapping.get(1).tableAlias + ".", entityQueryFetchMapping.get(2).tableAlias + ".");
    //        }
    //        throw new SqldbHammerException("entity query fetch times must be 3");
    //    }
    //
    //    private Tuple4<String, String, String, String> getFetchAliasTuple4() {
    //        if (entityQueryFetchMapping.size() == 4) {
    //            return Tuples.of(entityQueryFetchMapping.get(0).tableAlias + ".",
    //                entityQueryFetchMapping.get(1).tableAlias + ".", entityQueryFetchMapping.get(2).tableAlias + ".",
    //                entityQueryFetchMapping.get(3).tableAlias + ".");
    //        }
    //        throw new SqldbHammerException("entity query fetch times must be 4");
    //    }
    //
    //    private Tuple5<String, String, String, String, String> getFetchAliasTuple5() {
    //        if (entityQueryFetchMapping.size() == 5) {
    //            return Tuples.of(entityQueryFetchMapping.get(0).tableAlias + ".",
    //                entityQueryFetchMapping.get(1).tableAlias + ".", entityQueryFetchMapping.get(2).tableAlias + ".",
    //                entityQueryFetchMapping.get(3).tableAlias + ".", entityQueryFetchMapping.get(4).tableAlias + ".");
    //        }
    //        throw new SqldbHammerException("entity query fetch times must be 5");
    //    }
    //
    //    private Tuple6<String, String, String, String, String, String> getFetchAliasTuple6() {
    //        if (entityQueryFetchMapping.size() == 6) {
    //            return Tuples.of(entityQueryFetchMapping.get(0).tableAlias + ".",
    //                entityQueryFetchMapping.get(1).tableAlias + ".", entityQueryFetchMapping.get(2).tableAlias + ".",
    //                entityQueryFetchMapping.get(3).tableAlias + ".", entityQueryFetchMapping.get(4).tableAlias + ".",
    //                entityQueryFetchMapping.get(5).tableAlias + ".");
    //        }
    //        throw new SqldbHammerException("entity query fetch times must be 6");
    //    }

    //
    //    private Tuple7<String, String, String, String, String, String, String> getFetchAliasTuple7() {
    //        if (entityQueryFetchMapping.size() == 3) {
    //            return Tuples.of(entityQueryFetchMapping.get(0).tableAlias + ".", entityQueryFetchMapping.get(1).tableAlias + ".",
    //                    entityQueryFetchMapping.get(2).tableAlias + ".", entityQueryFetchMapping.get(3).tableAlias + ".",
    //                    entityQueryFetchMapping.get(4).tableAlias + ".", entityQueryFetchMapping.get(5).tableAlias + ".",
    //                    entityQueryFetchMapping.get(6).tableAlias + ".");
    //        }
    //        throw new SqldbHammerException("entity query fetch times must be 7");
    //    }
    //
    //    private Tuple8<String, String, String, String, String, String, String, String> getFetchAliasTuple8() {
    //        if (entityQueryFetchMapping.size() == 3) {
    //            return Tuples.of(entityQueryFetchMapping.get(0).tableAlias + ".", entityQueryFetchMapping.get(1).tableAlias + ".",
    //                    entityQueryFetchMapping.get(2).tableAlias + ".", entityQueryFetchMapping.get(3).tableAlias + ".",
    //                    entityQueryFetchMapping.get(4).tableAlias + ".", entityQueryFetchMapping.get(5).tableAlias + ".",
    //                    entityQueryFetchMapping.get(6).tableAlias + ".", entityQueryFetchMapping.get(7).tableAlias + ".");
    //        }
    //        throw new SqldbHammerException("entity query fetch times must be 8");
    //    }
    //
    //    private Tuple9<String, String, String, String, String, String, String, String, String> getFetchAliasTuple9() {
    //        if (entityQueryFetchMapping.size() == 3) {
    //            return Tuples.of(entityQueryFetchMapping.get(0).tableAlias + ".", entityQueryFetchMapping.get(1).tableAlias + ".",
    //                    entityQueryFetchMapping.get(2).tableAlias + ".", entityQueryFetchMapping.get(3).tableAlias + ".",
    //                    entityQueryFetchMapping.get(4).tableAlias + ".", entityQueryFetchMapping.get(5).tableAlias + ".",
    //                    entityQueryFetchMapping.get(6).tableAlias + ".", entityQueryFetchMapping.get(7).tableAlias + ".",
    //                    entityQueryFetchMapping.get(8).tableAlias + ".");
    //        }
    //        throw new SqldbHammerException("entity query fetch times must be 9");
    //    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public DslQueryConfig getConfig() {
        return (DslQueryConfig) conditionConfig;
    }
}
