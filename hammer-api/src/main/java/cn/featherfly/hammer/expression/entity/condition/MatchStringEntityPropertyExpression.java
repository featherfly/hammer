
/*
 * All rights Reserved, Designed By zhongj
 * @Title: ConpareEntityExpression.java
 * @Package cn.featherfly.hammer.expression.entity.condition
 * @Description: ConpareEntityExpression
 * @author: zhongj
 * @date: 2023-07-19 18:01:19
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition;

import java.util.Collection;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableToCollectionFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;

/**
 * The Interface MatchStringEntityExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface MatchStringEntityPropertyExpression<E> extends MatchStringEntityExpression<E> {

    /**
     * entity match string function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity match string function property expression
     */
    <R> MatchStringEntityPropertyExpression<R> property(SerializableFunction<E, R> name);

    /**
     * entity match string function property expression.
     *
     * @param <R>  the generic type
     * @param <RE> the generic type
     * @param name the name
     * @return entity match string function property expression
     */
    <R extends Collection<RE>,
            RE> MatchStringEntityPropertyExpression<RE> property(SerializableToCollectionFunction<E, R, RE> name);

    /**
     * entity match string function string property expression.
     *
     * @param name the name
     * @return entity match string function property expression
     */
    MatchStringEntityPropertySetValueExpression property(SerializableToStringFunction<E> name);
}
