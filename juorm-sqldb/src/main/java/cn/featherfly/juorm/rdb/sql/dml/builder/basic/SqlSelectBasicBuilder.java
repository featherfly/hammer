package cn.featherfly.juorm.rdb.sql.dml.builder.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.dialect.Dialect.Keyworld;
import cn.featherfly.common.db.dialect.Join;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.juorm.mapping.ClassMapping;
import cn.featherfly.juorm.mapping.MappingFactory;
import cn.featherfly.juorm.operator.AggregateFunction;
import cn.featherfly.juorm.rdb.sql.dialect.Dialect;
import cn.featherfly.juorm.rdb.sql.dml.SqlBuilder;
import cn.featherfly.juorm.rdb.sql.model.SelectColumnElement;

/**
 * <p>
 * sql select basic builder. columns with given table
 * </p>
 *
 * @author zhongj
 */
public class SqlSelectBasicBuilder implements SqlBuilder {

    protected String tableAlias;

    protected String tableName;

    protected boolean buildWithFrom = true;

    protected List<SelectColumnElement> columns = new ArrayList<>(0);

    protected Dialect dialect;

    protected ClassMapping<?> classMapping;

    protected SqlSelectColumnsBasicBuilder defaultSelectColumnsBasicBuilder;

    protected List<SqlJoinOnBasicBuilder> sqlJoinOnBasicBuilders = new ArrayList<>(0);

    protected List<SqlSelectColumnsBasicBuilder> joinSelectColumnsBasicBuilders = new ArrayList<>(0);

    protected MappingFactory mappingFactory;

    /**
     * @param dialect   dialect
     * @param tableName tableName
     */
    public SqlSelectBasicBuilder(Dialect dialect, String tableName) {
        this(dialect, tableName, null);
    }

    /**
     * @param dialect    dialect
     * @param tableName  tableName
     * @param tableAlias alias
     */
    public SqlSelectBasicBuilder(Dialect dialect, String tableName, String tableAlias) {
        this.dialect = dialect;
        this.tableAlias = tableAlias;
        this.tableName = tableName;

        defaultSelectColumnsBasicBuilder = new SqlSelectColumnsBasicBuilder(dialect, tableAlias);
    }

    /**
     * Instantiates a new sql select basic builder.
     *
     * @param dialect        dialect
     * @param classMapping   classMapping
     * @param mappingFactory the mapping factory
     */
    public SqlSelectBasicBuilder(Dialect dialect, ClassMapping<?> classMapping, MappingFactory mappingFactory) {
        this(dialect, classMapping, null, mappingFactory);
    }

    /**
     * Instantiates a new sql select basic builder.
     *
     * @param dialect        dialect
     * @param classMapping   classMapping
     * @param tableAlias     alias
     * @param mappingFactory the mapping factory
     */
    public SqlSelectBasicBuilder(Dialect dialect, ClassMapping<?> classMapping, String tableAlias,
            MappingFactory mappingFactory) {
        this.dialect = dialect;
        this.classMapping = classMapping;
        tableName = classMapping.getRepositoryName();
        this.tableAlias = tableAlias;
        this.mappingFactory = mappingFactory;

        defaultSelectColumnsBasicBuilder = new SqlSelectColumnsBasicBuilder(dialect, classMapping, tableAlias,
                mappingFactory);
    }

    /**
     * 返回alias
     *
     * @return alias
     */
    public String getTableAlias() {
        return tableAlias;
    }

    /**
     * 设置alias
     *
     * @param tableAlias tableAlias
     */
    public void setTableAlias(String tableAlias) {
        this.tableAlias = tableAlias;
        defaultSelectColumnsBasicBuilder.setTableAlias(tableAlias);
    }

    /**
     * 返回tableName
     *
     * @return tableName
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 设置tableName
     *
     * @param tableName tableName
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * 返回buildWithFrom
     *
     * @return buildWithFrom
     */
    public boolean isBuildWithFrom() {
        return buildWithFrom;
    }

    /**
     * 设置buildWithFrom
     *
     * @param buildWithFrom buildWithFrom
     */
    public void setBuildWithFrom(boolean buildWithFrom) {
        this.buildWithFrom = buildWithFrom;
    }

    /**
     * add column
     *
     * @param column            column
     * @param aggregateFunction aggregateFunction
     * @return this
     */
    public SqlSelectBasicBuilder addSelectColumn(String column, AggregateFunction aggregateFunction) {
        defaultSelectColumnsBasicBuilder.addSelectColumn(column, aggregateFunction);
        return this;
    }

    /**
     * add column
     *
     * @param column            column
     * @param aggregateFunction aggregateFunction
     * @param asName            alias name
     * @return this
     */
    public SqlSelectBasicBuilder addSelectColumn(String column, AggregateFunction aggregateFunction, String asName) {
        defaultSelectColumnsBasicBuilder.addSelectColumn(column, aggregateFunction, asName);
        return this;
    }

    /**
     * add column
     *
     * @param column column
     * @return this
     */
    public SqlSelectBasicBuilder addSelectColumn(String column) {
        defaultSelectColumnsBasicBuilder.addSelectColumn(column);
        return this;
    }

