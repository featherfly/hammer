
/*
 * All rights Reserved, Designed By zhongj
 * @Title: JdbcQuery.java
 * @Package cn.featherfly.hammer.sqldb.jdbc
 * @Description: JdbcQuery
 * @author: zhongj
 * @date: 2023-07-10 16:15:10
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import cn.featherfly.common.repository.MulitiQuery;
import cn.featherfly.common.repository.mapper.MulitiQueryRowMapper;
import cn.featherfly.common.repository.mapper.MulitiQueryTupleMapperBuilder;
import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.common.repository.mapper.TupleRowMapperBuilder;
import cn.featherfly.common.tuple.MutableTuple;
import cn.featherfly.common.tuple.Tuple;

/**
 * jdbc procedure.
 *
 * @author zhongj
 */
public interface JdbcProcedure {

    /**
     * call procedure .
     *
     * @param name the procedure name
     * @param args the args
     * @return LogicExpressionist
     */
    int call(String name, Serializable... args);

    //    /**
    //     * call procedure .
    //     *
    //     * @param name the procedure name
    //     * @param args the args
    //     * @return LogicExpressionist
    //     */
    //    int call(String name, SequencedMap<String, Object> args);
    //    如果map不按照参数顺序设置，则会报错，因为无法从metadata中获取参数的名称（只能获取顺序）
    //    所以都需要按照顺序设置了，则还设置名称是多余的

    /**
     * call procedure .
     *
     * @param <T> the generic type
     * @param name the procedure name
     * @param args the args
     * @return LogicExpressionist
     */
    <T extends MutableTuple> int call(String name, T args);

    //    /**
    //     * call procedure .
    //     *
    //     * @param name the procedure name
    //     * @param args the args
    //     * @return LogicExpressionist
    //     */
    //    int call(String name, Map<String, Object> args);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * call procedure muliti-query. lazy load data at {@link MulitiQuery#next()}, so the caller
     * needs to close the MulitiQuery object manually.
     *
     * <pre>
     * <code>
     * // use try with resource, auto close
     * try (MulitiQuery query = jdbc.callMultiQuery("procedurename", params)) {
     *      while (query.hasNext()) {
     *          Map&lt;String,Object&gt; map = query.next();
     *          // or
     *          User user =  query.next(User.class);
     *          // or
     *          RowMapper&lt;User&gt; userRowMapper = new ... // your custome RowMapper
     *          User user =  query.next(userRowMapper);
     *      }
     * } catch (Exception e) {
     *       // Logic for handling exceptions
     * }
     * </code>
     * </pre>
     *
     * @param name the procedure name
     * @param args the args
     * @return muliti-query object
     */
    MulitiQuery callMultiQuery(String name, Serializable... args);

    /**
     * call procedure muliti-query.
     *
     * @param <T> the generic type
     * @param name the procedure name
     * @param mapperFunction the mapper function
     * @param args the args
     * @return muliti-query object
     */
    <T extends Tuple> T callMultiQuery(String name,
        Function<MulitiQueryTupleMapperBuilder, MulitiQueryRowMapper<T>> mapperFunction, Serializable... args);

    //    /**
    //     * call procedure muliti-query.
    //     *
    //     * @param <E> the element type
    //     * @param name the procedure name
    //     * @param mapper the mapper
    //     * @param args the args
    //     * @return LogicExpressionist
    //     */
    //    <E> List<E> callMultiQuery(String name, RowMapper<E> mapper, Serializable...args);
    //
    //    /**
    //     * call procedure muliti-query.
    //     *
    //     * @param <T> the generic type
    //     * @param name the procedure name
    //     * @param elementType the element type
    //     * @param args the args
    //     * @return LogicExpressionist
    //     */
    //    <T> List<T> callMultiQuery(String name, Class<T> elementType, Serializable...args);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * call procedure query.
     *
     * @param name the procedure name
     * @param args the args
     * @return LogicExpressionist
     */
    List<Map<String, Serializable>> callQuery(String name, Serializable... args);

    /**
     * call procedure query.
     *
     * @param <E> the element type
     * @param name the procedure name
     * @param mapper the mapper
     * @param args the args
     * @return LogicExpressionist
     */
    <E> List<E> callQuery(String name, RowMapper<E> mapper, Serializable... args);

    /**
     * call procedure query.
     *
     * @param <T> the generic type
     * @param name the procedure name
     * @param elementType the element type
     * @param args the args
     * @return LogicExpressionist
     */
    <T> List<T> callQuery(String name, Class<T> elementType, Serializable... args);

    /**
     * call procedure query.
     *
     * @param <T> the generic type
     * @param sql the sql
     * @param mapper the mapper
     * @param args the args
     * @return the list
     */
    <T> List<T> callQuery(String sql, Function<TupleRowMapperBuilder, RowMapper<T>> mapper, Serializable... args);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * call procedure query.
     *
     * @param name the procedure name
     * @param args the args
     * @return LogicExpressionist
     */
    Map<String, Serializable> callQuerySingle(String name, Serializable... args);

    /**
     * call procedure query.
     *
     * @param <E> the element type
     * @param name the procedure name
     * @param mapper the mapper
     * @param args the args
     * @return LogicExpressionist
     */
    <E> E callQuerySingle(String name, RowMapper<E> mapper, Serializable... args);

    /**
     * call procedure query.
     *
     * @param <T> the generic type
     * @param name the procedure name
     * @param elementType the element type
     * @param args the args
     * @return the mapper object
     */
    <T> T callQuerySingle(String name, Class<T> elementType, Serializable... args);

    /**
     * call procedure query.
     *
     * @param <T> the generic type
     * @param sql the sql
     * @param mapper the mapper
     * @param args the args
     * @return the mapper object
     */
    <T> T callQuerySingle(String sql, Function<TupleRowMapperBuilder, RowMapper<T>> mapper, Serializable... args);
}
