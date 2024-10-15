
package cn.featherfly.hammer.expression.query;

import cn.featherfly.common.tuple.Tuple2;

/**
 * dsl for query single executor2 .
 *
 * @author zhongj
 */
public interface QuerySingleExecutor2 extends QuerySingleExecutor {

    /**
     * query for single, return null when not found.
     *
     * @param <E1>     the generic type
     * @param <E2>     the generic type
     * @param prefixes the prefixes
     * @param type1    the type 1
     * @param type2    the type 2
     * @return object
     */
    <E1, E2> Tuple2<E1, E2> single(Tuple2<String, String> prefixes, Class<E1> type1, Class<E2> type2);

    /**
     * query for single, return null when not found.
     *
     * @param <E1>  the generic type
     * @param <E2>  the generic type
     * @param type1 the type 1
     * @param type2 the type 2
     * @return object
     */
    default <E1, E2> Tuple2<E1, E2> single(Class<E1> type1, Class<E2> type2) {
        return single(null, type1, type2);
    }

    /**
     * query for single, return null when not found.
     *
     * @param <E1>     the generic type
     * @param <E2>     the generic type
     * @param prefixes the prefixes
     * @param types    the types
     * @return object
     */
    default <E1, E2> Tuple2<E1, E2> single(Tuple2<String, String> prefixes, Tuple2<Class<E1>, Class<E2>> types) {
        return single(prefixes, types.get0(), types.get1());
    }

    /**
     * query for single, return null when not found.
     *
     * @param <E1>  the generic type
     * @param <E2>  the generic type
     * @param types the types
     * @return object
     */
    default <E1, E2> Tuple2<E1, E2> single(Tuple2<Class<E1>, Class<E2>> types) {
        return single(null, types);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * query for unique, throw exception when not found.
     *
     * @param <E1>     the generic type
     * @param <E2>     the generic type
     * @param prefixes the prefixes
     * @param type1    the type 1
     * @param type2    the type 2
     * @return the e
     */
    <E1, E2> Tuple2<E1, E2> unique(Tuple2<String, String> prefixes, Class<E1> type1, Class<E2> type2);

    /**
     * query for unique, throw exception when not found.
     *
     * @param <E1>  the generic type
     * @param <E2>  the generic type
     * @param type1 the type 1
     * @param type2 the type 2
     * @return the e
     */
    default <E1, E2> Tuple2<E1, E2> unique(Class<E1> type1, Class<E2> type2) {
        return unique(null, type1, type2);
    }

    /**
     * query for unique, throw exception when not found.
     *
     * @param <E1>     the generic type
     * @param <E2>     the generic type
     * @param prefixes the prefixes
     * @param types    the types
     * @return the e
     */
    default <E1, E2> Tuple2<E1, E2> unique(Tuple2<String, String> prefixes, Tuple2<Class<E1>, Class<E2>> types) {
        return unique(prefixes, types.get0(), types.get1());
    }

    /**
     * query for unique, throw exception when not found.
     *
     * @param <E1>  the generic type
     * @param <E2>  the generic type
     * @param types the types
     * @return the e
     */
    default <E1, E2> Tuple2<E1, E2> unique(Tuple2<Class<E1>, Class<E2>> types) {
        return unique(null, types);
    }

    // ****************************************************************************************************************

    //    /**
    //     * query for single, return null when not found.
    //     *
    //     * @param <E1>     the generic type
    //     * @param <E2>     the generic type
    //     * @param consumer the consumer
    //     * @return object
    //     */
    //    <E1, E2> Tuple2<E1, E2> single(Consumer<ClassMapper> consumer);
    //
    //    default void t() {
    //        single(mapper -> mapper.map("", String.class).map("", Integer.class).map("", Byte.class).map("", Short.class)
    //                .map("", Double.class).map("", Float.class));
    //        single(mapper -> mapper.map(String.class).map(Integer.class).map(Byte.class).map(Short.class).map(Double.class)
    //                .map(Float.class));
    //    }
    //
    //    interface ClassMapper {
    //        <E> PrefixClassMapper1<E> map(String prefix, Class<E> type);
    //
    //        <E> ClassMapper1<E> map(Class<E> type);
    //    }
    //
    //    interface PrefixClassMapper1<E> {
    //        <E2> PrefixClassMapper2<E, E2> map(String prefix, Class<E2> type);
    //
    //        E get0();
    //    }
    //
    //    interface PrefixClassMapper2<E1, E2> {
    //        <E3> PrefixClassMapper3<E1, E2, E3> map(String prefix, Class<E3> type);
    //
    //        E1 get0();
    //
    //        E2 get1();
    //    }
    //
    //    interface PrefixClassMapper3<E1, E2, E3> {
    //        <E4> PrefixClassMapper4<E1, E2, E3, E4> map(String prefix, Class<E4> type);
    //
    //        E1 get0();
    //
    //        E2 get1();
    //
    //        E3 get2();
    //    }
    //
    //    interface PrefixClassMapper4<E1, E2, E3, E4> {
    //        <E5> PrefixClassMapper5<E1, E2, E3, E4, E5> map(String prefix, Class<E5> type);
    //
    //        E1 get0();
    //
    //        E2 get1();
    //
    //        E3 get2();
    //
    //        E4 get3();
    //
    //    }
    //
    //    interface PrefixClassMapper5<E1, E2, E3, E4, E5> {
    //        <E6> PrefixClassMapper6<E1, E2, E3, E4, E5, E6> map(String prefix, Class<E6> type);
    //
    //        E1 get0();
    //
    //        E2 get1();
    //
    //        E3 get2();
    //
    //        E4 get3();
    //
    //        E5 get4();
    //    }
    //
    //    interface PrefixClassMapper6<E1, E2, E3, E4, E5, E6> extends ClassMapper6<E1, E2, E3, E4, E5, E6> {
    //    }
    //
    //    interface ClassMapper1<E> {
    //        <E2> ClassMapper2<E, E2> map(Class<E2> type);
    //
    //        E get0();
    //    }
    //
    //    interface ClassMapper2<E1, E2> {
    //        <E3> ClassMapper3<E1, E2, E3> map(Class<E3> type);
    //
    //        E1 get0();
    //
    //        E2 get1();
    //    }
    //
    //    interface ClassMapper3<E1, E2, E3> {
    //        <E4> ClassMapper4<E1, E2, E3, E4> map(Class<E4> type);
    //
    //        E1 get0();
    //
    //        E2 get1();
    //
    //        E3 get2();
    //    }
    //
    //    interface ClassMapper4<E1, E2, E3, E4> {
    //        <E5> ClassMapper5<E1, E2, E3, E4, E5> map(Class<E5> type);
    //
    //        E1 get0();
    //
    //        E2 get1();
    //
    //        E3 get2();
    //
    //        E4 get3();
    //
    //    }
    //
    //    interface ClassMapper5<E1, E2, E3, E4, E5> {
    //        <E6> ClassMapper6<E1, E2, E3, E4, E5, E6> map(Class<E6> type);
    //
    //        E1 get0();
    //
    //        E2 get1();
    //
    //        E3 get2();
    //
    //        E4 get3();
    //
    //        E5 get4();
    //    }
    //
    //    interface ClassMapper6<E1, E2, E3, E4, E5, E6> {
    //        E1 get0();
    //
    //        E2 get1();
    //
    //        E3 get2();
    //
    //        E4 get3();
    //
    //        E5 get4();
    //
    //        E6 get5();
    //    }
}
