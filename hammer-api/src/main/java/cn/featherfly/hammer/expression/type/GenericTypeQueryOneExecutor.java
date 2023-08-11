
package cn.featherfly.hammer.expression.type;

/**
 * dsl for generic type query one executor.
 *
 * @author zhongj
 * @param <E> the query result type
 */
public interface GenericTypeQueryOneExecutor<E>
        extends GenericTypeQuerySingleExecutor<E>, GenericTypeQueryUniqueExecutor<E> {

}
