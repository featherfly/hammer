//
//package cn.featherfly.hammer.sqldb.dsl.type;
//
//import java.util.List;
//
//import cn.featherfly.data.query.QueryExecutor;
//
///**
// * TypeQueryExecutor.
// *
// * @author zhongj
// */
//public class StaticTypeQueryExecutor<E> implements cn.featherfly.data.query.QueryExecutor<E> {
//
//    private Class<E> type;
//
//    private QueryExecutor<E> queryExecutor;
//
//    /**
//     * Instantiates a new type query executor.
//     *
//     * @param type the type
//     * @param queryExecutor the query executor
//     */
//    public StaticTypeQueryExecutor(Class<E> type, QueryExecutor<E> queryExecutor) {
//        // FIXME 这里不正确，后续来处理
//        super();
//        this.type = type;
//        this.queryExecutor = queryExecutor;
//    }
//
//    /**
//     * query for list
//     *
//     * @return list
//     */
//    @Override
//    public List<E> list() {
//        return queryExecutor.list();
//    }
//
//    /**
//     * query for single
//     *
//     * @return object
//     */
//    @Override
//    public E single() {
//        return queryExecutor.single();
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public E unique() {
//        return queryExecutor.unique();
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public Iterable<E> each() {
//        return queryExecutor.each();
//    }
//}
