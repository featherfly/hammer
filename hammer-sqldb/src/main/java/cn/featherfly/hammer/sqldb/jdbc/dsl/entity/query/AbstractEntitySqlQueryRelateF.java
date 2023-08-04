//
///*
// * All rights Reserved, Designed By zhongj
// * @Title: AbstractEntitySqlQueryRelate.java
// * @Package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query
// * @Description: AbstractEntitySqlQueryRelate
// * @author: zhongj
// * @date: 2023-07-14 15:55:14
// * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
// */
//package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query;
//
//import java.util.List;
//import java.util.function.Predicate;
//
//import com.speedment.common.tuple.Tuple2;
//
//import cn.featherfly.common.db.mapping.JdbcClassMapping;
//import cn.featherfly.common.db.mapping.JdbcMappingFactory;
//import cn.featherfly.common.repository.builder.AliasManager;
//import cn.featherfly.common.structure.page.PaginationResults;
//import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
//import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
//
///**
// * AbstractEntitySqlQueryRelate.
// *
// * @author zhongj
// * @param <R1> the join type1
// * @param <R2> the join type2
// * @param <RS> the return type
// */
//public abstract class AbstractEntitySqlQueryRelateF<R1, R2>
//        //        extends AbstractEntitySqlQueryRelate<R1, R2, Tuple2<R1, R2>> {
//        extends AbstractSqlQueryRelate<R1> {
//
//    /**
//     * @param jdbc
//     * @param classMapping
//     * @param factory
//     * @param sqlPageFactory
//     * @param aliasManager
//     * @param ignoreStrategy
//     */
//    public AbstractEntitySqlQueryRelateF(Jdbc jdbc, JdbcClassMapping<R1> classMapping, JdbcMappingFactory factory,
//            SqlPageFactory sqlPageFactory, AliasManager aliasManager, Predicate<Object> ignoreStrategy) {
//        super(jdbc, classMapping, factory, sqlPageFactory, aliasManager, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public List<Tuple2<R1, R2>> list() {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public Tuple2<R1, R2> single() {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public Tuple2<R1, R2> unique() {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public PaginationResults<Tuple2<R1, R2>> pagination() {
//        // YUFEI_TODO Auto-generated method stub
//        return null;
//    }
//}
