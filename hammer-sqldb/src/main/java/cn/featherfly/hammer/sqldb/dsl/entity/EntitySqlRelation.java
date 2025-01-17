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

package cn.featherfly.hammer.sqldb.dsl.entity;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.apache.commons.lang3.ArrayUtils;

import cn.featherfly.common.bean.PropertyAccessor;
import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectJoinOnBasicBuilder;
import cn.featherfly.common.db.dialect.Join;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.Str;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.common.tuple.MutableTuples;
import cn.featherfly.common.tuple.Tuple2;
import cn.featherfly.common.tuple.Tuples;
import cn.featherfly.common.tuple.mutable.MutableTuple9;
import cn.featherfly.hammer.config.dsl.ConditionConfig;
import cn.featherfly.hammer.expression.condition.Expression;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.dsl.query.SqlRelation;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.mapper.EntityRowMapper;

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
    protected MutableTuple9<EntityRelation<?>, EntityRelation<?>, EntityRelation<?>, EntityRelation<?>,
        EntityRelation<?>, EntityRelation<?>, EntityRelation<?>, EntityRelation<?>,
        EntityRelation<?>> entityFilterableMappingTuple = MutableTuples.create9();

    /** The joined relations. */
    protected final Set<String> joinedRelations = new HashSet<>();

    /**
     * Instantiates a new abstract sql query entity properties.
     *
     * @param jdbc the jdbc
     * @param aliasManager aliasManager
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
     * @param sourceIndex the source index
     * @param propertyName the property name
     * @param joinClassMapping the join class mapping
     * @param joinPropertyName the join property name
     * @return the this
     */
    public R addFilterable(int sourceIndex, String propertyName, JdbcClassMapping<?> joinClassMapping,
        String joinPropertyName) {
        return addFilterable(sourceIndex, propertyName, joinClassMapping, joinPropertyName, false);
    }

    /**
     * Adds the filterable.
     *
     * @param sourceIndex the source index
     * @param propertyName the property name
     * @param joinClassMapping the join class mapping
     * @param joinPropertyName the join property name
     * @param fetchToProperty the fetch to property
     * @return the this
     */
    @SuppressWarnings("unchecked")
    public R addFilterable(int sourceIndex, String propertyName, JdbcClassMapping<?> joinClassMapping,
        String joinPropertyName, boolean fetchToProperty) {
        AssertIllegalArgument.isGe(index, 0, "entity index");
        AssertIllegalArgument.isLt(index, entityFilterableMappingTuple.degree(), "entity index");
        switch (index) {
            case 0:
                EntityRelation<?> eqm = createEntityRelationMapping(sourceIndex, propertyName, joinClassMapping,
                    joinPropertyName, fetchToProperty);
                entityFilterableMappingTuple.set0(eqm);
                initBuilder(eqm);
                break;
            case 1:
                entityFilterableMappingTuple.set1(createEntityRelationMapping(sourceIndex, propertyName,
                    joinClassMapping, joinPropertyName, fetchToProperty));
                break;
            case 2:
                entityFilterableMappingTuple.set2(createEntityRelationMapping(sourceIndex, propertyName,
                    joinClassMapping, joinPropertyName, fetchToProperty));
                break;
            case 3:
                entityFilterableMappingTuple.set3(createEntityRelationMapping(sourceIndex, propertyName,
                    joinClassMapping, joinPropertyName, fetchToProperty));
                break;
            case 4:
                entityFilterableMappingTuple.set4(createEntityRelationMapping(sourceIndex, propertyName,
                    joinClassMapping, joinPropertyName, fetchToProperty));
                break;
            case 5:
                entityFilterableMappingTuple.set5(createEntityRelationMapping(sourceIndex, propertyName,
                    joinClassMapping, joinPropertyName, fetchToProperty));
                break;
            case 6:
                entityFilterableMappingTuple.set6(createEntityRelationMapping(sourceIndex, propertyName,
                    joinClassMapping, joinPropertyName, fetchToProperty));
                break;
            case 7:
                entityFilterableMappingTuple.set7(createEntityRelationMapping(sourceIndex, propertyName,
                    joinClassMapping, joinPropertyName, fetchToProperty));
                break;
            case 8:
                entityFilterableMappingTuple.set8(createEntityRelationMapping(sourceIndex, propertyName,
                    joinClassMapping, joinPropertyName, fetchToProperty));
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
     * @param sourceIndex the source index
     * @param propertyName the property name
     * @param joinClassMapping the join class mapping
     * @return this type implements EntitySqlRelation
     */
    public R join(int sourceIndex, String propertyName, JdbcClassMapping<?> joinClassMapping) {
        return join(Join.INNER_JOIN, sourceIndex, propertyName, joinClassMapping);
    }

    /**
     * Join.
     *
     * @param join the join
     * @param sourceIndex the source index
     * @param propertyName the property name
     * @param joinClassMapping the join class mapping
     * @return this type implements EntitySqlRelation
     */
    public R join(Join join, int sourceIndex, String propertyName, JdbcClassMapping<?> joinClassMapping) {
        return join(join, sourceIndex, propertyName, joinClassMapping, false);
    }

    /**
     * Join.
     *
     * @param sourceIndex the source index
     * @param propertyName the property name
     * @param joinClassMapping the join class mapping
     * @param returnType the return type
     * @return this type implements EntitySqlRelation
     */
    public R join(int sourceIndex, String propertyName, JdbcClassMapping<?> joinClassMapping, boolean returnType) {
        return join(Join.INNER_JOIN, sourceIndex, propertyName, joinClassMapping, returnType);
    }

    /**
     * Join.
     *
     * @param join the join
     * @param sourceIndex the source index
     * @param propertyName the property name
     * @param joinClassMapping the join class mapping
     * @param returnType the return type
     * @return this type implements EntitySqlRelation
     */
    public R join(Join join, int sourceIndex, String propertyName, JdbcClassMapping<?> joinClassMapping,
        boolean returnType) {
        if (joinClassMapping.getPrimaryKeyPropertyMappings().size() == 1) {
            return join(join, sourceIndex, propertyName, joinClassMapping,
                joinClassMapping.getPrimaryKeyPropertyMappings().get(0).getRepositoryFieldName(), returnType);
        }
        throw new SqldbHammerException(
            Str.format("only support one privary key, but more than one privary key found {0}",
                joinClassMapping.getPrimaryKeyPropertyMappings().size()));
    }

    /**
     * Join.
     *
     * @param sourceIndex the source index
     * @param joinClassMapping the join class mapping
     * @param joinPropertyName the join property name
     * @param returnType the return type
     * @return this type implements EntitySqlRelation
     */
    public R join(int sourceIndex, JdbcClassMapping<?> joinClassMapping, String joinPropertyName, boolean returnType) {
        return join(Join.INNER_JOIN, sourceIndex, joinClassMapping, joinPropertyName, returnType);
    }

    /**
     * Join.
     *
     * @param join the join
     * @param sourceIndex the source index
     * @param joinClassMapping the join class mapping
     * @param joinPropertyName the join property name
     * @param returnType the return type
     * @return this type implements EntitySqlRelation
     */
    public R join(Join join, int sourceIndex, JdbcClassMapping<?> joinClassMapping, String joinPropertyName,
        boolean returnType) {
        EntityRelation<?> erm = getEntityRelation(sourceIndex);
        return join(join, sourceIndex, erm.getIdName(), joinClassMapping, joinPropertyName, returnType);
    }

    /**
     * Join.
     *
     * @param sourceIndex the source index
     * @param propertyName the property name
     * @param joinClassMapping the join class mapping
     * @param joinPropertyName the join property name
     * @return this type implements EntitySqlRelation
     */
    public R join(int sourceIndex, String propertyName, JdbcClassMapping<?> joinClassMapping, String joinPropertyName) {
        return join(Join.INNER_JOIN, sourceIndex, propertyName, joinClassMapping, joinPropertyName);
    }

    /**
     * Join.
     *
     * @param join the join
     * @param sourceIndex the source index
     * @param propertyName the property name
     * @param joinClassMapping the join class mapping
     * @param joinPropertyName the join property name
     * @return this type implements EntitySqlRelation
     */
    public R join(Join join, int sourceIndex, String propertyName, JdbcClassMapping<?> joinClassMapping,
        String joinPropertyName) {
        return join(join, sourceIndex, propertyName, joinClassMapping, joinPropertyName, true);
    }

    /**
     * Join.
     *
     * @param sourceIndex the source index
     * @param propertyName the property name
     * @param joinClassMapping the join class mapping
     * @param joinPropertyName the join property name
     * @param returnType the return type
     * @return this type implements EntitySqlRelation
     */
    public R join(int sourceIndex, String propertyName, JdbcClassMapping<?> joinClassMapping, String joinPropertyName,
        boolean returnType) {
        return join(Join.INNER_JOIN, sourceIndex, propertyName, joinClassMapping, joinPropertyName, returnType);
    }

    /**
     * Join.
     *
     * @param join the join
     * @param sourceIndex the source index
     * @param propertyName the property name
     * @param joinClassMapping the join class mapping
     * @param joinPropertyName the join property name
     * @param returnType the return type
     * @return this type implements EntitySqlRelation
     */
    public abstract R join(Join join, int sourceIndex, String propertyName, JdbcClassMapping<?> joinClassMapping,
        String joinPropertyName, boolean returnType);

    /**
     * Join.
     *
     * @param <T> the generic type
     * @param joinClassMapping the join class mapping
     * @param onExpression the on expression
     * @return this type implements EntitySqlRelation
     */
    public <T> EntitySqlRelation<?, ?> join(JdbcClassMapping<T> joinClassMapping, Supplier<Expression> onExpression) {
        return join(Join.INNER_JOIN, joinClassMapping, onExpression);
    }

    /**
     * Join.
     *
     * @param <T> the generic type
     * @param join the join
     * @param joinClassMapping the join class mapping
     * @param onExpression the on expression
     * @return this type implements EntitySqlRelation
     */
    public abstract <T> EntitySqlRelation<?, ?> join(Join join, JdbcClassMapping<T> joinClassMapping,
        Supplier<Expression> onExpression);

    /**
     * Inits the builder.
     *
     * @param erm the erm
     */
    protected abstract void initBuilder(EntityRelation<?> erm);

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
     * get EntityRelation Tuple.
     *
     * @return EntityRelation Tuple
     */
    public MutableTuple9<EntityRelation<?>, EntityRelation<?>, EntityRelation<?>, EntityRelation<?>, EntityRelation<?>,
        EntityRelation<?>, EntityRelation<?>, EntityRelation<?>, EntityRelation<?>> getEntityRelationTuple() {
        return entityFilterableMappingTuple;
    }

    /**
     * Gets the entity relation.
     *
     * @param index the index
     * @return the entity relation
     */
    public EntityRelation<?> getEntityRelation(int index) {
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

    /**
     * Gets the filterable entity relations.
     *
     * @return the filterable entity relations
     */
    public EntityRelation<?>[] getFilterableEntityRelations() {
        return entityFilterableMappingTuple.streamOf(EntityRelation.class).filter(r -> r != null)
            .toArray(n -> new EntityRelation[index]);
    }

    // ****************************************************************************************************************
    //
    // ****************************************************************************************************************

    /**
     * Creates the entity relation mapping.
     *
     * @param <E> the element type
     * @param sourceIndex the source index
     * @param propertyName the property name
     * @param joinClassMapping the join class mapping
     * @param joinPropertyName the join property name
     * @param fetchToProperty the fetch to property
     * @return the entity relation mapping
     */
    protected <E> EntityRelation<E> createEntityRelationMapping(int sourceIndex, String propertyName,
        JdbcClassMapping<E> joinClassMapping, String joinPropertyName, boolean fetchToProperty) {
        EntityRelation<?> ser = getEntityRelation(sourceIndex);
        int[] joinFromPropertyIndexes;
        if (ser != null && fetchToProperty) {
            JdbcClassMapping<?> cm = ser.getClassMapping();
            JdbcPropertyMapping pm = cm.getPropertyMapping(propertyName);
            joinFromPropertyIndexes = ArrayUtils.addAll(ser.getJoinFromPropertyIndexes(), pm.getPropertyIndexes());
        } else {// first query
            joinFromPropertyIndexes = ArrayUtils.EMPTY_INT_ARRAY;
        }
        return new EntityRelation<>(jdbc, joinClassMapping, joinPropertyName, ser, propertyName,
            joinFromPropertyIndexes, fetchToProperty, aliasManager);
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
    public static class EntityRelation<E> {

        /**
         * Instantiates a new entity relation mapping.
         *
         * @param jdbc the jdbc
         * @param classMapping the class mapping
         * @param joinPropertyName the join property name
         * @param joinFrom the join from
         * @param joinFromPropertyName the join from property name
         * @param joinFromPropertyIndexes the join from property indexes
         * @param fetchToProperty the fetch to property
         * @param aliasManager the alias manager
         */
        public EntityRelation(Jdbc jdbc, JdbcClassMapping<E> classMapping, String joinPropertyName,
            EntityRelation<?> joinFrom, String joinFromPropertyName, int[] joinFromPropertyIndexes,
            boolean fetchToProperty, AliasManager aliasManager) {
            this(jdbc, classMapping, joinPropertyName, joinFrom, joinFromPropertyName, joinFromPropertyIndexes,
                fetchToProperty, aliasManager, null);
        }

        /**
         * Instantiates a new entity relation mapping.
         *
         * @param jdbc the jdbc
         * @param classMapping the class mapping
         * @param joinPropertyName the join property name
         * @param joinFrom the join from
         * @param joinFromPropertyName the join from property name
         * @param joinFromPropertyIndexes the join from property indexes
         * @param fetchToProperty the fetch to property
         * @param aliasManager the alias manager
         * @param selectJoinOnBasicBuilder the select join on basic builder
         */
        public EntityRelation(Jdbc jdbc, JdbcClassMapping<E> classMapping, String joinPropertyName,
            EntityRelation<?> joinFrom, String joinFromPropertyName, int[] joinFromPropertyIndexes,
            boolean fetchToProperty, AliasManager aliasManager, SqlSelectJoinOnBasicBuilder selectJoinOnBasicBuilder) {
            super();
            this.classMapping = classMapping;
            this.joinPropertyName = joinPropertyName;
            this.joinFromPropertyName = joinFromPropertyName;
            this.joinFromPropertyIndexes = joinFromPropertyIndexes;
            //            joinFromIndex = joinFromIndex;
            this.joinFrom = joinFrom;
            this.fetchToProperty = fetchToProperty;

            tableAlias = aliasManager.put(classMapping.getRepositoryName());

            if (classMapping.getPrimaryKeyPropertyMappings().size() == 1) {
                idName = classMapping.getPrimaryKeyPropertyMappings().get(0).getRepositoryFieldName();
            }

            if (Lang.isEmpty(joinPropertyName)) {
                if (Lang.isEmpty(idName)) {
                    if (Lang.isNotEmpty(joinFrom)) {
                        throw new SqldbHammerException("joinPropertyName and idName are all empty");
                    }
                } else {
                    this.joinPropertyName = idName;
                }
            }

            if (fetchToProperty) {
                if (joinFrom.getFullJoinPropertyName() == null) {
                    fullJoinFromPropertyName = joinFromPropertyName;
                } else {
                    fullJoinFromPropertyName = joinFrom.getFullJoinPropertyName() + Chars.DOT + joinFromPropertyName;
                }
            } else {
                fullJoinFromPropertyName = null;
            }

            this.selectJoinOnBasicBuilder = selectJoinOnBasicBuilder;

            propertyAccessor = jdbc.getPropertyAccessorFactory().create(classMapping.getType());
            this.jdbc = jdbc;
        }

        private final Jdbc jdbc;

        private final PropertyAccessor<E> propertyAccessor;

        private Set<Tuple2<int[], JdbcPropertyMapping>> fetchPropertyMappings = new LinkedHashSet<>();

        /** The select join on basic builder. */
        SqlSelectJoinOnBasicBuilder selectJoinOnBasicBuilder;

        /** The class mapping. */
        JdbcClassMapping<E> classMapping;

        // ManyToOne OneToOne
        private final EntityRelation<?> joinFrom;

        private final boolean fetchToProperty;

        /** The join property name. */
        String joinPropertyName;

        /** The join from full property name. */
        String joinFromFullPropertyName;

        /** The table alias. */
        String tableAlias;

        /** The id name. */
        String idName;

        private final String joinFromPropertyName;

        private final String fullJoinFromPropertyName;

        /** The join from property indexes. */
        int[] joinFromPropertyIndexes;

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
         * Gets the join from.
         *
         * @return the join from
         */
        public EntityRelation<?> getJoinFrom() {
            return joinFrom;
        }

        /**
         * Checks if is fetch to property.
         *
         * @return true, if is fetch to property
         */
        public boolean isFetchToProperty() {
            return fetchToProperty;
        }

        /**
         * Adds the fetch property mapping.
         *
         * @param indexes the indexes
         * @param propertyMapping the property mapping
         */
        public void addFetchPropertyMapping(int[] indexes, JdbcPropertyMapping propertyMapping) {
            if (joinFrom != null && fetchToProperty) {
                joinFrom.addFetchPropertyMapping(indexes, propertyMapping);
            } else {
                fetchPropertyMappings.add(Tuples.of(indexes, propertyMapping));
            }
        }

        /**
         * Gets the fetch property mappings.
         *
         * @return the fetch property mappings
         */
        public Set<Tuple2<int[], JdbcPropertyMapping>> getFetchPropertyMappings() {
            return fetchPropertyMappings;
        }

        /**
         * Gets the join from property indexes.
         *
         * @return the join from property indexes
         */
        public int[] getJoinFromPropertyIndexes() {
            return joinFromPropertyIndexes;
        }

        /**
         * Gets the join from full property name.
         *
         * @return the join from full property name
         */
        public String getFullJoinPropertyName() {
            return fullJoinFromPropertyName;
        }

        /**
         * Gets the full join property name.
         *
         * @param prefixTableAlias the prefix table alias
         * @return the full join property name
         */
        public String getFullJoinPropertyName(boolean prefixTableAlias) {
            if (prefixTableAlias) {
                return getRootObject().getTableAlias() + Chars.DOT + fullJoinFromPropertyName;
            }
            return fullJoinFromPropertyName;
        }

        private EntityRelation<?> getRootObject() {
            if (joinFrom != null && fetchToProperty) {
                return joinFrom.getRootObject();
            } else {
                return this;
            }
        }

        /**
         * Gets the mapper.
         *
         * @return the mapper
         */
        public EntityRowMapper<E> getMapper() {
            if (Lang.isEmpty(fetchPropertyMappings)) {
                return new EntityRowMapper<>(propertyAccessor, jdbc.getDialect(), classMapping);
            } else {
                return new EntityRowMapper<>(propertyAccessor, jdbc.getDialect(), classMapping, fetchPropertyMappings);
            }
            //            return new NestedBeanPropertyRowMapper<>(instantiator, manager);
        }
    }
}
