/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntitySqlRelation.java
 * @Package cn.featherfly.hammer.sqldb.jdbc.dsl.entity
 * @Description: EntitySqlRelation
 * @author: zhongj
 * @date: 2023年8月25日 下午6:07:01
 * @version V1.0
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */

package cn.featherfly.hammer.sqldb.jdbc.dsl.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.speedment.common.tuple.MutableTuples;
import com.speedment.common.tuple.mutable.MutableTuple9;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectJoinOnBasicBuilder;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.Strings;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.hammer.config.dsl.ConditionConfig;
import cn.featherfly.hammer.expression.condition.Expression;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.dsl.query.SqlRelation;

/**
 * abstract entity sql relation.
 *
 * @author zhongj
 * @param <R> implements EntitySqlRelation
 * @param <B> sql builder
 */
public abstract class EntitySqlRelation<R extends EntitySqlRelation<R, B>, B extends SqlBuilder>
        implements SqlRelation<B> {

    /** The jdbc. */
    protected Jdbc jdbc;

    /** The alias manager. */
    protected AliasManager aliasManager;

    /** The ignore strategy. */
    protected ConditionConfig<?> conditionConfig;

    /** The index. */
    protected int index;

    /** The entity filterable mapping tuple. */
    protected MutableTuple9<EntityRelationMapping<?>, EntityRelationMapping<?>, EntityRelationMapping<?>, EntityRelationMapping<?>, EntityRelationMapping<?>, EntityRelationMapping<?>, EntityRelationMapping<?>, EntityRelationMapping<?>, EntityRelationMapping<?>> entityFilterableMappingTuple = MutableTuples
            .create9();

    protected final Set<String> joinedRelations = new HashSet<>();

    /**
     * Instantiates a new abstract sql query entity properties.
     *
     * @param jdbc            the jdbc
     * @param aliasManager    aliasManager
     * @param conditionConfig the condition config
     */
    protected EntitySqlRelation(Jdbc jdbc, AliasManager aliasManager, ConditionConfig<?> conditionConfig) {
        AssertIllegalArgument.isNotNull(jdbc, "jdbc");
        AssertIllegalArgument.isNotNull(aliasManager, "aliasManager");
        AssertIllegalArgument.isNotNull(conditionConfig, "conditionConfig");
        this.jdbc = jdbc;
        this.aliasManager = aliasManager;
        this.conditionConfig = conditionConfig;

        //        entityQueryFetchIndexes.add(0); // 默认加入第一个
    }

    /**
     * Adds the filterable.
     *
     * @param classMapping the class mapping
     * @return the this
     */
    public R addFilterable(JdbcClassMapping<?> classMapping) {
        return addFilterable(0, null, classMapping, null);
    }

    /**
     * Adds the filterable.
     *
     * @param sourceIndex      the source index
     * @param propertyName     the property name
     * @param joinClassMapping the join class mapping
     * @param joinPropertyName the join property name
     * @return the this
     */
    @SuppressWarnings("unchecked")
    public R addFilterable(int sourceIndex, String propertyName, JdbcClassMapping<?> joinClassMapping,
            String joinPropertyName) {
        AssertIllegalArgument.isGe(index, 0, "entity index");
        AssertIllegalArgument.isLt(index, entityFilterableMappingTuple.degree(), "entity index");
        switch (index) {
            case 0:
                EntityRelationMapping<?> eqm = createEntityRelationMapping(sourceIndex, propertyName, joinClassMapping,
                        joinPropertyName);
                entityFilterableMappingTuple.set0(eqm);
                initBuilder(eqm);
                break;
            case 1:
                entityFilterableMappingTuple.set1(
                        createEntityRelationMapping(sourceIndex, propertyName, joinClassMapping, joinPropertyName));
                break;
            case 2:
                entityFilterableMappingTuple.set2(
                        createEntityRelationMapping(sourceIndex, propertyName, joinClassMapping, joinPropertyName));
                break;
            case 3:
                entityFilterableMappingTuple.set3(
                        createEntityRelationMapping(sourceIndex, propertyName, joinClassMapping, joinPropertyName));
                break;
            case 4:
                entityFilterableMappingTuple.set4(
                        createEntityRelationMapping(sourceIndex, propertyName, joinClassMapping, joinPropertyName));
                break;
            case 5:
                entityFilterableMappingTuple.set5(
                        createEntityRelationMapping(sourceIndex, propertyName, joinClassMapping, joinPropertyName));
                break;
            case 6:
                entityFilterableMappingTuple.set6(
                        createEntityRelationMapping(sourceIndex, propertyName, joinClassMapping, joinPropertyName));
                break;
            case 7:
                entityFilterableMappingTuple.set7(
                        createEntityRelationMapping(sourceIndex, propertyName, joinClassMapping, joinPropertyName));
                break;
            case 8:
                entityFilterableMappingTuple.set8(
                        createEntityRelationMapping(sourceIndex, propertyName, joinClassMapping, joinPropertyName));
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
     * @param sourceIndex      the source index
     * @param propertyName     the property name
     * @param joinClassMapping the join class mapping
     * @return this type implements EntitySqlRelation
     */
    public R join(int sourceIndex, String propertyName, JdbcClassMapping<?> joinClassMapping) {
        return join(sourceIndex, propertyName, joinClassMapping, false);
    }

    /**
     * Join.
     *
     * @param sourceIndex      the source index
     * @param propertyName     the property name
     * @param joinClassMapping the join class mapping
     * @param returnType       the return type
     * @return this type implements EntitySqlRelation
     */
    public R join(int sourceIndex, String propertyName, JdbcClassMapping<?> joinClassMapping, boolean returnType) {
        if (joinClassMapping.getPrivaryKeyPropertyMappings().size() == 1) {
            return join(sourceIndex, propertyName, joinClassMapping,
                    joinClassMapping.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName(), returnType);
        }
        throw new SqldbHammerException(
                Strings.format("only support one privary key, but more than one privary key found {0}",
                        joinClassMapping.getPrivaryKeyPropertyMappings().size()));
    }

    /**
     * Join.
     *
     * @param sourceIndex      the source index
     * @param joinClassMapping the join class mapping
     * @param joinPropertyName the join property name
     * @param returnType       the return type
     * @return this type implements EntitySqlRelation
     */
    public R join(int sourceIndex, JdbcClassMapping<?> joinClassMapping, String joinPropertyName, boolean returnType) {
        EntityRelationMapping<?> erm = getEntityRelationMapping(sourceIndex);
        return join(sourceIndex, erm.getIdName(), joinClassMapping, joinPropertyName, returnType);
    }

    /**
     * Join.
     *
     * @param sourceIndex      the source index
     * @param propertyName     the property name
     * @param joinClassMapping the join class mapping
     * @param joinPropertyName the join property name
     * @return this type implements EntitySqlRelation
     */
    public R join(int sourceIndex, String propertyName, JdbcClassMapping<?> joinClassMapping, String joinPropertyName) {
        return join(sourceIndex, propertyName, joinClassMapping, joinPropertyName, true);
    }

    /**
     * Join.
     *
     * @param sourceIndex      the source index
     * @param propertyName     the property name
     * @param joinClassMapping the join class mapping
     * @param joinPropertyName the join property name
     * @param returnType       the return type
     * @return this type implements EntitySqlRelation
     */
    public abstract R join(int sourceIndex, String propertyName, JdbcClassMapping<?> joinClassMapping,
            String joinPropertyName, boolean returnType);

    /**
     * Join.
     *
     * @param <T>              the generic type
     * @param joinClassMapping the join class mapping
     * @param onExpression     the on expression
     * @return this type implements EntitySqlRelation
     */
    public abstract <T> EntitySqlRelation<?, ?> join(JdbcClassMapping<T> joinClassMapping,
            Supplier<Expression> onExpression);

    /**
     * Inits the builder.
     *
     * @param erm the erm
     */
    protected abstract void initBuilder(EntityRelationMapping<?> erm);

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
    public MutableTuple9<EntityRelationMapping<?>, EntityRelationMapping<?>, EntityRelationMapping<?>, EntityRelationMapping<?>, EntityRelationMapping<?>, EntityRelationMapping<?>, EntityRelationMapping<?>, EntityRelationMapping<?>, EntityRelationMapping<?>> getEntityRelationMappingTuple() {
        return entityFilterableMappingTuple;
    }

    /**
     * Gets the entity query mapping.
     *
     * @param index the index
     * @return the entity query mapping
     */
    public EntityRelationMapping<?> getEntityRelationMapping(int index) {
        switch (index) {
            case 0:
                return entityFilterableMappingTuple.getOrNull0();
            case 1:
                return entityFilterableMappingTuple.getOrNull1();
            case 2:
                return entityFilterableMappingTuple.getOrNull2();
            case 3:
                return entityFilterableMappingTuple.getOrNull3();
            case 4:
                return entityFilterableMappingTuple.getOrNull4();
            case 5:
                return entityFilterableMappingTuple.getOrNull5();
            case 6:
                return entityFilterableMappingTuple.getOrNull6();
            case 7:
                return entityFilterableMappingTuple.getOrNull7();
            case 8:
                return entityFilterableMappingTuple.getOrNull8();
            default:
                throw new SqldbHammerException("entity query mapping index must be 0-8");
        }
    }

    // ****************************************************************************************************************
    //
    // ****************************************************************************************************************

    /**
     * Creates the entity relation mapping.
     *
     * @param <E>              the element type
     * @param sourceIndex      the source index
     * @param propertyName     the property name
     * @param joinClassMapping the join class mapping
     * @param joinPropertyName the join property name
     * @return the entity relation mapping
     */
    protected <E> EntityRelationMapping<E> createEntityRelationMapping(int sourceIndex, String propertyName,
            JdbcClassMapping<E> joinClassMapping, String joinPropertyName) {
        return new EntityRelationMapping<>(joinClassMapping, joinPropertyName, sourceIndex, propertyName, aliasManager);
    }

    // ********************************************************************
    //
    // ********************************************************************

    /**
     * The Class EntityRelationMapping.
     *
     * @author zhongj
     * @param <E> the element type
     */
    public static class EntityRelationMapping<E> {

        /**
         * Instantiates a new entity relation mapping.
         *
         * @param classMapping         the class mapping
         * @param joinPropertyName     the join property name
         * @param joinFromIndex        the join from index
         * @param joinFromPropertyName the join from property name
         * @param aliasManager         the alias manager
         */
        public EntityRelationMapping(JdbcClassMapping<E> classMapping, String joinPropertyName, int joinFromIndex,
                String joinFromPropertyName, AliasManager aliasManager) {
            this(classMapping, joinPropertyName, joinFromIndex, joinFromPropertyName, aliasManager, null);
        }

        /**
         * Instantiates a new entity relation mapping.
         *
         * @param classMapping             the class mapping
         * @param joinPropertyName         the join property name
         * @param joinFromIndex            the join from index
         * @param joinFromPropertyName     the join from property name
         * @param aliasManager             the alias manager
         * @param selectJoinOnBasicBuilder the select join on basic builder
         */
        public EntityRelationMapping(JdbcClassMapping<E> classMapping, String joinPropertyName, int joinFromIndex,
                String joinFromPropertyName, AliasManager aliasManager,
                SqlSelectJoinOnBasicBuilder selectJoinOnBasicBuilder) {
            super();
            this.classMapping = classMapping;
            this.joinPropertyName = joinPropertyName;
            this.joinFromPropertyName = joinFromPropertyName;
            this.joinFromIndex = joinFromIndex;

            tableAlias = aliasManager.put(classMapping.getRepositoryName());

            if (classMapping.getPrivaryKeyPropertyMappings().size() == 1) {
                idName = classMapping.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName();
            }

            if (Lang.isEmpty(joinPropertyName)) {
                if (Lang.isEmpty(idName)) {
                    if (Lang.isNotEmpty(joinFromPropertyName)) {
                        throw new SqldbHammerException("joinPropertyName and idName are all empty");
                    }
                } else {
                    this.joinPropertyName = idName;
                }
            }

            this.selectJoinOnBasicBuilder = selectJoinOnBasicBuilder;
        }

        /** The select join on basic builder. */
        SqlSelectJoinOnBasicBuilder selectJoinOnBasicBuilder;

        /** The class mapping. */
        JdbcClassMapping<E> classMapping;

        /** The join property name. */
        String joinPropertyName;

        /** The table alias. */
        String tableAlias;

        /** The id name. */
        String idName;

        /** The join from index. */
        int joinFromIndex;

        /** The join from property name. */
        String joinFromPropertyName;

        /**
         * get classMapping value.
         *
         * @return classMapping
         */
        public JdbcClassMapping<E> getClassMapping() {
            return classMapping;
        }

        /**
         * get tableAlias value.
         *
         * @return tableAlias
         */
        public String getTableAlias() {
            return tableAlias;
        }

        /**
         * get idName value.
         *
         * @return idName
         */
        public String getIdName() {
            return idName;
        }

        /**
         * set idName value.
         *
         * @param idName idName
         */
        public void setIdName(String idName) {
            this.idName = idName;
        }

        /**
         * get joinPropertyName value.
         *
         * @return joinPropertyName
         */
        public String getJoinPropertyName() {
            return joinPropertyName;
        }

        /**
         * get joinFromPropertyName value.
         *
         * @return joinFromPropertyName
         */
        public String getJoinFromPropertyName() {
            return joinFromPropertyName;
        }

        /**
         * Gets the join from index.
         *
         * @return the join from index
         */
        public int getJoinFromIndex() {
            return joinFromIndex;
        }
    }
}
