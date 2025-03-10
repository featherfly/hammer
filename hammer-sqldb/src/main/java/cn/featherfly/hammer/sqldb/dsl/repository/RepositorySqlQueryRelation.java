/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-27 19:30:27
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Supplier;

import cn.featherfly.common.db.Column;
import cn.featherfly.common.db.builder.dml.basic.SqlJoinOnBuilder;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectJoinOnBasicBuilder;
import cn.featherfly.common.db.dialect.Join;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.exception.NotImplementedException;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.hammer.config.dsl.DslQueryConfig;
import cn.featherfly.hammer.expression.condition.Expression;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * abstract entity sql query entity properties.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelation
    extends RepositorySqlRelation<RepositorySqlQueryRelation, SqlSelectBasicBuilder> {

    /** The select builder. */
    private SqlSelectBasicBuilder selectBuilder;

    private Map<Integer, RepositoryRelation> repositoryQueryFetchMapping = new HashMap<>();

    private Set<String> queryFetchAlias = new HashSet<>();

    /**
     * Instantiates a new abstract sql query entity properties.
     *
     * @param jdbc the jdbc
     * @param aliasManager aliasManager
     * @param metadata the metadata
     * @param queryConfig the query config
     */
    public RepositorySqlQueryRelation(Jdbc jdbc, AliasManager aliasManager, DatabaseMetadata metadata,
        DslQueryConfig queryConfig) {
        super(jdbc, aliasManager, metadata, queryConfig);
    }

    /**
     * add a query mapping.
     *
     * @param repository the repository
     * @return the entity sql query relation
     */
    public RepositorySqlQueryRelation query(String repository) {
        return addFilterable(repository);
    }

    /**
     * add a query mapping.
     *
     * @param repository the repository
     * @param alias the alias
     * @return the entity sql query relation
     */
    public RepositorySqlQueryRelation query(String repository, String alias) {
        return addFilterable(repository, alias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositorySqlQueryRelation join(String joinRepository, Supplier<Expression> onExpression) {
        AssertIllegalArgument.isNotNull(joinRepository, "joinRepository");
        //        RepositoryRelation erm = getRepositoryRelation(sourceIndex);
        addFilterable(joinRepository);
        RepositoryRelation jerm = getRepositoryRelation(index - 1);
        SqlSelectJoinOnBasicBuilder selectJoinOnBasicBuilder = join0(jerm.getRepository(), jerm.getRepositoryAlias(),
            onExpression.get().expression());
        jerm.selectJoinOnBasicBuilder = selectJoinOnBasicBuilder;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositorySqlQueryRelation join(int sourceIndex, String sourceField, String joinRepository,
        String joinRepositoryAlias, String joinField) {
        AssertIllegalArgument.isNotNull(joinRepository, "joinRepository");
        if (Lang.isEmpty(joinField)) {
            List<Column> pks = metadata.getTable(joinRepository).getPrimaryColumns();
            if (pks.size() == 1) {
                joinField = pks.get(0).getName();
            } else {
                AssertIllegalArgument.isNotNull(joinField, "joinField");
            }
        }

        RepositoryRelation erm = getRepositoryRelation(sourceIndex);

        if (Lang.isEmpty(sourceField)) {
            List<Column> pks = metadata.getTable(erm.getRepository()).getPrimaryColumns();
            if (pks.size() == 1) {
                sourceField = pks.get(0).getName();
            } else {
                AssertIllegalArgument.isNotNull(sourceField, "sourceField");
            }
        }

        addFilterable(sourceIndex, sourceField, joinRepository, joinRepositoryAlias, joinField);

        RepositoryRelation jerm = getRepositoryRelation(index - 1);

        SqlSelectJoinOnBasicBuilder selectJoinOnBasicBuilder = join0(erm.getRepositoryAlias(), sourceField,
            jerm.getRepository(), jerm.getRepositoryAlias(), jerm.getField());
        jerm.selectJoinOnBasicBuilder = selectJoinOnBasicBuilder;

        return this;
    }

    private SqlSelectJoinOnBasicBuilder join0(String sourceTableAlias, String sourceColumn, String joinTable,
        String joinTableAlias, String joinTableColumn) {
        return getBuilder().join(Join.INNER_JOIN, metadata.getTable(joinTable), joinTableAlias, joinTableColumn,
            sourceTableAlias, sourceColumn);
    }

    private SqlSelectJoinOnBasicBuilder join0(String joinTable, String joinTableAlias, String onSql) {
        return getBuilder().join(Join.INNER_JOIN, metadata.getTable(joinTable), joinTableAlias, onSql);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositorySqlQueryRelation join(SqlJoinOnBuilder joinOnBuilder) {
        throw new NotImplementedException();
    }

    /**
     * Fetch.
     *
     * @param index the index
     * @return the repository sql query relation
     */
    public RepositorySqlQueryRelation fetch(int index) {
        checkIndex(index);
        RepositoryRelation erm = getRepositoryRelation(index);
        repositoryQueryFetchMapping.put(repositoryQueryFetchMapping.size(), erm);
        queryFetchAlias.add(erm.getRepositoryAlias());

        if (index > 0) {
            erm.selectJoinOnBasicBuilder.fetch();
        }

        return this;
    }

    /**
     * fetch fields.
     *
     * @param index the index
     * @param fields the fields
     * @return the repository sql query relation
     */
    public RepositorySqlQueryRelation fetch(int index, String... fields) {
        checkIndex(index);
        RepositoryRelation erm = getRepositoryRelation(index);
        repositoryQueryFetchMapping.put(repositoryQueryFetchMapping.size(), erm);
        queryFetchAlias.add(erm.getRepositoryAlias());

        if (index > 0) {
            erm.selectJoinOnBasicBuilder.addColumns(fields);
        }

        return this;
    }

    /**
     * fetch fields.
     *
     * @param index the index
     * @param fields the fields
     * @return the repository sql query relation
     */
    public RepositorySqlQueryRelation fetch(int index, Map<String, String> fields) {
        checkIndex(index);
        RepositoryRelation erm = getRepositoryRelation(index);
        repositoryQueryFetchMapping.put(repositoryQueryFetchMapping.size(), erm);
        queryFetchAlias.add(erm.getRepositoryAlias());

        if (index > 0) {
            for (Entry<String, String> entry : fields.entrySet()) {
                erm.selectJoinOnBasicBuilder.addColumn(entry.getKey(), entry.getValue());
            }
        }

        return this;
    }

    /**
     * Fetch.
     *
     * @param index the index
     * @param field the field
     * @return the repository sql query relation
     */
    public RepositorySqlQueryRelation fetch(int index, String field) {
        return fetch(index, false, field);
    }

    /**
     * Fetch.
     *
     * @param index the index
     * @param distinct the distinct
     * @param field the field
     * @return the repository sql query relation
     */
    public RepositorySqlQueryRelation fetch(int index, boolean distinct, String field) {
        return fetch(index, distinct, field, null);
    }

    /**
     * Fetch.
     *
     * @param index the index
     * @param distinct the distinct
     * @param field the field
     * @param alias the alias
     * @return the repository sql query relation
     */
    public RepositorySqlQueryRelation fetch(int index, boolean distinct, String field, String alias) {
        checkIndex(index);
        RepositoryRelation erm = getRepositoryRelation(index);
        repositoryQueryFetchMapping.put(repositoryQueryFetchMapping.size(), erm);
        queryFetchAlias.add(erm.getRepositoryAlias());

        if (index > 0) {
            erm.selectJoinOnBasicBuilder.addColumn(distinct, field, alias);
        }

        return this;
    }

    /**
     * Fetch.
     *
     * @param index the index
     * @param aggregateFunction the aggregate function
     * @param field the field
     * @return the repository sql query relation
     */
    public RepositorySqlQueryRelation fetch(int index, AggregateFunction aggregateFunction, String field) {
        return fetch(index, aggregateFunction, field, null);
    }

    /**
     * Fetch.
     *
     * @param index the index
     * @param aggregateFunction the aggregate function
     * @param field the field
     * @param alias the alias
     * @return the repository sql query relation
     */
    public RepositorySqlQueryRelation fetch(int index, AggregateFunction aggregateFunction, String field,
        String alias) {
        return fetch(index, aggregateFunction, false, field, alias);
    }

    /**
     * Fetch.
     *
     * @param index the index
     * @param aggregateFunction the aggregate function
     * @param distinct the distinct
     * @param field the field
     * @param alias the alias
     * @return the repository sql query relation
     */
    public RepositorySqlQueryRelation fetch(int index, AggregateFunction aggregateFunction, boolean distinct,
        String field, String alias) {
        checkIndex(index);
        RepositoryRelation erm = getRepositoryRelation(index);
        repositoryQueryFetchMapping.put(repositoryQueryFetchMapping.size(), erm);
        queryFetchAlias.add(erm.getRepositoryAlias());

        if (index > 0) {
            erm.selectJoinOnBasicBuilder.addColumn(aggregateFunction, distinct, field, alias);
        }

        return this;
    }

    /**
     * Checks if is return tuple.
     *
     * @return true, if is return tuple
     */
    public boolean isReturnTuple() {
        return repositoryQueryFetchMapping.size() > 1;
    }

    /**
     * Builds the select count sql.
     *
     * @return the string
     */
    public String buildSelectCountSql() {
        return jdbc.getDialect().getKeywords().select() + " " + jdbc.getDialect().getKeywords().count() + "(*) "
            + jdbc.getDialect().getKeywords().from() + " " + getRepositoryRelation(0).getRepository() + " "
            + getRepositoryRelation(0).getRepositoryAlias();
    }

    /**
     * Builds the select sql.
     *
     * @return the string
     */
    public String buildSelectSql() {
        return selectBuilder.setColumnAliasPrefixTableAlias(isReturnTuple())
            .build((tableName, tableAlias) -> queryFetchAlias.contains(tableAlias));
    }

    // ****************************************************************************************************************
    //	protected method
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initBuilder(RepositoryRelation erm) {
        selectBuilder = new SqlSelectBasicBuilder(jdbc.getDialect(), metadata.getTable(erm.getRepository()),
            erm.getRepositoryAlias());
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

    //    private Tuple2<String, String> getFetchAliasTuple2() {
    //        if (repositoryQueryFetchMapping.size() == 2) {
    //            return Tuples.of(repositoryQueryFetchMapping.get(0).getJoinRepositoryAlias() + ".",
    //                    repositoryQueryFetchMapping.get(1).getJoinRepositoryAlias() + ".");
    //        }
    //        throw new SqldbHammerException("repository query fetch times must be 2");
    //    }
    //
    //    private Tuple3<String, String, String> getFetchAliasTuple3() {
    //        if (repositoryQueryFetchMapping.size() == 3) {
    //            return Tuples.of(repositoryQueryFetchMapping.get(0).getJoinRepositoryAlias() + ".",
    //                    repositoryQueryFetchMapping.get(1).getJoinRepositoryAlias() + ".",
    //                    repositoryQueryFetchMapping.get(2).getJoinRepositoryAlias() + ".");
    //        }
    //        throw new SqldbHammerException("repository query fetch times must be 3");
    //    }
    //
    //    private Tuple4<String, String, String, String> getFetchAliasTuple4() {
    //        if (repositoryQueryFetchMapping.size() == 4) {
    //            return Tuples.of(repositoryQueryFetchMapping.get(0).getJoinRepositoryAlias() + ".",
    //                    repositoryQueryFetchMapping.get(1).getJoinRepositoryAlias() + ".",
    //                    repositoryQueryFetchMapping.get(2).getJoinRepositoryAlias() + ".",
    //                    repositoryQueryFetchMapping.get(3).getJoinRepositoryAlias() + ".");
    //        }
    //        throw new SqldbHammerException("repository query fetch times must be 4");
    //    }
    //
    //    private Tuple5<String, String, String, String, String> getFetchAliasTuple5() {
    //        if (repositoryQueryFetchMapping.size() == 5) {
    //            return Tuples.of(repositoryQueryFetchMapping.get(0).getJoinRepositoryAlias() + ".",
    //                    repositoryQueryFetchMapping.get(1).getJoinRepositoryAlias() + ".",
    //                    repositoryQueryFetchMapping.get(2).getJoinRepositoryAlias() + ".",
    //                    repositoryQueryFetchMapping.get(3).getJoinRepositoryAlias() + ".",
    //                    repositoryQueryFetchMapping.get(4).getJoinRepositoryAlias() + ".");
    //        }
    //        throw new SqldbHammerException("repository query fetch times must be 5");
    //    }
    //
    //    private Tuple6<String, String, String, String, String, String> getFetchAliasTuple6() {
    //        if (repositoryQueryFetchMapping.size() == 6) {
    //            return Tuples.of(repositoryQueryFetchMapping.get(0).getJoinRepositoryAlias() + ".",
    //                    repositoryQueryFetchMapping.get(1).getJoinRepositoryAlias() + ".",
    //                    repositoryQueryFetchMapping.get(2).getJoinRepositoryAlias() + ".",
    //                    repositoryQueryFetchMapping.get(3).getJoinRepositoryAlias() + ".",
    //                    repositoryQueryFetchMapping.get(4).getJoinRepositoryAlias() + ".",
    //                    repositoryQueryFetchMapping.get(5).getJoinRepositoryAlias() + ".");
    //        }
    //        throw new SqldbHammerException("repository query fetch times must be 6");
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
