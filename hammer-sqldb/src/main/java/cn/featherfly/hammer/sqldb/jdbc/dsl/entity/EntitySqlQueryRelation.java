
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuple3;
import com.speedment.common.tuple.Tuple4;
import com.speedment.common.tuple.Tuple5;
import com.speedment.common.tuple.Tuple6;
import com.speedment.common.tuple.Tuple7;
import com.speedment.common.tuple.Tuple8;
import com.speedment.common.tuple.Tuple9;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectJoinOnBasicBuilder;
import cn.featherfly.common.db.dialect.Join;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * abstract entity sql query entity properties.
 *
 * @author zhongj
 */
public class EntitySqlQueryRelation extends EntitySqlRelation<EntitySqlQueryRelation, SqlSelectBasicBuilder> {

    /** The select builder. */
    private SqlSelectBasicBuilder selectBuilder;

    private Map<Integer, EntityRelationMapping<?>> entityQueryFetchMapping = new HashMap<>();

    private Set<String> queryFetchAlias = new HashSet<>();

    /**
     * Instantiates a new abstract sql query entity properties.
     *
     * @param dialect        the dialect
     * @param aliasManager   aliasManager
     * @param ignoreStrategy the ignore strategy
     */
    public EntitySqlQueryRelation(Jdbc jdbc, AliasManager aliasManager, Predicate<?> ignoreStrategy) {
        super(jdbc, aliasManager, ignoreStrategy);
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

    @Override
    protected SqlSelectJoinOnBasicBuilder join0(String tableAlias, String columnName,
            JdbcClassMapping<?> joinClassMapping, String joinTableAlias, String joinTableColumnName) {
        return getBuilder().join(Join.INNER_JOIN, tableAlias, columnName, joinClassMapping, joinTableAlias,
                joinTableColumnName);
    }

    /**
     * Fetch.
     *
     * @param index the index
     */
    public EntitySqlQueryRelation fetch(int index) {
        AssertIllegalArgument.isGe(index, 0, "fetch entity index");
        AssertIllegalArgument.isLt(index, entityFilterableMappingTuple.degree(), "fetch entity index");
        EntityRelationMapping<?> erm = getEntityRelationMapping(index);
        //        entityQueryFetchMapping.put(index, erm);
        entityQueryFetchMapping.put(entityQueryFetchMapping.size(), erm);
        queryFetchAlias.add(erm.getTableAlias());

        if (index > 0) {
            erm.selectJoinOnBasicBuilder.fetch();
        }

        return this;
    }

    public EntitySqlQueryRelation fetchProperty(int index) {
        AssertIllegalArgument.isGe(index, 0, "fetch entity index");
        AssertIllegalArgument.isLt(index, entityFilterableMappingTuple.degree(), "fetch entity index");
        EntityRelationMapping<?> erm = getEntityRelationMapping(index);
        queryFetchAlias.add(erm.getTableAlias());
        if (index > 0) {
            //            erm.selectJoinOnBasicBuilder.fetch(erm.getJoinFromPropertyName());
            erm.selectJoinOnBasicBuilder.fetch((alias, prefixTableAlias) -> {
                if (prefixTableAlias) {
                    EntityRelationMapping<?> jerm = getEntityRelationMapping(erm.getJoinFromIndex());
                    return jerm.getTableAlias() + Chars.DOT_CHAR + erm.getJoinFromPropertyName();
                } else {
                    return erm.getJoinFromPropertyName();
                }
            });
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
     * @param <R> the generic type
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

    //    /**
    //     * 返回selectBuilder.
    //     *
    //     * @return selectBuilder
    //     */
    //    public SqlSelectBasicBuilder getSelectBuilder() {
    //        return selectBuilder;
    //    }

    public String buildSelectSql() {
        return selectBuilder.setColumnAliasPrefixTableAlias(isReturnTuple())
                .build((tableName, tableAlias) -> queryFetchAlias.contains(tableAlias));
    }

    /**
     * Single tuple.
     *
     * @param sql        the sql
     * @param resultType the result type
     * @param params     the params
     * @return the r
     */
    @SuppressWarnings("unchecked")
    public <R> R single(String sql, Object[] params) {
        //        if (isReturnTuple()) {
        switch (entityQueryFetchMapping.size()) {
            case 1:
                return (R) jdbc.querySingle(sql, entityFilterableMappingTuple.getOrNull0().getClassMapping().getType(),
                        params);
            case 2:
                return (R) jdbc.querySingle(sql, entityQueryFetchMapping.get(0).getClassMapping().getType(),
                        entityQueryFetchMapping.get(1).getClassMapping().getType(), getFetchAliasTuple2(), params);
            case 3:
                return (R) jdbc.querySingle(sql, entityQueryFetchMapping.get(0).getClassMapping().getType(),
                        entityQueryFetchMapping.get(1).getClassMapping().getType(),
                        entityQueryFetchMapping.get(2).classMapping.getType(), getFetchAliasTuple3(), params);
            case 4:
                return (R) jdbc.querySingle(sql, entityQueryFetchMapping.get(0).getClassMapping().getType(),
                        entityQueryFetchMapping.get(1).getClassMapping().getType(),
                        entityQueryFetchMapping.get(2).classMapping.getType(),
                        entityQueryFetchMapping.get(3).classMapping.getType(), getFetchAliasTuple4(), params);
            case 5:
                return (R) jdbc.querySingle(sql, entityQueryFetchMapping.get(0).getClassMapping().getType(),
                        entityQueryFetchMapping.get(1).getClassMapping().getType(),
                        entityQueryFetchMapping.get(2).classMapping.getType(),
                        entityQueryFetchMapping.get(3).classMapping.getType(),
                        entityQueryFetchMapping.get(4).classMapping.getType(), getFetchAliasTuple5(), params);
            case 6:
                return (R) jdbc.querySingle(sql, entityQueryFetchMapping.get(0).getClassMapping().getType(),
                        entityQueryFetchMapping.get(1).getClassMapping().getType(),
                        entityQueryFetchMapping.get(2).classMapping.getType(),
                        entityQueryFetchMapping.get(3).classMapping.getType(),
                        entityQueryFetchMapping.get(4).classMapping.getType(),
                        entityQueryFetchMapping.get(5).classMapping.getType(), getFetchAliasTuple6(), params);
            default:
                throw new SqldbHammerException("entity query fetch times must be 2-6");
        }
        //        } else {
        //            throw new SqldbHammerException("query result is not tuple type");
        //        }
    }

    /**
     * Unique tuple.
     *
     * @param sql        the sql
     * @param resultType the result type
     * @param params     the params
     * @return the r
     */
    @SuppressWarnings("unchecked")
    public <R> R unique(String sql, Object[] params) {
        //        if (isReturnTuple()) {
        switch (entityQueryFetchMapping.size()) {
            case 1:
                return (R) jdbc.queryUnique(sql, entityFilterableMappingTuple.getOrNull0().getClassMapping().getType(),
                        params);
            case 2:
                return (R) jdbc.queryUnique(sql, entityQueryFetchMapping.get(0).getClassMapping().getType(),
                        entityQueryFetchMapping.get(1).getClassMapping().getType(), getFetchAliasTuple2(), params);
            case 3:
                return (R) jdbc.queryUnique(sql, entityQueryFetchMapping.get(0).getClassMapping().getType(),
                        entityQueryFetchMapping.get(1).getClassMapping().getType(),
                        entityQueryFetchMapping.get(2).classMapping.getType(), getFetchAliasTuple3(), params);
            case 4:
                return (R) jdbc.queryUnique(sql, entityQueryFetchMapping.get(0).getClassMapping().getType(),
                        entityQueryFetchMapping.get(1).getClassMapping().getType(),
                        entityQueryFetchMapping.get(2).classMapping.getType(),
                        entityQueryFetchMapping.get(3).classMapping.getType(), getFetchAliasTuple4(), params);
            case 5:
                return (R) jdbc.queryUnique(sql, entityQueryFetchMapping.get(0).getClassMapping().getType(),
                        entityQueryFetchMapping.get(1).getClassMapping().getType(),
                        entityQueryFetchMapping.get(2).classMapping.getType(),
                        entityQueryFetchMapping.get(3).classMapping.getType(),
                        entityQueryFetchMapping.get(4).classMapping.getType(), getFetchAliasTuple5(), params);
            case 6:
                return (R) jdbc.queryUnique(sql, entityQueryFetchMapping.get(0).getClassMapping().getType(),
                        entityQueryFetchMapping.get(1).getClassMapping().getType(),
                        entityQueryFetchMapping.get(2).classMapping.getType(),
                        entityQueryFetchMapping.get(3).classMapping.getType(),
                        entityQueryFetchMapping.get(4).classMapping.getType(),
                        entityQueryFetchMapping.get(5).classMapping.getType(), getFetchAliasTuple6(), params);
            default:
                throw new SqldbHammerException("entity query fetch times must be 2-6");
        }
        //        } else {
        //            throw new SqldbHammerException("query result is not tuple type");
        //        }
    }

    /**
     * List tuple.
     *
     * @param sql        the sql
     * @param resultType the result type
     * @param params     the params
     * @return the list
     */
    @SuppressWarnings("unchecked")
    public <R> List<R> list(String sql, Object[] params) {
        //        if (isReturnTuple()) {
        switch (entityQueryFetchMapping.size()) {
            case 1:
                return (List<R>) jdbc.query(sql, entityFilterableMappingTuple.getOrNull0().getClassMapping().getType(),
                        params);
            case 2:
                return (List<R>) jdbc.query(sql, entityQueryFetchMapping.get(0).getClassMapping().getType(),
                        entityQueryFetchMapping.get(1).getClassMapping().getType(), getFetchAliasTuple2(), params);
            case 3:
                return (List<R>) jdbc.query(sql, entityQueryFetchMapping.get(0).getClassMapping().getType(),
                        entityQueryFetchMapping.get(1).getClassMapping().getType(),
                        entityQueryFetchMapping.get(2).classMapping.getType(), getFetchAliasTuple3(), params);
            case 4:
                return (List<R>) jdbc.query(sql, entityQueryFetchMapping.get(0).getClassMapping().getType(),
                        entityQueryFetchMapping.get(1).getClassMapping().getType(),
                        entityQueryFetchMapping.get(2).classMapping.getType(),
                        entityQueryFetchMapping.get(3).classMapping.getType(), getFetchAliasTuple4(), params);
            case 5:
                return (List<R>) jdbc.query(sql, entityQueryFetchMapping.get(0).getClassMapping().getType(),
                        entityQueryFetchMapping.get(1).getClassMapping().getType(),
                        entityQueryFetchMapping.get(2).classMapping.getType(),
                        entityQueryFetchMapping.get(3).classMapping.getType(),
                        entityQueryFetchMapping.get(4).classMapping.getType(), getFetchAliasTuple5(), params);
            case 6:
                return (List<R>) jdbc.query(sql, entityQueryFetchMapping.get(0).getClassMapping().getType(),
                        entityQueryFetchMapping.get(1).getClassMapping().getType(),
                        entityQueryFetchMapping.get(2).classMapping.getType(),
                        entityQueryFetchMapping.get(3).classMapping.getType(),
                        entityQueryFetchMapping.get(4).classMapping.getType(),
                        entityQueryFetchMapping.get(5).classMapping.getType(), getFetchAliasTuple6(), params);
            default:
                throw new SqldbHammerException("entity query fetch times must be 2-6");
        }
        //        } else {
        //            throw new SqldbHammerException("query result is not tuple type");
        //        }
    }

    // ****************************************************************************************************************
    //	protected method
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initBuilder(EntityRelationMapping<?> erm) {
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

    private Tuple2<String, String> getFetchAliasTuple2() {
        if (entityQueryFetchMapping.size() == 2) {
            return Tuples.of(entityQueryFetchMapping.get(0).tableAlias + ".",
                    entityQueryFetchMapping.get(1).tableAlias + ".");
        }
        throw new SqldbHammerException("entity query fetch times must be 2");
    }

    private Tuple3<String, String, String> getFetchAliasTuple3() {
        if (entityQueryFetchMapping.size() == 3) {
            return Tuples.of(entityQueryFetchMapping.get(0).tableAlias + ".",
                    entityQueryFetchMapping.get(1).tableAlias + ".", entityQueryFetchMapping.get(2).tableAlias + ".");
        }
        throw new SqldbHammerException("entity query fetch times must be 3");
    }

    private Tuple4<String, String, String, String> getFetchAliasTuple4() {
        if (entityQueryFetchMapping.size() == 4) {
            return Tuples.of(entityQueryFetchMapping.get(0).tableAlias + ".",
                    entityQueryFetchMapping.get(1).tableAlias + ".", entityQueryFetchMapping.get(2).tableAlias + ".",
                    entityQueryFetchMapping.get(3).tableAlias + ".");
        }
        throw new SqldbHammerException("entity query fetch times must be 4");
    }

    private Tuple5<String, String, String, String, String> getFetchAliasTuple5() {
        if (entityQueryFetchMapping.size() == 5) {
            return Tuples.of(entityQueryFetchMapping.get(0).tableAlias + ".",
                    entityQueryFetchMapping.get(1).tableAlias + ".", entityQueryFetchMapping.get(2).tableAlias + ".",
                    entityQueryFetchMapping.get(3).tableAlias + ".", entityQueryFetchMapping.get(4).tableAlias + ".");
        }
        throw new SqldbHammerException("entity query fetch times must be 5");
    }

    private Tuple6<String, String, String, String, String, String> getFetchAliasTuple6() {
        if (entityQueryFetchMapping.size() == 6) {
            return Tuples.of(entityQueryFetchMapping.get(0).tableAlias + ".",
                    entityQueryFetchMapping.get(1).tableAlias + ".", entityQueryFetchMapping.get(2).tableAlias + ".",
                    entityQueryFetchMapping.get(3).tableAlias + ".", entityQueryFetchMapping.get(4).tableAlias + ".",
                    entityQueryFetchMapping.get(5).tableAlias + ".");
        }
        throw new SqldbHammerException("entity query fetch times must be 6");
    }
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
}
