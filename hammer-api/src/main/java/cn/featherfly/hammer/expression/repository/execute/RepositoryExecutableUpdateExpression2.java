
package cn.featherfly.hammer.expression.repository.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;

/**
 * repository executable update expression2.
 *
 * @author zhongj
 * @param <U> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryExecutableUpdateExpression2<U extends RepositoryExecutableUpdateExpression2<U, C, L>,
    C extends RepositoryExecutableConditionsGroupExpression2<C, L, UpdateConditionConfig>,
    L extends RepositoryExecutableConditionsGroupLogicExpression2<C, L, UpdateConditionConfig>>
    extends RepositoryUpdateExpression<U, C, L>, RepositoryFieldExecutableUpdateExpression2<U, C, L>,
    RepositoryExecutableUpdateSetExpression2<U, C, L> {
    // YUFEI_TODO 后续来加入多表更新
    //    /**
    //     * Sets the.
    //     *
    //     * @param consumer the consumer
    //     * @return the u
    //     */
    //    U set(BiConsumer<RepositoryExecutableUpdateExpression<?, ?, ?>,
    //        RepositoryExecutableUpdateExpression<?, ?, ?>> consumer);
    //    default void a() {
    //        RepositoryExecutableUpdateExpression2<?, ?, ?> a = null;
    //        a.set((r1, r2) -> {
    //            r1.set("name", "yufei").increase("age", 1);
    //            r2.set("username", "yufei").increase("acount", 1);
    //        });
    //    }

}
