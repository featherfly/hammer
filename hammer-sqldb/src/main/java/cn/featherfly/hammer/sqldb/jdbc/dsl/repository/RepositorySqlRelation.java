/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-27 19:30:27
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.speedment.common.tuple.MutableTuples;
import com.speedment.common.tuple.mutable.MutableTuple9;

import cn.featherfly.common.db.Column;
import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectJoinOnBasicBuilder;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.Strings;
import cn.featherfly.common.repository.AliasRepository;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.hammer.config.dsl.ConditionConfig;
import cn.featherfly.hammer.expression.condition.Expression;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.dsl.query.SqlRelation;

/**
 * abstract entity sql query entity properties.
 *
 * @author zhongj
 * @param <R> the generic type
 * @param <B> the generic type
 */
public abstract class RepositorySqlRelation<R extends RepositorySqlRelation<R, B>, B extends SqlBuilder>
    implements SqlRelation<B> {

    /** The jdbc. */
    protected Jdbc jdbc;

    /** The alias manager. */
    protected AliasManager aliasManager;

    /** The metadata. */
    protected DatabaseMetadata metadata;

    /** The ignore strategy. */
    protected ConditionConfig<?> conditionConfig;

    /** The index. */
    protected int index;

    /** The entity filterable mapping tuple. */
    protected MutableTuple9<RepositoryRelation, RepositoryRelation, RepositoryRelation, RepositoryRelation,
        RepositoryRelation, RepositoryRelation, RepositoryRelation, RepositoryRelation,
        RepositoryRelation> repositoryFilterableTuple = MutableTuples.create9();

    /**
     * Instantiates a new abstract sql query entity properties.
     *
     * @param jdbc            the jdbc
     * @param aliasManager    aliasManager
     * @param metadata        the metadata
     * @param conditionConfig the condition config
     */
    protected RepositorySqlRelation(Jdbc jdbc, AliasManager aliasManager, DatabaseMetadata metadata,
        ConditionConfig<?> conditionConfig) {
        AssertIllegalArgument.isNotNull(jdbc, "jdbc");
        AssertIllegalArgument.isNotNull(aliasManager, "aliasManager");
        AssertIllegalArgument.isNotNull(metadata, "metadata");
        AssertIllegalArgument.isNotNull(conditionConfig, "conditionConfig");
        this.jdbc = jdbc;
        this.aliasManager = aliasManager;
        this.metadata = metadata;
        this.conditionConfig = conditionConfig;

        //        entityQueryFetchIndexes.add(0); // 默认加入第一个
    }

    /**
     * Adds the filterable.
     *
     * @param repository the repository
     * @return the this
     */
    public R addFilterable(Repository repository) {
        return addFilterable(repository.name());
    }

    /**
     * Adds the filterable.
     *
     * @param repository the repository
     * @return the this
     */
    public R addFilterable(AliasRepository repository) {
        return addFilterable(repository.name(), repository.alias());
    }

    /**
     * Adds the filterable.
     *
     * @param repository the repository
     * @return the this
     */
    public R addFilterable(String repository) {
        return addFilterable(0, null, repository, null);
    }

    /**
     * Adds the filterable.
     *
     * @param repository the repository
     * @param alias      the alias
     * @return the this
     */
    public R addFilterable(String repository, String alias) {
        return addFilterable(0, null, repository, alias, null);
    }

    /**
     * Adds the filterable.
     *
     * @param sourceIndex    the source index
     * @param sourceField    the source field
     * @param joinRepository the join repository
     * @param joinField      the join field
     * @return the r
     */
    public R addFilterable(int sourceIndex, String sourceField, String joinRepository, String joinField) {
        return addFilterable(sourceIndex, sourceField, joinRepository, null, joinField);
    }

    /**
     * Adds the filterable.
     *
     * @param sourceIndex         the source index
     * @param sourceField         the source field
     * @param joinRepository      the join repository
     * @param joinRepositoryAlias the join repository alias
     * @param joinField           the join property name
     * @return the this
     */
    @SuppressWarnings("unchecked")
    public R addFilterable(int sourceIndex, String sourceField, String joinRepository, String joinRepositoryAlias,
        String joinField) {
        checkIndex(index);
        switch (index) {
            case 0:
                RepositoryRelation eqm = createRelationMapping(sourceIndex, sourceField, joinRepository,
                    joinRepositoryAlias, joinField);
                repositoryFilterableTuple.set0(eqm);
                initBuilder(eqm);
                break;
            case 1:
                repositoryFilterableTuple.set1(
                    createRelationMapping(sourceIndex, sourceField, joinRepository, joinRepositoryAlias, joinField));
                break;
            case 2:
                repositoryFilterableTuple.set2(
                    createRelationMapping(sourceIndex, sourceField, joinRepository, joinRepositoryAlias, joinField));
                break;
            case 3:
                repositoryFilterableTuple.set3(
                    createRelationMapping(sourceIndex, sourceField, joinRepository, joinRepositoryAlias, joinField));
                break;
            case 4:
                repositoryFilterableTuple.set4(
                    createRelationMapping(sourceIndex, sourceField, joinRepository, joinRepositoryAlias, joinField));
                break;
            case 5:
                repositoryFilterableTuple.set5(
                    createRelationMapping(sourceIndex, sourceField, joinRepository, joinRepositoryAlias, joinField));
                break;
            case 6:
                repositoryFilterableTuple.set6(
                    createRelationMapping(sourceIndex, sourceField, joinRepository, joinRepositoryAlias, joinField));
                break;
            case 7:
                repositoryFilterableTuple.set7(
                    createRelationMapping(sourceIndex, sourceField, joinRepository, joinRepositoryAlias, joinField));
                break;
            case 8:
                repositoryFilterableTuple.set8(
                    createRelationMapping(sourceIndex, sourceField, joinRepository, joinRepositoryAlias, joinField));
                break;
            default:
                break;
        }
        index++;
        return (R) this;
    }

    /**
     * Join.
     *
     * @param sourceIndex    the source index
     * @param sourceField    the property name
     * @param joinRepository the join repository
     * @return the r
     */
    public R join(int sourceIndex, String sourceField, String joinRepository) {
        List<Column> pkList = metadata.getTable(joinRepository).getPrimaryColumns();
        if (pkList.size() == 1) {
            return join(sourceIndex, sourceField, joinRepository, pkList.get(0).getName());
        }
        throw new SqldbHammerException(
            Strings.format("only support one primary key, but more than one primary key found {0}", pkList.size()));
    }

    /**
     * Join.
     *
     * @param sourceIndex    the source index
     * @param sourceField    the source field
     * @param joinRepository the join repository
     * @param joinField      the join field
     * @return the r
     */
    @SuppressWarnings("unchecked")
    public R join(int sourceIndex, String sourceField, String joinRepository, String joinField) {
        AssertIllegalArgument.isNotNull(sourceField, "sourceField");
        AssertIllegalArgument.isNotNull(joinRepository, "joinRepository");
        AssertIllegalArgument.isNotNull(joinField, "joinField");
        RepositoryRelation erm = getRepositoryRelation(sourceIndex);

        addFilterable(sourceIndex, sourceField, joinRepository, joinField);

        RepositoryRelation jerm = getRepositoryRelation(index - 1);

        SqlSelectJoinOnBasicBuilder selectJoinOnBasicBuilder = join0(erm.getRepositoryAlias(), sourceField,
            jerm.getRepository(), jerm.getRepositoryAlias(), jerm.getField());
        jerm.selectJoinOnBasicBuilder = selectJoinOnBasicBuilder;

        return (R) this;
    }

    /**
     * Join.
     *
     * @param sourceIndex    the source index
     * @param joinRepository the join repository
     * @return the r
     */
    @SuppressWarnings("unchecked")
    public R join(String joinRepository, Supplier<Expression> onExpression) {
        AssertIllegalArgument.isNotNull(joinRepository, "joinRepository");
        //        RepositoryRelation erm = getRepositoryRelation(sourceIndex);
        addFilterable(joinRepository);
        RepositoryRelation jerm = getRepositoryRelation(index - 1);
        SqlSelectJoinOnBasicBuilder selectJoinOnBasicBuilder = join0(jerm.getRepository(), jerm.getRepositoryAlias(),
            onExpression.get().expression());
        jerm.selectJoinOnBasicBuilder = selectJoinOnBasicBuilder;
        return (R) this;
    }

    /**
     * Join 0.
     *
     * @param sourceTableAlias the table alias
     * @param sourceColumn     the column name
     * @param joinTable        the join table
     * @param joinTableAlias   the join table alias
     * @param joinTableColumn  the join table column name
     * @return the sql select join on basic builder
     */
    protected abstract SqlSelectJoinOnBasicBuilder join0(String sourceTableAlias, String sourceColumn, String joinTable,
        String joinTableAlias, String joinTableColumn);

    /**
     * Join 0.
     *
     * @param joinTable      the join table
     * @param joinTableAlias the join table alias
     * @param onSql          the on sql
     * @return the sql select join on basic builder
     */
    protected abstract SqlSelectJoinOnBasicBuilder join0(String joinTable, String joinTableAlias, String onSql);

    /**
     * Inits the builder.
     *
     * @param erm the erm
     */
    protected abstract void initBuilder(RepositoryRelation erm);

    /**
     * {@inheritDoc}
     */
    @Override
    public Jdbc getJdbc() {
        return jdbc;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AliasManager getAliasManager() {
        return aliasManager;
    }

    /**
     * Gets the metadata.
     *
     * @return the metadata
     */
    public DatabaseMetadata getMetadata() {
        return metadata;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Predicate<Object> getIgnoreStrategy() {
        return conditionConfig.getIgnoreStrategy();
    }

    /**
     * get entityQueryMappingTuple value.
     *
     * @return entityQueryMappingTuple
     */
    public MutableTuple9<RepositoryRelation, RepositoryRelation, RepositoryRelation, RepositoryRelation,
        RepositoryRelation, RepositoryRelation, RepositoryRelation, RepositoryRelation,
        RepositoryRelation> getRepositoryRelationTuple() {
        return repositoryFilterableTuple;
    }

    /**
     * Gets the entity query mapping.
     *
     * @param index the index
     * @return the entity query mapping
     */
    public RepositoryRelation getRepositoryRelation(int index) {
        switch (index) {
            case 0:
                return repositoryFilterableTuple.getOrNull0();
            case 1:
                return repositoryFilterableTuple.getOrNull1();
            case 2:
                return repositoryFilterableTuple.getOrNull2();
            case 3:
                return repositoryFilterableTuple.getOrNull3();
            case 4:
                return repositoryFilterableTuple.getOrNull4();
            case 5:
                return repositoryFilterableTuple.getOrNull5();
            case 6:
                return repositoryFilterableTuple.getOrNull6();
            case 7:
                return repositoryFilterableTuple.getOrNull7();
            case 8:
                return repositoryFilterableTuple.getOrNull8();
            default:
                throw new SqldbHammerException("entity query mapping index must be 0-8");
        }
    }

    // ****************************************************************************************************************
    //
    // ****************************************************************************************************************

    /**
     * Check index.
     *
     * @param index the index
     */
    protected void checkIndex(int index) {
        AssertIllegalArgument.isGe(index, 0, "repository index");
        AssertIllegalArgument.isLt(index, repositoryFilterableTuple.degree(), "repository index");
    }

    /**
     * Creates the entity relation mapping.
     *
     * @param sourceIndex         the source index
     * @param sourceField         the source field
     * @param joinRepository      the join repository
     * @param joinRepositoryAlias the join repository alias
     * @param joinField           the join field
     * @return the entity relation mapping
     */
    protected RepositoryRelation createRelationMapping(int sourceIndex, String sourceField, String joinRepository,
        String joinRepositoryAlias, String joinField) {
        return new RepositoryRelation(sourceIndex, sourceField, joinRepository, joinRepositoryAlias, joinField,
            aliasManager);
    }

    // ********************************************************************
    //
    // ********************************************************************

    /**
     * The Class RepositoryRelationMapping.
     *
     * @author zhongj
     */
    public static class RepositoryRelation {

        /**
         * Instantiates a new repository relation mapping.
         *
         * @param sourceIndex         the source index
         * @param sourceField         the source field name
         * @param joinRepository      the join repository
         * @param joinRepositoryAlias the join repository alias
         * @param joinField           the join field name
         * @param aliasManager        the alias manager
         */
        public RepositoryRelation(int sourceIndex, String sourceField, String joinRepository,
            String joinRepositoryAlias, String joinField, AliasManager aliasManager) {
            this(sourceIndex, sourceField, joinRepository, joinRepositoryAlias, joinField, aliasManager, null);
        }

        /**
         * Instantiates a new repository relation mapping.
         *
         * @param sourceIndex              the join from index
         * @param sourceField              the join from property name
         * @param joinRepository           the join repository
         * @param joinRepositoryAlias      the join repository alias
         * @param joinField                the join property name
         * @param aliasManager             the alias manager
         * @param selectJoinOnBasicBuilder the select join on basic builder
         */
        public RepositoryRelation(int sourceIndex, String sourceField, String joinRepository,
            String joinRepositoryAlias, String joinField, AliasManager aliasManager,
            SqlSelectJoinOnBasicBuilder selectJoinOnBasicBuilder) {
            super();
            if (sourceIndex > 0) {
                AssertIllegalArgument.isNotEmpty(joinField, "joinField");
                AssertIllegalArgument.isNotEmpty(sourceField, "sourceField");
                //                if (Lang.isNotEmpty(sourceField)) {
                //                    throw new SqldbHammerException("joinPropertyName and idName are all empty");
                //                }
            }

            this.sourceIndex = sourceIndex;
            this.sourceField = sourceField;

            repository = joinRepository;
            field = joinField;
            if (Lang.isEmpty(joinRepositoryAlias)) {
                repositoryAlias = aliasManager.put(joinRepository);
            } else {
                aliasManager.put(repository, joinRepositoryAlias);
                repositoryAlias = joinRepositoryAlias;
            }

            this.selectJoinOnBasicBuilder = selectJoinOnBasicBuilder;
        }

        /** The select join on basic builder. */
        SqlSelectJoinOnBasicBuilder selectJoinOnBasicBuilder;

        /** The join repository. */
        String repository;

        /** The table alias. */
        String repositoryAlias;

        /** The join field. */
        String field;

        /** The source index. */
        int sourceIndex;

        /** The source field name. */
        String sourceField;

        /**
         * Gets the join repository.
         *
         * @return the join repository
         */
        public String getRepository() {
            return repository;
        }

        /**
         * Gets the join repository alias.
         *
         * @return the join repository alias
         */
        public String getRepositoryAlias() {
            return repositoryAlias;
        }

        /**
         * Gets the join field.
         *
         * @return the join field
         */
        public String getField() {
            return field;
        }

        /**
         * Gets the source index.
         *
         * @return the source index
         */
        public int getSourceIndex() {
            return sourceIndex;
        }

        /**
         * Gets the source field name.
         *
         * @return the source field name
         */
        public String getSourceField() {
            return sourceField;
        }
    }
}
