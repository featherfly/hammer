
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity;

import java.util.function.Predicate;

import com.speedment.common.tuple.MutableTuples;
import com.speedment.common.tuple.mutable.MutableTuple9;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectJoinOnBasicBuilder;
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
public abstract class EntitySqlRelation<R extends EntitySqlRelation<R, B>, B extends SqlBuilder> {

    protected Jdbc jdbc;

    /** The alias manager. */
    protected AliasManager aliasManager;

    /** The ignore strategy. */
    protected Predicate<?> ignoreStrategy;

    protected int index;

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

    //    public R join(int sourceIndex, String propertyName, JdbcClassMapping<?> classMapping) {
    //        // IMPLSOON 未实现
    //        EntityRelationMapping<?> erm = getEntityRelationMapping(sourceIndex);
    //        return addFilterable(classMapping);
    //    }
    //
    //    public R join(int sourceIndex, JdbcClassMapping<?> classMapping, String repositoryPropertyName) {
    //        // IMPLSOON 未实现
    //        EntityRelationMapping<?> erm = getEntityRelationMapping(sourceIndex);
    //        return addFilterable(classMapping);
    //    }
    //
    //    public R join(int sourceIndex, String propertyName, JdbcClassMapping<?> classMapping,
    //            String repositoryPropertyName) {
    //        // IMPLSOON 未实现
    //        return addFilterable(classMapping);
    //    }

    /**
     * Adds the filterable.
     *
     * @param classMapping the class mapping
     * @return the r
     */
    @SuppressWarnings("unchecked")
    public R addFilterable(JdbcClassMapping<?> classMapping) {
        AssertIllegalArgument.isGe(index, 0, "entity index");
        AssertIllegalArgument.isLt(index, entityFilterableMappingTuple.degree(), "entity index");
        switch (index) {
            case 0:
                EntityRelationMapping<?> eqm = createEntityRelationMapping(classMapping);
                entityFilterableMappingTuple.set0(eqm);
                //                selectBuilder = new SqlSelectBasicBuilder(jdbc.getDialect(), classMapping, eqm.tableAlias);
                initBuilder(eqm);
                break;
            case 1:
                entityFilterableMappingTuple.set1(createEntityRelationMapping(classMapping));
                break;
            case 2:
                entityFilterableMappingTuple.set2(createEntityRelationMapping(classMapping));
                break;
            case 3:
                entityFilterableMappingTuple.set3(createEntityRelationMapping(classMapping));
                break;
            case 4:
                entityFilterableMappingTuple.set4(createEntityRelationMapping(classMapping));
                break;
            case 5:
                entityFilterableMappingTuple.set5(createEntityRelationMapping(classMapping));
                break;
            case 6:
                entityFilterableMappingTuple.set6(createEntityRelationMapping(classMapping));
                break;
            case 7:
                entityFilterableMappingTuple.set7(createEntityRelationMapping(classMapping));
                break;
            case 8:
                entityFilterableMappingTuple.set8(createEntityRelationMapping(classMapping));
                break;
            default:
                break;
        }
        index++;
        return (R) this;
    }

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

    protected EntityRelationMapping<?> createEntityRelationMapping(JdbcClassMapping<?> classMapping) {
        return new EntityRelationMapping<>(classMapping, aliasManager);
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
         * @param classMapping the class mapping
         * @param aliasManager the alias manager
         */
        public EntityRelationMapping(JdbcClassMapping<E> classMapping, AliasManager aliasManager) {
            this(classMapping, aliasManager, null);
        }

        /**
         * Instantiates a new entity relation mapping.
         *
         * @param classMapping             the class mapping
         * @param aliasManager             the alias manager
         * @param selectJoinOnBasicBuilder the select join on basic builder
         */
        public EntityRelationMapping(JdbcClassMapping<E> classMapping, AliasManager aliasManager,
                SqlSelectJoinOnBasicBuilder selectJoinOnBasicBuilder) {
            super();
            this.classMapping = classMapping;

            String tableAlias = aliasManager.getAlias(classMapping.getRepositoryName());
            if (tableAlias == null) {
                tableAlias = aliasManager.put(classMapping.getRepositoryName());
            }
            this.tableAlias = tableAlias;

            if (classMapping.getPrivaryKeyPropertyMappings().size() == 1) {
                idName = classMapping.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName();
            }

            this.selectJoinOnBasicBuilder = selectJoinOnBasicBuilder;
        }

        SqlSelectJoinOnBasicBuilder selectJoinOnBasicBuilder;

        /** The class mapping. */
        JdbcClassMapping<E> classMapping;

        /** The table alias. */
        String tableAlias;

        /** The id name. */
        String idName;

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
         * set idName value
         *
         * @param idName idName
         */
        public void setIdName(String idName) {
            this.idName = idName;
        }
    }

}
