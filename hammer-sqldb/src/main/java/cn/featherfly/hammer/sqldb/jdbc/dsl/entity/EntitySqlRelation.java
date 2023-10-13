/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntitySqlRelation.java
 * @Package cn.featherfly.hammer.sqldb.jdbc.dsl.entity
 * @Description: todo (用一句话描述该文件做什么)
 * @author: zhongj
 * @date: 2023年8月25日 下午6:07:01
 * @version V1.0
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */

package cn.featherfly.hammer.sqldb.jdbc.dsl.entity;

import java.util.function.Predicate;

import com.speedment.common.tuple.MutableTuples;
import com.speedment.common.tuple.mutable.MutableTuple9;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectJoinOnBasicBuilder;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * abstract entity sql query entity properties.
 *
 * @author zhongj
 * @param <R> the generic type
 * @param <B> the generic type
 */
public abstract class EntitySqlRelation<R extends EntitySqlRelation<R, B>, B extends SqlBuilder> {

    /** The jdbc. */
    protected Jdbc jdbc;

    /** The alias manager. */
    protected AliasManager aliasManager;

    /** The ignore strategy. */
    protected Predicate<?> ignoreStrategy;

    /** The index. */
    protected int index;

    /** The entity filterable mapping tuple. */
    protected MutableTuple9<EntityRelationMapping<?>, EntityRelationMapping<?>, EntityRelationMapping<?>,
            EntityRelationMapping<?>, EntityRelationMapping<?>, EntityRelationMapping<?>, EntityRelationMapping<?>,
            EntityRelationMapping<?>, EntityRelationMapping<?>> entityFilterableMappingTuple = MutableTuples.create9();

    //    private MutableTuple9<Boolean, Boolean, Boolean, Boolean, Boolean, Boolean, Boolean, Boolean,
    //            Boolean> entityQueryFetchTuple = MutableTuples.create9();

    /**
     * Instantiates a new abstract sql query entity properties.
     *
     * @param jdbc           the jdbc
     * @param aliasManager   aliasManager
     * @param ignoreStrategy the ignore strategy
     */
    public EntitySqlRelation(Jdbc jdbc, AliasManager aliasManager, Predicate<?> ignoreStrategy) {
        AssertIllegalArgument.isNotNull(jdbc, "jdbc");
        AssertIllegalArgument.isNotNull(aliasManager, "aliasManager");
        AssertIllegalArgument.isNotNull(ignoreStrategy, "ignoreStrategy");
        this.jdbc = jdbc;
        this.aliasManager = aliasManager;
        this.ignoreStrategy = ignoreStrategy;

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
     * @param joinClassMapping the join class mapping
     * @param propertyName     the property name
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
                //                selectBuilder = new SqlSelectBasicBuilder(jdbc.getDialect(), classMapping, eqm.tableAlias);
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
     * Inits the builder.
     *
     * @param erm the erm
     */
    protected abstract void initBuilder(EntityRelationMapping<?> erm);

    /**
     * Gets the builder.
     *
     * @return the builder
     */
    public abstract B getBuilder();

    /**
     * get jdbc value.
     *
     * @return jdbc
     */
    public Jdbc getJdbc() {
        return jdbc;
    }

    /**
     * get aliasManager value.
     *
     * @return aliasManager
     */
    public AliasManager getAliasManager() {
        return aliasManager;
    }

    /**
     * get ignoreStrategy value.
     *
     * @return ignoreStrategy
     */
    public Predicate<?> getIgnorePolicy() {
        return ignoreStrategy;
    }

    /**
     * get entityQueryMappingTuple value.
     *
     * @return entityQueryMappingTuple
     */
    public MutableTuple9<EntityRelationMapping<?>, EntityRelationMapping<?>, EntityRelationMapping<?>,
            EntityRelationMapping<?>, EntityRelationMapping<?>, EntityRelationMapping<?>, EntityRelationMapping<?>,
            EntityRelationMapping<?>, EntityRelationMapping<?>> getEntityRelationMappingTuple() {
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

            //            String tableAlias = aliasManager.getAlias(classMapping.getRepositoryName());
            //            if (tableAlias == null) {
            //                tableAlias = aliasManager.put(classMapping.getRepositoryName());
            //            }

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