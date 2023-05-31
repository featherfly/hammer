//
//package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query;
//
//import cn.featherfly.common.db.mapping.JdbcMappingFactory;
//import cn.featherfly.hammer.dsl.query.type.EntityQueryConditionGroup;
//import cn.featherfly.hammer.dsl.query.type.EntityQueryConditionGroupLogic;
//import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression;
//import cn.featherfly.hammer.expression.entity.query.EntityQuerySortedExpression;
//import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
//import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;
//import cn.featherfly.hammer.sqldb.sql.dml.AbstractEntitySqlQueryConditionGroupExpression;
//
///**
// * entity sql query condition group expression.实体sql查询条件逻辑组表达式.
// *
// * @author zhongj
// * @param <E> the element type
// */
//public abstract class EntitySqlQueryConditionGroupExpression<E> extends
//        AbstractEntitySqlQueryConditionGroupExpression<E, EntityQueryConditionGroup<E>,
//                EntityQueryConditionGroupLogic<E>>
//        implements EntityQueryConditionGroup<E>, EntityQueryConditionGroupLogic<E>, EntityQuerySortExpression<E>,
//        EntityQuerySortedExpression<E> {
//
//    /** The limit. */
//    //    private Limit limit;
//
//    /**
//     * Instantiates a new type sql query condition group expression.
//     *
//     * @param factory        the factory
//     * @param sqlPageFactory the sql page factory
//     * @param queryRelation  the query relation
//     */
//    public EntitySqlQueryConditionGroupExpression(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
//            EntitySqlQueryRelation queryRelation) {
//        this(null, factory, sqlPageFactory, queryRelation);
//    }
//
//    /**
//     * Instantiates a new entity sql query condition group expression.
//     *
//     * @param parent         the parent
//     * @param factory        the factory
//     * @param sqlPageFactory the sql page factory
//     * @param queryRelation  the query relation
//     */
//    EntitySqlQueryConditionGroupExpression(EntityQueryConditionGroupLogic<E> parent, JdbcMappingFactory factory,
//            SqlPageFactory sqlPageFactory, EntitySqlQueryRelation queryRelation) {
//        super(parent, factory, sqlPageFactory, queryRelation);
//    }
//
//    // ********************************************************************
//    // property
//    // ********************************************************************
//
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //    @Override
//    //    protected EntitySqlQueryConditionGroupExpression<E> createGroup(EntityQueryConditionGroupLogicExpression<E> parent,
//    //            String queryAlias, EntitySqlQuery<E> entityQueryEntity) {
//    //        return new EntitySqlQueryConditionGroupExpression<>(parent, jdbc, queryAlias, classMapping, factory,
//    //                sqlPageFactory, aliasManager, entityQueryEntity, ignoreStrategy);
//    //    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public String build() {
//        //        String condition = super.build();
//        //        if (parent == null) {
//        //            if (Lang.isNotEmpty(condition)) {
//        //                return dialect.getKeywords().where() + Chars.SPACE + super.build() + Chars.SPACE + sortBuilder.build();
//        //            } else {
//        //                return super.build() + Chars.SPACE + sortBuilder.build();
//        //            }
//        //        } else {
//        //            return super.build();
//        //        }
//        //        return super.build() + Chars.SPACE + sortBuilder.build();
//        return super.build();
//    }
//
//    //    /**
//    //     * Limit.
//    //     *
//    //     * @param limit the limit
//    //     * @return the type query limit executor
//    //     */
//    //    @Override
//    //    public EntityQueryLimitExecutor<E> limit(Limit limit) {
//    //        this.limit = limit;
//    //        return this;
//    //    }
//
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //    @SuppressWarnings("unchecked")
//    //    @Override
//    //    public List<E> list() {
//    //        String sql = getRoot().expression();
//    //        Object[] params = getRoot().getParams().toArray();
//    //        if (limit != null) {
//    //            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
//    //                    params);
//    //            sql = pageQuery.getSql();
//    //            params = pageQuery.getParams();
//    //        }
//    //        return (List<E>) entitySqlRelation.getJdbc().query(sql, classMapping.getType(), params);
//    //    }
//    //
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //    @Override
//    //    public PaginationResults<E> pagination() {
//    //        String sql = getRoot().expression();
//    //        String countSql = SqlUtils.convertSelectToCount(sql);
//    //        Object[] params = getRoot().getParams().toArray();
//    //        SimplePaginationResults<E> pagination = new SimplePaginationResults<>(limit);
//    //        if (limit != null) {
//    //            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
//    //                    params);
//    //            @SuppressWarnings("unchecked")
//    //            List<E> list = (List<E>) entitySqlRelation.getJdbc().query(pageQuery.getSql(), classMapping.getType(),
//    //                    pageQuery.getParams());
//    //            //            @SuppressWarnings("unchecked")
//    //            //            List<E> list = (List<E>) entitySqlRelation.getJdbc().query(dialect.getPaginationSql(sql, limit.getOffset(), limit.getLimit()),
//    //            //                    classMapping.getType(),
//    //            //                    dialect.getPaginationSqlParameter(params, limit.getOffset(), limit.getLimit()));
//    //            pagination.setPageResults(list);
//    //            int total = entitySqlRelation.getJdbc().queryInt(countSql, params);
//    //            pagination.setTotal(total);
//    //        } else {
//    //            @SuppressWarnings("unchecked")
//    //            List<E> list = (List<E>) entitySqlRelation.getJdbc().query(sql, params, classMapping.getType());
//    //            pagination.setPageResults(list);
//    //            pagination.setTotal(list.size());
//    //        }
//    //        return pagination;
//    //    }
//    //
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //    @SuppressWarnings("unchecked")
//    //    @Override
//    //    public E single() {
//    //        String sql = getRoot().expression();
//    //        Object[] params = getRoot().getParams().toArray();
//    //        if (limit != null) {
//    //            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
//    //                    params);
//    //            sql = pageQuery.getSql();
//    //            params = pageQuery.getParams();
//    //            //            sql = dialect.getPaginationSql(sql, limit.getOffset(), limit.getLimit());
//    //            //            params = dialect.getPaginationSqlParameter(params, limit.getOffset(), limit.getLimit());
//    //        }
//    //        return (E) entitySqlRelation.getJdbc().querySingle(sql, classMapping.getType(), params);
//    //    }
//    //
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //    @SuppressWarnings("unchecked")
//    //    @Override
//    //    public E unique() {
//    //        String sql = getRoot().expression();
//    //        Object[] params = getRoot().getParams().toArray();
//    //        if (limit != null) {
//    //            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
//    //                    params);
//    //            sql = pageQuery.getSql();
//    //            params = pageQuery.getParams();
//    //            //            sql = dialect.getPaginationSql(sql, limit.getOffset(), limit.getLimit());
//    //            //            params = dialect.getPaginationSqlParameter(params, limit.getOffset(), limit.getLimit());
//    //        }
//    //        return (E) entitySqlRelation.getJdbc().queryUnique(sql, classMapping.getType(), params);
//    //    }
//
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //    @Override
//    //    public Long count() {
//    //        throw new UnsupportedException();
//    //    }
//}