    /**
     * add column
     *
     * @param column column
     * @param asName asName
     * @return this
     */
    public SqlSelectBasicBuilder addSelectColumn(String column, String asName) {
        defaultSelectColumnsBasicBuilder.addSelectColumn(column, asName);
        return this;
    }

    /**
     * addColumns
     *
     * @param columns columns
     * @return this
     */
    public SqlSelectBasicBuilder addSelectColumns(String... columns) {
        defaultSelectColumnsBasicBuilder.addSelectColumns(columns);
        return this;
    }

    /**
     * addColumns
     *
     * @param columns columns
     * @return this
     */
    public SqlSelectBasicBuilder addSelectColumns(Collection<String> columns) {
        defaultSelectColumnsBasicBuilder.addSelectColumns(columns);
        return this;
    }

    /**
     * addSelectProperty.
     *
     * @param propertyName the property name
     * @param aliasName    the alias name
     * @return this
     */
    public SqlSelectBasicBuilder addSelectProperty(String propertyName, String aliasName) {
        defaultSelectColumnsBasicBuilder.addSelectProperty(propertyName, aliasName);
        return this;
    }

    /**
     * addSelectProperties.
     *
     * @param properties the properties
     * @return this
     */
    public SqlSelectBasicBuilder addSelectProperties(Map<String, String> properties) {
        defaultSelectColumnsBasicBuilder.addSelectProperties(properties);
        return this;
    }

    /**
     * Join.
     *
     * @param conditionColumn     the condition column
     * @param joinTableName       the join table name
     * @param joinTableAlias      the join table alias
     * @param joinTableColumnName the join table column name
     * @return the sql select join on basic builder
     */
    public SqlSelectJoinOnBasicBuilder join(String conditionColumn, String joinTableName, String joinTableAlias,
            String joinTableColumnName) {
        return join(Join.INNER_JOIN, conditionColumn, joinTableName, joinTableAlias, joinTableColumnName);
    }

    /**
     * Join.
     *
     * @param conditionTableAlias the condition table alias
     * @param conditionColumn     the condition column
     * @param joinTableName       the join table name
     * @param joinTableAlias      the join table alias
     * @param joinTableColumnName the join table column name
     * @return the sql select join on basic builder
     */
    public SqlSelectJoinOnBasicBuilder join(String conditionTableAlias, String conditionColumn, String joinTableName,
            String joinTableAlias, String joinTableColumnName) {
        return join(Join.INNER_JOIN, conditionTableAlias, conditionColumn, joinTableName, joinTableAlias,
                joinTableColumnName);
    }

    /**
     * Join.
     *
     * @param join                the join
     * @param conditionColumn     the condition column
     * @param joinTableName       the join table name
     * @param joinTableAlias      the join table alias
     * @param joinTableColumnName the join table column name
     * @return the sql select join on basic builder
     */
    public SqlSelectJoinOnBasicBuilder join(Join join, String conditionColumn, String joinTableName,
            String joinTableAlias, String joinTableColumnName) {
        return join(join, tableAlias, conditionColumn, joinTableName, joinTableAlias, joinTableColumnName);
    }

    /**
     * Join.
     *
     * @param join                the join
     * @param conditionTableAlias the condition table alias
     * @param conditionColumn     the condition column
     * @param joinTableName       the join table name
     * @param joinTableAlias      the join table alias
     * @param joinTableColumnName the join table column name
     * @return the sql select join on basic builder
     */
    public SqlSelectJoinOnBasicBuilder join(Join join, String conditionTableAlias, String conditionColumn,
            String joinTableName, String joinTableAlias, String joinTableColumnName) {
        SqlJoinOnBasicBuilder joinOnBuilder = new SqlJoinOnBasicBuilder(dialect, join, joinTableName, joinTableAlias,
                joinTableColumnName, conditionTableAlias, conditionColumn);
        sqlJoinOnBasicBuilders.add(joinOnBuilder);
        SqlSelectColumnsBasicBuilder joinSelectColumnsBuilder = new SqlSelectColumnsBasicBuilder(dialect,
                joinTableAlias);
        return new SqlSelectJoinOnBasicBuilder(this, joinSelectColumnsBuilder);
    }

    /**
     * Join.
     *
     * @param conditionTableAlias the condition table alias
     * @param conditionColumn     the condition column
     * @param classMapping        the class mapping
     * @param tableAlias          the table alias
     * @return the sql select join on basic builder
     */
    public SqlSelectJoinOnBasicBuilder join(String conditionTableAlias, String conditionColumn,
            ClassMapping<?> classMapping, String tableAlias) {
        return join(Join.INNER_JOIN, conditionTableAlias, conditionColumn, classMapping, tableAlias);
    }

