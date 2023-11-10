
/*
 * All rights Reserved, Designed By zhongj
 * @Title: ConpareEntityExpression.java
 * @Package cn.featherfly.hammer.expression.entity.condition
 * @Description: ConpareEntityExpression
 * @author: zhongj
 * @date: 2023-07-19 18:01:19
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.repository.condition;

import cn.featherfly.common.function.serializable.SerializableFunction;

/**
 * The Interface MatchStringRepositoryPropertyExpression.
 *
 * @author zhongj
 * @param <T> the element type
 */
public interface MatchStringRepositoryFieldExpression extends MatchStringRepositoryExpression {

    /**
     * entity match string function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity match string function property expression
     */
    <T, R> MatchStringRepositoryFieldExpression property(SerializableFunction<T, R> name);

    /**
     * entity match string function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity match string function property expression
     */
    <T, R> MatchStringRepositoryFieldExpression property(SerializableFunction<T, R> name);

    //
    //    /**
    //     * entity match string function property expression.
    //     *
    //     * @param <R>  the generic type
    //     * @param <E>  the generic type
    //     * @param name the name
    //     * @return entity match string function property expression
    //     */
    //    <R extends Collection<E>,
    //            E> MatchStringRepositoryPropertyExpression<E> property(SerializableToCollectionFunction<T, R, E> name);
    //
    //    /**
    //     * entity match string function string property expression.
    //     *
    //     * @param name the name
    //     * @return entity match string function property expression
    //     */
    //    MatchStringRepositoryPropertySetValueExpression property(SerializableToStringFunction<T> name);
}