    /**
     * Join.
     *
     * @param conditionTableAlias the condition table alias
     * @param conditionColumn     the condition column
     * @param classMapping        the class mapping
     * @param tableAlias          the table alias
     * @param joinTableColumnName the join table column name
     * @return the sql select join on basic builder
     */
    public SqlSelectJoinOnBasicBuilder join(String conditionTableAlias, String conditionColumn,
            ClassMapping<?> classMapping, String tableAlias, String joinTableColumnName) {
        return join(Join.INNER_JOIN, conditionTableAlias, conditionColumn, classMapping, tableAlias,
                joinTableColumnName);
    }

    /**
     * Join.
     *
     * @param join                the join
     * @param conditionTableAlias the condition table alias
     * @param conditionColumn     the condition column
     * @param classMapping        the class mapping
     * @param tableAlias          the table alias
     * @return the sql select join on basic builder
     */
    public SqlSelectJoinOnBasicBuilder join(Join join, String conditionTableAlias, String conditionColumn,
            ClassMapping<?> classMapping, String tableAlias) {
        return join(join, conditionTableAlias, conditionColumn, classMapping, tableAlias,
                classMapping.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName());
    }

    /**
     * Join.
     *
     * @param join                the join
     * @param conditionTableAlias the condition table alias
     * @param conditionColumn     the condition column
     * @param classMapping        the class mapping
     * @param tableAlias          the table alias
     * @param joinTableColumnName the join table column name
     * @return the sql select join on basic builder
     */
    public SqlSelectJoinOnBasicBuilder join(Join join, String conditionTableAlias, String conditionColumn,
            ClassMapping<?> classMapping, String tableAlias, String joinTableColumnName) {

        SqlJoinOnBasicBuilder joinOnBuilder = new SqlJoinOnBasicBuilder(dialect, join, classMapping.getRepositoryName(),
                tableAlias, joinTableColumnName, conditionTableAlias, conditionColumn);
        sqlJoinOnBasicBuilders.add(joinOnBuilder);
        SqlSelectColumnsBasicBuilder joinSelectColumnsBuilder = new SqlSelectColumnsBasicBuilder(dialect, classMapping,
                tableAlias, mappingFactory);
        return new SqlSelectJoinOnBasicBuilder(this, joinSelectColumnsBuilder);
        // return join(join, conditionTableAlias, conditionColumn, classMapping,
        // tableAlias, joinTableColumnName, null);
    }

    // public SqlSelectJoinOnBasicBuilder join(Join join,
    // String conditionTableAlias, String conditionColumn,
    // ClassMapping<?> classMapping, String tableAlias,
    // String joinTableColumnName, String fetchProeprtyName) {
    //
    // SqlJoinOnBasicBuilder joinOnBuilder = new SqlJoinOnBasicBuilder(dialect,
    // join, classMapping.getRepositoryName(), tableAlias,
    // joinTableColumnName, conditionTableAlias, conditionColumn);
    // sqlJoinOnBasicBuilders.add(joinOnBuilder);
    // SqlSelectColumnsBasicBuilder joinSelectColumnsBuilder = new
    // SqlSelectColumnsBasicBuilder(
    // dialect, classMapping, tableAlias, mappingFactory);
    // return new SqlSelectJoinOnBasicBuilder(this, joinSelectColumnsBuilder);
    // }

    void addJoinSelectColumnsBasicBuilder(SqlSelectColumnsBasicBuilder joinSelectColumnsBuilder) {
        joinSelectColumnsBasicBuilders.add(joinSelectColumnsBuilder);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String build() {
        StringBuilder select = new StringBuilder();
        Keyworld keyworld = dialect.getKeywords();
        select.append(keyworld.select());
        select.append(Chars.SPACE).append(defaultSelectColumnsBasicBuilder.build());
        for (SqlSelectColumnsBasicBuilder joinColumnsBuilder : joinSelectColumnsBasicBuilders) {
            select.append(Chars.COMMA).append(Chars.SPACE).append(joinColumnsBuilder.build());
        }
        // if (columns.isEmpty()) {
        // if (classMapping == null) {
        // if (LangUtils.isEmpty(tableAlias)) {
        // select.append(Chars.SPACE).append(Chars.STAR);
        // } else {
        // select.append(Chars.SPACE).append(tableAlias).append(Chars.DOT).append(Chars.STAR);
        // }
        // } else {
        // select.append(Chars.SPACE)
        // .append(ClassMappingUtils.getSelectColumnsSql(classMapping,
        // tableAlias, dialect));
        // }
        // } else {
        // for (SelectColumnElement column : columns) {
        // // 基础构建器一个实例对应一个table
        // column.setTableAlias(tableAlias);
        // select.append(Chars.SPACE).append(column).append(Chars.COMMA);
        // }
        // select.deleteCharAt(select.length() - 1);
        // }

        if (buildWithFrom) {
            AssertIllegalArgument.isNotEmpty(tableName, "buildWithFrom=true时，tableName不能为空");
            select.append(Chars.SPACE).append(keyworld.from()).append(Chars.SPACE)
                    .append(dialect.buildTableSql(tableName, tableAlias));

            sqlJoinOnBasicBuilders.forEach(builder -> {
                select.append(Chars.SPACE).append(builder.build());
            });
        }
        return select.toString();
    }
}
